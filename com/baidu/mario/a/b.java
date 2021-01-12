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
    private com.baidu.mario.gldraw2d.params.c cbJ;
    private long ccd;
    private long cce;
    private long ccf;
    private com.baidu.mario.a.b.d ccj;
    private boolean cck;
    private int ccl;
    private c ccm;
    private AudioParams cco;
    private com.baidu.mario.audio.a.a ccp;
    private Context mAppContext;
    private int ccb = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean ccc = false;
    private boolean ccg = false;
    private boolean mIsLandscape = false;
    private int adr = 0;
    private int ads = 0;
    private byte[] ccq = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer ccr = ByteBuffer.allocate(3840).put(this.ccq);
    private Timer cct = null;
    private TimerTask ccu = null;
    private boolean ccv = false;
    private boolean ccw = false;
    private long ccx = 0;
    private d cch = d.YU();
    private com.baidu.mario.a.a ccn = null;
    private e cci = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.ccm != null) {
                b.this.ccm.onStart();
                b.this.ccv = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bF(long j) {
            b.this.ccf = j;
            if (j > b.this.ccb && b.this.cck) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.ccf);
            if (b.this.ccm != null) {
                b.this.ccm.ab((int) b.this.ccf, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.ccm != null) {
                b.this.ccm.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.cci);
    }

    public void setGameRecordCallback(c cVar) {
        this.ccm = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.ccn = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.cbJ == null) {
                this.cbJ = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.cbJ.a(eGLContext);
            }
            this.cbJ.YE().setWidth(i);
            this.cbJ.YE().setHeight(i2);
            if (z) {
                this.cbJ.YG().a(MirrorType.VERTICALLY);
            }
            this.adr = i;
            this.ads = i2;
            this.ccj.setVideoWidth(i);
            this.ccj.setVideoHeight(i2);
        }
    }

    public void fr(int i) {
        if (this.cbJ != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.cbJ.c(dVar);
                if (this.cch != null) {
                    this.cch.b(this.cbJ);
                }
                this.mTextureId = i;
            }
            h(this.mTextureId, System.nanoTime());
        }
    }

    private void h(int i, long j) {
        if (this.cck && this.ccj != null) {
            switch (this.ccl) {
                case 0:
                    YS();
                    if (this.cch != null) {
                        this.cch.a(this.mAppContext, this.ccj, this.cci);
                    }
                    this.ccl = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.cbJ.YD().setId(i);
                    if (this.cch != null) {
                        this.cch.c(this.cbJ);
                    }
                    this.ccl = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.ccl);
            }
        }
        if (this.cch != null && !this.ccc) {
            this.cch.onVideoFrameAvailable(j - this.ccd);
        }
    }

    public long YN() {
        return this.ccf;
    }

    public void YO() {
        if (!this.ccc) {
            this.ccg = true;
            pauseRecord();
            return;
        }
        this.ccg = false;
    }

    public void YP() {
        if (this.ccc && this.ccg) {
            resumeRecord();
        }
        this.ccg = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.cck) {
            Log.i(TAG, "startRecored");
            this.ccx = System.nanoTime();
            this.mIsLandscape = z2;
            this.ccj.setOutputFile(str);
            this.ccj.setAudioIncluded(z);
            this.ccj.setOutputTotalMs(i * 1000);
            this.ccj.setVideoWidth(this.adr);
            this.ccj.setVideoHeight(this.ads);
            this.ccd = 0L;
            this.ccf = 0L;
            if (i > 0 && i < 120) {
                this.ccb = i * 1000;
            } else {
                this.ccb = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void YQ() {
        if (this.cct != null) {
            this.cct.cancel();
            this.cct = null;
            this.ccu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.ccj.setAudioSampleRate(audioParams.getSampleRate());
            this.ccj.setAudioFrameSize(audioParams.getFrameSize());
            this.ccj.setAudioChannel(audioParams.getChannelConfig());
        }
        this.ccv = false;
        this.cck = true;
        YQ();
        this.cct = new Timer();
        this.ccu = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.ccv || b.this.ccw) {
                    b.this.c(b.this.ccr, 3840, System.nanoTime() - b.this.ccx);
                    b.this.ccw = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.YQ();
                b.this.ccw = false;
            }
        };
        this.cct.schedule(this.ccu, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.ccp == null) {
            YT();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.cco = new AudioParams();
        } else {
            this.cco = audioParams;
        }
        if (this.ccn != null) {
            Log.i(TAG, "set audio engie:" + this.ccn);
            this.ccn.a(this.ccp);
        }
    }

    public void pauseRecord() {
        if (this.ccc) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.cck) {
            this.ccc = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.cce = System.nanoTime();
            this.ccd = 0L;
            if (this.cch != null) {
                this.cch.YX();
                this.ccd = (this.cce - (this.ccf * TimeUtils.NANOS_PER_MS)) - this.cch.YV();
                if (this.ccd < 0) {
                    this.ccd = 0L;
                }
            }
            if (this.ccm != null) {
                this.ccm.onPause();
            }
            YQ();
        }
    }

    public void resumeRecord() {
        if (this.ccc) {
            this.ccd += System.nanoTime() - this.cce;
            this.ccc = false;
            a((AudioParams) null);
            if (this.ccm != null) {
                this.ccm.onResume();
            }
        }
    }

    private void YR() {
        if (this.ccc) {
            this.ccd += System.nanoTime() - this.cce;
            this.ccc = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        YR();
        this.cck = false;
        this.ccv = false;
        this.ccw = false;
        switch (this.ccl) {
            case 0:
                return;
            case 1:
            case 2:
                this.ccl = 0;
                if (this.cch != null) {
                    this.cch.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.ccl);
        }
    }

    private void YS() {
        if (this.ccj != null && this.cbJ != null) {
            int videoHeight = this.ccj.getVideoHeight();
            int videoWidth = this.ccj.getVideoWidth();
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
            this.ccj.setVideoWidth(videoWidth);
            this.ccj.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.ccj = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.cci = eVar;
    }

    private void YT() {
        if (this.ccp == null) {
            this.ccp = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.cch != null && this.cck && byteBuffer != null && i > 0 && !this.ccc) {
            this.cch.onAudioFrameAvailable(byteBuffer, i, j - this.ccd);
        }
    }

    public void release() {
        if (this.cch != null) {
            this.cch.onDestroy();
            this.cch = null;
        }
        if (this.cci != null) {
            this.cci = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> ccz;

        public a(b bVar) {
            this.ccz = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.ccz.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.ccz.get() != null) {
                this.ccz.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.ccz.get() != null) {
                this.ccz.get().ccw = false;
                this.ccz.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.ccz.get() != null) {
                this.ccz.get().YQ();
            }
        }
    }
}
