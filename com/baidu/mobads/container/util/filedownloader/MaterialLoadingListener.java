package com.baidu.mobads.container.util.filedownloader;

import android.graphics.Bitmap;
import android.view.View;
/* loaded from: classes2.dex */
public interface MaterialLoadingListener {
    void onLoadingComplete(String str, View view, Bitmap bitmap);

    void onLoadingFailed(String str, View view, MaterialLoadErrorCode materialLoadErrorCode);

    void onLoadingStarted(String str, View view);
}
