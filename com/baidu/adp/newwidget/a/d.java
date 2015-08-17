package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bw;
    public com.baidu.adp.widget.a.a Bx;
    public volatile boolean isDefault = true;

    public boolean kj() {
        return (this.Bw == null || this.Bw.getBitmap() == null) ? false : true;
    }

    public boolean kk() {
        return this.Bx != null && this.Bx.nd();
    }

    public boolean isAvailable() {
        return kj() || kk();
    }

    public int getWidth() {
        if (kj()) {
            return this.Bw.getIntrinsicWidth();
        }
        if (kk()) {
            return this.Bx.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kj()) {
            return this.Bw.getIntrinsicHeight();
        }
        if (kk()) {
            return this.Bx.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bx = null;
        this.Bw = null;
    }

    public boolean fI() {
        if (kk()) {
            return this.Bx.fI();
        }
        return false;
    }
}
