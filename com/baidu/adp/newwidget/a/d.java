package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BC;
    public com.baidu.adp.widget.a.a BD;
    public volatile boolean isDefault = true;

    public boolean kj() {
        return (this.BC == null || this.BC.getBitmap() == null) ? false : true;
    }

    public boolean kk() {
        return this.BD != null && this.BD.nh();
    }

    public boolean isAvailable() {
        return kj() || kk();
    }

    public int getWidth() {
        if (kj()) {
            return this.BC.getIntrinsicWidth();
        }
        if (kk()) {
            return this.BD.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kj()) {
            return this.BC.getIntrinsicHeight();
        }
        if (kk()) {
            return this.BD.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BD = null;
        this.BC = null;
    }

    public boolean fF() {
        if (kk()) {
            return this.BD.fF();
        }
        return false;
    }
}
