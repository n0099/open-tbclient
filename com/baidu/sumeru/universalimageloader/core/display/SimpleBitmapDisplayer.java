package com.baidu.sumeru.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.baidu.sumeru.universalimageloader.core.assist.LoadedFrom;
import com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware;
/* loaded from: classes3.dex */
public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    @Override // com.baidu.sumeru.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
    }
}
