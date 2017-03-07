package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Cv;
    public com.baidu.adp.widget.a.a Cw;
    public volatile boolean isDefault = true;

    public boolean iB() {
        return (this.Cv == null || this.Cv.getBitmap() == null || this.Cv.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iC() {
        return this.Cw != null && this.Cw.kO();
    }

    public boolean isAvailable() {
        return iB() || iC();
    }

    public int getWidth() {
        if (iB()) {
            return this.Cv.getIntrinsicWidth();
        }
        if (iC()) {
            return this.Cw.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iB()) {
            return this.Cv.getIntrinsicHeight();
        }
        if (iC()) {
            return this.Cw.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Cw = null;
        this.Cv = null;
    }

    public boolean ef() {
        if (iC()) {
            return this.Cw.ef();
        }
        return false;
    }
}
