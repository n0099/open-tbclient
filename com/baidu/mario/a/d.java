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
/* loaded from: classes6.dex */
public class d {
    private static volatile d bVJ;
    private e bUY;
    private com.baidu.mario.a.b.d bUZ;
    private com.baidu.mario.a.a.a bVB;
    private com.baidu.mario.a.b.c bVC;
    private com.baidu.mario.a.a.b bVE;
    private com.baidu.mario.a.b.c bVF;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bVH;
    private int bVI;
    private HandlerThread bVs;
    private a bVw;
    private f bVx;
    private com.baidu.mario.a.b.e bVy;
    private com.baidu.mario.a.b.f bVz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bVp = 0;
    private static volatile boolean bVA = false;
    private int bVq = 0;
    private boolean bVr = false;
    private volatile boolean bVt = false;
    private boolean bVu = false;
    private long bVv = 0;
    private volatile boolean bVD = false;
    private volatile boolean bVG = false;

    public static d Yy() {
        if (bVJ == null) {
            synchronized (d.class) {
                if (bVJ == null) {
                    bVJ = new d();
                }
            }
        }
        return bVJ;
    }

    private d() {
    }

    public long Yz() {
        if (this.bVE != null) {
            return this.bVE.Yz();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bVt);
        if (this.bVt) {
            YC();
            return;
        }
        this.bVt = true;
        this.mContext = context;
        this.bUZ = dVar;
        this.bUY = eVar;
        YA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        YD();
        YE();
        if (YF()) {
            YG();
            YH();
        } else if (!this.bVu) {
            YI();
        } else {
            YC();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bVE != null && this.bVE.isRunning() && this.bVG && bVA) {
            this.bVE.bf(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bVD && this.bVB != null && this.bVB.isRunning()) {
            this.bVB.d(byteBuffer, i, j);
        }
    }

    public void YB() {
        if (this.bVE != null) {
            this.bVE.YU();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bVt);
        if (this.bVt) {
            if (!YM() && this.bVw != null) {
                this.bVw.sendMessage(this.bVw.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bVw != null) {
                this.bVw.sendMessageDelayed(this.bVw.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bVD = false;
        this.bVG = false;
        this.bVv = 0L;
        if (this.bVB != null && this.bVB.isRunning()) {
            this.bVB.stopRecording();
        }
        if (this.bVE != null && this.bVE.isRunning()) {
            this.bVE.stopRecording();
        }
        dt(false);
    }

    public void onDestroy() {
        if (this.bVH != null) {
            this.bVH.clear();
            this.bVH = null;
        }
        this.bVx = null;
        this.mContext = null;
        this.bUZ = null;
        gA(0);
        releaseInstance();
        if (this.bVw != null) {
            this.bVw.removeCallbacksAndMessages(null);
            this.bVw = null;
        }
        if (this.bVs != null) {
            this.bVs.quit();
            this.bVs = null;
        }
    }

    private static void releaseInstance() {
        bVJ = null;
    }

    private static void dt(boolean z) {
        bVA = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bVH == null) {
                this.bVH = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bVH.size()) {
                    break;
                }
                if (this.bVH.get(i3).Yo() == cVar.Yo()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bVH.size()) {
                if (this.bVH.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bVH.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bVH.add(cVar.clone());
            } else {
                this.bVH.add(cVar);
            }
            Collections.sort(this.bVH);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bVE != null) {
            a(cVar, z);
            this.bVE.q(this.bVH);
        }
    }

    private void YC() {
        if (this.bVw != null) {
            this.bVw.sendMessageDelayed(this.bVw.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void YD() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bVy = new com.baidu.mario.a.b.e();
        }
        if (this.bUZ.isAudioIncluded()) {
            this.bVB = new com.baidu.mario.a.a.a();
        } else {
            bVA = true;
        }
        this.bVE = new com.baidu.mario.a.a.b();
        this.bVq = 0;
        if (!this.bVr && this.bVs == null) {
            this.bVs = new HandlerThread(TAG);
            this.bVs.start();
        }
        if (this.bVw == null) {
            if (this.bVs != null) {
                this.bVw = new a(this.bVs.getLooper());
            } else {
                this.bVw = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bVw.removeCallbacksAndMessages(null);
        }
        this.bVx = new f(this.bUZ.getOutputTotalMs());
    }

    private void YE() {
        this.bVF = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void du(boolean z) {
                if (z) {
                    d.this.bVE.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dv(boolean z) {
                d.this.bVG = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dw(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dx(boolean z) {
                d.this.bVE.YP();
                d.this.bVE = null;
                d.this.bVF = null;
                d.this.u(2, z);
            }
        };
        this.bVC = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void du(boolean z) {
                if (z) {
                    d.this.bVB.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dv(boolean z) {
                d.this.bVD = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void dw(boolean z) {
                boolean unused = d.bVA = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dx(boolean z) {
                d.this.bVB.YP();
                d.this.bVB = null;
                d.this.bVC = null;
                d.this.u(4, z);
            }
        };
        this.bVz = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dy(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dz(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bVy.Zf();
                    d.this.bVy = null;
                }
                d.this.bVz = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean YF() {
        boolean z = true;
        if (this.bVB != null && this.bVB.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bVB.stopRecording();
            this.bVB.YP();
            z = false;
        }
        if (this.bVE != null && this.bVE.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bVE.stopRecording();
            this.bVE.YP();
            z = false;
        }
        if (this.bUZ != null && !this.bVy.a(this.bUZ.getOutputFile(), this.bUZ.getOutputFormat(), this.bVz)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void YG() {
        if (this.bVB != null) {
            this.bVB.a(this.bUZ, this.bVy, this.bVC);
        }
    }

    private void YH() {
        YJ();
        this.bVE.a(this.bVH, this.bUZ, this.bVy, this.bVF);
    }

    private void YI() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bVu);
        if (this.bVw != null) {
            this.bVu = true;
            this.bVw.sendMessageDelayed(this.bVw.obtainMessage(7005), 500L);
        }
    }

    private void YJ() {
        YK();
    }

    private void YK() {
        if (this.bVH != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bVH.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Yk = it.next().Yk();
                if (Yk.XW() == MirrorType.NO_MIRROR) {
                    Yk.gy(-this.bVI);
                } else {
                    Yk.gy(this.bVI);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bVp);
        if (YL()) {
            this.bVw.sendMessage(this.bVw.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(YM())));
        }
    }

    private static void gA(int i) {
        bVp = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            bVp |= i;
        }
        this.bVq++;
    }

    private boolean YL() {
        if (this.bUZ == null) {
            return false;
        }
        return this.bUZ.isAudioIncluded() ? this.bVq == 3 : this.bVq == 2;
    }

    private synchronized boolean YM() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bVp);
        i = (bVp ^ 1) ^ 2;
        if (this.bUZ != null) {
            if (this.bUZ.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bVp);
        if (YN() && this.bVw != null) {
            this.bVw.sendMessage(this.bVw.obtainMessage(7003, Boolean.valueOf(YO())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            bVp ^= i;
        }
        this.bVq--;
    }

    private boolean YN() {
        return this.bVq == 0;
    }

    private synchronized boolean YO() {
        return bVp == 0;
    }

    public void bi(long j) {
        this.bVv *= TimeUtils.NANOS_PER_MS;
        if (this.bUY != null) {
            this.bUY.bh(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bUY != null) {
                        d.this.bUY.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bVt = false;
                    break;
                case 7002:
                    if (d.this.bUY != null) {
                        d.this.bUY.bh(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bUY != null) {
                        if (d.this.bUZ != null) {
                            str = d.this.bUZ.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bUY.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bUY != null) {
                        d.this.bUY.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.YA();
                    break;
                case 7006:
                    d.this.bVt = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
