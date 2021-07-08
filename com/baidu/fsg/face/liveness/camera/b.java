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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.video.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f6007a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6008b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6009c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6010d = 480;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6011e = 640;

    /* renamed from: i  reason: collision with root package name */
    public static int f6012i = 0;
    public static final String j = "CameraInterface";
    public static final float k = 0.2f;
    public static int o = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Camera f6013f;

    /* renamed from: g  reason: collision with root package name */
    public MediaRecorder f6014g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceHolder f6015h;
    public a l;
    public String m;
    public boolean n;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public com.baidu.fsg.face.liveness.video.a t;
    public e u;
    public boolean v;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f6017a;

        /* renamed from: b  reason: collision with root package name */
        public int f6018b;

        public a(int i2, int i3) {
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
            this.f6017a = i2;
            this.f6018b = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-39446330, "Lcom/baidu/fsg/face/liveness/camera/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-39446330, "Lcom/baidu/fsg/face/liveness/camera/b;");
        }
    }

    public b() {
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
        this.m = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        this.n = false;
        this.p = true;
        this.q = 2;
        this.r = true;
        this.s = false;
    }

    public void b() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (camera = this.f6013f) == null) {
            return;
        }
        camera.startPreview();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LogUtil.d("调用 stopPreview");
            if (this.f6013f != null) {
                if (this.v && this.s) {
                    f();
                }
                this.f6013f.stopPreview();
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                LogUtil.d("调用 doStopCamera");
                try {
                    if (this.v && this.s) {
                        f();
                    }
                    if (this.f6015h != null && Build.VERSION.SDK_INT >= 14) {
                        this.f6015h.getSurface().release();
                    }
                    if (this.f6013f != null) {
                        this.f6013f.setPreviewCallback(null);
                        this.f6013f.stopPreview();
                        this.f6013f.release();
                        this.n = false;
                        this.f6013f = null;
                    }
                    this.p = true;
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LogUtil.d("调用 stopRecordVideo");
            this.s = false;
            com.baidu.fsg.face.liveness.video.a aVar = this.t;
            if (aVar != null) {
                aVar.g();
                this.t = null;
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                try {
                    if (this.f6014g != null && this.r) {
                        this.f6014g.stop();
                        this.f6014g.reset();
                        this.f6014g.release();
                        this.f6014g = null;
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (a() == 1) {
                this.p = false;
            }
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (a) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.v = z;
        }
    }

    public boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            try {
                if (this.f6013f == null) {
                    a(activity, 1);
                }
                if (this.f6013f == null) {
                    this.r = false;
                    return false;
                }
                if (this.f6014g == null) {
                    this.f6014g = new MediaRecorder();
                } else {
                    this.f6014g.reset();
                }
                Camera.Parameters parameters = this.f6013f.getParameters();
                a a2 = a(activity, parameters, this.l);
                Camera camera = this.f6013f;
                camera.getClass();
                Camera.Size size = new Camera.Size(camera, a2.f6017a, a2.f6018b);
                List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null && supportedPreviewSizes.contains(size)) {
                    parameters.setPreviewSize(a2.f6017a, a2.f6018b);
                }
                this.f6013f.setParameters(parameters);
                this.f6013f.unlock();
                this.f6014g.setCamera(this.f6013f);
                this.f6014g.setVideoSource(1);
                this.f6014g.setAudioSource(1);
                this.f6014g.setOutputFormat(2);
                this.f6014g.setVideoEncodingBitRate(1048576);
                this.f6014g.setVideoEncoder(2);
                this.f6014g.setAudioEncoder(3);
                this.f6014g.setVideoSize(a2.f6017a, a2.f6018b);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(o, cameraInfo);
                this.f6014g.setOrientationHint(cameraInfo.orientation);
                File file = new File(g.a(activity));
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f6014g.setOutputFile(new File(g.b(activity)).getAbsolutePath());
                this.f6014g.prepare();
                this.f6014g.start();
                this.r = true;
                return true;
            } catch (Exception e2) {
                d.a(e2);
                g();
                this.r = false;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean a(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, activity, i2)) == null) {
            LogUtil.d("调用 doOpenCamera");
            this.q = i2;
            Camera camera = this.f6013f;
            if (camera != null) {
                camera.stopPreview();
                this.f6013f.release();
                this.f6013f = null;
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
                this.f6013f = Camera.open(o);
                a(activity);
                return true;
            } catch (Throwable th) {
                d.a(th);
                Camera camera2 = this.f6013f;
                if (camera2 != null) {
                    camera2.release();
                    this.f6013f = null;
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public void a(Activity activity, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, surfaceHolder) == null) {
            LogUtil.d("调用 doStartPreview");
            Camera camera = this.f6013f;
            if (camera != null) {
                try {
                    this.f6015h = surfaceHolder;
                    camera.setPreviewDisplay(surfaceHolder);
                    this.f6013f.startPreview();
                } catch (Throwable th) {
                    d.a(th);
                }
                this.n = true;
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Camera.getNumberOfCameras() : invokeV.intValue;
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) && this.v && this.u != null && this.s) {
            this.u.a(bArr, System.nanoTime() / 1000);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LogUtil.d("调用 startRecordVideo");
            if (this.s) {
                return;
            }
            this.s = true;
            com.baidu.fsg.face.liveness.video.b bVar = new com.baidu.fsg.face.liveness.video.b(this) { // from class: com.baidu.fsg.face.liveness.camera.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f6016a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6016a = this;
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public void a(e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                        this.f6016a.u = eVar;
                    }
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public void b(e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, eVar) == null) {
                        this.f6016a.u = null;
                    }
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public int c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        return 270;
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public int a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f6016a.l.f6017a : invokeV.intValue;
                }

                @Override // com.baidu.fsg.face.liveness.video.b
                public int b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6016a.l.f6018b : invokeV.intValue;
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
            com.baidu.fsg.face.liveness.video.a aVar = new com.baidu.fsg.face.liveness.video.a(c2, bVar);
            this.t = aVar;
            aVar.f();
        }
    }

    private a b(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, parameters)) == null) {
            a aVar = this.l;
            if (aVar != null) {
                return aVar;
            }
            List<a> a2 = a(activity, parameters);
            this.l = new a(640, 480);
            if (a2 != null && a2.size() != 0) {
                Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
                a aVar2 = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
                float f2 = aVar2.f6018b / aVar2.f6017a;
                a aVar3 = this.l;
                float f3 = aVar3.f6017a / aVar3.f6018b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar2.f6017a + "*" + aVar2.f6018b);
                StringBuilder sb = new StringBuilder();
                sb.append(f2);
                sb.append("");
                arrayList.add(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    a aVar4 = a2.get(i2);
                    int i3 = aVar4.f6017a;
                    float f4 = i3 / aVar4.f6018b;
                    sb2.append(i3);
                    sb2.append("*");
                    sb2.append(aVar4.f6018b);
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
        return (a) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Activity activity) {
        Camera camera;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (camera = this.f6013f) == null) {
            return;
        }
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
                    f6012i = i4;
                    f6012i = (360 - i4) % 360;
                } else {
                    f6012i = ((cameraInfo.orientation - i2) + 360) % 360;
                }
                this.f6013f.setDisplayOrientation(f6012i);
            } else if (i3 == 8) {
                int i5 = ((90 - i2) + 360) % 360;
                f6012i = i5;
                this.f6013f.setDisplayOrientation(i5);
            } else {
                f6012i = ((90 - i2) + 360) % 360;
                try {
                    Method method = this.f6013f.getClass().getMethod("setDisplayOrientation", Integer.TYPE);
                    if (method != null) {
                        method.invoke(this.f6013f, Integer.valueOf(f6012i));
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
            this.f6013f.setParameters(parameters);
        }
        i2 = 0;
        i3 = Build.VERSION.SDK_INT;
        if (i3 < 9) {
        }
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
        }
        if (parameters.getSupportedFlashModes() == null) {
        }
        this.f6013f.setParameters(parameters);
    }

    private a a(Context context, Camera.Parameters parameters, a aVar) {
        InterceptResult invokeLLL;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, parameters, aVar)) == null) {
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedVideoSizes == null || supportedVideoSizes.size() == 0 || supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return aVar;
            }
            float f2 = aVar.f6018b / aVar.f6017a;
            a aVar2 = new a(0, 0);
            a aVar3 = new a(0, 0);
            a aVar4 = new a(0, 0);
            a aVar5 = new a(0, 0);
            for (int i5 = 0; i5 < supportedVideoSizes.size(); i5++) {
                Camera.Size size = supportedVideoSizes.get(i5);
                int i6 = size.width;
                aVar3.f6017a = i6;
                int i7 = size.height;
                aVar3.f6018b = i7;
                if (i6 == aVar.f6017a && i7 == aVar.f6018b) {
                    aVar2.f6017a = i6;
                    aVar2.f6018b = i7;
                    return aVar2;
                }
                for (int i8 = 0; i8 < supportedPreviewSizes.size(); i8++) {
                    Camera.Size size2 = supportedPreviewSizes.get(i8);
                    int i9 = size2.width;
                    aVar4.f6017a = i9;
                    int i10 = size2.height;
                    aVar4.f6018b = i10;
                    int i11 = aVar3.f6017a;
                    if (i11 == i9 && (i4 = aVar3.f6018b) == i10 && i11 * i4 >= aVar5.f6017a * aVar5.f6018b && i11 * i4 <= 921600) {
                        aVar5.f6017a = i11;
                        aVar5.f6018b = i4;
                    }
                }
                if (Math.abs((size.width / size.height) - f2) < 0.01f && (i2 = aVar3.f6017a) >= aVar2.f6017a && (i3 = aVar3.f6018b) >= aVar2.f6018b) {
                    if (i2 * i3 <= 921600) {
                        aVar2 = aVar3;
                    }
                }
            }
            return aVar5.f6017a > 0 ? aVar5 : aVar2.f6017a > 0 ? aVar2 : aVar4;
        }
        return (a) invokeLLL.objValue;
    }

    private List<a> a(Activity activity, Camera.Parameters parameters) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, activity, parameters)) == null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return null;
            }
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            a aVar = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight() + f.a(activity));
            int i2 = 153600;
            int i3 = 921600;
            int i4 = aVar.f6017a;
            int i5 = aVar.f6018b;
            if ((i4 * i5) / 4 > 921600) {
                i3 = 2073600;
                i2 = (i4 * i5) / 8;
            }
            ArrayList arrayList = new ArrayList();
            RimStatisticsUtil.onEventWithValue(com.baidu.fsg.face.liveness.d.F, i2 + "-" + i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.f6017a + "*" + aVar.f6018b);
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
        return (List) invokeLL.objValue;
    }

    public a a(Activity activity, Camera.Parameters parameters, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, parameters, z)) == null) {
            a b2 = b(activity, parameters);
            parameters.setPreviewSize(b2.f6017a, b2.f6018b);
            LogUtil.d("cameraSize.width:" + b2.f6017a + ",cameraSize.height:" + b2.f6018b);
            return b2;
        }
        return (a) invokeLLZ.objValue;
    }

    public void a(Camera.Parameters parameters, a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, parameters, aVar) == null) {
            float f2 = aVar != null ? aVar.f6017a / aVar.f6018b : 0.0f;
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

    public void a(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, previewCallback) == null) || this.f6013f == null) {
            return;
        }
        this.f6013f.setPreviewCallbackWithBuffer(previewCallback);
        this.f6013f.addCallbackBuffer(new byte[((i().f6017a * i().f6018b) * ImageFormat.getBitsPerPixel(this.f6013f.getParameters().getPreviewFormat())) / 8]);
    }
}
