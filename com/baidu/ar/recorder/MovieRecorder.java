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
import com.baidu.platform.comapi.map.NodeType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class MovieRecorder implements b {
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    private static volatile MovieRecorder tJ;
    private Context mContext;
    private d tA;
    private e tB;
    private com.baidu.ar.recorder.a.a tD;
    private c tE;
    private com.baidu.ar.recorder.a.b tG;
    private c tH;
    private EncoderParams tj;
    private MovieRecorderCallback tk;

    /* renamed from: tv  reason: collision with root package name */
    private HandlerThread f1241tv;
    private a ty;
    private com.baidu.ar.recorder.a tz;
    private static final String TAG = MovieRecorder.class.getSimpleName();
    private static volatile int ts = 0;
    private static volatile boolean tC = false;
    private int tt = 0;
    private boolean tu = false;
    private volatile boolean tw = false;
    private boolean tx = false;
    private volatile boolean tF = false;
    private volatile boolean tI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case NodeType.E_PARTICLE /* 7000 */:
                    if (MovieRecorder.this.tk != null) {
                        MovieRecorder.this.tk.onRecorderInit((Surface) message.obj);
                        break;
                    }
                    break;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (MovieRecorder.this.tk != null) {
                        MovieRecorder.this.tk.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.tw = false;
                    break;
                case 7002:
                    if (MovieRecorder.this.tk != null) {
                        MovieRecorder.this.tk.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (MovieRecorder.this.tk != null) {
                        MovieRecorder.this.tk.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.tj != null ? MovieRecorder.this.tj.getOutputFile() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (MovieRecorder.this.tk != null) {
                        MovieRecorder.this.tk.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    MovieRecorder.this.fv();
                    break;
                case 7006:
                    MovieRecorder.this.tw = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private static void L(boolean z) {
        tC = z;
    }

    private static void M(int i) {
        ts = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(int i, boolean z) {
        com.baidu.ar.g.b.k(TAG, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        f(i, z);
        com.baidu.ar.g.b.k(TAG, "checkMovieRecordStartState sMovieRecordState = " + ts);
        if (fD()) {
            this.ty.sendMessage(this.ty.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(fE())));
        }
    }

    private void f(int i, boolean z) {
        if (z) {
            ts |= i;
        }
        this.tt++;
    }

    private void fA() {
        if (this.tD != null) {
            this.tD.a(this.tj, this.tA, this.tE);
        }
    }

    private void fB() {
        this.tG.a(this.tj, this.tA, this.tH);
    }

    private void fC() {
        com.baidu.ar.g.b.k(TAG, "restartRecorder mRestartTried = " + this.tx);
        if (this.ty != null) {
            this.tx = true;
            this.ty.sendMessageDelayed(this.ty.obtainMessage(7005), 500L);
        }
    }

    private boolean fD() {
        if (this.tj == null) {
            return false;
        }
        return this.tj.isAudioIncluded() ? this.tt == 3 : this.tt == 2;
    }

    private synchronized boolean fE() {
        int i;
        com.baidu.ar.g.b.k(TAG, "isMovieRecordStarted sMovieRecordState = " + ts);
        i = (ts ^ 1) ^ 2;
        if (this.tj != null) {
            if (this.tj.isAudioIncluded()) {
                i ^= 4;
            }
        }
        return i == 0;
    }

    private boolean fF() {
        return this.tt == 0;
    }

    private synchronized boolean fG() {
        return ts == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv() {
        fx();
        fy();
        if (fz()) {
            fA();
            fB();
        } else if (this.tx) {
            fw();
        } else {
            fC();
        }
    }

    private void fw() {
        if (this.ty != null) {
            this.ty.sendMessageDelayed(this.ty.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, false), 500L);
        }
    }

    private void fx() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.tA = new d();
        }
        if (this.tj.isAudioIncluded()) {
            this.tD = new com.baidu.ar.recorder.a.a();
        } else {
            tC = true;
        }
        this.tG = new com.baidu.ar.recorder.a.b();
        this.tt = 0;
        if (!this.tu && this.f1241tv == null) {
            this.f1241tv = new HandlerThread(TAG);
            this.f1241tv.start();
        }
        if (this.ty != null) {
            this.ty.removeCallbacksAndMessages(null);
        } else if (this.f1241tv != null) {
            this.ty = new a(this.f1241tv.getLooper());
        } else {
            this.ty = new a(this.mContext.getMainLooper());
        }
        this.tz = new com.baidu.ar.recorder.a(this.tj.getOutputTotalMs());
    }

    private void fy() {
        this.tH = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.1
            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                MovieRecorder.this.tI = z;
                MovieRecorder.this.e(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void O(boolean z) {
            }

            @Override // com.baidu.ar.recorder.b.c
            public void P(boolean z) {
                if (MovieRecorder.this.tG != null) {
                    MovieRecorder.this.tG.fI();
                    MovieRecorder.this.tG = null;
                }
                MovieRecorder.this.tH = null;
                MovieRecorder.this.g(2, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    if (MovieRecorder.this.ty != null) {
                        MovieRecorder.this.ty.sendMessage(MovieRecorder.this.ty.obtainMessage(NodeType.E_PARTICLE, obj));
                    }
                    if (MovieRecorder.this.tG != null) {
                        MovieRecorder.this.tG.startRecording();
                    }
                }
            }
        };
        this.tE = new c() { // from class: com.baidu.ar.recorder.MovieRecorder.2
            @Override // com.baidu.ar.recorder.b.c
            public void N(boolean z) {
                MovieRecorder.this.tF = z;
                MovieRecorder.this.e(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void O(boolean z) {
                boolean unused = MovieRecorder.tC = z;
            }

            @Override // com.baidu.ar.recorder.b.c
            public void P(boolean z) {
                MovieRecorder.this.tD.fI();
                MovieRecorder.this.tD = null;
                MovieRecorder.this.tE = null;
                MovieRecorder.this.g(4, z);
            }

            @Override // com.baidu.ar.recorder.b.c
            public void a(boolean z, Object obj) {
                if (z) {
                    MovieRecorder.this.tD.startRecording();
                }
            }
        };
        this.tB = new e() { // from class: com.baidu.ar.recorder.MovieRecorder.3
            @Override // com.baidu.ar.recorder.b.e
            public void Q(boolean z) {
                MovieRecorder.this.e(1, z);
            }

            @Override // com.baidu.ar.recorder.b.e
            public void R(boolean z) {
                if (Build.VERSION.SDK_INT >= 18) {
                    MovieRecorder.this.tA.fW();
                    MovieRecorder.this.tA = null;
                }
                MovieRecorder.this.tB = null;
                MovieRecorder.this.g(1, z);
            }
        };
    }

    private boolean fz() {
        boolean z = true;
        if (this.tD != null && this.tD.isRunning()) {
            com.baidu.ar.g.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.tD.stopRecording();
            this.tD.fI();
            z = false;
        }
        if (this.tG != null && this.tG.isRunning()) {
            com.baidu.ar.g.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.tG.stopRecording();
            this.tG.fI();
            z = false;
        }
        if (this.tj == null || this.tA.a(this.tj.getOutputFile(), this.tj.getOutputFormat(), this.tB)) {
            return z;
        }
        com.baidu.ar.g.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(int i, boolean z) {
        com.baidu.ar.g.b.k(TAG, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        h(i, z);
        com.baidu.ar.g.b.k(TAG, "checkMovieRecordStopState sMovieRecordState = " + ts);
        if (fF() && this.ty != null) {
            this.ty.sendMessage(this.ty.obtainMessage(7003, Boolean.valueOf(fG())));
        }
    }

    public static MovieRecorder getInstance() {
        if (tJ == null) {
            synchronized (MovieRecorder.class) {
                if (tJ == null) {
                    tJ = new MovieRecorder();
                }
            }
        }
        return tJ;
    }

    private void h(int i, boolean z) {
        if (z) {
            ts ^= i;
        }
        this.tt--;
    }

    private static void releaseInstance() {
        tJ = null;
    }

    private void u(long j) {
        if (!this.tz.fH()) {
            this.tz.v(j);
            return;
        }
        int w = this.tz.w(j);
        if (w <= 0 || this.ty == null) {
            return;
        }
        this.ty.sendMessage(this.ty.obtainMessage(7002, Integer.valueOf(w)));
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        if (this.tF && this.tD != null && this.tD.isRunning()) {
            this.tD.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        this.tz = null;
        this.mContext = null;
        this.tj = null;
        this.tk = null;
        M(0);
        releaseInstance();
        if (this.ty != null) {
            this.ty.removeCallbacksAndMessages(null);
            this.ty = null;
        }
        if (this.f1241tv != null) {
            this.f1241tv.quit();
            this.f1241tv = null;
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        if (this.tG != null && this.tG.isRunning() && this.tI && tC) {
            this.tG.x(j);
            u(j / TimeUtils.NANOS_PER_MS);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        com.baidu.ar.g.b.k(TAG, "startRecorder mStarting = " + this.tw);
        if (this.tw) {
            fw();
            return;
        }
        this.tw = true;
        this.mContext = context;
        this.tj = encoderParams;
        this.tk = movieRecorderCallback;
        fv();
    }

    @Override // com.baidu.ar.record.b
    public void stopRecorder() {
        com.baidu.ar.g.b.k(TAG, "stopRecorder mStarting = " + this.tw);
        if (this.tw) {
            if (!fE() && this.ty != null) {
                this.ty.sendMessage(this.ty.obtainMessage(7004, Integer.valueOf((int) ERROR_CODE_ON_STOP)));
            }
            com.baidu.ar.g.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            if (this.ty != null) {
                this.ty.sendMessageDelayed(this.ty.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.tF = false;
        this.tI = false;
        if (this.tD != null && this.tD.isRunning()) {
            this.tD.stopRecording();
        }
        if (this.tG != null && this.tG.isRunning()) {
            this.tG.stopRecording();
        }
        L(false);
    }
}
