package com.baidu.ar.recg;
/* loaded from: classes3.dex */
public interface ImageRecognitionCallback {
    void onFeatureDBInit(boolean z);

    void onRecognizeResult(boolean z, String str);

    void onResourceDownload(boolean z);

    void onResourceRequest(boolean z, int i, String str);
}
