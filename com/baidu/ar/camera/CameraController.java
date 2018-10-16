package com.baidu.ar.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class CameraController implements ICamera, e {
    private static final String CAMERA_THREAD_NAME = "CameraHandlerThread";
    private static volatile CameraController sInstance;
    private CameraCallback mCameraCallback;
    private c mCameraEngine;
    private Handler mCameraHandler;
    private HandlerThread mCameraThread;
    private final Lock mLock = new ReentrantLock(true);
    private static final String TAG = CameraController.class.getSimpleName();
    private static volatile boolean sThreadStarting = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private e a;

        public a(Looper looper, e eVar) {
            super(looper);
            this.a = eVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.handleMessage(message);
        }
    }

    private CameraController() {
    }

    public static CameraController getInstance() {
        if (sInstance == null) {
            synchronized (CameraController.class) {
                if (sInstance == null) {
                    sInstance = new CameraController();
                }
            }
        }
        return sInstance;
    }

    private void handleCloseFlash() {
        boolean f = this.mCameraEngine != null ? this.mCameraEngine.f() : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onFlashClose(f);
        }
    }

    private void handleOpenFlash() {
        boolean e = this.mCameraEngine != null ? this.mCameraEngine.e() : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onFlashOpen(e);
        }
    }

    private void handleQuitThread() {
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onCameraRelease(true);
            this.mCameraCallback = null;
        }
        if (this.mCameraThread != null) {
            this.mCameraThread.getLooper().quit();
        }
        this.mCameraThread = null;
        this.mCameraHandler = null;
        releaseInstance();
    }

    private void handleReleaseCamera() {
        if (this.mCameraEngine != null) {
            this.mCameraEngine.g();
            this.mCameraEngine = null;
        }
    }

    private void handleReopenCamera(CameraParams cameraParams) {
        boolean z = false;
        if (this.mCameraEngine != null && (z = this.mCameraEngine.d())) {
            this.mCameraEngine.g();
            this.mCameraEngine = null;
            this.mCameraEngine = c.a();
            z = this.mCameraEngine.a(cameraParams);
            if (z) {
                z = this.mCameraEngine.b(cameraParams);
            }
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onCameraReopen(z);
        }
    }

    private void handleSetPreviewCallback(Camera.PreviewCallback previewCallback) {
        boolean a2 = this.mCameraEngine != null ? this.mCameraEngine.a(previewCallback) : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewCallbackSet(a2);
        }
    }

    private void handleSetPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        boolean b = this.mCameraEngine != null ? this.mCameraEngine.b(previewCallback) : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewCallbackSet(b);
        }
    }

    private void handleSetSurfaceHolder(SurfaceHolder surfaceHolder) {
        boolean a2 = this.mCameraEngine != null ? this.mCameraEngine.a(surfaceHolder) : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onSurfaceHolderSet(a2);
        }
    }

    private void handleSetSurfaceTexture(SurfaceTexture surfaceTexture) {
        boolean a2 = this.mCameraEngine != null ? this.mCameraEngine.a(surfaceTexture) : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onSurfaceTextureSet(a2);
        }
    }

    private void handleSetupCamera(CameraParams cameraParams) {
        boolean z = false;
        if (this.mCameraEngine != null && (z = this.mCameraEngine.a(cameraParams))) {
            z = this.mCameraEngine.b(cameraParams);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onCameraSetup(z);
        }
    }

    private void handleStartPreview() {
        boolean c = this.mCameraEngine != null ? this.mCameraEngine.c() : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewStart(c);
        }
    }

    private void handleStopPreview() {
        boolean d = this.mCameraEngine != null ? this.mCameraEngine.d() : false;
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewStop(d);
        }
    }

    private void initCameraController() {
        if (isRunning()) {
            this.mCameraHandler.removeMessages(1012);
        } else {
            this.mCameraThread = new HandlerThread(CAMERA_THREAD_NAME);
            this.mCameraThread.start();
            this.mCameraHandler = new a(this.mCameraThread.getLooper(), this);
        }
        this.mCameraEngine = c.a();
    }

    private static boolean isThreadStarting() {
        return sThreadStarting;
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    private static void setThreadStarting(boolean z) {
        sThreadStarting = z;
    }

    @Override // com.baidu.ar.camera.ICamera
    public void closeFlash() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1011));
        }
    }

    @Override // com.baidu.ar.camera.e
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                handleSetupCamera((CameraParams) message.obj);
                return;
            case 1002:
                handleReleaseCamera();
                return;
            case 1003:
                handleReopenCamera((CameraParams) message.obj);
                return;
            case 1004:
                handleSetSurfaceTexture((SurfaceTexture) message.obj);
                return;
            case 1005:
                handleSetSurfaceHolder((SurfaceHolder) message.obj);
                return;
            case 1006:
                handleSetPreviewCallback((Camera.PreviewCallback) message.obj);
                return;
            case 1007:
                handleSetPreviewCallbackWithBuffer((Camera.PreviewCallback) message.obj);
                return;
            case 1008:
                handleStartPreview();
                return;
            case 1009:
                handleStopPreview();
                return;
            case 1010:
                handleOpenFlash();
                return;
            case 1011:
                handleCloseFlash();
                return;
            case 1012:
                if (isThreadStarting()) {
                    return;
                }
                this.mLock.lock();
                try {
                    handleQuitThread();
                    return;
                } finally {
                    this.mLock.unlock();
                }
            default:
                return;
        }
    }

    public boolean hasPermission(Context context) {
        return CameraHelper.checkCameraPermission(context);
    }

    public boolean isRunning() {
        return this.mCameraThread != null && this.mCameraThread.isAlive();
    }

    @Override // com.baidu.ar.camera.ICamera
    public void openFlash() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1010));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void releaseCamera() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1002));
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1012));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void reopenCamera(CameraParams cameraParams) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1003, cameraParams));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1006, previewCallback));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1007, previewCallback));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1005, surfaceHolder));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1004, surfaceTexture));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public boolean setupCamera(CameraParams cameraParams, CameraCallback cameraCallback) {
        setThreadStarting(true);
        this.mLock.lock();
        try {
            initCameraController();
            setThreadStarting(false);
            this.mLock.unlock();
            this.mCameraCallback = cameraCallback;
            if (this.mCameraHandler != null) {
                this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1001, cameraParams));
            }
            return true;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void startPreview() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1008));
        }
    }

    @Override // com.baidu.ar.camera.ICamera
    public void stopPreview() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1009));
        }
    }
}
