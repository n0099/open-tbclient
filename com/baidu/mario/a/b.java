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
    private long aJE;
    private long aJF;
    private long aJG;
    private com.baidu.mario.a.b.d aJK;
    private boolean aJL;
    private c aJM;
    private AudioParams aJO;
    private com.baidu.mario.audio.a.a aJP;
    private com.baidu.mario.gldraw2d.params.c aJg;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aJC = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean aJD = false;
    private boolean aJH = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aJQ = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aJR = ByteBuffer.allocate(3840).put(this.aJQ);
    private Timer aJS = null;
    private TimerTask aJT = null;
    private boolean aJU = false;
    private boolean aJV = false;
    private long aJW = 0;
    private d aJI = d.CL();
    private com.baidu.mario.a.a aJN = null;
    private e aJJ = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aJM != null) {
                b.this.aJM.onStart();
                b.this.aJU = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void V(long j) {
            b.this.aJG = j;
            if (j > b.this.aJC && b.this.aJL) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aJG);
            if (b.this.aJM != null) {
                b.this.aJM.q((int) b.this.aJG, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aJM != null) {
                b.this.aJM.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aJJ);
    }

    public void setGameRecordCallback(c cVar) {
        this.aJM = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aJN = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aJg == null) {
                this.aJg = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aJg.b(eGLContext);
            }
            this.aJg.Cv().setWidth(i);
            this.aJg.Cv().setHeight(i2);
            if (z) {
                this.aJg.Cx().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aJK.setVideoWidth(i);
            this.aJK.setVideoHeight(i2);
        }
    }

    public void dd(int i) {
        if (this.aJg != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aJg.c(dVar);
                if (this.aJI != null) {
                    this.aJI.b(this.aJg);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aJL && this.aJK != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    CJ();
                    if (this.aJI != null) {
                        this.aJI.a(this.mAppContext, this.aJK, this.aJJ);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aJg.Cu().setId(i);
                    if (this.aJI != null) {
                        this.aJI.c(this.aJg);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aJI != null && !this.aJD) {
            this.aJI.W(j - this.aJE);
        }
    }

    public long CE() {
        return this.aJG;
    }

    public void CF() {
        if (!this.aJD) {
            this.aJH = true;
            pauseRecord();
            return;
        }
        this.aJH = false;
    }

    public void CG() {
        if (this.aJD && this.aJH) {
            resumeRecord();
        }
        this.aJH = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aJL) {
            Log.i(TAG, "startRecored");
            this.aJW = System.nanoTime();
            this.mIsLandscape = z2;
            this.aJK.setOutputFile(str);
            this.aJK.bJ(z);
            this.aJK.Z(i * 1000);
            this.aJK.setVideoWidth(this.mCanvasWidth);
            this.aJK.setVideoHeight(this.mCanvasHeight);
            this.aJE = 0L;
            this.aJG = 0L;
            if (i > 0 && i < 120) {
                this.aJC = i * 1000;
            } else {
                this.aJC = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CH() {
        if (this.aJS != null) {
            this.aJS.cancel();
            this.aJS = null;
            this.aJT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aJK.dg(audioParams.getSampleRate());
            this.aJK.dh(audioParams.getFrameSize());
            this.aJK.df(audioParams.getChannelConfig());
        }
        this.aJU = false;
        this.aJL = true;
        CH();
        this.aJS = new Timer();
        this.aJT = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aJU || b.this.aJV) {
                    b.this.c(b.this.aJR, 3840, System.nanoTime() - b.this.aJW);
                    b.this.aJV = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.CH();
                b.this.aJV = false;
            }
        };
        this.aJS.schedule(this.aJT, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aJP == null) {
            CK();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aJO = new AudioParams();
        } else {
            this.aJO = audioParams;
        }
        if (this.aJN != null) {
            Log.i(TAG, "set audio engie:" + this.aJN);
            this.aJN.a(this.aJP);
        }
    }

    public void pauseRecord() {
        if (this.aJD) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aJL) {
            this.aJD = true;
            Log.i(TAG, "pauseRecord");
            this.aJF = System.nanoTime();
            this.aJE = 0L;
            if (this.aJI != null) {
                this.aJI.CO();
                this.aJE = (this.aJF - (this.aJG * TimeUtils.NANOS_PER_MS)) - this.aJI.CM();
                if (this.aJE < 0) {
                    this.aJE = 0L;
                }
            }
            if (this.aJM != null) {
                this.aJM.onPause();
            }
            CH();
        }
    }

    public void resumeRecord() {
        if (this.aJD) {
            this.aJE += System.nanoTime() - this.aJF;
            this.aJD = false;
            a((AudioParams) null);
            if (this.aJM != null) {
                this.aJM.onResume();
            }
        }
    }

    private void CI() {
        if (this.aJD) {
            this.aJE += System.nanoTime() - this.aJF;
            this.aJD = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        CI();
        this.aJL = false;
        this.aJU = false;
        this.aJV = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aJI != null) {
                    this.aJI.CP();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void CJ() {
        if (this.aJK != null && this.aJg != null) {
            int videoHeight = this.aJK.getVideoHeight();
            int videoWidth = this.aJK.getVideoWidth();
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
            this.aJK.setVideoWidth(videoWidth);
            this.aJK.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aJK = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aJJ = eVar;
    }

    private void CK() {
        if (this.aJP == null) {
            this.aJP = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aJI != null && this.aJL && byteBuffer != null && i > 0 && !this.aJD) {
            this.aJI.onAudioFrameAvailable(byteBuffer, i, j - this.aJE);
        }
    }

    public void release() {
        if (this.aJI != null) {
            this.aJI.onDestroy();
            this.aJI = null;
        }
        if (this.aJJ != null) {
            this.aJJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aJY;

        public a(b bVar) {
            this.aJY = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aJY.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aJY.get() != null) {
                this.aJY.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aJY.get() != null) {
                this.aJY.get().aJV = false;
                this.aJY.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aJY.get() != null) {
                this.aJY.get().CH();
            }
        }
    }
}
