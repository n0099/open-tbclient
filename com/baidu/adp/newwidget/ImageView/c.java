package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable IS;
    public com.baidu.adp.widget.ImageView.a IT;
    public volatile boolean isDefault = true;

    public boolean mi() {
        return (this.IS == null || this.IS.getBitmap() == null || this.IS.getBitmap().isRecycled()) ? false : true;
    }

    public boolean mj() {
        return this.IT != null && this.IT.oq();
    }

    public boolean isAvailable() {
        return mi() || mj();
    }

    public int getWidth() {
        if (mi()) {
            return this.IS.getIntrinsicWidth();
        }
        if (mj()) {
            return this.IT.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (mi()) {
            return this.IS.getIntrinsicHeight();
        }
        if (mj()) {
            return this.IT.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.IT = null;
        this.IS = null;
    }
}
