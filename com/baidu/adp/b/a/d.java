package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BZ;
    public com.baidu.adp.widget.a.a Ca;
    public volatile boolean isDefault = true;

    public boolean iC() {
        return (this.BZ == null || this.BZ.getBitmap() == null || this.BZ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iD() {
        return this.Ca != null && this.Ca.kO();
    }

    public boolean isAvailable() {
        return iC() || iD();
    }

    public int getWidth() {
        if (iC()) {
            return this.BZ.getIntrinsicWidth();
        }
        if (iD()) {
            return this.Ca.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iC()) {
            return this.BZ.getIntrinsicHeight();
        }
        if (iD()) {
            return this.Ca.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Ca = null;
        this.BZ = null;
    }

    public boolean isGif() {
        if (iD()) {
            return this.Ca.isGif();
        }
        return false;
    }
}
