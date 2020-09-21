package com.baidu.ala.recorder.video.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.live.adp.lib.util.BdLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TargetApi(16)
/* loaded from: classes12.dex */
public class CameraUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String TAG;

    static {
        $assertionsDisabled = !CameraUtils.class.desiredAssertionStatus();
        TAG = CameraUtils.class.getSimpleName();
    }

    public static Camera.Size choosePreviewSize(Camera.Parameters parameters, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes;
        double d;
        Camera.Size size;
        double d2;
        double d3;
        Camera.Size size2;
        if (parameters == null || (supportedPreviewSizes = parameters.getSupportedPreviewSizes()) == null) {
            return null;
        }
        double d4 = i / i2;
        Camera.Size size3 = null;
        double d5 = Double.MAX_VALUE;
        for (Camera.Size size4 : supportedPreviewSizes) {
            if (Math.abs((size4.width / size4.height) - d4) <= 0.1d) {
                if (Math.abs(size4.height - i2) < d5) {
                    d3 = Math.abs(size4.height - i2);
                    size2 = size4;
                } else {
                    d3 = d5;
                    size2 = size3;
                }
                size3 = size2;
                d5 = d3;
            }
        }
        if (size3 == null) {
            double d6 = Double.MAX_VALUE;
            double d7 = Double.MAX_VALUE;
            for (Camera.Size size5 : supportedPreviewSizes) {
                double abs = Math.abs((size5.width / size5.height) - d4);
                if (abs > d7 || Math.abs(size5.height - i2) >= d6) {
                    double d8 = d7;
                    d = d6;
                    size = size3;
                    d2 = d8;
                } else {
                    d = Math.abs(size5.height - i2);
                    size = size5;
                    d2 = abs;
                }
                size3 = size;
                d6 = d;
                d7 = d2;
            }
        }
        Camera.Size size6 = size3;
        if (size6 != null) {
            parameters.setPreviewSize(size6.width, size6.height);
            return size6;
        }
        return size6;
    }

    public static void chooseFixedPreviewFps(Camera.Parameters parameters, int i) {
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
            }
        }
    }

    public static int getCameraDisplayOrientation(Activity activity, Camera.CameraInfo cameraInfo, int i) {
        int i2 = 0;
        if (cameraInfo == null) {
            cameraInfo = new Camera.CameraInfo();
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i3 = 0; i3 < numberOfCameras; i3++) {
                try {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == i) {
                        break;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((i2 + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
        }
        return ((cameraInfo.orientation - i2) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
    }

    public static void setVideoStabilization(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (!parameters.getVideoStabilization()) {
                parameters.setVideoStabilization(true);
                BdLog.d("Enabling video stabilization");
                return;
            }
            return;
        }
        BdLog.d("This device does not support video stabilization");
    }

    public static float getExposureCompensation(Camera camera) {
        if (camera == null) {
            return 0.0f;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            float exposureCompensation = parameters.getExposureCompensation();
            float minExposureCompensation = parameters.getMinExposureCompensation();
            return (exposureCompensation - minExposureCompensation) / (parameters.getMaxExposureCompensation() - minExposureCompensation);
        } catch (Exception e) {
            BdLog.d("getExposureCompensation fail: " + e.getMessage());
            return 0.0f;
        }
    }

    public static void setExposureCompensation(Camera camera, float f) {
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                float minExposureCompensation = parameters.getMinExposureCompensation();
                parameters.setExposureCompensation((int) (minExposureCompensation + ((parameters.getMaxExposureCompensation() - minExposureCompensation) * f)));
                camera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public static void rectFToRect(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static Map<String, String> getFullCameraParameters(Camera camera) {
        HashMap hashMap = new HashMap(64);
        try {
            Method declaredMethod = camera.getClass().getDeclaredMethod("native_getParameters", new Class[0]);
            declaredMethod.setAccessible(true);
            TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(';');
            simpleStringSplitter.setString((String) declaredMethod.invoke(camera, new Object[0]));
            for (String str : simpleStringSplitter) {
                int indexOf = str.indexOf(61);
                if (indexOf != -1) {
                    hashMap.put(str.substring(0, indexOf), str.substring(indexOf + 1));
                }
            }
            return hashMap;
        } catch (Exception e) {
            Log.e(TAG, "ex:", e);
            Log.e(TAG, "Unable to retrieve parameters from Camera.");
            return hashMap;
        }
    }

    public static void turnLightOn(Camera.Parameters parameters) {
        List<String> supportedFlashModes;
        if (parameters != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !"torch".equals(parameters.getFlashMode()) && supportedFlashModes.contains("torch")) {
            parameters.setFlashMode("torch");
        }
    }

    public static void turnLightOff(Camera.Parameters parameters) {
        if (parameters != null) {
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            String flashMode = parameters.getFlashMode();
            if (supportedFlashModes != null && !"off".equals(flashMode) && supportedFlashModes.contains("off")) {
                parameters.setFlashMode("off");
            }
        }
    }

    public static void setFocusModes(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
        }
    }

    public static void prepareMatrix(Activity activity, int i, Matrix matrix, int i2, int i3) {
        matrix.setScale(1 == i ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(determineDisplayOrientation(activity, i));
        matrix.postScale(i2 / 2000.0f, i3 / 2000.0f);
        matrix.postTranslate(i2 / 2.0f, i3 / 2.0f);
    }

    public static int determineDisplayOrientation(Activity activity, int i) {
        int i2;
        int i3 = 0;
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            int rotationAngle = getRotationAngle(activity);
            if (cameraInfo.facing == 1) {
                i3 = (cameraInfo.orientation + rotationAngle) % EncoderTextureDrawer.X264_WIDTH;
                i2 = (360 - i3) % EncoderTextureDrawer.X264_WIDTH;
            } else {
                i2 = ((cameraInfo.orientation - rotationAngle) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
            }
            return i2;
        } catch (RuntimeException e) {
            int i4 = i3;
            BdLog.e(e);
            return i4;
        }
    }

    public static int getRotationAngle(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
            default:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
        }
    }

    public static boolean hasCamera2(Context context) {
        boolean z;
        if (context != null && Build.VERSION.SDK_INT >= 21) {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService(PixelReadParams.DEFAULT_FILTER_ID);
                if ($assertionsDisabled || cameraManager != null) {
                    String[] cameraIdList = cameraManager.getCameraIdList();
                    if (cameraIdList.length == 0) {
                        z = false;
                    } else {
                        int length = cameraIdList.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = true;
                                break;
                            }
                            String str = cameraIdList[i];
                            if (str != null && !str.trim().isEmpty()) {
                                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                                if (num != null && num.intValue() == 2) {
                                    z = false;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                        z = false;
                    }
                    return z;
                }
                throw new AssertionError();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
