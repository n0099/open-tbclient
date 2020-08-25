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
    private com.baidu.mario.a.b.d byC;
    private boolean byD;
    private int byE;
    private c byF;
    private AudioParams byH;
    private com.baidu.mario.audio.a.a byI;
    private com.baidu.mario.gldraw2d.params.c byc;
    private long byw;
    private long byx;
    private long byy;
    private Context mAppContext;
    private int byu = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean byv = false;
    private boolean byz = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] byJ = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer byK = ByteBuffer.allocate(3840).put(this.byJ);
    private Timer byL = null;
    private TimerTask byM = null;
    private boolean byN = false;
    private boolean byO = false;
    private long byP = 0;
    private d byA = d.Se();
    private com.baidu.mario.a.a byG = null;
    private e byB = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.byF != null) {
                b.this.byF.onStart();
                b.this.byN = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aH(long j) {
            b.this.byy = j;
            if (j > b.this.byu && b.this.byD) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.byy);
            if (b.this.byF != null) {
                b.this.byF.G((int) b.this.byy, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.byF != null) {
                b.this.byF.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.byB);
    }

    public void setGameRecordCallback(c cVar) {
        this.byF = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.byG = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.byc == null) {
                this.byc = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.byc.a(eGLContext);
            }
            this.byc.RO().setWidth(i);
            this.byc.RO().setHeight(i2);
            if (z) {
                this.byc.RQ().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.byC.setVideoWidth(i);
            this.byC.setVideoHeight(i2);
        }
    }

    public void fF(int i) {
        if (this.byc != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.byc.c(dVar);
                if (this.byA != null) {
                    this.byA.b(this.byc);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.byD && this.byC != null) {
            switch (this.byE) {
                case 0:
                    Sc();
                    if (this.byA != null) {
                        this.byA.a(this.mAppContext, this.byC, this.byB);
                    }
                    this.byE = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.byc.RN().setId(i);
                    if (this.byA != null) {
                        this.byA.c(this.byc);
                    }
                    this.byE = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.byE);
            }
        }
        if (this.byA != null && !this.byv) {
            this.byA.onVideoFrameAvailable(j - this.byw);
        }
    }

    public long RX() {
        return this.byy;
    }

    public void RY() {
        if (!this.byv) {
            this.byz = true;
            pauseRecord();
            return;
        }
        this.byz = false;
    }

    public void RZ() {
        if (this.byv && this.byz) {
            resumeRecord();
        }
        this.byz = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.byD) {
            Log.i(TAG, "startRecored");
            this.byP = System.nanoTime();
            this.mIsLandscape = z2;
            this.byC.setOutputFile(str);
            this.byC.setAudioIncluded(z);
            this.byC.setOutputTotalMs(i * 1000);
            this.byC.setVideoWidth(this.mCanvasWidth);
            this.byC.setVideoHeight(this.mCanvasHeight);
            this.byw = 0L;
            this.byy = 0L;
            if (i > 0 && i < 120) {
                this.byu = i * 1000;
            } else {
                this.byu = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sa() {
        if (this.byL != null) {
            this.byL.cancel();
            this.byL = null;
            this.byM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.byC.setAudioSampleRate(audioParams.getSampleRate());
            this.byC.setAudioFrameSize(audioParams.getFrameSize());
            this.byC.setAudioChannel(audioParams.getChannelConfig());
        }
        this.byN = false;
        this.byD = true;
        Sa();
        this.byL = new Timer();
        this.byM = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.byN || b.this.byO) {
                    b.this.c(b.this.byK, 3840, System.nanoTime() - b.this.byP);
                    b.this.byO = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Sa();
                b.this.byO = false;
            }
        };
        this.byL.schedule(this.byM, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.byI == null) {
            Sd();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.byH = new AudioParams();
        } else {
            this.byH = audioParams;
        }
        if (this.byG != null) {
            Log.i(TAG, "set audio engie:" + this.byG);
            this.byG.a(this.byI);
        }
    }

    public void pauseRecord() {
        if (this.byv) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.byD) {
            this.byv = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.byx = System.nanoTime();
            this.byw = 0L;
            if (this.byA != null) {
                this.byA.Sh();
                this.byw = (this.byx - (this.byy * TimeUtils.NANOS_PER_MS)) - this.byA.Sf();
                if (this.byw < 0) {
                    this.byw = 0L;
                }
            }
            if (this.byF != null) {
                this.byF.onPause();
            }
            Sa();
        }
    }

    public void resumeRecord() {
        if (this.byv) {
            this.byw += System.nanoTime() - this.byx;
            this.byv = false;
            a((AudioParams) null);
            if (this.byF != null) {
                this.byF.onResume();
            }
        }
    }

    private void Sb() {
        if (this.byv) {
            this.byw += System.nanoTime() - this.byx;
            this.byv = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Sb();
        this.byD = false;
        this.byN = false;
        this.byO = false;
        switch (this.byE) {
            case 0:
                return;
            case 1:
            case 2:
                this.byE = 0;
                if (this.byA != null) {
                    this.byA.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.byE);
        }
    }

    private void Sc() {
        if (this.byC != null && this.byc != null) {
            int videoHeight = this.byC.getVideoHeight();
            int videoWidth = this.byC.getVideoWidth();
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
            this.byC.setVideoWidth(videoWidth);
            this.byC.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.byC = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.byB = eVar;
    }

    private void Sd() {
        if (this.byI == null) {
            this.byI = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.byA != null && this.byD && byteBuffer != null && i > 0 && !this.byv) {
            this.byA.onAudioFrameAvailable(byteBuffer, i, j - this.byw);
        }
    }

    public void release() {
        if (this.byA != null) {
            this.byA.onDestroy();
            this.byA = null;
        }
        if (this.byB != null) {
            this.byB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> byR;

        public a(b bVar) {
            this.byR = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.byR.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.byR.get() != null) {
                this.byR.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.byR.get() != null) {
                this.byR.get().byO = false;
                this.byR.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.byR.get() != null) {
                this.byR.get().Sa();
            }
        }
    }
}
