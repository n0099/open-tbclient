package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
/* loaded from: classes2.dex */
public class RoundRectButton extends Button {
    public int mLeftBottomCorner;
    public int mLeftTopCorner;
    public int mRightBottomCorner;
    public int mRightTopCorner;
    public Context mViewContext;

    /* loaded from: classes2.dex */
    public static class Builder {
        public View.OnClickListener mBtnListener;
        public int mLeftBottomCorner;
        public int mLeftTopCorner;
        public int mRightBottomCorner;
        public int mRightTopCorner;
        public int mBtnBackgroundColor = Color.parseColor("#3789FD");
        public int mBtnBackgroundAlpha = 255;
        public String mBtnTextMsg = "";
        public int mBtnTextSizeSp = 14;
        public int mBtnTextColor = Color.parseColor("#ffffffff");

        public RoundRectButton create(Context context) {
            return new RoundRectButton(context, this);
        }

        public Builder setBtnBackgroundAlpha(int i) {
            this.mBtnBackgroundAlpha = i;
            return this;
        }

        public Builder setBtnBackgroundColor(int i) {
            this.mBtnBackgroundColor = i;
            return this;
        }

        public Builder setBtnClickListener(View.OnClickListener onClickListener) {
            this.mBtnListener = onClickListener;
            return this;
        }

        public Builder setBtnTextColor(int i) {
            this.mBtnTextColor = i;
            return this;
        }

        public Builder setBtnTextMsg(String str) {
            this.mBtnTextMsg = str;
            return this;
        }

        public Builder setBtnTextSizeSp(int i) {
            this.mBtnTextSizeSp = i;
            return this;
        }

        public Builder setLeftBottomCorner(int i) {
            this.mLeftBottomCorner = i;
            return this;
        }

        public Builder setLeftTopCorner(int i) {
            this.mLeftTopCorner = i;
            return this;
        }

        public Builder setRightBottomCorner(int i) {
            this.mRightBottomCorner = i;
            return this;
        }

        public Builder setRightTopCorner(int i) {
            this.mRightTopCorner = i;
            return this;
        }
    }

    public RoundRectButton(Context context, Builder builder) {
        super(context);
        this.mViewContext = context;
        if (builder == null) {
            return;
        }
        this.mLeftTopCorner = builder.mLeftTopCorner;
        this.mRightBottomCorner = builder.mRightBottomCorner;
        this.mLeftBottomCorner = builder.mLeftBottomCorner;
        this.mRightTopCorner = builder.mRightTopCorner;
        setOnClickListener(builder.mBtnListener);
        setText(builder.mBtnTextMsg);
        setGravity(17);
        setTextColor(builder.mBtnTextColor);
        setTextSize(2, builder.mBtnTextSizeSp);
        int textSize = (int) getTextSize();
        setPadding(textSize, 0, textSize, 0);
        setBackgroundDrawable(getDrawable(builder.mBtnBackgroundColor, builder.mBtnBackgroundAlpha));
        if (Build.VERSION.SDK_INT >= 21) {
            setStateListAnimator(null);
        }
    }

    private GradientDrawable getDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setAlpha(i2);
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadii(new float[]{this.mLeftTopCorner, this.mLeftTopCorner, this.mRightTopCorner, this.mRightTopCorner, this.mRightBottomCorner, this.mRightBottomCorner, this.mLeftBottomCorner, this.mLeftBottomCorner});
        } catch (Exception unused) {
        }
        return gradientDrawable;
    }
}
