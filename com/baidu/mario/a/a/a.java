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
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e bCB;
    private HandlerThread bCR;
    private Handler bCS;
    private com.baidu.mario.a.b.a bCT;
    private volatile boolean bCU = false;

    private void a(e eVar, c cVar) {
        this.bCR = new HandlerThread("AudioRecorderThread");
        this.bCR.start();
        this.bCS = new b(this.bCR.getLooper());
        try {
            this.bCT = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bCT == null) {
                return;
            }
        }
        this.bCB = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bCT.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bCR != null && this.bCR.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bCS.sendMessage(this.bCS.obtainMessage(1001, dVar));
        this.bCU = true;
        return true;
    }

    public void startRecording() {
        if (this.bCS != null) {
            this.bCS.sendMessage(this.bCS.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0218a c0218a = new C0218a(byteBuffer, i, j);
            if (this.bCS != null && this.bCU) {
                this.bCS.sendMessage(this.bCS.obtainMessage(1003, c0218a));
            }
        }
    }

    public void stopRecording() {
        if (this.bCS != null && this.bCU) {
            this.bCU = false;
            this.bCS.sendMessage(this.bCS.obtainMessage(1004));
        }
    }

    public void Tm() {
        if (this.bCS != null) {
            this.bCS.removeCallbacksAndMessages(null);
            this.bCS.sendMessage(this.bCS.obtainMessage(1005));
            this.bCS.sendMessage(this.bCS.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
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
                    a.this.Tn();
                    return;
                case 1003:
                    C0218a c0218a = (C0218a) message.obj;
                    a.this.e(c0218a.bCV, c0218a.bCW, c0218a.bCX);
                    return;
                case 1004:
                    a.this.To();
                    return;
                case 1005:
                    a.this.Tp();
                    return;
                case 1006:
                    a.this.Tq();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bCT != null) {
            this.bCT.a(dVar, this.bCB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bCT.Ty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bCT.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To() {
        if (Build.VERSION.SDK_INT >= 18 && this.bCT != null) {
            this.bCT.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tp() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bCT != null) {
                this.bCT.Tx();
                this.bCT.Tw();
            }
            this.bCT = null;
            this.bCB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (this.bCS != null) {
            this.bCS.removeCallbacksAndMessages(null);
            this.bCS = null;
        }
        if (this.bCR != null) {
            this.bCR.quit();
            this.bCR = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0218a {
        ByteBuffer bCV;
        int bCW;
        long bCX;

        public C0218a(ByteBuffer byteBuffer, int i, long j) {
            this.bCV = byteBuffer;
            this.bCW = i;
            this.bCX = j;
        }
    }
}
