package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable vq;
    public com.baidu.adp.widget.a.a vr;

    public boolean hJ() {
        return (this.vq == null || this.vq.getBitmap() == null || this.vq.getBitmap().isRecycled()) ? false : true;
    }

    public boolean hK() {
        return this.vr != null && this.vr.jW();
    }

    public boolean isAvailable() {
        return hJ() || hK();
    }

    public int getWidth() {
        if (hJ()) {
            return this.vq.getIntrinsicWidth();
        }
        if (hK()) {
            return this.vr.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (hJ()) {
            return this.vq.getIntrinsicHeight();
        }
        if (hK()) {
            return this.vr.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.vr = null;
        this.vq = null;
    }

    public boolean cY() {
        if (hK()) {
            return this.vr.cY();
        }
        return false;
    }
}
