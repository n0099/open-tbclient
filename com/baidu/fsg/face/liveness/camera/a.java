package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.beans.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1721a = 480;
    public static final int b = 640;
    private static final String c = "CameraControl";
    private static final float d = 0.2f;
    private static int l = -1;
    private Camera e;
    private MediaRecorder f;
    private SurfaceHolder g;
    private C0131a h;
    private C0131a i;
    private int m;
    private String j = "on";
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
                this.m = (i + cameraInfo.orientation) % EncoderTextureDrawer.X264_WIDTH;
                this.m = (360 - this.m) % EncoderTextureDrawer.X264_WIDTH;
            } else {
                this.m = ((cameraInfo.orientation - i) + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
            }
            this.e.setDisplayOrientation(this.m);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.n) {
                    this.j = "off";
                    parameters.setFlashMode(this.j);
                } else {
                    parameters.setFlashMode(this.j);
                }
            } else {
                this.j = "off";
            }
            this.e.setParameters(parameters);
        }
    }

    private C0131a a(Activity activity, Camera.Parameters parameters) {
        C0131a b2 = b(activity, parameters);
        this.h = new C0131a(b2.f1722a, b2.b);
        if (this.p) {
            this.i = b(this.e.getParameters(), b2);
        }
        parameters.setPreviewSize(this.h.f1722a, this.h.b);
        return this.h;
    }

    private C0131a b(Activity activity, Camera.Parameters parameters) {
        List<C0131a> c2 = c(activity, parameters);
        C0131a c0131a = new C0131a(640, 480);
        if (c2 == null || c2.size() == 0) {
            return c0131a;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0131a c0131a2 = new C0131a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        float f = c0131a2.b / c0131a2.f1722a;
        int i = 0;
        C0131a c0131a3 = c0131a;
        float f2 = c0131a.f1722a / c0131a.b;
        while (true) {
            int i2 = i;
            if (i2 < c2.size()) {
                C0131a c0131a4 = c2.get(i2);
                float abs = Math.abs((c0131a4.f1722a / c0131a4.b) - f);
                if (abs < f2) {
                    f2 = abs;
                    c0131a3 = c0131a4;
                }
                i = i2 + 1;
            } else {
                return c0131a3;
            }
        }
    }

    private List<C0131a> c(Activity activity, Camera.Parameters parameters) {
        int i;
        int i2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        C0131a c0131a = new C0131a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        if ((c0131a.f1722a * c0131a.b) / 4 <= 921600) {
            i = 153600;
            i2 = 921600;
        } else {
            i = (c0131a.f1722a * c0131a.b) / 8;
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
                arrayList.add(new C0131a(size.width, size.height));
            }
            i3 = i4 + 1;
        }
    }

    public void a(Camera.Parameters parameters, C0131a c0131a) {
        Camera.Size size = null;
        float f = c0131a != null ? c0131a.f1722a / c0131a.b : 0.0f;
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
                this.f.setVideoSize(this.i.f1722a, this.i.b);
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
            }
        } catch (Exception e) {
            d.a(e);
        }
    }

    private C0131a b(Camera.Parameters parameters, C0131a c0131a) {
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes != null && supportedVideoSizes.size() != 0 && supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
            float f = c0131a.b / c0131a.f1722a;
            C0131a c0131a2 = new C0131a(0, 0);
            C0131a c0131a3 = new C0131a(0, 0);
            C0131a c0131a4 = new C0131a(0, 0);
            C0131a c0131a5 = new C0131a(0, 0);
            C0131a c0131a6 = new C0131a(0, 0);
            C0131a c0131a7 = new C0131a(0, 0);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < supportedVideoSizes.size()) {
                    Camera.Size size = supportedVideoSizes.get(i2);
                    c0131a3.f1722a = size.width;
                    c0131a3.b = size.height;
                    if (c0131a3.f1722a == c0131a.f1722a && c0131a3.b == c0131a.b) {
                        c0131a2.f1722a = c0131a3.f1722a;
                        c0131a2.b = c0131a3.b;
                        return c0131a2;
                    }
                    if (Math.abs((size.height / size.width) - f) < 0.01f && c0131a3.f1722a >= c0131a2.f1722a && c0131a3.b >= c0131a2.b && c0131a3.f1722a * c0131a3.b <= 921600) {
                        c0131a2.f1722a = c0131a3.f1722a;
                        c0131a2.b = c0131a3.b;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= supportedPreviewSizes.size()) {
                            break;
                        }
                        Camera.Size size2 = supportedPreviewSizes.get(i4);
                        c0131a4.f1722a = size2.width;
                        c0131a4.b = size2.height;
                        if (((c0131a3.f1722a == c0131a4.f1722a && c0131a3.b == c0131a4.b) || Math.abs((c0131a4.b / c0131a4.f1722a) - (c0131a3.b / c0131a3.f1722a)) < 0.01f) && c0131a3.f1722a * c0131a3.b >= c0131a5.f1722a * c0131a5.b && c0131a3.f1722a * c0131a3.b <= 921600) {
                            c0131a5.f1722a = c0131a3.f1722a;
                            c0131a5.b = c0131a3.b;
                            c0131a6.b = c0131a4.b;
                            c0131a6.f1722a = c0131a4.f1722a;
                        }
                        i3 = i4 + 1;
                    }
                    if (c0131a3.f1722a * c0131a3.b >= c0131a7.f1722a * c0131a7.b && c0131a3.f1722a * c0131a3.b <= 921600) {
                        c0131a7.f1722a = c0131a3.f1722a;
                        c0131a7.b = c0131a3.b;
                    }
                    i = i2 + 1;
                } else if (c0131a2.f1722a > 0) {
                    return c0131a2;
                } else {
                    if (c0131a5.f1722a > 0) {
                        this.h.b = c0131a6.b;
                        this.h.f1722a = c0131a6.f1722a;
                        return c0131a5;
                    }
                    return c0131a7;
                }
            }
        } else {
            return c0131a;
        }
    }

    public C0131a f() {
        return this.h;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.e != null) {
            this.e.setPreviewCallback(previewCallback);
        }
    }

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0131a {

        /* renamed from: a  reason: collision with root package name */
        public int f1722a;
        public int b;

        public C0131a(int i, int i2) {
            this.f1722a = i;
            this.b = i2;
        }
    }
}
