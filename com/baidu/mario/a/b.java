package com.baidu.mario.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b acG;
    private c acF;
    private Handler mAudioHandler;
    private HandlerThread mAudioThread;

    public static b rS() {
        if (acG == null) {
            synchronized (b.class) {
                if (acG == null) {
                    acG = new b();
                }
            }
        }
        return acG;
    }

    private static void releaseInstance() {
        acG = null;
    }

    private b() {
    }

    private void startAudioThread() {
        this.mAudioThread = new HandlerThread("AudioHandlerThread");
        this.mAudioThread.start();
        this.mAudioHandler = new a(this.mAudioThread.getLooper());
    }

    public boolean a(e eVar, com.baidu.mario.a.a aVar) {
        if (isRunning()) {
            Log.e(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.acF == null) {
            this.acF = new c();
        }
        this.acF.a(aVar);
        startAudioThread();
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1001, eVar));
        return true;
    }

    public void startAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1002));
        }
    }

    public void stopAudio() {
        handleStopAudioEngine();
    }

    public void releaseAudio() {
        if (this.mAudioHandler != null) {
            this.mAudioHandler.removeCallbacksAndMessages(null);
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1004));
            this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1005));
        }
    }

    public boolean isRunning() {
        return this.mAudioThread != null && this.mAudioThread.isAlive();
    }

    public e rT() {
        if (this.acF != null) {
            return this.acF.rT();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    b.this.a((e) message.obj);
                    return;
                case 1002:
                    b.this.handleStartAudioEngine();
                    return;
                case 1003:
                    b.this.handleStopAudioEngine();
                    return;
                case 1004:
                    b.this.handleReleaseAudioEngine();
                    return;
                case 1005:
                    b.this.handleQuit();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (this.acF != null) {
            this.acF.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartAudioEngine() {
        if (this.acF != null) {
            this.acF.rU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopAudioEngine() {
        if (this.acF != null) {
            this.acF.rV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReleaseAudioEngine() {
        if (this.acF != null) {
            this.acF.rW();
        }
        this.acF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        releaseInstance();
        if (this.mAudioHandler != null) {
            this.mAudioHandler.removeCallbacksAndMessages(null);
            this.mAudioHandler = null;
        }
        if (this.mAudioThread != null) {
            this.mAudioThread.quit();
            this.mAudioThread = null;
        }
    }
}
