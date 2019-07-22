package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable GQ;
    public com.baidu.adp.widget.ImageView.a GR;
    public volatile boolean isDefault = true;

    public boolean lx() {
        return (this.GQ == null || this.GQ.getBitmap() == null || this.GQ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean ly() {
        return this.GR != null && this.GR.nL();
    }

    public boolean isAvailable() {
        return lx() || ly();
    }

    public int getWidth() {
        if (lx()) {
            return this.GQ.getIntrinsicWidth();
        }
        if (ly()) {
            return this.GR.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (lx()) {
            return this.GQ.getIntrinsicHeight();
        }
        if (ly()) {
            return this.GR.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.GR = null;
        this.GQ = null;
    }
}
