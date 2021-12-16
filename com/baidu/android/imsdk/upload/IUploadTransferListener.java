package com.baidu.android.imsdk.upload;
/* loaded from: classes9.dex */
public interface IUploadTransferListener {
    void onFailed(int i2, int i3, String str);

    void onFinished(int i2, String str);

    void onProgress(int i2);
}
