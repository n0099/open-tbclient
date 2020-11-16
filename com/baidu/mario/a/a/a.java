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
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread bVO;
    private Handler bVP;
    private com.baidu.mario.a.b.a bVQ;
    private volatile boolean bVR = false;
    private e bVy;

    private void a(e eVar, c cVar) {
        this.bVO = new HandlerThread("AudioRecorderThread");
        this.bVO.start();
        this.bVP = new b(this.bVO.getLooper());
        try {
            this.bVQ = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bVQ == null) {
                return;
            }
        }
        this.bVy = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVQ.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bVO != null && this.bVO.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bVP.sendMessage(this.bVP.obtainMessage(1001, dVar));
        this.bVR = true;
        return true;
    }

    public void startRecording() {
        if (this.bVP != null) {
            this.bVP.sendMessage(this.bVP.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0257a c0257a = new C0257a(byteBuffer, i, j);
            if (this.bVP != null && this.bVR) {
                this.bVP.sendMessage(this.bVP.obtainMessage(1003, c0257a));
            }
        }
    }

    public void stopRecording() {
        if (this.bVP != null && this.bVR) {
            this.bVR = false;
            this.bVP.sendMessage(this.bVP.obtainMessage(1004));
        }
    }

    public void YP() {
        if (this.bVP != null) {
            this.bVP.removeCallbacksAndMessages(null);
            this.bVP.sendMessage(this.bVP.obtainMessage(1005));
            this.bVP.sendMessage(this.bVP.obtainMessage(1006));
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
                    a.this.b((d) message.obj);
                    return;
                case 1002:
                    a.this.YQ();
                    return;
                case 1003:
                    C0257a c0257a = (C0257a) message.obj;
                    a.this.e(c0257a.bVS, c0257a.bVT, c0257a.bVU);
                    return;
                case 1004:
                    a.this.YR();
                    return;
                case 1005:
                    a.this.YS();
                    return;
                case 1006:
                    a.this.YT();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bVQ != null) {
            this.bVQ.a(dVar, this.bVy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YQ() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVQ.Zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVQ.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YR() {
        if (Build.VERSION.SDK_INT >= 18 && this.bVQ != null) {
            this.bVQ.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YS() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bVQ != null) {
                this.bVQ.Za();
                this.bVQ.YZ();
            }
            this.bVQ = null;
            this.bVy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YT() {
        if (this.bVP != null) {
            this.bVP.removeCallbacksAndMessages(null);
            this.bVP = null;
        }
        if (this.bVO != null) {
            this.bVO.quit();
            this.bVO = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0257a {
        ByteBuffer bVS;
        int bVT;
        long bVU;

        public C0257a(ByteBuffer byteBuffer, int i, long j) {
            this.bVS = byteBuffer;
            this.bVT = i;
            this.bVU = j;
        }
    }
}
