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
    private e bnT;
    private HandlerThread boj;
    private Handler bok;
    private com.baidu.mario.a.b.a bol;
    private volatile boolean bom = false;

    private void a(e eVar, c cVar) {
        this.boj = new HandlerThread("AudioRecorderThread");
        this.boj.start();
        this.bok = new b(this.boj.getLooper());
        try {
            this.bol = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bol == null) {
                return;
            }
        }
        this.bnT = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bol.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.boj != null && this.boj.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bok.sendMessage(this.bok.obtainMessage(1001, dVar));
        this.bom = true;
        return true;
    }

    public void startRecording() {
        if (this.bok != null) {
            this.bok.sendMessage(this.bok.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0202a c0202a = new C0202a(byteBuffer, i, j);
            if (this.bok != null && this.bom) {
                this.bok.sendMessage(this.bok.obtainMessage(1003, c0202a));
            }
        }
    }

    public void stopRecording() {
        if (this.bok != null && this.bom) {
            this.bom = false;
            this.bok.sendMessage(this.bok.obtainMessage(1004));
        }
    }

    public void Lg() {
        if (this.bok != null) {
            this.bok.removeCallbacksAndMessages(null);
            this.bok.sendMessage(this.bok.obtainMessage(1005));
            this.bok.sendMessage(this.bok.obtainMessage(1006));
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
                    a.this.Lh();
                    return;
                case 1003:
                    C0202a c0202a = (C0202a) message.obj;
                    a.this.e(c0202a.bon, c0202a.boo, c0202a.bop);
                    return;
                case 1004:
                    a.this.Li();
                    return;
                case 1005:
                    a.this.Lj();
                    return;
                case 1006:
                    a.this.Lk();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bol != null) {
            this.bol.a(dVar, this.bnT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bol.Ls();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bol.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        if (Build.VERSION.SDK_INT >= 18 && this.bol != null) {
            this.bol.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bol != null) {
                this.bol.Lr();
                this.bol.Lq();
            }
            this.bol = null;
            this.bnT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (this.bok != null) {
            this.bok.removeCallbacksAndMessages(null);
            this.bok = null;
        }
        if (this.boj != null) {
            this.boj.quit();
            this.boj = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0202a {
        ByteBuffer bon;
        int boo;
        long bop;

        public C0202a(ByteBuffer byteBuffer, int i, long j) {
            this.bon = byteBuffer;
            this.boo = i;
            this.bop = j;
        }
    }
}
