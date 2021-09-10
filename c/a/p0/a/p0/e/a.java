package c.a.p0.a.p0.e;

import androidx.annotation.Nullable;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7908a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f7909b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0345a implements c.a.p0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f7910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7911f;

        /* renamed from: c.a.p0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0346a implements c.a.p0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0345a f7912e;

            public C0346a(C0345a c0345a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0345a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7912e = c0345a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    d.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                    c.a.p0.a.v2.e1.b bVar = this.f7912e.f7910e;
                    if (bVar != null) {
                        bVar.onCallback(exc);
                    }
                }
            }
        }

        public C0345a(a aVar, c.a.p0.a.v2.e1.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7910e = bVar;
            this.f7911f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc == null) {
                    d.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    c.a.p0.a.v2.e1.b bVar = this.f7910e;
                    if (bVar != null) {
                        bVar.onCallback(null);
                        return;
                    }
                    return;
                }
                d.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                c.a.p0.a.m2.b.o(this.f7911f, new C0346a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f7913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7914f;

        /* renamed from: c.a.p0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0347a implements c.a.p0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7915e;

            public C0347a(b bVar) {
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
                this.f7915e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                c.a.p0.a.v2.e1.b bVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (bVar = this.f7915e.f7913e) == null) {
                    return;
                }
                bVar.onCallback(exc);
            }
        }

        public b(a aVar, c.a.p0.a.v2.e1.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7913e = bVar;
            this.f7914f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc != null) {
                    c.a.p0.a.v2.e1.b bVar = this.f7913e;
                    if (bVar != null) {
                        bVar.onCallback(exc);
                        return;
                    }
                    return;
                }
                c.a.p0.a.p0.b.h(this.f7914f, new C0347a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7916e;

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
            this.f7916e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7916e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-403096068, "Lc/a/p0/a/p0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-403096068, "Lc/a/p0/a/p0/e/a;");
                return;
            }
        }
        f7908a = k.f7077a;
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
            if (f7909b == null) {
                synchronized (a.class) {
                    if (f7909b == null) {
                        f7909b = new a();
                    }
                }
            }
            return f7909b;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.a.m2.e.b.b().e(null, 0);
            c.a.p0.a.m2.e.b.b().e(null, 1);
            c.a.p0.a.p0.b.h(0, null);
            c.a.p0.a.p0.b.h(1, null);
        }
    }

    public void c(@Nullable c.a.p0.a.v2.e1.b<Exception> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) {
            d.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
            g(new C0345a(this, bVar, i2), i2);
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (f7908a) {
                String str = "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3;
            }
            c.a.p0.a.m2.b.l(i2, i3);
            c.a.p0.a.p0.b.g(i2, i3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "tryUpdateAllPresetCoresAsync", 2);
        }
    }

    public final void g(@Nullable c.a.p0.a.v2.e1.b<Exception> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bVar, i2) == null) {
            c.a.p0.a.m2.e.b.b().e(new b(this, bVar, i2), i2);
        }
    }
}
