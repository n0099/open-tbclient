package com.baidu.mario.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.b.b.c;
import com.baidu.mario.b.b.d;
import com.baidu.mario.b.b.e;
import com.baidu.mario.b.b.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private volatile boolean axQ = false;
    private HandlerThread axV;
    private Handler axW;
    private com.baidu.mario.gldraw2d.a axX;
    private g axY;
    private e axx;

    private void a(e eVar, c cVar) {
        this.axV = new HandlerThread("VideoRecorderThread");
        this.axV.start();
        this.axW = new HandlerC0101b(this.axV.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY = new g();
            this.axY.a(cVar);
            this.axx = eVar;
        }
    }

    public long yh() {
        if (this.axY != null) {
            return this.axY.yh();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.axV != null && this.axV.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.axW.sendMessage(this.axW.obtainMessage(1001, new a(arrayList, dVar)));
        this.axQ = true;
        return true;
    }

    public void yy() {
        if (this.axW != null) {
            this.axW.sendMessage(this.axW.obtainMessage(1002));
        }
    }

    public void j(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.axW != null) {
            this.axW.sendMessage(this.axW.obtainMessage(1003, arrayList));
        }
    }

    public void L(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.axW != null && this.axQ) {
            this.axW.sendMessage(this.axW.obtainMessage(1005, i, i2));
        }
    }

    public void yF() {
        if (this.axW != null && this.axQ) {
            this.axW.removeMessages(1005);
        }
    }

    public void yz() {
        if (this.axW != null && this.axQ) {
            this.axQ = false;
            this.axW.removeMessages(1005);
            this.axW.sendMessage(this.axW.obtainMessage(1006));
        }
    }

    public void yA() {
        if (this.axW != null) {
            this.axW.removeCallbacksAndMessages(null);
            this.axW.sendMessage(this.axW.obtainMessage(1007));
            this.axW.sendMessage(this.axW.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0101b extends Handler {
        public HandlerC0101b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.axG, aVar.axg);
                    return;
                case 1002:
                    b.this.yB();
                    return;
                case 1003:
                    b.this.k((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.Q((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.yG();
                    return;
                case 1007:
                    b.this.yH();
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
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY.a(dVar, this.axx);
            if (this.axX == null) {
                this.axX = new com.baidu.mario.gldraw2d.a(this.axY.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY.yL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axX.M(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axX.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY.bg(false);
            this.axX.L(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yG() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY.bg(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axY.yK();
            this.axY.yJ();
            this.axY = null;
            this.axx = null;
            this.axX.xu();
            this.axX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.axW != null) {
            this.axW.removeCallbacksAndMessages(null);
            this.axW = null;
        }
        if (this.axV != null) {
            this.axV.quit();
            this.axV = null;
        }
    }

    /* loaded from: classes2.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> axG;
        d axg;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.axG = arrayList;
            this.axg = dVar;
        }
    }
}
