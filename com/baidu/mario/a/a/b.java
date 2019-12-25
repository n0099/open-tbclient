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
/* loaded from: classes9.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread aFH;
    private Handler aFI;
    private com.baidu.mario.gldraw2d.a aFJ;
    private g aFK;
    private e aFi;
    private volatile boolean aFC = false;
    private boolean aFL = false;

    private void a(e eVar, c cVar) {
        this.aFH = new HandlerThread("VideoRecorderThread");
        this.aFH.start();
        this.aFI = new HandlerC0114b(this.aFH.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.aFK = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.aFK == null) {
                    return;
                }
            }
            this.aFK.a(cVar);
            this.aFi = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.aFL = true;
        } else {
            this.aFL = false;
        }
    }

    public long zY() {
        if (this.aFK != null) {
            return this.aFK.zY();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aFH != null && this.aFH.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aFI.sendMessage(this.aFI.obtainMessage(1001, new a(arrayList, dVar)));
        this.aFC = true;
        return true;
    }

    public void Ap() {
        if (this.aFI != null) {
            this.aFI.sendMessage(this.aFI.obtainMessage(1002));
        }
    }

    public void j(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aFI != null) {
            this.aFI.sendMessage(this.aFI.obtainMessage(1003, arrayList));
        }
    }

    public void M(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aFI != null && this.aFC) {
            this.aFI.sendMessage(this.aFI.obtainMessage(1005, i, i2));
            synchronized (this.aFJ) {
                try {
                    if (this.aFL) {
                        this.aFJ.wait(12L);
                    } else {
                        this.aFJ.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Au() {
        if (this.aFI != null && this.aFC) {
            this.aFI.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aFI != null && this.aFC) {
            this.aFC = false;
            this.aFI.removeMessages(1005);
            this.aFI.sendMessage(this.aFI.obtainMessage(1006));
        }
    }

    public void Aq() {
        if (this.aFI != null) {
            this.aFI.removeCallbacksAndMessages(null);
            this.aFI.sendMessage(this.aFI.obtainMessage(1007));
            this.aFI.sendMessage(this.aFI.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC0114b extends Handler {
        public HandlerC0114b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.aFr, aVar.aEK);
                    return;
                case 1002:
                    b.this.Ar();
                    return;
                case 1003:
                    b.this.k((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.R((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Av();
                    return;
                case 1007:
                    b.this.Aw();
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
        if (Build.VERSION.SDK_INT >= 18 && this.aFK != null) {
            this.aFK.a(dVar, this.aFi);
            if (this.aFJ == null) {
                this.aFJ = new com.baidu.mario.gldraw2d.a(this.aFK.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar() {
        if (Build.VERSION.SDK_INT >= 18 && this.aFK != null) {
            this.aFK.Az();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFJ.K(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFJ.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.aFK != null) {
            this.aFK.bv(false);
            this.aFJ.M(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Av() {
        if (Build.VERSION.SDK_INT >= 18 && this.aFK != null) {
            this.aFK.bv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        if (Build.VERSION.SDK_INT >= 18 && this.aFK != null) {
            this.aFK.Ay();
            this.aFK.releaseEncoder();
            this.aFK = null;
            this.aFi = null;
            this.aFJ.zk();
            this.aFJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aFI != null) {
            this.aFI.removeCallbacksAndMessages(null);
            this.aFI = null;
        }
        if (this.aFH != null) {
            this.aFH.quit();
            this.aFH = null;
        }
    }

    /* loaded from: classes9.dex */
    class a {
        d aEK;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aFr;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aFr = arrayList;
            this.aEK = dVar;
        }
    }
}
