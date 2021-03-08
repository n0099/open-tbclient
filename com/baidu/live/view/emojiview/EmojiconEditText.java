package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class EmojiconEditText extends EditText {
    private int bWj;
    private int bWk;
    private int bWl;

    public EmojiconEditText(Context context) {
        super(context);
        this.bWj = (int) getTextSize();
        this.bWl = (int) getTextSize();
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
        this.bWj = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
        this.bWk = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
        obtainStyledAttributes.recycle();
        this.bWl = (int) getTextSize();
        setText(getText());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        XQ();
    }

    public void setExpressionSize(int i) {
        this.bWj = i;
        XQ();
    }

    private void XQ() {
        d.a(getContext(), getText(), this.bWj, this.bWk, this.bWl);
    }
}
