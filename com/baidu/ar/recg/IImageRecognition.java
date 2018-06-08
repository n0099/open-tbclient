package com.baidu.ar.recg;

import android.content.Context;
/* loaded from: classes3.dex */
public interface IImageRecognition {
    void initRecognition(Context context, ImageRecognitionCallback imageRecognitionCallback);

    void recognizeFrame(int i, int i2, byte[] bArr);

    void release();

    void startRecognition();

    void stopRecognition();
}
