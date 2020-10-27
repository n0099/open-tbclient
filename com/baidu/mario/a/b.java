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
    private long bQT;
    private long bQU;
    private long bQV;
    private com.baidu.mario.a.b.d bQZ;
    private com.baidu.mario.gldraw2d.params.c bQz;
    private boolean bRa;
    private int bRb;
    private c bRc;
    private AudioParams bRe;
    private com.baidu.mario.audio.a.a bRf;
    private Context mAppContext;
    private int bQR = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bQS = false;
    private boolean bQW = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bRg = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bRh = ByteBuffer.allocate(3840).put(this.bRg);
    private Timer bRi = null;
    private TimerTask bRj = null;
    private boolean bRk = false;
    private boolean bRl = false;
    private long bRm = 0;
    private d bQX = d.WI();
    private com.baidu.mario.a.a bRd = null;
    private e bQY = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bRc != null) {
                b.this.bRc.onStart();
                b.this.bRk = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aL(long j) {
            b.this.bQV = j;
            if (j > b.this.bQR && b.this.bRa) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bQV);
            if (b.this.bRc != null) {
                b.this.bRc.U((int) b.this.bQV, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bRc != null) {
                b.this.bRc.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bQY);
    }

    public void setGameRecordCallback(c cVar) {
        this.bRc = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bRd = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bQz == null) {
                this.bQz = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bQz.a(eGLContext);
            }
            this.bQz.Ws().setWidth(i);
            this.bQz.Ws().setHeight(i2);
            if (z) {
                this.bQz.Wu().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bQZ.setVideoWidth(i);
            this.bQZ.setVideoHeight(i2);
        }
    }

    public void gt(int i) {
        if (this.bQz != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bQz.c(dVar);
                if (this.bQX != null) {
                    this.bQX.b(this.bQz);
                }
                this.mTextureId = i;
            }
            f(this.mTextureId, System.nanoTime());
        }
    }

    private void f(int i, long j) {
        if (this.bRa && this.bQZ != null) {
            switch (this.bRb) {
                case 0:
                    WG();
                    if (this.bQX != null) {
                        this.bQX.a(this.mAppContext, this.bQZ, this.bQY);
                    }
                    this.bRb = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bQz.Wr().setId(i);
                    if (this.bQX != null) {
                        this.bQX.c(this.bQz);
                    }
                    this.bRb = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bRb);
            }
        }
        if (this.bQX != null && !this.bQS) {
            this.bQX.onVideoFrameAvailable(j - this.bQT);
        }
    }

    public long WB() {
        return this.bQV;
    }

    public void WC() {
        if (!this.bQS) {
            this.bQW = true;
            pauseRecord();
            return;
        }
        this.bQW = false;
    }

    public void WD() {
        if (this.bQS && this.bQW) {
            resumeRecord();
        }
        this.bQW = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bRa) {
            Log.i(TAG, "startRecored");
            this.bRm = System.nanoTime();
            this.mIsLandscape = z2;
            this.bQZ.setOutputFile(str);
            this.bQZ.setAudioIncluded(z);
            this.bQZ.setOutputTotalMs(i * 1000);
            this.bQZ.setVideoWidth(this.mCanvasWidth);
            this.bQZ.setVideoHeight(this.mCanvasHeight);
            this.bQT = 0L;
            this.bQV = 0L;
            if (i > 0 && i < 120) {
                this.bQR = i * 1000;
            } else {
                this.bQR = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WE() {
        if (this.bRi != null) {
            this.bRi.cancel();
            this.bRi = null;
            this.bRj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bQZ.setAudioSampleRate(audioParams.getSampleRate());
            this.bQZ.setAudioFrameSize(audioParams.getFrameSize());
            this.bQZ.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bRk = false;
        this.bRa = true;
        WE();
        this.bRi = new Timer();
        this.bRj = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bRk || b.this.bRl) {
                    b.this.c(b.this.bRh, 3840, System.nanoTime() - b.this.bRm);
                    b.this.bRl = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.WE();
                b.this.bRl = false;
            }
        };
        this.bRi.schedule(this.bRj, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bRf == null) {
            WH();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bRe = new AudioParams();
        } else {
            this.bRe = audioParams;
        }
        if (this.bRd != null) {
            Log.i(TAG, "set audio engie:" + this.bRd);
            this.bRd.a(this.bRf);
        }
    }

    public void pauseRecord() {
        if (this.bQS) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bRa) {
            this.bQS = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bQU = System.nanoTime();
            this.bQT = 0L;
            if (this.bQX != null) {
                this.bQX.WL();
                this.bQT = (this.bQU - (this.bQV * TimeUtils.NANOS_PER_MS)) - this.bQX.WJ();
                if (this.bQT < 0) {
                    this.bQT = 0L;
                }
            }
            if (this.bRc != null) {
                this.bRc.onPause();
            }
            WE();
        }
    }

    public void resumeRecord() {
        if (this.bQS) {
            this.bQT += System.nanoTime() - this.bQU;
            this.bQS = false;
            a((AudioParams) null);
            if (this.bRc != null) {
                this.bRc.onResume();
            }
        }
    }

    private void WF() {
        if (this.bQS) {
            this.bQT += System.nanoTime() - this.bQU;
            this.bQS = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        WF();
        this.bRa = false;
        this.bRk = false;
        this.bRl = false;
        switch (this.bRb) {
            case 0:
                return;
            case 1:
            case 2:
                this.bRb = 0;
                if (this.bQX != null) {
                    this.bQX.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bRb);
        }
    }

    private void WG() {
        if (this.bQZ != null && this.bQz != null) {
            int videoHeight = this.bQZ.getVideoHeight();
            int videoWidth = this.bQZ.getVideoWidth();
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
            this.bQZ.setVideoWidth(videoWidth);
            this.bQZ.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bQZ = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bQY = eVar;
    }

    private void WH() {
        if (this.bRf == null) {
            this.bRf = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bQX != null && this.bRa && byteBuffer != null && i > 0 && !this.bQS) {
            this.bQX.onAudioFrameAvailable(byteBuffer, i, j - this.bQT);
        }
    }

    public void release() {
        if (this.bQX != null) {
            this.bQX.onDestroy();
            this.bQX = null;
        }
        if (this.bQY != null) {
            this.bQY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bRo;

        public a(b bVar) {
            this.bRo = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bRo.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bRo.get() != null) {
                this.bRo.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bRo.get() != null) {
                this.bRo.get().bRl = false;
                this.bRo.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bRo.get() != null) {
                this.bRo.get().WE();
            }
        }
    }
}
