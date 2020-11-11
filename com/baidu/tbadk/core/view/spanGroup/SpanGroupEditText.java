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
    private EDIT_TEXT_TYPE fae;
    private View.OnKeyListener faf;
    private long mForumId;
    private SpanGroupManager mSpanGroupManager;

    /* loaded from: classes.dex */
    public enum EDIT_TEXT_TYPE {
        TYPE_COMMODITY,
        TYPE_DEFAULT
    }

    public EDIT_TEXT_TYPE getType() {
        return this.fae;
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fae = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.mForumId = 0L;
        this.mSpanGroupManager = new SpanGroupManager(this, context instanceof h ? ((h) context).getUniqueId() : null);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.fae = edit_text_type;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.btu();
        }
        super.setText(charSequence, bufferType);
    }

    public void m(List<com.baidu.tieba.i.a> list, List<String> list2) {
        if (!y.isEmpty(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.tieba.i.a aVar = list.get(i2);
                    String str = list2.get(i2);
                    if (!this.mSpanGroupManager.Cy(aVar.cIb())) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                        t a2 = t.a(tbLinkSpanGroup, aVar);
                        a2.eAf = str;
                        tbLinkSpanGroup.Cz(a2.mContent);
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

    public void qo(int i) {
        com.baidu.tbadk.core.view.spanGroup.a qq = this.mSpanGroupManager.qq(i);
        if (qq != null && getText() != null) {
            this.mSpanGroupManager.bc(qq.getStart(), qq.getEnd());
        }
    }

    public void btq() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.btq();
        }
    }

    public void btr() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.btr();
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC0582a interfaceC0582a) {
        this.mSpanGroupManager.b(interfaceC0582a);
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
        this.faf = onKeyListener;
    }

    /* loaded from: classes.dex */
    private class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.faf == null || !SpanGroupEditText.this.faf.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
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
