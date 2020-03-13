package com.baidu.mario.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.a.b.c;
import com.baidu.mario.a.b.d;
import com.baidu.mario.a.b.e;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.mario.a.b.a aKA;
    private volatile boolean aKB = false;
    private e aKi;
    private HandlerThread aKy;
    private Handler aKz;

    private void a(e eVar, c cVar) {
        this.aKy = new HandlerThread("AudioRecorderThread");
        this.aKy.start();
        this.aKz = new b(this.aKy.getLooper());
        try {
            this.aKA = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aKA == null) {
                return;
            }
        }
        this.aKi = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKA.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aKy != null && this.aKy.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKz.sendMessage(this.aKz.obtainMessage(1001, dVar));
        this.aKB = true;
        return true;
    }

    public void Dd() {
        if (this.aKz != null) {
            this.aKz.sendMessage(this.aKz.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0123a c0123a = new C0123a(byteBuffer, i, j);
            if (this.aKz != null && this.aKB) {
                this.aKz.sendMessage(this.aKz.obtainMessage(1003, c0123a));
            }
        }
    }

    public void stopRecording() {
        if (this.aKz != null && this.aKB) {
            this.aKB = false;
            this.aKz.sendMessage(this.aKz.obtainMessage(1004));
        }
    }

    public void De() {
        if (this.aKz != null) {
            this.aKz.removeCallbacksAndMessages(null);
            this.aKz.sendMessage(this.aKz.obtainMessage(1005));
            this.aKz.sendMessage(this.aKz.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a.this.b((d) message.obj);
                    return;
                case 1002:
                    a.this.Df();
                    return;
                case 1003:
                    C0123a c0123a = (C0123a) message.obj;
                    a.this.e(c0123a.aKC, c0123a.aKD, c0123a.aKE);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.Dg();
                    return;
                case 1006:
                    a.this.Dh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKA != null) {
            this.aKA.a(dVar, this.aKi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKA.Dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKA.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKA != null) {
            this.aKA.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aKA != null) {
                this.aKA.Dm();
                this.aKA.releaseEncoder();
            }
            this.aKA = null;
            this.aKi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        if (this.aKz != null) {
            this.aKz.removeCallbacksAndMessages(null);
            this.aKz = null;
        }
        if (this.aKy != null) {
            this.aKy.quit();
            this.aKy = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0123a {
        ByteBuffer aKC;
        int aKD;
        long aKE;

        public C0123a(ByteBuffer byteBuffer, int i, long j) {
            this.aKC = byteBuffer;
            this.aKD = i;
            this.aKE = j;
        }
    }
}
