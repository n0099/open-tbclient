package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.swan.apps.an.s;
/* loaded from: classes2.dex */
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
            s.a(getContext(), getDrawable());
            this.mColorFilter = s.bM(getContext());
            this.mFlagShouldDecorate = false;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int i) {
        if (hasDecorateColorFilter()) {
            s.a(getContext(), getDrawable(), i);
        } else {
            super.setImageAlpha(i);
        }
    }

    private boolean shouldDecorate() {
        return this.mFlagShouldDecorate || this.mColorFilter != s.bM(getContext());
    }

    private boolean hasDecorateColorFilter() {
        return Color.alpha(s.bM(getContext())) != 0;
    }
}
