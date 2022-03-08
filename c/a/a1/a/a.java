package c.a.a1.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.a.h.a;
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
    public static final boolean f1282f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f1283g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f1284b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.a1.a.h.b f1285c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1286d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.a1.a.g.a f1287e;

    /* renamed from: c.a.a1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0015a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.a1.b.c f1288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f1289f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f1290g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1291h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f1292i;

        public RunnableC0015a(a aVar, c.a.a1.b.c cVar, boolean z, String str, JSONObject jSONObject) {
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
            this.f1292i = aVar;
            this.f1288e = cVar;
            this.f1289f = z;
            this.f1290g = str;
            this.f1291h = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.a1.b.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f1288e) == null) {
                return;
            }
            if (this.f1289f) {
                cVar.onSuccess(this.f1290g, this.f1291h);
                this.f1292i.o(false);
                return;
            }
            String str = this.f1290g;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.f1288e.onFailure(str, this.f1291h);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f1293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f1294f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.a1.a.h.a f1295g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f1296h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f1297i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1298j;
        public final /* synthetic */ a k;

        public b(a aVar, boolean z, boolean z2, c.a.a1.a.h.a aVar2, long j2, String str, JSONObject jSONObject) {
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
            this.f1293e = z;
            this.f1294f = z2;
            this.f1295g = aVar2;
            this.f1296h = j2;
            this.f1297i = str;
            this.f1298j = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1293e) {
                    this.k.f1285c.t(this.f1294f, this.f1295g, this.f1296h, this.f1297i);
                    this.k.o(!this.f1294f);
                } else {
                    this.k.f1285c.s(this.f1294f, this.f1295g, this.f1296h);
                }
                this.k.l(this.f1293e, this.f1295g.a(), this.f1297i, this.f1298j, this.f1295g.b());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1299e;

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
            this.f1299e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.i0.b.a.a.g()) {
                this.f1299e.f1287e = new c.a.a1.a.g.a();
                if (c.a.a1.a.b.b.f().p()) {
                    this.f1299e.f1285c = new c.a.a1.a.h.b(this.f1299e.f1286d, c.a.a1.a.c.a.f1334c);
                    this.f1299e.n();
                } else if (c.a.a1.a.b.b.f().o()) {
                    this.f1299e.f1285c = new c.a.a1.a.h.b(this.f1299e.f1286d, c.a.a1.a.c.a.f1335d);
                } else {
                    this.f1299e.f1285c = new c.a.a1.a.h.b(this.f1299e.f1286d, c.a.a1.a.c.a.f1334c);
                }
            }
        }

        public /* synthetic */ c(a aVar, RunnableC0015a runnableC0015a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1305e;

        /* renamed from: f  reason: collision with root package name */
        public String f1306f;

        /* renamed from: g  reason: collision with root package name */
        public String f1307g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f1308h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f1309i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f1310j;

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
            this.f1310j = aVar;
            this.f1305e = z;
            this.f1306f = str;
            this.f1307g = str2;
            this.f1308h = jSONObject;
            this.f1309i = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<c.a.a1.b.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1310j.f1287e == null || TextUtils.isEmpty(this.f1306f) || (list = this.f1310j.f1287e.a.getList()) == null || list.size() <= 0) {
                return;
            }
            for (c.a.a1.b.a aVar : list) {
                if (TextUtils.equals(this.f1306f, aVar.getBizType())) {
                    aVar.onReceiveResult(this.f1305e, this.f1306f, this.f1307g, this.f1308h, this.f1309i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1311e;

        /* renamed from: f  reason: collision with root package name */
        public long f1312f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f1313g;

        /* renamed from: c.a.a1.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0017a implements c.a.a1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.a1.a.h.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f1314b;

            public C0017a(f fVar, c.a.a1.a.h.a aVar) {
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
                this.f1314b = fVar;
                this.a = aVar;
            }

            @Override // c.a.a1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.f1314b.f1313g.f1285c.m(true, this.a);
                    this.f1314b.f1313g.l(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // c.a.a1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f1314b.f1313g.f1285c.u(true, this.a);
                    this.f1314b.f1313g.l(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // c.a.a1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    f fVar = this.f1314b;
                    fVar.f1313g.k(false, true, this.a, fVar.f1312f, str2, jSONObject);
                }
            }

            @Override // c.a.a1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.f1314b;
                    fVar.f1313g.k(true, true, this.a, fVar.f1312f, str2, jSONObject);
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
            this.f1313g = aVar;
            this.f1311e = z;
        }

        public final boolean a(c.a.a1.a.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!c.a.a1.a.b.b.f().p()) {
                    boolean unused = a.f1282f;
                    return false;
                } else if (c.a.a1.a.b.b.f().a(aVar.a())) {
                    return true;
                } else {
                    if (a.f1282f) {
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
                if (this.f1313g.f1285c == null) {
                    boolean unused = a.f1282f;
                } else if (!NetWorkUtils.isConnected(this.f1313g.f1286d)) {
                    boolean unused2 = a.f1282f;
                } else {
                    c.a.a1.a.h.a i2 = this.f1313g.f1285c.i();
                    if (i2 == null) {
                        boolean unused3 = a.f1282f;
                        return;
                    }
                    if (!a(i2)) {
                        this.f1313g.l(false, i2.a(), "component disabled", i2.b(), null);
                    }
                    if (this.f1311e || this.f1313g.f1285c.b()) {
                        this.f1313g.f1285c.p();
                        this.f1313g.f1285c.r();
                        c.a.a1.a.d.a.g().c(i2, new C0017a(this, i2));
                        return;
                    }
                    this.f1313g.a.schedule(this, c.a.a1.a.b.b.f().l(), TimeUnit.MILLISECONDS);
                    boolean unused4 = a.f1282f;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1485592833, "Lc/a/a1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1485592833, "Lc/a/a1/a/a;");
                return;
            }
        }
        f1282f = AppConfig.isDebug();
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
        this.f1286d = AppRuntime.getAppContext();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.a = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new c(this, null));
        this.f1284b = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f1283g == null) {
                synchronized (a.class) {
                    if (f1283g == null) {
                        f1283g = new a();
                    }
                }
            }
            return f1283g;
        }
        return (a) invokeV.objValue;
    }

    public void j(boolean z, String str, JSONObject jSONObject, c.a.a1.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, cVar}) == null) {
            this.f1284b.execute(new RunnableC0015a(this, cVar, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, c.a.a1.a.h.a aVar, long j2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar, Long.valueOf(j2), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, aVar, j2, str, jSONObject));
        }
    }

    public final void l(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.f1284b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void n() {
        c.a.a1.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = (c.a.a1.a.e.b) ServiceManager.getService(c.a.a1.a.e.b.a)) == null) {
            return;
        }
        boolean z = f1282f;
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

    public void q(List<String> list, String str, long j2, int i2, c.a.a1.b.c cVar) {
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

    public void s(String str, String str2, c.a.a1.b.c cVar) {
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
        public c.a.a1.a.h.a f1300e;

        /* renamed from: f  reason: collision with root package name */
        public long f1301f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1302g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.a1.b.c f1303h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f1304i;

        /* renamed from: c.a.a1.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0016a implements c.a.a1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C0016a(d dVar) {
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

            @Override // c.a.a1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.f1302g) {
                        this.a.f1304i.f1285c.m(false, this.a.f1300e);
                        d dVar = this.a;
                        dVar.f1304i.l(false, dVar.f1300e.a(), "dir not found", this.a.f1300e.b(), null);
                    } else if (this.a.f1303h != null) {
                        d dVar2 = this.a;
                        dVar2.f1304i.j(false, "dir not found", dVar2.f1300e.c(), this.a.f1303h);
                    }
                }
            }

            @Override // c.a.a1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.f1300e.n(jSONObject);
                    if (this.a.f1302g) {
                        this.a.f1304i.f1285c.u(false, this.a.f1300e);
                        d dVar = this.a;
                        dVar.f1304i.l(false, dVar.f1300e.a(), "zip failed", this.a.f1300e.b(), null);
                    } else if (this.a.f1303h != null) {
                        d dVar2 = this.a;
                        dVar2.f1304i.j(false, "zip failed", dVar2.f1300e.c(), this.a.f1303h);
                    }
                }
            }

            @Override // c.a.a1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    if (!this.a.f1302g) {
                        if (this.a.f1303h != null) {
                            d dVar = this.a;
                            dVar.f1304i.j(false, str2, jSONObject, dVar.f1303h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f1304i.k(false, false, dVar2.f1300e, this.a.f1301f, str2, jSONObject);
                }
            }

            @Override // c.a.a1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (!this.a.f1302g) {
                        if (this.a.f1303h != null) {
                            d dVar = this.a;
                            dVar.f1304i.j(true, str2, jSONObject, dVar.f1303h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f1304i.k(true, false, dVar2.f1300e, this.a.f1301f, str2, jSONObject);
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
            this.f1304i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.o(i2);
            bVar.l(jSONObject);
            bVar.m(j2);
            bVar.p(true);
            bVar.n(i3);
            this.f1300e = bVar.k();
            this.f1302g = true;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!c.a.a1.a.b.b.f().p()) {
                    boolean unused = a.f1282f;
                    if (c.a.a1.a.b.b.f().o()) {
                        this.f1304i.f1285c.c();
                    }
                    return false;
                } else if (c.a.a1.a.b.b.f().a(this.f1300e.a())) {
                    return true;
                } else {
                    if (a.f1282f) {
                        String str = "Voyager bizType " + this.f1300e.a() + " disable.";
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.a1.a.d.a.g().d(this.f1300e, new C0016a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.f1302g) {
                        this.f1304i.l(false, this.f1300e.a(), "component disabled", this.f1300e.b(), null);
                        return;
                    } else if (this.f1303h != null) {
                        this.f1304i.j(false, "component disabled", this.f1300e.c(), this.f1303h);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.f1302g) {
                    this.f1304i.f1285c.k(this.f1300e);
                }
                f();
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j2, int i2, c.a.a1.b.c cVar) {
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
            this.f1304i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.m(j2);
            bVar.n(i2);
            bVar.p(true);
            this.f1300e = bVar.k();
            this.f1303h = cVar;
        }

        public d(a aVar, String str, String str2, c.a.a1.b.c cVar) {
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
            this.f1304i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            this.f1300e = bVar.k();
            this.f1303h = cVar;
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
            this.f1304i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i2);
            bVar.n(i3);
            bVar.l(jSONObject);
            this.f1300e = bVar.k();
            this.f1302g = true;
        }
    }
}
