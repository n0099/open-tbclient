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
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private int csv;
    private int csw;
    private Context mContext;
    private Handler mHandler;
    private FloatBuffer mTextureBuffer;
    private HandlerThread mThread;
    private FloatBuffer mVertexBuffer;
    private int mVideoHeight;
    private int mVideoWidth;
    private volatile boolean mIsGoingRelase = false;
    private d.a csu = null;
    private long mEncoderCostMs = 0;
    private int mEncoderCostCount = 0;
    private long mLastInputEncodeMS = 0;
    private long mLastOutputEncodeMS = 0;
    private d csr = null;
    private com.baidu.rtc.camera.filter.a.c css = null;
    private com.baidu.rtc.camera.filter.glfilter.a.a cst = null;
    private com.baidu.rtc.camera.filter.a.a csm = null;

    public c(Context context) {
        this.mThread = null;
        this.mHandler = null;
        this.mContext = context;
        this.mThread = new HandlerThread("TextureEncoder");
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    public void a(final EGLContext eGLContext, d.a aVar) {
        this.csu = aVar;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(eGLContext, new d.a() { // from class: com.baidu.rtc.camera.a.c.1.1
                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onFormatChanged(MediaFormat mediaFormat) {
                        if (!c.this.mIsGoingRelase && c.this.csu != null) {
                            c.this.csu.onFormatChanged(mediaFormat);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecConfig(byte[] bArr, int i, int i2) {
                        if (!c.this.mIsGoingRelase && c.this.csu != null) {
                            c.this.csu.onCodecConfig(bArr, i, i2);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                        c.this.mLastOutputEncodeMS = System.currentTimeMillis();
                        if (!c.this.mIsGoingRelase && c.this.csu != null) {
                            c.this.csu.onCodecData(bArr, i, i2, i3, j);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecError(int i) {
                        if (!c.this.mIsGoingRelase && c.this.csu != null) {
                            c.this.csu.onCodecError(i);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EGLContext eGLContext, d.a aVar) {
        try {
            this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctB);
            this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctC);
            this.csr = new d(aVar);
            this.csr.a(aVar);
            this.csm = new com.baidu.rtc.camera.filter.a.a(eGLContext, 1);
            this.css = new com.baidu.rtc.camera.filter.a.c(this.csm, this.csr.getInputSurface(), true);
            this.css.makeCurrent();
            if (this.cst == null) {
                this.cst = new com.baidu.rtc.camera.filter.glfilter.a.a(this.mContext);
            }
            this.mVideoWidth = b.agA().encodeWidth;
            this.mVideoHeight = b.agA().encodeHeight;
            this.cst.onInputSizeChanged(this.csv, this.csw);
            this.cst.Z(this.mVideoWidth, this.mVideoHeight);
        } catch (Exception e) {
            e.printStackTrace();
            if (aVar != null) {
                aVar.onCodecError(3);
            }
        }
    }

    public void g(final int i, final long j) {
        if (!this.mIsGoingRelase) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.mLastInputEncodeMS = System.currentTimeMillis();
                    c.this.h(i, j);
                    if (c.this.mLastInputEncodeMS > 0 && c.this.mLastOutputEncodeMS > 0 && c.this.mLastInputEncodeMS > c.this.mLastOutputEncodeMS + 1000 && c.this.csu != null) {
                        c.this.csu.onCodecError(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, long j) {
        try {
            this.css.makeCurrent();
            this.csr.drainEncoder(false);
            if (this.cst != null) {
                GLES30.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
                this.cst.a(i, this.mVertexBuffer, this.mTextureBuffer);
            }
            this.css.setPresentationTime(j);
            this.css.swapBuffers();
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
        if (this.csr != null) {
            this.csr.drainEncoder(true);
            this.csr.release();
            this.csr = null;
        }
        if (this.css != null) {
            this.css.release();
            this.css = null;
        }
        if (this.cst != null) {
            this.cst.release();
            this.cst = null;
        }
        com.baidu.rtc.camera.filter.glfilter.utils.a.checkGlError("mVideoEncoder start");
        if (this.csm != null) {
            this.csm.release();
            this.csm = null;
        }
    }
}
