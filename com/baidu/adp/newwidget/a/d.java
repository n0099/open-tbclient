package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BZ;
    public com.baidu.adp.widget.a.a Ca;
    public volatile boolean isDefault = true;

    public boolean iG() {
        return (this.BZ == null || this.BZ.getBitmap() == null || this.BZ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iH() {
        return this.Ca != null && this.Ca.kT();
    }

    public boolean isAvailable() {
        return iG() || iH();
    }

    public int getWidth() {
        if (iG()) {
            return this.BZ.getIntrinsicWidth();
        }
        if (iH()) {
            return this.Ca.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iG()) {
            return this.BZ.getIntrinsicHeight();
        }
        if (iH()) {
            return this.Ca.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Ca = null;
        this.BZ = null;
    }

    public boolean ef() {
        if (iH()) {
            return this.Ca.ef();
        }
        return false;
    }
}
