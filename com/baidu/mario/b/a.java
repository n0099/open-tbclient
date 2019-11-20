package com.baidu.mario.b;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.mario.gldraw2d.params.MirrorType;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.mario.gldraw2d.params.c awB;
    private com.baidu.mario.a.e awm;
    private long axa;
    private long axb;
    private long axc;
    private com.baidu.mario.b.b.d axg;
    private boolean axh;
    private int axi;
    private b axj;
    private com.baidu.mario.a.a.a axk;
    private com.baidu.mario.a.a.b axl;
    private Context mAppContext;
    private int awY = 120000;
    private int mTextureId = -1;
    private boolean awZ = false;
    private boolean axd = false;
    private boolean mIsLandscape = false;
    private int De = 0;
    private int Df = 0;
    private c axe = c.yg();
    private d axf = new d() { // from class: com.baidu.mario.b.a.1
        @Override // com.baidu.mario.b.d
        public void onRecorderStart(boolean z) {
            if (a.this.axj != null) {
                a.this.axj.onStart();
            }
        }

        @Override // com.baidu.mario.b.d
        public void N(long j) {
            a.this.axc = j;
            if (j > a.this.awY && a.this.axh) {
                a.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderComplete(boolean z, String str) {
            Log.i(a.TAG, "on RecorderComplete record time :" + a.this.axc);
            if (a.this.axj != null) {
                a.this.axj.l((int) a.this.axc, str);
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderError(int i) {
            Log.i(a.TAG, "onRecorderError:" + i);
            if (a.this.axj != null) {
                a.this.axj.onError(i);
            }
        }
    };

    public a(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.b.b.d(), this.axf);
    }

    public void setGameRecordCallback(b bVar) {
        this.axj = bVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.awB == null) {
                this.awB = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.awB.b(eGLContext);
            }
            this.awB.xS().setWidth(i);
            this.awB.xS().setHeight(i2);
            if (z) {
                this.awB.xU().a(MirrorType.VERTICALLY);
            }
            this.De = i;
            this.Df = i2;
            this.axg.setVideoWidth(i);
            this.axg.setVideoHeight(i2);
        }
    }

    public void cx(int i) {
        if (this.awB != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.awB.c(dVar);
                if (this.axe != null) {
                    this.axe.b(this.awB);
                }
                this.mTextureId = i;
            }
            c(this.mTextureId, System.nanoTime());
        }
    }

    private void c(int i, long j) {
        if (this.axh && this.axg != null) {
            switch (this.axi) {
                case 0:
                    ye();
                    if (this.axe != null) {
                        this.axe.a(this.mAppContext, this.axg, this.axf);
                    }
                    this.axi = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.awB.xR().setId(i);
                    if (this.axe != null) {
                        this.axe.c(this.awB);
                    }
                    this.axi = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.axi);
            }
        }
        if (this.axe != null && !this.awZ) {
            this.axe.O(j - this.axa);
        }
    }

    public long yb() {
        return this.axc;
    }

    public void yc() {
        if (!this.awZ) {
            this.axd = true;
            pauseRecord();
            return;
        }
        this.axd = false;
    }

    public void yd() {
        if (this.awZ && this.axd) {
            resumeRecord();
        }
        this.axd = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.axh) {
            Log.i(TAG, "startRecored");
            this.mIsLandscape = z2;
            this.axg.dq(str);
            this.axg.bh(z);
            this.axg.R(i * 1000);
            this.axg.setVideoWidth(this.De);
            this.axg.setVideoHeight(this.Df);
            if (i > 0 && i < 120) {
                this.awY = i * 1000;
            } else {
                this.awY = 120000;
            }
            c((com.baidu.mario.a.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        this.axh = true;
        this.axa = 0L;
        this.axc = 0L;
    }

    private void c(com.baidu.mario.a.e eVar) {
        if (this.axl == null) {
            yf();
        }
        if (eVar == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.awm = new com.baidu.mario.a.e();
        } else {
            this.awm = eVar;
        }
        this.axk = com.baidu.mario.a.a.a.xt();
        this.axk.a(this.awm, this.axl);
    }

    public void pauseRecord() {
        if (this.awZ) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.axh) {
            this.awZ = true;
            Log.i(TAG, "pauseRecord");
            this.axb = System.nanoTime();
            this.axa = 0L;
            if (this.axe != null) {
                this.axe.yj();
                this.axa = (this.axb - (this.axc * 1000000)) - this.axe.yh();
                if (this.axa < 0) {
                    this.axa = 0L;
                }
            }
            if (this.axj != null) {
                this.axj.onPause();
            }
        }
    }

    public void resumeRecord() {
        if (this.awZ) {
            this.axa += System.nanoTime() - this.axb;
            Log.i(TAG, "resumeRecord time dur:" + this.axa);
            this.awZ = false;
            if (this.axj != null) {
                this.axj.onResume();
            }
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        resumeRecord();
        this.axh = false;
        switch (this.axi) {
            case 0:
                return;
            case 1:
            case 2:
                this.axi = 0;
                if (this.axe != null) {
                    this.axe.yk();
                }
                if (this.axk != null) {
                    this.axk.a(this.axl);
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.axi);
        }
    }

    private void ye() {
        if (this.axg != null && this.awB != null) {
            int videoHeight = this.axg.getVideoHeight();
            int videoWidth = this.axg.getVideoWidth();
            if (videoHeight > videoWidth) {
                videoHeight = (this.axg.getVideoWidth() * this.awB.xS().getHeight()) / this.awB.xS().getWidth();
            } else {
                videoWidth = (this.axg.getVideoHeight() * this.awB.xS().getHeight()) / this.awB.xS().getWidth();
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
            this.axg.setVideoWidth(videoHeight);
            this.axg.setVideoHeight(videoWidth);
        }
    }

    public void a(com.baidu.mario.b.b.d dVar) {
        this.axg = dVar;
    }

    public void a(com.baidu.mario.b.b.d dVar, d dVar2) {
        a(dVar);
        this.axf = dVar2;
    }

    private void yf() {
        if (this.axl == null) {
            this.axl = new C0099a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.axe != null && this.axh && byteBuffer != null && i > 0 && !this.awZ) {
            this.axe.onAudioFrameAvailable(byteBuffer, i, j - this.axa);
        }
    }

    public void release() {
        if (this.axk != null) {
            this.axk.release();
            this.axk = null;
        }
        if (this.axe != null) {
            this.axe.onDestroy();
            this.axe = null;
        }
        if (this.axf != null) {
            this.axf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mario.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0099a implements com.baidu.mario.a.a.b {
        private WeakReference<a> axn;

        public C0099a(a aVar) {
            this.axn = new WeakReference<>(aVar);
            Log.i(a.TAG, "gameRecorderRef is:" + this.axn.get());
        }

        @Override // com.baidu.mario.a.a.b
        public void a(boolean z, com.baidu.mario.a.e eVar) {
            if (this.axn.get() != null) {
                this.axn.get().aY(z);
                Log.i(a.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.axn.get() != null) {
                this.axn.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioStop(boolean z) {
            Log.i(a.TAG, "onAudioStop");
        }
    }
}
