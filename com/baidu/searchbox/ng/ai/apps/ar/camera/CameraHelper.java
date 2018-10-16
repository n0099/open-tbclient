package com.baidu.searchbox.ng.ai.apps.ar.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraHelper {
    public static final int GET_CAMERA_ID_ERROR = -1;
    private static final String TAG = CameraHelper.class.getSimpleName();

    public static int getBackCameraId() {
        return isCameraSupported(0) ? 0 : -1;
    }

    public static int getFrontCameraId() {
        return isCameraSupported(1) ? 1 : -1;
    }

    public static final boolean isBackCameraCurrent() {
        return new Camera.CameraInfo().facing == 0;
    }

    public static boolean isCameraSupported(int i) {
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

    public static boolean isCameraPreviewSupported(CameraParams cameraParams) {
        boolean z;
        boolean z2 = false;
        if (isCameraSupported(cameraParams.getCameraId())) {
            Camera camera = null;
            try {
                camera = Camera.open(cameraParams.getCameraId());
                Iterator<Camera.Size> it = camera.getParameters().getSupportedPreviewSizes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Camera.Size next = it.next();
                    if (next.width == cameraParams.getPreviewWidth() && next.height == cameraParams.getPreviewHeight()) {
                        z = true;
                        break;
                    }
                }
                z2 = z;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (camera != null) {
                try {
                    camera.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return z2;
    }

    public static void correctCameraParams(CameraParams cameraParams, Camera.Parameters parameters) {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize(parameters, cameraParams.getPreviewWidth(), cameraParams.getPreviewHeight(), cameraParams.isKeepAspectRatio(), cameraParams.getAspectTolerance(), cameraParams.isPreviewCorrectUpward());
        if (optimalPreviewSize != null) {
            cameraParams.setPreviewWidth(optimalPreviewSize.width);
            cameraParams.setPreviewHeight(optimalPreviewSize.height);
        }
        Camera.Size optimalPictureSize = getOptimalPictureSize(parameters, cameraParams.getPictureWidth(), cameraParams.getPictureHeight(), cameraParams.isKeepAspectRatio(), cameraParams.getAspectTolerance(), cameraParams.isPictureCorrectUpward());
        if (optimalPreviewSize != null) {
            cameraParams.setPictureWidth(optimalPictureSize.width);
            cameraParams.setPictureHeight(optimalPictureSize.height);
        }
        int optimalPreviewFrameRate = getOptimalPreviewFrameRate(parameters, cameraParams.getFrameRate(), cameraParams.isFrameRateCorrectUpward());
        if (parameters.getSupportedPreviewFormats().contains(17)) {
            parameters.setPreviewFormat(17);
        }
        cameraParams.setFrameRate(optimalPreviewFrameRate);
    }

    private static Camera.Size getOptimalPreviewSize(Camera.Parameters parameters, int i, int i2, boolean z, double d, boolean z2) {
        List<Camera.Size> supportedPreviewSizes;
        if (parameters != null && (supportedPreviewSizes = parameters.getSupportedPreviewSizes()) != null) {
            Camera.Size optimalSize = getOptimalSize(supportedPreviewSizes, i, i2, z, d, z2);
            if (optimalSize == null) {
                return getOptimalSize(supportedPreviewSizes, i, i2, z, d, !z2);
            }
            return optimalSize;
        }
        return null;
    }

    private static Camera.Size getOptimalPictureSize(Camera.Parameters parameters, int i, int i2, boolean z, double d, boolean z2) {
        List<Camera.Size> supportedPictureSizes;
        if (parameters != null && (supportedPictureSizes = parameters.getSupportedPictureSizes()) != null) {
            Camera.Size optimalSize = getOptimalSize(supportedPictureSizes, i, i2, z, d, z2);
            if (optimalSize == null) {
                return getOptimalSize(supportedPictureSizes, i, i2, z, d, !z2);
            }
            return optimalSize;
        }
        return null;
    }

    private static Camera.Size getOptimalSize(List<Camera.Size> list, int i, int i2, boolean z, double d, boolean z2) {
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

    private static int getOptimalPreviewFrameRate(Camera.Parameters parameters, int i, boolean z) {
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null) {
            int optimalRate = getOptimalRate(supportedPreviewFrameRates, i, z);
            if (optimalRate == 0) {
                optimalRate = getOptimalRate(supportedPreviewFrameRates, i, !z);
            }
            return optimalRate;
        }
        return i;
    }

    private static int getOptimalRate(List<Integer> list, int i, boolean z) {
        if (!list.contains(Integer.valueOf(i))) {
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
        return i;
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

    public static boolean checkCameraPermission(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? checkPermissionOverVersionM(context, context.getApplicationContext().getPackageName()) : checkPermissionUnderVersionM();
    }

    private static boolean checkPermissionOverVersionM(Context context, String str) {
        return context.getPackageManager().checkPermission("android.permission.CAMERA", str) == 0;
    }

    private static boolean checkPermissionUnderVersionM() {
        boolean z = true;
        Camera camera = null;
        try {
            camera = Camera.open();
            camera.setParameters(camera.getParameters());
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
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
}
