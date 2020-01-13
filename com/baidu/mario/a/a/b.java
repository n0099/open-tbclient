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
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private Handler aGA;
    private com.baidu.mario.gldraw2d.a aGB;
    private g aGC;
    private e aGa;
    private HandlerThread aGz;
    private volatile boolean aGu = false;
    private boolean aGD = false;

    private void a(e eVar, c cVar) {
        this.aGz = new HandlerThread("VideoRecorderThread");
        this.aGz.start();
        this.aGA = new HandlerC0116b(this.aGz.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aGC = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aGC == null) {
                    return;
                }
            }
            this.aGC.a(cVar);
            this.aGa = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aGD = true;
        } else {
            this.aGD = false;
        }
    }

    public long Au() {
        if (this.aGC != null) {
            return this.aGC.Au();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aGz != null && this.aGz.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aGA.sendMessage(this.aGA.obtainMessage(1001, new a(arrayList, dVar)));
        this.aGu = true;
        return true;
    }

    public void AL() {
        if (this.aGA != null) {
            this.aGA.sendMessage(this.aGA.obtainMessage(1002));
        }
    }

    public void j(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aGA != null) {
            this.aGA.sendMessage(this.aGA.obtainMessage(1003, arrayList));
        }
    }

    public void P(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aGA != null && this.aGu) {
            this.aGA.sendMessage(this.aGA.obtainMessage(1005, i, i2));
            synchronized (this.aGB) {
                try {
                    if (this.aGD) {
                        this.aGB.wait(12L);
                    } else {
                        this.aGB.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void AQ() {
        if (this.aGA != null && this.aGu) {
            this.aGA.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aGA != null && this.aGu) {
            this.aGu = false;
            this.aGA.removeMessages(1005);
            this.aGA.sendMessage(this.aGA.obtainMessage(1006));
        }
    }

    public void AM() {
        if (this.aGA != null) {
            this.aGA.removeCallbacksAndMessages(null);
            this.aGA.sendMessage(this.aGA.obtainMessage(1007));
            this.aGA.sendMessage(this.aGA.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class HandlerC0116b extends Handler {
        public HandlerC0116b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.aGj, aVar.aFC);
                    return;
                case 1002:
                    b.this.AN();
                    return;
                case 1003:
                    b.this.k((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.U((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.AR();
                    return;
                case 1007:
                    b.this.AS();
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
        if (Build.VERSION.SDK_INT >= 18 && this.aGC != null) {
            this.aGC.a(dVar, this.aGa);
            if (this.aGB == null) {
                this.aGB = new com.baidu.mario.gldraw2d.a(this.aGC.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        if (Build.VERSION.SDK_INT >= 18 && this.aGC != null) {
            this.aGC.AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGB.J(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGB.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aGC != null) {
            this.aGC.bA(false);
            this.aGB.P(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        if (Build.VERSION.SDK_INT >= 18 && this.aGC != null) {
            this.aGC.bA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        if (Build.VERSION.SDK_INT >= 18 && this.aGC != null) {
            this.aGC.AU();
            this.aGC.releaseEncoder();
            this.aGC = null;
            this.aGa = null;
            this.aGB.zG();
            this.aGB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aGA != null) {
            this.aGA.removeCallbacksAndMessages(null);
            this.aGA = null;
        }
        if (this.aGz != null) {
            this.aGz.quit();
            this.aGz = null;
        }
    }

    /* loaded from: classes10.dex */
    class a {
        d aFC;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aGj;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aGj = arrayList;
            this.aFC = dVar;
        }
    }
}
