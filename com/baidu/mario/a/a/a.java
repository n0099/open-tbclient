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
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e bJd;
    private HandlerThread bJt;
    private Handler bJu;
    private com.baidu.mario.a.b.a bJv;
    private volatile boolean bJw = false;

    private void a(e eVar, c cVar) {
        this.bJt = new HandlerThread("AudioRecorderThread");
        this.bJt.start();
        this.bJu = new b(this.bJt.getLooper());
        try {
            this.bJv = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.bJv == null) {
                return;
            }
        }
        this.bJd = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJv.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.bJt != null && this.bJt.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bJu.sendMessage(this.bJu.obtainMessage(1001, dVar));
        this.bJw = true;
        return true;
    }

    public void startRecording() {
        if (this.bJu != null) {
            this.bJu.sendMessage(this.bJu.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0233a c0233a = new C0233a(byteBuffer, i, j);
            if (this.bJu != null && this.bJw) {
                this.bJu.sendMessage(this.bJu.obtainMessage(1003, c0233a));
            }
        }
    }

    public void stopRecording() {
        if (this.bJu != null && this.bJw) {
            this.bJw = false;
            this.bJu.sendMessage(this.bJu.obtainMessage(1004));
        }
    }

    public void Vf() {
        if (this.bJu != null) {
            this.bJu.removeCallbacksAndMessages(null);
            this.bJu.sendMessage(this.bJu.obtainMessage(1005));
            this.bJu.sendMessage(this.bJu.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
                    a.this.Vg();
                    return;
                case 1003:
                    C0233a c0233a = (C0233a) message.obj;
                    a.this.e(c0233a.bJx, c0233a.bJy, c0233a.bJz);
                    return;
                case 1004:
                    a.this.Vh();
                    return;
                case 1005:
                    a.this.Vi();
                    return;
                case 1006:
                    a.this.Vj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bJv != null) {
            this.bJv.a(dVar, this.bJd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vg() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJv.Vr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJv.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        if (Build.VERSION.SDK_INT >= 18 && this.bJv != null) {
            this.bJv.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.bJv != null) {
                this.bJv.Vq();
                this.bJv.Vp();
            }
            this.bJv = null;
            this.bJd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        if (this.bJu != null) {
            this.bJu.removeCallbacksAndMessages(null);
            this.bJu = null;
        }
        if (this.bJt != null) {
            this.bJt.quit();
            this.bJt = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0233a {
        ByteBuffer bJx;
        int bJy;
        long bJz;

        public C0233a(ByteBuffer byteBuffer, int i, long j) {
            this.bJx = byteBuffer;
            this.bJy = i;
            this.bJz = j;
        }
    }
}
