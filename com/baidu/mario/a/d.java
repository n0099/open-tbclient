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
    private static volatile d bgB;
    private e bfP;
    private com.baidu.mario.a.b.d bfQ;
    private int bgA;
    private HandlerThread bgj;
    private a bgn;
    private f bgo;
    private com.baidu.mario.a.b.e bgp;
    private com.baidu.mario.a.b.f bgq;
    private com.baidu.mario.a.a.a bgt;
    private com.baidu.mario.a.b.c bgu;
    private com.baidu.mario.a.a.b bgw;
    private com.baidu.mario.a.b.c bgx;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bgz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bgg = 0;
    private static volatile boolean bgr = false;
    private int bgh = 0;
    private boolean bgi = false;
    private volatile boolean bgk = false;
    private boolean bgl = false;
    private long bgm = 0;
    private volatile boolean bgv = false;
    private volatile boolean bgy = false;

    public static d IX() {
        if (bgB == null) {
            synchronized (d.class) {
                if (bgB == null) {
                    bgB = new d();
                }
            }
        }
        return bgB;
    }

    private d() {
    }

    public long IY() {
        if (this.bgw != null) {
            return this.bgw.IY();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bgk);
        if (this.bgk) {
            Jb();
            return;
        }
        this.bgk = true;
        this.mContext = context;
        this.bfQ = dVar;
        this.bfP = eVar;
        IZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IZ() {
        Jc();
        Jd();
        if (Je()) {
            Jf();
            Jg();
        } else if (!this.bgl) {
            Jh();
        } else {
            Jb();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bgw != null && this.bgw.isRunning() && this.bgy && bgr) {
            this.bgw.az(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bgv && this.bgt != null && this.bgt.isRunning()) {
            this.bgt.d(byteBuffer, i, j);
        }
    }

    public void Ja() {
        if (this.bgw != null) {
            this.bgw.Jt();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bgk);
        if (this.bgk) {
            if (!Jl() && this.bgn != null) {
                this.bgn.sendMessage(this.bgn.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bgn != null) {
                this.bgn.sendMessageDelayed(this.bgn.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bgv = false;
        this.bgy = false;
        this.bgm = 0L;
        if (this.bgt != null && this.bgt.isRunning()) {
            this.bgt.stopRecording();
        }
        if (this.bgw != null && this.bgw.isRunning()) {
            this.bgw.stopRecording();
        }
        cl(false);
    }

    public void onDestroy() {
        if (this.bgz != null) {
            this.bgz.clear();
            this.bgz = null;
        }
        this.bgo = null;
        this.mContext = null;
        this.bfQ = null;
        du(0);
        releaseInstance();
        if (this.bgn != null) {
            this.bgn.removeCallbacksAndMessages(null);
            this.bgn = null;
        }
        if (this.bgj != null) {
            this.bgj.quit();
            this.bgj = null;
        }
    }

    private static void releaseInstance() {
        bgB = null;
    }

    private static void cl(boolean z) {
        bgr = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bgz == null) {
                this.bgz = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bgz.size()) {
                    break;
                }
                if (this.bgz.get(i3).IN() == cVar.IN()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bgz.size()) {
                if (this.bgz.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bgz.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bgz.add(cVar.clone());
            } else {
                this.bgz.add(cVar);
            }
            Collections.sort(this.bgz);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bgw != null) {
            a(cVar, z);
            this.bgw.l(this.bgz);
        }
    }

    private void Jb() {
        if (this.bgn != null) {
            this.bgn.sendMessageDelayed(this.bgn.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Jc() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgp = new com.baidu.mario.a.b.e();
        }
        if (this.bfQ.isAudioIncluded()) {
            this.bgt = new com.baidu.mario.a.a.a();
        } else {
            bgr = true;
        }
        this.bgw = new com.baidu.mario.a.a.b();
        this.bgh = 0;
        if (!this.bgi && this.bgj == null) {
            this.bgj = new HandlerThread(TAG);
            this.bgj.start();
        }
        if (this.bgn == null) {
            if (this.bgj != null) {
                this.bgn = new a(this.bgj.getLooper());
            } else {
                this.bgn = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bgn.removeCallbacksAndMessages(null);
        }
        this.bgo = new f(this.bfQ.getOutputTotalMs());
    }

    private void Jd() {
        this.bgx = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cm(boolean z) {
                if (z) {
                    d.this.bgw.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cn(boolean z) {
                d.this.bgy = z;
                d.this.m(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void co(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cp(boolean z) {
                d.this.bgw.Jo();
                d.this.bgw = null;
                d.this.bgx = null;
                d.this.o(2, z);
            }
        };
        this.bgu = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cm(boolean z) {
                if (z) {
                    d.this.bgt.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cn(boolean z) {
                d.this.bgv = z;
                d.this.m(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void co(boolean z) {
                boolean unused = d.bgr = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cp(boolean z) {
                d.this.bgt.Jo();
                d.this.bgt = null;
                d.this.bgu = null;
                d.this.o(4, z);
            }
        };
        this.bgq = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cq(boolean z) {
                d.this.m(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cr(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bgp.JE();
                    d.this.bgp = null;
                }
                d.this.bgq = null;
                d.this.o(1, z);
            }
        };
    }

    private boolean Je() {
        boolean z = true;
        if (this.bgt != null && this.bgt.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bgt.stopRecording();
            this.bgt.Jo();
            z = false;
        }
        if (this.bgw != null && this.bgw.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bgw.stopRecording();
            this.bgw.Jo();
            z = false;
        }
        if (this.bfQ != null && !this.bgp.a(this.bfQ.getOutputFile(), this.bfQ.getOutputFormat(), this.bgq)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Jf() {
        if (this.bgt != null) {
            this.bgt.a(this.bfQ, this.bgp, this.bgu);
        }
    }

    private void Jg() {
        Ji();
        this.bgw.a(this.bgz, this.bfQ, this.bgp, this.bgx);
    }

    private void Jh() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bgl);
        if (this.bgn != null) {
            this.bgl = true;
            this.bgn.sendMessageDelayed(this.bgn.obtainMessage(7005), 500L);
        }
    }

    private void Ji() {
        Jj();
    }

    private void Jj() {
        if (this.bgz != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bgz.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a IJ = it.next().IJ();
                if (IJ.Iv() == MirrorType.NO_MIRROR) {
                    IJ.ds(-this.bgA);
                } else {
                    IJ.ds(this.bgA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        n(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bgg);
        if (Jk()) {
            this.bgn.sendMessage(this.bgn.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Jl())));
        }
    }

    private static void du(int i) {
        bgg = i;
    }

    private void n(int i, boolean z) {
        if (z) {
            bgg |= i;
        }
        this.bgh++;
    }

    private boolean Jk() {
        if (this.bfQ == null) {
            return false;
        }
        return this.bfQ.isAudioIncluded() ? this.bgh == 3 : this.bgh == 2;
    }

    private synchronized boolean Jl() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bgg);
        i = (bgg ^ 1) ^ 2;
        if (this.bfQ != null) {
            if (this.bfQ.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        p(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bgg);
        if (Jm() && this.bgn != null) {
            this.bgn.sendMessage(this.bgn.obtainMessage(7003, Boolean.valueOf(Jn())));
        }
    }

    private void p(int i, boolean z) {
        if (z) {
            bgg ^= i;
        }
        this.bgh--;
    }

    private boolean Jm() {
        return this.bgh == 0;
    }

    private synchronized boolean Jn() {
        return bgg == 0;
    }

    public void aC(long j) {
        this.bgm *= TimeUtils.NANOS_PER_MS;
        if (this.bfP != null) {
            this.bfP.aB(j);
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
                    if (d.this.bfP != null) {
                        d.this.bfP.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bgk = false;
                    break;
                case 7002:
                    if (d.this.bfP != null) {
                        d.this.bfP.aB(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bfP != null) {
                        if (d.this.bfQ != null) {
                            str = d.this.bfQ.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bfP.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bfP != null) {
                        d.this.bfP.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.IZ();
                    break;
                case 7006:
                    d.this.bgk = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
