package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable aph;
    public com.baidu.adp.widget.a.a api;
    public volatile boolean isDefault = true;

    public boolean qa() {
        return (this.aph == null || this.aph.getBitmap() == null || this.aph.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qb() {
        return this.api != null && this.api.si();
    }

    public boolean isAvailable() {
        return qa() || qb();
    }

    public int getWidth() {
        if (qa()) {
            return this.aph.getIntrinsicWidth();
        }
        if (qb()) {
            return this.api.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (qa()) {
            return this.aph.getIntrinsicHeight();
        }
        if (qb()) {
            return this.api.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.api = null;
        this.aph = null;
    }
}
