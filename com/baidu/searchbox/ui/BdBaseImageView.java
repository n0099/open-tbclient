package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.searchbox.ui.fontsize.view.FontSizeImageView;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class BdBaseImageView extends FontSizeImageView {
    public int mColorFilter;
    public boolean mFlagShouldDecorate;
    public boolean mIsResponseFontSize;
    public boolean supportDark;

    public BdBaseImageView(Context context) {
        super(context);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
        this.mIsResponseFontSize = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (shouldDecorate() && this.supportDark) {
                PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable());
                this.mColorFilter = PorterDuffModeHelper.getUiCoverLayerColor(getContext());
                this.mFlagShouldDecorate = false;
            }
            super.draw(canvas);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (hasDecorateColorFilter() && this.supportDark) {
            PorterDuffModeHelper.decorateSrcATopMode(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mFlagShouldDecorate = true;
        super.setImageDrawable(drawable);
    }

    @Override // com.baidu.searchbox.ui.fontsize.view.FontSizeImageView, com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public void setIsResponseFontSize(boolean z) {
        this.mIsResponseFontSize = z;
    }

    public void setSupportDark(Boolean bool) {
        this.supportDark = bool.booleanValue();
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
        this.mIsResponseFontSize = false;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
        this.supportDark = true;
        this.mIsResponseFontSize = false;
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

    @Override // com.baidu.searchbox.ui.fontsize.view.FontSizeImageView, com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener
    public boolean isResponseFontSize() {
        return this.mIsResponseFontSize;
    }
}
