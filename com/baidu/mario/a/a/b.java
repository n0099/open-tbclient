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
    private HandlerThread bRW;
    private Handler bRX;
    private com.baidu.mario.gldraw2d.a bRY;
    private g bRZ;
    private e bRy;
    private volatile boolean bRR = false;
    private boolean bSa = false;

    private void a(e eVar, c cVar) {
        this.bRW = new HandlerThread("VideoRecorderThread");
        this.bRW.start();
        this.bRX = new HandlerC0248b(this.bRW.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bRZ = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bRZ == null) {
                    return;
                }
            }
            this.bRZ.a(cVar);
            this.bRy = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bSa = true;
        } else {
            this.bSa = false;
        }
    }

    public long WJ() {
        if (this.bRZ != null) {
            return this.bRZ.WJ();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bRW != null && this.bRW.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bRX.sendMessage(this.bRX.obtainMessage(1001, new a(arrayList, dVar)));
        this.bRR = true;
        return true;
    }

    public void startRecording() {
        if (this.bRX != null) {
            this.bRX.sendMessage(this.bRX.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bRX != null) {
            this.bRX.sendMessage(this.bRX.obtainMessage(1003, arrayList));
        }
    }

    public void aJ(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bRX != null && this.bRR) {
            this.bRX.sendMessage(this.bRX.obtainMessage(1005, i, i2));
            synchronized (this.bRY) {
                try {
                    if (this.bSa) {
                        this.bRY.wait(12L);
                    } else {
                        this.bRY.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Xe() {
        if (this.bRX != null && this.bRR) {
            this.bRX.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bRX != null && this.bRR) {
            this.bRR = false;
            this.bRX.removeMessages(1005);
            this.bRX.sendMessage(this.bRX.obtainMessage(1006));
        }
    }

    public void WZ() {
        if (this.bRX != null) {
            this.bRX.removeCallbacksAndMessages(null);
            this.bRX.sendMessage(this.bRX.obtainMessage(1007));
            this.bRX.sendMessage(this.bRX.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0248b extends Handler {
        public HandlerC0248b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bRH, aVar.bQZ);
                    return;
                case 1002:
                    b.this.Xa();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aN((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Xf();
                    return;
                case 1007:
                    b.this.Xg();
                    return;
                case 1008:
                    b.this.Xh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bRZ != null) {
            this.bRZ.a(dVar, this.bRy);
            if (this.bRY == null) {
                this.bRY = new com.baidu.mario.gldraw2d.a(this.bRZ.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        if (Build.VERSION.SDK_INT >= 18 && this.bRZ != null) {
            this.bRZ.Xl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRY.am(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRY.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bRZ != null) {
            this.bRZ.dr(false);
            this.bRY.aJ(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xf() {
        if (Build.VERSION.SDK_INT >= 18 && this.bRZ != null) {
            this.bRZ.dr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xg() {
        if (Build.VERSION.SDK_INT >= 18 && this.bRZ != null) {
            this.bRZ.Xk();
            this.bRZ.Xj();
            this.bRZ = null;
            this.bRy = null;
            this.bRY.VV();
            this.bRY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        if (this.bRX != null) {
            this.bRX.removeCallbacksAndMessages(null);
            this.bRX = null;
        }
        if (this.bRW != null) {
            this.bRW.quit();
            this.bRW = null;
        }
    }

    /* loaded from: classes5.dex */
    class a {
        d bQZ;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bRH;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bRH = arrayList;
            this.bQZ = dVar;
        }
    }
}
