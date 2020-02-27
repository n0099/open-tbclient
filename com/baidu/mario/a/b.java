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
    private long aJC;
    private long aJD;
    private long aJE;
    private com.baidu.mario.a.b.d aJI;
    private boolean aJJ;
    private c aJK;
    private AudioParams aJM;
    private com.baidu.mario.audio.a.a aJN;
    private com.baidu.mario.gldraw2d.params.c aJe;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aJA = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean aJB = false;
    private boolean aJF = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aJO = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aJP = ByteBuffer.allocate(3840).put(this.aJO);
    private Timer aJQ = null;
    private TimerTask aJR = null;
    private boolean aJS = false;
    private boolean aJT = false;
    private long aJU = 0;
    private d aJG = d.CJ();
    private com.baidu.mario.a.a aJL = null;
    private e aJH = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aJK != null) {
                b.this.aJK.onStart();
                b.this.aJS = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void V(long j) {
            b.this.aJE = j;
            if (j > b.this.aJA && b.this.aJJ) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aJE);
            if (b.this.aJK != null) {
                b.this.aJK.q((int) b.this.aJE, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aJK != null) {
                b.this.aJK.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aJH);
    }

    public void setGameRecordCallback(c cVar) {
        this.aJK = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aJL = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aJe == null) {
                this.aJe = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aJe.b(eGLContext);
            }
            this.aJe.Ct().setWidth(i);
            this.aJe.Ct().setHeight(i2);
            if (z) {
                this.aJe.Cv().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aJI.setVideoWidth(i);
            this.aJI.setVideoHeight(i2);
        }
    }

    public void dd(int i) {
        if (this.aJe != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aJe.c(dVar);
                if (this.aJG != null) {
                    this.aJG.b(this.aJe);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aJJ && this.aJI != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    CH();
                    if (this.aJG != null) {
                        this.aJG.a(this.mAppContext, this.aJI, this.aJH);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aJe.Cs().setId(i);
                    if (this.aJG != null) {
                        this.aJG.c(this.aJe);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aJG != null && !this.aJB) {
            this.aJG.W(j - this.aJC);
        }
    }

    public long CC() {
        return this.aJE;
    }

    public void CD() {
        if (!this.aJB) {
            this.aJF = true;
            pauseRecord();
            return;
        }
        this.aJF = false;
    }

    public void CE() {
        if (this.aJB && this.aJF) {
            resumeRecord();
        }
        this.aJF = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aJJ) {
            Log.i(TAG, "startRecored");
            this.aJU = System.nanoTime();
            this.mIsLandscape = z2;
            this.aJI.setOutputFile(str);
            this.aJI.bJ(z);
            this.aJI.Z(i * 1000);
            this.aJI.setVideoWidth(this.mCanvasWidth);
            this.aJI.setVideoHeight(this.mCanvasHeight);
            this.aJC = 0L;
            this.aJE = 0L;
            if (i > 0 && i < 120) {
                this.aJA = i * 1000;
            } else {
                this.aJA = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CF() {
        if (this.aJQ != null) {
            this.aJQ.cancel();
            this.aJQ = null;
            this.aJR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aJI.dg(audioParams.getSampleRate());
            this.aJI.dh(audioParams.getFrameSize());
            this.aJI.df(audioParams.getChannelConfig());
        }
        this.aJS = false;
        this.aJJ = true;
        CF();
        this.aJQ = new Timer();
        this.aJR = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aJS || b.this.aJT) {
                    b.this.c(b.this.aJP, 3840, System.nanoTime() - b.this.aJU);
                    b.this.aJT = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.CF();
                b.this.aJT = false;
            }
        };
        this.aJQ.schedule(this.aJR, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aJN == null) {
            CI();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aJM = new AudioParams();
        } else {
            this.aJM = audioParams;
        }
        if (this.aJL != null) {
            Log.i(TAG, "set audio engie:" + this.aJL);
            this.aJL.a(this.aJN);
        }
    }

    public void pauseRecord() {
        if (this.aJB) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aJJ) {
            this.aJB = true;
            Log.i(TAG, "pauseRecord");
            this.aJD = System.nanoTime();
            this.aJC = 0L;
            if (this.aJG != null) {
                this.aJG.CM();
                this.aJC = (this.aJD - (this.aJE * TimeUtils.NANOS_PER_MS)) - this.aJG.CK();
                if (this.aJC < 0) {
                    this.aJC = 0L;
                }
            }
            if (this.aJK != null) {
                this.aJK.onPause();
            }
            CF();
        }
    }

    public void resumeRecord() {
        if (this.aJB) {
            this.aJC += System.nanoTime() - this.aJD;
            this.aJB = false;
            a((AudioParams) null);
            if (this.aJK != null) {
                this.aJK.onResume();
            }
        }
    }

    private void CG() {
        if (this.aJB) {
            this.aJC += System.nanoTime() - this.aJD;
            this.aJB = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        CG();
        this.aJJ = false;
        this.aJS = false;
        this.aJT = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aJG != null) {
                    this.aJG.CN();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void CH() {
        if (this.aJI != null && this.aJe != null) {
            int videoHeight = this.aJI.getVideoHeight();
            int videoWidth = this.aJI.getVideoWidth();
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
            this.aJI.setVideoWidth(videoWidth);
            this.aJI.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aJI = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aJH = eVar;
    }

    private void CI() {
        if (this.aJN == null) {
            this.aJN = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aJG != null && this.aJJ && byteBuffer != null && i > 0 && !this.aJB) {
            this.aJG.onAudioFrameAvailable(byteBuffer, i, j - this.aJC);
        }
    }

    public void release() {
        if (this.aJG != null) {
            this.aJG.onDestroy();
            this.aJG = null;
        }
        if (this.aJH != null) {
            this.aJH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aJW;

        public a(b bVar) {
            this.aJW = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aJW.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aJW.get() != null) {
                this.aJW.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aJW.get() != null) {
                this.aJW.get().aJT = false;
                this.aJW.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aJW.get() != null) {
                this.aJW.get().CF();
            }
        }
    }
}
