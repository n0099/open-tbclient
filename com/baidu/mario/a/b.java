package com.baidu.mario.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long aJS;
    private long aJT;
    private long aJU;
    private com.baidu.mario.a.b.d aJY;
    private boolean aJZ;
    private com.baidu.mario.gldraw2d.params.c aJu;
    private c aKa;
    private AudioParams aKc;
    private com.baidu.mario.audio.a.a aKd;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aJQ = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean aJR = false;
    private boolean aJV = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aKe = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aKf = ByteBuffer.allocate(3840).put(this.aKe);
    private Timer aKg = null;
    private TimerTask aKh = null;
    private boolean aKi = false;
    private boolean aKj = false;
    private long aKk = 0;
    private d aJW = d.CS();
    private com.baidu.mario.a.a aKb = null;
    private e aJX = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aKa != null) {
                b.this.aKa.onStart();
                b.this.aKi = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void V(long j) {
            b.this.aJU = j;
            if (j > b.this.aJQ && b.this.aJZ) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aJU);
            if (b.this.aKa != null) {
                b.this.aKa.q((int) b.this.aJU, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aKa != null) {
                b.this.aKa.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aJX);
    }

    public void setGameRecordCallback(c cVar) {
        this.aKa = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aKb = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aJu == null) {
                this.aJu = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aJu.b(eGLContext);
            }
            this.aJu.CC().setWidth(i);
            this.aJu.CC().setHeight(i2);
            if (z) {
                this.aJu.CE().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aJY.setVideoWidth(i);
            this.aJY.setVideoHeight(i2);
        }
    }

    public void dd(int i) {
        if (this.aJu != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aJu.c(dVar);
                if (this.aJW != null) {
                    this.aJW.b(this.aJu);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aJZ && this.aJY != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    CQ();
                    if (this.aJW != null) {
                        this.aJW.a(this.mAppContext, this.aJY, this.aJX);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aJu.CB().setId(i);
                    if (this.aJW != null) {
                        this.aJW.c(this.aJu);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aJW != null && !this.aJR) {
            this.aJW.W(j - this.aJS);
        }
    }

    public long CL() {
        return this.aJU;
    }

    public void CM() {
        if (!this.aJR) {
            this.aJV = true;
            pauseRecord();
            return;
        }
        this.aJV = false;
    }

    public void CN() {
        if (this.aJR && this.aJV) {
            resumeRecord();
        }
        this.aJV = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aJZ) {
            Log.i(TAG, "startRecored");
            this.aKk = System.nanoTime();
            this.mIsLandscape = z2;
            this.aJY.setOutputFile(str);
            this.aJY.bK(z);
            this.aJY.Z(i * 1000);
            this.aJY.setVideoWidth(this.mCanvasWidth);
            this.aJY.setVideoHeight(this.mCanvasHeight);
            this.aJS = 0L;
            this.aJU = 0L;
            if (i > 0 && i < 120) {
                this.aJQ = i * 1000;
            } else {
                this.aJQ = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CO() {
        if (this.aKg != null) {
            this.aKg.cancel();
            this.aKg = null;
            this.aKh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aJY.dg(audioParams.getSampleRate());
            this.aJY.dh(audioParams.getFrameSize());
            this.aJY.df(audioParams.getChannelConfig());
        }
        this.aKi = false;
        this.aJZ = true;
        CO();
        this.aKg = new Timer();
        this.aKh = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aKi || b.this.aKj) {
                    b.this.c(b.this.aKf, 3840, System.nanoTime() - b.this.aKk);
                    b.this.aKj = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.CO();
                b.this.aKj = false;
            }
        };
        this.aKg.schedule(this.aKh, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aKd == null) {
            CR();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aKc = new AudioParams();
        } else {
            this.aKc = audioParams;
        }
        if (this.aKb != null) {
            Log.i(TAG, "set audio engie:" + this.aKb);
            this.aKb.a(this.aKd);
        }
    }

    public void pauseRecord() {
        if (this.aJR) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aJZ) {
            this.aJR = true;
            Log.i(TAG, "pauseRecord");
            this.aJT = System.nanoTime();
            this.aJS = 0L;
            if (this.aJW != null) {
                this.aJW.CV();
                this.aJS = (this.aJT - (this.aJU * TimeUtils.NANOS_PER_MS)) - this.aJW.CT();
                if (this.aJS < 0) {
                    this.aJS = 0L;
                }
            }
            if (this.aKa != null) {
                this.aKa.onPause();
            }
            CO();
        }
    }

    public void resumeRecord() {
        if (this.aJR) {
            this.aJS += System.nanoTime() - this.aJT;
            this.aJR = false;
            a((AudioParams) null);
            if (this.aKa != null) {
                this.aKa.onResume();
            }
        }
    }

    private void CP() {
        if (this.aJR) {
            this.aJS += System.nanoTime() - this.aJT;
            this.aJR = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        CP();
        this.aJZ = false;
        this.aKi = false;
        this.aKj = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aJW != null) {
                    this.aJW.CW();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void CQ() {
        if (this.aJY != null && this.aJu != null) {
            int videoHeight = this.aJY.getVideoHeight();
            int videoWidth = this.aJY.getVideoWidth();
            if (videoHeight >= 1920 || videoWidth >= 1920) {
                videoHeight = (int) ((videoHeight * 2) / 3.0f);
                videoWidth = (int) ((videoWidth * 2) / 3.0f);
            }
            if (videoHeight % 2 == 1) {
                videoHeight++;
            }
            if (videoWidth % 2 == 1) {
                videoWidth++;
            }
            Log.i(TAG, "Record video width:" + videoWidth + " ;video height:" + videoHeight);
            this.aJY.setVideoWidth(videoWidth);
            this.aJY.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aJY = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aJX = eVar;
    }

    private void CR() {
        if (this.aKd == null) {
            this.aKd = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aJW != null && this.aJZ && byteBuffer != null && i > 0 && !this.aJR) {
            this.aJW.onAudioFrameAvailable(byteBuffer, i, j - this.aJS);
        }
    }

    public void release() {
        if (this.aJW != null) {
            this.aJW.onDestroy();
            this.aJW = null;
        }
        if (this.aJX != null) {
            this.aJX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aKm;

        public a(b bVar) {
            this.aKm = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aKm.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aKm.get() != null) {
                this.aKm.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aKm.get() != null) {
                this.aKm.get().aKj = false;
                this.aKm.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aKm.get() != null) {
                this.aKm.get().CO();
            }
        }
    }
}
