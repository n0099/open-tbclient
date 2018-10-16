package com.baidu.searchbox.ng.ai.apps.ar.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
/* loaded from: classes2.dex */
class CameraEngine {
    private static final int RETRY_OPEN_CAMERA_DELAY_MS = 50;
    private static final int RETRY_OPEN_CAMERA_MAX = 3;
    private static final String TAG = CameraEngine.class.getSimpleName();
    private static volatile CameraEngine sInstance;
    private Camera mCamera = null;

    public static CameraEngine getInstance() {
        if (sInstance == null) {
            synchronized (CameraEngine.class) {
                if (sInstance == null) {
                    sInstance = new CameraEngine();
                }
            }
        }
        return sInstance;
    }

    public static void releaseInstance() {
        sInstance = null;
    }

    private CameraEngine() {
    }

    public boolean openCamera(CameraParams cameraParams) {
        for (int i = 0; i < 3; i++) {
            try {
                this.mCamera = Camera.open(cameraParams.getCameraId());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.mCamera != null) {
                        this.mCamera.release();
                    }
                    Thread.sleep(50L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean setParameters(CameraParams cameraParams) {
        try {
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (cameraParams.isAutoCorrectParams()) {
                CameraHelper.correctCameraParams(cameraParams, parameters);
            }
            parameters.setPreviewSize(cameraParams.getPreviewWidth(), cameraParams.getPreviewHeight());
            parameters.setPreviewFrameRate(cameraParams.getFrameRate());
            parameters.setPictureSize(cameraParams.getPictureWidth(), cameraParams.getPictureHeight());
            if (cameraParams.isAutoFocus()) {
                CameraHelper.setAutoFocus(parameters);
            }
            this.mCamera.setDisplayOrientation(cameraParams.getRotateDegree());
            this.mCamera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPreviewTexture(SurfaceTexture surfaceTexture) {
        try {
            this.mCamera.setPreviewTexture(surfaceTexture);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPreviewHolder(SurfaceHolder surfaceHolder) {
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(previewCallback);
            return true;
        }
        return false;
    }

    public boolean setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallbackWithBuffer(previewCallback);
            Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
            int bitsPerPixel = ((previewSize.height * previewSize.width) * ImageFormat.getBitsPerPixel(17)) / 8;
            for (int i = 0; i < 3; i++) {
                this.mCamera.addCallbackBuffer(new byte[bitsPerPixel]);
            }
            return true;
        }
        return false;
    }

    public boolean startPreview() {
        Log.d(TAG, "startPreview !!!");
        try {
            this.mCamera.startPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopPreview() {
        Log.d(TAG, "stopPreview");
        try {
            this.mCamera.stopPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean openFlash() {
        try {
            if (CameraHelper.isBackCameraCurrent()) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (!"torch".equals(parameters.getFlashMode())) {
                    parameters.setFlashMode("torch");
                    this.mCamera.setParameters(parameters);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean closeFlash() {
        try {
            if (CameraHelper.isBackCameraCurrent()) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (!ARCameraAttr.FlashType.FLASH_OFF.equals(parameters.getFlashMode())) {
                    parameters.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                    this.mCamera.setParameters(parameters);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void release() {
        if (this.mCamera != null) {
            this.mCamera.release();
            this.mCamera = null;
        }
        releaseInstance();
    }
}
