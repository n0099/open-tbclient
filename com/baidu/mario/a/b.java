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
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long bfP;
    private long bfQ;
    private long bfR;
    private com.baidu.mario.a.b.d bfV;
    private boolean bfW;
    private int bfX;
    private c bfY;
    private com.baidu.mario.gldraw2d.params.c bfr;
    private AudioParams bga;
    private com.baidu.mario.audio.a.a bgb;
    private Context mAppContext;
    private int bfN = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bfO = false;
    private boolean bfS = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bgc = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bgd = ByteBuffer.allocate(3840).put(this.bgc);
    private Timer bge = null;
    private TimerTask bgf = null;
    private boolean bgg = false;
    private boolean bgh = false;
    private long bgi = 0;
    private d bfT = d.IW();
    private com.baidu.mario.a.a bfZ = null;
    private e bfU = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bfY != null) {
                b.this.bfY.onStart();
                b.this.bgg = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aB(long j) {
            b.this.bfR = j;
            if (j > b.this.bfN && b.this.bfW) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bfR);
            if (b.this.bfY != null) {
                b.this.bfY.F((int) b.this.bfR, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bfY != null) {
                b.this.bfY.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bfU);
    }

    public void setGameRecordCallback(c cVar) {
        this.bfY = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bfZ = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bfr == null) {
                this.bfr = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bfr.a(eGLContext);
            }
            this.bfr.IG().setWidth(i);
            this.bfr.IG().setHeight(i2);
            if (z) {
                this.bfr.II().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bfV.setVideoWidth(i);
            this.bfV.setVideoHeight(i2);
        }
    }

    public void dt(int i) {
        if (this.bfr != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bfr.c(dVar);
                if (this.bfT != null) {
                    this.bfT.b(this.bfr);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.bfW && this.bfV != null) {
            switch (this.bfX) {
                case 0:
                    IU();
                    if (this.bfT != null) {
                        this.bfT.a(this.mAppContext, this.bfV, this.bfU);
                    }
                    this.bfX = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bfr.IF().setId(i);
                    if (this.bfT != null) {
                        this.bfT.c(this.bfr);
                    }
                    this.bfX = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bfX);
            }
        }
        if (this.bfT != null && !this.bfO) {
            this.bfT.onVideoFrameAvailable(j - this.bfP);
        }
    }

    public long IP() {
        return this.bfR;
    }

    public void IQ() {
        if (!this.bfO) {
            this.bfS = true;
            pauseRecord();
            return;
        }
        this.bfS = false;
    }

    public void IR() {
        if (this.bfO && this.bfS) {
            resumeRecord();
        }
        this.bfS = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bfW) {
            Log.i(TAG, "startRecored");
            this.bgi = System.nanoTime();
            this.mIsLandscape = z2;
            this.bfV.setOutputFile(str);
            this.bfV.setAudioIncluded(z);
            this.bfV.setOutputTotalMs(i * 1000);
            this.bfV.setVideoWidth(this.mCanvasWidth);
            this.bfV.setVideoHeight(this.mCanvasHeight);
            this.bfP = 0L;
            this.bfR = 0L;
            if (i > 0 && i < 120) {
                this.bfN = i * 1000;
            } else {
                this.bfN = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IS() {
        if (this.bge != null) {
            this.bge.cancel();
            this.bge = null;
            this.bgf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bfV.setAudioSampleRate(audioParams.getSampleRate());
            this.bfV.setAudioFrameSize(audioParams.getFrameSize());
            this.bfV.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bgg = false;
        this.bfW = true;
        IS();
        this.bge = new Timer();
        this.bgf = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bgg || b.this.bgh) {
                    b.this.c(b.this.bgd, 3840, System.nanoTime() - b.this.bgi);
                    b.this.bgh = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.IS();
                b.this.bgh = false;
            }
        };
        this.bge.schedule(this.bgf, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bgb == null) {
            IV();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bga = new AudioParams();
        } else {
            this.bga = audioParams;
        }
        if (this.bfZ != null) {
            Log.i(TAG, "set audio engie:" + this.bfZ);
            this.bfZ.a(this.bgb);
        }
    }

    public void pauseRecord() {
        if (this.bfO) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bfW) {
            this.bfO = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bfQ = System.nanoTime();
            this.bfP = 0L;
            if (this.bfT != null) {
                this.bfT.IZ();
                this.bfP = (this.bfQ - (this.bfR * TimeUtils.NANOS_PER_MS)) - this.bfT.IX();
                if (this.bfP < 0) {
                    this.bfP = 0L;
                }
            }
            if (this.bfY != null) {
                this.bfY.onPause();
            }
            IS();
        }
    }

    public void resumeRecord() {
        if (this.bfO) {
            this.bfP += System.nanoTime() - this.bfQ;
            this.bfO = false;
            a((AudioParams) null);
            if (this.bfY != null) {
                this.bfY.onResume();
            }
        }
    }

    private void IT() {
        if (this.bfO) {
            this.bfP += System.nanoTime() - this.bfQ;
            this.bfO = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        IT();
        this.bfW = false;
        this.bgg = false;
        this.bgh = false;
        switch (this.bfX) {
            case 0:
                return;
            case 1:
            case 2:
                this.bfX = 0;
                if (this.bfT != null) {
                    this.bfT.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bfX);
        }
    }

    private void IU() {
        if (this.bfV != null && this.bfr != null) {
            int videoHeight = this.bfV.getVideoHeight();
            int videoWidth = this.bfV.getVideoWidth();
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
            this.bfV.setVideoWidth(videoWidth);
            this.bfV.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bfV = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bfU = eVar;
    }

    private void IV() {
        if (this.bgb == null) {
            this.bgb = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bfT != null && this.bfW && byteBuffer != null && i > 0 && !this.bfO) {
            this.bfT.onAudioFrameAvailable(byteBuffer, i, j - this.bfP);
        }
    }

    public void release() {
        if (this.bfT != null) {
            this.bfT.onDestroy();
            this.bfT = null;
        }
        if (this.bfU != null) {
            this.bfU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bgk;

        public a(b bVar) {
            this.bgk = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bgk.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bgk.get() != null) {
                this.bgk.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bgk.get() != null) {
                this.bgk.get().bgh = false;
                this.bgk.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bgk.get() != null) {
                this.bgk.get().IS();
            }
        }
    }
}
