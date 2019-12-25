package com.baidu.pass.biometrics.face.liveness.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CameraInterface {
    public static final int CAMERA_TYPE_LIVENESS = 3;
    public static final int DEFAULT_PREVIEW_HEIGHT = 480;
    public static final int DEFAULT_PREVIEW_WIDTH = 640;
    private static final float MAX_DIFF_MATCH_PREVIEW_SCALE = 0.2f;
    private static final String TAG = "CameraInterface";
    private static int cameraId = -1;
    Camera camera;
    private int displayRotation;
    private String flashMode = "off";
    private boolean isFrontCamera = true;
    SurfaceHolder mSurfaceHolder;
    private CameraSize previewSize;

    @TargetApi(9)
    public boolean doOpenCamera(Activity activity, int i) {
        if (this.camera != null) {
            this.camera.stopPreview();
            this.camera.release();
            this.camera = null;
        }
        if (getCameraNum() == 1) {
            this.isFrontCamera = false;
        }
        if (this.isFrontCamera) {
            cameraId = 1;
        } else {
            cameraId = 0;
        }
        try {
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

    public void doStartPreview(Activity activity, SurfaceHolder surfaceHolder) {
        if (this.camera != null) {
            try {
                this.mSurfaceHolder = surfaceHolder;
                this.camera.setPreviewDisplay(surfaceHolder);
                this.camera.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    @TargetApi(9)
    public int getCameraNum() {
        return Camera.getNumberOfCameras();
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
                this.camera = null;
            }
            this.isFrontCamera = true;
        } catch (Exception e) {
            Log.e(e);
        }
    }

    @TargetApi(8)
    public void setCameraParam(Activity activity) {
        int i = 0;
        if (this.camera != null) {
            Camera.Parameters parameters = this.camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            setPictureSize(parameters, setPreviewSize(activity, parameters, false));
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = 180;
                    break;
                case 3:
                    i = 270;
                    break;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(cameraId, cameraInfo);
                if (cameraInfo.facing == 1) {
                    this.displayRotation = (i + cameraInfo.orientation) % 360;
                    this.displayRotation = (360 - this.displayRotation) % 360;
                } else {
                    this.displayRotation = ((cameraInfo.orientation - i) + 360) % 360;
                }
                this.camera.setDisplayOrientation(this.displayRotation);
            } else if (Build.VERSION.SDK_INT == 8) {
                this.displayRotation = ((90 - i) + 360) % 360;
                this.camera.setDisplayOrientation(this.displayRotation);
            } else {
                this.displayRotation = ((90 - i) + 360) % 360;
                try {
                    Method method = this.camera.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                    if (method != null) {
                        method.invoke(this.camera, Integer.valueOf(this.displayRotation));
                    }
                } catch (Exception e) {
                    Log.e(e);
                }
            }
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

    private CameraSize getMinMatchPreviewSize(Activity activity, Camera.Parameters parameters) {
        if (this.previewSize != null) {
            return this.previewSize;
        }
        List<CameraSize> supportedPreviewSizes = getSupportedPreviewSizes(activity, parameters);
        this.previewSize = new CameraSize(640, 480);
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return this.previewSize;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        CameraSize cameraSize = new CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        float f = cameraSize.height / cameraSize.width;
        int i = 0;
        float f2 = this.previewSize.width / this.previewSize.height;
        while (true) {
            int i2 = i;
            if (i2 < supportedPreviewSizes.size()) {
                CameraSize cameraSize2 = supportedPreviewSizes.get(i2);
                float abs = Math.abs((cameraSize2.width / cameraSize2.height) - f);
                if (abs < f2) {
                    this.previewSize = cameraSize2;
                    f2 = abs;
                }
                i = i2 + 1;
            } else {
                return this.previewSize;
            }
        }
    }

    public CameraSize setPreviewSize(Activity activity, Camera.Parameters parameters, boolean z) {
        CameraSize minMatchPreviewSize = getMinMatchPreviewSize(activity, parameters);
        parameters.setPreviewSize(minMatchPreviewSize.width, minMatchPreviewSize.height);
        return minMatchPreviewSize;
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

    public boolean isFrontCamera() {
        if (getCameraNum() == 1) {
            this.isFrontCamera = false;
        }
        return this.isFrontCamera;
    }

    public CameraSize getPreviewSize() {
        if (this.previewSize == null) {
            this.previewSize = new CameraSize(640, 480);
        }
        return this.previewSize;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        if (this.camera != null) {
            this.camera.setPreviewCallback(previewCallback);
        }
    }

    /* loaded from: classes4.dex */
    public static class CameraSize {
        public int height;
        public int width;

        public CameraSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
