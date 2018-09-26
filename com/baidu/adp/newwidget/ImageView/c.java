package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable Im;
    public com.baidu.adp.widget.ImageView.a In;
    public volatile boolean isDefault = true;

    public boolean mb() {
        return (this.Im == null || this.Im.getBitmap() == null || this.Im.getBitmap().isRecycled()) ? false : true;
    }

    public boolean mc() {
        return this.In != null && this.In.oi();
    }

    public boolean isAvailable() {
        return mb() || mc();
    }

    public int getWidth() {
        if (mb()) {
            return this.Im.getIntrinsicWidth();
        }
        if (mc()) {
            return this.In.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (mb()) {
            return this.Im.getIntrinsicHeight();
        }
        if (mc()) {
            return this.In.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.In = null;
        this.Im = null;
    }
}
