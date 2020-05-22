package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public com.baidu.adp.widget.ImageView.a PM;
    public BitmapDrawable drawable;
    public volatile boolean isDefault = true;

    public boolean isDrawableAvalible() {
        return (this.drawable == null || this.drawable.getBitmap() == null || this.drawable.getBitmap().isRecycled()) ? false : true;
    }

    public boolean isBdImgAvailable() {
        return this.PM != null && this.PM.isValidNow();
    }

    public boolean isAvailable() {
        return isDrawableAvalible() || isBdImgAvailable();
    }

    public int getWidth() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicWidth();
        }
        if (isBdImgAvailable()) {
            return this.PM.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicHeight();
        }
        if (isBdImgAvailable()) {
            return this.PM.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.PM = null;
        this.drawable = null;
    }
}
