package com.baidu.searchbox.upload.provider.listener;
/* loaded from: classes20.dex */
public interface UploadVideoListener {
    void uploadFail(String str);

    void uploadProgress(int i);

    void uploadSuccess(String str, String str2, String str3);
}
