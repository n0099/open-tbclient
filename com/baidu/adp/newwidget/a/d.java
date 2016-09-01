package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable vp;
    public com.baidu.adp.widget.a.a vq;

    public boolean hJ() {
        return (this.vp == null || this.vp.getBitmap() == null || this.vp.getBitmap().isRecycled()) ? false : true;
    }

    public boolean hK() {
        return this.vq != null && this.vq.jW();
    }

    public boolean isAvailable() {
        return hJ() || hK();
    }

    public int getWidth() {
        if (hJ()) {
            return this.vp.getIntrinsicWidth();
        }
        if (hK()) {
            return this.vq.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (hJ()) {
            return this.vp.getIntrinsicHeight();
        }
        if (hK()) {
            return this.vq.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.vq = null;
        this.vp = null;
    }

    public boolean cY() {
        if (hK()) {
            return this.vq.cY();
        }
        return false;
    }
}
