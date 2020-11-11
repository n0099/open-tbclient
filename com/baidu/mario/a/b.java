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
/* loaded from: classes5.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long bWD;
    private long bWE;
    private long bWF;
    private com.baidu.mario.a.b.d bWJ;
    private boolean bWK;
    private int bWL;
    private c bWM;
    private AudioParams bWO;
    private com.baidu.mario.audio.a.a bWP;
    private com.baidu.mario.gldraw2d.params.c bWj;
    private Context mAppContext;
    private int bWB = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bWC = false;
    private boolean bWG = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bWQ = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bWR = ByteBuffer.allocate(3840).put(this.bWQ);
    private Timer bWS = null;
    private TimerTask bWT = null;
    private boolean bWU = false;
    private boolean bWV = false;
    private long bWW = 0;
    private d bWH = d.Zh();
    private com.baidu.mario.a.a bWN = null;
    private e bWI = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bWM != null) {
                b.this.bWM.onStart();
                b.this.bWU = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bh(long j) {
            b.this.bWF = j;
            if (j > b.this.bWB && b.this.bWK) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bWF);
            if (b.this.bWM != null) {
                b.this.bWM.Y((int) b.this.bWF, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bWM != null) {
                b.this.bWM.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bWI);
    }

    public void setGameRecordCallback(c cVar) {
        this.bWM = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bWN = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bWj == null) {
                this.bWj = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bWj.a(eGLContext);
            }
            this.bWj.YR().setWidth(i);
            this.bWj.YR().setHeight(i2);
            if (z) {
                this.bWj.YT().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bWJ.setVideoWidth(i);
            this.bWJ.setVideoHeight(i2);
        }
    }

    public void gD(int i) {
        if (this.bWj != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bWj.c(dVar);
                if (this.bWH != null) {
                    this.bWH.b(this.bWj);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.bWK && this.bWJ != null) {
            switch (this.bWL) {
                case 0:
                    Zf();
                    if (this.bWH != null) {
                        this.bWH.a(this.mAppContext, this.bWJ, this.bWI);
                    }
                    this.bWL = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bWj.YQ().setId(i);
                    if (this.bWH != null) {
                        this.bWH.c(this.bWj);
                    }
                    this.bWL = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bWL);
            }
        }
        if (this.bWH != null && !this.bWC) {
            this.bWH.onVideoFrameAvailable(j - this.bWD);
        }
    }

    public long Za() {
        return this.bWF;
    }

    public void Zb() {
        if (!this.bWC) {
            this.bWG = true;
            pauseRecord();
            return;
        }
        this.bWG = false;
    }

    public void Zc() {
        if (this.bWC && this.bWG) {
            resumeRecord();
        }
        this.bWG = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bWK) {
            Log.i(TAG, "startRecored");
            this.bWW = System.nanoTime();
            this.mIsLandscape = z2;
            this.bWJ.setOutputFile(str);
            this.bWJ.setAudioIncluded(z);
            this.bWJ.setOutputTotalMs(i * 1000);
            this.bWJ.setVideoWidth(this.mCanvasWidth);
            this.bWJ.setVideoHeight(this.mCanvasHeight);
            this.bWD = 0L;
            this.bWF = 0L;
            if (i > 0 && i < 120) {
                this.bWB = i * 1000;
            } else {
                this.bWB = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Zd() {
        if (this.bWS != null) {
            this.bWS.cancel();
            this.bWS = null;
            this.bWT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bWJ.setAudioSampleRate(audioParams.getSampleRate());
            this.bWJ.setAudioFrameSize(audioParams.getFrameSize());
            this.bWJ.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bWU = false;
        this.bWK = true;
        Zd();
        this.bWS = new Timer();
        this.bWT = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bWU || b.this.bWV) {
                    b.this.c(b.this.bWR, 3840, System.nanoTime() - b.this.bWW);
                    b.this.bWV = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Zd();
                b.this.bWV = false;
            }
        };
        this.bWS.schedule(this.bWT, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bWP == null) {
            Zg();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bWO = new AudioParams();
        } else {
            this.bWO = audioParams;
        }
        if (this.bWN != null) {
            Log.i(TAG, "set audio engie:" + this.bWN);
            this.bWN.a(this.bWP);
        }
    }

    public void pauseRecord() {
        if (this.bWC) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bWK) {
            this.bWC = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bWE = System.nanoTime();
            this.bWD = 0L;
            if (this.bWH != null) {
                this.bWH.Zk();
                this.bWD = (this.bWE - (this.bWF * TimeUtils.NANOS_PER_MS)) - this.bWH.Zi();
                if (this.bWD < 0) {
                    this.bWD = 0L;
                }
            }
            if (this.bWM != null) {
                this.bWM.onPause();
            }
            Zd();
        }
    }

    public void resumeRecord() {
        if (this.bWC) {
            this.bWD += System.nanoTime() - this.bWE;
            this.bWC = false;
            a((AudioParams) null);
            if (this.bWM != null) {
                this.bWM.onResume();
            }
        }
    }

    private void Ze() {
        if (this.bWC) {
            this.bWD += System.nanoTime() - this.bWE;
            this.bWC = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Ze();
        this.bWK = false;
        this.bWU = false;
        this.bWV = false;
        switch (this.bWL) {
            case 0:
                return;
            case 1:
            case 2:
                this.bWL = 0;
                if (this.bWH != null) {
                    this.bWH.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bWL);
        }
    }

    private void Zf() {
        if (this.bWJ != null && this.bWj != null) {
            int videoHeight = this.bWJ.getVideoHeight();
            int videoWidth = this.bWJ.getVideoWidth();
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
            this.bWJ.setVideoWidth(videoWidth);
            this.bWJ.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bWJ = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bWI = eVar;
    }

    private void Zg() {
        if (this.bWP == null) {
            this.bWP = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bWH != null && this.bWK && byteBuffer != null && i > 0 && !this.bWC) {
            this.bWH.onAudioFrameAvailable(byteBuffer, i, j - this.bWD);
        }
    }

    public void release() {
        if (this.bWH != null) {
            this.bWH.onDestroy();
            this.bWH = null;
        }
        if (this.bWI != null) {
            this.bWI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bWY;

        public a(b bVar) {
            this.bWY = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bWY.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bWY.get() != null) {
                this.bWY.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bWY.get() != null) {
                this.bWY.get().bWV = false;
                this.bWY.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bWY.get() != null) {
                this.bWY.get().Zd();
            }
        }
    }
}
