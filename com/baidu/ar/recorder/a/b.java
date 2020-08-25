package com.baidu.ar.recorder.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import com.baidu.ar.recorder.b.f;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private d tA;
    private HandlerThread tV;
    private Handler tW;
    private f tX;
    private volatile boolean tn = false;

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
                    b.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    b.this.fJ();
                    return;
                case 1003:
                    b.this.y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1004:
                    b.this.fN();
                    return;
                case 1005:
                    b.this.fO();
                    return;
                case 1006:
                    b.this.co();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX.a(encoderParams, this.tA);
        }
    }

    private void a(d dVar, c cVar) {
        this.tV = new HandlerThread("VideoRecorderThread");
        this.tV.start();
        this.tW = new a(this.tV.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX = new f();
            this.tX.a(cVar);
            this.tA = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co() {
        if (this.tW != null) {
            this.tW.removeCallbacksAndMessages(null);
            this.tW = null;
        }
        if (this.tV != null) {
            this.tV.quit();
            this.tV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX.fS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX.S(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX.fR();
            this.tX.fQ();
            this.tX = null;
            this.tA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tX.S(false);
        }
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.g.b.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.tW.sendMessage(this.tW.obtainMessage(1001, encoderParams));
        this.tn = true;
        return true;
    }

    public void fI() {
        if (this.tW != null) {
            this.tW.removeCallbacksAndMessages(null);
            this.tW.sendMessage(this.tW.obtainMessage(1005));
            this.tW.sendMessage(this.tW.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.tV != null && this.tV.isAlive();
    }

    public void startRecording() {
        if (this.tW != null) {
            this.tW.sendMessage(this.tW.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.tW == null || !this.tn) {
            return;
        }
        this.tn = false;
        this.tW.sendMessage(this.tW.obtainMessage(1004));
    }

    public void x(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.tW == null || !this.tn) {
            return;
        }
        this.tW.sendMessage(this.tW.obtainMessage(1003, i, i2));
    }
}
