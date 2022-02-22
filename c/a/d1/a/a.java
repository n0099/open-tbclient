package c.a.d1.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d1.a.h.a;
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
    public static final boolean f3455f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f3456g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f3457b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d1.a.h.b f3458c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3459d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d1.a.g.a f3460e;

    /* renamed from: c.a.d1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0133a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d1.b.c f3461e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f3462f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3463g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3464h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f3465i;

        public RunnableC0133a(a aVar, c.a.d1.b.c cVar, boolean z, String str, JSONObject jSONObject) {
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
            this.f3465i = aVar;
            this.f3461e = cVar;
            this.f3462f = z;
            this.f3463g = str;
            this.f3464h = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.d1.b.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f3461e) == null) {
                return;
            }
            if (this.f3462f) {
                cVar.onSuccess(this.f3463g, this.f3464h);
                this.f3465i.o(false);
                return;
            }
            String str = this.f3463g;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.f3461e.onFailure(str, this.f3464h);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f3466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f3467f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.d1.a.h.a f3468g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f3469h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f3470i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3471j;
        public final /* synthetic */ a k;

        public b(a aVar, boolean z, boolean z2, c.a.d1.a.h.a aVar2, long j2, String str, JSONObject jSONObject) {
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
            this.f3466e = z;
            this.f3467f = z2;
            this.f3468g = aVar2;
            this.f3469h = j2;
            this.f3470i = str;
            this.f3471j = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f3466e) {
                    this.k.f3458c.t(this.f3467f, this.f3468g, this.f3469h, this.f3470i);
                    this.k.o(!this.f3467f);
                } else {
                    this.k.f3458c.s(this.f3467f, this.f3468g, this.f3469h);
                }
                this.k.l(this.f3466e, this.f3468g.a(), this.f3470i, this.f3471j, this.f3468g.b());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3472e;

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
            this.f3472e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.l0.b.a.a.g()) {
                this.f3472e.f3460e = new c.a.d1.a.g.a();
                if (c.a.d1.a.b.b.f().p()) {
                    this.f3472e.f3458c = new c.a.d1.a.h.b(this.f3472e.f3459d, c.a.d1.a.c.a.f3507c);
                    this.f3472e.n();
                } else if (c.a.d1.a.b.b.f().o()) {
                    this.f3472e.f3458c = new c.a.d1.a.h.b(this.f3472e.f3459d, c.a.d1.a.c.a.f3508d);
                } else {
                    this.f3472e.f3458c = new c.a.d1.a.h.b(this.f3472e.f3459d, c.a.d1.a.c.a.f3507c);
                }
            }
        }

        public /* synthetic */ c(a aVar, RunnableC0133a runnableC0133a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3478e;

        /* renamed from: f  reason: collision with root package name */
        public String f3479f;

        /* renamed from: g  reason: collision with root package name */
        public String f3480g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f3481h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f3482i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f3483j;

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
            this.f3483j = aVar;
            this.f3478e = z;
            this.f3479f = str;
            this.f3480g = str2;
            this.f3481h = jSONObject;
            this.f3482i = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<c.a.d1.b.a> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3483j.f3460e == null || TextUtils.isEmpty(this.f3479f) || (list = this.f3483j.f3460e.a.getList()) == null || list.size() <= 0) {
                return;
            }
            for (c.a.d1.b.a aVar : list) {
                if (TextUtils.equals(this.f3479f, aVar.getBizType())) {
                    aVar.onReceiveResult(this.f3478e, this.f3479f, this.f3480g, this.f3481h, this.f3482i);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3484e;

        /* renamed from: f  reason: collision with root package name */
        public long f3485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f3486g;

        /* renamed from: c.a.d1.a.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0135a implements c.a.d1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.d1.a.h.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f3487b;

            public C0135a(f fVar, c.a.d1.a.h.a aVar) {
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
                this.f3487b = fVar;
                this.a = aVar;
            }

            @Override // c.a.d1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.f3487b.f3486g.f3458c.m(true, this.a);
                    this.f3487b.f3486g.l(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // c.a.d1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f3487b.f3486g.f3458c.u(true, this.a);
                    this.f3487b.f3486g.l(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // c.a.d1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    f fVar = this.f3487b;
                    fVar.f3486g.k(false, true, this.a, fVar.f3485f, str2, jSONObject);
                }
            }

            @Override // c.a.d1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.f3487b;
                    fVar.f3486g.k(true, true, this.a, fVar.f3485f, str2, jSONObject);
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
            this.f3486g = aVar;
            this.f3484e = z;
        }

        public final boolean a(c.a.d1.a.h.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!c.a.d1.a.b.b.f().p()) {
                    boolean unused = a.f3455f;
                    return false;
                } else if (c.a.d1.a.b.b.f().a(aVar.a())) {
                    return true;
                } else {
                    if (a.f3455f) {
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
                if (this.f3486g.f3458c == null) {
                    boolean unused = a.f3455f;
                } else if (!NetWorkUtils.isConnected(this.f3486g.f3459d)) {
                    boolean unused2 = a.f3455f;
                } else {
                    c.a.d1.a.h.a i2 = this.f3486g.f3458c.i();
                    if (i2 == null) {
                        boolean unused3 = a.f3455f;
                        return;
                    }
                    if (!a(i2)) {
                        this.f3486g.l(false, i2.a(), "component disabled", i2.b(), null);
                    }
                    if (this.f3484e || this.f3486g.f3458c.b()) {
                        this.f3486g.f3458c.p();
                        this.f3486g.f3458c.r();
                        c.a.d1.a.d.a.g().c(i2, new C0135a(this, i2));
                        return;
                    }
                    this.f3486g.a.schedule(this, c.a.d1.a.b.b.f().l(), TimeUnit.MILLISECONDS);
                    boolean unused4 = a.f3455f;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146863420, "Lc/a/d1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-146863420, "Lc/a/d1/a/a;");
                return;
            }
        }
        f3455f = AppConfig.isDebug();
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
        this.f3459d = AppRuntime.getAppContext();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.a = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new c(this, null));
        this.f3457b = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f3456g == null) {
                synchronized (a.class) {
                    if (f3456g == null) {
                        f3456g = new a();
                    }
                }
            }
            return f3456g;
        }
        return (a) invokeV.objValue;
    }

    public void j(boolean z, String str, JSONObject jSONObject, c.a.d1.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, cVar}) == null) {
            this.f3457b.execute(new RunnableC0133a(this, cVar, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, c.a.d1.a.h.a aVar, long j2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar, Long.valueOf(j2), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, aVar, j2, str, jSONObject));
        }
    }

    public final void l(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.f3457b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void n() {
        c.a.d1.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = (c.a.d1.a.e.b) ServiceManager.getService(c.a.d1.a.e.b.a)) == null) {
            return;
        }
        boolean z = f3455f;
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

    public void q(List<String> list, String str, long j2, int i2, c.a.d1.b.c cVar) {
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

    public void s(String str, String str2, c.a.d1.b.c cVar) {
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
        public c.a.d1.a.h.a f3473e;

        /* renamed from: f  reason: collision with root package name */
        public long f3474f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f3475g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.d1.b.c f3476h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f3477i;

        /* renamed from: c.a.d1.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0134a implements c.a.d1.a.e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C0134a(d dVar) {
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

            @Override // c.a.d1.a.e.c
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.f3475g) {
                        this.a.f3477i.f3458c.m(false, this.a.f3473e);
                        d dVar = this.a;
                        dVar.f3477i.l(false, dVar.f3473e.a(), "dir not found", this.a.f3473e.b(), null);
                    } else if (this.a.f3476h != null) {
                        d dVar2 = this.a;
                        dVar2.f3477i.j(false, "dir not found", dVar2.f3473e.c(), this.a.f3476h);
                    }
                }
            }

            @Override // c.a.d1.a.e.c
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.f3473e.n(jSONObject);
                    if (this.a.f3475g) {
                        this.a.f3477i.f3458c.u(false, this.a.f3473e);
                        d dVar = this.a;
                        dVar.f3477i.l(false, dVar.f3473e.a(), "zip failed", this.a.f3473e.b(), null);
                    } else if (this.a.f3476h != null) {
                        d dVar2 = this.a;
                        dVar2.f3477i.j(false, "zip failed", dVar2.f3473e.c(), this.a.f3476h);
                    }
                }
            }

            @Override // c.a.d1.a.e.c
            public void c(String str, int i2, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2, jSONObject) == null) {
                    if (!this.a.f3475g) {
                        if (this.a.f3476h != null) {
                            d dVar = this.a;
                            dVar.f3477i.j(false, str2, jSONObject, dVar.f3476h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f3477i.k(false, false, dVar2.f3473e, this.a.f3474f, str2, jSONObject);
                }
            }

            @Override // c.a.d1.a.e.c
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (!this.a.f3475g) {
                        if (this.a.f3476h != null) {
                            d dVar = this.a;
                            dVar.f3477i.j(true, str2, jSONObject, dVar.f3476h);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.f3477i.k(true, false, dVar2.f3473e, this.a.f3474f, str2, jSONObject);
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
            this.f3477i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.o(i2);
            bVar.l(jSONObject);
            bVar.m(j2);
            bVar.p(true);
            bVar.n(i3);
            this.f3473e = bVar.k();
            this.f3475g = true;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!c.a.d1.a.b.b.f().p()) {
                    boolean unused = a.f3455f;
                    if (c.a.d1.a.b.b.f().o()) {
                        this.f3477i.f3458c.c();
                    }
                    return false;
                } else if (c.a.d1.a.b.b.f().a(this.f3473e.a())) {
                    return true;
                } else {
                    if (a.f3455f) {
                        String str = "Voyager bizType " + this.f3473e.a() + " disable.";
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.d1.a.d.a.g().d(this.f3473e, new C0134a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.f3475g) {
                        this.f3477i.l(false, this.f3473e.a(), "component disabled", this.f3473e.b(), null);
                        return;
                    } else if (this.f3476h != null) {
                        this.f3477i.j(false, "component disabled", this.f3473e.c(), this.f3476h);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.f3475g) {
                    this.f3477i.f3458c.k(this.f3473e);
                }
                f();
            }
        }

        public d(a aVar, ArrayList<String> arrayList, String str, long j2, int i2, c.a.d1.b.c cVar) {
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
            this.f3477i = aVar;
            a.b bVar = new a.b(str, arrayList);
            bVar.m(j2);
            bVar.n(i2);
            bVar.p(true);
            this.f3473e = bVar.k();
            this.f3476h = cVar;
        }

        public d(a aVar, String str, String str2, c.a.d1.b.c cVar) {
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
            this.f3477i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            this.f3473e = bVar.k();
            this.f3476h = cVar;
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
            this.f3477i = aVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a.b bVar = new a.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i2);
            bVar.n(i3);
            bVar.l(jSONObject);
            this.f3473e = bVar.k();
            this.f3475g = true;
        }
    }
}
