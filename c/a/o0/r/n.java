package c.a.o0.r;

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
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f12277h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12278a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f12279b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f12280c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.d f12281d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.c f12282e;

    /* renamed from: f  reason: collision with root package name */
    public int f12283f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12284g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12285e;

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
            this.f12285e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12285e.f12282e) == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f12286e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12287f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12288g;

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
            this.f12288g = nVar;
            this.f12286e = jSONArray;
            this.f12287f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12288g.f12282e) == null) {
                return;
            }
            cVar.u(this.f12286e, this.f12287f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f12289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12290f;

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
            this.f12290f = nVar;
            this.f12289e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12290f.f12282e) == null) {
                return;
            }
            cVar.w(this.f12289e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12291e;

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
            this.f12291e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12291e.f12282e) == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12293f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12294g;

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
            this.f12294g = nVar;
            this.f12292e = z;
            this.f12293f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12294g.f12282e) == null) {
                return;
            }
            if (this.f12292e) {
                cVar.y(this.f12293f);
            } else {
                cVar.x(this.f12293f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f12295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12296f;

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
            this.f12296f = nVar;
            this.f12295e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12296f.f12282e) == null) {
                return;
            }
            cVar.r(this.f12295e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12299e;

        /* renamed from: f  reason: collision with root package name */
        public int f12300f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f12301g;

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
            this.f12301g = nVar;
            this.f12299e = str;
            this.f12300f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12301g.f12282e) == null) {
                return;
            }
            cVar.a(this.f12299e, this.f12300f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.o0.r.k f12302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12303f;

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
            this.f12303f = nVar;
            c.a.o0.r.k kVar = new c.a.o0.r.k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.isSampled());
            this.f12302e = kVar;
            kVar.f12271e = flow.getStartTime();
            this.f12302e.f12274h = "1";
            nVar.f12283f++;
        }

        public void a(boolean z) {
            c.a.o0.r.k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (kVar = this.f12302e) == null) {
                return;
            }
            kVar.l = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12303f.f12282e == null) {
                return;
            }
            this.f12302e.a();
            if (!TextUtils.isEmpty(this.f12303f.f12281d.d(this.f12302e.f12267a))) {
                c.a.o0.r.k kVar = this.f12302e;
                kVar.f12276j = this.f12303f.f12281d.d(kVar.f12267a);
            }
            this.f12303f.f12282e.p(this.f12302e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12304e;

        /* renamed from: f  reason: collision with root package name */
        public int f12305f;

        /* renamed from: g  reason: collision with root package name */
        public long f12306g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f12307h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ n f12308i;

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
            this.f12308i = nVar;
            this.f12304e = str;
            this.f12305f = i2;
            this.f12306g = System.currentTimeMillis();
            this.f12307h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12308i.f12282e) == null) {
                return;
            }
            cVar.d(this.f12304e, this.f12305f, this.f12306g, this.f12307h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f12309e;

        /* renamed from: f  reason: collision with root package name */
        public int f12310f;

        /* renamed from: g  reason: collision with root package name */
        public String f12311g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ n f12312h;

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
            this.f12312h = nVar;
            this.f12309e = str;
            this.f12310f = i2;
            this.f12311g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.o0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12312h.f12282e) == null) {
                return;
            }
            cVar.s(this.f12309e, this.f12310f, this.f12311g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f12313e;

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
            this.f12313e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f12313e.f12281d = c.a.o0.r.d.g();
                n nVar = this.f12313e;
                nVar.f12282e = new c.a.o0.r.c(nVar.f12278a);
                this.f12313e.f12282e.o();
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
        this.f12284g = false;
        g(c.a.o0.r.e.f());
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12277h == null) {
                synchronized (n.class) {
                    if (f12277h == null) {
                        f12277h = new n();
                    }
                }
            }
            return f12277h;
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
                    if (this.f12281d != null && this.f12281d.m(str)) {
                        iVar.a(true);
                    }
                    this.f12279b.execute(iVar);
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
        this.f12279b.execute(new c.a.o0.p.a(i2));
        this.f12280c.execute(new c.a.o0.p.a(i2));
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f12279b.execute(new h(this, str, i2));
        }
    }

    public Flow d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f12283f, i2);
            c.a.o0.r.d dVar = this.f12281d;
            if (dVar != null && !dVar.c(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !c.a.o0.r.e.h().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.o0.r.d dVar2 = this.f12281d;
                if (dVar2 != null && dVar2.i(str) > 0) {
                    if (new Random().nextInt(100) >= this.f12281d.i(str)) {
                        flow.setSampled(true);
                        return flow;
                    }
                }
                c.a.o0.r.d dVar3 = this.f12281d;
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
            this.f12279b.execute(new j(this, str, i2, jSONArray));
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f12278a == null && context != null) {
            if (context instanceof Application) {
                this.f12278a = context;
            } else {
                this.f12278a = context.getApplicationContext();
            }
            int i2 = c.a.o0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.f12283f = i2;
            if (i2 > 1073741823) {
                this.f12283f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            } else {
                this.f12283f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            }
            ExecutorService h2 = h();
            this.f12279b = h2;
            h2.execute(new l(this));
            this.f12280c = Executors.newSingleThreadExecutor();
        }
    }

    public final ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (c.a.o0.r.e.h() != null && !c.a.o0.r.e.h().j()) {
                if (c.a.o0.r.e.h().d() == null) {
                    return Executors.newSingleThreadExecutor();
                }
                return c.a.o0.r.e.h().d();
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
        c.a.o0.r.d dVar = this.f12281d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f12279b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, str, jSONObject, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, jSONObject, i2);
        c.a.o0.r.d dVar = this.f12281d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f12279b.execute(gVar);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12279b.execute(new d(this));
        }
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f12279b.execute(new g(this, str, str2, i2, str3, i3));
        }
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f12279b.execute(new g(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void o(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qVar) == null) {
            this.f12279b.execute(new f(this, qVar));
        }
    }

    public void p(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, str2) == null) {
            this.f12279b.execute(new k(this, str, i2, str2));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f12284g) {
            return;
        }
        this.f12284g = true;
        this.f12279b.execute(new a(this));
    }

    public void r(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, jSONArray, str) == null) {
            r.d(jSONArray);
            this.f12280c.execute(new b(this, jSONArray, str));
        }
    }

    public void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            r.d(jSONArray);
            this.f12280c.execute(new c(this, jSONArray));
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            this.f12279b.execute(new e(this, z, str));
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.o0.r.i f12297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f12298f;

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
            this.f12298f = nVar;
            this.f12297e = new c.a.o0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            c.a.o0.r.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (iVar = this.f12297e) == null) {
                return;
            }
            iVar.f12265j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f12298f.f12282e == null) {
                return;
            }
            this.f12297e.b();
            if (!TextUtils.isEmpty(this.f12298f.f12281d.d(this.f12297e.f12256a))) {
                c.a.o0.r.i iVar = this.f12297e;
                iVar.f12264i = this.f12298f.f12281d.d(iVar.f12256a);
            }
            c.a.o0.r.i iVar2 = this.f12297e;
            if ((iVar2.f12262g & 8) != 0) {
                this.f12298f.f12282e.l(iVar2);
            } else {
                this.f12298f.f12282e.k(iVar2);
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
            this.f12298f = nVar;
            this.f12297e = new c.a.o0.r.i(str, jSONObject, i2);
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
            this.f12298f = nVar;
            this.f12297e = new c.a.o0.r.i(str, str2, i2, str3, i3);
        }

        public g(n nVar, String str, String str2, int i2, String str3, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f12298f = nVar;
            this.f12297e = new c.a.o0.r.i(str, str2, i2, str3, j2, i3);
        }
    }
}
