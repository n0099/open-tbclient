package com.baidu.ar.task;
/* loaded from: classes3.dex */
public interface OnFileUploadListener {
    void onFailure(int i, String str);

    void onProgressUpdate(int i);

    void onStartUpload();

    void onSuccess(int i, String str);
}
