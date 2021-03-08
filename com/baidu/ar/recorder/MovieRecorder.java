package com.baidu.ar.recorder;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.record.MovieRecorderCallback;
import com.baidu.ar.record.b;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import com.baidu.ar.recorder.b.e;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class MovieRecorder implements b {
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    private static final String TAG = MovieRecorder.class.getSimpleName();
    private static volatile int uf = 0;
    private static volatile boolean up = false;
    private static volatile MovieRecorder uw;
    private Context mContext;
    private EncoderParams tW;
    private MovieRecorderCallback tX;
    private HandlerThread ui;
    private a ul;
    private com.baidu.ar.recorder.a um;
    private d un;
    private e uo;
    private com.baidu.ar.recorder.a.a uq;
    private c ur;
    private com.baidu.ar.recorder.a.b ut;
    private c uu;
    private int ug = 0;
    private boolean uh = false;
    private volatile boolean uj = false;
    private boolean uk = false;
    private volatile boolean us = false;
    private volatile boolean uv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7000:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderInit((Surface) message.obj);
                        break;
                    }
                    break;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.uj = false;
                    break;
                case 7002:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.tW != null ? MovieRecorder.this.tW.getOutputFile() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    MovieRecorder.this.fw();
                    break;
                case 7006:
                    MovieRecorder.this.uj = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private static void J(boolean z) {
        up = z;
    }

    private static void P(int i) {
        uf = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(int i, boolean z) {
        com.baidu.ar.h.b.k(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        f(i, z);
        com.baidu.ar.h.b.k(TAG, "checkMovieRecordStartState sMovieRecordState = " + uf);
        if (fE()) {
            this.ul.sendMessage(this.ul.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(fF())));
        }
    }

    private void f(int i, boolean z) {
        if (z) {
            uf |= i;
        }
        this.ug++;
    }

    private boolean fA() {
        boolean z = true;
        if (this.uq != null && this.uq.isRunning()) {
            com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.uq.stopRecording();
            this.uq.fJ();
            z = false;
        }
        if (this.ut != null && this.ut.isRunning()) {
            com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.ut.stopRecording();
            this.ut.fJ();
            z = false;
        }
        if (this.tW == null || this.un.a(this.tW.getOutputFile(), this.tW.getOutputFormat(), this.uo)) {
            return z;
        }
        com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    private void fB() {
        if (this.uq != null) {
            this.uq.a(this.tW, this.un, this.ur);
        }
    }

    private void fC() {
        this.ut.a(this.tW, this.un, this.uu);
    }

    private void fD() {
        com.baidu.ar.h.b.k(TAG, "restartRecorder mRestartTried = " + this.uk);
        if (this.ul != null) {
            this.uk = true;
            this.ul.sendMessageDelayed(this.ul.obtainMessage(7005), 500L);
        }
    }

    private boolean fE() {
        if (this.tW == null) {
            return false;
        }
        return this.tW.isAudioIncluded() ? this.ug == 3 : this.ug == 2;
    }

    private synchronized boolean fF() {
        int i;
        com.baidu.ar.h.b.k(TAG, "isMovieRecordStarted sMovieRecordState = " + uf);
        i = (uf ^ 1) ^ 2;
        if (this.tW != null) {
            if (this.tW.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    private boolean fG() {
        return this.ug == 0;
    }

    private synchronized boolean fH() {
        return uf == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        fy();
        fz();
        if (fA()) {
            fB();
            fC();
        } else if (this.uk) {
            fx();
        } else {
            fD();
        }
    }

    private void fx() {
        if (this.ul != null) {
            this.ul.sendMessageDelayed(this.ul.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void fy() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.un = new d();
        }
        if (this.tW.isAudioIncluded()) {
            this.uq = new com.baidu.ar.recorder.a.a();
        } else {
            up = true;
        }
        this.ut = new com.baidu.ar.recorder.a.b();
        this.ug = 0;
        if (!this.uh && this.ui == null) {
            this.ui = new HandlerThread(TAG);
            this.ui.start();
        }
        if (this.ul != null) {
            this.ul.removeCallbacksAndMessages(null);
        } else if (this.ui != null) {
            this.ul = new a(this.ui.getLooper());
        } else {
            this.ul = new a(this.mContext.getMainLooper());
        }
        this.um = new com.baidu.ar.recorder.a(this.tW.getOutputTotalMs());
    }

    private void fz() {
        this.uu = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.1
            @Override // com.baidu.ar.recorder.b.c
            public void L(boolean z) {
                MovieRecorder.this.uv = z;
                MovieRecorder.this.e(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                if (MovieRecorder.this.ut != null) {
                    MovieRecorder.this.ut.fJ();
                    MovieRecorder.this.ut = null;
                }
                MovieRecorder.this.uu = null;
                MovieRecorder.this.g(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    if (MovieRecorder.this.ul != null) {
                        MovieRecorder.this.ul.sendMessage(MovieRecorder.this.ul.obtainMessage(7000, obj));
                    }
                    if (MovieRecorder.this.ut != null) {
                        MovieRecorder.this.ut.startRecording();
                    }
                }
            }
        };
        this.ur = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.2
            @Override // com.baidu.ar.recorder.b.c
            public void L(boolean z) {
                MovieRecorder.this.us = z;
                MovieRecorder.this.e(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
                boolean unused = MovieRecorder.up = z;
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                MovieRecorder.this.uq.fJ();
                MovieRecorder.this.uq = null;
                MovieRecorder.this.ur = null;
                MovieRecorder.this.g(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    MovieRecorder.this.uq.startRecording();
                }
            }
        };
        this.uo = new e() { // from class: com.baidu.ar.recorder.MovieRecorder.3
            @Override // com.baidu.ar.recorder.b.e
            public void O(boolean z) {
                MovieRecorder.this.e(1, z);
            }

            @Override // com.baidu.ar.recorder.b.e
            public void P(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    MovieRecorder.this.un.fX();
                    MovieRecorder.this.un = null;
                }
                MovieRecorder.this.uo = null;
                MovieRecorder.this.g(1, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(int i, boolean z) {
        com.baidu.ar.h.b.k(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        h(i, z);
        com.baidu.ar.h.b.k(TAG, "checkMovieRecordStopState sMovieRecordState = " + uf);
        if (fG() && this.ul != null) {
            this.ul.sendMessage(this.ul.obtainMessage(7003, Boolean.valueOf(fH())));
        }
    }

    public static MovieRecorder getInstance() {
        if (uw == null) {
            synchronized (MovieRecorder.class) {
                if (uw == null) {
                    uw = new MovieRecorder();
                }
            }
        }
        return uw;
    }

    private void h(int i, boolean z) {
        if (z) {
            uf ^= i;
        }
        this.ug--;
    }

    private static void releaseInstance() {
        uw = null;
    }

    private void s(long j) {
        if (!this.um.fI()) {
            this.um.t(j);
            return;
        }
        int u = this.um.u(j);
        if (u <= 0 || this.ul == null) {
            return;
        }
        this.ul.sendMessage(this.ul.obtainMessage(7002, Integer.valueOf(u)));
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.us && this.uq != null && this.uq.isRunning()) {
            this.uq.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        this.um = null;
        this.mContext = null;
        this.tW = null;
        this.tX = null;
        P(0);
        releaseInstance();
        if (this.ul != null) {
            this.ul.removeCallbacksAndMessages(null);
            this.ul = null;
        }
        if (this.ui != null) {
            this.ui.quit();
            this.ui = null;
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        if (this.ut != null && this.ut.isRunning() && this.uv && up) {
            this.ut.v(j);
            s(j / TimeUtils.NANOS_PER_MS);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        com.baidu.ar.h.b.k(TAG, "startRecorder mStarting = " + this.uj);
        if (this.uj) {
            fx();
            return;
        }
        this.uj = true;
        this.mContext = context;
        this.tW = encoderParams;
        this.tX = movieRecorderCallback;
        fw();
    }

    @Override // com.baidu.ar.record.b
    public void stopRecorder() {
        com.baidu.ar.h.b.k(TAG, "stopRecorder mStarting = " + this.uj);
        if (this.uj) {
            if (!fF() && this.ul != null) {
                this.ul.sendMessage(this.ul.obtainMessage(7004, 4002));
            }
            com.baidu.ar.h.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.ul != null) {
                this.ul.sendMessageDelayed(this.ul.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.us = false;
        this.uv = false;
        if (this.uq != null && this.uq.isRunning()) {
            this.uq.stopRecording();
        }
        if (this.ut != null && this.ut.isRunning()) {
            this.ut.stopRecording();
        }
        J(false);
    }
}
