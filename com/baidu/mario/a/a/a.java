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
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e aGa;
    private HandlerThread aGr;
    private Handler aGs;
    private com.baidu.mario.a.b.a aGt;
    private volatile boolean aGu = false;

    private void a(e eVar, c cVar) {
        this.aGr = new HandlerThread("AudioRecorderThread");
        this.aGr.start();
        this.aGs = new b(this.aGr.getLooper());
        try {
            this.aGt = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aGt == null) {
                return;
            }
        }
        this.aGa = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGt.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aGr != null && this.aGr.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aGs.sendMessage(this.aGs.obtainMessage(1001, dVar));
        this.aGu = true;
        return true;
    }

    public void AL() {
        if (this.aGs != null) {
            this.aGs.sendMessage(this.aGs.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0115a c0115a = new C0115a(byteBuffer, i, j);
            if (this.aGs != null && this.aGu) {
                this.aGs.sendMessage(this.aGs.obtainMessage(1003, c0115a));
            }
        }
    }

    public void stopRecording() {
        if (this.aGs != null && this.aGu) {
            this.aGu = false;
            this.aGs.sendMessage(this.aGs.obtainMessage(1004));
        }
    }

    public void AM() {
        if (this.aGs != null) {
            this.aGs.removeCallbacksAndMessages(null);
            this.aGs.sendMessage(this.aGs.obtainMessage(1005));
            this.aGs.sendMessage(this.aGs.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
                    a.this.AN();
                    return;
                case 1003:
                    C0115a c0115a = (C0115a) message.obj;
                    a.this.e(c0115a.aGv, c0115a.aGw, c0115a.aGx);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.AO();
                    return;
                case 1006:
                    a.this.AP();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aGt != null) {
            this.aGt.a(dVar, this.aGa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGt.AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGt.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aGt != null) {
            this.aGt.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aGt != null) {
                this.aGt.AU();
                this.aGt.releaseEncoder();
            }
            this.aGt = null;
            this.aGa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP() {
        if (this.aGs != null) {
            this.aGs.removeCallbacksAndMessages(null);
            this.aGs = null;
        }
        if (this.aGr != null) {
            this.aGr.quit();
            this.aGr = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0115a {
        ByteBuffer aGv;
        int aGw;
        long aGx;

        public C0115a(ByteBuffer byteBuffer, int i, long j) {
            this.aGv = byteBuffer;
            this.aGw = i;
            this.aGx = j;
        }
    }
}
