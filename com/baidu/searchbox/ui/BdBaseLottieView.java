package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
/* loaded from: classes4.dex */
public class BdBaseLottieView extends LottieAnimationView {
    public int mColorFilter;
    public boolean mFlagShouldDecorate;
    public boolean supportDark;

    public BdBaseLottieView(Context context) {
        super(context);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (shouldDecorate() && this.supportDark) {
            PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable());
            this.mColorFilter = PorterDuffModeHelper.getUiCoverLayerColor(getContext());
            this.mFlagShouldDecorate = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (hasDecorateColorFilter() && this.supportDark) {
            PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mFlagShouldDecorate = true;
        super.setImageDrawable(drawable);
    }

    public void setSupportDark(Boolean bool) {
        this.supportDark = bool.booleanValue();
    }

    public BdBaseLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
    }

    public BdBaseLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
    }

    private boolean hasDecorateColorFilter() {
        if (Color.alpha(PorterDuffModeHelper.getUiCoverLayerColor(getContext())) != 0) {
            return true;
        }
        return false;
    }

    private boolean shouldDecorate() {
        if (!this.mFlagShouldDecorate && this.mColorFilter == PorterDuffModeHelper.getUiCoverLayerColor(getContext())) {
            return false;
        }
        return true;
    }
}
