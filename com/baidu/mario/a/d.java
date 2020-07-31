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
/* loaded from: classes10.dex */
public class d {
    private static volatile d btA;
    private e bsO;
    private com.baidu.mario.a.b.d bsP;
    private HandlerThread bti;
    private a btm;
    private f bto;
    private com.baidu.mario.a.b.e btp;
    private com.baidu.mario.a.b.f btq;
    private com.baidu.mario.a.a.a bts;
    private com.baidu.mario.a.b.c btt;
    private com.baidu.mario.a.a.b btv;
    private com.baidu.mario.a.b.c btw;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> bty;
    private int btz;
    private Context mContext;
    private static final String TAG = d.class.getSimpleName();
    private static volatile int btf = 0;
    private static volatile boolean btr = false;
    private int btg = 0;
    private boolean bth = false;
    private volatile boolean btj = false;
    private boolean btk = false;
    private long btl = 0;
    private volatile boolean btu = false;
    private volatile boolean btx = false;

    public static d Mf() {
        if (btA == null) {
            synchronized (d.class) {
                if (btA == null) {
                    btA = new d();
                }
            }
        }
        return btA;
    }

    private d() {
    }

    public long Mg() {
        if (this.btv != null) {
            return this.btv.Mg();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.btj);
        if (this.btj) {
            Mj();
            return;
        }
        this.btj = true;
        this.mContext = context;
        this.bsP = dVar;
        this.bsO = eVar;
        Mh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        Mk();
        Ml();
        if (Mm()) {
            Mn();
            Mo();
        } else if (!this.btk) {
            Mp();
        } else {
            Mj();
        }
    }

    public void onVideoFrameAvailable(long j) {
        if (this.btv != null && this.btv.isRunning() && this.btx && btr) {
            this.btv.aE(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.btu && this.bts != null && this.bts.isRunning()) {
            this.bts.d(byteBuffer, i, j);
        }
    }

    public void Mi() {
        if (this.btv != null) {
            this.btv.MB();
        }
    }

    public void stopRecorder() {
        Log.i(TAG, "stopRecorder mStarting = " + this.btj);
        if (this.btj) {
            if (!Mt() && this.btm != null) {
                this.btm.sendMessage(this.btm.obtainMessage(7004, Integer.valueOf((int) MovieRecorder.ERROR_CODE_ON_STOP)));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.btm != null) {
                this.btm.sendMessageDelayed(this.btm.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.btu = false;
        this.btx = false;
        this.btl = 0L;
        if (this.bts != null && this.bts.isRunning()) {
            this.bts.stopRecording();
        }
        if (this.btv != null && this.btv.isRunning()) {
            this.btv.stopRecording();
        }
        cF(false);
    }

    public void onDestroy() {
        if (this.bty != null) {
            this.bty.clear();
            this.bty = null;
        }
        this.bto = null;
        this.mContext = null;
        this.bsP = null;
        dL(0);
        releaseInstance();
        if (this.btm != null) {
            this.btm.removeCallbacksAndMessages(null);
            this.btm = null;
        }
        if (this.bti != null) {
            this.bti.quit();
            this.bti = null;
        }
    }

    private static void releaseInstance() {
        btA = null;
    }

    private static void cF(boolean z) {
        btr = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.bty == null) {
                this.bty = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.bty.size()) {
                    break;
                }
                if (this.bty.get(i3).LV() == cVar.LV()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.bty.size()) {
                if (this.bty.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.bty.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.bty.add(cVar.clone());
            } else {
                this.bty.add(cVar);
            }
            Collections.sort(this.bty);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.btv != null) {
            a(cVar, z);
            this.btv.l(this.bty);
        }
    }

    private void Mj() {
        if (this.btm != null) {
            this.btm.sendMessageDelayed(this.btm.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void Mk() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.btp = new com.baidu.mario.a.b.e();
        }
        if (this.bsP.isAudioIncluded()) {
            this.bts = new com.baidu.mario.a.a.a();
        } else {
            btr = true;
        }
        this.btv = new com.baidu.mario.a.a.b();
        this.btg = 0;
        if (!this.bth && this.bti == null) {
            this.bti = new HandlerThread(TAG);
            this.bti.start();
        }
        if (this.btm == null) {
            if (this.bti != null) {
                this.btm = new a(this.bti.getLooper());
            } else {
                this.btm = new a(this.mContext.getMainLooper());
            }
        } else {
            this.btm.removeCallbacksAndMessages(null);
        }
        this.bto = new f(this.bsP.getOutputTotalMs());
    }

    private void Ml() {
        this.btw = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void cG(boolean z) {
                if (z) {
                    d.this.btv.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cH(boolean z) {
                d.this.btx = z;
                d.this.n(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cI(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void cJ(boolean z) {
                d.this.btv.Mw();
                d.this.btv = null;
                d.this.btw = null;
                d.this.p(2, z);
            }
        };
        this.btt = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void cG(boolean z) {
                if (z) {
                    d.this.bts.startRecording();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void cH(boolean z) {
                d.this.btu = z;
                d.this.n(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void cI(boolean z) {
                boolean unused = d.btr = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void cJ(boolean z) {
                d.this.bts.Mw();
                d.this.bts = null;
                d.this.btt = null;
                d.this.p(4, z);
            }
        };
        this.btq = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void cK(boolean z) {
                d.this.n(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void cL(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.btp.MM();
                    d.this.btp = null;
                }
                d.this.btq = null;
                d.this.p(1, z);
            }
        };
    }

    private boolean Mm() {
        boolean z = true;
        if (this.bts != null && this.bts.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.bts.stopRecording();
            this.bts.Mw();
            z = false;
        }
        if (this.btv != null && this.btv.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.btv.stopRecording();
            this.btv.Mw();
            z = false;
        }
        if (this.bsP != null && !this.btp.a(this.bsP.getOutputFile(), this.bsP.getOutputFormat(), this.btq)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Mn() {
        if (this.bts != null) {
            this.bts.a(this.bsP, this.btp, this.btt);
        }
    }

    private void Mo() {
        Mq();
        this.btv.a(this.bty, this.bsP, this.btp, this.btw);
    }

    private void Mp() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.btk);
        if (this.btm != null) {
            this.btk = true;
            this.btm.sendMessageDelayed(this.btm.obtainMessage(7005), 500L);
        }
    }

    private void Mq() {
        Mr();
    }

    private void Mr() {
        if (this.bty != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.bty.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a LR = it.next().LR();
                if (LR.LD() == MirrorType.NO_MIRROR) {
                    LR.dJ(-this.btz);
                } else {
                    LR.dJ(this.btz);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        o(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + btf);
        if (Ms()) {
            this.btm.sendMessage(this.btm.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(Mt())));
        }
    }

    private static void dL(int i) {
        btf = i;
    }

    private void o(int i, boolean z) {
        if (z) {
            btf |= i;
        }
        this.btg++;
    }

    private boolean Ms() {
        if (this.bsP == null) {
            return false;
        }
        return this.bsP.isAudioIncluded() ? this.btg == 3 : this.btg == 2;
    }

    private synchronized boolean Mt() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + btf);
        i = (btf ^ 1) ^ 2;
        if (this.bsP != null) {
            if (this.bsP.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        q(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + btf);
        if (Mu() && this.btm != null) {
            this.btm.sendMessage(this.btm.obtainMessage(7003, Boolean.valueOf(Mv())));
        }
    }

    private void q(int i, boolean z) {
        if (z) {
            btf ^= i;
        }
        this.btg--;
    }

    private boolean Mu() {
        return this.btg == 0;
    }

    private synchronized boolean Mv() {
        return btf == 0;
    }

    public void aH(long j) {
        this.btl *= TimeUtils.NANOS_PER_MS;
        if (this.bsO != null) {
            this.bsO.aG(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (d.this.bsO != null) {
                        d.this.bsO.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.btj = false;
                    break;
                case 7002:
                    if (d.this.bsO != null) {
                        d.this.bsO.aG(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.bsO != null) {
                        if (d.this.bsP != null) {
                            str = d.this.bsP.getOutputFile();
                        } else {
                            str = null;
                        }
                        d.this.bsO.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.bsO != null) {
                        d.this.bsO.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Mh();
                    break;
                case 7006:
                    d.this.btj = false;
                    d.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
