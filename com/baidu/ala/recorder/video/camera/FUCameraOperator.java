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
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.helper.AlaFrameTrack;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.ala.recorder.IFaceUnityOperator;
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
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class FUCameraOperator implements IFaceUnityOperator, ICameraOperator {
    private static final int DEFAULT_ROTATE = 0;
    private static final String EFFECT_NONE = "none";
    private static final String FILTER_DEFAULT = "origin";
    private static final int ITEM_ARRAYS_COUNT = 3;
    private static final int ITEM_ARRAYS_EFFECT = 1;
    private static final int ITEM_ARRAYS_EFFECT_ABIMOJI_3D = 2;
    private static final int ITEM_ARRAYS_FACE_BEAUTY_INDEX = 0;
    private static final int MAX_DROP_FIRST_FRAMES = 5;
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final String TAG = "AlaLiveRecorder_FU";
    private int faceTrackingStatus;
    private boolean isGiftEffectNeedRefresh;
    private boolean isNeedEffectItem;
    private final int[] itemsArray;
    private WeakReference<Activity> mActivityReference;
    private volatile int mBeautyLevel;
    private Camera mCamera;
    private int mCameraId;
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
    private int mDropFrames;
    private int mEffectItem;
    private EglCore mEglCore;
    private int mEncodeHeight;
    private int mEncodeWidth;
    private TextureEncoder mEncoder;
    private int mEncoderRestCount;
    private int mFaceShape;
    private float mFaceShapeLevel;
    private float mFacebeautyBlurLevel;
    private float mFacebeautyCheeckThin;
    private float mFacebeautyColorLevel;
    private float mFacebeautyEnlargeEye;
    private int mFacebeautyItem;
    private float mFacebeautyRedLevel;
    private String mFilterName;
    private int mFrameId;
    private int mFramebuffer;
    private AFullFrameRect mFullScreen;
    private String mGiftEffectFilePath;
    private int mGiftEffectItem;
    private HandlerThread mHandlerThread;
    private boolean mHasReportFrameError;
    private float[] mIdentityMatrix;
    private float[] mIdentityMatrix90;
    private ImageReader mImageReader;
    private int mImgLineSize;
    private volatile boolean mIsCreateFuObj;
    private volatile boolean mIsMirror;
    private float[] mMirrorIdentityMatrix;
    private float[] mMirrorIdentityMatrix90;
    private int mOffscreenTexture;
    private Camera.PreviewCallback mPreviewCallback;
    private AlaFrameTrack mPreviewFpsLimit;
    private float[] mPreviewVertex;
    private RecorderHandler mRecorderHandler;
    private volatile boolean mRequestEncoderReset;
    private volatile boolean mRequestKeyFrame;
    private byte[] mSendBuffer;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private boolean mVideoModelFit;
    private WindowSurface mWindowSurface;
    private int mWindowSurfaceHeight;
    private int mWindowSurfaceWidth;
    private int mYOffset;
    private static boolean FU_INITED = false;
    private static boolean IS_TIEBA = isTiebaType();
    private static String mEffectFileName = "none";

    public FUCameraOperator(Activity activity, AlaCameraRecorder.SurfaceHolder surfaceHolder, ICameraStatusHandler iCameraStatusHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack, RecorderHandler recorderHandler) {
        this.mFacebeautyColorLevel = IS_TIEBA ? 0.5f : 0.6f;
        this.mFacebeautyBlurLevel = IS_TIEBA ? 6.0f : 3.0f;
        this.mFacebeautyCheeckThin = IS_TIEBA ? 1.0f : 0.7f;
        this.mFacebeautyEnlargeEye = 0.5f;
        this.mFacebeautyRedLevel = IS_TIEBA ? 0.5f : 1.4f;
        this.mFaceShape = 3;
        this.mFaceShapeLevel = 0.5f;
        this.mFacebeautyItem = 0;
        this.mEffectItem = 0;
        this.mGiftEffectItem = 0;
        this.itemsArray = new int[3];
        this.mFilterName = FILTER_DEFAULT;
        this.isNeedEffectItem = true;
        this.mDropFrames = 0;
        this.faceTrackingStatus = -1;
        this.mGiftEffectFilePath = "";
        this.isGiftEffectNeedRefresh = true;
        this.mPreviewFpsLimit = new AlaFrameTrack(15);
        this.mYOffset = 0;
        this.mWindowSurfaceWidth = 0;
        this.mWindowSurfaceHeight = 0;
        this.mIsCreateFuObj = false;
        this.mBeautyLevel = 3;
        this.mActivityReference = null;
        this.mCameraId = 1;
        this.mEncodeWidth = 0;
        this.mEncodeHeight = 0;
        this.mOffscreenTexture = 0;
        this.mIdentityMatrix = new float[16];
        this.mIdentityMatrix90 = new float[16];
        this.mMirrorIdentityMatrix = new float[16];
        this.mMirrorIdentityMatrix90 = new float[16];
        this.mIsMirror = false;
        this.mHasReportFrameError = false;
        this.mSendBuffer = null;
        this.mImgLineSize = 0;
        this.mEncoder = null;
        this.mRequestEncoderReset = false;
        this.mEncoderRestCount = 0;
        this.mRequestKeyFrame = true;
        this.mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.ala.recorder.video.camera.FUCameraOperator.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                camera.addCallbackBuffer(bArr);
                FUCameraOperator.this.mCameraNV21Byte = bArr;
                FUCameraOperator.this.frameAvailable();
            }
        };
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
        this.mHandlerThread = new HandlerThread("ala_live_recorder_fu");
        this.mHandlerThread.start();
        this.mDataThreadHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private static boolean isTiebaType() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: IOException -> 0x01d0, TRY_LEAVE, TryCatch #0 {IOException -> 0x01d0, blocks: (B:11:0x0029, B:13:0x002d, B:15:0x0038, B:17:0x0045, B:19:0x0064, B:21:0x0068, B:22:0x0070, B:24:0x007e, B:76:0x01c1, B:78:0x01c5), top: B:88:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fuAddEffectAndGift() {
        int fuDualInputToTexture;
        int i;
        int i2;
        boolean z = false;
        if (this.isNeedEffectItem) {
            this.isNeedEffectItem = false;
            try {
                if (mEffectFileName.equals("none")) {
                    int[] iArr = this.itemsArray;
                    this.mEffectItem = 0;
                    iArr[1] = 0;
                } else {
                    InputStream open = this.mActivityReference.get().getAssets().open(mEffectFileName);
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    int i3 = this.itemsArray[1];
                    int[] iArr2 = this.itemsArray;
                    int fuCreateItemFromPackage = faceunity.fuCreateItemFromPackage(bArr);
                    this.mEffectItem = fuCreateItemFromPackage;
                    iArr2[1] = fuCreateItemFromPackage;
                    faceunity.fuItemSetParam(this.mEffectItem, "isAndroid", 1.0d);
                    if (i3 != 0) {
                        faceunity.fuDestroyItem(i3);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.isGiftEffectNeedRefresh) {
            this.isGiftEffectNeedRefresh = false;
            this.faceTrackingStatus = -1;
            try {
                if (this.mGiftEffectFilePath != null && !this.mGiftEffectFilePath.equals("")) {
                    File file = new File(this.mGiftEffectFilePath);
                    if (file.exists()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr2 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr2);
                        fileInputStream.close();
                        i = faceunity.fuCreateItemFromPackage(bArr2);
                        faceunity.fuItemSetParam(i, "isAndroid", 1.0d);
                        if (i == 0 && this.mRecorderHandler != null) {
                            this.mRecorderHandler.sendError(6, this.mGiftEffectFilePath);
                        }
                        i2 = this.itemsArray[2];
                        int[] iArr3 = this.itemsArray;
                        this.mGiftEffectItem = i;
                        iArr3[2] = i;
                        if (i2 != 0) {
                            faceunity.fuDestroyItem(i2);
                        }
                    } else if (this.mRecorderHandler != null) {
                        this.mRecorderHandler.sendError(5, this.mGiftEffectFilePath);
                    }
                }
                i = 0;
                i2 = this.itemsArray[2];
                int[] iArr32 = this.itemsArray;
                this.mGiftEffectItem = i;
                iArr32[2] = i;
                if (i2 != 0) {
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        boolean z2 = this.mCameraId == 1;
        if (this.mEffectItem != 0) {
            faceunity.fuItemSetParam(this.mEffectItem, "rotationAngle", z2 ? 90.0d : 270.0d);
        }
        if (this.mGiftEffectItem != 0) {
            faceunity.fuItemSetParam(this.mGiftEffectItem, "rotationAngle", z2 ? 90.0d : 270.0d);
        }
        if (!TextUtils.isEmpty(this.mFilterName)) {
            faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
        }
        if (IS_TIEBA) {
            faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterName);
            if (this.mConfig.isSupportFaceStyle()) {
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
            }
            faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", this.mFaceShape);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", this.mFaceShapeLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "tooth_whiten", 0.0d);
        } else {
            faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_level", 0.4000000059604645d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", this.mFacebeautyColorLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", this.mFacebeautyRedLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", this.mFacebeautyBlurLevel);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "skin_detect", 1.0d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "tooth_whiten", 1.0d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", 4.0d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", 1.0d);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", this.mFacebeautyEnlargeEye);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", this.mFacebeautyCheeckThin);
            faceunity.fuItemSetParam(this.mFacebeautyItem, "intensity_nose", 0.5d);
        }
        int i4 = z2 ? 1 : 33;
        if (this.mConfig.isSupportFaceStyle() || this.itemsArray[2] > 0 || this.itemsArray[1] > 0) {
            byte[] bArr3 = this.mCameraNV21Byte;
            int i5 = this.mCameraTxtId;
            int i6 = this.mCameraPreviewWidth;
            int i7 = this.mCameraPreviewHeight;
            int i8 = this.mFrameId;
            this.mFrameId = i8 + 1;
            fuDualInputToTexture = faceunity.fuDualInputToTexture(bArr3, i5, i4, i6, i7, i8, this.itemsArray);
        } else {
            int i9 = this.mCameraTxtId;
            int i10 = this.mCameraPreviewWidth;
            int i11 = this.mCameraPreviewHeight;
            int i12 = this.mFrameId;
            this.mFrameId = i12 + 1;
            fuDualInputToTexture = faceunity.fuBeautifyImage(i9, i4, i10, i11, i12, this.itemsArray);
        }
        int fuIsTracking = faceunity.fuIsTracking();
        if (this.faceTrackingStatus == -1 || this.faceTrackingStatus != fuIsTracking) {
            this.faceTrackingStatus = fuIsTracking;
            z = true;
        }
        if (z && this.mGiftEffectItem != 0 && this.mRecorderHandler != null) {
            this.mRecorderHandler.sendFuTrackFace(fuIsTracking);
        }
        return fuDualInputToTexture;
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
                    this.mFullScreen.drawFrame(fuAddEffectAndGift(), fArr, null);
                    if (this.mDropFrames < 5) {
                        this.mDropFrames++;
                        return;
                    }
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkGlError("glBindFramebuffer");
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
                this.mFullScreen.drawFrame(this.mOffscreenTexture, fArr, null);
                eglSurfaceBase.setPresentationTime(j);
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
        initResource();
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
            fuInitWithoutGLContext();
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
                    if (this.mFullScreen == null) {
                        this.mFullScreen = new AFullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
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
        if (this.mFullScreen != null && this.mFullScreen.getVertexCount() == 4) {
            if (isLandscape()) {
                z = false;
            } else {
                z = true;
            }
            this.mPreviewVertex = AlaLiveUtilHelper.getVertexArray(this.mWindowSurfaceWidth, this.mWindowSurfaceHeight, z ? this.mCameraPreviewHeight : this.mCameraPreviewWidth, z ? this.mCameraPreviewWidth : this.mCameraPreviewHeight, this.mVideoModelFit);
            this.mFullScreen.resetVertexArray(this.mPreviewVertex);
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
        if (this.mFullScreen != null) {
            this.mFullScreen.release(true);
            this.mFullScreen = null;
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
        if (this.mEffectItem != 0) {
            faceunity.fuDestroyItem(this.mEffectItem);
        }
        int[] iArr = this.itemsArray;
        this.mFacebeautyItem = 0;
        iArr[0] = 0;
        int[] iArr2 = this.itemsArray;
        this.mEffectItem = 0;
        iArr2[1] = 0;
        int[] iArr3 = this.itemsArray;
        this.mGiftEffectItem = 0;
        iArr3[2] = 0;
        if (this.mIsCreateFuObj) {
            faceunity.fuDestroyAllItems();
            faceunity.fuOnDeviceLost();
            faceunity.fuDone();
        }
        this.isNeedEffectItem = true;
        this.isGiftEffectNeedRefresh = true;
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
            this.mDataThreadHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.FUCameraOperator.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (FUCameraOperator.this.mImageReader != null) {
                            FUCameraOperator.this.mImageReader.setOnImageAvailableListener(null, null);
                            FUCameraOperator.this.mImageReader.close();
                            FUCameraOperator.this.mImageReader = null;
                        }
                        if (z) {
                            FUCameraOperator.this.setupImageReader();
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
            this.mEncoder.prepare(this.mEglCore.getEGLContext(), encodeConfig, new VideoEncoderCore.OutputCallback() { // from class: com.baidu.ala.recorder.video.camera.FUCameraOperator.3
                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onFormatChanged(MediaFormat mediaFormat) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecConfig(byte[] bArr, int i, int i2) {
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecData(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                    if (!FUCameraOperator.this.mRequestKeyFrame || i3 == 2) {
                        if (FUCameraOperator.this.mRequestKeyFrame && i3 == 2) {
                            FUCameraOperator.this.mRequestKeyFrame = false;
                        }
                        if (FUCameraOperator.this.mDataCallback != null) {
                            FUCameraOperator.this.mDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j, j2);
                        }
                    }
                }

                @Override // com.baidu.ala.recorder.video.hardware.VideoEncoderCore.OutputCallback
                public void onCodecError(int i) {
                    BdLog.e("resetTextureEncoder onCodecError -- " + i);
                    FUCameraOperator.this.mRequestEncoderReset = true;
                    if (FUCameraOperator.this.mDataCallback != null) {
                        FUCameraOperator.this.mDataCallback.onError(i);
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
                this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.ala.recorder.video.camera.FUCameraOperator.4
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public void onImageAvailable(ImageReader imageReader) {
                        if (FUCameraOperator.this.mImageReader != null) {
                            Image image = null;
                            try {
                                Image acquireNextImage = FUCameraOperator.this.mImageReader.acquireNextImage();
                                FUCameraOperator.this.mHasReportFrameError = false;
                                if (acquireNextImage != null) {
                                    try {
                                        ByteBuffer buffer = acquireNextImage.getPlanes()[0].getBuffer();
                                        if (buffer == null) {
                                            acquireNextImage.close();
                                            return;
                                        }
                                        try {
                                            int pixelStride = acquireNextImage.getPlanes()[0].getPixelStride();
                                            FUCameraOperator.this.mImgLineSize = (acquireNextImage.getPlanes()[0].getRowStride() / pixelStride) * 4;
                                            buffer.rewind();
                                            int remaining = buffer.remaining();
                                            if (FUCameraOperator.this.mSendBuffer == null || FUCameraOperator.this.mSendBuffer.length < remaining) {
                                                FUCameraOperator.this.mSendBuffer = new byte[remaining];
                                            }
                                            buffer.get(FUCameraOperator.this.mSendBuffer);
                                            acquireNextImage.close();
                                            if (FUCameraOperator.this.mDataCallback != null) {
                                                FUCameraOperator.this.mDataCallback.onRawVideoFrameReceived(FUCameraOperator.this.mSendBuffer, remaining, 0, FUCameraOperator.this.mImgLineSize);
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
                                if (FUCameraOperator.this.mRecorderHandler != null && !FUCameraOperator.this.mHasReportFrameError) {
                                    FUCameraOperator.this.mRecorderHandler.sendError(1, e3.getMessage());
                                    FUCameraOperator.this.mHasReportFrameError = true;
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

    private void fuInitWithoutGLContext() {
        try {
            synchronized (AFullFrameRect.class) {
                if (!FU_INITED) {
                    FU_INITED = true;
                    if (AlaLiveRecorderConfig.getFaceUnityCallback() != null) {
                        faceunity.fuSetup(AlaLiveRecorderConfig.getFaceUnityCallback().getV3Data(), null, AlaLiveRecorderConfig.getFaceUnityCallback().getAuthPackCert());
                    } else {
                        Log.e(TAG, "faceunity fuSetup getFaceUnityCallback = null ");
                    }
                }
            }
            faceunity.fuSetMaxFaces(1);
            if (AlaLiveRecorderConfig.getFaceUnityCallback() != null) {
                this.mFacebeautyItem = faceunity.fuCreateItemFromPackage(AlaLiveRecorderConfig.getFaceUnityCallback().getFaceBeautificationData());
                this.itemsArray[0] = this.mFacebeautyItem;
            } else {
                Log.e(TAG, "faceunity createItemFromPackage getFaceUnityCallback = null");
            }
            this.mIsCreateFuObj = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (str == null || !str.equals(this.mGiftEffectFilePath)) {
            this.mGiftEffectFilePath = str;
            this.isGiftEffectNeedRefresh = true;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str, String str2, float f) {
        if (TextUtils.isEmpty(str2)) {
            this.mFilterName = FILTER_DEFAULT;
        } else {
            this.mFilterName = str2;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
        switch (i) {
            case 0:
                this.mFacebeautyBlurLevel = 0.0f;
                return;
            case 1:
                this.mFacebeautyBlurLevel = 1.0f;
                return;
            case 2:
                this.mFacebeautyBlurLevel = 2.0f;
                return;
            case 3:
                this.mFacebeautyBlurLevel = 3.0f;
                return;
            case 4:
                this.mFacebeautyBlurLevel = 4.0f;
                return;
            case 5:
                this.mFacebeautyBlurLevel = 5.0f;
                return;
            case 6:
                this.mFacebeautyBlurLevel = 6.0f;
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
        this.mFacebeautyColorLevel = f;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
        this.mFacebeautyCheeckThin = f;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
        this.mFacebeautyEnlargeEye = f;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
        this.mFaceShape = i;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
        this.mFaceShapeLevel = f;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
        if (IS_TIEBA) {
            this.mFacebeautyRedLevel = f;
        } else {
            this.mFacebeautyRedLevel = 2.0f * f;
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
    }

    public static boolean isValid() {
        return AlaLiveUtilHelper.loadPluginLibrary("nama") && AlaLiveUtilHelper.isClassValid("com.faceunity.wrapper.faceunity");
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
