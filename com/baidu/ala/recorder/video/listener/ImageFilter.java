package com.baidu.ala.recorder.video.listener;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
/* loaded from: classes15.dex */
public interface ImageFilter {

    /* loaded from: classes15.dex */
    public interface Output {
        void onImageDone(int i, float[] fArr, long j);
    }

    Camera.PreviewCallback getCameraPreviewCallback();

    SurfaceTexture getCameraTexture();

    void setupImageOutput(Output output);
}
