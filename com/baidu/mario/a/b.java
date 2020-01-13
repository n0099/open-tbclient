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
/* loaded from: classes10.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.mario.gldraw2d.params.c aEY;
    private com.baidu.mario.a.b.d aFC;
    private boolean aFD;
    private c aFE;
    private AudioParams aFG;
    private com.baidu.mario.audio.a.a aFH;
    private long aFw;
    private long aFx;
    private long aFy;
    private Context mAppContext;
    private int mRecordingStatus;
    private int aFu = 120000;
    private int mTextureId = -1;
    private boolean aFv = false;
    private boolean aFz = false;
    private boolean mIsLandscape = false;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;
    private byte[] aFI = ByteBuffer.allocate(3840).putShort(Short.MIN_VALUE).array();
    private ByteBuffer aFJ = ByteBuffer.allocate(3840).put(this.aFI);
    private Timer aFK = null;
    private TimerTask aFL = null;
    private boolean aFM = false;
    private boolean aFN = false;
    private long aFO = 0;
    private d aFA = d.At();
    private com.baidu.mario.a.a aFF = null;
    private e aFB = new e() { // from class: com.baidu.mario.a.b.1
        @Override // com.baidu.mario.a.e
        public void onRecorderStart(boolean z) {
            if (b.this.aFE != null) {
                b.this.aFE.onStart();
                b.this.aFM = true;
            }
        }

        @Override // com.baidu.mario.a.e
        public void R(long j) {
            b.this.aFy = j;
            if (j > b.this.aFu && b.this.aFD) {
                b.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderComplete(boolean z, String str) {
            Log.i(b.TAG, "on RecorderComplete record time :" + b.this.aFy);
            if (b.this.aFE != null) {
                b.this.aFE.p((int) b.this.aFy, str);
            }
        }

        @Override // com.baidu.mario.a.e
        public void onRecorderError(int i) {
            Log.i(b.TAG, "onRecorderError:" + i);
            if (b.this.aFE != null) {
                b.this.aFE.onError(i);
            }
        }
    };

    public b(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.a.b.d(), this.aFB);
    }

    public void setGameRecordCallback(c cVar) {
        this.aFE = cVar;
    }

    public void setAudioEngineProxy(com.baidu.mario.a.a aVar) {
        this.aFF = aVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.aEY == null) {
                this.aEY = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.aEY.b(eGLContext);
            }
            this.aEY.Ad().setWidth(i);
            this.aEY.Ad().setHeight(i2);
            if (z) {
                this.aEY.Af().a(MirrorType.VERTICALLY);
            }
            this.mCanvasWidth = i;
            this.mCanvasHeight = i2;
            this.aFC.setVideoWidth(i);
            this.aFC.setVideoHeight(i2);
        }
    }

    public void cN(int i) {
        if (this.aEY != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.aEY.c(dVar);
                if (this.aFA != null) {
                    this.aFA.b(this.aEY);
                }
                this.mTextureId = i;
            }
            d(this.mTextureId, System.nanoTime());
        }
    }

    private void d(int i, long j) {
        if (this.aFD && this.aFC != null) {
            switch (this.mRecordingStatus) {
                case 0:
                    Ar();
                    if (this.aFA != null) {
                        this.aFA.a(this.mAppContext, this.aFC, this.aFB);
                    }
                    this.mRecordingStatus = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.aEY.Ac().setId(i);
                    if (this.aFA != null) {
                        this.aFA.c(this.aEY);
                    }
                    this.mRecordingStatus = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
        if (this.aFA != null && !this.aFv) {
            this.aFA.S(j - this.aFw);
        }
    }

    public long Am() {
        return this.aFy;
    }

    public void An() {
        if (!this.aFv) {
            this.aFz = true;
            pauseRecord();
            return;
        }
        this.aFz = false;
    }

    public void Ao() {
        if (this.aFv && this.aFz) {
            resumeRecord();
        }
        this.aFz = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aFD) {
            Log.i(TAG, "startRecored");
            this.aFO = System.nanoTime();
            this.mIsLandscape = z2;
            this.aFC.setOutputFile(str);
            this.aFC.bB(z);
            this.aFC.V(i * 1000);
            this.aFC.setVideoWidth(this.mCanvasWidth);
            this.aFC.setVideoHeight(this.mCanvasHeight);
            this.aFw = 0L;
            this.aFy = 0L;
            if (i > 0 && i < 120) {
                this.aFu = i * 1000;
            } else {
                this.aFu = 120000;
            }
            a((AudioParams) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ap() {
        if (this.aFK != null) {
            this.aFK.cancel();
            this.aFK = null;
            this.aFL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.aFC.cQ(audioParams.getSampleRate());
            this.aFC.cR(audioParams.getFrameSize());
            this.aFC.cP(audioParams.getChannelConfig());
        }
        this.aFM = false;
        this.aFD = true;
        Ap();
        this.aFK = new Timer();
        this.aFL = new TimerTask() { // from class: com.baidu.mario.a.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!b.this.aFM || b.this.aFN) {
                    b.this.c(b.this.aFJ, 3840, System.nanoTime() - b.this.aFO);
                    b.this.aFN = true;
                    return;
                }
                Log.i(b.TAG, "cancel audio time");
                b.this.Ap();
                b.this.aFN = false;
            }
        };
        this.aFK.schedule(this.aFL, 300L, 20L);
    }

    private void a(AudioParams audioParams) {
        if (this.aFH == null) {
            As();
        }
        if (audioParams == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.aFG = new AudioParams();
        } else {
            this.aFG = audioParams;
        }
        if (this.aFF != null) {
            Log.i(TAG, "set audio engie:" + this.aFF);
            this.aFF.a(this.aFH);
        }
    }

    public void pauseRecord() {
        if (this.aFv) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aFD) {
            this.aFv = true;
            Log.i(TAG, "pauseRecord");
            this.aFx = System.nanoTime();
            this.aFw = 0L;
            if (this.aFA != null) {
                this.aFA.Aw();
                this.aFw = (this.aFx - (this.aFy * TimeUtils.NANOS_PER_MS)) - this.aFA.Au();
                if (this.aFw < 0) {
                    this.aFw = 0L;
                }
            }
            if (this.aFE != null) {
                this.aFE.onPause();
            }
            Ap();
        }
    }

    public void resumeRecord() {
        if (this.aFv) {
            this.aFw += System.nanoTime() - this.aFx;
            this.aFv = false;
            a((AudioParams) null);
            if (this.aFE != null) {
                this.aFE.onResume();
            }
        }
    }

    private void Aq() {
        if (this.aFv) {
            this.aFw += System.nanoTime() - this.aFx;
            this.aFv = false;
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        Aq();
        this.aFD = false;
        this.aFM = false;
        this.aFN = false;
        switch (this.mRecordingStatus) {
            case 0:
                return;
            case 1:
            case 2:
                this.mRecordingStatus = 0;
                if (this.aFA != null) {
                    this.aFA.Ax();
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
        }
    }

    private void Ar() {
        if (this.aFC != null && this.aEY != null) {
            int videoHeight = this.aFC.getVideoHeight();
            int videoWidth = this.aFC.getVideoWidth();
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
            this.aFC.setVideoWidth(videoWidth);
            this.aFC.setVideoHeight(videoHeight);
        }
    }

    public void a(com.baidu.mario.a.b.d dVar) {
        this.aFC = dVar;
    }

    public void a(com.baidu.mario.a.b.d dVar, e eVar) {
        a(dVar);
        this.aFB = eVar;
    }

    private void As() {
        if (this.aFH == null) {
            this.aFH = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.aFA != null && this.aFD && byteBuffer != null && i > 0 && !this.aFv) {
            this.aFA.onAudioFrameAvailable(byteBuffer, i, j - this.aFw);
        }
    }

    public void release() {
        if (this.aFA != null) {
            this.aFA.onDestroy();
            this.aFA = null;
        }
        if (this.aFB != null) {
            this.aFB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements com.baidu.mario.audio.a.a {
        private WeakReference<b> aFQ;

        public a(b bVar) {
            this.aFQ = new WeakReference<>(bVar);
            Log.i(b.TAG, "gameRecorderRef is:" + this.aFQ.get());
        }

        @Override // com.baidu.mario.audio.a.a
        public void a(boolean z, AudioParams audioParams) {
            if (this.aFQ.get() != null) {
                this.aFQ.get().b(z, audioParams);
                Log.i(b.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aFQ.get() != null) {
                this.aFQ.get().aFN = false;
                this.aFQ.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.audio.a.a
        public void onAudioStop(boolean z) {
            Log.i(b.TAG, "onAudioStop");
            if (this.aFQ.get() != null) {
                this.aFQ.get().Ap();
            }
        }
    }
}
