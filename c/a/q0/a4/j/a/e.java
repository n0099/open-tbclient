package c.a.q0.a4.j.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.p.b;
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
public class e implements b.InterfaceC1424b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15721a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1424b f15722b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1424b f15723c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1424b f15724d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15725e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f15726f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f15727g;

    /* renamed from: h  reason: collision with root package name */
    public int f15728h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15729i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f15730j;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15731a;

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
            this.f15731a = eVar;
        }

        @Override // c.a.w0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f15731a.C();
                this.f15731a.f15724d.k(this.f15731a.f15727g, this.f15731a.f15726f);
                if (this.f15731a.f15729i) {
                    this.f15731a.f15729i = false;
                    this.f15731a.f15724d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-342688965, "Lc/a/q0/a4/j/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-342688965, "Lc/a/q0/a4/j/a/e;");
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
        this.f15725e = false;
        this.f15729i = false;
        this.f15730j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f15718b.c() >= c.f15717a) {
                c.f15718b.k(0);
            }
            if (1 != c.f15718b.d().intValue()) {
                this.f15723c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f15722b = B;
        this.f15724d = B;
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
                        k.f15721a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15723c == null) {
            return;
        }
        this.f15722b.u(this.f15728h);
        this.f15722b.i(this.f15723c.o());
        this.f15722b.m(this.f15723c.a());
        this.f15722b.j(this.f15723c.p());
        this.f15723c.q();
        this.f15723c.release();
        this.f15724d = this.f15722b;
        this.f15725e = false;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.c(i2, i3, i4, i5);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void d(byte[] bArr) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1424b = this.f15724d) == this.f15722b && interfaceC1424b != null) {
            interfaceC1424b.d(bArr);
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f15722b.g(i2, i3, i4, z);
            b.InterfaceC1424b interfaceC1424b = this.f15723c;
            if (interfaceC1424b != null) {
                interfaceC1424b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void h(boolean z) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f15725e = z;
            if (z && (interfaceC1424b = this.f15723c) != null) {
                interfaceC1424b.s(this.f15730j);
                this.f15724d = this.f15723c;
                return;
            }
            b.InterfaceC1424b interfaceC1424b2 = this.f15723c;
            if (interfaceC1424b2 != null) {
                interfaceC1424b2.release();
            }
            this.f15724d = this.f15722b;
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void i(boolean z) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.i(z);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void j(boolean z) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.j(z);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f15727g = surfaceTexture;
            this.f15726f = fVar;
            if (this.f15725e && (interfaceC1424b = this.f15723c) != null) {
                if (interfaceC1424b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1424b interfaceC1424b2 = this.f15724d;
                if (interfaceC1424b2 != null) {
                    boolean k2 = interfaceC1424b2.k(surfaceTexture, fVar);
                    if (this.f15729i) {
                        this.f15729i = false;
                        this.f15724d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1424b interfaceC1424b3 = this.f15722b;
            this.f15724d = interfaceC1424b3;
            if (interfaceC1424b3 != null) {
                return interfaceC1424b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void l(int i2) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.l(i2);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void m(boolean z) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.m(z);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15729i = true;
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                interfaceC1424b.n();
            }
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void q() {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.q();
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f15724d = null;
            b.InterfaceC1424b interfaceC1424b = this.f15722b;
            if (interfaceC1424b != null) {
                interfaceC1424b.release();
            }
            b.InterfaceC1424b interfaceC1424b2 = this.f15723c;
            if (interfaceC1424b2 != null) {
                interfaceC1424b2.release();
            }
            k = null;
            this.f15726f = null;
            this.f15727g = null;
            this.f15730j = null;
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void s(b.a aVar) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1424b = this.f15723c) == null) {
            return;
        }
        interfaceC1424b.s(aVar);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1424b interfaceC1424b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1424b = this.f15724d) == null) {
            return;
        }
        interfaceC1424b.t(i2, i3, i4, i5);
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f15728h = i2;
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                interfaceC1424b.u(i2);
            }
        }
    }

    @Override // c.a.w0.p.b.InterfaceC1424b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1424b interfaceC1424b = this.f15724d;
            if (interfaceC1424b != null) {
                return interfaceC1424b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
