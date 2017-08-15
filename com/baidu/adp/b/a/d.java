package com.baidu.adp.b.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {
    public BitmapDrawable DA;
    public com.baidu.adp.widget.a.a DB;
    public volatile boolean isDefault = true;

    public boolean iM() {
        return (this.DA == null || this.DA.getBitmap() == null || this.DA.getBitmap().isRecycled()) ? false : true;
    }

    public boolean iN() {
        return this.DB != null && this.DB.kY();
    }

    public boolean isAvailable() {
        return iM() || iN();
    }

    public int getWidth() {
        if (iM()) {
            return this.DA.getIntrinsicWidth();
        }
        if (iN()) {
            return this.DB.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (iM()) {
            return this.DA.getIntrinsicHeight();
        }
        if (iN()) {
            return this.DB.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.DB = null;
        this.DA = null;
    }

    public boolean isGif() {
        if (iN()) {
            return this.DB.isGif();
        }
        return false;
    }
}
