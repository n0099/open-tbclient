package com.baidu.pass.biometrics.face.liveness.b;

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
import kotlinx.coroutines.DebugKt;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f9539g = "CameraInterface";

    /* renamed from: h  reason: collision with root package name */
    public static final int f9540h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9541i = 480;
    public static final int j = 640;
    public static final float k = 0.2f;
    public static int l = -1;

    /* renamed from: a  reason: collision with root package name */
    public Camera f9542a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9543b;

    /* renamed from: c  reason: collision with root package name */
    public C0115a f9544c;

    /* renamed from: e  reason: collision with root package name */
    public int f9546e;

    /* renamed from: d  reason: collision with root package name */
    public String f9545d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9547f = true;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0115a {

        /* renamed from: a  reason: collision with root package name */
        public int f9548a;

        /* renamed from: b  reason: collision with root package name */
        public int f9549b;

        public C0115a(int i2, int i3) {
            this.f9548a = i2;
            this.f9549b = i3;
        }
    }

    @TargetApi(9)
    public boolean a(Activity activity, int i2) {
        Camera camera = this.f9542a;
        if (camera != null) {
            camera.stopPreview();
            this.f9542a.release();
            this.f9542a = null;
        }
        if (b() == 1) {
            this.f9547f = false;
        }
        if (this.f9547f) {
            l = 1;
        } else {
            l = 0;
        }
        try {
            this.f9542a = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            Camera camera2 = this.f9542a;
            if (camera2 != null) {
                camera2.release();
                this.f9542a = null;
            }
            return false;
        }
    }

    @TargetApi(9)
    public int b() {
        return Camera.getNumberOfCameras();
    }

    public C0115a c() {
        if (this.f9544c == null) {
            this.f9544c = new C0115a(640, 480);
        }
        return this.f9544c;
    }

    public boolean d() {
        if (b() == 1) {
            this.f9547f = false;
        }
        return this.f9547f;
    }

    public void e() {
        Camera camera = this.f9542a;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void f() {
        Camera camera = this.f9542a;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    @TargetApi(5)
    private List<C0115a> b(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0115a c0115a = new C0115a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i2 = 153600;
        int i3 = 921600;
        int i4 = c0115a.f9548a * c0115a.f9549b;
        if (i4 / 4 > 921600) {
            i3 = 2073600;
            i2 = i4 / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < supportedPreviewSizes.size(); i5++) {
            Camera.Size size = supportedPreviewSizes.get(i5);
            int i6 = size.width;
            int i7 = size.height;
            int i8 = i6 * i7;
            if (i8 >= i2 && i8 <= i3) {
                arrayList.add(new C0115a(i6, i7));
            }
        }
        return arrayList;
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        Camera camera = this.f9542a;
        if (camera != null) {
            try {
                this.f9543b = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f9542a.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public synchronized void a() {
        try {
            if (this.f9543b != null && Build.VERSION.SDK_INT >= 14) {
                this.f9543b.getSurface().release();
            }
            if (this.f9542a != null) {
                this.f9542a.setPreviewCallback(null);
                this.f9542a.stopPreview();
                this.f9542a.release();
                this.f9542a = null;
            }
            this.f9547f = true;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity) {
        int i2;
        int i3;
        Camera camera = this.f9542a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters, false));
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
                i3 = Build.VERSION.SDK_INT;
                if (i3 < 9) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(l, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        int i4 = (cameraInfo.orientation + i2) % 360;
                        this.f9546e = i4;
                        this.f9546e = (360 - i4) % 360;
                    } else {
                        this.f9546e = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    this.f9542a.setDisplayOrientation(this.f9546e);
                } else if (i3 == 8) {
                    int i5 = ((90 - i2) + 360) % 360;
                    this.f9546e = i5;
                    this.f9542a.setDisplayOrientation(i5);
                } else {
                    this.f9546e = ((90 - i2) + 360) % 360;
                    try {
                        Method method = this.f9542a.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                        if (method != null) {
                            method.invoke(this.f9542a, Integer.valueOf(this.f9546e));
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                if (parameters.getSupportedFlashModes() == null) {
                    if (this.f9547f) {
                        this.f9545d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    } else {
                        parameters.setFlashMode(this.f9545d);
                    }
                } else {
                    this.f9545d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                this.f9542a.setParameters(parameters);
            }
            i2 = 0;
            i3 = Build.VERSION.SDK_INT;
            if (i3 < 9) {
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            }
            if (parameters.getSupportedFlashModes() == null) {
            }
            this.f9542a.setParameters(parameters);
        }
    }

    private C0115a a(Activity activity, Camera.Parameters parameters) {
        C0115a c0115a = this.f9544c;
        if (c0115a != null) {
            return c0115a;
        }
        List<C0115a> b2 = b(activity, parameters);
        this.f9544c = new C0115a(640, 480);
        if (b2 != null && b2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0115a c0115a2 = new C0115a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0115a2.f9549b / c0115a2.f9548a;
            C0115a c0115a3 = this.f9544c;
            float f3 = c0115a3.f9548a / c0115a3.f9549b;
            for (int i2 = 0; i2 < b2.size(); i2++) {
                C0115a c0115a4 = b2.get(i2);
                float abs = Math.abs((c0115a4.f9548a / c0115a4.f9549b) - f2);
                if (abs < f3) {
                    this.f9544c = c0115a4;
                    f3 = abs;
                }
            }
            return this.f9544c;
        }
        return this.f9544c;
    }

    public C0115a a(Activity activity, Camera.Parameters parameters, boolean z) {
        C0115a a2 = a(activity, parameters);
        parameters.setPreviewSize(a2.f9548a, a2.f9549b);
        return a2;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, C0115a c0115a) {
        int i2;
        int i3;
        float f2 = c0115a != null ? c0115a.f9548a / c0115a.f9549b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes == null) {
            return;
        }
        int size = supportedPictureSizes.size();
        Camera.Size size2 = null;
        Camera.Size size3 = null;
        for (int i4 = 0; i4 < size; i4++) {
            Camera.Size size4 = supportedPictureSizes.get(i4);
            if (size3 == null || ((i2 = size4.width) >= size3.width && (i3 = size4.height) >= size3.height && i2 * i3 < 5000000)) {
                size3 = size4;
            }
            if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                int i5 = size4.width;
                int i6 = size4.height;
                if (i5 * i6 < 7000000 && (size2 == null || (i5 > size2.width && i6 > size2.height))) {
                    size2 = size4;
                }
            }
        }
        if (size2 == null) {
            size2 = size3;
        }
        parameters.setPictureSize(size2.width, size2.height);
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f9542a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
