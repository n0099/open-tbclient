package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.util.Log;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.LogReport;
import com.baidu.ala.recorder.video.RecorderHandler;
import com.baidu.ala.recorder.video.listener.CameraListener;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
import com.baidu.ala.tbadk.util.ScreenHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@TargetApi(16)
/* loaded from: classes15.dex */
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
    private AlaRecorderLog.CameraInfo mCurInfo;
    private CameraListener mListener;
    private RecorderHandler mMainHandler;
    private Matrix mMatrix;
    private List<Camera.Area> mMeteringAreaList;
    private byte[][] mPreviewCallbackBuffer;
    private AlaLiveVideoConfig mVideoConfig;
    private float mExposureCompensation = 0.5f;
    private Camera mCamera = null;
    private int mCameraId = -1;
    private boolean mIsBackCamera = false;
    private int mDisplayRotate = 0;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private long mLastTimeCaremaError = 0;
    private int mCaremaErrorCount = 0;
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    private int mFrontCameraExposure = -1;
    private int mBackCameraExposure = -1;
    protected int fps = 0;
    private Boolean mDebug = true;
    private List<Camera.Area> mFocusAreaList = new ArrayList();

    static /* synthetic */ int access$508(AlaCameraManager alaCameraManager) {
        int i = alaCameraManager.mCaremaErrorCount;
        alaCameraManager.mCaremaErrorCount = i + 1;
        return i;
    }

    public AlaCameraManager(Activity activity, RecorderHandler recorderHandler, CameraListener cameraListener) {
        this.mActivity = null;
        this.mActivity = activity;
        this.mMainHandler = recorderHandler;
        this.mListener = cameraListener;
        this.mFocusAreaList.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
        this.mMeteringAreaList = new ArrayList();
        this.mMeteringAreaList.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
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

    public void postResetCamera() {
        CameraExecutor.getInst().posRunnable(new Runnable() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                AlaCameraManager.this.resetCamera();
            }
        });
    }

    public void postDestroy(Runnable runnable) {
        CameraExecutor.getInst().posRunnable(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartCamera() {
        this.mIsBackCamera = TbadkCoreApplicationProxy.getInst().getIsBackCamera();
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
            if (this.mCameraId == 1 && this.mFrontCameraExposure != -1) {
                parameters.setExposureCompensation(this.mFrontCameraExposure);
            }
            if (this.mCameraId == 0 && this.mBackCameraExposure != -1) {
                parameters.setExposureCompensation(this.mBackCameraExposure);
            }
            if (isDebug()) {
                int[] iArr = new int[2];
                parameters.getPreviewFpsRange(iArr);
                Camera.Size previewSize = parameters.getPreviewSize();
                d("Format:" + parameters.getPreviewFormat() + ", FpsRange:" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + iArr[1] + ", FlushLight:" + (mFlushLightStatus == 1) + ", preSize:" + (previewSize == null ? "null" : "[" + previewSize.width + ", " + previewSize.height + "]") + ", Exposure:" + parameters.getExposureCompensation());
                return parameters;
            }
            return parameters;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openCamera() {
        String str;
        if (this.mCamera != null) {
            if (isDebug()) {
                d("openCamera: " + (this.mCamera != null));
            }
            return true;
        }
        this.mCurInfo = new AlaRecorderLog.CameraInfo();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.mCurInfo.print(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_OPENCAMERA);
        this.mCameraId = 1;
        if (this.mIsBackCamera) {
            this.mCameraId = 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        this.mCurInfo.cameraCount = numberOfCameras;
        this.mCurInfo.curCameraPosition = -1;
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
                    this.mCurInfo.curCameraPosition = i;
                    this.mCurInfo.info = cameraInfo;
                    this.mCamera = Camera.open(i);
                    break;
                }
            } catch (Exception e) {
                this.mCurInfo.print(e.getMessage());
                BdLog.e(e);
                errLog(13, " open " + e.toString());
                return false;
            }
        }
        if (this.mCamera == null) {
            this.mCurInfo.print("Open default");
            this.mCamera = Camera.open();
        }
        if (this.mCamera == null) {
            this.mCurInfo.print("mCamera==null");
            return false;
        }
        try {
            Camera.Parameters defaultCameras = getDefaultCameras();
            this.mCamera.setParameters(defaultCameras);
            Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
            this.mPreviewWidth = previewSize.width;
            this.mPreviewHeight = previewSize.height;
            this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, cameraInfo, this.mCameraId);
            Log.e("qlc", "mDisplayRotate  " + this.mDisplayRotate + " mVideoConfig.isLandscape() " + this.mVideoConfig.isLandscape());
            this.mCamera.setDisplayOrientation(this.mDisplayRotate);
            this.mCurInfo.params = defaultCameras;
            this.mCurInfo.previewWidth = this.mPreviewWidth;
            this.mCurInfo.previewHeight = this.mPreviewHeight;
            this.mCurInfo.displayRotate = Integer.valueOf(this.mDisplayRotate);
            this.mCamera.setErrorCallback(new Camera.ErrorCallback() { // from class: com.baidu.ala.recorder.video.camera.AlaCameraManager.7
                @Override // android.hardware.Camera.ErrorCallback
                public void onError(int i2, Camera camera) {
                    AlaCameraManager.this.mCurInfo.print("error:" + i2);
                    BdLog.e("Camera error. errcode is " + i2);
                    if (i2 == 100 || i2 == 1) {
                        if (System.currentTimeMillis() - AlaCameraManager.this.mLastTimeCaremaError > 30000) {
                            AlaCameraManager.this.mCaremaErrorCount = 0;
                        }
                        AlaCameraManager.this.mLastTimeCaremaError = System.currentTimeMillis();
                        if (AlaCameraManager.this.mCaremaErrorCount > 3) {
                            AlaCameraManager.this.errLog(10, "camera error count > 3 and camera error = " + i2);
                            return;
                        }
                        AlaCameraManager.access$508(AlaCameraManager.this);
                        AlaCameraManager.this.releaseCamera(false);
                        AlaCameraManager.this.openCamera();
                    }
                }
            });
            if (this.mListener == null || this.mListener.getImageFilter() == null) {
                if (this.mListener == null) {
                    str = "mListener=null";
                } else if (this.mListener.getImageFilter() == null) {
                    str = "mListener.getImageFilter=null";
                } else {
                    str = "mListener.getImageFilter!=null";
                }
                this.mCurInfo.print(str);
                return false;
            }
            try {
                r0 = this.mListener.onCameraOpen(this.mCamera, this.mCameraId);
                if (r0) {
                    this.mCamera.stopPreview();
                    setupCameraBuffer(this.mCamera);
                    this.mCamera.setPreviewCallbackWithBuffer(this.mListener.getImageFilter().getCameraPreviewCallback());
                    if (this.mListener.getImageFilter().getCameraTexture() != null) {
                        this.mCamera.setPreviewTexture(this.mListener.getImageFilter().getCameraTexture());
                    }
                    this.mCamera.startPreview();
                }
            } catch (Throwable th) {
                this.mCurInfo.print("startPreview error");
                this.mCurInfo.print(th.getMessage());
                if (this.mMainHandler != null) {
                    this.mMainHandler.sendError(3, th.getMessage());
                }
            }
            LogReport.logCameraStart(this.mCurInfo);
            return r0;
        } catch (Exception e2) {
            this.mCurInfo.print(e2.getMessage());
            BdLog.e(e2);
            errLog(13, " getParameters " + e2.toString());
            return false;
        }
    }

    public void onFocus(int i, int i2, int i3, int i4) {
        if (this.mCamera != null && this.mActivity != null) {
            try {
                calculateTapArea(i, i2, 1.0f, i3, i4, ScreenHelper.getScreenWidth(this.mActivity), ScreenHelper.getScreenHeight(this.mActivity), this.mFocusAreaList.get(0).rect);
                this.mCamera.cancelAutoFocus();
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (parameters.getSupportedFocusModes().contains("auto")) {
                    parameters.setFocusMode("auto");
                    parameters.setFocusAreas(this.mFocusAreaList);
                }
                this.mCamera.setParameters(parameters);
                this.mCamera.autoFocus(null);
            } catch (Exception e) {
                BdLog.e(e);
                errLog(13, " onFocus " + e.toString());
            }
        }
    }

    public void onExposure(float f) {
        Camera.Parameters parameters;
        if (this.mCamera != null && this.mActivity != null && (parameters = this.mCamera.getParameters()) != null) {
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int round = Math.round((maxExposureCompensation - minExposureCompensation) * (1.0f - f)) + minExposureCompensation;
            if (round >= minExposureCompensation) {
                minExposureCompensation = round;
            }
            if (minExposureCompensation <= maxExposureCompensation) {
                maxExposureCompensation = minExposureCompensation;
            }
            if (this.mCameraId == 1) {
                this.mFrontCameraExposure = maxExposureCompensation;
            }
            if (this.mCameraId == 0) {
                this.mBackCameraExposure = maxExposureCompensation;
            }
            parameters.setExposureCompensation(maxExposureCompensation);
            this.mCamera.setParameters(parameters);
        }
    }

    public float getExposure() {
        if (this.mCamera == null || this.mActivity == null) {
            return -1.0f;
        }
        try {
            Camera.Parameters parameters = this.mCamera.getParameters();
            if (parameters == null) {
                return -1.0f;
            }
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            int minExposureCompensation = maxExposureCompensation - parameters.getMinExposureCompensation();
            int i = 0;
            if (this.mCameraId == 1) {
                i = this.mFrontCameraExposure;
            }
            if (this.mCameraId == 0) {
                i = this.mBackCameraExposure;
            }
            return ((maxExposureCompensation - i) * 1.0f) / minExposureCompensation;
        } catch (Exception e) {
            errLog(13, " getExposure " + e.toString());
            return -1.0f;
        }
    }

    private void calculateTapArea(int i, int i2, float f, int i3, int i4, int i5, int i6, Rect rect) {
        int i7 = (int) (i * f);
        int i8 = (int) (i2 * f);
        int clamp = CameraUtils.clamp(i3 - (i7 / 2), 0, i5 - i7);
        int clamp2 = CameraUtils.clamp(i4 - (i8 / 2), 0, i6 - i8);
        RectF rectF = new RectF(clamp, clamp2, i7 + clamp, i8 + clamp2);
        this.mMatrix = new Matrix();
        Matrix matrix = new Matrix();
        if (this.mActivity != null) {
            CameraUtils.prepareMatrix(this.mActivity, this.mCameraId, matrix, ScreenHelper.getScreenWidth(this.mActivity), ScreenHelper.getScreenHeight(this.mActivity));
        }
        matrix.invert(this.mMatrix);
        this.mMatrix.mapRect(rectF);
        CameraUtils.rectFToRect(rectF, rect);
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
            errLog(13, " getExposure " + e.toString());
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
            errLog(13, " releaseCamera " + e.toString());
        }
        if (z && this.mMainHandler != null) {
            this.mMainHandler.sendVideoCollectionStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void surfaceChanged(int i, int i2) {
        if (this.mCamera != null && this.mActivity != null) {
            if (this.mSurfaceWidth != i || this.mSurfaceHeight != i2) {
                setCameraDisplayRotation();
            }
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            if (this.mListener != null) {
                this.mListener.onSurfaceChanged(i, i2);
                try {
                    this.mCamera.stopPreview();
                    setupCameraBuffer(this.mCamera);
                    this.mCamera.setPreviewCallbackWithBuffer(this.mListener.getImageFilter().getCameraPreviewCallback());
                    if (this.mListener.getImageFilter().getCameraTexture() != null) {
                        this.mCamera.setPreviewTexture(this.mListener.getImageFilter().getCameraTexture());
                    }
                    this.mCamera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                    errLog(13, " surfaceChanged " + e.toString());
                }
            }
        }
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void switchCamera() {
        releaseCamera(false);
        this.mIsBackCamera = !this.mIsBackCamera;
        TbadkCoreApplicationProxy.getInst().setIsBackCamera(this.mIsBackCamera);
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
    public int getDisplayRotate() {
        return this.mDisplayRotate;
    }

    @Override // com.baidu.ala.recorder.video.camera.ICameraStatusHandler
    public void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig) {
        this.mVideoConfig = new AlaLiveVideoConfig(alaLiveVideoConfig);
    }

    private void setCameraDisplayRotation() {
        try {
            if (this.mCamera != null && this.mCamera.getParameters() != null) {
                this.mDisplayRotate = CameraUtils.getCameraDisplayOrientation(this.mActivity, null, this.mCameraId);
                this.mCamera.setDisplayOrientation(this.mDisplayRotate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetCamera() {
        releaseCamera(false);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errLog(int i, String str) {
        LogReport.logCameraError(i, str);
        if (this.mMainHandler != null) {
            this.mMainHandler.sendError(i, str);
        }
    }

    private void d(String str) {
        Log.d("DuAr_CameraMSG", str);
    }

    private boolean isDebug() {
        return this.mDebug.booleanValue();
    }
}
