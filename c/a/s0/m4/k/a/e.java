package c.a.s0.m4.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.y0.p.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e implements b.InterfaceC1577b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static volatile e f19728k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1577b f19729b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1577b f19730c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1577b f19731d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19732e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f19733f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f19734g;

    /* renamed from: h  reason: collision with root package name */
    public int f19735h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19736i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f19737j;

    /* loaded from: classes7.dex */
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

        @Override // c.a.y0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f19731d.k(this.a.f19734g, this.a.f19733f);
                if (this.a.f19736i) {
                    this.a.f19736i = false;
                    this.a.f19731d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-270511452, "Lc/a/s0/m4/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-270511452, "Lc/a/s0/m4/k/a/e;");
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
        this.f19732e = false;
        this.f19736i = false;
        this.f19737j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f19725b.c() >= c.a) {
                c.f19725b.k(0);
            }
            if (1 != c.f19725b.d().intValue()) {
                this.f19730c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f19729b = B;
        this.f19731d = B;
    }

    public static e D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (f19728k == null) {
                synchronized (e.class) {
                    if (f19728k == null) {
                        f19728k = new e(tbPageContext);
                    } else if (tbPageContext != null) {
                        f19728k.a = tbPageContext;
                    }
                }
            }
            return f19728k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19730c == null) {
            return;
        }
        this.f19729b.u(this.f19735h);
        this.f19729b.i(this.f19730c.o());
        this.f19729b.m(this.f19730c.a());
        this.f19729b.j(this.f19730c.p());
        this.f19730c.q();
        this.f19730c.release();
        this.f19731d = this.f19729b;
        this.f19732e = false;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.c(i2, i3, i4, i5);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void d(byte[] bArr) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1577b = this.f19731d) == this.f19729b && interfaceC1577b != null) {
            interfaceC1577b.d(bArr);
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f19729b.g(i2, i3, i4, z);
            b.InterfaceC1577b interfaceC1577b = this.f19730c;
            if (interfaceC1577b != null) {
                interfaceC1577b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void h(boolean z) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f19732e = z;
            if (z && (interfaceC1577b = this.f19730c) != null) {
                interfaceC1577b.s(this.f19737j);
                this.f19731d = this.f19730c;
                return;
            }
            b.InterfaceC1577b interfaceC1577b2 = this.f19730c;
            if (interfaceC1577b2 != null) {
                interfaceC1577b2.release();
            }
            this.f19731d = this.f19729b;
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void i(boolean z) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.i(z);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void j(boolean z) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.j(z);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f19734g = surfaceTexture;
            this.f19733f = fVar;
            if (this.f19732e && (interfaceC1577b = this.f19730c) != null) {
                if (interfaceC1577b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1577b interfaceC1577b2 = this.f19731d;
                if (interfaceC1577b2 != null) {
                    boolean k2 = interfaceC1577b2.k(surfaceTexture, fVar);
                    if (this.f19736i) {
                        this.f19736i = false;
                        this.f19731d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1577b interfaceC1577b3 = this.f19729b;
            this.f19731d = interfaceC1577b3;
            if (interfaceC1577b3 != null) {
                return interfaceC1577b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void l(int i2) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.l(i2);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void m(boolean z) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.m(z);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f19736i = true;
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                interfaceC1577b.n();
            }
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void q() {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.q();
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f19731d = null;
            b.InterfaceC1577b interfaceC1577b = this.f19729b;
            if (interfaceC1577b != null) {
                interfaceC1577b.release();
            }
            b.InterfaceC1577b interfaceC1577b2 = this.f19730c;
            if (interfaceC1577b2 != null) {
                interfaceC1577b2.release();
            }
            f19728k = null;
            this.f19733f = null;
            this.f19734g = null;
            this.f19737j = null;
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void s(b.a aVar) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1577b = this.f19730c) == null) {
            return;
        }
        interfaceC1577b.s(aVar);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1577b interfaceC1577b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1577b = this.f19731d) == null) {
            return;
        }
        interfaceC1577b.t(i2, i3, i4, i5);
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f19735h = i2;
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                interfaceC1577b.u(i2);
            }
        }
    }

    @Override // c.a.y0.p.b.InterfaceC1577b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1577b interfaceC1577b = this.f19731d;
            if (interfaceC1577b != null) {
                return interfaceC1577b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
