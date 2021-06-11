package com.baidu.swan.apps.publisher.emoji;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import d.a.l0.a.v2.r0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class EmojiEditText extends AppCompatEditText {

    /* renamed from: e  reason: collision with root package name */
    public e f11064e;

    /* renamed from: f  reason: collision with root package name */
    public f f11065f;

    /* renamed from: g  reason: collision with root package name */
    public String f11066g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f11067h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f11068i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (EmojiEditText.this.b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Editable f11070e;

        public b(Editable editable) {
            this.f11070e = editable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int selectionStart = EmojiEditText.this.getSelectionStart();
            if (selectionStart > 0) {
                this.f11070e.delete(selectionStart - 1, selectionStart);
            }
            EmojiEditText.this.f();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends InputConnectionWrapper {
        public c(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            if (i2 == 1 && i3 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i2, i3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                return super.sendKeyEvent(keyEvent);
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public /* synthetic */ d(EmojiEditText emojiEditText, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2);

        void b(int i2);

        void onBack();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2, int i3);
    }

    public EmojiEditText(Context context) {
        super(context);
        this.j = 200;
    }

    public final boolean b() {
        int scrollY = getScrollY();
        int height = getLayout().getHeight() - getHeight();
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    public void c() {
        Editable editableText = getEditableText();
        if (!TextUtils.isEmpty(editableText) && Pattern.compile("\\[([一-龥\\w])+\\]").matcher(editableText).find()) {
            getEditableText().replace(0, editableText.length(), d.a.l0.a.w1.h.b.c().g(getContext(), editableText, this));
        }
    }

    public final void d() {
        this.f11067h = r0.b(getContext());
        setText(getText());
        setOnTouchListener(new a());
        addTextChangedListener(new d(this, null));
    }

    public void e() {
        this.f11064e = null;
    }

    public void f() {
        this.f11067h.c(this.f11066g);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new c(onCreateInputConnection, true);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        e eVar;
        if (i2 != 4 || (eVar = this.f11064e) == null) {
            return false;
        }
        eVar.onBack();
        return false;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        f fVar = this.f11065f;
        if (fVar != null) {
            fVar.a(i2, i3);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String charSequence2 = charSequence.toString();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+]").matcher(charSequence2);
        int i5 = 0;
        while (matcher.find()) {
            i5++;
            charSequence2 = charSequence2.replace(matcher.group(), "");
        }
        int length = charSequence2.length() + i5;
        if (length <= this.j) {
            e eVar = this.f11064e;
            if (eVar != null) {
                eVar.b(length);
                return;
            }
            return;
        }
        e eVar2 = this.f11064e;
        if (eVar2 != null) {
            eVar2.a(length);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        if (i2 == 16908322) {
            CharSequence a2 = this.f11067h.a();
            if (a2 == null) {
                return super.onTextContextMenuItem(i2);
            }
            this.f11066g = a2.toString();
            this.f11067h.c(" ");
            SpannableString g2 = d.a.l0.a.w1.h.b.c().g(getContext(), this.f11066g, this);
            int selectionStart = getSelectionStart();
            Editable editableText = getEditableText();
            editableText.insert(selectionStart, g2);
            b bVar = new b(editableText);
            this.f11068i = bVar;
            post(bVar);
        }
        return super.onTextContextMenuItem(i2);
    }

    public void setListener(e eVar) {
        this.f11064e = eVar;
    }

    public void setMaxSize(int i2) {
        this.j = i2;
    }

    public void setSelectListener(f fVar) {
        this.f11065f = fVar;
    }

    public EmojiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 200;
        d();
    }

    public EmojiEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 200;
        d();
    }
}
