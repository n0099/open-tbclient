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
    private e aKg;
    private HandlerThread aKw;
    private Handler aKx;
    private com.baidu.mario.a.b.a aKy;
    private volatile boolean aKz = false;

    private void a(e eVar, c cVar) {
        this.aKw = new HandlerThread("AudioRecorderThread");
        this.aKw.start();
        this.aKx = new b(this.aKw.getLooper());
        try {
            this.aKy = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aKy == null) {
                return;
            }
        }
        this.aKg = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKy.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aKw != null && this.aKw.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKx.sendMessage(this.aKx.obtainMessage(1001, dVar));
        this.aKz = true;
        return true;
    }

    public void Db() {
        if (this.aKx != null) {
            this.aKx.sendMessage(this.aKx.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0123a c0123a = new C0123a(byteBuffer, i, j);
            if (this.aKx != null && this.aKz) {
                this.aKx.sendMessage(this.aKx.obtainMessage(1003, c0123a));
            }
        }
    }

    public void stopRecording() {
        if (this.aKx != null && this.aKz) {
            this.aKz = false;
            this.aKx.sendMessage(this.aKx.obtainMessage(1004));
        }
    }

    public void Dc() {
        if (this.aKx != null) {
            this.aKx.removeCallbacksAndMessages(null);
            this.aKx.sendMessage(this.aKx.obtainMessage(1005));
            this.aKx.sendMessage(this.aKx.obtainMessage(1006));
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
                    a.this.Dd();
                    return;
                case 1003:
                    C0123a c0123a = (C0123a) message.obj;
                    a.this.e(c0123a.aKA, c0123a.aKB, c0123a.aKC);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.De();
                    return;
                case 1006:
                    a.this.Df();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKy != null) {
            this.aKy.a(dVar, this.aKg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dd() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKy.Dl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKy.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKy != null) {
            this.aKy.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aKy != null) {
                this.aKy.Dk();
                this.aKy.releaseEncoder();
            }
            this.aKy = null;
            this.aKg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df() {
        if (this.aKx != null) {
            this.aKx.removeCallbacksAndMessages(null);
            this.aKx = null;
        }
        if (this.aKw != null) {
            this.aKw.quit();
            this.aKw = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0123a {
        ByteBuffer aKA;
        int aKB;
        long aKC;

        public C0123a(ByteBuffer byteBuffer, int i, long j) {
            this.aKA = byteBuffer;
            this.aKB = i;
            this.aKC = j;
        }
    }
}
