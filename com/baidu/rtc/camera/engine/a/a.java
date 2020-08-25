package com.baidu.rtc.camera.engine.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.rtc.camera.engine.model.CalculateType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private Camera mCamera;

    /* renamed from: com.baidu.rtc.camera.engine.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0287a {
        public static a bNw = new a(null);
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private a() {
    }

    public static a WG() {
        return C0287a.bNw;
    }

    public void aU(Context context) {
        g(context, com.baidu.rtc.camera.engine.a.b.WH().bNA);
    }

    public void g(Context context, int i) {
        try {
            a(context, com.baidu.rtc.camera.engine.a.b.WH().cameraId, i, com.baidu.rtc.camera.engine.a.b.WH().bNC, com.baidu.rtc.camera.engine.a.b.WH().bND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context, int i, int i2, int i3, int i4) {
        if (this.mCamera != null) {
            throw new RuntimeException("camera already initialized!");
        }
        this.mCamera = Camera.open(i);
        if (this.mCamera == null) {
            throw new RuntimeException("Unable to open camera");
        }
        com.baidu.rtc.camera.engine.a.b WH = com.baidu.rtc.camera.engine.a.b.WH();
        WH.cameraId = i;
        this.mCamera.cancelAutoFocus();
        Camera.Parameters parameters = this.mCamera.getParameters();
        WH.bNH = b(parameters);
        WH.bNB = a(parameters, i2 * 1000);
        parameters.setRecordingHint(true);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(parameters);
        a(this.mCamera, i3, i4);
        b(this.mCamera, i3, i4);
        z((Activity) context);
        this.mCamera.setDisplayOrientation(WH.orientation);
    }

    public void b(SurfaceTexture surfaceTexture) {
        if (this.mCamera == null) {
            throw new IllegalStateException("Camera must be set when start preview");
        }
        try {
            this.mCamera.setPreviewTexture(surfaceTexture);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startPreview() {
        if (this.mCamera == null) {
            throw new IllegalStateException("Camera must be set when start preview");
        }
        this.mCamera.startPreview();
    }

    public void releaseCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.setPreviewCallbackWithBuffer(null);
            this.mCamera.addCallbackBuffer(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
        com.baidu.rtc.camera.engine.a.b.WH().bNH = false;
    }

    public void b(Camera.PreviewCallback previewCallback) {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(previewCallback);
        }
    }

    private void a(Camera camera, int i, int i2) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = a(parameters.getSupportedPreviewSizes(), i, i2, CalculateType.Lower);
        parameters.setPreviewSize(a.width, a.height);
        com.baidu.rtc.camera.engine.a.b.WH().bNE = a.width;
        com.baidu.rtc.camera.engine.a.b.WH().bNF = a.height;
        camera.setParameters(parameters);
    }

    private void b(Camera camera, int i, int i2) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = a(parameters.getSupportedPictureSizes(), i, i2, CalculateType.Max);
        parameters.setPictureSize(a.width, a.height);
        camera.setParameters(parameters);
    }

    private int z(Activity activity) {
        int i;
        int i2 = 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(com.baidu.rtc.camera.engine.a.b.WH().cameraId, cameraInfo);
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
            i = (360 - ((i2 + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH)) % EncoderTextureDrawer.X264_WIDTH;
        } else {
            i = ((cameraInfo.orientation - i2) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
        }
        com.baidu.rtc.camera.engine.a.b.WH().orientation = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.rtc.camera.engine.a.a$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements Camera.AutoFocusCallback {
        final /* synthetic */ String bNu;

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode(this.bNu);
            camera.setParameters(parameters);
        }
    }

    public static boolean b(Camera.Parameters parameters) {
        if (parameters.getFlashMode() == null) {
            return false;
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        return (supportedFlashModes == null || supportedFlashModes.isEmpty() || (supportedFlashModes.size() == 1 && supportedFlashModes.get(0).equals("off"))) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
        if ((r0.height / r9) > 0.8d) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0185, code lost:
        if ((r0.height / r9) > 0.8d) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Camera.Size a(List<Camera.Size> list, int i, int i2, CalculateType calculateType) {
        Camera.Size size;
        Camera.Size size2;
        boolean z;
        Y(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Camera.Size size3 : list) {
            if ((size3.height * i) / i2 == size3.width) {
                if (size3.width > i && size3.height > i2) {
                    arrayList.add(size3);
                } else {
                    arrayList2.add(size3);
                }
            }
        }
        Camera.Size size4 = null;
        switch (calculateType) {
            case Min:
                if (arrayList2.size() > 1) {
                    size = (Camera.Size) Collections.min(arrayList2, new b(null));
                    break;
                } else {
                    if (arrayList2.size() == 1) {
                        size = (Camera.Size) arrayList2.get(0);
                        break;
                    }
                    size = null;
                    break;
                }
            case Max:
                if (arrayList.size() > 1) {
                    size = (Camera.Size) Collections.max(arrayList, new b(null));
                    break;
                } else {
                    if (arrayList.size() == 1) {
                        size = (Camera.Size) arrayList.get(0);
                        break;
                    }
                    size = null;
                    break;
                }
            case Lower:
                if (arrayList2.size() > 0) {
                    size = (Camera.Size) Collections.max(arrayList2, new b(null));
                    if (size.width / i >= 0.8d) {
                        break;
                    }
                    size = null;
                    break;
                } else {
                    if (arrayList.size() > 0) {
                        Camera.Size size5 = (Camera.Size) Collections.min(arrayList, new b(null));
                        if (i / size5.width >= 0.8d && i2 / size5.height >= 0.8d) {
                            size4 = size5;
                        }
                        size = size4;
                        break;
                    }
                    size = null;
                }
                break;
            case Larger:
                if (arrayList.size() <= 0) {
                    if (arrayList2.size() > 0) {
                        size = (Camera.Size) Collections.max(arrayList2, new b(null));
                        if (size.width / i >= 0.8d) {
                            break;
                        }
                    }
                    size = null;
                    break;
                } else {
                    Camera.Size size6 = (Camera.Size) Collections.min(arrayList, new b(null));
                    if (i / size6.width >= 0.8d && i2 / size6.height >= 0.8d) {
                        size4 = size6;
                    }
                    size = size4;
                    break;
                }
                break;
            default:
                size = null;
                break;
        }
        if (size == null) {
            boolean z2 = false;
            Camera.Size size7 = list.get(0);
            for (Camera.Size size8 : list) {
                if (size8.width != i || size8.height != i2 || size8.height / size8.width != com.baidu.rtc.camera.engine.a.b.WH().bNz) {
                    if (size8.width == i) {
                        z2 = true;
                        if (Math.abs(size7.height - i2) > Math.abs(size8.height - i2) && size8.height / size8.width == com.baidu.rtc.camera.engine.a.b.WH().bNz) {
                            return size8;
                        }
                    } else if (size8.height == i2) {
                        z2 = true;
                        if (Math.abs(size7.width - i) > Math.abs(size8.width - i) && size8.height / size8.width == com.baidu.rtc.camera.engine.a.b.WH().bNz) {
                            return size8;
                        }
                    } else if (!z2 && Math.abs(size7.width - i) > Math.abs(size8.width - i) && Math.abs(size7.height - i2) > Math.abs(size8.height - i2) && size8.height / size8.width == com.baidu.rtc.camera.engine.a.b.WH().bNz) {
                        boolean z3 = z2;
                        size2 = size8;
                        z = z3;
                        size7 = size2;
                        z2 = z;
                    }
                    z = z2;
                    size2 = size7;
                    size7 = size2;
                    z2 = z;
                } else {
                    return size8;
                }
            }
            return size7;
        }
        return size;
    }

    private static void Y(List<Camera.Size> list) {
        Collections.sort(list, new b(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b implements Comparator<Camera.Size> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    }

    public static int a(Camera.Parameters parameters, int i) {
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                return iArr[0];
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == iArr2[1]) {
            return iArr2[0];
        }
        return iArr2[1] / 2;
    }
}
