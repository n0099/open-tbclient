package com.baidu.mario.b;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mario.gldraw2d.params.MirrorType;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.mario.a.e acI;
    private com.baidu.mario.gldraw2d.params.c acX;
    private com.baidu.mario.b.b.d adD;
    private boolean adE;
    private int adF;
    private b adG;
    private com.baidu.mario.a.a.a adH;
    private com.baidu.mario.a.a.b adI;
    private long adx;
    private long ady;
    private long adz;
    private Context mAppContext;
    private int adv = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean adw = false;
    private boolean adA = false;
    private boolean mIsLandscape = false;
    private int TV = 0;
    private int TW = 0;
    private c adB = c.sN();
    private d adC = new d() { // from class: com.baidu.mario.b.a.1
        @Override // com.baidu.mario.b.d
        public void onRecorderStart(boolean z) {
            if (a.this.adG != null) {
                a.this.adG.onStart();
            }
        }

        @Override // com.baidu.mario.b.d
        public void v(long j) {
            a.this.adz = j;
            if (j > a.this.adv && a.this.adE) {
                a.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderComplete(boolean z, String str) {
            Log.i(a.TAG, "on RecorderComplete record time :" + a.this.adz);
            if (a.this.adG != null) {
                a.this.adG.h((int) a.this.adz, str);
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderError(int i) {
            Log.i(a.TAG, "onRecorderError:" + i);
            if (a.this.adG != null) {
                a.this.adG.onError(i);
            }
        }
    };

    public a(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.b.b.d(), this.adC);
    }

    public void setGameRecordCallback(b bVar) {
        this.adG = bVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.acX == null) {
                this.acX = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.acX.c(eGLContext);
            }
            this.acX.sy().setWidth(i);
            this.acX.sy().setHeight(i2);
            if (z) {
                this.acX.sA().a(MirrorType.VERTICALLY);
            }
            this.TV = i;
            this.TW = i2;
            this.adD.setVideoWidth(i);
            this.adD.setVideoHeight(i2);
        }
    }

    public void bB(int i) {
        if (this.acX != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.acX.c(dVar);
                if (this.adB != null) {
                    this.adB.b(this.acX);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.adE && this.adD != null) {
            switch (this.adF) {
                case 0:
                    sK();
                    if (this.adB != null) {
                        this.adB.a(this.mAppContext, this.adD, this.adC);
                    }
                    this.adF = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.acX.sx().setId(i);
                    if (this.adB != null) {
                        this.adB.c(this.acX);
                    }
                    this.adF = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.adF);
            }
        }
        if (this.adB != null && !this.adw) {
            this.adB.w(j - this.adx);
        }
    }

    public long sH() {
        return this.adz;
    }

    public void sI() {
        if (!this.adw) {
            this.adA = true;
            pauseRecord();
            return;
        }
        this.adA = false;
    }

    public void sJ() {
        if (this.adw && this.adA) {
            resumeRecord();
        }
        this.adA = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.adE) {
            Log.i(TAG, "startRecored");
            this.mIsLandscape = z2;
            this.adD.setOutputFile(str);
            this.adD.aM(z);
            this.adD.z(i * 1000);
            this.adD.setVideoWidth(this.TV);
            this.adD.setVideoHeight(this.TW);
            if (i > 0 && i < 120) {
                this.adv = i * 1000;
            } else {
                this.adv = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            c((com.baidu.mario.a.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(boolean z) {
        this.adE = true;
        this.adx = 0L;
        this.adz = 0L;
    }

    private void c(com.baidu.mario.a.e eVar) {
        if (this.adI == null) {
            sL();
        }
        if (eVar == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.acI = new com.baidu.mario.a.e();
        } else {
            this.acI = eVar;
        }
        this.adH = com.baidu.mario.a.a.a.rZ();
        this.adH.a(this.acI, this.adI);
    }

    public void pauseRecord() {
        if (this.adw) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.adE) {
            this.adw = true;
            Log.i(TAG, "pauseRecord");
            this.ady = System.nanoTime();
            this.adx = 0L;
            if (this.adB != null) {
                this.adB.sQ();
                this.adx = (this.ady - (this.adz * 1000000)) - this.adB.sO();
                if (this.adx < 0) {
                    this.adx = 0L;
                }
            }
            if (this.adG != null) {
                this.adG.onPause();
            }
        }
    }

    public void resumeRecord() {
        if (this.adw) {
            this.adx += System.nanoTime() - this.ady;
            Log.i(TAG, "resumeRecord time dur:" + this.adx);
            this.adw = false;
            if (this.adG != null) {
                this.adG.onResume();
            }
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        resumeRecord();
        this.adE = false;
        switch (this.adF) {
            case 0:
                return;
            case 1:
            case 2:
                this.adF = 0;
                if (this.adB != null) {
                    this.adB.sR();
                }
                if (this.adH != null) {
                    this.adH.a(this.adI);
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.adF);
        }
    }

    private void sK() {
        if (this.adD != null && this.acX != null) {
            int videoHeight = this.adD.getVideoHeight();
            int videoWidth = this.adD.getVideoWidth();
            if (videoHeight > videoWidth) {
                videoHeight = (this.adD.getVideoWidth() * this.acX.sy().getHeight()) / this.acX.sy().getWidth();
            } else {
                videoWidth = (this.adD.getVideoHeight() * this.acX.sy().getHeight()) / this.acX.sy().getWidth();
            }
            if (videoHeight > 1920) {
                videoHeight /= 2;
                videoWidth /= 2;
            }
            if (videoHeight % 2 == 1) {
                videoHeight++;
            }
            if (videoWidth % 2 == 1) {
                videoWidth++;
            }
            if (videoHeight % 2 == 1) {
                videoHeight++;
            }
            if (videoWidth % 2 == 1) {
                videoWidth++;
            }
            if (videoHeight > 1920) {
                videoHeight = 1920;
            }
            if (!this.mIsLandscape) {
                int i = videoWidth;
                videoWidth = videoHeight;
                videoHeight = i;
            }
            this.adD.setVideoWidth(videoHeight);
            this.adD.setVideoHeight(videoWidth);
        }
    }

    public void a(com.baidu.mario.b.b.d dVar) {
        this.adD = dVar;
    }

    public void a(com.baidu.mario.b.b.d dVar, d dVar2) {
        a(dVar);
        this.adC = dVar2;
    }

    private void sL() {
        if (this.adI == null) {
            this.adI = new C0059a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.adB != null && this.adE && byteBuffer != null && i > 0 && !this.adw) {
            this.adB.onAudioFrameAvailable(byteBuffer, i, j - this.adx);
        }
    }

    public void release() {
        if (this.adH != null) {
            this.adH.release();
            this.adH = null;
        }
        if (this.adB != null) {
            this.adB.onDestroy();
            this.adB = null;
        }
        if (this.adC != null) {
            this.adC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mario.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0059a implements com.baidu.mario.a.a.b {
        private WeakReference<a> adK;

        public C0059a(a aVar) {
            this.adK = new WeakReference<>(aVar);
            Log.i(a.TAG, "gameRecorderRef is:" + this.adK.get());
        }

        @Override // com.baidu.mario.a.a.b
        public void a(boolean z, com.baidu.mario.a.e eVar) {
            if (this.adK.get() != null) {
                this.adK.get().aD(z);
                Log.i(a.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.adK.get() != null) {
                this.adK.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioStop(boolean z) {
            Log.i(a.TAG, "onAudioStop");
        }
    }
}
