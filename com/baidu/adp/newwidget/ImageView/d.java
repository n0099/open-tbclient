package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public com.baidu.adp.widget.ImageView.a Sy;
    public BitmapDrawable drawable;
    public volatile boolean isDefault = true;

    public boolean isDrawableAvalible() {
        return (this.drawable == null || this.drawable.getBitmap() == null || this.drawable.getBitmap().isRecycled()) ? false : true;
    }

    public boolean isBdImgAvailable() {
        return this.Sy != null && this.Sy.isValidNow();
    }

    public boolean isAvailable() {
        return isDrawableAvalible() || isBdImgAvailable();
    }

    public int getWidth() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicWidth();
        }
        if (isBdImgAvailable()) {
            return this.Sy.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicHeight();
        }
        if (isBdImgAvailable()) {
            return this.Sy.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Sy = null;
        this.drawable = null;
    }
}
