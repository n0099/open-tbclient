package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Dy;
    public com.baidu.adp.widget.a.a Dz;
    public volatile boolean isDefault = true;

    public boolean iM() {
        return (this.Dy == null || this.Dy.getBitmap() == null || this.Dy.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iN() {
        return this.Dz != null && this.Dz.kY();
    }

    public boolean isAvailable() {
        return iM() || iN();
    }

    public int getWidth() {
        if (iM()) {
            return this.Dy.getIntrinsicWidth();
        }
        if (iN()) {
            return this.Dz.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iM()) {
            return this.Dy.getIntrinsicHeight();
        }
        if (iN()) {
            return this.Dz.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Dz = null;
        this.Dy = null;
    }

    public boolean isGif() {
        if (iN()) {
            return this.Dz.isGif();
        }
        return false;
    }
}
