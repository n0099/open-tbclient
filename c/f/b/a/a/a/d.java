package c.f.b.a.a.a;

import android.app.Activity;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.base.camera.internal.CameraCtrl;
import com.dxmpay.wallet.core.utils.LogUtil;
/* loaded from: classes9.dex */
public class d implements Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final String p;
    public static d q;
    public static final byte[] r;
    public static final CameraCtrl s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f28949e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28950f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28951g;

    /* renamed from: h  reason: collision with root package name */
    public int f28952h;

    /* renamed from: i  reason: collision with root package name */
    public int f28953i;

    /* renamed from: j  reason: collision with root package name */
    public final int f28954j;

    /* renamed from: k  reason: collision with root package name */
    public final int f28955k;
    public final int l;
    public final long m;
    public final int n;
    public long o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370934033, "Lc/f/b/a/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1370934033, "Lc/f/b/a/a/a/d;");
                return;
            }
        }
        p = d.class.getSimpleName();
        q = null;
        r = new byte[0];
        s = CameraCtrl.getInstance();
    }

    public d(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28949e = null;
        this.o = 0L;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f28950f = i3;
        this.f28951g = i4;
        this.f28954j = i6;
        this.f28955k = i7;
        this.m = 1000 / i7;
        this.f28949e = cVar;
        if (i5 % 90 == 0) {
            this.n = (i5 + 360) % 360;
        } else {
            this.n = 0;
        }
    }

    public static int a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                rotation = 1;
            } else if (rotation == 1) {
                rotation = 0;
            } else if (rotation == 2) {
                rotation = 3;
            } else if (rotation == 3) {
                rotation = 2;
            }
            return rotation * 90;
        }
        return invokeL.intValue;
    }

    public static int b(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, activity, i2)) == null) {
            try {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (i2 == 1) {
                    return ((-defaultDisplay.getRotation()) * 90) - cameraInfo.orientation;
                }
                return ((-defaultDisplay.getRotation()) * 90) + cameraInfo.orientation;
            } catch (Throwable unused) {
                return a(activity);
            }
        }
        return invokeLI.intValue;
    }

    public static d c(int i2, int i3, int i4, int i5, int i6, int i7, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), cVar})) == null) {
            synchronized (r) {
                d dVar = new d(i2, i3, i4, i5, i6, i7, cVar);
                if (q != null) {
                    if (dVar.equals(q)) {
                        return q;
                    }
                    s.destroy();
                    q.f28949e.destroyCamera();
                }
                try {
                    if (!s.init(i2, i3, i4, dVar.n, i6, i7)) {
                        LogUtil.errord(p, "can not initialize camera");
                        q = null;
                        return null;
                    }
                    dVar.f28952h = s.getPreviewWidht();
                    dVar.f28953i = s.getPreviewHeight();
                    q = dVar;
                    dVar.e(cVar);
                    return q;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    q = null;
                    return null;
                }
            }
        }
        return (d) invokeCommon.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s.pause();
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            synchronized (r) {
                if (cVar != null) {
                    if (this.f28949e != null && cVar != this.f28949e) {
                        this.f28949e.destroyCamera();
                    }
                    cVar.initCamera(this.f28952h, this.f28953i, this.f28954j, this.f28955k);
                    this.f28949e = cVar;
                } else {
                    if (this.f28949e != null) {
                        this.f28949e.destroyCamera();
                    }
                    this.f28949e = null;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                c cVar = dVar.f28949e;
                return (cVar == null || this.f28949e != null) && dVar.l == this.l && dVar.f28951g == this.f28951g && dVar.f28950f == this.f28950f && dVar.n == this.n && dVar.f28954j == this.f28954j && dVar.f28955k == this.f28955k && cVar.equals(this.f28949e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (r) {
                s.destroy();
                if (!z && this.f28949e != null) {
                    this.f28949e.destroyCamera();
                }
                this.f28949e = null;
                q = null;
            }
        }
    }

    public boolean g(SurfaceHolder surfaceHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceHolder)) == null) {
            if (surfaceHolder == null) {
                LogUtil.errord(p, "The camera preview surface is null");
                return false;
            }
            s.start(this, surfaceHolder);
            return true;
        }
        return invokeL.booleanValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? s.camera() : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.l);
            sb.append(this.f28951g);
            sb.append(this.f28950f);
            sb.append(this.n);
            sb.append(this.f28954j);
            sb.append(this.f28955k);
            sb.append(this.f28949e.hashCode());
            return sb.hashCode();
        }
        return invokeV.intValue;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bArr, camera) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.o;
            if (0 == j2) {
                this.o = currentTimeMillis;
            } else if (currentTimeMillis - j2 > this.m) {
                this.o = currentTimeMillis;
                if (this.f28949e != null) {
                    try {
                        this.f28949e.processImage(bArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            camera.addCallbackBuffer(bArr);
        }
    }
}
