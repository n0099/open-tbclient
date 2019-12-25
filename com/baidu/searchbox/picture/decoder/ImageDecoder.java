package com.baidu.searchbox.picture.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
/* loaded from: classes11.dex */
public interface ImageDecoder {
    Bitmap decode(Context context, Uri uri) throws Exception;
}
