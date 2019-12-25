package com.baidu.ala.recorder.video.camera;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Environment;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaFormat;
/* loaded from: classes2.dex */
public class CameraUtils {
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
            return (360 - ((i2 + cameraInfo.orientation) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [146=4] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void createFileWithByte(byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        BufferedOutputStream bufferedOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(), IjkMediaFormat.CODEC_NAME_H264);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, true);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedOutputStream = bufferedOutputStream2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
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
}
