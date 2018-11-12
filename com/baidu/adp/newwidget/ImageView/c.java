package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable IS;
    public com.baidu.adp.widget.ImageView.a IT;
    public volatile boolean isDefault = true;

    public boolean mj() {
        return (this.IS == null || this.IS.getBitmap() == null || this.IS.getBitmap().isRecycled()) ? false : true;
    }

    public boolean mk() {
        return this.IT != null && this.IT.or();
    }

    public boolean isAvailable() {
        return mj() || mk();
    }

    public int getWidth() {
        if (mj()) {
            return this.IS.getIntrinsicWidth();
        }
        if (mk()) {
            return this.IT.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (mj()) {
            return this.IS.getIntrinsicHeight();
        }
        if (mk()) {
            return this.IT.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.IT = null;
        this.IS = null;
    }
}
