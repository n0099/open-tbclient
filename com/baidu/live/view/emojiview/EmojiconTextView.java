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
    private int bUJ;
    private int bUK;
    private int bUL;
    private SpannableString bUW;

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
        this.bUL = (int) getTextSize();
        if (attributeSet == null) {
            this.bUJ = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Expression);
            this.bUJ = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
            this.bUK = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence) && this.bUW == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            d.a(getContext(), spannableStringBuilder, this.bUJ, this.bUK, this.bUL);
            charSequence = spannableStringBuilder;
        } else if (this.bUW != null) {
            d.a(getContext(), this.bUW, this.bUJ, this.bUK, this.bUL);
            charSequence = this.bUW;
        }
        super.setText(charSequence, bufferType);
    }

    public void setSpannableString(SpannableString spannableString) {
        this.bUW = spannableString;
    }

    public void setExpressionSize(int i) {
        this.bUJ = i;
        super.setText(getText());
    }
}
