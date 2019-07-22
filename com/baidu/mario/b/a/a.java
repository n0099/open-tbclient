package com.baidu.mario.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.baidu.mario.b.b.c;
import com.baidu.mario.b.b.d;
import com.baidu.mario.b.b.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private HandlerThread aeH;
    private Handler aeI;
    private com.baidu.mario.b.b.a aeJ;
    private volatile boolean aeK = false;
    private e aer;

    private void a(e eVar, c cVar) {
        this.aeH = new HandlerThread("AudioRecorderThread");
        this.aeH.start();
        this.aeI = new b(this.aeH.getLooper());
        this.aeJ = new com.baidu.mario.b.b.a();
        this.aer = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aeH != null && this.aeH.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aeI.sendMessage(this.aeI.obtainMessage(1001, dVar));
        this.aeK = true;
        return true;
    }

    public void tE() {
        if (this.aeI != null) {
            this.aeI.sendMessage(this.aeI.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0060a c0060a = new C0060a(byteBuffer, i, j);
            if (this.aeI != null && this.aeK) {
                this.aeI.sendMessage(this.aeI.obtainMessage(1003, c0060a));
            }
        }
    }

    public void stopRecording() {
        if (this.aeI != null && this.aeK) {
            this.aeK = false;
            this.aeI.sendMessage(this.aeI.obtainMessage(1004));
        }
    }

    public void tF() {
        if (this.aeI != null) {
            this.aeI.removeCallbacksAndMessages(null);
            this.aeI.sendMessage(this.aeI.obtainMessage(1005));
            this.aeI.sendMessage(this.aeI.obtainMessage(PointerIconCompat.TYPE_CELL));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
                    a.this.tG();
                    return;
                case 1003:
                    C0060a c0060a = (C0060a) message.obj;
                    a.this.e(c0060a.aeL, c0060a.aeM, c0060a.aeN);
                    return;
                case 1004:
                    a.this.tH();
                    return;
                case 1005:
                    a.this.tI();
                    return;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    a.this.tJ();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.a(dVar, this.aer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeJ.tP();
            this.aeJ.tO();
            this.aeJ = null;
            this.aer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        if (this.aeI != null) {
            this.aeI.removeCallbacksAndMessages(null);
            this.aeI = null;
        }
        if (this.aeH != null) {
            this.aeH.quit();
            this.aeH = null;
        }
    }

    /* renamed from: com.baidu.mario.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0060a {
        ByteBuffer aeL;
        int aeM;
        long aeN;

        public C0060a(ByteBuffer byteBuffer, int i, long j) {
            this.aeL = byteBuffer;
            this.aeM = i;
            this.aeN = j;
        }
    }
}
