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
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread bXG;
    private Handler bXH;
    private com.baidu.mario.gldraw2d.a bXI;
    private g bXJ;
    private e bXi;
    private volatile boolean bXB = false;
    private boolean bXK = false;

    private void a(e eVar, c cVar) {
        this.bXG = new HandlerThread("VideoRecorderThread");
        this.bXG.start();
        this.bXH = new HandlerC0260b(this.bXG.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bXJ = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bXJ == null) {
                    return;
                }
            }
            this.bXJ.a(cVar);
            this.bXi = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bXK = true;
        } else {
            this.bXK = false;
        }
    }

    public long Zi() {
        if (this.bXJ != null) {
            return this.bXJ.Zi();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bXG != null && this.bXG.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bXH.sendMessage(this.bXH.obtainMessage(1001, new a(arrayList, dVar)));
        this.bXB = true;
        return true;
    }

    public void startRecording() {
        if (this.bXH != null) {
            this.bXH.sendMessage(this.bXH.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bXH != null) {
            this.bXH.sendMessage(this.bXH.obtainMessage(1003, arrayList));
        }
    }

    public void bf(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bXH != null && this.bXB) {
            this.bXH.sendMessage(this.bXH.obtainMessage(1005, i, i2));
            synchronized (this.bXI) {
                try {
                    if (this.bXK) {
                        this.bXI.wait(12L);
                    } else {
                        this.bXI.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void ZD() {
        if (this.bXH != null && this.bXB) {
            this.bXH.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bXH != null && this.bXB) {
            this.bXB = false;
            this.bXH.removeMessages(1005);
            this.bXH.sendMessage(this.bXH.obtainMessage(1006));
        }
    }

    public void Zy() {
        if (this.bXH != null) {
            this.bXH.removeCallbacksAndMessages(null);
            this.bXH.sendMessage(this.bXH.obtainMessage(1007));
            this.bXH.sendMessage(this.bXH.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0260b extends Handler {
        public HandlerC0260b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bXr, aVar.bWJ);
                    return;
                case 1002:
                    b.this.Zz();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bj((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.ZE();
                    return;
                case 1007:
                    b.this.ZF();
                    return;
                case 1008:
                    b.this.ZG();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bXJ != null) {
            this.bXJ.a(dVar, this.bXi);
            if (this.bXI == null) {
                this.bXI = new com.baidu.mario.gldraw2d.a(this.bXJ.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        if (Build.VERSION.SDK_INT >= 18 && this.bXJ != null) {
            this.bXJ.ZK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXI.at(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXI.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bXJ != null) {
            this.bXJ.dy(false);
            this.bXI.bf(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZE() {
        if (Build.VERSION.SDK_INT >= 18 && this.bXJ != null) {
            this.bXJ.dy(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZF() {
        if (Build.VERSION.SDK_INT >= 18 && this.bXJ != null) {
            this.bXJ.ZJ();
            this.bXJ.ZI();
            this.bXJ = null;
            this.bXi = null;
            this.bXI.Yu();
            this.bXI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        if (this.bXH != null) {
            this.bXH.removeCallbacksAndMessages(null);
            this.bXH = null;
        }
        if (this.bXG != null) {
            this.bXG.quit();
            this.bXG = null;
        }
    }

    /* loaded from: classes5.dex */
    class a {
        d bWJ;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bXr;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bXr = arrayList;
            this.bWJ = dVar;
        }
    }
}
