package com.baidu.mario.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b awk;
    private c awj;
    private Handler mAudioHandler;
    private HandlerThread mAudioThread;

    public static b xm() {
        if (awk == null) {
            synchronized (b.class) {
                if (awk == null) {
                    awk = new b();
                }
            }
        }
        return awk;
    }

    private static void releaseInstance() {
        awk = null;
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
        if (this.awj == null) {
            this.awj = new c();
        }
        this.awj.a(aVar);
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

    public e xn() {
        if (this.awj != null) {
            return this.awj.xn();
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
        if (this.awj != null) {
            this.awj.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartAudioEngine() {
        if (this.awj != null) {
            this.awj.xo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopAudioEngine() {
        if (this.awj != null) {
            this.awj.xp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReleaseAudioEngine() {
        if (this.awj != null) {
            this.awj.xq();
        }
        this.awj = null;
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
