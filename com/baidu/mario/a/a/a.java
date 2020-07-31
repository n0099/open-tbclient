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
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread btF;
    private Handler btG;
    private com.baidu.mario.a.b.a btH;
    private volatile boolean btI = false;
    private e btp;

    private void a(e eVar, c cVar) {
        this.btF = new HandlerThread("AudioRecorderThread");
        this.btF.start();
        this.btG = new b(this.btF.getLooper());
        try {
            this.btH = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.btH == null) {
                return;
            }
        }
        this.btp = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.btH.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.btF != null && this.btF.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.btG.sendMessage(this.btG.obtainMessage(1001, dVar));
        this.btI = true;
        return true;
    }

    public void startRecording() {
        if (this.btG != null) {
            this.btG.sendMessage(this.btG.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0210a c0210a = new C0210a(byteBuffer, i, j);
            if (this.btG != null && this.btI) {
                this.btG.sendMessage(this.btG.obtainMessage(1003, c0210a));
            }
        }
    }

    public void stopRecording() {
        if (this.btG != null && this.btI) {
            this.btI = false;
            this.btG.sendMessage(this.btG.obtainMessage(1004));
        }
    }

    public void Mw() {
        if (this.btG != null) {
            this.btG.removeCallbacksAndMessages(null);
            this.btG.sendMessage(this.btG.obtainMessage(1005));
            this.btG.sendMessage(this.btG.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
                    a.this.Mx();
                    return;
                case 1003:
                    C0210a c0210a = (C0210a) message.obj;
                    a.this.e(c0210a.btJ, c0210a.btK, c0210a.btL);
                    return;
                case 1004:
                    a.this.My();
                    return;
                case 1005:
                    a.this.Mz();
                    return;
                case 1006:
                    a.this.MA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.btH != null) {
            this.btH.a(dVar, this.btp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btH.MI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btH.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        if (Build.VERSION.SDK_INT >= 18 && this.btH != null) {
            this.btH.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mz() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.btH != null) {
                this.btH.MH();
                this.btH.MG();
            }
            this.btH = null;
            this.btp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MA() {
        if (this.btG != null) {
            this.btG.removeCallbacksAndMessages(null);
            this.btG = null;
        }
        if (this.btF != null) {
            this.btF.quit();
            this.btF = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0210a {
        ByteBuffer btJ;
        int btK;
        long btL;

        public C0210a(ByteBuffer byteBuffer, int i, long j) {
            this.btJ = byteBuffer;
            this.btK = i;
            this.btL = j;
        }
    }
}
