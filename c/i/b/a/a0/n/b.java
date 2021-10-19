package c.i.b.a.a0.n;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.e;
import c.i.b.a.a0.f;
import c.i.b.a.a0.g;
import c.i.b.a.a0.k;
import c.i.b.a.a0.l;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class b implements e, l {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.i0.l f32505a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f32506b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f32507c;

    /* renamed from: d  reason: collision with root package name */
    public final c.i.b.a.i0.l f32508d;

    /* renamed from: e  reason: collision with root package name */
    public g f32509e;

    /* renamed from: f  reason: collision with root package name */
    public int f32510f;

    /* renamed from: g  reason: collision with root package name */
    public int f32511g;

    /* renamed from: h  reason: collision with root package name */
    public int f32512h;

    /* renamed from: i  reason: collision with root package name */
    public int f32513i;

    /* renamed from: j  reason: collision with root package name */
    public long f32514j;
    public a k;
    public d l;
    public c m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445210815, "Lc/i/b/a/a0/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445210815, "Lc/i/b/a/a0/n/b;");
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
        this.f32505a = new c.i.b.a.i0.l(4);
        this.f32506b = new c.i.b.a.i0.l(9);
        this.f32507c = new c.i.b.a.i0.l(11);
        this.f32508d = new c.i.b.a.i0.l();
        this.f32510f = 1;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f32510f = 1;
            this.f32511g = 0;
        }
    }

    @Override // c.i.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.i.b.a.a0.l
    public long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            fVar.c(this.f32505a.f33839a, 0, 3);
            this.f32505a.J(0);
            if (this.f32505a.A() != n) {
                return false;
            }
            fVar.c(this.f32505a.f33839a, 0, 2);
            this.f32505a.J(0);
            if ((this.f32505a.D() & 250) != 0) {
                return false;
            }
            fVar.c(this.f32505a.f33839a, 0, 4);
            this.f32505a.J(0);
            int i2 = this.f32505a.i();
            fVar.e();
            fVar.g(i2);
            fVar.c(this.f32505a.f33839a, 0, 4);
            this.f32505a.J(0);
            return this.f32505a.i() == 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f32510f;
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

    @Override // c.i.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f32509e = gVar;
        }
    }

    @Override // c.i.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.d() : invokeV.longValue;
    }

    public final c.i.b.a.i0.l i(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            if (this.f32513i > this.f32508d.b()) {
                c.i.b.a.i0.l lVar = this.f32508d;
                lVar.H(new byte[Math.max(lVar.b() * 2, this.f32513i)], 0);
            } else {
                this.f32508d.J(0);
            }
            this.f32508d.I(this.f32513i);
            fVar.readFully(this.f32508d.f33839a, 0, this.f32513i);
            return this.f32508d;
        }
        return (c.i.b.a.i0.l) invokeL.objValue;
    }

    public final boolean j(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) {
            if (fVar.a(this.f32506b.f33839a, 0, 9, true)) {
                this.f32506b.J(0);
                this.f32506b.K(4);
                int x = this.f32506b.x();
                boolean z = (x & 4) != 0;
                boolean z2 = (x & 1) != 0;
                if (z && this.k == null) {
                    this.k = new a(this.f32509e.a(8, 1));
                }
                if (z2 && this.l == null) {
                    this.l = new d(this.f32509e.a(9, 2));
                }
                if (this.m == null) {
                    this.m = new c(null);
                }
                this.f32509e.j();
                this.f32509e.p(this);
                this.f32511g = (this.f32506b.i() - 9) + 4;
                this.f32510f = 2;
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
            if (this.f32512h == 8 && (aVar = this.k) != null) {
                aVar.a(i(fVar), this.f32514j);
            } else if (this.f32512h == 9 && (dVar = this.l) != null) {
                dVar.a(i(fVar), this.f32514j);
            } else if (this.f32512h == 18 && (cVar = this.m) != null) {
                cVar.a(i(fVar), this.f32514j);
            } else {
                fVar.h(this.f32513i);
                z = false;
                this.f32511g = 4;
                this.f32510f = 2;
                return z;
            }
            z = true;
            this.f32511g = 4;
            this.f32510f = 2;
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fVar)) == null) {
            if (fVar.a(this.f32507c.f33839a, 0, 11, true)) {
                this.f32507c.J(0);
                this.f32512h = this.f32507c.x();
                this.f32513i = this.f32507c.A();
                this.f32514j = this.f32507c.A();
                this.f32514j = ((this.f32507c.x() << 24) | this.f32514j) * 1000;
                this.f32507c.K(3);
                this.f32510f = 4;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            fVar.h(this.f32511g);
            this.f32511g = 0;
            this.f32510f = 3;
        }
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }
}
