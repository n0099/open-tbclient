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
/* loaded from: classes20.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e bze;
    private HandlerThread bzu;
    private Handler bzv;
    private com.baidu.mario.a.b.a bzw;
    private volatile boolean bzx = false;

    private void a(e eVar, c cVar) {
        this.bzu = new HandlerThread("AudioRecorderThread");
        this.bzu.start();
        this.bzv = new b(this.bzu.getLooper());
        try {
            this.bzw = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bzw == null) {
                return;
            }
        }
        this.bze = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzw.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bzu != null && this.bzu.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bzv.sendMessage(this.bzv.obtainMessage(1001, dVar));
        this.bzx = true;
        return true;
    }

    public void startRecording() {
        if (this.bzv != null) {
            this.bzv.sendMessage(this.bzv.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0219a c0219a = new C0219a(byteBuffer, i, j);
            if (this.bzv != null && this.bzx) {
                this.bzv.sendMessage(this.bzv.obtainMessage(1003, c0219a));
            }
        }
    }

    public void stopRecording() {
        if (this.bzv != null && this.bzx) {
            this.bzx = false;
            this.bzv.sendMessage(this.bzv.obtainMessage(1004));
        }
    }

    public void Sv() {
        if (this.bzv != null) {
            this.bzv.removeCallbacksAndMessages(null);
            this.bzv.sendMessage(this.bzv.obtainMessage(1005));
            this.bzv.sendMessage(this.bzv.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
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
                    a.this.Sw();
                    return;
                case 1003:
                    C0219a c0219a = (C0219a) message.obj;
                    a.this.e(c0219a.bzy, c0219a.bzz, c0219a.bzA);
                    return;
                case 1004:
                    a.this.Sx();
                    return;
                case 1005:
                    a.this.Sy();
                    return;
                case 1006:
                    a.this.Sz();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bzw != null) {
            this.bzw.a(dVar, this.bze);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzw.SH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzw.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzw != null) {
            this.bzw.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sy() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bzw != null) {
                this.bzw.SG();
                this.bzw.SF();
            }
            this.bzw = null;
            this.bze = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sz() {
        if (this.bzv != null) {
            this.bzv.removeCallbacksAndMessages(null);
            this.bzv = null;
        }
        if (this.bzu != null) {
            this.bzu.quit();
            this.bzu = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0219a {
        long bzA;
        ByteBuffer bzy;
        int bzz;

        public C0219a(ByteBuffer byteBuffer, int i, long j) {
            this.bzy = byteBuffer;
            this.bzz = i;
            this.bzA = j;
        }
    }
}
