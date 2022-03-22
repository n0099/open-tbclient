package com.baidu.android.imsdk.upload;
/* loaded from: classes3.dex */
public interface IFileUploadListener {
    void onFailed(int i, String str);

    void onFinished(int i);

    void onProgress(int i);
}
