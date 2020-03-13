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
    private HandlerThread aKG;
    private Handler aKH;
    private com.baidu.mario.gldraw2d.a aKI;
    private g aKJ;
    private e aKi;
    private volatile boolean aKB = false;
    private boolean aKK = false;

    private void a(e eVar, c cVar) {
        this.aKG = new HandlerThread("VideoRecorderThread");
        this.aKG.start();
        this.aKH = new HandlerC0124b(this.aKG.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aKJ = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aKJ == null) {
                    return;
                }
            }
            this.aKJ.a(cVar);
            this.aKi = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aKK = true;
        } else {
            this.aKK = false;
        }
    }

    public long CM() {
        if (this.aKJ != null) {
            return this.aKJ.CM();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aKG != null && this.aKG.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aKH.sendMessage(this.aKH.obtainMessage(1001, new a(arrayList, dVar)));
        this.aKB = true;
        return true;
    }

    public void Dd() {
        if (this.aKH != null) {
            this.aKH.sendMessage(this.aKH.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aKH != null) {
            this.aKH.sendMessage(this.aKH.obtainMessage(1003, arrayList));
        }
    }

    public void T(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aKH != null && this.aKB) {
            this.aKH.sendMessage(this.aKH.obtainMessage(1005, i, i2));
            synchronized (this.aKI) {
                try {
                    if (this.aKK) {
                        this.aKI.wait(12L);
                    } else {
                        this.aKI.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Di() {
        if (this.aKH != null && this.aKB) {
            this.aKH.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aKH != null && this.aKB) {
            this.aKB = false;
            this.aKH.removeMessages(1005);
            this.aKH.sendMessage(this.aKH.obtainMessage(1006));
        }
    }

    public void De() {
        if (this.aKH != null) {
            this.aKH.removeCallbacksAndMessages(null);
            this.aKH.sendMessage(this.aKH.obtainMessage(1007));
            this.aKH.sendMessage(this.aKH.obtainMessage(1008));
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
                    b.this.a(aVar.aKr, aVar.aJK);
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
        if (Build.VERSION.SDK_INT >= 18 && this.aKJ != null) {
            this.aKJ.a(dVar, this.aKi);
            if (this.aKI == null) {
                this.aKI = new com.baidu.mario.gldraw2d.a(this.aKJ.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKJ != null) {
            this.aKJ.Dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKI.J(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKI.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aKJ != null) {
            this.aKJ.bI(false);
            this.aKI.T(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKJ != null) {
            this.aKJ.bI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk() {
        if (Build.VERSION.SDK_INT >= 18 && this.aKJ != null) {
            this.aKJ.Dm();
            this.aKJ.releaseEncoder();
            this.aKJ = null;
            this.aKi = null;
            this.aKI.BY();
            this.aKI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aKH != null) {
            this.aKH.removeCallbacksAndMessages(null);
            this.aKH = null;
        }
        if (this.aKG != null) {
            this.aKG.quit();
            this.aKG = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d aJK;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aKr;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aKr = arrayList;
            this.aJK = dVar;
        }
    }
}
