package c.a.p0.a4.j.a;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.p.b;
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
public class e implements b.InterfaceC1414b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15435a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1414b f15436b;

    /* renamed from: c  reason: collision with root package name */
    public b.InterfaceC1414b f15437c;

    /* renamed from: d  reason: collision with root package name */
    public b.InterfaceC1414b f15438d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15439e;

    /* renamed from: f  reason: collision with root package name */
    public b.f f15440f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f15441g;

    /* renamed from: h  reason: collision with root package name */
    public int f15442h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15443i;

    /* renamed from: j  reason: collision with root package name */
    public b.a f15444j;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15445a;

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
            this.f15445a = eVar;
        }

        @Override // c.a.v0.p.b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.f15445a.C();
                this.f15445a.f15438d.k(this.f15445a.f15441g, this.f15445a.f15440f);
                if (this.f15445a.f15443i) {
                    this.f15445a.f15443i = false;
                    this.f15445a.f15438d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-471771684, "Lc/a/p0/a4/j/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-471771684, "Lc/a/p0/a4/j/a/e;");
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
        this.f15439e = false;
        this.f15443i = false;
        this.f15444j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - c.f15432b.c() >= c.f15431a) {
                c.f15432b.k(0);
            }
            if (1 != c.f15432b.d().intValue()) {
                this.f15437c = b.U(tbPageContext);
            }
        }
        d B = d.B(tbPageContext);
        this.f15436b = B;
        this.f15438d = B;
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
                        k.f15435a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (e) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15437c == null) {
            return;
        }
        this.f15436b.u(this.f15442h);
        this.f15436b.i(this.f15437c.o());
        this.f15436b.m(this.f15437c.a());
        this.f15436b.j(this.f15437c.p());
        this.f15437c.q();
        this.f15437c.release();
        this.f15438d = this.f15436b;
        this.f15439e = false;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void c(int i2, int i3, int i4, int i5) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.c(i2, i3, i4, i5);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void d(byte[] bArr) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (interfaceC1414b = this.f15438d) == this.f15436b && interfaceC1414b != null) {
            interfaceC1414b.d(bArr);
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f15436b.g(i2, i3, i4, z);
            b.InterfaceC1414b interfaceC1414b = this.f15437c;
            if (interfaceC1414b != null) {
                interfaceC1414b.g(i2, i3, i4, z);
            }
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void h(boolean z) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f15439e = z;
            if (z && (interfaceC1414b = this.f15437c) != null) {
                interfaceC1414b.s(this.f15444j);
                this.f15438d = this.f15437c;
                return;
            }
            b.InterfaceC1414b interfaceC1414b2 = this.f15437c;
            if (interfaceC1414b2 != null) {
                interfaceC1414b2.release();
            }
            this.f15438d = this.f15436b;
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void i(boolean z) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.i(z);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void j(boolean z) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.j(z);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.f15441g = surfaceTexture;
            this.f15440f = fVar;
            if (this.f15439e && (interfaceC1414b = this.f15437c) != null) {
                if (interfaceC1414b.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                b.InterfaceC1414b interfaceC1414b2 = this.f15438d;
                if (interfaceC1414b2 != null) {
                    boolean k2 = interfaceC1414b2.k(surfaceTexture, fVar);
                    if (this.f15443i) {
                        this.f15443i = false;
                        this.f15438d.n();
                    }
                    return k2;
                }
                return false;
            }
            b.InterfaceC1414b interfaceC1414b3 = this.f15436b;
            this.f15438d = interfaceC1414b3;
            if (interfaceC1414b3 != null) {
                return interfaceC1414b3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void l(int i2) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.l(i2);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void m(boolean z) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.m(z);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f15443i = true;
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                interfaceC1414b.n();
            }
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void q() {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.q();
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.f15438d = null;
            b.InterfaceC1414b interfaceC1414b = this.f15436b;
            if (interfaceC1414b != null) {
                interfaceC1414b.release();
            }
            b.InterfaceC1414b interfaceC1414b2 = this.f15437c;
            if (interfaceC1414b2 != null) {
                interfaceC1414b2.release();
            }
            k = null;
            this.f15440f = null;
            this.f15441g = null;
            this.f15444j = null;
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void s(b.a aVar) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (interfaceC1414b = this.f15437c) == null) {
            return;
        }
        interfaceC1414b.s(aVar);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void t(int i2, int i3, int i4, int i5) {
        b.InterfaceC1414b interfaceC1414b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) || (interfaceC1414b = this.f15438d) == null) {
            return;
        }
        interfaceC1414b.t(i2, i3, i4, i5);
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f15442h = i2;
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                interfaceC1414b.u(i2);
            }
        }
    }

    @Override // c.a.v0.p.b.InterfaceC1414b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.InterfaceC1414b interfaceC1414b = this.f15438d;
            if (interfaceC1414b != null) {
                return interfaceC1414b.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
