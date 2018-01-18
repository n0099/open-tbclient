package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable apn;
    public com.baidu.adp.widget.a.a apo;
    public volatile boolean isDefault = true;

    public boolean pZ() {
        return (this.apn == null || this.apn.getBitmap() == null || this.apn.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qa() {
        return this.apo != null && this.apo.sj();
    }

    public boolean isAvailable() {
        return pZ() || qa();
    }

    public int getWidth() {
        if (pZ()) {
            return this.apn.getIntrinsicWidth();
        }
        if (qa()) {
            return this.apo.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (pZ()) {
            return this.apn.getIntrinsicHeight();
        }
        if (qa()) {
            return this.apo.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.apo = null;
        this.apn = null;
    }
}
