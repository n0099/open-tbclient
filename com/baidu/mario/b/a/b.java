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
    private e axP;
    private volatile boolean ayi = false;
    private HandlerThread ayn;
    private Handler ayo;
    private com.baidu.mario.gldraw2d.a ayp;
    private g ayq;

    private void a(e eVar, c cVar) {
        this.ayn = new HandlerThread("VideoRecorderThread");
        this.ayn.start();
        this.ayo = new HandlerC0101b(this.ayn.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayq = new g();
            this.ayq.a(cVar);
            this.axP = eVar;
        }
    }

    public long yg() {
        if (this.ayq != null) {
            return this.ayq.yg();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.ayn != null && this.ayn.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.ayo.sendMessage(this.ayo.obtainMessage(1001, new a(arrayList, dVar)));
        this.ayi = true;
        return true;
    }

    public void yx() {
        if (this.ayo != null) {
            this.ayo.sendMessage(this.ayo.obtainMessage(1002));
        }
    }

    public void j(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.ayo != null) {
            this.ayo.sendMessage(this.ayo.obtainMessage(1003, arrayList));
        }
    }

    public void M(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.ayo != null && this.ayi) {
            this.ayo.sendMessage(this.ayo.obtainMessage(1005, i, i2));
        }
    }

    public void yE() {
        if (this.ayo != null && this.ayi) {
            this.ayo.removeMessages(1005);
        }
    }

    public void yy() {
        if (this.ayo != null && this.ayi) {
            this.ayi = false;
            this.ayo.removeMessages(1005);
            this.ayo.sendMessage(this.ayo.obtainMessage(1006));
        }
    }

    public void yz() {
        if (this.ayo != null) {
            this.ayo.removeCallbacksAndMessages(null);
            this.ayo.sendMessage(this.ayo.obtainMessage(1007));
            this.ayo.sendMessage(this.ayo.obtainMessage(1008));
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
                    b.this.a(aVar.axY, aVar.axy);
                    return;
                case 1002:
                    b.this.yA();
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
                    b.this.yF();
                    return;
                case 1007:
                    b.this.yG();
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
            this.ayq.a(dVar, this.axP);
            if (this.ayp == null) {
                this.ayp = new com.baidu.mario.gldraw2d.a(this.ayq.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yA() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayq.yK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayp.M(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayp.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayq.bg(false);
            this.ayp.M(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayq.bg(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yG() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ayq.yJ();
            this.ayq.yI();
            this.ayq = null;
            this.axP = null;
            this.ayp.xt();
            this.ayp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.ayo != null) {
            this.ayo.removeCallbacksAndMessages(null);
            this.ayo = null;
        }
        if (this.ayn != null) {
            this.ayn.quit();
            this.ayn = null;
        }
    }

    /* loaded from: classes2.dex */
    class a {
        ArrayList<com.baidu.mario.gldraw2d.params.c> axY;
        d axy;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.axY = arrayList;
            this.axy = dVar;
        }
    }
}
