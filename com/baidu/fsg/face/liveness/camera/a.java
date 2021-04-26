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
import kotlinx.coroutines.DebugKt;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6152a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6153b = 640;

    /* renamed from: c  reason: collision with root package name */
    public static final String f6154c = "CameraControl";

    /* renamed from: d  reason: collision with root package name */
    public static final float f6155d = 0.2f;
    public static int l = -1;

    /* renamed from: e  reason: collision with root package name */
    public Camera f6156e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f6157f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f6158g;

    /* renamed from: h  reason: collision with root package name */
    public C0083a f6159h;

    /* renamed from: i  reason: collision with root package name */
    public C0083a f6160i;
    public int m;
    public String j = DebugKt.DEBUG_PROPERTY_VALUE_ON;
    public boolean k = false;
    public boolean n = true;
    public boolean o = true;
    public boolean p = false;

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        public int f6161a;

        /* renamed from: b  reason: collision with root package name */
        public int f6162b;

        public C0083a(int i2, int i3) {
            this.f6161a = i2;
            this.f6162b = i3;
        }
    }

    private C0083a b(Activity activity, Camera.Parameters parameters) {
        List<C0083a> c2 = c(activity, parameters);
        C0083a c0083a = new C0083a(640, 480);
        if (c2 != null && c2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C0083a c0083a2 = new C0083a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            float f2 = c0083a2.f6162b / c0083a2.f6161a;
            float f3 = c0083a.f6161a / c0083a.f6162b;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                C0083a c0083a3 = c2.get(i2);
                float abs = Math.abs((c0083a3.f6161a / c0083a3.f6162b) - f2);
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
        int i2 = 153600;
        int i3 = 921600;
        int i4 = c0083a.f6161a;
        int i5 = c0083a.f6162b;
        if ((i4 * i5) / 4 > 921600) {
            i3 = 2073600;
            i2 = (i4 * i5) / 8;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
            Camera.Size size = supportedPreviewSizes.get(i6);
            int i7 = size.width;
            int i8 = size.height;
            if (i7 * i8 >= i2 && i7 * i8 <= i3) {
                arrayList.add(new C0083a(i7, i8));
            }
        }
        return arrayList;
    }

    public boolean a(Activity activity, boolean z) {
        this.p = z;
        Camera camera = this.f6156e;
        if (camera != null) {
            camera.stopPreview();
            this.f6156e.release();
            this.f6156e = null;
        }
        try {
            if (a()) {
                l = 1;
            } else {
                l = 0;
            }
            this.f6156e = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            d.a(th);
            Camera camera2 = this.f6156e;
            if (camera2 != null) {
                camera2.release();
                this.f6156e = null;
            }
            return false;
        }
    }

    public synchronized void d() {
        try {
            if (this.f6158g != null && Build.VERSION.SDK_INT >= 14) {
                this.f6158g.getSurface().release();
            }
            if (this.f6156e != null) {
                this.f6156e.setPreviewCallback(null);
                this.f6156e.stopPreview();
                this.f6156e.release();
                this.k = false;
                this.f6156e = null;
            }
            this.n = true;
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public synchronized void e() {
        try {
            if (this.f6157f != null && this.o) {
                this.f6157f.reset();
                this.f6157f.release();
                this.f6157f = null;
            }
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public C0083a f() {
        return this.f6159h;
    }

    public void b() {
        Camera camera = this.f6156e;
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
        Camera camera = this.f6156e;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    private C0083a b(Camera.Parameters parameters, C0083a c0083a) {
        List<Camera.Size> list;
        int i2;
        int i3;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
            return c0083a;
        }
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return c0083a;
        }
        float f2 = c0083a.f6162b / c0083a.f6161a;
        C0083a c0083a2 = new C0083a(0, 0);
        C0083a c0083a3 = new C0083a(0, 0);
        C0083a c0083a4 = new C0083a(0, 0);
        C0083a c0083a5 = new C0083a(0, 0);
        C0083a c0083a6 = new C0083a(0, 0);
        int i4 = 921600;
        C0083a c0083a7 = new C0083a(0, 0);
        int i5 = 0;
        while (i5 < supportedVideoSizes.size()) {
            Camera.Size size = supportedVideoSizes.get(i5);
            int i6 = size.width;
            c0083a3.f6161a = i6;
            int i7 = size.height;
            c0083a3.f6162b = i7;
            if (i6 == c0083a.f6161a && i7 == c0083a.f6162b) {
                c0083a2.f6161a = i6;
                c0083a2.f6162b = i7;
                return c0083a2;
            }
            float f3 = 0.01f;
            if (Math.abs((size.height / size.width) - f2) < 0.01f && (i2 = c0083a3.f6161a) >= c0083a2.f6161a && (i3 = c0083a3.f6162b) >= c0083a2.f6162b && i2 * i3 <= i4) {
                c0083a2.f6161a = i2;
                c0083a2.f6162b = i3;
            }
            int i8 = 0;
            while (i8 < supportedPreviewSizes.size()) {
                Camera.Size size2 = supportedPreviewSizes.get(i8);
                int i9 = size2.width;
                c0083a4.f6161a = i9;
                int i10 = size2.height;
                c0083a4.f6162b = i10;
                if (!(c0083a3.f6161a == i9 && c0083a3.f6162b == i10) && Math.abs((c0083a4.f6162b / c0083a4.f6161a) - (c0083a3.f6162b / c0083a3.f6161a)) >= f3) {
                    list = supportedVideoSizes;
                } else {
                    int i11 = c0083a3.f6161a;
                    int i12 = c0083a3.f6162b;
                    list = supportedVideoSizes;
                    if (i11 * i12 >= c0083a5.f6161a * c0083a5.f6162b && i11 * i12 <= 921600) {
                        c0083a5.f6161a = i11;
                        c0083a5.f6162b = i12;
                        c0083a6.f6162b = c0083a4.f6162b;
                        c0083a6.f6161a = c0083a4.f6161a;
                    }
                }
                i8++;
                supportedVideoSizes = list;
                f3 = 0.01f;
            }
            List<Camera.Size> list2 = supportedVideoSizes;
            int i13 = c0083a3.f6161a;
            int i14 = c0083a3.f6162b;
            if (i13 * i14 >= c0083a7.f6161a * c0083a7.f6162b && i13 * i14 <= 921600) {
                c0083a7.f6161a = i13;
                c0083a7.f6162b = i14;
            }
            i5++;
            supportedVideoSizes = list2;
            i4 = 921600;
        }
        if (c0083a2.f6161a > 0) {
            return c0083a2;
        }
        if (c0083a5.f6161a > 0) {
            C0083a c0083a8 = this.f6159h;
            c0083a8.f6162b = c0083a6.f6162b;
            c0083a8.f6161a = c0083a6.f6161a;
            return c0083a5;
        }
        return c0083a7;
    }

    private void a(Activity activity) {
        Camera camera = this.f6156e;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters));
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            int i2 = 0;
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(l, cameraInfo);
            if (cameraInfo.facing == 1) {
                int i3 = (cameraInfo.orientation + i2) % 360;
                this.m = i3;
                this.m = (360 - i3) % 360;
            } else {
                this.m = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            this.f6156e.setDisplayOrientation(this.m);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.n) {
                    this.j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                } else {
                    parameters.setFlashMode(this.j);
                }
            } else {
                this.j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            this.f6156e.setParameters(parameters);
        }
    }

    private C0083a a(Activity activity, Camera.Parameters parameters) {
        C0083a b2 = b(activity, parameters);
        this.f6159h = new C0083a(b2.f6161a, b2.f6162b);
        if (this.p) {
            this.f6160i = b(this.f6156e.getParameters(), b2);
        }
        C0083a c0083a = this.f6159h;
        parameters.setPreviewSize(c0083a.f6161a, c0083a.f6162b);
        return this.f6159h;
    }

    public void a(Camera.Parameters parameters, C0083a c0083a) {
        int i2;
        int i3;
        float f2 = c0083a != null ? c0083a.f6161a / c0083a.f6162b : 0.0f;
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

    public void a(Context context, SurfaceHolder surfaceHolder) {
        Camera camera = this.f6156e;
        if (camera != null) {
            try {
                this.f6158g = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f6156e.startPreview();
            } catch (Throwable th) {
                d.a(th);
            }
            this.k = true;
        }
    }

    public boolean a(Context context) {
        if (this.p) {
            try {
                if (this.f6157f == null) {
                    this.f6157f = new MediaRecorder();
                } else {
                    this.f6157f.reset();
                }
                this.f6156e.unlock();
                this.f6157f.setCamera(this.f6156e);
                this.f6157f.setVideoSource(1);
                this.f6157f.setAudioSource(1);
                this.f6157f.setOutputFormat(2);
                this.f6157f.setVideoEncodingBitRate(c.a().b(context));
                this.f6157f.setVideoEncoder(2);
                this.f6157f.setAudioEncoder(3);
                this.f6157f.setVideoSize(this.f6160i.f6161a, this.f6160i.f6162b);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(l, cameraInfo);
                this.f6157f.setOrientationHint(cameraInfo.orientation);
                File file = new File(g.a(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                String b2 = g.b(context);
                g.b(b2);
                this.f6157f.setOutputFile(new File(b2).getAbsolutePath());
                this.f6157f.prepare();
                this.f6157f.start();
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
        Camera camera = this.f6156e;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }
}
