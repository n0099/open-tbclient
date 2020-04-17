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
    private static volatile MovieRecorder sE;
    private Context mContext;
    private com.baidu.ar.recorder.a.b sB;
    private c sC;
    private EncoderParams se;
    private MovieRecorderCallback sf;
    private HandlerThread sq;
    private a st;
    private com.baidu.ar.recorder.a su;
    private d sv;
    private e sw;
    private com.baidu.ar.recorder.a.a sy;
    private c sz;
    private static final String TAG = MovieRecorder.class.getSimpleName();
    private static volatile int sn = 0;
    private static volatile boolean sx = false;
    private int so = 0;
    private boolean sp = false;
    private volatile boolean sr = false;
    private boolean ss = false;
    private volatile boolean sA = false;
    private volatile boolean sD = false;

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
                    if (MovieRecorder.this.sf != null) {
                        MovieRecorder.this.sf.onRecorderInit((Surface) message.obj);
                        break;
                    }
                    break;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (MovieRecorder.this.sf != null) {
                        MovieRecorder.this.sf.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.sr = false;
                    break;
                case 7002:
                    if (MovieRecorder.this.sf != null) {
                        MovieRecorder.this.sf.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (MovieRecorder.this.sf != null) {
                        MovieRecorder.this.sf.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.se != null ? MovieRecorder.this.se.getOutputFile() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (MovieRecorder.this.sf != null) {
                        MovieRecorder.this.sf.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    MovieRecorder.this.dT();
                    break;
                case 7006:
                    MovieRecorder.this.sr = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private static void E(int i) {
        sn = i;
    }

    private static void J(boolean z) {
        sx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, boolean z) {
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        d(i, z);
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + sn);
        if (eb()) {
            this.st.sendMessage(this.st.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(ec())));
        }
    }

    private void d(int i, boolean z) {
        if (z) {
            sn |= i;
        }
        this.so++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT() {
        dV();
        dW();
        if (dX()) {
            dY();
            dZ();
        } else if (this.ss) {
            dU();
        } else {
            ea();
        }
    }

    private void dU() {
        if (this.st != null) {
            this.st.sendMessageDelayed(this.st.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void dV() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sv = new d();
        }
        if (this.se.isAudioIncluded()) {
            this.sy = new com.baidu.ar.recorder.a.a();
        } else {
            sx = true;
        }
        this.sB = new com.baidu.ar.recorder.a.b();
        this.so = 0;
        if (!this.sp && this.sq == null) {
            this.sq = new HandlerThread(TAG);
            this.sq.start();
        }
        if (this.st != null) {
            this.st.removeCallbacksAndMessages(null);
        } else if (this.sq != null) {
            this.st = new a(this.sq.getLooper());
        } else {
            this.st = new a(this.mContext.getMainLooper());
        }
        this.su = new com.baidu.ar.recorder.a(this.se.getOutputTotalMs());
    }

    private void dW() {
        this.sC = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.1
            @Override // com.baidu.ar.recorder.b.c
            public void L(boolean z) {
                MovieRecorder.this.sD = z;
                MovieRecorder.this.c(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                if (MovieRecorder.this.sB != null) {
                    MovieRecorder.this.sB.eg();
                    MovieRecorder.this.sB = null;
                }
                MovieRecorder.this.sC = null;
                MovieRecorder.this.e(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    if (MovieRecorder.this.st != null) {
                        MovieRecorder.this.st.sendMessage(MovieRecorder.this.st.obtainMessage(7000, obj));
                    }
                    if (MovieRecorder.this.sB != null) {
                        MovieRecorder.this.sB.startRecording();
                    }
                }
            }
        };
        this.sz = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.2
            @Override // com.baidu.ar.recorder.b.c
            public void L(boolean z) {
                MovieRecorder.this.sA = z;
                MovieRecorder.this.c(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
                boolean unused = MovieRecorder.sx = z;
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                MovieRecorder.this.sy.eg();
                MovieRecorder.this.sy = null;
                MovieRecorder.this.sz = null;
                MovieRecorder.this.e(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    MovieRecorder.this.sy.startRecording();
                }
            }
        };
        this.sw = new e() { // from class: com.baidu.ar.recorder.MovieRecorder.3
            @Override // com.baidu.ar.recorder.b.e
            public void O(boolean z) {
                MovieRecorder.this.c(1, z);
            }

            @Override // com.baidu.ar.recorder.b.e
            public void P(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    MovieRecorder.this.sv.eu();
                    MovieRecorder.this.sv = null;
                }
                MovieRecorder.this.sw = null;
                MovieRecorder.this.e(1, z);
            }
        };
    }

    private boolean dX() {
        boolean z = true;
        if (this.sy != null && this.sy.isRunning()) {
            com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.sy.stopRecording();
            this.sy.eg();
            z = false;
        }
        if (this.sB != null && this.sB.isRunning()) {
            com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.sB.stopRecording();
            this.sB.eg();
            z = false;
        }
        if (this.se == null || this.sv.a(this.se.getOutputFile(), this.se.getOutputFormat(), this.sw)) {
            return z;
        }
        com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    private void dY() {
        if (this.sy != null) {
            this.sy.a(this.se, this.sv, this.sz);
        }
    }

    private void dZ() {
        this.sB.a(this.se, this.sv, this.sC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(int i, boolean z) {
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        f(i, z);
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + sn);
        if (ed() && this.st != null) {
            this.st.sendMessage(this.st.obtainMessage(7003, Boolean.valueOf(ee())));
        }
    }

    private void ea() {
        com.baidu.ar.f.b.i(TAG, "restartRecorder mRestartTried = " + this.ss);
        if (this.st != null) {
            this.ss = true;
            this.st.sendMessageDelayed(this.st.obtainMessage(7005), 500L);
        }
    }

    private boolean eb() {
        if (this.se == null) {
            return false;
        }
        return this.se.isAudioIncluded() ? this.so == 3 : this.so == 2;
    }

    private synchronized boolean ec() {
        int i;
        com.baidu.ar.f.b.i(TAG, "isMovieRecordStarted sMovieRecordState = " + sn);
        i = (sn ^ 1) ^ 2;
        if (this.se != null) {
            if (this.se.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    private boolean ed() {
        return this.so == 0;
    }

    private synchronized boolean ee() {
        return sn == 0;
    }

    private void f(int i, boolean z) {
        if (z) {
            sn ^= i;
        }
        this.so--;
    }

    public static MovieRecorder getInstance() {
        if (sE == null) {
            synchronized (MovieRecorder.class) {
                if (sE == null) {
                    sE = new MovieRecorder();
                }
            }
        }
        return sE;
    }

    private static void releaseInstance() {
        sE = null;
    }

    private void u(long j) {
        if (!this.su.ef()) {
            this.su.v(j);
            return;
        }
        int w = this.su.w(j);
        if (w <= 0 || this.st == null) {
            return;
        }
        this.st.sendMessage(this.st.obtainMessage(7002, Integer.valueOf(w)));
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.sA && this.sy != null && this.sy.isRunning()) {
            this.sy.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        this.su = null;
        this.mContext = null;
        this.se = null;
        this.sf = null;
        E(0);
        releaseInstance();
        if (this.st != null) {
            this.st.removeCallbacksAndMessages(null);
            this.st = null;
        }
        if (this.sq != null) {
            this.sq.quit();
            this.sq = null;
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        if (this.sB != null && this.sB.isRunning() && this.sD && sx) {
            this.sB.x(j);
            u(j / TimeUtils.NANOS_PER_MS);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        com.baidu.ar.f.b.i(TAG, "startRecorder mStarting = " + this.sr);
        if (this.sr) {
            dU();
            return;
        }
        this.sr = true;
        this.mContext = context;
        this.se = encoderParams;
        this.sf = movieRecorderCallback;
        dT();
    }

    @Override // com.baidu.ar.record.b
    public void stopRecorder() {
        com.baidu.ar.f.b.i(TAG, "stopRecorder mStarting = " + this.sr);
        if (this.sr) {
            if (!ec() && this.st != null) {
                this.st.sendMessage(this.st.obtainMessage(7004, Integer.valueOf((int) ERROR_CODE_ON_STOP)));
            }
            com.baidu.ar.f.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.st != null) {
                this.st.sendMessageDelayed(this.st.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.sA = false;
        this.sD = false;
        if (this.sy != null && this.sy.isRunning()) {
            this.sy.stopRecording();
        }
        if (this.sB != null && this.sB.isRunning()) {
            this.sB.stopRecording();
        }
        J(false);
    }
}
