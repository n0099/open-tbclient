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
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.mario.a.b.a bXA;
    private volatile boolean bXB = false;
    private e bXi;
    private HandlerThread bXy;
    private Handler bXz;

    private void a(e eVar, c cVar) {
        this.bXy = new HandlerThread("AudioRecorderThread");
        this.bXy.start();
        this.bXz = new b(this.bXy.getLooper());
        try {
            this.bXA = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bXA == null) {
                return;
            }
        }
        this.bXi = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXA.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bXy != null && this.bXy.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bXz.sendMessage(this.bXz.obtainMessage(1001, dVar));
        this.bXB = true;
        return true;
    }

    public void startRecording() {
        if (this.bXz != null) {
            this.bXz.sendMessage(this.bXz.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0259a c0259a = new C0259a(byteBuffer, i, j);
            if (this.bXz != null && this.bXB) {
                this.bXz.sendMessage(this.bXz.obtainMessage(1003, c0259a));
            }
        }
    }

    public void stopRecording() {
        if (this.bXz != null && this.bXB) {
            this.bXB = false;
            this.bXz.sendMessage(this.bXz.obtainMessage(1004));
        }
    }

    public void Zy() {
        if (this.bXz != null) {
            this.bXz.removeCallbacksAndMessages(null);
            this.bXz.sendMessage(this.bXz.obtainMessage(1005));
            this.bXz.sendMessage(this.bXz.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
                    a.this.Zz();
                    return;
                case 1003:
                    C0259a c0259a = (C0259a) message.obj;
                    a.this.e(c0259a.bXC, c0259a.bXD, c0259a.bXE);
                    return;
                case 1004:
                    a.this.ZA();
                    return;
                case 1005:
                    a.this.ZB();
                    return;
                case 1006:
                    a.this.ZC();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bXA != null) {
            this.bXA.a(dVar, this.bXi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXA.ZK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXA.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZA() {
        if (Build.VERSION.SDK_INT >= 18 && this.bXA != null) {
            this.bXA.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZB() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bXA != null) {
                this.bXA.ZJ();
                this.bXA.ZI();
            }
            this.bXA = null;
            this.bXi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZC() {
        if (this.bXz != null) {
            this.bXz.removeCallbacksAndMessages(null);
            this.bXz = null;
        }
        if (this.bXy != null) {
            this.bXy.quit();
            this.bXy = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0259a {
        ByteBuffer bXC;
        int bXD;
        long bXE;

        public C0259a(ByteBuffer byteBuffer, int i, long j) {
            this.bXC = byteBuffer;
            this.bXD = i;
            this.bXE = j;
        }
    }
}
