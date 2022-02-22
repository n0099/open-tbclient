package c.a.z.b;

import c.a.z.b.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.z.b.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public c f26957b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.z.b.g.c f26958c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-899291071, "Lc/a/z/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-899291071, "Lc/a/z/b/b;");
        }
    }

    public b(c.a.z.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26958c = cVar;
        this.a = new c.a.z.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f26957b = new c.a.z.b.e.b();
            } else {
                this.f26957b = cVar;
            }
            this.f26957b.b(this.f26958c.k(), this.f26958c.j());
        }
    }

    public void b(long j2) {
        c.a.z.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f26957b == null || (cVar = this.f26958c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j2 != 0) {
            this.f26958c.i().i(j2);
        }
        this.f26957b.a(this.f26958c.f(), this.f26958c.i());
    }

    public c.a.z.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.z.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b2 = this.f26958c.i().b();
            c.a.z.b.h.b.b(b2);
            c.a.z.b.g.a c2 = this.f26958c.c();
            c.a.z.b.h.b.e(b2, c2.h(), c2.i());
            c.a.z.b.h.b.a(b2, c2.e());
            c.a.z.b.h.b.c(b2, c2.b());
            if ((c2.g() + 360) % 180 == 0) {
                c.a.z.b.h.b.d(b2, this.f26958c.k(), this.f26958c.j(), c2.f(), c2.c());
                return;
            }
            c.a.z.b.f.c clone = this.f26958c.j().clone();
            clone.f(this.f26958c.j().b());
            clone.e(this.f26958c.j().c());
            c.a.z.b.h.b.d(b2, this.f26958c.k(), clone, c2.f(), c2.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f26957b;
            if (cVar != null) {
                cVar.release();
                this.f26957b = null;
            }
            c.a.z.b.d.a aVar = this.a;
            if (aVar != null) {
                aVar.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c h2 = this.f26958c.h();
            this.f26957b = h2;
            a(h2);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            c.a.z.b.g.c cVar2 = this.f26958c;
            if (cVar2 != null) {
                cVar2.p(cVar);
            }
            this.f26957b.release();
            a(cVar);
        }
    }
}
