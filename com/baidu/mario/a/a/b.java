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
    private HandlerThread bgT;
    private Handler bgU;
    private com.baidu.mario.gldraw2d.a bgV;
    private g bgW;
    private e bgv;
    private volatile boolean bgO = false;
    private boolean bgX = false;

    private void a(e eVar, c cVar) {
        this.bgT = new HandlerThread("VideoRecorderThread");
        this.bgT.start();
        this.bgU = new HandlerC0170b(this.bgT.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bgW = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bgW == null) {
                    return;
                }
            }
            this.bgW.a(cVar);
            this.bgv = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bgX = true;
        } else {
            this.bgX = false;
        }
    }

    public long IX() {
        if (this.bgW != null) {
            return this.bgW.IX();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bgT != null && this.bgT.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bgU.sendMessage(this.bgU.obtainMessage(1001, new a(arrayList, dVar)));
        this.bgO = true;
        return true;
    }

    public void startRecording() {
        if (this.bgU != null) {
            this.bgU.sendMessage(this.bgU.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bgU != null) {
            this.bgU.sendMessage(this.bgU.obtainMessage(1003, arrayList));
        }
    }

    public void az(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bgU != null && this.bgO) {
            this.bgU.sendMessage(this.bgU.obtainMessage(1005, i, i2));
            synchronized (this.bgV) {
                try {
                    if (this.bgX) {
                        this.bgV.wait(12L);
                    } else {
                        this.bgV.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Js() {
        if (this.bgU != null && this.bgO) {
            this.bgU.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bgU != null && this.bgO) {
            this.bgO = false;
            this.bgU.removeMessages(1005);
            this.bgU.sendMessage(this.bgU.obtainMessage(1006));
        }
    }

    public void Jn() {
        if (this.bgU != null) {
            this.bgU.removeCallbacksAndMessages(null);
            this.bgU.sendMessage(this.bgU.obtainMessage(1007));
            this.bgU.sendMessage(this.bgU.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class HandlerC0170b extends Handler {
        public HandlerC0170b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bgE, aVar.bfV);
                    return;
                case 1002:
                    b.this.Jo();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aD((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Jt();
                    return;
                case 1007:
                    b.this.Ju();
                    return;
                case 1008:
                    b.this.Jv();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bgW != null) {
            this.bgW.a(dVar, this.bgv);
            if (this.bgV == null) {
                this.bgV = new com.baidu.mario.gldraw2d.a(this.bgW.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo() {
        if (Build.VERSION.SDK_INT >= 18 && this.bgW != null) {
            this.bgW.Jz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgV.P(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgV.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bgW != null) {
            this.bgW.cs(false);
            this.bgV.az(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (Build.VERSION.SDK_INT >= 18 && this.bgW != null) {
            this.bgW.cs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        if (Build.VERSION.SDK_INT >= 18 && this.bgW != null) {
            this.bgW.Jy();
            this.bgW.Jx();
            this.bgW = null;
            this.bgv = null;
            this.bgV.Ii();
            this.bgV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        if (this.bgU != null) {
            this.bgU.removeCallbacksAndMessages(null);
            this.bgU = null;
        }
        if (this.bgT != null) {
            this.bgT.quit();
            this.bgT = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d bfV;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bgE;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bgE = arrayList;
            this.bfV = dVar;
        }
    }
}
