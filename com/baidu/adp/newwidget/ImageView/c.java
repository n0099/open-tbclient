package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable FR;
    public com.baidu.adp.widget.ImageView.a FT;
    public volatile boolean isDefault = true;

    public boolean kT() {
        return (this.FR == null || this.FR.getBitmap() == null || this.FR.getBitmap().isRecycled()) ? false : true;
    }

    public boolean kU() {
        return this.FT != null && this.FT.na();
    }

    public boolean isAvailable() {
        return kT() || kU();
    }

    public int getWidth() {
        if (kT()) {
            return this.FR.getIntrinsicWidth();
        }
        if (kU()) {
            return this.FT.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kT()) {
            return this.FR.getIntrinsicHeight();
        }
        if (kU()) {
            return this.FT.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.FT = null;
        this.FR = null;
    }
}
