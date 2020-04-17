package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b is;
    private c ip;
    private HandlerThread iq;
    private Handler ir;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
                    b.this.bF();
                    return;
                case 1003:
                    b.this.bG();
                    return;
                case 1004:
                    b.this.bH();
                    return;
                case 1005:
                    b.this.bI();
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
        if (this.ip != null) {
            this.ip.b(audioParams);
        }
    }

    public static b bA() {
        if (is == null) {
            synchronized (b.class) {
                if (is == null) {
                    is = new b();
                }
            }
        }
        return is;
    }

    private void bB() {
        this.iq = new HandlerThread("AudioHandlerThread");
        this.iq.start();
        this.ir = new a(this.iq.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF() {
        if (this.ip != null) {
            this.ip.bJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG() {
        if (this.ip != null) {
            this.ip.bK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH() {
        if (this.ip != null) {
            this.ip.bL();
        }
        this.ip = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI() {
        releaseInstance();
        if (this.ir != null) {
            this.ir.removeCallbacksAndMessages(null);
            this.ir = null;
        }
        if (this.iq != null) {
            this.iq.quit();
            this.iq = null;
        }
    }

    private static void releaseInstance() {
        is = null;
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.ip == null) {
            this.ip = new c();
        }
        this.ip.a(aVar);
        bB();
        this.ir.sendMessage(this.ir.obtainMessage(1001, audioParams));
        return true;
    }

    public void bC() {
        bG();
    }

    public void bD() {
        if (this.ir != null) {
            this.ir.removeCallbacksAndMessages(null);
            this.ir.sendMessage(this.ir.obtainMessage(1004));
            this.ir.sendMessage(this.ir.obtainMessage(1005));
        }
    }

    public AudioParams bE() {
        if (this.ip != null) {
            return this.ip.bE();
        }
        return null;
    }

    public boolean isRunning() {
        return this.iq != null && this.iq.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.ip == null) {
                this.ip = new c();
            }
            this.ip.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        if (this.ir != null) {
            this.ir.sendMessage(this.ir.obtainMessage(1002));
        }
    }
}
