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
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class SpanGroupEditText extends AppCompatEditText {
    private EDIT_TEXT_TYPE fqs;
    private View.OnKeyListener fqt;
    private long mForumId;
    private SpanGroupManager mSpanGroupManager;

    /* loaded from: classes.dex */
    public enum EDIT_TEXT_TYPE {
        TYPE_COMMODITY,
        TYPE_DEFAULT
    }

    public EDIT_TEXT_TYPE getType() {
        return this.fqs;
    }

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fqs = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.mForumId = 0L;
        this.mSpanGroupManager = new SpanGroupManager(this, context instanceof i ? ((i) context).getUniqueId() : null);
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        this.fqs = edit_text_type;
    }

    public void p(CharSequence charSequence) {
        if (getText() != null) {
            getText().insert(getSelectionEnd(), charSequence);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.byD();
        }
        super.setText(charSequence, bufferType);
    }

    public void o(List<com.baidu.tieba.j.a> list, List<String> list2) {
        if (!x.isEmpty(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.tieba.j.a aVar = list.get(i2);
                    String str = list2.get(i2);
                    if (!this.mSpanGroupManager.CD(aVar.cQi())) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                        u a2 = u.a(tbLinkSpanGroup, aVar);
                        a2.ePl = str;
                        tbLinkSpanGroup.CE(a2.mContent);
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

    public void rz(int i) {
        com.baidu.tbadk.core.view.spanGroup.a rB = this.mSpanGroupManager.rB(i);
        if (rB != null && getText() != null) {
            this.mSpanGroupManager.bc(rB.getStart(), rB.getEnd());
        }
    }

    public void byz() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.byz();
        }
    }

    public void byA() {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.byA();
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC0585a interfaceC0585a) {
        this.mSpanGroupManager.b(interfaceC0585a);
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
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
        this.fqt = onKeyListener;
    }

    /* loaded from: classes.dex */
    private class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.fqt == null || !SpanGroupEditText.this.fqt.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
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
