package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public volatile boolean isDefault = true;
    public BitmapDrawable zK;
    public com.baidu.adp.widget.ImageView.a zL;

    /* renamed from: if  reason: not valid java name */
    public boolean m10if() {
        return (this.zK == null || this.zK.getBitmap() == null || this.zK.getBitmap().isRecycled()) ? false : true;
    }

    public boolean ig() {
        return this.zL != null && this.zL.kn();
    }

    public boolean isAvailable() {
        return m10if() || ig();
    }

    public int getWidth() {
        if (m10if()) {
            return this.zK.getIntrinsicWidth();
        }
        if (ig()) {
            return this.zL.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (m10if()) {
            return this.zK.getIntrinsicHeight();
        }
        if (ig()) {
            return this.zL.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.zL = null;
        this.zK = null;
    }
}
