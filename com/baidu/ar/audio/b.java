package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b iF;
    private c iC;
    private HandlerThread iD;
    private Handler iE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
                    b.this.ck();
                    return;
                case 1003:
                    b.this.cl();
                    return;
                case 1004:
                    b.this.cm();
                    return;
                case 1005:
                    b.this.cn();
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
        if (this.iC != null) {
            this.iC.b(audioParams);
        }
    }

    public static b cf() {
        if (iF == null) {
            synchronized (b.class) {
                if (iF == null) {
                    iF = new b();
                }
            }
        }
        return iF;
    }

    private void cg() {
        this.iD = new HandlerThread("AudioHandlerThread");
        this.iD.start();
        this.iE = new a(this.iD.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck() {
        if (this.iC != null) {
            this.iC.co();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        if (this.iC != null) {
            this.iC.cp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm() {
        if (this.iC != null) {
            this.iC.cq();
        }
        this.iC = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        releaseInstance();
        if (this.iE != null) {
            this.iE.removeCallbacksAndMessages(null);
            this.iE = null;
        }
        if (this.iD != null) {
            this.iD.quit();
            this.iD = null;
        }
    }

    private static void releaseInstance() {
        iF = null;
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (isRunning()) {
            com.baidu.ar.h.b.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.iC == null) {
            this.iC = new c();
        }
        this.iC.a(aVar);
        cg();
        this.iE.sendMessage(this.iE.obtainMessage(1001, audioParams));
        return true;
    }

    public void ch() {
        cl();
    }

    public void ci() {
        if (this.iE != null) {
            this.iE.removeCallbacksAndMessages(null);
            this.iE.sendMessage(this.iE.obtainMessage(1004));
            this.iE.sendMessage(this.iE.obtainMessage(1005));
        }
    }

    public AudioParams cj() {
        if (this.iC != null) {
            return this.iC.cj();
        }
        return null;
    }

    public boolean isRunning() {
        return this.iD != null && this.iD.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.iC == null) {
                this.iC = new c();
            }
            this.iC.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        if (this.iE != null) {
            this.iE.sendMessage(this.iE.obtainMessage(1002));
        }
    }
}
