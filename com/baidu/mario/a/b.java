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
/* loaded from: classes3.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long cgS;
    private long cgT;
    private long cgU;
    private com.baidu.mario.a.b.d cgY;
    private boolean cgZ;
    private com.baidu.mario.gldraw2d.params.c cgy;
    private int cha;
    private c chb;
    private AudioParams chd;
    private com.baidu.mario.audio.a.a che;
    private Context mAppContext;
    private int cgQ = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean cgR = false;
    private boolean cgV = false;
    private boolean mIsLandscape = false;
    private int adt = 0;
    private int adu = 0;
    private byte[] chf = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer chg = ByteBuffer.allocate(3840).put(this.chf);
    private Timer chh = null;
    private TimerTask chi = null;
    private boolean chj = false;
    private boolean chk = false;
    private long chl = 0;
    private d cgW = d.acN();
    private com.baidu.mario.a.a chc = null;
    private e cgX = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.chb != null) {
                b.this.chb.onStart();
                b.this.chj = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bF(long j) {
            b.this.cgU = j;
            if (j > b.this.cgQ && b.this.cgZ) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.cgU);
            if (b.this.chb != null) {
                b.this.chb.aa((int) b.this.cgU, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.chb != null) {
                b.this.chb.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.cgX);
    }

    public void setGameRecordCallback(c cVar) {
        this.chb = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.chc = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.cgy == null) {
                this.cgy = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.cgy.a(eGLContext);
            }
            this.cgy.acx().setWidth(i);
            this.cgy.acx().setHeight(i2);
            if (z) {
                this.cgy.acz().a(MirrorType.VERTICALLY);
            }
            this.adt = i;
            this.adu = i2;
            this.cgY.setVideoWidth(i);
            this.cgY.setVideoHeight(i2);
        }
    }

    public void gY(int i) {
        if (this.cgy != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.cgy.c(dVar);
                if (this.cgW != null) {
                    this.cgW.b(this.cgy);
                }
                this.mTextureId = i;
            }
            h(this.mTextureId, System.nanoTime());
        }
    }

    private void h(int i, long j) {
        if (this.cgZ && this.cgY != null) {
            switch (this.cha) {
                case 0:
                    acL();
                    if (this.cgW != null) {
                        this.cgW.a(this.mAppContext, this.cgY, this.cgX);
                    }
                    this.cha = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.cgy.acw().setId(i);
                    if (this.cgW != null) {
                        this.cgW.c(this.cgy);
                    }
                    this.cha = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.cha);
            }
        }
        if (this.cgW != null && !this.cgR) {
            this.cgW.onVideoFrameAvailable(j - this.cgS);
        }
    }

    public long acG() {
        return this.cgU;
    }

    public void acH() {
        if (!this.cgR) {
            this.cgV = true;
            pauseRecord();
            return;
        }
        this.cgV = false;
    }

    public void acI() {
        if (this.cgR && this.cgV) {
            resumeRecord();
        }
        this.cgV = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.cgZ) {
            Log.i(TAG, "startRecored");
            this.chl = System.nanoTime();
            this.mIsLandscape = z2;
            this.cgY.setOutputFile(str);
            this.cgY.setAudioIncluded(z);
            this.cgY.setOutputTotalMs(i * 1000);
            this.cgY.setVideoWidth(this.adt);
            this.cgY.setVideoHeight(this.adu);
            this.cgS = 0L;
            this.cgU = 0L;
            if (i > 0 && i < 120) {
                this.cgQ = i * 1000;
            } else {
                this.cgQ = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void acJ() {
        if (this.chh != null) {
            this.chh.cancel();
            this.chh = null;
            this.chi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.cgY.setAudioSampleRate(audioParams.getSampleRate());
            this.cgY.setAudioFrameSize(audioParams.getFrameSize());
            this.cgY.setAudioChannel(audioParams.getChannelConfig());
        }
        this.chj = false;
        this.cgZ = true;
        acJ();
        this.chh = new Timer();
        this.chi = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.chj || b.this.chk) {
                    b.this.c(b.this.chg, 3840, System.nanoTime() - b.this.chl);
                    b.this.chk = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.acJ();
                b.this.chk = false;
            }
        };
        this.chh.schedule(this.chi, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.che == null) {
            acM();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.chd = new AudioParams();
        } else {
            this.chd = audioParams;
        }
        if (this.chc != null) {
            Log.i(TAG, "set audio engie:" + this.chc);
            this.chc.a(this.che);
        }
    }

    public void pauseRecord() {
        if (this.cgR) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.cgZ) {
            this.cgR = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.cgT = System.nanoTime();
            this.cgS = 0L;
            if (this.cgW != null) {
                this.cgW.acQ();
                this.cgS = (this.cgT - (this.cgU * TimeUtils.NANOS_PER_MS)) - this.cgW.acO();
                if (this.cgS < 0) {
                    this.cgS = 0L;
                }
            }
            if (this.chb != null) {
                this.chb.onPause();
            }
            acJ();
        }
    }

    public void resumeRecord() {
        if (this.cgR) {
            this.cgS += System.nanoTime() - this.cgT;
            this.cgR = false;
            a((AudioParams) null);
            if (this.chb != null) {
                this.chb.onResume();
            }
        }
    }

    private void acK() {
        if (this.cgR) {
            this.cgS += System.nanoTime() - this.cgT;
            this.cgR = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        acK();
        this.cgZ = false;
        this.chj = false;
        this.chk = false;
        switch (this.cha) {
            case 0:
                return;
            case 1:
            case 2:
                this.cha = 0;
                if (this.cgW != null) {
                    this.cgW.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.cha);
        }
    }

    private void acL() {
        if (this.cgY != null && this.cgy != null) {
            int videoHeight = this.cgY.getVideoHeight();
            int videoWidth = this.cgY.getVideoWidth();
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
            this.cgY.setVideoWidth(videoWidth);
            this.cgY.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.cgY = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.cgX = eVar;
    }

    private void acM() {
        if (this.che == null) {
            this.che = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.cgW != null && this.cgZ && byteBuffer != null && i > 0 && !this.cgR) {
            this.cgW.onAudioFrameAvailable(byteBuffer, i, j - this.cgS);
        }
    }

    public void release() {
        if (this.cgW != null) {
            this.cgW.onDestroy();
            this.cgW = null;
        }
        if (this.cgX != null) {
            this.cgX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> chn;

        public a(b bVar) {
            this.chn = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.chn.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.chn.get() != null) {
                this.chn.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.chn.get() != null) {
                this.chn.get().chk = false;
                this.chn.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.chn.get() != null) {
                this.chn.get().acJ();
            }
        }
    }
}
