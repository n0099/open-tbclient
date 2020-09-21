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
/* loaded from: classes4.dex */
public class d {
    private static volatile d bCM;
    private f bCA;
    private com.baidu.mario.a.b.e bCB;
    private com.baidu.mario.a.b.f bCC;
    private com.baidu.mario.a.a.a bCE;
    private com.baidu.mario.a.b.c bCF;
    private com.baidu.mario.a.a.b bCH;
    private com.baidu.mario.a.b.c bCI;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bCK;
    private int bCL;
    private e bCb;
    private com.baidu.mario.a.b.d bCc;
    private HandlerThread bCv;
    private a bCz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bCs = 0;
    private static volatile boolean bCD = false;
    private int bCt = 0;
    private boolean bCu = false;
    private volatile boolean bCw = false;
    private boolean bCx = false;
    private long bCy = 0;
    private volatile boolean bCG = false;
    private volatile boolean bCJ = false;

    public static d SV() {
        if (bCM == null) {
            synchronized (d.class) {
                if (bCM == null) {
                    bCM = new d();
                }
            }
        }
        return bCM;
    }

    private d() {
    }

    public long SW() {
        if (this.bCH != null) {
            return this.bCH.SW();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bCw);
        if (this.bCw) {
            SZ();
            return;
        }
        this.bCw = true;
        this.mContext = context;
        this.bCc = dVar;
        this.bCb = eVar;
        SX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SX() {
        Ta();
        Tb();
        if (Tc()) {
            Td();
            Te();
        } else if (!this.bCx) {
            Tf();
        } else {
            SZ();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bCH != null && this.bCH.isRunning() && this.bCJ && bCD) {
            this.bCH.aF(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bCG && this.bCE != null && this.bCE.isRunning()) {
            this.bCE.d(byteBuffer, i, j);
        }
    }

    public void SY() {
        if (this.bCH != null) {
            this.bCH.Tr();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bCw);
        if (this.bCw) {
            if (!Tj() && this.bCz != null) {
                this.bCz.sendMessage(this.bCz.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bCz != null) {
                this.bCz.sendMessageDelayed(this.bCz.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bCG = false;
        this.bCJ = false;
        this.bCy = 0L;
        if (this.bCE != null && this.bCE.isRunning()) {
            this.bCE.stopRecording();
        }
        if (this.bCH != null && this.bCH.isRunning()) {
            this.bCH.stopRecording();
        }
        cP(false);
    }

    public void onDestroy() {
        if (this.bCK != null) {
            this.bCK.clear();
            this.bCK = null;
        }
        this.bCA = null;
        this.mContext = null;
        this.bCc = null;
        fP(0);
        releaseInstance();
        if (this.bCz != null) {
            this.bCz.removeCallbacksAndMessages(null);
            this.bCz = null;
        }
        if (this.bCv != null) {
            this.bCv.quit();
            this.bCv = null;
        }
    }

    private static void releaseInstance() {
        bCM = null;
    }

    private static void cP(boolean z) {
        bCD = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bCK == null) {
                this.bCK = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bCK.size()) {
                    break;
                }
                if (this.bCK.get(i3).SL() == cVar.SL()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bCK.size()) {
                if (this.bCK.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bCK.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bCK.add(cVar.clone());
            } else {
                this.bCK.add(cVar);
            }
            Collections.sort(this.bCK);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bCH != null) {
            a(cVar, z);
            this.bCH.q(this.bCK);
        }
    }

    private void SZ() {
        if (this.bCz != null) {
            this.bCz.sendMessageDelayed(this.bCz.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Ta() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bCB = new com.baidu.mario.a.b.e();
        }
        if (this.bCc.isAudioIncluded()) {
            this.bCE = new com.baidu.mario.a.a.a();
        } else {
            bCD = true;
        }
        this.bCH = new com.baidu.mario.a.a.b();
        this.bCt = 0;
        if (!this.bCu && this.bCv == null) {
            this.bCv = new HandlerThread(TAG);
            this.bCv.start();
        }
        if (this.bCz == null) {
            if (this.bCv != null) {
                this.bCz = new a(this.bCv.getLooper());
            } else {
                this.bCz = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bCz.removeCallbacksAndMessages(null);
        }
        this.bCA = new f(this.bCc.getOutputTotalMs());
    }

    private void Tb() {
        this.bCI = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
                if (z) {
                    d.this.bCH.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
                d.this.bCJ = z;
                d.this.p(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cS(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cT(boolean z) {
                d.this.bCH.Tm();
                d.this.bCH = null;
                d.this.bCI = null;
                d.this.r(2, z);
            }
        };
        this.bCF = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cQ(boolean z) {
                if (z) {
                    d.this.bCE.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cR(boolean z) {
                d.this.bCG = z;
                d.this.p(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cS(boolean z) {
                boolean unused = d.bCD = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cT(boolean z) {
                d.this.bCE.Tm();
                d.this.bCE = null;
                d.this.bCF = null;
                d.this.r(4, z);
            }
        };
        this.bCC = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cU(boolean z) {
                d.this.p(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cV(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bCB.TC();
                    d.this.bCB = null;
                }
                d.this.bCC = null;
                d.this.r(1, z);
            }
        };
    }

    private boolean Tc() {
        boolean z = true;
        if (this.bCE != null && this.bCE.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bCE.stopRecording();
            this.bCE.Tm();
            z = false;
        }
        if (this.bCH != null && this.bCH.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bCH.stopRecording();
            this.bCH.Tm();
            z = false;
        }
        if (this.bCc != null && !this.bCB.a(this.bCc.getOutputFile(), this.bCc.getOutputFormat(), this.bCC)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Td() {
        if (this.bCE != null) {
            this.bCE.a(this.bCc, this.bCB, this.bCF);
        }
    }

    private void Te() {
        Tg();
        this.bCH.a(this.bCK, this.bCc, this.bCB, this.bCI);
    }

    private void Tf() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bCx);
        if (this.bCz != null) {
            this.bCx = true;
            this.bCz.sendMessageDelayed(this.bCz.obtainMessage(7005), 500L);
        }
    }

    private void Tg() {
        Th();
    }

    private void Th() {
        if (this.bCK != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bCK.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a SH = it.next().SH();
                if (SH.St() == MirrorType.NO_MIRROR) {
                    SH.fN(-this.bCL);
                } else {
                    SH.fN(this.bCL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        q(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bCs);
        if (Ti()) {
            this.bCz.sendMessage(this.bCz.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Tj())));
        }
    }

    private static void fP(int i) {
        bCs = i;
    }

    private void q(int i, boolean z) {
        if (z) {
            bCs |= i;
        }
        this.bCt++;
    }

    private boolean Ti() {
        if (this.bCc == null) {
            return false;
        }
        return this.bCc.isAudioIncluded() ? this.bCt == 3 : this.bCt == 2;
    }

    private synchronized boolean Tj() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bCs);
        i = (bCs ^ 1) ^ 2;
        if (this.bCc != null) {
            if (this.bCc.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bCs);
        if (Tk() && this.bCz != null) {
            this.bCz.sendMessage(this.bCz.obtainMessage(7003, Boolean.valueOf(Tl())));
        }
    }

    private void t(int i, boolean z) {
        if (z) {
            bCs ^= i;
        }
        this.bCt--;
    }

    private boolean Tk() {
        return this.bCt == 0;
    }

    private synchronized boolean Tl() {
        return bCs == 0;
    }

    public void aI(long j) {
        this.bCy *= TimeUtils.NANOS_PER_MS;
        if (this.bCb != null) {
            this.bCb.aH(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bCb != null) {
                        d.this.bCb.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bCw = false;
                    break;
                case 7002:
                    if (d.this.bCb != null) {
                        d.this.bCb.aH(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bCb != null) {
                        if (d.this.bCc != null) {
                            str = d.this.bCc.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bCb.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bCb != null) {
                        d.this.bCb.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.SX();
                    break;
                case 7006:
                    d.this.bCw = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
