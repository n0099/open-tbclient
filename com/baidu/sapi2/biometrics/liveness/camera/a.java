package com.baidu.sapi2.biometrics.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.fsg.biometrics.base.d.c;
import com.baidu.fsg.biometrics.base.d.d;
import com.baidu.fsg.biometrics.base.d.f;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 480;
    public static final int e = 640;
    private static final String i = "CameraInterface";
    private static final float j = 0.2f;
    private static int n = -1;
    Camera f;
    MediaRecorder g;
    SurfaceHolder h;
    private C0077a k;
    private int o;
    private String l = "off";
    private boolean m = false;
    private boolean p = true;
    private int q = 2;
    private boolean r = true;

    public boolean a(Context context, int i2) {
        this.q = i2;
        if (this.f != null) {
            this.f.stopPreview();
            this.f.release();
            this.f = null;
        }
        if (a() == 1) {
            this.p = false;
        }
        if (this.p) {
            n = 1;
            try {
                this.f = Camera.open(n);
                a(context);
            } catch (Throwable th) {
                c.a(th);
                return false;
            }
        } else {
            n = 0;
            try {
                this.f = Camera.open();
            } catch (Exception e2) {
                this.f = null;
                return false;
            }
        }
        return true;
    }

    public void a(Context context, SurfaceHolder surfaceHolder) {
        if (this.f != null) {
            try {
                a(context);
                this.h = surfaceHolder;
                this.f.setPreviewDisplay(surfaceHolder);
                this.f.startPreview();
            } catch (Throwable th) {
                c.a(th);
            }
            this.m = true;
        }
    }

    public int a() {
        return Camera.getNumberOfCameras();
    }

    public void b() {
        if (this.f != null) {
            this.f.startPreview();
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.stopPreview();
        }
    }

    public synchronized void d() {
        try {
            if (this.h != null && Build.VERSION.SDK_INT >= 14) {
                this.h.getSurface().release();
            }
            if (this.f != null) {
                this.f.setPreviewCallback(null);
                this.f.stopPreview();
                this.f.release();
                this.m = false;
                this.f = null;
            }
            this.p = true;
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    public void a(Context context) {
        int i2 = 0;
        if (this.f != null) {
            Camera.Parameters parameters = this.f.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(context, parameters, false));
            switch (((Activity) context).getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = SubsamplingScaleImageView.ORIENTATION_180;
                    break;
                case 3:
                    i2 = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(n, cameraInfo);
                if (cameraInfo.facing == 1) {
                    this.o = (i2 + cameraInfo.orientation) % 360;
                    this.o = (360 - this.o) % 360;
                } else {
                    this.o = ((cameraInfo.orientation - i2) + 360) % 360;
                }
                this.f.setDisplayOrientation(this.o);
            } else if (Build.VERSION.SDK_INT == 8) {
                this.o = ((90 - i2) + 360) % 360;
                this.f.setDisplayOrientation(this.o);
            } else {
                this.o = ((90 - i2) + 360) % 360;
                try {
                    Method method = this.f.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                    if (method != null) {
                        method.invoke(this.f, Integer.valueOf(this.o));
                    }
                } catch (Exception e2) {
                    c.a(e2);
                }
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.p) {
                    this.l = "off";
                    parameters.setFlashMode(this.l);
                } else {
                    parameters.setFlashMode(this.l);
                }
            } else {
                this.l = "off";
            }
            this.f.setParameters(parameters);
        }
    }

    public boolean b(Context context) {
        try {
            if (this.f == null) {
                a(context, 1);
            }
            if (this.f == null) {
                this.r = false;
                return false;
            }
            if (this.g == null) {
                this.g = new MediaRecorder();
            } else {
                this.g.reset();
            }
            Camera.Parameters parameters = this.f.getParameters();
            C0077a a2 = a(context, parameters, this.k);
            Camera camera = this.f;
            camera.getClass();
            Camera.Size size = new Camera.Size(camera, a2.a, a2.b);
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null && supportedPreviewSizes.contains(size)) {
                parameters.setPreviewSize(a2.a, a2.b);
            }
            this.f.setParameters(parameters);
            this.f.unlock();
            this.g.setCamera(this.f);
            this.g.setVideoSource(1);
            this.g.setAudioSource(1);
            this.g.setOutputFormat(2);
            this.g.setVideoEncoder(2);
            this.g.setAudioEncoder(3);
            this.g.setMaxDuration(10000);
            this.g.setMaxFileSize(2000000L);
            this.g.setVideoSize(a2.a, a2.b);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(n, cameraInfo);
            this.g.setOrientationHint(cameraInfo.orientation);
            String a3 = f.a(context);
            File file = new File(a3);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.g.setOutputFile(new File(a3 + File.separator + f.b).getAbsolutePath());
            this.g.prepare();
            this.g.start();
            this.r = true;
            return true;
        } catch (Exception e2) {
            c.a(e2);
            if (this.f != null) {
                this.f.lock();
            }
            e();
            this.r = false;
            return false;
        }
    }

    public synchronized void e() {
        try {
            if (this.g != null && this.r) {
                this.g.stop();
                this.g.reset();
                this.g.release();
                this.g = null;
            }
            if (this.f != null) {
                this.f.lock();
            }
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    private C0077a a(Context context, Camera.Parameters parameters, C0077a c0077a) {
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
            return c0077a;
        }
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return c0077a;
        }
        float f = c0077a.b / c0077a.a;
        C0077a c0077a2 = new C0077a(0, 0);
        C0077a c0077a3 = new C0077a(0, 0);
        C0077a c0077a4 = new C0077a(0, 0);
        C0077a c0077a5 = new C0077a(0, 0);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            C0077a c0077a6 = c0077a2;
            if (i3 >= supportedVideoSizes.size()) {
                return c0077a5.a > 0 ? c0077a5 : c0077a6.a <= 0 ? c0077a4 : c0077a6;
            }
            Camera.Size size = supportedVideoSizes.get(i3);
            c0077a3.a = size.width;
            c0077a3.b = size.height;
            if (c0077a3.a == c0077a.a && c0077a3.b == c0077a.b) {
                c0077a6.a = c0077a3.a;
                c0077a6.b = c0077a3.b;
                return c0077a6;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= supportedPreviewSizes.size()) {
                    break;
                }
                Camera.Size size2 = supportedPreviewSizes.get(i5);
                c0077a4.a = size2.width;
                c0077a4.b = size2.height;
                if (c0077a3.a == c0077a4.a && c0077a3.b == c0077a4.b && c0077a3.a * c0077a3.b >= c0077a5.a * c0077a5.b && c0077a3.a * c0077a3.b <= 921600) {
                    c0077a5.a = c0077a3.a;
                    c0077a5.b = c0077a3.b;
                }
                i4 = i5 + 1;
            }
            c0077a2 = (Math.abs((((float) size.width) / ((float) size.height)) - f) >= 0.01f || c0077a3.a < c0077a6.a || c0077a3.b < c0077a6.b || c0077a3.a * c0077a3.b > 921600) ? c0077a6 : c0077a3;
            i2 = i3 + 1;
        }
    }

    private List<C0077a> a(Context context, Camera.Parameters parameters) {
        int i2;
        int i3;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        C0077a c0077a = new C0077a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + d.a((Activity) context));
        if ((c0077a.a * c0077a.b) / 4 <= 691200) {
            i2 = 153600;
            i3 = 691200;
        } else {
            i2 = (c0077a.a * c0077a.b) / 8;
            i3 = 921600;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= supportedPreviewSizes.size()) {
                return arrayList;
            }
            Camera.Size size = supportedPreviewSizes.get(i5);
            if (size.width * size.height >= i2 && size.width * size.height <= i3) {
                arrayList.add(new C0077a(size.width, size.height));
            }
            i4 = i5 + 1;
        }
    }

    private C0077a b(Context context, Camera.Parameters parameters) {
        if (this.k != null) {
            return this.k;
        }
        List<C0077a> a2 = a(context, parameters);
        this.k = new C0077a(640, d);
        if (a2 == null || a2.size() == 0) {
            return this.k;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        C0077a c0077a = new C0077a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + d.a((Activity) context));
        float f = c0077a.b / c0077a.a;
        int i2 = 0;
        float f2 = 2.1474836E9f;
        while (true) {
            int i3 = i2;
            if (i3 < a2.size()) {
                C0077a c0077a2 = a2.get(i3);
                float abs = Math.abs((c0077a2.a / c0077a2.b) - f);
                if (abs <= j && abs < f2) {
                    this.k = c0077a2;
                    f2 = abs;
                }
                i2 = i3 + 1;
            } else {
                return this.k;
            }
        }
    }

    public C0077a a(Context context, Camera.Parameters parameters, boolean z) {
        C0077a b2 = b(context, parameters);
        parameters.setPreviewSize(b2.a, b2.b);
        return b2;
    }

    public void a(Camera.Parameters parameters, C0077a c0077a) {
        Camera.Size size = null;
        float f = c0077a != null ? c0077a.a / c0077a.b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            int size2 = supportedPictureSizes.size();
            int i2 = 0;
            Camera.Size size3 = null;
            while (i2 < size2) {
                Camera.Size size4 = supportedPictureSizes.get(i2);
                if (size3 == null) {
                    size3 = size4;
                } else if (size4.width >= size3.width && size4.height >= size3.height && size4.width * size4.height < 5000000) {
                    size3 = size4;
                }
                if (f <= 0.0f || Math.abs((size4.width / size4.height) - f) >= 0.15f || size4.width * size4.height >= 7000000 || (size != null && (size4.width <= size.width || size4.height <= size.height))) {
                    size4 = size;
                }
                i2++;
                size = size4;
            }
            if (size == null) {
                size = size3;
            }
            parameters.setPictureSize(size.width, size.height);
        }
    }

    public boolean f() {
        if (a() == 1) {
            this.p = false;
        }
        return this.p;
    }

    public C0077a g() {
        return this.k;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.f != null) {
            this.f.setPreviewCallback(previewCallback);
        }
    }

    /* renamed from: com.baidu.sapi2.biometrics.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0077a {
        public int a;
        public int b;

        public C0077a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
}
