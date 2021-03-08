package com.baidu.ala.recorder.video.camera;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class CameraExecutor {
    private static volatile CameraExecutor mInstance = null;
    private Handler mCameraHandler;
    private HandlerThread mCameraThread;

    private CameraExecutor() {
        this.mCameraThread = null;
        this.mCameraHandler = null;
        this.mCameraThread = new HandlerThread("rc_exec_camera_thread");
        this.mCameraThread.start();
        this.mCameraHandler = new Handler(this.mCameraThread.getLooper());
    }

    public static CameraExecutor getInst() {
        if (mInstance != null) {
            return mInstance;
        }
        synchronized (CameraExecutor.class) {
            if (mInstance == null) {
                mInstance = new CameraExecutor();
            }
        }
        return mInstance;
    }

    public void posRunnable(Runnable runnable) {
        if (runnable != null) {
            this.mCameraHandler.post(runnable);
        }
    }
}
