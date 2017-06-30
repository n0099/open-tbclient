package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BZ;
    public com.baidu.adp.widget.a.a Ca;
    public volatile boolean isDefault = true;

    public boolean iE() {
        return (this.BZ == null || this.BZ.getBitmap() == null || this.BZ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iF() {
        return this.Ca != null && this.Ca.kQ();
    }

    public boolean isAvailable() {
        return iE() || iF();
    }

    public int getWidth() {
        if (iE()) {
            return this.BZ.getIntrinsicWidth();
        }
        if (iF()) {
            return this.Ca.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iE()) {
            return this.BZ.getIntrinsicHeight();
        }
        if (iF()) {
            return this.Ca.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Ca = null;
        this.BZ = null;
    }

    public boolean isGif() {
        if (iF()) {
            return this.Ca.isGif();
        }
        return false;
    }
}
