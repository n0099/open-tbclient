package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class EmojiconEditText extends EditText {
    private int bVF;
    private int bVG;
    private int bVH;

    public EmojiconEditText(Context context) {
        super(context);
        this.bVF = (int) getTextSize();
        this.bVH = (int) getTextSize();
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
        this.bVF = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
        this.bVG = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
        obtainStyledAttributes.recycle();
        this.bVH = (int) getTextSize();
        setText(getText());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ZX();
    }

    public void setExpressionSize(int i) {
        this.bVF = i;
        ZX();
    }

    private void ZX() {
        d.a(getContext(), getText(), this.bVF, this.bVG, this.bVH);
    }
}
