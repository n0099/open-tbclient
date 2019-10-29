package com.baidu.mario.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.b.b.c;
import com.baidu.mario.b.b.d;
import com.baidu.mario.b.b.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e axP;
    private HandlerThread ayf;
    private Handler ayg;
    private com.baidu.mario.b.b.a ayh;
    private volatile boolean ayi = false;

    private void a(e eVar, c cVar) {
        this.ayf = new HandlerThread("AudioRecorderThread");
        this.ayf.start();
        this.ayg = new b(this.ayf.getLooper());
        this.ayh = new com.baidu.mario.b.b.a();
        this.axP = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.ayf != null && this.ayf.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.ayg.sendMessage(this.ayg.obtainMessage(1001, dVar));
        this.ayi = true;
        return true;
    }

    public void yx() {
        if (this.ayg != null) {
            this.ayg.sendMessage(this.ayg.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0100a c0100a = new C0100a(byteBuffer, i, j);
            if (this.ayg != null && this.ayi) {
                this.ayg.sendMessage(this.ayg.obtainMessage(1003, c0100a));
            }
        }
    }

    public void yy() {
        if (this.ayg != null && this.ayi) {
            this.ayi = false;
            this.ayg.sendMessage(this.ayg.obtainMessage(1004));
        }
    }

    public void yz() {
        if (this.ayg != null) {
            this.ayg.removeCallbacksAndMessages(null);
            this.ayg.sendMessage(this.ayg.obtainMessage(1005));
            this.ayg.sendMessage(this.ayg.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
                    a.this.yA();
                    return;
                case 1003:
                    C0100a c0100a = (C0100a) message.obj;
                    a.this.e(c0100a.ayj, c0100a.ayk, c0100a.ayl);
                    return;
                case 1004:
                    a.this.yB();
                    return;
                case 1005:
                    a.this.yC();
                    return;
                case 1006:
                    a.this.yD();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.a(dVar, this.axP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yA() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.yK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayh.yJ();
            this.ayh.yI();
            this.ayh = null;
            this.axP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD() {
        if (this.ayg != null) {
            this.ayg.removeCallbacksAndMessages(null);
            this.ayg = null;
        }
        if (this.ayf != null) {
            this.ayf.quit();
            this.ayf = null;
        }
    }

    /* renamed from: com.baidu.mario.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0100a {
        ByteBuffer ayj;
        int ayk;
        long ayl;

        public C0100a(ByteBuffer byteBuffer, int i, long j) {
            this.ayj = byteBuffer;
            this.ayk = i;
            this.ayl = j;
        }
    }
}
