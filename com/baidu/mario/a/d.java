package com.baidu.mario.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.recorder.MovieRecorder;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int byS = 0;
    private static volatile boolean bzd = false;
    private static volatile d bzm;
    private e byB;
    private com.baidu.mario.a.b.d byC;
    private HandlerThread byV;
    private a byZ;
    private f bza;
    private com.baidu.mario.a.b.e bzb;
    private com.baidu.mario.a.b.f bzc;
    private com.baidu.mario.a.a.a bze;
    private com.baidu.mario.a.b.c bzf;
    private com.baidu.mario.a.a.b bzh;
    private com.baidu.mario.a.b.c bzi;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bzk;
    private int bzl;
    private Context mContext;
    private int byT = 0;
    private boolean byU = false;
    private volatile boolean byW = false;
    private boolean byX = false;
    private long byY = 0;
    private volatile boolean bzg = false;
    private volatile boolean bzj = false;

    public static d Se() {
        if (bzm == null) {
            synchronized (d.class) {
                if (bzm == null) {
                    bzm = new d();
                }
            }
        }
        return bzm;
    }

    private d() {
    }

    public long Sf() {
        if (this.bzh != null) {
            return this.bzh.Sf();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.byW);
        if (this.byW) {
            Si();
            return;
        }
        this.byW = true;
        this.mContext = context;
        this.byC = dVar;
        this.byB = eVar;
        Sg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sg() {
        Sj();
        Sk();
        if (Sl()) {
            Sm();
            Sn();
        } else if (!this.byX) {
            So();
        } else {
            Si();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bzh != null && this.bzh.isRunning() && this.bzj && bzd) {
            this.bzh.aF(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bzg && this.bze != null && this.bze.isRunning()) {
            this.bze.d(byteBuffer, i, j);
        }
    }

    public void Sh() {
        if (this.bzh != null) {
            this.bzh.SA();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.byW);
        if (this.byW) {
            if (!Ss() && this.byZ != null) {
                this.byZ.sendMessage(this.byZ.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.byZ != null) {
                this.byZ.sendMessageDelayed(this.byZ.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bzg = false;
        this.bzj = false;
        this.byY = 0L;
        if (this.bze != null && this.bze.isRunning()) {
            this.bze.stopRecording();
        }
        if (this.bzh != null && this.bzh.isRunning()) {
            this.bzh.stopRecording();
        }
        cN(false);
    }

    public void onDestroy() {
        if (this.bzk != null) {
            this.bzk.clear();
            this.bzk = null;
        }
        this.bza = null;
        this.mContext = null;
        this.byC = null;
        fG(0);
        releaseInstance();
        if (this.byZ != null) {
            this.byZ.removeCallbacksAndMessages(null);
            this.byZ = null;
        }
        if (this.byV != null) {
            this.byV.quit();
            this.byV = null;
        }
    }

    private static void releaseInstance() {
        bzm = null;
    }

    private static void cN(boolean z) {
        bzd = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bzk == null) {
                this.bzk = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bzk.size()) {
                    break;
                }
                if (this.bzk.get(i3).RU() == cVar.RU()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bzk.size()) {
                if (this.bzk.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bzk.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bzk.add(cVar.clone());
            } else {
                this.bzk.add(cVar);
            }
            Collections.sort(this.bzk);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bzh != null) {
            a(cVar, z);
            this.bzh.q(this.bzk);
        }
    }

    private void Si() {
        if (this.byZ != null) {
            this.byZ.sendMessageDelayed(this.byZ.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Sj() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bzb = new com.baidu.mario.a.b.e();
        }
        if (this.byC.isAudioIncluded()) {
            this.bze = new com.baidu.mario.a.a.a();
        } else {
            bzd = true;
        }
        this.bzh = new com.baidu.mario.a.a.b();
        this.byT = 0;
        if (!this.byU && this.byV == null) {
            this.byV = new HandlerThread(TAG);
            this.byV.start();
        }
        if (this.byZ == null) {
            if (this.byV != null) {
                this.byZ = new a(this.byV.getLooper());
            } else {
                this.byZ = new a(this.mContext.getMainLooper());
            }
        } else {
            this.byZ.removeCallbacksAndMessages(null);
        }
        this.bza = new f(this.byC.getOutputTotalMs());
    }

    private void Sk() {
        this.bzi = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cO(boolean z) {
                if (z) {
                    d.this.bzh.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cP(boolean z) {
                d.this.bzj = z;
                d.this.p(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
                d.this.bzh.Sv();
                d.this.bzh = null;
                d.this.bzi = null;
                d.this.r(2, z);
            }
        };
        this.bzf = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cO(boolean z) {
                if (z) {
                    d.this.bze.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cP(boolean z) {
                d.this.bzg = z;
                d.this.p(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
                boolean unused = d.bzd = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
                d.this.bze.Sv();
                d.this.bze = null;
                d.this.bzf = null;
                d.this.r(4, z);
            }
        };
        this.bzc = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cS(boolean z) {
                d.this.p(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cT(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bzb.SL();
                    d.this.bzb = null;
                }
                d.this.bzc = null;
                d.this.r(1, z);
            }
        };
    }

    private boolean Sl() {
        boolean z = true;
        if (this.bze != null && this.bze.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bze.stopRecording();
            this.bze.Sv();
            z = false;
        }
        if (this.bzh != null && this.bzh.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bzh.stopRecording();
            this.bzh.Sv();
            z = false;
        }
        if (this.byC != null && !this.bzb.a(this.byC.getOutputFile(), this.byC.getOutputFormat(), this.bzc)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Sm() {
        if (this.bze != null) {
            this.bze.a(this.byC, this.bzb, this.bzf);
        }
    }

    private void Sn() {
        Sp();
        this.bzh.a(this.bzk, this.byC, this.bzb, this.bzi);
    }

    private void So() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.byX);
        if (this.byZ != null) {
            this.byX = true;
            this.byZ.sendMessageDelayed(this.byZ.obtainMessage(7005), 500L);
        }
    }

    private void Sp() {
        Sq();
    }

    private void Sq() {
        if (this.bzk != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bzk.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a RQ = it.next().RQ();
                if (RQ.RC() == MirrorType.NO_MIRROR) {
                    RQ.fE(-this.bzl);
                } else {
                    RQ.fE(this.bzl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        q(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + byS);
        if (Sr()) {
            this.byZ.sendMessage(this.byZ.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Ss())));
        }
    }

    private static void fG(int i) {
        byS = i;
    }

    private void q(int i, boolean z) {
        if (z) {
            byS |= i;
        }
        this.byT++;
    }

    private boolean Sr() {
        if (this.byC == null) {
            return false;
        }
        return this.byC.isAudioIncluded() ? this.byT == 3 : this.byT == 2;
    }

    private synchronized boolean Ss() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + byS);
        i = (byS ^ 1) ^ 2;
        if (this.byC != null) {
            if (this.byC.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + byS);
        if (St() && this.byZ != null) {
            this.byZ.sendMessage(this.byZ.obtainMessage(7003, Boolean.valueOf(Su())));
        }
    }

    private void t(int i, boolean z) {
        if (z) {
            byS ^= i;
        }
        this.byT--;
    }

    private boolean St() {
        return this.byT == 0;
    }

    private synchronized boolean Su() {
        return byS == 0;
    }

    public void aI(long j) {
        this.byY *= TimeUtils.NANOS_PER_MS;
        if (this.byB != null) {
            this.byB.aH(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.byB != null) {
                        d.this.byB.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.byW = false;
                    break;
                case 7002:
                    if (d.this.byB != null) {
                        d.this.byB.aH(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.byB != null) {
                        if (d.this.byC != null) {
                            str = d.this.byC.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.byB.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.byB != null) {
                        d.this.byB.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Sg();
                    break;
                case 7006:
                    d.this.byW = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
