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
import d.b.c.a.i;
import d.b.h0.r.f0.p.a;
import d.b.h0.r.q.v;
import java.util.List;
/* loaded from: classes3.dex */
public class SpanGroupEditText extends AppCompatEditText {

    /* renamed from: e  reason: collision with root package name */
    public EDIT_TEXT_TYPE f13279e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupManager f13280f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnKeyListener f13281g;

    /* renamed from: h  reason: collision with root package name */
    public long f13282h;

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
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67));
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.f13281g == null || !SpanGroupEditText.this.f13281g.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
                return super.sendKeyEvent(keyEvent);
            }
            return true;
        }
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public void b() {
        SpanGroupManager spanGroupManager = this.f13280f;
        if (spanGroupManager != null) {
            spanGroupManager.g();
        }
    }

    public void c(int i) {
        d.b.h0.r.f0.p.a r = this.f13280f.r(i);
        if (r == null || getText() == null) {
            return;
        }
        this.f13280f.l(r.f(), r.c());
    }

    public void d(CharSequence charSequence) {
        if (getText() == null) {
            return;
        }
        getText().insert(getSelectionEnd(), charSequence);
    }

    public void e(List<d.b.i0.w0.a> list, List<String> list2) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            d.b.i0.w0.a aVar = list.get(i);
            String str = list2.get(i);
            if (!this.f13280f.i(aVar.a())) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                v b2 = v.b(tbLinkSpanGroup, aVar);
                b2.l = str;
                tbLinkSpanGroup.z(b2.f51307h);
                tbLinkSpanGroup.r();
                this.f13280f.v(tbLinkSpanGroup);
            }
        }
    }

    public void f() {
        SpanGroupManager spanGroupManager = this.f13280f;
        if (spanGroupManager != null) {
            spanGroupManager.B();
        }
    }

    public long getForumId() {
        return this.f13282h;
    }

    public SpanGroupManager getSpanGroupManager() {
        return this.f13280f;
    }

    public EDIT_TEXT_TYPE getType() {
        return this.f13279e;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public void setForumId(long j) {
        this.f13282h = j;
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC1090a interfaceC1090a) {
        this.f13280f.F(interfaceC1090a);
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        this.f13281g = onKeyListener;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpanGroupManager spanGroupManager = this.f13280f;
        if (spanGroupManager != null) {
            spanGroupManager.k();
        }
        super.setText(charSequence, bufferType);
    }

    public void setTransLink(boolean z) {
        this.f13280f.G(z);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.f13279e = edit_text_type;
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13279e = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.f13282h = 0L;
        this.f13280f = new SpanGroupManager(this, context instanceof i ? ((i) context).getUniqueId() : null);
    }
}
