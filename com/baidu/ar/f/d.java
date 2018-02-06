package com.baidu.ar.f;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ar.camera.CameraCallback;
import com.baidu.ar.camera.CameraController;
import com.baidu.ar.camera.CameraParams;
/* loaded from: classes3.dex */
public class d implements CameraCallback {
    SurfaceTexture a;
    private CameraParams b;
    private CameraCallback c;
    private volatile boolean d = false;

    public void a() {
        if (this.d) {
            CameraController.getInstance().stopPreview();
            com.baidu.ar.util.b.a("bdar: Camera stopPreview in CameraTextureHolder");
        }
    }

    public void a(Camera.PreviewCallback previewCallback, boolean z) {
        if (this.d) {
            return;
        }
        if (z) {
            CameraController.getInstance().setPreviewCallbackWithBuffer(previewCallback);
        } else {
            CameraController.getInstance().setPreviewCallback(previewCallback);
        }
        CameraController.getInstance().startPreview();
        com.baidu.ar.util.b.a("bdar: Camera startPreview in CameraTextureHolder");
    }

    public void a(CameraParams cameraParams, CameraCallback cameraCallback) {
        this.b = cameraParams;
        this.c = cameraCallback;
        this.a = new SurfaceTexture(-1);
        CameraController.getInstance().setupCamera(this.b, this);
        com.baidu.ar.util.b.a("bdar: Camera setupCamera in CameraTextureHolder");
    }

    public void b() {
        CameraController.getInstance().openFlash();
    }

    public void c() {
        CameraController.getInstance().closeFlash();
    }

    public void d() {
        this.a = null;
        CameraController.getInstance().releaseCamera();
        com.baidu.ar.util.b.a("bdar: Camera releaseCamera in CameraTextureHolder");
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onCameraRelease(boolean z) {
        this.d = false;
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onCameraSetup(boolean z) {
        com.baidu.ar.util.b.a("bdar: Camera onCameraSetup in CameraTextureHolder result = " + z);
        if (this.a != null) {
            if (z) {
                CameraController.getInstance().setSurfaceTexture(this.a);
            }
            if (this.c != null) {
                this.c.onCameraSetup(z);
            }
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onFlashClose(boolean z) {
        if (this.c != null) {
            this.c.onFlashClose(z);
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onFlashOpen(boolean z) {
        if (this.c != null) {
            this.c.onFlashOpen(z);
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewCallbackSet(boolean z) {
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewStart(boolean z) {
        if (z) {
            this.d = true;
        }
        if (this.c != null) {
            this.c.onPreviewStart(z);
        }
        com.baidu.ar.util.b.a("bdar: Camera onPreviewStart in CameraTextureHolder");
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onPreviewStop(boolean z) {
        if (z) {
            this.d = false;
        }
        if (this.c != null) {
            this.c.onPreviewStop(z);
        }
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onSurfaceHolderSet(boolean z) {
    }

    @Override // com.baidu.ar.camera.CameraCallback
    public void onSurfaceTextureSet(boolean z) {
    }
}
