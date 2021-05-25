package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.video.e;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5917a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5918b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5919c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5920d = 480;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5921e = 640;

    /* renamed from: i  reason: collision with root package name */
    public static int f5922i = 0;
    public static final String j = "CameraInterface";
    public static final float k = 0.2f;
    public static int o = -1;

    /* renamed from: f  reason: collision with root package name */
    public Camera f5923f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f5924g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceHolder f5925h;
    public a l;
    public String m = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    public boolean n = false;
    public boolean p = true;
    public int q = 2;
    public boolean r = true;
    public boolean s = false;
    public com.baidu.fsg.face.liveness.video.a t;
    public e u;
    public boolean v;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5927a;

        /* renamed from: b  reason: collision with root package name */
        public int f5928b;

        public a(int i2, int i3) {
            this.f5927a = i2;
            this.f5928b = i3;
        }
    }

    public void b() {
        Camera camera = this.f5923f;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public void c() {
        LogUtil.d("调用 stopPreview");
        if (this.f5923f != null) {
            if (this.v && this.s) {
                f();
            }
            this.f5923f.stopPreview();
        }
    }

    public synchronized void d() {
        LogUtil.d("调用 doStopCamera");
        try {
            if (this.v && this.s) {
                f();
            }
            if (this.f5925h != null && Build.VERSION.SDK_INT >= 14) {
                this.f5925h.getSurface().release();
            }
            if (this.f5923f != null) {
                this.f5923f.setPreviewCallback(null);
                this.f5923f.stopPreview();
                this.f5923f.release();
                this.n = false;
                this.f5923f = null;
            }
            this.p = true;
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public boolean e() {
        return this.s;
    }

    public void f() {
        LogUtil.d("调用 stopRecordVideo");
        this.s = false;
        com.baidu.fsg.face.liveness.video.a aVar = this.t;
        if (aVar != null) {
            aVar.g();
            this.t = null;
        }
    }

    public synchronized void g() {
        try {
            if (this.f5924g != null && this.r) {
                this.f5924g.stop();
                this.f5924g.reset();
                this.f5924g.release();
                this.f5924g = null;
            }
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public boolean h() {
        if (a() == 1) {
            this.p = false;
        }
        return this.p;
    }

    public a i() {
        return this.l;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public boolean b(Activity activity) {
        try {
            if (this.f5923f == null) {
                a(activity, 1);
            }
            if (this.f5923f == null) {
                this.r = false;
                return false;
            }
            if (this.f5924g == null) {
                this.f5924g = new MediaRecorder();
            } else {
                this.f5924g.reset();
            }
            Camera.Parameters parameters = this.f5923f.getParameters();
            a a2 = a(activity, parameters, this.l);
            Camera camera = this.f5923f;
            camera.getClass();
            Camera.Size size = new Camera.Size(camera, a2.f5927a, a2.f5928b);
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null && supportedPreviewSizes.contains(size)) {
                parameters.setPreviewSize(a2.f5927a, a2.f5928b);
            }
            this.f5923f.setParameters(parameters);
            this.f5923f.unlock();
            this.f5924g.setCamera(this.f5923f);
            this.f5924g.setVideoSource(1);
            this.f5924g.setAudioSource(1);
            this.f5924g.setOutputFormat(2);
            this.f5924g.setVideoEncodingBitRate(1048576);
            this.f5924g.setVideoEncoder(2);
            this.f5924g.setAudioEncoder(3);
            this.f5924g.setVideoSize(a2.f5927a, a2.f5928b);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(o, cameraInfo);
            this.f5924g.setOrientationHint(cameraInfo.orientation);
            File file = new File(g.a(activity));
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f5924g.setOutputFile(new File(g.b(activity)).getAbsolutePath());
            this.f5924g.prepare();
            this.f5924g.start();
            this.r = true;
            return true;
        } catch (Exception e2) {
            d.a(e2);
            g();
            this.r = false;
            return false;
        }
    }

    public boolean a(Activity activity, int i2) {
        LogUtil.d("调用 doOpenCamera");
        this.q = i2;
        Camera camera = this.f5923f;
        if (camera != null) {
            camera.stopPreview();
            this.f5923f.release();
            this.f5923f = null;
        }
        if (a() == 1) {
            this.p = false;
        }
        if (this.p) {
            o = 1;
        } else {
            o = 0;
        }
        try {
            this.f5923f = Camera.open(o);
            a(activity);
            return true;
        } catch (Throwable th) {
            d.a(th);
            Camera camera2 = this.f5923f;
            if (camera2 != null) {
                camera2.release();
                this.f5923f = null;
            }
            return false;
        }
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        LogUtil.d("调用 doStartPreview");
        Camera camera = this.f5923f;
        if (camera != null) {
            try {
                this.f5925h = surfaceHolder;
                camera.setPreviewDisplay(surfaceHolder);
                this.f5923f.startPreview();
            } catch (Throwable th) {
                d.a(th);
            }
            this.n = true;
        }
    }

    public int a() {
        return Camera.getNumberOfCameras();
    }

    public void a(byte[] bArr) {
        if (this.v && this.u != null && this.s) {
            this.u.a(bArr, System.nanoTime() / 1000);
        }
    }

    public void a(Context context) {
        LogUtil.d("调用 startRecordVideo");
        if (this.s) {
            return;
        }
        this.s = true;
        com.baidu.fsg.face.liveness.video.b bVar = new com.baidu.fsg.face.liveness.video.b() { // from class: com.baidu.fsg.face.liveness.camera.b.1
            @Override // com.baidu.fsg.face.liveness.video.b
            public void a(e eVar) {
                b.this.u = eVar;
            }

            @Override // com.baidu.fsg.face.liveness.video.b
            public void b(e eVar) {
                b.this.u = null;
            }

            @Override // com.baidu.fsg.face.liveness.video.b
            public int c() {
                return 270;
            }

            @Override // com.baidu.fsg.face.liveness.video.b
            public int a() {
                return b.this.l.f5927a;
            }

            @Override // com.baidu.fsg.face.liveness.video.b
            public int b() {
                return b.this.l.f5928b;
            }
        };
        String c2 = g.c(context);
        File file = new File(c2);
        try {
            g.a(file);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.e("CameraInterface", "创建保存视频路径失败:", e2);
        }
        com.baidu.fsg.face.liveness.video.a aVar = new com.baidu.fsg.face.liveness.video.a(c2, bVar);
        this.t = aVar;
        aVar.f();
    }

    private a b(Activity activity, Camera.Parameters parameters) {
        a aVar = this.l;
        if (aVar != null) {
            return aVar;
        }
        List<a> a2 = a(activity, parameters);
        this.l = new a(640, 480);
        if (a2 != null && a2.size() != 0) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a aVar2 = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            float f2 = aVar2.f5928b / aVar2.f5927a;
            a aVar3 = this.l;
            float f3 = aVar3.f5927a / aVar3.f5928b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar2.f5927a + "*" + aVar2.f5928b);
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append("");
            arrayList.add(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a aVar4 = a2.get(i2);
                int i3 = aVar4.f5927a;
                float f4 = i3 / aVar4.f5928b;
                sb2.append(i3);
                sb2.append("*");
                sb2.append(aVar4.f5928b);
                sb2.append("*");
                sb2.append(f4);
                sb2.append("-");
                float abs = Math.abs(f4 - f2);
                if (abs < f3) {
                    this.l = aVar4;
                    f3 = abs;
                }
            }
            arrayList.add(sb2.length() > 1 ? sb2.substring(0, sb2.length() - 1) : "");
            RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.G, arrayList);
            return this.l;
        }
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity) {
        int i2;
        int i3;
        Camera camera = this.f5923f;
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
                    Camera.getCameraInfo(o, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        int i4 = (cameraInfo.orientation + i2) % 360;
                        f5922i = i4;
                        f5922i = (360 - i4) % 360;
                    } else {
                        f5922i = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    this.f5923f.setDisplayOrientation(f5922i);
                } else if (i3 == 8) {
                    int i5 = ((90 - i2) + 360) % 360;
                    f5922i = i5;
                    this.f5923f.setDisplayOrientation(i5);
                } else {
                    f5922i = ((90 - i2) + 360) % 360;
                    try {
                        Method method = this.f5923f.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                        if (method != null) {
                            method.invoke(this.f5923f, Integer.valueOf(f5922i));
                        }
                    } catch (Exception e2) {
                        d.a(e2);
                    }
                }
                if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                if (parameters.getSupportedFlashModes() == null) {
                    if (this.p) {
                        this.m = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    } else {
                        parameters.setFlashMode(this.m);
                    }
                } else {
                    this.m = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                this.f5923f.setParameters(parameters);
            }
            i2 = 0;
            i3 = Build.VERSION.SDK_INT;
            if (i3 < 9) {
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            }
            if (parameters.getSupportedFlashModes() == null) {
            }
            this.f5923f.setParameters(parameters);
        }
    }

    private a a(Context context, Camera.Parameters parameters, a aVar) {
        int i2;
        int i3;
        int i4;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes == null || supportedVideoSizes.size() == 0 || supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return aVar;
        }
        float f2 = aVar.f5928b / aVar.f5927a;
        a aVar2 = new a(0, 0);
        a aVar3 = new a(0, 0);
        a aVar4 = new a(0, 0);
        a aVar5 = new a(0, 0);
        for (int i5 = 0; i5 < supportedVideoSizes.size(); i5++) {
            Camera.Size size = supportedVideoSizes.get(i5);
            int i6 = size.width;
            aVar3.f5927a = i6;
            int i7 = size.height;
            aVar3.f5928b = i7;
            if (i6 == aVar.f5927a && i7 == aVar.f5928b) {
                aVar2.f5927a = i6;
                aVar2.f5928b = i7;
                return aVar2;
            }
            for (int i8 = 0; i8 < supportedPreviewSizes.size(); i8++) {
                Camera.Size size2 = supportedPreviewSizes.get(i8);
                int i9 = size2.width;
                aVar4.f5927a = i9;
                int i10 = size2.height;
                aVar4.f5928b = i10;
                int i11 = aVar3.f5927a;
                if (i11 == i9 && (i4 = aVar3.f5928b) == i10 && i11 * i4 >= aVar5.f5927a * aVar5.f5928b && i11 * i4 <= 921600) {
                    aVar5.f5927a = i11;
                    aVar5.f5928b = i4;
                }
            }
            if (Math.abs((size.width / size.height) - f2) < 0.01f && (i2 = aVar3.f5927a) >= aVar2.f5927a && (i3 = aVar3.f5928b) >= aVar2.f5928b) {
                if (i2 * i3 <= 921600) {
                    aVar2 = aVar3;
                }
            }
        }
        return aVar5.f5927a > 0 ? aVar5 : aVar2.f5927a > 0 ? aVar2 : aVar4;
    }

    private List<a> a(Activity activity, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        a aVar = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        int i2 = 153600;
        int i3 = 921600;
        int i4 = aVar.f5927a;
        int i5 = aVar.f5928b;
        if ((i4 * i5) / 4 > 921600) {
            i3 = 2073600;
            i2 = (i4 * i5) / 8;
        }
        ArrayList arrayList = new ArrayList();
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.F, i2 + "-" + i3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.f5927a + "*" + aVar.f5928b);
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
            Camera.Size size = supportedPreviewSizes.get(i6);
            sb.append(size.width);
            sb.append("*");
            sb.append(size.height);
            sb.append("-");
            int i7 = size.width;
            int i8 = size.height;
            if (i7 * i8 >= i2 && i7 * i8 <= i3) {
                arrayList.add(new a(i7, i8));
            }
        }
        arrayList2.add(sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "");
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.E, arrayList2);
        return arrayList;
    }

    public a a(Activity activity, Camera.Parameters parameters, boolean z) {
        a b2 = b(activity, parameters);
        parameters.setPreviewSize(b2.f5927a, b2.f5928b);
        LogUtil.d("cameraSize.width:" + b2.f5927a + ",cameraSize.height:" + b2.f5928b);
        return b2;
    }

    public void a(Camera.Parameters parameters, a aVar) {
        int i2;
        int i3;
        float f2 = aVar != null ? aVar.f5927a / aVar.f5928b : 0.0f;
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
        if (this.f5923f != null) {
            this.f5923f.setPreviewCallbackWithBuffer(previewCallback);
            this.f5923f.addCallbackBuffer(new byte[((i().f5927a * i().f5928b) * ImageFormat.getBitsPerPixel(this.f5923f.getParameters().getPreviewFormat())) / 8]);
        }
    }
}
