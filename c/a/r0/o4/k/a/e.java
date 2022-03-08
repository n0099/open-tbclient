package c.a.r0.o4.k.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.y0.o.b;
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
public class e implements b.InterfaceC1618b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1618b f20538b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1618b f20539c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1618b f20540d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20541e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f20542f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f20543g;

    /* renamed from: h  reason: collision with root package name */
    public int f20544h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20545i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f20546j;

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

        @Override // c.a.y0.o.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.f20540d.k(this.a.f20543g, this.a.f20542f);
                if (this.a.f20545i) {
                    this.a.f20545i = false;
                    this.a.f20540d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(280464199, "Lc/a/r0/o4/k/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(280464199, "Lc/a/r0/o4/k/a/e;");
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
        this.f20541e = false;
        this.f20545i = false;
        this.f20546j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f20535b.c() >= c.a) {
                c.f20535b.k(0);
            }
            if (1 != c.f20535b.d().intValue()) {
                this.f20539c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f20538b = B;
        this.f20540d = B;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20539c == null) {
            return;
        }
        this.f20538b.u(this.f20544h);
        this.f20538b.i(this.f20539c.o());
        this.f20538b.m(this.f20539c.a());
        this.f20538b.j(this.f20539c.p());
        this.f20539c.q();
        this.f20539c.release();
        this.f20540d = this.f20538b;
        this.f20541e = false;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.c(i2, i3, i4, i5);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void d(byte[] bArr) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1618b = this.f20540d) == this.f20538b && interfaceC1618b != null) {
            interfaceC1618b.d(bArr);
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f20538b.g(i2, i3, i4, z);
            b.InterfaceC1618b interfaceC1618b = this.f20539c;
            if (interfaceC1618b != null) {
                interfaceC1618b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void h(boolean z) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f20541e = z;
            if (z && (interfaceC1618b = this.f20539c) != null) {
                interfaceC1618b.s(this.f20546j);
                this.f20540d = this.f20539c;
                return;
            }
            b.InterfaceC1618b interfaceC1618b2 = this.f20539c;
            if (interfaceC1618b2 != null) {
                interfaceC1618b2.release();
            }
            this.f20540d = this.f20538b;
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void i(boolean z) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.i(z);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void j(boolean z) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.j(z);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f20543g = surfaceTexture;
            this.f20542f = fVar;
            if (this.f20541e && (interfaceC1618b = this.f20539c) != null) {
                if (interfaceC1618b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1618b interfaceC1618b2 = this.f20540d;
                if (interfaceC1618b2 != null) {
                    boolean k2 = interfaceC1618b2.k(surfaceTexture, fVar);
                    if (this.f20545i) {
                        this.f20545i = false;
                        this.f20540d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1618b interfaceC1618b3 = this.f20538b;
            this.f20540d = interfaceC1618b3;
            if (interfaceC1618b3 != null) {
                return interfaceC1618b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void l(int i2) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.l(i2);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void m(boolean z) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.m(z);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f20545i = true;
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                interfaceC1618b.n();
            }
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void q() {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.q();
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f20540d = null;
            b.InterfaceC1618b interfaceC1618b = this.f20538b;
            if (interfaceC1618b != null) {
                interfaceC1618b.release();
            }
            b.InterfaceC1618b interfaceC1618b2 = this.f20539c;
            if (interfaceC1618b2 != null) {
                interfaceC1618b2.release();
            }
            k = null;
            this.f20542f = null;
            this.f20543g = null;
            this.f20546j = null;
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void s(b.a aVar) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1618b = this.f20539c) == null) {
            return;
        }
        interfaceC1618b.s(aVar);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1618b interfaceC1618b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1618b = this.f20540d) == null) {
            return;
        }
        interfaceC1618b.t(i2, i3, i4, i5);
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f20544h = i2;
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                interfaceC1618b.u(i2);
            }
        }
    }

    @Override // c.a.y0.o.b.InterfaceC1618b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1618b interfaceC1618b = this.f20540d;
            if (interfaceC1618b != null) {
                return interfaceC1618b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
