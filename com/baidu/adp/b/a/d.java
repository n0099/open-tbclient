package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bu;
    public com.baidu.adp.widget.a.a Bv;
    public volatile boolean isDefault = true;

    public boolean iE() {
        return (this.Bu == null || this.Bu.getBitmap() == null || this.Bu.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iF() {
        return this.Bv != null && this.Bv.kP();
    }

    public boolean isAvailable() {
        return iE() || iF();
    }

    public int getWidth() {
        if (iE()) {
            return this.Bu.getIntrinsicWidth();
        }
        if (iF()) {
            return this.Bv.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iE()) {
            return this.Bu.getIntrinsicHeight();
        }
        if (iF()) {
            return this.Bv.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bv = null;
        this.Bu = null;
    }

    public boolean isGif() {
        if (iF()) {
            return this.Bv.isGif();
        }
        return false;
    }
}
