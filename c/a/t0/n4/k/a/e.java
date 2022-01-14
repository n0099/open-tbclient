package c.a.t0.n4.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.p.b;
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
public class e implements b.InterfaceC0019b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0019b f19918b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC0019b f19919c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC0019b f19920d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19921e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f19922f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f19923g;

    /* renamed from: h  reason: collision with root package name */
    public int f19924h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19925i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f19926j;

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

        @Override // c.a.a1.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f19920d.k(this.a.f19923g, this.a.f19922f);
                if (this.a.f19925i) {
                    this.a.f19925i = false;
                    this.a.f19920d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1948883196, "Lc/a/t0/n4/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1948883196, "Lc/a/t0/n4/k/a/e;");
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
        this.f19921e = false;
        this.f19925i = false;
        this.f19926j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f19915b.c() >= c.a) {
                c.f19915b.k(0);
            }
            if (1 != c.f19915b.d().intValue()) {
                this.f19919c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f19918b = B;
        this.f19920d = B;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19919c == null) {
            return;
        }
        this.f19918b.u(this.f19924h);
        this.f19918b.i(this.f19919c.o());
        this.f19918b.m(this.f19919c.a());
        this.f19918b.j(this.f19919c.p());
        this.f19919c.q();
        this.f19919c.release();
        this.f19920d = this.f19918b;
        this.f19921e = false;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.c(i2, i3, i4, i5);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void d(byte[] bArr) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC0019b = this.f19920d) == this.f19918b && interfaceC0019b != null) {
            interfaceC0019b.d(bArr);
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f19918b.g(i2, i3, i4, z);
            b.InterfaceC0019b interfaceC0019b = this.f19919c;
            if (interfaceC0019b != null) {
                interfaceC0019b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void h(boolean z) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f19921e = z;
            if (z && (interfaceC0019b = this.f19919c) != null) {
                interfaceC0019b.s(this.f19926j);
                this.f19920d = this.f19919c;
                return;
            }
            b.InterfaceC0019b interfaceC0019b2 = this.f19919c;
            if (interfaceC0019b2 != null) {
                interfaceC0019b2.release();
            }
            this.f19920d = this.f19918b;
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void i(boolean z) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.i(z);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void j(boolean z) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.j(z);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f19923g = surfaceTexture;
            this.f19922f = fVar;
            if (this.f19921e && (interfaceC0019b = this.f19919c) != null) {
                if (interfaceC0019b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC0019b interfaceC0019b2 = this.f19920d;
                if (interfaceC0019b2 != null) {
                    boolean k2 = interfaceC0019b2.k(surfaceTexture, fVar);
                    if (this.f19925i) {
                        this.f19925i = false;
                        this.f19920d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC0019b interfaceC0019b3 = this.f19918b;
            this.f19920d = interfaceC0019b3;
            if (interfaceC0019b3 != null) {
                return interfaceC0019b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void l(int i2) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.l(i2);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void m(boolean z) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.m(z);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f19925i = true;
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                interfaceC0019b.n();
            }
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void q() {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.q();
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f19920d = null;
            b.InterfaceC0019b interfaceC0019b = this.f19918b;
            if (interfaceC0019b != null) {
                interfaceC0019b.release();
            }
            b.InterfaceC0019b interfaceC0019b2 = this.f19919c;
            if (interfaceC0019b2 != null) {
                interfaceC0019b2.release();
            }
            k = null;
            this.f19922f = null;
            this.f19923g = null;
            this.f19926j = null;
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void s(b.a aVar) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC0019b = this.f19919c) == null) {
            return;
        }
        interfaceC0019b.s(aVar);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC0019b = this.f19920d) == null) {
            return;
        }
        interfaceC0019b.t(i2, i3, i4, i5);
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f19924h = i2;
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                interfaceC0019b.u(i2);
            }
        }
    }

    @Override // c.a.a1.p.b.InterfaceC0019b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.f19920d;
            if (interfaceC0019b != null) {
                return interfaceC0019b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
