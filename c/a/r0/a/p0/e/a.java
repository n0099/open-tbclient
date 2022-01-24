package c.a.r0.a.p0.e;

import androidx.annotation.Nullable;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f8314b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0510a implements c.a.r0.a.z2.g1.c<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f8315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8316f;

        /* renamed from: c.a.r0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0511a implements c.a.r0.a.z2.g1.c<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0510a f8317e;

            public C0511a(C0510a c0510a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0510a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8317e = c0510a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    d.l("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                    c.a.r0.a.z2.g1.c cVar = this.f8317e.f8315e;
                    if (cVar != null) {
                        cVar.onCallback(exc);
                    }
                }
            }
        }

        public C0510a(a aVar, c.a.r0.a.z2.g1.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8315e = cVar;
            this.f8316f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc == null) {
                    d.k("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    c.a.r0.a.z2.g1.c cVar = this.f8315e;
                    if (cVar != null) {
                        cVar.onCallback(null);
                        return;
                    }
                    return;
                }
                d.k("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                c.a.r0.a.q2.b.o(this.f8316f, new C0511a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.z2.g1.c<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f8318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8319f;

        /* renamed from: c.a.r0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0512a implements c.a.r0.a.z2.g1.c<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8320e;

            public C0512a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8320e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(Exception exc) {
                c.a.r0.a.z2.g1.c cVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (cVar = this.f8320e.f8318e) == null) {
                    return;
                }
                cVar.onCallback(exc);
            }
        }

        public b(a aVar, c.a.r0.a.z2.g1.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8318e = cVar;
            this.f8319f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc != null) {
                    c.a.r0.a.z2.g1.c cVar = this.f8318e;
                    if (cVar != null) {
                        cVar.onCallback(exc);
                        return;
                    }
                    return;
                }
                c.a.r0.a.p0.b.h(this.f8319f, new C0512a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8321e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8321e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8321e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144930630, "Lc/a/r0/a/p0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-144930630, "Lc/a/r0/a/p0/e/a;");
                return;
            }
        }
        a = k.a;
    }

    public a() {
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

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f8314b == null) {
                synchronized (a.class) {
                    if (f8314b == null) {
                        f8314b = new a();
                    }
                }
            }
            return f8314b;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.a.q2.e.b.b().e(null, 0);
            c.a.r0.a.q2.e.b.b().e(null, 1);
            c.a.r0.a.p0.b.h(0, null);
            c.a.r0.a.p0.b.h(1, null);
        }
    }

    public void c(@Nullable c.a.r0.a.z2.g1.c<Exception> cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i2) == null) {
            d.k("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
            g(new C0510a(this, cVar, i2), i2);
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (a) {
                String str = "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3;
            }
            c.a.r0.a.q2.b.l(i2, i3);
            c.a.r0.a.p0.b.g(i2, i3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "tryUpdateAllPresetCoresAsync", 2);
        }
    }

    public final void g(@Nullable c.a.r0.a.z2.g1.c<Exception> cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, cVar, i2) == null) {
            c.a.r0.a.q2.e.b.b().e(new b(this, cVar, i2), i2);
        }
    }
}
