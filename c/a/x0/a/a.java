package c.a.x0.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.a.h.a;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f21985f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f21986g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f21987b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x0.a.h.b f21988c;

    /* renamed from: d  reason: collision with root package name */
    public Context f21989d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.x0.a.g.a f21990e;

    /* renamed from: c.a.x0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1624a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.x0.b.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f21993d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21994e;

        public RunnableC1624a(a aVar, c.a.x0.b.c cVar, boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21994e = aVar;
            this.a = cVar;
            this.f21991b = z;
            this.f21992c = str;
            this.f21993d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.x0.b.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.a) == null) {
                return;
            }
            if (this.f21991b) {
                cVar.onSuccess(this.f21992c, this.f21993d);
                this.f21994e.o(false);
                return;
            }
            String str = this.f21992c;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.a.onFailure(str, this.f21993d);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21995b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.a.h.a f21996c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f21997d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f21999f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f22000g;

        public b(a aVar, boolean z, boolean z2, c.a.x0.a.h.a aVar2, long j, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), Boolean.valueOf(z2), aVar2, Long.valueOf(j), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22000g = aVar;
            this.a = z;
            this.f21995b = z2;
            this.f21996c = aVar2;
            this.f21997d = j;
            this.f21998e = str;
            this.f21999f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    this.f22000g.f21988c.t(this.f21995b, this.f21996c, this.f21997d, this.f21998e);
                    this.f22000g.o(!this.f21995b);
                } else {
                    this.f22000g.f21988c.s(this.f21995b, this.f21996c, this.f21997d);
                }
                this.f22000g.l(this.a, this.f21996c.a(), this.f21998e, this.f21999f, this.f21996c.b());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.g0.b.a.a.g()) {
                this.a.f21990e = new c.a.x0.a.g.a();
                if (c.a.x0.a.b.b.f().p()) {
                    this.a.f21988c = new c.a.x0.a.h.b(this.a.f21989d, c.a.x0.a.c.a.f22030c);
                    this.a.n();
                } else if (c.a.x0.a.b.b.f().o()) {
                    this.a.f21988c = new c.a.x0.a.h.b(this.a.f21989d, c.a.x0.a.c.a.f22031d);
                } else {
                    this.a.f21988c = new c.a.x0.a.h.b(this.a.f21989d, c.a.x0.a.c.a.f22030c);
                }
            }
        }

        public /* synthetic */ c(a aVar, RunnableC1624a runnableC1624a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f22005b;

        /* renamed from: c  reason: collision with root package name */
        public String f22006c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f22007d;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f22008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22009f;

        public e(a aVar, boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), str, str2, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22009f = aVar;
            this.a = z;
            this.f22005b = str;
            this.f22006c = str2;
            this.f22007d = jSONObject;
            this.f22008e = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<c.a.x0.b.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22009f.f21990e == null || TextUtils.isEmpty(this.f22005b) || (list = this.f22009f.f21990e.a.getList()) == null || list.size() <= 0) {
                return;
            }
            for (c.a.x0.b.a aVar : list) {
                if (TextUtils.equals(this.f22005b, aVar.getBizType())) {
                    aVar.onReceiveResult(this.a, this.f22005b, this.f22006c, this.f22007d, this.f22008e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public long f22010b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f22011c;

        /* renamed from: c.a.x0.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1626a implements c.a.x0.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.x0.a.h.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f22012b;

            public C1626a(f fVar, c.a.x0.a.h.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22012b = fVar;
                this.a = aVar;
            }

            @Override // c.a.x0.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.f22012b.f22011c.f21988c.m(true, this.a);
                    this.f22012b.f22011c.l(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // c.a.x0.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f22012b.f22011c.f21988c.u(true, this.a);
                    this.f22012b.f22011c.l(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // c.a.x0.a.e.c
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    f fVar = this.f22012b;
                    fVar.f22011c.k(false, true, this.a, fVar.f22010b, str2, jSONObject);
                }
            }

            @Override // c.a.x0.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.f22012b;
                    fVar.f22011c.k(true, true, this.a, fVar.f22010b, str2, jSONObject);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22011c = aVar;
            this.a = z;
        }

        public final boolean a(c.a.x0.a.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!c.a.x0.a.b.b.f().p()) {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    return false;
                } else if (c.a.x0.a.b.b.f().a(aVar.a())) {
                    return true;
                } else {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + aVar.a() + " disable.");
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
                if (this.f22011c.f21988c == null) {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "TaskModel not init");
                    }
                } else if (!NetWorkUtils.isConnected(this.f22011c.f21989d)) {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "network error, won't retry ");
                    }
                } else {
                    c.a.x0.a.h.a i = this.f22011c.f21988c.i();
                    if (i == null) {
                        if (a.f21985f) {
                            Log.d("VoyagerFileProcessor", "don't have retry task ");
                            return;
                        }
                        return;
                    }
                    if (!a(i)) {
                        this.f22011c.l(false, i.a(), "component disabled", i.b(), null);
                    }
                    if (this.a || this.f22011c.f21988c.b()) {
                        this.f22011c.f21988c.p();
                        this.f22011c.f21988c.r();
                        c.a.x0.a.d.a.g().c(i, new C1626a(this, i));
                        return;
                    }
                    this.f22011c.a.schedule(this, c.a.x0.a.b.b.f().l(), TimeUnit.MILLISECONDS);
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "time error, won't retry ");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394711865, "Lc/a/x0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394711865, "Lc/a/x0/a/a;");
                return;
            }
        }
        f21985f = AppConfig.isDebug();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21989d = AppRuntime.getAppContext();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.a = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new c(this, null));
        this.f21987b = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f21986g == null) {
                synchronized (a.class) {
                    if (f21986g == null) {
                        f21986g = new a();
                    }
                }
            }
            return f21986g;
        }
        return (a) invokeV.objValue;
    }

    public void j(boolean z, String str, JSONObject jSONObject, c.a.x0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, cVar}) == null) {
            this.f21987b.execute(new RunnableC1624a(this, cVar, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, c.a.x0.a.h.a aVar, long j, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar, Long.valueOf(j), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, aVar, j, str, jSONObject));
        }
    }

    public final void l(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.f21987b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void n() {
        c.a.x0.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = (c.a.x0.a.e.b) ServiceManager.getService(c.a.x0.a.e.b.a)) == null) {
            return;
        }
        if (f21985f) {
            Log.e("VoyagerFileProcessor", "register retry listener");
        }
        bVar.b();
        bVar.a();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a.execute(new f(this, z));
        }
    }

    public void p(List<String> list, String str, long j, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, i2, jSONObject));
        }
    }

    public void q(List<String> list, String str, long j, int i, c.a.x0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), cVar}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, cVar));
        }
    }

    public void r(String str, String str2, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, str, str2, i, i2, jSONObject));
        }
    }

    public void s(String str, String str2, c.a.x0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, cVar) == null) {
            this.a.execute(new d(this, str, str2, cVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.x0.a.h.a a;

        /* renamed from: b  reason: collision with root package name */
        public long f22001b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22002c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.x0.b.c f22003d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22004e;

        /* renamed from: c.a.x0.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1625a implements c.a.x0.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C1625a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // c.a.x0.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.f22002c) {
                        this.a.f22004e.f21988c.m(false, this.a.a);
                        d dVar = this.a;
                        dVar.f22004e.l(false, dVar.a.a(), "dir not found", this.a.a.b(), null);
                    } else if (this.a.f22003d != null) {
                        d dVar2 = this.a;
                        dVar2.f22004e.j(false, "dir not found", dVar2.a.c(), this.a.f22003d);
                    }
                }
            }

            @Override // c.a.x0.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.a.n(jSONObject);
                    if (this.a.f22002c) {
                        this.a.f22004e.f21988c.u(false, this.a.a);
                        d dVar = this.a;
                        dVar.f22004e.l(false, dVar.a.a(), "zip failed", this.a.a.b(), null);
                    } else if (this.a.f22003d != null) {
                        d dVar2 = this.a;
                        dVar2.f22004e.j(false, "zip failed", dVar2.a.c(), this.a.f22003d);
                    }
                }
            }

            @Override // c.a.x0.a.e.c
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    if (!this.a.f22002c) {
                        if (this.a.f22003d != null) {
                            d dVar = this.a;
                            dVar.f22004e.j(false, str2, jSONObject, dVar.f22003d);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f22004e.k(false, false, dVar2.a, this.a.f22001b, str2, jSONObject);
                }
            }

            @Override // c.a.x0.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (!this.a.f22002c) {
                        if (this.a.f22003d != null) {
                            d dVar = this.a;
                            dVar.f22004e.j(true, str2, jSONObject, dVar.f22003d);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f22004e.k(true, false, dVar2.a, this.a.f22001b, str2, jSONObject);
                }
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f22004e = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.o(i);
            bVar.l(jSONObject);
            bVar.m(j);
            bVar.p(true);
            bVar.n(i2);
            this.a = bVar.k();
            this.f22002c = true;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!c.a.x0.a.b.b.f().p()) {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    if (c.a.x0.a.b.b.f().o()) {
                        this.f22004e.f21988c.c();
                    }
                    return false;
                } else if (c.a.x0.a.b.b.f().a(this.a.a())) {
                    return true;
                } else {
                    if (a.f21985f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + this.a.a() + " disable.");
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.x0.a.d.a.g().d(this.a, new C1625a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.f22002c) {
                        this.f22004e.l(false, this.a.a(), "component disabled", this.a.b(), null);
                        return;
                    } else if (this.f22003d != null) {
                        this.f22004e.j(false, "component disabled", this.a.c(), this.f22003d);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.f22002c) {
                    this.f22004e.f21988c.k(this.a);
                }
                f();
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j, int i, c.a.x0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList, str, Long.valueOf(j), Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f22004e = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.m(j);
            bVar.n(i);
            bVar.p(true);
            this.a = bVar.k();
            this.f22003d = cVar;
        }

        public d(a aVar, String str, String str2, c.a.x0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f22004e = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            this.a = bVar.k();
            this.f22003d = cVar;
        }

        public d(a aVar, String str, String str2, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22004e = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i);
            bVar.n(i2);
            bVar.l(jSONObject);
            this.a = bVar.k();
            this.f22002c = true;
        }
    }
}
