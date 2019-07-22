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
    private long adU;
    private long adV;
    private long adW;
    private com.baidu.mario.a.e adg;
    private com.baidu.mario.gldraw2d.params.c adv;
    private com.baidu.mario.b.b.d aea;
    private boolean aeb;
    private int aec;
    private b aed;
    private com.baidu.mario.a.a.a aee;
    private com.baidu.mario.a.a.b aef;
    private Context mAppContext;
    private int adS = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mTextureId = -1;
    private boolean adT = false;
    private boolean adX = false;
    private boolean mIsLandscape = false;
    private int Un = 0;
    private int Uo = 0;
    private c adY = c.tl();
    private d adZ = new d() { // from class: com.baidu.mario.b.a.1
        @Override // com.baidu.mario.b.d
        public void onRecorderStart(boolean z) {
            if (a.this.aed != null) {
                a.this.aed.onStart();
            }
        }

        @Override // com.baidu.mario.b.d
        public void v(long j) {
            a.this.adW = j;
            if (j > a.this.adS && a.this.aeb) {
                a.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderComplete(boolean z, String str) {
            Log.i(a.TAG, "on RecorderComplete record time :" + a.this.adW);
            if (a.this.aed != null) {
                a.this.aed.h((int) a.this.adW, str);
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderError(int i) {
            Log.i(a.TAG, "onRecorderError:" + i);
            if (a.this.aed != null) {
                a.this.aed.onError(i);
            }
        }
    };

    public a(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.b.b.d(), this.adZ);
    }

    public void setGameRecordCallback(b bVar) {
        this.aed = bVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.adv == null) {
                this.adv = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.adv.c(eGLContext);
            }
            this.adv.sW().setWidth(i);
            this.adv.sW().setHeight(i2);
            if (z) {
                this.adv.sY().a(MirrorType.VERTICALLY);
            }
            this.Un = i;
            this.Uo = i2;
            this.aea.setVideoWidth(i);
            this.aea.setVideoHeight(i2);
        }
    }

    public void bB(int i) {
        if (this.adv != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.adv.c(dVar);
                if (this.adY != null) {
                    this.adY.b(this.adv);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.aeb && this.aea != null) {
            switch (this.aec) {
                case 0:
                    ti();
                    if (this.adY != null) {
                        this.adY.a(this.mAppContext, this.aea, this.adZ);
                    }
                    this.aec = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.adv.sV().setId(i);
                    if (this.adY != null) {
                        this.adY.c(this.adv);
                    }
                    this.aec = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.aec);
            }
        }
        if (this.adY != null && !this.adT) {
            this.adY.w(j - this.adU);
        }
    }

    public long tf() {
        return this.adW;
    }

    public void tg() {
        if (!this.adT) {
            this.adX = true;
            pauseRecord();
            return;
        }
        this.adX = false;
    }

    public void th() {
        if (this.adT && this.adX) {
            resumeRecord();
        }
        this.adX = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.aeb) {
            Log.i(TAG, "startRecored");
            this.mIsLandscape = z2;
            this.aea.cF(str);
            this.aea.aP(z);
            this.aea.z(i * 1000);
            this.aea.setVideoWidth(this.Un);
            this.aea.setVideoHeight(this.Uo);
            if (i > 0 && i < 120) {
                this.adS = i * 1000;
            } else {
                this.adS = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
            }
            c((com.baidu.mario.a.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(boolean z) {
        this.aeb = true;
        this.adU = 0L;
        this.adW = 0L;
    }

    private void c(com.baidu.mario.a.e eVar) {
        if (this.aef == null) {
            tj();
        }
        if (eVar == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.adg = new com.baidu.mario.a.e();
        } else {
            this.adg = eVar;
        }
        this.aee = com.baidu.mario.a.a.a.sx();
        this.aee.a(this.adg, this.aef);
    }

    public void pauseRecord() {
        if (this.adT) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.aeb) {
            this.adT = true;
            Log.i(TAG, "pauseRecord");
            this.adV = System.nanoTime();
            this.adU = 0L;
            if (this.adY != null) {
                this.adY.tp();
                this.adU = (this.adV - (this.adW * 1000000)) - this.adY.tm();
                if (this.adU < 0) {
                    this.adU = 0L;
                }
            }
            if (this.aed != null) {
                this.aed.onPause();
            }
        }
    }

    public void resumeRecord() {
        if (this.adT) {
            this.adU += System.nanoTime() - this.adV;
            Log.i(TAG, "resumeRecord time dur:" + this.adU);
            this.adT = false;
            if (this.aed != null) {
                this.aed.onResume();
            }
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        resumeRecord();
        this.aeb = false;
        switch (this.aec) {
            case 0:
                return;
            case 1:
            case 2:
                this.aec = 0;
                if (this.adY != null) {
                    this.adY.tq();
                }
                if (this.aee != null) {
                    this.aee.a(this.aef);
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.aec);
        }
    }

    private void ti() {
        if (this.aea != null && this.adv != null) {
            int videoHeight = this.aea.getVideoHeight();
            int videoWidth = this.aea.getVideoWidth();
            if (videoHeight > videoWidth) {
                videoHeight = (this.aea.getVideoWidth() * this.adv.sW().getHeight()) / this.adv.sW().getWidth();
            } else {
                videoWidth = (this.aea.getVideoHeight() * this.adv.sW().getHeight()) / this.adv.sW().getWidth();
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
            this.aea.setVideoWidth(videoHeight);
            this.aea.setVideoHeight(videoWidth);
        }
    }

    public void a(com.baidu.mario.b.b.d dVar) {
        this.aea = dVar;
    }

    public void a(com.baidu.mario.b.b.d dVar, d dVar2) {
        a(dVar);
        this.adZ = dVar2;
    }

    private void tj() {
        if (this.aef == null) {
            this.aef = new C0059a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.adY != null && this.aeb && byteBuffer != null && i > 0 && !this.adT) {
            this.adY.onAudioFrameAvailable(byteBuffer, i, j - this.adU);
        }
    }

    public void release() {
        if (this.aee != null) {
            this.aee.release();
            this.aee = null;
        }
        if (this.adY != null) {
            this.adY.onDestroy();
            this.adY = null;
        }
        if (this.adZ != null) {
            this.adZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mario.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0059a implements com.baidu.mario.a.a.b {
        private WeakReference<a> aeh;

        public C0059a(a aVar) {
            this.aeh = new WeakReference<>(aVar);
            Log.i(a.TAG, "gameRecorderRef is:" + this.aeh.get());
        }

        @Override // com.baidu.mario.a.a.b
        public void a(boolean z, com.baidu.mario.a.e eVar) {
            if (this.aeh.get() != null) {
                this.aeh.get().aG(z);
                Log.i(a.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.aeh.get() != null) {
                this.aeh.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioStop(boolean z) {
            Log.i(a.TAG, "onAudioStop");
        }
    }
}
