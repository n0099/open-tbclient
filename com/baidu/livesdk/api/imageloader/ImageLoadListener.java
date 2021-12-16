package com.baidu.livesdk.api.imageloader;

import android.graphics.Bitmap;
/* loaded from: classes10.dex */
public interface ImageLoadListener {
    void onLoadingComplete(String str, Bitmap bitmap);

    void onLoadingFail(String str);
}
