package b.a.r0.d4.j.a;

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
public class e implements b.InterfaceC1471b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17071a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1471b f17072b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1471b f17073c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1471b f17074d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17075e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f17076f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f17077g;

    /* renamed from: h  reason: collision with root package name */
    public int f17078h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17079i;
    public b.a j;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f17080a;

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
            this.f17080a = eVar;
        }

        @Override // b.a.x0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f17080a.C();
                this.f17080a.f17074d.k(this.f17080a.f17077g, this.f17080a.f17076f);
                if (this.f17080a.f17079i) {
                    this.f17080a.f17079i = false;
                    this.f17080a.f17074d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-830468162, "Lb/a/r0/d4/j/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-830468162, "Lb/a/r0/d4/j/a/e;");
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
        this.f17075e = false;
        this.f17079i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f17068b.c() >= c.f17067a) {
                c.f17068b.k(0);
            }
            if (1 != c.f17068b.d().intValue()) {
                this.f17073c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f17072b = B;
        this.f17074d = B;
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
                        k.f17071a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17073c == null) {
            return;
        }
        this.f17072b.u(this.f17078h);
        this.f17072b.i(this.f17073c.o());
        this.f17072b.m(this.f17073c.a());
        this.f17072b.j(this.f17073c.p());
        this.f17073c.q();
        this.f17073c.release();
        this.f17074d = this.f17072b;
        this.f17075e = false;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.c(i2, i3, i4, i5);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void d(byte[] bArr) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1471b = this.f17074d) == this.f17072b && interfaceC1471b != null) {
            interfaceC1471b.d(bArr);
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f17072b.g(i2, i3, i4, z);
            b.InterfaceC1471b interfaceC1471b = this.f17073c;
            if (interfaceC1471b != null) {
                interfaceC1471b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void h(boolean z) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f17075e = z;
            if (z && (interfaceC1471b = this.f17073c) != null) {
                interfaceC1471b.s(this.j);
                this.f17074d = this.f17073c;
                return;
            }
            b.InterfaceC1471b interfaceC1471b2 = this.f17073c;
            if (interfaceC1471b2 != null) {
                interfaceC1471b2.release();
            }
            this.f17074d = this.f17072b;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void i(boolean z) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.i(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void j(boolean z) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.j(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f17077g = surfaceTexture;
            this.f17076f = fVar;
            if (this.f17075e && (interfaceC1471b = this.f17073c) != null) {
                if (interfaceC1471b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1471b interfaceC1471b2 = this.f17074d;
                if (interfaceC1471b2 != null) {
                    boolean k2 = interfaceC1471b2.k(surfaceTexture, fVar);
                    if (this.f17079i) {
                        this.f17079i = false;
                        this.f17074d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1471b interfaceC1471b3 = this.f17072b;
            this.f17074d = interfaceC1471b3;
            if (interfaceC1471b3 != null) {
                return interfaceC1471b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void l(int i2) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.l(i2);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void m(boolean z) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.m(z);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17079i = true;
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                interfaceC1471b.n();
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void q() {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.q();
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f17074d = null;
            b.InterfaceC1471b interfaceC1471b = this.f17072b;
            if (interfaceC1471b != null) {
                interfaceC1471b.release();
            }
            b.InterfaceC1471b interfaceC1471b2 = this.f17073c;
            if (interfaceC1471b2 != null) {
                interfaceC1471b2.release();
            }
            k = null;
            this.f17076f = null;
            this.f17077g = null;
            this.j = null;
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void s(b.a aVar) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1471b = this.f17073c) == null) {
            return;
        }
        interfaceC1471b.s(aVar);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1471b interfaceC1471b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1471b = this.f17074d) == null) {
            return;
        }
        interfaceC1471b.t(i2, i3, i4, i5);
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f17078h = i2;
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                interfaceC1471b.u(i2);
            }
        }
    }

    @Override // b.a.x0.p.b.InterfaceC1471b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1471b interfaceC1471b = this.f17074d;
            if (interfaceC1471b != null) {
                return interfaceC1471b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
