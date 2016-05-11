package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable sw;
    public com.baidu.adp.widget.a.a sx;

    public boolean gN() {
        return (this.sw == null || this.sw.getBitmap() == null) ? false : true;
    }

    public boolean gO() {
        return this.sx != null && this.sx.iZ();
    }

    public boolean isAvailable() {
        return gN() || gO();
    }

    public int getWidth() {
        if (gN()) {
            return this.sw.getIntrinsicWidth();
        }
        if (gO()) {
            return this.sx.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gN()) {
            return this.sw.getIntrinsicHeight();
        }
        if (gO()) {
            return this.sx.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.sx = null;
        this.sw = null;
    }

    public boolean cd() {
        if (gO()) {
            return this.sx.cd();
        }
        return false;
    }
}
