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
    private long bfK;
    private long bfL;
    private long bfM;
    private com.baidu.mario.a.b.d bfQ;
    private boolean bfR;
    private int bfS;
    private c bfT;
    private AudioParams bfV;
    private com.baidu.mario.audio.a.a bfW;
    private com.baidu.mario.gldraw2d.params.c bfm;
    private Context mAppContext;
    private int bfI = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bfJ = false;
    private boolean bfN = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bfX = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bfY = ByteBuffer.allocate(3840).put(this.bfX);
    private Timer bfZ = null;
    private TimerTask bga = null;
    private boolean bgb = false;
    private boolean bgc = false;
    private long bgd = 0;
    private d bfO = d.IX();
    private com.baidu.mario.a.a bfU = null;
    private e bfP = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bfT != null) {
                b.this.bfT.onStart();
                b.this.bgb = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aB(long j) {
            b.this.bfM = j;
            if (j > b.this.bfI && b.this.bfR) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bfM);
            if (b.this.bfT != null) {
                b.this.bfT.F((int) b.this.bfM, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bfT != null) {
                b.this.bfT.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bfP);
    }

    public void setGameRecordCallback(c cVar) {
        this.bfT = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bfU = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bfm == null) {
                this.bfm = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bfm.a(eGLContext);
            }
            this.bfm.IH().setWidth(i);
            this.bfm.IH().setHeight(i2);
            if (z) {
                this.bfm.IJ().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bfQ.setVideoWidth(i);
            this.bfQ.setVideoHeight(i2);
        }
    }

    public void dt(int i) {
        if (this.bfm != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bfm.c(dVar);
                if (this.bfO != null) {
                    this.bfO.b(this.bfm);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.bfR && this.bfQ != null) {
            switch (this.bfS) {
                case 0:
                    IV();
                    if (this.bfO != null) {
                        this.bfO.a(this.mAppContext, this.bfQ, this.bfP);
                    }
                    this.bfS = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bfm.IG().setId(i);
                    if (this.bfO != null) {
                        this.bfO.c(this.bfm);
                    }
                    this.bfS = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bfS);
            }
        }
        if (this.bfO != null && !this.bfJ) {
            this.bfO.onVideoFrameAvailable(j - this.bfK);
        }
    }

    public long IQ() {
        return this.bfM;
    }

    public void IR() {
        if (!this.bfJ) {
            this.bfN = true;
            pauseRecord();
            return;
        }
        this.bfN = false;
    }

    public void IS() {
        if (this.bfJ && this.bfN) {
            resumeRecord();
        }
        this.bfN = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bfR) {
            Log.i(TAG, "startRecored");
            this.bgd = System.nanoTime();
            this.mIsLandscape = z2;
            this.bfQ.setOutputFile(str);
            this.bfQ.setAudioIncluded(z);
            this.bfQ.setOutputTotalMs(i * 1000);
            this.bfQ.setVideoWidth(this.mCanvasWidth);
            this.bfQ.setVideoHeight(this.mCanvasHeight);
            this.bfK = 0L;
            this.bfM = 0L;
            if (i > 0 && i < 120) {
                this.bfI = i * 1000;
            } else {
                this.bfI = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IT() {
        if (this.bfZ != null) {
            this.bfZ.cancel();
            this.bfZ = null;
            this.bga = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bfQ.setAudioSampleRate(audioParams.getSampleRate());
            this.bfQ.setAudioFrameSize(audioParams.getFrameSize());
            this.bfQ.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bgb = false;
        this.bfR = true;
        IT();
        this.bfZ = new Timer();
        this.bga = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bgb || b.this.bgc) {
                    b.this.c(b.this.bfY, 3840, System.nanoTime() - b.this.bgd);
                    b.this.bgc = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.IT();
                b.this.bgc = false;
            }
        };
        this.bfZ.schedule(this.bga, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bfW == null) {
            IW();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bfV = new AudioParams();
        } else {
            this.bfV = audioParams;
        }
        if (this.bfU != null) {
            Log.i(TAG, "set audio engie:" + this.bfU);
            this.bfU.a(this.bfW);
        }
    }

    public void pauseRecord() {
        if (this.bfJ) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bfR) {
            this.bfJ = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bfL = System.nanoTime();
            this.bfK = 0L;
            if (this.bfO != null) {
                this.bfO.Ja();
                this.bfK = (this.bfL - (this.bfM * TimeUtils.NANOS_PER_MS)) - this.bfO.IY();
                if (this.bfK < 0) {
                    this.bfK = 0L;
                }
            }
            if (this.bfT != null) {
                this.bfT.onPause();
            }
            IT();
        }
    }

    public void resumeRecord() {
        if (this.bfJ) {
            this.bfK += System.nanoTime() - this.bfL;
            this.bfJ = false;
            a((AudioParams) null);
            if (this.bfT != null) {
                this.bfT.onResume();
            }
        }
    }

    private void IU() {
        if (this.bfJ) {
            this.bfK += System.nanoTime() - this.bfL;
            this.bfJ = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        IU();
        this.bfR = false;
        this.bgb = false;
        this.bgc = false;
        switch (this.bfS) {
            case 0:
                return;
            case 1:
            case 2:
                this.bfS = 0;
                if (this.bfO != null) {
                    this.bfO.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bfS);
        }
    }

    private void IV() {
        if (this.bfQ != null && this.bfm != null) {
            int videoHeight = this.bfQ.getVideoHeight();
            int videoWidth = this.bfQ.getVideoWidth();
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
            this.bfQ.setVideoWidth(videoWidth);
            this.bfQ.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bfQ = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bfP = eVar;
    }

    private void IW() {
        if (this.bfW == null) {
            this.bfW = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bfO != null && this.bfR && byteBuffer != null && i > 0 && !this.bfJ) {
            this.bfO.onAudioFrameAvailable(byteBuffer, i, j - this.bfK);
        }
    }

    public void release() {
        if (this.bfO != null) {
            this.bfO.onDestroy();
            this.bfO = null;
        }
        if (this.bfP != null) {
            this.bfP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bgf;

        public a(b bVar) {
            this.bgf = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bgf.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bgf.get() != null) {
                this.bgf.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bgf.get() != null) {
                this.bgf.get().bgc = false;
                this.bgf.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bgf.get() != null) {
                this.bgf.get().IT();
            }
        }
    }
}
