package com.baidu.searchbox.ng.ai.apps.camera.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.camera.listener.ActionCompleteListener;
import com.baidu.searchbox.ng.ai.apps.camera.model.CameraAttrModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final boolean DEBUG = false;
    private static final String IMAGE_PREFIX = "IMG_";
    private static final String IMAGE_SUFFIX = ".jpg";
    private static final String TAG = "AiAppsCameraManager";
    private static final String VIDEO_PREFIX = "VID_";
    private static final String VIDEO_SUFFIX = ".mp4";
    private Camera mCamera;
    private CameraAttrModel mCameraAttrModel;
    public Context mContext;
    private SurfaceHolder mHolder;
    private MediaRecorder mMediaRecorder;
    private String mPictureQuality;
    private String mThumbPath;
    private String mVideoPath;

    public CameraPreview(Context context) {
        super(context);
        this.mPictureQuality = Quality.NORMAL.getQualityName();
        this.mVideoPath = "";
        this.mThumbPath = "";
    }

    public CameraPreview(Context context, CameraAttrModel cameraAttrModel) {
        super(context);
        this.mPictureQuality = Quality.NORMAL.getQualityName();
        this.mVideoPath = "";
        this.mThumbPath = "";
        this.mContext = context;
        this.mCameraAttrModel = cameraAttrModel;
        this.mHolder = getHolder();
        this.mHolder.addCallback(this);
    }

    public Camera getCameraInstance() {
        try {
            this.mCamera = Camera.open(getFrontOrBackCameraId());
            if (this.mCameraAttrModel != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                setFlashMode(this.mCamera, parameters, this.mCameraAttrModel.getFlash());
                int width = this.mCameraAttrModel.getWidth();
                int height = this.mCameraAttrModel.getHeight();
                Camera.Size bestPreviewSize = getBestPreviewSize(parameters.getSupportedPreviewSizes(), width, height);
                if (bestPreviewSize != null) {
                    parameters.setPreviewSize(bestPreviewSize.width, bestPreviewSize.height);
                }
                Camera.Size bestPreviewSize2 = getBestPreviewSize(parameters.getSupportedPictureSizes(), width, height);
                if (bestPreviewSize2 != null) {
                    parameters.setPictureSize(bestPreviewSize2.width, bestPreviewSize2.height);
                }
                this.mCamera.setParameters(parameters);
            }
        } catch (Exception e) {
        }
        return this.mCamera;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        getCameraInstance();
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
                setCameraDisplayOrientation();
            }
        } catch (IOException e) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        updateAttr(this.mCameraAttrModel);
    }

    public void onRelease() {
        releaseVideoRecord();
        clearSaveMediaPath();
        if (this.mHolder != null) {
            this.mHolder.removeCallback(this);
        }
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void takePicture(final String str, final ActionCompleteListener actionCompleteListener) {
        this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview.1
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(final byte[] bArr, Camera camera) {
                camera.startPreview();
                CameraPreview.this.setCameraDisplayOrientation();
                AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        int quality = Quality.getQuality(CameraPreview.this.mPictureQuality);
                        boolean z = CameraPreview.this.getResources().getConfiguration().orientation == 1;
                        boolean z2 = CameraPreview.this.getFrontOrBackCameraId() == 0;
                        if (z) {
                            i = z2 ? 90 : -90;
                        } else {
                            i = 0;
                        }
                        boolean saveImage = AiAppsCameraManager.getIns().saveImage(bArr, str, quality, i);
                        if (actionCompleteListener != null) {
                            if (saveImage) {
                                actionCompleteListener.onSuccess(str);
                            } else {
                                actionCompleteListener.onFailure();
                            }
                        }
                    }
                }, "saveImage");
            }
        });
    }

    public boolean startRecording(String str) {
        setSaveMediaPath(str);
        if (prepareVideoRecorder()) {
            this.mMediaRecorder.start();
            return true;
        }
        clearSaveMediaPath();
        return false;
    }

    public boolean stopRecording() {
        releaseVideoRecord();
        if (this.mCamera != null) {
            this.mCamera.lock();
        }
        ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
        return true;
    }

    private boolean prepareVideoRecorder() {
        releaseVideoRecord();
        this.mMediaRecorder = new MediaRecorder();
        this.mCamera = getCameraInstance();
        setCameraDisplayOrientation();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setAudioSource(5);
        this.mMediaRecorder.setVideoSource(1);
        this.mMediaRecorder.setProfile(getCamcorderProfile());
        this.mMediaRecorder.setOutputFile(getVideoPath());
        this.mMediaRecorder.setPreviewDisplay(this.mHolder.getSurface());
        try {
            this.mMediaRecorder.prepare();
            return true;
        } catch (IOException e) {
            return false;
        } catch (IllegalStateException e2) {
            return false;
        }
    }

    private void releaseVideoRecord() {
        if (this.mMediaRecorder != null) {
            try {
                this.mMediaRecorder.stop();
            } catch (IllegalStateException e) {
            } finally {
                this.mMediaRecorder.reset();
                this.mMediaRecorder.release();
                this.mMediaRecorder = null;
            }
        }
    }

    private void setFlashMode(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (camera != null && parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && !TextUtils.equals(str, parameters.getFlashMode()) && supportedFlashModes.contains(str)) {
            parameters.setFlashMode(str);
            camera.setParameters(parameters);
        }
    }

    private Camera.Size getBestPreviewSize(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        float f = i / i2;
        float f2 = -1.0f;
        Iterator<Camera.Size> it = list.iterator();
        while (true) {
            float f3 = f2;
            Camera.Size size2 = size;
            if (it.hasNext()) {
                Camera.Size next = it.next();
                float abs = Math.abs((next.width / next.height) - f);
                if (f3 < 0.0f) {
                    f3 = abs;
                    size2 = next;
                }
                if (abs < f3) {
                    size = next;
                    f2 = abs;
                } else {
                    f2 = f3;
                    size = size2;
                }
            } else {
                return size2;
            }
        }
    }

    private CamcorderProfile getCamcorderProfile() {
        int i = 6;
        if (!CamcorderProfile.hasProfile(6)) {
            if (CamcorderProfile.hasProfile(5)) {
                i = 5;
            } else {
                i = CamcorderProfile.hasProfile(4) ? 4 : 1;
            }
        }
        return CamcorderProfile.get(i);
    }

    public void updateAttr(CameraAttrModel cameraAttrModel) {
        try {
            this.mCameraAttrModel = cameraAttrModel;
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mCamera = null;
            }
            getCameraInstance();
            if (this.mCamera != null) {
                this.mCamera.setPreviewDisplay(this.mHolder);
                this.mCamera.startPreview();
                setCameraDisplayOrientation();
            }
        } catch (IOException e) {
            AiAppsCameraManager.getIns().onExceptionError(cameraAttrModel.slaveId, cameraAttrModel.cameraId, false);
        }
    }

    public void setQuality(String str) {
        this.mPictureQuality = str;
    }

    public String getTakePhotoPath(String str) {
        return str + File.separator + IMAGE_PREFIX + Calendar.getInstance().getTimeInMillis() + IMAGE_SUFFIX;
    }

    private void setSaveMediaPath(String str) {
        this.mVideoPath = str + File.separator + VIDEO_PREFIX + Calendar.getInstance().getTimeInMillis() + VIDEO_SUFFIX;
        this.mThumbPath = str + File.separator + IMAGE_PREFIX + Calendar.getInstance().getTimeInMillis() + IMAGE_SUFFIX;
        AiAppsFileUtils.createNewFileSafely(new File(this.mVideoPath));
    }

    public void clearSaveMediaPath() {
        this.mVideoPath = "";
        this.mThumbPath = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        return (this.mCameraAttrModel == null || !this.mCameraAttrModel.isFrontCamera()) ? 0 : 1;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public String getThumbPath() {
        return this.mThumbPath;
    }

    public String getSlaveId() {
        return this.mCameraAttrModel == null ? "" : this.mCameraAttrModel.slaveId;
    }

    public void setCameraDisplayOrientation() {
        int i;
        int i2;
        Context context = getContext();
        if (context instanceof Activity) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
            switch (((Activity) context).getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = 180;
                    break;
                case 3:
                    i = 270;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i2 = (360 - ((i + cameraInfo.orientation) % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i) + 360) % 360;
            }
            this.mCamera.setDisplayOrientation(i2);
        }
    }

    /* loaded from: classes2.dex */
    public enum Quality {
        HIGH("high", 100),
        NORMAL("normal", 80),
        LOW(Config.EXCEPTION_MEMORY_LOW, 60);
        
        private int qualityInt;
        private String qualityName;

        Quality(String str, int i) {
            this.qualityName = str;
            this.qualityInt = i;
        }

        public static int getQuality(String str) {
            Quality[] values;
            int qualityInt = NORMAL.getQualityInt();
            int i = qualityInt;
            for (Quality quality : values()) {
                if (TextUtils.equals(quality.getQualityName(), str)) {
                    i = quality.qualityInt;
                }
            }
            return i;
        }

        public String getQualityName() {
            return this.qualityName;
        }

        public int getQualityInt() {
            return this.qualityInt;
        }
    }
}
