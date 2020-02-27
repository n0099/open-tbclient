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
    private static final String TAG = d.class.getSimpleName();
    private static volatile int aJX = 0;
    private static volatile boolean aKi = false;
    private static volatile d aKr;
    private e aJH;
    private com.baidu.mario.a.b.d aJI;
    private HandlerThread aKa;
    private a aKe;
    private f aKf;
    private com.baidu.mario.a.b.e aKg;
    private com.baidu.mario.a.b.f aKh;
    private com.baidu.mario.a.a.a aKj;
    private com.baidu.mario.a.b.c aKk;
    private com.baidu.mario.a.a.b aKm;
    private com.baidu.mario.a.b.c aKn;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aKp;
    private int aKq;
    private Context mContext;
    private int aJY = 0;
    private boolean aJZ = false;
    private volatile boolean aKb = false;
    private boolean aKc = false;
    private long aKd = 0;
    private volatile boolean aKl = false;
    private volatile boolean aKo = false;

    public static d CJ() {
        if (aKr == null) {
            synchronized (d.class) {
                if (aKr == null) {
                    aKr = new d();
                }
            }
        }
        return aKr;
    }

    private d() {
    }

    public long CK() {
        if (this.aKm != null) {
            return this.aKm.CK();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aKb);
        if (this.aKb) {
            CO();
            return;
        }
        this.aKb = true;
        this.mContext = context;
        this.aJI = dVar;
        this.aJH = eVar;
        CL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL() {
        CP();
        CQ();
        if (CR()) {
            CS();
            CT();
        } else if (!this.aKc) {
            CU();
        } else {
            CO();
        }
    }

    public void W(long j) {
        if (this.aKm != null && this.aKm.isRunning() && this.aKo && aKi) {
            this.aKm.T(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aKl && this.aKj != null && this.aKj.isRunning()) {
            this.aKj.d(byteBuffer, i, j);
        }
    }

    public void CM() {
        if (this.aKm != null) {
            this.aKm.Dg();
        }
    }

    public void CN() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aKb);
        if (this.aKb) {
            if (!CY() && this.aKe != null) {
                this.aKe.sendMessage(this.aKe.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aKe != null) {
                this.aKe.sendMessageDelayed(this.aKe.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aKl = false;
        this.aKo = false;
        this.aKd = 0L;
        if (this.aKj != null && this.aKj.isRunning()) {
            this.aKj.stopRecording();
        }
        if (this.aKm != null && this.aKm.isRunning()) {
            this.aKm.stopRecording();
        }
        bB(false);
    }

    public void onDestroy() {
        if (this.aKp != null) {
            this.aKp.clear();
            this.aKp = null;
        }
        this.aKf = null;
        this.mContext = null;
        this.aJI = null;
        de(0);
        releaseInstance();
        if (this.aKe != null) {
            this.aKe.removeCallbacksAndMessages(null);
            this.aKe = null;
        }
        if (this.aKa != null) {
            this.aKa.quit();
            this.aKa = null;
        }
    }

    private static void releaseInstance() {
        aKr = null;
    }

    private static void bB(boolean z) {
        aKi = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aKp == null) {
                this.aKp = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aKp.size()) {
                    break;
                }
                if (this.aKp.get(i3).Cz() == cVar.Cz()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aKp.size()) {
                if (this.aKp.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aKp.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aKp.add(cVar.clone());
            } else {
                this.aKp.add(cVar);
            }
            Collections.sort(this.aKp);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aKm != null) {
            a(cVar, z);
            this.aKm.l(this.aKp);
        }
    }

    private void CO() {
        if (this.aKe != null) {
            this.aKe.sendMessageDelayed(this.aKe.obtainMessage(7001, false), 500L);
        }
    }

    private void CP() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKg = new com.baidu.mario.a.b.e();
        }
        if (this.aJI.Du()) {
            this.aKj = new com.baidu.mario.a.a.a();
        } else {
            aKi = true;
        }
        this.aKm = new com.baidu.mario.a.a.b();
        this.aJY = 0;
        if (!this.aJZ && this.aKa == null) {
            this.aKa = new HandlerThread(TAG);
            this.aKa.start();
        }
        if (this.aKe == null) {
            if (this.aKa != null) {
                this.aKe = new a(this.aKa.getLooper());
            } else {
                this.aKe = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aKe.removeCallbacksAndMessages(null);
        }
        this.aKf = new f(this.aJI.Do());
    }

    private void CQ() {
        this.aKn = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKm.Db();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKo = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKm.Dc();
                d.this.aKm = null;
                d.this.aKn = null;
                d.this.l(2, z);
            }
        };
        this.aKk = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKj.Db();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKl = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
                boolean unused = d.aKi = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKj.Dc();
                d.this.aKj = null;
                d.this.aKk = null;
                d.this.l(4, z);
            }
        };
        this.aKh = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void bG(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bH(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aKg.DD();
                    d.this.aKg = null;
                }
                d.this.aKh = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean CR() {
        boolean z = true;
        if (this.aKj != null && this.aKj.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aKj.stopRecording();
            this.aKj.Dc();
            z = false;
        }
        if (this.aKm != null && this.aKm.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aKm.stopRecording();
            this.aKm.Dc();
            z = false;
        }
        if (this.aJI != null && !this.aKg.a(this.aJI.Dm(), this.aJI.Dn(), this.aKh)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void CS() {
        if (this.aKj != null) {
            this.aKj.a(this.aJI, this.aKg, this.aKk);
        }
    }

    private void CT() {
        CV();
        this.aKm.a(this.aKp, this.aJI, this.aKg, this.aKn);
    }

    private void CU() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aKc);
        if (this.aKe != null) {
            this.aKc = true;
            this.aKe.sendMessageDelayed(this.aKe.obtainMessage(7005), 500L);
        }
    }

    private void CV() {
        CW();
    }

    private void CW() {
        if (this.aKp != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aKp.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Cv = it.next().Cv();
                if (Cv.Ch() == MirrorType.NO_MIRROR) {
                    Cv.dc(-this.aKq);
                } else {
                    Cv.dc(this.aKq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aJX);
        if (CX()) {
            this.aKe.sendMessage(this.aKe.obtainMessage(7001, Boolean.valueOf(CY())));
        }
    }

    private static void de(int i) {
        aJX = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aJX |= i;
        }
        this.aJY++;
    }

    private boolean CX() {
        if (this.aJI == null) {
            return false;
        }
        return this.aJI.Du() ? this.aJY == 3 : this.aJY == 2;
    }

    private synchronized boolean CY() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aJX);
        i = (aJX ^ 1) ^ 2;
        if (this.aJI != null) {
            if (this.aJI.Du()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aJX);
        if (CZ() && this.aKe != null) {
            this.aKe.sendMessage(this.aKe.obtainMessage(7003, Boolean.valueOf(Da())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aJX ^= i;
        }
        this.aJY--;
    }

    private boolean CZ() {
        return this.aJY == 0;
    }

    private synchronized boolean Da() {
        return aJX == 0;
    }

    public void X(long j) {
        this.aKd *= TimeUtils.NANOS_PER_MS;
        if (this.aJH != null) {
            this.aJH.V(j);
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
                    if (d.this.aJH != null) {
                        d.this.aJH.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aKb = false;
                    break;
                case 7002:
                    if (d.this.aJH != null) {
                        d.this.aJH.V(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aJH != null) {
                        if (d.this.aJI != null) {
                            str = d.this.aJI.Dm();
                        } else {
                            str = null;
                        }
                        d.this.aJH.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aJH != null) {
                        d.this.aJH.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.CL();
                    break;
                case 7006:
                    d.this.aKb = false;
                    d.this.CN();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
