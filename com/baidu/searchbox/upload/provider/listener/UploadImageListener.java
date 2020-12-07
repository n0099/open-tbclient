package com.baidu.searchbox.upload.provider.listener;
/* loaded from: classes20.dex */
public interface UploadImageListener {
    void uploadFail();

    void uploadProgress(float f);

    void uploadSuccess(String str, int i, int i2, long j);
}
