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
    private static volatile int aJY = 0;
    private static volatile boolean aKj = false;
    private static volatile d aKs;
    private e aJI;
    private com.baidu.mario.a.b.d aJJ;
    private HandlerThread aKb;
    private a aKf;
    private f aKg;
    private com.baidu.mario.a.b.e aKh;
    private com.baidu.mario.a.b.f aKi;
    private com.baidu.mario.a.a.a aKk;
    private com.baidu.mario.a.b.c aKl;
    private com.baidu.mario.a.a.b aKn;
    private com.baidu.mario.a.b.c aKo;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aKq;
    private int aKr;
    private Context mContext;
    private int aJZ = 0;
    private boolean aKa = false;
    private volatile boolean aKc = false;
    private boolean aKd = false;
    private long aKe = 0;
    private volatile boolean aKm = false;
    private volatile boolean aKp = false;

    public static d CL() {
        if (aKs == null) {
            synchronized (d.class) {
                if (aKs == null) {
                    aKs = new d();
                }
            }
        }
        return aKs;
    }

    private d() {
    }

    public long CM() {
        if (this.aKn != null) {
            return this.aKn.CM();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aKc);
        if (this.aKc) {
            CQ();
            return;
        }
        this.aKc = true;
        this.mContext = context;
        this.aJJ = dVar;
        this.aJI = eVar;
        CN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        CR();
        CS();
        if (CT()) {
            CU();
            CV();
        } else if (!this.aKd) {
            CW();
        } else {
            CQ();
        }
    }

    public void W(long j) {
        if (this.aKn != null && this.aKn.isRunning() && this.aKp && aKj) {
            this.aKn.T(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aKm && this.aKk != null && this.aKk.isRunning()) {
            this.aKk.d(byteBuffer, i, j);
        }
    }

    public void CO() {
        if (this.aKn != null) {
            this.aKn.Di();
        }
    }

    public void CP() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aKc);
        if (this.aKc) {
            if (!Da() && this.aKf != null) {
                this.aKf.sendMessage(this.aKf.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aKf != null) {
                this.aKf.sendMessageDelayed(this.aKf.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aKm = false;
        this.aKp = false;
        this.aKe = 0L;
        if (this.aKk != null && this.aKk.isRunning()) {
            this.aKk.stopRecording();
        }
        if (this.aKn != null && this.aKn.isRunning()) {
            this.aKn.stopRecording();
        }
        bB(false);
    }

    public void onDestroy() {
        if (this.aKq != null) {
            this.aKq.clear();
            this.aKq = null;
        }
        this.aKg = null;
        this.mContext = null;
        this.aJJ = null;
        de(0);
        releaseInstance();
        if (this.aKf != null) {
            this.aKf.removeCallbacksAndMessages(null);
            this.aKf = null;
        }
        if (this.aKb != null) {
            this.aKb.quit();
            this.aKb = null;
        }
    }

    private static void releaseInstance() {
        aKs = null;
    }

    private static void bB(boolean z) {
        aKj = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aKq == null) {
                this.aKq = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aKq.size()) {
                    break;
                }
                if (this.aKq.get(i3).CB() == cVar.CB()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aKq.size()) {
                if (this.aKq.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aKq.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aKq.add(cVar.clone());
            } else {
                this.aKq.add(cVar);
            }
            Collections.sort(this.aKq);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aKn != null) {
            a(cVar, z);
            this.aKn.l(this.aKq);
        }
    }

    private void CQ() {
        if (this.aKf != null) {
            this.aKf.sendMessageDelayed(this.aKf.obtainMessage(7001, false), 500L);
        }
    }

    private void CR() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKh = new com.baidu.mario.a.b.e();
        }
        if (this.aJJ.Dw()) {
            this.aKk = new com.baidu.mario.a.a.a();
        } else {
            aKj = true;
        }
        this.aKn = new com.baidu.mario.a.a.b();
        this.aJZ = 0;
        if (!this.aKa && this.aKb == null) {
            this.aKb = new HandlerThread(TAG);
            this.aKb.start();
        }
        if (this.aKf == null) {
            if (this.aKb != null) {
                this.aKf = new a(this.aKb.getLooper());
            } else {
                this.aKf = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aKf.removeCallbacksAndMessages(null);
        }
        this.aKg = new f(this.aJJ.Dq());
    }

    private void CS() {
        this.aKo = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKn.Dd();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKp = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKn.De();
                d.this.aKn = null;
                d.this.aKo = null;
                d.this.l(2, z);
            }
        };
        this.aKl = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKk.Dd();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKm = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
                boolean unused = d.aKj = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKk.De();
                d.this.aKk = null;
                d.this.aKl = null;
                d.this.l(4, z);
            }
        };
        this.aKi = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void bG(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bH(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aKh.DF();
                    d.this.aKh = null;
                }
                d.this.aKi = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean CT() {
        boolean z = true;
        if (this.aKk != null && this.aKk.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aKk.stopRecording();
            this.aKk.De();
            z = false;
        }
        if (this.aKn != null && this.aKn.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aKn.stopRecording();
            this.aKn.De();
            z = false;
        }
        if (this.aJJ != null && !this.aKh.a(this.aJJ.Do(), this.aJJ.Dp(), this.aKi)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void CU() {
        if (this.aKk != null) {
            this.aKk.a(this.aJJ, this.aKh, this.aKl);
        }
    }

    private void CV() {
        CX();
        this.aKn.a(this.aKq, this.aJJ, this.aKh, this.aKo);
    }

    private void CW() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aKd);
        if (this.aKf != null) {
            this.aKd = true;
            this.aKf.sendMessageDelayed(this.aKf.obtainMessage(7005), 500L);
        }
    }

    private void CX() {
        CY();
    }

    private void CY() {
        if (this.aKq != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aKq.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Cx = it.next().Cx();
                if (Cx.Cj() == MirrorType.NO_MIRROR) {
                    Cx.dc(-this.aKr);
                } else {
                    Cx.dc(this.aKr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aJY);
        if (CZ()) {
            this.aKf.sendMessage(this.aKf.obtainMessage(7001, Boolean.valueOf(Da())));
        }
    }

    private static void de(int i) {
        aJY = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aJY |= i;
        }
        this.aJZ++;
    }

    private boolean CZ() {
        if (this.aJJ == null) {
            return false;
        }
        return this.aJJ.Dw() ? this.aJZ == 3 : this.aJZ == 2;
    }

    private synchronized boolean Da() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aJY);
        i = (aJY ^ 1) ^ 2;
        if (this.aJJ != null) {
            if (this.aJJ.Dw()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aJY);
        if (Db() && this.aKf != null) {
            this.aKf.sendMessage(this.aKf.obtainMessage(7003, Boolean.valueOf(Dc())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aJY ^= i;
        }
        this.aJZ--;
    }

    private boolean Db() {
        return this.aJZ == 0;
    }

    private synchronized boolean Dc() {
        return aJY == 0;
    }

    public void X(long j) {
        this.aKe *= TimeUtils.NANOS_PER_MS;
        if (this.aJI != null) {
            this.aJI.V(j);
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
                    if (d.this.aJI != null) {
                        d.this.aJI.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aKc = false;
                    break;
                case 7002:
                    if (d.this.aJI != null) {
                        d.this.aJI.V(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aJI != null) {
                        if (d.this.aJJ != null) {
                            str = d.this.aJJ.Do();
                        } else {
                            str = null;
                        }
                        d.this.aJI.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aJI != null) {
                        d.this.aJI.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.CN();
                    break;
                case 7006:
                    d.this.aKc = false;
                    d.this.CP();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
