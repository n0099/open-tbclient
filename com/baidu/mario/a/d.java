package com.baidu.mario.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int cgK = 0;
    private static volatile boolean cgV = false;
    private static volatile d che;
    private HandlerThread cgN;
    private a cgR;
    private f cgS;
    private com.baidu.mario.a.b.e cgT;
    private com.baidu.mario.a.b.f cgU;
    private com.baidu.mario.a.a.a cgW;
    private com.baidu.mario.a.b.c cgX;
    private com.baidu.mario.a.a.b cgZ;
    private e cgt;
    private com.baidu.mario.a.b.d cgu;
    private com.baidu.mario.a.b.c cha;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> chc;
    private int chd;
    private Context mContext;
    private int cgL = 0;
    private boolean cgM = false;
    private volatile boolean cgO = false;
    private boolean cgP = false;
    private long cgQ = 0;
    private volatile boolean cgY = false;
    private volatile boolean chb = false;

    public static d aaN() {
        if (che == null) {
            synchronized (d.class) {
                if (che == null) {
                    che = new d();
                }
            }
        }
        return che;
    }

    private d() {
    }

    public long aaO() {
        if (this.cgZ != null) {
            return this.cgZ.aaO();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.cgO);
        if (this.cgO) {
            aaR();
            return;
        }
        this.cgO = true;
        this.mContext = context;
        this.cgu = dVar;
        this.cgt = eVar;
        aaP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaP() {
        aaS();
        aaT();
        if (aaU()) {
            aaV();
            aaW();
        } else if (!this.cgP) {
            aaX();
        } else {
            aaR();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.cgZ != null && this.cgZ.isRunning() && this.chb && cgV) {
            this.cgZ.bH(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.cgY && this.cgW != null && this.cgW.isRunning()) {
            this.cgW.d(byteBuffer, i, j);
        }
    }

    public void aaQ() {
        if (this.cgZ != null) {
            this.cgZ.abi();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.cgO);
        if (this.cgO) {
            if (!abb() && this.cgR != null) {
                this.cgR.sendMessage(this.cgR.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.cgR != null) {
                this.cgR.sendMessageDelayed(this.cgR.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.cgY = false;
        this.chb = false;
        this.cgQ = 0L;
        if (this.cgW != null && this.cgW.isRunning()) {
            this.cgW.stopRecording();
        }
        if (this.cgZ != null && this.cgZ.isRunning()) {
            this.cgZ.stopRecording();
        }
        dS(false);
    }

    public void onDestroy() {
        if (this.chc != null) {
            this.chc.clear();
            this.chc = null;
        }
        this.cgS = null;
        this.mContext = null;
        this.cgu = null;
        fy(0);
        releaseInstance();
        if (this.cgR != null) {
            this.cgR.removeCallbacksAndMessages(null);
            this.cgR = null;
        }
        if (this.cgN != null) {
            this.cgN.quit();
            this.cgN = null;
        }
    }

    private static void releaseInstance() {
        che = null;
    }

    private static void dS(boolean z) {
        cgV = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.chc == null) {
                this.chc = new ArrayList<>();
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.chc.size()) {
                    break;
                }
                if (this.chc.get(i3).aaD() == cVar.aaD()) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            if (i >= 0 && i < this.chc.size()) {
                if (this.chc.get(i).getEGLContext() != cVar.getEGLContext()) {
                    this.chc.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                this.chc.add(cVar.clone());
            } else {
                this.chc.add(cVar);
            }
            Collections.sort(this.chc);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.cgZ != null) {
            a(cVar, z);
            this.cgZ.l(this.chc);
        }
    }

    private void aaR() {
        if (this.cgR != null) {
            this.cgR.sendMessageDelayed(this.cgR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void aaS() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cgT = new com.baidu.mario.a.b.e();
        }
        if (this.cgu.isAudioIncluded()) {
            this.cgW = new com.baidu.mario.a.a.a();
        } else {
            cgV = true;
        }
        this.cgZ = new com.baidu.mario.a.a.b();
        this.cgL = 0;
        if (!this.cgM && this.cgN == null) {
            this.cgN = new HandlerThread(TAG);
            this.cgN.start();
        }
        if (this.cgR == null) {
            if (this.cgN != null) {
                this.cgR = new a(this.cgN.getLooper());
            } else {
                this.cgR = new a(this.mContext.getMainLooper());
            }
        } else {
            this.cgR.removeCallbacksAndMessages(null);
        }
        this.cgS = new f(this.cgu.getOutputTotalMs());
    }

    private void aaT() {
        this.cha = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dT(boolean z) {
                if (z) {
                    d.this.cgZ.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dU(boolean z) {
                d.this.chb = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dV(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dW(boolean z) {
                d.this.cgZ.abe();
                d.this.cgZ = null;
                d.this.cha = null;
                d.this.u(2, z);
            }
        };
        this.cgX = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dT(boolean z) {
                if (z) {
                    d.this.cgW.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dU(boolean z) {
                d.this.cgY = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dV(boolean z) {
                boolean unused = d.cgV = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dW(boolean z) {
                d.this.cgW.abe();
                d.this.cgW = null;
                d.this.cgX = null;
                d.this.u(4, z);
            }
        };
        this.cgU = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dX(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dY(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.cgT.abq();
                    d.this.cgT = null;
                }
                d.this.cgU = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean aaU() {
        boolean z = true;
        if (this.cgW != null && this.cgW.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.cgW.stopRecording();
            this.cgW.abe();
            z = false;
        }
        if (this.cgZ != null && this.cgZ.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.cgZ.stopRecording();
            this.cgZ.abe();
            z = false;
        }
        if (this.cgu != null && !this.cgT.a(this.cgu.getOutputFile(), this.cgu.getOutputFormat(), this.cgU)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void aaV() {
        if (this.cgW != null) {
            this.cgW.a(this.cgu, this.cgT, this.cgX);
        }
    }

    private void aaW() {
        aaY();
        this.cgZ.a(this.chc, this.cgu, this.cgT, this.cha);
    }

    private void aaX() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.cgP);
        if (this.cgR != null) {
            this.cgP = true;
            this.cgR.sendMessageDelayed(this.cgR.obtainMessage(7005), 500L);
        }
    }

    private void aaY() {
        aaZ();
    }

    private void aaZ() {
        if (this.chc != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.chc.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a aaz = it.next().aaz();
                if (aaz.aam() == MirrorType.NO_MIRROR) {
                    aaz.fw(-this.chd);
                } else {
                    aaz.fw(this.chd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + cgK);
        if (aba()) {
            this.cgR.sendMessage(this.cgR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(abb())));
        }
    }

    private static void fy(int i) {
        cgK = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            cgK |= i;
        }
        this.cgL++;
    }

    private boolean aba() {
        if (this.cgu == null) {
            return false;
        }
        return this.cgu.isAudioIncluded() ? this.cgL == 3 : this.cgL == 2;
    }

    private synchronized boolean abb() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + cgK);
        i = (cgK ^ 1) ^ 2;
        if (this.cgu != null) {
            if (this.cgu.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + cgK);
        if (abc() && this.cgR != null) {
            this.cgR.sendMessage(this.cgR.obtainMessage(7003, Boolean.valueOf(abd())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            cgK ^= i;
        }
        this.cgL--;
    }

    private boolean abc() {
        return this.cgL == 0;
    }

    private synchronized boolean abd() {
        return cgK == 0;
    }

    public void bK(long j) {
        this.cgQ *= TimeUtils.NANOS_PER_MS;
        if (this.cgt != null) {
            this.cgt.bJ(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.cgt != null) {
                        d.this.cgt.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.cgO = false;
                    break;
                case 7002:
                    if (d.this.cgt != null) {
                        d.this.cgt.bJ(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.cgt != null) {
                        if (d.this.cgu != null) {
                            str = d.this.cgu.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.cgt.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.cgt != null) {
                        d.this.cgt.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.aaP();
                    break;
                case 7006:
                    d.this.cgO = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
