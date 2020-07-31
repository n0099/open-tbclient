package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b iH;
    private c iE;
    private HandlerThread iF;
    private Handler iG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    b.this.a((AudioParams) message.obj);
                    return;
                case 1002:
                    b.this.bT();
                    return;
                case 1003:
                    b.this.bU();
                    return;
                case 1004:
                    b.this.bV();
                    return;
                case 1005:
                    b.this.bW();
                    return;
                default:
                    return;
            }
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioParams audioParams) {
        if (this.iE != null) {
            this.iE.b(audioParams);
        }
    }

    public static b bO() {
        if (iH == null) {
            synchronized (b.class) {
                if (iH == null) {
                    iH = new b();
                }
            }
        }
        return iH;
    }

    private void bP() {
        this.iF = new HandlerThread("AudioHandlerThread");
        this.iF.start();
        this.iG = new a(this.iF.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        if (this.iE != null) {
            this.iE.bX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU() {
        if (this.iE != null) {
            this.iE.bY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV() {
        if (this.iE != null) {
            this.iE.bZ();
        }
        this.iE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW() {
        releaseInstance();
        if (this.iG != null) {
            this.iG.removeCallbacksAndMessages(null);
            this.iG = null;
        }
        if (this.iF != null) {
            this.iF.quit();
            this.iF = null;
        }
    }

    private static void releaseInstance() {
        iH = null;
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.iE == null) {
            this.iE = new c();
        }
        this.iE.a(aVar);
        bP();
        this.iG.sendMessage(this.iG.obtainMessage(1001, audioParams));
        return true;
    }

    public void bQ() {
        bU();
    }

    public void bR() {
        if (this.iG != null) {
            this.iG.removeCallbacksAndMessages(null);
            this.iG.sendMessage(this.iG.obtainMessage(1004));
            this.iG.sendMessage(this.iG.obtainMessage(1005));
        }
    }

    public AudioParams bS() {
        if (this.iE != null) {
            return this.iE.bS();
        }
        return null;
    }

    public boolean isRunning() {
        return this.iF != null && this.iF.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.iE == null) {
                this.iE = new c();
            }
            this.iE.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        if (this.iG != null) {
            this.iG.sendMessage(this.iG.obtainMessage(1002));
        }
    }
}
