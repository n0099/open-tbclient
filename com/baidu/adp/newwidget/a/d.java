package com.baidu.adp.newwidget.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public volatile boolean isDefault = true;
    public BitmapDrawable re;
    public com.baidu.adp.widget.a.a rf;

    public boolean gE() {
        return (this.re == null || this.re.getBitmap() == null) ? false : true;
    }

    public boolean gF() {
        return this.rf != null && this.rf.jj();
    }

    public boolean isAvailable() {
        return gE() || gF();
    }

    public int getWidth() {
        if (gE()) {
            return this.re.getIntrinsicWidth();
        }
        if (gF()) {
            return this.rf.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (gE()) {
            return this.re.getIntrinsicHeight();
        }
        if (gF()) {
            return this.rf.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.rf = null;
        this.re = null;
    }

    public boolean cm() {
        if (gF()) {
            return this.rf.cm();
        }
        return false;
    }
}
