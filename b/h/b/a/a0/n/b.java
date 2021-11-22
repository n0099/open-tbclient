package b.h.b.a.a0.n;

import androidx.core.view.InputDeviceCompat;
import b.h.b.a.a0.e;
import b.h.b.a.a0.f;
import b.h.b.a.a0.g;
import b.h.b.a.a0.k;
import b.h.b.a.a0.l;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class b implements e, l {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.i0.l f32241a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.i0.l f32242b;

    /* renamed from: c  reason: collision with root package name */
    public final b.h.b.a.i0.l f32243c;

    /* renamed from: d  reason: collision with root package name */
    public final b.h.b.a.i0.l f32244d;

    /* renamed from: e  reason: collision with root package name */
    public g f32245e;

    /* renamed from: f  reason: collision with root package name */
    public int f32246f;

    /* renamed from: g  reason: collision with root package name */
    public int f32247g;

    /* renamed from: h  reason: collision with root package name */
    public int f32248h;

    /* renamed from: i  reason: collision with root package name */
    public int f32249i;
    public long j;
    public a k;
    public d l;
    public c m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1659359617, "Lb/h/b/a/a0/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1659359617, "Lb/h/b/a/a0/n/b;");
                return;
            }
        }
        n = v.q("FLV");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32241a = new b.h.b.a.i0.l(4);
        this.f32242b = new b.h.b.a.i0.l(9);
        this.f32243c = new b.h.b.a.i0.l(11);
        this.f32244d = new b.h.b.a.i0.l();
        this.f32246f = 1;
    }

    @Override // b.h.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f32246f = 1;
            this.f32247g = 0;
        }
    }

    @Override // b.h.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.h.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // b.h.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            fVar.c(this.f32241a.f33493a, 0, 3);
            this.f32241a.J(0);
            if (this.f32241a.A() != n) {
                return false;
            }
            fVar.c(this.f32241a.f33493a, 0, 2);
            this.f32241a.J(0);
            if ((this.f32241a.D() & 250) != 0) {
                return false;
            }
            fVar.c(this.f32241a.f33493a, 0, 4);
            this.f32241a.J(0);
            int i2 = this.f32241a.i();
            fVar.e();
            fVar.g(i2);
            fVar.c(this.f32241a.f33493a, 0, 4);
            this.f32241a.J(0);
            return this.f32241a.i() == 0;
        }
        return invokeL.booleanValue;
    }

    @Override // b.h.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f32246f;
            if (i2 != 1) {
                if (i2 == 2) {
                    m(fVar);
                } else if (i2 != 3) {
                    if (i2 == 4 && k(fVar)) {
                        return 0;
                    }
                } else if (!l(fVar)) {
                    return -1;
                }
            } else if (!j(fVar)) {
                return -1;
            }
        }
    }

    @Override // b.h.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f32245e = gVar;
        }
    }

    @Override // b.h.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.d() : invokeV.longValue;
    }

    public final b.h.b.a.i0.l i(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            if (this.f32249i > this.f32244d.b()) {
                b.h.b.a.i0.l lVar = this.f32244d;
                lVar.H(new byte[Math.max(lVar.b() * 2, this.f32249i)], 0);
            } else {
                this.f32244d.J(0);
            }
            this.f32244d.I(this.f32249i);
            fVar.readFully(this.f32244d.f33493a, 0, this.f32249i);
            return this.f32244d;
        }
        return (b.h.b.a.i0.l) invokeL.objValue;
    }

    public final boolean j(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) {
            if (fVar.a(this.f32242b.f33493a, 0, 9, true)) {
                this.f32242b.J(0);
                this.f32242b.K(4);
                int x = this.f32242b.x();
                boolean z = (x & 4) != 0;
                boolean z2 = (x & 1) != 0;
                if (z && this.k == null) {
                    this.k = new a(this.f32245e.a(8, 1));
                }
                if (z2 && this.l == null) {
                    this.l = new d(this.f32245e.a(9, 2));
                }
                if (this.m == null) {
                    this.m = new c(null);
                }
                this.f32245e.j();
                this.f32245e.p(this);
                this.f32247g = (this.f32242b.i() - 9) + 4;
                this.f32246f = 2;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean k(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        c cVar;
        d dVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fVar)) == null) {
            if (this.f32248h == 8 && (aVar = this.k) != null) {
                aVar.a(i(fVar), this.j);
            } else if (this.f32248h == 9 && (dVar = this.l) != null) {
                dVar.a(i(fVar), this.j);
            } else if (this.f32248h == 18 && (cVar = this.m) != null) {
                cVar.a(i(fVar), this.j);
            } else {
                fVar.h(this.f32249i);
                z = false;
                this.f32247g = 4;
                this.f32246f = 2;
                return z;
            }
            z = true;
            this.f32247g = 4;
            this.f32246f = 2;
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fVar)) == null) {
            if (fVar.a(this.f32243c.f33493a, 0, 11, true)) {
                this.f32243c.J(0);
                this.f32248h = this.f32243c.x();
                this.f32249i = this.f32243c.A();
                this.j = this.f32243c.A();
                this.j = ((this.f32243c.x() << 24) | this.j) * 1000;
                this.f32243c.K(3);
                this.f32246f = 4;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            fVar.h(this.f32247g);
            this.f32247g = 0;
            this.f32246f = 3;
        }
    }

    @Override // b.h.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }
}
