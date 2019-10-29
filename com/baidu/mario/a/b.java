package com.baidu.mario.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b awC;
    private c awB;
    private Handler mAudioHandler;
    private HandlerThread mAudioThread;

    public static b xl() {
        if (awC == null) {
            synchronized (b.class) {
                if (awC == null) {
                    awC = new b();
                }
            }
        }
        return awC;
    }

    private static void releaseInstance() {
        awC = null;
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
        if (this.awB == null) {
            this.awB = new c();
        }
        this.awB.a(aVar);
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

    public e xm() {
        if (this.awB != null) {
            return this.awB.xm();
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
        if (this.awB != null) {
            this.awB.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartAudioEngine() {
        if (this.awB != null) {
            this.awB.xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopAudioEngine() {
        if (this.awB != null) {
            this.awB.xo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReleaseAudioEngine() {
        if (this.awB != null) {
            this.awB.xp();
        }
        this.awB = null;
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
