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
    private com.baidu.mario.a.e awE;
    private com.baidu.mario.gldraw2d.params.c awT;
    private int axA;
    private b axB;
    private com.baidu.mario.a.a.a axC;
    private com.baidu.mario.a.a.b axD;
    private long axs;
    private long axt;
    private long axu;
    private com.baidu.mario.b.b.d axy;
    private boolean axz;
    private Context mAppContext;
    private int axq = 120000;
    private int mTextureId = -1;
    private boolean axr = false;
    private boolean axv = false;
    private boolean mIsLandscape = false;
    private int DF = 0;
    private int DG = 0;
    private c axw = c.yf();
    private d axx = new d() { // from class: com.baidu.mario.b.a.1
        @Override // com.baidu.mario.b.d
        public void onRecorderStart(boolean z) {
            if (a.this.axB != null) {
                a.this.axB.onStart();
            }
        }

        @Override // com.baidu.mario.b.d
        public void O(long j) {
            a.this.axu = j;
            if (j > a.this.axq && a.this.axz) {
                a.this.stopRecord();
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderComplete(boolean z, String str) {
            Log.i(a.TAG, "on RecorderComplete record time :" + a.this.axu);
            if (a.this.axB != null) {
                a.this.axB.l((int) a.this.axu, str);
            }
        }

        @Override // com.baidu.mario.b.d
        public void onRecorderError(int i) {
            Log.i(a.TAG, "onRecorderError:" + i);
            if (a.this.axB != null) {
                a.this.axB.onError(i);
            }
        }
    };

    public a(Context context) {
        this.mAppContext = context;
        a(new com.baidu.mario.b.b.d(), this.axx);
    }

    public void setGameRecordCallback(b bVar) {
        this.axB = bVar;
    }

    public void a(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext != null) {
            this.mAppContext = context;
            Log.i(TAG, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
            if (this.awT == null) {
                this.awT = new com.baidu.mario.gldraw2d.params.c(eGLContext, 0, true);
            } else {
                this.awT.b(eGLContext);
            }
            this.awT.xR().setWidth(i);
            this.awT.xR().setHeight(i2);
            if (z) {
                this.awT.xT().a(MirrorType.VERTICALLY);
            }
            this.DF = i;
            this.DG = i2;
            this.axy.setVideoWidth(i);
            this.axy.setVideoHeight(i2);
        }
    }

    public void cx(int i) {
        if (this.awT != null) {
            if (this.mTextureId != i) {
                com.baidu.mario.gldraw2d.d.d dVar = new com.baidu.mario.gldraw2d.d.d();
                dVar.setId(i);
                this.awT.c(dVar);
                if (this.axw != null) {
                    this.axw.b(this.awT);
                }
                this.mTextureId = i;
            }
            e(this.mTextureId, System.nanoTime());
        }
    }

    private void e(int i, long j) {
        if (this.axz && this.axy != null) {
            switch (this.axA) {
                case 0:
                    yd();
                    if (this.axw != null) {
                        this.axw.a(this.mAppContext, this.axy, this.axx);
                    }
                    this.axA = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.awT.xQ().setId(i);
                    if (this.axw != null) {
                        this.axw.c(this.awT);
                    }
                    this.axA = 1;
                    break;
                default:
                    throw new RuntimeException("unknown status " + this.axA);
            }
        }
        if (this.axw != null && !this.axr) {
            this.axw.P(j - this.axs);
        }
    }

    public long ya() {
        return this.axu;
    }

    public void yb() {
        if (!this.axr) {
            this.axv = true;
            pauseRecord();
            return;
        }
        this.axv = false;
    }

    public void yc() {
        if (this.axr && this.axv) {
            resumeRecord();
        }
        this.axv = false;
    }

    public void startRecord(boolean z, int i, String str, boolean z2) {
        if (!this.axz) {
            Log.i(TAG, "startRecored");
            this.mIsLandscape = z2;
            this.axy.dq(str);
            this.axy.bh(z);
            this.axy.S(i * 1000);
            this.axy.setVideoWidth(this.DF);
            this.axy.setVideoHeight(this.DG);
            if (i > 0 && i < 120) {
                this.axq = i * 1000;
            } else {
                this.axq = 120000;
            }
            c((com.baidu.mario.a.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        this.axz = true;
        this.axs = 0L;
        this.axu = 0L;
    }

    private void c(com.baidu.mario.a.e eVar) {
        if (this.axD == null) {
            ye();
        }
        if (eVar == null) {
            Log.i(TAG, "audioParams is null,start to create AudioPams");
            this.awE = new com.baidu.mario.a.e();
        } else {
            this.awE = eVar;
        }
        this.axC = com.baidu.mario.a.a.a.xs();
        this.axC.a(this.awE, this.axD);
    }

    public void pauseRecord() {
        if (this.axr) {
            Log.i(TAG, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.axz) {
            this.axr = true;
            Log.i(TAG, "pauseRecord");
            this.axt = System.nanoTime();
            this.axs = 0L;
            if (this.axw != null) {
                this.axw.yi();
                this.axs = (this.axt - (this.axu * 1000000)) - this.axw.yg();
                if (this.axs < 0) {
                    this.axs = 0L;
                }
            }
            if (this.axB != null) {
                this.axB.onPause();
            }
        }
    }

    public void resumeRecord() {
        if (this.axr) {
            this.axs += System.nanoTime() - this.axt;
            Log.i(TAG, "resumeRecord time dur:" + this.axs);
            this.axr = false;
            if (this.axB != null) {
                this.axB.onResume();
            }
        }
    }

    public void stopRecord() {
        Log.i(TAG, "stopRecored");
        resumeRecord();
        this.axz = false;
        switch (this.axA) {
            case 0:
                return;
            case 1:
            case 2:
                this.axA = 0;
                if (this.axw != null) {
                    this.axw.yj();
                }
                if (this.axC != null) {
                    this.axC.a(this.axD);
                    return;
                }
                return;
            default:
                throw new RuntimeException("unknown status " + this.axA);
        }
    }

    private void yd() {
        if (this.axy != null && this.awT != null) {
            int videoHeight = this.axy.getVideoHeight();
            int videoWidth = this.axy.getVideoWidth();
            if (videoHeight > videoWidth) {
                videoHeight = (this.axy.getVideoWidth() * this.awT.xR().getHeight()) / this.awT.xR().getWidth();
            } else {
                videoWidth = (this.axy.getVideoHeight() * this.awT.xR().getHeight()) / this.awT.xR().getWidth();
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
            this.axy.setVideoWidth(videoHeight);
            this.axy.setVideoHeight(videoWidth);
        }
    }

    public void a(com.baidu.mario.b.b.d dVar) {
        this.axy = dVar;
    }

    public void a(com.baidu.mario.b.b.d dVar, d dVar2) {
        a(dVar);
        this.axx = dVar2;
    }

    private void ye() {
        if (this.axD == null) {
            this.axD = new C0099a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ByteBuffer byteBuffer, int i, long j) {
        if (this.axw != null && this.axz && byteBuffer != null && i > 0 && !this.axr) {
            this.axw.onAudioFrameAvailable(byteBuffer, i, j - this.axs);
        }
    }

    public void release() {
        if (this.axC != null) {
            this.axC.release();
            this.axC = null;
        }
        if (this.axw != null) {
            this.axw.onDestroy();
            this.axw = null;
        }
        if (this.axx != null) {
            this.axx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mario.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0099a implements com.baidu.mario.a.a.b {
        private WeakReference<a> axF;

        public C0099a(a aVar) {
            this.axF = new WeakReference<>(aVar);
            Log.i(a.TAG, "gameRecorderRef is:" + this.axF.get());
        }

        @Override // com.baidu.mario.a.a.b
        public void a(boolean z, com.baidu.mario.a.e eVar) {
            if (this.axF.get() != null) {
                this.axF.get().aY(z);
                Log.i(a.TAG, "onAudioStart");
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
            if (this.axF.get() != null) {
                this.axF.get().c(byteBuffer, i, j);
            }
        }

        @Override // com.baidu.mario.a.a.b
        public void onAudioStop(boolean z) {
            Log.i(a.TAG, "onAudioStop");
        }
    }
}
