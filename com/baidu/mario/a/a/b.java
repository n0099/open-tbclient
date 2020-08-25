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
/* loaded from: classes20.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private Handler bzA;
    private com.baidu.mario.gldraw2d.a bzB;
    private g bzC;
    private e bzb;
    private HandlerThread bzz;
    private volatile boolean bzu = false;
    private boolean bzD = false;

    private void a(e eVar, c cVar) {
        this.bzz = new HandlerThread("VideoRecorderThread");
        this.bzz.start();
        this.bzA = new HandlerC0220b(this.bzz.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bzC = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bzC == null) {
                    return;
                }
            }
            this.bzC.a(cVar);
            this.bzb = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bzD = true;
        } else {
            this.bzD = false;
        }
    }

    public long Sf() {
        if (this.bzC != null) {
            return this.bzC.Sf();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bzz != null && this.bzz.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bzA.sendMessage(this.bzA.obtainMessage(1001, new a(arrayList, dVar)));
        this.bzu = true;
        return true;
    }

    public void startRecording() {
        if (this.bzA != null) {
            this.bzA.sendMessage(this.bzA.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bzA != null) {
            this.bzA.sendMessage(this.bzA.obtainMessage(1003, arrayList));
        }
    }

    public void aF(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bzA != null && this.bzu) {
            this.bzA.sendMessage(this.bzA.obtainMessage(1005, i, i2));
            synchronized (this.bzB) {
                try {
                    if (this.bzD) {
                        this.bzB.wait(12L);
                    } else {
                        this.bzB.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void SA() {
        if (this.bzA != null && this.bzu) {
            this.bzA.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bzA != null && this.bzu) {
            this.bzu = false;
            this.bzA.removeMessages(1005);
            this.bzA.sendMessage(this.bzA.obtainMessage(1006));
        }
    }

    public void Sv() {
        if (this.bzA != null) {
            this.bzA.removeCallbacksAndMessages(null);
            this.bzA.sendMessage(this.bzA.obtainMessage(1007));
            this.bzA.sendMessage(this.bzA.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class HandlerC0220b extends Handler {
        public HandlerC0220b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bzk, aVar.byC);
                    return;
                case 1002:
                    b.this.Sw();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aJ((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.SB();
                    return;
                case 1007:
                    b.this.SC();
                    return;
                case 1008:
                    b.this.SD();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bzC != null) {
            this.bzC.a(dVar, this.bzb);
            if (this.bzB == null) {
                this.bzB = new com.baidu.mario.gldraw2d.a(this.bzC.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzC != null) {
            this.bzC.SH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzB.V(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzB.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bzC != null) {
            this.bzC.cU(false);
            this.bzB.aF(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SB() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzC != null) {
            this.bzC.cU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SC() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzC != null) {
            this.bzC.SG();
            this.bzC.SF();
            this.bzC = null;
            this.bzb = null;
            this.bzB.Rr();
            this.bzB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        if (this.bzA != null) {
            this.bzA.removeCallbacksAndMessages(null);
            this.bzA = null;
        }
        if (this.bzz != null) {
            this.bzz.quit();
            this.bzz = null;
        }
    }

    /* loaded from: classes20.dex */
    class a {
        d byC;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bzk;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bzk = arrayList;
            this.byC = dVar;
        }
    }
}
