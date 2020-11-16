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
/* loaded from: classes6.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long bUT;
    private long bUU;
    private long bUV;
    private com.baidu.mario.a.b.d bUZ;
    private com.baidu.mario.gldraw2d.params.c bUz;
    private boolean bVa;
    private int bVb;
    private c bVc;
    private AudioParams bVe;
    private com.baidu.mario.audio.a.a bVf;
    private Context mAppContext;
    private int bUR = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bUS = false;
    private boolean bUW = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bVg = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bVh = ByteBuffer.allocate(3840).put(this.bVg);
    private Timer bVi = null;
    private TimerTask bVj = null;
    private boolean bVk = false;
    private boolean bVl = false;
    private long bVm = 0;
    private d bUX = d.Yy();
    private com.baidu.mario.a.a bVd = null;
    private e bUY = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bVc != null) {
                b.this.bVc.onStart();
                b.this.bVk = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bh(long j) {
            b.this.bUV = j;
            if (j > b.this.bUR && b.this.bVa) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bUV);
            if (b.this.bVc != null) {
                b.this.bVc.Y((int) b.this.bUV, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bVc != null) {
                b.this.bVc.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bUY);
    }

    public void setGameRecordCallback(c cVar) {
        this.bVc = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bVd = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bUz == null) {
                this.bUz = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bUz.a(eGLContext);
            }
            this.bUz.Yi().setWidth(i);
            this.bUz.Yi().setHeight(i2);
            if (z) {
                this.bUz.Yk().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bUZ.setVideoWidth(i);
            this.bUZ.setVideoHeight(i2);
        }
    }

    public void gz(int i) {
        if (this.bUz != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bUz.c(dVar);
                if (this.bUX != null) {
                    this.bUX.b(this.bUz);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.bVa && this.bUZ != null) {
            switch (this.bVb) {
                case 0:
                    Yw();
                    if (this.bUX != null) {
                        this.bUX.a(this.mAppContext, this.bUZ, this.bUY);
                    }
                    this.bVb = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bUz.Yh().setId(i);
                    if (this.bUX != null) {
                        this.bUX.c(this.bUz);
                    }
                    this.bVb = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bVb);
            }
        }
        if (this.bUX != null && !this.bUS) {
            this.bUX.onVideoFrameAvailable(j - this.bUT);
        }
    }

    public long Yr() {
        return this.bUV;
    }

    public void Ys() {
        if (!this.bUS) {
            this.bUW = true;
            pauseRecord();
            return;
        }
        this.bUW = false;
    }

    public void Yt() {
        if (this.bUS && this.bUW) {
            resumeRecord();
        }
        this.bUW = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bVa) {
            Log.i(TAG, "startRecored");
            this.bVm = System.nanoTime();
            this.mIsLandscape = z2;
            this.bUZ.setOutputFile(str);
            this.bUZ.setAudioIncluded(z);
            this.bUZ.setOutputTotalMs(i * 1000);
            this.bUZ.setVideoWidth(this.mCanvasWidth);
            this.bUZ.setVideoHeight(this.mCanvasHeight);
            this.bUT = 0L;
            this.bUV = 0L;
            if (i > 0 && i < 120) {
                this.bUR = i * 1000;
            } else {
                this.bUR = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Yu() {
        if (this.bVi != null) {
            this.bVi.cancel();
            this.bVi = null;
            this.bVj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bUZ.setAudioSampleRate(audioParams.getSampleRate());
            this.bUZ.setAudioFrameSize(audioParams.getFrameSize());
            this.bUZ.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bVk = false;
        this.bVa = true;
        Yu();
        this.bVi = new Timer();
        this.bVj = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bVk || b.this.bVl) {
                    b.this.c(b.this.bVh, 3840, System.nanoTime() - b.this.bVm);
                    b.this.bVl = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Yu();
                b.this.bVl = false;
            }
        };
        this.bVi.schedule(this.bVj, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bVf == null) {
            Yx();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bVe = new AudioParams();
        } else {
            this.bVe = audioParams;
        }
        if (this.bVd != null) {
            Log.i(TAG, "set audio engie:" + this.bVd);
            this.bVd.a(this.bVf);
        }
    }

    public void pauseRecord() {
        if (this.bUS) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bVa) {
            this.bUS = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bUU = System.nanoTime();
            this.bUT = 0L;
            if (this.bUX != null) {
                this.bUX.YB();
                this.bUT = (this.bUU - (this.bUV * TimeUtils.NANOS_PER_MS)) - this.bUX.Yz();
                if (this.bUT < 0) {
                    this.bUT = 0L;
                }
            }
            if (this.bVc != null) {
                this.bVc.onPause();
            }
            Yu();
        }
    }

    public void resumeRecord() {
        if (this.bUS) {
            this.bUT += System.nanoTime() - this.bUU;
            this.bUS = false;
            a((AudioParams) null);
            if (this.bVc != null) {
                this.bVc.onResume();
            }
        }
    }

    private void Yv() {
        if (this.bUS) {
            this.bUT += System.nanoTime() - this.bUU;
            this.bUS = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Yv();
        this.bVa = false;
        this.bVk = false;
        this.bVl = false;
        switch (this.bVb) {
            case 0:
                return;
            case 1:
            case 2:
                this.bVb = 0;
                if (this.bUX != null) {
                    this.bUX.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bVb);
        }
    }

    private void Yw() {
        if (this.bUZ != null && this.bUz != null) {
            int videoHeight = this.bUZ.getVideoHeight();
            int videoWidth = this.bUZ.getVideoWidth();
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
            this.bUZ.setVideoWidth(videoWidth);
            this.bUZ.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bUZ = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bUY = eVar;
    }

    private void Yx() {
        if (this.bVf == null) {
            this.bVf = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bUX != null && this.bVa && byteBuffer != null && i > 0 && !this.bUS) {
            this.bUX.onAudioFrameAvailable(byteBuffer, i, j - this.bUT);
        }
    }

    public void release() {
        if (this.bUX != null) {
            this.bUX.onDestroy();
            this.bUX = null;
        }
        if (this.bUY != null) {
            this.bUY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bVo;

        public a(b bVar) {
            this.bVo = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bVo.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bVo.get() != null) {
                this.bVo.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bVo.get() != null) {
                this.bVo.get().bVl = false;
                this.bVo.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bVo.get() != null) {
                this.bVo.get().Yu();
            }
        }
    }
}
