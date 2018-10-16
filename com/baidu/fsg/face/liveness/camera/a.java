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
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static final int a = 480;
    public static final int b = 640;
    private static final String c = "CameraControl";
    private static final float d = 0.2f;
    private static int l = -1;
    private Camera e;
    private MediaRecorder f;
    private SurfaceHolder g;
    private C0079a h;
    private C0079a i;
    private int m;
    private String j = ARCameraAttr.FlashType.FLASH_ON;
    private boolean k = false;
    private boolean n = true;
    private boolean o = true;
    private boolean p = false;

    public boolean a(Activity activity, boolean z) {
        this.p = z;
        if (this.e != null) {
            this.e.stopPreview();
            this.e.release();
            this.e = null;
        }
        try {
            if (a()) {
                l = 1;
            } else {
                l = 0;
            }
            this.e = Camera.open(l);
            a(activity);
            return true;
        } catch (Throwable th) {
            d.a(th);
            if (this.e != null) {
                this.e.release();
                this.e = null;
            }
            return false;
        }
    }

    public boolean a() {
        if (Camera.getNumberOfCameras() == 1) {
            this.n = false;
        }
        return this.n;
    }

    private void a(Activity activity) {
        int i = 0;
        if (this.e != null) {
            Camera.Parameters parameters = this.e.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters));
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
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(l, cameraInfo);
            if (cameraInfo.facing == 1) {
                this.m = (i + cameraInfo.orientation) % 360;
                this.m = (360 - this.m) % 360;
            } else {
                this.m = ((cameraInfo.orientation - i) + 360) % 360;
            }
            this.e.setDisplayOrientation(this.m);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.n) {
                    this.j = ARCameraAttr.FlashType.FLASH_OFF;
                    parameters.setFlashMode(this.j);
                } else {
                    parameters.setFlashMode(this.j);
                }
            } else {
                this.j = ARCameraAttr.FlashType.FLASH_OFF;
            }
            this.e.setParameters(parameters);
        }
    }

    private C0079a a(Activity activity, Camera.Parameters parameters) {
        C0079a b2 = b(activity, parameters);
        this.h = new C0079a(b2.a, b2.b);
        if (this.p) {
            this.i = b(this.e.getParameters(), b2);
        }
        parameters.setPreviewSize(this.h.a, this.h.b);
        return this.h;
    }

    private C0079a b(Activity activity, Camera.Parameters parameters) {
        List<C0079a> c2 = c(activity, parameters);
        C0079a c0079a = new C0079a(640, 480);
        if (c2 == null || c2.size() == 0) {
            return c0079a;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
        C0079a c0079a2 = new C0079a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        float f = c0079a2.b / c0079a2.a;
        int i = 0;
        C0079a c0079a3 = c0079a;
        float f2 = c0079a.a / c0079a.b;
        while (true) {
            int i2 = i;
            if (i2 < c2.size()) {
                C0079a c0079a4 = c2.get(i2);
                float abs = Math.abs((c0079a4.a / c0079a4.b) - f);
                if (abs < f2) {
                    f2 = abs;
                    c0079a3 = c0079a4;
                }
                i = i2 + 1;
            } else {
                return c0079a3;
            }
        }
    }

    private List<C0079a> c(Activity activity, Camera.Parameters parameters) {
        int i;
        int i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
        C0079a c0079a = new C0079a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        if ((c0079a.a * c0079a.b) / 4 <= 921600) {
            i = 153600;
            i2 = 921600;
        } else {
            i = (c0079a.a * c0079a.b) / 8;
            i2 = 2073600;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= supportedPreviewSizes.size()) {
                return arrayList;
            }
            Camera.Size size = supportedPreviewSizes.get(i4);
            if (size.width * size.height >= i && size.width * size.height <= i2) {
                arrayList.add(new C0079a(size.width, size.height));
            }
            i3 = i4 + 1;
        }
    }

    public void a(Camera.Parameters parameters, C0079a c0079a) {
        Camera.Size size = null;
        float f = c0079a != null ? c0079a.a / c0079a.b : 0.0f;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            int size2 = supportedPictureSizes.size();
            int i = 0;
            Camera.Size size3 = null;
            while (i < size2) {
                Camera.Size size4 = supportedPictureSizes.get(i);
                if (size3 == null) {
                    size3 = size4;
                } else if (size4.width >= size3.width && size4.height >= size3.height && size4.width * size4.height < 5000000) {
                    size3 = size4;
                }
                if (f <= 0.0f || Math.abs((size4.width / size4.height) - f) >= 0.15f || size4.width * size4.height >= 7000000 || (size != null && (size4.width <= size.width || size4.height <= size.height))) {
                    size4 = size;
                }
                i++;
                size = size4;
            }
            if (size == null) {
                size = size3;
            }
            parameters.setPictureSize(size.width, size.height);
        }
    }

    public void a(Context context, SurfaceHolder surfaceHolder) {
        if (this.e != null) {
            try {
                this.g = surfaceHolder;
                this.e.setPreviewDisplay(surfaceHolder);
                this.e.startPreview();
            } catch (Throwable th) {
                d.a(th);
            }
            this.k = true;
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.startPreview();
        }
    }

    public void c() {
        if (this.e != null) {
            this.e.stopPreview();
        }
    }

    public synchronized void d() {
        try {
            if (this.g != null && Build.VERSION.SDK_INT >= 14) {
                this.g.getSurface().release();
            }
            if (this.e != null) {
                this.e.setPreviewCallback(null);
                this.e.stopPreview();
                this.e.release();
                this.k = false;
                this.e = null;
            }
            this.n = true;
        } catch (Exception e) {
            d.a(e);
        }
    }

    public boolean a(Context context) {
        if (this.p) {
            try {
                if (this.f == null) {
                    this.f = new MediaRecorder();
                } else {
                    this.f.reset();
                }
                this.e.unlock();
                this.f.setCamera(this.e);
                this.f.setVideoSource(1);
                this.f.setAudioSource(1);
                this.f.setOutputFormat(2);
                this.f.setVideoEncodingBitRate(c.a().b(context));
                this.f.setVideoEncoder(2);
                this.f.setAudioEncoder(3);
                this.f.setVideoSize(this.i.a, this.i.b);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(l, cameraInfo);
                this.f.setOrientationHint(cameraInfo.orientation);
                File file = new File(g.a(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                String b2 = g.b(context);
                g.b(b2);
                this.f.setOutputFile(new File(b2).getAbsolutePath());
                this.f.prepare();
                this.f.start();
                this.o = true;
                return true;
            } catch (Exception e) {
                d.a(e);
                if (this.e != null) {
                    this.e.lock();
                }
                e();
                this.o = false;
                return false;
            }
        }
        return false;
    }

    public synchronized void e() {
        try {
            if (this.f != null && this.o) {
                this.f.reset();
                this.f.release();
                this.f = null;
            }
            if (this.e != null) {
                this.e.lock();
            }
        } catch (Exception e) {
            d.a(e);
        }
    }

    private C0079a b(Camera.Parameters parameters, C0079a c0079a) {
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes != null && supportedVideoSizes.size() != 0 && supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
            float f = c0079a.b / c0079a.a;
            C0079a c0079a2 = new C0079a(0, 0);
            C0079a c0079a3 = new C0079a(0, 0);
            C0079a c0079a4 = new C0079a(0, 0);
            C0079a c0079a5 = new C0079a(0, 0);
            C0079a c0079a6 = new C0079a(0, 0);
            C0079a c0079a7 = new C0079a(0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < supportedVideoSizes.size()) {
                    Camera.Size size = supportedVideoSizes.get(i2);
                    c0079a3.a = size.width;
                    c0079a3.b = size.height;
                    if (c0079a3.a == c0079a.a && c0079a3.b == c0079a.b) {
                        c0079a2.a = c0079a3.a;
                        c0079a2.b = c0079a3.b;
                        return c0079a2;
                    }
                    if (Math.abs((size.height / size.width) - f) < 0.01f && c0079a3.a >= c0079a2.a && c0079a3.b >= c0079a2.b && c0079a3.a * c0079a3.b <= 921600) {
                        c0079a2.a = c0079a3.a;
                        c0079a2.b = c0079a3.b;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= supportedPreviewSizes.size()) {
                            break;
                        }
                        Camera.Size size2 = supportedPreviewSizes.get(i4);
                        c0079a4.a = size2.width;
                        c0079a4.b = size2.height;
                        if (((c0079a3.a == c0079a4.a && c0079a3.b == c0079a4.b) || Math.abs((c0079a4.b / c0079a4.a) - (c0079a3.b / c0079a3.a)) < 0.01f) && c0079a3.a * c0079a3.b >= c0079a5.a * c0079a5.b && c0079a3.a * c0079a3.b <= 921600) {
                            c0079a5.a = c0079a3.a;
                            c0079a5.b = c0079a3.b;
                            c0079a6.b = c0079a4.b;
                            c0079a6.a = c0079a4.a;
                        }
                        i3 = i4 + 1;
                    }
                    if (c0079a3.a * c0079a3.b >= c0079a7.a * c0079a7.b && c0079a3.a * c0079a3.b <= 921600) {
                        c0079a7.a = c0079a3.a;
                        c0079a7.b = c0079a3.b;
                    }
                    i = i2 + 1;
                } else if (c0079a2.a > 0) {
                    return c0079a2;
                } else {
                    if (c0079a5.a > 0) {
                        this.h.b = c0079a6.b;
                        this.h.a = c0079a6.a;
                        return c0079a5;
                    }
                    return c0079a7;
                }
            }
        } else {
            return c0079a;
        }
    }

    public C0079a f() {
        return this.h;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.e != null) {
            this.e.setPreviewCallback(previewCallback);
        }
    }

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0079a {
        public int a;
        public int b;

        public C0079a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
}
