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
import com.baidu.tieba.l83;
import com.baidu.tieba.to3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class EmojiEditText extends AppCompatEditText {
    public e a;
    public f b;
    public String c;
    public to3 d;
    public Runnable e;
    public int f;

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);

        void b(int i);

        void onBack();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (EmojiEditText.this.b()) {
                view2.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view2.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ Editable a;

        public b(Editable editable) {
            this.a = editable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int selectionStart = EmojiEditText.this.getSelectionStart();
            if (selectionStart > 0) {
                this.a.delete(selectionStart - 1, selectionStart);
            }
            EmojiEditText.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends InputConnectionWrapper {
        public c(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                KeyEvent keyEvent = new KeyEvent(0, 67);
                KeyEvent keyEvent2 = new KeyEvent(1, 67);
                if (sendKeyEvent(keyEvent) && sendKeyEvent(keyEvent2)) {
                    return true;
                }
                return false;
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                return super.sendKeyEvent(keyEvent);
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public d() {
        }

        public /* synthetic */ d(EmojiEditText emojiEditText, a aVar) {
            this();
        }
    }

    public EmojiEditText(Context context) {
        super(context);
        this.f = 200;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new c(onCreateInputConnection, true);
    }

    public void setListener(e eVar) {
        this.a = eVar;
    }

    public void setMaxSize(int i) {
        this.f = i;
    }

    public void setSelectListener(f fVar) {
        this.b = fVar;
    }

    public EmojiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 200;
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        e eVar;
        if (i == 4 && (eVar = this.a) != null) {
            eVar.onBack();
            return false;
        }
        return false;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(i, i2);
        }
    }

    public EmojiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 200;
        init();
    }

    public final boolean b() {
        int scrollY = getScrollY();
        int height = getLayout().getHeight() - getHeight();
        if (height == 0) {
            return false;
        }
        if (scrollY <= 0 && scrollY >= height - 1) {
            return false;
        }
        return true;
    }

    public void d() {
        this.a = null;
    }

    public void e() {
        this.d.c(this.c);
    }

    public final void init() {
        this.d = to3.b(getContext());
        setText(getText());
        setOnTouchListener(new a());
        addTextChangedListener(new d(this, null));
    }

    public void c() {
        Editable editableText = getEditableText();
        if (TextUtils.isEmpty(editableText) || !Pattern.compile("\\[([一-龥\\w])+\\]").matcher(editableText).find()) {
            return;
        }
        getEditableText().replace(0, editableText.length(), l83.c().g(getContext(), editableText, this));
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+]").matcher(charSequence2);
        int i4 = 0;
        while (matcher.find()) {
            i4++;
            charSequence2 = charSequence2.replace(matcher.group(), "");
        }
        int length = charSequence2.length() + i4;
        if (length <= this.f) {
            e eVar = this.a;
            if (eVar != null) {
                eVar.b(length);
                return;
            }
            return;
        }
        e eVar2 = this.a;
        if (eVar2 != null) {
            eVar2.a(length);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            CharSequence a2 = this.d.a();
            if (a2 == null) {
                return super.onTextContextMenuItem(i);
            }
            this.c = a2.toString();
            this.d.c(" ");
            SpannableString g = l83.c().g(getContext(), this.c, this);
            int selectionStart = getSelectionStart();
            Editable editableText = getEditableText();
            editableText.insert(selectionStart, g);
            b bVar = new b(editableText);
            this.e = bVar;
            post(bVar);
        }
        return super.onTextContextMenuItem(i);
    }
}
