package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class EmojiconTextView extends TextView {
    private int bVF;
    private int bVG;
    private int bVH;
    private SpannableString bWb;

    public EmojiconTextView(Context context) {
        super(context);
        init(null);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.bVH = (int) getTextSize();
        if (attributeSet == null) {
            this.bVF = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Expression);
            this.bVF = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
            this.bVG = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence) && this.bWb == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            d.a(getContext(), spannableStringBuilder, this.bVF, this.bVG, this.bVH);
            charSequence = spannableStringBuilder;
        } else if (this.bWb != null) {
            d.a(getContext(), this.bWb, this.bVF, this.bVG, this.bVH);
            charSequence = this.bWb;
        }
        super.setText(charSequence, bufferType);
    }

    public void setSpannableString(SpannableString spannableString) {
        this.bWb = spannableString;
    }

    public void setExpressionSize(int i) {
        this.bVF = i;
        super.setText(getText());
    }
}
