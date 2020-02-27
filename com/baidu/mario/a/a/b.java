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
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread aKE;
    private Handler aKF;
    private com.baidu.mario.gldraw2d.a aKG;
    private g aKH;
    private e aKg;
    private volatile boolean aKz = false;
    private boolean aKI = false;

    private void a(e eVar, c cVar) {
        this.aKE = new HandlerThread("VideoRecorderThread");
        this.aKE.start();
        this.aKF = new HandlerC0124b(this.aKE.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aKH = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aKH == null) {
                    return;
                }
            }
            this.aKH.a(cVar);
            this.aKg = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aKI = true;
        } else {
            this.aKI = false;
        }
    }

    public long CK() {
        if (this.aKH != null) {
            return this.aKH.CK();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aKE != null && this.aKE.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKF.sendMessage(this.aKF.obtainMessage(1001, new a(arrayList, dVar)));
        this.aKz = true;
        return true;
    }

    public void Db() {
        if (this.aKF != null) {
            this.aKF.sendMessage(this.aKF.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aKF != null) {
            this.aKF.sendMessage(this.aKF.obtainMessage(1003, arrayList));
        }
    }

    public void T(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aKF != null && this.aKz) {
            this.aKF.sendMessage(this.aKF.obtainMessage(1005, i, i2));
            synchronized (this.aKG) {
                try {
                    if (this.aKI) {
                        this.aKG.wait(12L);
                    } else {
                        this.aKG.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Dg() {
        if (this.aKF != null && this.aKz) {
            this.aKF.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aKF != null && this.aKz) {
            this.aKz = false;
            this.aKF.removeMessages(1005);
            this.aKF.sendMessage(this.aKF.obtainMessage(1006));
        }
    }

    public void Dc() {
        if (this.aKF != null) {
            this.aKF.removeCallbacksAndMessages(null);
            this.aKF.sendMessage(this.aKF.obtainMessage(1007));
            this.aKF.sendMessage(this.aKF.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class HandlerC0124b extends Handler {
        public HandlerC0124b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.aKp, aVar.aJI);
                    return;
                case 1002:
                    b.this.Dd();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.Y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Dh();
                    return;
                case 1007:
                    b.this.Di();
                    return;
                case 1008:
                    b.this.handleQuit();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKH != null) {
            this.aKH.a(dVar, this.aKg);
            if (this.aKG == null) {
                this.aKG = new com.baidu.mario.gldraw2d.a(this.aKH.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dd() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKH != null) {
            this.aKH.Dl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKG.J(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKG.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKH != null) {
            this.aKH.bI(false);
            this.aKG.T(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKH != null) {
            this.aKH.bI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKH != null) {
            this.aKH.Dk();
            this.aKH.releaseEncoder();
            this.aKH = null;
            this.aKg = null;
            this.aKG.BW();
            this.aKG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aKF != null) {
            this.aKF.removeCallbacksAndMessages(null);
            this.aKF = null;
        }
        if (this.aKE != null) {
            this.aKE.quit();
            this.aKE = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d aJI;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aKp;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aKp = arrayList;
            this.aJI = dVar;
        }
    }
}
