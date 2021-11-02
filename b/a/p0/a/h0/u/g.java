package b.a.p0.a.h0.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.h0.o.i.a;
import b.a.p0.a.h0.p.a;
import b.a.p0.a.j2.c;
import b.a.p0.a.p.d.l1;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g implements b.a.p0.a.g1.h {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static final boolean B;
    public static int C;
    public static final boolean v;
    public static volatile g w;
    public static int x;
    public static boolean y;
    public static PreloadState z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanCoreVersion f5825a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f5826b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.h0.f.d.b f5827c;

    /* renamed from: d  reason: collision with root package name */
    public List<q> f5828d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.h0.l.g.b<b.a.p0.a.h0.l.g.a> f5829e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.h0.l.a f5830f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5831g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.a.p.e.b f5832h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5833i;
    public boolean j;
    public boolean k;
    public final HashMap<String, b.a.p0.a.p.e.d> l;
    public LinkedList<b.a.p0.a.o0.d.a> m;
    public final Object n;
    public final String o;
    public String p;
    public q q;
    public l1 r;
    public b.a.p0.a.p.e.h s;
    public volatile boolean t;
    public boolean u;

    /* loaded from: classes.dex */
    public static class a extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.p0.a.h0.u.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0247a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0247a(a aVar) {
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
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g.z0(false);
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                boolean z = !TextUtils.isEmpty(b.a.p0.a.a2.d.g().getAppId());
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (z) {
                    return;
                }
                b.a.p0.a.a2.d.g().z().M(15);
                q0.b0(new RunnableC0247a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.h0.l.g.d<b.a.p0.a.h0.l.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.l.g.d
        /* renamed from: b */
        public void a(boolean z, b.a.p0.a.h0.l.g.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, aVar) == null) && z) {
                b.a.p0.a.r1.h.p("startup").A("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h0.l.g.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f5834a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5834a = gVar;
        }

        @Override // b.a.p0.a.h0.l.g.j
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.f5834a.n) {
                    this.f5834a.f5831g = true;
                    this.f5834a.I();
                    this.f5834a.k0();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f5835a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5835a = gVar;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.f5835a.n) {
                    this.f5835a.f5831g = true;
                    this.f5835a.I();
                    this.f5835a.k0();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.a.p0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f5836a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5836a = gVar;
        }

        @Override // b.a.p0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.f5836a.f5833i = true;
                this.f5836a.k0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f5837e;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5837e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f5837e.F0(s.h(bool));
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.u.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0248g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f5838e;

        public RunnableC0248g(g gVar, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5838e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a2 = b.a.p0.a.c1.a.l0().a();
                if (g.v) {
                    String str = "checkRuntimeRetry: isLowDevice " + a2;
                }
                b.a.p0.a.v2.e1.b bVar = this.f5838e;
                if (bVar != null) {
                    bVar.onCallback(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.v2.j.i();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f5839e;

            public a(i iVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5839e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5839e.O0();
                }
            }
        }

        public i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (g.v) {
                    b.a.p0.q.d.b().e();
                    b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(g.getContext(), b.a.p0.a.h.aiapps_preloadCoreRuntime_end);
                    f2.l(1);
                    f2.F();
                }
                q0.X(new a(this, gVar));
                boolean unused = g.v;
                b.a.p0.a.v1.c.e.a.E().M(14);
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "prepare " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class j extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                boolean unused = g.v;
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class k extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f5840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f5841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f5842g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f5843e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f5844f;

            public a(k kVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5844f = kVar;
                this.f5843e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5843e.j) {
                    return;
                }
                b.a.p0.a.r1.h.p("startup").C(new UbcFlowEvent("na_pre_load_ok"));
                b.a.p0.a.i2.a.d().i("na_pre_load_ok");
                b.a.p0.a.r1.h.h("preload", "startup");
                k kVar = this.f5844f;
                kVar.f5842g.i0(this.f5843e, kVar.f5840e, kVar.f5841f);
                b.a.p0.a.r1.h.j(this.f5844f.f5840e, false);
            }
        }

        public k(g gVar, b.a.p0.a.f1.e.b bVar, e.g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5842g = gVar;
            this.f5840e = bVar;
            this.f5841f = gVar2;
        }

        @Override // b.a.p0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                q0.b0(new a(this, gVar));
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "startFirstPage " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f5846f;

        public l(g gVar, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5846f = gVar;
            this.f5845e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5846f.f5832h == null) {
                    b.a.p0.a.h0.u.b.c(11);
                    return;
                }
                if (a.C0241a.b()) {
                    z = true;
                } else {
                    String c2 = b.a.p0.a.c2.f.p0.c.c(b.a.p0.a.g1.f.T(), this.f5845e.M(), this.f5845e.E());
                    SwanAppConfigData E = this.f5845e.E();
                    String g2 = E != null ? E.g(c2) : null;
                    boolean equals = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(g2);
                    int i2 = 0;
                    if (g2 == null) {
                        i2 = 12;
                    } else if (!equals) {
                        i2 = 13;
                    }
                    if (i2 != 0) {
                        b.a.p0.a.h0.u.b.c(i2);
                    }
                    z = equals;
                }
                if (z && this.f5845e.E() != null) {
                    b.a.p0.a.h0.p.b.c().b(g.B ? ((b.a.p0.a.h0.l.g.a) this.f5846f.f5829e.e(this.f5845e.K().e0())).i() : this.f5846f.f5830f, this.f5846f.f5832h, this.f5845e.M(), this.f5845e.E(), null, true);
                } else if (this.f5845e.E() == null) {
                    b.a.p0.a.h0.u.b.c(15);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("preload");
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_start_mem");
                p.A("preload_start_mem", b.a.p0.a.e0.g.d.b().c(g.C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements b.a.p0.a.h0.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5848b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f5849e;

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
                this.f5849e = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (g.v) {
                        String str = "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.f5849e.f5848b.j;
                    }
                    if (this.f5849e.f5848b.j) {
                        if (g.v) {
                            Log.getStackTraceString(new Exception("runtime object is release."));
                            return;
                        }
                        return;
                    }
                    this.f5849e.f5848b.Q0();
                    this.f5849e.f5848b.P0();
                    if (this.f5849e.f5848b.f5825a == null) {
                        PreloadState unused = g.z = PreloadState.LOAD_FAILED;
                        this.f5849e.f5848b.Y();
                        return;
                    }
                    n nVar = this.f5849e;
                    nVar.f5848b.t0(nVar.f5847a);
                    this.f5849e.f5848b.y0();
                }
            }
        }

        public n(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5848b = gVar;
            this.f5847a = z;
        }

        @Override // b.a.p0.a.h0.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = g.v;
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("preload");
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_end_mem");
                p.A("preload_end_mem", b.a.p0.a.e0.g.d.b().c(g.C));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5850a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2093199245, "Lb/a/p0/a/h0/u/g$p;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2093199245, "Lb/a/p0/a/h0/u/g$p;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                b.a.p0.a.c1.a.Z().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (g.v) {
                    String str = "getHighDeviceTimeout: 6000";
                }
                return 6000;
            }
            return invokeV.intValue;
        }

        public static int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                b.a.p0.a.c1.a.Z().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (g.v) {
                    String str = "getLowDeviceTimeout: timeoutMs 8000";
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f5850a < 0) {
                    b.a.p0.a.c1.a.Z().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    f5850a = 0;
                }
                return f5850a;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                b.a.p0.a.c1.a.Z().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (g.v) {
                    String str = "getRetryProcessTimeout: 8000";
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                boolean z = c() > 0;
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class q implements b.a.p0.a.v2.e1.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                b(gVar);
            }
        }

        public abstract void b(g gVar);
    }

    /* loaded from: classes.dex */
    public static class r extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hasMessages(1002) : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1001) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                removeCallbacksAndMessages(null);
                removeCallbacks(s.f5856f);
                removeCallbacks(s.f5857g);
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                sendEmptyMessageDelayed(1001, i2);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1001) {
                    s.f5856f.run();
                } else if (i2 == 1002) {
                    s.f5857g.run();
                }
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                sendEmptyMessageDelayed(1002, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int f5851a;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5852b;

        /* renamed from: c  reason: collision with root package name */
        public static int f5853c;

        /* renamed from: d  reason: collision with root package name */
        public static int f5854d;

        /* renamed from: e  reason: collision with root package name */
        public static r f5855e;

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f5856f;

        /* renamed from: g  reason: collision with root package name */
        public static final Runnable f5857g;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!g.w.b0()) {
                        boolean z = true;
                        if (s.f5854d < 1) {
                            if (!((s.f5855e == null || !s.f5855e.a()) ? false : false)) {
                                if (s.f5855e == null) {
                                    r unused = s.f5855e = new r(b.a.p0.a.a2.d.g().getMainLooper());
                                }
                                s.f5855e.e(p.d());
                            }
                            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "start retry runtime.");
                            g.B0();
                            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                            aVar.j(5L);
                            aVar.h(49L);
                            aVar.e("start retry");
                            s.j(aVar);
                            return;
                        }
                        b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                        return;
                    }
                    b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                }
            }
        }

        /* loaded from: classes.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!g.w.b0()) {
                        if (s.f5854d >= 1) {
                            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "isMasterReady:" + g.w.a0() + ",isSlaveReady:" + g.w.c0());
                            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                            aVar.j(5L);
                            aVar.h(49L);
                            aVar.e("retry timeout");
                            s.j(aVar);
                            if (b.a.p0.a.g1.g.a().b()) {
                                b.a.p0.a.f1.d.a.d(g.getContext(), aVar, 0, b.a.p0.a.a2.d.g().getAppId());
                                b.a.p0.a.j2.e.m(b.a.p0.a.a2.d.g().r().K(), 0, aVar);
                                b.a.p0.a.c1.a.g0().flush(false);
                            }
                            b.a.p0.a.v2.f.j(b.a.p0.a.a2.d.g().x());
                            return;
                        }
                        return;
                    }
                    b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "Retry: successfully.");
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2093199152, "Lb/a/p0/a/h0/u/g$s;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2093199152, "Lb/a/p0/a/h0/u/g$s;");
                    return;
                }
            }
            f5851a = p.b();
            f5852b = p.a();
            f5853c = 0;
            f5854d = 0;
            f5856f = new a();
            f5857g = new b();
        }

        public static CopyOnWriteArrayList<q> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CopyOnWriteArrayList<>(g.w.f5828d) : (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) ? bool.booleanValue() ? f5851a : f5852b : invokeL.intValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                f5854d++;
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f5854d);
            }
        }

        public static void j(b.a.p0.a.q2.a aVar) {
            b.a.p0.a.a2.e r;
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65546, null, aVar) == null) && (r = b.a.p0.a.a2.d.g().r()) != null && (l = r.l()) == 0) {
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(r.M());
                dVar.q(b.a.p0.a.j2.k.m(l));
                dVar.m(b.a.p0.a.a2.e.U());
                b.a.p0.a.j2.k.L(dVar);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                f5854d = f5853c;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static boolean f5858a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f5859b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2093199121, "Lb/a/p0/a/h0/u/g$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2093199121, "Lb/a/p0/a/h0/u/g$t;");
                    return;
                }
            }
            boolean A = b.a.p0.a.c1.a.Z().A();
            f5858a = A;
            f5859b = A;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB") : (String) invokeV.objValue;
        }

        public static String b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 ? "V8" : i2 == 0 ? WebView.LOGTAG : "AB" : (String) invokeI.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (g.v) {
                    String a2 = a();
                    char c2 = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -1406842887) {
                        if (hashCode != 2081) {
                            if (hashCode == 2722 && a2.equals("V8")) {
                                c2 = 0;
                            }
                        } else if (a2.equals("AB")) {
                            c2 = 2;
                        }
                    } else if (a2.equals(WebView.LOGTAG)) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        return true;
                    }
                    if (c2 == 1) {
                        return false;
                    }
                }
                return f5859b;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String a2 = a();
                if (a2.equals("V8")) {
                    return true;
                }
                if (a2.equals("AB")) {
                    return b.a.p0.a.c1.a.Z().A();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
                f5859b = f5858a;
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                f5858a = intent.getBooleanExtra("bundle_key_v8_ab", f5858a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597820095, "Lb/a/p0/a/h0/u/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597820095, "Lb/a/p0/a/h0/u/g;");
                return;
            }
        }
        v = b.a.p0.a.k.f6397a;
        x = 10150;
        y = false;
        z = PreloadState.UNKNOWN;
        A = false;
        B = b.a.p0.a.h0.o.e.a.f();
        C = -1;
    }

    public g() {
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
        this.f5828d = new CopyOnWriteArrayList();
        this.m = new LinkedList<>();
        this.n = new Object();
        this.o = UUID.randomUUID().toString();
        this.t = false;
        this.u = false;
        b.a.p0.a.g1.i.e(this);
        this.l = new HashMap<>();
        this.r = new b.a.p0.a.p.e.j.b();
        this.s = b.a.p0.a.p.e.j.c.a().b().a();
        if (B) {
            this.f5829e = new b.a.p0.a.h0.l.g.m();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: b.a.p0.a.h0.u.g */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void A0(boolean z2, boolean z3) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (g.class) {
                boolean z4 = v;
                if (w == null) {
                    return;
                }
                z = PreloadState.UNKNOWN;
                w.j = true;
                w.q = null;
                y = false;
                if (z3) {
                    s.i();
                    copyOnWriteArrayList = s.g();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (w.f5827c != null) {
                    w.s.a(w.f5827c);
                }
                b.a.p0.a.u.e.p.g.e();
                b.a.p0.a.m2.c.a.c();
                E0();
                b.a.p0.a.g1.i.f(w);
                w = null;
                b.a.p0.a.h0.p.b.c().d();
                A = z2;
                M().p0(null, copyOnWriteArrayList);
            }
        }
    }

    public static synchronized void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (g.class) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "releaseAndRetry");
                A0(false, true);
            }
        }
    }

    public static synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (g.class) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "releaseForCoreUpdate");
                boolean z2 = v;
                if (w != null && !w.a0()) {
                    if (w.q == null) {
                        w.q = new a();
                    }
                    w.u0(w.q);
                    return;
                }
                b.a.p0.a.a2.d.g().z().M(15);
                z0(false);
            }
        }
    }

    public static void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (B) {
                if (w.f5829e != null) {
                    w.f5829e.reset();
                }
            } else if (w.f5830f != null) {
                if (w.f5830f instanceof b.a.p0.a.h0.l.e) {
                    w.f5830f.destroy();
                }
                w.f5830f = null;
            }
        }
    }

    public static void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (w.l != null) {
                for (b.a.p0.a.p.e.d dVar : ((HashMap) w.l.clone()).values()) {
                    if (dVar != null) {
                        dVar.destroy();
                    }
                }
            }
            D0();
            if (w.f5832h != null) {
                w.f5832h = null;
            }
        }
    }

    public static g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (w == null) {
                synchronized (g.class) {
                    if (w == null) {
                        w = new g();
                    }
                }
            }
            return w;
        }
        return (g) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? r0().statsCode(A) : invokeV.intValue;
    }

    public static PreloadState r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? z : (PreloadState) invokeV.objValue;
    }

    public static synchronized void z0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65573, null, z2) == null) {
            synchronized (g.class) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "release");
                A0(z2, false);
            }
        }
    }

    public final String E(String str, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z2)) == null) {
            String str2 = z2 ? "slave" : "master";
            if (!TextUtils.isEmpty(str)) {
                b.a.p0.a.h0.a.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void F() {
        b.a.p0.a.h0.l.g.b<b.a.p0.a.h0.l.g.a> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f5829e) == null || z == PreloadState.LOADED) {
            return;
        }
        bVar.b(new b(this));
    }

    public final void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (s.f5855e == null) {
                r unused = s.f5855e = new r(b.a.p0.a.a2.d.g().getMainLooper());
            }
            s.f5855e.c();
            s.f5855e.d(i2);
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (b.a.p0.a.e0.f.e.e.d() || b.a.p0.a.c1.a.n().K() || b.a.p0.a.n0.k.c.f6843d.w() || !h0()) {
                return false;
            }
            return t.c() && new File(Q()).exists();
        }
        return invokeV.booleanValue;
    }

    public void G0(b.a.p0.a.o0.d.a aVar) {
        b.a.p0.a.h0.f.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (aVar == null) {
                if (v) {
                    throw new IllegalArgumentException("message must be non-null.");
                }
                return;
            }
            synchronized (this.n) {
                if (!this.f5831g) {
                    if (v) {
                        Log.getStackTraceString(new Exception("message:" + aVar.f7099a));
                    }
                    this.m.add(aVar);
                    return;
                }
                if (B) {
                    if (!this.f5829e.g()) {
                        this.f5829e.d(aVar);
                        return;
                    } else if (this.f5829e.a() == 0) {
                        return;
                    } else {
                        f2 = ((b.a.p0.a.h0.l.g.a) this.f5829e.a()).i().f();
                    }
                } else {
                    b.a.p0.a.h0.l.a aVar2 = this.f5830f;
                    if (aVar2 == null) {
                        return;
                    }
                    f2 = aVar2.f();
                }
                if (v) {
                    String str = "master dispatch msg:" + aVar.f7099a;
                }
                b.a.p0.a.o0.a.a(f2, aVar);
            }
        }
    }

    public void H(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) && p.e()) {
            if (!b.a.p0.a.a2.d.g().r().l0()) {
                boolean z3 = s.f5855e != null && s.f5855e.b();
                if (!z2 && z3) {
                    if (v) {
                        String str = "checkRuntimeRetry: isReuse " + z2 + ", return.";
                        String str2 = "checkRuntimeRetry: isRunning " + z3 + ", return.";
                        return;
                    }
                    return;
                } else if (b0()) {
                    boolean z4 = v;
                    return;
                } else {
                    K(new f(this));
                    return;
                }
            }
            boolean z5 = v;
        }
    }

    public void H0(String str, b.a.p0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            if (b.a.p0.a.h0.l.g.e.a(str)) {
                G0(aVar);
            } else if (b.a.p0.a.h0.k.a.a(str)) {
                b.a.p0.a.o0.a.a(b.a.p0.a.e0.f.d.f.k().l(), aVar);
            } else {
                b.a.p0.a.p.e.d dVar = this.l.get(str);
                if (dVar == null) {
                    if (v) {
                        String str2 = "can't find view manager. webviewId: " + str + " message: " + aVar;
                        return;
                    }
                    return;
                }
                b.a.p0.a.o0.a.a(dVar.s(), aVar);
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.m.isEmpty()) {
            return;
        }
        Iterator<b.a.p0.a.o0.d.a> it = this.m.iterator();
        while (it.hasNext()) {
            b.a.p0.a.o0.d.a next = it.next();
            if (v) {
                String str = "dispatchPendingEvents event: " + next.f7099a;
            }
            G0(next);
        }
        this.m.clear();
    }

    public void I0(@NonNull b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            q0.b0(new l(this, eVar));
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", z.statsCode(A));
            b.a.p0.a.a2.d.g().w(str, bundle);
        }
    }

    public void J0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (v) {
                    String str = "setExtensionCore before. extension core: " + this.f5826b;
                }
                this.f5826b = extensionCore;
                if (v) {
                    String str2 = "setExtensionCore after. extension core: " + this.f5826b;
                }
            } else if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                sb.toString();
            }
        }
    }

    public final void K(b.a.p0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            b.a.p0.a.v2.q.j(new RunnableC0248g(this, bVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    public void K0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (v) {
                    String str = "setSwanCoreVersion before. swan core: " + this.f5825a;
                }
                this.f5825a = swanCoreVersion;
                if (v) {
                    String str2 = "setSwanCoreVersion after. swan core: " + this.f5825a;
                }
            } else if (v) {
                Log.getStackTraceString(new Exception("setSwanCoreVersion failed."));
                String str3 = "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion;
            }
        }
    }

    @Nullable
    public ExtensionCore L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f5826b : (ExtensionCore) invokeV.objValue;
    }

    public void L0(b.a.p0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bVar, gVar) == null) {
            if (v) {
                String str = "startFirstPage cur swanCoreVersion: " + this.f5825a;
                String str2 = "startFirstPage launchInfo coreVersion: " + bVar.h0();
            }
            N0(bVar);
            M0(bVar);
            b.a.p0.a.r1.h.o().C(new UbcFlowEvent("na_pre_load_check"));
            b.a.p0.a.i2.a.d().i("na_pre_load_check");
            u0(new k(this, bVar, gVar));
        }
    }

    public void M0(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            ExtensionCore extensionCore = this.f5826b;
            if (extensionCore != null) {
                bVar.A0(extensionCore);
            } else {
                this.f5826b = bVar.N();
            }
        }
    }

    @NonNull
    public HashMap<String, b.a.p0.a.p.e.d> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (HashMap) invokeV.objValue;
    }

    public void N0(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            SwanCoreVersion swanCoreVersion = this.f5825a;
            if (swanCoreVersion != null) {
                bVar.W0(swanCoreVersion);
            } else {
                this.f5825a = bVar.h0();
            }
        }
    }

    public b.a.p0.a.h0.l.a O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (B) {
                if (this.f5829e.g()) {
                    return ((b.a.p0.a.h0.l.g.a) this.f5829e.a()).i();
                }
                return null;
            }
            return this.f5830f;
        }
        return (b.a.p0.a.h0.l.a) invokeV.objValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.t) {
                boolean z2 = v;
                return;
            }
            boolean z3 = true;
            this.t = true;
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            z3 = (g2 == null || !g2.C()) ? false : false;
            boolean y2 = b.a.p0.a.c1.a.Z().y();
            if (!z3 && y2) {
                boolean z4 = v;
                b.a.p0.a.h0.t.a.l(getContext());
            } else if (v) {
                String str = "Can't preload additional slave manager, isOccupied: " + z3 + ", ab: " + y2;
            }
        }
    }

    public String P() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Q0();
            if (g0()) {
                str = Q();
            } else {
                str = this.f5825a.swanCorePath + File.separator + "master/master.html";
            }
            if (b.a.p0.a.h0.a.d()) {
                E(str, false);
            } else if (b.a.p0.a.e0.f.e.e.d()) {
                b.a.p0.a.e0.f.e.d.k();
                b.a.p0.a.e0.f.e.d.g().h("loadmaster");
                return b.a.p0.a.e0.f.e.e.a();
            } else {
                b.a.p0.a.h0.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ExtensionCore extensionCore = this.f5826b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                J0(b.a.p0.a.p0.b.c(0));
            }
        }
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(T())) {
                return "";
            }
            return T() + "runtime/index.js";
        }
        return (String) invokeV.objValue;
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f5825a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.f5825a)));
                K0(b.a.p0.a.m2.b.g(0));
            }
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void R0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            this.k = z2;
        }
    }

    @Nullable
    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Q0();
            if (this.f5825a == null) {
                return null;
            }
            String str = this.f5825a.swanCorePath + File.separator + "slaves/slaves.html";
            if (b.a.p0.a.h0.a.d()) {
                E(str, true);
            } else if (b.a.p0.a.e0.f.e.e.d()) {
                return b.a.p0.a.e0.f.e.e.b();
            } else {
                b.a.p0.a.h0.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f5825a == null) {
                return "";
            }
            return this.f5825a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f5825a : (SwanCoreVersion) invokeV.objValue;
    }

    public b.a.p0.a.p.e.d V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (this.l.isEmpty() || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.l.get(str);
        }
        return (b.a.p0.a.p.e.d) invokeL.objValue;
    }

    public l1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.r : (l1) invokeV.objValue;
    }

    @Nullable
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            Z();
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this.n) {
                this.f5831g = false;
                if (B) {
                    this.f5829e.reset();
                } else {
                    this.f5830f = null;
                }
            }
            this.f5833i = false;
            this.f5832h = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", b.a.p0.a.m2.f.a.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", g0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = b.a.p0.a.m2.b.g(0);
                jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
                SwanCoreVersion g3 = b.a.p0.a.m2.b.g(1);
                jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10001);
            bVar.h(b.a.p0.a.a2.e.i() == null ? "null appKey" : b.a.p0.a.a2.e.i().k());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && TextUtils.isEmpty(this.p)) {
            b.a.p0.a.p.e.b bVar = this.f5832h;
            this.p = bVar != null ? bVar.a() : "";
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "initWebViewUa ua: " + this.p);
        }
    }

    @Override // b.a.p0.a.g1.h
    public void a(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dVar) == null) {
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this.n) {
                z2 = this.f5831g;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.h
    public void b(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, dVar) == null) {
            String b2 = dVar.b();
            this.l.remove(b2);
            if (dVar instanceof b.a.p0.a.p.e.b) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, b2);
                G0(new b.a.p0.a.o0.d.c(hashMap));
                b.a.p0.a.e0.d.g("SwanApp", "onUnload");
            }
            b.a.p0.a.z1.b.d.a.a();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            synchronized (this.n) {
                z2 = this.f5831g && this.f5833i;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.h
    public void c(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            synchronized (this.n) {
                z2 = this.f5833i;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.h
    public void d(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, dVar) == null) {
            this.l.put(dVar.b(), dVar);
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            long currentTimeMillis = v ? System.currentTimeMillis() : 0L;
            SwanCoreVersion swanCoreVersion = this.f5825a;
            boolean z2 = swanCoreVersion != null && swanCoreVersion.isAvailable();
            ExtensionCore extensionCore = this.f5826b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z2 &= extensionCore.isAvailable();
            }
            if (v) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "isSwanAvailable cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (B) {
                return this.f5829e.i();
            }
            return this.f5830f instanceof b.a.p0.a.h0.l.e;
        }
        return invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (b.a.p0.a.c1.a.n0().d() || b.a.p0.a.h2.d.a() == null) {
                return true;
            }
            boolean exists = new File(b.a.p0.a.h2.d.a()).exists();
            if (v) {
                String str = "is v8 load success: " + exists;
            }
            return exists;
        }
        return invokeV.booleanValue;
    }

    public final void i0(g gVar, b.a.p0.a.f1.e.b bVar, e.g gVar2) {
        b.a.p0.a.h0.l.a aVar;
        b.a.p0.a.p.e.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048622, this, gVar, bVar, gVar2) == null) {
            if (B) {
                b.a.p0.a.h0.l.g.b<b.a.p0.a.h0.l.g.a> bVar3 = gVar.f5829e;
                aVar = bVar3.h() ? ((b.a.p0.a.h0.l.g.a) bVar3.e(bVar.e0())).i() : null;
            } else {
                aVar = gVar.f5830f;
            }
            if (aVar != null && (bVar2 = gVar.f5832h) != null) {
                b.a.p0.a.c2.f.p0.c.e(aVar, bVar2, bVar, gVar2);
                gVar.f5832h = null;
            } else if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("startFirstPage mMasterManager ");
                sb.append(gVar.f5830f != null);
                sb.append(" startFirstPage mSlaveManager ");
                sb.append(gVar.f5832h != null);
                sb.toString();
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.f5828d.isEmpty()) {
            return;
        }
        F();
        z = PreloadState.LOADED;
        s.k();
        J("event_preload_finish");
        b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_end"));
        b.a.p0.a.h0.l.g.n.a.i().q();
        for (q qVar : this.f5828d) {
            if (qVar != null) {
                if (v) {
                    String str = "onReady result: " + qVar.toString();
                }
                qVar.onCallback(this);
            }
        }
        this.f5828d.clear();
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && !this.f5828d.isEmpty() && b0()) {
            j0();
            if (b.a.p0.a.a2.d.g().r().b0()) {
                return;
            }
            b.a.p0.a.v2.q.j(new o(this), "SwanMemory");
        }
    }

    public void l0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            boolean f2 = B ? this.f5829e.f() : this.f5830f != null;
            if (z2 && !this.f5831g && f2) {
                boolean z3 = v;
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.n) {
                    this.f5831g = true;
                    I();
                    k0();
                }
            } else if (z2 || this.f5832h == null || this.f5833i) {
            } else {
                boolean z4 = v;
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.f5833i = true;
                k0();
            }
        }
    }

    public void m0(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048626, this, prefetchEvent, pMSAppInfo) == null) && B) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (b0() && d0()) {
                    b.a.p0.a.p.e.b bVar = this.f5832h;
                    if (bVar != null) {
                        prefetchEvent.isT7Available = bVar.J();
                    } else {
                        prefetchEvent.isT7Available = e0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    String str = prefetchEvent.pageUrl;
                    Map<String, String> h2 = createMessage.h();
                    String str2 = h2 != null ? h2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    if (!b.a.p0.a.a1.e.C(prefetchEvent.appPath, str)) {
                        if (v) {
                            String str3 = "page path - " + str + " not exit";
                            return;
                        }
                        return;
                    }
                    if (createMessage.i()) {
                        b.a.p0.a.e0.c.d();
                        b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f5829e.c(createMessage, pMSAppInfo);
                    n0(prefetchEvent);
                    if (v) {
                        String str4 = "swan-core version - " + this.f5825a.swanCoreVersionName;
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = v;
        }
    }

    public final void n0(PrefetchEvent prefetchEvent) {
        a.C0240a b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, prefetchEvent) == null) && b.a.p0.a.h0.o.e.a.l()) {
            b.a.p0.a.p.e.b bVar = this.f5832h;
            if (bVar != null && c0()) {
                b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch slave");
                long currentTimeMillis = v ? System.currentTimeMillis() : 0L;
                b.a.p0.a.a2.e r2 = b.a.p0.a.a2.d.g().r();
                if (r2 == null) {
                    return;
                }
                H0(bVar.b(), b.a.p0.a.h0.o.i.a.a(bVar, prefetchEvent, r2).b());
                if (v) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "prefetch slave cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
                b.a.p0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch slave finish:" + b2.toString());
                return;
            }
            boolean z2 = v;
        }
    }

    public void o0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            p0(intent, null);
        }
    }

    public final void p0(Intent intent, CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, intent, copyOnWriteArrayList) == null) {
            b.a.p0.a.r1.k.g.a.c().f();
            b.a.p0.a.r1.k.i.b.e().g();
            if (b0()) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z2 = true;
            y = true;
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            J("event_preload_start");
            if (intent == null) {
                swanCoreVersion = b.a.p0.a.m2.b.g(0);
                extensionCore = b.a.p0.a.p0.b.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                b.a.p0.a.c1.a.f().g(intent.getIntExtra("bundle_key_preload_switch", x));
                C = intent.getIntExtra("bundle_key_main_pid", C);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                J("event_preload_error");
                b.a.p0.a.e0.d.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            K0(swanCoreVersion);
            if (extensionCore == null) {
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            J0(extensionCore);
            t.f();
            b.a.p0.a.v2.q.j(new h(this), "prepare ab description");
            if (G()) {
                b.a.p0.a.h2.f c2 = b.a.p0.a.h2.d.c();
                if (!c2.b() && !c2.a()) {
                    J("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                v0();
            } else {
                w0(copyOnWriteArrayList);
            }
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public b.a.p0.a.h0.l.a s0(boolean z2, b.a.p0.a.h0.b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048630, this, z2, bVar)) == null) {
            b.a.p0.a.h0.l.a e2 = this.r.e(getContext(), z2 ? 1 : 0);
            b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
            e2.loadUrl(P());
            e2.c(bVar);
            return e2;
        }
        return (b.a.p0.a.h0.l.a) invokeZL.objValue;
    }

    public final void t0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            synchronized (this.n) {
                boolean f2 = B ? this.f5829e.f() : this.f5830f != null;
                if (!this.f5831g && !f2) {
                    b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster start.");
                    b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_start"));
                    if (B) {
                        this.f5829e.j(z2, new c(this));
                        return;
                    }
                    this.f5830f = this.r.e(getContext(), z2 ? 1 : 0);
                    b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
                    this.f5830f.loadUrl(P());
                    this.f5830f.c(new d(this));
                }
            }
        }
    }

    public void u0(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, qVar) == null) {
            b.a.p0.a.r1.k.g.a.c().f();
            b.a.p0.a.r1.k.i.b.e().g();
            if (qVar != null && !this.f5828d.contains(qVar)) {
                this.f5828d.add(qVar);
            }
            boolean b0 = b0();
            b.a.p0.a.r1.h.o().A("preload", b0 ? "1" : "0");
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "prepareRuntime preload = " + b0);
            if (b0) {
                j0();
                return;
            }
            z = PreloadState.LOADING;
            b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_start"));
            if (!b.a.p0.a.a2.d.g().r().b0()) {
                b.a.p0.a.v2.q.j(new m(this), "SwanMemory");
            }
            Q0();
            boolean G = G();
            this.u = G;
            if (G) {
                b.a.p0.a.h2.f c2 = b.a.p0.a.h2.d.c();
                if (!c2.b() && c2.a()) {
                    this.u = false;
                }
            }
            boolean z2 = this.u;
            b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "mIsUseV8Master:" + this.u);
            if (this.u) {
                t0(true);
            }
            if (this.f5827c == null) {
                this.f5827c = new n(this, z2);
                boolean z3 = v;
                this.s.b(this.f5827c);
            }
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            u0(new i(this));
        }
    }

    public final void w0(CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, copyOnWriteArrayList) == null) {
            if (this.f5828d == null) {
                this.f5828d = new CopyOnWriteArrayList();
            }
            Iterator<q> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (!this.f5828d.contains(next)) {
                    this.f5828d.add(next);
                }
            }
            u0(new j(this));
        }
    }

    public b.a.p0.a.p.e.b x0(Context context, b.a.p0.a.h0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, context, bVar)) == null) {
            try {
                b.a.p0.a.p.e.b f2 = this.r.f(context);
                b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_created"));
                String S = S();
                if (S != null) {
                    b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                    if (P != null && !TextUtils.isEmpty(P.k())) {
                        S = Uri.parse(S).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, b.a.p0.a.a1.e.v(P.k(), P.Y(), false, null, null).getAbsolutePath()).toString();
                        if (!S.endsWith(File.separator)) {
                            S = S + File.separator;
                        }
                    }
                    f2.loadUrl(S);
                }
                b.a.p0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave loadUrl " + S);
                f2.c(bVar);
                return f2;
            } catch (NullPointerException e2) {
                b.a.p0.a.h0.a.e(context);
                throw e2;
            }
        }
        return (b.a.p0.a.p.e.b) invokeLL.objValue;
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && !this.f5833i && this.f5832h == null) {
            boolean z2 = v;
            b.a.p0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_start"));
            this.f5832h = x0(getContext(), new e(this));
            Z();
        }
    }
}
