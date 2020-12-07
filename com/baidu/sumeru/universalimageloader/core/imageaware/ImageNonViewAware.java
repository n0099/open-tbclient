package com.baidu.sumeru.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sumeru.universalimageloader.core.assist.ImageSize;
import com.baidu.sumeru.universalimageloader.core.assist.ViewScaleType;
/* loaded from: classes11.dex */
public class ImageNonViewAware implements ImageAware {
    protected final ImageSize imageSize;
    protected final String imageUri;
    protected final ViewScaleType scaleType;

    public ImageNonViewAware(ImageSize imageSize, ViewScaleType viewScaleType) {
        this(null, imageSize, viewScaleType);
    }

    public ImageNonViewAware(String str, ImageSize imageSize, ViewScaleType viewScaleType) {
        this.imageUri = str;
        this.imageSize = imageSize;
        this.scaleType = viewScaleType;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        return this.imageSize.getWidth();
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        return this.imageSize.getHeight();
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return null;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return false;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public int getId() {
        return TextUtils.isEmpty(this.imageUri) ? super.hashCode() : this.imageUri.hashCode();
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }
}
