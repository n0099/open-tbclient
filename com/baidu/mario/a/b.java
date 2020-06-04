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
    private com.baidu.mario.gldraw2d.params.c bmR;
    private com.baidu.mario.audio.a.a bnA;
    private long bno;
    private long bnp;
    private long bnq;
    private com.baidu.mario.a.b.d bnu;
    private boolean bnv;
    private int bnw;
    private c bnx;
    private AudioParams bnz;
    private Context mAppContext;
    private int bnm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean bnn = false;
    private boolean bnr = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] bnB = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer bnC = ByteBuffer.allocate(3840).put(this.bnB);
    private Timer bnD = null;
    private TimerTask bnE = null;
    private boolean bnF = false;
    private boolean bnG = false;
    private long bnH = 0;
    private d bns = d.KP();
    private com.baidu.mario.a.a bny = null;
    private e bnt = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.bnx != null) {
                b.this.bnx.onStart();
                b.this.bnF = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void aG(long j) {
            b.this.bnq = j;
            if (j > b.this.bnm && b.this.bnv) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.bnq);
            if (b.this.bnx != null) {
                b.this.bnx.F((int) b.this.bnq, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.bnx != null) {
                b.this.bnx.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.bnt);
    }

    public void setGameRecordCallback(c cVar) {
        this.bnx = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.bny = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bmR == null) {
                this.bmR = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bmR.a(eGLContext);
            }
            this.bmR.Kz().setWidth(i);
            this.bmR.Kz().setHeight(i2);
            if (z) {
                this.bmR.KB().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.bnu.setVideoWidth(i);
            this.bnu.setVideoHeight(i2);
        }
    }

    public void dA(int i) {
        if (this.bmR != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bmR.c(dVar);
                if (this.bns != null) {
                    this.bns.b(this.bmR);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.bnv && this.bnu != null) {
            switch (this.bnw) {
                case 0:
                    KN();
                    if (this.bns != null) {
                        this.bns.a(this.mAppContext, this.bnu, this.bnt);
                    }
                    this.bnw = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bmR.Ky().setId(i);
                    if (this.bns != null) {
                        this.bns.c(this.bmR);
                    }
                    this.bnw = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.bnw);
            }
        }
        if (this.bns != null && !this.bnn) {
            this.bns.onVideoFrameAvailable(j - this.bno);
        }
    }

    public long KI() {
        return this.bnq;
    }

    public void KJ() {
        if (!this.bnn) {
            this.bnr = true;
            pauseRecord();
            return;
        }
        this.bnr = false;
    }

    public void KK() {
        if (this.bnn && this.bnr) {
            resumeRecord();
        }
        this.bnr = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.bnv) {
            Log.i(TAG, "startRecored");
            this.bnH = System.nanoTime();
            this.mIsLandscape = z2;
            this.bnu.setOutputFile(str);
            this.bnu.setAudioIncluded(z);
            this.bnu.setOutputTotalMs(i * 1000);
            this.bnu.setVideoWidth(this.mCanvasWidth);
            this.bnu.setVideoHeight(this.mCanvasHeight);
            this.bno = 0L;
            this.bnq = 0L;
            if (i > 0 && i < 120) {
                this.bnm = i * 1000;
            } else {
                this.bnm = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void KL() {
        if (this.bnD != null) {
            this.bnD.cancel();
            this.bnD = null;
            this.bnE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.bnu.setAudioSampleRate(audioParams.getSampleRate());
            this.bnu.setAudioFrameSize(audioParams.getFrameSize());
            this.bnu.setAudioChannel(audioParams.getChannelConfig());
        }
        this.bnF = false;
        this.bnv = true;
        KL();
        this.bnD = new Timer();
        this.bnE = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.bnF || b.this.bnG) {
                    b.this.c(b.this.bnC, 3840, System.nanoTime() - b.this.bnH);
                    b.this.bnG = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.KL();
                b.this.bnG = false;
            }
        };
        this.bnD.schedule(this.bnE, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.bnA == null) {
            KO();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.bnz = new AudioParams();
        } else {
            this.bnz = audioParams;
        }
        if (this.bny != null) {
            Log.i(TAG, "set audio engie:" + this.bny);
            this.bny.a(this.bnA);
        }
    }

    public void pauseRecord() {
        if (this.bnn) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.bnv) {
            this.bnn = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.bnp = System.nanoTime();
            this.bno = 0L;
            if (this.bns != null) {
                this.bns.KS();
                this.bno = (this.bnp - (this.bnq * TimeUtils.NANOS_PER_MS)) - this.bns.KQ();
                if (this.bno < 0) {
                    this.bno = 0L;
                }
            }
            if (this.bnx != null) {
                this.bnx.onPause();
            }
            KL();
        }
    }

    public void resumeRecord() {
        if (this.bnn) {
            this.bno += System.nanoTime() - this.bnp;
            this.bnn = false;
            a((AudioParams) null);
            if (this.bnx != null) {
                this.bnx.onResume();
            }
        }
    }

    private void KM() {
        if (this.bnn) {
            this.bno += System.nanoTime() - this.bnp;
            this.bnn = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        KM();
        this.bnv = false;
        this.bnF = false;
        this.bnG = false;
        switch (this.bnw) {
            case 0:
                return;
            case 1:
            case 2:
                this.bnw = 0;
                if (this.bns != null) {
                    this.bns.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.bnw);
        }
    }

    private void KN() {
        if (this.bnu != null && this.bmR != null) {
            int videoHeight = this.bnu.getVideoHeight();
            int videoWidth = this.bnu.getVideoWidth();
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
            this.bnu.setVideoWidth(videoWidth);
            this.bnu.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.bnu = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.bnt = eVar;
    }

    private void KO() {
        if (this.bnA == null) {
            this.bnA = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.bns != null && this.bnv && byteBuffer != null && i > 0 && !this.bnn) {
            this.bns.onAudioFrameAvailable(byteBuffer, i, j - this.bno);
        }
    }

    public void release() {
        if (this.bns != null) {
            this.bns.onDestroy();
            this.bns = null;
        }
        if (this.bnt != null) {
            this.bnt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> bnJ;

        public a(b bVar) {
            this.bnJ = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.bnJ.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.bnJ.get() != null) {
                this.bnJ.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.bnJ.get() != null) {
                this.bnJ.get().bnG = false;
                this.bnJ.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.bnJ.get() != null) {
                this.bnJ.get().KL();
            }
        }
    }
}
