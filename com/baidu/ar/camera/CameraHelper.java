package com.baidu.ar.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
class CameraHelper {
    public static final int GET_CAMERA_ID_ERROR = -1;
    private static final String a = CameraHelper.class.getSimpleName();

    CameraHelper() {
    }

    private static int a(Camera.Parameters parameters, int i, boolean z) {
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null) {
            return i;
        }
        int a2 = a(supportedPreviewFrameRates, i, z);
        if (a2 == 0) {
            a2 = a(supportedPreviewFrameRates, i, !z);
        }
        return a2;
    }

    private static int a(List<Integer> list, int i, boolean z) {
        if (list.contains(Integer.valueOf(i))) {
            return i;
        }
        Collections.sort(list);
        if (!z) {
            Collections.reverse(list);
        }
        int i2 = 0;
        for (Integer num : list) {
            if (z) {
                if (num.intValue() >= i) {
                    i2 = num.intValue();
                }
            } else if (num.intValue() <= i) {
                i2 = num.intValue();
            }
        }
        return i2;
    }

    private static Camera.Size a(Camera.Parameters parameters, int i, int i2, boolean z, double d, boolean z2) {
        List<Camera.Size> supportedPreviewSizes;
        if (parameters != null && (supportedPreviewSizes = parameters.getSupportedPreviewSizes()) != null) {
            Camera.Size a2 = a(supportedPreviewSizes, i, i2, z, d, z2);
            if (a2 == null) {
                return a(supportedPreviewSizes, i, i2, z, d, !z2);
            }
            return a2;
        }
        return null;
    }

    private static Camera.Size a(List<Camera.Size> list, int i, int i2, boolean z, double d, boolean z2) {
        double d2 = i / i2;
        Collections.sort(list, new CameraSizeComparator(z2));
        for (Camera.Size size : list) {
            if (z2) {
                if (size.width < i) {
                    continue;
                } else if (z || Math.abs((size.width / size.height) - d2) <= d) {
                }
            } else if (size.width <= i) {
                return z ? size : size;
            } else {
                continue;
            }
        }
        return null;
    }

    private static boolean a() {
        boolean z;
        Camera camera;
        Camera camera2 = null;
        try {
            camera2 = Camera.open();
            camera2.setParameters(camera2.getParameters());
            z = true;
            camera = camera2;
        } catch (Exception e) {
            Camera camera3 = camera2;
            z = false;
            camera = camera3;
        }
        if (camera != null) {
            try {
                camera.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    private static boolean a(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission("android.permission.CAMERA", str) == 0;
    }

    private static Camera.Size b(Camera.Parameters parameters, int i, int i2, boolean z, double d, boolean z2) {
        List<Camera.Size> supportedPictureSizes;
        if (parameters != null && (supportedPictureSizes = parameters.getSupportedPictureSizes()) != null) {
            Camera.Size a2 = a(supportedPictureSizes, i, i2, z, d, z2);
            if (a2 == null) {
                return a(supportedPictureSizes, i, i2, z, d, !z2);
            }
            return a2;
        }
        return null;
    }

    public static boolean checkCameraPermission(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? a(context, context.getApplicationContext().getPackageName()) : a();
    }

    public static void correctCameraParas(CameraParams cameraParams, Camera.Parameters parameters) {
        Camera.Size a2 = a(parameters, cameraParams.getPreviewWidth(), cameraParams.getPreviewHeight(), cameraParams.isKeepAspectRatio(), cameraParams.getAspectTolerance(), cameraParams.isPreviewCorrectUpward());
        if (a2 != null) {
            cameraParams.setPreviewWidth(a2.width);
            cameraParams.setPreviewHeight(a2.height);
        }
        Camera.Size b = b(parameters, cameraParams.getPictureWidth(), cameraParams.getPictureHeight(), cameraParams.isKeepAspectRatio(), cameraParams.getAspectTolerance(), cameraParams.isPictureCorrectUpward());
        if (a2 != null) {
            cameraParams.setPictureWidth(b.width);
            cameraParams.setPictureHeight(b.height);
        }
        cameraParams.setFrameRate(a(parameters, cameraParams.getFrameRate(), cameraParams.isFrameRateCorrectUpward()));
    }

    public static int getBackCameraId() {
        return a(0) ? 0 : -1;
    }

    public static int getFrontCameraId() {
        return a(1) ? 1 : -1;
    }

    public static final boolean isBackCameraCurrent() {
        return new Camera.CameraInfo().facing == 0;
    }

    public static void setAutoFocus(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
        }
    }
}
