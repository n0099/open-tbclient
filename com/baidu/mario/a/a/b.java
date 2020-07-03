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
    private e bsT;
    private HandlerThread btr;
    private Handler bts;
    private com.baidu.mario.gldraw2d.a btt;
    private g btu;
    private volatile boolean btm = false;
    private boolean btv = false;

    private void a(e eVar, c cVar) {
        this.btr = new HandlerThread("VideoRecorderThread");
        this.btr.start();
        this.bts = new HandlerC0209b(this.btr.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.btu = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.btu == null) {
                    return;
                }
            }
            this.btu.a(cVar);
            this.bsT = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.btv = true;
        } else {
            this.btv = false;
        }
    }

    public long LZ() {
        if (this.btu != null) {
            return this.btu.LZ();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.btr != null && this.btr.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bts.sendMessage(this.bts.obtainMessage(1001, new a(arrayList, dVar)));
        this.btm = true;
        return true;
    }

    public void startRecording() {
        if (this.bts != null) {
            this.bts.sendMessage(this.bts.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bts != null) {
            this.bts.sendMessage(this.bts.obtainMessage(1003, arrayList));
        }
    }

    public void aE(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bts != null && this.btm) {
            this.bts.sendMessage(this.bts.obtainMessage(1005, i, i2));
            synchronized (this.btt) {
                try {
                    if (this.btv) {
                        this.btt.wait(12L);
                    } else {
                        this.btt.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Mu() {
        if (this.bts != null && this.btm) {
            this.bts.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bts != null && this.btm) {
            this.btm = false;
            this.bts.removeMessages(1005);
            this.bts.sendMessage(this.bts.obtainMessage(1006));
        }
    }

    public void Mp() {
        if (this.bts != null) {
            this.bts.removeCallbacksAndMessages(null);
            this.bts.sendMessage(this.bts.obtainMessage(1007));
            this.bts.sendMessage(this.bts.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class HandlerC0209b extends Handler {
        public HandlerC0209b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.btc, aVar.bsu);
                    return;
                case 1002:
                    b.this.Mq();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aI((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Mv();
                    return;
                case 1007:
                    b.this.Mw();
                    return;
                case 1008:
                    b.this.Mx();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.btu != null) {
            this.btu.a(dVar, this.bsT);
            if (this.btt == null) {
                this.btt = new com.baidu.mario.gldraw2d.a(this.btu.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq() {
        if (Build.VERSION.SDK_INT >= 18 && this.btu != null) {
            this.btu.MB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btt.U(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btt.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.btu != null) {
            this.btu.cK(false);
            this.btt.aE(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mv() {
        if (Build.VERSION.SDK_INT >= 18 && this.btu != null) {
            this.btu.cK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mw() {
        if (Build.VERSION.SDK_INT >= 18 && this.btu != null) {
            this.btu.MA();
            this.btu.Mz();
            this.btu = null;
            this.bsT = null;
            this.btt.Lk();
            this.btt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx() {
        if (this.bts != null) {
            this.bts.removeCallbacksAndMessages(null);
            this.bts = null;
        }
        if (this.btr != null) {
            this.btr.quit();
            this.btr = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d bsu;
        ArrayList<com.baidu.mario.gldraw2d.params.c> btc;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.btc = arrayList;
            this.bsu = dVar;
        }
    }
}
