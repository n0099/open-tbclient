package c.a.r0.b4.j.a;

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
/* loaded from: classes3.dex */
public class e implements b.InterfaceC1426b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f16264a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1426b f16265b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1426b f16266c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1426b f16267d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16268e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f16269f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f16270g;

    /* renamed from: h  reason: collision with root package name */
    public int f16271h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16272i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f16273j;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f16274a;

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
            this.f16274a = eVar;
        }

        @Override // c.a.x0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f16274a.C();
                this.f16274a.f16267d.k(this.f16274a.f16270g, this.f16274a.f16269f);
                if (this.f16274a.f16272i) {
                    this.f16274a.f16272i = false;
                    this.f16274a.f16267d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2021060709, "Lc/a/r0/b4/j/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2021060709, "Lc/a/r0/b4/j/a/e;");
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
        this.f16268e = false;
        this.f16272i = false;
        this.f16273j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f16261b.c() >= c.f16260a) {
                c.f16261b.k(0);
            }
            if (1 != c.f16261b.d().intValue()) {
                this.f16266c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f16265b = B;
        this.f16267d = B;
    }

    public static e D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (e.class) {
                    if (k == null) {
                        k = new e(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.f16264a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16266c == null) {
            return;
        }
        this.f16265b.u(this.f16271h);
        this.f16265b.i(this.f16266c.o());
        this.f16265b.m(this.f16266c.a());
        this.f16265b.j(this.f16266c.p());
        this.f16266c.q();
        this.f16266c.release();
        this.f16267d = this.f16265b;
        this.f16268e = false;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.c(i2, i3, i4, i5);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void d(byte[] bArr) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1426b = this.f16267d) == this.f16265b && interfaceC1426b != null) {
            interfaceC1426b.d(bArr);
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f16265b.g(i2, i3, i4, z);
            b.InterfaceC1426b interfaceC1426b = this.f16266c;
            if (interfaceC1426b != null) {
                interfaceC1426b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void h(boolean z) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f16268e = z;
            if (z && (interfaceC1426b = this.f16266c) != null) {
                interfaceC1426b.s(this.f16273j);
                this.f16267d = this.f16266c;
                return;
            }
            b.InterfaceC1426b interfaceC1426b2 = this.f16266c;
            if (interfaceC1426b2 != null) {
                interfaceC1426b2.release();
            }
            this.f16267d = this.f16265b;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void i(boolean z) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.i(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void j(boolean z) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.j(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f16270g = surfaceTexture;
            this.f16269f = fVar;
            if (this.f16268e && (interfaceC1426b = this.f16266c) != null) {
                if (interfaceC1426b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1426b interfaceC1426b2 = this.f16267d;
                if (interfaceC1426b2 != null) {
                    boolean k2 = interfaceC1426b2.k(surfaceTexture, fVar);
                    if (this.f16272i) {
                        this.f16272i = false;
                        this.f16267d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1426b interfaceC1426b3 = this.f16265b;
            this.f16267d = interfaceC1426b3;
            if (interfaceC1426b3 != null) {
                return interfaceC1426b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void l(int i2) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.l(i2);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void m(boolean z) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.m(z);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16272i = true;
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                interfaceC1426b.n();
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void q() {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.q();
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f16267d = null;
            b.InterfaceC1426b interfaceC1426b = this.f16265b;
            if (interfaceC1426b != null) {
                interfaceC1426b.release();
            }
            b.InterfaceC1426b interfaceC1426b2 = this.f16266c;
            if (interfaceC1426b2 != null) {
                interfaceC1426b2.release();
            }
            k = null;
            this.f16269f = null;
            this.f16270g = null;
            this.f16273j = null;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void s(b.a aVar) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1426b = this.f16266c) == null) {
            return;
        }
        interfaceC1426b.s(aVar);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1426b interfaceC1426b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1426b = this.f16267d) == null) {
            return;
        }
        interfaceC1426b.t(i2, i3, i4, i5);
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f16271h = i2;
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                interfaceC1426b.u(i2);
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1426b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1426b interfaceC1426b = this.f16267d;
            if (interfaceC1426b != null) {
                return interfaceC1426b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
