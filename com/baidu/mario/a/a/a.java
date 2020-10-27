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
    private HandlerThread bRO;
    private Handler bRP;
    private com.baidu.mario.a.b.a bRQ;
    private volatile boolean bRR = false;
    private e bRy;

    private void a(e eVar, c cVar) {
        this.bRO = new HandlerThread("AudioRecorderThread");
        this.bRO.start();
        this.bRP = new b(this.bRO.getLooper());
        try {
            this.bRQ = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bRQ == null) {
                return;
            }
        }
        this.bRy = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRQ.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bRO != null && this.bRO.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bRP.sendMessage(this.bRP.obtainMessage(1001, dVar));
        this.bRR = true;
        return true;
    }

    public void startRecording() {
        if (this.bRP != null) {
            this.bRP.sendMessage(this.bRP.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0247a c0247a = new C0247a(byteBuffer, i, j);
            if (this.bRP != null && this.bRR) {
                this.bRP.sendMessage(this.bRP.obtainMessage(1003, c0247a));
            }
        }
    }

    public void stopRecording() {
        if (this.bRP != null && this.bRR) {
            this.bRR = false;
            this.bRP.sendMessage(this.bRP.obtainMessage(1004));
        }
    }

    public void WZ() {
        if (this.bRP != null) {
            this.bRP.removeCallbacksAndMessages(null);
            this.bRP.sendMessage(this.bRP.obtainMessage(1005));
            this.bRP.sendMessage(this.bRP.obtainMessage(1006));
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
                    a.this.Xa();
                    return;
                case 1003:
                    C0247a c0247a = (C0247a) message.obj;
                    a.this.e(c0247a.bRS, c0247a.bRT, c0247a.bRU);
                    return;
                case 1004:
                    a.this.Xb();
                    return;
                case 1005:
                    a.this.Xc();
                    return;
                case 1006:
                    a.this.Xd();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bRQ != null) {
            this.bRQ.a(dVar, this.bRy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRQ.Xl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRQ.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        if (Build.VERSION.SDK_INT >= 18 && this.bRQ != null) {
            this.bRQ.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bRQ != null) {
                this.bRQ.Xk();
                this.bRQ.Xj();
            }
            this.bRQ = null;
            this.bRy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xd() {
        if (this.bRP != null) {
            this.bRP.removeCallbacksAndMessages(null);
            this.bRP = null;
        }
        if (this.bRO != null) {
            this.bRO.quit();
            this.bRO = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0247a {
        ByteBuffer bRS;
        int bRT;
        long bRU;

        public C0247a(ByteBuffer byteBuffer, int i, long j) {
            this.bRS = byteBuffer;
            this.bRT = i;
            this.bRU = j;
        }
    }
}
