package com.baidu.ar.recorder.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static final String TAG = "a";
    public HandlerThread uB;
    public Handler uC;
    public com.baidu.ar.recorder.b.a uD;
    public volatile boolean ua = false;
    public d un;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a {
        public ByteBuffer uE;
        public int uF;
        public long uG;

        public C0058a(ByteBuffer byteBuffer, int i, long j) {
            this.uE = byteBuffer;
            this.uF = i;
            this.uG = j;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    a.this.fK();
                    return;
                case 1003:
                    C0058a c0058a = (C0058a) message.obj;
                    a.this.b(c0058a.uE, c0058a.uF, c0058a.uG);
                    return;
                case 1004:
                    a.this.fL();
                    return;
                case 1005:
                    a.this.fM();
                    return;
                case 1006:
                    a.this.fN();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.a(encoderParams, this.un);
        }
    }

    private void a(d dVar, c cVar) {
        HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
        this.uB = handlerThread;
        handlerThread.start();
        this.uC = new b(this.uB.getLooper());
        com.baidu.ar.recorder.b.a aVar = new com.baidu.ar.recorder.b.a();
        this.uD = aVar;
        this.un = dVar;
        if (Build.VERSION.SDK_INT >= 18) {
            aVar.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.a(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.fT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.a(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.fS();
            this.uD.fR();
            this.uD = null;
            this.un = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN() {
        Handler handler = this.uC;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.uC = null;
        }
        HandlerThread handlerThread = this.uB;
        if (handlerThread != null) {
            handlerThread.quit();
            this.uB = null;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0058a c0058a = new C0058a(byteBuffer, i, j);
        if (this.uC == null || !this.ua) {
            return;
        }
        Handler handler = this.uC;
        handler.sendMessage(handler.obtainMessage(1003, c0058a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.h.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        Handler handler = this.uC;
        handler.sendMessage(handler.obtainMessage(1001, encoderParams));
        this.ua = true;
        return true;
    }

    public void fJ() {
        Handler handler = this.uC;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.uC;
            handler2.sendMessage(handler2.obtainMessage(1005));
            Handler handler3 = this.uC;
            handler3.sendMessage(handler3.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.uB;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void startRecording() {
        Handler handler = this.uC;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.uC == null || !this.ua) {
            return;
        }
        this.ua = false;
        Handler handler = this.uC;
        handler.sendMessage(handler.obtainMessage(1004));
    }
}
