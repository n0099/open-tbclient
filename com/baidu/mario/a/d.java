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
/* loaded from: classes10.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private static volatile int aFR = 0;
    private static volatile boolean aGc = false;
    private static volatile d aGl;
    private e aFB;
    private com.baidu.mario.a.b.d aFC;
    private HandlerThread aFU;
    private a aFY;
    private f aFZ;
    private com.baidu.mario.a.b.e aGa;
    private com.baidu.mario.a.b.f aGb;
    private com.baidu.mario.a.a.a aGd;
    private com.baidu.mario.a.b.c aGe;
    private com.baidu.mario.a.a.b aGg;
    private com.baidu.mario.a.b.c aGh;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aGj;
    private int aGk;
    private Context mContext;
    private int aFS = 0;
    private boolean aFT = false;
    private volatile boolean aFV = false;
    private boolean aFW = false;
    private long aFX = 0;
    private volatile boolean aGf = false;
    private volatile boolean aGi = false;

    public static d At() {
        if (aGl == null) {
            synchronized (d.class) {
                if (aGl == null) {
                    aGl = new d();
                }
            }
        }
        return aGl;
    }

    private d() {
    }

    public long Au() {
        if (this.aGg != null) {
            return this.aGg.Au();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aFV);
        if (this.aFV) {
            Ay();
            return;
        }
        this.aFV = true;
        this.mContext = context;
        this.aFC = dVar;
        this.aFB = eVar;
        Av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Av() {
        Az();
        AA();
        if (AB()) {
            AC();
            AD();
        } else if (!this.aFW) {
            AE();
        } else {
            Ay();
        }
    }

    public void S(long j) {
        if (this.aGg != null && this.aGg.isRunning() && this.aGi && aGc) {
            this.aGg.P(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aGf && this.aGd != null && this.aGd.isRunning()) {
            this.aGd.d(byteBuffer, i, j);
        }
    }

    public void Aw() {
        if (this.aGg != null) {
            this.aGg.AQ();
        }
    }

    public void Ax() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aFV);
        if (this.aFV) {
            if (!AI() && this.aFY != null) {
                this.aFY.sendMessage(this.aFY.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aFY != null) {
                this.aFY.sendMessageDelayed(this.aFY.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aGf = false;
        this.aGi = false;
        this.aFX = 0L;
        if (this.aGd != null && this.aGd.isRunning()) {
            this.aGd.stopRecording();
        }
        if (this.aGg != null && this.aGg.isRunning()) {
            this.aGg.stopRecording();
        }
        bt(false);
    }

    public void onDestroy() {
        if (this.aGj != null) {
            this.aGj.clear();
            this.aGj = null;
        }
        this.aFZ = null;
        this.mContext = null;
        this.aFC = null;
        cO(0);
        releaseInstance();
        if (this.aFY != null) {
            this.aFY.removeCallbacksAndMessages(null);
            this.aFY = null;
        }
        if (this.aFU != null) {
            this.aFU.quit();
            this.aFU = null;
        }
    }

    private static void releaseInstance() {
        aGl = null;
    }

    private static void bt(boolean z) {
        aGc = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aGj == null) {
                this.aGj = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aGj.size()) {
                    break;
                }
                if (this.aGj.get(i3).Aj() == cVar.Aj()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aGj.size()) {
                if (this.aGj.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aGj.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aGj.add(cVar.clone());
            } else {
                this.aGj.add(cVar);
            }
            Collections.sort(this.aGj);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aGg != null) {
            a(cVar, z);
            this.aGg.j(this.aGj);
        }
    }

    private void Ay() {
        if (this.aFY != null) {
            this.aFY.sendMessageDelayed(this.aFY.obtainMessage(7001, false), 500L);
        }
    }

    private void Az() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aGa = new com.baidu.mario.a.b.e();
        }
        if (this.aFC.Be()) {
            this.aGd = new com.baidu.mario.a.a.a();
        } else {
            aGc = true;
        }
        this.aGg = new com.baidu.mario.a.a.b();
        this.aFS = 0;
        if (!this.aFT && this.aFU == null) {
            this.aFU = new HandlerThread(TAG);
            this.aFU.start();
        }
        if (this.aFY == null) {
            if (this.aFU != null) {
                this.aFY = new a(this.aFU.getLooper());
            } else {
                this.aFY = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aFY.removeCallbacksAndMessages(null);
        }
        this.aFZ = new f(this.aFC.AY());
    }

    private void AA() {
        this.aGh = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bu(boolean z) {
                if (z) {
                    d.this.aGg.AL();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bv(boolean z) {
                d.this.aGi = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bw(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bx(boolean z) {
                d.this.aGg.AM();
                d.this.aGg = null;
                d.this.aGh = null;
                d.this.l(2, z);
            }
        };
        this.aGe = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bu(boolean z) {
                if (z) {
                    d.this.aGd.AL();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bv(boolean z) {
                d.this.aGf = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bw(boolean z) {
                boolean unused = d.aGc = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bx(boolean z) {
                d.this.aGd.AM();
                d.this.aGd = null;
                d.this.aGe = null;
                d.this.l(4, z);
            }
        };
        this.aGb = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void by(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bz(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aGa.Bn();
                    d.this.aGa = null;
                }
                d.this.aGb = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean AB() {
        boolean z = true;
        if (this.aGd != null && this.aGd.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aGd.stopRecording();
            this.aGd.AM();
            z = false;
        }
        if (this.aGg != null && this.aGg.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aGg.stopRecording();
            this.aGg.AM();
            z = false;
        }
        if (this.aFC != null && !this.aGa.a(this.aFC.AW(), this.aFC.AX(), this.aGb)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void AC() {
        if (this.aGd != null) {
            this.aGd.a(this.aFC, this.aGa, this.aGe);
        }
    }

    private void AD() {
        AF();
        this.aGg.a(this.aGj, this.aFC, this.aGa, this.aGh);
    }

    private void AE() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aFW);
        if (this.aFY != null) {
            this.aFW = true;
            this.aFY.sendMessageDelayed(this.aFY.obtainMessage(7005), 500L);
        }
    }

    private void AF() {
        AG();
    }

    private void AG() {
        if (this.aGj != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aGj.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Af = it.next().Af();
                if (Af.zR() == MirrorType.NO_MIRROR) {
                    Af.cM(-this.aGk);
                } else {
                    Af.cM(this.aGk);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aFR);
        if (AH()) {
            this.aFY.sendMessage(this.aFY.obtainMessage(7001, Boolean.valueOf(AI())));
        }
    }

    private static void cO(int i) {
        aFR = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aFR |= i;
        }
        this.aFS++;
    }

    private boolean AH() {
        if (this.aFC == null) {
            return false;
        }
        return this.aFC.Be() ? this.aFS == 3 : this.aFS == 2;
    }

    private synchronized boolean AI() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aFR);
        i = (aFR ^ 1) ^ 2;
        if (this.aFC != null) {
            if (this.aFC.Be()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aFR);
        if (AJ() && this.aFY != null) {
            this.aFY.sendMessage(this.aFY.obtainMessage(7003, Boolean.valueOf(AK())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aFR ^= i;
        }
        this.aFS--;
    }

    private boolean AJ() {
        return this.aFS == 0;
    }

    private synchronized boolean AK() {
        return aFR == 0;
    }

    public void T(long j) {
        this.aFX *= TimeUtils.NANOS_PER_MS;
        if (this.aFB != null) {
            this.aFB.R(j);
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
                case 7001:
                    if (d.this.aFB != null) {
                        d.this.aFB.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aFV = false;
                    break;
                case 7002:
                    if (d.this.aFB != null) {
                        d.this.aFB.R(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aFB != null) {
                        if (d.this.aFC != null) {
                            str = d.this.aFC.AW();
                        } else {
                            str = null;
                        }
                        d.this.aFB.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aFB != null) {
                        d.this.aFB.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.Av();
                    break;
                case 7006:
                    d.this.aFV = false;
                    d.this.Ax();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
