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
    private static volatile int bnK = 0;
    private static volatile boolean bnV = false;
    private static volatile d boe;
    private HandlerThread bnN;
    private a bnR;
    private f bnS;
    private com.baidu.mario.a.b.e bnT;
    private com.baidu.mario.a.b.f bnU;
    private com.baidu.mario.a.a.a bnW;
    private com.baidu.mario.a.b.c bnX;
    private com.baidu.mario.a.a.b bnZ;
    private e bnt;
    private com.baidu.mario.a.b.d bnu;
    private com.baidu.mario.a.b.c boa;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> boc;
    private int bod;
    private Context mContext;
    private int bnL = 0;
    private boolean bnM = false;
    private volatile boolean bnO = false;
    private boolean bnP = false;
    private long bnQ = 0;
    private volatile boolean bnY = false;
    private volatile boolean bob = false;

    public static d KP() {
        if (boe == null) {
            synchronized (d.class) {
                if (boe == null) {
                    boe = new d();
                }
            }
        }
        return boe;
    }

    private d() {
    }

    public long KQ() {
        if (this.bnZ != null) {
            return this.bnZ.KQ();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bnO);
        if (this.bnO) {
            KT();
            return;
        }
        this.bnO = true;
        this.mContext = context;
        this.bnu = dVar;
        this.bnt = eVar;
        KR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KR() {
        KU();
        KV();
        if (KW()) {
            KX();
            KY();
        } else if (!this.bnP) {
            KZ();
        } else {
            KT();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bnZ != null && this.bnZ.isRunning() && this.bob && bnV) {
            this.bnZ.aE(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bnY && this.bnW != null && this.bnW.isRunning()) {
            this.bnW.d(byteBuffer, i, j);
        }
    }

    public void KS() {
        if (this.bnZ != null) {
            this.bnZ.Ll();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bnO);
        if (this.bnO) {
            if (!Ld() && this.bnR != null) {
                this.bnR.sendMessage(this.bnR.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bnR != null) {
                this.bnR.sendMessageDelayed(this.bnR.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bnY = false;
        this.bob = false;
        this.bnQ = 0L;
        if (this.bnW != null && this.bnW.isRunning()) {
            this.bnW.stopRecording();
        }
        if (this.bnZ != null && this.bnZ.isRunning()) {
            this.bnZ.stopRecording();
        }
        cx(false);
    }

    public void onDestroy() {
        if (this.boc != null) {
            this.boc.clear();
            this.boc = null;
        }
        this.bnS = null;
        this.mContext = null;
        this.bnu = null;
        dz(0);
        releaseInstance();
        if (this.bnR != null) {
            this.bnR.removeCallbacksAndMessages(null);
            this.bnR = null;
        }
        if (this.bnN != null) {
            this.bnN.quit();
            this.bnN = null;
        }
    }

    private static void releaseInstance() {
        boe = null;
    }

    private static void cx(boolean z) {
        bnV = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.boc == null) {
                this.boc = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.boc.size()) {
                    break;
                }
                if (this.boc.get(i3).KF() == cVar.KF()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.boc.size()) {
                if (this.boc.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.boc.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.boc.add(cVar.clone());
            } else {
                this.boc.add(cVar);
            }
            Collections.sort(this.boc);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bnZ != null) {
            a(cVar, z);
            this.bnZ.l(this.boc);
        }
    }

    private void KT() {
        if (this.bnR != null) {
            this.bnR.sendMessageDelayed(this.bnR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void KU() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bnT = new com.baidu.mario.a.b.e();
        }
        if (this.bnu.isAudioIncluded()) {
            this.bnW = new com.baidu.mario.a.a.a();
        } else {
            bnV = true;
        }
        this.bnZ = new com.baidu.mario.a.a.b();
        this.bnL = 0;
        if (!this.bnM && this.bnN == null) {
            this.bnN = new HandlerThread(TAG);
            this.bnN.start();
        }
        if (this.bnR == null) {
            if (this.bnN != null) {
                this.bnR = new a(this.bnN.getLooper());
            } else {
                this.bnR = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bnR.removeCallbacksAndMessages(null);
        }
        this.bnS = new f(this.bnu.getOutputTotalMs());
    }

    private void KV() {
        this.boa = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cy(boolean z) {
                if (z) {
                    d.this.bnZ.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cz(boolean z) {
                d.this.bob = z;
                d.this.m(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cA(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cB(boolean z) {
                d.this.bnZ.Lg();
                d.this.bnZ = null;
                d.this.boa = null;
                d.this.o(2, z);
            }
        };
        this.bnX = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cy(boolean z) {
                if (z) {
                    d.this.bnW.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cz(boolean z) {
                d.this.bnY = z;
                d.this.m(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cA(boolean z) {
                boolean unused = d.bnV = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cB(boolean z) {
                d.this.bnW.Lg();
                d.this.bnW = null;
                d.this.bnX = null;
                d.this.o(4, z);
            }
        };
        this.bnU = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cC(boolean z) {
                d.this.m(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cD(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bnT.Lw();
                    d.this.bnT = null;
                }
                d.this.bnU = null;
                d.this.o(1, z);
            }
        };
    }

    private boolean KW() {
        boolean z = true;
        if (this.bnW != null && this.bnW.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bnW.stopRecording();
            this.bnW.Lg();
            z = false;
        }
        if (this.bnZ != null && this.bnZ.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bnZ.stopRecording();
            this.bnZ.Lg();
            z = false;
        }
        if (this.bnu != null && !this.bnT.a(this.bnu.getOutputFile(), this.bnu.getOutputFormat(), this.bnU)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void KX() {
        if (this.bnW != null) {
            this.bnW.a(this.bnu, this.bnT, this.bnX);
        }
    }

    private void KY() {
        La();
        this.bnZ.a(this.boc, this.bnu, this.bnT, this.boa);
    }

    private void KZ() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bnP);
        if (this.bnR != null) {
            this.bnP = true;
            this.bnR.sendMessageDelayed(this.bnR.obtainMessage(7005), 500L);
        }
    }

    private void La() {
        Lb();
    }

    private void Lb() {
        if (this.boc != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.boc.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a KB = it.next().KB();
                if (KB.Kn() == MirrorType.NO_MIRROR) {
                    KB.dx(-this.bod);
                } else {
                    KB.dx(this.bod);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        n(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bnK);
        if (Lc()) {
            this.bnR.sendMessage(this.bnR.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Ld())));
        }
    }

    private static void dz(int i) {
        bnK = i;
    }

    private void n(int i, boolean z) {
        if (z) {
            bnK |= i;
        }
        this.bnL++;
    }

    private boolean Lc() {
        if (this.bnu == null) {
            return false;
        }
        return this.bnu.isAudioIncluded() ? this.bnL == 3 : this.bnL == 2;
    }

    private synchronized boolean Ld() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bnK);
        i = (bnK ^ 1) ^ 2;
        if (this.bnu != null) {
            if (this.bnu.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        p(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bnK);
        if (Le() && this.bnR != null) {
            this.bnR.sendMessage(this.bnR.obtainMessage(7003, Boolean.valueOf(Lf())));
        }
    }

    private void p(int i, boolean z) {
        if (z) {
            bnK ^= i;
        }
        this.bnL--;
    }

    private boolean Le() {
        return this.bnL == 0;
    }

    private synchronized boolean Lf() {
        return bnK == 0;
    }

    public void aH(long j) {
        this.bnQ *= TimeUtils.NANOS_PER_MS;
        if (this.bnt != null) {
            this.bnt.aG(j);
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
                    if (d.this.bnt != null) {
                        d.this.bnt.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bnO = false;
                    break;
                case 7002:
                    if (d.this.bnt != null) {
                        d.this.bnt.aG(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bnt != null) {
                        if (d.this.bnu != null) {
                            str = d.this.bnu.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bnt.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bnt != null) {
                        d.this.bnt.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.KR();
                    break;
                case 7006:
                    d.this.bnO = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
