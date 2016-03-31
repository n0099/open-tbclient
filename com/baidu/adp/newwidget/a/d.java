package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Ch;
    public com.baidu.adp.widget.a.a Ci;
    public volatile boolean isDefault = true;

    public boolean kA() {
        return (this.Ch == null || this.Ch.getBitmap() == null) ? false : true;
    }

    public boolean kB() {
        return this.Ci != null && this.Ci.mL();
    }

    public boolean isAvailable() {
        return kA() || kB();
    }

    public int getWidth() {
        if (kA()) {
            return this.Ch.getIntrinsicWidth();
        }
        if (kB()) {
            return this.Ci.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kA()) {
            return this.Ch.getIntrinsicHeight();
        }
        if (kB()) {
            return this.Ci.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Ci = null;
        this.Ch = null;
    }

    public boolean fO() {
        if (kB()) {
            return this.Ci.fO();
        }
        return false;
    }
}
