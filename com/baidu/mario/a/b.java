package com.baidu.mario.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private long aEE;
    private long aEF;
    private long aEG;
    private com.baidu.mario.a.b.d aEK;
    private boolean aEL;
    private c aEM;
    private AudioParams aEO;
    private com.baidu.mario.audio.a.a aEP;
    private com.baidu.mario.gldraw2d.params.c aEg;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aEC = 120000;
    private int mTextureId = -1;
    private boolean aED = false;
    private boolean aEH = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aEQ = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aER = ByteBuffer.allocate(3840).put(this.aEQ);
    private Timer aES = null;
    private TimerTask aET = null;
    private boolean aEU = false;
    private boolean aEV = false;
    private long aEW = 0;
    private d aEI = d.zX();
    private com.baidu.mario.a.a aEN = null;
    private e aEJ = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aEM != null) {
                b.this.aEM.onStart();
                b.this.aEU = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void O(long j) {
            b.this.aEG = j;
            if (j > b.this.aEC && b.this.aEL) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aEG);
            if (b.this.aEM != null) {
                b.this.aEM.m((int) b.this.aEG, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aEM != null) {
                b.this.aEM.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aEJ);
    }

    public void setGameRecordCallback(c cVar) {
        this.aEM = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aEN = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aEg == null) {
                this.aEg = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aEg.b(eGLContext);
            }
            this.aEg.zH().setWidth(i);
            this.aEg.zH().setHeight(i2);
            if (z) {
                this.aEg.zJ().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aEK.setVideoWidth(i);
            this.aEK.setVideoHeight(i2);
        }
    }

    public void cM(int i) {
        if (this.aEg != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aEg.c(dVar);
                if (this.aEI != null) {
                    this.aEI.b(this.aEg);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aEL && this.aEK != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    zV();
                    if (this.aEI != null) {
                        this.aEI.a(this.mAppContext, this.aEK, this.aEJ);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aEg.zG().setId(i);
                    if (this.aEI != null) {
                        this.aEI.c(this.aEg);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aEI != null && !this.aED) {
            this.aEI.P(j - this.aEE);
        }
    }

    public long zQ() {
        return this.aEG;
    }

    public void zR() {
        if (!this.aED) {
            this.aEH = true;
            pauseRecord();
            return;
        }
        this.aEH = false;
    }

    public void zS() {
        if (this.aED && this.aEH) {
            resumeRecord();
        }
        this.aEH = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aEL) {
            Log.i(TAG, "startRecored");
            this.aEW = System.nanoTime();
            this.mIsLandscape = z2;
            this.aEK.setOutputFile(str);
            this.aEK.bw(z);
            this.aEK.S(i * 1000);
            this.aEK.setVideoWidth(this.mCanvasWidth);
            this.aEK.setVideoHeight(this.mCanvasHeight);
            this.aEE = 0L;
            this.aEG = 0L;
            if (i > 0 && i < 120) {
                this.aEC = i * 1000;
            } else {
                this.aEC = 120000;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zT() {
        if (this.aES != null) {
            this.aES.cancel();
            this.aES = null;
            this.aET = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aEK.cP(audioParams.getSampleRate());
            this.aEK.cQ(audioParams.getFrameSize());
            this.aEK.cO(audioParams.getChannelConfig());
        }
        this.aEU = false;
        this.aEL = true;
        zT();
        this.aES = new Timer();
        this.aET = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aEU || b.this.aEV) {
                    b.this.c(b.this.aER, 3840, System.nanoTime() - b.this.aEW);
                    b.this.aEV = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.zT();
                b.this.aEV = false;
            }
        };
        this.aES.schedule(this.aET, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aEP == null) {
            zW();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aEO = new AudioParams();
        } else {
            this.aEO = audioParams;
        }
        if (this.aEN != null) {
            Log.i(TAG, "set audio engie:" + this.aEN);
            this.aEN.a(this.aEP);
        }
    }

    public void pauseRecord() {
        if (this.aED) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aEL) {
            this.aED = true;
            Log.i(TAG, "pauseRecord");
            this.aEF = System.nanoTime();
            this.aEE = 0L;
            if (this.aEI != null) {
                this.aEI.Aa();
                this.aEE = (this.aEF - (this.aEG * TimeUtils.NANOS_PER_MS)) - this.aEI.zY();
                if (this.aEE < 0) {
                    this.aEE = 0L;
                }
            }
            if (this.aEM != null) {
                this.aEM.onPause();
            }
            zT();
        }
    }

    public void resumeRecord() {
        if (this.aED) {
            this.aEE += System.nanoTime() - this.aEF;
            this.aED = false;
            a((AudioParams) null);
            if (this.aEM != null) {
                this.aEM.onResume();
            }
        }
    }

    private void zU() {
        if (this.aED) {
            this.aEE += System.nanoTime() - this.aEF;
            this.aED = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        zU();
        this.aEL = false;
        this.aEU = false;
        this.aEV = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aEI != null) {
                    this.aEI.Ab();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void zV() {
        if (this.aEK != null && this.aEg != null) {
            int videoHeight = this.aEK.getVideoHeight();
            int videoWidth = this.aEK.getVideoWidth();
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
            this.aEK.setVideoWidth(videoWidth);
            this.aEK.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aEK = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aEJ = eVar;
    }

    private void zW() {
        if (this.aEP == null) {
            this.aEP = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aEI != null && this.aEL && byteBuffer != null && i > 0 && !this.aED) {
            this.aEI.onAudioFrameAvailable(byteBuffer, i, j - this.aEE);
        }
    }

    public void release() {
        if (this.aEI != null) {
            this.aEI.onDestroy();
            this.aEI = null;
        }
        if (this.aEJ != null) {
            this.aEJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aEY;

        public a(b bVar) {
            this.aEY = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aEY.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aEY.get() != null) {
                this.aEY.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aEY.get() != null) {
                this.aEY.get().aEV = false;
                this.aEY.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aEY.get() != null) {
                this.aEY.get().zT();
            }
        }
    }
}
