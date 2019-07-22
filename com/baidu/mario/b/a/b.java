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
import com.baidu.mario.b.b.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private volatile boolean aeK = false;
    private HandlerThread aeP;
    private Handler aeQ;
    private com.baidu.mario.gldraw2d.a aeR;
    private g aeS;
    private e aer;

    private void a(e eVar, c cVar) {
        this.aeP = new HandlerThread("VideoRecorderThread");
        this.aeP.start();
        this.aeQ = new HandlerC0061b(this.aeP.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS = new g();
            this.aeS.a(cVar);
            this.aer = eVar;
        }
    }

    public long tm() {
        if (this.aeS != null) {
            return this.aeS.tm();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aeP != null && this.aeP.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aeQ.sendMessage(this.aeQ.obtainMessage(1001, new a(arrayList, dVar)));
        this.aeK = true;
        return true;
    }

    public void tE() {
        if (this.aeQ != null) {
            this.aeQ.sendMessage(this.aeQ.obtainMessage(1002));
        }
    }

    public void g(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aeQ != null) {
            this.aeQ.sendMessage(this.aeQ.obtainMessage(1003, arrayList));
        }
    }

    public void t(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aeQ != null && this.aeK) {
            this.aeQ.sendMessage(this.aeQ.obtainMessage(1005, i, i2));
        }
    }

    public void tK() {
        if (this.aeQ != null && this.aeK) {
            this.aeQ.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aeQ != null && this.aeK) {
            this.aeK = false;
            this.aeQ.removeMessages(1005);
            this.aeQ.sendMessage(this.aeQ.obtainMessage(PointerIconCompat.TYPE_CELL));
        }
    }

    public void tF() {
        if (this.aeQ != null) {
            this.aeQ.removeCallbacksAndMessages(null);
            this.aeQ.sendMessage(this.aeQ.obtainMessage(PointerIconCompat.TYPE_CROSSHAIR));
            this.aeQ.sendMessage(this.aeQ.obtainMessage(PointerIconCompat.TYPE_TEXT));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0061b extends Handler {
        public HandlerC0061b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.aeA, aVar.aea);
                    return;
                case 1002:
                    b.this.tG();
                    return;
                case 1003:
                    b.this.h((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    b.this.tL();
                    return;
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    b.this.tM();
                    return;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                    b.this.handleQuit();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS.a(dVar, this.aer);
            if (this.aeR == null) {
                this.aeR = new com.baidu.mario.gldraw2d.a(this.aeS.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS.tQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeR.n(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeR.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS.aO(false);
            this.aeR.t(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS.aO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeS.tP();
            this.aeS.tO();
            this.aeS = null;
            this.aer = null;
            this.aeR.sy();
            this.aeR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aeQ != null) {
            this.aeQ.removeCallbacksAndMessages(null);
            this.aeQ = null;
        }
        if (this.aeP != null) {
            this.aeP.quit();
            this.aeP = null;
        }
    }

    /* loaded from: classes2.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> aeA;
        d aea;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aeA = arrayList;
            this.aea = dVar;
        }
    }
}
