package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable vh;
    public com.baidu.adp.widget.a.a vi;

    public boolean hH() {
        return (this.vh == null || this.vh.getBitmap() == null || this.vh.getBitmap().isRecycled()) ? false : true;
    }

    public boolean hI() {
        return this.vi != null && this.vi.jU();
    }

    public boolean isAvailable() {
        return hH() || hI();
    }

    public int getWidth() {
        if (hH()) {
            return this.vh.getIntrinsicWidth();
        }
        if (hI()) {
            return this.vi.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (hH()) {
            return this.vh.getIntrinsicHeight();
        }
        if (hI()) {
            return this.vi.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.vi = null;
        this.vh = null;
    }

    public boolean cW() {
        if (hI()) {
            return this.vi.cW();
        }
        return false;
    }
}
