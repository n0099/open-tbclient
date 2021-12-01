package c.a.r0.k4.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e implements b.InterfaceC1535b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static volatile e f18945k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1535b f18946b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1535b f18947c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1535b f18948d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18949e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f18950f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f18951g;

    /* renamed from: h  reason: collision with root package name */
    public int f18952h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18953i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f18954j;

    /* loaded from: classes6.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.x0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f18948d.k(this.a.f18951g, this.a.f18950f);
                if (this.a.f18953i) {
                    this.a.f18953i = false;
                    this.a.f18948d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1079652541, "Lc/a/r0/k4/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1079652541, "Lc/a/r0/k4/k/a/e;");
        }
    }

    public e(TbPageContext tbPageContext) {
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
        this.f18949e = false;
        this.f18953i = false;
        this.f18954j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f18942b.c() >= c.a) {
                c.f18942b.k(0);
            }
            if (1 != c.f18942b.d().intValue()) {
                this.f18947c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f18946b = B;
        this.f18948d = B;
    }

    public static e D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (f18945k == null) {
                synchronized (e.class) {
                    if (f18945k == null) {
                        f18945k = new e(tbPageContext);
                    } else if (tbPageContext != null) {
                        f18945k.a = tbPageContext;
                    }
                }
            }
            return f18945k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18947c == null) {
            return;
        }
        this.f18946b.u(this.f18952h);
        this.f18946b.i(this.f18947c.o());
        this.f18946b.m(this.f18947c.a());
        this.f18946b.j(this.f18947c.p());
        this.f18947c.q();
        this.f18947c.release();
        this.f18948d = this.f18946b;
        this.f18949e = false;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.c(i2, i3, i4, i5);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void d(byte[] bArr) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1535b = this.f18948d) == this.f18946b && interfaceC1535b != null) {
            interfaceC1535b.d(bArr);
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f18946b.g(i2, i3, i4, z);
            b.InterfaceC1535b interfaceC1535b = this.f18947c;
            if (interfaceC1535b != null) {
                interfaceC1535b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void h(boolean z) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f18949e = z;
            if (z && (interfaceC1535b = this.f18947c) != null) {
                interfaceC1535b.s(this.f18954j);
                this.f18948d = this.f18947c;
                return;
            }
            b.InterfaceC1535b interfaceC1535b2 = this.f18947c;
            if (interfaceC1535b2 != null) {
                interfaceC1535b2.release();
            }
            this.f18948d = this.f18946b;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void i(boolean z) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.i(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void j(boolean z) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.j(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f18951g = surfaceTexture;
            this.f18950f = fVar;
            if (this.f18949e && (interfaceC1535b = this.f18947c) != null) {
                if (interfaceC1535b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1535b interfaceC1535b2 = this.f18948d;
                if (interfaceC1535b2 != null) {
                    boolean k2 = interfaceC1535b2.k(surfaceTexture, fVar);
                    if (this.f18953i) {
                        this.f18953i = false;
                        this.f18948d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1535b interfaceC1535b3 = this.f18946b;
            this.f18948d = interfaceC1535b3;
            if (interfaceC1535b3 != null) {
                return interfaceC1535b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void l(int i2) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.l(i2);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void m(boolean z) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.m(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f18953i = true;
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                interfaceC1535b.n();
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void q() {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.q();
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f18948d = null;
            b.InterfaceC1535b interfaceC1535b = this.f18946b;
            if (interfaceC1535b != null) {
                interfaceC1535b.release();
            }
            b.InterfaceC1535b interfaceC1535b2 = this.f18947c;
            if (interfaceC1535b2 != null) {
                interfaceC1535b2.release();
            }
            f18945k = null;
            this.f18950f = null;
            this.f18951g = null;
            this.f18954j = null;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void s(b.a aVar) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1535b = this.f18947c) == null) {
            return;
        }
        interfaceC1535b.s(aVar);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1535b interfaceC1535b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1535b = this.f18948d) == null) {
            return;
        }
        interfaceC1535b.t(i2, i3, i4, i5);
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f18952h = i2;
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                interfaceC1535b.u(i2);
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1535b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1535b interfaceC1535b = this.f18948d;
            if (interfaceC1535b != null) {
                return interfaceC1535b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
