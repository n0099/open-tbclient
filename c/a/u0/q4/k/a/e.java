package c.a.u0.q4.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.b1.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e implements b.InterfaceC0021b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0021b f21586b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC0021b f21587c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC0021b f21588d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21589e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f21590f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f21591g;

    /* renamed from: h  reason: collision with root package name */
    public int f21592h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21593i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f21594j;

    /* loaded from: classes8.dex */
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

        @Override // c.a.b1.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f21588d.k(this.a.f21591g, this.a.f21590f);
                if (this.a.f21593i) {
                    this.a.f21593i = false;
                    this.a.f21588d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1347770726, "Lc/a/u0/q4/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1347770726, "Lc/a/u0/q4/k/a/e;");
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
        this.f21589e = false;
        this.f21593i = false;
        this.f21594j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f21583b.c() >= c.a) {
                c.f21583b.k(0);
            }
            if (1 != c.f21583b.d().intValue()) {
                this.f21587c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f21586b = B;
        this.f21588d = B;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21587c == null) {
            return;
        }
        this.f21586b.u(this.f21592h);
        this.f21586b.i(this.f21587c.o());
        this.f21586b.m(this.f21587c.a());
        this.f21586b.j(this.f21587c.p());
        this.f21587c.q();
        this.f21587c.release();
        this.f21588d = this.f21586b;
        this.f21589e = false;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.c(i2, i3, i4, i5);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void d(byte[] bArr) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC0021b = this.f21588d) == this.f21586b && interfaceC0021b != null) {
            interfaceC0021b.d(bArr);
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f21586b.g(i2, i3, i4, z);
            b.InterfaceC0021b interfaceC0021b = this.f21587c;
            if (interfaceC0021b != null) {
                interfaceC0021b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void h(boolean z) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f21589e = z;
            if (z && (interfaceC0021b = this.f21587c) != null) {
                interfaceC0021b.s(this.f21594j);
                this.f21588d = this.f21587c;
                return;
            }
            b.InterfaceC0021b interfaceC0021b2 = this.f21587c;
            if (interfaceC0021b2 != null) {
                interfaceC0021b2.release();
            }
            this.f21588d = this.f21586b;
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void i(boolean z) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.i(z);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void j(boolean z) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.j(z);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f21591g = surfaceTexture;
            this.f21590f = fVar;
            if (this.f21589e && (interfaceC0021b = this.f21587c) != null) {
                if (interfaceC0021b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC0021b interfaceC0021b2 = this.f21588d;
                if (interfaceC0021b2 != null) {
                    boolean k2 = interfaceC0021b2.k(surfaceTexture, fVar);
                    if (this.f21593i) {
                        this.f21593i = false;
                        this.f21588d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC0021b interfaceC0021b3 = this.f21586b;
            this.f21588d = interfaceC0021b3;
            if (interfaceC0021b3 != null) {
                return interfaceC0021b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void l(int i2) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.l(i2);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void m(boolean z) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.m(z);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f21593i = true;
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                interfaceC0021b.n();
            }
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void q() {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.q();
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f21588d = null;
            b.InterfaceC0021b interfaceC0021b = this.f21586b;
            if (interfaceC0021b != null) {
                interfaceC0021b.release();
            }
            b.InterfaceC0021b interfaceC0021b2 = this.f21587c;
            if (interfaceC0021b2 != null) {
                interfaceC0021b2.release();
            }
            k = null;
            this.f21590f = null;
            this.f21591g = null;
            this.f21594j = null;
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void s(b.a aVar) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC0021b = this.f21587c) == null) {
            return;
        }
        interfaceC0021b.s(aVar);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC0021b interfaceC0021b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC0021b = this.f21588d) == null) {
            return;
        }
        interfaceC0021b.t(i2, i3, i4, i5);
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f21592h = i2;
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                interfaceC0021b.u(i2);
            }
        }
    }

    @Override // c.a.b1.p.b.InterfaceC0021b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC0021b interfaceC0021b = this.f21588d;
            if (interfaceC0021b != null) {
                return interfaceC0021b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
