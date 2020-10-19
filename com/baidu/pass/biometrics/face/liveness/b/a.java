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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2746a = "CameraInterface";
    public static final int b = 3;
    public static final int c = 480;
    public static final int d = 640;
    private static final float e = 0.2f;
    private static int f = -1;
    Camera g;
    SurfaceHolder h;
    private C0246a i;
    private int k;
    private String j = "off";
    private boolean l = true;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C0246a {

        /* renamed from: a  reason: collision with root package name */
        public int f2747a;
        public int b;

        public C0246a(int i, int i2) {
            this.f2747a = i;
            this.b = i2;
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

    public C0246a c() {
        if (this.i == null) {
            this.i = new C0246a(640, 480);
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
    private List<C0246a> b(Activity activity, Camera.Parameters parameters) {
        int i;
        int i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0246a c0246a = new C0246a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
            int i3 = c0246a.f2747a;
            int i4 = c0246a.b;
            if ((i3 * i4) / 4 > 921600) {
                i = (i3 * i4) / 8;
                i2 = 2073600;
            } else {
                i = 153600;
                i2 = 921600;
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
                if (i7 * i8 >= i && i7 * i8 <= i2) {
                    arrayList.add(new C0246a(i7, i8));
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
                    i = 270;
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

    private C0246a a(Activity activity, Camera.Parameters parameters) {
        C0246a c0246a = this.i;
        if (c0246a == null) {
            List<C0246a> b2 = b(activity, parameters);
            this.i = new C0246a(640, 480);
            if (b2 != null && b2.size() != 0) {
                Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                C0246a c0246a2 = new C0246a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(activity));
                float f2 = c0246a2.b / c0246a2.f2747a;
                C0246a c0246a3 = this.i;
                float f3 = c0246a3.f2747a / c0246a3.b;
                int i = 0;
                float f4 = f3;
                while (true) {
                    int i2 = i;
                    if (i2 < b2.size()) {
                        C0246a c0246a4 = b2.get(i2);
                        float abs = Math.abs((c0246a4.f2747a / c0246a4.b) - f2);
                        if (abs < f4) {
                            this.i = c0246a4;
                            f4 = abs;
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
            return c0246a;
        }
    }

    public C0246a a(Activity activity, Camera.Parameters parameters, boolean z) {
        C0246a a2 = a(activity, parameters);
        parameters.setPreviewSize(a2.f2747a, a2.b);
        return a2;
    }

    @TargetApi(5)
    public void a(Camera.Parameters parameters, C0246a c0246a) {
        int i;
        int i2;
        Camera.Size size = null;
        float f2 = c0246a != null ? c0246a.f2747a / c0246a.b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            int size2 = supportedPictureSizes.size();
            int i3 = 0;
            Camera.Size size3 = null;
            while (i3 < size2) {
                Camera.Size size4 = supportedPictureSizes.get(i3);
                if (size3 == null || ((i = size4.width) >= size3.width && (i2 = size4.height) >= size3.height && i * i2 < 5000000)) {
                    size3 = size4;
                }
                if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                    int i4 = size4.width;
                    int i5 = size4.height;
                    if (i4 * i5 < 7000000) {
                        if (size != null) {
                            if (i4 > size.width && i5 > size.height) {
                            }
                        }
                        i3++;
                        size = size4;
                    }
                }
                size4 = size;
                i3++;
                size = size4;
            }
            if (size == null) {
                size = size3;
            }
            parameters.setPictureSize(size.width, size.height);
        }
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.g;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
