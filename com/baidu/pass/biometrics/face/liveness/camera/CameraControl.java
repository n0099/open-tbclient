package com.baidu.pass.biometrics.face.liveness.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraControl {
    public static final int DEFAULT_PREVIEW_HEIGHT = 480;
    public static final int DEFAULT_PREVIEW_WIDTH = 640;
    private static final float MAX_DIFF_MATCH_PREVIEW_SCALE = 0.2f;
    private static final String TAG = "CameraControl";
    private static int cameraId = -1;
    private Camera camera;
    private int displayRotation;
    private CameraSize mPreviewSize;
    private SurfaceHolder mSurfaceHolder;
    private String flashMode = "on";
    private boolean isPreviewing = false;
    private boolean isFrontCamera = true;
    private boolean isUseRecord = false;

    @TargetApi(11)
    public boolean doOpenCamera(Activity activity, boolean z) {
        this.isUseRecord = z;
        if (this.camera != null) {
            this.camera.stopPreview();
            this.camera.release();
            this.camera = null;
        }
        try {
            if (isFrontCamera()) {
                cameraId = 1;
            } else {
                cameraId = 0;
            }
            this.camera = Camera.open(cameraId);
            setCameraParam(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            if (this.camera != null) {
                this.camera.release();
                this.camera = null;
            }
            return false;
        }
    }

    @TargetApi(9)
    public boolean isFrontCamera() {
        if (Camera.getNumberOfCameras() == 1) {
            this.isFrontCamera = false;
        }
        return this.isFrontCamera;
    }

    @TargetApi(9)
    private void setCameraParam(Activity activity) {
        int i = 0;
        if (this.camera != null) {
            Camera.Parameters parameters = this.camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            setPictureSize(parameters, setPreviewSize(activity, parameters));
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = SubsamplingScaleImageView.ORIENTATION_180;
                    break;
                case 3:
                    i = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(cameraId, cameraInfo);
            if (cameraInfo.facing == 1) {
                this.displayRotation = (i + cameraInfo.orientation) % 360;
                this.displayRotation = (360 - this.displayRotation) % 360;
            } else {
                this.displayRotation = ((cameraInfo.orientation - i) + 360) % 360;
            }
            this.camera.setDisplayOrientation(this.displayRotation);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.isFrontCamera) {
                    this.flashMode = "off";
                    parameters.setFlashMode(this.flashMode);
                } else {
                    parameters.setFlashMode(this.flashMode);
                }
            } else {
                this.flashMode = "off";
            }
            this.camera.setParameters(parameters);
        }
    }

    private CameraSize setPreviewSize(Activity activity, Camera.Parameters parameters) {
        CameraSize minMatchPreviewSize = getMinMatchPreviewSize(activity, parameters);
        this.mPreviewSize = new CameraSize(minMatchPreviewSize.width, minMatchPreviewSize.height);
        if (this.isUseRecord) {
            getBestVideoSizeMatchPreviewSize(this.camera.getParameters(), minMatchPreviewSize);
        }
        parameters.setPreviewSize(this.mPreviewSize.width, this.mPreviewSize.height);
        return this.mPreviewSize;
    }

    private CameraSize getMinMatchPreviewSize(Activity activity, Camera.Parameters parameters) {
        List<CameraSize> supportedPreviewSizes = getSupportedPreviewSizes(activity, parameters);
        CameraSize cameraSize = new CameraSize(640, 480);
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return cameraSize;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        CameraSize cameraSize2 = new CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        float f = cameraSize2.height / cameraSize2.width;
        int i = 0;
        CameraSize cameraSize3 = cameraSize;
        float f2 = cameraSize.width / cameraSize.height;
        while (true) {
            int i2 = i;
            if (i2 < supportedPreviewSizes.size()) {
                CameraSize cameraSize4 = supportedPreviewSizes.get(i2);
                float abs = Math.abs((cameraSize4.width / cameraSize4.height) - f);
                if (abs < f2) {
                    f2 = abs;
                    cameraSize3 = cameraSize4;
                }
                i = i2 + 1;
            } else {
                return cameraSize3;
            }
        }
    }

    @TargetApi(5)
    private List<CameraSize> getSupportedPreviewSizes(Activity activity, Camera.Parameters parameters) {
        int i;
        int i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        CameraSize cameraSize = new CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        if ((cameraSize.width * cameraSize.height) / 4 <= 921600) {
            i = 153600;
            i2 = 921600;
        } else {
            i = (cameraSize.width * cameraSize.height) / 8;
            i2 = 2073600;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= supportedPreviewSizes.size()) {
                return arrayList;
            }
            Camera.Size size = supportedPreviewSizes.get(i4);
            if (size.width * size.height >= i && size.width * size.height <= i2) {
                arrayList.add(new CameraSize(size.width, size.height));
            }
            i3 = i4 + 1;
        }
    }

    @TargetApi(5)
    public void setPictureSize(Camera.Parameters parameters, CameraSize cameraSize) {
        Camera.Size size = null;
        float f = cameraSize != null ? cameraSize.width / cameraSize.height : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            int size2 = supportedPictureSizes.size();
            int i = 0;
            Camera.Size size3 = null;
            while (i < size2) {
                Camera.Size size4 = supportedPictureSizes.get(i);
                if (size3 == null) {
                    size3 = size4;
                } else if (size4.width >= size3.width && size4.height >= size3.height && size4.width * size4.height < 5000000) {
                    size3 = size4;
                }
                if (f <= 0.0f || Math.abs((size4.width / size4.height) - f) >= 0.15f || size4.width * size4.height >= 7000000 || (size != null && (size4.width <= size.width || size4.height <= size.height))) {
                    size4 = size;
                }
                i++;
                size = size4;
            }
            if (size == null) {
                size = size3;
            }
            parameters.setPictureSize(size.width, size.height);
        }
    }

    public void doStartPreview(Context context, SurfaceHolder surfaceHolder) {
        if (this.camera != null) {
            try {
                this.mSurfaceHolder = surfaceHolder;
                this.camera.setPreviewDisplay(surfaceHolder);
                this.camera.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
            this.isPreviewing = true;
        }
    }

    public void startPreview() {
        if (this.camera != null) {
            this.camera.startPreview();
        }
    }

    public void stopPreview() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    public synchronized void doStopCamera() {
        try {
            if (this.mSurfaceHolder != null && Build.VERSION.SDK_INT >= 14) {
                this.mSurfaceHolder.getSurface().release();
            }
            if (this.camera != null) {
                this.camera.setPreviewCallback(null);
                this.camera.stopPreview();
                this.camera.release();
                this.isPreviewing = false;
                this.camera = null;
            }
            this.isFrontCamera = true;
        } catch (Exception e) {
            Log.e(e);
        }
    }

    @TargetApi(11)
    private CameraSize getBestVideoSizeMatchPreviewSize(Camera.Parameters parameters, CameraSize cameraSize) {
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes != null && supportedVideoSizes.size() != 0 && supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
            float f = cameraSize.height / cameraSize.width;
            CameraSize cameraSize2 = new CameraSize(0, 0);
            CameraSize cameraSize3 = new CameraSize(0, 0);
            CameraSize cameraSize4 = new CameraSize(0, 0);
            CameraSize cameraSize5 = new CameraSize(0, 0);
            CameraSize cameraSize6 = new CameraSize(0, 0);
            CameraSize cameraSize7 = new CameraSize(0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < supportedVideoSizes.size()) {
                    Camera.Size size = supportedVideoSizes.get(i2);
                    cameraSize3.width = size.width;
                    cameraSize3.height = size.height;
                    if (cameraSize3.width == cameraSize.width && cameraSize3.height == cameraSize.height) {
                        cameraSize2.width = cameraSize3.width;
                        cameraSize2.height = cameraSize3.height;
                        return cameraSize2;
                    }
                    if (Math.abs((size.height / size.width) - f) < 0.01f && cameraSize3.width >= cameraSize2.width && cameraSize3.height >= cameraSize2.height && cameraSize3.width * cameraSize3.height <= 921600) {
                        cameraSize2.width = cameraSize3.width;
                        cameraSize2.height = cameraSize3.height;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= supportedPreviewSizes.size()) {
                            break;
                        }
                        Camera.Size size2 = supportedPreviewSizes.get(i4);
                        cameraSize4.width = size2.width;
                        cameraSize4.height = size2.height;
                        if (((cameraSize3.width == cameraSize4.width && cameraSize3.height == cameraSize4.height) || Math.abs((cameraSize4.height / cameraSize4.width) - (cameraSize3.height / cameraSize3.width)) < 0.01f) && cameraSize3.width * cameraSize3.height >= cameraSize5.width * cameraSize5.height && cameraSize3.width * cameraSize3.height <= 921600) {
                            cameraSize5.width = cameraSize3.width;
                            cameraSize5.height = cameraSize3.height;
                            cameraSize6.height = cameraSize4.height;
                            cameraSize6.width = cameraSize4.width;
                        }
                        i3 = i4 + 1;
                    }
                    if (cameraSize3.width * cameraSize3.height >= cameraSize7.width * cameraSize7.height && cameraSize3.width * cameraSize3.height <= 921600) {
                        cameraSize7.width = cameraSize3.width;
                        cameraSize7.height = cameraSize3.height;
                    }
                    i = i2 + 1;
                } else if (cameraSize2.width > 0) {
                    return cameraSize2;
                } else {
                    if (cameraSize5.width > 0) {
                        this.mPreviewSize.height = cameraSize6.height;
                        this.mPreviewSize.width = cameraSize6.width;
                        return cameraSize5;
                    }
                    return cameraSize7;
                }
            }
        } else {
            return cameraSize;
        }
    }

    public CameraSize getPreviewSize() {
        return this.mPreviewSize;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.camera != null) {
            this.camera.setPreviewCallback(previewCallback);
        }
    }

    /* loaded from: classes2.dex */
    public static class CameraSize {
        public int height;
        public int width;

        public CameraSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
