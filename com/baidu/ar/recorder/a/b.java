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
    private volatile boolean sI = false;
    private d sV;
    private HandlerThread tq;
    private Handler tr;
    private f ts;

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
                    b.this.ex();
                    return;
                case 1003:
                    b.this.y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1004:
                    b.this.eB();
                    return;
                case 1005:
                    b.this.eC();
                    return;
                case 1006:
                    b.this.bW();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts.a(encoderParams, this.sV);
        }
    }

    private void a(d dVar, c cVar) {
        this.tq = new HandlerThread("VideoRecorderThread");
        this.tq.start();
        this.tr = new a(this.tq.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts = new f();
            this.ts.a(cVar);
            this.sV = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW() {
        if (this.tr != null) {
            this.tr.removeCallbacksAndMessages(null);
            this.tr = null;
        }
        if (this.tq != null) {
            this.tq.quit();
            this.tq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts.R(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts.eF();
            this.ts.eE();
            this.ts = null;
            this.sV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts.eG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ts.R(false);
        }
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.tr.sendMessage(this.tr.obtainMessage(1001, encoderParams));
        this.sI = true;
        return true;
    }

    public void ew() {
        if (this.tr != null) {
            this.tr.removeCallbacksAndMessages(null);
            this.tr.sendMessage(this.tr.obtainMessage(1005));
            this.tr.sendMessage(this.tr.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.tq != null && this.tq.isAlive();
    }

    public void startRecording() {
        if (this.tr != null) {
            this.tr.sendMessage(this.tr.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.tr == null || !this.sI) {
            return;
        }
        this.sI = false;
        this.tr.sendMessage(this.tr.obtainMessage(1004));
    }

    public void x(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.tr == null || !this.sI) {
            return;
        }
        this.tr.sendMessage(this.tr.obtainMessage(1003, i, i2));
    }
}
