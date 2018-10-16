package com.baidu.searchbox.ng.ai.apps.ar.camera.easy;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.searchbox.ng.ai.apps.ar.camera.CameraParams;
/* loaded from: classes2.dex */
public interface IEasyCamera {
    void closeFlash();

    void openFlash();

    void startCamera(CameraParams cameraParams, SurfaceTexture surfaceTexture, Camera.PreviewCallback previewCallback, EasyCameraCallback easyCameraCallback);

    void stopCamera();

    void switchCamera();
}
