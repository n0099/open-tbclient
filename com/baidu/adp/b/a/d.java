package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable Bx;
    public com.baidu.adp.widget.ImageView.a By;
    public volatile boolean isDefault = true;

    public boolean iD() {
        return (this.Bx == null || this.Bx.getBitmap() == null || this.Bx.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iE() {
        return this.By != null && this.By.kO();
    }

    public boolean isAvailable() {
        return iD() || iE();
    }

    public int getWidth() {
        if (iD()) {
            return this.Bx.getIntrinsicWidth();
        }
        if (iE()) {
            return this.By.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iD()) {
            return this.Bx.getIntrinsicHeight();
        }
        if (iE()) {
            return this.By.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.By = null;
        this.Bx = null;
    }
}
