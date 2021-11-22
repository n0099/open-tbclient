package b.a.p0.a.n2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.n2.q;
import b.a.p0.a.z2.w;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7312a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f7313b;

    /* renamed from: c  reason: collision with root package name */
    public static Object f7314c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f7315d;

    /* renamed from: e  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f7316e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.e f7317e;

        public a(b.a.p0.a.n2.s.e eVar) {
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
            this.f7317e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7317e.b(n.Z());
                b.a.p0.a.n2.b.k("778", this.f7317e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7319f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f7320g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7321h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f7322i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;
        public final /* synthetic */ NetworkStatRecord o;

        public b(String str, long j, long j2, int i2, int i3, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7318e = str;
            this.f7319f = j;
            this.f7320g = j2;
            this.f7321h = i2;
            this.f7322i = i3;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = str6;
            this.o = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (n.o(this.f7318e)) {
                    if (n.f7312a) {
                        String str = "onRequest: ignore " + this.f7318e;
                        return;
                    }
                    return;
                }
                long j = this.f7319f - this.f7320g;
                boolean z = this.f7321h == 200;
                if (this.f7322i == 0) {
                    if (TextUtils.equals(this.j, "1")) {
                        if (z) {
                            b.a.p0.a.h0.i.g.d.b.d().e(b.a.p0.a.h0.i.g.d.a.c(this.f7318e, this.f7320g, this.f7319f, this.f7321h, this.k));
                        } else {
                            b.a.p0.a.h0.i.g.d.b.d().e(b.a.p0.a.h0.i.g.d.a.a(this.f7318e, this.f7320g, this.f7319f, this.f7321h, this.k));
                        }
                    } else if (TextUtils.equals(this.j, "0")) {
                        b.a.p0.a.h0.i.g.d.b.d().e(b.a.p0.a.h0.i.g.d.a.b(this.f7318e, this.f7320g, this.k));
                    }
                }
                if (z && j < 5000) {
                    if (n.f7312a) {
                        String str2 = "code 200 & cost(" + (this.f7319f - this.f7320g) + ") is ok, don't report";
                        return;
                    }
                    return;
                }
                n.j(this.f7321h, this.f7318e, this.f7322i, this.l, this.m, this.n, this.j, this.f7320g, this.f7319f, this.o);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7324f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7325g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7326h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7327i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

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
            this.f7323e = str;
            this.f7324f = i2;
            this.f7325g = str2;
            this.f7326h = str3;
            this.f7327i = str4;
            this.j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.n2.s.c cVar;
            JSONObject f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a2 = b.a.p0.a.p1.l.a();
                if (n.f7312a) {
                    String str = "get NetworkQuality: " + a2;
                }
                if (TextUtils.equals(this.f7323e, "1")) {
                    cVar = new b.a.p0.a.n2.s.c(this.f7324f, this.f7325g, this.f7326h, a2);
                } else {
                    cVar = new b.a.p0.a.n2.s.c(this.f7325g, a2, 0L, 0L);
                }
                new q.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f7327i)) {
                    cVar.r(this.f7327i);
                }
                if (!TextUtils.isEmpty(this.j)) {
                    cVar.q(this.j);
                }
                cVar.f7380b = "downloadFile";
                if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                    cVar.f7381c = b.a.p0.a.d2.e.L().X().T();
                }
                cVar.f7384f = b.a.p0.a.d2.e.f0();
                cVar.f7379a = n.n(this.k);
                b.a.p0.a.n2.b.k("834", cVar.f());
                b.a.p0.a.e0.d.k("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.e f7328e;

        public d(b.a.p0.a.n2.s.e eVar) {
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
            this.f7328e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("894", this.f7328e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.b f7329e;

        public e(b.a.p0.a.n2.s.b bVar) {
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
            this.f7329e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("751", this.f7329e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f7331f;

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
            this.f7330e = str;
            this.f7331f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                dVar.f7383e = this.f7330e;
                dVar.f7380b = "show";
                dVar.f7379a = "swan";
                ForbiddenInfo forbiddenInfo = this.f7331f;
                dVar.f7381c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f7331f.appId);
                b.a.p0.a.n2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7333f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7334g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Exception f7335h;

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
            this.f7332e = str;
            this.f7333f = str2;
            this.f7334g = i2;
            this.f7335h = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.d2.e a0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
                return;
            }
            b.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
            dVar.f7380b = "login";
            dVar.f7379a = n.n(V.G());
            dVar.f7384f = appId;
            dVar.f7383e = this.f7332e;
            dVar.a("appName", Y);
            dVar.a("invokeFrom", this.f7333f);
            dVar.a("scene", Integer.valueOf(this.f7334g));
            JSONObject f2 = dVar.f();
            if (TextUtils.equals(this.f7332e, "show")) {
                b.a.p0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f2, false);
                b.a.p0.a.n2.b.i("1936", "80", f2);
            } else if (TextUtils.equals(this.f7332e, "success")) {
                b.a.p0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f2, false);
                b.a.p0.a.n2.b.i("1936", "81", f2);
            } else if (TextUtils.equals(this.f7332e, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.f7332e, "check_fail")) {
                b.a.p0.a.e0.d.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f2, this.f7335h, false);
                b.a.p0.a.n2.b.i("1936", "82", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7336e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7337f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7338g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f7339h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Exception f7340i;
        public final /* synthetic */ boolean j;

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
            this.f7336e = str;
            this.f7337f = str2;
            this.f7338g = str3;
            this.f7339h = z;
            this.f7340i = exc;
            this.j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
                b.a V = r.V();
                String Y = r.Y();
                String appId = r.getAppId();
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                dVar.f7380b = "swanLogin";
                dVar.f7379a = n.n(V.G());
                dVar.f7384f = appId;
                dVar.f7383e = this.f7336e;
                dVar.a("appName", Y);
                dVar.a("loginScene", this.f7337f);
                String str = this.f7338g;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                JSONObject f2 = dVar.f();
                if (this.f7339h) {
                    b.a.p0.a.e0.d.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f2, this.f7340i, false);
                } else if (this.j) {
                    b.a.p0.a.e0.d.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f2, this.f7340i, false);
                } else {
                    b.a.p0.a.e0.d.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f2, false);
                }
                b.a.p0.a.n2.b.i("1936", "1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7343g;

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
            this.f7341e = str;
            this.f7342f = str2;
            this.f7343g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
                eVar.f7379a = n.n(b.a.p0.a.d2.d.J().r().l());
                String str = this.f7341e;
                eVar.f7380b = str;
                eVar.f7385g = this.f7342f;
                if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
                    eVar.f7383e = this.f7343g;
                }
                eVar.f7384f = b.a.p0.a.d2.d.J().getAppId();
                eVar.a("source", b.a.p0.a.d2.d.J().r().V().T());
                eVar.a("mode", "normal");
                eVar.a("from", "login");
                JSONObject f2 = eVar.f();
                if (n.f7312a) {
                    String str2 = "staticLoginResult: event = " + f2;
                }
                b.a.p0.a.n2.b.k("1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7344e;

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
            this.f7344e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (n.f7314c) {
                    try {
                        n.f7314c.wait(this.f7344e);
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
        public final /* synthetic */ b.a.p0.a.n2.s.e f7345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.a f7346f;

        public k(b.a.p0.a.n2.s.e eVar, b.a.p0.a.n2.a aVar) {
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
            this.f7345e = eVar;
            this.f7346f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.s.e eVar = this.f7345e;
                if (eVar != null) {
                    b.a.p0.a.n2.b.f(this.f7346f, eVar.f().toString());
                }
                b.a.p0.a.n2.b.c(this.f7346f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7348f;

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
            this.f7347e = z;
            this.f7348f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                dVar.f7379a = n.n(b.a.p0.a.d2.d.J().r().l());
                dVar.f7384f = b.a.p0.a.d2.d.J().getAppId();
                dVar.a("type", Integer.valueOf(this.f7347e ? 1 : 2));
                dVar.a("errorCode", Long.valueOf(b.a.p0.a.b3.b.c().g()));
                dVar.a("degradeUrl", this.f7348f);
                dVar.a("appid", b.a.p0.a.d2.d.J().getAppId());
                dVar.a("hostname", b.a.p0.a.c1.a.n().a());
                dVar.a("_swebfr", b.a.p0.a.b3.c.e());
                b.a.p0.a.n2.b.i("3863", "3863", dVar.f());
                if (this.f7347e) {
                    b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                    aVar.k(1L);
                    aVar.i(2108L);
                    b.a.p0.a.u2.e.a().f(aVar);
                    b.a.p0.a.n2.s.d dVar2 = new b.a.p0.a.n2.s.d();
                    dVar2.p(aVar);
                    dVar2.r(b.a.p0.a.d2.d.J().r().V());
                    dVar2.q(n.n(b.a.p0.a.d2.d.J().l()));
                    dVar2.m(b.a.p0.a.d2.d.J().getAppId());
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
        public final /* synthetic */ b.a.p0.a.n2.s.d f7349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7350f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Exception f7351g;

        public m(b.a.p0.a.n2.s.d dVar, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7349e = dVar;
            this.f7350f = j;
            this.f7351g = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.f7349e.g())) {
                    this.f7349e.k(b.a.p0.a.d2.d.J().r().V().V());
                }
                JSONObject f2 = this.f7349e.f();
                b.a.p0.a.e0.d.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + b.a.p0.a.z2.k.e(new Date(this.f7350f), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f2, this.f7351g, false);
                b.a.p0.a.n2.b.k("671", f2);
            }
        }
    }

    /* renamed from: b.a.p0.a.n2.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0331n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.e f7352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7353f;

        public RunnableC0331n(b.a.p0.a.n2.s.e eVar, String str) {
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
            this.f7352e = eVar;
            this.f7353f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f2 = this.f7352e.f();
                b.a.p0.a.n2.b.k(this.f7353f, f2);
                if ("606".equals(this.f7353f)) {
                    b.a.p0.a.n2.l.a().b(f2.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.e f7356g;

        public o(String str, String str2, b.a.p0.a.n2.s.e eVar) {
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
            this.f7354e = str;
            this.f7355f = str2;
            this.f7356g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.i(this.f7354e, this.f7355f, this.f7356g.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.b f7357e;

        public p(b.a.p0.a.n2.s.b bVar) {
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
            this.f7357e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("751", this.f7357e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.b f7358e;

        public q(b.a.p0.a.n2.s.b bVar) {
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
            this.f7358e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("751", this.f7358e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.b f7359e;

        public r(b.a.p0.a.n2.s.b bVar) {
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
            this.f7359e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("751", this.f7359e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.b f7360e;

        public s(b.a.p0.a.n2.s.b bVar) {
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
            this.f7360e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("751", this.f7360e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330166722, "Lb/a/p0/a/n2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330166722, "Lb/a/p0/a/n2/n;");
                return;
            }
        }
        f7312a = b.a.p0.a.k.f6863a;
        f7313b = Executors.newSingleThreadExecutor();
        f7314c = new Object();
        f7315d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f7316e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f7316e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f7316e;
        copyOnWriteArrayList2.add(b.a.p0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f7316e;
        copyOnWriteArrayList3.add(b.a.p0.a.d0.a.b() + "/smtapp/recordhandler/getrecordinfo");
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
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || !b.a.p0.a.d2.d.J().D() || (P = (V = b.a.p0.a.d2.d.J().r().V()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = V.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
        fVar.f7379a = n(b.a.p0.a.d2.d.J().l());
        fVar.f7384f = V.H();
        if (b.a.p0.a.x1.a.a.F(V.g0())) {
            fVar.f7381c = "remote-debug";
        } else if (b.a.p0.a.x1.a.a.D()) {
            fVar.f7381c = "local-debug";
        } else {
            fVar.f7381c = V.T();
        }
        fVar.f7380b = "launch";
        fVar.f7383e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        b.a.p0.a.n2.e.n(fVar, V.W(), V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = b.a.p0.a.u1.h.d("startup");
        if (d2 != null) {
            if (d2.w() || d2.t()) {
                return;
            }
            d2.E("value", "na_success");
        }
    }

    public static void F(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, str) == null) {
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            if (b.a.p0.a.d2.d.J().r().H()) {
                eVar.d(b.a.p0.a.d2.d.J().r().V().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f7380b = "show";
            eVar.f7381c = str;
            eVar.f7383e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f7384f = b.a.p0.a.d2.e.f0();
            b.a.p0.a.u1.k.i.c.e().d(new a(eVar), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (b.a.p0.a.d2.d.J().r().H()) {
                b.a V = b.a.p0.a.d2.d.J().r().V();
                i2 = V.G();
                str3 = V.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            b.a.p0.a.n2.s.b bVar = new b.a.p0.a.n2.s.b();
            bVar.f7380b = "pay";
            bVar.f7381c = str;
            bVar.f7384f = b.a.p0.a.d2.e.f0();
            bVar.f7379a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", b.a.p0.a.d2.e.L().Y());
                bVar.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                bVar.d(str3);
            }
            bVar.b(Z());
            b.a.p0.a.z2.q.k(new q(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            b.a.p0.a.n2.s.b bVar = new b.a.p0.a.n2.s.b();
            b.a V = b.a.p0.a.d2.d.J().r().V();
            if (b.a.p0.a.d2.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f7380b = "pay";
            bVar.f7383e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f7381c = str;
            bVar.f7384f = b.a.p0.a.d2.e.f0();
            bVar.f7379a = n(V.G());
            bVar.a("money", str2);
            bVar.b(Z());
            b.a.p0.a.z2.q.j(new p(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && b.a.p0.a.d2.d.J().r().H()) {
            b.a V = b.a.p0.a.d2.d.J().r().V();
            int G = V.G();
            b.a.p0.a.n2.s.b bVar = new b.a.p0.a.n2.s.b();
            bVar.f7380b = "paykey";
            bVar.f7379a = n(G);
            bVar.f7381c = str;
            bVar.f7383e = str4;
            bVar.a("appid", V.H());
            bVar.a("money", str2);
            bVar.a("source", V.T());
            bVar.a("pmappkey", str3);
            b.a.p0.a.z2.q.k(new s(bVar), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.p0.a.n2.s.b bVar = new b.a.p0.a.n2.s.b();
            b.a V = b.a.p0.a.d2.d.J().r().V();
            if (b.a.p0.a.d2.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f7380b = "paylogin";
            bVar.f7381c = str;
            bVar.f7384f = V.I();
            bVar.f7379a = n(V.G());
            bVar.f7383e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", b.a.p0.a.c1.a.n().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.U().H();
            b.a.p0.a.m1.c K1 = H == null ? null : H.K1();
            if (K1 != null && !TextUtils.isEmpty(K1.i())) {
                bVar.a("page", K1.i());
            }
            bVar.b(Z());
            b.a.p0.a.z2.q.j(new e(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && b.a.p0.a.d2.d.J().r().H()) {
            b.a V = b.a.p0.a.d2.d.J().r().V();
            int G = V.G();
            b.a.p0.a.n2.s.b bVar = new b.a.p0.a.n2.s.b();
            bVar.f7380b = "payProcess";
            bVar.f7379a = n(G);
            bVar.f7381c = str;
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
            b.a.p0.a.z2.q.k(new r(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7380b = "launch";
            fVar.f7383e = str;
            if (b.a.p0.a.d2.e.a0() != null) {
                b.a V = b.a.p0.a.d2.e.a0().V();
                fVar.f7379a = n(V.G());
                fVar.f7384f = V.H();
                fVar.f7381c = V.T();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            f7313b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (f7312a) {
                    String str3 = "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str;
                }
            } else if (TextUtils.isEmpty(str2)) {
                boolean z = f7312a;
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (f7312a) {
                        String str4 = "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2;
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (f7312a) {
                        String str5 = "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2;
                    }
                } else if (f7315d.contains(host)) {
                    if (f7312a) {
                        String str6 = "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2;
                    }
                } else {
                    if (f7312a) {
                        String str7 = "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject;
                    }
                    b.a.p0.a.n2.b.i("1415", "66", jSONObject);
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

    public static void R(b.a.p0.a.n2.s.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, dVar) == null) || dVar == null) {
            return;
        }
        b.a.p0.a.z2.q.j(new m(dVar, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void S(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            f7313b.execute(new g(str, str2, i2, TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) ? new Exception("stack") : null));
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
            f7313b.execute(new h(str2, str, str3, equals, (equals || equals2) ? new Exception("stack") : null, equals2));
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            f7313b.execute(new l(z, str));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            String str5 = "";
            if (a0 != null) {
                str5 = n(a0.l());
                str4 = a0.N();
                str3 = a0.V().T();
            } else {
                str3 = "";
                str4 = str3;
            }
            eVar.f7379a = str5;
            eVar.f7380b = AlbumActivityConfig.FROM_WEB_VIEW;
            eVar.f7381c = str3;
            eVar.a("appkey", str4);
            eVar.a("url", str);
            eVar.a("browser", str2);
            y("3320", "96", eVar);
            if (f7312a) {
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
                if (f7312a) {
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
            b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
            b.a.p0.a.d2.e r2 = J.r();
            b.a V = r2.V();
            if (J.D() && r2.r0()) {
                Bundle s0 = V.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r2.V().u1());
                    b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
                    fVar.f7379a = n(V.G());
                    fVar.f7380b = "launch";
                    fVar.f7383e = QueryResponse.Options.CANCEL;
                    fVar.q = valueOf;
                    fVar.j(V);
                    fVar.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(V.W()));
                    onEvent(fVar);
                    b.a.p0.a.n2.s.f fVar2 = new b.a.p0.a.n2.s.f();
                    fVar2.f7379a = n(V.G());
                    fVar2.f7380b = "launch";
                    fVar2.f7383e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(V);
                    fVar2.b(k(V.W()));
                    fVar2.a("reason", QueryResponse.Options.CANCEL);
                    if (V.G() == 1) {
                        fVar.a("errorList", b.a.p0.a.c1.b.j().a());
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
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
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
            f7313b.execute(new j(i2));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [b.a.p0.a.n2.n.j.run():void] */
    public static /* synthetic */ boolean b() {
        return f7312a;
    }

    public static b.a.p0.a.n2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? b.a.p0.a.n2.b.a(str) : (b.a.p0.a.n2.a) invokeL.objValue;
    }

    public static void d(b.a.p0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, fVar) == null) || fVar == null || b.a.p0.a.d2.e.L() == null || b.a.p0.a.d2.e.L().X() == null) {
            return;
        }
        b.a X = b.a.p0.a.d2.e.L().X();
        fVar.f7379a = n(X.G());
        fVar.f7384f = X.H();
        fVar.a("appkey", X.I());
        x("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            eVar.f7379a = n(0);
            eVar.f7380b = str;
            x("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                b.a X = b.a.p0.a.d2.e.L().X();
                eVar.f7379a = n(X.G());
                eVar.f7384f = X.H();
                eVar.f7380b = str;
                eVar.f7381c = str2;
                eVar.f7383e = str3;
                eVar.a("appkey", X.I());
            }
            x("923", eVar);
        }
    }

    public static void g(b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, eVar) == null) {
            if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                b.a X = b.a.p0.a.d2.e.L().X();
                eVar.f7379a = n(X.G());
                eVar.f7384f = X.H();
                eVar.f7381c = X.T();
            }
            x("936", eVar);
        }
    }

    public static void h(b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, eVar) == null) {
            if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                b.a X = b.a.p0.a.d2.e.L().X();
                eVar.f7379a = n(X.G());
                eVar.f7384f = X.H();
                eVar.f7381c = X.T();
            }
            x("914", eVar);
        }
    }

    public static void i(b.a.p0.a.n2.a aVar, b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        b.a.p0.a.z2.q.j(new k(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        b.a.p0.a.n2.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = b.a.p0.a.p1.l.a();
            if (f7312a) {
                String str6 = "get NetworkQuality: " + a2;
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new b.a.p0.a.n2.s.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new b.a.p0.a.n2.s.c(str, a2, j2, j3);
            }
            q.a aVar = new q.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.q(str4);
            }
            cVar.f7380b = "request";
            b.a.p0.a.d2.e r2 = b.a.p0.a.d2.d.J().r();
            if (r2 != null && r2.H()) {
                cVar.f7381c = r2.V().T();
                cVar.f7382d = r2.V().V();
            }
            cVar.f7384f = b.a.p0.a.d2.e.f0();
            cVar.f7379a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.f7370b = X;
            if (X != null) {
                cVar.e(X);
            }
            if (f7312a) {
                String str7 = "Reporting: " + cVar.f();
            }
            JSONObject f2 = cVar.f();
            if (cVar.o()) {
                b.a.p0.a.e0.d.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                b.a.p0.a.e0.d.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            b.a.p0.a.n2.b.k("834", f2);
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
                    if (f7312a) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? b.a.p0.a.n1.g.g() ? "1" : "0" : (String) invokeV.objValue;
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
                if (f7312a) {
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
            if (f7312a) {
                String str2 = "isIgnoreRequest: start with " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f7316e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = f7316e.get(i2);
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    if (f7312a) {
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

    public static void onEvent(b.a.p0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, fVar) == null) {
            ExtensionCore T = b.a.p0.a.h0.u.g.U().T();
            if (T != null) {
                fVar.a("extension_ver", T.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", b.a.p0.a.d2.d.J().r().V().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "static", Float.valueOf(b.a.p0.a.c1.a.m().a()));
            fVar.a("device_score", jSONObject.toString());
            x("606", fVar);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (f7314c) {
                try {
                    f7314c.notifyAll();
                }
            }
        }
    }

    public static void q(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            eVar.f7380b = str;
            eVar.f7383e = str2;
            eVar.f7384f = b.a.p0.a.d2.e.f0();
            if (b.a.p0.a.d2.e.L() != null && b.a.p0.a.d2.e.L().X() != null) {
                b.a X = b.a.p0.a.d2.e.L().X();
                eVar.f7381c = X.T();
                eVar.f7379a = n(X.G());
            }
            if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            b.a.p0.a.z2.q.k(new d(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, fVar) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                boolean z = f7312a;
                return;
            }
            b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", b.a.p0.a.h2.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, a0.d0().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f6383b);
                    jSONObject.put("scopeData", fVar.f6382a);
                }
            } catch (JSONException e2) {
                if (f7312a) {
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
            f7313b.execute(new i(str, str2, str3));
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        f7313b.execute(new c(str5, i2, str, str2, str3, str4, i3));
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
        f7313b.execute(new f(str, forbiddenInfo));
    }

    public static void x(String str, b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.u1.k.i.c.e().d(new RunnableC0331n(eVar, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b.a.p0.a.z2.q.j(new o(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
        aVar.k(5L);
        aVar.i(50L);
        b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
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
            if (f7312a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        R(dVar);
    }
}
