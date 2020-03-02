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
    private long aJD;
    private long aJE;
    private long aJF;
    private com.baidu.mario.a.b.d aJJ;
    private boolean aJK;
    private c aJL;
    private AudioParams aJN;
    private com.baidu.mario.audio.a.a aJO;
    private com.baidu.mario.gldraw2d.params.c aJf;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aJB = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean aJC = false;
    private boolean aJG = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aJP = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aJQ = ByteBuffer.allocate(3840).put(this.aJP);
    private Timer aJR = null;
    private TimerTask aJS = null;
    private boolean aJT = false;
    private boolean aJU = false;
    private long aJV = 0;
    private d aJH = d.CL();
    private com.baidu.mario.a.a aJM = null;
    private e aJI = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aJL != null) {
                b.this.aJL.onStart();
                b.this.aJT = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void V(long j) {
            b.this.aJF = j;
            if (j > b.this.aJB && b.this.aJK) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aJF);
            if (b.this.aJL != null) {
                b.this.aJL.q((int) b.this.aJF, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aJL != null) {
                b.this.aJL.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aJI);
    }

    public void setGameRecordCallback(c cVar) {
        this.aJL = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aJM = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aJf == null) {
                this.aJf = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aJf.b(eGLContext);
            }
            this.aJf.Cv().setWidth(i);
            this.aJf.Cv().setHeight(i2);
            if (z) {
                this.aJf.Cx().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aJJ.setVideoWidth(i);
            this.aJJ.setVideoHeight(i2);
        }
    }

    public void dd(int i) {
        if (this.aJf != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aJf.c(dVar);
                if (this.aJH != null) {
                    this.aJH.b(this.aJf);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aJK && this.aJJ != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    CJ();
                    if (this.aJH != null) {
                        this.aJH.a(this.mAppContext, this.aJJ, this.aJI);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aJf.Cu().setId(i);
                    if (this.aJH != null) {
                        this.aJH.c(this.aJf);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aJH != null && !this.aJC) {
            this.aJH.W(j - this.aJD);
        }
    }

    public long CE() {
        return this.aJF;
    }

    public void CF() {
        if (!this.aJC) {
            this.aJG = true;
            pauseRecord();
            return;
        }
        this.aJG = false;
    }

    public void CG() {
        if (this.aJC && this.aJG) {
            resumeRecord();
        }
        this.aJG = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aJK) {
            Log.i(TAG, "startRecored");
            this.aJV = System.nanoTime();
            this.mIsLandscape = z2;
            this.aJJ.setOutputFile(str);
            this.aJJ.bJ(z);
            this.aJJ.Z(i * 1000);
            this.aJJ.setVideoWidth(this.mCanvasWidth);
            this.aJJ.setVideoHeight(this.mCanvasHeight);
            this.aJD = 0L;
            this.aJF = 0L;
            if (i > 0 && i < 120) {
                this.aJB = i * 1000;
            } else {
                this.aJB = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CH() {
        if (this.aJR != null) {
            this.aJR.cancel();
            this.aJR = null;
            this.aJS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aJJ.dg(audioParams.getSampleRate());
            this.aJJ.dh(audioParams.getFrameSize());
            this.aJJ.df(audioParams.getChannelConfig());
        }
        this.aJT = false;
        this.aJK = true;
        CH();
        this.aJR = new Timer();
        this.aJS = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aJT || b.this.aJU) {
                    b.this.c(b.this.aJQ, 3840, System.nanoTime() - b.this.aJV);
                    b.this.aJU = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.CH();
                b.this.aJU = false;
            }
        };
        this.aJR.schedule(this.aJS, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aJO == null) {
            CK();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aJN = new AudioParams();
        } else {
            this.aJN = audioParams;
        }
        if (this.aJM != null) {
            Log.i(TAG, "set audio engie:" + this.aJM);
            this.aJM.a(this.aJO);
        }
    }

    public void pauseRecord() {
        if (this.aJC) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aJK) {
            this.aJC = true;
            Log.i(TAG, "pauseRecord");
            this.aJE = System.nanoTime();
            this.aJD = 0L;
            if (this.aJH != null) {
                this.aJH.CO();
                this.aJD = (this.aJE - (this.aJF * TimeUtils.NANOS_PER_MS)) - this.aJH.CM();
                if (this.aJD < 0) {
                    this.aJD = 0L;
                }
            }
            if (this.aJL != null) {
                this.aJL.onPause();
            }
            CH();
        }
    }

    public void resumeRecord() {
        if (this.aJC) {
            this.aJD += System.nanoTime() - this.aJE;
            this.aJC = false;
            a((AudioParams) null);
            if (this.aJL != null) {
                this.aJL.onResume();
            }
        }
    }

    private void CI() {
        if (this.aJC) {
            this.aJD += System.nanoTime() - this.aJE;
            this.aJC = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        CI();
        this.aJK = false;
        this.aJT = false;
        this.aJU = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aJH != null) {
                    this.aJH.CP();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void CJ() {
        if (this.aJJ != null && this.aJf != null) {
            int videoHeight = this.aJJ.getVideoHeight();
            int videoWidth = this.aJJ.getVideoWidth();
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
            this.aJJ.setVideoWidth(videoWidth);
            this.aJJ.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aJJ = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aJI = eVar;
    }

    private void CK() {
        if (this.aJO == null) {
            this.aJO = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aJH != null && this.aJK && byteBuffer != null && i > 0 && !this.aJC) {
            this.aJH.onAudioFrameAvailable(byteBuffer, i, j - this.aJD);
        }
    }

    public void release() {
        if (this.aJH != null) {
            this.aJH.onDestroy();
            this.aJH = null;
        }
        if (this.aJI != null) {
            this.aJI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aJX;

        public a(b bVar) {
            this.aJX = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aJX.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aJX.get() != null) {
                this.aJX.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aJX.get() != null) {
                this.aJX.get().aJU = false;
                this.aJX.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aJX.get() != null) {
                this.aJX.get().CH();
            }
        }
    }
}
