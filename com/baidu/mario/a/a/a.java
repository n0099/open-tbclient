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
/* loaded from: classes14.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e ccJ;
    private HandlerThread ccZ;
    private Handler cda;
    private com.baidu.mario.a.b.a cdb;
    private volatile boolean cdc = false;

    private void a(e eVar, c cVar) {
        this.ccZ = new HandlerThread("AudioRecorderThread");
        this.ccZ.start();
        this.cda = new b(this.ccZ.getLooper());
        try {
            this.cdb = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.cdb == null) {
                return;
            }
        }
        this.ccJ = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.cdb.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.ccZ != null && this.ccZ.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.cda.sendMessage(this.cda.obtainMessage(1001, dVar));
        this.cdc = true;
        return true;
    }

    public void startRecording() {
        if (this.cda != null) {
            this.cda.sendMessage(this.cda.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0255a c0255a = new C0255a(byteBuffer, i, j);
            if (this.cda != null && this.cdc) {
                this.cda.sendMessage(this.cda.obtainMessage(1003, c0255a));
            }
        }
    }

    public void stopRecording() {
        if (this.cda != null && this.cdc) {
            this.cdc = false;
            this.cda.sendMessage(this.cda.obtainMessage(1004));
        }
    }

    public void Zl() {
        if (this.cda != null) {
            this.cda.removeCallbacksAndMessages(null);
            this.cda.sendMessage(this.cda.obtainMessage(1005));
            this.cda.sendMessage(this.cda.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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
                    a.this.Zm();
                    return;
                case 1003:
                    C0255a c0255a = (C0255a) message.obj;
                    a.this.e(c0255a.cdd, c0255a.cde, c0255a.cdf);
                    return;
                case 1004:
                    a.this.Zn();
                    return;
                case 1005:
                    a.this.Zo();
                    return;
                case 1006:
                    a.this.Zp();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.cdb != null) {
            this.cdb.a(dVar, this.ccJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cdb.Zx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cdb.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zn() {
        if (Build.VERSION.SDK_INT >= 18 && this.cdb != null) {
            this.cdb.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zo() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.cdb != null) {
                this.cdb.Zw();
                this.cdb.Zv();
            }
            this.cdb = null;
            this.ccJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zp() {
        if (this.cda != null) {
            this.cda.removeCallbacksAndMessages(null);
            this.cda = null;
        }
        if (this.ccZ != null) {
            this.ccZ.quit();
            this.ccZ = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private class C0255a {
        ByteBuffer cdd;
        int cde;
        long cdf;

        public C0255a(ByteBuffer byteBuffer, int i, long j) {
            this.cdd = byteBuffer;
            this.cde = i;
            this.cdf = j;
        }
    }
}
