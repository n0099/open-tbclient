package com.baidu.searchbox.ugc.emoji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.R;
/* loaded from: classes13.dex */
public class EmojiconTextView extends AppCompatTextView {
    private int mEmojiconSize;

    public EmojiconTextView(Context context) {
        super(context);
        init(null, context);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, context);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, context);
    }

    private void init(AttributeSet attributeSet, Context context) {
        if (attributeSet == null) {
            this.mEmojiconSize = (int) (getTextSize() + DeviceUtil.ScreenInfo.dp2px(context, 2.0f));
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Emojicon);
            this.mEmojiconSize = (int) obtainStyledAttributes.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize() + DeviceUtil.ScreenInfo.dp2px(context, 2.0f));
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence)) {
            super.setText(charSequence, bufferType);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        EmojiconHandler.addEmojis(getContext(), spannableStringBuilder, this.mEmojiconSize);
        super.setText(spannableStringBuilder, bufferType);
    }

    public void setEmojiconSize(int i) {
        this.mEmojiconSize = i;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }
}
