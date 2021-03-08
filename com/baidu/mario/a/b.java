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
    private long chO;
    private long chP;
    private long chQ;
    private com.baidu.mario.a.b.d chU;
    private boolean chV;
    private int chW;
    private c chX;
    private AudioParams chZ;
    private com.baidu.mario.gldraw2d.params.c chu;
    private com.baidu.mario.audio.a.a cia;
    private Context mAppContext;
    private int chM = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean chN = false;
    private boolean chR = false;
    private boolean mIsLandscape = false;
    private int aeE = 0;
    private int aeF = 0;
    private byte[] cib = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer cic = ByteBuffer.allocate(3840).put(this.cib);
    private Timer cie = null;
    private TimerTask cif = null;
    private boolean cig = false;
    private boolean cih = false;
    private long cii = 0;
    private d chS = d.aaQ();
    private com.baidu.mario.a.a chY = null;
    private e chT = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.chX != null) {
                b.this.chX.onStart();
                b.this.cig = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void bJ(long j) {
            b.this.chQ = j;
            if (j > b.this.chM && b.this.chV) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.chQ);
            if (b.this.chX != null) {
                b.this.chX.af((int) b.this.chQ, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.chX != null) {
                b.this.chX.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.chT);
    }

    public void setGameRecordCallback(c cVar) {
        this.chX = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.chY = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.chu == null) {
                this.chu = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.chu.a(eGLContext);
            }
            this.chu.aaA().setWidth(i);
            this.chu.aaA().setHeight(i2);
            if (z) {
                this.chu.aaC().a(MirrorType.VERTICALLY);
            }
            this.aeE = i;
            this.aeF = i2;
            this.chU.setVideoWidth(i);
            this.chU.setVideoHeight(i2);
        }
    }

    public void fy(int i) {
        if (this.chu != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.chu.c(dVar);
                if (this.chS != null) {
                    this.chS.b(this.chu);
                }
                this.mTextureId = i;
            }
            i(this.mTextureId, System.nanoTime());
        }
    }

    private void i(int i, long j) {
        if (this.chV && this.chU != null) {
            switch (this.chW) {
                case 0:
                    aaO();
                    if (this.chS != null) {
                        this.chS.a(this.mAppContext, this.chU, this.chT);
                    }
                    this.chW = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.chu.aaz().setId(i);
                    if (this.chS != null) {
                        this.chS.c(this.chu);
                    }
                    this.chW = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.chW);
            }
        }
        if (this.chS != null && !this.chN) {
            this.chS.onVideoFrameAvailable(j - this.chO);
        }
    }

    public long aaJ() {
        return this.chQ;
    }

    public void aaK() {
        if (!this.chN) {
            this.chR = true;
            pauseRecord();
            return;
        }
        this.chR = false;
    }

    public void aaL() {
        if (this.chN && this.chR) {
            resumeRecord();
        }
        this.chR = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.chV) {
            Log.i(TAG, "startRecored");
            this.cii = System.nanoTime();
            this.mIsLandscape = z2;
            this.chU.setOutputFile(str);
            this.chU.setAudioIncluded(z);
            this.chU.setOutputTotalMs(i * 1000);
            this.chU.setVideoWidth(this.aeE);
            this.chU.setVideoHeight(this.aeF);
            this.chO = 0L;
            this.chQ = 0L;
            if (i > 0 && i < 120) {
                this.chM = i * 1000;
            } else {
                this.chM = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaM() {
        if (this.cie != null) {
            this.cie.cancel();
            this.cie = null;
            this.cif = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.chU.setAudioSampleRate(audioParams.getSampleRate());
            this.chU.setAudioFrameSize(audioParams.getFrameSize());
            this.chU.setAudioChannel(audioParams.getChannelConfig());
        }
        this.cig = false;
        this.chV = true;
        aaM();
        this.cie = new Timer();
        this.cif = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.cig || b.this.cih) {
                    b.this.c(b.this.cic, 3840, System.nanoTime() - b.this.cii);
                    b.this.cih = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.aaM();
                b.this.cih = false;
            }
        };
        this.cie.schedule(this.cif, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.cia == null) {
            aaP();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.chZ = new AudioParams();
        } else {
            this.chZ = audioParams;
        }
        if (this.chY != null) {
            Log.i(TAG, "set audio engie:" + this.chY);
            this.chY.a(this.cia);
        }
    }

    public void pauseRecord() {
        if (this.chN) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.chV) {
            this.chN = true;
            Log.i(TAG, LuaMessageHelper.KEY_SEND_LUA_MESSAGE.PAUSE_RECORD);
            this.chP = System.nanoTime();
            this.chO = 0L;
            if (this.chS != null) {
                this.chS.aaT();
                this.chO = (this.chP - (this.chQ * TimeUtils.NANOS_PER_MS)) - this.chS.aaR();
                if (this.chO < 0) {
                    this.chO = 0L;
                }
            }
            if (this.chX != null) {
                this.chX.onPause();
            }
            aaM();
        }
    }

    public void resumeRecord() {
        if (this.chN) {
            this.chO += System.nanoTime() - this.chP;
            this.chN = false;
            a((AudioParams) null);
            if (this.chX != null) {
                this.chX.onResume();
            }
        }
    }

    private void aaN() {
        if (this.chN) {
            this.chO += System.nanoTime() - this.chP;
            this.chN = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        aaN();
        this.chV = false;
        this.cig = false;
        this.cih = false;
        switch (this.chW) {
            case 0:
                return;
            case 1:
            case 2:
                this.chW = 0;
                if (this.chS != null) {
                    this.chS.stopRecorder();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.chW);
        }
    }

    private void aaO() {
        if (this.chU != null && this.chu != null) {
            int videoHeight = this.chU.getVideoHeight();
            int videoWidth = this.chU.getVideoWidth();
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
            this.chU.setVideoWidth(videoWidth);
            this.chU.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.chU = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.chT = eVar;
    }

    private void aaP() {
        if (this.cia == null) {
            this.cia = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.chS != null && this.chV && byteBuffer != null && i > 0 && !this.chN) {
            this.chS.onAudioFrameAvailable(byteBuffer, i, j - this.chO);
        }
    }

    public void release() {
        if (this.chS != null) {
            this.chS.onDestroy();
            this.chS = null;
        }
        if (this.chT != null) {
            this.chT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> cik;

        public a(b bVar) {
            this.cik = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.cik.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.cik.get() != null) {
                this.cik.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.cik.get() != null) {
                this.cik.get().cih = false;
                this.cik.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.cik.get() != null) {
                this.cik.get().aaM();
            }
        }
    }
}
