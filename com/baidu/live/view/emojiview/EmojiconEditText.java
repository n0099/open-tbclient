package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class EmojiconEditText extends EditText {
    private int bUJ;
    private int bUK;
    private int bUL;

    public EmojiconEditText(Context context) {
        super(context);
        this.bUJ = (int) getTextSize();
        this.bUL = (int) getTextSize();
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Expression);
        this.bUJ = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
        this.bUK = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
        obtainStyledAttributes.recycle();
        this.bUL = (int) getTextSize();
        setText(getText());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        XN();
    }

    public void setExpressionSize(int i) {
        this.bUJ = i;
        XN();
    }

    private void XN() {
        d.a(getContext(), getText(), this.bUJ, this.bUK, this.bUL);
    }
}
