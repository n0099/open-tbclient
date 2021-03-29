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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f9643g = "CameraInterface";

    /* renamed from: h  reason: collision with root package name */
    public static final int f9644h = 3;
    public static final int i = 480;
    public static final int j = 640;
    public static final float k = 0.2f;
    public static int l = -1;

    /* renamed from: a  reason: collision with root package name */
    public Camera f9645a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f9646b;

    /* renamed from: c  reason: collision with root package name */
    public C0116a f9647c;

    /* renamed from: e  reason: collision with root package name */
    public int f9649e;

    /* renamed from: d  reason: collision with root package name */
    public String f9648d = "off";

    /* renamed from: f  reason: collision with root package name */
    public boolean f9650f = true;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0116a {

        /* renamed from: a  reason: collision with root package name */
        public int f9651a;

        /* renamed from: b  reason: collision with root package name */
        public int f9652b;

        public C0116a(int i, int i2) {
            this.f9651a = i;
            this.f9652b = i2;
        }
    }

    @TargetApi(9)
    public boolean a(Activity activity, int i2) {
        Camera camera = this.f9645a;
        if (camera != null) {
            camera.stopPreview();
            this.f9645a.release();
            this.f9645a = null;
        }
        if (b() == 1) {
            this.f9650f = false;
        }
        if (this.f9650f) {
            l = 1;
        } else {
            l = 0;
        }
        try {
            this.f9645a = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            Camera camera2 = this.f9645a;
            if (camera2 != null) {
                camera2.release();
                this.f9645a = null;
            }
            return false;
        }
    }

    @TargetApi(9)
    public int b() {
        return Camera.getNumberOfCameras();
    }

    public C0116a c() {
        if (this.f9647c == null) {
            this.f9647c = new C0116a(640, 480);
        }
        return this.f9647c;
    }

    public boolean d() {
        if (b() == 1) {
            this.f9650f = false;
        }
        return this.f9650f;
    }

    public void e() {
        Camera camera = this.f9645a;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void f() {
        Camera camera = this.f9645a;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    @TargetApi(5)
    private List<C0116a> b(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0116a c0116a = new C0116a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
        int i2 = 153600;
        int i3 = 921600;
        int i4 = c0116a.f9651a * c0116a.f9652b;
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
                arrayList.add(new C0116a(i6, i7));
            }
        }
        return arrayList;
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        Camera camera = this.f9645a;
        if (camera != null) {
            try {
                this.f9646b = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f9645a.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public synchronized void a() {
        try {
            if (this.f9646b != null && Build.VERSION.SDK_INT >= 14) {
                this.f9646b.getSurface().release();
            }
            if (this.f9645a != null) {
                this.f9645a.setPreviewCallback(null);
                this.f9645a.stopPreview();
                this.f9645a.release();
                this.f9645a = null;
            }
            this.f9650f = true;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity) {
        int i2;
        int i3;
        Camera camera = this.f9645a;
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
                        this.f9649e = i4;
                        this.f9649e = (360 - i4) % 360;
                    } else {
                        this.f9649e = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    this.f9645a.setDisplayOrientation(this.f9649e);
                } else if (i3 == 8) {
                    int i5 = ((90 - i2) + 360) % 360;
                    this.f9649e = i5;
                    this.f9645a.setDisplayOrientation(i5);
                } else {
                    this.f9649e = ((90 - i2) + 360) % 360;
                    try {
                        Method method = this.f9645a.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                        if (method != null) {
                            method.invoke(this.f9645a, Integer.valueOf(this.f9649e));
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                if (parameters.getSupportedFlashModes() == null) {
                    if (this.f9650f) {
                        this.f9648d = "off";
                        parameters.setFlashMode("off");
                    } else {
                        parameters.setFlashMode(this.f9648d);
                    }
                } else {
                    this.f9648d = "off";
                }
                this.f9645a.setParameters(parameters);
            }
            i2 = 0;
            i3 = Build.VERSION.SDK_INT;
            if (i3 < 9) {
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            }
            if (parameters.getSupportedFlashModes() == null) {
            }
            this.f9645a.setParameters(parameters);
        }
    }

    private C0116a a(Activity activity, Camera.Parameters parameters) {
        C0116a c0116a = this.f9647c;
        if (c0116a != null) {
            return c0116a;
        }
        List<C0116a> b2 = b(activity, parameters);
        this.f9647c = new C0116a(640, 480);
        if (b2 != null && b2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0116a c0116a2 = new C0116a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            float f2 = c0116a2.f9652b / c0116a2.f9651a;
            C0116a c0116a3 = this.f9647c;
            float f3 = c0116a3.f9651a / c0116a3.f9652b;
            for (int i2 = 0; i2 < b2.size(); i2++) {
                C0116a c0116a4 = b2.get(i2);
                float abs = Math.abs((c0116a4.f9651a / c0116a4.f9652b) - f2);
                if (abs < f3) {
                    this.f9647c = c0116a4;
                    f3 = abs;
                }
            }
            return this.f9647c;
        }
        return this.f9647c;
    }

    public C0116a a(Activity activity, Camera.Parameters parameters, boolean z) {
        C0116a a2 = a(activity, parameters);
        parameters.setPreviewSize(a2.f9651a, a2.f9652b);
        return a2;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, C0116a c0116a) {
        int i2;
        int i3;
        float f2 = c0116a != null ? c0116a.f9651a / c0116a.f9652b : 0.0f;
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
        Camera camera = this.f9645a;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
