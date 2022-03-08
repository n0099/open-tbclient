package com.baidu.livesdk.api.imageloader;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public interface ImageLoadListener {
    void onLoadingComplete(String str, Bitmap bitmap);

    void onLoadingFail(String str);
}
