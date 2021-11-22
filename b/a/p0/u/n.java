package b.a.p0.u;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes4.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f12213h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12214a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f12215b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f12216c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.u.d f12217d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.u.c f12218e;

    /* renamed from: f  reason: collision with root package name */
    public int f12219f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12220g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12221e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12221e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12221e.f12218e) == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f12222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12224g;

        public b(n nVar, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12224g = nVar;
            this.f12222e = jSONArray;
            this.f12223f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12224g.f12218e) == null) {
                return;
            }
            cVar.u(this.f12222e, this.f12223f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f12225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12226f;

        public c(n nVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12226f = nVar;
            this.f12225e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12226f.f12218e) == null) {
                return;
            }
            cVar.w(this.f12225e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12227e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12227e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12227e.f12218e) == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12230g;

        public e(n nVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12230g = nVar;
            this.f12228e = z;
            this.f12229f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12230g.f12218e) == null) {
                return;
            }
            if (this.f12228e) {
                cVar.y(this.f12229f);
            } else {
                cVar.x(this.f12229f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f12231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12232f;

        public f(n nVar, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12232f = nVar;
            this.f12231e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12232f.f12218e) == null) {
                return;
            }
            cVar.r(this.f12231e);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12235e;

        /* renamed from: f  reason: collision with root package name */
        public int f12236f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12237g;

        public h(n nVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12237g = nVar;
            this.f12235e = str;
            this.f12236f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12237g.f12218e) == null) {
                return;
            }
            cVar.a(this.f12235e, this.f12236f);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.p0.u.k f12238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12239f;

        public i(n nVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12239f = nVar;
            b.a.p0.u.k kVar = new b.a.p0.u.k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.isSampled());
            this.f12238e = kVar;
            kVar.f12208e = flow.getStartTime();
            this.f12238e.f12211h = "1";
            nVar.f12219f++;
        }

        public void a(boolean z) {
            b.a.p0.u.k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (kVar = this.f12238e) == null) {
                return;
            }
            kVar.l = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12239f.f12218e == null) {
                return;
            }
            this.f12238e.a();
            if (!TextUtils.isEmpty(this.f12239f.f12217d.d(this.f12238e.f12204a))) {
                b.a.p0.u.k kVar = this.f12238e;
                kVar.j = this.f12239f.f12217d.d(kVar.f12204a);
            }
            this.f12239f.f12218e.p(this.f12238e);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12240e;

        /* renamed from: f  reason: collision with root package name */
        public int f12241f;

        /* renamed from: g  reason: collision with root package name */
        public long f12242g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f12243h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ n f12244i;

        public j(n nVar, String str, int i2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12244i = nVar;
            this.f12240e = str;
            this.f12241f = i2;
            this.f12242g = System.currentTimeMillis();
            this.f12243h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12244i.f12218e) == null) {
                return;
            }
            cVar.d(this.f12240e, this.f12241f, this.f12242g, this.f12243h);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12245e;

        /* renamed from: f  reason: collision with root package name */
        public int f12246f;

        /* renamed from: g  reason: collision with root package name */
        public String f12247g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ n f12248h;

        public k(n nVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12248h = nVar;
            this.f12245e = str;
            this.f12246f = i2;
            this.f12247g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12248h.f12218e) == null) {
                return;
            }
            cVar.s(this.f12245e, this.f12246f, this.f12247g);
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12249e;

        public l(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12249e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f12249e.f12217d = b.a.p0.u.d.g();
                n nVar = this.f12249e;
                nVar.f12218e = new b.a.p0.u.c(nVar.f12214a);
                this.f12249e.f12218e.o();
            }
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12220g = false;
        g(b.a.p0.u.e.getContext());
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12213h == null) {
                synchronized (n.class) {
                    if (f12213h == null) {
                        f12213h = new n();
                    }
                }
            }
            return f12213h;
        }
        return (n) invokeV.objValue;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i2)) == null) {
            synchronized (this) {
                d2 = d(str, i2);
                if (d2 != null && d2.getValid()) {
                    i iVar = new i(this, d2, str2);
                    if (this.f12217d != null && this.f12217d.m(str)) {
                        iVar.a(true);
                    }
                    this.f12215b.execute(iVar);
                }
            }
            return d2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f12215b.execute(new b.a.p0.s.a(i2));
        this.f12216c.execute(new b.a.p0.s.a(i2));
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f12215b.execute(new h(this, str, i2));
        }
    }

    public Flow d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f12219f, i2);
            b.a.p0.u.d dVar = this.f12217d;
            if (dVar != null && !dVar.c(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !b.a.p0.u.e.g().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                b.a.p0.u.d dVar2 = this.f12217d;
                if (dVar2 != null && dVar2.i(str) > 0) {
                    if (new Random().nextInt(100) >= this.f12217d.i(str)) {
                        flow.setSampled(true);
                        return flow;
                    }
                }
                b.a.p0.u.d dVar3 = this.f12217d;
                if (dVar3 != null && dVar3.l(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, jSONArray) == null) {
            this.f12215b.execute(new j(this, str, i2, jSONArray));
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f12214a == null && context != null) {
            if (context instanceof Application) {
                this.f12214a = context;
            } else {
                this.f12214a = context.getApplicationContext();
            }
            int i2 = b.a.p0.d.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.f12219f = i2;
            if (i2 > 1073741823) {
                this.f12219f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            } else {
                this.f12219f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            }
            ExecutorService h2 = h();
            this.f12215b = h2;
            h2.execute(new l(this));
            this.f12216c = Executors.newSingleThreadExecutor();
        }
    }

    public final ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (b.a.p0.u.e.g() != null && !b.a.p0.u.e.g().j()) {
                if (b.a.p0.u.e.g().d() == null) {
                    return Executors.newSingleThreadExecutor();
                }
                return b.a.p0.u.e.g().d();
            }
            return Executors.newSingleThreadExecutor();
        }
        return (ExecutorService) invokeV.objValue;
    }

    public boolean i(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) ? TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20 : invokeLI.booleanValue;
    }

    public void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, str2, i2);
        b.a.p0.u.d dVar = this.f12217d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f12215b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, str, jSONObject, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, jSONObject, i2);
        b.a.p0.u.d dVar = this.f12217d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f12215b.execute(gVar);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12215b.execute(new d(this));
        }
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f12215b.execute(new g(this, str, str2, i2, str3, i3));
        }
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f12215b.execute(new g(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void o(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qVar) == null) {
            this.f12215b.execute(new f(this, qVar));
        }
    }

    public void p(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, str2) == null) {
            this.f12215b.execute(new k(this, str, i2, str2));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f12220g) {
            return;
        }
        this.f12220g = true;
        this.f12215b.execute(new a(this));
    }

    public void r(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, jSONArray, str) == null) {
            r.d(jSONArray);
            this.f12216c.execute(new b(this, jSONArray, str));
        }
    }

    public void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            r.d(jSONArray);
            this.f12216c.execute(new c(this, jSONArray));
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            this.f12215b.execute(new e(this, z, str));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public b.a.p0.u.i f12233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12234f;

        public g(n nVar, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12234f = nVar;
            this.f12233e = new b.a.p0.u.i(str, str2, i2);
        }

        public void a(boolean z) {
            b.a.p0.u.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (iVar = this.f12233e) == null) {
                return;
            }
            iVar.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12234f.f12218e == null) {
                return;
            }
            this.f12233e.b();
            if (!TextUtils.isEmpty(this.f12234f.f12217d.d(this.f12233e.f12194a))) {
                b.a.p0.u.i iVar = this.f12233e;
                iVar.f12202i = this.f12234f.f12217d.d(iVar.f12194a);
            }
            b.a.p0.u.i iVar2 = this.f12233e;
            if ((iVar2.f12200g & 8) != 0) {
                this.f12234f.f12218e.l(iVar2);
            } else {
                this.f12234f.f12218e.k(iVar2);
            }
        }

        public g(n nVar, String str, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f12234f = nVar;
            this.f12233e = new b.a.p0.u.i(str, jSONObject, i2);
        }

        public g(n nVar, String str, String str2, int i2, String str3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f12234f = nVar;
            this.f12233e = new b.a.p0.u.i(str, str2, i2, str3, i3);
        }

        public g(n nVar, String str, String str2, int i2, String str3, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f12234f = nVar;
            this.f12233e = new b.a.p0.u.i(str, str2, i2, str3, j, i3);
        }
    }
}
