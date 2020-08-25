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
    private e bzb;
    private HandlerThread bzr;
    private Handler bzs;
    private com.baidu.mario.a.b.a bzt;
    private volatile boolean bzu = false;

    private void a(e eVar, c cVar) {
        this.bzr = new HandlerThread("AudioRecorderThread");
        this.bzr.start();
        this.bzs = new b(this.bzr.getLooper());
        try {
            this.bzt = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bzt == null) {
                return;
            }
        }
        this.bzb = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzt.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bzr != null && this.bzr.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bzs.sendMessage(this.bzs.obtainMessage(1001, dVar));
        this.bzu = true;
        return true;
    }

    public void startRecording() {
        if (this.bzs != null) {
            this.bzs.sendMessage(this.bzs.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0219a c0219a = new C0219a(byteBuffer, i, j);
            if (this.bzs != null && this.bzu) {
                this.bzs.sendMessage(this.bzs.obtainMessage(1003, c0219a));
            }
        }
    }

    public void stopRecording() {
        if (this.bzs != null && this.bzu) {
            this.bzu = false;
            this.bzs.sendMessage(this.bzs.obtainMessage(1004));
        }
    }

    public void Sv() {
        if (this.bzs != null) {
            this.bzs.removeCallbacksAndMessages(null);
            this.bzs.sendMessage(this.bzs.obtainMessage(1005));
            this.bzs.sendMessage(this.bzs.obtainMessage(1006));
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
                    a.this.e(c0219a.bzv, c0219a.bzw, c0219a.bzx);
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
        if (Build.VERSION.SDK_INT >= 18 && this.bzt != null) {
            this.bzt.a(dVar, this.bzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzt.SH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzt.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzt != null) {
            this.bzt.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sy() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bzt != null) {
                this.bzt.SG();
                this.bzt.SF();
            }
            this.bzt = null;
            this.bzb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sz() {
        if (this.bzs != null) {
            this.bzs.removeCallbacksAndMessages(null);
            this.bzs = null;
        }
        if (this.bzr != null) {
            this.bzr.quit();
            this.bzr = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0219a {
        ByteBuffer bzv;
        int bzw;
        long bzx;

        public C0219a(ByteBuffer byteBuffer, int i, long j) {
            this.bzv = byteBuffer;
            this.bzw = i;
            this.bzx = j;
        }
    }
}
