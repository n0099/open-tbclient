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
/* loaded from: classes11.dex */
public class MovieRecorder implements b {
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    private static final String TAG = MovieRecorder.class.getSimpleName();
    private static volatile int sN = 0;
    private static volatile boolean sX = false;
    private static volatile MovieRecorder te;
    private Context mContext;
    private EncoderParams sE;
    private MovieRecorderCallback sF;
    private HandlerThread sQ;
    private a sT;
    private com.baidu.ar.recorder.a sU;
    private d sV;
    private e sW;
    private com.baidu.ar.recorder.a.a sY;
    private c sZ;
    private com.baidu.ar.recorder.a.b tb;
    private c tc;
    private int sO = 0;
    private boolean sP = false;
    private volatile boolean sR = false;
    private boolean sS = false;
    private volatile boolean ta = false;
    private volatile boolean td = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7000:
                    if (MovieRecorder.this.sF != null) {
                        MovieRecorder.this.sF.onRecorderInit((Surface) message.obj);
                        break;
                    }
                    break;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (MovieRecorder.this.sF != null) {
                        MovieRecorder.this.sF.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.sR = false;
                    break;
                case 7002:
                    if (MovieRecorder.this.sF != null) {
                        MovieRecorder.this.sF.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (MovieRecorder.this.sF != null) {
                        MovieRecorder.this.sF.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.sE != null ? MovieRecorder.this.sE.getOutputFile() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (MovieRecorder.this.sF != null) {
                        MovieRecorder.this.sF.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    MovieRecorder.this.ej();
                    break;
                case 7006:
                    MovieRecorder.this.sR = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private static void K(int i) {
        sN = i;
    }

    private static void K(boolean z) {
        sX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i, boolean z) {
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        e(i, z);
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStartState sMovieRecordState = " + sN);
        if (er()) {
            this.sT.sendMessage(this.sT.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(es())));
        }
    }

    private void e(int i, boolean z) {
        if (z) {
            sN |= i;
        }
        this.sO++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej() {
        el();
        em();
        if (en()) {
            eo();
            ep();
        } else if (this.sS) {
            ek();
        } else {
            eq();
        }
    }

    private void ek() {
        if (this.sT != null) {
            this.sT.sendMessageDelayed(this.sT.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void el() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.sV = new d();
        }
        if (this.sE.isAudioIncluded()) {
            this.sY = new com.baidu.ar.recorder.a.a();
        } else {
            sX = true;
        }
        this.tb = new com.baidu.ar.recorder.a.b();
        this.sO = 0;
        if (!this.sP && this.sQ == null) {
            this.sQ = new HandlerThread(TAG);
            this.sQ.start();
        }
        if (this.sT != null) {
            this.sT.removeCallbacksAndMessages(null);
        } else if (this.sQ != null) {
            this.sT = new a(this.sQ.getLooper());
        } else {
            this.sT = new a(this.mContext.getMainLooper());
        }
        this.sU = new com.baidu.ar.recorder.a(this.sE.getOutputTotalMs());
    }

    private void em() {
        this.tc = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.1
            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
                MovieRecorder.this.td = z;
                MovieRecorder.this.d(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
            }

            @Override // com.baidu.ar.recorder.b.c
            public void O(boolean z) {
                if (MovieRecorder.this.tb != null) {
                    MovieRecorder.this.tb.ew();
                    MovieRecorder.this.tb = null;
                }
                MovieRecorder.this.tc = null;
                MovieRecorder.this.f(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    if (MovieRecorder.this.sT != null) {
                        MovieRecorder.this.sT.sendMessage(MovieRecorder.this.sT.obtainMessage(7000, obj));
                    }
                    if (MovieRecorder.this.tb != null) {
                        MovieRecorder.this.tb.startRecording();
                    }
                }
            }
        };
        this.sZ = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.2
            @Override // com.baidu.ar.recorder.b.c
            public void M(boolean z) {
                MovieRecorder.this.ta = z;
                MovieRecorder.this.d(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                boolean unused = MovieRecorder.sX = z;
            }

            @Override // com.baidu.ar.recorder.b.c
            public void O(boolean z) {
                MovieRecorder.this.sY.ew();
                MovieRecorder.this.sY = null;
                MovieRecorder.this.sZ = null;
                MovieRecorder.this.f(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    MovieRecorder.this.sY.startRecording();
                }
            }
        };
        this.sW = new e() { // from class: com.baidu.ar.recorder.MovieRecorder.3
            @Override // com.baidu.ar.recorder.b.e
            public void P(boolean z) {
                MovieRecorder.this.d(1, z);
            }

            @Override // com.baidu.ar.recorder.b.e
            public void Q(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    MovieRecorder.this.sV.eK();
                    MovieRecorder.this.sV = null;
                }
                MovieRecorder.this.sW = null;
                MovieRecorder.this.f(1, z);
            }
        };
    }

    private boolean en() {
        boolean z = true;
        if (this.sY != null && this.sY.isRunning()) {
            com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.sY.stopRecording();
            this.sY.ew();
            z = false;
        }
        if (this.tb != null && this.tb.isRunning()) {
            com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.tb.stopRecording();
            this.tb.ew();
            z = false;
        }
        if (this.sE == null || this.sV.a(this.sE.getOutputFile(), this.sE.getOutputFormat(), this.sW)) {
            return z;
        }
        com.baidu.ar.f.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    private void eo() {
        if (this.sY != null) {
            this.sY.a(this.sE, this.sV, this.sZ);
        }
    }

    private void ep() {
        this.tb.a(this.sE, this.sV, this.tc);
    }

    private void eq() {
        com.baidu.ar.f.b.i(TAG, "restartRecorder mRestartTried = " + this.sS);
        if (this.sT != null) {
            this.sS = true;
            this.sT.sendMessageDelayed(this.sT.obtainMessage(7005), 500L);
        }
    }

    private boolean er() {
        if (this.sE == null) {
            return false;
        }
        return this.sE.isAudioIncluded() ? this.sO == 3 : this.sO == 2;
    }

    private synchronized boolean es() {
        int i;
        com.baidu.ar.f.b.i(TAG, "isMovieRecordStarted sMovieRecordState = " + sN);
        i = (sN ^ 1) ^ 2;
        if (this.sE != null) {
            if (this.sE.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    private boolean et() {
        return this.sO == 0;
    }

    private synchronized boolean eu() {
        return sN == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(int i, boolean z) {
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        g(i, z);
        com.baidu.ar.f.b.i(TAG, "checkMovieRecordStopState sMovieRecordState = " + sN);
        if (et() && this.sT != null) {
            this.sT.sendMessage(this.sT.obtainMessage(7003, Boolean.valueOf(eu())));
        }
    }

    private void g(int i, boolean z) {
        if (z) {
            sN ^= i;
        }
        this.sO--;
    }

    public static MovieRecorder getInstance() {
        if (te == null) {
            synchronized (MovieRecorder.class) {
                if (te == null) {
                    te = new MovieRecorder();
                }
            }
        }
        return te;
    }

    private static void releaseInstance() {
        te = null;
    }

    private void u(long j) {
        if (!this.sU.ev()) {
            this.sU.v(j);
            return;
        }
        int w = this.sU.w(j);
        if (w <= 0 || this.sT == null) {
            return;
        }
        this.sT.sendMessage(this.sT.obtainMessage(7002, Integer.valueOf(w)));
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.ta && this.sY != null && this.sY.isRunning()) {
            this.sY.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        this.sU = null;
        this.mContext = null;
        this.sE = null;
        this.sF = null;
        K(0);
        releaseInstance();
        if (this.sT != null) {
            this.sT.removeCallbacksAndMessages(null);
            this.sT = null;
        }
        if (this.sQ != null) {
            this.sQ.quit();
            this.sQ = null;
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        if (this.tb != null && this.tb.isRunning() && this.td && sX) {
            this.tb.x(j);
            u(j / TimeUtils.NANOS_PER_MS);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        com.baidu.ar.f.b.i(TAG, "startRecorder mStarting = " + this.sR);
        if (this.sR) {
            ek();
            return;
        }
        this.sR = true;
        this.mContext = context;
        this.sE = encoderParams;
        this.sF = movieRecorderCallback;
        ej();
    }

    @Override // com.baidu.ar.record.b
    public void stopRecorder() {
        com.baidu.ar.f.b.i(TAG, "stopRecorder mStarting = " + this.sR);
        if (this.sR) {
            if (!es() && this.sT != null) {
                this.sT.sendMessage(this.sT.obtainMessage(7004, Integer.valueOf((int) ERROR_CODE_ON_STOP)));
            }
            com.baidu.ar.f.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.sT != null) {
                this.sT.sendMessageDelayed(this.sT.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.ta = false;
        this.td = false;
        if (this.sY != null && this.sY.isRunning()) {
            this.sY.stopRecording();
        }
        if (this.tb != null && this.tb.isRunning()) {
            this.tb.stopRecording();
        }
        K(false);
    }
}
