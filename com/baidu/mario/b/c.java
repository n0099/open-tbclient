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
    private static volatile c aeC;
    private d adZ;
    private ArrayList<com.baidu.mario.gldraw2d.params.c> aeA;
    private int aeB;
    private com.baidu.mario.b.b.d aea;
    private HandlerThread ael;
    private a aep;
    private e aeq;
    private com.baidu.mario.b.b.e aer;
    private f aes;
    private com.baidu.mario.b.a.a aeu;
    private com.baidu.mario.b.b.c aev;
    private com.baidu.mario.b.a.b aex;
    private com.baidu.mario.b.b.c aey;
    private Context mContext;
    private static final String TAG = c.class.getSimpleName();
    private static volatile int aei = 0;
    private static volatile boolean aet = false;
    private int aej = 0;
    private boolean aek = false;
    private volatile boolean aem = false;
    private boolean aen = false;
    private long aeo = 0;
    private volatile boolean aew = false;
    private volatile boolean aez = false;

    public static c tl() {
        if (aeC == null) {
            synchronized (c.class) {
                if (aeC == null) {
                    aeC = new c();
                }
            }
        }
        return aeC;
    }

    private c() {
    }

    public long tm() {
        if (this.aex != null) {
            return this.aex.tm();
        }
        return 0L;
    }

    public void a(Context context, com.baidu.mario.b.b.d dVar, d dVar2) {
        Log.i(TAG, "startRecorder mStarting = " + this.aem);
        if (this.aem) {
            tr();
            return;
        }
        this.aem = true;
        this.mContext = context;
        this.aea = dVar;
        this.adZ = dVar2;
        tn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tn() {
        ts();
        tt();
        if (tu()) {
            tv();
            tw();
        } else if (!this.aen) {
            tx();
        } else {
            tr();
        }
    }

    public void w(long j) {
        if (this.aex != null && this.aex.isRunning() && this.aez && aet) {
            this.aex.t(j);
        }
    }

    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.aew && this.aeu != null && this.aeu.isRunning()) {
            this.aeu.d(byteBuffer, i, j);
        }
    }

    public void tp() {
        if (this.aex != null) {
            this.aex.tK();
        }
    }

    public void tq() {
        Log.i(TAG, "stopRecorder mStarting = " + this.aem);
        if (this.aem) {
            if (!tB() && this.aep != null) {
                this.aep.sendMessage(this.aep.obtainMessage(7004, 4002));
            }
            Log.d(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.aep != null) {
                this.aep.sendMessageDelayed(this.aep.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.aew = false;
        this.aez = false;
        this.aeo = 0L;
        if (this.aeu != null && this.aeu.isRunning()) {
            this.aeu.stopRecording();
        }
        if (this.aex != null && this.aex.isRunning()) {
            this.aex.stopRecording();
        }
        aH(false);
    }

    public void onDestroy() {
        if (this.aeA != null) {
            this.aeA.clear();
            this.aeA = null;
        }
        this.aeq = null;
        this.mContext = null;
        this.aea = null;
        this.adZ = null;
        bC(0);
        releaseInstance();
        if (this.aep != null) {
            this.aep.removeCallbacksAndMessages(null);
            this.aep = null;
        }
        if (this.ael != null) {
            this.ael.quit();
            this.ael = null;
        }
    }

    private static void releaseInstance() {
        aeC = null;
    }

    private static void aH(boolean z) {
        aet = z;
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar) {
        a(cVar, true);
    }

    public void a(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (cVar != null && cVar.getEGLContext() != null) {
            if (this.aeA == null) {
                this.aeA = new ArrayList<>();
            }
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 >= this.aeA.size()) {
                    break;
                }
                if (this.aeA.get(i3).tc() == cVar.tc()) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (i2 >= 0 && i2 < this.aeA.size()) {
                if (this.aeA.get(i2).getEGLContext() != cVar.getEGLContext()) {
                    this.aeA.remove(i2);
                } else {
                    return;
                }
            }
            if (z) {
                this.aeA.add(cVar.clone());
            } else {
                this.aeA.add(cVar);
            }
            Collections.sort(this.aeA);
        }
    }

    public void c(com.baidu.mario.gldraw2d.params.c cVar) {
        b(cVar, true);
    }

    public void b(com.baidu.mario.gldraw2d.params.c cVar, boolean z) {
        if (this.aex != null) {
            a(cVar, z);
            this.aex.g(this.aeA);
        }
    }

    private void tr() {
        if (this.aep != null) {
            this.aep.sendMessageDelayed(this.aep.obtainMessage(7001, false), 500L);
        }
    }

    private void ts() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aer = new com.baidu.mario.b.b.e();
        }
        if (this.aea.tZ()) {
            this.aeu = new com.baidu.mario.b.a.a();
        } else {
            aet = true;
        }
        this.aex = new com.baidu.mario.b.a.b();
        this.aej = 0;
        if (!this.aek && this.ael == null) {
            this.ael = new HandlerThread(TAG);
            this.ael.start();
        }
        if (this.aep == null) {
            if (this.ael != null) {
                this.aep = new a(this.ael.getLooper());
            } else {
                this.aep = new a(this.mContext.getMainLooper());
            }
        } else {
            this.aep.removeCallbacksAndMessages(null);
        }
        this.aeq = new e(this.aea.tT());
    }

    private void tt() {
        this.aey = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.1
            @Override // com.baidu.mario.b.b.c
            public void aI(boolean z) {
                if (z) {
                    c.this.aex.tE();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void aJ(boolean z) {
                c.this.aez = z;
                c.this.h(2, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void aK(boolean z) {
            }

            @Override // com.baidu.mario.b.b.c
            public void aL(boolean z) {
                c.this.aex.tF();
                c.this.aex = null;
                c.this.aey = null;
                c.this.j(2, z);
            }
        };
        this.aev = new com.baidu.mario.b.b.c() { // from class: com.baidu.mario.b.c.2
            @Override // com.baidu.mario.b.b.c
            public void aI(boolean z) {
                if (z) {
                    c.this.aeu.tE();
                }
            }

            @Override // com.baidu.mario.b.b.c
            public void aJ(boolean z) {
                c.this.aew = z;
                c.this.h(4, z);
            }

            @Override // com.baidu.mario.b.b.c
            public void aK(boolean z) {
                boolean unused = c.aet = z;
            }

            @Override // com.baidu.mario.b.b.c
            public void aL(boolean z) {
                c.this.aeu.tF();
                c.this.aeu = null;
                c.this.aev = null;
                c.this.j(4, z);
            }
        };
        this.aes = new f() { // from class: com.baidu.mario.b.c.3
            @Override // com.baidu.mario.b.b.f
            public void aM(boolean z) {
                c.this.h(1, z);
            }

            @Override // com.baidu.mario.b.b.f
            public void aN(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    c.this.aer.ui();
                    c.this.aer = null;
                }
                c.this.aes = null;
                c.this.j(1, z);
            }
        };
    }

    private boolean tu() {
        boolean z = true;
        if (this.aeu != null && this.aeu.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.aeu.stopRecording();
            this.aeu.tF();
            z = false;
        }
        if (this.aex != null && this.aex.isRunning()) {
            Log.e(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.aex.stopRecording();
            this.aex.tF();
            z = false;
        }
        if (this.aea != null && !this.aer.a(this.aea.tR(), this.aea.tS(), this.aes)) {
            Log.e(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
            return false;
        }
        return z;
    }

    private void tv() {
        if (this.aeu != null) {
            this.aeu.a(this.aea, this.aer, this.aev);
        }
    }

    private void tw() {
        ty();
        this.aex.a(this.aeA, this.aea, this.aer, this.aey);
    }

    private void tx() {
        Log.i(TAG, "restartRecorder mRestartTried = " + this.aen);
        if (this.aep != null) {
            this.aen = true;
            this.aep.sendMessageDelayed(this.aep.obtainMessage(7005), 500L);
        }
    }

    private void ty() {
        tz();
    }

    private void tz() {
        if (this.aeA != null) {
            Iterator<com.baidu.mario.gldraw2d.params.c> it = this.aeA.iterator();
            while (it.hasNext()) {
                com.baidu.mario.gldraw2d.params.a sY = it.next().sY();
                if (sY.sK() == MirrorType.NO_MIRROR) {
                    sY.bA(-this.aeB);
                } else {
                    sY.bA(this.aeB);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        i(i, z);
        Log.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + aei);
        if (tA()) {
            this.aep.sendMessage(this.aep.obtainMessage(7001, Boolean.valueOf(tB())));
        }
    }

    private static void bC(int i) {
        aei = i;
    }

    private void i(int i, boolean z) {
        if (z) {
            aei |= i;
        }
        this.aej++;
    }

    private boolean tA() {
        if (this.aea == null) {
            return false;
        }
        return this.aea.tZ() ? this.aej == 3 : this.aej == 2;
    }

    private synchronized boolean tB() {
        int i;
        Log.i(TAG, "isMovieRecordStarted sMovieRecordState = " + aei);
        i = (aei ^ 1) ^ 2;
        if (this.aea != null) {
            if (this.aea.tZ()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(int i, boolean z) {
        Log.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        k(i, z);
        Log.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + aei);
        if (tC() && this.aep != null) {
            this.aep.sendMessage(this.aep.obtainMessage(7003, Boolean.valueOf(tD())));
        }
    }

    private void k(int i, boolean z) {
        if (z) {
            aei ^= i;
        }
        this.aej--;
    }

    private boolean tC() {
        return this.aej == 0;
    }

    private synchronized boolean tD() {
        return aei == 0;
    }

    public void x(long j) {
        this.aeo *= 1000000;
        if (this.adZ != null) {
            this.adZ.v(j);
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
                    if (c.this.adZ != null) {
                        c.this.adZ.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    c.this.aem = false;
                    break;
                case 7002:
                    if (c.this.adZ != null) {
                        c.this.adZ.v(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (c.this.adZ != null) {
                        if (c.this.aea != null) {
                            str = c.this.aea.tR();
                        } else {
                            str = null;
                        }
                        c.this.adZ.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                        break;
                    }
                    break;
                case 7004:
                    if (c.this.adZ != null) {
                        c.this.adZ.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    c.this.tn();
                    break;
                case 7006:
                    c.this.aem = false;
                    c.this.tq();
                    break;
            }
            super.handleMessage(message);
        }
    }
}
