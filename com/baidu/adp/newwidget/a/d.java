package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BM;
    public com.baidu.adp.widget.a.a BN;
    public volatile boolean isDefault = true;

    public boolean kq() {
        return (this.BM == null || this.BM.getBitmap() == null) ? false : true;
    }

    public boolean kr() {
        return this.BN != null && this.BN.mT();
    }

    public boolean isAvailable() {
        return kq() || kr();
    }

    public int getWidth() {
        if (kq()) {
            return this.BM.getIntrinsicWidth();
        }
        if (kr()) {
            return this.BN.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kq()) {
            return this.BM.getIntrinsicHeight();
        }
        if (kr()) {
            return this.BN.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BN = null;
        this.BM = null;
    }

    public boolean fN() {
        if (kr()) {
            return this.BN.fN();
        }
        return false;
    }
}
