package com.baidu.android.imsdk.upload;
/* loaded from: classes2.dex */
public interface IUploadTransferListener {
    void onFailed(int i, int i2, String str);

    void onFinished(int i, String str);

    void onProgress(int i);
}
