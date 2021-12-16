package c.a.q0.a.n2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.n2.q;
import c.a.q0.a.z2.w;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import com.kwad.v8.NodeJS;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f7352b;

    /* renamed from: c  reason: collision with root package name */
    public static Object f7353c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f7354d;

    /* renamed from: e  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f7355e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.e f7356e;

        public a(c.a.q0.a.n2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7356e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7356e.b(n.Z());
                c.a.q0.a.n2.b.k("778", this.f7356e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f7359g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7360h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f7361i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7362j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f7363k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;
        public final /* synthetic */ NetworkStatRecord o;

        public b(String str, long j2, long j3, int i2, int i3, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7357e = str;
            this.f7358f = j2;
            this.f7359g = j3;
            this.f7360h = i2;
            this.f7361i = i3;
            this.f7362j = str2;
            this.f7363k = str3;
            this.l = str4;
            this.m = str5;
            this.n = str6;
            this.o = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (n.o(this.f7357e)) {
                    if (n.a) {
                        String str = "onRequest: ignore " + this.f7357e;
                        return;
                    }
                    return;
                }
                long j2 = this.f7358f - this.f7359g;
                boolean z = this.f7360h == 200;
                if (this.f7361i == 0) {
                    if (TextUtils.equals(this.f7362j, "1")) {
                        if (z) {
                            c.a.q0.a.h0.i.g.d.b.d().e(c.a.q0.a.h0.i.g.d.a.c(this.f7357e, this.f7359g, this.f7358f, this.f7360h, this.f7363k));
                        } else {
                            c.a.q0.a.h0.i.g.d.b.d().e(c.a.q0.a.h0.i.g.d.a.a(this.f7357e, this.f7359g, this.f7358f, this.f7360h, this.f7363k));
                        }
                    } else if (TextUtils.equals(this.f7362j, "0")) {
                        c.a.q0.a.h0.i.g.d.b.d().e(c.a.q0.a.h0.i.g.d.a.b(this.f7357e, this.f7359g, this.f7363k));
                    }
                }
                if (z && j2 < 5000) {
                    if (n.a) {
                        String str2 = "code 200 & cost(" + (this.f7358f - this.f7359g) + ") is ok, don't report";
                        return;
                    }
                    return;
                }
                n.j(this.f7360h, this.f7357e, this.f7361i, this.l, this.m, this.n, this.f7362j, this.f7359g, this.f7358f, this.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7365f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7366g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7367h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7368i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7369j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f7370k;

        public c(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4, str5, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7364e = str;
            this.f7365f = i2;
            this.f7366g = str2;
            this.f7367h = str3;
            this.f7368i = str4;
            this.f7369j = str5;
            this.f7370k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.q0.a.n2.s.c cVar;
            JSONObject f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a = c.a.q0.a.p1.l.a();
                if (n.a) {
                    String str = "get NetworkQuality: " + a;
                }
                if (TextUtils.equals(this.f7364e, "1")) {
                    cVar = new c.a.q0.a.n2.s.c(this.f7365f, this.f7366g, this.f7367h, a);
                } else {
                    cVar = new c.a.q0.a.n2.s.c(this.f7366g, a, 0L, 0L);
                }
                new q.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f7368i)) {
                    cVar.r(this.f7368i);
                }
                if (!TextUtils.isEmpty(this.f7369j)) {
                    cVar.q(this.f7369j);
                }
                cVar.f7422b = "downloadFile";
                if (c.a.q0.a.d2.e.L() != null && c.a.q0.a.d2.e.L().X() != null) {
                    cVar.f7423c = c.a.q0.a.d2.e.L().X().T();
                }
                cVar.f7426f = c.a.q0.a.d2.e.f0();
                cVar.a = n.n(this.f7370k);
                c.a.q0.a.n2.b.k("834", cVar.f());
                c.a.q0.a.e0.d.k("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.e f7371e;

        public d(c.a.q0.a.n2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7371e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("894", this.f7371e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.b f7372e;

        public e(c.a.q0.a.n2.s.b bVar) {
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
            this.f7372e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("751", this.f7372e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f7374f;

        public f(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7373e = str;
            this.f7374f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
                dVar.f7425e = this.f7373e;
                dVar.f7422b = "show";
                dVar.a = "swan";
                ForbiddenInfo forbiddenInfo = this.f7374f;
                dVar.f7423c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f7374f.appId);
                c.a.q0.a.n2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Exception f7378h;

        public g(String str, String str2, int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7375e = str;
            this.f7376f = str2;
            this.f7377g = i2;
            this.f7378h = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.q0.a.d2.e a0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.q0.a.d2.e.a0()) == null) {
                return;
            }
            b.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
            dVar.f7422b = "login";
            dVar.a = n.n(V.G());
            dVar.f7426f = appId;
            dVar.f7425e = this.f7375e;
            dVar.a("appName", Y);
            dVar.a("invokeFrom", this.f7376f);
            dVar.a("scene", Integer.valueOf(this.f7377g));
            JSONObject f2 = dVar.f();
            if (TextUtils.equals(this.f7375e, "show")) {
                c.a.q0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f2, false);
                c.a.q0.a.n2.b.i("1936", "80", f2);
            } else if (TextUtils.equals(this.f7375e, "success")) {
                c.a.q0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f2, false);
                c.a.q0.a.n2.b.i("1936", "81", f2);
            } else if (TextUtils.equals(this.f7375e, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.f7375e, "check_fail")) {
                c.a.q0.a.e0.d.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f2, this.f7378h, false);
                c.a.q0.a.n2.b.i("1936", "82", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7381g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f7382h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Exception f7383i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ boolean f7384j;

        public h(String str, String str2, String str3, boolean z, Exception exc, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Boolean.valueOf(z), exc, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7379e = str;
            this.f7380f = str2;
            this.f7381g = str3;
            this.f7382h = z;
            this.f7383i = exc;
            this.f7384j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.d2.e r = c.a.q0.a.d2.d.J().r();
                b.a V = r.V();
                String Y = r.Y();
                String appId = r.getAppId();
                c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
                dVar.f7422b = "swanLogin";
                dVar.a = n.n(V.G());
                dVar.f7426f = appId;
                dVar.f7425e = this.f7379e;
                dVar.a("appName", Y);
                dVar.a("loginScene", this.f7380f);
                String str = this.f7381g;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                JSONObject f2 = dVar.f();
                if (this.f7382h) {
                    c.a.q0.a.e0.d.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f2, this.f7383i, false);
                } else if (this.f7384j) {
                    c.a.q0.a.e0.d.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f2, this.f7383i, false);
                } else {
                    c.a.q0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f2, false);
                }
                c.a.q0.a.n2.b.i("1936", "1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7387g;

        public i(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7385e = str;
            this.f7386f = str2;
            this.f7387g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
                eVar.a = n.n(c.a.q0.a.d2.d.J().r().l());
                String str = this.f7385e;
                eVar.f7422b = str;
                eVar.f7427g = this.f7386f;
                if (TextUtils.equals(str, "click")) {
                    eVar.f7425e = this.f7387g;
                }
                eVar.f7426f = c.a.q0.a.d2.d.J().getAppId();
                eVar.a("source", c.a.q0.a.d2.d.J().r().V().T());
                eVar.a("mode", "normal");
                eVar.a("from", "login");
                JSONObject f2 = eVar.f();
                if (n.a) {
                    String str2 = "staticLoginResult: event = " + f2;
                }
                c.a.q0.a.n2.b.k("1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7388e;

        public j(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7388e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (n.f7353c) {
                    try {
                        n.f7353c.wait(this.f7388e);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.e f7389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.a f7390f;

        public k(c.a.q0.a.n2.s.e eVar, c.a.q0.a.n2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7389e = eVar;
            this.f7390f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.s.e eVar = this.f7389e;
                if (eVar != null) {
                    c.a.q0.a.n2.b.f(this.f7390f, eVar.f().toString());
                }
                c.a.q0.a.n2.b.c(this.f7390f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7392f;

        public l(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7391e = z;
            this.f7392f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
                dVar.a = n.n(c.a.q0.a.d2.d.J().r().l());
                dVar.f7426f = c.a.q0.a.d2.d.J().getAppId();
                dVar.a("type", Integer.valueOf(this.f7391e ? 1 : 2));
                dVar.a("errorCode", Long.valueOf(c.a.q0.a.b3.b.c().g()));
                dVar.a("degradeUrl", this.f7392f);
                dVar.a("appid", c.a.q0.a.d2.d.J().getAppId());
                dVar.a("hostname", c.a.q0.a.c1.a.n().a());
                dVar.a("_swebfr", c.a.q0.a.b3.c.e());
                c.a.q0.a.n2.b.i("3863", "3863", dVar.f());
                if (this.f7391e) {
                    c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
                    aVar.k(1L);
                    aVar.i(2108L);
                    c.a.q0.a.u2.e.a().f(aVar);
                    c.a.q0.a.n2.s.d dVar2 = new c.a.q0.a.n2.s.d();
                    dVar2.p(aVar);
                    dVar2.r(c.a.q0.a.d2.d.J().r().V());
                    dVar2.q(n.n(c.a.q0.a.d2.d.J().l()));
                    dVar2.m(c.a.q0.a.d2.d.J().getAppId());
                    n.R(dVar2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.d f7393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Exception f7395g;

        public m(c.a.q0.a.n2.s.d dVar, long j2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7393e = dVar;
            this.f7394f = j2;
            this.f7395g = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.f7393e.g())) {
                    this.f7393e.k(c.a.q0.a.d2.d.J().r().V().V());
                }
                JSONObject f2 = this.f7393e.f();
                c.a.q0.a.e0.d.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + c.a.q0.a.z2.k.e(new Date(this.f7394f), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f2, this.f7395g, false);
                c.a.q0.a.n2.b.k("671", f2);
            }
        }
    }

    /* renamed from: c.a.q0.a.n2.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0421n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.e f7396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7397f;

        public RunnableC0421n(c.a.q0.a.n2.s.e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7396e = eVar;
            this.f7397f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f2 = this.f7396e.f();
                c.a.q0.a.n2.b.k(this.f7397f, f2);
                if ("606".equals(this.f7397f)) {
                    c.a.q0.a.n2.l.a().b(f2.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7399f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.e f7400g;

        public o(String str, String str2, c.a.q0.a.n2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7398e = str;
            this.f7399f = str2;
            this.f7400g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.i(this.f7398e, this.f7399f, this.f7400g.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.b f7401e;

        public p(c.a.q0.a.n2.s.b bVar) {
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
            this.f7401e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("751", this.f7401e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.b f7402e;

        public q(c.a.q0.a.n2.s.b bVar) {
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
            this.f7402e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("751", this.f7402e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.b f7403e;

        public r(c.a.q0.a.n2.s.b bVar) {
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
            this.f7403e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("751", this.f7403e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.n2.s.b f7404e;

        public s(c.a.q0.a.n2.s.b bVar) {
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
            this.f7404e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.n2.b.k("751", this.f7404e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628094592, "Lc/a/q0/a/n2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628094592, "Lc/a/q0/a/n2/n;");
                return;
            }
        }
        a = c.a.q0.a.k.a;
        f7352b = Executors.newSingleThreadExecutor();
        f7353c = new Object();
        f7354d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f7355e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f7355e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f7355e;
        copyOnWriteArrayList2.add(c.a.q0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f7355e;
        copyOnWriteArrayList3.add(c.a.q0.a.d0.a.b() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            t(0, str, i2, null, null, null, "0");
        }
    }

    public static void B(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, networkStatRecord) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, "");
        }
    }

    public static void C(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
            M(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord, str2);
        }
    }

    public static void D(String str, int i2, NetworkStatRecord networkStatRecord, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, networkStatRecord, str2) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, str2);
        }
    }

    public static void E() {
        b.a V;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || !c.a.q0.a.d2.d.J().D() || (P = (V = c.a.q0.a.d2.d.J().r().V()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = V.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.q0.a.n2.s.f fVar = new c.a.q0.a.n2.s.f();
        fVar.a = n(c.a.q0.a.d2.d.J().l());
        fVar.f7426f = V.H();
        if (c.a.q0.a.x1.a.a.F(V.g0())) {
            fVar.f7423c = "remote-debug";
        } else if (c.a.q0.a.x1.a.a.D()) {
            fVar.f7423c = "local-debug";
        } else {
            fVar.f7423c = V.T();
        }
        fVar.f7422b = "launch";
        fVar.f7425e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        c.a.q0.a.n2.e.n(fVar, V.W(), V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = c.a.q0.a.u1.h.d(NodeJS.STARTUP_SCRIPT_NAME);
        if (d2 != null) {
            if (d2.w() || d2.t()) {
                return;
            }
            d2.E("value", "na_success");
        }
    }

    public static void F(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            if (c.a.q0.a.d2.d.J().r().H()) {
                eVar.d(c.a.q0.a.d2.d.J().r().V().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f7422b = "show";
            eVar.f7423c = str;
            eVar.f7425e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f7426f = c.a.q0.a.d2.e.f0();
            c.a.q0.a.u1.k.i.c.e().d(new a(eVar), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (c.a.q0.a.d2.d.J().r().H()) {
                b.a V = c.a.q0.a.d2.d.J().r().V();
                i2 = V.G();
                str3 = V.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            c.a.q0.a.n2.s.b bVar = new c.a.q0.a.n2.s.b();
            bVar.f7422b = "pay";
            bVar.f7423c = str;
            bVar.f7426f = c.a.q0.a.d2.e.f0();
            bVar.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", c.a.q0.a.d2.e.L().Y());
                bVar.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                bVar.d(str3);
            }
            bVar.b(Z());
            c.a.q0.a.z2.q.k(new q(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            c.a.q0.a.n2.s.b bVar = new c.a.q0.a.n2.s.b();
            b.a V = c.a.q0.a.d2.d.J().r().V();
            if (c.a.q0.a.d2.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f7422b = "pay";
            bVar.f7425e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f7423c = str;
            bVar.f7426f = c.a.q0.a.d2.e.f0();
            bVar.a = n(V.G());
            bVar.a("money", str2);
            bVar.b(Z());
            c.a.q0.a.z2.q.j(new p(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && c.a.q0.a.d2.d.J().r().H()) {
            b.a V = c.a.q0.a.d2.d.J().r().V();
            int G = V.G();
            c.a.q0.a.n2.s.b bVar = new c.a.q0.a.n2.s.b();
            bVar.f7422b = "paykey";
            bVar.a = n(G);
            bVar.f7423c = str;
            bVar.f7425e = str4;
            bVar.a("appid", V.H());
            bVar.a("money", str2);
            bVar.a("source", V.T());
            bVar.a("pmappkey", str3);
            c.a.q0.a.z2.q.k(new s(bVar), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.q0.a.n2.s.b bVar = new c.a.q0.a.n2.s.b();
            b.a V = c.a.q0.a.d2.d.J().r().V();
            if (c.a.q0.a.d2.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f7422b = "paylogin";
            bVar.f7423c = str;
            bVar.f7426f = V.I();
            bVar.a = n(V.G());
            bVar.f7425e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", c.a.q0.a.c1.a.n().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            c.a.q0.a.h0.g.f H = c.a.q0.a.g1.f.U().H();
            c.a.q0.a.m1.c O1 = H == null ? null : H.O1();
            if (O1 != null && !TextUtils.isEmpty(O1.i())) {
                bVar.a("page", O1.i());
            }
            bVar.b(Z());
            c.a.q0.a.z2.q.j(new e(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && c.a.q0.a.d2.d.J().r().H()) {
            b.a V = c.a.q0.a.d2.d.J().r().V();
            int G = V.G();
            c.a.q0.a.n2.s.b bVar = new c.a.q0.a.n2.s.b();
            bVar.f7422b = "payProcess";
            bVar.a = n(G);
            bVar.f7423c = str;
            bVar.a("paymentProcess", str2);
            bVar.a("appid", V.H());
            bVar.a("source", V.T());
            if (V.j0() != null) {
                bVar.a("swan", V.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 == 0) {
                    bVar.a("payResultStatus", "success");
                } else if (i2 != 2) {
                    bVar.a("payResultStatus", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } else {
                    bVar.a("payResultStatus", QueryResponse.Options.CANCEL);
                }
            }
            bVar.b(Z());
            c.a.q0.a.z2.q.k(new r(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            c.a.q0.a.n2.s.f fVar = new c.a.q0.a.n2.s.f();
            fVar.f7422b = "launch";
            fVar.f7425e = str;
            if (c.a.q0.a.d2.e.a0() != null) {
                b.a V = c.a.q0.a.d2.e.a0().V();
                fVar.a = n(V.G());
                fVar.f7426f = V.H();
                fVar.f7423c = V.T();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            f7352b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (a) {
                    String str3 = "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str;
                }
            } else if (TextUtils.isEmpty(str2)) {
                boolean z = a;
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (a) {
                        String str4 = "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2;
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (a) {
                        String str5 = "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2;
                    }
                } else if (f7354d.contains(host)) {
                    if (a) {
                        String str6 = "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2;
                    }
                } else {
                    if (a) {
                        String str7 = "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject;
                    }
                    c.a.q0.a.n2.b.i("1415", "66", jSONObject);
                }
            }
        }
    }

    public static void O(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, "");
        }
    }

    public static void P(int i2, String str, int i3, String str2, long j2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3), str3}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, str3);
        }
    }

    public static void Q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5}) == null) {
            M(i2, str, i3, str2, str3, str4, "1", j2, j3, null, str5);
        }
    }

    public static void R(c.a.q0.a.n2.s.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, dVar) == null) || dVar == null) {
            return;
        }
        c.a.q0.a.z2.q.j(new m(dVar, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void S(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            f7352b.execute(new g(str, str2, i2, TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) ? new Exception("stack") : null));
        }
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            U(str, str2, null);
        }
    }

    public static void U(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, str2, str3) == null) {
            boolean equals = TextUtils.equals(str2, QueryResponse.Options.CANCEL);
            boolean equals2 = TextUtils.equals(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0);
            f7352b.execute(new h(str2, str, str3, equals, (equals || equals2) ? new Exception("stack") : null, equals2));
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            f7352b.execute(new l(z, str));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            String str5 = "";
            if (a0 != null) {
                str5 = n(a0.l());
                str4 = a0.N();
                str3 = a0.V().T();
            } else {
                str3 = "";
                str4 = str3;
            }
            eVar.a = str5;
            eVar.f7422b = AlbumActivityConfig.FROM_WEB_VIEW;
            eVar.f7423c = str3;
            eVar.a("appkey", str4);
            eVar.a("url", str);
            eVar.a("browser", str2);
            y("3320", "96", eVar);
            if (a) {
                String str6 = "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", eVar.f());
            }
        }
    }

    public static JSONObject X(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, networkStatRecord)) == null) {
            if (networkStatRecord == null) {
                return null;
            }
            long j2 = networkStatRecord.dnsEndTs;
            long j3 = networkStatRecord.dnsStartTs;
            long j4 = networkStatRecord.connTs;
            long j5 = networkStatRecord.startTs;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_network_start", j5);
                jSONObject.put("request_network_conn", j4);
                jSONObject.put("request_dns_start", j3);
                jSONObject.put("request_dns_end", j2);
                jSONObject.put("request_network_response", networkStatRecord.responseTs);
                jSONObject.put("request_send_header", networkStatRecord.sendHeaderTs);
                jSONObject.put("request_receive_header", networkStatRecord.receiveHeaderTs);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("connectTime", jSONObject);
                return jSONObject2;
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            c.a.q0.a.d2.d J = c.a.q0.a.d2.d.J();
            c.a.q0.a.d2.e r2 = J.r();
            b.a V = r2.V();
            if (J.D() && r2.r0()) {
                Bundle s0 = V.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r2.V().u1());
                    c.a.q0.a.n2.s.f fVar = new c.a.q0.a.n2.s.f();
                    fVar.a = n(V.G());
                    fVar.f7422b = "launch";
                    fVar.f7425e = QueryResponse.Options.CANCEL;
                    fVar.q = valueOf;
                    fVar.j(V);
                    fVar.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(V.W()));
                    onEvent(fVar);
                    c.a.q0.a.n2.s.f fVar2 = new c.a.q0.a.n2.s.f();
                    fVar2.a = n(V.G());
                    fVar2.f7422b = "launch";
                    fVar2.f7425e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(V);
                    fVar2.b(k(V.W()));
                    fVar2.a("reason", QueryResponse.Options.CANCEL);
                    if (V.G() == 1) {
                        fVar.a("errorList", c.a.q0.a.c1.b.j().a());
                    }
                    fVar2.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(fVar2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        b.a X;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            c.a.q0.a.d2.e L = c.a.q0.a.d2.e.L();
            if (L == null || (X = L.X()) == null || (M = X.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            f7352b.execute(new j(i2));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.a.q0.a.n2.n.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static c.a.q0.a.n2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? c.a.q0.a.n2.b.a(str) : (c.a.q0.a.n2.a) invokeL.objValue;
    }

    public static void d(c.a.q0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, fVar) == null) || fVar == null || c.a.q0.a.d2.e.L() == null || c.a.q0.a.d2.e.L().X() == null) {
            return;
        }
        b.a X = c.a.q0.a.d2.e.L().X();
        fVar.a = n(X.G());
        fVar.f7426f = X.H();
        fVar.a("appkey", X.I());
        x("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.a = n(0);
            eVar.f7422b = str;
            x("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            if (c.a.q0.a.d2.e.L() != null && c.a.q0.a.d2.e.L().X() != null) {
                b.a X = c.a.q0.a.d2.e.L().X();
                eVar.a = n(X.G());
                eVar.f7426f = X.H();
                eVar.f7422b = str;
                eVar.f7423c = str2;
                eVar.f7425e = str3;
                eVar.a("appkey", X.I());
            }
            x("923", eVar);
        }
    }

    public static void g(c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, eVar) == null) {
            if (c.a.q0.a.d2.e.L() != null && c.a.q0.a.d2.e.L().X() != null) {
                b.a X = c.a.q0.a.d2.e.L().X();
                eVar.a = n(X.G());
                eVar.f7426f = X.H();
                eVar.f7423c = X.T();
            }
            x("936", eVar);
        }
    }

    public static void h(c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, eVar) == null) {
            if (c.a.q0.a.d2.e.L() != null && c.a.q0.a.d2.e.L().X() != null) {
                b.a X = c.a.q0.a.d2.e.L().X();
                eVar.a = n(X.G());
                eVar.f7426f = X.H();
                eVar.f7423c = X.T();
            }
            x("914", eVar);
        }
    }

    public static void i(c.a.q0.a.n2.a aVar, c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        c.a.q0.a.z2.q.j(new k(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        c.a.q0.a.n2.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = c.a.q0.a.p1.l.a();
            if (a) {
                String str6 = "get NetworkQuality: " + a2;
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new c.a.q0.a.n2.s.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new c.a.q0.a.n2.s.c(str, a2, j2, j3);
            }
            q.a aVar = new q.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.q(str4);
            }
            cVar.f7422b = "request";
            c.a.q0.a.d2.e r2 = c.a.q0.a.d2.d.J().r();
            if (r2 != null && r2.H()) {
                cVar.f7423c = r2.V().T();
                cVar.f7424d = r2.V().V();
            }
            cVar.f7426f = c.a.q0.a.d2.e.f0();
            cVar.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.f7411b = X;
            if (X != null) {
                cVar.e(X);
            }
            if (a) {
                String str7 = "Reporting: " + cVar.f();
            }
            JSONObject f2 = cVar.f();
            if (cVar.o()) {
                c.a.q0.a.e0.d.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                c.a.q0.a.e0.d.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            c.a.q0.a.n2.b.k("834", f2);
            N(cVar.m(), cVar.n(), f2);
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null) {
                        if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                            return optJSONObject;
                        }
                    }
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? c.a.q0.a.n1.g.g() ? "1" : "0" : (String) invokeV.objValue;
    }

    @NonNull
    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (a) {
                String str2 = "isIgnoreRequest: start with " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f7355e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = f7355e.get(i2);
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    if (a) {
                        String str4 = "isIgnoreRequest: ignore " + str;
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onEvent(c.a.q0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, fVar) == null) {
            ExtensionCore T = c.a.q0.a.h0.u.g.U().T();
            if (T != null) {
                fVar.a("extension_ver", T.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", c.a.q0.a.d2.d.J().r().V().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "static", Float.valueOf(c.a.q0.a.c1.a.m().a()));
            fVar.a("device_score", jSONObject.toString());
            x("606", fVar);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (f7353c) {
                try {
                    f7353c.notifyAll();
                }
            }
        }
    }

    public static void q(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7422b = str;
            eVar.f7425e = str2;
            eVar.f7426f = c.a.q0.a.d2.e.f0();
            if (c.a.q0.a.d2.e.L() != null && c.a.q0.a.d2.e.L().X() != null) {
                b.a X = c.a.q0.a.d2.e.L().X();
                eVar.f7423c = X.T();
                eVar.a = n(X.G());
            }
            if (TextUtils.equals("click", str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            c.a.q0.a.z2.q.k(new d(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, c.a.q0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, fVar) == null) {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 == null) {
                boolean z = a;
                return;
            }
            c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", c.a.q0.a.h2.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, a0.d0().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f6544b);
                    jSONObject.put("scopeData", fVar.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            R(dVar);
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, str, str2, str3) == null) {
            f7352b.execute(new i(str, str2, str3));
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        f7352b.execute(new c(str5, i2, str, str2, str3, str4, i3));
    }

    public static void u(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            t(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void v(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            t(i2, str, i3, str2, str3, str4, "1");
        }
    }

    public static void w(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, forbiddenInfo, str) == null) || forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        f7352b.execute(new f(str, forbiddenInfo));
    }

    public static void x(String str, c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.q0.a.u1.k.i.c.e().d(new RunnableC0421n(eVar, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.q0.a.z2.q.j(new o(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        c.a.q0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (a0 = c.a.q0.a.d2.e.a0()) == null) {
            return;
        }
        c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
        aVar.k(5L);
        aVar.i(50L);
        c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
        dVar.p(aVar);
        dVar.r(a0.V());
        dVar.q(n(a0.l()));
        dVar.m(a0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", a0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        R(dVar);
    }
}
