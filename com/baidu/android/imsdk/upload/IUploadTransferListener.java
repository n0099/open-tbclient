package com.baidu.android.imsdk.upload;
/* loaded from: classes4.dex */
public interface IUploadTransferListener {
    void onFailed(int i2, int i3, String str);

    void onFinished(int i2, String str);

    void onProgress(int i2);
}
