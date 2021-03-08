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
    private HandlerThread uI;
    private Handler uJ;
    private f uK;
    private volatile boolean ua = false;
    private d un;

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
                    b.this.fK();
                    return;
                case 1003:
                    b.this.w((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1004:
                    b.this.fO();
                    return;
                case 1005:
                    b.this.fP();
                    return;
                case 1006:
                    b.this.cn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK.a(encoderParams, this.un);
        }
    }

    private void a(d dVar, c cVar) {
        this.uI = new HandlerThread("VideoRecorderThread");
        this.uI.start();
        this.uJ = new a(this.uI.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK = new f();
            this.uK.a(cVar);
            this.un = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        if (this.uJ != null) {
            this.uJ.removeCallbacksAndMessages(null);
            this.uJ = null;
        }
        if (this.uI != null) {
            this.uI.quit();
            this.uI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK.fT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK.Q(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK.fS();
            this.uK.fR();
            this.uK = null;
            this.un = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uK.Q(false);
        }
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.h.b.b(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.uJ.sendMessage(this.uJ.obtainMessage(1001, encoderParams));
        this.ua = true;
        return true;
    }

    public void fJ() {
        if (this.uJ != null) {
            this.uJ.removeCallbacksAndMessages(null);
            this.uJ.sendMessage(this.uJ.obtainMessage(1005));
            this.uJ.sendMessage(this.uJ.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.uI != null && this.uI.isAlive();
    }

    public void startRecording() {
        if (this.uJ != null) {
            this.uJ.sendMessage(this.uJ.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.uJ == null || !this.ua) {
            return;
        }
        this.ua = false;
        this.uJ.sendMessage(this.uJ.obtainMessage(1004));
    }

    public void v(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.uJ == null || !this.ua) {
            return;
        }
        this.uJ.sendMessage(this.uJ.obtainMessage(1003, i, i2));
    }
}
