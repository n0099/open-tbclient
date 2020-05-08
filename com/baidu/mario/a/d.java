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
    private static volatile d bgG;
    private e bfU;
    private com.baidu.mario.a.b.d bfV;
    private com.baidu.mario.a.a.b bgB;
    private com.baidu.mario.a.b.c bgC;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bgE;
    private int bgF;
    private HandlerThread bgo;
    private a bgt;
    private f bgu;
    private com.baidu.mario.a.b.e bgv;
    private com.baidu.mario.a.b.f bgw;
    private com.baidu.mario.a.a.a bgy;
    private com.baidu.mario.a.b.c bgz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int bgl = 0;
    private static volatile boolean bgx = false;
    private int bgm = 0;
    private boolean bgn = false;
    private volatile boolean bgp = false;
    private boolean bgq = false;
    private long bgr = 0;
    private volatile boolean bgA = false;
    private volatile boolean bgD = false;

    public static d IW() {
        if (bgG == null) {
            synchronized (d.class) {
                if (bgG == null) {
                    bgG = new d();
                }
            }
        }
        return bgG;
    }

    private d() {
    }

    public long IX() {
        if (this.bgB != null) {
            return this.bgB.IX();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.bgp);
        if (this.bgp) {
            Ja();
            return;
        }
        this.bgp = true;
        this.mContext = context;
        this.bfV = dVar;
        this.bfU = eVar;
        IY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        Jb();
        Jc();
        if (Jd()) {
            Je();
            Jf();
        } else if (!this.bgq) {
            Jg();
        } else {
            Ja();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.bgB != null && this.bgB.isRunning() && this.bgD && bgx) {
            this.bgB.az(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.bgA && this.bgy != null && this.bgy.isRunning()) {
            this.bgy.d(byteBuffer, i, j);
        }
    }

    public void IZ() {
        if (this.bgB != null) {
            this.bgB.Js();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.bgp);
        if (this.bgp) {
            if (!Jk() && this.bgt != null) {
                this.bgt.sendMessage(this.bgt.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.bgt != null) {
                this.bgt.sendMessageDelayed(this.bgt.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.bgA = false;
        this.bgD = false;
        this.bgr = 0L;
        if (this.bgy != null && this.bgy.isRunning()) {
            this.bgy.stopRecording();
        }
        if (this.bgB != null && this.bgB.isRunning()) {
            this.bgB.stopRecording();
        }
        cl(false);
    }

    public void onDestroy() {
        if (this.bgE != null) {
            this.bgE.clear();
            this.bgE = null;
        }
        this.bgu = null;
        this.mContext = null;
        this.bfV = null;
        du(0);
        releaseInstance();
        if (this.bgt != null) {
            this.bgt.removeCallbacksAndMessages(null);
            this.bgt = null;
        }
        if (this.bgo != null) {
            this.bgo.quit();
            this.bgo = null;
        }
    }

    private static void releaseInstance() {
        bgG = null;
    }

    private static void cl(boolean z) {
        bgx = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bgE == null) {
                this.bgE = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bgE.size()) {
                    break;
                }
                if (this.bgE.get(i3).IM() == cVar.IM()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bgE.size()) {
                if (this.bgE.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bgE.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bgE.add(cVar.clone());
            } else {
                this.bgE.add(cVar);
            }
            Collections.sort(this.bgE);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.bgB != null) {
            a(cVar, z);
            this.bgB.l(this.bgE);
        }
    }

    private void Ja() {
        if (this.bgt != null) {
            this.bgt.sendMessageDelayed(this.bgt.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Jb() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bgv = new com.baidu.mario.a.b.e();
        }
        if (this.bfV.isAudioIncluded()) {
            this.bgy = new com.baidu.mario.a.a.a();
        } else {
            bgx = true;
        }
        this.bgB = new com.baidu.mario.a.a.b();
        this.bgm = 0;
        if (!this.bgn && this.bgo == null) {
            this.bgo = new HandlerThread(TAG);
            this.bgo.start();
        }
        if (this.bgt == null) {
            if (this.bgo != null) {
                this.bgt = new a(this.bgo.getLooper());
            } else {
                this.bgt = new a(this.mContext.getMainLooper());
            }
        } else {
            this.bgt.removeCallbacksAndMessages(null);
        }
        this.bgu = new f(this.bfV.getOutputTotalMs());
    }

    private void Jc() {
        this.bgC = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cm(boolean z) {
                if (z) {
                    d.this.bgB.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cn(boolean z) {
                d.this.bgD = z;
                d.this.m(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void co(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cp(boolean z) {
                d.this.bgB.Jn();
                d.this.bgB = null;
                d.this.bgC = null;
                d.this.o(2, z);
            }
        };
        this.bgz = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cm(boolean z) {
                if (z) {
                    d.this.bgy.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cn(boolean z) {
                d.this.bgA = z;
                d.this.m(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void co(boolean z) {
                boolean unused = d.bgx = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cp(boolean z) {
                d.this.bgy.Jn();
                d.this.bgy = null;
                d.this.bgz = null;
                d.this.o(4, z);
            }
        };
        this.bgw = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cq(boolean z) {
                d.this.m(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cr(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.bgv.JD();
                    d.this.bgv = null;
                }
                d.this.bgw = null;
                d.this.o(1, z);
            }
        };
    }

    private boolean Jd() {
        boolean z = true;
        if (this.bgy != null && this.bgy.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bgy.stopRecording();
            this.bgy.Jn();
            z = false;
        }
        if (this.bgB != null && this.bgB.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.bgB.stopRecording();
            this.bgB.Jn();
            z = false;
        }
        if (this.bfV != null && !this.bgv.a(this.bfV.getOutputFile(), this.bfV.getOutputFormat(), this.bgw)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Je() {
        if (this.bgy != null) {
            this.bgy.a(this.bfV, this.bgv, this.bgz);
        }
    }

    private void Jf() {
        Jh();
        this.bgB.a(this.bgE, this.bfV, this.bgv, this.bgC);
    }

    private void Jg() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.bgq);
        if (this.bgt != null) {
            this.bgq = true;
            this.bgt.sendMessageDelayed(this.bgt.obtainMessage(7005), 500L);
        }
    }

    private void Jh() {
        Ji();
    }

    private void Ji() {
        if (this.bgE != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bgE.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a II = it.next().II();
                if (II.Iu() == MirrorType.NO_MIRROR) {
                    II.ds(-this.bgF);
                } else {
                    II.ds(this.bgF);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        n(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + bgl);
        if (Jj()) {
            this.bgt.sendMessage(this.bgt.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Jk())));
        }
    }

    private static void du(int i) {
        bgl = i;
    }

    private void n(int i, boolean z) {
        if (z) {
            bgl |= i;
        }
        this.bgm++;
    }

    private boolean Jj() {
        if (this.bfV == null) {
            return false;
        }
        return this.bfV.isAudioIncluded() ? this.bgm == 3 : this.bgm == 2;
    }

    private synchronized boolean Jk() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + bgl);
        i = (bgl ^ 1) ^ 2;
        if (this.bfV != null) {
            if (this.bfV.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        p(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + bgl);
        if (Jl() && this.bgt != null) {
            this.bgt.sendMessage(this.bgt.obtainMessage(7003, Boolean.valueOf(Jm())));
        }
    }

    private void p(int i, boolean z) {
        if (z) {
            bgl ^= i;
        }
        this.bgm--;
    }

    private boolean Jl() {
        return this.bgm == 0;
    }

    private synchronized boolean Jm() {
        return bgl == 0;
    }

    public void aC(long j) {
        this.bgr *= TimeUtils.NANOS_PER_MS;
        if (this.bfU != null) {
            this.bfU.aB(j);
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
                    if (d.this.bfU != null) {
                        d.this.bfU.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.bgp = false;
                    break;
                case 7002:
                    if (d.this.bfU != null) {
                        d.this.bfU.aB(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bfU != null) {
                        if (d.this.bfV != null) {
                            str = d.this.bfV.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bfU.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bfU != null) {
                        d.this.bfU.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.IY();
                    break;
                case 7006:
                    d.this.bgp = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
