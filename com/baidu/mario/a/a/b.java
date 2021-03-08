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
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread ciS;
    private Handler ciT;
    private com.baidu.mario.gldraw2d.a ciU;
    private g ciV;
    private e ciu;
    private volatile boolean ciN = false;
    private boolean ciW = false;

    private void a(e eVar, c cVar) {
        this.ciS = new HandlerThread("VideoRecorderThread");
        this.ciS.start();
        this.ciT = new HandlerC0263b(this.ciS.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.ciV = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.ciV == null) {
                    return;
                }
            }
            this.ciV.a(cVar);
            this.ciu = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.ciW = true;
        } else {
            this.ciW = false;
        }
    }

    public long aaR() {
        if (this.ciV != null) {
            return this.ciV.aaR();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.ciS != null && this.ciS.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.ciT.sendMessage(this.ciT.obtainMessage(1001, new a(arrayList, dVar)));
        this.ciN = true;
        return true;
    }

    public void startRecording() {
        if (this.ciT != null) {
            this.ciT.sendMessage(this.ciT.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.ciT != null) {
            this.ciT.sendMessage(this.ciT.obtainMessage(1003, arrayList));
        }
    }

    public void bH(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.ciT != null && this.ciN) {
            this.ciT.sendMessage(this.ciT.obtainMessage(1005, i, i2));
            synchronized (this.ciU) {
                try {
                    if (this.ciW) {
                        this.ciU.wait(12L);
                    } else {
                        this.ciU.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void abl() {
        if (this.ciT != null && this.ciN) {
            this.ciT.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.ciT != null && this.ciN) {
            this.ciN = false;
            this.ciT.removeMessages(1005);
            this.ciT.sendMessage(this.ciT.obtainMessage(1006));
        }
    }

    public void abh() {
        if (this.ciT != null) {
            this.ciT.removeCallbacksAndMessages(null);
            this.ciT.sendMessage(this.ciT.obtainMessage(1007));
            this.ciT.sendMessage(this.ciT.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class HandlerC0263b extends Handler {
        public HandlerC0263b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.ciD, aVar.chU);
                    return;
                case 1002:
                    b.this.abi();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bL((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.abm();
                    return;
                case 1007:
                    b.this.abn();
                    return;
                case 1008:
                    b.this.abo();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.ciV != null) {
            this.ciV.a(dVar, this.ciu);
            if (this.ciU == null) {
                this.ciU = new com.baidu.mario.gldraw2d.a(this.ciV.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        if (Build.VERSION.SDK_INT >= 18 && this.ciV != null) {
            this.ciV.startEncoder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciU.ax(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciU.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.ciV != null) {
            this.ciV.dZ(false);
            this.ciU.bH(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abm() {
        if (Build.VERSION.SDK_INT >= 18 && this.ciV != null) {
            this.ciV.dZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abn() {
        if (Build.VERSION.SDK_INT >= 18 && this.ciV != null) {
            this.ciV.stopEncoder();
            this.ciV.releaseEncoder();
            this.ciV = null;
            this.ciu = null;
            this.ciU.aag();
            this.ciU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abo() {
        if (this.ciT != null) {
            this.ciT.removeCallbacksAndMessages(null);
            this.ciT = null;
        }
        if (this.ciS != null) {
            this.ciS.quit();
            this.ciS = null;
        }
    }

    /* loaded from: classes14.dex */
    class a {
        d chU;
        ArrayList<com.baidu.mario.gldraw2d.params.c> ciD;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.ciD = arrayList;
            this.chU = dVar;
        }
    }
}
