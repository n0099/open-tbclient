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
/* loaded from: classes9.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int aEZ = 0;
    private static volatile boolean aFk = false;
    private static volatile d aFt;
    private e aEJ;
    private com.baidu.mario.a.b.d aEK;
    private HandlerThread aFc;
    private a aFg;
    private f aFh;
    private com.baidu.mario.a.b.e aFi;
    private com.baidu.mario.a.b.f aFj;
    private com.baidu.mario.a.a.a aFl;
    private com.baidu.mario.a.b.c aFm;
    private com.baidu.mario.a.a.b aFo;
    private com.baidu.mario.a.b.c aFp;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aFr;
    private int aFs;
    private Context mContext;
    private int aFa = 0;
    private boolean aFb = false;
    private volatile boolean aFd = false;
    private boolean aFe = false;
    private long aFf = 0;
    private volatile boolean aFn = false;
    private volatile boolean aFq = false;

    public static d zX() {
        if (aFt == null) {
            synchronized (d.class) {
                if (aFt == null) {
                    aFt = new d();
                }
            }
        }
        return aFt;
    }

    private d() {
    }

    public long zY() {
        if (this.aFo != null) {
            return this.aFo.zY();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aFd);
        if (this.aFd) {
            Ac();
            return;
        }
        this.aFd = true;
        this.mContext = context;
        this.aEK = dVar;
        this.aEJ = eVar;
        zZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zZ() {
        Ad();
        Ae();
        if (Af()) {
            Ag();
            Ah();
        } else if (!this.aFe) {
            Ai();
        } else {
            Ac();
        }
    }

    public void P(long j) {
        if (this.aFo != null && this.aFo.isRunning() && this.aFq && aFk) {
            this.aFo.M(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aFn && this.aFl != null && this.aFl.isRunning()) {
            this.aFl.d(byteBuffer, i, j);
        }
    }

    public void Aa() {
        if (this.aFo != null) {
            this.aFo.Au();
        }
    }

    public void Ab() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aFd);
        if (this.aFd) {
            if (!Am() && this.aFg != null) {
                this.aFg.sendMessage(this.aFg.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aFg != null) {
                this.aFg.sendMessageDelayed(this.aFg.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aFn = false;
        this.aFq = false;
        this.aFf = 0L;
        if (this.aFl != null && this.aFl.isRunning()) {
            this.aFl.stopRecording();
        }
        if (this.aFo != null && this.aFo.isRunning()) {
            this.aFo.stopRecording();
        }
        bo(false);
    }

    public void onDestroy() {
        if (this.aFr != null) {
            this.aFr.clear();
            this.aFr = null;
        }
        this.aFh = null;
        this.mContext = null;
        this.aEK = null;
        cN(0);
        releaseInstance();
        if (this.aFg != null) {
            this.aFg.removeCallbacksAndMessages(null);
            this.aFg = null;
        }
        if (this.aFc != null) {
            this.aFc.quit();
            this.aFc = null;
        }
    }

    private static void releaseInstance() {
        aFt = null;
    }

    private static void bo(boolean z) {
        aFk = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aFr == null) {
                this.aFr = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aFr.size()) {
                    break;
                }
                if (this.aFr.get(i3).zN() == cVar.zN()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aFr.size()) {
                if (this.aFr.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aFr.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aFr.add(cVar.clone());
            } else {
                this.aFr.add(cVar);
            }
            Collections.sort(this.aFr);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aFo != null) {
            a(cVar, z);
            this.aFo.j(this.aFr);
        }
    }

    private void Ac() {
        if (this.aFg != null) {
            this.aFg.sendMessageDelayed(this.aFg.obtainMessage(7001, false), 500L);
        }
    }

    private void Ad() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aFi = new com.baidu.mario.a.b.e();
        }
        if (this.aEK.AI()) {
            this.aFl = new com.baidu.mario.a.a.a();
        } else {
            aFk = true;
        }
        this.aFo = new com.baidu.mario.a.a.b();
        this.aFa = 0;
        if (!this.aFb && this.aFc == null) {
            this.aFc = new HandlerThread(TAG);
            this.aFc.start();
        }
        if (this.aFg == null) {
            if (this.aFc != null) {
                this.aFg = new a(this.aFc.getLooper());
            } else {
                this.aFg = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aFg.removeCallbacksAndMessages(null);
        }
        this.aFh = new f(this.aEK.AC());
    }

    private void Ae() {
        this.aFp = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bp(boolean z) {
                if (z) {
                    d.this.aFo.Ap();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bq(boolean z) {
                d.this.aFq = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void br(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bs(boolean z) {
                d.this.aFo.Aq();
                d.this.aFo = null;
                d.this.aFp = null;
                d.this.l(2, z);
            }
        };
        this.aFm = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bp(boolean z) {
                if (z) {
                    d.this.aFl.Ap();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bq(boolean z) {
                d.this.aFn = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void br(boolean z) {
                boolean unused = d.aFk = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bs(boolean z) {
                d.this.aFl.Aq();
                d.this.aFl = null;
                d.this.aFm = null;
                d.this.l(4, z);
            }
        };
        this.aFj = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void bt(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bu(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aFi.AR();
                    d.this.aFi = null;
                }
                d.this.aFj = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean Af() {
        boolean z = true;
        if (this.aFl != null && this.aFl.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aFl.stopRecording();
            this.aFl.Aq();
            z = false;
        }
        if (this.aFo != null && this.aFo.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aFo.stopRecording();
            this.aFo.Aq();
            z = false;
        }
        if (this.aEK != null && !this.aFi.a(this.aEK.AA(), this.aEK.AB(), this.aFj)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void Ag() {
        if (this.aFl != null) {
            this.aFl.a(this.aEK, this.aFi, this.aFm);
        }
    }

    private void Ah() {
        Aj();
        this.aFo.a(this.aFr, this.aEK, this.aFi, this.aFp);
    }

    private void Ai() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aFe);
        if (this.aFg != null) {
            this.aFe = true;
            this.aFg.sendMessageDelayed(this.aFg.obtainMessage(7005), 500L);
        }
    }

    private void Aj() {
        Ak();
    }

    private void Ak() {
        if (this.aFr != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aFr.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a zJ = it.next().zJ();
                if (zJ.zv() == MirrorType.NO_MIRROR) {
                    zJ.cL(-this.aFs);
                } else {
                    zJ.cL(this.aFs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aEZ);
        if (Al()) {
            this.aFg.sendMessage(this.aFg.obtainMessage(7001, Boolean.valueOf(Am())));
        }
    }

    private static void cN(int i) {
        aEZ = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aEZ |= i;
        }
        this.aFa++;
    }

    private boolean Al() {
        if (this.aEK == null) {
            return false;
        }
        return this.aEK.AI() ? this.aFa == 3 : this.aFa == 2;
    }

    private synchronized boolean Am() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aEZ);
        i = (aEZ ^ 1) ^ 2;
        if (this.aEK != null) {
            if (this.aEK.AI()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aEZ);
        if (An() && this.aFg != null) {
            this.aFg.sendMessage(this.aFg.obtainMessage(7003, Boolean.valueOf(Ao())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aEZ ^= i;
        }
        this.aFa--;
    }

    private boolean An() {
        return this.aFa == 0;
    }

    private synchronized boolean Ao() {
        return aEZ == 0;
    }

    public void Q(long j) {
        this.aFf *= TimeUtils.NANOS_PER_MS;
        if (this.aEJ != null) {
            this.aEJ.O(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            switch (message.what) {
                case 7001:
                    if (d.this.aEJ != null) {
                        d.this.aEJ.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aFd = false;
                    break;
                case 7002:
                    if (d.this.aEJ != null) {
                        d.this.aEJ.O(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aEJ != null) {
                        if (d.this.aEK != null) {
                            str = d.this.aEK.AA();
                        } else {
                            str = null;
                        }
                        d.this.aEJ.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aEJ != null) {
                        d.this.aEJ.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.zZ();
                    break;
                case 7006:
                    d.this.aFd = false;
                    d.this.Ab();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
