package com.baidu.android.imsdk.upload;
/* loaded from: classes6.dex */
public interface IFileUploadListener {
    void onFailed(int i, String str);

    void onFinished(int i);

    void onProgress(int i);
}
