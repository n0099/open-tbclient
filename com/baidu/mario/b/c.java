package com.baidu.mario.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.b.b.f;
import com.baidu.mario.gldraw2d.params.MirrorType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile int axG = 0;
    private static volatile boolean axR = false;
    private static volatile c aya;
    private HandlerThread axJ;
    private a axN;
    private e axO;
    private com.baidu.mario.b.b.e axP;
    private f axQ;
    private com.baidu.mario.b.a.a axS;
    private com.baidu.mario.b.b.c axT;
    private com.baidu.mario.b.a.b axV;
    private com.baidu.mario.b.b.c axW;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> axY;
    private int axZ;
    private d axx;
    private com.baidu.mario.b.b.d axy;
    private Context mContext;
    private int axH = 0;
    private boolean axI = false;
    private volatile boolean axK = false;
    private boolean axL = false;
    private long axM = 0;
    private volatile boolean axU = false;
    private volatile boolean axX = false;

    public static c yf() {
        if (aya == null) {
            synchronized (c.class) {
                if (aya == null) {
                    aya = new c();
                }
            }
        }
        return aya;
    }

    private c() {
    }

    public long yg() {
        if (this.axV != null) {
            return this.axV.yg();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.b.b.d dVar, d dVar2) {
        Log.i(TAG, "startRecorder mStarting = " + this.axK);
        if (this.axK) {
            yk();
            return;
        }
        this.axK = true;
        this.mContext = context;
        this.axy = dVar;
        this.axx = dVar2;
        yh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        yl();
        ym();
        if (yn()) {
            yo();
            yp();
        } else if (!this.axL) {
            yq();
        } else {
            yk();
        }
    }

    public void P(long j) {
        if (this.axV != null && this.axV.isRunning() && this.axX && axR) {
            this.axV.M(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.axU && this.axS != null && this.axS.isRunning()) {
            this.axS.d(byteBuffer, i, j);
        }
    }

    public void yi() {
        if (this.axV != null) {
            this.axV.yE();
        }
    }

    public void yj() {
        Log.i(TAG, "stopRecorder mStarting = " + this.axK);
        if (this.axK) {
            if (!yu() && this.axN != null) {
                this.axN.sendMessage(this.axN.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.axN != null) {
                this.axN.sendMessageDelayed(this.axN.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.axU = false;
        this.axX = false;
        this.axM = 0L;
        if (this.axS != null && this.axS.isRunning()) {
            this.axS.yy();
        }
        if (this.axV != null && this.axV.isRunning()) {
            this.axV.yy();
        }
        aZ(false);
    }

    public void onDestroy() {
        if (this.axY != null) {
            this.axY.clear();
            this.axY = null;
        }
        this.axO = null;
        this.mContext = null;
        this.axy = null;
        this.axx = null;
        cy(0);
        releaseInstance();
        if (this.axN != null) {
            this.axN.removeCallbacksAndMessages(null);
            this.axN = null;
        }
        if (this.axJ != null) {
            this.axJ.quit();
            this.axJ = null;
        }
    }

    private static void releaseInstance() {
        aya = null;
    }

    private static void aZ(boolean z) {
        axR = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.axY == null) {
                this.axY = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.axY.size()) {
                    break;
                }
                if (this.axY.get(i3).xX() == cVar.xX()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.axY.size()) {
                if (this.axY.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.axY.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.axY.add(cVar.clone());
            } else {
                this.axY.add(cVar);
            }
            Collections.sort(this.axY);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.axV != null) {
            a(cVar, z);
            this.axV.j(this.axY);
        }
    }

    private void yk() {
        if (this.axN != null) {
            this.axN.sendMessageDelayed(this.axN.obtainMessage(7001, false), 500L);
        }
    }

    private void yl() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axP = new com.baidu.mario.b.b.e();
        }
        if (this.axy.yT()) {
            this.axS = new com.baidu.mario.b.a.a();
        } else {
            axR = true;
        }
        this.axV = new com.baidu.mario.b.a.b();
        this.axH = 0;
        if (!this.axI && this.axJ == null) {
            this.axJ = new HandlerThread(TAG);
            this.axJ.start();
        }
        if (this.axN == null) {
            if (this.axJ != null) {
                this.axN = new a(this.axJ.getLooper());
            } else {
                this.axN = new a(this.mContext.getMainLooper());
            }
        } else {
            this.axN.removeCallbacksAndMessages(null);
        }
        this.axO = new e(this.axy.yN());
    }

    private void ym() {
        this.axW = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.1
            @Override // com.baidu.mario.b.b.c
            public void ba(boolean z) {
                if (z) {
                    c.this.axV.yx();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void bb(boolean z) {
                c.this.axX = z;
                c.this.j(2, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void bc(boolean z) {
            }

            @Override // com.baidu.mario.b.b.c
            public void bd(boolean z) {
                c.this.axV.yz();
                c.this.axV = null;
                c.this.axW = null;
                c.this.l(2, z);
            }
        };
        this.axT = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.2
            @Override // com.baidu.mario.b.b.c
            public void ba(boolean z) {
                if (z) {
                    c.this.axS.yx();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void bb(boolean z) {
                c.this.axU = z;
                c.this.j(4, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void bc(boolean z) {
                boolean unused = c.axR = z;
            }

            @Override // com.baidu.mario.b.b.c
            public void bd(boolean z) {
                c.this.axS.yz();
                c.this.axS = null;
                c.this.axT = null;
                c.this.l(4, z);
            }
        };
        this.axQ = new f() { // from class: com.baidu.mario.b.c.3
            @Override // com.baidu.mario.b.b.f
            public void be(boolean z) {
                c.this.j(1, z);
            }

            @Override // com.baidu.mario.b.b.f
            public void bf(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    c.this.axP.zc();
                    c.this.axP = null;
                }
                c.this.axQ = null;
                c.this.l(1, z);
            }
        };
    }

    private boolean yn() {
        boolean z = true;
        if (this.axS != null && this.axS.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.axS.yy();
            this.axS.yz();
            z = false;
        }
        if (this.axV != null && this.axV.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.axV.yy();
            this.axV.yz();
            z = false;
        }
        if (this.axy != null && !this.axP.a(this.axy.yL(), this.axy.yM(), this.axQ)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void yo() {
        if (this.axS != null) {
            this.axS.a(this.axy, this.axP, this.axT);
        }
    }

    private void yp() {
        yr();
        this.axV.a(this.axY, this.axy, this.axP, this.axW);
    }

    private void yq() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.axL);
        if (this.axN != null) {
            this.axL = true;
            this.axN.sendMessageDelayed(this.axN.obtainMessage(7005), 500L);
        }
    }

    private void yr() {
        ys();
    }

    private void ys() {
        if (this.axY != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.axY.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a xT = it.next().xT();
                if (xT.xF() == MirrorType.NO_MIRROR) {
                    xT.cw(-this.axZ);
                } else {
                    xT.cw(this.axZ);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + axG);
        if (yt()) {
            this.axN.sendMessage(this.axN.obtainMessage(7001, Boolean.valueOf(yu())));
        }
    }

    private static void cy(int i) {
        axG = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            axG |= i;
        }
        this.axH++;
    }

    private boolean yt() {
        if (this.axy == null) {
            return false;
        }
        return this.axy.yT() ? this.axH == 3 : this.axH == 2;
    }

    private synchronized boolean yu() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + axG);
        i = (axG ^ 1) ^ 2;
        if (this.axy != null) {
            if (this.axy.yT()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + axG);
        if (yv() && this.axN != null) {
            this.axN.sendMessage(this.axN.obtainMessage(7003, Boolean.valueOf(yw())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            axG ^= i;
        }
        this.axH--;
    }

    private boolean yv() {
        return this.axH == 0;
    }

    private synchronized boolean yw() {
        return axG == 0;
    }

    public void Q(long j) {
        this.axM *= 1000000;
        if (this.axx != null) {
            this.axx.O(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case 7001:
                    if (c.this.axx != null) {
                        c.this.axx.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    c.this.axK = false;
                    break;
                case 7002:
                    if (c.this.axx != null) {
                        c.this.axx.O(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (c.this.axx != null) {
                        if (c.this.axy != null) {
                            str = c.this.axy.yL();
                        } else {
                            str = null;
                        }
                        c.this.axx.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (c.this.axx != null) {
                        c.this.axx.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    c.this.yh();
                    break;
                case 7006:
                    c.this.axK = false;
                    c.this.yj();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
