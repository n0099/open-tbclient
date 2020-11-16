package com.baidu.ala.recorder.video.drawer;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.WindowSurface;
import com.baidu.ala.recorder.video.hardware.TextureEncoder;
import com.baidu.ala.recorder.video.hardware.VideoEncoderCore;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
@TargetApi(19)
/* loaded from: classes15.dex */
public class EncoderTextureDrawer {
    public static final int IDENTITY_90_MATRIX = 2;
    public static final int IDENTITY_MATRIX = 1;
    public static final int MIRROR_IDENTITY_90_MATRIX = 4;
    public static final int MIRROR_IDENTITY_MATRIX = 3;
    private static final boolean USE_YUV_CONVERT = false;
    public static final int X264_HEIGHT = 640;
    public static final int X264_WIDTH = 360;
    private static float[] mIdentityMatrix = new float[16];
    private static float[] mIdentityMatrix90 = new float[16];
    private static float[] mMirrorIdentityMatrix = new float[16];
    private static float[] mMirrorIdentityMatrix90 = new float[16];
    private static boolean matrixInit = false;
    public Handler dataHandler;
    public HandlerThread handlerThread;
    private boolean mCreateSucc;
    private IVideoRecorder.IVideoDataCallBack mDataCallback;
    private AFullFrameRect mFullScreen;
    private int mInputHeight;
    private int mInputWidth;
    private RecorderHandler mListener;
    private AlaLiveVideoConfig mVideoConfig;
    private boolean mRequestKeyFrame = false;
    private SWEncoder mSWEncoder = new SWEncoder();
    private HWEncoder mHWEncoder = new HWEncoder();
    private int mFrames = 0;
    private EglCore mEglCore = null;

    public EncoderTextureDrawer(RecorderHandler recorderHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mCreateSucc = false;
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.mListener = recorderHandler;
        this.mDataCallback = iVideoDataCallBack;
        this.mSWEncoder.surfaceWidth = 0;
        this.mSWEncoder.surfaceHeight = 0;
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.mCreateSucc = false;
        initMatrix();
    }

    public void onCreate(EglCore eglCore, AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mEglCore = eglCore;
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        this.mInputWidth = this.mVideoConfig.getPreviewWidth();
        this.mInputHeight = this.mVideoConfig.getPreviewHeight();
        encoderThreadInit();
        if (this.mVideoConfig.getEncoderType() == 2) {
            createImageReader();
        } else {
            createTextureEncoder();
        }
        this.mCreateSucc = true;
    }

    public void requestKeyframe() {
        this.mRequestKeyFrame = true;
    }

    public boolean isCreated() {
        return this.mCreateSucc;
    }

    public void onSurfaceChanged(int i, int i2) {
        if (this.mVideoConfig.getEncoderType() == 1) {
            createTextureEncoder();
        }
    }

    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null && alaLiveVideoConfig.getEncoderType() == 1 && this.mHWEncoder.encoder != null) {
            if (!AlaLiveVideoConfig.isEqual(this.mVideoConfig, alaLiveVideoConfig)) {
                if (AlaLiveVideoConfig.isUpdateBitrate(this.mVideoConfig, alaLiveVideoConfig) && TextureEncoder.isSupportBitRateOnFly()) {
                    this.mHWEncoder.encoder.updateBitrate(alaLiveVideoConfig.getBitStream());
                    this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
                } else {
                    this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
                    createTextureEncoder();
                }
            } else {
                return;
            }
        }
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    public void drawFrame(int i, float[] fArr, long j) {
        if (this.mVideoConfig.getEncoderType() == 1) {
            if (this.mHWEncoder.requestReset) {
                createTextureEncoder();
                this.mHWEncoder.resetCount++;
            }
            if (this.mHWEncoder.encoder != null) {
                this.mHWEncoder.encoder.drawFrame(i, fArr, j);
            }
        } else if (this.mSWEncoder.surface != null) {
            try {
                this.mSWEncoder.surface.makeCurrent();
                GlUtil.checkGlError("draw start");
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                GLES20.glViewport(0, 0, this.mInputWidth, this.mInputHeight);
                this.mFullScreen.drawFrame(i, fArr, null);
                this.mSWEncoder.surface.setPresentationTime(AlaNdkAdapter.getMediaStreamTS(true));
                if (!this.mSWEncoder.surface.swapBuffers()) {
                    BdLog.e("EncoderTextureDrawer.drawFrame swapBuffers failed");
                }
                GlUtil.checkGlError("draw end");
            } catch (Exception e) {
                try {
                    this.mSWEncoder.surface.release();
                    this.mSWEncoder.surface = null;
                } catch (Exception e2) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onSurfaceDestroy() {
    }

    public void onRelease() {
        destroyImageReader();
        destroyYuvOutput();
        hwEncoderHandleUnit();
        encoderThreadUnit();
    }

    public VideoFormat getVideoFormat() {
        if (this.mVideoConfig == null || this.mVideoConfig.getEncoderType() == 2) {
        }
        return VideoFormat.RGBA;
    }

    private void encoderThreadInit() {
        if (this.handlerThread == null && this.dataHandler == null) {
            this.handlerThread = new HandlerThread("ala_live_encoder");
            this.handlerThread.start();
            this.dataHandler = new Handler(this.handlerThread.getLooper());
        }
    }

    private void encoderThreadUnit() {
        if (this.handlerThread != null && this.handlerThread.getLooper() != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.handlerThread.getLooper().quitSafely();
            } else {
                this.handlerThread.getLooper().quit();
            }
        }
        this.handlerThread = null;
        this.dataHandler = null;
    }

    private void createImageReader() {
        if (this.mFullScreen == null) {
            this.mFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
        if (this.mSWEncoder.imageReader == null && this.mInputWidth != 0 && this.mInputHeight != 0) {
            this.mSWEncoder.imageReader = ImageReader.newInstance(this.mInputWidth, this.mInputHeight, 1, 1);
            try {
                this.mSWEncoder.imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer.1
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public void onImageAvailable(ImageReader imageReader) {
                        if (EncoderTextureDrawer.this.mSWEncoder.imageReader != null) {
                            Image image = null;
                            try {
                                Image acquireNextImage = EncoderTextureDrawer.this.mSWEncoder.imageReader.acquireNextImage();
                                EncoderTextureDrawer.this.mSWEncoder.hasReportFrameError = false;
                                if (acquireNextImage != null) {
                                    try {
                                        ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                                        if (buffer == null) {
                                            acquireNextImage.close();
                                            return;
                                        }
                                        try {
                                            int pixelStride = acquireNextImage.getPlanes()[0].getPixelStride();
                                            EncoderTextureDrawer.this.mSWEncoder.lineSize = (acquireNextImage.getPlanes()[0].getRowStride() / pixelStride) * 4;
                                            buffer.rewind();
                                            int remaining = buffer.remaining();
                                            if (EncoderTextureDrawer.this.mSWEncoder.sendBuffer == null || EncoderTextureDrawer.this.mSWEncoder.sendBuffer.length < remaining) {
                                                EncoderTextureDrawer.this.mSWEncoder.sendBuffer = new byte[remaining];
                                            }
                                            buffer.get(EncoderTextureDrawer.this.mSWEncoder.sendBuffer);
                                            acquireNextImage.close();
                                            if (EncoderTextureDrawer.this.mDataCallback != null) {
                                                EncoderTextureDrawer.this.mDataCallback.onRawVideoFrameReceived(EncoderTextureDrawer.this.mSWEncoder.sendBuffer, remaining, 0, EncoderTextureDrawer.this.mSWEncoder.lineSize);
                                            }
                                        } catch (IllegalStateException e) {
                                            e.printStackTrace();
                                            acquireNextImage.close();
                                        } catch (Throwable th) {
                                            acquireNextImage.close();
                                        }
                                    } catch (IllegalStateException e2) {
                                        acquireNextImage.close();
                                    }
                                }
                            } catch (UnsupportedOperationException e3) {
                                if (EncoderTextureDrawer.this.mListener != null && !EncoderTextureDrawer.this.mSWEncoder.hasReportFrameError) {
                                    EncoderTextureDrawer.this.mListener.sendError(1, e3.getMessage());
                                    EncoderTextureDrawer.this.mSWEncoder.hasReportFrameError = true;
                                }
                                if (0 != 0) {
                                    image.close();
                                }
                            } catch (Throwable th2) {
                                if (0 != 0) {
                                    image.close();
                                }
                            }
                        }
                    }
                }, this.dataHandler);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            setEncoderSurface(this.mSWEncoder.imageReader.getSurface());
        }
    }

    private void destroyImageReader() {
        try {
            if (this.mFullScreen != null) {
                this.mFullScreen.release(true);
                this.mFullScreen = null;
            }
            if (this.mSWEncoder.imageReader != null) {
                this.mSWEncoder.imageReader.setOnImageAvailableListener(null, null);
                this.mSWEncoder.imageReader.close();
                this.mSWEncoder.imageReader = null;
            }
            if (this.mSWEncoder.surface != null) {
                this.mSWEncoder.surface.release();
                this.mSWEncoder.surface = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createYuvOutput() {
        if (this.mSWEncoder.yuvOutput != null) {
            this.mSWEncoder.yuvOutput.destroy();
            this.mSWEncoder.yuvOutput = null;
        }
        this.mSWEncoder.yuvOutput = new YuvOutputDrawer(1);
        this.mSWEncoder.yuvOutput.create();
        this.mSWEncoder.x264Width = this.mVideoConfig.getVideoWidth();
        this.mSWEncoder.x264Height = this.mVideoConfig.getVideoHeight();
        this.mSWEncoder.yuvOutput.sizeChanged(this.mSWEncoder.x264Width, this.mSWEncoder.x264Height);
        this.mSWEncoder.yuvBuffer = new byte[((this.mSWEncoder.x264Width * this.mSWEncoder.x264Height) * 3) / 2];
    }

    private void yuvOutputDraw(int i, float[] fArr, long j) {
        try {
            this.mSWEncoder.yuvOutput.drawToTexture(i);
            int i2 = ((this.mSWEncoder.x264Width * this.mSWEncoder.x264Height) * 3) / 2;
            this.mSWEncoder.yuvOutput.getOutput(this.mSWEncoder.yuvBuffer, 0, i2);
            this.mDataCallback.onRawVideoFrameReceived(this.mSWEncoder.yuvBuffer, i2, 0, this.mSWEncoder.x264Width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeTestFiles(byte[] bArr) {
        this.mFrames++;
        if (this.mFrames % 20 == 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.yuv"));
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void destroyYuvOutput() {
        if (this.mSWEncoder != null && this.mSWEncoder.yuvOutput != null) {
            try {
                this.mSWEncoder.yuvOutput.destroy();
                this.mSWEncoder.yuvOutput = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setEncoderSurface(Surface surface) {
        try {
            if (this.mSWEncoder.surface != null) {
                this.mSWEncoder.surface.release();
                this.mSWEncoder.surface = null;
            }
            this.mSWEncoder.surface = new WindowSurface(this.mEglCore, surface, true);
        } catch (Exception e) {
            if (this.mListener != null) {
                this.mListener.sendError(3, e.getMessage());
            }
        }
    }

    private void createTextureEncoder() {
        if (this.mEglCore != null) {
            this.mHWEncoder.requestReset = false;
            if (this.mHWEncoder.encoder != null) {
                this.mHWEncoder.encoder.release();
                this.mHWEncoder.encoder = new TextureEncoder(this.dataHandler);
            }
            if (this.mHWEncoder.encoder == null) {
                this.mHWEncoder.encoder = new TextureEncoder(this.dataHandler);
            }
            TextureEncoder.EncodeConfig encodeConfig = new TextureEncoder.EncodeConfig();
            encodeConfig.encodeWidth = this.mVideoConfig.getVideoWidth();
            encodeConfig.encodeHeight = this.mVideoConfig.getVideoHeight();
            encodeConfig.encodeBitrate = this.mVideoConfig.getBitStream();
            encodeConfig.isLandscape = this.mVideoConfig.isLandscape();
            encodeConfig.H264GOP = this.mVideoConfig.getVideoGOP();
            encodeConfig.H264FPS = this.mVideoConfig.getVideoFPS();
            this.mHWEncoder.encoder.prepare(this.mEglCore.getEGLContext(), encodeConfig, new VideoEncoderCore.OutputCallback() { // from class: com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer.2
                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onFormatChanged(MediaFormat mediaFormat) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecConfig(byte[] bArr, int i, int i2) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecData(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                    if (!EncoderTextureDrawer.this.mRequestKeyFrame || i3 == 2) {
                        if (EncoderTextureDrawer.this.mRequestKeyFrame && i3 == 2) {
                            EncoderTextureDrawer.this.mRequestKeyFrame = false;
                        }
                        if (EncoderTextureDrawer.this.mDataCallback != null) {
                            EncoderTextureDrawer.this.mDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j, j2);
                        }
                    }
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecError(int i) {
                    BdLog.e("resetTextureEncoder onCodecError -- " + i);
                    EncoderTextureDrawer.this.mHWEncoder.requestReset = true;
                    if (EncoderTextureDrawer.this.mDataCallback != null) {
                        EncoderTextureDrawer.this.mDataCallback.onError(i);
                    }
                }
            });
        }
    }

    private void hwEncoderHandleUnit() {
        if (this.mHWEncoder != null && this.mHWEncoder.encoder != null) {
            this.mHWEncoder.encoder.release();
        }
    }

    public static float[] getMatrix(int i) {
        if (1 == i) {
            return mIdentityMatrix;
        }
        if (2 == i) {
            return mIdentityMatrix90;
        }
        if (3 == i) {
            return mMirrorIdentityMatrix;
        }
        if (4 == i) {
            return mMirrorIdentityMatrix90;
        }
        return mIdentityMatrix;
    }

    private static synchronized void initMatrix() {
        synchronized (EncoderTextureDrawer.class) {
            if (!matrixInit) {
                matrixInit = true;
                Matrix.setIdentityM(mIdentityMatrix, 0);
                AlaLiveUtilHelper.getTextureMatrix(mIdentityMatrix90, 90.0f, true);
                AlaLiveUtilHelper.getTextureMatrix(mMirrorIdentityMatrix, 0.0f, false);
                AlaLiveUtilHelper.getTextureMatrix(mMirrorIdentityMatrix90, 90.0f, false);
            }
        }
    }

    private static int getNearSize(int i) {
        long j = i;
        if (j % 8 != 0) {
            return (int) ((j & (-8)) + 8);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class SWEncoder {
        public ImageReader imageReader;
        public byte[] sendBuffer;
        public WindowSurface surface;
        public int surfaceHeight;
        public int surfaceWidth;
        public int x264Height;
        public int x264Width;
        public YuvOutputDrawer yuvOutput;
        private byte[] yuvBuffer = null;
        public boolean hasReportFrameError = false;
        public int lineSize = 0;

        SWEncoder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class HWEncoder {
        public TextureEncoder encoder;
        public boolean requestReset = false;
        public int resetCount = 0;

        HWEncoder() {
        }
    }
}
