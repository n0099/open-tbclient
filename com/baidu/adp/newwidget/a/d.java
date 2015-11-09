package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bv;
    public com.baidu.adp.widget.a.a Bw;
    public volatile boolean isDefault = true;

    public boolean ki() {
        return (this.Bv == null || this.Bv.getBitmap() == null) ? false : true;
    }

    public boolean kj() {
        return this.Bw != null && this.Bw.nc();
    }

    public boolean isAvailable() {
        return ki() || kj();
    }

    public int getWidth() {
        if (ki()) {
            return this.Bv.getIntrinsicWidth();
        }
        if (kj()) {
            return this.Bw.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (ki()) {
            return this.Bv.getIntrinsicHeight();
        }
        if (kj()) {
            return this.Bw.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bw = null;
        this.Bv = null;
    }

    public boolean fF() {
        if (kj()) {
            return this.Bw.fF();
        }
        return false;
    }
}
