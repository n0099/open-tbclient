package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable Ja;
    public com.baidu.adp.widget.ImageView.a Jb;
    public volatile boolean isDefault = true;

    public boolean mn() {
        return (this.Ja == null || this.Ja.getBitmap() == null || this.Ja.getBitmap().isRecycled()) ? false : true;
    }

    public boolean mo() {
        return this.Jb != null && this.Jb.oz();
    }

    public boolean isAvailable() {
        return mn() || mo();
    }

    public int getWidth() {
        if (mn()) {
            return this.Ja.getIntrinsicWidth();
        }
        if (mo()) {
            return this.Jb.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (mn()) {
            return this.Ja.getIntrinsicHeight();
        }
        if (mo()) {
            return this.Jb.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.Jb = null;
        this.Ja = null;
    }
}
