package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.swan.apps.ap.z;
/* loaded from: classes7.dex */
public class BdBaseImageView extends ImageView {
    private int mColorFilter;
    private boolean mFlagShouldDecorate;

    public BdBaseImageView(Context context) {
        super(context);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    public BdBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFlagShouldDecorate = true;
        this.mColorFilter = 0;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mFlagShouldDecorate = true;
        super.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (shouldDecorate()) {
            z.decorateSrcATopMode(getContext(), getDrawable());
            this.mColorFilter = z.getUiCoverLayerColor(getContext());
            this.mFlagShouldDecorate = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (hasDecorateColorFilter()) {
            z.decorateSrcATopMode(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean shouldDecorate() {
        return this.mFlagShouldDecorate || this.mColorFilter != z.getUiCoverLayerColor(getContext());
    }

    private boolean hasDecorateColorFilter() {
        return Color.alpha(z.getUiCoverLayerColor(getContext())) != 0;
    }
}
