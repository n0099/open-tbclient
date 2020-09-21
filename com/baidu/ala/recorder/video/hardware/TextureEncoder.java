package com.baidu.ala.recorder.video.hardware;

import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.WindowSurface;
import com.baidu.ala.recorder.video.hardware.VideoEncoderCore;
/* loaded from: classes12.dex */
public class TextureEncoder {
    private static final int ENCODE_TIMEOUT_MS = 1000;
    private static final int OFFSET = 20;
    private static final String TAG = TextureEncoder.class.getSimpleName();
    private static final boolean VERBOSE = false;
    private static final boolean mUseModelFit = false;
    private Handler mHandler;
    private float[] mEncoderVertex = new float[8];
    private volatile boolean mIsGoingRelase = false;
    private VideoEncoderCore.OutputCallback mCallback = null;
    private long mEncoderCostMs = 0;
    private int mEncoderCostCount = 0;
    private long mLastInputEncodeMS = 0;
    private long mLastOutputEncodeMS = 0;
    private VideoEncoderCore mVideoEncoder = null;
    private WindowSurface mInputWindowSurface = null;
    private AFullFrameRect mFullScreen = null;
    private EglCore mEglCore = null;

    public TextureEncoder(Handler handler) {
        this.mHandler = null;
        this.mHandler = handler;
    }

    public void prepare(final EGLContext eGLContext, final EncodeConfig encodeConfig, VideoEncoderCore.OutputCallback outputCallback) {
        this.mCallback = outputCallback;
        this.mHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.TextureEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                TextureEncoder.this.doPrepare(eGLContext, encodeConfig, new VideoEncoderCore.OutputCallback() { // from class: com.baidu.ala.recorder.video.hardware.TextureEncoder.1.1
                    @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                    public void onFormatChanged(MediaFormat mediaFormat) {
                        if (!TextureEncoder.this.mIsGoingRelase && TextureEncoder.this.mCallback != null) {
                            TextureEncoder.this.mCallback.onFormatChanged(mediaFormat);
                        }
                    }

                    @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                    public void onCodecConfig(byte[] bArr, int i, int i2) {
                        if (!TextureEncoder.this.mIsGoingRelase && TextureEncoder.this.mCallback != null) {
                            TextureEncoder.this.mCallback.onCodecConfig(bArr, i, i2);
                        }
                    }

                    @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                    public void onCodecData(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                        TextureEncoder.this.mLastOutputEncodeMS = System.currentTimeMillis();
                        if (!TextureEncoder.this.mIsGoingRelase && TextureEncoder.this.mCallback != null) {
                            TextureEncoder.this.mCallback.onCodecData(bArr, i, i2, i3, j, j2);
                        }
                    }

                    @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                    public void onCodecError(int i) {
                        if (!TextureEncoder.this.mIsGoingRelase && TextureEncoder.this.mCallback != null) {
                            TextureEncoder.this.mCallback.onCodecError(i);
                        }
                    }
                });
            }
        });
    }

    public static boolean isSupportBitRateOnFly() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public void updateBitrate(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.TextureEncoder.2
            @Override // java.lang.Runnable
            public void run() {
                TextureEncoder.this.doUpdateRate(i);
            }
        });
    }

    public void doUpdateRate(int i) {
        this.mVideoEncoder.updateBitrate(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPrepare(EGLContext eGLContext, EncodeConfig encodeConfig, VideoEncoderCore.OutputCallback outputCallback) {
        try {
            this.mVideoEncoder = new VideoEncoderCore(encodeConfig, outputCallback);
            this.mVideoEncoder.setOutputCallback(outputCallback);
            this.mEglCore = new EglCore(eGLContext, 1);
            this.mInputWindowSurface = new WindowSurface(this.mEglCore, this.mVideoEncoder.getInputSurface(), true);
            this.mInputWindowSurface.makeCurrent();
            this.mFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            setVertexArray();
        } catch (Exception e) {
            e.printStackTrace();
            if (outputCallback != null) {
                outputCallback.onCodecError(3);
            }
        }
    }

    private void setVertexArray() {
        if (this.mFullScreen != null && this.mFullScreen.getVertexCount() == 4) {
            boolean z = this.mVideoEncoder.getEncodeConfig().isLandscape;
            this.mEncoderVertex = AlaLiveUtilHelper.getVertexArray(this.mInputWindowSurface.getWidth(), this.mInputWindowSurface.getHeight(), z ? this.mVideoEncoder.getEncodeConfig().encodeHeight : this.mVideoEncoder.getEncodeConfig().encodeWidth, z ? this.mVideoEncoder.getEncodeConfig().encodeWidth : this.mVideoEncoder.getEncodeConfig().encodeHeight, false);
            this.mFullScreen.resetVertexArray(this.mEncoderVertex);
        }
    }

    public void drawFrame(final int i, final float[] fArr, final long j) {
        if (!this.mIsGoingRelase) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.TextureEncoder.3
                @Override // java.lang.Runnable
                public void run() {
                    TextureEncoder.this.mLastInputEncodeMS = System.currentTimeMillis();
                    TextureEncoder.this.doDrawFrame(i, fArr, j);
                    if (TextureEncoder.this.mLastInputEncodeMS > 0 && TextureEncoder.this.mLastOutputEncodeMS > 0 && TextureEncoder.this.mLastInputEncodeMS > TextureEncoder.this.mLastOutputEncodeMS + 1000 && TextureEncoder.this.mCallback != null) {
                        TextureEncoder.this.mCallback.onCodecError(2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDrawFrame(int i, float[] fArr, long j) {
        try {
            this.mInputWindowSurface.makeCurrent();
            this.mVideoEncoder.drainEncoder(false);
            this.mFullScreen.drawFrame(i, fArr);
            this.mInputWindowSurface.setPresentationTime(j);
            this.mInputWindowSurface.swapBuffers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            this.mIsGoingRelase = true;
            this.mHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.TextureEncoder.4
                @Override // java.lang.Runnable
                public void run() {
                    TextureEncoder.this.doRelease();
                }
            });
            GlUtil.logPrint("TextureEncoder.release end ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRelease() {
        GlUtil.logPrint("TextureEncoder.doRelease begin ");
        if (this.mVideoEncoder != null) {
            this.mVideoEncoder.drainEncoder(true);
            this.mVideoEncoder.release();
            this.mVideoEncoder = null;
        }
        if (this.mInputWindowSurface != null) {
            this.mInputWindowSurface.release();
            this.mInputWindowSurface = null;
        }
        if (this.mFullScreen != null) {
            this.mFullScreen.release(false);
            this.mFullScreen = null;
        }
        if (this.mEglCore != null) {
            this.mEglCore.release();
            this.mEglCore = null;
        }
        GlUtil.logPrint("TextureEncoder.doRelease done ");
    }

    /* loaded from: classes12.dex */
    public static class EncodeConfig {
        public int H264FPS;
        public int H264GOP;
        public int encodeBitrate;
        public int encodeHeight;
        public int encodeWidth;
        public boolean isLandscape;

        public static EncodeConfig CloneObj(EncodeConfig encodeConfig) {
            EncodeConfig encodeConfig2 = new EncodeConfig();
            encodeConfig2.encodeWidth = encodeConfig.encodeWidth;
            encodeConfig2.encodeHeight = encodeConfig.encodeHeight;
            encodeConfig2.encodeBitrate = encodeConfig.encodeBitrate;
            encodeConfig2.H264GOP = encodeConfig.H264GOP;
            encodeConfig2.H264FPS = encodeConfig.H264FPS;
            encodeConfig2.isLandscape = encodeConfig.isLandscape;
            return encodeConfig2;
        }
    }
}
