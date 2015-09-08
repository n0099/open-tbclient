package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bu;
    public com.baidu.adp.widget.a.a Bv;
    public volatile boolean isDefault = true;

    public boolean kg() {
        return (this.Bu == null || this.Bu.getBitmap() == null) ? false : true;
    }

    public boolean kh() {
        return this.Bv != null && this.Bv.na();
    }

    public boolean isAvailable() {
        return kg() || kh();
    }

    public int getWidth() {
        if (kg()) {
            return this.Bu.getIntrinsicWidth();
        }
        if (kh()) {
            return this.Bv.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kg()) {
            return this.Bu.getIntrinsicHeight();
        }
        if (kh()) {
            return this.Bv.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bv = null;
        this.Bu = null;
    }

    public boolean fF() {
        if (kh()) {
            return this.Bv.fF();
        }
        return false;
    }
}
