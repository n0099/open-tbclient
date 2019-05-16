package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable GI;
    public com.baidu.adp.widget.ImageView.a GJ;
    public volatile boolean isDefault = true;

    public boolean lh() {
        return (this.GI == null || this.GI.getBitmap() == null || this.GI.getBitmap().isRecycled()) ? false : true;
    }

    public boolean li() {
        return this.GJ != null && this.GJ.nt();
    }

    public boolean isAvailable() {
        return lh() || li();
    }

    public int getWidth() {
        if (lh()) {
            return this.GI.getIntrinsicWidth();
        }
        if (li()) {
            return this.GJ.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (lh()) {
            return this.GI.getIntrinsicHeight();
        }
        if (li()) {
            return this.GJ.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.GJ = null;
        this.GI = null;
    }
}
