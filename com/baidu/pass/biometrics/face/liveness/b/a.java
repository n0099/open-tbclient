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
    public static final String f9160g = "CameraInterface";

    /* renamed from: h  reason: collision with root package name */
    public static final int f9161h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9162i = 480;
    public static final int j = 640;
    public static final float k = 0.2f;
    public static int l = -1;

    /* renamed from: a  reason: collision with root package name */
    public Camera f9163a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9164b;

    /* renamed from: c  reason: collision with root package name */
    public C0113a f9165c;

    /* renamed from: e  reason: collision with root package name */
    public int f9167e;

    /* renamed from: d  reason: collision with root package name */
    public String f9166d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9168f = true;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0113a {

        /* renamed from: a  reason: collision with root package name */
        public int f9169a;

        /* renamed from: b  reason: collision with root package name */
        public int f9170b;

        public C0113a(int i2, int i3) {
            this.f9169a = i2;
            this.f9170b = i3;
        }
    }

    @TargetApi(9)
    public boolean a(Activity activity, int i2) {
        Camera camera = this.f9163a;
        if (camera != null) {
            camera.stopPreview();
            this.f9163a.release();
            this.f9163a = null;
        }
        if (b() == 1) {
            this.f9168f = false;
        }
        if (this.f9168f) {
            l = 1;
        } else {
            l = 0;
        }
        try {
            this.f9163a = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            Camera camera2 = this.f9163a;
            if (camera2 != null) {
                camera2.release();
                this.f9163a = null;
            }
            return false;
        }
    }

    @TargetApi(9)
    public int b() {
        return Camera.getNumberOfCameras();
    }

    public C0113a c() {
        if (this.f9165c == null) {
            this.f9165c = new C0113a(640, 480);
        }
        return this.f9165c;
    }

    public boolean d() {
        if (b() == 1) {
            this.f9168f = false;
        }
        return this.f9168f;
    }

    public void e() {
        Camera camera = this.f9163a;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void f() {
        Camera camera = this.f9163a;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    @TargetApi(5)
    private List<C0113a> b(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0113a c0113a = new C0113a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i2 = 153600;
        int i3 = 921600;
        int i4 = c0113a.f9169a * c0113a.f9170b;
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
                arrayList.add(new C0113a(i6, i7));
            }
        }
        return arrayList;
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        Camera camera = this.f9163a;
        if (camera != null) {
            try {
                this.f9164b = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f9163a.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public synchronized void a() {
        try {
            if (this.f9164b != null && Build.VERSION.SDK_INT >= 14) {
                this.f9164b.getSurface().release();
            }
            if (this.f9163a != null) {
                this.f9163a.setPreviewCallback(null);
                this.f9163a.stopPreview();
                this.f9163a.release();
                this.f9163a = null;
            }
            this.f9168f = true;
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
        Camera camera = this.f9163a;
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
                        this.f9167e = i4;
                        this.f9167e = (360 - i4) % 360;
                    } else {
                        this.f9167e = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    this.f9163a.setDisplayOrientation(this.f9167e);
                } else if (i3 == 8) {
                    int i5 = ((90 - i2) + 360) % 360;
                    this.f9167e = i5;
                    this.f9163a.setDisplayOrientation(i5);
                } else {
                    this.f9167e = ((90 - i2) + 360) % 360;
                    try {
                        Method method = this.f9163a.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                        if (method != null) {
                            method.invoke(this.f9163a, Integer.valueOf(this.f9167e));
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                if (parameters.getSupportedFlashModes() == null) {
                    if (this.f9168f) {
                        this.f9166d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    } else {
                        parameters.setFlashMode(this.f9166d);
                    }
                } else {
                    this.f9166d = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                this.f9163a.setParameters(parameters);
            }
            i2 = 0;
            i3 = Build.VERSION.SDK_INT;
            if (i3 < 9) {
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            }
            if (parameters.getSupportedFlashModes() == null) {
            }
            this.f9163a.setParameters(parameters);
        }
    }

    private C0113a a(Activity activity, Camera.Parameters parameters) {
        C0113a c0113a = this.f9165c;
        if (c0113a != null) {
            return c0113a;
        }
        List<C0113a> b2 = b(activity, parameters);
        this.f9165c = new C0113a(640, 480);
        if (b2 != null && b2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0113a c0113a2 = new C0113a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0113a2.f9170b / c0113a2.f9169a;
            C0113a c0113a3 = this.f9165c;
            float f3 = c0113a3.f9169a / c0113a3.f9170b;
            for (int i2 = 0; i2 < b2.size(); i2++) {
                C0113a c0113a4 = b2.get(i2);
                float abs = Math.abs((c0113a4.f9169a / c0113a4.f9170b) - f2);
                if (abs < f3) {
                    this.f9165c = c0113a4;
                    f3 = abs;
                }
            }
            return this.f9165c;
        }
        return this.f9165c;
    }

    public C0113a a(Activity activity, Camera.Parameters parameters, boolean z) {
        C0113a a2 = a(activity, parameters);
        parameters.setPreviewSize(a2.f9169a, a2.f9170b);
        return a2;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, C0113a c0113a) {
        int i2;
        int i3;
        float f2 = c0113a != null ? c0113a.f9169a / c0113a.f9170b : 0.0f;
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
        Camera camera = this.f9163a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
