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
/* loaded from: classes4.dex */
public class d implements Camera.PreviewCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final String p;
    public static d q;
    public static final byte[] r;
    public static final CameraCtrl s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile c f32325e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32326f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32327g;

    /* renamed from: h  reason: collision with root package name */
    public int f32328h;

    /* renamed from: i  reason: collision with root package name */
    public int f32329i;

    /* renamed from: j  reason: collision with root package name */
    public final int f32330j;
    public final int k;
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
        this.f32325e = null;
        this.o = 0L;
        i7 = i7 == 0 ? 15 : i7;
        this.l = i2;
        this.f32326f = i3;
        this.f32327g = i4;
        this.f32330j = i6;
        this.k = i7;
        this.m = 1000 / i7;
        this.f32325e = cVar;
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
                    q.f32325e.destroyCamera();
                }
                try {
                    if (!s.init(i2, i3, i4, dVar.n, i6, i7)) {
                        LogUtil.errord(p, "can not initialize camera");
                        q = null;
                        return null;
                    }
                    dVar.f32328h = s.getPreviewWidht();
                    dVar.f32329i = s.getPreviewHeight();
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
                    if (this.f32325e != null && cVar != this.f32325e) {
                        this.f32325e.destroyCamera();
                    }
                    cVar.initCamera(this.f32328h, this.f32329i, this.f32330j, this.k);
                    this.f32325e = cVar;
                } else {
                    if (this.f32325e != null) {
                        this.f32325e.destroyCamera();
                    }
                    this.f32325e = null;
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
                c cVar = dVar.f32325e;
                return (cVar == null || this.f32325e != null) && dVar.l == this.l && dVar.f32327g == this.f32327g && dVar.f32326f == this.f32326f && dVar.n == this.n && dVar.f32330j == this.f32330j && dVar.k == this.k && cVar.equals(this.f32325e);
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
                if (!z && this.f32325e != null) {
                    this.f32325e.destroyCamera();
                }
                this.f32325e = null;
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
            sb.append(this.f32327g);
            sb.append(this.f32326f);
            sb.append(this.n);
            sb.append(this.f32330j);
            sb.append(this.k);
            sb.append(this.f32325e.hashCode());
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
                if (this.f32325e != null) {
                    try {
                        this.f32325e.processImage(bArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            camera.addCallbackBuffer(bArr);
        }
    }
}
