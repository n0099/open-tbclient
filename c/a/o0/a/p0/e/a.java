package c.a.o0.a.p0.e;

import androidx.annotation.Nullable;
import c.a.o0.a.e0.d;
import c.a.o0.a.k;
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
    public static final boolean f7880a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f7881b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0343a implements c.a.o0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f7882e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7883f;

        /* renamed from: c.a.o0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0344a implements c.a.o0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0343a f7884e;

            public C0344a(C0343a c0343a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0343a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7884e = c0343a;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    d.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                    c.a.o0.a.v2.e1.b bVar = this.f7884e.f7882e;
                    if (bVar != null) {
                        bVar.onCallback(exc);
                    }
                }
            }
        }

        public C0343a(a aVar, c.a.o0.a.v2.e1.b bVar, int i2) {
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
            this.f7882e = bVar;
            this.f7883f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc == null) {
                    d.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    c.a.o0.a.v2.e1.b bVar = this.f7882e;
                    if (bVar != null) {
                        bVar.onCallback(null);
                        return;
                    }
                    return;
                }
                d.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                c.a.o0.a.m2.b.o(this.f7883f, new C0344a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f7885e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7886f;

        /* renamed from: c.a.o0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0345a implements c.a.o0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7887e;

            public C0345a(b bVar) {
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
                this.f7887e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                c.a.o0.a.v2.e1.b bVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (bVar = this.f7887e.f7885e) == null) {
                    return;
                }
                bVar.onCallback(exc);
            }
        }

        public b(a aVar, c.a.o0.a.v2.e1.b bVar, int i2) {
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
            this.f7885e = bVar;
            this.f7886f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc != null) {
                    c.a.o0.a.v2.e1.b bVar = this.f7885e;
                    if (bVar != null) {
                        bVar.onCallback(exc);
                        return;
                    }
                    return;
                }
                c.a.o0.a.p0.b.h(this.f7886f, new C0345a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7888e;

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
            this.f7888e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7888e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532178787, "Lc/a/o0/a/p0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-532178787, "Lc/a/o0/a/p0/e/a;");
                return;
            }
        }
        f7880a = k.f7049a;
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
            if (f7881b == null) {
                synchronized (a.class) {
                    if (f7881b == null) {
                        f7881b = new a();
                    }
                }
            }
            return f7881b;
        }
        return (a) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.o0.a.m2.e.b.b().e(null, 0);
            c.a.o0.a.m2.e.b.b().e(null, 1);
            c.a.o0.a.p0.b.h(0, null);
            c.a.o0.a.p0.b.h(1, null);
        }
    }

    public void c(@Nullable c.a.o0.a.v2.e1.b<Exception> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) {
            d.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
            g(new C0343a(this, bVar, i2), i2);
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (f7880a) {
                String str = "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3;
            }
            c.a.o0.a.m2.b.l(i2, i3);
            c.a.o0.a.p0.b.g(i2, i3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "tryUpdateAllPresetCoresAsync", 2);
        }
    }

    public final void g(@Nullable c.a.o0.a.v2.e1.b<Exception> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bVar, i2) == null) {
            c.a.o0.a.m2.e.b.b().e(new b(this, bVar, i2), i2);
        }
    }
}
