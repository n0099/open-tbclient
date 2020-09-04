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
    private HandlerThread bzC;
    private Handler bzD;
    private com.baidu.mario.gldraw2d.a bzE;
    private g bzF;
    private e bze;
    private volatile boolean bzx = false;
    private boolean bzG = false;

    private void a(e eVar, c cVar) {
        this.bzC = new HandlerThread("VideoRecorderThread");
        this.bzC.start();
        this.bzD = new HandlerC0220b(this.bzC.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bzF = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bzF == null) {
                    return;
                }
            }
            this.bzF.a(cVar);
            this.bze = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bzG = true;
        } else {
            this.bzG = false;
        }
    }

    public long Sf() {
        if (this.bzF != null) {
            return this.bzF.Sf();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bzC != null && this.bzC.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bzD.sendMessage(this.bzD.obtainMessage(1001, new a(arrayList, dVar)));
        this.bzx = true;
        return true;
    }

    public void startRecording() {
        if (this.bzD != null) {
            this.bzD.sendMessage(this.bzD.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bzD != null) {
            this.bzD.sendMessage(this.bzD.obtainMessage(1003, arrayList));
        }
    }

    public void aF(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bzD != null && this.bzx) {
            this.bzD.sendMessage(this.bzD.obtainMessage(1005, i, i2));
            synchronized (this.bzE) {
                try {
                    if (this.bzG) {
                        this.bzE.wait(12L);
                    } else {
                        this.bzE.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void SA() {
        if (this.bzD != null && this.bzx) {
            this.bzD.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bzD != null && this.bzx) {
            this.bzx = false;
            this.bzD.removeMessages(1005);
            this.bzD.sendMessage(this.bzD.obtainMessage(1006));
        }
    }

    public void Sv() {
        if (this.bzD != null) {
            this.bzD.removeCallbacksAndMessages(null);
            this.bzD.sendMessage(this.bzD.obtainMessage(1007));
            this.bzD.sendMessage(this.bzD.obtainMessage(1008));
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
                    b.this.a(aVar.bzn, aVar.byF);
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
        if (Build.VERSION.SDK_INT >= 18 && this.bzF != null) {
            this.bzF.a(dVar, this.bze);
            if (this.bzE == null) {
                this.bzE = new com.baidu.mario.gldraw2d.a(this.bzF.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzF != null) {
            this.bzF.SH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzE.V(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzE.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bzF != null) {
            this.bzF.cV(false);
            this.bzE.aF(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SB() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzF != null) {
            this.bzF.cV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SC() {
        if (Build.VERSION.SDK_INT >= 18 && this.bzF != null) {
            this.bzF.SG();
            this.bzF.SF();
            this.bzF = null;
            this.bze = null;
            this.bzE.Rr();
            this.bzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        if (this.bzD != null) {
            this.bzD.removeCallbacksAndMessages(null);
            this.bzD = null;
        }
        if (this.bzC != null) {
            this.bzC.quit();
            this.bzC = null;
        }
    }

    /* loaded from: classes20.dex */
    class a {
        d byF;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bzn;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bzn = arrayList;
            this.byF = dVar;
        }
    }
}
