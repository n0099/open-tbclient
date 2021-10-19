package c.a.x.b;

import c.a.x.b.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.x.b.d.a f30649a;

    /* renamed from: b  reason: collision with root package name */
    public c f30650b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x.b.g.c f30651c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-956549373, "Lc/a/x/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-956549373, "Lc/a/x/b/b;");
        }
    }

    public b(c.a.x.b.g.c cVar) {
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
        this.f30651c = cVar;
        this.f30649a = new c.a.x.b.d.a(cVar.i(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f30650b = new c.a.x.b.e.b();
            } else {
                this.f30650b = cVar;
            }
            this.f30650b.b(this.f30651c.m(), this.f30651c.l());
        }
    }

    public void b(long j2) {
        c.a.x.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.f30650b == null || (cVar = this.f30651c) == null) {
            return;
        }
        if (cVar.o()) {
            d();
        }
        if (j2 != 0) {
            this.f30651c.k().k(j2);
        }
        this.f30650b.a(this.f30651c.h(), this.f30651c.k());
    }

    public c.a.x.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30649a : (c.a.x.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] e2 = this.f30651c.k().e();
            c.a.x.b.h.b.b(e2);
            c.a.x.b.g.a f2 = this.f30651c.f();
            c.a.x.b.h.b.e(e2, f2.j(), f2.k());
            c.a.x.b.h.b.a(e2, f2.g());
            c.a.x.b.h.b.c(e2, f2.e());
            if ((f2.i() + 360) % 180 == 0) {
                c.a.x.b.h.b.d(e2, this.f30651c.m(), this.f30651c.l(), f2.h(), f2.f());
                return;
            }
            c.a.x.b.f.c clone = this.f30651c.l().clone();
            clone.h(this.f30651c.l().e());
            clone.g(this.f30651c.l().f());
            c.a.x.b.h.b.d(e2, this.f30651c.m(), clone, f2.h(), f2.f());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f30650b;
            if (cVar != null) {
                cVar.release();
                this.f30650b = null;
            }
            c.a.x.b.d.a aVar = this.f30649a;
            if (aVar != null) {
                aVar.f();
                this.f30649a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c j2 = this.f30651c.j();
            this.f30650b = j2;
            a(j2);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            c.a.x.b.g.c cVar2 = this.f30651c;
            if (cVar2 != null) {
                cVar2.r(cVar);
            }
            this.f30650b.release();
            a(cVar);
        }
    }
}
