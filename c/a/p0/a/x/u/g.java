package c.a.p0.a.x.u;

import android.annotation.SuppressLint;
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
import c.a.p0.a.d2.c;
import c.a.p0.a.f.d.r1;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.q0.d;
import c.a.p0.a.x.o.j.e.a;
import c.a.p0.a.x.p.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import com.kwad.v8.NodeJS;
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
public final class g implements c.a.p0.a.w0.h {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public static volatile g B;
    public static int C;
    public static boolean D;
    public static PreloadState E;
    public static boolean F;
    public static final boolean G;
    public static int H;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f8901b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.x.f.d.b f8902c;

    /* renamed from: d  reason: collision with root package name */
    public List<s> f8903d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.p0.a.x.b> f8904e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.x.l.g.b<c.a.p0.a.x.l.g.a> f8905f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.x.l.a f8906g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8907h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a.f.e.b<?> f8908i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.a.f.e.b<?> f8909j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final HashMap<String, c.a.p0.a.f.e.d> o;
    public LinkedList<c.a.p0.a.e0.d.b> p;
    public final Object q;
    public final Object r;
    public final String s;
    public String t;
    public s u;
    public r1 v;
    public c.a.p0.a.f.e.h w;
    public volatile boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public static class a extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.a.x.u.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0583a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0583a(a aVar) {
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
                    g.N0(false);
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

        @Override // c.a.p0.a.x.u.g.s
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                boolean z = !TextUtils.isEmpty(c.a.p0.a.t1.d.J().getAppId());
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (z) {
                    return;
                }
                c.a.p0.a.t1.d.J().z().X(15);
                q0.e0(new RunnableC0583a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.x.l.g.d<c.a.p0.a.x.l.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.x.l.g.d
        /* renamed from: b */
        public void a(boolean z, c.a.p0.a.x.l.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, aVar) == null) {
                this.a.y = z;
                if (z) {
                    c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).D("prefetch_env", "1");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.x.l.g.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.p0.a.x.l.g.j
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.f8907h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.a.q) {
                    this.a.f8907h = true;
                    this.a.Q();
                    this.a.v0();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.a.k = true;
                this.a.v0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.a.r) {
                    this.a.l = true;
                }
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                for (c.a.p0.a.x.b bVar : this.a.f8904e) {
                    bVar.a(str);
                }
                this.a.f8904e.clear();
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareNaSlave finished");
            }
        }
    }

    /* renamed from: c.a.p0.a.x.u.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0584g extends c.a.p0.a.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f8910b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.g f8911c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f8912d;

        /* renamed from: c.a.p0.a.x.u.g$g$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0584g f8913e;

            public a(C0584g c0584g) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0584g};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8913e = c0584g;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0584g c0584g = this.f8913e;
                    c.a.p0.a.x.l.a aVar = c0584g.a;
                    c.a.p0.a.f.e.b bVar = c0584g.f8912d.f8909j;
                    C0584g c0584g2 = this.f8913e;
                    c.a.p0.a.v1.f.o0.c.i(aVar, bVar, c0584g2.f8910b, c0584g2.f8911c);
                    g gVar = this.f8913e.f8912d;
                    gVar.M0(gVar.f8908i);
                }
            }
        }

        public C0584g(g gVar, c.a.p0.a.x.l.a aVar, c.a.p0.a.v0.e.b bVar, d.g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, bVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8912d = gVar;
            this.a = aVar;
            this.f8910b = bVar;
            this.f8911c = gVar2;
        }

        @Override // c.a.p0.a.x.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                synchronized (this.f8912d.r) {
                    this.f8912d.l = true;
                }
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_ok"));
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareNaSlave finished");
                q0.e0(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.p0.a.p2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f8914e;

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
                    return;
                }
            }
            this.f8914e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f8914e.T0(u.h(bool));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p2.g1.c f8915e;

        public i(g gVar, c.a.p0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8915e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a = c.a.p0.a.s0.a.u0().a();
                if (g.A) {
                    String str = "checkRuntimeRetry: isLowDevice " + a;
                }
                c.a.p0.a.p2.g1.c cVar = this.f8915e;
                if (cVar != null) {
                    cVar.onCallback(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.p2.j.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class k extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f8916e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f8917e;

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
                this.f8917e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8917e.e1();
                }
            }
        }

        public k(g gVar) {
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
            this.f8916e = gVar;
        }

        @Override // c.a.p0.a.x.u.g.s
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (g.A) {
                    c.a.p0.t.b.b().e();
                    c.a.p0.a.s1.b.f.e f2 = c.a.p0.a.s1.b.f.e.f(g.getContext(), R.string.aiapps_preloadCoreRuntime_end);
                    f2.l(1);
                    f2.G();
                }
                q0.a0(new a(this, gVar));
                boolean unused = g.A;
                c.a.p0.a.o1.c.e.a.P().X(14);
                if (c.a.p0.a.x.t.f.a.f() || c.a.p0.a.x.t.f.a.g()) {
                    this.f8916e.F0();
                }
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
    public class l extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f8918e;

        public l(g gVar) {
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
            this.f8918e = gVar;
        }

        @Override // c.a.p0.a.x.u.g.s
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (c.a.p0.a.x.t.f.a.f() || c.a.p0.a.x.t.f.a.g()) {
                    this.f8918e.F0();
                }
                boolean unused = g.A;
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
    public class m extends s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f8919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f8920f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8921g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f8922e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8923f;

            public a(m mVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8923f = mVar;
                this.f8922e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8922e.m) {
                    return;
                }
                c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("na_pre_load_ok"));
                c.a.p0.a.c2.a.d().i("na_pre_load_ok");
                c.a.p0.a.k1.h.h("preload", NodeJS.STARTUP_SCRIPT_NAME);
                m mVar = this.f8923f;
                mVar.f8921g.t0(this.f8922e, mVar.f8919e, mVar.f8920f);
                c.a.p0.a.k1.h.j(this.f8923f.f8919e, false);
            }
        }

        public m(g gVar, c.a.p0.a.v0.e.b bVar, d.g gVar2) {
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
            this.f8921g = gVar;
            this.f8919e = bVar;
            this.f8920f = gVar2;
        }

        @Override // c.a.p0.a.x.u.g.s
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                q0.e0(new a(this, gVar));
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
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8924e;

        public n(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8924e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.v1.f.o0.c.k(this.f8924e);
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
                c.a.p0.a.v1.f.o0.c.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f8925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f8926f;

        public p(g gVar, c.a.p0.a.t1.e eVar) {
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
            this.f8926f = gVar;
            this.f8925e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.a.x.t.f.a.d() && TextUtils.isEmpty(c.a.p0.a.w0.f.U().z()) && !c.a.p0.a.x.t.f.a.h(this.f8925e)) {
                    boolean unused = g.A;
                    return;
                }
                String d2 = c.a.p0.a.v1.f.o0.c.d(c.a.p0.a.w0.f.U(), this.f8925e.X(), this.f8925e.P());
                int c2 = c.a.p0.a.x.t.f.a.c(d2);
                if (!this.f8926f.O(c2)) {
                    c.a.p0.a.x.u.b.c(11);
                    return;
                }
                c.a.p0.a.f.e.b bVar = null;
                if (a.C0576a.b()) {
                    equals = true;
                } else {
                    SwanAppConfigData P = this.f8925e.P();
                    String h2 = P != null ? P.h(d2) : null;
                    equals = "main".equals(h2);
                    int i2 = 0;
                    if (h2 == null) {
                        i2 = 12;
                    } else if (!equals) {
                        i2 = 13;
                    }
                    if (i2 != 0) {
                        c.a.p0.a.x.u.b.c(i2);
                    }
                }
                if (c2 != 0 || this.f8926f.f8908i == null) {
                    if (c2 == 1 && this.f8926f.f8909j != null) {
                        bVar = this.f8926f.f8909j;
                    }
                } else {
                    bVar = this.f8926f.f8908i;
                }
                c.a.p0.a.f.e.b bVar2 = bVar;
                if (bVar2 == null) {
                    return;
                }
                if (equals && this.f8925e.P() != null) {
                    c.a.p0.a.x.p.b.c().b(g.G ? ((c.a.p0.a.x.l.g.a) this.f8926f.f8905f.e(this.f8925e.V().f0())).i() : this.f8926f.f8906g, bVar2, this.f8925e.X(), this.f8925e.P(), null, true);
                } else if (this.f8925e.P() == null) {
                    c.a.p0.a.x.u.b.c(15);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements c.a.p0.a.x.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f8927b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ q f8928e;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8928e = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (g.A) {
                        String str = "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.f8928e.f8927b.m;
                    }
                    if (this.f8928e.f8927b.m) {
                        if (g.A) {
                            Log.getStackTraceString(new Exception("runtime object is release."));
                            return;
                        }
                        return;
                    }
                    this.f8928e.f8927b.g1();
                    this.f8928e.f8927b.f1();
                    if (this.f8928e.f8927b.a == null) {
                        PreloadState unused = g.E = PreloadState.LOAD_FAILED;
                        this.f8928e.f8927b.h0();
                        return;
                    }
                    q qVar = this.f8928e;
                    qVar.f8927b.E0(qVar.a);
                    this.f8928e.f8927b.L0();
                }
            }
        }

        public q(g gVar, boolean z) {
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
            this.f8927b = gVar;
            this.a = z;
        }

        @Override // c.a.p0.a.x.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = g.A;
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                q0.e0(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1780184530, "Lc/a/p0/a/x/u/g$r;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780184530, "Lc/a/p0/a/x/u/g$r;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                c.a.p0.a.s0.a.g0().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (g.A) {
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
                c.a.p0.a.s0.a.g0().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (g.A) {
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
                if (a < 0) {
                    c.a.p0.a.s0.a.g0().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    a = 0;
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                c.a.p0.a.s0.a.g0().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (g.A) {
                    String str = "getRetryProcessTimeout: 8000";
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                boolean z = c() > 0;
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class s implements c.a.p0.a.p2.g1.c<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s() {
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
        @Override // c.a.p0.a.p2.g1.c
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
    public static class t extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Looper looper) {
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
                removeCallbacks(u.f8933f);
                removeCallbacks(u.f8934g);
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
                    u.f8933f.run();
                } else if (i2 == 1002) {
                    u.f8934g.run();
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
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public static final int a;

        /* renamed from: b  reason: collision with root package name */
        public static final int f8929b;

        /* renamed from: c  reason: collision with root package name */
        public static int f8930c;

        /* renamed from: d  reason: collision with root package name */
        public static int f8931d;

        /* renamed from: e  reason: collision with root package name */
        public static t f8932e;

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f8933f;

        /* renamed from: g  reason: collision with root package name */
        public static final Runnable f8934g;
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.p0.a.t1.d.J().r().x0()) {
                    return;
                }
                if (!g.B.m0()) {
                    boolean z = true;
                    if (u.f8931d < 1) {
                        if (!((u.f8932e == null || !u.f8932e.a()) ? false : false)) {
                            if (u.f8932e == null) {
                                t unused = u.f8932e = new t(c.a.p0.a.t1.d.J().getMainLooper());
                            }
                            u.f8932e.e(r.d());
                        }
                        c.a.p0.a.u.d.k("SwanAppCoreRuntime", "start retry runtime.");
                        g.P0();
                        c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
                        aVar.k(5L);
                        aVar.i(49L);
                        aVar.f("start retry");
                        u.j(aVar);
                        return;
                    }
                    c.a.p0.a.u.d.k("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.p0.a.t1.d.J().r().x0()) {
                    return;
                }
                if (!g.B.m0()) {
                    if (u.f8931d >= 1) {
                        c.a.p0.a.u.d.k("SwanAppCoreRuntime", "isMasterReady:" + g.B.k0() + ",isSlaveReady:" + g.B.n0());
                        c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
                        aVar.k(5L);
                        aVar.i(49L);
                        aVar.f("retry timeout");
                        u.j(aVar);
                        if (c.a.p0.a.w0.g.a().b()) {
                            c.a.p0.a.v0.d.a.e(g.getContext(), aVar, 0, c.a.p0.a.t1.d.J().getAppId());
                            c.a.p0.a.d2.e.m(c.a.p0.a.t1.d.J().r().V(), 0, aVar);
                            c.a.p0.a.s0.a.p0().flush(false);
                        }
                        c.a.p0.a.p2.f.j(c.a.p0.a.t1.d.J().x());
                        return;
                    }
                    return;
                }
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "Retry: successfully.");
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780184437, "Lc/a/p0/a/x/u/g$u;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1780184437, "Lc/a/p0/a/x/u/g$u;");
                    return;
                }
            }
            a = r.b();
            f8929b = r.a();
            f8930c = 0;
            f8931d = 0;
            f8933f = new a();
            f8934g = new b();
        }

        public static CopyOnWriteArrayList<s> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CopyOnWriteArrayList<>(g.B.f8903d) : (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) ? bool.booleanValue() ? a : f8929b : invokeL.intValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                f8931d++;
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f8931d);
            }
        }

        public static void j(c.a.p0.a.k2.a aVar) {
            c.a.p0.a.t1.e r;
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65546, null, aVar) == null) && (r = c.a.p0.a.t1.d.J().r()) != null && (l = r.l()) == 0) {
                c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
                dVar.p(aVar);
                dVar.r(r.X());
                dVar.q(c.a.p0.a.d2.n.n(l));
                dVar.m(c.a.p0.a.t1.e.f0());
                c.a.p0.a.d2.n.R(dVar);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                f8931d = f8930c;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f8935b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780184406, "Lc/a/p0/a/x/u/g$v;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1780184406, "Lc/a/p0/a/x/u/g$v;");
                    return;
                }
            }
            boolean y = c.a.p0.a.s0.a.g0().y();
            a = y;
            f8935b = y;
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
                if (g.A) {
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
                return f8935b;
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
                    return c.a.p0.a.s0.a.g0().y();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, null) == null) {
                f8935b = a;
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                a = intent.getBooleanExtra("bundle_key_v8_ab", a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78594428, "Lc/a/p0/a/x/u/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78594428, "Lc/a/p0/a/x/u/g;");
                return;
            }
        }
        A = c.a.p0.a.a.a;
        C = 10150;
        D = false;
        E = PreloadState.UNKNOWN;
        F = false;
        G = c.a.p0.a.x.o.e.a.h();
        H = -1;
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
        this.f8903d = new CopyOnWriteArrayList();
        this.f8904e = new CopyOnWriteArrayList();
        this.p = new LinkedList<>();
        this.q = new Object();
        this.r = new Object();
        this.s = UUID.randomUUID().toString();
        this.x = false;
        this.z = false;
        c.a.p0.a.w0.i.e(this);
        this.o = new HashMap<>();
        this.v = c.a.p0.a.s0.a.F0();
        this.w = c.a.p0.a.f.e.j.c.a().b().a();
        if (G) {
            this.f8905f = new c.a.p0.a.x.l.g.m();
        }
    }

    public static int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C0().statsCode(F) : invokeV.intValue;
    }

    public static PreloadState C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? E : (PreloadState) invokeV.objValue;
    }

    public static synchronized void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            synchronized (g.class) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "release");
                O0(z, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: c.a.p0.a.x.u.g */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void O0(boolean z, boolean z2) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (g.class) {
                boolean z3 = A;
                if (B == null) {
                    return;
                }
                E = PreloadState.UNKNOWN;
                B.m = true;
                B.u = null;
                D = false;
                if (z2) {
                    u.i();
                    copyOnWriteArrayList = u.g();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (B.f8902c != null) {
                    B.w.a(B.f8902c);
                }
                c.a.p0.a.k.e.p.l.f();
                c.a.p0.a.g2.c.a.c();
                S0();
                c.a.p0.a.w0.i.f(B);
                B = null;
                c.a.p0.a.x.p.b.c().d();
                F = z;
                U().A0(null, copyOnWriteArrayList);
            }
        }
    }

    public static synchronized void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (g.class) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "releaseAndRetry");
                O0(false, true);
            }
        }
    }

    public static synchronized void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            synchronized (g.class) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "releaseForCoreUpdate");
                boolean z = A;
                if (B != null && !B.k0()) {
                    if (B.u == null) {
                        B.u = new a();
                    }
                    B.H0(B.u);
                    return;
                }
                c.a.p0.a.t1.d.J().z().X(15);
                N0(false);
            }
        }
    }

    public static void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            if (G) {
                if (B.f8905f != null) {
                    B.f8905f.reset();
                }
            } else if (B.f8906g != null) {
                if (B.f8906g instanceof c.a.p0.a.x.l.e) {
                    B.f8906g.destroy();
                }
                B.f8906g = null;
            }
        }
    }

    public static void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (B.o != null) {
                for (c.a.p0.a.f.e.d dVar : ((HashMap) B.o.clone()).values()) {
                    if (dVar != null) {
                        dVar.destroy();
                    }
                }
            }
            R0();
            if (B.f8908i != null) {
                B.f8908i = null;
            }
            if (B.f8909j != null) {
                B.f8909j = null;
            }
        }
    }

    public static g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (B == null) {
                synchronized (g.class) {
                    if (B == null) {
                        B = new g();
                    }
                }
            }
            return B;
        }
        return (g) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public final void A0(Intent intent, CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, copyOnWriteArrayList) == null) {
            if (c.a.p0.a.t1.d.J().r().x0()) {
                c.a.p0.a.u.d.i("SwanAppCoreRuntime", "swan/web, preloadCoreRuntime: " + c.a.p0.a.t1.d.J().r().N());
                return;
            }
            c.a.p0.a.k1.k.g.a.c().f();
            c.a.p0.a.k1.k.i.c.e().f();
            if (m0()) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z = true;
            D = true;
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            R("event_preload_start");
            if (intent == null) {
                swanCoreVersion = c.a.p0.a.g2.b.g(0);
                extensionCore = c.a.p0.a.f0.b.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                c.a.p0.a.s0.a.g().g(intent.getIntExtra("bundle_key_preload_switch", C));
                H = intent.getIntExtra("bundle_key_main_pid", H);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                R("event_preload_error");
                c.a.p0.a.u.d.l("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            Y0(swanCoreVersion);
            if (extensionCore == null) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            X0(extensionCore);
            v.f();
            c.a.p0.a.p2.q.k(new j(this), "prepare ab description");
            if (N()) {
                c.a.p0.a.a2.f c2 = c.a.p0.a.a2.d.c();
                if (!c2.b() && !c2.a()) {
                    R("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                I0();
            } else {
                J0(copyOnWriteArrayList);
            }
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public c.a.p0.a.x.l.a D0(boolean z, c.a.p0.a.x.b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, bVar)) == null) {
            c.a.p0.a.x.l.a h2 = this.v.h(getContext(), z ? 1 : 0);
            c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
            h2.loadUrl(X());
            h2.d(bVar);
            return h2;
        }
        return (c.a.p0.a.x.l.a) invokeZL.objValue;
    }

    public final void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.q) {
                boolean f2 = G ? this.f8905f.f() : this.f8906g != null;
                if (!this.f8907h && !f2) {
                    c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareMaster start.");
                    c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_start"));
                    if (G) {
                        this.f8905f.j(z, new c(this));
                        return;
                    }
                    this.f8906g = this.v.h(getContext(), z ? 1 : 0);
                    c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_created"));
                    this.f8906g.loadUrl(X());
                    this.f8906g.d(new d(this));
                }
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c.a.p0.a.x.t.f.a.d() && !l0() && this.f8909j == null) {
            c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.f8909j = K0(getContext(), 1, new f(this));
            i0();
        }
    }

    public void G0(c.a.p0.a.x.l.a aVar, c.a.p0.a.v0.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, aVar, bVar, gVar) == null) {
            boolean l0 = l0();
            c.a.p0.a.k1.h.o().D("preload", l0 ? "1" : "0");
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareNaSlave preload = " + l0);
            if (l0) {
                c.a.p0.a.v1.f.o0.c.i(aVar, this.f8909j, bVar, gVar);
                M0(this.f8908i);
                return;
            }
            C0584g c0584g = new C0584g(this, aVar, bVar, gVar);
            if (this.f8909j != null) {
                K(c0584g);
                return;
            }
            c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_start"));
            this.f8909j = K0(getContext(), 1, c0584g);
            i0();
        }
    }

    public void H0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            if (c.a.p0.a.t1.d.J().r().x0()) {
                c.a.p0.a.u.d.i("SwanAppCoreRuntime", "swan/web, prepareRuntime: " + c.a.p0.a.t1.d.J().r().N());
                return;
            }
            c.a.p0.a.k1.k.g.a.c().f();
            c.a.p0.a.k1.k.i.c.e().f();
            if (sVar != null && !this.f8903d.contains(sVar)) {
                this.f8903d.add(sVar);
            }
            boolean m0 = m0();
            c.a.p0.a.k1.h.o().D("preload", m0 ? "1" : "0");
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareRuntime preload = " + m0);
            if (m0) {
                u0();
                return;
            }
            E = PreloadState.LOADING;
            c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_start"));
            g1();
            boolean N = N();
            this.z = N;
            if (N) {
                c.a.p0.a.a2.f c2 = c.a.p0.a.a2.d.c();
                if (!c2.b() && c2.a()) {
                    this.z = false;
                }
            }
            boolean z = this.z;
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "mIsUseV8Master:" + this.z);
            if (this.z) {
                E0(true);
            }
            if (this.f8902c == null) {
                this.f8902c = new q(this, z);
                boolean z2 = A;
                this.w.b(this.f8902c);
            }
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H0(new k(this));
        }
    }

    public final void J0(CopyOnWriteArrayList<s> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, copyOnWriteArrayList) == null) {
            if (this.f8903d == null) {
                this.f8903d = new CopyOnWriteArrayList();
            }
            Iterator<s> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (!this.f8903d.contains(next)) {
                    this.f8903d.add(next);
                }
            }
            H0(new l(this));
        }
    }

    public void K(@NonNull c.a.p0.a.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f8904e.add(bVar);
        }
    }

    public c.a.p0.a.f.e.b K0(Context context, int i2, c.a.p0.a.x.b bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, context, i2, bVar)) == null) {
            long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
            try {
                c.a.p0.a.f.e.b e2 = this.v.e(context, i2);
                if (i2 == 1) {
                    c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_naslave_created"));
                } else {
                    c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_slave_created"));
                }
                e2.d(bVar);
                String b0 = b0();
                if (i2 == 1) {
                    b0 = Z();
                }
                if (b0 != null) {
                    c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                    if (a0 != null && !TextUtils.isEmpty(a0.N())) {
                        String builder = Uri.parse(b0).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, c.a.p0.a.q0.d.v(a0.N(), a0.j0(), false, null, null).getAbsolutePath()).toString();
                        if (!builder.endsWith(File.separator)) {
                            builder = builder + File.separator;
                        }
                        b0 = builder;
                    }
                    e2.loadUrl(b0);
                }
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "prepareSlave loadUrl " + b0);
                if (A) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "prepareSlave cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
                return e2;
            } catch (NullPointerException e3) {
                c.a.p0.a.x.a.e(context);
                throw e3;
            }
        }
        return (c.a.p0.a.f.e.b) invokeLIL.objValue;
    }

    public final String L(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            String str2 = z ? "slave" : "master";
            if (!TextUtils.isEmpty(str)) {
                c.a.p0.a.x.a.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.k && this.f8908i == null) {
            boolean z = A;
            c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_slave_start"));
            this.f8908i = K0(getContext(), 0, new e(this));
            i0();
        }
    }

    public final void M() {
        c.a.p0.a.x.l.g.b<c.a.p0.a.x.l.g.a> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bVar = this.f8905f) == null || E == PreloadState.LOADED) {
            return;
        }
        bVar.c(new b(this));
    }

    public final void M0(c.a.p0.a.f.e.b<?> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (bVar != null) {
                c.a.p0.a.x.t.a.p(bVar);
            }
            this.f8908i = null;
            this.f8909j = null;
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (c.a.p0.a.u.f.e.e.d() || c.a.p0.a.s0.a.o().N() || c.a.p0.a.d0.k.c.f4765d.w() || !s0()) {
                return false;
            }
            return v.c() && new File(Y()).exists();
        }
        return invokeV.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0 && m0() && this.f8908i != null) {
                return true;
            }
            return i2 == 1 && l0() && this.f8909j != null;
        }
        return invokeI.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && r.e()) {
            if (!c.a.p0.a.t1.d.J().r().v0() && !c.a.p0.a.t1.d.J().r().x0()) {
                boolean z2 = u.f8932e != null && u.f8932e.b();
                if (!z && z2) {
                    if (A) {
                        String str = "checkRuntimeRetry: isReuse " + z + ", return.";
                        String str2 = "checkRuntimeRetry: isRunning " + z2 + ", return.";
                        return;
                    }
                    return;
                } else if (m0()) {
                    boolean z3 = A;
                    return;
                } else {
                    S(new h(this));
                    return;
                }
            }
            boolean z4 = A;
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.p.isEmpty()) {
            return;
        }
        Iterator<c.a.p0.a.e0.d.b> it = this.p.iterator();
        while (it.hasNext()) {
            c.a.p0.a.e0.d.b next = it.next();
            if (A) {
                String str = "dispatchPendingEvents event: " + next.a;
            }
            U0(next);
        }
        this.p.clear();
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", E.statsCode(F));
            c.a.p0.a.t1.d.J().w(str, bundle);
        }
    }

    public final void S(c.a.p0.a.p2.g1.c<Boolean> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            c.a.p0.a.p2.q.k(new i(this, cVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    @Nullable
    public ExtensionCore T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f8901b : (ExtensionCore) invokeV.objValue;
    }

    public final void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (u.f8932e == null) {
                t unused = u.f8932e = new t(c.a.p0.a.t1.d.J().getMainLooper());
            }
            u.f8932e.c();
            u.f8932e.d(i2);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void U0(c.a.p0.a.e0.d.b bVar) {
        c.a.p0.a.x.f.a g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (bVar == null) {
                if (A) {
                    throw new IllegalArgumentException("message must be non-null.");
                }
                return;
            }
            synchronized (this.q) {
                if (!this.f8907h) {
                    if (A) {
                        Log.getStackTraceString(new Exception("message:" + bVar.a));
                    }
                    this.p.add(bVar);
                    return;
                }
                if (G) {
                    if (!this.f8905f.g()) {
                        this.f8905f.d(bVar);
                        return;
                    } else if (this.f8905f.a() == 0) {
                        return;
                    } else {
                        g2 = ((c.a.p0.a.x.l.g.a) this.f8905f.a()).i().g();
                    }
                } else {
                    c.a.p0.a.x.l.a aVar = this.f8906g;
                    if (aVar == null) {
                        return;
                    }
                    g2 = aVar.g();
                }
                if (A) {
                    String str = "master dispatch msg:" + bVar.a;
                }
                c.a.p0.a.e0.a.a(g2, bVar);
            }
        }
    }

    @NonNull
    public HashMap<String, c.a.p0.a.f.e.d> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : (HashMap) invokeV.objValue;
    }

    public void V0(String str, c.a.p0.a.e0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, bVar) == null) {
            if (c.a.p0.a.x.l.g.e.a(str)) {
                U0(bVar);
            } else if (c.a.p0.a.x.k.a.a(str)) {
                c.a.p0.a.e0.a.a(c.a.p0.a.u.f.d.f.k().l(), bVar);
            } else {
                c.a.p0.a.f.e.d dVar = this.o.get(str);
                if (dVar == null) {
                    if (A) {
                        String str2 = "can't find view manager. webviewId: " + str + " message: " + bVar;
                        return;
                    }
                    return;
                }
                c.a.p0.a.e0.a.a(dVar.t(), bVar);
            }
        }
    }

    public c.a.p0.a.x.l.a W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (G) {
                if (this.f8905f.g()) {
                    return ((c.a.p0.a.x.l.g.a) this.f8905f.a()).i();
                }
                return null;
            }
            return this.f8906g;
        }
        return (c.a.p0.a.x.l.a) invokeV.objValue;
    }

    public void W0(@NonNull c.a.p0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            q0.e0(new p(this, eVar));
        }
    }

    public String X() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            g1();
            if (r0()) {
                str = Y();
            } else {
                str = this.a.swanCorePath + File.separator + "master/master.html";
            }
            if (c.a.p0.a.x.a.d()) {
                L(str, false);
            } else if (c.a.p0.a.u.f.e.e.d()) {
                c.a.p0.a.u.f.e.d.k();
                c.a.p0.a.u.f.e.d.g().h("loadmaster");
                return c.a.p0.a.u.f.e.e.a();
            } else {
                c.a.p0.a.x.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void X0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (A) {
                    String str = "setExtensionCore before. extension core: " + this.f8901b;
                }
                this.f8901b = extensionCore;
                if (A) {
                    String str2 = "setExtensionCore after. extension core: " + this.f8901b;
                }
            } else if (A) {
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

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (TextUtils.isEmpty(c0())) {
                return "";
            }
            return c0() + "runtime/index.js";
        }
        return (String) invokeV.objValue;
    }

    public void Y0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (A) {
                    String str = "setSwanCoreVersion before. swan core: " + this.a;
                }
                this.a = swanCoreVersion;
                if (A) {
                    String str2 = "setSwanCoreVersion after. swan core: " + this.a;
                }
            } else if (A) {
                Log.getStackTraceString(new Exception("setSwanCoreVersion failed."));
                String str3 = "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion;
            }
        }
    }

    @Nullable
    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slave-talos/index.js";
            if (c.a.p0.a.x.a.d()) {
                L(str, true);
            } else if (c.a.p0.a.u.f.e.e.d()) {
                return c.a.p0.a.u.f.e.e.b();
            } else {
                c.a.p0.a.x.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void Z0(c.a.p0.a.v0.e.b bVar, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, bVar, gVar) == null) {
            if (A) {
                String str = "startFirstPage cur swanCoreVersion: " + this.a;
                String str2 = "startFirstPage launchInfo coreVersion: " + bVar.j0();
            }
            d1(bVar);
            c1(bVar);
            c.a.p0.a.k1.h.o().F(new UbcFlowEvent("na_pre_load_check"));
            c.a.p0.a.c2.a.d().i("na_pre_load_check");
            H0(new m(this, bVar, gVar));
        }
    }

    @Override // c.a.p0.a.w0.h
    public void a(c.a.p0.a.f.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            q0.e0(new o(this));
        }
    }

    @Override // c.a.p0.a.w0.h
    public void b(c.a.p0.a.f.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, dVar) == null) {
            String c2 = dVar.c();
            this.o.remove(c2);
            if (dVar instanceof c.a.p0.a.f.e.b) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, c2);
                U0(new c.a.p0.a.e0.d.d(hashMap));
                c.a.p0.a.u.d.i("SwanApp", "onUnload");
            }
            c.a.p0.a.s1.b.d.a.a();
        }
    }

    @Nullable
    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            g1();
            if (this.a == null) {
                return null;
            }
            String str = this.a.swanCorePath + File.separator + "slaves/slaves.html";
            if (c.a.p0.a.x.a.d()) {
                L(str, true);
            } else if (c.a.p0.a.u.f.e.e.d()) {
                return c.a.p0.a.u.f.e.e.b();
            } else {
                c.a.p0.a.x.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            q0.e0(new n(this, str));
        }
    }

    @Override // c.a.p0.a.w0.h
    public void c(c.a.p0.a.f.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dVar) == null) {
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.a == null) {
                return "";
            }
            return this.a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public void c1(c.a.p0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) {
            ExtensionCore extensionCore = this.f8901b;
            if (extensionCore != null) {
                bVar.C0(extensionCore);
            } else {
                this.f8901b = bVar.O();
            }
        }
    }

    @Override // c.a.p0.a.w0.h
    public void d(c.a.p0.a.f.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) {
            this.o.put(dVar.c(), dVar);
        }
    }

    public SwanCoreVersion d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.a : (SwanCoreVersion) invokeV.objValue;
    }

    public void d1(c.a.p0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bVar) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion != null) {
                bVar.Z0(swanCoreVersion);
            } else {
                this.a = bVar.j0();
            }
        }
    }

    public c.a.p0.a.f.e.d e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            if (this.o.isEmpty() || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.o.get(str);
        }
        return (c.a.p0.a.f.e.d) invokeL.objValue;
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.x) {
                boolean z = A;
                return;
            }
            boolean z2 = true;
            this.x = true;
            c.a.p0.a.t1.d J = c.a.p0.a.t1.d.J();
            z2 = (J == null || !J.D()) ? false : false;
            boolean w = c.a.p0.a.s0.a.g0().w();
            if (!z2 && w) {
                boolean z3 = A;
                c.a.p0.a.x.t.a.n(getContext());
            } else if (A) {
                String str = "Can't preload additional slave manager, isOccupied: " + z2 + ", ab: " + w;
            }
        }
    }

    public r1 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.v : (r1) invokeV.objValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ExtensionCore extensionCore = this.f8901b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                X0(c.a.p0.a.f0.b.c(0));
            }
        }
    }

    @Nullable
    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            i0();
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            SwanCoreVersion swanCoreVersion = this.a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.a)));
                Y0(c.a.p0.a.g2.b.g(0));
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this.q) {
                this.f8907h = false;
                if (G) {
                    this.f8905f.reset();
                } else {
                    this.f8906g = null;
                }
            }
            this.k = false;
            this.l = false;
            this.f8908i = null;
            this.f8909j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", c.a.p0.a.g2.f.a.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", r0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = c.a.p0.a.g2.b.g(0);
                jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
                SwanCoreVersion g3 = c.a.p0.a.g2.b.g(1);
                jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
            } catch (JSONException e2) {
                if (A) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10001);
            bVar.h(c.a.p0.a.t1.e.L() == null ? "null appKey" : c.a.p0.a.t1.e.L().N());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.n = z;
        }
    }

    public final void i0() {
        c.a.p0.a.f.e.b<?> bVar;
        c.a.p0.a.f.e.b<?> bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (TextUtils.isEmpty(this.t) && (bVar2 = this.f8908i) != null) {
                this.t = bVar2.a();
            }
            if (TextUtils.isEmpty(this.t) && (bVar = this.f8909j) != null) {
                this.t = bVar.a();
            }
            if (TextUtils.isEmpty(this.t)) {
                return;
            }
            c.a.p0.a.u.d.k("SwanAppCoreRuntime", "initWebViewUa ua: " + this.t);
        }
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            synchronized (this.q) {
                z = this.f8907h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            synchronized (this.r) {
                z = this.l;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            synchronized (this.q) {
                z = this.f8907h && this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            synchronized (this.q) {
                z = this.k;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
            SwanCoreVersion swanCoreVersion = this.a;
            boolean z = swanCoreVersion != null && swanCoreVersion.isAvailable();
            ExtensionCore extensionCore = this.f8901b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z &= extensionCore.isAvailable();
            }
            if (A) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "isSwanAvailable cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (G) {
                return this.f8905f.i();
            }
            return this.f8906g instanceof c.a.p0.a.x.l.e;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (c.a.p0.a.s0.a.w0().d() || c.a.p0.a.a2.d.a() == null) {
                return true;
            }
            boolean exists = new File(c.a.p0.a.a2.d.a()).exists();
            if (A) {
                String str = "is v8 load success: " + exists;
            }
            return exists;
        }
        return invokeV.booleanValue;
    }

    public final void t0(g gVar, c.a.p0.a.v0.e.b bVar, d.g gVar2) {
        c.a.p0.a.x.l.a aVar;
        c.a.p0.a.f.e.b<?> bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, gVar, bVar, gVar2) == null) {
            if (G) {
                c.a.p0.a.x.l.g.b<c.a.p0.a.x.l.g.a> bVar3 = gVar.f8905f;
                aVar = bVar3.h() ? ((c.a.p0.a.x.l.g.a) bVar3.e(bVar.f0())).i() : null;
            } else {
                aVar = gVar.f8906g;
            }
            if (aVar != null) {
                String d2 = c.a.p0.a.v1.f.o0.c.d(c.a.p0.a.w0.f.U(), bVar, gVar2.f7117b);
                int c2 = c.a.p0.a.x.t.f.a.c(d2);
                if (A) {
                    String str = "launchFirstPage: " + d2 + " salveType:" + c2;
                }
                if ((c2 == 0 || !c.a.p0.a.x.t.f.a.d()) && (bVar2 = gVar.f8908i) != null) {
                    c.a.p0.a.v1.f.o0.c.i(aVar, bVar2, bVar, gVar2);
                    M0(gVar.f8909j);
                } else if (c2 == 1) {
                    G0(aVar, bVar, gVar2);
                }
            }
            if (A) {
                String str2 = "startFirstPage mMasterManager=" + gVar.f8906g + " mSlaveManager=" + gVar.f8908i + " mNASlaveManager=" + gVar.f8909j;
            }
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.f8903d.isEmpty()) {
            return;
        }
        M();
        E = PreloadState.LOADED;
        u.k();
        R("event_preload_finish");
        c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_end"));
        c.a.p0.a.x.l.g.n.a.i().q();
        for (s sVar : this.f8903d) {
            if (sVar != null) {
                if (A) {
                    String str = "onReady result: " + sVar.toString();
                }
                sVar.onCallback(this);
            }
        }
        this.f8903d.clear();
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && !this.f8903d.isEmpty() && m0()) {
            u0();
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            boolean f2 = G ? this.f8905f.f() : this.f8906g != null;
            if (z && !this.f8907h && f2) {
                boolean z2 = A;
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.q) {
                    this.f8907h = true;
                    Q();
                    v0();
                }
            } else if (z || this.f8908i == null || this.k) {
            } else {
                boolean z3 = A;
                c.a.p0.a.k1.h.p("preload").F(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.k = true;
                v0();
            }
        }
    }

    public void x0(String str, PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048644, this, str, prefetchEvent, pMSAppInfo) == null) && G) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (m0() && o0()) {
                    c.a.p0.a.f.e.b<?> bVar = this.f8908i;
                    if (bVar != null) {
                        prefetchEvent.isT7Available = bVar.L();
                    } else {
                        prefetchEvent.isT7Available = p0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    c.a.p0.a.x.o.j.d d2 = c.a.p0.a.x.o.j.d.d();
                    a.b a2 = c.a.p0.a.x.o.j.e.a.a();
                    a2.h(RecordType.PREFETCH_EVENT);
                    a2.f(createMessage.a);
                    d2.f(str, a2.e());
                    String str2 = prefetchEvent.pageUrl;
                    Map<String, String> t2 = createMessage.t();
                    String str3 = t2 != null ? t2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    if (!c.a.p0.a.q0.d.C(prefetchEvent.appPath, str2)) {
                        if (A) {
                            String str4 = "page path - " + str2 + " not exit";
                        }
                        c.a.p0.a.u.d.k("SwanAppCoreRuntime", "page path not exist - " + str2);
                        return;
                    }
                    if (createMessage.u()) {
                        c.a.p0.a.u.c.d();
                        c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f8905f.b(str, createMessage, pMSAppInfo);
                    y0(str, prefetchEvent);
                    if (A) {
                        String str5 = "swan-core version - " + this.a.swanCoreVersionName;
                    }
                    if (c.a.p0.a.x.t.f.a.e() || c.a.p0.a.x.t.f.a.g()) {
                        if (TextUtils.isEmpty(c.a.p0.a.w0.f.U().z()) && !c.a.p0.a.x.t.f.a.h(c.a.p0.a.t1.e.a0())) {
                            boolean z = A;
                            return;
                        } else if (c.a.p0.a.x.t.f.a.c(str2) == 1) {
                            F0();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                c.a.p0.a.u.d.k("SwanAppCoreRuntime", "Runtime is not ready or swanJs is not available");
                return;
            }
            boolean z2 = A;
        }
    }

    public final void y0(String str, PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048645, this, str, prefetchEvent) == null) && c.a.p0.a.x.o.e.a.o()) {
            c.a.p0.a.f.e.b<?> bVar = this.f8908i;
            if (bVar != null && n0()) {
                c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "start prefetch slave");
                long currentTimeMillis = A ? System.currentTimeMillis() : 0L;
                c.a.p0.a.t1.e r2 = c.a.p0.a.t1.d.J().r();
                if (r2 == null) {
                    return;
                }
                c.a.p0.a.x.o.i.a a2 = c.a.p0.a.x.o.i.a.a(bVar, prefetchEvent, r2);
                if (q0.S(bVar, a2.k)) {
                    V0(bVar.c(), a2.b());
                }
                if (A) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str2 = "prefetch slave cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
                c.a.p0.a.u.d.i(PrefetchEvent.MODULE, "prefetch slave finish");
                return;
            }
            boolean z = A;
        }
    }

    public void z0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, intent) == null) {
            A0(intent, null);
        }
    }
}
