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
    private HandlerThread aKF;
    private Handler aKG;
    private com.baidu.mario.gldraw2d.a aKH;
    private g aKI;
    private e aKh;
    private volatile boolean aKA = false;
    private boolean aKJ = false;

    private void a(e eVar, c cVar) {
        this.aKF = new HandlerThread("VideoRecorderThread");
        this.aKF.start();
        this.aKG = new HandlerC0124b(this.aKF.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aKI = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aKI == null) {
                    return;
                }
            }
            this.aKI.a(cVar);
            this.aKh = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aKJ = true;
        } else {
            this.aKJ = false;
        }
    }

    public long CM() {
        if (this.aKI != null) {
            return this.aKI.CM();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aKF != null && this.aKF.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKG.sendMessage(this.aKG.obtainMessage(1001, new a(arrayList, dVar)));
        this.aKA = true;
        return true;
    }

    public void Dd() {
        if (this.aKG != null) {
            this.aKG.sendMessage(this.aKG.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aKG != null) {
            this.aKG.sendMessage(this.aKG.obtainMessage(1003, arrayList));
        }
    }

    public void T(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aKG != null && this.aKA) {
            this.aKG.sendMessage(this.aKG.obtainMessage(1005, i, i2));
            synchronized (this.aKH) {
                try {
                    if (this.aKJ) {
                        this.aKH.wait(12L);
                    } else {
                        this.aKH.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Di() {
        if (this.aKG != null && this.aKA) {
            this.aKG.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aKG != null && this.aKA) {
            this.aKA = false;
            this.aKG.removeMessages(1005);
            this.aKG.sendMessage(this.aKG.obtainMessage(1006));
        }
    }

    public void De() {
        if (this.aKG != null) {
            this.aKG.removeCallbacksAndMessages(null);
            this.aKG.sendMessage(this.aKG.obtainMessage(1007));
            this.aKG.sendMessage(this.aKG.obtainMessage(1008));
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
                    b.this.a(aVar.aKq, aVar.aJJ);
                    return;
                case 1002:
                    b.this.Df();
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
                    b.this.Dj();
                    return;
                case 1007:
                    b.this.Dk();
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
        if (Build.VERSION.SDK_INT >= 18 && this.aKI != null) {
            this.aKI.a(dVar, this.aKh);
            if (this.aKH == null) {
                this.aKH = new com.baidu.mario.gldraw2d.a(this.aKI.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKI != null) {
            this.aKI.Dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKH.J(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKH.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKI != null) {
            this.aKI.bI(false);
            this.aKH.T(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKI != null) {
            this.aKI.bI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKI != null) {
            this.aKI.Dm();
            this.aKI.releaseEncoder();
            this.aKI = null;
            this.aKh = null;
            this.aKH.BY();
            this.aKH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aKG != null) {
            this.aKG.removeCallbacksAndMessages(null);
            this.aKG = null;
        }
        if (this.aKF != null) {
            this.aKF.quit();
            this.aKF = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d aJJ;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aKq;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aKq = arrayList;
            this.aJJ = dVar;
        }
    }
}
