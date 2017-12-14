package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bg;
    public com.baidu.adp.widget.a.a Bh;
    public volatile boolean isDefault = true;

    public boolean iA() {
        return (this.Bg == null || this.Bg.getBitmap() == null || this.Bg.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iB() {
        return this.Bh != null && this.Bh.kL();
    }

    public boolean isAvailable() {
        return iA() || iB();
    }

    public int getWidth() {
        if (iA()) {
            return this.Bg.getIntrinsicWidth();
        }
        if (iB()) {
            return this.Bh.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iA()) {
            return this.Bg.getIntrinsicHeight();
        }
        if (iB()) {
            return this.Bh.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bh = null;
        this.Bg = null;
    }
}
