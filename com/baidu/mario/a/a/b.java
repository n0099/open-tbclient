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
    private HandlerThread aKU;
    private Handler aKV;
    private com.baidu.mario.gldraw2d.a aKW;
    private g aKX;
    private e aKw;
    private volatile boolean aKP = false;
    private boolean aKY = false;

    private void a(e eVar, c cVar) {
        this.aKU = new HandlerThread("VideoRecorderThread");
        this.aKU.start();
        this.aKV = new HandlerC0124b(this.aKU.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aKX = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aKX == null) {
                    return;
                }
            }
            this.aKX.a(cVar);
            this.aKw = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aKY = true;
        } else {
            this.aKY = false;
        }
    }

    public long CT() {
        if (this.aKX != null) {
            return this.aKX.CT();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aKU != null && this.aKU.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKV.sendMessage(this.aKV.obtainMessage(1001, new a(arrayList, dVar)));
        this.aKP = true;
        return true;
    }

    public void Dk() {
        if (this.aKV != null) {
            this.aKV.sendMessage(this.aKV.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aKV != null) {
            this.aKV.sendMessage(this.aKV.obtainMessage(1003, arrayList));
        }
    }

    public void T(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aKV != null && this.aKP) {
            this.aKV.sendMessage(this.aKV.obtainMessage(1005, i, i2));
            synchronized (this.aKW) {
                try {
                    if (this.aKY) {
                        this.aKW.wait(12L);
                    } else {
                        this.aKW.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Dp() {
        if (this.aKV != null && this.aKP) {
            this.aKV.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aKV != null && this.aKP) {
            this.aKP = false;
            this.aKV.removeMessages(1005);
            this.aKV.sendMessage(this.aKV.obtainMessage(1006));
        }
    }

    public void Dl() {
        if (this.aKV != null) {
            this.aKV.removeCallbacksAndMessages(null);
            this.aKV.sendMessage(this.aKV.obtainMessage(1007));
            this.aKV.sendMessage(this.aKV.obtainMessage(1008));
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
                    b.this.a(aVar.aKF, aVar.aJY);
                    return;
                case 1002:
                    b.this.Dm();
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
                    b.this.Dq();
                    return;
                case 1007:
                    b.this.Dr();
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
        if (Build.VERSION.SDK_INT >= 18 && this.aKX != null) {
            this.aKX.a(dVar, this.aKw);
            if (this.aKW == null) {
                this.aKW = new com.baidu.mario.gldraw2d.a(this.aKX.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKX != null) {
            this.aKX.Du();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKW.J(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKW.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKX != null) {
            this.aKX.bJ(false);
            this.aKW.T(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKX != null) {
            this.aKX.bJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKX != null) {
            this.aKX.Dt();
            this.aKX.releaseEncoder();
            this.aKX = null;
            this.aKw = null;
            this.aKW.Cf();
            this.aKW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aKV != null) {
            this.aKV.removeCallbacksAndMessages(null);
            this.aKV = null;
        }
        if (this.aKU != null) {
            this.aKU.quit();
            this.aKU = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d aJY;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aKF;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aKF = arrayList;
            this.aJY = dVar;
        }
    }
}
