package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.beans.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5988a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5989b = 640;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5990c = "CameraControl";

    /* renamed from: d  reason: collision with root package name */
    public static final float f5991d = 0.2f;
    public static int l = -1;

    /* renamed from: e  reason: collision with root package name */
    public Camera f5992e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f5993f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f5994g;

    /* renamed from: h  reason: collision with root package name */
    public C0083a f5995h;
    public C0083a i;
    public int m;
    public String j = "on";
    public boolean k = false;
    public boolean n = true;
    public boolean o = true;
    public boolean p = false;

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        public int f5996a;

        /* renamed from: b  reason: collision with root package name */
        public int f5997b;

        public C0083a(int i, int i2) {
            this.f5996a = i;
            this.f5997b = i2;
        }
    }

    private C0083a b(Activity activity, Camera.Parameters parameters) {
        List<C0083a> c2 = c(activity, parameters);
        C0083a c0083a = new C0083a(640, 480);
        if (c2 != null && c2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0083a c0083a2 = new C0083a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            float f2 = c0083a2.f5997b / c0083a2.f5996a;
            float f3 = c0083a.f5996a / c0083a.f5997b;
            for (int i = 0; i < c2.size(); i++) {
                C0083a c0083a3 = c2.get(i);
                float abs = Math.abs((c0083a3.f5996a / c0083a3.f5997b) - f2);
                if (abs < f3) {
                    c0083a = c0083a3;
                    f3 = abs;
                }
            }
        }
        return c0083a;
    }

    private List<C0083a> c(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0083a c0083a = new C0083a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        int i = 153600;
        int i2 = 921600;
        int i3 = c0083a.f5996a;
        int i4 = c0083a.f5997b;
        if ((i3 * i4) / 4 > 921600) {
            i2 = 2073600;
            i = (i3 * i4) / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < supportedPreviewSizes.size(); i5++) {
            Camera.Size size = supportedPreviewSizes.get(i5);
            int i6 = size.width;
            int i7 = size.height;
            if (i6 * i7 >= i && i6 * i7 <= i2) {
                arrayList.add(new C0083a(i6, i7));
            }
        }
        return arrayList;
    }

    public boolean a(Activity activity, boolean z) {
        this.p = z;
        Camera camera = this.f5992e;
        if (camera != null) {
            camera.stopPreview();
            this.f5992e.release();
            this.f5992e = null;
        }
        try {
            if (a()) {
                l = 1;
            } else {
                l = 0;
            }
            this.f5992e = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            d.a(th);
            Camera camera2 = this.f5992e;
            if (camera2 != null) {
                camera2.release();
                this.f5992e = null;
            }
            return false;
        }
    }

    public synchronized void d() {
        try {
            if (this.f5994g != null && Build.VERSION.SDK_INT >= 14) {
                this.f5994g.getSurface().release();
            }
            if (this.f5992e != null) {
                this.f5992e.setPreviewCallback(null);
                this.f5992e.stopPreview();
                this.f5992e.release();
                this.k = false;
                this.f5992e = null;
            }
            this.n = true;
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public synchronized void e() {
        try {
            if (this.f5993f != null && this.o) {
                this.f5993f.reset();
                this.f5993f.release();
                this.f5993f = null;
            }
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public C0083a f() {
        return this.f5995h;
    }

    public void b() {
        Camera camera = this.f5992e;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public boolean a() {
        if (Camera.getNumberOfCameras() == 1) {
            this.n = false;
        }
        return this.n;
    }

    public void c() {
        Camera camera = this.f5992e;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    private C0083a b(Camera.Parameters parameters, C0083a c0083a) {
        List<Camera.Size> list;
        int i;
        int i2;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
            return c0083a;
        }
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return c0083a;
        }
        float f2 = c0083a.f5997b / c0083a.f5996a;
        C0083a c0083a2 = new C0083a(0, 0);
        C0083a c0083a3 = new C0083a(0, 0);
        C0083a c0083a4 = new C0083a(0, 0);
        C0083a c0083a5 = new C0083a(0, 0);
        C0083a c0083a6 = new C0083a(0, 0);
        int i3 = 921600;
        C0083a c0083a7 = new C0083a(0, 0);
        int i4 = 0;
        while (i4 < supportedVideoSizes.size()) {
            Camera.Size size = supportedVideoSizes.get(i4);
            int i5 = size.width;
            c0083a3.f5996a = i5;
            int i6 = size.height;
            c0083a3.f5997b = i6;
            if (i5 == c0083a.f5996a && i6 == c0083a.f5997b) {
                c0083a2.f5996a = i5;
                c0083a2.f5997b = i6;
                return c0083a2;
            }
            float f3 = 0.01f;
            if (Math.abs((size.height / size.width) - f2) < 0.01f && (i = c0083a3.f5996a) >= c0083a2.f5996a && (i2 = c0083a3.f5997b) >= c0083a2.f5997b && i * i2 <= i3) {
                c0083a2.f5996a = i;
                c0083a2.f5997b = i2;
            }
            int i7 = 0;
            while (i7 < supportedPreviewSizes.size()) {
                Camera.Size size2 = supportedPreviewSizes.get(i7);
                int i8 = size2.width;
                c0083a4.f5996a = i8;
                int i9 = size2.height;
                c0083a4.f5997b = i9;
                if (!(c0083a3.f5996a == i8 && c0083a3.f5997b == i9) && Math.abs((c0083a4.f5997b / c0083a4.f5996a) - (c0083a3.f5997b / c0083a3.f5996a)) >= f3) {
                    list = supportedVideoSizes;
                } else {
                    int i10 = c0083a3.f5996a;
                    int i11 = c0083a3.f5997b;
                    list = supportedVideoSizes;
                    if (i10 * i11 >= c0083a5.f5996a * c0083a5.f5997b && i10 * i11 <= 921600) {
                        c0083a5.f5996a = i10;
                        c0083a5.f5997b = i11;
                        c0083a6.f5997b = c0083a4.f5997b;
                        c0083a6.f5996a = c0083a4.f5996a;
                    }
                }
                i7++;
                supportedVideoSizes = list;
                f3 = 0.01f;
            }
            List<Camera.Size> list2 = supportedVideoSizes;
            int i12 = c0083a3.f5996a;
            int i13 = c0083a3.f5997b;
            if (i12 * i13 >= c0083a7.f5996a * c0083a7.f5997b && i12 * i13 <= 921600) {
                c0083a7.f5996a = i12;
                c0083a7.f5997b = i13;
            }
            i4++;
            supportedVideoSizes = list2;
            i3 = 921600;
        }
        if (c0083a2.f5996a > 0) {
            return c0083a2;
        }
        if (c0083a5.f5996a > 0) {
            C0083a c0083a8 = this.f5995h;
            c0083a8.f5997b = c0083a6.f5997b;
            c0083a8.f5996a = c0083a6.f5996a;
            return c0083a5;
        }
        return c0083a7;
    }

    private void a(Activity activity) {
        Camera camera = this.f5992e;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters));
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            int i = 0;
            if (rotation != 0) {
                if (rotation == 1) {
                    i = 90;
                } else if (rotation == 2) {
                    i = 180;
                } else if (rotation == 3) {
                    i = 270;
                }
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(l, cameraInfo);
            if (cameraInfo.facing == 1) {
                int i2 = (cameraInfo.orientation + i) % 360;
                this.m = i2;
                this.m = (360 - i2) % 360;
            } else {
                this.m = ((cameraInfo.orientation - i) + 360) % 360;
            }
            this.f5992e.setDisplayOrientation(this.m);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.n) {
                    this.j = "off";
                    parameters.setFlashMode("off");
                } else {
                    parameters.setFlashMode(this.j);
                }
            } else {
                this.j = "off";
            }
            this.f5992e.setParameters(parameters);
        }
    }

    private C0083a a(Activity activity, Camera.Parameters parameters) {
        C0083a b2 = b(activity, parameters);
        this.f5995h = new C0083a(b2.f5996a, b2.f5997b);
        if (this.p) {
            this.i = b(this.f5992e.getParameters(), b2);
        }
        C0083a c0083a = this.f5995h;
        parameters.setPreviewSize(c0083a.f5996a, c0083a.f5997b);
        return this.f5995h;
    }

    public void a(Camera.Parameters parameters, C0083a c0083a) {
        int i;
        int i2;
        float f2 = c0083a != null ? c0083a.f5996a / c0083a.f5997b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes == null) {
            return;
        }
        int size = supportedPictureSizes.size();
        Camera.Size size2 = null;
        Camera.Size size3 = null;
        for (int i3 = 0; i3 < size; i3++) {
            Camera.Size size4 = supportedPictureSizes.get(i3);
            if (size3 == null || ((i = size4.width) >= size3.width && (i2 = size4.height) >= size3.height && i * i2 < 5000000)) {
                size3 = size4;
            }
            if (f2 > 0.0f && Math.abs((size4.width / size4.height) - f2) < 0.15f) {
                int i4 = size4.width;
                int i5 = size4.height;
                if (i4 * i5 < 7000000 && (size2 == null || (i4 > size2.width && i5 > size2.height))) {
                    size2 = size4;
                }
            }
        }
        if (size2 == null) {
            size2 = size3;
        }
        parameters.setPictureSize(size2.width, size2.height);
    }

    public void a(Context context, SurfaceHolder surfaceHolder) {
        Camera camera = this.f5992e;
        if (camera != null) {
            try {
                this.f5994g = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f5992e.startPreview();
            } catch (Throwable th) {
                d.a(th);
            }
            this.k = true;
        }
    }

    public boolean a(Context context) {
        if (this.p) {
            try {
                if (this.f5993f == null) {
                    this.f5993f = new MediaRecorder();
                } else {
                    this.f5993f.reset();
                }
                this.f5992e.unlock();
                this.f5993f.setCamera(this.f5992e);
                this.f5993f.setVideoSource(1);
                this.f5993f.setAudioSource(1);
                this.f5993f.setOutputFormat(2);
                this.f5993f.setVideoEncodingBitRate(c.a().b(context));
                this.f5993f.setVideoEncoder(2);
                this.f5993f.setAudioEncoder(3);
                this.f5993f.setVideoSize(this.i.f5996a, this.i.f5997b);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(l, cameraInfo);
                this.f5993f.setOrientationHint(cameraInfo.orientation);
                File file = new File(g.a(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                String b2 = g.b(context);
                g.b(b2);
                this.f5993f.setOutputFile(new File(b2).getAbsolutePath());
                this.f5993f.prepare();
                this.f5993f.start();
                this.o = true;
                return true;
            } catch (Exception e2) {
                d.a(e2);
                e();
                this.o = false;
                return false;
            }
        }
        return false;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f5992e;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
