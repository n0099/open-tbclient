package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
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
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ala.dumixar.ARProcessor;
import com.baidu.ala.dumixar.BeautyDataManager;
import com.baidu.ala.dumixar.DuArConfig;
import com.baidu.ala.dumixar.gles.FullFrameRect;
import com.baidu.ala.dumixar.gles.Texture2dProgram;
import com.baidu.ala.dumixar.gles.TextureHelper;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.recorder.IFaceUnityOperator;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.ala.recorder.video.camera.AlaCameraRecorder;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.gles.EglSurfaceBase;
import com.baidu.ala.recorder.video.gles.FullFrameRectFU;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ala.recorder.video.gles.OffscreenSurface;
import com.baidu.ala.recorder.video.gles.Sticker;
import com.baidu.ala.recorder.video.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.WindowSurface;
import com.baidu.ala.recorder.video.hardware.TextureEncoder;
import com.baidu.ala.recorder.video.hardware.VideoEncoderCore;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.minivideo.a.b;
import com.baidu.minivideo.a.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class DuArCameraOperator implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, IFaceUnityOperator, ICameraOperator {
    public static final boolean DEBUG = false;
    private static final int DEFAULT_ROTATE = 0;
    private static final String EFFECT_NONE = "none";
    private static String FILTER_DEFAULT = null;
    private static final int MAX_DROP_FIRST_FRAMES = 5;
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final int PREVIEW_BUFFER_COUNT = 3;
    private static final String TAG = "AlaLiveRecorder_AR";
    private boolean hasProcessFirstFrame;
    private ARProcessor mARProcessor;
    private WeakReference<Activity> mActivityReference;
    private Camera mCamera;
    private byte[] mCameraNV21Byte;
    private SurfaceTexture mCameraTexture;
    private int mCameraTxtId;
    private WindowSurface mCodecWindowSurface;
    private AlaLiveVideoConfig mConfig;
    private IVideoRecorder.IVideoDataCallBack mDataCallback;
    private Handler mDataThreadHandler;
    private int mDepthBuffer;
    private EglCore mEglCore;
    private int mFrameId;
    private int mFramebuffer;
    private FullFrameRectFU mFullScreen;
    private FullFrameRect mFullScreen2D;
    private FullFrameRectFU mFullScreenSticker;
    private HandlerThread mHandlerThread;
    private float[] mIdentityMatrix;
    private ImageReader mImageReader;
    private float[] mMirrorIdentityMatrix;
    private byte[][] mPreviewCallbackBuffer;
    private float[] mPreviewVertex;
    private float[] mPreviewVertexSticker;
    private RecorderHandler mRecorderHandler;
    private Sticker mSticker;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private boolean mVideoModelFit;
    private WindowSurface mWindowSurface;
    private static String mEffectFileName = "none";
    private static boolean isSetupConfig = false;
    private String mFilterName = FILTER_DEFAULT;
    private boolean isNeedEffectItem = true;
    private int mDropFrames = 0;
    private int faceTrackingStatus = -1;
    private String mGiftEffectFilePath = "";
    private boolean isGiftEffectNeedRefresh = true;
    private AlaFrameTrack mPreviewFpsLimit = new AlaFrameTrack(15);
    private int mCameraPreviewWidth = 720;
    private int mCameraPreviewHeight = 1280;
    private int mYOffset = 0;
    private int mWindowSurfaceWidth = 0;
    private int mWindowSurfaceHeight = 0;
    private int mRotate = 0;
    private volatile int mBeautyLevel = 3;
    private int mCameraId = 1;
    private int mEncodeWidth = 0;
    private int mEncodeHeight = 0;
    private int mOffscreenTexture = 0;
    private volatile boolean mIsMirror = false;
    private boolean mHasReportFrameError = false;
    private byte[] mSendBuffer = null;
    private int mImgLineSize = 0;
    private TextureEncoder mEncoder = null;
    private volatile boolean mRequestEncoderReset = false;
    private int mEncoderRestCount = 0;
    private boolean isEncode = true;
    private HashMap<String, Object> mBeautyParams = new HashMap<>();
    boolean isSetup = false;
    private int mSetFilterNum = 10;

    static /* synthetic */ int access$510(DuArCameraOperator duArCameraOperator) {
        int i = duArCameraOperator.mSetFilterNum;
        duArCameraOperator.mSetFilterNum = i - 1;
        return i;
    }

    public DuArCameraOperator(Activity activity, Camera camera, AlaCameraRecorder.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack, RecorderHandler recorderHandler) {
        this.mActivityReference = null;
        d("construction：isTieba：");
        this.mCamera = camera;
        this.mSurfaceHolder = surfaceHolder;
        this.mRecorderHandler = recorderHandler;
        this.mDataCallback = iVideoDataCallBack;
        this.mActivityReference = new WeakReference<>(activity);
        this.mIdentityMatrix = new float[16];
        Matrix.setIdentityM(this.mIdentityMatrix, 0);
        this.mMirrorIdentityMatrix = new float[16];
        this.mPreviewVertex = new float[8];
        this.mVideoModelFit = false;
        recorderHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.1
            @Override // java.lang.Runnable
            public void run() {
                DuArCameraOperator.this.d("mRecorderHandler ------");
            }
        });
        initARConfig();
        AlaLiveUtilHelper.getTextureMatrix(this.mMirrorIdentityMatrix, 0.0f, false);
        this.mHandlerThread = new HandlerThread("ala_live_recorder_fu");
        this.mHandlerThread.start();
        this.mDataThreadHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private static boolean isTiebaType() {
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        d("onFrameAvailable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
    }

    public void setSticker(Sticker sticker) {
        this.mSticker = sticker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void frameAvailable() {
        int i;
        Bitmap popBitmap;
        TextureHelper.TextureBean loadTexture;
        float[] fArr = new float[16];
        if (this.mSticker != null && (popBitmap = this.mSticker.popBitmap()) != null && (loadTexture = TextureHelper.loadTexture(this.mActivityReference.get(), 0, popBitmap)) != null && loadTexture.textureId != 0) {
            this.mSticker.setTexutureId(loadTexture.textureId);
        }
        try {
            Matrix.setIdentityM(fArr, 0);
            i = this.mARProcessor.onProcessFrame(0, fArr);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (this.mPreviewFpsLimit.trackFrame()) {
            try {
                if (this.mWindowSurface != null) {
                    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
                    GlUtil.checkGlError("glBindFramebuffer");
                    this.mWindowSurface.makeCurrent();
                    GLES20.glViewport(0, 0, this.mCameraPreviewHeight, this.mCameraPreviewWidth);
                    this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                    if (this.mSticker != null) {
                        this.mSticker.setCameraSize(this.mCameraPreviewWidth, this.mCameraPreviewHeight);
                        this.mSticker.setScreenSize(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
                    }
                    this.mFullScreenSticker.drawFrame(i, fArr, this.mSticker);
                    if (this.mDropFrames < 5) {
                        this.mDropFrames++;
                        return;
                    }
                    GLES20.glBindFramebuffer(36160, 0);
                    this.mWindowSurface.makeCurrent();
                    GLES20.glViewport(0, -this.mYOffset, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    this.mFullScreen.drawFrame2(this.mOffscreenTexture, this.mIdentityMatrix);
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
                        doDrawEncodeSurface(this.mCodecWindowSurface, this.mMirrorIdentityMatrix, this.mCameraTexture.getTimestamp());
                    } else {
                        doDrawEncodeSurface(this.mCodecWindowSurface, this.mIdentityMatrix, this.mCameraTexture.getTimestamp());
                    }
                    this.mWindowSurface.makeCurrent();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void doDrawEncodeSurface(EglSurfaceBase eglSurfaceBase, float[] fArr, long j) {
        d("doDrawEncodeSurface");
        if (this.isEncode) {
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
                    this.mFullScreen.drawFrame(this.mOffscreenTexture, fArr, null);
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
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean onCameraOpened(Camera camera, int i, int i2) {
        d("onCameraOpened");
        this.mCamera = camera;
        if (this.mActivityReference.get() == null) {
            return false;
        }
        initResource();
        initARProcessor();
        this.mCameraId = i;
        this.mDropFrames = 0;
        Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
        this.mCameraPreviewWidth = previewSize.width;
        this.mCameraPreviewHeight = previewSize.height;
        this.mEncodeWidth = this.mCameraPreviewWidth;
        this.mEncodeHeight = this.mCameraPreviewHeight;
        this.mARProcessor.initSourceSize(this.mCameraPreviewWidth, this.mCameraPreviewHeight);
        this.mRotate = CameraUtils.getCameraDisplayOrientation(this.mActivityReference.get(), null, i);
        this.mRotate += 180;
        if (this.mCameraTexture == null) {
            setupSurface(this.mSurfaceHolder);
            if (this.mARProcessor != null) {
                this.mARProcessor.onResume();
            }
            if (this.mCameraTexture != null) {
                openCamera();
            }
            if (this.mConfig.getEncoderType() == 1) {
                resetTextureEncoder();
            } else {
                resetImageReader(true);
            }
        } else {
            openCamera();
        }
        return true;
    }

    private void createPreviewCallbackBuffer() {
        if (this.mPreviewCallbackBuffer == null) {
            try {
                this.mPreviewCallbackBuffer = (byte[][]) Array.newInstance(Byte.TYPE, 3, (int) (this.mConfig.getPreviewWidth() * this.mConfig.getPreviewHeight() * 1.5d));
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    private void setupSurface(AlaCameraRecorder.SurfaceHolder surfaceHolder) {
        d("setupSurface");
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
                    if (this.mFullScreen == null) {
                        this.mFullScreen = new FullFrameRectFU(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                        this.mFullScreenSticker = new FullFrameRectFU(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_STICKER));
                    }
                    if (this.mCameraTexture == null) {
                        this.mCameraTexture = this.mARProcessor.getCameraTexture();
                        if (this.mCameraTexture != null) {
                            setupSurfaceFinish();
                            this.mFullScreen2D = new FullFrameRect(new com.baidu.ala.dumixar.gles.Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                        }
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
        d("setupSurfaceFinish");
        GLES20.glViewport(0, 0, this.mWindowSurfaceWidth, this.mWindowSurfaceHeight);
        updateGeometry();
        prepareFramebuffer(this.mCameraPreviewHeight, this.mCameraPreviewWidth);
    }

    private boolean openCamera() {
        try {
            if (this.mCameraTexture != null) {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallbackWithBuffer(this);
                createPreviewCallbackBuffer();
                for (int i = 0; i < 3; i++) {
                    this.mCamera.addCallbackBuffer(this.mPreviewCallbackBuffer[i]);
                }
                this.mCamera.setPreviewTexture(this.mCameraTexture);
                this.mCamera.startPreview();
                this.mRecorderHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DuArCameraOperator.this.mARProcessor != null) {
                            DuArCameraOperator.this.d("openCamera size[ " + DuArCameraOperator.this.mCameraPreviewWidth + ", " + DuArCameraOperator.this.mCameraPreviewHeight + "]");
                        }
                    }
                });
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void prepareFramebuffer(int i, int i2) {
        d("prepareFramebuffer");
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

    private void initARConfig() {
        if (!isSetupConfig) {
            isSetupConfig = true;
            DuArConfig instance = DuArConfig.instance();
            b.a(this.mActivityReference.get().getApplicationContext(), instance.appId, instance.apiKey, instance.secretKey, new c(instance.getDuArSourcePath()));
            if (b.DX() != null) {
                b.DX();
                FILTER_DEFAULT = c.getFilterYuanTuPath();
            }
        }
    }

    private void initARProcessor() {
        try {
            if (this.mARProcessor == null) {
                this.hasProcessFirstFrame = false;
                this.mSetFilterNum = 10;
                this.mARProcessor = new ARProcessor(this.mActivityReference.get().getApplicationContext(), new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.3
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        DuArCameraOperator.this.d(" ar->onFrameAvailable surfaceTexture = " + surfaceTexture);
                        DuArCameraOperator.this.frameAvailable();
                        if (DuArCameraOperator.this.mARProcessor != null && DuArCameraOperator.this.mSetFilterNum > 0) {
                            if (!TextUtils.isEmpty(DuArCameraOperator.this.mFilterName)) {
                                DuArCameraOperator.this.d("ar->isFirstFrame:" + DuArCameraOperator.this.mFilterName);
                                DuArCameraOperator.this.mARProcessor.setFilterSelected(DuArCameraOperator.this.mFilterName);
                            }
                            if (!DuArCameraOperator.this.mBeautyParams.isEmpty()) {
                                DuArCameraOperator.this.mARProcessor.setBeautyParams(DuArCameraOperator.this.mBeautyParams);
                            }
                            DuArCameraOperator.this.hasProcessFirstFrame = true;
                            DuArCameraOperator.access$510(DuArCameraOperator.this);
                        }
                    }
                });
                this.mARProcessor.setCallback(new ARProcessor.CallbackAdapter() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.4
                    @Override // com.baidu.ala.dumixar.ARProcessor.CallbackAdapter
                    public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                        DuArCameraOperator.this.d("onSetup: " + z);
                        DuArCameraOperator.this.isSetup = z;
                    }
                });
                this.mARProcessor.onSurfaceChanged(null, this.mCameraPreviewWidth, this.mCameraPreviewHeight);
            }
        } catch (Exception e) {
        }
    }

    private void updateGeometry() {
        boolean z;
        d("updateGeometry");
        if (this.mFullScreen != null && this.mFullScreen.getVertexCount() == 4) {
            if (isLandscape()) {
                z = false;
            } else {
                z = true;
            }
            float f = z ? this.mCameraPreviewHeight : this.mCameraPreviewWidth;
            float f2 = z ? this.mCameraPreviewWidth : this.mCameraPreviewHeight;
            this.mPreviewVertex = AlaLiveUtilHelper.getVertexArray(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight, f, f2, this.mVideoModelFit);
            this.mPreviewVertexSticker = AlaLiveUtilHelper.getVertexArray(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight, f, f2, this.mVideoModelFit);
            this.mFullScreen.resetVertexArray(this.mPreviewVertex);
            this.mFullScreenSticker.resetVertexArray(this.mPreviewVertexSticker);
        }
    }

    private boolean isLandscape() {
        d("isLandscape");
        if (this.mActivityReference.get() == null || this.mActivityReference.get().getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void startRecorderData() {
        d("startRecorderData");
        if (this.mConfig.getEncoderType() != 1) {
            resetImageReader(true);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setEncoderSurface(Surface surface) {
        d("setEncoderSurface");
        if (this.isEncode) {
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
    }

    private void resetTextures() {
        d("resetTextures");
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
        if (this.mFullScreen != null) {
            this.mFullScreen.release(true);
            this.mFullScreen = null;
        }
        if (this.mFullScreenSticker != null) {
            this.mFullScreenSticker.release(true);
            this.mFullScreenSticker = null;
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void surfaceChanged(int i, int i2) {
        d("surfaceChanged");
        if (this.mEglCore == null) {
            BdLog.e("surfaceChanged, mEglCore = null ?");
        } else if (Math.abs(this.mWindowSurfaceHeight - i2) >= 10 || Math.abs(this.mWindowSurfaceWidth - i) >= 10) {
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
    public VideoFormat getVideoFormat() {
        return VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public Handler getDataThreadHandler() {
        if (this.mHandlerThread != null) {
            return new Handler(this.mHandlerThread.getLooper());
        }
        return null;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void release() {
        d("release");
        try {
            CameraExecutor.getInst().postMainRunable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DuArCameraOperator.this.mARProcessor != null) {
                        DuArCameraOperator.this.mARProcessor.onPause();
                        DuArCameraOperator.this.mARProcessor.onDestroy();
                        DuArCameraOperator.this.mARProcessor = null;
                    }
                }
            });
            this.hasProcessFirstFrame = false;
            if (this.mRecorderHandler != null) {
                this.mRecorderHandler.removeCallbacksAndMessages(null);
                this.mRecorderHandler = null;
            }
            GlUtil.checkGlError("releaseGl start");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.mWindowSurface != null) {
                this.mWindowSurface.release();
                this.mWindowSurface = null;
            }
            if (this.mEncoder != null && this.mEncoder != null) {
                this.mEncoder.release();
                this.mEncoder = null;
            }
            if (this.mCodecWindowSurface != null) {
                this.mCodecWindowSurface.release();
                this.mCodecWindowSurface = null;
            }
            if (this.mFullScreen != null) {
                this.mFullScreen.release(true);
                this.mFullScreen = null;
            }
            if (this.mFullScreenSticker != null) {
                this.mFullScreenSticker.release(true);
                this.mFullScreenSticker = null;
            }
            if (this.mFullScreen2D != null) {
                this.mFullScreen2D.release(true);
                this.mFullScreen2D = null;
            }
            if (this.mCameraTexture != null) {
                this.mCameraTexture.release();
                this.mCameraTexture = null;
            }
            this.isNeedEffectItem = true;
            this.isGiftEffectNeedRefresh = true;
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
            GlUtil.checkGlError("releaseGl done");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void initResource() {
        d("initResource");
        if (this.mEglCore == null) {
            try {
                this.mEglCore = new EglCore(null, 1);
            } catch (Exception e) {
                BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, BdStatsConstant.StatsType.ERROR, "new EglCore error (FUCameraOperator):" + e.getLocalizedMessage());
                if (this.mRecorderHandler != null) {
                    this.mRecorderHandler.sendError(3, "new EglCore() -> EGL14.eglCreateContext --" + e.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        d("setVideoConfig");
        if (alaLiveVideoConfig != null) {
            this.mConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
            if (this.mEncoder != null && alaLiveVideoConfig.getEncoderType() == 1) {
                resetTextureEncoder();
            }
        }
    }

    @TargetApi(19)
    private void resetImageReader(final boolean z) {
        d("resetImageReader");
        if (this.mDataThreadHandler != null) {
            this.mDataThreadHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DuArCameraOperator.this.mImageReader != null) {
                            DuArCameraOperator.this.mImageReader.setOnImageAvailableListener(null, null);
                            DuArCameraOperator.this.mImageReader.close();
                            DuArCameraOperator.this.mImageReader = null;
                        }
                        if (z) {
                            DuArCameraOperator.this.setupImageReader();
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
        d("resetTextureEncoder");
        if (this.isEncode && this.mEglCore != null) {
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
            this.mEncoder.prepare(this.mEglCore.getEGLContext(), encodeConfig, new VideoEncoderCore.OutputCallback() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.7
                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onFormatChanged(MediaFormat mediaFormat) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecConfig(byte[] bArr, int i, int i2) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                    if (DuArCameraOperator.this.mDataCallback != null) {
                        DuArCameraOperator.this.mDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                    }
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecError(int i) {
                    BdLog.e("resetTextureEncoder onCodecError -- " + i);
                    DuArCameraOperator.this.mRequestEncoderReset = true;
                    if (DuArCameraOperator.this.mDataCallback != null) {
                        DuArCameraOperator.this.mDataCallback.onError(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public void setupImageReader() {
        d("setupImageReader");
        if (!this.isEncode && this.mImageReader == null && this.mCameraPreviewWidth != 0 && this.mCameraPreviewHeight != 0) {
            this.mImageReader = ImageReader.newInstance(this.mCameraPreviewHeight, this.mCameraPreviewWidth, 1, 1);
            try {
                this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ala.recorder.video.camera.DuArCameraOperator.8
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public void onImageAvailable(ImageReader imageReader) {
                        if (DuArCameraOperator.this.mImageReader != null) {
                            Image image = null;
                            try {
                                Image acquireNextImage = DuArCameraOperator.this.mImageReader.acquireNextImage();
                                DuArCameraOperator.this.mHasReportFrameError = false;
                                if (acquireNextImage != null) {
                                    try {
                                        ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                                        if (buffer == null) {
                                            acquireNextImage.close();
                                            return;
                                        }
                                        try {
                                            int pixelStride = acquireNextImage.getPlanes()[0].getPixelStride();
                                            DuArCameraOperator.this.mImgLineSize = (acquireNextImage.getPlanes()[0].getRowStride() / pixelStride) * 4;
                                            buffer.rewind();
                                            int remaining = buffer.remaining();
                                            if (DuArCameraOperator.this.mSendBuffer == null || DuArCameraOperator.this.mSendBuffer.length < remaining) {
                                                DuArCameraOperator.this.mSendBuffer = new byte[remaining];
                                            }
                                            buffer.get(DuArCameraOperator.this.mSendBuffer);
                                            acquireNextImage.close();
                                            if (DuArCameraOperator.this.mDataCallback != null) {
                                                DuArCameraOperator.this.mDataCallback.onRawVideoFrameReceived(DuArCameraOperator.this.mSendBuffer, remaining, 0, DuArCameraOperator.this.mImgLineSize);
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
                                if (DuArCameraOperator.this.mRecorderHandler != null && !DuArCameraOperator.this.mHasReportFrameError) {
                                    DuArCameraOperator.this.mRecorderHandler.sendError(1, e3.getMessage());
                                    DuArCameraOperator.this.mHasReportFrameError = true;
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

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        d("onPreviewFrame - ");
        camera.addCallbackBuffer(bArr);
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEffectItemSelected(String str) {
        if (!str.equals(mEffectFileName)) {
            mEffectFileName = str;
            this.isNeedEffectItem = true;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onStickerItemSelected(Object obj) {
        if (obj == null) {
            this.mSticker = null;
        }
        if (obj != null && (obj instanceof Sticker)) {
            Sticker sticker = this.mSticker;
            if (sticker != null) {
                sticker.recycle();
            }
            this.mSticker = (Sticker) obj;
        } else if (obj != null && (obj instanceof com.baidu.minivideo.arface.bean.Sticker)) {
            this.isNeedEffectItem = true;
            if (this.mARProcessor != null) {
                this.mARProcessor.setEffectItemSelected((com.baidu.minivideo.arface.bean.Sticker) obj);
            }
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (str == null || !str.equals(this.mGiftEffectFilePath)) {
            this.mGiftEffectFilePath = str;
            this.isGiftEffectNeedRefresh = true;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mFilterName = FILTER_DEFAULT;
            return;
        }
        this.mFilterName = str;
        if (this.mARProcessor != null) {
            this.mARProcessor.setFilterSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPushMirror(boolean z) {
        this.mIsMirror = z;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public boolean isPushMirror() {
        return this.mIsMirror;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraOperator
    public void setPreviewFps(int i) {
        d("setPreviewFps " + i);
        if (i > 0) {
            this.mPreviewFpsLimit.setLimitFps(i);
        }
    }

    private void setBeautyParams(HashMap<String, Object> hashMap) {
        if (this.mARProcessor != null && this.hasProcessFirstFrame) {
            this.mARProcessor.setBeautyParams(hashMap);
        }
        this.mBeautyParams.putAll(hashMap);
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry != null && entry.getKey() != null) {
                if (entry.getValue() instanceof Integer) {
                    hashMap2.put(entry.getKey(), Float.valueOf(((Integer) entry.getValue()).intValue() * f));
                } else if (entry.getValue() instanceof Float) {
                    hashMap2.put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * f));
                } else if (entry.getValue() instanceof Double) {
                    hashMap2.put(entry.getKey(), Float.valueOf(new Float(((Double) entry.getValue()).doubleValue()).floatValue() * f));
                } else if (entry.getValue() instanceof String) {
                    try {
                        hashMap2.put(entry.getKey(), Float.valueOf(Float.valueOf((String) entry.getValue()).floatValue() * f));
                    } catch (Exception e) {
                    }
                }
            }
        }
        setBeautyParams(hashMap2);
    }

    public void setDefBeautyParams(HashMap<String, Object> hashMap) {
        BeautyDataManager.getInstance().setDefaultBeautyParams(hashMap);
        setBeautyParams(hashMap);
    }
}
