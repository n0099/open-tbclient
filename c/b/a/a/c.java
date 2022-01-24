package c.b.a.a;

import androidx.core.view.InputDeviceCompat;
import c.b.a.a.j;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.badlogic.ashley.core.EntityManager;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.a.b.a<c.b.a.a.d> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.a.b.a<c.b.a.a.d> f26913b;

    /* renamed from: c  reason: collision with root package name */
    public j f26914c;

    /* renamed from: d  reason: collision with root package name */
    public EntityManager f26915d;

    /* renamed from: e  reason: collision with root package name */
    public ComponentOperationHandler f26916e;

    /* renamed from: f  reason: collision with root package name */
    public h f26917f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26918g;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b implements c.b.a.b.a<c.b.a.a.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.a.b.a
        /* renamed from: b */
        public void a(c.b.a.b.b<c.b.a.a.d> bVar, c.b.a.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                this.a.f26917f.f(dVar);
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* renamed from: c.b.a.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1611c implements ComponentOperationHandler.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1611c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.badlogic.ashley.core.ComponentOperationHandler.b
        public boolean value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.f26918g : invokeV.booleanValue;
        }

        public /* synthetic */ C1611c(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.b.a.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26919e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26919e = cVar;
        }

        @Override // c.b.a.a.e
        public void a(c.b.a.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                this.f26919e.n(dVar);
            }
        }

        @Override // c.b.a.a.e
        public void b(c.b.a.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                this.f26919e.d(dVar);
            }
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.b.a.a.j.c
        public void a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.h(this.a);
            }
        }

        @Override // c.b.a.a.j.c
        public void b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                fVar.d(this.a);
            }
        }

        public /* synthetic */ e(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(127760729, "Lc/b/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(127760729, "Lc/b/a/a/c;");
                return;
            }
        }
        g.d(new Class[0]).b();
    }

    public c() {
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
        this.a = new b(this, null);
        this.f26913b = new b(this, null);
        this.f26914c = new j(new e(this, null));
        this.f26915d = new EntityManager(new d(this, null));
        this.f26916e = new ComponentOperationHandler(new C1611c(this, null));
        this.f26917f = new h(this.f26915d.c());
    }

    public void c(c.b.a.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f26915d.a(dVar, this.f26918g || this.f26917f.c());
        }
    }

    public void d(c.b.a.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            dVar.a.a(this.a);
            dVar.f26920b.a(this.f26913b);
            dVar.f26923e = this.f26916e;
            this.f26917f.f(dVar);
        }
    }

    public void e(g gVar, int i2, c.b.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, gVar, i2, eVar) == null) {
            this.f26917f.a(gVar, i2, eVar);
        }
    }

    public void f(g gVar, c.b.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, gVar, eVar) == null) {
            e(gVar, 0, eVar);
        }
    }

    public void g(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f26914c.a(fVar);
        }
    }

    public <T extends c.b.a.a.a> T h(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            try {
                return (T) c.b.b.q.p0.b.i(cls);
            } catch (ReflectionException unused) {
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    public c.b.a.a.d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new c.b.a.a.d() : (c.b.a.a.d) invokeV.objValue;
    }

    public c.b.a.c.b<c.b.a.a.d> j(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gVar)) == null) ? this.f26917f.b(gVar) : (c.b.a.c.b) invokeL.objValue;
    }

    public <T extends f> T k(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) ? (T) this.f26914c.b(cls) : (T) invokeL.objValue;
    }

    public c.b.a.c.b<f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26914c.c() : (c.b.a.c.b) invokeV.objValue;
    }

    public void m(c.b.a.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.f26915d.e(dVar, this.f26918g || this.f26917f.c());
        }
    }

    public void n(c.b.a.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f26917f.f(dVar);
            dVar.a.c(this.a);
            dVar.f26920b.c(this.f26913b);
            dVar.f26923e = null;
        }
    }

    public void o(c.b.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.f26917f.e(eVar);
        }
    }

    public void p(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f26914c.d(fVar);
        }
    }

    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            if (!this.f26918g) {
                this.f26918g = true;
                c.b.a.c.b<f> c2 = this.f26914c.c();
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    try {
                        f fVar = c2.get(i2);
                        if (fVar.e()) {
                            fVar.update(f2);
                        }
                        this.f26916e.b();
                        this.f26915d.d();
                    } finally {
                        this.f26918g = false;
                    }
                }
                return;
            }
            throw new IllegalStateException("Cannot call update() on an Engine that is already updating.");
        }
    }
}
