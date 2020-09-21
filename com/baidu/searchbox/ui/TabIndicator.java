package com.baidu.searchbox.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes19.dex */
public class TabIndicator extends Drawable {
    private int mAlpha;
    private int mCount;
    private int mCurrentIndex;
    private Drawable mSelected;
    private int mSpacing;
    private Drawable mUnselected;

    public TabIndicator(Resources resources, int i, int i2, int i3) {
        this(resources, i, i2, i3, 0);
    }

    public TabIndicator(Resources resources, int i, int i2, int i3, int i4) {
        this.mCurrentIndex = -1;
        this.mAlpha = 255;
        this.mSpacing = 0;
        this.mSpacing = i4;
        this.mSelected = resources.getDrawable(i);
        this.mUnselected = resources.getDrawable(i2);
        this.mSelected.setBounds(0, 0, this.mSelected.getIntrinsicWidth(), this.mSelected.getIntrinsicHeight());
        this.mUnselected.setBounds(0, 0, this.mUnselected.getIntrinsicWidth(), this.mUnselected.getIntrinsicHeight());
        setBounds(0, 0, getWidthForIndicators(i3) + ((i3 - 1) * this.mSpacing), Math.max(this.mUnselected.getIntrinsicHeight(), this.mSelected.getIntrinsicHeight()));
    }

    private int getWidthForIndicators(int i) {
        return (this.mUnselected.getIntrinsicWidth() * (i - 1)) + this.mSelected.getIntrinsicWidth();
    }

    public void setIndicatorCount(int i) {
        this.mCount = i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    public void setSelectedIndex(int i) {
        this.mCurrentIndex = i;
        setIndicatorCount(this.mCount);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        int save = canvas.save();
        int i = this.mCount;
        canvas.translate((getBounds().width() - (getWidthForIndicators(i) + ((i - 1) * this.mSpacing))) / 2, 0.0f);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == this.mCurrentIndex) {
                drawable = this.mSelected;
            } else {
                drawable = this.mUnselected;
            }
            if (this.mAlpha != 255) {
                drawable.setAlpha(this.mAlpha);
            }
            drawable.draw(canvas);
            canvas.translate(drawable.getIntrinsicWidth() + this.mSpacing, 0.0f);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void updateDrawable(Resources resources, int i, int i2) {
        this.mSelected = resources.getDrawable(i);
        this.mUnselected = resources.getDrawable(i2);
        this.mSelected.setBounds(0, 0, this.mSelected.getIntrinsicWidth(), this.mSelected.getIntrinsicHeight());
        this.mUnselected.setBounds(0, 0, this.mUnselected.getIntrinsicWidth(), this.mUnselected.getIntrinsicHeight());
    }
}
