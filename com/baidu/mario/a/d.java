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
    private static volatile int byV = 0;
    private static volatile boolean bzg = false;
    private static volatile d bzp;
    private e byE;
    private com.baidu.mario.a.b.d byF;
    private HandlerThread byY;
    private a bzc;
    private f bzd;
    private com.baidu.mario.a.b.e bze;
    private com.baidu.mario.a.b.f bzf;
    private com.baidu.mario.a.a.a bzh;
    private com.baidu.mario.a.b.c bzi;
    private com.baidu.mario.a.a.b bzk;
    private com.baidu.mario.a.b.c bzl;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bzn;
    private int bzo;
    private Context mContext;
    private int byW = 0;
    private boolean byX = false;
    private volatile boolean byZ = false;
    private boolean bza = false;
    private long bzb = 0;
    private volatile boolean bzj = false;
    private volatile boolean bzm = false;

    public static d Se() {
        if (bzp == null) {
            synchronized (d.class) {
                if (bzp == null) {
                    bzp = new d();
                }
            }
        }
        return bzp;
    }

    private d() {
    }

    public long Sf() {
        if (this.bzk != null) {
            return this.bzk.Sf();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.byZ);
        if (this.byZ) {
            Si();
            return;
        }
        this.byZ = true;
        this.mContext = context;
        this.byF = dVar;
        this.byE = eVar;
        Sg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sg() {
        Sj();
        Sk();
        if (Sl()) {
            Sm();
            Sn();
        } else if (!this.bza) {
            So();
        } else {
            Si();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bzk != null && this.bzk.isRunning() && this.bzm && bzg) {
            this.bzk.aF(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bzj && this.bzh != null && this.bzh.isRunning()) {
            this.bzh.d(byteBuffer, i, j);
        }
    }

    public void Sh() {
        if (this.bzk != null) {
            this.bzk.SA();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.byZ);
        if (this.byZ) {
            if (!Ss() && this.bzc != null) {
                this.bzc.sendMessage(this.bzc.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bzc != null) {
                this.bzc.sendMessageDelayed(this.bzc.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bzj = false;
        this.bzm = false;
        this.bzb = 0L;
        if (this.bzh != null && this.bzh.isRunning()) {
            this.bzh.stopRecording();
        }
        if (this.bzk != null && this.bzk.isRunning()) {
            this.bzk.stopRecording();
        }
        cO(false);
    }

    public void onDestroy() {
        if (this.bzn != null) {
            this.bzn.clear();
            this.bzn = null;
        }
        this.bzd = null;
        this.mContext = null;
        this.byF = null;
        fG(0);
        releaseInstance();
        if (this.bzc != null) {
            this.bzc.removeCallbacksAndMessages(null);
            this.bzc = null;
        }
        if (this.byY != null) {
            this.byY.quit();
            this.byY = null;
        }
    }

    private static void releaseInstance() {
        bzp = null;
    }

    private static void cO(boolean z) {
        bzg = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bzn == null) {
                this.bzn = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bzn.size()) {
                    break;
                }
                if (this.bzn.get(i3).RU() == cVar.RU()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bzn.size()) {
                if (this.bzn.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bzn.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bzn.add(cVar.clone());
            } else {
                this.bzn.add(cVar);
            }
            Collections.sort(this.bzn);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bzk != null) {
            a(cVar, z);
            this.bzk.q(this.bzn);
        }
    }

    private void Si() {
        if (this.bzc != null) {
            this.bzc.sendMessageDelayed(this.bzc.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Sj() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bze = new com.baidu.mario.a.b.e();
        }
        if (this.byF.isAudioIncluded()) {
            this.bzh = new com.baidu.mario.a.a.a();
        } else {
            bzg = true;
        }
        this.bzk = new com.baidu.mario.a.a.b();
        this.byW = 0;
        if (!this.byX && this.byY == null) {
            this.byY = new HandlerThread(TAG);
            this.byY.start();
        }
        if (this.bzc == null) {
            if (this.byY != null) {
                this.bzc = new a(this.byY.getLooper());
            } else {
                this.bzc = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bzc.removeCallbacksAndMessages(null);
        }
        this.bzd = new f(this.byF.getOutputTotalMs());
    }

    private void Sk() {
        this.bzl = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cP(boolean z) {
                if (z) {
                    d.this.bzk.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
                d.this.bzm = z;
                d.this.p(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cS(boolean z) {
                d.this.bzk.Sv();
                d.this.bzk = null;
                d.this.bzl = null;
                d.this.r(2, z);
            }
        };
        this.bzi = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cP(boolean z) {
                if (z) {
                    d.this.bzh.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
                d.this.bzj = z;
                d.this.p(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
                boolean unused = d.bzg = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cS(boolean z) {
                d.this.bzh.Sv();
                d.this.bzh = null;
                d.this.bzi = null;
                d.this.r(4, z);
            }
        };
        this.bzf = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cT(boolean z) {
                d.this.p(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cU(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bze.SL();
                    d.this.bze = null;
                }
                d.this.bzf = null;
                d.this.r(1, z);
            }
        };
    }

    private boolean Sl() {
        boolean z = true;
        if (this.bzh != null && this.bzh.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bzh.stopRecording();
            this.bzh.Sv();
            z = false;
        }
        if (this.bzk != null && this.bzk.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bzk.stopRecording();
            this.bzk.Sv();
            z = false;
        }
        if (this.byF != null && !this.bze.a(this.byF.getOutputFile(), this.byF.getOutputFormat(), this.bzf)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Sm() {
        if (this.bzh != null) {
            this.bzh.a(this.byF, this.bze, this.bzi);
        }
    }

    private void Sn() {
        Sp();
        this.bzk.a(this.bzn, this.byF, this.bze, this.bzl);
    }

    private void So() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bza);
        if (this.bzc != null) {
            this.bza = true;
            this.bzc.sendMessageDelayed(this.bzc.obtainMessage(7005), 500L);
        }
    }

    private void Sp() {
        Sq();
    }

    private void Sq() {
        if (this.bzn != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bzn.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a RQ = it.next().RQ();
                if (RQ.RC() == MirrorType.NO_MIRROR) {
                    RQ.fE(-this.bzo);
                } else {
                    RQ.fE(this.bzo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        q(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + byV);
        if (Sr()) {
            this.bzc.sendMessage(this.bzc.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Ss())));
        }
    }

    private static void fG(int i) {
        byV = i;
    }

    private void q(int i, boolean z) {
        if (z) {
            byV |= i;
        }
        this.byW++;
    }

    private boolean Sr() {
        if (this.byF == null) {
            return false;
        }
        return this.byF.isAudioIncluded() ? this.byW == 3 : this.byW == 2;
    }

    private synchronized boolean Ss() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + byV);
        i = (byV ^ 1) ^ 2;
        if (this.byF != null) {
            if (this.byF.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + byV);
        if (St() && this.bzc != null) {
            this.bzc.sendMessage(this.bzc.obtainMessage(7003, Boolean.valueOf(Su())));
        }
    }

    private void t(int i, boolean z) {
        if (z) {
            byV ^= i;
        }
        this.byW--;
    }

    private boolean St() {
        return this.byW == 0;
    }

    private synchronized boolean Su() {
        return byV == 0;
    }

    public void aI(long j) {
        this.bzb *= TimeUtils.NANOS_PER_MS;
        if (this.byE != null) {
            this.byE.aH(j);
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
                    if (d.this.byE != null) {
                        d.this.byE.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.byZ = false;
                    break;
                case 7002:
                    if (d.this.byE != null) {
                        d.this.byE.aH(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.byE != null) {
                        if (d.this.byF != null) {
                            str = d.this.byF.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.byE.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.byE != null) {
                        d.this.byE.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Sg();
                    break;
                case 7006:
                    d.this.byZ = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
