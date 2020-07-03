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
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private volatile boolean sI = false;
    private d sV;
    private HandlerThread tj;
    private Handler tk;
    private com.baidu.ar.recorder.b.a tl;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0086a {
        ByteBuffer tm;
        int tn;
        long to;

        public C0086a(ByteBuffer byteBuffer, int i, long j) {
            this.tm = byteBuffer;
            this.tn = i;
            this.to = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
                    a.this.ex();
                    return;
                case 1003:
                    C0086a c0086a = (C0086a) message.obj;
                    a.this.b(c0086a.tm, c0086a.tn, c0086a.to);
                    return;
                case 1004:
                    a.this.ey();
                    return;
                case 1005:
                    a.this.ez();
                    return;
                case 1006:
                    a.this.eA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.a(encoderParams, this.sV);
        }
    }

    private void a(d dVar, c cVar) {
        this.tj = new HandlerThread("AudioRecorderThread");
        this.tj.start();
        this.tk = new b(this.tj.getLooper());
        this.tl = new com.baidu.ar.recorder.b.a();
        this.sV = dVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.a(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA() {
        if (this.tk != null) {
            this.tk.removeCallbacksAndMessages(null);
            this.tk = null;
        }
        if (this.tj != null) {
            this.tj.quit();
            this.tj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.eG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.a(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tl.eF();
            this.tl.eE();
            this.tl = null;
            this.sV = null;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0086a c0086a = new C0086a(byteBuffer, i, j);
        if (this.tk == null || !this.sI) {
            return;
        }
        this.tk.sendMessage(this.tk.obtainMessage(1003, c0086a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.tk.sendMessage(this.tk.obtainMessage(1001, encoderParams));
        this.sI = true;
        return true;
    }

    public void ew() {
        if (this.tk != null) {
            this.tk.removeCallbacksAndMessages(null);
            this.tk.sendMessage(this.tk.obtainMessage(1005));
            this.tk.sendMessage(this.tk.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.tj != null && this.tj.isAlive();
    }

    public void startRecording() {
        if (this.tk != null) {
            this.tk.sendMessage(this.tk.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.tk == null || !this.sI) {
            return;
        }
        this.sI = false;
        this.tk.sendMessage(this.tk.obtainMessage(1004));
    }
}
