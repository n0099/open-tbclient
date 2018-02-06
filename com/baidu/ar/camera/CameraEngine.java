package com.baidu.ar.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
/* loaded from: classes3.dex */
class CameraEngine {
    private static final String a = CameraEngine.class.getSimpleName();
    private static volatile CameraEngine c;
    private Camera b = null;

    private CameraEngine() {
    }

    public static CameraEngine getInstance() {
        if (c == null) {
            synchronized (CameraEngine.class) {
                if (c == null) {
                    c = new CameraEngine();
                }
            }
        }
        return c;
    }

    public boolean closeFlash() {
        if (CameraHelper.isBackCameraCurrent()) {
            Camera.Parameters parameters = this.b.getParameters();
            if (parameters.getFlashMode() != "off") {
                parameters.setFlashMode("off");
                this.b.setParameters(parameters);
                return true;
            }
        }
        return false;
    }

    public boolean handleSetPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.b != null) {
            this.b.setPreviewCallbackWithBuffer(previewCallback);
            Camera.Size previewSize = this.b.getParameters().getPreviewSize();
            int bitsPerPixel = ((previewSize.height * previewSize.width) * ImageFormat.getBitsPerPixel(17)) / 8;
            for (int i = 0; i < 3; i++) {
                this.b.addCallbackBuffer(new byte[bitsPerPixel]);
            }
            return true;
        }
        return false;
    }

    public boolean openCamera(CameraParams cameraParams) {
        try {
            this.b = Camera.open(cameraParams.getCameraId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean openFlash() {
        if (CameraHelper.isBackCameraCurrent()) {
            Camera.Parameters parameters = this.b.getParameters();
            if (parameters.getFlashMode() != "torch") {
                parameters.setFlashMode("torch");
                this.b.setParameters(parameters);
                return true;
            }
        }
        return false;
    }

    public void release() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
        c = null;
    }

    public boolean setParameters(CameraParams cameraParams) {
        try {
            Camera.Parameters parameters = this.b.getParameters();
            if (cameraParams.isAutoCorrectParams()) {
                CameraHelper.correctCameraParas(cameraParams, parameters);
            }
            parameters.setPreviewSize(cameraParams.getPreviewWidth(), cameraParams.getPreviewHeight());
            parameters.setPreviewFrameRate(cameraParams.getFrameRate());
            parameters.setPictureSize(cameraParams.getPictureWidth(), cameraParams.getPictureHeight());
            if (cameraParams.isAutoFocus()) {
                CameraHelper.setAutoFocus(parameters);
            }
            this.b.setDisplayOrientation(cameraParams.getRotateDegree());
            this.b.setParameters(parameters);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.b != null) {
            this.b.setPreviewCallback(previewCallback);
            return true;
        }
        return false;
    }

    public boolean setPreviewHolder(SurfaceHolder surfaceHolder) {
        try {
            this.b.setPreviewDisplay(surfaceHolder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setPreviewTexture(SurfaceTexture surfaceTexture) {
        try {
            this.b.setPreviewTexture(surfaceTexture);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean startPreview() {
        Log.d(a, "startPreview !!!");
        try {
            this.b.startPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopPreview() {
        Log.d(a, "stopPreview");
        try {
            this.b.stopPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
