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
import com.baidu.mario.a.b.g;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread btN;
    private Handler btO;
    private com.baidu.mario.gldraw2d.a btP;
    private g btQ;
    private e btp;
    private volatile boolean btI = false;
    private boolean btR = false;

    private void a(e eVar, c cVar) {
        this.btN = new HandlerThread("VideoRecorderThread");
        this.btN.start();
        this.btO = new HandlerC0211b(this.btN.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.btQ = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.btQ == null) {
                    return;
                }
            }
            this.btQ.a(cVar);
            this.btp = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.btR = true;
        } else {
            this.btR = false;
        }
    }

    public long Mg() {
        if (this.btQ != null) {
            return this.btQ.Mg();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.btN != null && this.btN.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.btO.sendMessage(this.btO.obtainMessage(1001, new a(arrayList, dVar)));
        this.btI = true;
        return true;
    }

    public void startRecording() {
        if (this.btO != null) {
            this.btO.sendMessage(this.btO.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.btO != null) {
            this.btO.sendMessage(this.btO.obtainMessage(1003, arrayList));
        }
    }

    public void aE(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.btO != null && this.btI) {
            this.btO.sendMessage(this.btO.obtainMessage(1005, i, i2));
            synchronized (this.btP) {
                try {
                    if (this.btR) {
                        this.btP.wait(12L);
                    } else {
                        this.btP.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void MB() {
        if (this.btO != null && this.btI) {
            this.btO.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.btO != null && this.btI) {
            this.btI = false;
            this.btO.removeMessages(1005);
            this.btO.sendMessage(this.btO.obtainMessage(1006));
        }
    }

    public void Mw() {
        if (this.btO != null) {
            this.btO.removeCallbacksAndMessages(null);
            this.btO.sendMessage(this.btO.obtainMessage(1007));
            this.btO.sendMessage(this.btO.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class HandlerC0211b extends Handler {
        public HandlerC0211b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bty, aVar.bsP);
                    return;
                case 1002:
                    b.this.Mx();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aI((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.MC();
                    return;
                case 1007:
                    b.this.MD();
                    return;
                case 1008:
                    b.this.ME();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.btQ != null) {
            this.btQ.a(dVar, this.btp);
            if (this.btP == null) {
                this.btP = new com.baidu.mario.gldraw2d.a(this.btQ.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx() {
        if (Build.VERSION.SDK_INT >= 18 && this.btQ != null) {
            this.btQ.MI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btP.U(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btP.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.btQ != null) {
            this.btQ.cM(false);
            this.btP.aE(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC() {
        if (Build.VERSION.SDK_INT >= 18 && this.btQ != null) {
            this.btQ.cM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        if (Build.VERSION.SDK_INT >= 18 && this.btQ != null) {
            this.btQ.MH();
            this.btQ.MG();
            this.btQ = null;
            this.btp = null;
            this.btP.Lr();
            this.btP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ME() {
        if (this.btO != null) {
            this.btO.removeCallbacksAndMessages(null);
            this.btO = null;
        }
        if (this.btN != null) {
            this.btN.quit();
            this.btN = null;
        }
    }

    /* loaded from: classes10.dex */
    class a {
        d bsP;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bty;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bty = arrayList;
            this.bsP = dVar;
        }
    }
}
