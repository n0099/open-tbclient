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
    private HandlerThread axN;
    private Handler axO;
    private com.baidu.mario.b.b.a axP;
    private volatile boolean axQ = false;
    private e axx;

    private void a(e eVar, c cVar) {
        this.axN = new HandlerThread("AudioRecorderThread");
        this.axN.start();
        this.axO = new b(this.axN.getLooper());
        this.axP = new com.baidu.mario.b.b.a();
        this.axx = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.axN != null && this.axN.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.axO.sendMessage(this.axO.obtainMessage(1001, dVar));
        this.axQ = true;
        return true;
    }

    public void yy() {
        if (this.axO != null) {
            this.axO.sendMessage(this.axO.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0100a c0100a = new C0100a(byteBuffer, i, j);
            if (this.axO != null && this.axQ) {
                this.axO.sendMessage(this.axO.obtainMessage(1003, c0100a));
            }
        }
    }

    public void yz() {
        if (this.axO != null && this.axQ) {
            this.axQ = false;
            this.axO.sendMessage(this.axO.obtainMessage(1004));
        }
    }

    public void yA() {
        if (this.axO != null) {
            this.axO.removeCallbacksAndMessages(null);
            this.axO.sendMessage(this.axO.obtainMessage(1005));
            this.axO.sendMessage(this.axO.obtainMessage(1006));
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
                    a.this.yB();
                    return;
                case 1003:
                    C0100a c0100a = (C0100a) message.obj;
                    a.this.e(c0100a.axR, c0100a.axS, c0100a.axT);
                    return;
                case 1004:
                    a.this.yC();
                    return;
                case 1005:
                    a.this.yD();
                    return;
                case 1006:
                    a.this.yE();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.a(dVar, this.axx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.yL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP.yK();
            this.axP.yJ();
            this.axP = null;
            this.axx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE() {
        if (this.axO != null) {
            this.axO.removeCallbacksAndMessages(null);
            this.axO = null;
        }
        if (this.axN != null) {
            this.axN.quit();
            this.axN = null;
        }
    }

    /* renamed from: com.baidu.mario.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0100a {
        ByteBuffer axR;
        int axS;
        long axT;

        public C0100a(ByteBuffer byteBuffer, int i, long j) {
            this.axR = byteBuffer;
            this.axS = i;
            this.axT = j;
        }
    }
}
