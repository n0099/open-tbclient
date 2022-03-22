package c.a.p0.q4.l.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.o.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e implements b.InterfaceC1607b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1607b f17788b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1607b f17789c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1607b f17790d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17791e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f17792f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f17793g;

    /* renamed from: h  reason: collision with root package name */
    public int f17794h;
    public boolean i;
    public b.a j;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.v0.o.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f17790d.k(this.a.f17793g, this.a.f17792f);
                if (this.a.i) {
                    this.a.i = false;
                    this.a.f17790d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(730986282, "Lc/a/p0/q4/l/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(730986282, "Lc/a/p0/q4/l/a/e;");
        }
    }

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17791e = false;
        this.i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f17786b.c() >= c.a) {
                c.f17786b.k(0);
            }
            if (1 != c.f17786b.d().intValue()) {
                this.f17789c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f17788b = B;
        this.f17790d = B;
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
                        k.a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17789c == null) {
            return;
        }
        this.f17788b.u(this.f17794h);
        this.f17788b.i(this.f17789c.o());
        this.f17788b.m(this.f17789c.a());
        this.f17788b.j(this.f17789c.p());
        this.f17789c.q();
        this.f17789c.release();
        this.f17790d = this.f17788b;
        this.f17791e = false;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void c(int i, int i2, int i3, int i4) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.c(i, i2, i3, i4);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void d(byte[] bArr) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1607b = this.f17790d) == this.f17788b && interfaceC1607b != null) {
            interfaceC1607b.d(bArr);
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void g(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.f17788b.g(i, i2, i3, z);
            b.InterfaceC1607b interfaceC1607b = this.f17789c;
            if (interfaceC1607b != null) {
                interfaceC1607b.g(i, i2, i3, z);
            }
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void h(boolean z) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f17791e = z;
            if (z && (interfaceC1607b = this.f17789c) != null) {
                interfaceC1607b.s(this.j);
                this.f17790d = this.f17789c;
                return;
            }
            b.InterfaceC1607b interfaceC1607b2 = this.f17789c;
            if (interfaceC1607b2 != null) {
                interfaceC1607b2.release();
            }
            this.f17790d = this.f17788b;
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void i(boolean z) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.i(z);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void j(boolean z) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.j(z);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f17793g = surfaceTexture;
            this.f17792f = fVar;
            if (this.f17791e && (interfaceC1607b = this.f17789c) != null) {
                if (interfaceC1607b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1607b interfaceC1607b2 = this.f17790d;
                if (interfaceC1607b2 != null) {
                    boolean k2 = interfaceC1607b2.k(surfaceTexture, fVar);
                    if (this.i) {
                        this.i = false;
                        this.f17790d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1607b interfaceC1607b3 = this.f17788b;
            this.f17790d = interfaceC1607b3;
            if (interfaceC1607b3 != null) {
                return interfaceC1607b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void l(int i) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.l(i);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void m(boolean z) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.m(z);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                interfaceC1607b.n();
            }
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void q() {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.q();
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f17790d = null;
            b.InterfaceC1607b interfaceC1607b = this.f17788b;
            if (interfaceC1607b != null) {
                interfaceC1607b.release();
            }
            b.InterfaceC1607b interfaceC1607b2 = this.f17789c;
            if (interfaceC1607b2 != null) {
                interfaceC1607b2.release();
            }
            k = null;
            this.f17792f = null;
            this.f17793g = null;
            this.j = null;
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void s(b.a aVar) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1607b = this.f17789c) == null) {
            return;
        }
        interfaceC1607b.s(aVar);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void t(int i, int i2, int i3, int i4) {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i, i2, i3, i4) == null) || (interfaceC1607b = this.f17790d) == null) {
            return;
        }
        interfaceC1607b.t(i, i2, i3, i4);
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.f17794h = i;
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                interfaceC1607b.u(i);
            }
        }
    }

    @Override // c.a.v0.o.b.InterfaceC1607b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.f17790d;
            if (interfaceC1607b != null) {
                return interfaceC1607b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
