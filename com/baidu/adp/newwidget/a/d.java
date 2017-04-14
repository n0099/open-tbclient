package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable BW;
    public com.baidu.adp.widget.a.a BX;
    public volatile boolean isDefault = true;

    public boolean iF() {
        return (this.BW == null || this.BW.getBitmap() == null || this.BW.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iG() {
        return this.BX != null && this.BX.kS();
    }

    public boolean isAvailable() {
        return iF() || iG();
    }

    public int getWidth() {
        if (iF()) {
            return this.BW.getIntrinsicWidth();
        }
        if (iG()) {
            return this.BX.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iF()) {
            return this.BW.getIntrinsicHeight();
        }
        if (iG()) {
            return this.BX.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.BX = null;
        this.BW = null;
    }

    public boolean ee() {
        if (iG()) {
            return this.BX.ee();
        }
        return false;
    }
}
