package com.baidu.ar.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class CameraController implements CommonHandlerListener, ICamera {
    private static final String a = CameraController.class.getSimpleName();
    private static volatile boolean g = false;
    private static volatile CameraController h;
    private HandlerThread b;
    private Handler c;
    private CameraEngine d;
    private CameraCallback e;
    private final Lock f = new ReentrantLock(true);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CameraHandler extends Handler {
        public static final int MSG_CLOSE_FLASH = 1010;
        public static final int MSG_OPEN_FLASH = 1009;
        public static final int MSG_RELEASW_CAMERA = 1002;
        public static final int MSG_SETUP_CAMERA = 1001;
        public static final int MSG_SET_PREVIEW_CALLBACK = 1005;
        public static final int MSG_SET_PREVIEW_CALLBACK_WITH_BUFFER = 1006;
        public static final int MSG_SET_SURFACE_HOLDER = 1004;
        public static final int MSG_SET_SURFACE_TEXTURE = 1003;
        public static final int MSG_START_PREVIEW_MSG = 1007;
        public static final int MSG_STOP_PREVIEW_MSG = 1008;
        private CommonHandlerListener a;

        public CameraHandler(Looper looper, CommonHandlerListener commonHandlerListener) {
            super(looper);
            this.a = commonHandlerListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.handleMessage(message);
        }
    }

    private CameraController() {
    }

    private void a() {
        if (!isRunning()) {
            this.b = new HandlerThread("CameraHandlerThread");
            this.b.start();
            this.c = new CameraHandler(this.b.getLooper(), this);
        }
        this.d = CameraEngine.getInstance();
    }

    private void a(SurfaceTexture surfaceTexture) {
        boolean previewTexture = this.d != null ? this.d.setPreviewTexture(surfaceTexture) : false;
        if (this.e != null) {
            this.e.onSurfaceTextureSet(previewTexture);
        }
    }

    private void a(Camera.PreviewCallback previewCallback) {
        boolean previewCallback2 = this.d != null ? this.d.setPreviewCallback(previewCallback) : false;
        if (this.e != null) {
            this.e.onPreviewCallbackSet(previewCallback2);
        }
    }

    private void a(SurfaceHolder surfaceHolder) {
        boolean previewHolder = this.d != null ? this.d.setPreviewHolder(surfaceHolder) : false;
        if (this.e != null) {
            this.e.onSurfaceHolderSet(previewHolder);
        }
    }

    private void a(CameraParams cameraParams) {
        boolean openCamera = this.d.openCamera(cameraParams);
        if (openCamera) {
            openCamera = this.d.setParameters(cameraParams);
        } else {
            this.d.release();
        }
        if (this.e != null) {
            this.e.onCameraSetup(openCamera);
        }
        g = false;
    }

    private void b() {
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
        if (this.e != null) {
            this.e.onCameraRelease(true);
            this.e = null;
        }
        if (this.b != null) {
            this.b.getLooper().quit();
        }
        this.b = null;
        this.c = null;
        if (g) {
            return;
        }
        Log.i(a, "handleReleaseCamera mStarting = " + g);
        h = null;
    }

    private void b(Camera.PreviewCallback previewCallback) {
        boolean handleSetPreviewCallbackWithBuffer = this.d != null ? this.d.handleSetPreviewCallbackWithBuffer(previewCallback) : false;
        if (this.e != null) {
            this.e.onPreviewCallbackSet(handleSetPreviewCallbackWithBuffer);
        }
    }

    private void c() {
        boolean startPreview = this.d != null ? this.d.startPreview() : false;
        if (this.e != null) {
            this.e.onPreviewStart(startPreview);
        }
    }

    private void d() {
        boolean stopPreview = this.d != null ? this.d.stopPreview() : false;
        if (this.e != null) {
            this.e.onPreviewStop(stopPreview);
        }
    }

    private void e() {
        boolean openFlash = this.d != null ? this.d.openFlash() : false;
        if (this.e != null) {
            this.e.onFlashOpen(openFlash);
        }
    }

    private void f() {
        boolean closeFlash = this.d != null ? this.d.closeFlash() : false;
        if (this.e != null) {
            this.e.onFlashClose(closeFlash);
        }
    }

    public static CameraController getInstance() {
        if (h == null) {
            synchronized (CameraController.class) {
                if (h == null) {
                    h = new CameraController();
                }
            }
        }
        return h;
    }

    @Override // com.baidu.ar.camera.ICamera
    public void closeFlash() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1010));
        }
    }

    @Override // com.baidu.ar.camera.CommonHandlerListener
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                a((CameraParams) message.obj);
                return;
            case 1002:
                if (g) {
                    return;
                }
                this.f.lock();
                try {
                    b();
                    return;
                } finally {
                    this.f.unlock();
                }
            case 1003:
                a((SurfaceTexture) message.obj);
                return;
            case 1004:
                a((SurfaceHolder) message.obj);
                return;
            case 1005:
                a((Camera.PreviewCallback) message.obj);
                return;
            case 1006:
                b((Camera.PreviewCallback) message.obj);
                return;
            case 1007:
                c();
                return;
            case 1008:
                d();
                return;
            case 1009:
                e();
                return;
            case 1010:
                f();
                return;
            default:
                return;
        }
    }

    public boolean hasPermission(Context context) {
        return CameraHelper.checkCameraPermission(context);
    }

    public boolean isRunning() {
        return this.b != null && this.b.isAlive();
    }

    @Override // com.baidu.ar.camera.ICamera
    public void openFlash() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1009));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void releaseCamera() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1002));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1005, previewCallback));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1006, previewCallback));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1004, surfaceHolder));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1003, surfaceTexture));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public boolean setupCamera(CameraParams cameraParams, CameraCallback cameraCallback) {
        g = true;
        this.f.lock();
        try {
            a();
            this.f.unlock();
            this.e = cameraCallback;
            if (this.c != null) {
                this.c.sendMessage(this.c.obtainMessage(1001, cameraParams));
            }
            return true;
        } catch (Throwable th) {
            this.f.unlock();
            throw th;
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void startPreview() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1007));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void stopPreview() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1008));
        }
    }
}
