package com.baidu.mario.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.baidu.mario.b.b.c;
import com.baidu.mario.b.b.d;
import com.baidu.mario.b.b.e;
import com.baidu.mario.b.b.g;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private e adU;
    private volatile boolean aen = false;
    private HandlerThread aes;
    private Handler aet;
    private com.baidu.mario.gldraw2d.a aeu;
    private g aev;

    private void a(e eVar, c cVar) {
        this.aes = new HandlerThread("VideoRecorderThread");
        this.aes.start();
        this.aet = new HandlerC0061b(this.aes.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            this.aev = new g();
            this.aev.a(cVar);
            this.adU = eVar;
        }
    }

    public long sO() {
        if (this.aev != null) {
            return this.aev.sO();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.aes != null && this.aes.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.aet.sendMessage(this.aet.obtainMessage(1001, new a(arrayList, dVar)));
        this.aen = true;
        return true;
    }

    public void startRecording() {
        if (this.aet != null) {
            this.aet.sendMessage(this.aet.obtainMessage(1002));
        }
    }

    public void g(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.aet != null) {
            this.aet.sendMessage(this.aet.obtainMessage(1003, arrayList));
        }
    }

    public void t(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.aet != null && this.aen) {
            this.aet.sendMessage(this.aet.obtainMessage(1005, i, i2));
        }
    }

    public void tk() {
        if (this.aet != null && this.aen) {
            this.aet.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.aet != null && this.aen) {
            this.aen = false;
            this.aet.removeMessages(1005);
            this.aet.sendMessage(this.aet.obtainMessage(PointerIconCompat.TYPE_CELL));
        }
    }

    public void tf() {
        if (this.aet != null) {
            this.aet.removeCallbacksAndMessages(null);
            this.aet.sendMessage(this.aet.obtainMessage(PointerIconCompat.TYPE_CROSSHAIR));
            this.aet.sendMessage(this.aet.obtainMessage(PointerIconCompat.TYPE_TEXT));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0061b extends Handler {
        public HandlerC0061b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.aed, aVar.adD);
                    return;
                case 1002:
                    b.this.tg();
                    return;
                case 1003:
                    b.this.h((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.y((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    b.this.tl();
                    return;
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    b.this.tm();
                    return;
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
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
            this.aev.a(dVar, this.adU);
            if (this.aeu == null) {
                this.aeu = new com.baidu.mario.gldraw2d.a(this.aev.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aev.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeu.n(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aeu.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aev.aL(false);
            this.aeu.t(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aev.aL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aev.tq();
            this.aev.tp();
            this.aev = null;
            this.adU = null;
            this.aeu.sa();
            this.aeu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQuit() {
        if (this.aet != null) {
            this.aet.removeCallbacksAndMessages(null);
            this.aet = null;
        }
        if (this.aes != null) {
            this.aes.quit();
            this.aes = null;
        }
    }

    /* loaded from: classes2.dex */
    class a {
        d adD;
        ArrayList<com.baidu.mario.gldraw2d.params.c> aed;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.aed = arrayList;
            this.adD = dVar;
        }
    }
}
