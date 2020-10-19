package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
/* loaded from: classes10.dex */
public class BdBaseLottieView extends LottieAnimationView {
    private int mColorFilter;
    private boolean mFlagShouldDecorate;

    public BdBaseLottieView(Context context) {
        super(context);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    public BdBaseLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    public BdBaseLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mFlagShouldDecorate = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (shouldDecorate()) {
            PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable());
            this.mColorFilter = PorterDuffModeHelper.getUiCoverLayerColor(getContext());
            this.mFlagShouldDecorate = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (hasDecorateColorFilter()) {
            PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean shouldDecorate() {
        return this.mFlagShouldDecorate || this.mColorFilter != PorterDuffModeHelper.getUiCoverLayerColor(getContext());
    }

    private boolean hasDecorateColorFilter() {
        return Color.alpha(PorterDuffModeHelper.getUiCoverLayerColor(getContext())) != 0;
    }
}
