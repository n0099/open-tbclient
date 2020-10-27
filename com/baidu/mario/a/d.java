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
/* loaded from: classes5.dex */
public class d {
    private static volatile d bRJ;
    private e bQY;
    private com.baidu.mario.a.b.d bQZ;
    private com.baidu.mario.a.a.a bRB;
    private com.baidu.mario.a.b.c bRC;
    private com.baidu.mario.a.a.b bRE;
    private com.baidu.mario.a.b.c bRF;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bRH;
    private int bRI;
    private HandlerThread bRs;
    private a bRw;
    private f bRx;
    private com.baidu.mario.a.b.e bRy;
    private com.baidu.mario.a.b.f bRz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bRp = 0;
    private static volatile boolean bRA = false;
    private int bRq = 0;
    private boolean bRr = false;
    private volatile boolean bRt = false;
    private boolean bRu = false;
    private long bRv = 0;
    private volatile boolean bRD = false;
    private volatile boolean bRG = false;

    public static d WI() {
        if (bRJ == null) {
            synchronized (d.class) {
                if (bRJ == null) {
                    bRJ = new d();
                }
            }
        }
        return bRJ;
    }

    private d() {
    }

    public long WJ() {
        if (this.bRE != null) {
            return this.bRE.WJ();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bRt);
        if (this.bRt) {
            WM();
            return;
        }
        this.bRt = true;
        this.mContext = context;
        this.bQZ = dVar;
        this.bQY = eVar;
        WK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WK() {
        WN();
        WO();
        if (WP()) {
            WQ();
            WR();
        } else if (!this.bRu) {
            WS();
        } else {
            WM();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bRE != null && this.bRE.isRunning() && this.bRG && bRA) {
            this.bRE.aJ(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bRD && this.bRB != null && this.bRB.isRunning()) {
            this.bRB.d(byteBuffer, i, j);
        }
    }

    public void WL() {
        if (this.bRE != null) {
            this.bRE.Xe();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bRt);
        if (this.bRt) {
            if (!WW() && this.bRw != null) {
                this.bRw.sendMessage(this.bRw.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bRw != null) {
                this.bRw.sendMessageDelayed(this.bRw.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bRD = false;
        this.bRG = false;
        this.bRv = 0L;
        if (this.bRB != null && this.bRB.isRunning()) {
            this.bRB.stopRecording();
        }
        if (this.bRE != null && this.bRE.isRunning()) {
            this.bRE.stopRecording();
        }
        dk(false);
    }

    public void onDestroy() {
        if (this.bRH != null) {
            this.bRH.clear();
            this.bRH = null;
        }
        this.bRx = null;
        this.mContext = null;
        this.bQZ = null;
        gu(0);
        releaseInstance();
        if (this.bRw != null) {
            this.bRw.removeCallbacksAndMessages(null);
            this.bRw = null;
        }
        if (this.bRs != null) {
            this.bRs.quit();
            this.bRs = null;
        }
    }

    private static void releaseInstance() {
        bRJ = null;
    }

    private static void dk(boolean z) {
        bRA = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bRH == null) {
                this.bRH = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bRH.size()) {
                    break;
                }
                if (this.bRH.get(i3).Wy() == cVar.Wy()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bRH.size()) {
                if (this.bRH.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bRH.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bRH.add(cVar.clone());
            } else {
                this.bRH.add(cVar);
            }
            Collections.sort(this.bRH);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bRE != null) {
            a(cVar, z);
            this.bRE.q(this.bRH);
        }
    }

    private void WM() {
        if (this.bRw != null) {
            this.bRw.sendMessageDelayed(this.bRw.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void WN() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bRy = new com.baidu.mario.a.b.e();
        }
        if (this.bQZ.isAudioIncluded()) {
            this.bRB = new com.baidu.mario.a.a.a();
        } else {
            bRA = true;
        }
        this.bRE = new com.baidu.mario.a.a.b();
        this.bRq = 0;
        if (!this.bRr && this.bRs == null) {
            this.bRs = new HandlerThread(TAG);
            this.bRs.start();
        }
        if (this.bRw == null) {
            if (this.bRs != null) {
                this.bRw = new a(this.bRs.getLooper());
            } else {
                this.bRw = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bRw.removeCallbacksAndMessages(null);
        }
        this.bRx = new f(this.bQZ.getOutputTotalMs());
    }

    private void WO() {
        this.bRF = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void dl(boolean z) {
                if (z) {
                    d.this.bRE.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dm(boolean z) {
                d.this.bRG = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dn(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            /* renamed from: do */
            public void mo29do(boolean z) {
                d.this.bRE.WZ();
                d.this.bRE = null;
                d.this.bRF = null;
                d.this.u(2, z);
            }
        };
        this.bRC = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void dl(boolean z) {
                if (z) {
                    d.this.bRB.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dm(boolean z) {
                d.this.bRD = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dn(boolean z) {
                boolean unused = d.bRA = z;
            }

            @Override // com.baidu.mario.a.b.c
            /* renamed from: do */
            public void mo29do(boolean z) {
                d.this.bRB.WZ();
                d.this.bRB = null;
                d.this.bRC = null;
                d.this.u(4, z);
            }
        };
        this.bRz = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dp(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dq(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bRy.Xp();
                    d.this.bRy = null;
                }
                d.this.bRz = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean WP() {
        boolean z = true;
        if (this.bRB != null && this.bRB.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bRB.stopRecording();
            this.bRB.WZ();
            z = false;
        }
        if (this.bRE != null && this.bRE.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bRE.stopRecording();
            this.bRE.WZ();
            z = false;
        }
        if (this.bQZ != null && !this.bRy.a(this.bQZ.getOutputFile(), this.bQZ.getOutputFormat(), this.bRz)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void WQ() {
        if (this.bRB != null) {
            this.bRB.a(this.bQZ, this.bRy, this.bRC);
        }
    }

    private void WR() {
        WT();
        this.bRE.a(this.bRH, this.bQZ, this.bRy, this.bRF);
    }

    private void WS() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bRu);
        if (this.bRw != null) {
            this.bRu = true;
            this.bRw.sendMessageDelayed(this.bRw.obtainMessage(7005), 500L);
        }
    }

    private void WT() {
        WU();
    }

    private void WU() {
        if (this.bRH != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bRH.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Wu = it.next().Wu();
                if (Wu.Wg() == MirrorType.NO_MIRROR) {
                    Wu.gs(-this.bRI);
                } else {
                    Wu.gs(this.bRI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bRp);
        if (WV()) {
            this.bRw.sendMessage(this.bRw.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(WW())));
        }
    }

    private static void gu(int i) {
        bRp = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            bRp |= i;
        }
        this.bRq++;
    }

    private boolean WV() {
        if (this.bQZ == null) {
            return false;
        }
        return this.bQZ.isAudioIncluded() ? this.bRq == 3 : this.bRq == 2;
    }

    private synchronized boolean WW() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bRp);
        i = (bRp ^ 1) ^ 2;
        if (this.bQZ != null) {
            if (this.bQZ.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bRp);
        if (WX() && this.bRw != null) {
            this.bRw.sendMessage(this.bRw.obtainMessage(7003, Boolean.valueOf(WY())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            bRp ^= i;
        }
        this.bRq--;
    }

    private boolean WX() {
        return this.bRq == 0;
    }

    private synchronized boolean WY() {
        return bRp == 0;
    }

    public void aM(long j) {
        this.bRv *= TimeUtils.NANOS_PER_MS;
        if (this.bQY != null) {
            this.bQY.aL(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bQY != null) {
                        d.this.bQY.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bRt = false;
                    break;
                case 7002:
                    if (d.this.bQY != null) {
                        d.this.bQY.aL(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bQY != null) {
                        if (d.this.bQZ != null) {
                            str = d.this.bQZ.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bQY.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bQY != null) {
                        d.this.bQY.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.WK();
                    break;
                case 7006:
                    d.this.bRt = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
