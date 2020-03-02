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
    private volatile boolean aKA = false;
    private e aKh;
    private HandlerThread aKx;
    private Handler aKy;
    private com.baidu.mario.a.b.a aKz;

    private void a(e eVar, c cVar) {
        this.aKx = new HandlerThread("AudioRecorderThread");
        this.aKx.start();
        this.aKy = new b(this.aKx.getLooper());
        try {
            this.aKz = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aKz == null) {
                return;
            }
        }
        this.aKh = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKz.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aKx != null && this.aKx.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKy.sendMessage(this.aKy.obtainMessage(1001, dVar));
        this.aKA = true;
        return true;
    }

    public void Dd() {
        if (this.aKy != null) {
            this.aKy.sendMessage(this.aKy.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0123a c0123a = new C0123a(byteBuffer, i, j);
            if (this.aKy != null && this.aKA) {
                this.aKy.sendMessage(this.aKy.obtainMessage(1003, c0123a));
            }
        }
    }

    public void stopRecording() {
        if (this.aKy != null && this.aKA) {
            this.aKA = false;
            this.aKy.sendMessage(this.aKy.obtainMessage(1004));
        }
    }

    public void De() {
        if (this.aKy != null) {
            this.aKy.removeCallbacksAndMessages(null);
            this.aKy.sendMessage(this.aKy.obtainMessage(1005));
            this.aKy.sendMessage(this.aKy.obtainMessage(1006));
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
                    a.this.e(c0123a.aKB, c0123a.aKC, c0123a.aKD);
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
        if (Build.VERSION.SDK_INT >= 18 && this.aKz != null) {
            this.aKz.a(dVar, this.aKh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKz.Dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKz.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKz != null) {
            this.aKz.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aKz != null) {
                this.aKz.Dm();
                this.aKz.releaseEncoder();
            }
            this.aKz = null;
            this.aKh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        if (this.aKy != null) {
            this.aKy.removeCallbacksAndMessages(null);
            this.aKy = null;
        }
        if (this.aKx != null) {
            this.aKx.quit();
            this.aKx = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0123a {
        ByteBuffer aKB;
        int aKC;
        long aKD;

        public C0123a(ByteBuffer byteBuffer, int i, long j) {
            this.aKB = byteBuffer;
            this.aKC = i;
            this.aKD = j;
        }
    }
}
