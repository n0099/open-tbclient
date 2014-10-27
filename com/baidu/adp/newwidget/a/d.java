package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable rk;
    public com.baidu.adp.widget.a.a rl;

    public boolean gD() {
        return (this.rk == null || this.rk.getBitmap() == null) ? false : true;
    }

    public boolean gE() {
        return this.rl != null && this.rl.hm();
    }

    public boolean isAvailable() {
        return gD() || gE();
    }

    public int getWidth() {
        if (gD()) {
            return this.rk.getIntrinsicWidth();
        }
        if (gE()) {
            return this.rl.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gD()) {
            return this.rk.getIntrinsicHeight();
        }
        if (gE()) {
            return this.rl.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.rl = null;
        this.rk = null;
    }

    public boolean bM() {
        if (gE()) {
            return this.rl.bM();
        }
        return false;
    }
}
