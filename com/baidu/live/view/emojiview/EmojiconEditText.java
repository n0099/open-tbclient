package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class EmojiconEditText extends EditText {
    private int bQT;
    private int bQU;
    private int bQV;

    public EmojiconEditText(Context context) {
        super(context);
        this.bQT = (int) getTextSize();
        this.bQV = (int) getTextSize();
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
        this.bQT = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
        this.bQU = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
        obtainStyledAttributes.recycle();
        this.bQV = (int) getTextSize();
        setText(getText());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        We();
    }

    public void setExpressionSize(int i) {
        this.bQT = i;
        We();
    }

    private void We() {
        d.a(getContext(), getText(), this.bQT, this.bQU, this.bQV);
    }
}
