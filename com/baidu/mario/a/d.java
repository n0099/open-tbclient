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
/* loaded from: classes14.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int caE = 0;
    private static volatile boolean caP = false;
    private static volatile d caY;
    private HandlerThread caH;
    private a caL;
    private f caM;
    private com.baidu.mario.a.b.e caN;
    private com.baidu.mario.a.b.f caO;
    private com.baidu.mario.a.a.a caQ;
    private com.baidu.mario.a.b.c caR;
    private com.baidu.mario.a.a.b caT;
    private com.baidu.mario.a.b.c caU;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> caW;
    private int caX;
    private e can;
    private com.baidu.mario.a.b.d cao;
    private Context mContext;
    private int caF = 0;
    private boolean caG = false;
    private volatile boolean caI = false;
    private boolean caJ = false;
    private long caK = 0;
    private volatile boolean caS = false;
    private volatile boolean caV = false;

    public static d abb() {
        if (caY == null) {
            synchronized (d.class) {
                if (caY == null) {
                    caY = new d();
                }
            }
        }
        return caY;
    }

    private d() {
    }

    public long abc() {
        if (this.caT != null) {
            return this.caT.abc();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.caI);
        if (this.caI) {
            abf();
            return;
        }
        this.caI = true;
        this.mContext = context;
        this.cao = dVar;
        this.can = eVar;
        abd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abd() {
        abg();
        abh();
        if (abi()) {
            abj();
            abk();
        } else if (!this.caJ) {
            abl();
        } else {
            abf();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.caT != null && this.caT.isRunning() && this.caV && caP) {
            this.caT.bD(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.caS && this.caQ != null && this.caQ.isRunning()) {
            this.caQ.d(byteBuffer, i, j);
        }
    }

    public void abe() {
        if (this.caT != null) {
            this.caT.abx();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.caI);
        if (this.caI) {
            if (!abp() && this.caL != null) {
                this.caL.sendMessage(this.caL.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.caL != null) {
                this.caL.sendMessageDelayed(this.caL.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.caS = false;
        this.caV = false;
        this.caK = 0L;
        if (this.caQ != null && this.caQ.isRunning()) {
            this.caQ.stopRecording();
        }
        if (this.caT != null && this.caT.isRunning()) {
            this.caT.stopRecording();
        }
        dH(false);
    }

    public void onDestroy() {
        if (this.caW != null) {
            this.caW.clear();
            this.caW = null;
        }
        this.caM = null;
        this.mContext = null;
        this.cao = null;
        gY(0);
        releaseInstance();
        if (this.caL != null) {
            this.caL.removeCallbacksAndMessages(null);
            this.caL = null;
        }
        if (this.caH != null) {
            this.caH.quit();
            this.caH = null;
        }
    }

    private static void releaseInstance() {
        caY = null;
    }

    private static void dH(boolean z) {
        caP = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.caW == null) {
                this.caW = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.caW.size()) {
                    break;
                }
                if (this.caW.get(i3).aaR() == cVar.aaR()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.caW.size()) {
                if (this.caW.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.caW.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.caW.add(cVar.clone());
            } else {
                this.caW.add(cVar);
            }
            Collections.sort(this.caW);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.caT != null) {
            a(cVar, z);
            this.caT.q(this.caW);
        }
    }

    private void abf() {
        if (this.caL != null) {
            this.caL.sendMessageDelayed(this.caL.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void abg() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.caN = new com.baidu.mario.a.b.e();
        }
        if (this.cao.isAudioIncluded()) {
            this.caQ = new com.baidu.mario.a.a.a();
        } else {
            caP = true;
        }
        this.caT = new com.baidu.mario.a.a.b();
        this.caF = 0;
        if (!this.caG && this.caH == null) {
            this.caH = new HandlerThread(TAG);
            this.caH.start();
        }
        if (this.caL == null) {
            if (this.caH != null) {
                this.caL = new a(this.caH.getLooper());
            } else {
                this.caL = new a(this.mContext.getMainLooper());
            }
        } else {
            this.caL.removeCallbacksAndMessages(null);
        }
        this.caM = new f(this.cao.getOutputTotalMs());
    }

    private void abh() {
        this.caU = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dI(boolean z) {
                if (z) {
                    d.this.caT.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dJ(boolean z) {
                d.this.caV = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dK(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dL(boolean z) {
                d.this.caT.abs();
                d.this.caT = null;
                d.this.caU = null;
                d.this.u(2, z);
            }
        };
        this.caR = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dI(boolean z) {
                if (z) {
                    d.this.caQ.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dJ(boolean z) {
                d.this.caS = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dK(boolean z) {
                boolean unused = d.caP = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dL(boolean z) {
                d.this.caQ.abs();
                d.this.caQ = null;
                d.this.caR = null;
                d.this.u(4, z);
            }
        };
        this.caO = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dM(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dN(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.caN.abI();
                    d.this.caN = null;
                }
                d.this.caO = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean abi() {
        boolean z = true;
        if (this.caQ != null && this.caQ.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.caQ.stopRecording();
            this.caQ.abs();
            z = false;
        }
        if (this.caT != null && this.caT.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.caT.stopRecording();
            this.caT.abs();
            z = false;
        }
        if (this.cao != null && !this.caN.a(this.cao.getOutputFile(), this.cao.getOutputFormat(), this.caO)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void abj() {
        if (this.caQ != null) {
            this.caQ.a(this.cao, this.caN, this.caR);
        }
    }

    private void abk() {
        abm();
        this.caT.a(this.caW, this.cao, this.caN, this.caU);
    }

    private void abl() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.caJ);
        if (this.caL != null) {
            this.caJ = true;
            this.caL.sendMessageDelayed(this.caL.obtainMessage(7005), 500L);
        }
    }

    private void abm() {
        abn();
    }

    private void abn() {
        if (this.caW != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.caW.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a aaN = it.next().aaN();
                if (aaN.aaz() == MirrorType.NO_MIRROR) {
                    aaN.gW(-this.caX);
                } else {
                    aaN.gW(this.caX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + caE);
        if (abo()) {
            this.caL.sendMessage(this.caL.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(abp())));
        }
    }

    private static void gY(int i) {
        caE = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            caE |= i;
        }
        this.caF++;
    }

    private boolean abo() {
        if (this.cao == null) {
            return false;
        }
        return this.cao.isAudioIncluded() ? this.caF == 3 : this.caF == 2;
    }

    private synchronized boolean abp() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + caE);
        i = (caE ^ 1) ^ 2;
        if (this.cao != null) {
            if (this.cao.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + caE);
        if (abq() && this.caL != null) {
            this.caL.sendMessage(this.caL.obtainMessage(7003, Boolean.valueOf(abr())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            caE ^= i;
        }
        this.caF--;
    }

    private boolean abq() {
        return this.caF == 0;
    }

    private synchronized boolean abr() {
        return caE == 0;
    }

    public void bG(long j) {
        this.caK *= TimeUtils.NANOS_PER_MS;
        if (this.can != null) {
            this.can.bF(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.can != null) {
                        d.this.can.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.caI = false;
                    break;
                case 7002:
                    if (d.this.can != null) {
                        d.this.can.bF(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.can != null) {
                        if (d.this.cao != null) {
                            str = d.this.cao.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.can.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.can != null) {
                        d.this.can.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.abd();
                    break;
                case 7006:
                    d.this.caI = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
