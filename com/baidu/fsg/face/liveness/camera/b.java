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
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 480;
    public static final int e = 640;
    public static int i = 0;
    private static final String j = "CameraInterface";
    private static final float k = 0.2f;
    private static int o = -1;
    Camera f;
    MediaRecorder g;
    SurfaceHolder h;
    private a l;
    private String m = "off";
    private boolean n = false;
    private boolean p = true;
    private int q = 2;
    private boolean r = true;
    private boolean s = false;
    private com.baidu.fsg.face.liveness.video.a t;
    private e u;
    private boolean v;

    public void a(boolean z) {
        this.v = z;
    }

    public boolean a(Activity activity, int i2) {
        LogUtil.d("调用 doOpenCamera");
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
            o = 1;
        } else {
            o = 0;
        }
        try {
            this.f = Camera.open(o);
            a(activity);
            return true;
        } catch (Throwable th) {
            d.a(th);
            if (this.f != null) {
                this.f.release();
                this.f = null;
            }
            return false;
        }
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        LogUtil.d("调用 doStartPreview");
        if (this.f != null) {
            try {
                this.h = surfaceHolder;
                this.f.setPreviewDisplay(surfaceHolder);
                this.f.startPreview();
            } catch (Throwable th) {
                d.a(th);
            }
            this.n = true;
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
        LogUtil.d("调用 stopPreview");
        if (this.f != null) {
            if (this.v && this.s) {
                f();
            }
            this.f.stopPreview();
        }
    }

    public synchronized void d() {
        LogUtil.d("调用 doStopCamera");
        try {
            if (this.v && this.s) {
                f();
            }
            if (this.h != null && Build.VERSION.SDK_INT >= 14) {
                this.h.getSurface().release();
            }
            if (this.f != null) {
                this.f.setPreviewCallback(null);
                this.f.stopPreview();
                this.f.release();
                this.n = false;
                this.f = null;
            }
            this.p = true;
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    public boolean e() {
        return this.s;
    }

    public void a(byte[] bArr) {
        if (this.v && this.u != null && this.s) {
            this.u.a(bArr, System.nanoTime() / 1000);
        }
    }

    public void f() {
        LogUtil.d("调用 stopRecordVideo");
        this.s = false;
        if (this.t != null) {
            this.t.g();
            this.t = null;
        }
    }

    public void a(Context context) {
        LogUtil.d("调用 startRecordVideo");
        if (!this.s) {
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
                public int a() {
                    return b.this.l.a;
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public int b() {
                    return b.this.l.b;
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public int c() {
                    return 270;
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
                Log.e(j, "创建保存视频路径失败:", e2);
            }
            this.t = new com.baidu.fsg.face.liveness.video.a(c2, bVar);
            this.t.f();
        }
    }

    public void a(Activity activity) {
        int i2 = 0;
        if (this.f != null) {
            Camera.Parameters parameters = this.f.getParameters();
            parameters.setPictureFormat(256);
            parameters.setPreviewFormat(17);
            a(parameters, a(activity, parameters, false));
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(o, cameraInfo);
                if (cameraInfo.facing == 1) {
                    i = (i2 + cameraInfo.orientation) % 360;
                    i = (360 - i) % 360;
                } else {
                    i = ((cameraInfo.orientation - i2) + 360) % 360;
                }
                this.f.setDisplayOrientation(i);
            } else if (Build.VERSION.SDK_INT == 8) {
                i = ((90 - i2) + 360) % 360;
                this.f.setDisplayOrientation(i);
            } else {
                i = ((90 - i2) + 360) % 360;
                try {
                    Method method = this.f.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                    if (method != null) {
                        method.invoke(this.f, Integer.valueOf(i));
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            if (parameters.getSupportedFlashModes() != null) {
                if (this.p) {
                    this.m = "off";
                    parameters.setFlashMode(this.m);
                } else {
                    parameters.setFlashMode(this.m);
                }
            } else {
                this.m = "off";
            }
            this.f.setParameters(parameters);
        }
    }

    public boolean b(Activity activity) {
        try {
            if (this.f == null) {
                a(activity, 1);
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
            a a2 = a(activity, parameters, this.l);
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
            this.g.setVideoEncodingBitRate(1048576);
            this.g.setVideoEncoder(2);
            this.g.setAudioEncoder(3);
            this.g.setVideoSize(a2.a, a2.b);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(o, cameraInfo);
            this.g.setOrientationHint(cameraInfo.orientation);
            File file = new File(g.a(activity));
            if (!file.exists()) {
                file.mkdirs();
            }
            this.g.setOutputFile(new File(g.b(activity)).getAbsolutePath());
            this.g.prepare();
            this.g.start();
            this.r = true;
            return true;
        } catch (Exception e2) {
            d.a(e2);
            if (this.f != null) {
            }
            g();
            this.r = false;
            return false;
        }
    }

    public synchronized void g() {
        try {
            if (this.g != null && this.r) {
                this.g.stop();
                this.g.reset();
                this.g.release();
                this.g = null;
            }
            if (this.f != null) {
            }
        } catch (Exception e2) {
            d.a(e2);
        }
    }

    private a a(Context context, Camera.Parameters parameters, a aVar) {
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
            return aVar;
        }
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return aVar;
        }
        float f = aVar.b / aVar.a;
        a aVar2 = new a(0, 0);
        a aVar3 = new a(0, 0);
        a aVar4 = new a(0, 0);
        a aVar5 = new a(0, 0);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            a aVar6 = aVar2;
            if (i3 >= supportedVideoSizes.size()) {
                return aVar5.a > 0 ? aVar5 : aVar6.a <= 0 ? aVar4 : aVar6;
            }
            Camera.Size size = supportedVideoSizes.get(i3);
            aVar3.a = size.width;
            aVar3.b = size.height;
            if (aVar3.a == aVar.a && aVar3.b == aVar.b) {
                aVar6.a = aVar3.a;
                aVar6.b = aVar3.b;
                return aVar6;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= supportedPreviewSizes.size()) {
                    break;
                }
                Camera.Size size2 = supportedPreviewSizes.get(i5);
                aVar4.a = size2.width;
                aVar4.b = size2.height;
                if (aVar3.a == aVar4.a && aVar3.b == aVar4.b && aVar3.a * aVar3.b >= aVar5.a * aVar5.b && aVar3.a * aVar3.b <= 921600) {
                    aVar5.a = aVar3.a;
                    aVar5.b = aVar3.b;
                }
                i4 = i5 + 1;
            }
            aVar2 = (Math.abs((((float) size.width) / ((float) size.height)) - f) >= 0.01f || aVar3.a < aVar6.a || aVar3.b < aVar6.b || aVar3.a * aVar3.b > 921600) ? aVar6 : aVar3;
            i2 = i3 + 1;
        }
    }

    private List<a> a(Activity activity, Camera.Parameters parameters) {
        int i2;
        int i3;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
            return null;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        a aVar = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        if ((aVar.a * aVar.b) / 4 <= 921600) {
            i2 = 153600;
            i3 = 921600;
        } else {
            i2 = (aVar.a * aVar.b) / 8;
            i3 = 2073600;
        }
        ArrayList arrayList = new ArrayList();
        RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.F, i2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(aVar.a + "*" + aVar.b);
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < supportedPreviewSizes.size(); i4++) {
            Camera.Size size = supportedPreviewSizes.get(i4);
            sb.append(size.width);
            sb.append("*");
            sb.append(size.height);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (size.width * size.height >= i2 && size.width * size.height <= i3) {
                arrayList.add(new a(size.width, size.height));
            }
        }
        arrayList2.add(sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "");
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.E, arrayList2);
        return arrayList;
    }

    private a b(Activity activity, Camera.Parameters parameters) {
        if (this.l != null) {
            return this.l;
        }
        List<a> a2 = a(activity, parameters);
        this.l = new a(640, 480);
        if (a2 == null || a2.size() == 0) {
            return this.l;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        a aVar = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
        float f = aVar.b / aVar.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar.a + "*" + aVar.b);
        arrayList.add(f + "");
        StringBuilder sb = new StringBuilder();
        float f2 = this.l.a / this.l.b;
        for (int i2 = 0; i2 < a2.size(); i2++) {
            a aVar2 = a2.get(i2);
            float f3 = aVar2.a / aVar2.b;
            sb.append(aVar2.a);
            sb.append("*");
            sb.append(aVar2.b);
            sb.append("*");
            sb.append(f3);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            float abs = Math.abs(f3 - f);
            if (abs < f2) {
                this.l = aVar2;
                f2 = abs;
            }
        }
        arrayList.add(sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "");
        RimStatisticsUtil.onEventWithValues(com.baidu.fsg.face.liveness.d.G, arrayList);
        return this.l;
    }

    public a a(Activity activity, Camera.Parameters parameters, boolean z) {
        a b2 = b(activity, parameters);
        parameters.setPreviewSize(b2.a, b2.b);
        LogUtil.d("cameraSize.width:" + b2.a + ",cameraSize.height:" + b2.b);
        return b2;
    }

    public void a(Camera.Parameters parameters, a aVar) {
        Camera.Size size = null;
        float f = aVar != null ? aVar.a / aVar.b : 0.0f;
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

    public boolean h() {
        if (a() == 1) {
            this.p = false;
        }
        return this.p;
    }

    public a i() {
        return this.l;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        if (this.f != null) {
            this.f.setPreviewCallbackWithBuffer(previewCallback);
            this.f.addCallbackBuffer(new byte[((i().a * i().b) * ImageFormat.getBitsPerPixel(this.f.getParameters().getPreviewFormat())) / 8]);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
}
