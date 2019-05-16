package com.baidu.mario.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.b.b.f;
import com.baidu.mario.gldraw2d.params.MirrorType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile int adL = 0;
    private static volatile boolean adW = false;
    private static volatile c aef;
    private d adC;
    private com.baidu.mario.b.b.d adD;
    private HandlerThread adO;
    private a adS;
    private e adT;
    private com.baidu.mario.b.b.e adU;
    private f adV;
    private com.baidu.mario.b.a.a adX;
    private com.baidu.mario.b.b.c adY;
    private com.baidu.mario.b.a.b aea;
    private com.baidu.mario.b.b.c aeb;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aed;
    private int aee;
    private Context mContext;
    private int adM = 0;
    private boolean adN = false;
    private volatile boolean adP = false;
    private boolean adQ = false;
    private long adR = 0;
    private volatile boolean adZ = false;
    private volatile boolean aec = false;

    public static c sN() {
        if (aef == null) {
            synchronized (c.class) {
                if (aef == null) {
                    aef = new c();
                }
            }
        }
        return aef;
    }

    private c() {
    }

    public long sO() {
        if (this.aea != null) {
            return this.aea.sO();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.b.b.d dVar, d dVar2) {
        Log.i(TAG, "startRecorder mStarting = " + this.adP);
        if (this.adP) {
            sS();
            return;
        }
        this.adP = true;
        this.mContext = context;
        this.adD = dVar;
        this.adC = dVar2;
        sP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP() {
        sT();
        sU();
        if (sV()) {
            sW();
            sX();
        } else if (!this.adQ) {
            sY();
        } else {
            sS();
        }
    }

    public void w(long j) {
        if (this.aea != null && this.aea.isRunning() && this.aec && adW) {
            this.aea.t(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.adZ && this.adX != null && this.adX.isRunning()) {
            this.adX.d(byteBuffer, i, j);
        }
    }

    public void sQ() {
        if (this.aea != null) {
            this.aea.tk();
        }
    }

    public void sR() {
        Log.i(TAG, "stopRecorder mStarting = " + this.adP);
        if (this.adP) {
            if (!tc() && this.adS != null) {
                this.adS.sendMessage(this.adS.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.adS != null) {
                this.adS.sendMessageDelayed(this.adS.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.adZ = false;
        this.aec = false;
        this.adR = 0L;
        if (this.adX != null && this.adX.isRunning()) {
            this.adX.stopRecording();
        }
        if (this.aea != null && this.aea.isRunning()) {
            this.aea.stopRecording();
        }
        aE(false);
    }

    public void onDestroy() {
        if (this.aed != null) {
            this.aed.clear();
            this.aed = null;
        }
        this.adT = null;
        this.mContext = null;
        this.adD = null;
        this.adC = null;
        bC(0);
        releaseInstance();
        if (this.adS != null) {
            this.adS.removeCallbacksAndMessages(null);
            this.adS = null;
        }
        if (this.adO != null) {
            this.adO.quit();
            this.adO = null;
        }
    }

    private static void releaseInstance() {
        aef = null;
    }

    private static void aE(boolean z) {
        adW = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aed == null) {
                this.aed = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aed.size()) {
                    break;
                }
                if (this.aed.get(i3).sE() == cVar.sE()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aed.size()) {
                if (this.aed.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aed.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aed.add(cVar.clone());
            } else {
                this.aed.add(cVar);
            }
            Collections.sort(this.aed);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aea != null) {
            a(cVar, z);
            this.aea.g(this.aed);
        }
    }

    private void sS() {
        if (this.adS != null) {
            this.adS.sendMessageDelayed(this.adS.obtainMessage(7001, false), 500L);
        }
    }

    private void sT() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.adU = new com.baidu.mario.b.b.e();
        }
        if (this.adD.tA()) {
            this.adX = new com.baidu.mario.b.a.a();
        } else {
            adW = true;
        }
        this.aea = new com.baidu.mario.b.a.b();
        this.adM = 0;
        if (!this.adN && this.adO == null) {
            this.adO = new HandlerThread(TAG);
            this.adO.start();
        }
        if (this.adS == null) {
            if (this.adO != null) {
                this.adS = new a(this.adO.getLooper());
            } else {
                this.adS = new a(this.mContext.getMainLooper());
            }
        } else {
            this.adS.removeCallbacksAndMessages(null);
        }
        this.adT = new e(this.adD.tu());
    }

    private void sU() {
        this.aeb = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.1
            @Override // com.baidu.mario.b.b.c
            public void aF(boolean z) {
                if (z) {
                    c.this.aea.startRecording();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void aG(boolean z) {
                c.this.aec = z;
                c.this.h(2, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void aH(boolean z) {
            }

            @Override // com.baidu.mario.b.b.c
            public void aI(boolean z) {
                c.this.aea.tf();
                c.this.aea = null;
                c.this.aeb = null;
                c.this.j(2, z);
            }
        };
        this.adY = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.2
            @Override // com.baidu.mario.b.b.c
            public void aF(boolean z) {
                if (z) {
                    c.this.adX.startRecording();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void aG(boolean z) {
                c.this.adZ = z;
                c.this.h(4, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void aH(boolean z) {
                boolean unused = c.adW = z;
            }

            @Override // com.baidu.mario.b.b.c
            public void aI(boolean z) {
                c.this.adX.tf();
                c.this.adX = null;
                c.this.adY = null;
                c.this.j(4, z);
            }
        };
        this.adV = new f() { // from class: com.baidu.mario.b.c.3
            @Override // com.baidu.mario.b.b.f
            public void aJ(boolean z) {
                c.this.h(1, z);
            }

            @Override // com.baidu.mario.b.b.f
            public void aK(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    c.this.adU.tI();
                    c.this.adU = null;
                }
                c.this.adV = null;
                c.this.j(1, z);
            }
        };
    }

    private boolean sV() {
        boolean z = true;
        if (this.adX != null && this.adX.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.adX.stopRecording();
            this.adX.tf();
            z = false;
        }
        if (this.aea != null && this.aea.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aea.stopRecording();
            this.aea.tf();
            z = false;
        }
        if (this.adD != null && !this.adU.a(this.adD.ts(), this.adD.tt(), this.adV)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void sW() {
        if (this.adX != null) {
            this.adX.a(this.adD, this.adU, this.adY);
        }
    }

    private void sX() {
        sZ();
        this.aea.a(this.aed, this.adD, this.adU, this.aeb);
    }

    private void sY() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.adQ);
        if (this.adS != null) {
            this.adQ = true;
            this.adS.sendMessageDelayed(this.adS.obtainMessage(7005), 500L);
        }
    }

    private void sZ() {
        ta();
    }

    private void ta() {
        if (this.aed != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aed.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a sA = it.next().sA();
                if (sA.sm() == MirrorType.NO_MIRROR) {
                    sA.bA(-this.aee);
                } else {
                    sA.bA(this.aee);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        i(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + adL);
        if (tb()) {
            this.adS.sendMessage(this.adS.obtainMessage(7001, Boolean.valueOf(tc())));
        }
    }

    private static void bC(int i) {
        adL = i;
    }

    private void i(int i, boolean z) {
        if (z) {
            adL |= i;
        }
        this.adM++;
    }

    private boolean tb() {
        if (this.adD == null) {
            return false;
        }
        return this.adD.tA() ? this.adM == 3 : this.adM == 2;
    }

    private synchronized boolean tc() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + adL);
        i = (adL ^ 1) ^ 2;
        if (this.adD != null) {
            if (this.adD.tA()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + adL);
        if (td() && this.adS != null) {
            this.adS.sendMessage(this.adS.obtainMessage(7003, Boolean.valueOf(te())));
        }
    }

    private void k(int i, boolean z) {
        if (z) {
            adL ^= i;
        }
        this.adM--;
    }

    private boolean td() {
        return this.adM == 0;
    }

    private synchronized boolean te() {
        return adL == 0;
    }

    public void x(long j) {
        this.adR *= 1000000;
        if (this.adC != null) {
            this.adC.v(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case 7001:
                    if (c.this.adC != null) {
                        c.this.adC.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    c.this.adP = false;
                    break;
                case 7002:
                    if (c.this.adC != null) {
                        c.this.adC.v(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (c.this.adC != null) {
                        if (c.this.adD != null) {
                            str = c.this.adD.ts();
                        } else {
                            str = null;
                        }
                        c.this.adC.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (c.this.adC != null) {
                        c.this.adC.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    c.this.sP();
                    break;
                case 7006:
                    c.this.adP = false;
                    c.this.sR();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
