package com.baidu.ar.camera;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ar.PreviewCallback;
import com.baidu.ar.camera.easy.EasyCamera;
import com.baidu.ar.camera.easy.EasyCameraCallback;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.util.ARLog;
/* loaded from: classes3.dex */
public class ARCameraManager implements Camera.PreviewCallback, EasyCameraCallback {
    private static final String a = ARCameraManager.class.getSimpleName();
    private CameraParams b;
    private SurfaceTexture c;
    private PreviewCallback d;
    private b e;
    private a f;
    private a g;
    private a h;
    private ARSwitchCameraCallback i;
    private byte[] j = null;
    private Camera.Size k;
    private Bitmap l;
    private boolean m;

    private Bitmap a() {
        if (this.j == null || this.k == null) {
            return null;
        }
        try {
            return com.baidu.ar.utils.a.a(this.k.width, this.k.height, this.j);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            ARLog.e("save preview data OOM error");
            return null;
        }
    }

    public void closeFlash(a aVar) {
        this.h = aVar;
        EasyCamera.getInstance().closeFlash();
    }

    public Bitmap getLastPreview() {
        return this.l;
    }

    public boolean isFrontCameraPreviewSupported() {
        return CameraHelper.isCameraSupported(1);
    }

    @Override // com.baidu.ar.camera.easy.EasyCameraCallback
    public void onCameraStart(boolean z) {
        if (this.e == null || this.b == null) {
            return;
        }
        this.e.a(z, this.c, this.b.getPreviewWidth(), this.b.getPreviewHeight());
    }

    @Override // com.baidu.ar.camera.easy.EasyCameraCallback
    public void onCameraStop(boolean z) {
        if (this.f != null) {
            if (this.m) {
                this.l = a();
            }
            this.f.a(z);
        }
    }

    @Override // com.baidu.ar.camera.easy.EasyCameraCallback
    public void onCameraSwitch(boolean z) {
        if (this.i == null || this.b == null) {
            return;
        }
        this.i.onCameraSwitch(z, this.b.getCameraId() == 0);
    }

    @Override // com.baidu.ar.camera.easy.EasyCameraCallback
    public void onFlashClose(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }

    @Override // com.baidu.ar.camera.easy.EasyCameraCallback
    public void onFlashOpen(boolean z) {
        if (this.g != null) {
            this.g.a(z);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.d != null) {
            this.d.onPreviewFrame(bArr, this.b.getPreviewWidth(), this.b.getPreviewHeight());
        }
        StatisticHelper.getInstance().statisticFrameRate(StatisticConstants.CAMERA_PREVIEW_FRAME_RATE);
        this.j = bArr;
        try {
            if (this.k == null) {
                this.k = camera.getParameters().getPreviewSize();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFlash(a aVar) {
        this.g = aVar;
        EasyCamera.getInstance().openFlash();
    }

    public void setPreviewCallback(PreviewCallback previewCallback) {
        this.d = previewCallback;
    }

    public void startCamera(SurfaceTexture surfaceTexture, b bVar) {
        this.e = bVar;
        this.c = surfaceTexture;
        if (this.b == null) {
            this.b = new CameraParams();
        }
        EasyCamera.getInstance().startCamera(this.b, this.c, this, this);
    }

    public void stopCamera(a aVar, boolean z) {
        this.f = aVar;
        this.m = z;
        EasyCamera.getInstance().stopCamera();
    }

    public void switchCamera(ARSwitchCameraCallback aRSwitchCameraCallback) {
        this.i = aRSwitchCameraCallback;
        EasyCamera.getInstance().switchCamera();
    }
}
