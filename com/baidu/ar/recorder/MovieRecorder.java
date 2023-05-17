package com.baidu.ar.recorder;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.record.MovieRecorderCallback;
import com.baidu.ar.record.b;
import com.baidu.ar.recorder.b.c;
import com.baidu.ar.recorder.b.d;
import com.baidu.ar.recorder.b.e;
import com.baidu.tbadk.core.util.TbEnum;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class MovieRecorder implements b {
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    public static final String TAG = "MovieRecorder";
    public static volatile int uf;
    public static volatile boolean up;
    public static volatile MovieRecorder uw;
    public Context mContext;
    public EncoderParams tW;
    public MovieRecorderCallback tX;
    public HandlerThread ui;
    public a ul;
    public com.baidu.ar.recorder.a um;
    public d un;
    public e uo;
    public com.baidu.ar.recorder.a.a uq;
    public c ur;
    public com.baidu.ar.recorder.a.b ut;
    public c uu;
    public int ug = 0;
    public boolean uh = false;
    public volatile boolean uj = false;
    public boolean uk = false;
    public volatile boolean us = false;
    public volatile boolean uv = false;

    /* loaded from: classes.dex */
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
                case 7001:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.uj = false;
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG /* 7002 */:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.tW != null ? MovieRecorder.this.tW.getOutputFile() : null);
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                    if (MovieRecorder.this.tX != null) {
                        MovieRecorder.this.tX.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    MovieRecorder.this.fw();
                    break;
                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                    MovieRecorder.this.uj = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    public static void J(boolean z) {
        up = z;
    }

    public static void P(int i) {
        uf = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(int i, boolean z) {
        String str = TAG;
        com.baidu.ar.h.b.k(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        f(i, z);
        String str2 = TAG;
        com.baidu.ar.h.b.k(str2, "checkMovieRecordStartState sMovieRecordState = " + uf);
        if (fE()) {
            this.ul.sendMessage(this.ul.obtainMessage(7001, Boolean.valueOf(fF())));
        }
    }

    private void f(int i, boolean z) {
        if (z) {
            uf = i | uf;
        }
        this.ug++;
    }

    private boolean fA() {
        boolean z;
        com.baidu.ar.recorder.a.a aVar = this.uq;
        if (aVar == null || !aVar.isRunning()) {
            z = true;
        } else {
            com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.uq.stopRecording();
            this.uq.fJ();
            z = false;
        }
        com.baidu.ar.recorder.a.b bVar = this.ut;
        if (bVar != null && bVar.isRunning()) {
            com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.ut.stopRecording();
            this.ut.fJ();
            z = false;
        }
        EncoderParams encoderParams = this.tW;
        if (encoderParams == null || this.un.a(encoderParams.getOutputFile(), this.tW.getOutputFormat(), this.uo)) {
            return z;
        }
        com.baidu.ar.h.b.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    private void fB() {
        com.baidu.ar.recorder.a.a aVar = this.uq;
        if (aVar != null) {
            aVar.a(this.tW, this.un, this.ur);
        }
    }

    private void fC() {
        this.ut.a(this.tW, this.un, this.uu);
    }

    private void fD() {
        String str = TAG;
        com.baidu.ar.h.b.k(str, "restartRecorder mRestartTried = " + this.uk);
        a aVar = this.ul;
        if (aVar != null) {
            this.uk = true;
            aVar.sendMessageDelayed(aVar.obtainMessage(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL), 500L);
        }
    }

    private boolean fE() {
        EncoderParams encoderParams = this.tW;
        if (encoderParams == null) {
            return false;
        }
        if (encoderParams.isAudioIncluded()) {
            if (this.ug == 3) {
                return true;
            }
        } else if (this.ug == 2) {
            return true;
        }
        return false;
    }

    private synchronized boolean fF() {
        int i;
        String str = TAG;
        com.baidu.ar.h.b.k(str, "isMovieRecordStarted sMovieRecordState = " + uf);
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
        a aVar = this.ul;
        if (aVar != null) {
            aVar.sendMessageDelayed(aVar.obtainMessage(7001, Boolean.FALSE), 500L);
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
            HandlerThread handlerThread = new HandlerThread(TAG);
            this.ui = handlerThread;
            handlerThread.start();
        }
        a aVar = this.ul;
        if (aVar == null) {
            this.ul = this.ui != null ? new a(this.ui.getLooper()) : new a(this.mContext.getMainLooper());
        } else {
            aVar.removeCallbacksAndMessages(null);
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
        String str = TAG;
        com.baidu.ar.h.b.k(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        h(i, z);
        String str2 = TAG;
        com.baidu.ar.h.b.k(str2, "checkMovieRecordStopState sMovieRecordState = " + uf);
        if (fG() && this.ul != null) {
            this.ul.sendMessage(this.ul.obtainMessage(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE, Boolean.valueOf(fH())));
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
            uf = i ^ uf;
        }
        this.ug--;
    }

    public static void releaseInstance() {
        uw = null;
    }

    private void s(long j) {
        a aVar;
        if (!this.um.fI()) {
            this.um.t(j);
            return;
        }
        int u = this.um.u(j);
        if (u <= 0 || (aVar = this.ul) == null) {
            return;
        }
        aVar.sendMessage(aVar.obtainMessage(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG, Integer.valueOf(u)));
    }

    @Override // com.baidu.ar.record.b
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        com.baidu.ar.recorder.a.a aVar;
        if (this.us && (aVar = this.uq) != null && aVar.isRunning()) {
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
        a aVar = this.ul;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.ul = null;
        }
        HandlerThread handlerThread = this.ui;
        if (handlerThread != null) {
            handlerThread.quit();
            this.ui = null;
        }
    }

    @Override // com.baidu.ar.record.b
    public void onVideoFrameAvailable(long j) {
        com.baidu.ar.recorder.a.b bVar = this.ut;
        if (bVar != null && bVar.isRunning() && this.uv && up) {
            this.ut.v(j);
            s(j / 1000000);
        }
    }

    @Override // com.baidu.ar.record.b
    public void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback) {
        String str = TAG;
        com.baidu.ar.h.b.k(str, "startRecorder mStarting = " + this.uj);
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
        a aVar;
        String str = TAG;
        com.baidu.ar.h.b.k(str, "stopRecorder mStarting = " + this.uj);
        if (this.uj) {
            if (!fF() && (aVar = this.ul) != null) {
                aVar.sendMessage(aVar.obtainMessage(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE, 4002));
            }
            com.baidu.ar.h.b.c(TAG, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            a aVar2 = this.ul;
            if (aVar2 != null) {
                aVar2.sendMessageDelayed(aVar2.obtainMessage(TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL), 500L);
                return;
            }
            return;
        }
        this.us = false;
        this.uv = false;
        com.baidu.ar.recorder.a.a aVar3 = this.uq;
        if (aVar3 != null && aVar3.isRunning()) {
            this.uq.stopRecording();
        }
        com.baidu.ar.recorder.a.b bVar = this.ut;
        if (bVar != null && bVar.isRunning()) {
            this.ut.stopRecording();
        }
        J(false);
    }
}
