package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BE;
    public com.baidu.adp.widget.a.a BF;
    public volatile boolean isDefault = true;

    public boolean kk() {
        return (this.BE == null || this.BE.getBitmap() == null) ? false : true;
    }

    public boolean kl() {
        return this.BF != null && this.BF.mF();
    }

    public boolean isAvailable() {
        return kk() || kl();
    }

    public int getWidth() {
        if (kk()) {
            return this.BE.getIntrinsicWidth();
        }
        if (kl()) {
            return this.BF.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kk()) {
            return this.BE.getIntrinsicHeight();
        }
        if (kl()) {
            return this.BF.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BF = null;
        this.BE = null;
    }

    public boolean fF() {
        if (kl()) {
            return this.BF.fF();
        }
        return false;
    }
}
