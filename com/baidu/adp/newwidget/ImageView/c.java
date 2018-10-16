package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable IO;
    public com.baidu.adp.widget.ImageView.a IP;
    public volatile boolean isDefault = true;

    public boolean ml() {
        return (this.IO == null || this.IO.getBitmap() == null || this.IO.getBitmap().isRecycled()) ? false : true;
    }

    public boolean mm() {
        return this.IP != null && this.IP.ot();
    }

    public boolean isAvailable() {
        return ml() || mm();
    }

    public int getWidth() {
        if (ml()) {
            return this.IO.getIntrinsicWidth();
        }
        if (mm()) {
            return this.IP.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (ml()) {
            return this.IO.getIntrinsicHeight();
        }
        if (mm()) {
            return this.IP.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.IP = null;
        this.IO = null;
    }
}
