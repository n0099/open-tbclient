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
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bWZ = 0;
    private static volatile boolean bXk = false;
    private static volatile d bXt;
    private e bWI;
    private com.baidu.mario.a.b.d bWJ;
    private HandlerThread bXc;
    private a bXg;
    private f bXh;
    private com.baidu.mario.a.b.e bXi;
    private com.baidu.mario.a.b.f bXj;
    private com.baidu.mario.a.a.a bXl;
    private com.baidu.mario.a.b.c bXm;
    private com.baidu.mario.a.a.b bXo;
    private com.baidu.mario.a.b.c bXp;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bXr;
    private int bXs;
    private Context mContext;
    private int bXa = 0;
    private boolean bXb = false;
    private volatile boolean bXd = false;
    private boolean bXe = false;
    private long bXf = 0;
    private volatile boolean bXn = false;
    private volatile boolean bXq = false;

    public static d Zh() {
        if (bXt == null) {
            synchronized (d.class) {
                if (bXt == null) {
                    bXt = new d();
                }
            }
        }
        return bXt;
    }

    private d() {
    }

    public long Zi() {
        if (this.bXo != null) {
            return this.bXo.Zi();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bXd);
        if (this.bXd) {
            Zl();
            return;
        }
        this.bXd = true;
        this.mContext = context;
        this.bWJ = dVar;
        this.bWI = eVar;
        Zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        Zm();
        Zn();
        if (Zo()) {
            Zp();
            Zq();
        } else if (!this.bXe) {
            Zr();
        } else {
            Zl();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bXo != null && this.bXo.isRunning() && this.bXq && bXk) {
            this.bXo.bf(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bXn && this.bXl != null && this.bXl.isRunning()) {
            this.bXl.d(byteBuffer, i, j);
        }
    }

    public void Zk() {
        if (this.bXo != null) {
            this.bXo.ZD();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bXd);
        if (this.bXd) {
            if (!Zv() && this.bXg != null) {
                this.bXg.sendMessage(this.bXg.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bXg != null) {
                this.bXg.sendMessageDelayed(this.bXg.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bXn = false;
        this.bXq = false;
        this.bXf = 0L;
        if (this.bXl != null && this.bXl.isRunning()) {
            this.bXl.stopRecording();
        }
        if (this.bXo != null && this.bXo.isRunning()) {
            this.bXo.stopRecording();
        }
        dr(false);
    }

    public void onDestroy() {
        if (this.bXr != null) {
            this.bXr.clear();
            this.bXr = null;
        }
        this.bXh = null;
        this.mContext = null;
        this.bWJ = null;
        gE(0);
        releaseInstance();
        if (this.bXg != null) {
            this.bXg.removeCallbacksAndMessages(null);
            this.bXg = null;
        }
        if (this.bXc != null) {
            this.bXc.quit();
            this.bXc = null;
        }
    }

    private static void releaseInstance() {
        bXt = null;
    }

    private static void dr(boolean z) {
        bXk = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bXr == null) {
                this.bXr = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bXr.size()) {
                    break;
                }
                if (this.bXr.get(i3).YX() == cVar.YX()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bXr.size()) {
                if (this.bXr.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bXr.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bXr.add(cVar.clone());
            } else {
                this.bXr.add(cVar);
            }
            Collections.sort(this.bXr);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bXo != null) {
            a(cVar, z);
            this.bXo.q(this.bXr);
        }
    }

    private void Zl() {
        if (this.bXg != null) {
            this.bXg.sendMessageDelayed(this.bXg.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Zm() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bXi = new com.baidu.mario.a.b.e();
        }
        if (this.bWJ.isAudioIncluded()) {
            this.bXl = new com.baidu.mario.a.a.a();
        } else {
            bXk = true;
        }
        this.bXo = new com.baidu.mario.a.a.b();
        this.bXa = 0;
        if (!this.bXb && this.bXc == null) {
            this.bXc = new HandlerThread(TAG);
            this.bXc.start();
        }
        if (this.bXg == null) {
            if (this.bXc != null) {
                this.bXg = new a(this.bXc.getLooper());
            } else {
                this.bXg = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bXg.removeCallbacksAndMessages(null);
        }
        this.bXh = new f(this.bWJ.getOutputTotalMs());
    }

    private void Zn() {
        this.bXp = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void ds(boolean z) {
                if (z) {
                    d.this.bXo.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dt(boolean z) {
                d.this.bXq = z;
                d.this.r(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void du(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void dv(boolean z) {
                d.this.bXo.Zy();
                d.this.bXo = null;
                d.this.bXp = null;
                d.this.u(2, z);
            }
        };
        this.bXm = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void ds(boolean z) {
                if (z) {
                    d.this.bXl.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void dt(boolean z) {
                d.this.bXn = z;
                d.this.r(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void du(boolean z) {
                boolean unused = d.bXk = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void dv(boolean z) {
                d.this.bXl.Zy();
                d.this.bXl = null;
                d.this.bXm = null;
                d.this.u(4, z);
            }
        };
        this.bXj = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void dw(boolean z) {
                d.this.r(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void dx(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bXi.ZO();
                    d.this.bXi = null;
                }
                d.this.bXj = null;
                d.this.u(1, z);
            }
        };
    }

    private boolean Zo() {
        boolean z = true;
        if (this.bXl != null && this.bXl.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bXl.stopRecording();
            this.bXl.Zy();
            z = false;
        }
        if (this.bXo != null && this.bXo.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bXo.stopRecording();
            this.bXo.Zy();
            z = false;
        }
        if (this.bWJ != null && !this.bXi.a(this.bWJ.getOutputFile(), this.bWJ.getOutputFormat(), this.bXj)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Zp() {
        if (this.bXl != null) {
            this.bXl.a(this.bWJ, this.bXi, this.bXm);
        }
    }

    private void Zq() {
        Zs();
        this.bXo.a(this.bXr, this.bWJ, this.bXi, this.bXp);
    }

    private void Zr() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bXe);
        if (this.bXg != null) {
            this.bXe = true;
            this.bXg.sendMessageDelayed(this.bXg.obtainMessage(7005), 500L);
        }
    }

    private void Zs() {
        Zt();
    }

    private void Zt() {
        if (this.bXr != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bXr.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a YT = it.next().YT();
                if (YT.YF() == MirrorType.NO_MIRROR) {
                    YT.gC(-this.bXs);
                } else {
                    YT.gC(this.bXs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        t(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bWZ);
        if (Zu()) {
            this.bXg.sendMessage(this.bXg.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Zv())));
        }
    }

    private static void gE(int i) {
        bWZ = i;
    }

    private void t(int i, boolean z) {
        if (z) {
            bWZ |= i;
        }
        this.bXa++;
    }

    private boolean Zu() {
        if (this.bWJ == null) {
            return false;
        }
        return this.bWJ.isAudioIncluded() ? this.bXa == 3 : this.bXa == 2;
    }

    private synchronized boolean Zv() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bWZ);
        i = (bWZ ^ 1) ^ 2;
        if (this.bWJ != null) {
            if (this.bWJ.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        v(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bWZ);
        if (Zw() && this.bXg != null) {
            this.bXg.sendMessage(this.bXg.obtainMessage(7003, Boolean.valueOf(Zx())));
        }
    }

    private void v(int i, boolean z) {
        if (z) {
            bWZ ^= i;
        }
        this.bXa--;
    }

    private boolean Zw() {
        return this.bXa == 0;
    }

    private synchronized boolean Zx() {
        return bWZ == 0;
    }

    public void bi(long j) {
        this.bXf *= TimeUtils.NANOS_PER_MS;
        if (this.bWI != null) {
            this.bWI.bh(j);
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
                    if (d.this.bWI != null) {
                        d.this.bWI.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bXd = false;
                    break;
                case 7002:
                    if (d.this.bWI != null) {
                        d.this.bWI.bh(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bWI != null) {
                        if (d.this.bWJ != null) {
                            str = d.this.bWJ.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bWI.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bWI != null) {
                        d.this.bWI.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Zj();
                    break;
                case 7006:
                    d.this.bXd = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
