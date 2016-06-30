package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable sx;
    public com.baidu.adp.widget.a.a sy;

    public boolean gP() {
        return (this.sx == null || this.sx.getBitmap() == null) ? false : true;
    }

    public boolean gQ() {
        return this.sy != null && this.sy.jc();
    }

    public boolean isAvailable() {
        return gP() || gQ();
    }

    public int getWidth() {
        if (gP()) {
            return this.sx.getIntrinsicWidth();
        }
        if (gQ()) {
            return this.sy.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gP()) {
            return this.sx.getIntrinsicHeight();
        }
        if (gQ()) {
            return this.sy.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.sy = null;
        this.sx = null;
    }

    public boolean ce() {
        if (gQ()) {
            return this.sy.ce();
        }
        return false;
    }
}
