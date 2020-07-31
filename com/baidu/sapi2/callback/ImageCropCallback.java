package com.baidu.sapi2.callback;

import android.content.Context;
import android.net.Uri;
/* loaded from: classes19.dex */
public abstract class ImageCropCallback {

    /* loaded from: classes19.dex */
    public static abstract class ImageCropResult {
        public abstract void onImageResult(String str);
    }

    public abstract void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropResult imageCropResult);
}
