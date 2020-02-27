package com.baidu.searchbox.picture.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
/* loaded from: classes13.dex */
public interface ImageRegionDecoder {
    Bitmap decodeRegion(Rect rect, int i);

    Point init(Context context, Bitmap bitmap) throws Exception;

    Point init(Context context, Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
