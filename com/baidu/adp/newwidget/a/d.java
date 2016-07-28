package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable sZ;
    public com.baidu.adp.widget.a.a tb;

    public boolean gO() {
        return (this.sZ == null || this.sZ.getBitmap() == null || this.sZ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean gP() {
        return this.tb != null && this.tb.jb();
    }

    public boolean isAvailable() {
        return gO() || gP();
    }

    public int getWidth() {
        if (gO()) {
            return this.sZ.getIntrinsicWidth();
        }
        if (gP()) {
            return this.tb.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gO()) {
            return this.sZ.getIntrinsicHeight();
        }
        if (gP()) {
            return this.tb.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.tb = null;
        this.sZ = null;
    }

    public boolean cd() {
        if (gP()) {
            return this.tb.cd();
        }
        return false;
    }
}
