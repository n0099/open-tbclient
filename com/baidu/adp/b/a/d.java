package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BZ;
    public com.baidu.adp.widget.a.a Ca;
    public volatile boolean isDefault = true;

    public boolean iF() {
        return (this.BZ == null || this.BZ.getBitmap() == null || this.BZ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iG() {
        return this.Ca != null && this.Ca.kS();
    }

    public boolean isAvailable() {
        return iF() || iG();
    }

    public int getWidth() {
        if (iF()) {
            return this.BZ.getIntrinsicWidth();
        }
        if (iG()) {
            return this.Ca.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iF()) {
            return this.BZ.getIntrinsicHeight();
        }
        if (iG()) {
            return this.Ca.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Ca = null;
        this.BZ = null;
    }

    public boolean ef() {
        if (iG()) {
            return this.Ca.ef();
        }
        return false;
    }
}
