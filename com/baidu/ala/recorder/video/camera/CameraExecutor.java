package com.baidu.ala.recorder.video.camera;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class CameraExecutor {
    private static volatile CameraExecutor mInstance = null;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private Handler mMainHandle = new Handler();

    private CameraExecutor() {
        this.mHandlerThread = null;
        this.mHandler = null;
        this.mHandlerThread = new HandlerThread("rc_exec_camera_thread");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
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
            this.mHandler.post(runnable);
        }
    }

    public void postMainRunable(Runnable runnable) {
        if (runnable != null) {
            this.mMainHandle.post(runnable);
        }
    }
}
