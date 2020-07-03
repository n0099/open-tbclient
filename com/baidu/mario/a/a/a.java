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
    private e bsT;
    private HandlerThread btj;
    private Handler btk;
    private com.baidu.mario.a.b.a btl;
    private volatile boolean btm = false;

    private void a(e eVar, c cVar) {
        this.btj = new HandlerThread("AudioRecorderThread");
        this.btj.start();
        this.btk = new b(this.btj.getLooper());
        try {
            this.btl = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.btl == null) {
                return;
            }
        }
        this.bsT = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.btl.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.btj != null && this.btj.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.btk.sendMessage(this.btk.obtainMessage(1001, dVar));
        this.btm = true;
        return true;
    }

    public void startRecording() {
        if (this.btk != null) {
            this.btk.sendMessage(this.btk.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0208a c0208a = new C0208a(byteBuffer, i, j);
            if (this.btk != null && this.btm) {
                this.btk.sendMessage(this.btk.obtainMessage(1003, c0208a));
            }
        }
    }

    public void stopRecording() {
        if (this.btk != null && this.btm) {
            this.btm = false;
            this.btk.sendMessage(this.btk.obtainMessage(1004));
        }
    }

    public void Mp() {
        if (this.btk != null) {
            this.btk.removeCallbacksAndMessages(null);
            this.btk.sendMessage(this.btk.obtainMessage(1005));
            this.btk.sendMessage(this.btk.obtainMessage(1006));
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
                    a.this.Mq();
                    return;
                case 1003:
                    C0208a c0208a = (C0208a) message.obj;
                    a.this.e(c0208a.btn, c0208a.bto, c0208a.btp);
                    return;
                case 1004:
                    a.this.Mr();
                    return;
                case 1005:
                    a.this.Ms();
                    return;
                case 1006:
                    a.this.Mt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.btl != null) {
            this.btl.a(dVar, this.bsT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btl.MB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btl.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        if (Build.VERSION.SDK_INT >= 18 && this.btl != null) {
            this.btl.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ms() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.btl != null) {
                this.btl.MA();
                this.btl.Mz();
            }
            this.btl = null;
            this.bsT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mt() {
        if (this.btk != null) {
            this.btk.removeCallbacksAndMessages(null);
            this.btk = null;
        }
        if (this.btj != null) {
            this.btj.quit();
            this.btj = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0208a {
        ByteBuffer btn;
        int bto;
        long btp;

        public C0208a(ByteBuffer byteBuffer, int i, long j) {
            this.btn = byteBuffer;
            this.bto = i;
            this.btp = j;
        }
    }
}
