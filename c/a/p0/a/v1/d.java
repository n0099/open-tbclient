package c.a.p0.a.v1;

import c.a.p0.a.f0.f.g.f;
import c.a.p0.a.f0.f.g.h;
import c.a.p0.a.f0.f.g.i;
import c.a.p0.a.f0.f.g.j;
import c.a.p0.a.f0.f.g.k;
import c.a.p0.a.f0.f.g.l;
import c.a.p0.a.v1.f.g;
import c.a.p0.a.v1.f.v;
import c.a.p0.a.v1.f.z;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Service
/* loaded from: classes.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7829b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831966164, "Lc/a/p0/a/v1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831966164, "Lc/a/p0/a/v1/d;");
                return;
            }
        }
        f7829b = c.a.p0.a.a.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.v1.e
    public void a() {
        List<z> b2;
        List<z> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new c.a.p0.a.v0.a(this));
            b(new c.a.p0.a.u.f.e.a(this));
            b(new c.a.p0.a.u.f.f.a(this));
            b(new c.a.p0.a.u.f.d.a(this));
            b(new v(this));
            b(new g(this));
            b(new c.a.p0.a.v1.f.m0.a(this));
            b(new c.a.p0.a.f0.f.g.a(this));
            b(new j(this));
            b(new c.a.p0.a.f0.f.g.b(this));
            b(new f(this));
            b(new c.a.p0.a.f0.f.g.g(this));
            b(new c.a.p0.a.f0.f.g.e(this));
            b(new k(this));
            b(new c.a.p0.a.f0.f.g.d(this));
            b(new i(this));
            b(new c.a.p0.a.r2.a(this));
            b(new h(this));
            b(new c.a.p0.a.f0.f.g.c(this));
            c.a.p0.a.f.b.a.b d2 = c.a.p0.a.s0.b.d();
            if (d2 != null && (a = d2.a(this)) != null && !a.isEmpty()) {
                for (z zVar : a) {
                    b(zVar);
                }
            }
            if (f7829b) {
                b(new l(this));
                b(new c.a.p0.a.v1.f.a(this));
                if (d2 == null || (b2 = d2.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (z zVar2 : b2) {
                    b(zVar2);
                }
            }
        }
    }
}
