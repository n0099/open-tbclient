package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.rtc.camera.a.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private FloatBuffer bCA;
    private FloatBuffer bCB;
    private int bCD;
    private int bCE;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mThread;
    private int mVideoHeight;
    private int mVideoWidth;
    private volatile boolean mIsGoingRelase = false;
    private d.a bCC = null;
    private long mEncoderCostMs = 0;
    private int mEncoderCostCount = 0;
    private long mLastInputEncodeMS = 0;
    private long mLastOutputEncodeMS = 0;
    private d bCx = null;
    private com.baidu.rtc.camera.filter.a.c bCy = null;
    private com.baidu.rtc.camera.filter.glfilter.a.a bCz = null;
    private com.baidu.rtc.camera.filter.a.a bCt = null;

    public c(Context context) {
        this.mThread = null;
        this.mHandler = null;
        this.mContext = context;
        this.mThread = new HandlerThread("TextureEncoder");
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    public void a(final EGLContext eGLContext, d.a aVar) {
        this.bCC = aVar;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(eGLContext, new d.a() { // from class: com.baidu.rtc.camera.a.c.1.1
                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onFormatChanged(MediaFormat mediaFormat) {
                        if (!c.this.mIsGoingRelase && c.this.bCC != null) {
                            c.this.bCC.onFormatChanged(mediaFormat);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecConfig(byte[] bArr, int i, int i2) {
                        if (!c.this.mIsGoingRelase && c.this.bCC != null) {
                            c.this.bCC.onCodecConfig(bArr, i, i2);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                        c.this.mLastOutputEncodeMS = System.currentTimeMillis();
                        if (!c.this.mIsGoingRelase && c.this.bCC != null) {
                            c.this.bCC.onCodecData(bArr, i, i2, i3, j);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecError(int i) {
                        if (!c.this.mIsGoingRelase && c.this.bCC != null) {
                            c.this.bCC.onCodecError(i);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EGLContext eGLContext, d.a aVar) {
        try {
            this.bCA = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDL);
            this.bCB = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDM);
            this.bCx = new d(aVar);
            this.bCx.a(aVar);
            this.bCt = new com.baidu.rtc.camera.filter.a.a(eGLContext, 1);
            this.bCy = new com.baidu.rtc.camera.filter.a.c(this.bCt, this.bCx.getInputSurface(), true);
            this.bCy.makeCurrent();
            if (this.bCz == null) {
                this.bCz = new com.baidu.rtc.camera.filter.glfilter.a.a(this.mContext);
            }
            this.mVideoWidth = b.Po().encodeWidth;
            this.mVideoHeight = b.Po().encodeHeight;
            this.bCz.S(this.bCD, this.bCE);
            this.bCz.T(this.mVideoWidth, this.mVideoHeight);
        } catch (Exception e) {
            e.printStackTrace();
            if (aVar != null) {
                aVar.onCodecError(3);
            }
        }
    }

    public void f(final int i, final long j) {
        if (!this.mIsGoingRelase) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.mLastInputEncodeMS = System.currentTimeMillis();
                    c.this.g(i, j);
                    if (c.this.mLastInputEncodeMS > 0 && c.this.mLastOutputEncodeMS > 0 && c.this.mLastInputEncodeMS > c.this.mLastOutputEncodeMS + 1000 && c.this.bCC != null) {
                        c.this.bCC.onCodecError(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, long j) {
        try {
            this.bCy.makeCurrent();
            this.bCx.drainEncoder(false);
            if (this.bCz != null) {
                GLES30.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
                this.bCz.a(i, this.bCA, this.bCB);
            }
            this.bCy.setPresentationTime(j);
            this.bCy.swapBuffers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            this.mIsGoingRelase = true;
            this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.doRelease();
                }
            });
            if (Build.VERSION.SDK_INT >= 18) {
                this.mThread.quitSafely();
                this.mHandler.removeCallbacksAndMessages(null);
            } else {
                this.mThread.join(200L);
                this.mThread.quit();
                this.mHandler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRelease() {
        com.baidu.rtc.camera.filter.glfilter.utils.a.checkGlError("mVideoEncoder start");
        if (this.bCx != null) {
            this.bCx.drainEncoder(true);
            this.bCx.release();
            this.bCx = null;
        }
        if (this.bCy != null) {
            this.bCy.release();
            this.bCy = null;
        }
        if (this.bCz != null) {
            this.bCz.release();
            this.bCz = null;
        }
        com.baidu.rtc.camera.filter.glfilter.utils.a.checkGlError("mVideoEncoder start");
        if (this.bCt != null) {
            this.bCt.release();
            this.bCt = null;
        }
    }
}
