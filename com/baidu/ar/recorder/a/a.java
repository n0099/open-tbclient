package com.baidu.ar.recorder.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread sJ;
    private Handler sK;
    private com.baidu.ar.recorder.b.a sL;
    private volatile boolean si = false;
    private d sv;

    /* renamed from: com.baidu.ar.recorder.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0083a {
        ByteBuffer sM;
        int sN;
        long sO;

        public C0083a(ByteBuffer byteBuffer, int i, long j) {
            this.sM = byteBuffer;
            this.sN = i;
            this.sO = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a.this.a((EncoderParams) message.obj);
                    return;
                case 1002:
                    a.this.eh();
                    return;
                case 1003:
                    C0083a c0083a = (C0083a) message.obj;
                    a.this.b(c0083a.sM, c0083a.sN, c0083a.sO);
                    return;
                case 1004:
                    a.this.ei();
                    return;
                case 1005:
                    a.this.ej();
                    return;
                case 1006:
                    a.this.ek();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EncoderParams encoderParams) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.a(encoderParams, this.sv);
        }
    }

    private void a(d dVar, c cVar) {
        this.sJ = new HandlerThread("AudioRecorderThread");
        this.sJ.start();
        this.sK = new b(this.sJ.getLooper());
        this.sL = new com.baidu.ar.recorder.b.a();
        this.sv = dVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.a(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.eq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.a(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sL.ep();
            this.sL.eo();
            this.sL = null;
            this.sv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek() {
        if (this.sK != null) {
            this.sK.removeCallbacksAndMessages(null);
            this.sK = null;
        }
        if (this.sJ != null) {
            this.sJ.quit();
            this.sJ = null;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0083a c0083a = new C0083a(byteBuffer, i, j);
        if (this.sK == null || !this.si) {
            return;
        }
        this.sK.sendMessage(this.sK.obtainMessage(1003, c0083a));
    }

    public boolean a(EncoderParams encoderParams, d dVar, c cVar) {
        if (isRunning()) {
            com.baidu.ar.f.b.b(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(dVar, cVar);
        this.sK.sendMessage(this.sK.obtainMessage(1001, encoderParams));
        this.si = true;
        return true;
    }

    public void eg() {
        if (this.sK != null) {
            this.sK.removeCallbacksAndMessages(null);
            this.sK.sendMessage(this.sK.obtainMessage(1005));
            this.sK.sendMessage(this.sK.obtainMessage(1006));
        }
    }

    public boolean isRunning() {
        return this.sJ != null && this.sJ.isAlive();
    }

    public void startRecording() {
        if (this.sK != null) {
            this.sK.sendMessage(this.sK.obtainMessage(1002));
        }
    }

    public void stopRecording() {
        if (this.sK == null || !this.si) {
            return;
        }
        this.si = false;
        this.sK.sendMessage(this.sK.obtainMessage(1004));
    }
}
