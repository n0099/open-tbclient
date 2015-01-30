package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable rj;
    public com.baidu.adp.widget.a.a rk;

    public boolean gD() {
        return (this.rj == null || this.rj.getBitmap() == null) ? false : true;
    }

    public boolean gE() {
        return this.rk != null && this.rk.jk();
    }

    public boolean isAvailable() {
        return gD() || gE();
    }

    public int getWidth() {
        if (gD()) {
            return this.rj.getIntrinsicWidth();
        }
        if (gE()) {
            return this.rk.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gD()) {
            return this.rj.getIntrinsicHeight();
        }
        if (gE()) {
            return this.rk.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.rk = null;
        this.rj = null;
    }

    public boolean ck() {
        if (gE()) {
            return this.rk.ck();
        }
        return false;
    }
}
