package com.baidu.searchbox.ng.ai.apps.ar.camera.easy;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback;
import com.baidu.searchbox.ng.ai.apps.ar.camera.CameraController;
import com.baidu.searchbox.ng.ai.apps.ar.camera.CameraParams;
/* loaded from: classes2.dex */
public class EasyCamera implements Camera.PreviewCallback, CameraCallback, IEasyCamera {
    private static final int SLEEP_COUNT_MAX = 10;
    private static final int SLEEP_TIME_MS = 50;
    private static volatile EasyCamera sInstance;
    private CameraController mCameraController;
    private CameraParams mCameraParams;
    private EasyCameraCallback mEasyCameraCallback;
    private Camera.PreviewCallback mPreviewCallback;
    private boolean mReopening = false;
    private SurfaceTexture mSurfaceTexture;
    private static final String TAG = EasyCamera.class.getSimpleName();
    private static volatile boolean sCameraStarting = false;
    private static volatile boolean sCameraClosing = false;

    public static EasyCamera getInstance() {
        if (sInstance == null) {
            synchronized (EasyCamera.class) {
                if (sInstance == null) {
                    sInstance = new EasyCamera();
                }
            }
        }
        return sInstance;
    }

    private EasyCamera() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.IEasyCamera
    public void startCamera(CameraParams cameraParams, SurfaceTexture surfaceTexture, Camera.PreviewCallback previewCallback, EasyCameraCallback easyCameraCallback) {
        Log.d(TAG, "startCamera !!!");
        if (cameraParams != null && surfaceTexture != null) {
            sCameraStarting = true;
            if (!waitWhenReleasing()) {
                this.mCameraParams = cameraParams;
                this.mSurfaceTexture = surfaceTexture;
                this.mPreviewCallback = previewCallback;
                this.mEasyCameraCallback = easyCameraCallback;
                if (this.mCameraController == null) {
                    this.mCameraController = CameraController.getInstance();
                }
                this.mCameraController.setupCamera(cameraParams, this);
            }
        }
    }

    private boolean waitWhenReleasing() {
        int i = 0;
        while (sCameraClosing) {
            Log.d(TAG, "startCamera tryCount = " + i);
            try {
                Thread.sleep(50L);
                i++;
                if (i >= 10) {
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.IEasyCamera
    public void switchCamera() {
        Log.d(TAG, "switchCamera !!!");
        if (this.mCameraParams != null && this.mCameraController != null) {
            this.mReopening = true;
            if (this.mCameraParams.getCameraId() == 0) {
                this.mCameraParams.setCameraId(1);
            } else {
                this.mCameraParams.setCameraId(0);
            }
            this.mCameraController.reopenCamera(this.mCameraParams);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.IEasyCamera
    public void openFlash() {
        if (this.mCameraController != null) {
            this.mCameraController.openFlash();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.IEasyCamera
    public void closeFlash() {
        if (this.mCameraController != null) {
            this.mCameraController.closeFlash();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.easy.IEasyCamera
    public void stopCamera() {
        Log.d(TAG, "stopCamera !!!");
        if (this.mCameraController != null) {
            sCameraClosing = true;
            this.mCameraController.stopPreview();
        }
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onCameraSetup(boolean z) {
        Log.d(TAG, "onCameraSetup result = " + z);
        if (z) {
            if (this.mCameraController != null) {
                this.mCameraController.setSurfaceTexture(this.mSurfaceTexture);
            }
        } else if (this.mEasyCameraCallback != null) {
            this.mEasyCameraCallback.onCameraStart(false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onCameraRelease(boolean z) {
        Log.d(TAG, "onCameraRelease result = " + z);
        if (this.mEasyCameraCallback != null) {
            this.mEasyCameraCallback.onCameraStop(z);
        }
        this.mCameraParams = null;
        this.mSurfaceTexture = null;
        this.mPreviewCallback = null;
        this.mEasyCameraCallback = null;
        this.mCameraController = null;
        sCameraClosing = false;
        if (!sCameraStarting) {
            releaseInstance();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onCameraReopen(boolean z) {
        Log.d(TAG, "onCameraReopen result = " + z);
        if (z) {
            if (this.mCameraController != null) {
                this.mCameraController.setSurfaceTexture(this.mSurfaceTexture);
                return;
            }
            return;
        }
        if (this.mCameraParams != null) {
            if (this.mCameraParams.getCameraId() == 0) {
                this.mCameraParams.setCameraId(1);
            } else {
                this.mCameraParams.setCameraId(0);
            }
        }
        if (this.mEasyCameraCallback != null) {
            this.mEasyCameraCallback.onCameraSwitch(false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onSurfaceTextureSet(boolean z) {
        Log.d(TAG, "onSurfaceTextureSet result = " + z);
        if (z) {
            if (this.mCameraController != null) {
                if (this.mPreviewCallback != null) {
                    this.mCameraController.setPreviewCallbackWithBuffer(this);
                }
                this.mCameraController.startPreview();
            }
        } else if (this.mEasyCameraCallback != null) {
            if (this.mReopening) {
                this.mEasyCameraCallback.onCameraSwitch(false);
            } else {
                this.mEasyCameraCallback.onCameraStart(false);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onSurfaceHolderSet(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onPreviewCallbackSet(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onPreviewStart(boolean z) {
        Log.d(TAG, "onPreviewStart result = " + z);
        if (this.mEasyCameraCallback != null) {
            if (this.mReopening) {
                this.mEasyCameraCallback.onCameraSwitch(z);
                this.mReopening = false;
            } else {
                this.mEasyCameraCallback.onCameraStart(z);
            }
        }
        sCameraStarting = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onPreviewStop(boolean z) {
        Log.d(TAG, "onPreviewStop result = " + z);
        if (this.mCameraController != null) {
            this.mCameraController.releaseCamera();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onFlashOpen(boolean z) {
        if (this.mEasyCameraCallback != null) {
            this.mEasyCameraCallback.onFlashOpen(z);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CameraCallback
    public void onFlashClose(boolean z) {
        if (this.mEasyCameraCallback != null) {
            this.mEasyCameraCallback.onFlashClose(z);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        camera.addCallbackBuffer(bArr);
        if (this.mPreviewCallback != null) {
            this.mPreviewCallback.onPreviewFrame(bArr, camera);
        }
    }
}
