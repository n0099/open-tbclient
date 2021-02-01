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
/* loaded from: classes15.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e cgT;
    private HandlerThread chj;
    private Handler chk;
    private com.baidu.mario.a.b.a chl;
    private volatile boolean chm = false;

    private void a(e eVar, c cVar) {
        this.chj = new HandlerThread("AudioRecorderThread");
        this.chj.start();
        this.chk = new b(this.chj.getLooper());
        try {
            this.chl = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.chl == null) {
                return;
            }
        }
        this.cgT = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.chl.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.chj != null && this.chj.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.chk.sendMessage(this.chk.obtainMessage(1001, dVar));
        this.chm = true;
        return true;
    }

    public void startRecording() {
        if (this.chk != null) {
            this.chk.sendMessage(this.chk.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0256a c0256a = new C0256a(byteBuffer, i, j);
            if (this.chk != null && this.chm) {
                this.chk.sendMessage(this.chk.obtainMessage(1003, c0256a));
            }
        }
    }

    public void stopRecording() {
        if (this.chk != null && this.chm) {
            this.chm = false;
            this.chk.sendMessage(this.chk.obtainMessage(1004));
        }
    }

    public void abe() {
        if (this.chk != null) {
            this.chk.removeCallbacksAndMessages(null);
            this.chk.sendMessage(this.chk.obtainMessage(1005));
            this.chk.sendMessage(this.chk.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
                    a.this.abf();
                    return;
                case 1003:
                    C0256a c0256a = (C0256a) message.obj;
                    a.this.e(c0256a.chn, c0256a.cho, c0256a.chp);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.abg();
                    return;
                case 1006:
                    a.this.abh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.chl != null) {
            this.chl.a(dVar, this.cgT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abf() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chl.startEncoder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chl.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.chl != null) {
            this.chl.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abg() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.chl != null) {
                this.chl.stopEncoder();
                this.chl.releaseEncoder();
            }
            this.chl = null;
            this.cgT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abh() {
        if (this.chk != null) {
            this.chk.removeCallbacksAndMessages(null);
            this.chk = null;
        }
        if (this.chj != null) {
            this.chj.quit();
            this.chj = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0256a {
        ByteBuffer chn;
        int cho;
        long chp;

        public C0256a(ByteBuffer byteBuffer, int i, long j) {
            this.chn = byteBuffer;
            this.cho = i;
            this.chp = j;
        }
    }
}
