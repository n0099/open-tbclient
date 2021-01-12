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
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread uB;
    private Handler uC;
    private com.baidu.ar.recorder.b.a uD;
    private volatile boolean ua = false;
    private d un;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0080a {
        ByteBuffer uE;
        int uF;
        long uG;

        public C0080a(ByteBuffer byteBuffer, int i, long j) {
            this.uE = byteBuffer;
            this.uF = i;
            this.uG = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
                    C0080a c0080a = (C0080a) message.obj;
                    a.this.b(c0080a.uE, c0080a.uF, c0080a.uG);
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
        this.uB = new HandlerThread("AudioRecorderThread");
        this.uB.start();
        this.uC = new b(this.uB.getLooper());
        this.uD = new com.baidu.ar.recorder.b.a();
        this.un = dVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.uD.a(cVar);
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
        if (this.uC != null) {
            this.uC.removeCallbacksAndMessages(null);
            this.uC = null;
        }
        if (this.uB != null) {
            this.uB.quit();
            this.uB = null;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0080a c0080a = new C0080a(byteBuffer, i, j);
        if (this.uC == null || !this.ua) {
            return;
        }
        this.uC.sendMessage(this.uC.obtainMessage(1003, c0080a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.h.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.uC.sendMessage(this.uC.obtainMessage(1001, encoderParams));
        this.ua = true;
        return true;
    }

    public void fJ() {
        if (this.uC != null) {
            this.uC.removeCallbacksAndMessages(null);
            this.uC.sendMessage(this.uC.obtainMessage(1005));
            this.uC.sendMessage(this.uC.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.uB != null && this.uB.isAlive();
    }

    public void startRecording() {
        if (this.uC != null) {
            this.uC.sendMessage(this.uC.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.uC == null || !this.ua) {
            return;
        }
        this.ua = false;
        this.uC.sendMessage(this.uC.obtainMessage(1004));
    }
}
