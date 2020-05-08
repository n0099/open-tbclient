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
    private HandlerThread bgL;
    private Handler bgM;
    private com.baidu.mario.a.b.a bgN;
    private volatile boolean bgO = false;
    private e bgv;

    private void a(e eVar, c cVar) {
        this.bgL = new HandlerThread("AudioRecorderThread");
        this.bgL.start();
        this.bgM = new b(this.bgL.getLooper());
        try {
            this.bgN = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bgN == null) {
                return;
            }
        }
        this.bgv = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgN.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bgL != null && this.bgL.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bgM.sendMessage(this.bgM.obtainMessage(1001, dVar));
        this.bgO = true;
        return true;
    }

    public void startRecording() {
        if (this.bgM != null) {
            this.bgM.sendMessage(this.bgM.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0169a c0169a = new C0169a(byteBuffer, i, j);
            if (this.bgM != null && this.bgO) {
                this.bgM.sendMessage(this.bgM.obtainMessage(1003, c0169a));
            }
        }
    }

    public void stopRecording() {
        if (this.bgM != null && this.bgO) {
            this.bgO = false;
            this.bgM.sendMessage(this.bgM.obtainMessage(1004));
        }
    }

    public void Jn() {
        if (this.bgM != null) {
            this.bgM.removeCallbacksAndMessages(null);
            this.bgM.sendMessage(this.bgM.obtainMessage(1005));
            this.bgM.sendMessage(this.bgM.obtainMessage(1006));
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
                    a.this.Jo();
                    return;
                case 1003:
                    C0169a c0169a = (C0169a) message.obj;
                    a.this.e(c0169a.bgP, c0169a.bgQ, c0169a.bgR);
                    return;
                case 1004:
                    a.this.Jp();
                    return;
                case 1005:
                    a.this.Jq();
                    return;
                case 1006:
                    a.this.Jr();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bgN != null) {
            this.bgN.a(dVar, this.bgv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgN.Jz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgN.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (Build.VERSION.SDK_INT >= 18 && this.bgN != null) {
            this.bgN.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bgN != null) {
                this.bgN.Jy();
                this.bgN.Jx();
            }
            this.bgN = null;
            this.bgv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr() {
        if (this.bgM != null) {
            this.bgM.removeCallbacksAndMessages(null);
            this.bgM = null;
        }
        if (this.bgL != null) {
            this.bgL.quit();
            this.bgL = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0169a {
        ByteBuffer bgP;
        int bgQ;
        long bgR;

        public C0169a(ByteBuffer byteBuffer, int i, long j) {
            this.bgP = byteBuffer;
            this.bgQ = i;
            this.bgR = j;
        }
    }
}
