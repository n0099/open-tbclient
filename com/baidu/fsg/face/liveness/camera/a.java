package com.baidu.fsg.face.liveness.camera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.utils.CameraUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f34524b = 640;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34525c = "CameraControl";

    /* renamed from: d  reason: collision with root package name */
    public static final float f34526d = 0.2f;
    public static int l = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f34527e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f34528f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f34529g;

    /* renamed from: h  reason: collision with root package name */
    public C1822a f34530h;

    /* renamed from: i  reason: collision with root package name */
    public C1822a f34531i;

    /* renamed from: j  reason: collision with root package name */
    public String f34532j;
    public boolean k;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1822a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f34533b;

        public C1822a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f34533b = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-39446361, "Lcom/baidu/fsg/face/liveness/camera/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-39446361, "Lcom/baidu/fsg/face/liveness/camera/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34532j = DebugKt.DEBUG_PROPERTY_VALUE_ON;
        this.k = false;
        this.n = true;
        this.o = true;
        this.p = false;
    }

    private C1822a b(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, parameters)) == null) {
            List<C1822a> c2 = c(activity, parameters);
            C1822a c1822a = new C1822a(640, 480);
            if (c2 != null && c2.size() != 0) {
                Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                C1822a c1822a2 = new C1822a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
                float f2 = c1822a2.f34533b / c1822a2.a;
                float f3 = c1822a.a / c1822a.f34533b;
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    C1822a c1822a3 = c2.get(i2);
                    float abs = Math.abs((c1822a3.a / c1822a3.f34533b) - f2);
                    if (abs < f3) {
                        c1822a = c1822a3;
                        f3 = abs;
                    }
                }
            }
            return c1822a;
        }
        return (C1822a) invokeLL.objValue;
    }

    private List<C1822a> c(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, activity, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return null;
            }
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C1822a c1822a = new C1822a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            int i2 = 153600;
            int i3 = 921600;
            int i4 = c1822a.a;
            int i5 = c1822a.f34533b;
            if ((i4 * i5) / 4 > 921600) {
                i3 = CameraUtils.f34553b;
                i2 = (i4 * i5) / 8;
            }
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
                Camera.Size size = supportedPreviewSizes.get(i6);
                int i7 = size.width;
                int i8 = size.height;
                if (i7 * i8 >= i2 && i7 * i8 <= i3) {
                    arrayList.add(new C1822a(i7, i8));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean a(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, activity, z)) == null) {
            this.p = z;
            Camera camera = this.f34527e;
            if (camera != null) {
                camera.stopPreview();
                this.f34527e.release();
                this.f34527e = null;
            }
            try {
                if (a()) {
                    l = 1;
                } else {
                    l = 0;
                }
                this.f34527e = Camera.open(l);
                a(activity);
                return true;
            } catch (Throwable th) {
                d.a(th);
                Camera camera2 = this.f34527e;
                if (camera2 != null) {
                    camera2.release();
                    this.f34527e = null;
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                try {
                    if (this.f34529g != null && Build.VERSION.SDK_INT >= 14) {
                        this.f34529g.getSurface().release();
                    }
                    if (this.f34527e != null) {
                        this.f34527e.setPreviewCallback(null);
                        this.f34527e.stopPreview();
                        this.f34527e.release();
                        this.k = false;
                        this.f34527e = null;
                    }
                    this.n = true;
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                try {
                    if (this.f34528f != null && this.o) {
                        this.f34528f.reset();
                        this.f34528f.release();
                        this.f34528f = null;
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
        }
    }

    public C1822a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34530h : (C1822a) invokeV.objValue;
    }

    public void b() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (camera = this.f34527e) == null) {
            return;
        }
        camera.startPreview();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Camera.getNumberOfCameras() == 1) {
                this.n = false;
            }
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (camera = this.f34527e) == null) {
            return;
        }
        camera.stopPreview();
    }

    private C1822a b(Camera.Parameters parameters, C1822a c1822a) {
        InterceptResult invokeLL;
        List<Camera.Size> list;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, parameters, c1822a)) == null) {
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
                return c1822a;
            }
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return c1822a;
            }
            float f2 = c1822a.f34533b / c1822a.a;
            C1822a c1822a2 = new C1822a(0, 0);
            C1822a c1822a3 = new C1822a(0, 0);
            C1822a c1822a4 = new C1822a(0, 0);
            C1822a c1822a5 = new C1822a(0, 0);
            C1822a c1822a6 = new C1822a(0, 0);
            int i4 = 921600;
            C1822a c1822a7 = new C1822a(0, 0);
            int i5 = 0;
            while (i5 < supportedVideoSizes.size()) {
                Camera.Size size = supportedVideoSizes.get(i5);
                int i6 = size.width;
                c1822a3.a = i6;
                int i7 = size.height;
                c1822a3.f34533b = i7;
                if (i6 == c1822a.a && i7 == c1822a.f34533b) {
                    c1822a2.a = i6;
                    c1822a2.f34533b = i7;
                    return c1822a2;
                }
                float f3 = 0.01f;
                if (Math.abs((size.height / size.width) - f2) < 0.01f && (i2 = c1822a3.a) >= c1822a2.a && (i3 = c1822a3.f34533b) >= c1822a2.f34533b && i2 * i3 <= i4) {
                    c1822a2.a = i2;
                    c1822a2.f34533b = i3;
                }
                int i8 = 0;
                while (i8 < supportedPreviewSizes.size()) {
                    Camera.Size size2 = supportedPreviewSizes.get(i8);
                    int i9 = size2.width;
                    c1822a4.a = i9;
                    int i10 = size2.height;
                    c1822a4.f34533b = i10;
                    if (!(c1822a3.a == i9 && c1822a3.f34533b == i10) && Math.abs((c1822a4.f34533b / c1822a4.a) - (c1822a3.f34533b / c1822a3.a)) >= f3) {
                        list = supportedVideoSizes;
                    } else {
                        int i11 = c1822a3.a;
                        int i12 = c1822a3.f34533b;
                        list = supportedVideoSizes;
                        if (i11 * i12 >= c1822a5.a * c1822a5.f34533b && i11 * i12 <= 921600) {
                            c1822a5.a = i11;
                            c1822a5.f34533b = i12;
                            c1822a6.f34533b = c1822a4.f34533b;
                            c1822a6.a = c1822a4.a;
                        }
                    }
                    i8++;
                    supportedVideoSizes = list;
                    f3 = 0.01f;
                }
                List<Camera.Size> list2 = supportedVideoSizes;
                int i13 = c1822a3.a;
                int i14 = c1822a3.f34533b;
                if (i13 * i14 >= c1822a7.a * c1822a7.f34533b && i13 * i14 <= 921600) {
                    c1822a7.a = i13;
                    c1822a7.f34533b = i14;
                }
                i5++;
                supportedVideoSizes = list2;
                i4 = 921600;
            }
            if (c1822a2.a > 0) {
                return c1822a2;
            }
            if (c1822a5.a > 0) {
                C1822a c1822a8 = this.f34530h;
                c1822a8.f34533b = c1822a6.f34533b;
                c1822a8.a = c1822a6.a;
                return c1822a5;
            }
            return c1822a7;
        }
        return (C1822a) invokeLL.objValue;
    }

    private void a(Activity activity) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, activity) == null) || (camera = this.f34527e) == null) {
            return;
        }
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
        this.f34527e.setDisplayOrientation(this.m);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        if (parameters.getSupportedFlashModes() != null) {
            if (this.n) {
                this.f34532j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode(this.f34532j);
            }
        } else {
            this.f34532j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        this.f34527e.setParameters(parameters);
    }

    private C1822a a(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, activity, parameters)) == null) {
            C1822a b2 = b(activity, parameters);
            this.f34530h = new C1822a(b2.a, b2.f34533b);
            if (this.p) {
                this.f34531i = b(this.f34527e.getParameters(), b2);
            }
            C1822a c1822a = this.f34530h;
            parameters.setPreviewSize(c1822a.a, c1822a.f34533b);
            return this.f34530h;
        }
        return (C1822a) invokeLL.objValue;
    }

    public void a(Camera.Parameters parameters, C1822a c1822a) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parameters, c1822a) == null) {
            float f2 = c1822a != null ? c1822a.a / c1822a.f34533b : 0.0f;
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
    }

    public void a(Context context, SurfaceHolder surfaceHolder) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, surfaceHolder) == null) || (camera = this.f34527e) == null) {
            return;
        }
        try {
            this.f34529g = surfaceHolder;
            camera.setPreviewDisplay(surfaceHolder);
            this.f34527e.startPreview();
        } catch (Throwable th) {
            d.a(th);
        }
        this.k = true;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.p) {
                try {
                    if (this.f34528f == null) {
                        this.f34528f = new MediaRecorder();
                    } else {
                        this.f34528f.reset();
                    }
                    this.f34527e.unlock();
                    this.f34528f.setCamera(this.f34527e);
                    this.f34528f.setVideoSource(1);
                    this.f34528f.setAudioSource(1);
                    this.f34528f.setOutputFormat(2);
                    this.f34528f.setVideoEncodingBitRate(c.a().b(context));
                    this.f34528f.setVideoEncoder(2);
                    this.f34528f.setAudioEncoder(3);
                    this.f34528f.setVideoSize(this.f34531i.a, this.f34531i.f34533b);
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(l, cameraInfo);
                    this.f34528f.setOrientationHint(cameraInfo.orientation);
                    File file = new File(g.a(context));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String b2 = g.b(context);
                    g.c(b2);
                    this.f34528f.setOutputFile(new File(b2).getAbsolutePath());
                    this.f34528f.prepare();
                    this.f34528f.start();
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
        return invokeL.booleanValue;
    }

    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, previewCallback) == null) || (camera = this.f34527e) == null) {
            return;
        }
        camera.setPreviewCallback(previewCallback);
    }
}
