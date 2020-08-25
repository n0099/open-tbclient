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
    private int bNp;
    private int bNq;
    private Context mContext;
    private Handler mHandler;
    private FloatBuffer mTextureBuffer;
    private HandlerThread mThread;
    private FloatBuffer mVertexBuffer;
    private int mVideoHeight;
    private int mVideoWidth;
    private volatile boolean mIsGoingRelase = false;
    private d.a bNo = null;
    private long mEncoderCostMs = 0;
    private int mEncoderCostCount = 0;
    private long mLastInputEncodeMS = 0;
    private long mLastOutputEncodeMS = 0;
    private d bNl = null;
    private com.baidu.rtc.camera.filter.a.c bNm = null;
    private com.baidu.rtc.camera.filter.glfilter.a.a bNn = null;
    private com.baidu.rtc.camera.filter.a.a bNg = null;

    public c(Context context) {
        this.mThread = null;
        this.mHandler = null;
        this.mContext = context;
        this.mThread = new HandlerThread("TextureEncoder");
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    public void a(final EGLContext eGLContext, d.a aVar) {
        this.bNo = aVar;
        this.mHandler.post(new Runnable() { // from class: com.baidu.rtc.camera.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(eGLContext, new d.a() { // from class: com.baidu.rtc.camera.a.c.1.1
                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onFormatChanged(MediaFormat mediaFormat) {
                        if (!c.this.mIsGoingRelase && c.this.bNo != null) {
                            c.this.bNo.onFormatChanged(mediaFormat);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecConfig(byte[] bArr, int i, int i2) {
                        if (!c.this.mIsGoingRelase && c.this.bNo != null) {
                            c.this.bNo.onCodecConfig(bArr, i, i2);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                        c.this.mLastOutputEncodeMS = System.currentTimeMillis();
                        if (!c.this.mIsGoingRelase && c.this.bNo != null) {
                            c.this.bNo.onCodecData(bArr, i, i2, i3, j);
                        }
                    }

                    @Override // com.baidu.rtc.camera.a.d.a
                    public void onCodecError(int i) {
                        if (!c.this.mIsGoingRelase && c.this.bNo != null) {
                            c.this.bNo.onCodecError(i);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EGLContext eGLContext, d.a aVar) {
        try {
            this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOw);
            this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOx);
            this.bNl = new d(aVar);
            this.bNl.a(aVar);
            this.bNg = new com.baidu.rtc.camera.filter.a.a(eGLContext, 1);
            this.bNm = new com.baidu.rtc.camera.filter.a.c(this.bNg, this.bNl.getInputSurface(), true);
            this.bNm.makeCurrent();
            if (this.bNn == null) {
                this.bNn = new com.baidu.rtc.camera.filter.glfilter.a.a(this.mContext);
            }
            this.mVideoWidth = b.WF().encodeWidth;
            this.mVideoHeight = b.WF().encodeHeight;
            this.bNn.onInputSizeChanged(this.bNp, this.bNq);
            this.bNn.X(this.mVideoWidth, this.mVideoHeight);
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
                    if (c.this.mLastInputEncodeMS > 0 && c.this.mLastOutputEncodeMS > 0 && c.this.mLastInputEncodeMS > c.this.mLastOutputEncodeMS + 1000 && c.this.bNo != null) {
                        c.this.bNo.onCodecError(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, long j) {
        try {
            this.bNm.makeCurrent();
            this.bNl.drainEncoder(false);
            if (this.bNn != null) {
                GLES30.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
                this.bNn.a(i, this.mVertexBuffer, this.mTextureBuffer);
            }
            this.bNm.setPresentationTime(j);
            this.bNm.swapBuffers();
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
        if (this.bNl != null) {
            this.bNl.drainEncoder(true);
            this.bNl.release();
            this.bNl = null;
        }
        if (this.bNm != null) {
            this.bNm.release();
            this.bNm = null;
        }
        if (this.bNn != null) {
            this.bNn.release();
            this.bNn = null;
        }
        com.baidu.rtc.camera.filter.glfilter.utils.a.checkGlError("mVideoEncoder start");
        if (this.bNg != null) {
            this.bNg.release();
            this.bNg = null;
        }
    }
}
