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
    private HandlerThread aKM;
    private Handler aKN;
    private com.baidu.mario.a.b.a aKO;
    private volatile boolean aKP = false;
    private e aKw;

    private void a(e eVar, c cVar) {
        this.aKM = new HandlerThread("AudioRecorderThread");
        this.aKM.start();
        this.aKN = new b(this.aKM.getLooper());
        try {
            this.aKO = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aKO == null) {
                return;
            }
        }
        this.aKw = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKO.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aKM != null && this.aKM.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKN.sendMessage(this.aKN.obtainMessage(1001, dVar));
        this.aKP = true;
        return true;
    }

    public void Dk() {
        if (this.aKN != null) {
            this.aKN.sendMessage(this.aKN.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0123a c0123a = new C0123a(byteBuffer, i, j);
            if (this.aKN != null && this.aKP) {
                this.aKN.sendMessage(this.aKN.obtainMessage(1003, c0123a));
            }
        }
    }

    public void stopRecording() {
        if (this.aKN != null && this.aKP) {
            this.aKP = false;
            this.aKN.sendMessage(this.aKN.obtainMessage(1004));
        }
    }

    public void Dl() {
        if (this.aKN != null) {
            this.aKN.removeCallbacksAndMessages(null);
            this.aKN.sendMessage(this.aKN.obtainMessage(1005));
            this.aKN.sendMessage(this.aKN.obtainMessage(1006));
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
                    a.this.Dm();
                    return;
                case 1003:
                    C0123a c0123a = (C0123a) message.obj;
                    a.this.e(c0123a.aKQ, c0123a.aKR, c0123a.aKS);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.Dn();
                    return;
                case 1006:
                    a.this.Do();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKO != null) {
            this.aKO.a(dVar, this.aKw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKO.Du();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKO.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKO != null) {
            this.aKO.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aKO != null) {
                this.aKO.Dt();
                this.aKO.releaseEncoder();
            }
            this.aKO = null;
            this.aKw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do() {
        if (this.aKN != null) {
            this.aKN.removeCallbacksAndMessages(null);
            this.aKN = null;
        }
        if (this.aKM != null) {
            this.aKM.quit();
            this.aKM = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0123a {
        ByteBuffer aKQ;
        int aKR;
        long aKS;

        public C0123a(ByteBuffer byteBuffer, int i, long j) {
            this.aKQ = byteBuffer;
            this.aKR = i;
            this.aKS = j;
        }
    }
}
