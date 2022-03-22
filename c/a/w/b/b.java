package c.a.w.b;

import c.a.w.b.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.w.b.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public c f21849b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.w.b.g.c f21850c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-985178524, "Lc/a/w/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-985178524, "Lc/a/w/b/b;");
        }
    }

    public b(c.a.w.b.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21850c = cVar;
        this.a = new c.a.w.b.d.a(cVar.f(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f21849b = new c.a.w.b.e.b();
            } else {
                this.f21849b = cVar;
            }
            this.f21849b.b(this.f21850c.j(), this.f21850c.i());
        }
    }

    public void b(long j) {
        c.a.w.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f21849b == null || (cVar = this.f21850c) == null) {
            return;
        }
        if (cVar.l()) {
            d();
        }
        if (j != 0) {
            this.f21850c.h().h(j);
        }
        this.f21849b.a(this.f21850c.e(), this.f21850c.h());
    }

    public c.a.w.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.w.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b2 = this.f21850c.h().b();
            c.a.w.b.h.b.b(b2);
            c.a.w.b.g.a c2 = this.f21850c.c();
            c.a.w.b.h.b.e(b2, c2.g(), c2.h());
            c.a.w.b.h.b.a(b2, c2.d());
            c.a.w.b.h.b.c(b2, c2.b());
            if ((c2.f() + 360) % 180 == 0) {
                c.a.w.b.h.b.d(b2, this.f21850c.j(), this.f21850c.i(), c2.e(), c2.c());
                return;
            }
            c.a.w.b.f.c clone = this.f21850c.i().clone();
            clone.e(this.f21850c.i().b());
            clone.d(this.f21850c.i().c());
            c.a.w.b.h.b.d(b2, this.f21850c.j(), clone, c2.e(), c2.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f21849b;
            if (cVar != null) {
                cVar.release();
                this.f21849b = null;
            }
            c.a.w.b.d.a aVar = this.a;
            if (aVar != null) {
                aVar.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c g2 = this.f21850c.g();
            this.f21849b = g2;
            a(g2);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            c.a.w.b.g.c cVar2 = this.f21850c;
            if (cVar2 != null) {
                cVar2.o(cVar);
            }
            this.f21849b.release();
            a(cVar);
        }
    }
}
