package com.baidu.ar.camera.easy;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ar.camera.CameraParams;
/* loaded from: classes3.dex */
public interface IEasyCamera {
    void closeFlash();

    void openFlash();

    void startCamera(CameraParams cameraParams, SurfaceTexture surfaceTexture, Camera.PreviewCallback previewCallback, EasyCameraCallback easyCameraCallback);

    void stopCamera();

    void switchCamera();
}
