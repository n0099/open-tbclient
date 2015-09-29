package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bv;
    public com.baidu.adp.widget.a.a Bw;
    public volatile boolean isDefault = true;

    public boolean kh() {
        return (this.Bv == null || this.Bv.getBitmap() == null) ? false : true;
    }

    public boolean ki() {
        return this.Bw != null && this.Bw.nb();
    }

    public boolean isAvailable() {
        return kh() || ki();
    }

    public int getWidth() {
        if (kh()) {
            return this.Bv.getIntrinsicWidth();
        }
        if (ki()) {
            return this.Bw.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kh()) {
            return this.Bv.getIntrinsicHeight();
        }
        if (ki()) {
            return this.Bw.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bw = null;
        this.Bv = null;
    }

    public boolean fF() {
        if (ki()) {
            return this.Bw.fF();
        }
        return false;
    }
}
