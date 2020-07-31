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
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long bsJ;
    private long bsK;
    private long bsL;
    private com.baidu.mario.a.b.d bsP;
    private boolean bsQ;
    private int bsR;
    private c bsS;
    private AudioParams bsU;
    private com.baidu.mario.audio.a.a bsV;
    private com.baidu.mario.gldraw2d.params.c bsm;
    private Context mAppContext;
    private int bsH = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bsI = false;
    private boolean bsM = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bsW = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bsX = ByteBuffer.allocate(3840).put(this.bsW);
    private Timer bsY = null;
    private TimerTask bsZ = null;
    private boolean bta = false;
    private boolean btb = false;
    private long btc = 0;
    private d bsN = d.Mf();
    private com.baidu.mario.a.a bsT = null;
    private e bsO = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bsS != null) {
                b.this.bsS.onStart();
                b.this.bta = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aG(long j) {
            b.this.bsL = j;
            if (j > b.this.bsH && b.this.bsQ) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bsL);
            if (b.this.bsS != null) {
                b.this.bsS.H((int) b.this.bsL, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bsS != null) {
                b.this.bsS.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bsO);
    }

    public void setGameRecordCallback(c cVar) {
        this.bsS = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bsT = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bsm == null) {
                this.bsm = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bsm.a(eGLContext);
            }
            this.bsm.LP().setWidth(i);
            this.bsm.LP().setHeight(i2);
            if (z) {
                this.bsm.LR().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bsP.setVideoWidth(i);
            this.bsP.setVideoHeight(i2);
        }
    }

    public void dK(int i) {
        if (this.bsm != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bsm.c(dVar);
                if (this.bsN != null) {
                    this.bsN.b(this.bsm);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.bsQ && this.bsP != null) {
            switch (this.bsR) {
                case 0:
                    Md();
                    if (this.bsN != null) {
                        this.bsN.a(this.mAppContext, this.bsP, this.bsO);
                    }
                    this.bsR = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bsm.LO().setId(i);
                    if (this.bsN != null) {
                        this.bsN.c(this.bsm);
                    }
                    this.bsR = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bsR);
            }
        }
        if (this.bsN != null && !this.bsI) {
            this.bsN.onVideoFrameAvailable(j - this.bsJ);
        }
    }

    public long LY() {
        return this.bsL;
    }

    public void LZ() {
        if (!this.bsI) {
            this.bsM = true;
            pauseRecord();
            return;
        }
        this.bsM = false;
    }

    public void Ma() {
        if (this.bsI && this.bsM) {
            resumeRecord();
        }
        this.bsM = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bsQ) {
            Log.i(TAG, "startRecored");
            this.btc = System.nanoTime();
            this.mIsLandscape = z2;
            this.bsP.setOutputFile(str);
            this.bsP.setAudioIncluded(z);
            this.bsP.setOutputTotalMs(i * 1000);
            this.bsP.setVideoWidth(this.mCanvasWidth);
            this.bsP.setVideoHeight(this.mCanvasHeight);
            this.bsJ = 0L;
            this.bsL = 0L;
            if (i > 0 && i < 120) {
                this.bsH = i * 1000;
            } else {
                this.bsH = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Mb() {
        if (this.bsY != null) {
            this.bsY.cancel();
            this.bsY = null;
            this.bsZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bsP.setAudioSampleRate(audioParams.getSampleRate());
            this.bsP.setAudioFrameSize(audioParams.getFrameSize());
            this.bsP.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bta = false;
        this.bsQ = true;
        Mb();
        this.bsY = new Timer();
        this.bsZ = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bta || b.this.btb) {
                    b.this.c(b.this.bsX, 3840, System.nanoTime() - b.this.btc);
                    b.this.btb = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Mb();
                b.this.btb = false;
            }
        };
        this.bsY.schedule(this.bsZ, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bsV == null) {
            Me();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bsU = new AudioParams();
        } else {
            this.bsU = audioParams;
        }
        if (this.bsT != null) {
            Log.i(TAG, "set audio engie:" + this.bsT);
            this.bsT.a(this.bsV);
        }
    }

    public void pauseRecord() {
        if (this.bsI) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bsQ) {
            this.bsI = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bsK = System.nanoTime();
            this.bsJ = 0L;
            if (this.bsN != null) {
                this.bsN.Mi();
                this.bsJ = (this.bsK - (this.bsL * TimeUtils.NANOS_PER_MS)) - this.bsN.Mg();
                if (this.bsJ < 0) {
                    this.bsJ = 0L;
                }
            }
            if (this.bsS != null) {
                this.bsS.onPause();
            }
            Mb();
        }
    }

    public void resumeRecord() {
        if (this.bsI) {
            this.bsJ += System.nanoTime() - this.bsK;
            this.bsI = false;
            a((AudioParams) null);
            if (this.bsS != null) {
                this.bsS.onResume();
            }
        }
    }

    private void Mc() {
        if (this.bsI) {
            this.bsJ += System.nanoTime() - this.bsK;
            this.bsI = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Mc();
        this.bsQ = false;
        this.bta = false;
        this.btb = false;
        switch (this.bsR) {
            case 0:
                return;
            case 1:
            case 2:
                this.bsR = 0;
                if (this.bsN != null) {
                    this.bsN.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bsR);
        }
    }

    private void Md() {
        if (this.bsP != null && this.bsm != null) {
            int videoHeight = this.bsP.getVideoHeight();
            int videoWidth = this.bsP.getVideoWidth();
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
            this.bsP.setVideoWidth(videoWidth);
            this.bsP.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bsP = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bsO = eVar;
    }

    private void Me() {
        if (this.bsV == null) {
            this.bsV = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bsN != null && this.bsQ && byteBuffer != null && i > 0 && !this.bsI) {
            this.bsN.onAudioFrameAvailable(byteBuffer, i, j - this.bsJ);
        }
    }

    public void release() {
        if (this.bsN != null) {
            this.bsN.onDestroy();
            this.bsN = null;
        }
        if (this.bsO != null) {
            this.bsO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bte;

        public a(b bVar) {
            this.bte = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bte.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bte.get() != null) {
                this.bte.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bte.get() != null) {
                this.bte.get().btb = false;
                this.bte.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bte.get() != null) {
                this.bte.get().Mb();
            }
        }
    }
}
