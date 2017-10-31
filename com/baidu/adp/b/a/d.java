package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bh;
    public com.baidu.adp.widget.a.a Bi;
    public volatile boolean isDefault = true;

    public boolean iA() {
        return (this.Bh == null || this.Bh.getBitmap() == null || this.Bh.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iB() {
        return this.Bi != null && this.Bi.kL();
    }

    public boolean isAvailable() {
        return iA() || iB();
    }

    public int getWidth() {
        if (iA()) {
            return this.Bh.getIntrinsicWidth();
        }
        if (iB()) {
            return this.Bi.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iA()) {
            return this.Bh.getIntrinsicHeight();
        }
        if (iB()) {
            return this.Bi.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bi = null;
        this.Bh = null;
    }
}
