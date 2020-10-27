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
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class SpanGroupEditText extends AppCompatEditText {
    private EDIT_TEXT_TYPE eUp;
    private View.OnKeyListener eUq;
    private long mForumId;
    private SpanGroupManager mSpanGroupManager;

    /* loaded from: classes.dex */
    public enum EDIT_TEXT_TYPE {
        TYPE_COMMODITY,
        TYPE_DEFAULT
    }

    public EDIT_TEXT_TYPE getType() {
        return this.eUp;
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUp = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.mForumId = 0L;
        this.mSpanGroupManager = new SpanGroupManager(this, context instanceof h ? ((h) context).getUniqueId() : null);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.eUp = edit_text_type;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bqU();
        }
        super.setText(charSequence, bufferType);
    }

    public void l(List<com.baidu.tieba.i.a> list, List<String> list2) {
        if (!y.isEmpty(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.tieba.i.a aVar = list.get(i2);
                    String str = list2.get(i2);
                    if (!this.mSpanGroupManager.Ck(aVar.cFA())) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                        t a2 = t.a(tbLinkSpanGroup, aVar);
                        a2.eum = str;
                        tbLinkSpanGroup.Cl(a2.mContent);
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

    public void qe(int i) {
        com.baidu.tbadk.core.view.spanGroup.a qg = this.mSpanGroupManager.qg(i);
        if (qg != null && getText() != null) {
            this.mSpanGroupManager.bc(qg.getStart(), qg.getEnd());
        }
    }

    public void bqQ() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bqQ();
        }
    }

    public void bqR() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.bqR();
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC0570a interfaceC0570a) {
        this.mSpanGroupManager.b(interfaceC0570a);
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
        this.eUq = onKeyListener;
    }

    /* loaded from: classes.dex */
    private class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.eUq == null || !SpanGroupEditText.this.eUq.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
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
