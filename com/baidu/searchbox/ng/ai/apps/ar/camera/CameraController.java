package com.baidu.searchbox.ng.ai.apps.ar.camera;

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
/* loaded from: classes2.dex */
public class CameraController implements CommonHandlerListener, ICamera {
    private static final String CAMERA_THREAD_NAME = "CameraHandlerThread";
    private static volatile CameraController sInstance;
    private CameraCallback mCameraCallback;
    private CameraEngine mCameraEngine;
    private Handler mCameraHandler;
    private HandlerThread mCameraThread;
    private final Lock mLock = new ReentrantLock(true);
    private static final String TAG = CameraController.class.getSimpleName();
    private static volatile boolean sThreadStarting = false;

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

    private static void releaseInstance() {
        sInstance = null;
    }

    private static void setThreadStarting(boolean z) {
        sThreadStarting = z;
    }

    private static boolean isThreadStarting() {
        return sThreadStarting;
    }

    private CameraController() {
    }

    private void initCameraController() {
        if (!isRunning()) {
            this.mCameraThread = new HandlerThread(CAMERA_THREAD_NAME);
            this.mCameraThread.start();
            this.mCameraHandler = new CameraHandler(this.mCameraThread.getLooper(), this);
        } else {
            this.mCameraHandler.removeMessages(1012);
        }
        this.mCameraEngine = CameraEngine.getInstance();
    }

    public boolean isRunning() {
        return this.mCameraThread != null && this.mCameraThread.isAlive();
    }

    public boolean hasPermission(Context context) {
        return CameraHelper.checkCameraPermission(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
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

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void releaseCamera() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1002));
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1012));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void reopenCamera(CameraParams cameraParams) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1003, cameraParams));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1004, surfaceTexture));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1005, surfaceHolder));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1006, previewCallback));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1007, previewCallback));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void startPreview() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1008));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void stopPreview() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1009));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void openFlash() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1010));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.ICamera
    public void closeFlash() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendMessage(this.mCameraHandler.obtainMessage(1011));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.CommonHandlerListener
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
                if (!isThreadStarting()) {
                    this.mLock.lock();
                    try {
                        handleQuitThread();
                        return;
                    } finally {
                        this.mLock.unlock();
                    }
                }
                return;
            default:
                return;
        }
    }

    private void handleSetupCamera(CameraParams cameraParams) {
        boolean z = false;
        if (this.mCameraEngine != null && (z = this.mCameraEngine.openCamera(cameraParams))) {
            z = this.mCameraEngine.setParameters(cameraParams);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onCameraSetup(z);
        }
    }

    private void handleReleaseCamera() {
        if (this.mCameraEngine != null) {
            this.mCameraEngine.release();
            this.mCameraEngine = null;
        }
    }

    private void handleReopenCamera(CameraParams cameraParams) {
        boolean z = false;
        if (this.mCameraEngine != null && (z = this.mCameraEngine.stopPreview())) {
            this.mCameraEngine.release();
            this.mCameraEngine = null;
            this.mCameraEngine = CameraEngine.getInstance();
            z = this.mCameraEngine.openCamera(cameraParams);
            if (z) {
                z = this.mCameraEngine.setParameters(cameraParams);
            }
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onCameraReopen(z);
        }
    }

    private void handleSetSurfaceTexture(SurfaceTexture surfaceTexture) {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.setPreviewTexture(surfaceTexture);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onSurfaceTextureSet(z);
        }
    }

    private void handleSetSurfaceHolder(SurfaceHolder surfaceHolder) {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.setPreviewHolder(surfaceHolder);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onSurfaceHolderSet(z);
        }
    }

    private void handleSetPreviewCallback(Camera.PreviewCallback previewCallback) {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.setPreviewCallback(previewCallback);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewCallbackSet(z);
        }
    }

    private void handleSetPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.setPreviewCallbackWithBuffer(previewCallback);
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewCallbackSet(z);
        }
    }

    private void handleStartPreview() {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.startPreview();
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewStart(z);
        }
    }

    private void handleStopPreview() {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.stopPreview();
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onPreviewStop(z);
        }
    }

    private void handleOpenFlash() {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.openFlash();
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onFlashOpen(z);
        }
    }

    private void handleCloseFlash() {
        boolean z = false;
        if (this.mCameraEngine != null) {
            z = this.mCameraEngine.closeFlash();
        }
        if (this.mCameraCallback != null) {
            this.mCameraCallback.onFlashClose(z);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CameraHandler extends Handler {
        public static final int MSG_CLOSE_FLASH = 1011;
        public static final int MSG_OPEN_FLASH = 1010;
        public static final int MSG_QUIT_THREAD = 1012;
        public static final int MSG_RELEASW_CAMERA = 1002;
        public static final int MSG_REOPEN_CAMERA = 1003;
        public static final int MSG_SETUP_CAMERA = 1001;
        public static final int MSG_SET_PREVIEW_CALLBACK = 1006;
        public static final int MSG_SET_PREVIEW_CALLBACK_WITH_BUFFER = 1007;
        public static final int MSG_SET_SURFACE_HOLDER = 1005;
        public static final int MSG_SET_SURFACE_TEXTURE = 1004;
        public static final int MSG_START_PREVIEW_MSG = 1008;
        public static final int MSG_STOP_PREVIEW_MSG = 1009;
        private CommonHandlerListener listener;

        public CameraHandler(Looper looper, CommonHandlerListener commonHandlerListener) {
            super(looper);
            this.listener = commonHandlerListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.listener.handleMessage(message);
        }
    }
}
