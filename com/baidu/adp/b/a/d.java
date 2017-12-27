package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable apo;
    public com.baidu.adp.widget.a.a apq;
    public volatile boolean isDefault = true;

    public boolean pZ() {
        return (this.apo == null || this.apo.getBitmap() == null || this.apo.getBitmap().isRecycled()) ? false : true;
    }

    public boolean qa() {
        return this.apq != null && this.apq.sj();
    }

    public boolean isAvailable() {
        return pZ() || qa();
    }

    public int getWidth() {
        if (pZ()) {
            return this.apo.getIntrinsicWidth();
        }
        if (qa()) {
            return this.apq.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (pZ()) {
            return this.apo.getIntrinsicHeight();
        }
        if (qa()) {
            return this.apq.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.apq = null;
        this.apo = null;
    }
}
