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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SpanGroupEditText extends AppCompatEditText {
    private View.OnKeyListener ehn;
    private SpanGroupManager mSpanGroupManager;

    public SpanGroupEditText(Context context) {
        this(context, null);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpanGroupManager = new SpanGroupManager(this, context instanceof h ? ((h) context).getUniqueId() : null);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mSpanGroupManager != null) {
            this.mSpanGroupManager.aZb();
        }
        super.setText(charSequence, bufferType);
    }

    @Override // android.support.v7.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public boolean aYY() {
        return this.mSpanGroupManager.aYY();
    }

    public void setTransLink(boolean z) {
        this.mSpanGroupManager.setTransLink(z);
    }

    public SpanGroupManager getSpanGroupManager() {
        return this.mSpanGroupManager;
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        this.ehn = onKeyListener;
    }

    /* loaded from: classes.dex */
    private class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (SpanGroupEditText.this.ehn == null || !SpanGroupEditText.this.ehn.onKey(SpanGroupEditText.this, keyEvent.getKeyCode(), keyEvent)) {
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
