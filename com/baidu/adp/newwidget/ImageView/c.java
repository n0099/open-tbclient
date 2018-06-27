package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable FU;
    public com.baidu.adp.widget.ImageView.a FV;
    public volatile boolean isDefault = true;

    public boolean kT() {
        return (this.FU == null || this.FU.getBitmap() == null || this.FU.getBitmap().isRecycled()) ? false : true;
    }

    public boolean kU() {
        return this.FV != null && this.FV.na();
    }

    public boolean isAvailable() {
        return kT() || kU();
    }

    public int getWidth() {
        if (kT()) {
            return this.FU.getIntrinsicWidth();
        }
        if (kU()) {
            return this.FV.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kT()) {
            return this.FU.getIntrinsicHeight();
        }
        if (kU()) {
            return this.FV.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.FV = null;
        this.FU = null;
    }
}
