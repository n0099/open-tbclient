package b.a.p0.a.f2;

import b.a.p0.a.f2.f.g;
import b.a.p0.a.f2.f.v;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.k;
import b.a.p0.a.p0.f.g.f;
import b.a.p0.a.p0.f.g.h;
import b.a.p0.a.p0.f.g.i;
import b.a.p0.a.p0.f.g.j;
import b.a.p0.a.p0.f.g.l;
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
    public static final boolean f4856b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1322778244, "Lb/a/p0/a/f2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1322778244, "Lb/a/p0/a/f2/d;");
                return;
            }
        }
        f4856b = k.f6863a;
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

    @Override // b.a.p0.a.f2.e
    public void a() {
        List<z> b2;
        List<z> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f4857a.clear();
            b(new b.a.p0.a.f1.a(this));
            b(new b.a.p0.a.e0.f.e.a(this));
            b(new b.a.p0.a.e0.f.f.a(this));
            b(new b.a.p0.a.e0.f.d.a(this));
            b(new v(this));
            b(new g(this));
            b(new b.a.p0.a.f2.f.m0.a(this));
            b(new b.a.p0.a.p0.f.g.a(this));
            b(new j(this));
            b(new b.a.p0.a.p0.f.g.b(this));
            b(new f(this));
            b(new b.a.p0.a.p0.f.g.g(this));
            b(new b.a.p0.a.p0.f.g.e(this));
            b(new b.a.p0.a.p0.f.g.k(this));
            b(new b.a.p0.a.p0.f.g.d(this));
            b(new i(this));
            b(new b.a.p0.a.b3.a(this));
            b(new h(this));
            b(new b.a.p0.a.p0.f.g.c(this));
            b.a.p0.a.p.b.a.b d2 = b.a.p0.a.c1.b.d();
            if (d2 != null && (a2 = d2.a(this)) != null && !a2.isEmpty()) {
                for (z zVar : a2) {
                    b(zVar);
                }
            }
            if (f4856b) {
                b(new l(this));
                b(new b.a.p0.a.f2.f.a(this));
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
