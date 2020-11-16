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
/* loaded from: classes12.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private d tA;
    private HandlerThread tO;
    private Handler tP;
    private com.baidu.ar.recorder.b.a tQ;
    private volatile boolean tn = false;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private class C0086a {
        ByteBuffer tR;
        int tS;
        long tT;

        public C0086a(ByteBuffer byteBuffer, int i, long j) {
            this.tR = byteBuffer;
            this.tS = i;
            this.tT = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
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
                    a.this.fJ();
                    return;
                case 1003:
                    C0086a c0086a = (C0086a) message.obj;
                    a.this.b(c0086a.tR, c0086a.tS, c0086a.tT);
                    return;
                case 1004:
                    a.this.fK();
                    return;
                case 1005:
                    a.this.fL();
                    return;
                case 1006:
                    a.this.fM();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.a(encoderParams, this.tA);
        }
    }

    private void a(d dVar, c cVar) {
        this.tO = new HandlerThread("AudioRecorderThread");
        this.tO.start();
        this.tP = new b(this.tO.getLooper());
        this.tQ = new com.baidu.ar.recorder.b.a();
        this.tA = dVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.a(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.fS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.a(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tQ.fR();
            this.tQ.fQ();
            this.tQ = null;
            this.tA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        if (this.tP != null) {
            this.tP.removeCallbacksAndMessages(null);
            this.tP = null;
        }
        if (this.tO != null) {
            this.tO.quit();
            this.tO = null;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0086a c0086a = new C0086a(byteBuffer, i, j);
        if (this.tP == null || !this.tn) {
            return;
        }
        this.tP.sendMessage(this.tP.obtainMessage(1003, c0086a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.g.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.tP.sendMessage(this.tP.obtainMessage(1001, encoderParams));
        this.tn = true;
        return true;
    }

    public void fI() {
        if (this.tP != null) {
            this.tP.removeCallbacksAndMessages(null);
            this.tP.sendMessage(this.tP.obtainMessage(1005));
            this.tP.sendMessage(this.tP.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.tO != null && this.tO.isAlive();
    }

    public void startRecording() {
        if (this.tP != null) {
            this.tP.sendMessage(this.tP.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.tP == null || !this.tn) {
            return;
        }
        this.tn = false;
        this.tP.sendMessage(this.tP.obtainMessage(1004));
    }
}
