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
/* loaded from: classes4.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.params.c bBC;
    private long bBW;
    private long bBX;
    private long bBY;
    private com.baidu.mario.a.b.d bCc;
    private boolean bCd;
    private int bCe;
    private c bCf;
    private AudioParams bCh;
    private com.baidu.mario.audio.a.a bCi;
    private Context mAppContext;
    private int bBU = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bBV = false;
    private boolean bBZ = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bCj = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bCk = ByteBuffer.allocate(3840).put(this.bCj);
    private Timer bCl = null;
    private TimerTask bCm = null;
    private boolean bCn = false;
    private boolean bCo = false;
    private long bCp = 0;
    private d bCa = d.SV();
    private com.baidu.mario.a.a bCg = null;
    private e bCb = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bCf != null) {
                b.this.bCf.onStart();
                b.this.bCn = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aH(long j) {
            b.this.bBY = j;
            if (j > b.this.bBU && b.this.bCd) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bBY);
            if (b.this.bCf != null) {
                b.this.bCf.H((int) b.this.bBY, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bCf != null) {
                b.this.bCf.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bCb);
    }

    public void setGameRecordCallback(c cVar) {
        this.bCf = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bCg = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bBC == null) {
                this.bBC = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bBC.a(eGLContext);
            }
            this.bBC.SF().setWidth(i);
            this.bBC.SF().setHeight(i2);
            if (z) {
                this.bBC.SH().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bCc.setVideoWidth(i);
            this.bCc.setVideoHeight(i2);
        }
    }

    public void fO(int i) {
        if (this.bBC != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bBC.c(dVar);
                if (this.bCa != null) {
                    this.bCa.b(this.bBC);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.bCd && this.bCc != null) {
            switch (this.bCe) {
                case 0:
                    ST();
                    if (this.bCa != null) {
                        this.bCa.a(this.mAppContext, this.bCc, this.bCb);
                    }
                    this.bCe = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bBC.SE().setId(i);
                    if (this.bCa != null) {
                        this.bCa.c(this.bBC);
                    }
                    this.bCe = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bCe);
            }
        }
        if (this.bCa != null && !this.bBV) {
            this.bCa.onVideoFrameAvailable(j - this.bBW);
        }
    }

    public long SO() {
        return this.bBY;
    }

    public void SP() {
        if (!this.bBV) {
            this.bBZ = true;
            pauseRecord();
            return;
        }
        this.bBZ = false;
    }

    public void SQ() {
        if (this.bBV && this.bBZ) {
            resumeRecord();
        }
        this.bBZ = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bCd) {
            Log.i(TAG, "startRecored");
            this.bCp = System.nanoTime();
            this.mIsLandscape = z2;
            this.bCc.setOutputFile(str);
            this.bCc.setAudioIncluded(z);
            this.bCc.setOutputTotalMs(i * 1000);
            this.bCc.setVideoWidth(this.mCanvasWidth);
            this.bCc.setVideoHeight(this.mCanvasHeight);
            this.bBW = 0L;
            this.bBY = 0L;
            if (i > 0 && i < 120) {
                this.bBU = i * 1000;
            } else {
                this.bBU = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void SR() {
        if (this.bCl != null) {
            this.bCl.cancel();
            this.bCl = null;
            this.bCm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bCc.setAudioSampleRate(audioParams.getSampleRate());
            this.bCc.setAudioFrameSize(audioParams.getFrameSize());
            this.bCc.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bCn = false;
        this.bCd = true;
        SR();
        this.bCl = new Timer();
        this.bCm = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bCn || b.this.bCo) {
                    b.this.c(b.this.bCk, 3840, System.nanoTime() - b.this.bCp);
                    b.this.bCo = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.SR();
                b.this.bCo = false;
            }
        };
        this.bCl.schedule(this.bCm, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bCi == null) {
            SU();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bCh = new AudioParams();
        } else {
            this.bCh = audioParams;
        }
        if (this.bCg != null) {
            Log.i(TAG, "set audio engie:" + this.bCg);
            this.bCg.a(this.bCi);
        }
    }

    public void pauseRecord() {
        if (this.bBV) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bCd) {
            this.bBV = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bBX = System.nanoTime();
            this.bBW = 0L;
            if (this.bCa != null) {
                this.bCa.SY();
                this.bBW = (this.bBX - (this.bBY * TimeUtils.NANOS_PER_MS)) - this.bCa.SW();
                if (this.bBW < 0) {
                    this.bBW = 0L;
                }
            }
            if (this.bCf != null) {
                this.bCf.onPause();
            }
            SR();
        }
    }

    public void resumeRecord() {
        if (this.bBV) {
            this.bBW += System.nanoTime() - this.bBX;
            this.bBV = false;
            a((AudioParams) null);
            if (this.bCf != null) {
                this.bCf.onResume();
            }
        }
    }

    private void SS() {
        if (this.bBV) {
            this.bBW += System.nanoTime() - this.bBX;
            this.bBV = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        SS();
        this.bCd = false;
        this.bCn = false;
        this.bCo = false;
        switch (this.bCe) {
            case 0:
                return;
            case 1:
            case 2:
                this.bCe = 0;
                if (this.bCa != null) {
                    this.bCa.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bCe);
        }
    }

    private void ST() {
        if (this.bCc != null && this.bBC != null) {
            int videoHeight = this.bCc.getVideoHeight();
            int videoWidth = this.bCc.getVideoWidth();
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
            this.bCc.setVideoWidth(videoWidth);
            this.bCc.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bCc = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bCb = eVar;
    }

    private void SU() {
        if (this.bCi == null) {
            this.bCi = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bCa != null && this.bCd && byteBuffer != null && i > 0 && !this.bBV) {
            this.bCa.onAudioFrameAvailable(byteBuffer, i, j - this.bBW);
        }
    }

    public void release() {
        if (this.bCa != null) {
            this.bCa.onDestroy();
            this.bCa = null;
        }
        if (this.bCb != null) {
            this.bCb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bCr;

        public a(b bVar) {
            this.bCr = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bCr.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bCr.get() != null) {
                this.bCr.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bCr.get() != null) {
                this.bCr.get().bCo = false;
                this.bCr.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bCr.get() != null) {
                this.bCr.get().SR();
            }
        }
    }
}
