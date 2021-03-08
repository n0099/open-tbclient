package com.baidu.ala.recorder.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.IFaceUnityOperator;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.camera.AlaCameraManager;
import com.baidu.ala.recorder.video.camera.AlaTextureView;
import com.baidu.ala.recorder.video.camera.DuArCameraOperator;
import com.baidu.ala.recorder.video.camera.FUCameraOperator;
import com.baidu.ala.recorder.video.camera.GPUCameraOperator;
import com.baidu.ala.recorder.video.camera.ICameraOperator;
import com.baidu.ala.recorder.video.camera.ICameraStatusHandler;
import com.baidu.ala.recorder.video.camera.TBCameraOperator;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ala.recorder.video.drawer.ScreenTextureDrawer;
import com.baidu.ala.recorder.video.gles.EglCore;
import com.baidu.ala.recorder.video.listener.CameraListener;
import com.baidu.ala.recorder.video.listener.ImageFilter;
import com.baidu.ala.recorder.video.listener.TextureViewListener;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class AlaLiveSession implements IFaceUnityOperator, IVideoRecorder, ICameraStatusHandler, ICameraStatusHandler.Beauty {
    private static final int MIN_SURFACE_CHANGE = 10;
    private static final String TAG = AlaLiveSession.class.getSimpleName();
    private static final boolean VERBOSE = false;
    private ICameraOperator mCameraOperator;
    private Context mContext;
    private ConcurrentHashMap<String, Object> mDefBeautyParams;
    private EncoderTextureDrawer mEncoderDrawer;
    private IVideoRecorder.IVideoDataCallBack mExternVideoDataCallback;
    private RecorderHandler mHandler;
    private ScreenTextureDrawer mScreenDrawer;
    private EGLTextureReader mTextureReader;
    private EGLTextureReader.OnPixelReadCallback mTextureReaderListener;
    private AlaTextureView mTextureView;
    private AlaLiveVideoConfig mVideoConfig;
    private TextureViewListener.SurfaceHolder mWindowSurfaceHolder;
    private VideoBeautyType mBeautyType = VideoBeautyType.DUMIX_AR;
    private boolean mEnableEncoderDrawer = true;
    private AlaCameraManager mCameraMgr = null;
    private EglCore mEglCore = null;
    private volatile boolean mIsVideoThreadRun = false;
    private boolean mIsPreviewStoped = false;
    private boolean mSurfaceCreated = false;
    private boolean mUseDummyCapture = false;
    private boolean mIsMirror = false;
    private ImageFilter.Output mImageOutput = new ImageFilter.Output() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.3
        @Override // com.baidu.ala.recorder.video.listener.ImageFilter.Output
        public void onImageDone(int i, float[] fArr, long j) {
            int i2;
            if (AlaLiveSession.this.mScreenDrawer != null) {
                AlaLiveSession.this.mScreenDrawer.drawFrame(i, fArr);
            }
            boolean isBackCamera = AlaLiveSession.this.mCameraMgr.isBackCamera();
            if (AlaLiveSession.this.mEncoderDrawer != null && AlaLiveSession.this.mEnableEncoderDrawer) {
                if (isBackCamera) {
                    i2 = 1;
                } else {
                    i2 = AlaLiveSession.this.mIsMirror ? 3 : 1;
                }
                AlaLiveSession.this.mEncoderDrawer.drawFrame(i, EncoderTextureDrawer.getMatrix(i2), j);
            }
            if (AlaLiveSession.this.mTextureReader != null) {
                if (AlaLiveSession.this.mIsMirror) {
                    AlaLiveSession.this.mTextureReader.setPixelOutputFlipH(true);
                } else {
                    AlaLiveSession.this.mTextureReader.setPixelOutputFlipH(false);
                }
                if (AlaLiveSession.this.mVideoConfig.isLandscape()) {
                    AlaLiveSession.this.mTextureReader.onTextureUpdate(i, AlaLiveSession.this.mVideoConfig.getPreviewHeight(), AlaLiveSession.this.mVideoConfig.getPreviewWidth());
                } else {
                    AlaLiveSession.this.mTextureReader.onTextureUpdate(i, AlaLiveSession.this.mVideoConfig.getPreviewWidth(), AlaLiveSession.this.mVideoConfig.getPreviewHeight());
                }
            }
        }
    };
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback = new IVideoRecorder.IVideoDataCallBack() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.4
        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3, long j) {
            if (AlaLiveSession.this.mExternVideoDataCallback != null) {
                AlaLiveSession.this.mExternVideoDataCallback.onRawVideoFrameReceived(bArr, i, i2, i3, j);
            }
        }

        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2, int i4) {
            if (AlaLiveSession.this.mExternVideoDataCallback != null) {
                AlaLiveSession.this.mExternVideoDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3, j, j2, i4);
            }
        }

        @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
        public void onError(int i) {
            if (AlaLiveSession.this.mExternVideoDataCallback != null) {
                AlaLiveSession.this.mExternVideoDataCallback.onError(i);
            }
        }
    };
    private boolean mNeedBeauty = true;
    private boolean mNeedYuvConvert = false;
    private CameraListener mCameraListener = new CameraListener() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.5
        @Override // com.baidu.ala.recorder.video.listener.CameraListener
        public boolean onCameraOpen(Camera camera, int i) {
            AlaLiveSession.logPrint("mCameraListener.onCameraOpen | ");
            return AlaLiveSession.this.doOnCameraOpen(camera, i);
        }

        @Override // com.baidu.ala.recorder.video.listener.CameraListener
        public void onSurfaceChanged(int i, int i2) {
            AlaLiveSession.logPrint("mCameraListener.onSurfaceChanged width: " + i + " height:" + i2);
            AlaLiveSession.this.doOnSurfaceChanged(i, i2);
        }

        @Override // com.baidu.ala.recorder.video.listener.CameraListener
        public ImageFilter getImageFilter() {
            AlaLiveSession.logPrint("mCameraListener.getImageFilterDelegate | ");
            if (AlaLiveSession.this.mCameraOperator != null) {
                return AlaLiveSession.this.mCameraOperator.getImageFilter();
            }
            return null;
        }
    };
    private TextureViewListener mTextureViewListener = new TextureViewListener() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.6
        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AlaLiveSession.logPrint("mTextureViewListener.onSurfaceTextureAvailable | " + i + " | " + i2);
            AlaLiveSession.this.mSurfaceCreated = true;
            if (!AlaLiveSession.this.mIsPreviewStoped) {
                AlaLiveSession.this.startRecord();
            }
        }

        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AlaLiveSession.logPrint("mTextureViewListener.onSurfaceTextureSizeChanged | " + i + " | " + i2);
            AlaLiveSession.this.mCameraMgr.postSurfaceChanged(i, i2);
        }

        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AlaLiveSession.logPrint("mTextureViewListener.onSurfaceTextureDestroyed ");
            AlaLiveSession.this.mSurfaceCreated = false;
            AlaLiveSession.this.mIsVideoThreadRun = false;
            AlaLiveSession.this.mIsPreviewStoped = true;
            AlaLiveSession.this.mCameraMgr.postStopCamera();
        }

        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onConfigurationChanged(Configuration configuration) {
            AlaLiveSession.logPrint("mTextureViewListener.onSurfaceTextureSizeChanged ");
            if (AlaLiveSession.this.mSurfaceCreated) {
                AlaLiveSession.this.mCameraMgr.postResetCamera();
            }
        }

        @Override // com.baidu.ala.recorder.video.listener.TextureViewListener
        public void onSurfaceWindow(TextureViewListener.SurfaceHolder surfaceHolder) {
            AlaLiveSession.this.mWindowSurfaceHolder = surfaceHolder;
            AlaLiveSession.this.checkNeedCreateOperator();
            AlaLiveSession.this.checkNeedCreateDrawer();
            AlaLiveSession.this.checkNeedCreateReader();
        }
    };

    public AlaLiveSession(Context context) {
        this.mHandler = null;
        this.mContext = context;
        this.mHandler = new RecorderHandler(Looper.getMainLooper());
    }

    public void init(VideoRecorderType videoRecorderType, VideoBeautyType videoBeautyType) {
        if (videoRecorderType != VideoRecorderType.CAMERA) {
            throw new RuntimeException("not support type");
        }
        this.mBeautyType = videoBeautyType;
        this.mTextureView = new AlaTextureView(this.mContext);
        this.mTextureView.addListener(this.mTextureViewListener);
        this.mCameraMgr = new AlaCameraManager((Activity) this.mContext, this.mHandler, this.mCameraListener);
    }

    public void setTextureReaderListener(EGLTextureReader.OnPixelReadCallback onPixelReadCallback) {
        this.mTextureReaderListener = onPixelReadCallback;
        if (this.mTextureReader != null) {
            this.mTextureReader.setOnPixelReadCallback(onPixelReadCallback);
        }
    }

    public void enableEncoderDrawer(boolean z) {
        this.mEnableEncoderDrawer = z;
    }

    public void onFocus(int i, int i2, int i3, int i4) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.onFocus(i, i2, i3, i4);
        }
    }

    public void onExposure(float f) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.onExposure(f);
        }
    }

    public float getExposure() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.getExposure();
        }
        return -1.0f;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startRecord() {
        this.mIsPreviewStoped = false;
        if (this.mSurfaceCreated && !this.mIsVideoThreadRun) {
            if (this.mCameraMgr == null) {
                throw new RuntimeException("start record fail mCameraMgr = null");
            }
            this.mIsVideoThreadRun = true;
            this.mCameraMgr.postStartCamera();
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void stopRecord() {
        this.mIsPreviewStoped = true;
        this.mIsVideoThreadRun = false;
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postStopCamera();
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setVideoDataCallback(IVideoRecorder.IVideoDataCallBack iVideoDataCallBack) {
        this.mExternVideoDataCallback = iVideoDataCallBack;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void setRecorderCallback(RecorderCallback recorderCallback) {
        if (this.mHandler != null) {
            this.mHandler.setRecorderCallback(recorderCallback);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void willSwitchSense(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.willSwitchSense(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public VideoFormat getVideoFormat() {
        return this.mEncoderDrawer != null ? this.mEncoderDrawer.getVideoFormat() : VideoFormat.RGBA;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputWidth() {
        return this.mVideoConfig.getVideoWidth();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputHeight() {
        return this.mVideoConfig.getVideoHeight();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isVideoThreadRun() {
        return this.mIsVideoThreadRun;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean dealBackground() {
        return true;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public View getPreview() {
        return this.mTextureView;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void release() {
        if (this.mTextureView != null) {
            this.mTextureView.removeAllListener();
            this.mTextureView.release();
            this.mTextureView = null;
        }
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postDestroy(new Runnable() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaLiveSession.this.onGLDestroy();
                }
            });
        }
        this.mContext = null;
        if (this.mHandler != null) {
            this.mHandler.setRecorderCallback(null);
        }
        this.mHandler = null;
    }

    public void sendStreamState(int i, boolean z, int i2, boolean z2) {
        if (this.mHandler != null) {
            this.mHandler.sendStreamState(i, z, i2, z2);
        }
    }

    public void sendLostRate(double d) {
        if (this.mHandler != null) {
            this.mHandler.sendLostRate(d);
        }
    }

    public void sendDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        if (this.mHandler != null) {
            this.mHandler.sendDebugInfo(alaLiveDebugInfo);
        }
    }

    public void sendNetStateInfo(int i, int i2) {
        if (this.mHandler != null) {
            this.mHandler.sendNetState(i, i2);
        }
    }

    public void sendError(int i, String str) {
        if (this.mHandler != null) {
            this.mHandler.sendError(i, str);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendBufferChanged(i);
        }
    }

    public RecorderHandler getRecorderHandler() {
        return this.mHandler;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postSwitchCamera();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isBackCamera() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.isBackCamera();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchFlashingLight() {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postSwitchFlashLight();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isFlashingLightOpen() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.isFlashingLightOpen();
        }
        return false;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
    public void setBeauty(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setBeauty(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
    public int hasBeauty() {
        if (this.mCameraOperator != null) {
            return this.mCameraOperator.hasBeauty();
        }
        if (this.mBeautyType != VideoBeautyType.BEAUTY_NONE) {
            return 1;
        }
        return -1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int getDisplayRotate() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.getDisplayRotate();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder, com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setVideoConfig(alaLiveVideoConfig);
        }
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setVideoConfig(alaLiveVideoConfig);
        }
        if (this.mEncoderDrawer != null) {
            this.mEncoderDrawer.setVideoConfig(this.mVideoConfig);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getBitRate() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getBitStream();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEffectItemSelected(String str) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onEffectItemSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onStickerItemSelected(Object obj) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onStickerItemSelected(obj);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onGiftEffectItemSelected(str);
        } else if (this.mHandler != null) {
            this.mHandler.sendError(7, str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str, String str2, float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onFilterSelected(str, str2, f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onBlurLevelSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onColorLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onCheekThinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onEnlargeEyeSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onFaceShapeSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onFaceShapeLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onRedLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onChinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof IFaceUnityOperator)) {
            ((IFaceUnityOperator) this.mCameraOperator).onNoseSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler.Beauty
    public boolean hasAdvancedBeauty() {
        return this.mCameraOperator instanceof IFaceUnityOperator;
    }

    public void setPushMirror(boolean z) {
        if (this.mCameraOperator != null) {
            this.mIsMirror = z;
            this.mCameraOperator.setPushMirror(z);
        }
    }

    public boolean isPushMirror() {
        return this.mIsMirror;
    }

    public void setPreviewFps(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setPreviewFps(i);
        }
    }

    public void setDefBeautyParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (concurrentHashMap != null) {
            this.mDefBeautyParams = concurrentHashMap;
            if (this.mCameraOperator != null && (this.mCameraOperator instanceof DuArCameraOperator)) {
                ((DuArCameraOperator) this.mCameraOperator).setDefBeautyParams(concurrentHashMap);
            }
        }
    }

    public void setBeautyJsonPath(String str) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof DuArCameraOperator)) {
            ((DuArCameraOperator) this.mCameraOperator).setBeautyJsonPath(str);
        }
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof DuArCameraOperator)) {
            ((DuArCameraOperator) this.mCameraOperator).onBeautyParamsChanged(f, hashMap);
        }
    }

    public void onBeautyParamsChanged(String str, Object obj) {
        if (this.mCameraOperator != null && (this.mCameraOperator instanceof DuArCameraOperator)) {
            ((DuArCameraOperator) this.mCameraOperator).onBeautyParamsChanged(str, obj);
        }
    }

    public void setUseDummyCapture(boolean z) {
        this.mUseDummyCapture = z;
        Log.i(TAG, "setUseDummyCapture enable:" + z);
    }

    public void onPause() {
        Log.i(TAG, "onPause, mUseDummyCapture:" + this.mUseDummyCapture);
        if (this.mUseDummyCapture && this.mEncoderDrawer != null) {
            this.mEncoderDrawer.setRepeatDraw(true);
        }
    }

    public void onResume() {
        Log.i(TAG, "onResume, mUseDummyCapture:" + this.mUseDummyCapture);
        if (this.mUseDummyCapture && this.mEncoderDrawer != null) {
            this.mEncoderDrawer.setRepeatDraw(false);
        }
    }

    public void onBeautyTypeChanged(final VideoBeautyType videoBeautyType) {
        this.mCameraMgr.postDestroy(new Runnable() { // from class: com.baidu.ala.recorder.video.AlaLiveSession.2
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveSession.this.doOnBeautyTypeChanged(videoBeautyType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnBeautyTypeChanged(VideoBeautyType videoBeautyType) {
        stopRecord();
        if (this.mCameraOperator != null) {
            this.mCameraOperator.release();
            this.mCameraOperator = null;
        }
        this.mBeautyType = videoBeautyType;
        checkNeedCreateOperator();
        checkNeedCreateReader();
        startRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGLDestroy() {
        try {
            if (this.mCameraOperator != null) {
                this.mCameraOperator.release();
                this.mCameraOperator = null;
            }
            if (this.mEncoderDrawer != null) {
                this.mEncoderDrawer.onRelease();
                this.mEncoderDrawer = null;
            }
            if (this.mScreenDrawer != null) {
                this.mScreenDrawer.onRelease();
                this.mScreenDrawer = null;
            }
            if (this.mTextureReader != null) {
                this.mTextureReader.release();
                this.mTextureReader = null;
            }
            if (this.mEglCore != null) {
                this.mEglCore.makeNothingCurrent();
                this.mEglCore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedCreateOperator() {
        if (this.mCameraOperator == null) {
            this.mCameraOperator = createCameraOperator(true, this.mBeautyType);
            this.mCameraOperator.setVideoConfig(this.mVideoConfig);
            this.mCameraOperator.getImageFilter().setupImageOutput(this.mImageOutput);
            if (this.mDefBeautyParams != null) {
                setDefBeautyParams(this.mDefBeautyParams);
            }
            logPrint("checkNeedCreateOperator mNeedBeauty | " + this.mNeedBeauty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedCreateDrawer() {
        if (this.mScreenDrawer == null) {
            this.mScreenDrawer = new ScreenTextureDrawer();
            this.mScreenDrawer.onInputSize(this.mVideoConfig.getPreviewWidth(), this.mVideoConfig.getPreviewHeight());
        }
        if (this.mEncoderDrawer == null) {
            this.mEncoderDrawer = new EncoderTextureDrawer(this.mHandler, this.mVideoDataCallback);
            this.mEncoderDrawer.setVideoConfig(this.mVideoConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedCreateReader() {
        if (this.mTextureReader == null) {
            Log.e("qlc", "new EGLTextureReader mVideoConfig.isLandscape() " + this.mVideoConfig.isLandscape());
            this.mTextureReader = new EGLTextureReader(this.mContext, this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight());
        }
        if (this.mVideoConfig.isLandscape()) {
            this.mTextureReader.setOutPutSize(this.mVideoConfig.getVideoHeight(), this.mVideoConfig.getVideoWidth());
        } else {
            this.mTextureReader.setOutPutSize(this.mVideoConfig.getVideoWidth(), this.mVideoConfig.getVideoHeight());
        }
        if (this.mTextureReaderListener != null) {
            this.mTextureReader.setOnPixelReadCallback(this.mTextureReaderListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnSurfaceChanged(int i, int i2) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.surfaceChanged(i, i2);
        }
        int surfaceWidth = this.mScreenDrawer.getSurfaceWidth();
        int surfaceheight = this.mScreenDrawer.getSurfaceheight();
        if (Math.abs(surfaceheight - i2) >= 10 || Math.abs(surfaceWidth - i) >= 10) {
            this.mScreenDrawer.onSurfaceChanged(i, i2);
            if (surfaceheight <= surfaceWidth || i2 <= i || surfaceWidth <= 0) {
                if ((surfaceWidth <= surfaceheight || i <= i2 || surfaceheight <= 0) && this.mVideoConfig != null && this.mEncoderDrawer != null) {
                    this.mEncoderDrawer.onSurfaceChanged(i, i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doOnCameraOpen(Camera camera, int i) {
        boolean z = true;
        if (this.mEglCore == null) {
            try {
                this.mEglCore = new EglCore(null, 1);
            } catch (Exception e) {
                if (this.mHandler != null) {
                    this.mHandler.sendError(3, "new EglCore() -> EGL14.eglCreateContext --" + e.getMessage());
                }
            }
        }
        if (this.mScreenDrawer == null || this.mEncoderDrawer == null) {
            logPrint("doOnCameraOpen error mScreenDrawer = null or mEncoderDrawer = null");
            return false;
        }
        if (!this.mScreenDrawer.isCreated()) {
            this.mScreenDrawer.onSurfaceCreate(this.mEglCore, this.mWindowSurfaceHolder.getSurface());
            z = false;
        }
        if (!this.mEncoderDrawer.isCreated()) {
            this.mEncoderDrawer.onCreate(this.mEglCore, this.mVideoConfig);
        }
        this.mEncoderDrawer.requestKeyframe();
        if (z) {
            this.mScreenDrawer.makeContext();
        }
        if (this.mTextureReader != null && this.mEglCore != null) {
            this.mTextureReader.setup(this.mEglCore.getEGLContext());
        }
        if (this.mCameraOperator != null) {
            return this.mCameraOperator.onCameraOpened(camera, i, this.mEglCore);
        }
        return false;
    }

    private ICameraOperator createCameraOperator(boolean z, VideoBeautyType videoBeautyType) {
        Activity activity = (Activity) this.mContext;
        if (z && Build.VERSION.SDK_INT >= 19) {
            if (videoBeautyType == VideoBeautyType.DUMIX_AR) {
                return new DuArCameraOperator(activity, this.mWindowSurfaceHolder, this, this.mHandler);
            }
            if (videoBeautyType == VideoBeautyType.BEAUTY_FACEUNITY) {
                if (FUCameraOperator.isValid()) {
                    return new FUCameraOperator(activity, this.mWindowSurfaceHolder, this, this.mHandler);
                }
            } else if (videoBeautyType == VideoBeautyType.BEAUTY_NONE) {
                return new GPUCameraOperator(activity, this.mWindowSurfaceHolder, this, this.mHandler);
            }
            return new TBCameraOperator(activity, this.mWindowSurfaceHolder, this, this.mHandler);
        }
        this.mNeedBeauty = false;
        if (Build.VERSION.SDK_INT < 19) {
            this.mNeedYuvConvert = true;
            this.mVideoConfig.setEncodeType(2);
        }
        return new GPUCameraOperator(activity, this.mWindowSurfaceHolder, this, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logPrint(String str) {
    }
}
