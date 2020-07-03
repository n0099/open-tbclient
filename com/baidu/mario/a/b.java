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
    private com.baidu.mario.gldraw2d.params.c brR;
    private com.baidu.mario.audio.a.a bsA;
    private long bso;
    private long bsp;
    private long bsq;
    private com.baidu.mario.a.b.d bsu;
    private boolean bsv;
    private int bsw;
    private c bsx;
    private AudioParams bsz;
    private Context mAppContext;
    private int bsm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bsn = false;
    private boolean bsr = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bsB = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bsC = ByteBuffer.allocate(3840).put(this.bsB);
    private Timer bsD = null;
    private TimerTask bsE = null;
    private boolean bsF = false;
    private boolean bsG = false;
    private long bsH = 0;
    private d bss = d.LY();
    private com.baidu.mario.a.a bsy = null;
    private e bst = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bsx != null) {
                b.this.bsx.onStart();
                b.this.bsF = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aG(long j) {
            b.this.bsq = j;
            if (j > b.this.bsm && b.this.bsv) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bsq);
            if (b.this.bsx != null) {
                b.this.bsx.H((int) b.this.bsq, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bsx != null) {
                b.this.bsx.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bst);
    }

    public void setGameRecordCallback(c cVar) {
        this.bsx = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bsy = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.brR == null) {
                this.brR = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.brR.a(eGLContext);
            }
            this.brR.LI().setWidth(i);
            this.brR.LI().setHeight(i2);
            if (z) {
                this.brR.LK().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bsu.setVideoWidth(i);
            this.bsu.setVideoHeight(i2);
        }
    }

    public void dK(int i) {
        if (this.brR != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.brR.c(dVar);
                if (this.bss != null) {
                    this.bss.b(this.brR);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.bsv && this.bsu != null) {
            switch (this.bsw) {
                case 0:
                    LW();
                    if (this.bss != null) {
                        this.bss.a(this.mAppContext, this.bsu, this.bst);
                    }
                    this.bsw = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.brR.LH().setId(i);
                    if (this.bss != null) {
                        this.bss.c(this.brR);
                    }
                    this.bsw = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bsw);
            }
        }
        if (this.bss != null && !this.bsn) {
            this.bss.onVideoFrameAvailable(j - this.bso);
        }
    }

    public long LR() {
        return this.bsq;
    }

    public void LS() {
        if (!this.bsn) {
            this.bsr = true;
            pauseRecord();
            return;
        }
        this.bsr = false;
    }

    public void LT() {
        if (this.bsn && this.bsr) {
            resumeRecord();
        }
        this.bsr = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bsv) {
            Log.i(TAG, "startRecored");
            this.bsH = System.nanoTime();
            this.mIsLandscape = z2;
            this.bsu.setOutputFile(str);
            this.bsu.setAudioIncluded(z);
            this.bsu.setOutputTotalMs(i * 1000);
            this.bsu.setVideoWidth(this.mCanvasWidth);
            this.bsu.setVideoHeight(this.mCanvasHeight);
            this.bso = 0L;
            this.bsq = 0L;
            if (i > 0 && i < 120) {
                this.bsm = i * 1000;
            } else {
                this.bsm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void LU() {
        if (this.bsD != null) {
            this.bsD.cancel();
            this.bsD = null;
            this.bsE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bsu.setAudioSampleRate(audioParams.getSampleRate());
            this.bsu.setAudioFrameSize(audioParams.getFrameSize());
            this.bsu.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bsF = false;
        this.bsv = true;
        LU();
        this.bsD = new Timer();
        this.bsE = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bsF || b.this.bsG) {
                    b.this.c(b.this.bsC, 3840, System.nanoTime() - b.this.bsH);
                    b.this.bsG = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.LU();
                b.this.bsG = false;
            }
        };
        this.bsD.schedule(this.bsE, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bsA == null) {
            LX();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bsz = new AudioParams();
        } else {
            this.bsz = audioParams;
        }
        if (this.bsy != null) {
            Log.i(TAG, "set audio engie:" + this.bsy);
            this.bsy.a(this.bsA);
        }
    }

    public void pauseRecord() {
        if (this.bsn) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bsv) {
            this.bsn = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bsp = System.nanoTime();
            this.bso = 0L;
            if (this.bss != null) {
                this.bss.Mb();
                this.bso = (this.bsp - (this.bsq * TimeUtils.NANOS_PER_MS)) - this.bss.LZ();
                if (this.bso < 0) {
                    this.bso = 0L;
                }
            }
            if (this.bsx != null) {
                this.bsx.onPause();
            }
            LU();
        }
    }

    public void resumeRecord() {
        if (this.bsn) {
            this.bso += System.nanoTime() - this.bsp;
            this.bsn = false;
            a((AudioParams) null);
            if (this.bsx != null) {
                this.bsx.onResume();
            }
        }
    }

    private void LV() {
        if (this.bsn) {
            this.bso += System.nanoTime() - this.bsp;
            this.bsn = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        LV();
        this.bsv = false;
        this.bsF = false;
        this.bsG = false;
        switch (this.bsw) {
            case 0:
                return;
            case 1:
            case 2:
                this.bsw = 0;
                if (this.bss != null) {
                    this.bss.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bsw);
        }
    }

    private void LW() {
        if (this.bsu != null && this.brR != null) {
            int videoHeight = this.bsu.getVideoHeight();
            int videoWidth = this.bsu.getVideoWidth();
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
            this.bsu.setVideoWidth(videoWidth);
            this.bsu.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bsu = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bst = eVar;
    }

    private void LX() {
        if (this.bsA == null) {
            this.bsA = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bss != null && this.bsv && byteBuffer != null && i > 0 && !this.bsn) {
            this.bss.onAudioFrameAvailable(byteBuffer, i, j - this.bso);
        }
    }

    public void release() {
        if (this.bss != null) {
            this.bss.onDestroy();
            this.bss = null;
        }
        if (this.bst != null) {
            this.bst = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bsJ;

        public a(b bVar) {
            this.bsJ = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bsJ.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bsJ.get() != null) {
                this.bsJ.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bsJ.get() != null) {
                this.bsJ.get().bsG = false;
                this.bsJ.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bsJ.get() != null) {
                this.bsJ.get().LU();
            }
        }
    }
}
