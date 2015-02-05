package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable rj;
    public com.baidu.adp.widget.a.a rk;

    public boolean gE() {
        return (this.rj == null || this.rj.getBitmap() == null) ? false : true;
    }

    public boolean gF() {
        return this.rk != null && this.rk.jd();
    }

    public boolean isAvailable() {
        return gE() || gF();
    }

    public int getWidth() {
        if (gE()) {
            return this.rj.getIntrinsicWidth();
        }
        if (gF()) {
            return this.rk.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gE()) {
            return this.rj.getIntrinsicHeight();
        }
        if (gF()) {
            return this.rk.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.rk = null;
        this.rj = null;
    }

    public boolean ck() {
        if (gF()) {
            return this.rk.ck();
        }
        return false;
    }
}
