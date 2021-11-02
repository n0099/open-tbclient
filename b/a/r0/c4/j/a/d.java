package b.a.r0.c4.j.a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.p.b;
import b.a.x0.t.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes4.dex */
public class d extends b.a.r0.c4.j.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d F;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Camera.CameraInfo B;
    public Surface C;
    public MediaPlayer D;
    public byte[][] E;
    public Camera r;
    public Camera.Parameters s;
    public int t;
    public b.f u;
    public int v;
    public List<Camera.Area> w;
    public List<Camera.Area> x;
    public Matrix y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15438e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15438e = dVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) || this.f15438e.u == null) {
                return;
            }
            this.f15438e.u.a(bArr, 1);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(976986270, "Lb/a/r0/c4/j/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(976986270, "Lb/a/r0/c4/j/a/d;");
        }
    }

    public d(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = 0;
        this.f15419a = tbPageContext;
        D();
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        arrayList.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
        ArrayList arrayList2 = new ArrayList();
        this.x = arrayList2;
        arrayList2.add(new Camera.Area(new Rect(0, 0, 0, 0), 1));
    }

    public static d B(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (F == null) {
                synchronized (d.class) {
                    if (F == null) {
                        F = new d(tbPageContext);
                    } else if (tbPageContext != null) {
                        F.f15419a = tbPageContext;
                    }
                }
            }
            return F;
        }
        return (d) invokeL.objValue;
    }

    public static Camera.Size C(List<Camera.Size> list, int i2, int i3) {
        InterceptResult invokeLII;
        Camera.Size size;
        Camera.Size size2;
        Camera.Size size3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, list, i2, i3)) == null) {
            if (list != null) {
                int i4 = i2 * i3;
                int i5 = Integer.MAX_VALUE;
                float f2 = i2 / i3;
                float f3 = 2.1474836E9f;
                float f4 = Float.MAX_VALUE;
                Iterator<Camera.Size> it = list.iterator();
                size = null;
                size2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        size3 = null;
                        break;
                    }
                    size3 = it.next();
                    if (size3 != null) {
                        if (size3.width == i2 && size3.height == i3) {
                            break;
                        }
                        int abs = Math.abs(i4 - (size3.width * size3.height));
                        if (abs < i5) {
                            size = size3;
                            i5 = abs;
                        }
                        float abs2 = Math.abs((size3.width / size3.height) - f2);
                        if (abs2 - f4 <= 0.001d) {
                            float f5 = abs;
                            if (f5 < f3) {
                                size2 = size3;
                                f3 = f5;
                                f4 = abs2;
                            }
                        }
                    }
                }
            } else {
                size = null;
                size2 = null;
                size3 = null;
            }
            if (size3 != null) {
                return size3;
            }
            if (size2 != null) {
                return size2;
            }
            if (size != null) {
                return size;
            }
            return null;
        }
        return (Camera.Size) invokeLII.objValue;
    }

    public static void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            boolean z = false;
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(i2, cameraInfo);
                    int i3 = cameraInfo.facing;
                    if (i3 == 1) {
                        b.a.r0.c4.j.a.a.o = true;
                    } else if (i3 == 0) {
                        b.a.r0.c4.j.a.a.p = true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    b.a.x0.f.a.b("getCameraInfo", e2.getMessage());
                }
            }
            if (b.a.r0.c4.j.a.a.o && !DeviceInfoUtil.isHuaweiMateX() && !DeviceInfoUtil.isOppN5207()) {
                z = true;
            }
            b.a.r0.c4.j.a.a.o = z;
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                if (numberOfCameras == 1) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(0, cameraInfo);
                    this.B = cameraInfo;
                    return 0;
                }
                for (int i2 = 0; i2 < numberOfCameras; i2++) {
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    Camera.getCameraInfo(i2, cameraInfo2);
                    if (this.f15420b && cameraInfo2.facing == 1) {
                        this.B = cameraInfo2;
                        return i2;
                    } else if (!this.f15420b && cameraInfo2.facing == 0) {
                        this.B = cameraInfo2;
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int[] E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<int[]> supportedPreviewFpsRange = this.r.getParameters().getSupportedPreviewFpsRange();
            int[] iArr = null;
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int i2 = Integer.MAX_VALUE;
                Iterator<int[]> it = supportedPreviewFpsRange.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int[] next = it.next();
                    if (next != null) {
                        int i4 = next[1] < 1000 ? 1 : 1000;
                        int i5 = next[0] / i4;
                        int i6 = next[1] / i4;
                        int i7 = this.k;
                        if (i7 >= i5 && i7 <= i6) {
                            iArr = next;
                            i3 = i7;
                            break;
                        }
                        int abs = Math.abs(i5 - this.k);
                        int abs2 = Math.abs(i6 - this.k);
                        if (abs <= abs2 && abs < i2) {
                            iArr = next;
                            i3 = i5;
                            i2 = abs;
                        } else if (abs2 <= abs && abs2 < i2) {
                            iArr = next;
                            i3 = i6;
                            i2 = abs2;
                        }
                    }
                }
                this.t = i3;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            List<Camera.Size> supportedPreviewSizes = this.r.getParameters().getSupportedPreviewSizes();
            Camera.Size C = C(supportedPreviewSizes, this.f15424f, this.f15425g);
            if (C != null) {
                this.f15422d = C.width;
                this.f15423e = C.height;
            }
            if (b.a.r0.c4.j.a.a.q == null) {
                if (C != null && this.f15424f == C.width && this.f15425g == C.height) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (supportedPreviewSizes != null) {
                    for (Camera.Size size : supportedPreviewSizes) {
                        sb.append(size.width);
                        sb.append(',');
                        sb.append(size.height);
                        sb.append(com.alipay.sdk.encrypt.a.f34124h);
                        sb.append(size.height / size.width);
                        sb.append('\n');
                    }
                }
                b.a.r0.c4.j.a.a.q = sb.toString();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.f15421c && this.f15422d < this.f15423e) || (!this.f15421c && this.f15422d > this.f15423e)) {
                this.f15426h = this.f15423e;
                this.f15427i = this.f15422d;
                return;
            }
            this.f15426h = this.f15422d;
            this.f15427i = this.f15423e;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Camera camera = this.r;
            if (camera == null || this.f15419a == null) {
                return -1;
            }
            return camera.getParameters().getPreviewFormat();
        }
        return invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) || this.r == null || this.f15419a == null) {
            return;
        }
        try {
            z(i2, i3, 1.0f, i4, i5, v.e(), v.d(), this.w.get(0).rect);
            z(i2, i3, 1.5f, i4, i5, v.e(), v.d(), this.x.get(0).rect);
            this.r.cancelAutoFocus();
            Camera.Parameters parameters = this.r.getParameters();
            if (parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                parameters.setFocusAreas(this.w);
            }
            parameters.setMeteringAreas(this.x);
            this.r.setParameters(parameters);
            this.r.autoFocus(null);
        } catch (Exception e2) {
            b.a.x0.t.c.g(e2);
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void d(byte[] bArr) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) || (camera = this.r) == null) {
            return;
        }
        camera.addCallbackBuffer(bArr);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.r0.c4.j.a.a.q : (String) invokeV.objValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r != null : invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f15424f = Math.max(i2, i3);
            this.f15425g = Math.min(i2, i3);
            this.f15421c = i2 > i3;
            this.k = i4;
            i(z);
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f15420b = (z && x()) || !(z || w());
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        float f2;
        List<String> supportedAntibanding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, surfaceTexture, fVar)) == null) {
            this.l = surfaceTexture;
            this.u = fVar;
            try {
                q();
                int A = A();
                this.j = A;
                if (A >= 0) {
                    Camera open = Camera.open(A);
                    this.r = open;
                    if (open != null) {
                        F();
                        int[] E = E();
                        if (this.f15422d > 0 && this.f15423e > 0 && this.t != 0 && E != null && E.length == 2) {
                            Camera.Parameters parameters = this.r.getParameters();
                            this.s = parameters;
                            parameters.setPreviewSize(this.f15422d, this.f15423e);
                            if (c.f15437c && (supportedAntibanding = this.s.getSupportedAntibanding()) != null && supportedAntibanding.contains("50hz")) {
                                this.s.setAntibanding("50hz");
                            }
                            List<String> supportedFocusModes = this.s.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                this.s.setFocusMode("continuous-video");
                            }
                            this.s.setPreviewFpsRange(E[0], E[1]);
                            b.a.r0.c4.j.a.h.a.g(this.v, this.j, this.r);
                            if (this.s.isVideoStabilizationSupported() && !this.s.getVideoStabilization()) {
                                this.s.setVideoStabilization(true);
                            }
                            try {
                                this.s.setExposureCompensation((int) (((this.s.getMaxExposureCompensation() - f2) * 0.5d) + this.s.getMinExposureCompensation()));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.z = b.a.r0.c4.j.a.h.a.c(this.s);
                            this.r.setParameters(this.s);
                            if (this.E == null) {
                                this.E = (byte[][]) Array.newInstance(byte.class, 3, ((this.f15422d * this.f15423e) * 3) / 2);
                            }
                            a aVar = new a(this);
                            this.r.setPreviewCallbackWithBuffer(aVar);
                            for (int i2 = 0; i2 < 3; i2++) {
                                this.r.addCallbackBuffer(this.E[i2]);
                            }
                            this.r.setPreviewCallbackWithBuffer(aVar);
                            this.r.setPreviewTexture(this.l);
                            this.r.startPreview();
                            G();
                            c.f15436b.k(1);
                            return true;
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                e3.getMessage();
            }
            q();
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.r == null) {
            return;
        }
        if ((i2 >= 1 || i2 <= -1) && this.z != -1) {
            try {
                Camera.Parameters parameters = this.r.getParameters();
                if (parameters.isZoomSupported()) {
                    int i3 = this.A + i2;
                    if (i3 > this.z) {
                        i3 = this.z;
                    } else if (i3 < 0) {
                        i3 = 0;
                    }
                    if (this.A != i3) {
                        parameters.setZoom(i3);
                        this.r.setParameters(parameters);
                        this.A = i3;
                    }
                }
            } catch (Exception e2) {
                b.a.x0.t.c.g(e2);
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void n() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.r == null || (tbPageContext = this.f15419a) == null) {
            return;
        }
        b.a.r0.c4.j.a.h.a.h(tbPageContext, A(), this.r);
        G();
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Camera.CameraInfo cameraInfo = this.B;
            return (cameraInfo != null && cameraInfo.facing == 1) || this.f15420b;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void q() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (camera = this.r) == null) {
            return;
        }
        try {
            camera.stopPreview();
        } catch (Exception e2) {
            e2.printStackTrace();
            String str = "stopPreview:" + e2.getMessage();
        }
        try {
            this.r.setPreviewTexture(null);
            this.r.setPreviewCallbackWithBuffer(null);
        } catch (Exception e3) {
            e3.printStackTrace();
            String str2 = "stopPreview:" + e3.getMessage();
        }
        try {
            this.r.release();
        } catch (Exception e4) {
            e4.printStackTrace();
            String str3 = "stopPreview:" + e4.getMessage();
        }
        this.z = 0;
        this.A = 0;
        this.y = null;
        this.r = null;
        Surface surface = this.C;
        if (surface != null) {
            surface.release();
        }
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.D.release();
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            F = null;
            this.f15419a = null;
            this.u = null;
            this.l = null;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void s(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void t(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048595, this, i2, i3, i4, i5) != null) || this.r == null || this.f15419a == null) {
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.v = i2;
        }
    }

    public final void z(int i2, int i3, float f2, int i4, int i5, int i6, int i7, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), rect}) == null) {
            int i8 = (int) (i2 * f2);
            int i9 = (int) (i3 * f2);
            int a2 = b.a.r0.c4.j.a.h.a.a(i4 - (i8 / 2), 0, i6 - i8);
            int a3 = b.a.r0.c4.j.a.h.a.a(i5 - (i9 / 2), 0, i7 - i9);
            RectF rectF = new RectF(a2, a3, a2 + i8, a3 + i9);
            if (this.y == null) {
                this.y = new Matrix();
                Matrix matrix = new Matrix();
                TbPageContext tbPageContext = this.f15419a;
                if (tbPageContext != null) {
                    b.a.r0.c4.j.a.h.a.e(tbPageContext, this.j, matrix);
                }
                matrix.invert(this.y);
            }
            this.y.mapRect(rectF);
            b.a.r0.c4.j.a.h.a.f(rectF, rect);
        }
    }
}
