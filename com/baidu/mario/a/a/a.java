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
    private HandlerThread ciK;
    private Handler ciL;
    private com.baidu.mario.a.b.a ciM;
    private volatile boolean ciN = false;
    private e ciu;

    private void a(e eVar, c cVar) {
        this.ciK = new HandlerThread("AudioRecorderThread");
        this.ciK.start();
        this.ciL = new b(this.ciK.getLooper());
        try {
            this.ciM = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.ciM == null) {
                return;
            }
        }
        this.ciu = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciM.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.ciK != null && this.ciK.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.ciL.sendMessage(this.ciL.obtainMessage(1001, dVar));
        this.ciN = true;
        return true;
    }

    public void startRecording() {
        if (this.ciL != null) {
            this.ciL.sendMessage(this.ciL.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0262a c0262a = new C0262a(byteBuffer, i, j);
            if (this.ciL != null && this.ciN) {
                this.ciL.sendMessage(this.ciL.obtainMessage(1003, c0262a));
            }
        }
    }

    public void stopRecording() {
        if (this.ciL != null && this.ciN) {
            this.ciN = false;
            this.ciL.sendMessage(this.ciL.obtainMessage(1004));
        }
    }

    public void abh() {
        if (this.ciL != null) {
            this.ciL.removeCallbacksAndMessages(null);
            this.ciL.sendMessage(this.ciL.obtainMessage(1005));
            this.ciL.sendMessage(this.ciL.obtainMessage(1006));
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
                    a.this.abi();
                    return;
                case 1003:
                    C0262a c0262a = (C0262a) message.obj;
                    a.this.e(c0262a.ciO, c0262a.ciP, c0262a.ciQ);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.abj();
                    return;
                case 1006:
                    a.this.abk();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.ciM != null) {
            this.ciM.a(dVar, this.ciu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciM.startEncoder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciM.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.ciM != null) {
            this.ciM.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abj() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.ciM != null) {
                this.ciM.stopEncoder();
                this.ciM.releaseEncoder();
            }
            this.ciM = null;
            this.ciu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        if (this.ciL != null) {
            this.ciL.removeCallbacksAndMessages(null);
            this.ciL = null;
        }
        if (this.ciK != null) {
            this.ciK.quit();
            this.ciK = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private class C0262a {
        ByteBuffer ciO;
        int ciP;
        long ciQ;

        public C0262a(ByteBuffer byteBuffer, int i, long j) {
            this.ciO = byteBuffer;
            this.ciP = i;
            this.ciQ = j;
        }
    }
}
