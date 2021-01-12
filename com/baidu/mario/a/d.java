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
/* loaded from: classes14.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int ccA = 0;
    private static volatile boolean ccL = false;
    private static volatile d ccU;
    private HandlerThread ccD;
    private a ccH;
    private f ccI;
    private com.baidu.mario.a.b.e ccJ;
    private com.baidu.mario.a.b.f ccK;
    private com.baidu.mario.a.a.a ccM;
    private com.baidu.mario.a.b.c ccN;
    private com.baidu.mario.a.a.b ccP;
    private com.baidu.mario.a.b.c ccQ;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> ccS;
    private int ccT;
    private e cci;
    private com.baidu.mario.a.b.d ccj;
    private Context mContext;
    private int ccB = 0;
    private boolean ccC = false;
    private volatile boolean ccE = false;
    private boolean ccF = false;
    private long ccG = 0;
    private volatile boolean ccO = false;
    private volatile boolean ccR = false;

    public static d YU() {
        if (ccU == null) {
            synchronized (d.class) {
                if (ccU == null) {
                    ccU = new d();
                }
            }
        }
        return ccU;
    }

    private d() {
    }

    public long YV() {
        if (this.ccP != null) {
            return this.ccP.YV();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.ccE);
        if (this.ccE) {
            YY();
            return;
        }
        this.ccE = true;
        this.mContext = context;
        this.ccj = dVar;
        this.cci = eVar;
        YW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YW() {
        YZ();
        Za();
        if (Zb()) {
            Zc();
            Zd();
        } else if (!this.ccF) {
            Ze();
        } else {
            YY();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.ccP != null && this.ccP.isRunning() && this.ccR && ccL) {
            this.ccP.bD(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.ccO && this.ccM != null && this.ccM.isRunning()) {
            this.ccM.d(byteBuffer, i, j);
        }
    }

    public void YX() {
        if (this.ccP != null) {
            this.ccP.Zq();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.ccE);
        if (this.ccE) {
            if (!Zi() && this.ccH != null) {
                this.ccH.sendMessage(this.ccH.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.ccH != null) {
                this.ccH.sendMessageDelayed(this.ccH.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.ccO = false;
        this.ccR = false;
        this.ccG = 0L;
        if (this.ccM != null && this.ccM.isRunning()) {
            this.ccM.stopRecording();
        }
        if (this.ccP != null && this.ccP.isRunning()) {
            this.ccP.stopRecording();
        }
        dK(false);
    }

    public void onDestroy() {
        if (this.ccS != null) {
            this.ccS.clear();
            this.ccS = null;
        }
        this.ccI = null;
        this.mContext = null;
        this.ccj = null;
        fs(0);
        releaseInstance();
        if (this.ccH != null) {
            this.ccH.removeCallbacksAndMessages(null);
            this.ccH = null;
        }
        if (this.ccD != null) {
            this.ccD.quit();
            this.ccD = null;
        }
    }

    private static void releaseInstance() {
        ccU = null;
    }

    private static void dK(boolean z) {
        ccL = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.ccS == null) {
                this.ccS = new ArrayList<>();
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ccS.size()) {
                    break;
                }
                if (this.ccS.get(i3).YK() == cVar.YK()) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            if (i >= 0 && i < this.ccS.size()) {
                if (this.ccS.get(i).getEGLContext() != cVar.getEGLContext()) {
                    this.ccS.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                this.ccS.add(cVar.clone());
            } else {
                this.ccS.add(cVar);
            }
            Collections.sort(this.ccS);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.ccP != null) {
            a(cVar, z);
            this.ccP.l(this.ccS);
        }
    }

    private void YY() {
        if (this.ccH != null) {
            this.ccH.sendMessageDelayed(this.ccH.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void YZ() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ccJ = new com.baidu.mario.a.b.e();
        }
        if (this.ccj.isAudioIncluded()) {
            this.ccM = new com.baidu.mario.a.a.a();
        } else {
            ccL = true;
        }
        this.ccP = new com.baidu.mario.a.a.b();
        this.ccB = 0;
        if (!this.ccC && this.ccD == null) {
            this.ccD = new HandlerThread(TAG);
            this.ccD.start();
        }
        if (this.ccH == null) {
            if (this.ccD != null) {
                this.ccH = new a(this.ccD.getLooper());
            } else {
                this.ccH = new a(this.mContext.getMainLooper());
            }
        } else {
            this.ccH.removeCallbacksAndMessages(null);
        }
        this.ccI = new f(this.ccj.getOutputTotalMs());
    }

    private void Za() {
        this.ccQ = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dL(boolean z) {
                if (z) {
                    d.this.ccP.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dM(boolean z) {
                d.this.ccR = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dN(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dO(boolean z) {
                d.this.ccP.Zl();
                d.this.ccP = null;
                d.this.ccQ = null;
                d.this.u(2, z);
            }
        };
        this.ccN = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dL(boolean z) {
                if (z) {
                    d.this.ccM.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dM(boolean z) {
                d.this.ccO = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dN(boolean z) {
                boolean unused = d.ccL = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dO(boolean z) {
                d.this.ccM.Zl();
                d.this.ccM = null;
                d.this.ccN = null;
                d.this.u(4, z);
            }
        };
        this.ccK = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dP(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dQ(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.ccJ.ZB();
                    d.this.ccJ = null;
                }
                d.this.ccK = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean Zb() {
        boolean z = true;
        if (this.ccM != null && this.ccM.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.ccM.stopRecording();
            this.ccM.Zl();
            z = false;
        }
        if (this.ccP != null && this.ccP.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.ccP.stopRecording();
            this.ccP.Zl();
            z = false;
        }
        if (this.ccj != null && !this.ccJ.a(this.ccj.getOutputFile(), this.ccj.getOutputFormat(), this.ccK)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Zc() {
        if (this.ccM != null) {
            this.ccM.a(this.ccj, this.ccJ, this.ccN);
        }
    }

    private void Zd() {
        Zf();
        this.ccP.a(this.ccS, this.ccj, this.ccJ, this.ccQ);
    }

    private void Ze() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.ccF);
        if (this.ccH != null) {
            this.ccF = true;
            this.ccH.sendMessageDelayed(this.ccH.obtainMessage(7005), 500L);
        }
    }

    private void Zf() {
        Zg();
    }

    private void Zg() {
        if (this.ccS != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.ccS.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a YG = it.next().YG();
                if (YG.Yt() == MirrorType.NO_MIRROR) {
                    YG.fq(-this.ccT);
                } else {
                    YG.fq(this.ccT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + ccA);
        if (Zh()) {
            this.ccH.sendMessage(this.ccH.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Zi())));
        }
    }

    private static void fs(int i) {
        ccA = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            ccA |= i;
        }
        this.ccB++;
    }

    private boolean Zh() {
        if (this.ccj == null) {
            return false;
        }
        return this.ccj.isAudioIncluded() ? this.ccB == 3 : this.ccB == 2;
    }

    private synchronized boolean Zi() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + ccA);
        i = (ccA ^ 1) ^ 2;
        if (this.ccj != null) {
            if (this.ccj.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + ccA);
        if (Zj() && this.ccH != null) {
            this.ccH.sendMessage(this.ccH.obtainMessage(7003, Boolean.valueOf(Zk())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            ccA ^= i;
        }
        this.ccB--;
    }

    private boolean Zj() {
        return this.ccB == 0;
    }

    private synchronized boolean Zk() {
        return ccA == 0;
    }

    public void bG(long j) {
        this.ccG *= TimeUtils.NANOS_PER_MS;
        if (this.cci != null) {
            this.cci.bF(j);
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
                    if (d.this.cci != null) {
                        d.this.cci.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.ccE = false;
                    break;
                case 7002:
                    if (d.this.cci != null) {
                        d.this.cci.bF(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.cci != null) {
                        if (d.this.ccj != null) {
                            str = d.this.ccj.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.cci.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.cci != null) {
                        d.this.cci.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.YW();
                    break;
                case 7006:
                    d.this.ccE = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
