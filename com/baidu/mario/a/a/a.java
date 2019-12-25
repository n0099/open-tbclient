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
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private Handler aFA;
    private com.baidu.mario.a.b.a aFB;
    private volatile boolean aFC = false;
    private e aFi;
    private HandlerThread aFz;

    private void a(e eVar, c cVar) {
        this.aFz = new HandlerThread("AudioRecorderThread");
        this.aFz.start();
        this.aFA = new b(this.aFz.getLooper());
        try {
            this.aFB = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.aFB == null) {
                return;
            }
        }
        this.aFi = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFB.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aFz != null && this.aFz.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aFA.sendMessage(this.aFA.obtainMessage(1001, dVar));
        this.aFC = true;
        return true;
    }

    public void Ap() {
        if (this.aFA != null) {
            this.aFA.sendMessage(this.aFA.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0113a c0113a = new C0113a(byteBuffer, i, j);
            if (this.aFA != null && this.aFC) {
                this.aFA.sendMessage(this.aFA.obtainMessage(1003, c0113a));
            }
        }
    }

    public void stopRecording() {
        if (this.aFA != null && this.aFC) {
            this.aFC = false;
            this.aFA.sendMessage(this.aFA.obtainMessage(1004));
        }
    }

    public void Aq() {
        if (this.aFA != null) {
            this.aFA.removeCallbacksAndMessages(null);
            this.aFA.sendMessage(this.aFA.obtainMessage(1005));
            this.aFA.sendMessage(this.aFA.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
                    a.this.Ar();
                    return;
                case 1003:
                    C0113a c0113a = (C0113a) message.obj;
                    a.this.e(c0113a.aFD, c0113a.aFE, c0113a.aFF);
                    return;
                case 1004:
                    a.this.handleStopRecording();
                    return;
                case 1005:
                    a.this.As();
                    return;
                case 1006:
                    a.this.At();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aFB != null) {
            this.aFB.a(dVar, this.aFi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFB.Az();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFB.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRecording() {
        if (Build.VERSION.SDK_INT >= 18 && this.aFB != null) {
            this.aFB.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.aFB != null) {
                this.aFB.Ay();
                this.aFB.releaseEncoder();
            }
            this.aFB = null;
            this.aFi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At() {
        if (this.aFA != null) {
            this.aFA.removeCallbacksAndMessages(null);
            this.aFA = null;
        }
        if (this.aFz != null) {
            this.aFz.quit();
            this.aFz = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0113a {
        ByteBuffer aFD;
        int aFE;
        long aFF;

        public C0113a(ByteBuffer byteBuffer, int i, long j) {
            this.aFD = byteBuffer;
            this.aFE = i;
            this.aFF = j;
        }
    }
}
