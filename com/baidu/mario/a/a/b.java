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
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private HandlerThread bVW;
    private Handler bVX;
    private com.baidu.mario.gldraw2d.a bVY;
    private g bVZ;
    private e bVy;
    private volatile boolean bVR = false;
    private boolean bWa = false;

    private void a(e eVar, c cVar) {
        this.bVW = new HandlerThread("VideoRecorderThread");
        this.bVW.start();
        this.bVX = new HandlerC0258b(this.bVW.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bVZ = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bVZ == null) {
                    return;
                }
            }
            this.bVZ.a(cVar);
            this.bVy = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bWa = true;
        } else {
            this.bWa = false;
        }
    }

    public long Yz() {
        if (this.bVZ != null) {
            return this.bVZ.Yz();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bVW != null && this.bVW.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bVX.sendMessage(this.bVX.obtainMessage(1001, new a(arrayList, dVar)));
        this.bVR = true;
        return true;
    }

    public void startRecording() {
        if (this.bVX != null) {
            this.bVX.sendMessage(this.bVX.obtainMessage(1002));
        }
    }

    public void q(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bVX != null) {
            this.bVX.sendMessage(this.bVX.obtainMessage(1003, arrayList));
        }
    }

    public void bf(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bVX != null && this.bVR) {
            this.bVX.sendMessage(this.bVX.obtainMessage(1005, i, i2));
            synchronized (this.bVY) {
                try {
                    if (this.bWa) {
                        this.bVY.wait(12L);
                    } else {
                        this.bVY.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void YU() {
        if (this.bVX != null && this.bVR) {
            this.bVX.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bVX != null && this.bVR) {
            this.bVR = false;
            this.bVX.removeMessages(1005);
            this.bVX.sendMessage(this.bVX.obtainMessage(1006));
        }
    }

    public void YP() {
        if (this.bVX != null) {
            this.bVX.removeCallbacksAndMessages(null);
            this.bVX.sendMessage(this.bVX.obtainMessage(1007));
            this.bVX.sendMessage(this.bVX.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class HandlerC0258b extends Handler {
        public HandlerC0258b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.bVH, aVar.bUZ);
                    return;
                case 1002:
                    b.this.YQ();
                    return;
                case 1003:
                    b.this.r((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bj((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.YV();
                    return;
                case 1007:
                    b.this.YW();
                    return;
                case 1008:
                    b.this.YX();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bVZ != null) {
            this.bVZ.a(dVar, this.bVy);
            if (this.bVY == null) {
                this.bVY = new com.baidu.mario.gldraw2d.a(this.bVZ.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YQ() {
        if (Build.VERSION.SDK_INT >= 18 && this.bVZ != null) {
            this.bVZ.Zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVY.at(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVY.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bVZ != null) {
            this.bVZ.dA(false);
            this.bVY.bf(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        if (Build.VERSION.SDK_INT >= 18 && this.bVZ != null) {
            this.bVZ.dA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YW() {
        if (Build.VERSION.SDK_INT >= 18 && this.bVZ != null) {
            this.bVZ.Za();
            this.bVZ.YZ();
            this.bVZ = null;
            this.bVy = null;
            this.bVY.XL();
            this.bVY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YX() {
        if (this.bVX != null) {
            this.bVX.removeCallbacksAndMessages(null);
            this.bVX = null;
        }
        if (this.bVW != null) {
            this.bVW.quit();
            this.bVW = null;
        }
    }

    /* loaded from: classes6.dex */
    class a {
        d bUZ;
        ArrayList<com.baidu.mario.gldraw2d.params.c> bVH;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.bVH = arrayList;
            this.bUZ = dVar;
        }
    }
}
