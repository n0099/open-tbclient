package com.baidu.ar.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
/* loaded from: classes3.dex */
class c {
    private static final String a = c.class.getSimpleName();
    private static volatile c c;
    private Camera b = null;

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public static void b() {
        c = null;
    }

    public boolean a(SurfaceTexture surfaceTexture) {
        try {
            this.b.setPreviewTexture(surfaceTexture);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(Camera.PreviewCallback previewCallback) {
        if (this.b != null) {
            this.b.setPreviewCallback(previewCallback);
            return true;
        }
        return false;
    }

    public boolean a(SurfaceHolder surfaceHolder) {
        try {
            this.b.setPreviewDisplay(surfaceHolder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(CameraParams cameraParams) {
        for (int i = 0; i < 3; i++) {
            try {
                this.b = Camera.open(cameraParams.getCameraId());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.b != null) {
                        this.b.release();
                    }
                    Thread.sleep(50L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean b(Camera.PreviewCallback previewCallback) {
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

    public boolean b(CameraParams cameraParams) {
        try {
            Camera.Parameters parameters = this.b.getParameters();
            if (cameraParams.isAutoCorrectParams()) {
                CameraHelper.correctCameraParams(cameraParams, parameters);
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

    public boolean c() {
        Log.d(a, "startPreview !!!");
        try {
            this.b.startPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean d() {
        Log.d(a, "stopPreview");
        try {
            this.b.stopPreview();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean e() {
        try {
            if (CameraHelper.isBackCameraCurrent()) {
                Camera.Parameters parameters = this.b.getParameters();
                if (!"torch".equals(parameters.getFlashMode())) {
                    parameters.setFlashMode("torch");
                    this.b.setParameters(parameters);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean f() {
        try {
            if (CameraHelper.isBackCameraCurrent()) {
                Camera.Parameters parameters = this.b.getParameters();
                if (!ARCameraAttr.FlashType.FLASH_OFF.equals(parameters.getFlashMode())) {
                    parameters.setFlashMode(ARCameraAttr.FlashType.FLASH_OFF);
                    this.b.setParameters(parameters);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void g() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
        b();
    }
}
