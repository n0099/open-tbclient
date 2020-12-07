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
/* loaded from: classes14.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.params.c bZO;
    private long cai;
    private long caj;
    private long cak;
    private com.baidu.mario.a.b.d cao;
    private boolean cap;
    private int caq;
    private c car;
    private AudioParams cat;
    private com.baidu.mario.audio.a.a cau;
    private Context mAppContext;
    private int cag = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean cah = false;
    private boolean cal = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] cav = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer caw = ByteBuffer.allocate(3840).put(this.cav);
    private Timer cax = null;
    private TimerTask cay = null;
    private boolean caz = false;
    private boolean caA = false;
    private long caB = 0;
    private d cam = d.abb();
    private com.baidu.mario.a.a cas = null;
    private e can = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.car != null) {
                b.this.car.onStart();
                b.this.caz = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bF(long j) {
            b.this.cak = j;
            if (j > b.this.cag && b.this.cap) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.cak);
            if (b.this.car != null) {
                b.this.car.Y((int) b.this.cak, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.car != null) {
                b.this.car.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.can);
    }

    public void setGameRecordCallback(c cVar) {
        this.car = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.cas = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.bZO == null) {
                this.bZO = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.bZO.a(eGLContext);
            }
            this.bZO.aaL().setWidth(i);
            this.bZO.aaL().setHeight(i2);
            if (z) {
                this.bZO.aaN().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.cao.setVideoWidth(i);
            this.cao.setVideoHeight(i2);
        }
    }

    public void gX(int i) {
        if (this.bZO != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.bZO.c(dVar);
                if (this.cam != null) {
                    this.cam.b(this.bZO);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.cap && this.cao != null) {
            switch (this.caq) {
                case 0:
                    aaZ();
                    if (this.cam != null) {
                        this.cam.a(this.mAppContext, this.cao, this.can);
                    }
                    this.caq = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.bZO.aaK().setId(i);
                    if (this.cam != null) {
                        this.cam.c(this.bZO);
                    }
                    this.caq = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.caq);
            }
        }
        if (this.cam != null && !this.cah) {
            this.cam.onVideoFrameAvailable(j - this.cai);
        }
    }

    public long aaU() {
        return this.cak;
    }

    public void aaV() {
        if (!this.cah) {
            this.cal = true;
            pauseRecord();
            return;
        }
        this.cal = false;
    }

    public void aaW() {
        if (this.cah && this.cal) {
            resumeRecord();
        }
        this.cal = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.cap) {
            Log.i(TAG, "startRecored");
            this.caB = System.nanoTime();
            this.mIsLandscape = z2;
            this.cao.setOutputFile(str);
            this.cao.setAudioIncluded(z);
            this.cao.setOutputTotalMs(i * 1000);
            this.cao.setVideoWidth(this.mCanvasWidth);
            this.cao.setVideoHeight(this.mCanvasHeight);
            this.cai = 0L;
            this.cak = 0L;
            if (i > 0 && i < 120) {
                this.cag = i * 1000;
            } else {
                this.cag = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaX() {
        if (this.cax != null) {
            this.cax.cancel();
            this.cax = null;
            this.cay = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.cao.setAudioSampleRate(audioParams.getSampleRate());
            this.cao.setAudioFrameSize(audioParams.getFrameSize());
            this.cao.setAudioChannel(audioParams.getChannelConfig());
        }
        this.caz = false;
        this.cap = true;
        aaX();
        this.cax = new Timer();
        this.cay = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.caz || b.this.caA) {
                    b.this.c(b.this.caw, 3840, System.nanoTime() - b.this.caB);
                    b.this.caA = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.aaX();
                b.this.caA = false;
            }
        };
        this.cax.schedule(this.cay, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.cau == null) {
            aba();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.cat = new AudioParams();
        } else {
            this.cat = audioParams;
        }
        if (this.cas != null) {
            Log.i(TAG, "set audio engie:" + this.cas);
            this.cas.a(this.cau);
        }
    }

    public void pauseRecord() {
        if (this.cah) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.cap) {
            this.cah = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.caj = System.nanoTime();
            this.cai = 0L;
            if (this.cam != null) {
                this.cam.abe();
                this.cai = (this.caj - (this.cak * TimeUtils.NANOS_PER_MS)) - this.cam.abc();
                if (this.cai < 0) {
                    this.cai = 0L;
                }
            }
            if (this.car != null) {
                this.car.onPause();
            }
            aaX();
        }
    }

    public void resumeRecord() {
        if (this.cah) {
            this.cai += System.nanoTime() - this.caj;
            this.cah = false;
            a((AudioParams) null);
            if (this.car != null) {
                this.car.onResume();
            }
        }
    }

    private void aaY() {
        if (this.cah) {
            this.cai += System.nanoTime() - this.caj;
            this.cah = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        aaY();
        this.cap = false;
        this.caz = false;
        this.caA = false;
        switch (this.caq) {
            case 0:
                return;
            case 1:
            case 2:
                this.caq = 0;
                if (this.cam != null) {
                    this.cam.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.caq);
        }
    }

    private void aaZ() {
        if (this.cao != null && this.bZO != null) {
            int videoHeight = this.cao.getVideoHeight();
            int videoWidth = this.cao.getVideoWidth();
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
            this.cao.setVideoWidth(videoWidth);
            this.cao.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.cao = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.can = eVar;
    }

    private void aba() {
        if (this.cau == null) {
            this.cau = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.cam != null && this.cap && byteBuffer != null && i > 0 && !this.cah) {
            this.cam.onAudioFrameAvailable(byteBuffer, i, j - this.cai);
        }
    }

    public void release() {
        if (this.cam != null) {
            this.cam.onDestroy();
            this.cam = null;
        }
        if (this.can != null) {
            this.can = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> caD;

        public a(b bVar) {
            this.caD = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.caD.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.caD.get() != null) {
                this.caD.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.caD.get() != null) {
                this.caD.get().caA = false;
                this.caD.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.caD.get() != null) {
                this.caD.get().aaX();
            }
        }
    }
}
