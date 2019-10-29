package com.baidu.ala.liveRecorder.video.camera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.ala.liveRecorder.IFaceUnityOperator;
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.ala.liveRecorder.video.IVideoRecorder;
import com.baidu.ala.liveRecorder.video.RecorderHandler;
import com.baidu.ala.liveRecorder.video.VideoBeautyType;
import com.baidu.ala.liveRecorder.video.camera.AlaCameraRecorder;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public class AlaCameraManager implements ICameraStatusHandler {
    private static final int CAMERA_FLUSHLIGHT_OFF = 2;
    private static final int CAMERA_FLUSHLIGHT_ON = 1;
    private static final int CAMERA_FLUSHLIGHT_UNINIT = 0;
    private static final int MAX_CAREMA_ERROR_COUNT = 3;
    private static final int MAX_CAREMA_ERROR_INTERVAL = 30000;
    private static final int REQ_CAMERA_FPS = 30;
    private static final String SP_CAMERA_FACING = "ala_carema_is_back";
    private static int mFlushLightStatus = 0;
    private Activity mActivity;
    private volatile CameraHandler mCameraHandler;
    private ICameraOperator mCameraOperator;
    private volatile Looper mLooper;
    private RecorderHandler mMainHandler;
    private boolean mNeedBeauty;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;
    private Camera mCamera = null;
    private int mCameraId = -1;
    private int mCameraBufferLength = 0;
    private volatile boolean mIsSendDataStart = false;
    private boolean mIsBackCamera = false;
    private int mDisplayRotate = 0;
    private int mDisplayRotateOffset = 0;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private long mLastTimeCaremaError = 0;
    private int mCaremaErrorCount = 0;
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    protected int fps = 0;

    static /* synthetic */ int access$108(AlaCameraManager alaCameraManager) {
        int i = alaCameraManager.mCaremaErrorCount;
        alaCameraManager.mCaremaErrorCount = i + 1;
        return i;
    }

    public AlaCameraManager(Activity activity, AlaCameraRecorder.SurfaceHolder surfaceHolder, RecorderHandler recorderHandler, IVideoRecorder.IVideoDataCallBack iVideoDataCallBack, boolean z, VideoBeautyType videoBeautyType) {
        this.mSurfaceHolder = null;
        this.mActivity = null;
        this.mNeedBeauty = true;
        this.mNeedBeauty = z;
        this.mActivity = activity;
        this.mSurfaceHolder = surfaceHolder;
        this.mMainHandler = recorderHandler;
        this.mVideoDataCallback = iVideoDataCallBack;
        this.mCameraOperator = createCameraOperator(this.mNeedBeauty, videoBeautyType);
    }

    public void setCameraLooper(Looper looper) {
        this.mLooper = looper;
        if (this.mCameraHandler == null) {
            this.mCameraHandler = new CameraHandler(this, this.mLooper);
        }
    }

    public void prepStartCamera() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendStartCamera();
        }
    }

    public void prepStopCamera() {
        this.mIsSendDataStart = false;
        if (this.mCameraHandler != null) {
            this.mCameraHandler.sendStopCamera();
        }
    }

    public void doStartCamera() {
        this.mIsBackCamera = SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(SP_CAMERA_FACING), false);
        boolean openCamera = openCamera();
        if (this.mIsSendDataStart) {
            startSendData();
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.sendVideoCollectionStart(openCamera, this.mPreviewHeight, this.mPreviewWidth);
        }
    }

    public void doStopCamera() {
        if (this.mCameraHandler != null) {
            this.mCameraHandler.removeCallbacksAndMessages(null);
        }
        if (this.mCameraOperator != null) {
            this.mCameraOperator.release();
        }
        releaseCamera(true);
        this.mActivity = null;
        this.mCameraHandler = null;
    }

    public CameraHandler getHandler() {
        return this.mCameraHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openCamera() {
        boolean z;
        if (this.mCamera != null) {
            return true;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.mCameraId = 1;
        if (this.mIsBackCamera) {
            this.mCameraId = 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (true) {
            if (i >= numberOfCameras) {
                break;
            }
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing != this.mCameraId) {
                    i++;
                } else {
                    this.mCamera = Camera.open(i);
                    break;
                }
            } catch (Exception e) {
                BdLog.e(e);
                return false;
            }
        }
        if (this.mCamera == null) {
            this.mCamera = Camera.open();
        }
        if (this.mCamera != null) {
            try {
                Camera.Parameters parameters = this.mCamera.getParameters();
                parameters.setPreviewFormat(17);
                CameraUtils.choosePreviewSize(parameters, this.mVideoConfig.getPreviewHeight(), this.mVideoConfig.getPreviewWidth());
                CameraUtils.chooseFixedPreviewFps(parameters, 30000);
                parameters.setRecordingHint(true);
                if (this.mIsBackCamera) {
                    if (mFlushLightStatus == 1) {
                        CameraUtils.turnLightOn(parameters);
                    } else if (mFlushLightStatus == 2) {
                        CameraUtils.turnLightOff(parameters);
                    }
                }
                parameters.setRecordingHint(true);
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                this.mCamera.setParameters(parameters);
                Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
                this.mPreviewWidth = previewSize.width;
                this.mPreviewHeight = previewSize.height;
                this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, cameraInfo, this.mCameraId);
                this.mDisplayRotate += this.mDisplayRotateOffset;
                this.mCamera.setDisplayOrientation(this.mDisplayRotate);
                this.mCameraBufferLength = (int) (this.mPreviewWidth * this.mPreviewHeight * 1.5d);
                this.mCamera.setErrorCallback(new Camera.ErrorCallback() { // from class: com.baidu.ala.liveRecorder.video.camera.AlaCameraManager.1
                    @Override // android.hardware.Camera.ErrorCallback
                    public void onError(int i2, Camera camera) {
                        BdLog.e("Camera error. errcode is " + i2);
                        if (i2 == 100 || i2 == 1) {
                            if (System.currentTimeMillis() - AlaCameraManager.this.mLastTimeCaremaError > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                                AlaCameraManager.this.mCaremaErrorCount = 0;
                            }
                            AlaCameraManager.this.mLastTimeCaremaError = System.currentTimeMillis();
                            if (AlaCameraManager.this.mCaremaErrorCount <= 3) {
                                AlaCameraManager.access$108(AlaCameraManager.this);
                                AlaCameraManager.this.releaseCamera(false);
                                AlaCameraManager.this.openCamera();
                            }
                        }
                    }
                });
                if (this.mCameraOperator != null) {
                    this.mCameraOperator.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
                    try {
                        z = this.mCameraOperator.onCameraOpened(this.mCamera, this.mCameraId, this.mCameraBufferLength);
                    } catch (Throwable th) {
                        BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, BdStatsConstant.StatsType.ERROR, "openCamera Failed:" + th.getLocalizedMessage());
                        if (this.mMainHandler != null) {
                            this.mMainHandler.sendError(3, th.getMessage());
                        }
                        z = false;
                    }
                    return z;
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera(boolean z) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallbackWithBuffer(null);
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (z && this.mMainHandler != null) {
            this.mMainHandler.sendVideoCollectionStop();
        }
    }

    private ICameraOperator createCameraOperator(boolean z, VideoBeautyType videoBeautyType) {
        if (z && Build.VERSION.SDK_INT >= 19) {
            if (videoBeautyType == VideoBeautyType.BEAUTY_FACEUNITY && FUCameraOperator.isValid()) {
                return new FUCameraOperator(this.mActivity, this.mCamera, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
            }
            return new BaoBaoCameraOperator(this.mActivity, this.mCamera, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
        }
        this.mNeedBeauty = false;
        return new CPUCaremaOperator(this.mActivity, this.mCamera, this.mSurfaceHolder, this, this.mVideoDataCallback);
    }

    public void surfaceChanged(int i, int i2) {
        if (this.mCameraHandler != null || this.mCamera != null || this.mActivity != null) {
            if (this.mSurfaceWidth != i || this.mSurfaceHeight != i2) {
                resetCamera();
            }
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            if (this.mCameraOperator != null) {
                this.mCameraOperator.surfaceChanged(i, i2);
            }
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        releaseCamera(false);
        this.mIsBackCamera = !this.mIsBackCamera;
        SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(SP_CAMERA_FACING), this.mIsBackCamera);
        openCamera();
        if (this.mMainHandler != null) {
            this.mMainHandler.sendSwitchCarema(this.mIsBackCamera ? false : true);
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public boolean isBackCamera() {
        return this.mIsBackCamera;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public void switchFlashingLight() {
        if (this.mIsBackCamera) {
            releaseCamera(false);
            if (mFlushLightStatus != 1) {
                mFlushLightStatus = 1;
            } else {
                mFlushLightStatus = 2;
            }
            openCamera();
            if (this.mMainHandler != null) {
                this.mMainHandler.sendSwitchFlashLight(isFlashingLightOpen());
            }
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public boolean isFlashingLightOpen() {
        return mFlushLightStatus == 1;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public void setBeauty(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setBeauty(i);
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public int hasBeauty() {
        if (this.mCameraOperator != null) {
            return this.mCameraOperator.hasBeauty();
        }
        return -1;
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public int getDisplayRotate() {
        return this.mDisplayRotate;
    }

    public int getOutputWidth() {
        return this.mCameraOperator != null ? this.mCameraOperator.getOutputWidth() : this.mPreviewWidth;
    }

    public int getOutputHeight() {
        return this.mCameraOperator != null ? this.mCameraOperator.getOutputHeight() : this.mPreviewHeight;
    }

    public ICameraOperator getCameraOperator() {
        return this.mCameraOperator;
    }

    public IFaceUnityOperator getFaceUnityOperator() {
        if (this.mCameraOperator instanceof IFaceUnityOperator) {
            return (IFaceUnityOperator) this.mCameraOperator;
        }
        return null;
    }

    public Handler getDataHandler() {
        return (this.mCameraOperator == null || this.mCameraOperator.getDataThreadHandler() == null) ? this.mCameraHandler : this.mCameraOperator.getDataThreadHandler();
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setVideoConfig(this.mVideoConfig);
        }
    }

    private void resetCamera() {
        try {
            if (this.mCamera != null && this.mCamera.getParameters() != null) {
                this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, null, this.mCameraId);
                this.mDisplayRotate += this.mDisplayRotateOffset;
                this.mCamera.setDisplayOrientation(this.mDisplayRotate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSendDataFlag(boolean z) {
        this.mIsSendDataStart = z;
    }

    public void startSendData() {
        resetCamera();
        if (this.mCameraOperator != null) {
            this.mCameraOperator.startRecorderData();
        }
        this.mIsSendDataStart = true;
    }

    public void setDisplayRotateOffset(int i) {
        if (!(this.mCameraOperator instanceof IFaceUnityOperator)) {
            this.mDisplayRotateOffset = i;
        }
    }

    @Override // com.baidu.ala.liveRecorder.video.camera.ICameraStatusHandler
    public boolean hasAdvancedBeauty() {
        return this.mCameraOperator instanceof IFaceUnityOperator;
    }

    public void setPushMirror(boolean z) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setPushMirror(z);
        }
    }

    public boolean isPushMirror() {
        if (this.mCameraOperator != null) {
            return this.mCameraOperator.isPushMirror();
        }
        return false;
    }

    public void resetCamera2() {
        releaseCamera(false);
        openCamera();
    }

    public void setPreviewFps(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setPreviewFps(i);
        }
    }
}
