package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.recorder.IFaceUnityOperator;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoFormat;
import com.baidu.live.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(16)
/* loaded from: classes3.dex */
public class AlaCameraRecorder extends TextureView implements TextureView.SurfaceTextureListener, IFaceUnityOperator, IVideoRecorder, ICameraStatusHandler {
    private static final String LOG_TAG = "ala_camera_recorder";
    private static final int MIN_SURFACE_CHANGE = 10;
    private Activity mActivity;
    private VideoBeautyType mBeautyType;
    private AlaCameraManager mCameraMgr;
    private IVideoRecorder.IVideoDataCallBack mExternVideoDataCallback;
    private RecorderHandler mHandler;
    private boolean mIsPreviewStoped;
    private volatile boolean mIsVideoThreadRun;
    private boolean mNeedBeauty;
    private Surface mSurface;
    private boolean mSurfaceCreated;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private int mSurfaceWidth;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;

    /* loaded from: classes3.dex */
    public interface SurfaceHolder {
        Surface getSurface();

        SurfaceTexture getSurfaceTexture();
    }

    public AlaCameraRecorder(Context context, RecorderHandler recorderHandler, boolean z, VideoBeautyType videoBeautyType) {
        super(context);
        this.mIsVideoThreadRun = false;
        this.mCameraMgr = null;
        this.mSurfaceHolder = new SurfaceHolder() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraRecorder.1
            @Override // com.baidu.ala.recorder.video.camera.AlaCameraRecorder.SurfaceHolder
            public Surface getSurface() {
                return AlaCameraRecorder.this.mSurface;
            }

            @Override // com.baidu.ala.recorder.video.camera.AlaCameraRecorder.SurfaceHolder
            public SurfaceTexture getSurfaceTexture() {
                return AlaCameraRecorder.this.mSurfaceTexture;
            }
        };
        this.mActivity = null;
        this.mIsPreviewStoped = false;
        this.mHandler = null;
        this.mNeedBeauty = false;
        this.mSurfaceCreated = false;
        this.mBeautyType = VideoBeautyType.BEAUTY_FACEUNITY;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mVideoDataCallback = new IVideoRecorder.IVideoDataCallBack() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraRecorder.2
            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3) {
                if (AlaCameraRecorder.this.mExternVideoDataCallback != null) {
                    AlaCameraRecorder.this.mExternVideoDataCallback.onRawVideoFrameReceived(bArr, i, i2, i3);
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2) {
                if (AlaCameraRecorder.this.mExternVideoDataCallback != null) {
                    AlaCameraRecorder.this.mExternVideoDataCallback.onEncodeVideoFrameRecived(bArr, i, i2, i3, j, j2);
                }
            }

            @Override // com.baidu.ala.recorder.video.IVideoRecorder.IVideoDataCallBack
            public void onError(int i) {
                if (AlaCameraRecorder.this.mExternVideoDataCallback != null) {
                    AlaCameraRecorder.this.mExternVideoDataCallback.onError(i);
                }
            }
        };
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
            this.mHandler = recorderHandler;
            this.mNeedBeauty = z;
            this.mBeautyType = videoBeautyType;
            setSurfaceTextureListener(this);
            this.mCameraMgr = new AlaCameraManager(this.mActivity, this.mSurfaceHolder, this.mHandler, this.mVideoDataCallback, this.mNeedBeauty, this.mBeautyType);
            return;
        }
        throw new IllegalArgumentException("context must be Activity");
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startRecord() {
        this.mIsPreviewStoped = false;
        if (this.mSurfaceCreated) {
            if (this.mActivity == null) {
                BdLog.e("mActivity is null.");
            } else if (!this.mIsVideoThreadRun) {
                this.mIsVideoThreadRun = true;
                if (this.mCameraMgr == null) {
                    throw new RuntimeException("mCameraMgr == null");
                }
                this.mCameraMgr.postStartCamera();
                BdLog.d("action startpreview");
            }
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
        this.mHandler.setRecorderCallback(recorderCallback);
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void willSwitchSense(int i) {
        if (this.mCameraMgr != null && this.mCameraMgr.getCameraOperator() != null) {
            this.mCameraMgr.getCameraOperator().willSwitchSense(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public VideoFormat getVideoFormat() {
        return (this.mCameraMgr == null || this.mCameraMgr.getCameraOperator() == null) ? VideoFormat.RGBA : this.mCameraMgr.getCameraOperator().getVideoFormat();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputWidth() {
        if (this.mCameraMgr == null || this.mCameraMgr.getCameraOperator() == null) {
            return 0;
        }
        return this.mCameraMgr.getOutputWidth();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getOutputHeight() {
        if (this.mCameraMgr == null || this.mCameraMgr.getCameraOperator() == null) {
            return 0;
        }
        return this.mCameraMgr.getOutputHeight();
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isVideoThreadRun() {
        return this.mIsVideoThreadRun;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public boolean isForeBackgroundSwitchEnable() {
        return true;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public View getPreview() {
        return this;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void release() {
        stopRecord();
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postDestroy();
        }
        try {
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.mSurfaceTexture != null) {
            setSurfaceTexture(this.mSurfaceTexture);
            if (this.mSurface == null) {
                this.mSurface = new Surface(this.mSurfaceTexture);
            }
        } else {
            this.mSurfaceTexture = surfaceTexture;
            this.mSurface = new Surface(surfaceTexture);
        }
        this.mSurfaceCreated = true;
        if (!this.mIsPreviewStoped) {
            startRecord();
        }
        if (this.mSurfaceWidth > 0 && this.mSurfaceHeight > 0 && (i != this.mSurfaceWidth || i2 != this.mSurfaceHeight)) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
        this.mSurfaceHeight = i2;
        this.mSurfaceWidth = i;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mCameraMgr != null && getLayoutParams() != null) {
            resetCamera();
            if (this.mSurfaceHeight > 0 && this.mSurfaceWidth > 0) {
                if (configuration.orientation == 2 && this.mSurfaceWidth < this.mSurfaceHeight) {
                    int i = this.mSurfaceHeight;
                    this.mSurfaceHeight = this.mSurfaceWidth;
                    this.mSurfaceWidth = i;
                    if (this.mSurfaceTexture != null) {
                        onSurfaceTextureSizeChanged(this.mSurfaceTexture, this.mSurfaceWidth, this.mSurfaceHeight);
                    }
                }
                if (configuration.orientation == 1 && this.mSurfaceHeight < this.mSurfaceWidth) {
                    int i2 = this.mSurfaceHeight;
                    this.mSurfaceHeight = this.mSurfaceWidth;
                    this.mSurfaceWidth = i2;
                    if (this.mSurfaceTexture != null) {
                        onSurfaceTextureSizeChanged(this.mSurfaceTexture, this.mSurfaceWidth, this.mSurfaceHeight);
                    }
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        int realScreenOrientation = AlaLiveUtilHelper.getRealScreenOrientation(this.mActivity);
        if (i != this.mSurfaceWidth || i2 != this.mSurfaceHeight) {
            if (this.mCameraMgr != null && realScreenOrientation == 2 && i < i2) {
                i = i2;
                i2 = i;
            }
            if (this.mCameraMgr != null) {
                this.mSurfaceWidth = i;
                this.mSurfaceHeight = i2;
                this.mCameraMgr.postSurfaceChanged(i, i2);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        stopRecord();
        return this.mSurfaceTexture == null;
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
        this.mCameraMgr = new AlaCameraManager(this.mActivity, this.mSurfaceHolder, this.mHandler, this.mVideoDataCallback, this.mNeedBeauty, this.mBeautyType);
        this.mCameraMgr.setVideoConfig(this.mVideoConfig);
        return this.mCameraMgr.isBackCamera();
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
        this.mCameraMgr = new AlaCameraManager(this.mActivity, this.mSurfaceHolder, this.mHandler, this.mVideoDataCallback, this.mNeedBeauty, this.mBeautyType);
        this.mCameraMgr.setVideoConfig(this.mVideoConfig);
        return this.mCameraMgr.isFlashingLightOpen();
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setBeauty(int i) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postBeautyLevel(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int hasBeauty() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.hasBeauty();
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
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setVideoConfig(this.mVideoConfig);
        }
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public int getBitRate() {
        if (this.mVideoConfig != null) {
            return this.mVideoConfig.getBitStream();
        }
        return 0;
    }

    @Override // com.baidu.ala.recorder.video.IVideoRecorder
    public void startGetDataToSend() {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postSendData();
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEffectItemSelected(String str) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onEffectItemSelected(str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onStickerItemSelected(Object obj) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onStickerItemSelected(obj);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onGiftEffectItemSelected(String str) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onGiftEffectItemSelected(str);
        } else if (this.mHandler != null) {
            this.mHandler.sendError(7, str);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFilterSelected(String str, String str2, float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onFilterSelected(str, str2, f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onBlurLevelSelected(int i) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onBlurLevelSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onColorLevelSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onColorLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onCheekThinSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onCheekThinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onEnlargeEyeSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onEnlargeEyeSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeSelected(int i) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onFaceShapeSelected(i);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onFaceShapeLevelSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onFaceShapeLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onRedLevelSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onRedLevelSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onChinSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onChinSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.IFaceUnityOperator
    public void onNoseSelected(float f) {
        if (this.mCameraMgr != null && this.mCameraMgr.getFaceUnityOperator() != null) {
            this.mCameraMgr.getFaceUnityOperator().onNoseSelected(f);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean hasAdvancedBeauty() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.hasAdvancedBeauty();
        }
        return false;
    }

    public void setPushMirror(boolean z) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setPushMirror(z);
        }
    }

    public boolean isPushMirror() {
        if (this.mCameraMgr != null) {
            return this.mCameraMgr.isPushMirror();
        }
        return false;
    }

    public void setPreviewFps(int i) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setPreviewFps(i);
        }
    }

    public void setDefBeautyParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setDefBeautyParams(concurrentHashMap);
        }
    }

    public void setBeautyJsonPath(String str) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.setBeautyJsonPath(str);
        }
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.onBeautyParamsChanged(f, hashMap);
        }
    }

    public void onBeautyTypeChanged(VideoBeautyType videoBeautyType) {
        this.mBeautyType = videoBeautyType;
        if (this.mCameraMgr != null) {
            stopRecord();
            this.mCameraMgr.postStopCamera();
            this.mCameraMgr.postDestroy();
            this.mCameraMgr = null;
        }
        this.mCameraMgr = new AlaCameraManager(this.mActivity, this.mSurfaceHolder, this.mHandler, this.mVideoDataCallback, this.mNeedBeauty, this.mBeautyType);
        this.mCameraMgr.setVideoConfig(this.mVideoConfig);
        startRecord();
    }

    private void resetCamera() {
        if (this.mCameraMgr != null) {
            this.mCameraMgr.postResetCamera();
        }
    }
}
