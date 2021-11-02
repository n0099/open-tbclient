package b.a.r0.c4.j.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e implements b.InterfaceC1429b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15439a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1429b f15440b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1429b f15441c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1429b f15442d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15443e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f15444f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f15445g;

    /* renamed from: h  reason: collision with root package name */
    public int f15446h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15447i;
    public b.a j;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15448a;

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
            this.f15448a = eVar;
        }

        @Override // b.a.x0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f15448a.C();
                this.f15448a.f15442d.k(this.f15448a.f15445g, this.f15448a.f15444f);
                if (this.f15448a.f15447i) {
                    this.f15448a.f15447i = false;
                    this.f15448a.f15442d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(976986301, "Lb/a/r0/c4/j/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(976986301, "Lb/a/r0/c4/j/a/e;");
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
        this.f15443e = false;
        this.f15447i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f15436b.c() >= c.f15435a) {
                c.f15436b.k(0);
            }
            if (1 != c.f15436b.d().intValue()) {
                this.f15441c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f15440b = B;
        this.f15442d = B;
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
                        k.f15439a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15441c == null) {
            return;
        }
        this.f15440b.u(this.f15446h);
        this.f15440b.i(this.f15441c.o());
        this.f15440b.m(this.f15441c.a());
        this.f15440b.j(this.f15441c.p());
        this.f15441c.q();
        this.f15441c.release();
        this.f15442d = this.f15440b;
        this.f15443e = false;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.c(i2, i3, i4, i5);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void d(byte[] bArr) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1429b = this.f15442d) == this.f15440b && interfaceC1429b != null) {
            interfaceC1429b.d(bArr);
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f15440b.g(i2, i3, i4, z);
            b.InterfaceC1429b interfaceC1429b = this.f15441c;
            if (interfaceC1429b != null) {
                interfaceC1429b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void h(boolean z) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f15443e = z;
            if (z && (interfaceC1429b = this.f15441c) != null) {
                interfaceC1429b.s(this.j);
                this.f15442d = this.f15441c;
                return;
            }
            b.InterfaceC1429b interfaceC1429b2 = this.f15441c;
            if (interfaceC1429b2 != null) {
                interfaceC1429b2.release();
            }
            this.f15442d = this.f15440b;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void i(boolean z) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.i(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void j(boolean z) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.j(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f15445g = surfaceTexture;
            this.f15444f = fVar;
            if (this.f15443e && (interfaceC1429b = this.f15441c) != null) {
                if (interfaceC1429b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1429b interfaceC1429b2 = this.f15442d;
                if (interfaceC1429b2 != null) {
                    boolean k2 = interfaceC1429b2.k(surfaceTexture, fVar);
                    if (this.f15447i) {
                        this.f15447i = false;
                        this.f15442d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1429b interfaceC1429b3 = this.f15440b;
            this.f15442d = interfaceC1429b3;
            if (interfaceC1429b3 != null) {
                return interfaceC1429b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void l(int i2) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.l(i2);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void m(boolean z) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.m(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15447i = true;
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                interfaceC1429b.n();
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void q() {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.q();
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f15442d = null;
            b.InterfaceC1429b interfaceC1429b = this.f15440b;
            if (interfaceC1429b != null) {
                interfaceC1429b.release();
            }
            b.InterfaceC1429b interfaceC1429b2 = this.f15441c;
            if (interfaceC1429b2 != null) {
                interfaceC1429b2.release();
            }
            k = null;
            this.f15444f = null;
            this.f15445g = null;
            this.j = null;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void s(b.a aVar) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1429b = this.f15441c) == null) {
            return;
        }
        interfaceC1429b.s(aVar);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1429b interfaceC1429b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1429b = this.f15442d) == null) {
            return;
        }
        interfaceC1429b.t(i2, i3, i4, i5);
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f15446h = i2;
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                interfaceC1429b.u(i2);
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1429b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1429b interfaceC1429b = this.f15442d;
            if (interfaceC1429b != null) {
                return interfaceC1429b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
