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
    private HandlerThread bJB;
    private Handler bJC;
    private com.baidu.mario.gldraw2d.a bJD;
    private g bJE;
    private e bJd;
    private volatile boolean bJw = false;
    private boolean bJF = false;

    private void a(e eVar, c cVar) {
        this.bJB = new HandlerThread("VideoRecorderThread");
        this.bJB.start();
        this.bJC = new HandlerC0234b(this.bJB.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bJE = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bJE == null) {
                    return;
                }
            }
            this.bJE.a(cVar);
            this.bJd = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bJF = true;
        } else {
            this.bJF = false;
        }
    }

    public long UP() {
        if (this.bJE != null) {
            return this.bJE.UP();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bJB != null && this.bJB.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bJC.sendMessage(this.bJC.obtainMessage(1001, new a(arrayList, dVar)));
        this.bJw = true;
        return true;
    }

    public void startRecording() {
        if (this.bJC != null) {
            this.bJC.sendMessage(this.bJC.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bJC != null) {
            this.bJC.sendMessage(this.bJC.obtainMessage(1003, arrayList));
        }
    }

    public void aH(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bJC != null && this.bJw) {
            this.bJC.sendMessage(this.bJC.obtainMessage(1005, i, i2));
            synchronized (this.bJD) {
                try {
                    if (this.bJF) {
                        this.bJD.wait(12L);
                    } else {
                        this.bJD.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Vk() {
        if (this.bJC != null && this.bJw) {
            this.bJC.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bJC != null && this.bJw) {
            this.bJw = false;
            this.bJC.removeMessages(1005);
            this.bJC.sendMessage(this.bJC.obtainMessage(1006));
        }
    }

    public void Vf() {
        if (this.bJC != null) {
            this.bJC.removeCallbacksAndMessages(null);
            this.bJC.sendMessage(this.bJC.obtainMessage(1007));
            this.bJC.sendMessage(this.bJC.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0234b extends Handler {
        public HandlerC0234b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bJm, aVar.bIE);
                    return;
                case 1002:
                    b.this.Vg();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aL((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Vl();
                    return;
                case 1007:
                    b.this.Vm();
                    return;
                case 1008:
                    b.this.Vn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bJE != null) {
            this.bJE.a(dVar, this.bJd);
            if (this.bJD == null) {
                this.bJD = new com.baidu.mario.gldraw2d.a(this.bJE.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vg() {
        if (Build.VERSION.SDK_INT >= 18 && this.bJE != null) {
            this.bJE.Vr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJD.ac(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bJD.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bJE != null) {
            this.bJE.dd(false);
            this.bJD.aH(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (Build.VERSION.SDK_INT >= 18 && this.bJE != null) {
            this.bJE.dd(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vm() {
        if (Build.VERSION.SDK_INT >= 18 && this.bJE != null) {
            this.bJE.Vq();
            this.bJE.Vp();
            this.bJE = null;
            this.bJd = null;
            this.bJD.Ub();
            this.bJD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        if (this.bJC != null) {
            this.bJC.removeCallbacksAndMessages(null);
            this.bJC = null;
        }
        if (this.bJB != null) {
            this.bJB.quit();
            this.bJB = null;
        }
    }

    /* loaded from: classes5.dex */
    class a {
        d bIE;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bJm;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bJm = arrayList;
            this.bIE = dVar;
        }
    }
}
