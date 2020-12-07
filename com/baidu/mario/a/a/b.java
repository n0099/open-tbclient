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
    private e caN;
    private HandlerThread cbl;
    private Handler cbm;
    private com.baidu.mario.gldraw2d.a cbn;
    private g cbo;
    private volatile boolean cbg = false;
    private boolean cbp = false;

    private void a(e eVar, c cVar) {
        this.cbl = new HandlerThread("VideoRecorderThread");
        this.cbl.start();
        this.cbm = new HandlerC0267b(this.cbl.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.cbo = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.cbo == null) {
                    return;
                }
            }
            this.cbo.a(cVar);
            this.caN = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.cbp = true;
        } else {
            this.cbp = false;
        }
    }

    public long abc() {
        if (this.cbo != null) {
            return this.cbo.abc();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.cbl != null && this.cbl.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.cbm.sendMessage(this.cbm.obtainMessage(1001, new a(arrayList, dVar)));
        this.cbg = true;
        return true;
    }

    public void startRecording() {
        if (this.cbm != null) {
            this.cbm.sendMessage(this.cbm.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.cbm != null) {
            this.cbm.sendMessage(this.cbm.obtainMessage(1003, arrayList));
        }
    }

    public void bD(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.cbm != null && this.cbg) {
            this.cbm.sendMessage(this.cbm.obtainMessage(1005, i, i2));
            synchronized (this.cbn) {
                try {
                    if (this.cbp) {
                        this.cbn.wait(12L);
                    } else {
                        this.cbn.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void abx() {
        if (this.cbm != null && this.cbg) {
            this.cbm.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.cbm != null && this.cbg) {
            this.cbg = false;
            this.cbm.removeMessages(1005);
            this.cbm.sendMessage(this.cbm.obtainMessage(1006));
        }
    }

    public void abs() {
        if (this.cbm != null) {
            this.cbm.removeCallbacksAndMessages(null);
            this.cbm.sendMessage(this.cbm.obtainMessage(1007));
            this.cbm.sendMessage(this.cbm.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class HandlerC0267b extends Handler {
        public HandlerC0267b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.caW, aVar.cao);
                    return;
                case 1002:
                    b.this.abt();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bH((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.aby();
                    return;
                case 1007:
                    b.this.abz();
                    return;
                case 1008:
                    b.this.abA();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.cbo != null) {
            this.cbo.a(dVar, this.caN);
            if (this.cbn == null) {
                this.cbn = new com.baidu.mario.gldraw2d.a(this.cbo.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abt() {
        if (Build.VERSION.SDK_INT >= 18 && this.cbo != null) {
            this.cbo.abE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cbn.av(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cbn.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.cbo != null) {
            this.cbo.dO(false);
            this.cbn.bD(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aby() {
        if (Build.VERSION.SDK_INT >= 18 && this.cbo != null) {
            this.cbo.dO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abz() {
        if (Build.VERSION.SDK_INT >= 18 && this.cbo != null) {
            this.cbo.abD();
            this.cbo.abC();
            this.cbo = null;
            this.caN = null;
            this.cbn.aao();
            this.cbn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abA() {
        if (this.cbm != null) {
            this.cbm.removeCallbacksAndMessages(null);
            this.cbm = null;
        }
        if (this.cbl != null) {
            this.cbl.quit();
            this.cbl = null;
        }
    }

    /* loaded from: classes14.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> caW;
        d cao;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.caW = arrayList;
            this.cao = dVar;
        }
    }
}
