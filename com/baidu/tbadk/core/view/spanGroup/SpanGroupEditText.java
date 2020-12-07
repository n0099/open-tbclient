package com.baidu.tbadk.core.view.spanGroup;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class SpanGroupEditText extends AppCompatEditText {
    private EDIT_TEXT_TYPE fgJ;
    private View.OnKeyListener fgK;
    private long mForumId;
    private SpanGroupManager mSpanGroupManager;

    /* loaded from: classes.dex */
    public enum EDIT_TEXT_TYPE {
        TYPE_COMMODITY,
        TYPE_DEFAULT
    }

    public EDIT_TEXT_TYPE getType() {
        return this.fgJ;
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgJ = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.mForumId = 0L;
        this.mSpanGroupManager = new SpanGroupManager(this, context instanceof h ? ((h) context).getUniqueId() : null);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.fgJ = edit_text_type;
    }

    public void p(CharSequence charSequence) {
        if (getText() != null) {
            getText().insert(getSelectionEnd(), charSequence);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bwk();
        }
        super.setText(charSequence, bufferType);
    }

    public void m(List<com.baidu.tieba.j.a> list, List<String> list2) {
        if (!y.isEmpty(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.tieba.j.a aVar = list.get(i2);
                    String str = list2.get(i2);
                    if (!this.mSpanGroupManager.CF(aVar.cMU())) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                        u a2 = u.a(tbLinkSpanGroup, aVar);
                        a2.eFv = str;
                        tbLinkSpanGroup.CG(a2.mContent);
                        tbLinkSpanGroup.build();
                        this.mSpanGroupManager.a(tbLinkSpanGroup);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void rn(int i) {
        com.baidu.tbadk.core.view.spanGroup.a rp = this.mSpanGroupManager.rp(i);
        if (rp != null && getText() != null) {
            this.mSpanGroupManager.be(rp.getStart(), rp.getEnd());
        }
    }

    public void bwg() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bwg();
        }
    }

    public void bwh() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bwh();
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC0594a interfaceC0594a) {
        this.mSpanGroupManager.b(interfaceC0594a);
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    @Override // android.support.v7.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public void setTransLink(boolean z) {
        this.mSpanGroupManager.setTransLink(z);
    }

    public SpanGroupManager getSpanGroupManager() {
        return this.mSpanGroupManager;
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        this.fgK = onKeyListener;
    }

    /* loaded from: classes.dex */
    private class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.fgK == null || !SpanGroupEditText.this.fgK.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
                return super.sendKeyEvent(keyEvent);
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) : super.deleteSurroundingText(i, i2);
        }
    }
}
