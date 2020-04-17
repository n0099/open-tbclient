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
    private HandlerThread bgG;
    private Handler bgH;
    private com.baidu.mario.a.b.a bgI;
    private volatile boolean bgJ = false;
    private e bgp;

    private void a(e eVar, c cVar) {
        this.bgG = new HandlerThread("AudioRecorderThread");
        this.bgG.start();
        this.bgH = new b(this.bgG.getLooper());
        try {
            this.bgI = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bgI == null) {
                return;
            }
        }
        this.bgp = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgI.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bgG != null && this.bgG.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bgH.sendMessage(this.bgH.obtainMessage(1001, dVar));
        this.bgJ = true;
        return true;
    }

    public void startRecording() {
        if (this.bgH != null) {
            this.bgH.sendMessage(this.bgH.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0148a c0148a = new C0148a(byteBuffer, i, j);
            if (this.bgH != null && this.bgJ) {
                this.bgH.sendMessage(this.bgH.obtainMessage(1003, c0148a));
            }
        }
    }

    public void stopRecording() {
        if (this.bgH != null && this.bgJ) {
            this.bgJ = false;
            this.bgH.sendMessage(this.bgH.obtainMessage(1004));
        }
    }

    public void Jo() {
        if (this.bgH != null) {
            this.bgH.removeCallbacksAndMessages(null);
            this.bgH.sendMessage(this.bgH.obtainMessage(1005));
            this.bgH.sendMessage(this.bgH.obtainMessage(1006));
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
                    a.this.Jp();
                    return;
                case 1003:
                    C0148a c0148a = (C0148a) message.obj;
                    a.this.e(c0148a.bgK, c0148a.bgL, c0148a.bgM);
                    return;
                case 1004:
                    a.this.Jq();
                    return;
                case 1005:
                    a.this.Jr();
                    return;
                case 1006:
                    a.this.Js();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bgI != null) {
            this.bgI.a(dVar, this.bgp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgI.JA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgI.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        if (Build.VERSION.SDK_INT >= 18 && this.bgI != null) {
            this.bgI.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bgI != null) {
                this.bgI.Jz();
                this.bgI.Jy();
            }
            this.bgI = null;
            this.bgp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Js() {
        if (this.bgH != null) {
            this.bgH.removeCallbacksAndMessages(null);
            this.bgH = null;
        }
        if (this.bgG != null) {
            this.bgG.quit();
            this.bgG = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0148a {
        ByteBuffer bgK;
        int bgL;
        long bgM;

        public C0148a(ByteBuffer byteBuffer, int i, long j) {
            this.bgK = byteBuffer;
            this.bgL = i;
            this.bgM = j;
        }
    }
}
