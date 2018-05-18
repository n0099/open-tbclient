package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public volatile boolean isDefault = true;
    public BitmapDrawable zJ;
    public com.baidu.adp.widget.ImageView.a zK;

    /* renamed from: if  reason: not valid java name */
    public boolean m10if() {
        return (this.zJ == null || this.zJ.getBitmap() == null || this.zJ.getBitmap().isRecycled()) ? false : true;
    }

    public boolean ig() {
        return this.zK != null && this.zK.km();
    }

    public boolean isAvailable() {
        return m10if() || ig();
    }

    public int getWidth() {
        if (m10if()) {
            return this.zJ.getIntrinsicWidth();
        }
        if (ig()) {
            return this.zK.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (m10if()) {
            return this.zJ.getIntrinsicHeight();
        }
        if (ig()) {
            return this.zK.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.zK = null;
        this.zJ = null;
    }
}
