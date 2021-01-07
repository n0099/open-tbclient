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
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread chV;
    private Handler chW;
    private com.baidu.mario.gldraw2d.a chX;
    private g chY;
    private e chx;
    private volatile boolean chQ = false;
    private boolean chZ = false;

    private void a(e eVar, c cVar) {
        this.chV = new HandlerThread("VideoRecorderThread");
        this.chV.start();
        this.chW = new HandlerC0267b(this.chV.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.chY = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.chY == null) {
                    return;
                }
            }
            this.chY.a(cVar);
            this.chx = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.chZ = true;
        } else {
            this.chZ = false;
        }
    }

    public long acO() {
        if (this.chY != null) {
            return this.chY.acO();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.chV != null && this.chV.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.chW.sendMessage(this.chW.obtainMessage(1001, new a(arrayList, dVar)));
        this.chQ = true;
        return true;
    }

    public void startRecording() {
        if (this.chW != null) {
            this.chW.sendMessage(this.chW.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.chW != null) {
            this.chW.sendMessage(this.chW.obtainMessage(1003, arrayList));
        }
    }

    public void bD(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.chW != null && this.chQ) {
            this.chW.sendMessage(this.chW.obtainMessage(1005, i, i2));
            synchronized (this.chX) {
                try {
                    if (this.chZ) {
                        this.chX.wait(12L);
                    } else {
                        this.chX.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void adj() {
        if (this.chW != null && this.chQ) {
            this.chW.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.chW != null && this.chQ) {
            this.chQ = false;
            this.chW.removeMessages(1005);
            this.chW.sendMessage(this.chW.obtainMessage(1006));
        }
    }

    public void ade() {
        if (this.chW != null) {
            this.chW.removeCallbacksAndMessages(null);
            this.chW.sendMessage(this.chW.obtainMessage(1007));
            this.chW.sendMessage(this.chW.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0267b extends Handler {
        public HandlerC0267b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.chG, aVar.cgY);
                    return;
                case 1002:
                    b.this.adf();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bH((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.adk();
                    return;
                case 1007:
                    b.this.adl();
                    return;
                case 1008:
                    b.this.adm();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.chY != null) {
            this.chY.a(dVar, this.chx);
            if (this.chX == null) {
                this.chX = new com.baidu.mario.gldraw2d.a(this.chY.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adf() {
        if (Build.VERSION.SDK_INT >= 18 && this.chY != null) {
            this.chY.adq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chX.aA(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chX.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.chY != null) {
            this.chY.dV(false);
            this.chX.bD(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adk() {
        if (Build.VERSION.SDK_INT >= 18 && this.chY != null) {
            this.chY.dV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adl() {
        if (Build.VERSION.SDK_INT >= 18 && this.chY != null) {
            this.chY.adp();
            this.chY.ado();
            this.chY = null;
            this.chx = null;
            this.chX.acc();
            this.chX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adm() {
        if (this.chW != null) {
            this.chW.removeCallbacksAndMessages(null);
            this.chW = null;
        }
        if (this.chV != null) {
            this.chV.quit();
            this.chV = null;
        }
    }

    /* loaded from: classes3.dex */
    class a {
        d cgY;
        ArrayList<com.baidu.mario.gldraw2d.params.c> chG;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.chG = arrayList;
            this.cgY = dVar;
        }
    }
}
