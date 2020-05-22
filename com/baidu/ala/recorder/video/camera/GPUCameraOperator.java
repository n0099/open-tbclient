package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.camera.AlaCameraRecorder;
import com.baidu.ala.recorder.video.gles.AFullFrameRect;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.EglSurfaceBase;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.OffscreenSurface;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.WindowSurface;
import com.baidu.ala.recorder.video.hardware.TextureEncoder;
import com.baidu.ala.recorder.video.hardware.VideoEncoderCore;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class GPUCameraOperator implements ICameraOperator {
    private static final int DEFAULT_ROTATE = 0;
    private static final int MAX_DROP_FIRST_FRAMES = 5;
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final String TAG = "AlaLiveRecorder_GPU";
    private WeakReference<Activity> mActivityReference;
    private AFullFrameRect mCamFullScreen;
    private Camera mCamera;
    private byte[] mCameraNV21Byte;
    private int mCameraPreviewHeight;
    private int mCameraPreviewWidth;
    private SurfaceTexture mCameraTexture;
    private int mCameraTxtId;
    private WindowSurface mCodecWindowSurface;
    private AlaLiveVideoConfig mConfig;
    private IVideoRecorder.IVideoDataCallBack mDataCallback;
    private Handler mDataThreadHandler;
    private int mDepthBuffer;
    private EglCore mEglCore;
    private int mFramebuffer;
    private HandlerThread mHandlerThread;
    private ImageReader mImageReader;
    private AFullFrameRect mOffFullScreen;
    private float[] mPreviewVertex;
    private RecorderHandler mRecorderHandler;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private boolean mVideoModelFit;
    private WindowSurface mWindowSurface;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);
    private int mWindowSurfaceWidth = 0;
    private int mWindowSurfaceHeight = 0;
    private int mDropFrames = 0;
    private volatile int mBeautyLevel = 3;
    private int mCameraId = 1;
    private int mEncodeWidth = 0;
    private int mEncodeHeight = 0;
    private int mOffscreenTexture = 0;
    private float[] mIdentityMatrix = new float[16];
    private float[] mIdentityMatrix90 = new float[16];
    private float[] mMirrorIdentityMatrix = new float[16];
    private float[] mMirrorIdentityMatrix90 = new float[16];
    private volatile boolean mIsMirror = false;
    private boolean mHasReportFrameError = false;
    private byte[] mSendBuffer = null;
    private int mImgLineSize = 0;
    private TextureEncoder mEncoder = null;
    private volatile boolean mRequestEncoderReset = false;
    private int mEncoderRestCount = 0;
    private volatile boolean mRequestKeyFrame = true;
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.1
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            GPUCameraOperator.this.mCamera.addCallbackBuffer(bArr);
            GPUCameraOperator.this.mCameraNV21Byte = bArr;
            GPUCameraOperator.this.frameAvailable();
        }
    };

    public GPUCameraOperator(Activity activity, AlaCameraRecorder.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack, RecorderHandler recorderHandler) {
        this.mActivityReference = null;
        this.mSurfaceHolder = surfaceHolder;
        this.mRecorderHandler = recorderHandler;
        this.mDataCallback = iVideoDataCallBack;
        this.mActivityReference = new WeakReference<>(activity);
        Matrix.setIdentityM(this.mIdentityMatrix, 0);
        AlaLiveUtilHelper.getTextureMatrix(this.mIdentityMatrix90, 90.0f, true);
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix, 0.0f, false);
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix90, 90.0f, false);
        this.mPreviewVertex = new float[8];
        this.mVideoModelFit = false;
        initResource();
        this.mHandlerThread = new HandlerThread("ala_live_recorder_gpu");
        this.mHandlerThread.start();
        this.mDataThreadHandler = new Handler(this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void frameAvailable() {
        float[] fArr = new float[16];
        try {
            this.mCameraTexture.updateTexImage();
            this.mCameraTexture.getTransformMatrix(fArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mPreviewFpsLimit.trackFrame()) {
            try {
                if (this.mCameraNV21Byte == null || this.mCameraNV21Byte.length == 0) {
                    Log.e(TAG, "camera nv21 bytes null");
                } else if (this.mWindowSurface != null) {
                    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
                    GlUtil.checkGlError("glBindFramebuffer");
                    this.mWindowSurface.makeCurrent();
                    GLES20.glViewport(0, 0, this.mCameraPreviewHeight, this.mCameraPreviewWidth);
                    this.mCamFullScreen.drawFrame2(this.mCameraTxtId, fArr);
                    if (this.mDropFrames < 5) {
                        this.mDropFrames++;
                        return;
                    }
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkGlError("glBindFramebuffer");
                    this.mWindowSurface.makeCurrent();
                    GLES20.glViewport(0, 0, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    this.mOffFullScreen.drawFrame2(this.mOffscreenTexture, this.mIdentityMatrix);
                    if (!this.mWindowSurface.swapBuffers()) {
                        try {
                            this.mWindowSurface.release();
                            this.mWindowSurface = null;
                            this.mWindowSurface = new WindowSurface(this.mEglCore, this.mSurfaceHolder.getSurface(), false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (this.mIsMirror) {
                        doDrawEncodeSurface(this.mCodecWindowSurface, this.mMirrorIdentityMatrix, AlaNdkAdapter.getMediaStreamTS(true));
                    } else {
                        doDrawEncodeSurface(this.mCodecWindowSurface, this.mIdentityMatrix, AlaNdkAdapter.getMediaStreamTS(true));
                    }
                    this.mWindowSurface.makeCurrent();
                    GlUtil.checkGlError("draw done");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void doDrawEncodeSurface(EglSurfaceBase eglSurfaceBase, float[] fArr, long j) {
        if (this.mConfig.getEncoderType() == 1) {
            if (this.mRequestEncoderReset) {
                resetTextureEncoder();
                this.mEncoderRestCount++;
            }
            if (this.mEncoder != null) {
                this.mEncoder.drawFrame(this.mOffscreenTexture, fArr, j);
            }
        } else if (eglSurfaceBase != null) {
            try {
                eglSurfaceBase.makeCurrent();
                GlUtil.checkGlError("draw start");
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                GLES20.glViewport(0, 0, this.mEncodeHeight, this.mEncodeWidth);
                this.mOffFullScreen.drawFrame(this.mOffscreenTexture, fArr, null);
                eglSurfaceBase.setPresentationTime(this.mCameraTexture.getTimestamp());
                eglSurfaceBase.swapBuffers();
            } catch (Exception e) {
                try {
                    if (eglSurfaceBase instanceof WindowSurface) {
                        ((WindowSurface) eglSurfaceBase).release();
                        this.mCodecWindowSurface = null;
                    } else if (eglSurfaceBase instanceof OffscreenSurface) {
                        ((OffscreenSurface) eglSurfaceBase).release();
                    }
                } catch (Exception e2) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i) {
        this.mCamera = camera;
        if (this.mActivityReference.get() == null) {
            return false;
        }
        this.mCameraId = i;
        this.mDropFrames = 0;
        Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
        this.mCameraPreviewWidth = previewSize.width;
        this.mCameraPreviewHeight = previewSize.height;
        this.mEncodeWidth = this.mCameraPreviewWidth;
        this.mEncodeHeight = this.mCameraPreviewHeight;
        if (this.mCameraTexture == null) {
            setupSurface(this.mSurfaceHolder);
            if (this.mConfig.getEncoderType() == 1) {
                resetTextureEncoder();
            } else {
                resetImageReader(true);
            }
        } else {
            this.mRequestKeyFrame = true;
        }
        return true;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public Camera.PreviewCallback getPreviewCallback() {
        return this.mPreviewCallback;
    }

    private void setupSurface(AlaCameraRecorder.SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            Surface surface = surfaceHolder.getSurface();
            try {
                try {
                    if (this.mWindowSurface == null) {
                        this.mWindowSurface = new WindowSurface(this.mEglCore, surface, false);
                        this.mWindowSurface.makeCurrent();
                        if (this.mWindowSurfaceWidth == 0) {
                            this.mWindowSurfaceWidth = this.mWindowSurface.getWidth();
                        }
                        if (this.mWindowSurfaceHeight == 0) {
                            this.mWindowSurfaceHeight = this.mWindowSurface.getHeight();
                        }
                    }
                    if (this.mOffFullScreen == null) {
                        this.mOffFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                    }
                    if (this.mCamFullScreen == null) {
                        this.mCamFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                    }
                    if (this.mCameraTexture == null) {
                        this.mCameraTxtId = GlUtil.createTextureOES();
                        this.mCameraTexture = new SurfaceTexture(this.mCameraTxtId);
                        setupSurfaceFinish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, BdStatsConstant.StatsType.ERROR, "setup Surface error:" + e2.getLocalizedMessage());
                if (this.mRecorderHandler != null) {
                    this.mRecorderHandler.sendError(3, "create window surface --" + e2.getMessage());
                }
            }
        }
    }

    private void setupSurfaceFinish() {
        GLES20.glViewport(0, 0, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
        updateGeometry();
        prepareFramebuffer(this.mCameraPreviewHeight, this.mCameraPreviewWidth);
    }

    private void prepareFramebuffer(int i, int i2) {
        int[] iArr = new int[1];
        if (this.mOffscreenTexture > 0) {
            iArr[0] = this.mOffscreenTexture;
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mOffscreenTexture = -1;
        }
        if (this.mFramebuffer > 0) {
            iArr[0] = this.mFramebuffer;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.mFramebuffer = -1;
        }
        if (this.mDepthBuffer > 0) {
            iArr[0] = this.mDepthBuffer;
            GLES20.glDeleteRenderbuffers(1, iArr, 0);
            this.mDepthBuffer = -1;
        }
        GlUtil.checkGlError("prepareFramebuffer start");
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        this.mOffscreenTexture = iArr[0];
        GLES20.glBindTexture(3553, this.mOffscreenTexture);
        GlUtil.checkGlError("glBindTexture " + this.mOffscreenTexture);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        GLES20.glGenFramebuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenFramebuffers");
        this.mFramebuffer = iArr[0];
        GLES20.glBindFramebuffer(36160, this.mFramebuffer);
        GlUtil.checkGlError("glBindFramebuffer " + this.mFramebuffer);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GlUtil.checkGlError("glGenRenderbuffers");
        this.mDepthBuffer = iArr[0];
        GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
        GlUtil.checkGlError("glBindRenderbuffer " + this.mDepthBuffer);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        GlUtil.checkGlError("glRenderbufferStorage");
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
        GlUtil.checkGlError("glFramebufferRenderbuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffscreenTexture, 0);
        GlUtil.checkGlError("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new RuntimeException("Framebuffer not complete, status=" + glCheckFramebufferStatus);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("prepareFramebuffer done");
    }

    private void updateGeometry() {
        boolean z;
        if (this.mOffFullScreen != null && this.mOffFullScreen.getVertexCount() == 4) {
            if (isLandscape()) {
                z = false;
            } else {
                z = true;
            }
            this.mPreviewVertex = AlaLiveUtilHelper.getVertexArray(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight, z ? this.mCameraPreviewHeight : this.mCameraPreviewWidth, z ? this.mCameraPreviewWidth : this.mCameraPreviewHeight, this.mVideoModelFit);
            this.mOffFullScreen.resetVertexArray(this.mPreviewVertex);
        }
    }

    private boolean isLandscape() {
        if (this.mActivityReference.get() == null || this.mActivityReference.get().getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    private void setEncoderSurface(Surface surface) {
        try {
            if (this.mCodecWindowSurface != null) {
                this.mCodecWindowSurface.release();
                this.mCodecWindowSurface = null;
            }
            this.mCodecWindowSurface = new WindowSurface(this.mEglCore, surface, true);
        } catch (Exception e) {
            if (this.mRecorderHandler != null) {
                this.mRecorderHandler.sendError(3, e.getMessage());
            }
        }
    }

    private void resetTextures() {
        if (this.mWindowSurface != null) {
            this.mWindowSurface.release();
            this.mWindowSurface = null;
        }
        if (this.mCodecWindowSurface != null) {
            this.mCodecWindowSurface.release();
            this.mCodecWindowSurface = null;
        }
        if (this.mEncoder != null) {
            this.mEncoder.release();
            this.mEncoder = null;
        }
        GlUtil.checkGlError("releaseGl done");
        if (this.mEglCore != null) {
            this.mEglCore.makeNothingCurrent();
        }
        if (this.mOffFullScreen != null) {
            this.mOffFullScreen.release(true);
            this.mOffFullScreen = null;
        }
        if (this.mCamFullScreen != null) {
            this.mCamFullScreen.release(true);
            this.mCamFullScreen = null;
        }
        if (this.mCameraTexture != null) {
            this.mCameraTexture.release();
            this.mCameraTexture = null;
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
        if (this.mEglCore != null) {
            if (Math.abs(this.mWindowSurfaceHeight - i2) >= 10 || Math.abs(this.mWindowSurfaceWidth - i) >= 10) {
                if (this.mWindowSurfaceHeight > this.mWindowSurfaceWidth && i2 > i && this.mWindowSurfaceWidth > 0) {
                    this.mWindowSurfaceHeight = i2;
                    this.mWindowSurfaceWidth = i;
                    updateGeometry();
                } else if (this.mWindowSurfaceWidth > this.mWindowSurfaceHeight && i > i2 && this.mWindowSurfaceHeight > 0) {
                    this.mWindowSurfaceHeight = i2;
                    this.mWindowSurfaceWidth = i;
                    updateGeometry();
                } else {
                    this.mWindowSurfaceWidth = i;
                    this.mWindowSurfaceHeight = i2;
                    resetTextures();
                    setupSurface(this.mSurfaceHolder);
                    if (this.mConfig != null) {
                        if (this.mConfig.getEncoderType() == 1) {
                            resetTextureEncoder();
                        } else {
                            resetImageReader(true);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setBeauty(int i) {
        this.mBeautyLevel = i;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int hasBeauty() {
        return this.mBeautyLevel;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewSize(int i, int i2) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int getOutputWidth() {
        if (this.mConfig != null) {
            return this.mConfig.getVideoWidth();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public int getOutputHeight() {
        if (this.mConfig != null) {
            return this.mConfig.getVideoHeight();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void willSwitchSense(int i) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public SurfaceTexture getSurfaceTexture() {
        return this.mCameraTexture;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public VideoFormat getVideoFormat() {
        return VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void release() {
        if (this.mRecorderHandler != null) {
            this.mRecorderHandler.removeCallbacksAndMessages(null);
            this.mRecorderHandler = null;
        }
        GlUtil.checkGlError("releaseGl start");
        resetTextures();
        GlUtil.checkGlError("releaseGl done");
        if (this.mEglCore != null) {
            this.mEglCore.release();
            this.mEglCore = null;
        }
        resetImageReader(false);
        if (this.mHandlerThread != null && this.mHandlerThread.getLooper() != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.getLooper().quitSafely();
            } else {
                this.mHandlerThread.getLooper().quit();
            }
        }
        this.mHandlerThread = null;
        this.mDataThreadHandler = null;
    }

    private void initResource() {
        try {
            this.mEglCore = new EglCore(null, 1);
        } catch (Exception e) {
            BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, BdStatsConstant.StatsType.ERROR, "new EglCore error (FUCameraOperator):" + e.getLocalizedMessage());
            if (this.mRecorderHandler != null) {
                this.mRecorderHandler.sendError(3, "new EglCore() -> EGL14.eglCreateContext --" + e.getMessage());
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null && this.mEncoder != null && alaLiveVideoConfig.getEncoderType() == 1) {
            if (!AlaLiveVideoConfig.isEqual(this.mConfig, alaLiveVideoConfig)) {
                if (AlaLiveVideoConfig.isUpdateBitrate(this.mConfig, alaLiveVideoConfig) && TextureEncoder.isSupportBitRateOnFly()) {
                    this.mEncoder.updateBitrate(alaLiveVideoConfig.getBitStream());
                    this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
                    return;
                }
                this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
                resetTextureEncoder();
                return;
            }
            return;
        }
        this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    @TargetApi(19)
    private void resetImageReader(final boolean z) {
        if (this.mDataThreadHandler != null) {
            this.mDataThreadHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (GPUCameraOperator.this.mImageReader != null) {
                            GPUCameraOperator.this.mImageReader.setOnImageAvailableListener(null, null);
                            GPUCameraOperator.this.mImageReader.close();
                            GPUCameraOperator.this.mImageReader = null;
                        }
                        if (z) {
                            GPUCameraOperator.this.setupImageReader();
                        }
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    private void resetTextureEncoder() {
        if (this.mEglCore != null) {
            this.mRequestEncoderReset = false;
            if (this.mEncoder != null) {
                this.mEncoder.release();
                this.mEncoder = new TextureEncoder();
            }
            if (this.mEncoder == null) {
                this.mEncoder = new TextureEncoder();
            }
            TextureEncoder.EncodeConfig encodeConfig = new TextureEncoder.EncodeConfig();
            encodeConfig.encodeWidth = this.mConfig.getVideoWidth();
            encodeConfig.encodeHeight = this.mConfig.getVideoHeight();
            encodeConfig.encodeBitrate = this.mConfig.getBitStream();
            encodeConfig.isLandscape = this.mConfig.isLandscape();
            encodeConfig.H264GOP = this.mConfig.getVideoGOP();
            encodeConfig.H264FPS = this.mConfig.getVideoFPS();
            this.mEncoder.prepare(this.mEglCore.getEGLContext(), encodeConfig, new VideoEncoderCore.OutputCallback() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.3
                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onFormatChanged(MediaFormat mediaFormat) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecConfig(byte[] bArr, int i, int i2) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecData(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                    if (!GPUCameraOperator.this.mRequestKeyFrame || i3 == 2) {
                        if (GPUCameraOperator.this.mRequestKeyFrame && i3 == 2) {
                            GPUCameraOperator.this.mRequestKeyFrame = false;
                        }
                        if (GPUCameraOperator.this.mDataCallback != null) {
                            GPUCameraOperator.this.mDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j, j2);
                        }
                    }
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecError(int i) {
                    BdLog.e("resetTextureEncoder onCodecError -- " + i);
                    GPUCameraOperator.this.mRequestEncoderReset = true;
                    if (GPUCameraOperator.this.mDataCallback != null) {
                        GPUCameraOperator.this.mDataCallback.onError(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public void setupImageReader() {
        if (this.mImageReader == null && this.mCameraPreviewWidth != 0 && this.mCameraPreviewHeight != 0) {
            this.mImageReader = ImageReader.newInstance(this.mCameraPreviewHeight, this.mCameraPreviewWidth, 1, 1);
            try {
                this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ala.recorder.video.camera.GPUCameraOperator.4
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public void onImageAvailable(ImageReader imageReader) {
                        if (GPUCameraOperator.this.mImageReader != null) {
                            Image image = null;
                            try {
                                Image acquireNextImage = GPUCameraOperator.this.mImageReader.acquireNextImage();
                                GPUCameraOperator.this.mHasReportFrameError = false;
                                if (acquireNextImage != null) {
                                    try {
                                        ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                                        if (buffer == null) {
                                            acquireNextImage.close();
                                            return;
                                        }
                                        try {
                                            int pixelStride = acquireNextImage.getPlanes()[0].getPixelStride();
                                            GPUCameraOperator.this.mImgLineSize = (acquireNextImage.getPlanes()[0].getRowStride() / pixelStride) * 4;
                                            buffer.rewind();
                                            int remaining = buffer.remaining();
                                            if (GPUCameraOperator.this.mSendBuffer == null || GPUCameraOperator.this.mSendBuffer.length < remaining) {
                                                GPUCameraOperator.this.mSendBuffer = new byte[remaining];
                                            }
                                            buffer.get(GPUCameraOperator.this.mSendBuffer);
                                            acquireNextImage.close();
                                            if (GPUCameraOperator.this.mDataCallback != null) {
                                                GPUCameraOperator.this.mDataCallback.onRawVideoFrameReceived(GPUCameraOperator.this.mSendBuffer, remaining, 0, GPUCameraOperator.this.mImgLineSize);
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
                                if (GPUCameraOperator.this.mRecorderHandler != null && !GPUCameraOperator.this.mHasReportFrameError) {
                                    GPUCameraOperator.this.mRecorderHandler.sendError(1, e3.getMessage());
                                    GPUCameraOperator.this.mHasReportFrameError = true;
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
                }, this.mDataThreadHandler);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            setEncoderSurface(this.mImageReader.getSurface());
        }
    }

    public static boolean isValid() {
        return true;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPushMirror(boolean z) {
        this.mIsMirror = z;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewFps(int i) {
        if (i > 0) {
            this.mPreviewFpsLimit.setLimitFps(i);
        }
    }
}
