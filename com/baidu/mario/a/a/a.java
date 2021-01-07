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
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread chN;
    private Handler chO;
    private com.baidu.mario.a.b.a chP;
    private volatile boolean chQ = false;
    private e chx;

    private void a(e eVar, c cVar) {
        this.chN = new HandlerThread("AudioRecorderThread");
        this.chN.start();
        this.chO = new b(this.chN.getLooper());
        try {
            this.chP = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.chP == null) {
                return;
            }
        }
        this.chx = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.chP.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.chN != null && this.chN.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.chO.sendMessage(this.chO.obtainMessage(1001, dVar));
        this.chQ = true;
        return true;
    }

    public void startRecording() {
        if (this.chO != null) {
            this.chO.sendMessage(this.chO.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0266a c0266a = new C0266a(byteBuffer, i, j);
            if (this.chO != null && this.chQ) {
                this.chO.sendMessage(this.chO.obtainMessage(1003, c0266a));
            }
        }
    }

    public void stopRecording() {
        if (this.chO != null && this.chQ) {
            this.chQ = false;
            this.chO.sendMessage(this.chO.obtainMessage(1004));
        }
    }

    public void ade() {
        if (this.chO != null) {
            this.chO.removeCallbacksAndMessages(null);
            this.chO.sendMessage(this.chO.obtainMessage(1005));
            this.chO.sendMessage(this.chO.obtainMessage(1006));
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
                    a.this.b((d) message.obj);
                    return;
                case 1002:
                    a.this.adf();
                    return;
                case 1003:
                    C0266a c0266a = (C0266a) message.obj;
                    a.this.e(c0266a.chR, c0266a.chS, c0266a.chT);
                    return;
                case 1004:
                    a.this.adg();
                    return;
                case 1005:
                    a.this.adh();
                    return;
                case 1006:
                    a.this.adi();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.chP != null) {
            this.chP.a(dVar, this.chx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adf() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chP.adq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chP.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adg() {
        if (Build.VERSION.SDK_INT >= 18 && this.chP != null) {
            this.chP.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adh() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.chP != null) {
                this.chP.adp();
                this.chP.ado();
            }
            this.chP = null;
            this.chx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adi() {
        if (this.chO != null) {
            this.chO.removeCallbacksAndMessages(null);
            this.chO = null;
        }
        if (this.chN != null) {
            this.chN.quit();
            this.chN = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0266a {
        ByteBuffer chR;
        int chS;
        long chT;

        public C0266a(ByteBuffer byteBuffer, int i, long j) {
            this.chR = byteBuffer;
            this.chS = i;
            this.chT = j;
        }
    }
}
