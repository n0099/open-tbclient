package c.a.p0.u;

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
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f11094h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f11095b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f11096c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.u.d f11097d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.u.c f11098e;

    /* renamed from: f  reason: collision with root package name */
    public int f11099f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11100g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f11101e;

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
            this.f11101e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11101e.f11098e) == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f11102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f11104g;

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
            this.f11104g = nVar;
            this.f11102e = jSONArray;
            this.f11103f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11104g.f11098e) == null) {
                return;
            }
            cVar.u(this.f11102e, this.f11103f);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f11105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f11106f;

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
            this.f11106f = nVar;
            this.f11105e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11106f.f11098e) == null) {
                return;
            }
            cVar.w(this.f11105e);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f11107e;

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
            this.f11107e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11107e.f11098e) == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f11110g;

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
            this.f11110g = nVar;
            this.f11108e = z;
            this.f11109f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11110g.f11098e) == null) {
                return;
            }
            if (this.f11108e) {
                cVar.y(this.f11109f);
            } else {
                cVar.x(this.f11109f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f11111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f11112f;

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
            this.f11112f = nVar;
            this.f11111e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11112f.f11098e) == null) {
                return;
            }
            cVar.r(this.f11111e);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f11115e;

        /* renamed from: f  reason: collision with root package name */
        public int f11116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f11117g;

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
            this.f11117g = nVar;
            this.f11115e = str;
            this.f11116f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11117g.f11098e) == null) {
                return;
            }
            cVar.a(this.f11115e, this.f11116f);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.u.k f11118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f11119f;

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
            this.f11119f = nVar;
            c.a.p0.u.k kVar = new c.a.p0.u.k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.isSampled());
            this.f11118e = kVar;
            kVar.f11087e = flow.getStartTime();
            this.f11118e.f11090h = "1";
            nVar.f11099f++;
        }

        public void a(boolean z) {
            c.a.p0.u.k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (kVar = this.f11118e) == null) {
                return;
            }
            kVar.l = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f11119f.f11098e == null) {
                return;
            }
            this.f11118e.a();
            if (!TextUtils.isEmpty(this.f11119f.f11097d.d(this.f11118e.a))) {
                c.a.p0.u.k kVar = this.f11118e;
                kVar.f11092j = this.f11119f.f11097d.d(kVar.a);
            }
            this.f11119f.f11098e.p(this.f11118e);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f11120e;

        /* renamed from: f  reason: collision with root package name */
        public int f11121f;

        /* renamed from: g  reason: collision with root package name */
        public long f11122g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f11123h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ n f11124i;

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
            this.f11124i = nVar;
            this.f11120e = str;
            this.f11121f = i2;
            this.f11122g = System.currentTimeMillis();
            this.f11123h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11124i.f11098e) == null) {
                return;
            }
            cVar.d(this.f11120e, this.f11121f, this.f11122g, this.f11123h);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f11125e;

        /* renamed from: f  reason: collision with root package name */
        public int f11126f;

        /* renamed from: g  reason: collision with root package name */
        public String f11127g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ n f11128h;

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
            this.f11128h = nVar;
            this.f11125e = str;
            this.f11126f = i2;
            this.f11127g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.u.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f11128h.f11098e) == null) {
                return;
            }
            cVar.s(this.f11125e, this.f11126f, this.f11127g);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f11129e;

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
            this.f11129e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f11129e.f11097d = c.a.p0.u.d.g();
                n nVar = this.f11129e;
                nVar.f11098e = new c.a.p0.u.c(nVar.a);
                this.f11129e.f11098e.o();
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
        this.f11100g = false;
        g(c.a.p0.u.e.getContext());
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11094h == null) {
                synchronized (n.class) {
                    if (f11094h == null) {
                        f11094h = new n();
                    }
                }
            }
            return f11094h;
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
                    if (this.f11097d != null && this.f11097d.m(str)) {
                        iVar.a(true);
                    }
                    this.f11095b.execute(iVar);
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
        this.f11095b.execute(new c.a.p0.s.a(i2));
        this.f11096c.execute(new c.a.p0.s.a(i2));
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f11095b.execute(new h(this, str, i2));
        }
    }

    public Flow d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f11099f, i2);
            c.a.p0.u.d dVar = this.f11097d;
            if (dVar != null && !dVar.c(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !c.a.p0.u.e.g().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                c.a.p0.u.d dVar2 = this.f11097d;
                if (dVar2 != null && dVar2.i(str) > 0) {
                    if (new Random().nextInt(100) >= this.f11097d.i(str)) {
                        flow.setSampled(true);
                        return flow;
                    }
                }
                c.a.p0.u.d dVar3 = this.f11097d;
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
            this.f11095b.execute(new j(this, str, i2, jSONArray));
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.a == null && context != null) {
            if (context instanceof Application) {
                this.a = context;
            } else {
                this.a = context.getApplicationContext();
            }
            int i2 = c.a.p0.d.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.f11099f = i2;
            if (i2 > 1073741823) {
                this.f11099f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            } else {
                this.f11099f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            }
            ExecutorService h2 = h();
            this.f11095b = h2;
            h2.execute(new l(this));
            this.f11096c = Executors.newSingleThreadExecutor();
        }
    }

    public final ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (c.a.p0.u.e.g() != null && !c.a.p0.u.e.g().j()) {
                if (c.a.p0.u.e.g().d() == null) {
                    return Executors.newSingleThreadExecutor();
                }
                return c.a.p0.u.e.g().d();
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
        c.a.p0.u.d dVar = this.f11097d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f11095b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, str, jSONObject, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, jSONObject, i2);
        c.a.p0.u.d dVar = this.f11097d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f11095b.execute(gVar);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f11095b.execute(new d(this));
        }
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f11095b.execute(new g(this, str, str2, i2, str3, i3));
        }
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f11095b.execute(new g(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void o(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qVar) == null) {
            this.f11095b.execute(new f(this, qVar));
        }
    }

    public void p(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, str2) == null) {
            this.f11095b.execute(new k(this, str, i2, str2));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f11100g) {
            return;
        }
        this.f11100g = true;
        this.f11095b.execute(new a(this));
    }

    public void r(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, jSONArray, str) == null) {
            r.d(jSONArray);
            this.f11096c.execute(new b(this, jSONArray, str));
        }
    }

    public void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            r.d(jSONArray);
            this.f11096c.execute(new c(this, jSONArray));
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            this.f11095b.execute(new e(this, z, str));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.p0.u.i f11113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f11114f;

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
            this.f11114f = nVar;
            this.f11113e = new c.a.p0.u.i(str, str2, i2);
        }

        public void a(boolean z) {
            c.a.p0.u.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (iVar = this.f11113e) == null) {
                return;
            }
            iVar.f11082j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f11114f.f11098e == null) {
                return;
            }
            this.f11113e.b();
            if (!TextUtils.isEmpty(this.f11114f.f11097d.d(this.f11113e.a))) {
                c.a.p0.u.i iVar = this.f11113e;
                iVar.f11081i = this.f11114f.f11097d.d(iVar.a);
            }
            c.a.p0.u.i iVar2 = this.f11113e;
            if ((iVar2.f11079g & 8) != 0) {
                this.f11114f.f11098e.l(iVar2);
            } else {
                this.f11114f.f11098e.k(iVar2);
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
            this.f11114f = nVar;
            this.f11113e = new c.a.p0.u.i(str, jSONObject, i2);
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
            this.f11114f = nVar;
            this.f11113e = new c.a.p0.u.i(str, str2, i2, str3, i3);
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
            this.f11114f = nVar;
            this.f11113e = new c.a.p0.u.i(str, str2, i2, str3, j2, i3);
        }
    }
}
