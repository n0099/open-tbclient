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
    private static volatile d ciF;
    private e chT;
    private com.baidu.mario.a.b.d chU;
    private com.baidu.mario.a.a.b ciA;
    private com.baidu.mario.a.b.c ciB;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> ciD;
    private int ciE;
    private HandlerThread cio;
    private a cis;
    private f cit;
    private com.baidu.mario.a.b.e ciu;
    private com.baidu.mario.a.b.f civ;
    private com.baidu.mario.a.a.a cix;
    private com.baidu.mario.a.b.c ciy;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int cil = 0;
    private static volatile boolean ciw = false;
    private int cim = 0;
    private boolean cin = false;
    private volatile boolean cip = false;
    private boolean ciq = false;
    private long cir = 0;
    private volatile boolean ciz = false;
    private volatile boolean ciC = false;

    public static d aaQ() {
        if (ciF == null) {
            synchronized (d.class) {
                if (ciF == null) {
                    ciF = new d();
                }
            }
        }
        return ciF;
    }

    private d() {
    }

    public long aaR() {
        if (this.ciA != null) {
            return this.ciA.aaR();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.cip);
        if (this.cip) {
            aaU();
            return;
        }
        this.cip = true;
        this.mContext = context;
        this.chU = dVar;
        this.chT = eVar;
        aaS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaS() {
        aaV();
        aaW();
        if (aaX()) {
            aaY();
            aaZ();
        } else if (!this.ciq) {
            aba();
        } else {
            aaU();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.ciA != null && this.ciA.isRunning() && this.ciC && ciw) {
            this.ciA.bH(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.ciz && this.cix != null && this.cix.isRunning()) {
            this.cix.d(byteBuffer, i, j);
        }
    }

    public void aaT() {
        if (this.ciA != null) {
            this.ciA.abl();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.cip);
        if (this.cip) {
            if (!abe() && this.cis != null) {
                this.cis.sendMessage(this.cis.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.cis != null) {
                this.cis.sendMessageDelayed(this.cis.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.ciz = false;
        this.ciC = false;
        this.cir = 0L;
        if (this.cix != null && this.cix.isRunning()) {
            this.cix.stopRecording();
        }
        if (this.ciA != null && this.ciA.isRunning()) {
            this.ciA.stopRecording();
        }
        dS(false);
    }

    public void onDestroy() {
        if (this.ciD != null) {
            this.ciD.clear();
            this.ciD = null;
        }
        this.cit = null;
        this.mContext = null;
        this.chU = null;
        fz(0);
        releaseInstance();
        if (this.cis != null) {
            this.cis.removeCallbacksAndMessages(null);
            this.cis = null;
        }
        if (this.cio != null) {
            this.cio.quit();
            this.cio = null;
        }
    }

    private static void releaseInstance() {
        ciF = null;
    }

    private static void dS(boolean z) {
        ciw = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.ciD == null) {
                this.ciD = new ArrayList<>();
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ciD.size()) {
                    break;
                }
                if (this.ciD.get(i3).aaG() == cVar.aaG()) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            if (i >= 0 && i < this.ciD.size()) {
                if (this.ciD.get(i).getEGLContext() != cVar.getEGLContext()) {
                    this.ciD.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                this.ciD.add(cVar.clone());
            } else {
                this.ciD.add(cVar);
            }
            Collections.sort(this.ciD);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.ciA != null) {
            a(cVar, z);
            this.ciA.l(this.ciD);
        }
    }

    private void aaU() {
        if (this.cis != null) {
            this.cis.sendMessageDelayed(this.cis.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void aaV() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ciu = new com.baidu.mario.a.b.e();
        }
        if (this.chU.isAudioIncluded()) {
            this.cix = new com.baidu.mario.a.a.a();
        } else {
            ciw = true;
        }
        this.ciA = new com.baidu.mario.a.a.b();
        this.cim = 0;
        if (!this.cin && this.cio == null) {
            this.cio = new HandlerThread(TAG);
            this.cio.start();
        }
        if (this.cis == null) {
            if (this.cio != null) {
                this.cis = new a(this.cio.getLooper());
            } else {
                this.cis = new a(this.mContext.getMainLooper());
            }
        } else {
            this.cis.removeCallbacksAndMessages(null);
        }
        this.cit = new f(this.chU.getOutputTotalMs());
    }

    private void aaW() {
        this.ciB = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dT(boolean z) {
                if (z) {
                    d.this.ciA.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dU(boolean z) {
                d.this.ciC = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dV(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dW(boolean z) {
                d.this.ciA.abh();
                d.this.ciA = null;
                d.this.ciB = null;
                d.this.u(2, z);
            }
        };
        this.ciy = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dT(boolean z) {
                if (z) {
                    d.this.cix.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dU(boolean z) {
                d.this.ciz = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dV(boolean z) {
                boolean unused = d.ciw = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dW(boolean z) {
                d.this.cix.abh();
                d.this.cix = null;
                d.this.ciy = null;
                d.this.u(4, z);
            }
        };
        this.civ = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dX(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dY(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.ciu.abt();
                    d.this.ciu = null;
                }
                d.this.civ = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean aaX() {
        boolean z = true;
        if (this.cix != null && this.cix.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.cix.stopRecording();
            this.cix.abh();
            z = false;
        }
        if (this.ciA != null && this.ciA.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.ciA.stopRecording();
            this.ciA.abh();
            z = false;
        }
        if (this.chU != null && !this.ciu.a(this.chU.getOutputFile(), this.chU.getOutputFormat(), this.civ)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void aaY() {
        if (this.cix != null) {
            this.cix.a(this.chU, this.ciu, this.ciy);
        }
    }

    private void aaZ() {
        abb();
        this.ciA.a(this.ciD, this.chU, this.ciu, this.ciB);
    }

    private void aba() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.ciq);
        if (this.cis != null) {
            this.ciq = true;
            this.cis.sendMessageDelayed(this.cis.obtainMessage(7005), 500L);
        }
    }

    private void abb() {
        abc();
    }

    private void abc() {
        if (this.ciD != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.ciD.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a aaC = it.next().aaC();
                if (aaC.aap() == MirrorType.NO_MIRROR) {
                    aaC.fx(-this.ciE);
                } else {
                    aaC.fx(this.ciE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + cil);
        if (abd()) {
            this.cis.sendMessage(this.cis.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(abe())));
        }
    }

    private static void fz(int i) {
        cil = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            cil |= i;
        }
        this.cim++;
    }

    private boolean abd() {
        if (this.chU == null) {
            return false;
        }
        return this.chU.isAudioIncluded() ? this.cim == 3 : this.cim == 2;
    }

    private synchronized boolean abe() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + cil);
        i = (cil ^ 1) ^ 2;
        if (this.chU != null) {
            if (this.chU.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + cil);
        if (abf() && this.cis != null) {
            this.cis.sendMessage(this.cis.obtainMessage(7003, Boolean.valueOf(abg())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            cil ^= i;
        }
        this.cim--;
    }

    private boolean abf() {
        return this.cim == 0;
    }

    private synchronized boolean abg() {
        return cil == 0;
    }

    public void bK(long j) {
        this.cir *= TimeUtils.NANOS_PER_MS;
        if (this.chT != null) {
            this.chT.bJ(j);
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
                    if (d.this.chT != null) {
                        d.this.chT.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.cip = false;
                    break;
                case 7002:
                    if (d.this.chT != null) {
                        d.this.chT.bJ(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.chT != null) {
                        if (d.this.chU != null) {
                            str = d.this.chU.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.chT.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.chT != null) {
                        d.this.chT.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.aaS();
                    break;
                case 7006:
                    d.this.cip = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
