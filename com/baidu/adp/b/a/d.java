package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable apr;
    public com.baidu.adp.widget.a.a aps;
    public volatile boolean isDefault = true;

    public boolean qa() {
        return (this.apr == null || this.apr.getBitmap() == null || this.apr.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qb() {
        return this.aps != null && this.aps.sk();
    }

    public boolean isAvailable() {
        return qa() || qb();
    }

    public int getWidth() {
        if (qa()) {
            return this.apr.getIntrinsicWidth();
        }
        if (qb()) {
            return this.aps.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (qa()) {
            return this.apr.getIntrinsicHeight();
        }
        if (qb()) {
            return this.aps.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.aps = null;
        this.apr = null;
    }
}
