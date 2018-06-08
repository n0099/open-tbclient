package com.baidu.ar.camera;
/* loaded from: classes3.dex */
public interface CameraCallback {
    void onCameraRelease(boolean z);

    void onCameraReopen(boolean z);

    void onCameraSetup(boolean z);

    void onFlashClose(boolean z);

    void onFlashOpen(boolean z);

    void onPreviewCallbackSet(boolean z);

    void onPreviewStart(boolean z);

    void onPreviewStop(boolean z);

    void onSurfaceHolderSet(boolean z);

    void onSurfaceTextureSet(boolean z);
}
