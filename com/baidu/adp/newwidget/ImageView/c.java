package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable FQ;
    public com.baidu.adp.widget.ImageView.a FR;
    public volatile boolean isDefault = true;

    public boolean kV() {
        return (this.FQ == null || this.FQ.getBitmap() == null || this.FQ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean kW() {
        return this.FR != null && this.FR.nc();
    }

    public boolean isAvailable() {
        return kV() || kW();
    }

    public int getWidth() {
        if (kV()) {
            return this.FQ.getIntrinsicWidth();
        }
        if (kW()) {
            return this.FR.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (kV()) {
            return this.FQ.getIntrinsicHeight();
        }
        if (kW()) {
            return this.FR.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.FR = null;
        this.FQ = null;
    }
}
