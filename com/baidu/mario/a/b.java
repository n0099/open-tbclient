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
/* loaded from: classes15.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.params.c cfU;
    private com.baidu.mario.audio.a.a cgA;
    private long cgo;
    private long cgp;
    private long cgq;
    private com.baidu.mario.a.b.d cgu;
    private boolean cgv;
    private int cgw;
    private c cgx;
    private AudioParams cgz;
    private Context mAppContext;
    private int cgm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean cgn = false;
    private boolean cgr = false;
    private boolean mIsLandscape = false;
    private int adl = 0;
    private int adm = 0;
    private byte[] cgB = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer cgC = ByteBuffer.allocate(3840).put(this.cgB);
    private Timer cgD = null;
    private TimerTask cgE = null;
    private boolean cgF = false;
    private boolean cgG = false;
    private long cgH = 0;
    private d cgs = d.aaN();
    private com.baidu.mario.a.a cgy = null;
    private e cgt = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.cgx != null) {
                b.this.cgx.onStart();
                b.this.cgF = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bJ(long j) {
            b.this.cgq = j;
            if (j > b.this.cgm && b.this.cgv) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.cgq);
            if (b.this.cgx != null) {
                b.this.cgx.af((int) b.this.cgq, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.cgx != null) {
                b.this.cgx.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.cgt);
    }

    public void setGameRecordCallback(c cVar) {
        this.cgx = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.cgy = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.cfU == null) {
                this.cfU = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.cfU.a(eGLContext);
            }
            this.cfU.aax().setWidth(i);
            this.cfU.aax().setHeight(i2);
            if (z) {
                this.cfU.aaz().a(MirrorType.VERTICALLY);
            }
            this.adl = i;
            this.adm = i2;
            this.cgu.setVideoWidth(i);
            this.cgu.setVideoHeight(i2);
        }
    }

    public void fx(int i) {
        if (this.cfU != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.cfU.c(dVar);
                if (this.cgs != null) {
                    this.cgs.b(this.cfU);
                }
                this.mTextureId = i;
            }
            i(this.mTextureId, System.nanoTime());
        }
    }

    private void i(int i, long j) {
        if (this.cgv && this.cgu != null) {
            switch (this.cgw) {
                case 0:
                    aaL();
                    if (this.cgs != null) {
                        this.cgs.a(this.mAppContext, this.cgu, this.cgt);
                    }
                    this.cgw = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.cfU.aaw().setId(i);
                    if (this.cgs != null) {
                        this.cgs.c(this.cfU);
                    }
                    this.cgw = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.cgw);
            }
        }
        if (this.cgs != null && !this.cgn) {
            this.cgs.onVideoFrameAvailable(j - this.cgo);
        }
    }

    public long aaG() {
        return this.cgq;
    }

    public void aaH() {
        if (!this.cgn) {
            this.cgr = true;
            pauseRecord();
            return;
        }
        this.cgr = false;
    }

    public void aaI() {
        if (this.cgn && this.cgr) {
            resumeRecord();
        }
        this.cgr = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.cgv) {
            Log.i(TAG, "startRecored");
            this.cgH = System.nanoTime();
            this.mIsLandscape = z2;
            this.cgu.setOutputFile(str);
            this.cgu.setAudioIncluded(z);
            this.cgu.setOutputTotalMs(i * 1000);
            this.cgu.setVideoWidth(this.adl);
            this.cgu.setVideoHeight(this.adm);
            this.cgo = 0L;
            this.cgq = 0L;
            if (i > 0 && i < 120) {
                this.cgm = i * 1000;
            } else {
                this.cgm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaJ() {
        if (this.cgD != null) {
            this.cgD.cancel();
            this.cgD = null;
            this.cgE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.cgu.setAudioSampleRate(audioParams.getSampleRate());
            this.cgu.setAudioFrameSize(audioParams.getFrameSize());
            this.cgu.setAudioChannel(audioParams.getChannelConfig());
        }
        this.cgF = false;
        this.cgv = true;
        aaJ();
        this.cgD = new Timer();
        this.cgE = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.cgF || b.this.cgG) {
                    b.this.c(b.this.cgC, 3840, System.nanoTime() - b.this.cgH);
                    b.this.cgG = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.aaJ();
                b.this.cgG = false;
            }
        };
        this.cgD.schedule(this.cgE, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.cgA == null) {
            aaM();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.cgz = new AudioParams();
        } else {
            this.cgz = audioParams;
        }
        if (this.cgy != null) {
            Log.i(TAG, "set audio engie:" + this.cgy);
            this.cgy.a(this.cgA);
        }
    }

    public void pauseRecord() {
        if (this.cgn) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.cgv) {
            this.cgn = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.cgp = System.nanoTime();
            this.cgo = 0L;
            if (this.cgs != null) {
                this.cgs.aaQ();
                this.cgo = (this.cgp - (this.cgq * TimeUtils.NANOS_PER_MS)) - this.cgs.aaO();
                if (this.cgo < 0) {
                    this.cgo = 0L;
                }
            }
            if (this.cgx != null) {
                this.cgx.onPause();
            }
            aaJ();
        }
    }

    public void resumeRecord() {
        if (this.cgn) {
            this.cgo += System.nanoTime() - this.cgp;
            this.cgn = false;
            a((AudioParams) null);
            if (this.cgx != null) {
                this.cgx.onResume();
            }
        }
    }

    private void aaK() {
        if (this.cgn) {
            this.cgo += System.nanoTime() - this.cgp;
            this.cgn = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        aaK();
        this.cgv = false;
        this.cgF = false;
        this.cgG = false;
        switch (this.cgw) {
            case 0:
                return;
            case 1:
            case 2:
                this.cgw = 0;
                if (this.cgs != null) {
                    this.cgs.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.cgw);
        }
    }

    private void aaL() {
        if (this.cgu != null && this.cfU != null) {
            int videoHeight = this.cgu.getVideoHeight();
            int videoWidth = this.cgu.getVideoWidth();
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
            this.cgu.setVideoWidth(videoWidth);
            this.cgu.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.cgu = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.cgt = eVar;
    }

    private void aaM() {
        if (this.cgA == null) {
            this.cgA = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.cgs != null && this.cgv && byteBuffer != null && i > 0 && !this.cgn) {
            this.cgs.onAudioFrameAvailable(byteBuffer, i, j - this.cgo);
        }
    }

    public void release() {
        if (this.cgs != null) {
            this.cgs.onDestroy();
            this.cgs = null;
        }
        if (this.cgt != null) {
            this.cgt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> cgJ;

        public a(b bVar) {
            this.cgJ = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.cgJ.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.cgJ.get() != null) {
                this.cgJ.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.cgJ.get() != null) {
                this.cgJ.get().cgG = false;
                this.cgJ.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.cgJ.get() != null) {
                this.cgJ.get().aaJ();
            }
        }
    }
}
