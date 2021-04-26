package com.baidu.sapi2.callback;

import android.content.Context;
import android.net.Uri;
/* loaded from: classes2.dex */
public abstract class ImageCropCallback {

    /* loaded from: classes2.dex */
    public static abstract class ImageCropResult {
        public abstract void onImageResult(String str);
    }

    public abstract void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropResult imageCropResult);
}
