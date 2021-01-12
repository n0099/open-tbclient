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
    private e ccJ;
    private HandlerThread cdh;
    private Handler cdi;
    private com.baidu.mario.gldraw2d.a cdj;
    private g cdk;
    private volatile boolean cdc = false;
    private boolean cdl = false;

    private void a(e eVar, c cVar) {
        this.cdh = new HandlerThread("VideoRecorderThread");
        this.cdh.start();
        this.cdi = new HandlerC0256b(this.cdh.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.cdk = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.cdk == null) {
                    return;
                }
            }
            this.cdk.a(cVar);
            this.ccJ = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.cdl = true;
        } else {
            this.cdl = false;
        }
    }

    public long YV() {
        if (this.cdk != null) {
            return this.cdk.YV();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.cdh != null && this.cdh.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.cdi.sendMessage(this.cdi.obtainMessage(1001, new a(arrayList, dVar)));
        this.cdc = true;
        return true;
    }

    public void startRecording() {
        if (this.cdi != null) {
            this.cdi.sendMessage(this.cdi.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.cdi != null) {
            this.cdi.sendMessage(this.cdi.obtainMessage(1003, arrayList));
        }
    }

    public void bD(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.cdi != null && this.cdc) {
            this.cdi.sendMessage(this.cdi.obtainMessage(1005, i, i2));
            synchronized (this.cdj) {
                try {
                    if (this.cdl) {
                        this.cdj.wait(12L);
                    } else {
                        this.cdj.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Zq() {
        if (this.cdi != null && this.cdc) {
            this.cdi.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.cdi != null && this.cdc) {
            this.cdc = false;
            this.cdi.removeMessages(1005);
            this.cdi.sendMessage(this.cdi.obtainMessage(1006));
        }
    }

    public void Zl() {
        if (this.cdi != null) {
            this.cdi.removeCallbacksAndMessages(null);
            this.cdi.sendMessage(this.cdi.obtainMessage(1007));
            this.cdi.sendMessage(this.cdi.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class HandlerC0256b extends Handler {
        public HandlerC0256b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.ccS, aVar.ccj);
                    return;
                case 1002:
                    b.this.Zm();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bH((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Zr();
                    return;
                case 1007:
                    b.this.Zs();
                    return;
                case 1008:
                    b.this.Zt();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.cdk != null) {
            this.cdk.a(dVar, this.ccJ);
            if (this.cdj == null) {
                this.cdj = new com.baidu.mario.gldraw2d.a(this.cdk.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        if (Build.VERSION.SDK_INT >= 18 && this.cdk != null) {
            this.cdk.Zx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cdj.aA(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cdj.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.cdk != null) {
            this.cdk.dR(false);
            this.cdj.bD(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        if (Build.VERSION.SDK_INT >= 18 && this.cdk != null) {
            this.cdk.dR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zs() {
        if (Build.VERSION.SDK_INT >= 18 && this.cdk != null) {
            this.cdk.Zw();
            this.cdk.Zv();
            this.cdk = null;
            this.ccJ = null;
            this.cdj.Yj();
            this.cdj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zt() {
        if (this.cdi != null) {
            this.cdi.removeCallbacksAndMessages(null);
            this.cdi = null;
        }
        if (this.cdh != null) {
            this.cdh.quit();
            this.cdh = null;
        }
    }

    /* loaded from: classes14.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> ccS;
        d ccj;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.ccS = arrayList;
            this.ccj = dVar;
        }
    }
}
