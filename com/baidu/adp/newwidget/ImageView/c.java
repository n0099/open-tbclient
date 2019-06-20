package com.baidu.adp.newwidget.ImageView;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class c {
    public BitmapDrawable GH;
    public com.baidu.adp.widget.ImageView.a GI;
    public volatile boolean isDefault = true;

    public boolean lh() {
        return (this.GH == null || this.GH.getBitmap() == null || this.GH.getBitmap().isRecycled()) ? false : true;
    }

    public boolean li() {
        return this.GI != null && this.GI.nt();
    }

    public boolean isAvailable() {
        return lh() || li();
    }

    public int getWidth() {
        if (lh()) {
            return this.GH.getIntrinsicWidth();
        }
        if (li()) {
            return this.GI.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (lh()) {
            return this.GH.getIntrinsicHeight();
        }
        if (li()) {
            return this.GI.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.GI = null;
        this.GH = null;
    }
}
