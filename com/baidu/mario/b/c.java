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
    private static volatile c axI;
    private com.baidu.mario.b.a.a axA;
    private com.baidu.mario.b.b.c axB;
    private com.baidu.mario.b.a.b axD;
    private com.baidu.mario.b.b.c axE;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> axG;
    private int axH;
    private d axf;
    private com.baidu.mario.b.b.d axg;
    private HandlerThread axr;
    private a axv;
    private e axw;
    private com.baidu.mario.b.b.e axx;
    private f axy;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static volatile int axo = 0;
    private static volatile boolean axz = false;
    private int axp = 0;
    private boolean axq = false;
    private volatile boolean axs = false;
    private boolean axt = false;
    private long axu = 0;
    private volatile boolean axC = false;
    private volatile boolean axF = false;

    public static c yg() {
        if (axI == null) {
            synchronized (c.class) {
                if (axI == null) {
                    axI = new c();
                }
            }
        }
        return axI;
    }

    private c() {
    }

    public long yh() {
        if (this.axD != null) {
            return this.axD.yh();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.b.b.d dVar, d dVar2) {
        Log.i(TAG, "startRecorder mStarting = " + this.axs);
        if (this.axs) {
            yl();
            return;
        }
        this.axs = true;
        this.mContext = context;
        this.axg = dVar;
        this.axf = dVar2;
        yi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi() {
        ym();
        yn();
        if (yo()) {
            yp();
            yq();
        } else if (!this.axt) {
            yr();
        } else {
            yl();
        }
    }

    public void O(long j) {
        if (this.axD != null && this.axD.isRunning() && this.axF && axz) {
            this.axD.L(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.axC && this.axA != null && this.axA.isRunning()) {
            this.axA.d(byteBuffer, i, j);
        }
    }

    public void yj() {
        if (this.axD != null) {
            this.axD.yF();
        }
    }

    public void yk() {
        Log.i(TAG, "stopRecorder mStarting = " + this.axs);
        if (this.axs) {
            if (!yv() && this.axv != null) {
                this.axv.sendMessage(this.axv.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.axv != null) {
                this.axv.sendMessageDelayed(this.axv.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.axC = false;
        this.axF = false;
        this.axu = 0L;
        if (this.axA != null && this.axA.isRunning()) {
            this.axA.yz();
        }
        if (this.axD != null && this.axD.isRunning()) {
            this.axD.yz();
        }
        aZ(false);
    }

    public void onDestroy() {
        if (this.axG != null) {
            this.axG.clear();
            this.axG = null;
        }
        this.axw = null;
        this.mContext = null;
        this.axg = null;
        this.axf = null;
        cy(0);
        releaseInstance();
        if (this.axv != null) {
            this.axv.removeCallbacksAndMessages(null);
            this.axv = null;
        }
        if (this.axr != null) {
            this.axr.quit();
            this.axr = null;
        }
    }

    private static void releaseInstance() {
        axI = null;
    }

    private static void aZ(boolean z) {
        axz = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.axG == null) {
                this.axG = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.axG.size()) {
                    break;
                }
                if (this.axG.get(i3).xY() == cVar.xY()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.axG.size()) {
                if (this.axG.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.axG.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.axG.add(cVar.clone());
            } else {
                this.axG.add(cVar);
            }
            Collections.sort(this.axG);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.axD != null) {
            a(cVar, z);
            this.axD.j(this.axG);
        }
    }

    private void yl() {
        if (this.axv != null) {
            this.axv.sendMessageDelayed(this.axv.obtainMessage(7001, false), 500L);
        }
    }

    private void ym() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.axx = new com.baidu.mario.b.b.e();
        }
        if (this.axg.yU()) {
            this.axA = new com.baidu.mario.b.a.a();
        } else {
            axz = true;
        }
        this.axD = new com.baidu.mario.b.a.b();
        this.axp = 0;
        if (!this.axq && this.axr == null) {
            this.axr = new HandlerThread(TAG);
            this.axr.start();
        }
        if (this.axv == null) {
            if (this.axr != null) {
                this.axv = new a(this.axr.getLooper());
            } else {
                this.axv = new a(this.mContext.getMainLooper());
            }
        } else {
            this.axv.removeCallbacksAndMessages(null);
        }
        this.axw = new e(this.axg.yO());
    }

    private void yn() {
        this.axE = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.1
            @Override // com.baidu.mario.b.b.c
            public void ba(boolean z) {
                if (z) {
                    c.this.axD.yy();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void bb(boolean z) {
                c.this.axF = z;
                c.this.j(2, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void bc(boolean z) {
            }

            @Override // com.baidu.mario.b.b.c
            public void bd(boolean z) {
                c.this.axD.yA();
                c.this.axD = null;
                c.this.axE = null;
                c.this.l(2, z);
            }
        };
        this.axB = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.2
            @Override // com.baidu.mario.b.b.c
            public void ba(boolean z) {
                if (z) {
                    c.this.axA.yy();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void bb(boolean z) {
                c.this.axC = z;
                c.this.j(4, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void bc(boolean z) {
                boolean unused = c.axz = z;
            }

            @Override // com.baidu.mario.b.b.c
            public void bd(boolean z) {
                c.this.axA.yA();
                c.this.axA = null;
                c.this.axB = null;
                c.this.l(4, z);
            }
        };
        this.axy = new f() { // from class: com.baidu.mario.b.c.3
            @Override // com.baidu.mario.b.b.f
            public void be(boolean z) {
                c.this.j(1, z);
            }

            @Override // com.baidu.mario.b.b.f
            public void bf(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    c.this.axx.zd();
                    c.this.axx = null;
                }
                c.this.axy = null;
                c.this.l(1, z);
            }
        };
    }

    private boolean yo() {
        boolean z = true;
        if (this.axA != null && this.axA.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.axA.yz();
            this.axA.yA();
            z = false;
        }
        if (this.axD != null && this.axD.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.axD.yz();
            this.axD.yA();
            z = false;
        }
        if (this.axg != null && !this.axx.a(this.axg.yM(), this.axg.yN(), this.axy)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void yp() {
        if (this.axA != null) {
            this.axA.a(this.axg, this.axx, this.axB);
        }
    }

    private void yq() {
        ys();
        this.axD.a(this.axG, this.axg, this.axx, this.axE);
    }

    private void yr() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.axt);
        if (this.axv != null) {
            this.axt = true;
            this.axv.sendMessageDelayed(this.axv.obtainMessage(7005), 500L);
        }
    }

    private void ys() {
        yt();
    }

    private void yt() {
        if (this.axG != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.axG.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a xU = it.next().xU();
                if (xU.xG() == MirrorType.NO_MIRROR) {
                    xU.cw(-this.axH);
                } else {
                    xU.cw(this.axH);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + axo);
        if (yu()) {
            this.axv.sendMessage(this.axv.obtainMessage(7001, Boolean.valueOf(yv())));
        }
    }

    private static void cy(int i) {
        axo = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            axo |= i;
        }
        this.axp++;
    }

    private boolean yu() {
        if (this.axg == null) {
            return false;
        }
        return this.axg.yU() ? this.axp == 3 : this.axp == 2;
    }

    private synchronized boolean yv() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + axo);
        i = (axo ^ 1) ^ 2;
        if (this.axg != null) {
            if (this.axg.yU()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + axo);
        if (yw() && this.axv != null) {
            this.axv.sendMessage(this.axv.obtainMessage(7003, Boolean.valueOf(yx())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            axo ^= i;
        }
        this.axp--;
    }

    private boolean yw() {
        return this.axp == 0;
    }

    private synchronized boolean yx() {
        return axo == 0;
    }

    public void P(long j) {
        this.axu *= 1000000;
        if (this.axf != null) {
            this.axf.N(j);
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
                    if (c.this.axf != null) {
                        c.this.axf.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    c.this.axs = false;
                    break;
                case 7002:
                    if (c.this.axf != null) {
                        c.this.axf.N(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (c.this.axf != null) {
                        if (c.this.axg != null) {
                            str = c.this.axg.yM();
                        } else {
                            str = null;
                        }
                        c.this.axf.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (c.this.axf != null) {
                        c.this.axf.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    c.this.yi();
                    break;
                case 7006:
                    c.this.axs = false;
                    c.this.yk();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
