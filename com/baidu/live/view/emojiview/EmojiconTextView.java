package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class EmojiconTextView extends TextView {
    private int bQT;
    private int bQU;
    private int bQV;
    private SpannableString bRp;

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
        this.bQV = (int) getTextSize();
        if (attributeSet == null) {
            this.bQT = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Expression);
            this.bQT = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
            this.bQU = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence) && this.bRp == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            d.a(getContext(), spannableStringBuilder, this.bQT, this.bQU, this.bQV);
            charSequence = spannableStringBuilder;
        } else if (this.bRp != null) {
            d.a(getContext(), this.bRp, this.bQT, this.bQU, this.bQV);
            charSequence = this.bRp;
        }
        super.setText(charSequence, bufferType);
    }

    public void setSpannableString(SpannableString spannableString) {
        this.bRp = spannableString;
    }

    public void setExpressionSize(int i) {
        this.bQT = i;
        super.setText(getText());
    }
}
