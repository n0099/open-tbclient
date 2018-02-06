package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable apq;
    public com.baidu.adp.widget.a.a apr;
    public volatile boolean isDefault = true;

    public boolean qa() {
        return (this.apq == null || this.apq.getBitmap() == null || this.apq.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qb() {
        return this.apr != null && this.apr.si();
    }

    public boolean isAvailable() {
        return qa() || qb();
    }

    public int getWidth() {
        if (qa()) {
            return this.apq.getIntrinsicWidth();
        }
        if (qb()) {
            return this.apr.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (qa()) {
            return this.apq.getIntrinsicHeight();
        }
        if (qb()) {
            return this.apr.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.apr = null;
        this.apq = null;
    }
}
