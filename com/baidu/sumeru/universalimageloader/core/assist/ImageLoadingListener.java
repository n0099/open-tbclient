package com.baidu.sumeru.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;
/* loaded from: classes12.dex */
public interface ImageLoadingListener {
    void onLoadingCancelled(String str, View view);

    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingFailed(String str, View view, FailReason failReason);

    void onLoadingStarted(String str, View view);
}
