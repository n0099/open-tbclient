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
    private static volatile int aJZ = 0;
    private static volatile boolean aKk = false;
    private static volatile d aKt;
    private e aJJ;
    private com.baidu.mario.a.b.d aJK;
    private HandlerThread aKc;
    private a aKg;
    private f aKh;
    private com.baidu.mario.a.b.e aKi;
    private com.baidu.mario.a.b.f aKj;
    private com.baidu.mario.a.a.a aKl;
    private com.baidu.mario.a.b.c aKm;
    private com.baidu.mario.a.a.b aKo;
    private com.baidu.mario.a.b.c aKp;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aKr;
    private int aKs;
    private Context mContext;
    private int aKa = 0;
    private boolean aKb = false;
    private volatile boolean aKd = false;
    private boolean aKe = false;
    private long aKf = 0;
    private volatile boolean aKn = false;
    private volatile boolean aKq = false;

    public static d CL() {
        if (aKt == null) {
            synchronized (d.class) {
                if (aKt == null) {
                    aKt = new d();
                }
            }
        }
        return aKt;
    }

    private d() {
    }

    public long CM() {
        if (this.aKo != null) {
            return this.aKo.CM();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.a.b.d dVar, e eVar) {
        Log.i(TAG, "startRecorder mStarting = " + this.aKd);
        if (this.aKd) {
            CQ();
            return;
        }
        this.aKd = true;
        this.mContext = context;
        this.aJK = dVar;
        this.aJJ = eVar;
        CN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        CR();
        CS();
        if (CT()) {
            CU();
            CV();
        } else if (!this.aKe) {
            CW();
        } else {
            CQ();
        }
    }

    public void W(long j) {
        if (this.aKo != null && this.aKo.isRunning() && this.aKq && aKk) {
            this.aKo.T(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aKn && this.aKl != null && this.aKl.isRunning()) {
            this.aKl.d(byteBuffer, i, j);
        }
    }

    public void CO() {
        if (this.aKo != null) {
            this.aKo.Di();
        }
    }

    public void CP() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aKd);
        if (this.aKd) {
            if (!Da() && this.aKg != null) {
                this.aKg.sendMessage(this.aKg.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aKg != null) {
                this.aKg.sendMessageDelayed(this.aKg.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aKn = false;
        this.aKq = false;
        this.aKf = 0L;
        if (this.aKl != null && this.aKl.isRunning()) {
            this.aKl.stopRecording();
        }
        if (this.aKo != null && this.aKo.isRunning()) {
            this.aKo.stopRecording();
        }
        bB(false);
    }

    public void onDestroy() {
        if (this.aKr != null) {
            this.aKr.clear();
            this.aKr = null;
        }
        this.aKh = null;
        this.mContext = null;
        this.aJK = null;
        de(0);
        releaseInstance();
        if (this.aKg != null) {
            this.aKg.removeCallbacksAndMessages(null);
            this.aKg = null;
        }
        if (this.aKc != null) {
            this.aKc.quit();
            this.aKc = null;
        }
    }

    private static void releaseInstance() {
        aKt = null;
    }

    private static void bB(boolean z) {
        aKk = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aKr == null) {
                this.aKr = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aKr.size()) {
                    break;
                }
                if (this.aKr.get(i3).CB() == cVar.CB()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aKr.size()) {
                if (this.aKr.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aKr.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aKr.add(cVar.clone());
            } else {
                this.aKr.add(cVar);
            }
            Collections.sort(this.aKr);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aKo != null) {
            a(cVar, z);
            this.aKo.l(this.aKr);
        }
    }

    private void CQ() {
        if (this.aKg != null) {
            this.aKg.sendMessageDelayed(this.aKg.obtainMessage(7001, false), 500L);
        }
    }

    private void CR() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aKi = new com.baidu.mario.a.b.e();
        }
        if (this.aJK.Dw()) {
            this.aKl = new com.baidu.mario.a.a.a();
        } else {
            aKk = true;
        }
        this.aKo = new com.baidu.mario.a.a.b();
        this.aKa = 0;
        if (!this.aKb && this.aKc == null) {
            this.aKc = new HandlerThread(TAG);
            this.aKc.start();
        }
        if (this.aKg == null) {
            if (this.aKc != null) {
                this.aKg = new a(this.aKc.getLooper());
            } else {
                this.aKg = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aKg.removeCallbacksAndMessages(null);
        }
        this.aKh = new f(this.aJK.Dq());
    }

    private void CS() {
        this.aKp = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.1
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKo.Dd();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKq = z;
                d.this.j(2, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKo.De();
                d.this.aKo = null;
                d.this.aKp = null;
                d.this.l(2, z);
            }
        };
        this.aKm = new com.baidu.mario.a.b.c() { // from class: com.baidu.mario.a.d.2
            @Override // com.baidu.mario.a.b.c
            public void bC(boolean z) {
                if (z) {
                    d.this.aKl.Dd();
                }
            }

            @Override // com.baidu.mario.a.b.c
            public void bD(boolean z) {
                d.this.aKn = z;
                d.this.j(4, z);
            }

            @Override // com.baidu.mario.a.b.c
            public void bE(boolean z) {
                boolean unused = d.aKk = z;
            }

            @Override // com.baidu.mario.a.b.c
            public void bF(boolean z) {
                d.this.aKl.De();
                d.this.aKl = null;
                d.this.aKm = null;
                d.this.l(4, z);
            }
        };
        this.aKj = new com.baidu.mario.a.b.f() { // from class: com.baidu.mario.a.d.3
            @Override // com.baidu.mario.a.b.f
            public void bG(boolean z) {
                d.this.j(1, z);
            }

            @Override // com.baidu.mario.a.b.f
            public void bH(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    d.this.aKi.DF();
                    d.this.aKi = null;
                }
                d.this.aKj = null;
                d.this.l(1, z);
            }
        };
    }

    private boolean CT() {
        boolean z = true;
        if (this.aKl != null && this.aKl.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aKl.stopRecording();
            this.aKl.De();
            z = false;
        }
        if (this.aKo != null && this.aKo.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aKo.stopRecording();
            this.aKo.De();
            z = false;
        }
        if (this.aJK != null && !this.aKi.a(this.aJK.Do(), this.aJK.Dp(), this.aKj)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void CU() {
        if (this.aKl != null) {
            this.aKl.a(this.aJK, this.aKi, this.aKm);
        }
    }

    private void CV() {
        CX();
        this.aKo.a(this.aKr, this.aJK, this.aKi, this.aKp);
    }

    private void CW() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aKe);
        if (this.aKg != null) {
            this.aKe = true;
            this.aKg.sendMessageDelayed(this.aKg.obtainMessage(7005), 500L);
        }
    }

    private void CX() {
        CY();
    }

    private void CY() {
        if (this.aKr != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aKr.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a Cx = it.next().Cx();
                if (Cx.Cj() == MirrorType.NO_MIRROR) {
                    Cx.dc(-this.aKs);
                } else {
                    Cx.dc(this.aKs);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aJZ);
        if (CZ()) {
            this.aKg.sendMessage(this.aKg.obtainMessage(7001, Boolean.valueOf(Da())));
        }
    }

    private static void de(int i) {
        aJZ = i;
    }

    private void k(int i, boolean z) {
        if (z) {
            aJZ |= i;
        }
        this.aKa++;
    }

    private boolean CZ() {
        if (this.aJK == null) {
            return false;
        }
        return this.aJK.Dw() ? this.aKa == 3 : this.aKa == 2;
    }

    private synchronized boolean Da() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aJZ);
        i = (aJZ ^ 1) ^ 2;
        if (this.aJK != null) {
            if (this.aJK.Dw()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        m(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aJZ);
        if (Db() && this.aKg != null) {
            this.aKg.sendMessage(this.aKg.obtainMessage(7003, Boolean.valueOf(Dc())));
        }
    }

    private void m(int i, boolean z) {
        if (z) {
            aJZ ^= i;
        }
        this.aKa--;
    }

    private boolean Db() {
        return this.aKa == 0;
    }

    private synchronized boolean Dc() {
        return aJZ == 0;
    }

    public void X(long j) {
        this.aKf *= TimeUtils.NANOS_PER_MS;
        if (this.aJJ != null) {
            this.aJJ.V(j);
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
                    if (d.this.aJJ != null) {
                        d.this.aJJ.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    d.this.aKd = false;
                    break;
                case 7002:
                    if (d.this.aJJ != null) {
                        d.this.aJJ.V(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (d.this.aJJ != null) {
                        if (d.this.aJK != null) {
                            str = d.this.aJK.Do();
                        } else {
                            str = null;
                        }
                        d.this.aJJ.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (d.this.aJJ != null) {
                        d.this.aJJ.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    d.this.CN();
                    break;
                case 7006:
                    d.this.aKd = false;
                    d.this.CP();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
