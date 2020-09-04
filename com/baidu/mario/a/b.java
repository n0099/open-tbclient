package com.baidu.mario.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes20.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long byA;
    private long byB;
    private com.baidu.mario.a.b.d byF;
    private boolean byG;
    private int byH;
    private c byI;
    private AudioParams byK;
    private com.baidu.mario.audio.a.a byL;
    private com.baidu.mario.gldraw2d.params.c byf;
    private long byz;
    private Context mAppContext;
    private int byx = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean byy = false;
    private boolean byC = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] byM = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer byN = ByteBuffer.allocate(3840).put(this.byM);
    private Timer byO = null;
    private TimerTask byP = null;
    private boolean byQ = false;
    private boolean byR = false;
    private long byS = 0;
    private d byD = d.Se();
    private com.baidu.mario.a.a byJ = null;
    private e byE = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.byI != null) {
                b.this.byI.onStart();
                b.this.byQ = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aH(long j) {
            b.this.byB = j;
            if (j > b.this.byx && b.this.byG) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.byB);
            if (b.this.byI != null) {
                b.this.byI.G((int) b.this.byB, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.byI != null) {
                b.this.byI.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.byE);
    }

    public void setGameRecordCallback(c cVar) {
        this.byI = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.byJ = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.byf == null) {
                this.byf = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.byf.a(eGLContext);
            }
            this.byf.RO().setWidth(i);
            this.byf.RO().setHeight(i2);
            if (z) {
                this.byf.RQ().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.byF.setVideoWidth(i);
            this.byF.setVideoHeight(i2);
        }
    }

    public void fF(int i) {
        if (this.byf != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.byf.c(dVar);
                if (this.byD != null) {
                    this.byD.b(this.byf);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.byG && this.byF != null) {
            switch (this.byH) {
                case 0:
                    Sc();
                    if (this.byD != null) {
                        this.byD.a(this.mAppContext, this.byF, this.byE);
                    }
                    this.byH = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.byf.RN().setId(i);
                    if (this.byD != null) {
                        this.byD.c(this.byf);
                    }
                    this.byH = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.byH);
            }
        }
        if (this.byD != null && !this.byy) {
            this.byD.onVideoFrameAvailable(j - this.byz);
        }
    }

    public long RX() {
        return this.byB;
    }

    public void RY() {
        if (!this.byy) {
            this.byC = true;
            pauseRecord();
            return;
        }
        this.byC = false;
    }

    public void RZ() {
        if (this.byy && this.byC) {
            resumeRecord();
        }
        this.byC = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.byG) {
            Log.i(TAG, "startRecored");
            this.byS = System.nanoTime();
            this.mIsLandscape = z2;
            this.byF.setOutputFile(str);
            this.byF.setAudioIncluded(z);
            this.byF.setOutputTotalMs(i * 1000);
            this.byF.setVideoWidth(this.mCanvasWidth);
            this.byF.setVideoHeight(this.mCanvasHeight);
            this.byz = 0L;
            this.byB = 0L;
            if (i > 0 && i < 120) {
                this.byx = i * 1000;
            } else {
                this.byx = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sa() {
        if (this.byO != null) {
            this.byO.cancel();
            this.byO = null;
            this.byP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.byF.setAudioSampleRate(audioParams.getSampleRate());
            this.byF.setAudioFrameSize(audioParams.getFrameSize());
            this.byF.setAudioChannel(audioParams.getChannelConfig());
        }
        this.byQ = false;
        this.byG = true;
        Sa();
        this.byO = new Timer();
        this.byP = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.byQ || b.this.byR) {
                    b.this.c(b.this.byN, 3840, System.nanoTime() - b.this.byS);
                    b.this.byR = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Sa();
                b.this.byR = false;
            }
        };
        this.byO.schedule(this.byP, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.byL == null) {
            Sd();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.byK = new AudioParams();
        } else {
            this.byK = audioParams;
        }
        if (this.byJ != null) {
            Log.i(TAG, "set audio engie:" + this.byJ);
            this.byJ.a(this.byL);
        }
    }

    public void pauseRecord() {
        if (this.byy) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.byG) {
            this.byy = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.byA = System.nanoTime();
            this.byz = 0L;
            if (this.byD != null) {
                this.byD.Sh();
                this.byz = (this.byA - (this.byB * TimeUtils.NANOS_PER_MS)) - this.byD.Sf();
                if (this.byz < 0) {
                    this.byz = 0L;
                }
            }
            if (this.byI != null) {
                this.byI.onPause();
            }
            Sa();
        }
    }

    public void resumeRecord() {
        if (this.byy) {
            this.byz += System.nanoTime() - this.byA;
            this.byy = false;
            a((AudioParams) null);
            if (this.byI != null) {
                this.byI.onResume();
            }
        }
    }

    private void Sb() {
        if (this.byy) {
            this.byz += System.nanoTime() - this.byA;
            this.byy = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Sb();
        this.byG = false;
        this.byQ = false;
        this.byR = false;
        switch (this.byH) {
            case 0:
                return;
            case 1:
            case 2:
                this.byH = 0;
                if (this.byD != null) {
                    this.byD.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.byH);
        }
    }

    private void Sc() {
        if (this.byF != null && this.byf != null) {
            int videoHeight = this.byF.getVideoHeight();
            int videoWidth = this.byF.getVideoWidth();
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
            this.byF.setVideoWidth(videoWidth);
            this.byF.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.byF = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.byE = eVar;
    }

    private void Sd() {
        if (this.byL == null) {
            this.byL = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.byD != null && this.byG && byteBuffer != null && i > 0 && !this.byy) {
            this.byD.onAudioFrameAvailable(byteBuffer, i, j - this.byz);
        }
    }

    public void release() {
        if (this.byD != null) {
            this.byD.onDestroy();
            this.byD = null;
        }
        if (this.byE != null) {
            this.byE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> byU;

        public a(b bVar) {
            this.byU = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.byU.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.byU.get() != null) {
                this.byU.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.byU.get() != null) {
                this.byU.get().byR = false;
                this.byU.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.byU.get() != null) {
                this.byU.get().Sa();
            }
        }
    }
}
