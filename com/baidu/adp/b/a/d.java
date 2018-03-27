package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable api;
    public com.baidu.adp.widget.a.a apj;
    public volatile boolean isDefault = true;

    public boolean qa() {
        return (this.api == null || this.api.getBitmap() == null || this.api.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qb() {
        return this.apj != null && this.apj.si();
    }

    public boolean isAvailable() {
        return qa() || qb();
    }

    public int getWidth() {
        if (qa()) {
            return this.api.getIntrinsicWidth();
        }
        if (qb()) {
            return this.apj.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (qa()) {
            return this.api.getIntrinsicHeight();
        }
        if (qb()) {
            return this.apj.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.apj = null;
        this.api = null;
    }
}
