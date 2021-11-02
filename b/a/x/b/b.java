package b.a.x.b;

import b.a.x.b.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.x.b.d.a f29368a;

    /* renamed from: b  reason: collision with root package name */
    public c f29369b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.x.b.g.c f29370c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-760035868, "Lb/a/x/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-760035868, "Lb/a/x/b/b;");
        }
    }

    public b(b.a.x.b.g.c cVar) {
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
        this.f29370c = cVar;
        this.f29368a = new b.a.x.b.d.a(cVar.g(), 1);
        d();
    }

    public final void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar == null) {
                this.f29369b = new b.a.x.b.e.b();
            } else {
                this.f29369b = cVar;
            }
            this.f29369b.b(this.f29370c.k(), this.f29370c.j());
        }
    }

    public void b(long j) {
        b.a.x.b.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f29369b == null || (cVar = this.f29370c) == null) {
            return;
        }
        if (cVar.m()) {
            d();
        }
        if (j != 0) {
            this.f29370c.i().i(j);
        }
        this.f29369b.a(this.f29370c.f(), this.f29370c.i());
    }

    public b.a.x.b.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29368a : (b.a.x.b.d.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b2 = this.f29370c.i().b();
            b.a.x.b.h.b.b(b2);
            b.a.x.b.g.a c2 = this.f29370c.c();
            b.a.x.b.h.b.e(b2, c2.h(), c2.i());
            b.a.x.b.h.b.a(b2, c2.e());
            b.a.x.b.h.b.c(b2, c2.b());
            if ((c2.g() + 360) % 180 == 0) {
                b.a.x.b.h.b.d(b2, this.f29370c.k(), this.f29370c.j(), c2.f(), c2.c());
                return;
            }
            b.a.x.b.f.c clone = this.f29370c.j().clone();
            clone.f(this.f29370c.j().b());
            clone.e(this.f29370c.j().c());
            b.a.x.b.h.b.d(b2, this.f29370c.k(), clone, c2.f(), c2.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f29369b;
            if (cVar != null) {
                cVar.release();
                this.f29369b = null;
            }
            b.a.x.b.d.a aVar = this.f29368a;
            if (aVar != null) {
                aVar.f();
                this.f29368a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c h2 = this.f29370c.h();
            this.f29369b = h2;
            a(h2);
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            b.a.x.b.g.c cVar2 = this.f29370c;
            if (cVar2 != null) {
                cVar2.p(cVar);
            }
            this.f29369b.release();
            a(cVar);
        }
    }
}
