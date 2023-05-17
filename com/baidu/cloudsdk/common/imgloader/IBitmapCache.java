package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public interface IBitmapCache {
    void clean();

    void delete(String str);

    boolean exists(String str);

    Bitmap get(String str);

    void put(String str, Bitmap bitmap);
}
