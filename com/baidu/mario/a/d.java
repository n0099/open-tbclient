package com.baidu.mario.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class d {
    private static volatile d aKH;
    private e aJX;
    private com.baidu.mario.a.b.d aJY;
    private com.baidu.mario.a.b.c aKA;
    private com.baidu.mario.a.a.b aKC;
    private com.baidu.mario.a.b.c aKD;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aKF;
    private int aKG;
    private HandlerThread aKq;
    private a aKu;
    private f aKv;
    private com.baidu.mario.a.b.e aKw;
    private com.baidu.mario.a.b.f aKx;
    private com.baidu.mario.a.a.a aKz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int aKn = 0;
    private static volatile boolean aKy = false;
    private int aKo = 0;
    private boolean aKp = false;
    private volatile boolean aKr = false;
    private boolean aKs = false;
    private long aKt = 0;
    private volatile boolean aKB = false;
    private volatile boolean aKE = false;

    public static d CS() {
        if (aKH == null) {
            synchronized (d.class) {
                if (aKH == null) {
                    aKH = new d();
                }
            }
        }
        return aKH;
    }

    private d() {
    }

    public long CT() {
        if (this.aKC != null) {
            return this.aKC.CT();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aKr);
        if (this.aKr) {
            CX();
            return;
        }
        this.aKr = true;
        this.mContext = context;
        this.aJY = dVar;
        this.aJX = eVar;
        CU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        CY();
        CZ();
        if (Da()) {
            Db();
            Dc();
        } else if (!this.aKs) {
            Dd();
        } else {
            CX();
        }
    }

    public void W(long j) {
        if (this.aKC != null && this.aKC.isRunning() && this.aKE && aKy) {
            this.aKC.T(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aKB && this.aKz != null && this.aKz.isRunning()) {
            this.aKz.d(byteBuffer, i, j);
        }
    }

    public void CV() {
        if (this.aKC != null) {
            this.aKC.Dp();
        }
    }

    public void CW() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aKr);
        if (this.aKr) {
            if (!Dh() && this.aKu != null) {
                this.aKu.sendMessage(this.aKu.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aKu != null) {
                this.aKu.sendMessageDelayed(this.aKu.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aKB = false;
        this.aKE = false;
        this.aKt = 0L;
        if (this.aKz != null && this.aKz.isRunning()) {
            this.aKz.stopRecording();
        }
        if (this.aKC != null && this.aKC.isRunning()) {
            this.aKC.stopRecording();
        }
        bC(false);
    }

    public void onDestroy() {
        if (this.aKF != null) {
            this.aKF.clear();
            this.aKF = null;
        }
        this.aKv = null;
        this.mContext = null;
        this.aJY = null;
        de(0);
        releaseInstance();
        if (this.aKu != null) {
            this.aKu.removeCallbacksAndMessages(null);
            this.aKu = null;
        }
        if (this.aKq != null) {
            this.aKq.quit();
            this.aKq = null;
        }
    }

    private static void releaseInstance() {
        aKH = null;
    }

    private static void bC(boolean z) {
        aKy = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aKF == null) {
                this.aKF = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aKF.size()) {
                    break;
                }
                if (this.aKF.get(i3).CI() == cVar.CI()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aKF.size()) {
                if (this.aKF.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aKF.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aKF.add(cVar.clone());
            } else {
                this.aKF.add(cVar);
            }
            Collections.sort(this.aKF);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aKC != null) {
            a(cVar, z);
            this.aKC.l(this.aKF);
        }
    }

    private void CX() {
        if (this.aKu != null) {
            this.aKu.sendMessageDelayed(this.aKu.obtainMessage(7001, false), 500L);
        }
    }

    private void CY() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKw = new com.baidu.mario.a.b.e();
        }
        if (this.aJY.DD()) {
            this.aKz = new com.baidu.mario.a.a.a();
        } else {
            aKy = true;
        }
        this.aKC = new com.baidu.mario.a.a.b();
        this.aKo = 0;
        if (!this.aKp && this.aKq == null) {
            this.aKq = new HandlerThread(TAG);
            this.aKq.start();
        }
        if (this.aKu == null) {
            if (this.aKq != null) {
                this.aKu = new a(this.aKq.getLooper());
            } else {
                this.aKu = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aKu.removeCallbacksAndMessages(null);
        }
        this.aKv = new f(this.aJY.Dx());
    }

    private void CZ() {
        this.aKD = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                if (z) {
                    d.this.aKC.Dk();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
                d.this.aKE = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bG(boolean z) {
                d.this.aKC.Dl();
                d.this.aKC = null;
                d.this.aKD = null;
                d.this.l(2, z);
            }
        };
        this.aKA = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                if (z) {
                    d.this.aKz.Dk();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
                d.this.aKB = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                boolean unused = d.aKy = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bG(boolean z) {
                d.this.aKz.Dl();
                d.this.aKz = null;
                d.this.aKA = null;
                d.this.l(4, z);
            }
        };
        this.aKx = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void bH(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bI(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aKw.DM();
                    d.this.aKw = null;
                }
                d.this.aKx = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean Da() {
        boolean z = true;
        if (this.aKz != null && this.aKz.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aKz.stopRecording();
            this.aKz.Dl();
            z = false;
        }
        if (this.aKC != null && this.aKC.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aKC.stopRecording();
            this.aKC.Dl();
            z = false;
        }
        if (this.aJY != null && !this.aKw.a(this.aJY.Dv(), this.aJY.Dw(), this.aKx)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Db() {
        if (this.aKz != null) {
            this.aKz.a(this.aJY, this.aKw, this.aKA);
        }
    }

    private void Dc() {
        De();
        this.aKC.a(this.aKF, this.aJY, this.aKw, this.aKD);
    }

    private void Dd() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aKs);
        if (this.aKu != null) {
            this.aKs = true;
            this.aKu.sendMessageDelayed(this.aKu.obtainMessage(7005), 500L);
        }
    }

    private void De() {
        Df();
    }

    private void Df() {
        if (this.aKF != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aKF.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a CE = it.next().CE();
                if (CE.Cq() == MirrorType.NO_MIRROR) {
                    CE.dc(-this.aKG);
                } else {
                    CE.dc(this.aKG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aKn);
        if (Dg()) {
            this.aKu.sendMessage(this.aKu.obtainMessage(7001, Boolean.valueOf(Dh())));
        }
    }

    private static void de(int i) {
        aKn = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aKn |= i;
        }
        this.aKo++;
    }

    private boolean Dg() {
        if (this.aJY == null) {
            return false;
        }
        return this.aJY.DD() ? this.aKo == 3 : this.aKo == 2;
    }

    private synchronized boolean Dh() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aKn);
        i = (aKn ^ 1) ^ 2;
        if (this.aJY != null) {
            if (this.aJY.DD()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aKn);
        if (Di() && this.aKu != null) {
            this.aKu.sendMessage(this.aKu.obtainMessage(7003, Boolean.valueOf(Dj())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aKn ^= i;
        }
        this.aKo--;
    }

    private boolean Di() {
        return this.aKo == 0;
    }

    private synchronized boolean Dj() {
        return aKn == 0;
    }

    public void X(long j) {
        this.aKt *= TimeUtils.NANOS_PER_MS;
        if (this.aJX != null) {
            this.aJX.V(j);
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
                case 7001:
                    if (d.this.aJX != null) {
                        d.this.aJX.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aKr = false;
                    break;
                case 7002:
                    if (d.this.aJX != null) {
                        d.this.aJX.V(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aJX != null) {
                        if (d.this.aJY != null) {
                            str = d.this.aJY.Dv();
                        } else {
                            str = null;
                        }
                        d.this.aJX.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aJX != null) {
                        d.this.aJX.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.CU();
                    break;
                case 7006:
                    d.this.aKr = false;
                    d.this.CW();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
