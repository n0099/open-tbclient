package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BM;
    public com.baidu.adp.widget.a.a BN;
    public volatile boolean isDefault = true;

    public boolean ku() {
        return (this.BM == null || this.BM.getBitmap() == null) ? false : true;
    }

    public boolean kv() {
        return this.BN != null && this.BN.mT();
    }

    public boolean isAvailable() {
        return ku() || kv();
    }

    public int getWidth() {
        if (ku()) {
            return this.BM.getIntrinsicWidth();
        }
        if (kv()) {
            return this.BN.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (ku()) {
            return this.BM.getIntrinsicHeight();
        }
        if (kv()) {
            return this.BN.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BN = null;
        this.BM = null;
    }

    public boolean fN() {
        if (kv()) {
            return this.BN.fN();
        }
        return false;
    }
}
