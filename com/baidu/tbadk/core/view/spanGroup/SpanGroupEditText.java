package com.baidu.tbadk.core.view.spanGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import d.a.c.a.i;
import d.a.j0.r.f0.p.a;
import d.a.j0.r.q.v;
import java.util.List;
/* loaded from: classes3.dex */
public class SpanGroupEditText extends AppCompatEditText {

    /* renamed from: e  reason: collision with root package name */
    public EDIT_TEXT_TYPE f12585e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupManager f12586f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnKeyListener f12587g;

    /* renamed from: h  reason: collision with root package name */
    public long f12588h;

    /* loaded from: classes3.dex */
    public enum EDIT_TEXT_TYPE {
        TYPE_COMMODITY,
        TYPE_DEFAULT
    }

    /* loaded from: classes3.dex */
    public class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            if (i2 == 1 && i3 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67));
            }
            return super.deleteSurroundingText(i2, i3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.f12587g == null || !SpanGroupEditText.this.f12587g.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
                return super.sendKeyEvent(keyEvent);
            }
            return true;
        }
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public void b() {
        SpanGroupManager spanGroupManager = this.f12586f;
        if (spanGroupManager != null) {
            spanGroupManager.g();
        }
    }

    public void c(int i2) {
        d.a.j0.r.f0.p.a r = this.f12586f.r(i2);
        if (r == null || getText() == null) {
            return;
        }
        this.f12586f.l(r.f(), r.c());
    }

    public void d(CharSequence charSequence) {
        if (getText() == null) {
            return;
        }
        getText().insert(getSelectionEnd(), charSequence);
    }

    public void e(List<d.a.k0.w0.a> list, List<String> list2) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            d.a.k0.w0.a aVar = list.get(i2);
            String str = list2.get(i2);
            if (!this.f12586f.i(aVar.a())) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                v b2 = v.b(tbLinkSpanGroup, aVar);
                b2.l = str;
                tbLinkSpanGroup.z(b2.f50095h);
                tbLinkSpanGroup.r();
                this.f12586f.v(tbLinkSpanGroup);
            }
        }
    }

    public void f() {
        SpanGroupManager spanGroupManager = this.f12586f;
        if (spanGroupManager != null) {
            spanGroupManager.B();
        }
    }

    public long getForumId() {
        return this.f12588h;
    }

    public SpanGroupManager getSpanGroupManager() {
        return this.f12586f;
    }

    public EDIT_TEXT_TYPE getType() {
        return this.f12585e;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public void setForumId(long j) {
        this.f12588h = j;
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC1127a interfaceC1127a) {
        this.f12586f.F(interfaceC1127a);
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        this.f12587g = onKeyListener;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpanGroupManager spanGroupManager = this.f12586f;
        if (spanGroupManager != null) {
            spanGroupManager.k();
        }
        super.setText(charSequence, bufferType);
    }

    public void setTransLink(boolean z) {
        this.f12586f.G(z);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.f12585e = edit_text_type;
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12585e = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.f12588h = 0L;
        this.f12586f = new SpanGroupManager(this, context instanceof i ? ((i) context).getUniqueId() : null);
    }
}
