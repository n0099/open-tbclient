package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import com.baidu.ala.recorder.IFaceUnityOperator;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.IVideoRecorder;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.camera.AlaCameraRecorder;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(16)
/* loaded from: classes3.dex */
public class AlaCameraManager implements ICameraStatusHandler {
    private static final int CAMERA_FLUSHLIGHT_OFF = 2;
    private static final int CAMERA_FLUSHLIGHT_ON = 1;
    private static final int CAMERA_FLUSHLIGHT_UNINIT = 0;
    private static final boolean IS_OPEN_TAG = false;
    private static final int MAX_CAREMA_ERROR_COUNT = 3;
    private static final int MAX_CAREMA_ERROR_INTERVAL = 30000;
    private static final int PREVIEW_BUFFER_COUNT = 3;
    private static final int REQ_CAMERA_FPS = 30;
    private static final String SP_CAMERA_FACING = "ala_carema_is_back";
    private static final String TAG = "LIVE_SDK_JNI";
    private static int mFlushLightStatus = 0;
    private Activity mActivity;
    private ICameraOperator mCameraOperator;
    private RecorderHandler mMainHandler;
    private boolean mNeedBeauty;
    private byte[][] mPreviewCallbackBuffer;
    private AlaCameraRecorder.SurfaceHolder mSurfaceHolder;
    private AlaLiveVideoConfig mVideoConfig;
    private IVideoRecorder.IVideoDataCallBack mVideoDataCallback;
    private float mExposureCompensation = 0.5f;
    private Camera mCamera = null;
    private int mCameraId = -1;
    private boolean mIsBackCamera = false;
    private int mDisplayRotate = 0;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private long mLastTimeCaremaError = 0;
    private int mCaremaErrorCount = 0;
    private volatile boolean mIsMirror = false;
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    protected int fps = 0;

    static /* synthetic */ int access$508(AlaCameraManager alaCameraManager) {
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

    public void postStartCamera() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.1
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.doStartCamera();
            }
        });
    }

    public void postStopCamera() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.2
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.doStopCamera();
            }
        });
    }

    public void postSurfaceChanged(final int i, final int i2) {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.3
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.surfaceChanged(i, i2);
            }
        });
    }

    public void postSwitchCamera() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.4
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.switchCamera();
            }
        });
    }

    public void postSwitchFlashLight() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.5
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.switchFlashingLight();
            }
        });
    }

    public void postBeautyLevel(final int i) {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.setBeauty(i);
            }
        });
    }

    public void postSendData() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.7
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void postResetCamera() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.8
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.resetCamera();
            }
        });
    }

    public void postDestroy() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (AlaCameraManager.this.mCameraOperator != null) {
                    AlaCameraManager.this.mCameraOperator.release();
                    AlaCameraManager.this.mCameraOperator = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartCamera() {
        this.mIsBackCamera = SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(SP_CAMERA_FACING), false);
        boolean openCamera = openCamera();
        if (this.mMainHandler != null) {
            this.mMainHandler.sendVideoCollectionStart(openCamera, this.mPreviewHeight, this.mPreviewWidth);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStopCamera() {
        releaseCamera(true);
    }

    private Camera.Parameters getDefaultCameras() {
        try {
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setPreviewFormat(17);
            CameraUtils.choosePreviewSize(parameters, this.mVideoConfig.getPreviewHeight(), this.mVideoConfig.getPreviewWidth());
            CameraUtils.chooseFixedPreviewFps(parameters, 30000);
            if (this.mIsBackCamera) {
                if (mFlushLightStatus == 1) {
                    CameraUtils.turnLightOn(parameters);
                } else if (mFlushLightStatus == 2) {
                    CameraUtils.turnLightOff(parameters);
                }
            }
            CameraUtils.setFocusModes(parameters);
            return parameters;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openCamera() {
        Throwable th;
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
        if (this.mCamera == null) {
            return false;
        }
        try {
            this.mCamera.setParameters(getDefaultCameras());
            Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
            this.mPreviewWidth = previewSize.width;
            this.mPreviewHeight = previewSize.height;
            this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, cameraInfo, this.mCameraId);
            this.mCamera.setDisplayOrientation(this.mDisplayRotate);
            this.mCamera.setErrorCallback(new Camera.ErrorCallback() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.10
                @Override // android.hardware.Camera.ErrorCallback
                public void onError(int i2, Camera camera) {
                    BdLog.e("Camera error. errcode is " + i2);
                    if (i2 == 100 || i2 == 1) {
                        if (System.currentTimeMillis() - AlaCameraManager.this.mLastTimeCaremaError > 30000) {
                            AlaCameraManager.this.mCaremaErrorCount = 0;
                        }
                        AlaCameraManager.this.mLastTimeCaremaError = System.currentTimeMillis();
                        if (AlaCameraManager.this.mCaremaErrorCount <= 3) {
                            AlaCameraManager.access$508(AlaCameraManager.this);
                            AlaCameraManager.this.releaseCamera(false);
                            AlaCameraManager.this.openCamera();
                        }
                    }
                }
            });
            if (this.mCameraOperator == null) {
                return false;
            }
            this.mCameraOperator.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            try {
                boolean onCameraOpened = this.mCameraOperator.onCameraOpened(this.mCamera, this.mCameraId);
                if (onCameraOpened) {
                    try {
                        this.mCamera.stopPreview();
                        setupCameraBuffer(this.mCamera);
                        this.mCamera.setPreviewCallbackWithBuffer(this.mCameraOperator.getPreviewCallback());
                        this.mCamera.setPreviewTexture(this.mCameraOperator.getSurfaceTexture());
                        this.mCamera.startPreview();
                        return onCameraOpened;
                    } catch (Throwable th2) {
                        th = th2;
                        z = onCameraOpened;
                        BdStatisticsManager.getInstance().newDebug("AlaLiveRecorder", 0L, null, BdStatsConstant.StatsType.ERROR, "openCamera Failed:" + th.getLocalizedMessage());
                        if (this.mMainHandler != null) {
                            this.mMainHandler.sendError(3, th.getMessage());
                        }
                        return z;
                    }
                }
                return onCameraOpened;
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        } catch (Exception e2) {
            BdLog.e(e2);
            return false;
        }
    }

    private void setupCameraBuffer(Camera camera) {
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            if (this.mPreviewCallbackBuffer == null) {
                int i = previewSize.width;
                this.mPreviewCallbackBuffer = (byte[][]) Array.newInstance(Byte.TYPE, 3, (int) (previewSize.height * i * 1.5d));
            }
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.mPreviewCallbackBuffer != null && this.mPreviewCallbackBuffer[i2] != null) {
                    this.mCamera.addCallbackBuffer(this.mPreviewCallbackBuffer[i2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            if (videoBeautyType == VideoBeautyType.DUMIX_AR) {
                this.mNeedBeauty = false;
                return new DuArCameraOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
            }
            if (videoBeautyType == VideoBeautyType.BEAUTY_FACEUNITY) {
                if (FUCameraOperator.isValid()) {
                    return new FUCameraOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
                }
            } else if (videoBeautyType == VideoBeautyType.BEAUTY_NONE) {
                return new GPUCameraOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
            }
            return new TBCameraOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
        }
        this.mNeedBeauty = false;
        if (GPUCameraOperator.isValid()) {
            return new GPUCameraOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback, this.mMainHandler);
        }
        return new CPUCaremaOperator(this.mActivity, this.mSurfaceHolder, this, this.mVideoDataCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void surfaceChanged(int i, int i2) {
        if (this.mCamera != null && this.mActivity != null) {
            if (this.mSurfaceWidth != i || this.mSurfaceHeight != i2) {
                setCameraDisplayRoation();
            }
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            if (this.mCameraOperator != null) {
                this.mCameraOperator.surfaceChanged(i, i2);
                try {
                    this.mCamera.stopPreview();
                    setupCameraBuffer(this.mCamera);
                    this.mCamera.setPreviewCallbackWithBuffer(this.mCameraOperator.getPreviewCallback());
                    this.mCamera.setPreviewTexture(this.mCameraOperator.getSurfaceTexture());
                    this.mCamera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        releaseCamera(false);
        this.mIsBackCamera = !this.mIsBackCamera;
        SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(SP_CAMERA_FACING), this.mIsBackCamera);
        openCamera();
        if (this.mMainHandler != null) {
            this.mMainHandler.sendSwitchCarema(this.mIsBackCamera ? false : true);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isBackCamera() {
        return this.mIsBackCamera;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
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

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public boolean isFlashingLightOpen() {
        return mFlushLightStatus == 1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setBeauty(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setBeauty(i);
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public int hasBeauty() {
        if (this.mCameraOperator != null) {
            return this.mCameraOperator.hasBeauty();
        }
        return -1;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
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

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setVideoConfig(this.mVideoConfig);
        }
    }

    private void setCameraDisplayRoation() {
        try {
            if (this.mCamera != null && this.mCamera.getParameters() != null) {
                this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, null, this.mCameraId);
                this.mCamera.setDisplayOrientation(this.mDisplayRotate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
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

    public void resetCamera() {
        releaseCamera(false);
        openCamera();
    }

    public void setPreviewFps(int i) {
        if (this.mCameraOperator != null) {
            this.mCameraOperator.setPreviewFps(i);
        }
    }

    public void setDefBeautyParams(ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (this.mCameraOperator instanceof DuArCameraOperator) {
            ((DuArCameraOperator) this.mCameraOperator).setDefBeautyParams(concurrentHashMap);
        }
    }

    public void setBeautyJsonPath(String str) {
        if (this.mCameraOperator instanceof DuArCameraOperator) {
            ((DuArCameraOperator) this.mCameraOperator).setBeautyJsonPath(str);
        }
    }

    public void onBeautyParamsChanged(float f, HashMap<String, Object> hashMap) {
        if (this.mCameraOperator instanceof DuArCameraOperator) {
            ((DuArCameraOperator) this.mCameraOperator).onBeautyParamsChanged(f, hashMap);
        }
    }
}
