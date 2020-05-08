package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public com.baidu.adp.widget.ImageView.a Pz;
    public BitmapDrawable drawable;
    public volatile boolean isDefault = true;

    public boolean isDrawableAvalible() {
        return (this.drawable == null || this.drawable.getBitmap() == null || this.drawable.getBitmap().isRecycled()) ? false : true;
    }

    public boolean isBdImgAvailable() {
        return this.Pz != null && this.Pz.isValidNow();
    }

    public boolean isAvailable() {
        return isDrawableAvalible() || isBdImgAvailable();
    }

    public int getWidth() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicWidth();
        }
        if (isBdImgAvailable()) {
            return this.Pz.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicHeight();
        }
        if (isBdImgAvailable()) {
            return this.Pz.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Pz = null;
        this.drawable = null;
    }
}
