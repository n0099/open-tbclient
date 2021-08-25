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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f40098a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f40099b = 640;

    /* renamed from: c  reason: collision with root package name */
    public static final String f40100c = "CameraControl";

    /* renamed from: d  reason: collision with root package name */
    public static final float f40101d = 0.2f;
    public static int l = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Camera f40102e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f40103f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f40104g;

    /* renamed from: h  reason: collision with root package name */
    public C1654a f40105h;

    /* renamed from: i  reason: collision with root package name */
    public C1654a f40106i;

    /* renamed from: j  reason: collision with root package name */
    public String f40107j;
    public boolean k;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: com.baidu.fsg.face.liveness.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1654a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40108a;

        /* renamed from: b  reason: collision with root package name */
        public int f40109b;

        public C1654a(int i2, int i3) {
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
            this.f40108a = i2;
            this.f40109b = i3;
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
        this.f40107j = DebugKt.DEBUG_PROPERTY_VALUE_ON;
        this.k = false;
        this.n = true;
        this.o = true;
        this.p = false;
    }

    private C1654a b(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, parameters)) == null) {
            List<C1654a> c2 = c(activity, parameters);
            C1654a c1654a = new C1654a(640, 480);
            if (c2 != null && c2.size() != 0) {
                Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                C1654a c1654a2 = new C1654a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
                float f2 = c1654a2.f40109b / c1654a2.f40108a;
                float f3 = c1654a.f40108a / c1654a.f40109b;
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    C1654a c1654a3 = c2.get(i2);
                    float abs = Math.abs((c1654a3.f40108a / c1654a3.f40109b) - f2);
                    if (abs < f3) {
                        c1654a = c1654a3;
                        f3 = abs;
                    }
                }
            }
            return c1654a;
        }
        return (C1654a) invokeLL.objValue;
    }

    private List<C1654a> c(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return null;
            }
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            C1654a c1654a = new C1654a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            int i2 = 153600;
            int i3 = 921600;
            int i4 = c1654a.f40108a;
            int i5 = c1654a.f40109b;
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
                    arrayList.add(new C1654a(i7, i8));
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
            Camera camera = this.f40102e;
            if (camera != null) {
                camera.stopPreview();
                this.f40102e.release();
                this.f40102e = null;
            }
            try {
                if (a()) {
                    l = 1;
                } else {
                    l = 0;
                }
                this.f40102e = Camera.open(l);
                a(activity);
                return true;
            } catch (Throwable th) {
                d.a(th);
                Camera camera2 = this.f40102e;
                if (camera2 != null) {
                    camera2.release();
                    this.f40102e = null;
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
                    if (this.f40104g != null && Build.VERSION.SDK_INT >= 14) {
                        this.f40104g.getSurface().release();
                    }
                    if (this.f40102e != null) {
                        this.f40102e.setPreviewCallback(null);
                        this.f40102e.stopPreview();
                        this.f40102e.release();
                        this.k = false;
                        this.f40102e = null;
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
                    if (this.f40103f != null && this.o) {
                        this.f40103f.reset();
                        this.f40103f.release();
                        this.f40103f = null;
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
        }
    }

    public C1654a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40105h : (C1654a) invokeV.objValue;
    }

    public void b() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (camera = this.f40102e) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (camera = this.f40102e) == null) {
            return;
        }
        camera.stopPreview();
    }

    private C1654a b(Camera.Parameters parameters, C1654a c1654a) {
        InterceptResult invokeLL;
        List<Camera.Size> list;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, parameters, c1654a)) == null) {
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedVideoSizes == null || supportedVideoSizes.size() == 0) {
                return c1654a;
            }
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return c1654a;
            }
            float f2 = c1654a.f40109b / c1654a.f40108a;
            C1654a c1654a2 = new C1654a(0, 0);
            C1654a c1654a3 = new C1654a(0, 0);
            C1654a c1654a4 = new C1654a(0, 0);
            C1654a c1654a5 = new C1654a(0, 0);
            C1654a c1654a6 = new C1654a(0, 0);
            int i4 = 921600;
            C1654a c1654a7 = new C1654a(0, 0);
            int i5 = 0;
            while (i5 < supportedVideoSizes.size()) {
                Camera.Size size = supportedVideoSizes.get(i5);
                int i6 = size.width;
                c1654a3.f40108a = i6;
                int i7 = size.height;
                c1654a3.f40109b = i7;
                if (i6 == c1654a.f40108a && i7 == c1654a.f40109b) {
                    c1654a2.f40108a = i6;
                    c1654a2.f40109b = i7;
                    return c1654a2;
                }
                float f3 = 0.01f;
                if (Math.abs((size.height / size.width) - f2) < 0.01f && (i2 = c1654a3.f40108a) >= c1654a2.f40108a && (i3 = c1654a3.f40109b) >= c1654a2.f40109b && i2 * i3 <= i4) {
                    c1654a2.f40108a = i2;
                    c1654a2.f40109b = i3;
                }
                int i8 = 0;
                while (i8 < supportedPreviewSizes.size()) {
                    Camera.Size size2 = supportedPreviewSizes.get(i8);
                    int i9 = size2.width;
                    c1654a4.f40108a = i9;
                    int i10 = size2.height;
                    c1654a4.f40109b = i10;
                    if (!(c1654a3.f40108a == i9 && c1654a3.f40109b == i10) && Math.abs((c1654a4.f40109b / c1654a4.f40108a) - (c1654a3.f40109b / c1654a3.f40108a)) >= f3) {
                        list = supportedVideoSizes;
                    } else {
                        int i11 = c1654a3.f40108a;
                        int i12 = c1654a3.f40109b;
                        list = supportedVideoSizes;
                        if (i11 * i12 >= c1654a5.f40108a * c1654a5.f40109b && i11 * i12 <= 921600) {
                            c1654a5.f40108a = i11;
                            c1654a5.f40109b = i12;
                            c1654a6.f40109b = c1654a4.f40109b;
                            c1654a6.f40108a = c1654a4.f40108a;
                        }
                    }
                    i8++;
                    supportedVideoSizes = list;
                    f3 = 0.01f;
                }
                List<Camera.Size> list2 = supportedVideoSizes;
                int i13 = c1654a3.f40108a;
                int i14 = c1654a3.f40109b;
                if (i13 * i14 >= c1654a7.f40108a * c1654a7.f40109b && i13 * i14 <= 921600) {
                    c1654a7.f40108a = i13;
                    c1654a7.f40109b = i14;
                }
                i5++;
                supportedVideoSizes = list2;
                i4 = 921600;
            }
            if (c1654a2.f40108a > 0) {
                return c1654a2;
            }
            if (c1654a5.f40108a > 0) {
                C1654a c1654a8 = this.f40105h;
                c1654a8.f40109b = c1654a6.f40109b;
                c1654a8.f40108a = c1654a6.f40108a;
                return c1654a5;
            }
            return c1654a7;
        }
        return (C1654a) invokeLL.objValue;
    }

    private void a(Activity activity) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, activity) == null) || (camera = this.f40102e) == null) {
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
        this.f40102e.setDisplayOrientation(this.m);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        if (parameters.getSupportedFlashModes() != null) {
            if (this.n) {
                this.f40107j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode(this.f40107j);
            }
        } else {
            this.f40107j = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        this.f40102e.setParameters(parameters);
    }

    private C1654a a(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, activity, parameters)) == null) {
            C1654a b2 = b(activity, parameters);
            this.f40105h = new C1654a(b2.f40108a, b2.f40109b);
            if (this.p) {
                this.f40106i = b(this.f40102e.getParameters(), b2);
            }
            C1654a c1654a = this.f40105h;
            parameters.setPreviewSize(c1654a.f40108a, c1654a.f40109b);
            return this.f40105h;
        }
        return (C1654a) invokeLL.objValue;
    }

    public void a(Camera.Parameters parameters, C1654a c1654a) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parameters, c1654a) == null) {
            float f2 = c1654a != null ? c1654a.f40108a / c1654a.f40109b : 0.0f;
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
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, surfaceHolder) == null) || (camera = this.f40102e) == null) {
            return;
        }
        try {
            this.f40104g = surfaceHolder;
            camera.setPreviewDisplay(surfaceHolder);
            this.f40102e.startPreview();
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
                    if (this.f40103f == null) {
                        this.f40103f = new MediaRecorder();
                    } else {
                        this.f40103f.reset();
                    }
                    this.f40102e.unlock();
                    this.f40103f.setCamera(this.f40102e);
                    this.f40103f.setVideoSource(1);
                    this.f40103f.setAudioSource(1);
                    this.f40103f.setOutputFormat(2);
                    this.f40103f.setVideoEncodingBitRate(c.a().b(context));
                    this.f40103f.setVideoEncoder(2);
                    this.f40103f.setAudioEncoder(3);
                    this.f40103f.setVideoSize(this.f40106i.f40108a, this.f40106i.f40109b);
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(l, cameraInfo);
                    this.f40103f.setOrientationHint(cameraInfo.orientation);
                    File file = new File(g.a(context));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String b2 = g.b(context);
                    g.b(b2);
                    this.f40103f.setOutputFile(new File(b2).getAbsolutePath());
                    this.f40103f.prepare();
                    this.f40103f.start();
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, previewCallback) == null) || (camera = this.f40102e) == null) {
            return;
        }
        camera.setPreviewCallback(previewCallback);
    }
}
