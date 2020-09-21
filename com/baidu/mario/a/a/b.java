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
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private e bCB;
    private HandlerThread bCZ;
    private Handler bDa;
    private com.baidu.mario.gldraw2d.a bDb;
    private g bDc;
    private volatile boolean bCU = false;
    private boolean bDd = false;

    private void a(e eVar, c cVar) {
        this.bCZ = new HandlerThread("VideoRecorderThread");
        this.bCZ.start();
        this.bDa = new HandlerC0219b(this.bCZ.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bDc = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bDc == null) {
                    return;
                }
            }
            this.bDc.a(cVar);
            this.bCB = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bDd = true;
        } else {
            this.bDd = false;
        }
    }

    public long SW() {
        if (this.bDc != null) {
            return this.bDc.SW();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bCZ != null && this.bCZ.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bDa.sendMessage(this.bDa.obtainMessage(1001, new a(arrayList, dVar)));
        this.bCU = true;
        return true;
    }

    public void startRecording() {
        if (this.bDa != null) {
            this.bDa.sendMessage(this.bDa.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bDa != null) {
            this.bDa.sendMessage(this.bDa.obtainMessage(1003, arrayList));
        }
    }

    public void aF(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bDa != null && this.bCU) {
            this.bDa.sendMessage(this.bDa.obtainMessage(1005, i, i2));
            synchronized (this.bDb) {
                try {
                    if (this.bDd) {
                        this.bDb.wait(12L);
                    } else {
                        this.bDb.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Tr() {
        if (this.bDa != null && this.bCU) {
            this.bDa.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bDa != null && this.bCU) {
            this.bCU = false;
            this.bDa.removeMessages(1005);
            this.bDa.sendMessage(this.bDa.obtainMessage(1006));
        }
    }

    public void Tm() {
        if (this.bDa != null) {
            this.bDa.removeCallbacksAndMessages(null);
            this.bDa.sendMessage(this.bDa.obtainMessage(1007));
            this.bDa.sendMessage(this.bDa.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC0219b extends Handler {
        public HandlerC0219b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bCK, aVar.bCc);
                    return;
                case 1002:
                    b.this.Tn();
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
                    b.this.Ts();
                    return;
                case 1007:
                    b.this.Tt();
                    return;
                case 1008:
                    b.this.Tu();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bDc != null) {
            this.bDc.a(dVar, this.bCB);
            if (this.bDb == null) {
                this.bDb = new com.baidu.mario.gldraw2d.a(this.bDc.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (Build.VERSION.SDK_INT >= 18 && this.bDc != null) {
            this.bDc.Ty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bDb.Z(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bDb.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bDc != null) {
            this.bDc.cW(false);
            this.bDb.aF(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
        if (Build.VERSION.SDK_INT >= 18 && this.bDc != null) {
            this.bDc.cW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (Build.VERSION.SDK_INT >= 18 && this.bDc != null) {
            this.bDc.Tx();
            this.bDc.Tw();
            this.bDc = null;
            this.bCB = null;
            this.bDb.Si();
            this.bDb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tu() {
        if (this.bDa != null) {
            this.bDa.removeCallbacksAndMessages(null);
            this.bDa = null;
        }
        if (this.bCZ != null) {
            this.bCZ.quit();
            this.bCZ = null;
        }
    }

    /* loaded from: classes4.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> bCK;
        d bCc;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bCK = arrayList;
            this.bCc = dVar;
        }
    }
}
