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
    private int bWj;
    private int bWk;
    private int bWl;
    private SpannableString bWw;

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
        this.bWl = (int) getTextSize();
        if (attributeSet == null) {
            this.bWj = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Expression);
            this.bWj = (int) obtainStyledAttributes.getDimension(a.j.Expression_expressionSize, getTextSize());
            this.bWk = obtainStyledAttributes.getInt(a.j.Expression_expressionAlignment, 1);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence) && this.bWw == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            d.a(getContext(), spannableStringBuilder, this.bWj, this.bWk, this.bWl);
            charSequence = spannableStringBuilder;
        } else if (this.bWw != null) {
            d.a(getContext(), this.bWw, this.bWj, this.bWk, this.bWl);
            charSequence = this.bWw;
        }
        super.setText(charSequence, bufferType);
    }

    public void setSpannableString(SpannableString spannableString) {
        this.bWw = spannableString;
    }

    public void setExpressionSize(int i) {
        this.bWj = i;
        super.setText(getText());
    }
}
