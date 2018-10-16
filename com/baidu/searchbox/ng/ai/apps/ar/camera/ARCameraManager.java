package com.baidu.searchbox.ng.ai.apps.ar.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCamera;
import com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback;
/* loaded from: classes2.dex */
public class ARCameraManager implements Camera.PreviewCallback, EasyCameraCallback {
    private static final String TAG = ARCameraManager.class.getSimpleName();
    private CameraParams mCameraParams;
    private ARCameraCallback mCloseFlashCallback;
    private ARCameraCallback mOpenFlashCallback;
    private byte[] mPreBuffer = null;
    private PreviewCallback mPreviewCallback;
    private Camera.Size mPreviewSize;
    private SurfaceTexture mSourceTexture;
    private ARStartCameraCallback mStartCameraCallback;
    private ARCameraCallback mStopCameraCallback;
    private ARSwitchCameraCallback mSwitchCameraCallback;

    public void startCamera(SurfaceTexture surfaceTexture, ARStartCameraCallback aRStartCameraCallback) {
        this.mStartCameraCallback = aRStartCameraCallback;
        this.mSourceTexture = surfaceTexture;
        if (this.mCameraParams == null) {
            this.mCameraParams = new CameraParams();
        }
        EasyCamera.getInstance().startCamera(this.mCameraParams, this.mSourceTexture, this, this);
    }

    public void stopCamera(ARCameraCallback aRCameraCallback, boolean z) {
        this.mStopCameraCallback = aRCameraCallback;
        EasyCamera.getInstance().stopCamera();
    }

    public void openFlash(ARCameraCallback aRCameraCallback) {
        this.mOpenFlashCallback = aRCameraCallback;
        EasyCamera.getInstance().openFlash();
    }

    public void closeFlash(ARCameraCallback aRCameraCallback) {
        this.mCloseFlashCallback = aRCameraCallback;
        EasyCamera.getInstance().closeFlash();
    }

    public void switchCamera(ARSwitchCameraCallback aRSwitchCameraCallback) {
        this.mSwitchCameraCallback = aRSwitchCameraCallback;
        EasyCamera.getInstance().switchCamera();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback
    public void onCameraStart(boolean z) {
        if (this.mStartCameraCallback != null && this.mCameraParams != null) {
            this.mStartCameraCallback.onCameraStart(z, this.mSourceTexture, this.mCameraParams.getPreviewWidth(), this.mCameraParams.getPreviewHeight());
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback
    public void onCameraSwitch(boolean z) {
        if (this.mSwitchCameraCallback != null && this.mCameraParams != null) {
            this.mSwitchCameraCallback.onCameraSwitch(z, this.mCameraParams.getCameraId() == 0);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback
    public void onFlashOpen(boolean z) {
        if (this.mOpenFlashCallback != null) {
            this.mOpenFlashCallback.onResult(z);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback
    public void onFlashClose(boolean z) {
        if (this.mCloseFlashCallback != null) {
            this.mCloseFlashCallback.onResult(z);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.EasyCameraCallback
    public void onCameraStop(boolean z) {
        if (this.mStopCameraCallback != null) {
            this.mStopCameraCallback.onResult(z);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mPreviewCallback != null) {
            this.mPreviewCallback.onPreviewFrame(bArr, this.mCameraParams.getPreviewWidth(), this.mCameraParams.getPreviewHeight());
        }
        this.mPreBuffer = bArr;
        try {
            if (this.mPreviewSize == null) {
                this.mPreviewSize = camera.getParameters().getPreviewSize();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreviewCallback(PreviewCallback previewCallback) {
        this.mPreviewCallback = previewCallback;
    }

    public boolean isFrontCameraPreviewSupported() {
        return CameraHelper.isCameraSupported(1);
    }
}
