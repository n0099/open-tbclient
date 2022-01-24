package c.a.c1.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c1.a.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f2563f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f2564g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f2565b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.c1.a.h.b f2566c;

    /* renamed from: d  reason: collision with root package name */
    public Context f2567d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.c1.a.g.a f2568e;

    /* renamed from: c.a.c1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0104a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c1.b.c f2569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f2570f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f2571g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2572h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f2573i;

        public RunnableC0104a(a aVar, c.a.c1.b.c cVar, boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2573i = aVar;
            this.f2569e = cVar;
            this.f2570f = z;
            this.f2571g = str;
            this.f2572h = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.c1.b.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f2569e) == null) {
                return;
            }
            if (this.f2570f) {
                cVar.onSuccess(this.f2571g, this.f2572h);
                this.f2573i.o(false);
                return;
            }
            String str = this.f2571g;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.f2569e.onFailure(str, this.f2572h);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f2574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f2575f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.c1.a.h.a f2576g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f2577h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f2578i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2579j;
        public final /* synthetic */ a k;

        public b(a aVar, boolean z, boolean z2, c.a.c1.a.h.a aVar2, long j2, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), Boolean.valueOf(z2), aVar2, Long.valueOf(j2), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f2574e = z;
            this.f2575f = z2;
            this.f2576g = aVar2;
            this.f2577h = j2;
            this.f2578i = str;
            this.f2579j = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f2574e) {
                    this.k.f2566c.t(this.f2575f, this.f2576g, this.f2577h, this.f2578i);
                    this.k.o(!this.f2575f);
                } else {
                    this.k.f2566c.s(this.f2575f, this.f2576g, this.f2577h);
                }
                this.k.l(this.f2574e, this.f2576g.a(), this.f2578i, this.f2579j, this.f2576g.b());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2580e;

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
            this.f2580e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.k0.b.a.a.g()) {
                this.f2580e.f2568e = new c.a.c1.a.g.a();
                if (c.a.c1.a.b.b.f().p()) {
                    this.f2580e.f2566c = new c.a.c1.a.h.b(this.f2580e.f2567d, c.a.c1.a.c.a.f2615c);
                    this.f2580e.n();
                } else if (c.a.c1.a.b.b.f().o()) {
                    this.f2580e.f2566c = new c.a.c1.a.h.b(this.f2580e.f2567d, c.a.c1.a.c.a.f2616d);
                } else {
                    this.f2580e.f2566c = new c.a.c1.a.h.b(this.f2580e.f2567d, c.a.c1.a.c.a.f2615c);
                }
            }
        }

        public /* synthetic */ c(a aVar, RunnableC0104a runnableC0104a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2586e;

        /* renamed from: f  reason: collision with root package name */
        public String f2587f;

        /* renamed from: g  reason: collision with root package name */
        public String f2588g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f2589h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f2590i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f2591j;

        public e(a aVar, boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), str, str2, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2591j = aVar;
            this.f2586e = z;
            this.f2587f = str;
            this.f2588g = str2;
            this.f2589h = jSONObject;
            this.f2590i = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<c.a.c1.b.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f2591j.f2568e == null || TextUtils.isEmpty(this.f2587f) || (list = this.f2591j.f2568e.a.getList()) == null || list.size() <= 0) {
                return;
            }
            for (c.a.c1.b.a aVar : list) {
                if (TextUtils.equals(this.f2587f, aVar.getBizType())) {
                    aVar.onReceiveResult(this.f2586e, this.f2587f, this.f2588g, this.f2589h, this.f2590i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2592e;

        /* renamed from: f  reason: collision with root package name */
        public long f2593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f2594g;

        /* renamed from: c.a.c1.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0106a implements c.a.c1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.c1.a.h.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f2595b;

            public C0106a(f fVar, c.a.c1.a.h.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2595b = fVar;
                this.a = aVar;
            }

            @Override // c.a.c1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.f2595b.f2594g.f2566c.m(true, this.a);
                    this.f2595b.f2594g.l(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // c.a.c1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f2595b.f2594g.f2566c.u(true, this.a);
                    this.f2595b.f2594g.l(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // c.a.c1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    f fVar = this.f2595b;
                    fVar.f2594g.k(false, true, this.a, fVar.f2593f, str2, jSONObject);
                }
            }

            @Override // c.a.c1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.f2595b;
                    fVar.f2594g.k(true, true, this.a, fVar.f2593f, str2, jSONObject);
                }
            }
        }

        public f(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2594g = aVar;
            this.f2592e = z;
        }

        public final boolean a(c.a.c1.a.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!c.a.c1.a.b.b.f().p()) {
                    boolean unused = a.f2563f;
                    return false;
                } else if (c.a.c1.a.b.b.f().a(aVar.a())) {
                    return true;
                } else {
                    if (a.f2563f) {
                        String str = "Voyager bizType " + aVar.a() + " disable.";
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f2594g.f2566c == null) {
                    boolean unused = a.f2563f;
                } else if (!NetWorkUtils.isConnected(this.f2594g.f2567d)) {
                    boolean unused2 = a.f2563f;
                } else {
                    c.a.c1.a.h.a i2 = this.f2594g.f2566c.i();
                    if (i2 == null) {
                        boolean unused3 = a.f2563f;
                        return;
                    }
                    if (!a(i2)) {
                        this.f2594g.l(false, i2.a(), "component disabled", i2.b(), null);
                    }
                    if (this.f2592e || this.f2594g.f2566c.b()) {
                        this.f2594g.f2566c.p();
                        this.f2594g.f2566c.r();
                        c.a.c1.a.d.a.g().c(i2, new C0106a(this, i2));
                        return;
                    }
                    this.f2594g.a.schedule(this, c.a.c1.a.b.b.f().l(), TimeUnit.MILLISECONDS);
                    boolean unused4 = a.f2563f;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1034367101, "Lc/a/c1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1034367101, "Lc/a/c1/a/a;");
                return;
            }
        }
        f2563f = AppConfig.isDebug();
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
                return;
            }
        }
        this.f2567d = AppRuntime.getAppContext();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.a = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new c(this, null));
        this.f2565b = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f2564g == null) {
                synchronized (a.class) {
                    if (f2564g == null) {
                        f2564g = new a();
                    }
                }
            }
            return f2564g;
        }
        return (a) invokeV.objValue;
    }

    public void j(boolean z, String str, JSONObject jSONObject, c.a.c1.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, cVar}) == null) {
            this.f2565b.execute(new RunnableC0104a(this, cVar, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, c.a.c1.a.h.a aVar, long j2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar, Long.valueOf(j2), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, aVar, j2, str, jSONObject));
        }
    }

    public final void l(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.f2565b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void n() {
        c.a.c1.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = (c.a.c1.a.e.b) ServiceManager.getService(c.a.c1.a.e.b.a)) == null) {
            return;
        }
        boolean z = f2563f;
        bVar.b();
        bVar.a();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a.execute(new f(this, z));
        }
    }

    public void p(List<String> list, String str, long j2, int i2, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), jSONObject}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j2, i2, i3, jSONObject));
        }
    }

    public void q(List<String> list, String str, long j2, int i2, c.a.c1.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), cVar}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j2, i2, cVar));
        }
    }

    public void r(String str, String str2, int i2, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject}) == null) {
            this.a.execute(new d(this, str, str2, i2, i3, jSONObject));
        }
    }

    public void s(String str, String str2, c.a.c1.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, cVar) == null) {
            this.a.execute(new d(this, str, str2, cVar));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.c1.a.h.a f2581e;

        /* renamed from: f  reason: collision with root package name */
        public long f2582f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2583g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.c1.b.c f2584h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f2585i;

        /* renamed from: c.a.c1.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0105a implements c.a.c1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C0105a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // c.a.c1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.f2583g) {
                        this.a.f2585i.f2566c.m(false, this.a.f2581e);
                        d dVar = this.a;
                        dVar.f2585i.l(false, dVar.f2581e.a(), "dir not found", this.a.f2581e.b(), null);
                    } else if (this.a.f2584h != null) {
                        d dVar2 = this.a;
                        dVar2.f2585i.j(false, "dir not found", dVar2.f2581e.c(), this.a.f2584h);
                    }
                }
            }

            @Override // c.a.c1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.f2581e.n(jSONObject);
                    if (this.a.f2583g) {
                        this.a.f2585i.f2566c.u(false, this.a.f2581e);
                        d dVar = this.a;
                        dVar.f2585i.l(false, dVar.f2581e.a(), "zip failed", this.a.f2581e.b(), null);
                    } else if (this.a.f2584h != null) {
                        d dVar2 = this.a;
                        dVar2.f2585i.j(false, "zip failed", dVar2.f2581e.c(), this.a.f2584h);
                    }
                }
            }

            @Override // c.a.c1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    if (!this.a.f2583g) {
                        if (this.a.f2584h != null) {
                            d dVar = this.a;
                            dVar.f2585i.j(false, str2, jSONObject, dVar.f2584h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f2585i.k(false, false, dVar2.f2581e, this.a.f2582f, str2, jSONObject);
                }
            }

            @Override // c.a.c1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (!this.a.f2583g) {
                        if (this.a.f2584h != null) {
                            d dVar = this.a;
                            dVar.f2585i.j(true, str2, jSONObject, dVar.f2584h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f2585i.k(true, false, dVar2.f2581e, this.a.f2582f, str2, jSONObject);
                }
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j2, int i2, int i3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f2585i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.o(i2);
            bVar.l(jSONObject);
            bVar.m(j2);
            bVar.p(true);
            bVar.n(i3);
            this.f2581e = bVar.k();
            this.f2583g = true;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!c.a.c1.a.b.b.f().p()) {
                    boolean unused = a.f2563f;
                    if (c.a.c1.a.b.b.f().o()) {
                        this.f2585i.f2566c.c();
                    }
                    return false;
                } else if (c.a.c1.a.b.b.f().a(this.f2581e.a())) {
                    return true;
                } else {
                    if (a.f2563f) {
                        String str = "Voyager bizType " + this.f2581e.a() + " disable.";
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.c1.a.d.a.g().d(this.f2581e, new C0105a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.f2583g) {
                        this.f2585i.l(false, this.f2581e.a(), "component disabled", this.f2581e.b(), null);
                        return;
                    } else if (this.f2584h != null) {
                        this.f2585i.j(false, "component disabled", this.f2581e.c(), this.f2584h);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.f2583g) {
                    this.f2585i.f2566c.k(this.f2581e);
                }
                f();
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j2, int i2, c.a.c1.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList, str, Long.valueOf(j2), Integer.valueOf(i2), cVar};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f2585i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.m(j2);
            bVar.n(i2);
            bVar.p(true);
            this.f2581e = bVar.k();
            this.f2584h = cVar;
        }

        public d(a aVar, String str, String str2, c.a.c1.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f2585i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            this.f2581e = bVar.k();
            this.f2584h = cVar;
        }

        public d(a aVar, String str, String str2, int i2, int i3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2585i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i2);
            bVar.n(i3);
            bVar.l(jSONObject);
            this.f2581e = bVar.k();
            this.f2583g = true;
        }
    }
}
