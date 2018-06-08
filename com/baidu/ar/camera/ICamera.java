package com.baidu.ar.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
/* loaded from: classes3.dex */
public interface ICamera {
    void closeFlash();

    void openFlash();

    void releaseCamera();

    void reopenCamera(CameraParams cameraParams);

    void setPreviewCallback(Camera.PreviewCallback previewCallback);

    void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setSurfaceTexture(SurfaceTexture surfaceTexture);

    boolean setupCamera(CameraParams cameraParams, CameraCallback cameraCallback);

    void startPreview();

    void stopPreview();
}
