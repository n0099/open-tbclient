package com.baidu.live.adp.newwidget.imageview;

import android.graphics.drawable.BitmapDrawable;
import com.baidu.live.adp.widget.imageview.BdImage;
/* loaded from: classes7.dex */
public class DisplayImage {
    public BdImage bdImg;
    public BitmapDrawable drawable;
    public volatile boolean isDefault = true;

    public boolean isDrawableAvalible() {
        return (this.drawable == null || this.drawable.getBitmap() == null || this.drawable.getBitmap().isRecycled()) ? false : true;
    }

    public boolean isBdImgAvailable() {
        return this.bdImg != null && this.bdImg.isValidNow();
    }

    public boolean isAvailable() {
        return isDrawableAvalible() || isBdImgAvailable();
    }

    public int getWidth() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicWidth();
        }
        if (isBdImgAvailable()) {
            return this.bdImg.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (isDrawableAvalible()) {
            return this.drawable.getIntrinsicHeight();
        }
        if (isBdImgAvailable()) {
            return this.bdImg.getHeight();
        }
        return 0;
    }

    public void reset() {
        this.bdImg = null;
        this.drawable = null;
    }

    public boolean isGif() {
        if (isBdImgAvailable()) {
            return this.bdImg.isGif();
        }
        return false;
    }
}
