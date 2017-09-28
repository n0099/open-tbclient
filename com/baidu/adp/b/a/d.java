package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bw;
    public com.baidu.adp.widget.ImageView.a Bx;
    public volatile boolean isDefault = true;

    public boolean iD() {
        return (this.Bw == null || this.Bw.getBitmap() == null || this.Bw.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iE() {
        return this.Bx != null && this.Bx.kO();
    }

    public boolean isAvailable() {
        return iD() || iE();
    }

    public int getWidth() {
        if (iD()) {
            return this.Bw.getIntrinsicWidth();
        }
        if (iE()) {
            return this.Bx.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iD()) {
            return this.Bw.getIntrinsicHeight();
        }
        if (iE()) {
            return this.Bx.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Bx = null;
        this.Bw = null;
    }
}
