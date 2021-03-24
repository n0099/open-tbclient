package com.baidu.livesdk.api.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public interface ImageLoader {
    Bitmap getBitmapFromCache(String str);

    boolean hasCache(String str);

    void loadImage(String str, ImageView imageView);

    void loadImage(String str, ImageView imageView, int i, int i2, ImageLoadListener imageLoadListener, ImageProcessor imageProcessor);

    void loadImage(String str, ImageView imageView, ImageLoadListener imageLoadListener);

    void release();
}
