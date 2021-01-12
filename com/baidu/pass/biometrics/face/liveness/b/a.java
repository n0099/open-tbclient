package com.baidu.pass.biometrics.face.liveness.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4033a = "CameraInterface";

    /* renamed from: b  reason: collision with root package name */
    public static final int f4034b = 3;
    public static final int c = 480;
    public static final int d = 640;
    private static final float e = 0.2f;
    private static int f = -1;
    Camera g;
    SurfaceHolder h;
    private C0269a i;
    private int k;
    private String j = "off";
    private boolean l = true;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0269a {

        /* renamed from: a  reason: collision with root package name */
        public int f4035a;

        /* renamed from: b  reason: collision with root package name */
        public int f4036b;

        public C0269a(int i, int i2) {
            this.f4035a = i;
            this.f4036b = i2;
        }
    }

    @TargetApi(9)
    public boolean a(Activity activity, int i) {
        Camera camera = this.g;
        if (camera != null) {
            camera.stopPreview();
            this.g.release();
            this.g = null;
        }
        if (b() == 1) {
            this.l = false;
        }
        if (this.l) {
            f = 1;
        } else {
            f = 0;
        }
        try {
            this.g = Camera.open(f);
            a(activity);
            return true;
        } catch (Throwable th) {
            Log.e(th);
            Camera camera2 = this.g;
            if (camera2 != null) {
                camera2.release();
                this.g = null;
            }
            return false;
        }
    }

    @TargetApi(9)
    public int b() {
        return Camera.getNumberOfCameras();
    }

    public C0269a c() {
        if (this.i == null) {
            this.i = new C0269a(640, 480);
        }
        return this.i;
    }

    public boolean d() {
        if (b() == 1) {
            this.l = false;
        }
        return this.l;
    }

    public void e() {
        Camera camera = this.g;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void f() {
        Camera camera = this.g;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    @TargetApi(5)
    private List<C0269a> b(Activity activity, Camera.Parameters parameters) {
        int i;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0269a c0269a = new C0269a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            int i2 = 153600;
            int i3 = c0269a.f4035a;
            int i4 = c0269a.f4036b;
            if ((i3 * i4) / 4 > 921600) {
                i2 = (i4 * i3) / 8;
                i = 2073600;
            } else {
                i = 921600;
            }
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= supportedPreviewSizes.size()) {
                    return arrayList;
                }
                Camera.Size size = supportedPreviewSizes.get(i6);
                int i7 = size.width;
                int i8 = size.height;
                if (i7 * i8 >= i2 && i7 * i8 <= i) {
                    arrayList.add(new C0269a(i7, i8));
                }
                i5 = i6 + 1;
            }
        } else {
            return null;
        }
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        Camera camera = this.g;
        if (camera != null) {
            try {
                this.h = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.g.startPreview();
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public synchronized void a() {
        try {
            if (this.h != null && Build.VERSION.SDK_INT >= 14) {
                this.h.getSurface().release();
            }
            if (this.g != null) {
                this.g.setPreviewCallback(null);
                this.g.stopPreview();
                this.g.release();
                this.g = null;
            }
            this.l = true;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @TargetApi(8)
    public void a(Activity activity) {
        int i = 0;
        Camera camera = this.g;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters, false));
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = 180;
                    break;
                case 3:
                    i = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 9) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(f, cameraInfo);
                if (cameraInfo.facing == 1) {
                    this.k = (i + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH;
                    this.k = (360 - this.k) % EncoderTextureDrawer.X264_WIDTH;
                } else {
                    this.k = ((cameraInfo.orientation - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
                }
                this.g.setDisplayOrientation(this.k);
            } else if (i2 == 8) {
                this.k = ((90 - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
                this.g.setDisplayOrientation(this.k);
            } else {
                this.k = ((90 - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
                try {
                    Method method = this.g.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                    if (method != null) {
                        method.invoke(this.g, Integer.valueOf(this.k));
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.l) {
                    this.j = "off";
                    parameters.setFlashMode(this.j);
                } else {
                    parameters.setFlashMode(this.j);
                }
            } else {
                this.j = "off";
            }
            this.g.setParameters(parameters);
        }
    }

    private C0269a a(Activity activity, Camera.Parameters parameters) {
        C0269a c0269a = this.i;
        if (c0269a == null) {
            List<C0269a> b2 = b(activity, parameters);
            this.i = new C0269a(640, 480);
            if (b2 != null && b2.size() != 0) {
                Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                C0269a c0269a2 = new C0269a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
                float f2 = c0269a2.f4036b / c0269a2.f4035a;
                C0269a c0269a3 = this.i;
                float f3 = c0269a3.f4035a / c0269a3.f4036b;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < b2.size()) {
                        C0269a c0269a4 = b2.get(i2);
                        float abs = Math.abs((c0269a4.f4035a / c0269a4.f4036b) - f2);
                        if (abs < f3) {
                            this.i = c0269a4;
                            f3 = abs;
                        }
                        i = i2 + 1;
                    } else {
                        return this.i;
                    }
                }
            } else {
                return this.i;
            }
        } else {
            return c0269a;
        }
    }

    public C0269a a(Activity activity, Camera.Parameters parameters, boolean z) {
        C0269a a2 = a(activity, parameters);
        parameters.setPreviewSize(a2.f4035a, a2.f4036b);
        return a2;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, C0269a c0269a) {
        int i;
        int i2;
        float f2 = c0269a != null ? c0269a.f4035a / c0269a.f4036b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            int size = supportedPictureSizes.size();
            int i3 = 0;
            Camera.Size size2 = null;
            Camera.Size size3 = null;
            while (i3 < size) {
                Camera.Size size4 = supportedPictureSizes.get(i3);
                if (size3 == null || ((i = size4.width) >= size3.width && (i2 = size4.height) >= size3.height && i * i2 < 5000000)) {
                    size3 = size4;
                }
                if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                    int i4 = size4.width;
                    int i5 = size4.height;
                    if (i4 * i5 < 7000000) {
                        if (size2 != null) {
                            if (i4 > size2.width && i5 > size2.height) {
                            }
                        }
                        i3++;
                        size2 = size4;
                    }
                }
                size4 = size2;
                i3++;
                size2 = size4;
            }
            if (size2 == null) {
                size2 = size3;
            }
            parameters.setPictureSize(size2.width, size2.height);
        }
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.g;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
