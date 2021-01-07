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
/* loaded from: classes3.dex */
public class d {
    private static volatile d chI;
    private e cgX;
    private com.baidu.mario.a.b.d cgY;
    private com.baidu.mario.a.a.a chA;
    private com.baidu.mario.a.b.c chB;
    private com.baidu.mario.a.a.b chD;
    private com.baidu.mario.a.b.c chE;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> chG;
    private int chH;
    private HandlerThread chr;
    private a chv;
    private f chw;
    private com.baidu.mario.a.b.e chx;
    private com.baidu.mario.a.b.f chy;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int cho = 0;
    private static volatile boolean chz = false;
    private int chp = 0;
    private boolean chq = false;
    private volatile boolean chs = false;
    private boolean cht = false;
    private long chu = 0;
    private volatile boolean chC = false;
    private volatile boolean chF = false;

    public static d acN() {
        if (chI == null) {
            synchronized (d.class) {
                if (chI == null) {
                    chI = new d();
                }
            }
        }
        return chI;
    }

    private d() {
    }

    public long acO() {
        if (this.chD != null) {
            return this.chD.acO();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.chs);
        if (this.chs) {
            acR();
            return;
        }
        this.chs = true;
        this.mContext = context;
        this.cgY = dVar;
        this.cgX = eVar;
        acP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acP() {
        acS();
        acT();
        if (acU()) {
            acV();
            acW();
        } else if (!this.cht) {
            acX();
        } else {
            acR();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.chD != null && this.chD.isRunning() && this.chF && chz) {
            this.chD.bD(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.chC && this.chA != null && this.chA.isRunning()) {
            this.chA.d(byteBuffer, i, j);
        }
    }

    public void acQ() {
        if (this.chD != null) {
            this.chD.adj();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.chs);
        if (this.chs) {
            if (!adb() && this.chv != null) {
                this.chv.sendMessage(this.chv.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.chv != null) {
                this.chv.sendMessageDelayed(this.chv.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.chC = false;
        this.chF = false;
        this.chu = 0L;
        if (this.chA != null && this.chA.isRunning()) {
            this.chA.stopRecording();
        }
        if (this.chD != null && this.chD.isRunning()) {
            this.chD.stopRecording();
        }
        dO(false);
    }

    public void onDestroy() {
        if (this.chG != null) {
            this.chG.clear();
            this.chG = null;
        }
        this.chw = null;
        this.mContext = null;
        this.cgY = null;
        gZ(0);
        releaseInstance();
        if (this.chv != null) {
            this.chv.removeCallbacksAndMessages(null);
            this.chv = null;
        }
        if (this.chr != null) {
            this.chr.quit();
            this.chr = null;
        }
    }

    private static void releaseInstance() {
        chI = null;
    }

    private static void dO(boolean z) {
        chz = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.chG == null) {
                this.chG = new ArrayList<>();
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.chG.size()) {
                    break;
                }
                if (this.chG.get(i3).acD() == cVar.acD()) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            if (i >= 0 && i < this.chG.size()) {
                if (this.chG.get(i).getEGLContext() != cVar.getEGLContext()) {
                    this.chG.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                this.chG.add(cVar.clone());
            } else {
                this.chG.add(cVar);
            }
            Collections.sort(this.chG);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.chD != null) {
            a(cVar, z);
            this.chD.q(this.chG);
        }
    }

    private void acR() {
        if (this.chv != null) {
            this.chv.sendMessageDelayed(this.chv.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void acS() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.chx = new com.baidu.mario.a.b.e();
        }
        if (this.cgY.isAudioIncluded()) {
            this.chA = new com.baidu.mario.a.a.a();
        } else {
            chz = true;
        }
        this.chD = new com.baidu.mario.a.a.b();
        this.chp = 0;
        if (!this.chq && this.chr == null) {
            this.chr = new HandlerThread(TAG);
            this.chr.start();
        }
        if (this.chv == null) {
            if (this.chr != null) {
                this.chv = new a(this.chr.getLooper());
            } else {
                this.chv = new a(this.mContext.getMainLooper());
            }
        } else {
            this.chv.removeCallbacksAndMessages(null);
        }
        this.chw = new f(this.cgY.getOutputTotalMs());
    }

    private void acT() {
        this.chE = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dP(boolean z) {
                if (z) {
                    d.this.chD.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dQ(boolean z) {
                d.this.chF = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dR(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dS(boolean z) {
                d.this.chD.ade();
                d.this.chD = null;
                d.this.chE = null;
                d.this.u(2, z);
            }
        };
        this.chB = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dP(boolean z) {
                if (z) {
                    d.this.chA.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dQ(boolean z) {
                d.this.chC = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dR(boolean z) {
                boolean unused = d.chz = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dS(boolean z) {
                d.this.chA.ade();
                d.this.chA = null;
                d.this.chB = null;
                d.this.u(4, z);
            }
        };
        this.chy = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dT(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dU(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.chx.adu();
                    d.this.chx = null;
                }
                d.this.chy = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean acU() {
        boolean z = true;
        if (this.chA != null && this.chA.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.chA.stopRecording();
            this.chA.ade();
            z = false;
        }
        if (this.chD != null && this.chD.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.chD.stopRecording();
            this.chD.ade();
            z = false;
        }
        if (this.cgY != null && !this.chx.a(this.cgY.getOutputFile(), this.cgY.getOutputFormat(), this.chy)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void acV() {
        if (this.chA != null) {
            this.chA.a(this.cgY, this.chx, this.chB);
        }
    }

    private void acW() {
        acY();
        this.chD.a(this.chG, this.cgY, this.chx, this.chE);
    }

    private void acX() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.cht);
        if (this.chv != null) {
            this.cht = true;
            this.chv.sendMessageDelayed(this.chv.obtainMessage(7005), 500L);
        }
    }

    private void acY() {
        acZ();
    }

    private void acZ() {
        if (this.chG != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.chG.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a acz = it.next().acz();
                if (acz.acm() == MirrorType.NO_MIRROR) {
                    acz.gX(-this.chH);
                } else {
                    acz.gX(this.chH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + cho);
        if (ada()) {
            this.chv.sendMessage(this.chv.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(adb())));
        }
    }

    private static void gZ(int i) {
        cho = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            cho |= i;
        }
        this.chp++;
    }

    private boolean ada() {
        if (this.cgY == null) {
            return false;
        }
        return this.cgY.isAudioIncluded() ? this.chp == 3 : this.chp == 2;
    }

    private synchronized boolean adb() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + cho);
        i = (cho ^ 1) ^ 2;
        if (this.cgY != null) {
            if (this.cgY.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + cho);
        if (adc() && this.chv != null) {
            this.chv.sendMessage(this.chv.obtainMessage(7003, Boolean.valueOf(add())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            cho ^= i;
        }
        this.chp--;
    }

    private boolean adc() {
        return this.chp == 0;
    }

    private synchronized boolean add() {
        return cho == 0;
    }

    public void bG(long j) {
        this.chu *= TimeUtils.NANOS_PER_MS;
        if (this.cgX != null) {
            this.cgX.bF(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.cgX != null) {
                        d.this.cgX.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.chs = false;
                    break;
                case 7002:
                    if (d.this.cgX != null) {
                        d.this.cgX.bF(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.cgX != null) {
                        if (d.this.cgY != null) {
                            str = d.this.cgY.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.cgX.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.cgX != null) {
                        d.this.cgX.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.acP();
                    break;
                case 7006:
                    d.this.chs = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
