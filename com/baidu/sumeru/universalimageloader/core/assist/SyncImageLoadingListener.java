package com.baidu.sumeru.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;
/* loaded from: classes9.dex */
public class SyncImageLoadingListener extends SimpleImageLoadingListener {
    private Bitmap loadedImage;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.SimpleImageLoadingListener, com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        this.loadedImage = bitmap;
    }

    public Bitmap getLoadedBitmap() {
        return this.loadedImage;
    }
}
