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
/* loaded from: classes.dex */
public class b {
    public static final String TAG = "b";
    public HandlerThread uI;
    public Handler uJ;
    public f uK;
    public volatile boolean ua = false;
    public d un;

    /* loaded from: classes.dex */
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
        HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
        this.uI = handlerThread;
        handlerThread.start();
        this.uJ = new a(this.uI.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            f fVar = new f();
            this.uK = fVar;
            fVar.a(cVar);
            this.un = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        Handler handler = this.uJ;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.uJ = null;
        }
        HandlerThread handlerThread = this.uI;
        if (handlerThread != null) {
            handlerThread.quit();
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
        Handler handler = this.uJ;
        handler.sendMessage(handler.obtainMessage(1001, encoderParams));
        this.ua = true;
        return true;
    }

    public void fJ() {
        Handler handler = this.uJ;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.uJ;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.uJ;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.uI;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void startRecording() {
        Handler handler = this.uJ;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.uJ == null || !this.ua) {
            return;
        }
        this.ua = false;
        Handler handler = this.uJ;
        handler.sendMessage(handler.obtainMessage(1004));
    }

    public void v(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.uJ == null || !this.ua) {
            return;
        }
        Handler handler = this.uJ;
        handler.sendMessage(handler.obtainMessage(1003, i, i2));
    }
}
