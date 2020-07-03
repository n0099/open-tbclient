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
/* loaded from: classes11.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bsK = 0;
    private static volatile boolean bsV = false;
    private static volatile d bte;
    private HandlerThread bsN;
    private a bsR;
    private f bsS;
    private com.baidu.mario.a.b.e bsT;
    private com.baidu.mario.a.b.f bsU;
    private com.baidu.mario.a.a.a bsW;
    private com.baidu.mario.a.b.c bsX;
    private com.baidu.mario.a.a.b bsZ;
    private e bst;
    private com.baidu.mario.a.b.d bsu;
    private com.baidu.mario.a.b.c bta;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> btc;
    private int btd;
    private Context mContext;
    private int bsL = 0;
    private boolean bsM = false;
    private volatile boolean bsO = false;
    private boolean bsP = false;
    private long bsQ = 0;
    private volatile boolean bsY = false;
    private volatile boolean btb = false;

    public static d LY() {
        if (bte == null) {
            synchronized (d.class) {
                if (bte == null) {
                    bte = new d();
                }
            }
        }
        return bte;
    }

    private d() {
    }

    public long LZ() {
        if (this.bsZ != null) {
            return this.bsZ.LZ();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bsO);
        if (this.bsO) {
            Mc();
            return;
        }
        this.bsO = true;
        this.mContext = context;
        this.bsu = dVar;
        this.bst = eVar;
        Ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        Md();
        Me();
        if (Mf()) {
            Mg();
            Mh();
        } else if (!this.bsP) {
            Mi();
        } else {
            Mc();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bsZ != null && this.bsZ.isRunning() && this.btb && bsV) {
            this.bsZ.aE(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bsY && this.bsW != null && this.bsW.isRunning()) {
            this.bsW.d(byteBuffer, i, j);
        }
    }

    public void Mb() {
        if (this.bsZ != null) {
            this.bsZ.Mu();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bsO);
        if (this.bsO) {
            if (!Mm() && this.bsR != null) {
                this.bsR.sendMessage(this.bsR.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bsR != null) {
                this.bsR.sendMessageDelayed(this.bsR.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bsY = false;
        this.btb = false;
        this.bsQ = 0L;
        if (this.bsW != null && this.bsW.isRunning()) {
            this.bsW.stopRecording();
        }
        if (this.bsZ != null && this.bsZ.isRunning()) {
            this.bsZ.stopRecording();
        }
        cD(false);
    }

    public void onDestroy() {
        if (this.btc != null) {
            this.btc.clear();
            this.btc = null;
        }
        this.bsS = null;
        this.mContext = null;
        this.bsu = null;
        dL(0);
        releaseInstance();
        if (this.bsR != null) {
            this.bsR.removeCallbacksAndMessages(null);
            this.bsR = null;
        }
        if (this.bsN != null) {
            this.bsN.quit();
            this.bsN = null;
        }
    }

    private static void releaseInstance() {
        bte = null;
    }

    private static void cD(boolean z) {
        bsV = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.btc == null) {
                this.btc = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.btc.size()) {
                    break;
                }
                if (this.btc.get(i3).LO() == cVar.LO()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.btc.size()) {
                if (this.btc.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.btc.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.btc.add(cVar.clone());
            } else {
                this.btc.add(cVar);
            }
            Collections.sort(this.btc);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bsZ != null) {
            a(cVar, z);
            this.bsZ.l(this.btc);
        }
    }

    private void Mc() {
        if (this.bsR != null) {
            this.bsR.sendMessageDelayed(this.bsR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Md() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bsT = new com.baidu.mario.a.b.e();
        }
        if (this.bsu.isAudioIncluded()) {
            this.bsW = new com.baidu.mario.a.a.a();
        } else {
            bsV = true;
        }
        this.bsZ = new com.baidu.mario.a.a.b();
        this.bsL = 0;
        if (!this.bsM && this.bsN == null) {
            this.bsN = new HandlerThread(TAG);
            this.bsN.start();
        }
        if (this.bsR == null) {
            if (this.bsN != null) {
                this.bsR = new a(this.bsN.getLooper());
            } else {
                this.bsR = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bsR.removeCallbacksAndMessages(null);
        }
        this.bsS = new f(this.bsu.getOutputTotalMs());
    }

    private void Me() {
        this.bta = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cE(boolean z) {
                if (z) {
                    d.this.bsZ.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cF(boolean z) {
                d.this.btb = z;
                d.this.n(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cG(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cH(boolean z) {
                d.this.bsZ.Mp();
                d.this.bsZ = null;
                d.this.bta = null;
                d.this.p(2, z);
            }
        };
        this.bsX = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cE(boolean z) {
                if (z) {
                    d.this.bsW.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cF(boolean z) {
                d.this.bsY = z;
                d.this.n(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cG(boolean z) {
                boolean unused = d.bsV = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cH(boolean z) {
                d.this.bsW.Mp();
                d.this.bsW = null;
                d.this.bsX = null;
                d.this.p(4, z);
            }
        };
        this.bsU = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cI(boolean z) {
                d.this.n(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cJ(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bsT.MF();
                    d.this.bsT = null;
                }
                d.this.bsU = null;
                d.this.p(1, z);
            }
        };
    }

    private boolean Mf() {
        boolean z = true;
        if (this.bsW != null && this.bsW.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bsW.stopRecording();
            this.bsW.Mp();
            z = false;
        }
        if (this.bsZ != null && this.bsZ.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bsZ.stopRecording();
            this.bsZ.Mp();
            z = false;
        }
        if (this.bsu != null && !this.bsT.a(this.bsu.getOutputFile(), this.bsu.getOutputFormat(), this.bsU)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Mg() {
        if (this.bsW != null) {
            this.bsW.a(this.bsu, this.bsT, this.bsX);
        }
    }

    private void Mh() {
        Mj();
        this.bsZ.a(this.btc, this.bsu, this.bsT, this.bta);
    }

    private void Mi() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bsP);
        if (this.bsR != null) {
            this.bsP = true;
            this.bsR.sendMessageDelayed(this.bsR.obtainMessage(7005), 500L);
        }
    }

    private void Mj() {
        Mk();
    }

    private void Mk() {
        if (this.btc != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.btc.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a LK = it.next().LK();
                if (LK.Lw() == MirrorType.NO_MIRROR) {
                    LK.dJ(-this.btd);
                } else {
                    LK.dJ(this.btd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        o(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bsK);
        if (Ml()) {
            this.bsR.sendMessage(this.bsR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Mm())));
        }
    }

    private static void dL(int i) {
        bsK = i;
    }

    private void o(int i, boolean z) {
        if (z) {
            bsK |= i;
        }
        this.bsL++;
    }

    private boolean Ml() {
        if (this.bsu == null) {
            return false;
        }
        return this.bsu.isAudioIncluded() ? this.bsL == 3 : this.bsL == 2;
    }

    private synchronized boolean Mm() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bsK);
        i = (bsK ^ 1) ^ 2;
        if (this.bsu != null) {
            if (this.bsu.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        q(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bsK);
        if (Mn() && this.bsR != null) {
            this.bsR.sendMessage(this.bsR.obtainMessage(7003, Boolean.valueOf(Mo())));
        }
    }

    private void q(int i, boolean z) {
        if (z) {
            bsK ^= i;
        }
        this.bsL--;
    }

    private boolean Mn() {
        return this.bsL == 0;
    }

    private synchronized boolean Mo() {
        return bsK == 0;
    }

    public void aH(long j) {
        this.bsQ *= TimeUtils.NANOS_PER_MS;
        if (this.bst != null) {
            this.bst.aG(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bst != null) {
                        d.this.bst.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bsO = false;
                    break;
                case 7002:
                    if (d.this.bst != null) {
                        d.this.bst.aG(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bst != null) {
                        if (d.this.bsu != null) {
                            str = d.this.bsu.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bst.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bst != null) {
                        d.this.bst.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Ma();
                    break;
                case 7006:
                    d.this.bsO = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
