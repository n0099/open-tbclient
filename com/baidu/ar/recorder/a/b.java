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
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread sQ;
    private Handler sR;
    private f sS;
    private volatile boolean si = false;
    private d sv;

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
                    b.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    b.this.eh();
                    return;
                case 1003:
                    b.this.y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1004:
                    b.this.el();
                    return;
                case 1005:
                    b.this.em();
                    return;
                case 1006:
                    b.this.bI();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS.a(encoderParams, this.sv);
        }
    }

    private void a(d dVar, c cVar) {
        this.sQ = new HandlerThread("VideoRecorderThread");
        this.sQ.start();
        this.sR = new a(this.sQ.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS = new f();
            this.sS.a(cVar);
            this.sv = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI() {
        if (this.sR != null) {
            this.sR.removeCallbacksAndMessages(null);
            this.sR = null;
        }
        if (this.sQ != null) {
            this.sQ.quit();
            this.sQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS.eq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS.Q(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS.ep();
            this.sS.eo();
            this.sS = null;
            this.sv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sS.Q(false);
        }
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.sR.sendMessage(this.sR.obtainMessage(1001, encoderParams));
        this.si = true;
        return true;
    }

    public void eg() {
        if (this.sR != null) {
            this.sR.removeCallbacksAndMessages(null);
            this.sR.sendMessage(this.sR.obtainMessage(1005));
            this.sR.sendMessage(this.sR.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.sQ != null && this.sQ.isAlive();
    }

    public void startRecording() {
        if (this.sR != null) {
            this.sR.sendMessage(this.sR.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.sR == null || !this.si) {
            return;
        }
        this.si = false;
        this.sR.sendMessage(this.sR.obtainMessage(1004));
    }

    public void x(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.sR == null || !this.si) {
            return;
        }
        this.sR.sendMessage(this.sR.obtainMessage(1003, i, i2));
    }
}
