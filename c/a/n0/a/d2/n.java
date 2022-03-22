package c.a.n0.a.d2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.q;
import c.a.n0.a.p2.w;
import c.a.n0.a.v0.e.b;
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
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static final ExecutorService f4142b;

    /* renamed from: c  reason: collision with root package name */
    public static Object f4143c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f4144d;

    /* renamed from: e  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f4145e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.e a;

        public a(c.a.n0.a.d2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(n.Z());
                c.a.n0.a.d2.b.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f4146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f4147c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4148d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f4149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4150f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4151g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4152h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ NetworkStatRecord k;

        public b(String str, long j, long j2, int i, int i2, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4146b = j;
            this.f4147c = j2;
            this.f4148d = i;
            this.f4149e = i2;
            this.f4150f = str2;
            this.f4151g = str3;
            this.f4152h = str4;
            this.i = str5;
            this.j = str6;
            this.k = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (n.o(this.a)) {
                    if (n.a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.a);
                        return;
                    }
                    return;
                }
                long j = this.f4146b - this.f4147c;
                boolean z = this.f4148d == 200;
                if (this.f4149e == 0) {
                    if (TextUtils.equals(this.f4150f, "1")) {
                        if (z) {
                            c.a.n0.a.x.i.g.d.b.d().e(c.a.n0.a.x.i.g.d.a.c(this.a, this.f4147c, this.f4146b, this.f4148d, this.f4151g));
                        } else {
                            c.a.n0.a.x.i.g.d.b.d().e(c.a.n0.a.x.i.g.d.a.a(this.a, this.f4147c, this.f4146b, this.f4148d, this.f4151g));
                        }
                    } else if (TextUtils.equals(this.f4150f, "0")) {
                        c.a.n0.a.x.i.g.d.b.d().e(c.a.n0.a.x.i.g.d.a.b(this.a, this.f4147c, this.f4151g));
                    }
                }
                if (z && j < 5000) {
                    if (n.a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.f4146b - this.f4147c) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                n.j(this.f4148d, this.a, this.f4149e, this.f4152h, this.i, this.j, this.f4150f, this.f4147c, this.f4146b, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4153b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4154c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4155d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4158g;

        public c(String str, int i, String str2, String str3, String str4, String str5, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4153b = i;
            this.f4154c = str2;
            this.f4155d = str3;
            this.f4156e = str4;
            this.f4157f = str5;
            this.f4158g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.d2.s.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a = c.a.n0.a.f1.l.a();
                if (n.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a);
                }
                if (TextUtils.equals(this.a, "1")) {
                    cVar = new c.a.n0.a.d2.s.c(this.f4153b, this.f4154c, this.f4155d, a);
                } else {
                    cVar = new c.a.n0.a.d2.s.c(this.f4154c, a, 0L, 0L);
                }
                new q.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f4156e)) {
                    cVar.r(this.f4156e);
                }
                if (!TextUtils.isEmpty(this.f4157f)) {
                    cVar.q(this.f4157f);
                }
                cVar.f4188b = "downloadFile";
                if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                    cVar.f4189c = c.a.n0.a.t1.e.L().X().T();
                }
                cVar.f4192f = c.a.n0.a.t1.e.f0();
                cVar.a = n.n(this.f4158g);
                JSONObject f2 = cVar.f();
                c.a.n0.a.d2.b.k("834", f2);
                c.a.n0.a.u.d.k("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.e a;

        public d(c.a.n0.a.d2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.b a;

        public e(c.a.n0.a.d2.s.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f4159b;

        public f(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4159b = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.f4191e = this.a;
                dVar.f4188b = "show";
                dVar.a = "swan";
                ForbiddenInfo forbiddenInfo = this.f4159b;
                dVar.f4189c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f4159b.appId);
                c.a.n0.a.d2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4160b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4161c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Exception f4162d;

        public g(String str, String str2, int i, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4160b = str2;
            this.f4161c = i;
            this.f4162d = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.t1.e a0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
                return;
            }
            b.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
            dVar.f4188b = "login";
            dVar.a = n.n(V.G());
            dVar.f4192f = appId;
            dVar.f4191e = this.a;
            dVar.a("appName", Y);
            dVar.a("invokeFrom", this.f4160b);
            dVar.a("scene", Integer.valueOf(this.f4161c));
            JSONObject f2 = dVar.f();
            if (TextUtils.equals(this.a, "show")) {
                c.a.n0.a.u.d.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f2, false);
                c.a.n0.a.d2.b.i("1936", "80", f2);
            } else if (TextUtils.equals(this.a, "success")) {
                c.a.n0.a.u.d.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f2, false);
                c.a.n0.a.d2.b.i("1936", "81", f2);
            } else if (TextUtils.equals(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.a, "check_fail")) {
                c.a.n0.a.u.d.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f2, this.f4162d, false);
                c.a.n0.a.d2.b.i("1936", "82", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4163b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4164c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f4165d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Exception f4166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f4167f;

        public h(String str, String str2, String str3, boolean z, Exception exc, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Boolean.valueOf(z), exc, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4163b = str2;
            this.f4164c = str3;
            this.f4165d = z;
            this.f4166e = exc;
            this.f4167f = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
                b.a V = r.V();
                String Y = r.Y();
                String appId = r.getAppId();
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.f4188b = "swanLogin";
                dVar.a = n.n(V.G());
                dVar.f4192f = appId;
                dVar.f4191e = this.a;
                dVar.a("appName", Y);
                dVar.a("loginScene", this.f4163b);
                String str = this.f4164c;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                JSONObject f2 = dVar.f();
                if (this.f4165d) {
                    c.a.n0.a.u.d.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f2, this.f4166e, false);
                } else if (this.f4167f) {
                    c.a.n0.a.u.d.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f2, this.f4166e, false);
                } else {
                    c.a.n0.a.u.d.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f2, false);
                }
                c.a.n0.a.d2.b.i("1936", "1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4168b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4169c;

        public i(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4168b = str2;
            this.f4169c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
                eVar.a = n.n(c.a.n0.a.t1.d.J().r().l());
                String str = this.a;
                eVar.f4188b = str;
                eVar.f4193g = this.f4168b;
                if (TextUtils.equals(str, "click")) {
                    eVar.f4191e = this.f4169c;
                }
                eVar.f4192f = c.a.n0.a.t1.d.J().getAppId();
                eVar.a("source", c.a.n0.a.t1.d.J().r().V().T());
                eVar.a("mode", "normal");
                eVar.a("from", "login");
                JSONObject f2 = eVar.f();
                if (n.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f2);
                }
                c.a.n0.a.d2.b.k("1936", f2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public j(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (n.f4143c) {
                    try {
                        n.f4143c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.d2.a f4170b;

        public k(c.a.n0.a.d2.s.e eVar, c.a.n0.a.d2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f4170b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.s.e eVar = this.a;
                if (eVar != null) {
                    c.a.n0.a.d2.b.f(this.f4170b, eVar.f().toString());
                }
                c.a.n0.a.d2.b.c(this.f4170b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4171b;

        public l(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.f4171b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.a = n.n(c.a.n0.a.t1.d.J().r().l());
                dVar.f4192f = c.a.n0.a.t1.d.J().getAppId();
                dVar.a("type", Integer.valueOf(this.a ? 1 : 2));
                dVar.a("errorCode", Long.valueOf(c.a.n0.a.r2.b.c().g()));
                dVar.a("degradeUrl", this.f4171b);
                dVar.a("appid", c.a.n0.a.t1.d.J().getAppId());
                dVar.a("hostname", c.a.n0.a.s0.a.n().a());
                dVar.a("_swebfr", c.a.n0.a.r2.c.e());
                c.a.n0.a.d2.b.i("3863", "3863", dVar.f());
                if (this.a) {
                    c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                    aVar.k(1L);
                    aVar.i(2108L);
                    c.a.n0.a.k2.e.a().f(aVar);
                    c.a.n0.a.d2.s.d dVar2 = new c.a.n0.a.d2.s.d();
                    dVar2.p(aVar);
                    dVar2.r(c.a.n0.a.t1.d.J().r().V());
                    dVar2.q(n.n(c.a.n0.a.t1.d.J().l()));
                    dVar2.m(c.a.n0.a.t1.d.J().getAppId());
                    n.R(dVar2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f4172b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Exception f4173c;

        public m(c.a.n0.a.d2.s.d dVar, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), exc};
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
            this.f4172b = j;
            this.f4173c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(c.a.n0.a.t1.d.J().r().V().V());
                }
                JSONObject f2 = this.a.f();
                c.a.n0.a.u.d.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + c.a.n0.a.p2.k.e(new Date(this.f4172b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f2, this.f4173c, false);
                c.a.n0.a.d2.b.k("671", f2);
            }
        }
    }

    /* renamed from: c.a.n0.a.d2.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0245n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4174b;

        public RunnableC0245n(c.a.n0.a.d2.s.e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f4174b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f2 = this.a.f();
                c.a.n0.a.d2.b.k(this.f4174b, f2);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.f4174b)) {
                    c.a.n0.a.d2.l.a().b(f2.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4175b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.d2.s.e f4176c;

        public o(String str, String str2, c.a.n0.a.d2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4175b = str2;
            this.f4176c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.i(this.a, this.f4175b, this.f4176c.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.b a;

        public p(c.a.n0.a.d2.s.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.b a;

        public q(c.a.n0.a.d2.s.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.b a;

        public r(c.a.n0.a.d2.s.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.b a;

        public s(c.a.n0.a.d2.s.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.d2.b.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1208399897, "Lc/a/n0/a/d2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1208399897, "Lc/a/n0/a/d2/n;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f4142b = Executors.newSingleThreadExecutor();
        f4143c = new Object();
        f4144d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f4145e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f4145e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f4145e;
        copyOnWriteArrayList2.add(c.a.n0.a.t.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f4145e;
        copyOnWriteArrayList3.add(c.a.n0.a.t.a.b() + "/smtapp/recordhandler/getrecordinfo");
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
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || !c.a.n0.a.t1.d.J().D() || (P = (V = c.a.n0.a.t1.d.J().r().V()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = V.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.a = n(c.a.n0.a.t1.d.J().l());
        fVar.f4192f = V.H();
        if (c.a.n0.a.n1.a.a.F(V.g0())) {
            fVar.f4189c = "remote-debug";
        } else if (c.a.n0.a.n1.a.a.D()) {
            fVar.f4189c = "local-debug";
        } else {
            fVar.f4189c = V.T();
        }
        fVar.f4188b = "launch";
        fVar.f4191e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        c.a.n0.a.d2.e.n(fVar, V.W(), V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = c.a.n0.a.k1.h.d(NodeJS.STARTUP_SCRIPT_NAME);
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
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            if (c.a.n0.a.t1.d.J().r().H()) {
                eVar.d(c.a.n0.a.t1.d.J().r().V().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f4188b = "show";
            eVar.f4189c = str;
            eVar.f4191e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f4192f = c.a.n0.a.t1.e.f0();
            c.a.n0.a.k1.k.i.c.e().d(new a(eVar), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (c.a.n0.a.t1.d.J().r().H()) {
                b.a V = c.a.n0.a.t1.d.J().r().V();
                i2 = V.G();
                str3 = V.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            c.a.n0.a.d2.s.b bVar = new c.a.n0.a.d2.s.b();
            bVar.f4188b = TiebaStatic.DQPay.TYPE_VALUE;
            bVar.f4189c = str;
            bVar.f4192f = c.a.n0.a.t1.e.f0();
            bVar.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", c.a.n0.a.t1.e.L().Y());
                bVar.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                bVar.d(str3);
            }
            bVar.b(Z());
            c.a.n0.a.p2.q.k(new q(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            c.a.n0.a.d2.s.b bVar = new c.a.n0.a.d2.s.b();
            b.a V = c.a.n0.a.t1.d.J().r().V();
            if (c.a.n0.a.t1.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f4188b = TiebaStatic.DQPay.TYPE_VALUE;
            bVar.f4191e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f4189c = str;
            bVar.f4192f = c.a.n0.a.t1.e.f0();
            bVar.a = n(V.G());
            bVar.a("money", str2);
            bVar.b(Z());
            c.a.n0.a.p2.q.j(new p(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && c.a.n0.a.t1.d.J().r().H()) {
            b.a V = c.a.n0.a.t1.d.J().r().V();
            int G = V.G();
            c.a.n0.a.d2.s.b bVar = new c.a.n0.a.d2.s.b();
            bVar.f4188b = "paykey";
            bVar.a = n(G);
            bVar.f4189c = str;
            bVar.f4191e = str4;
            bVar.a("appid", V.H());
            bVar.a("money", str2);
            bVar.a("source", V.T());
            bVar.a("pmappkey", str3);
            c.a.n0.a.p2.q.k(new s(bVar), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.n0.a.d2.s.b bVar = new c.a.n0.a.d2.s.b();
            b.a V = c.a.n0.a.t1.d.J().r().V();
            if (c.a.n0.a.t1.d.J().r().H()) {
                bVar.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f4188b = "paylogin";
            bVar.f4189c = str;
            bVar.f4192f = V.I();
            bVar.a = n(V.G());
            bVar.f4191e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", c.a.n0.a.s0.a.n().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            c.a.n0.a.x.g.f H = c.a.n0.a.w0.f.U().H();
            c.a.n0.a.c1.c L1 = H == null ? null : H.L1();
            if (L1 != null && !TextUtils.isEmpty(L1.i())) {
                bVar.a("page", L1.i());
            }
            bVar.b(Z());
            c.a.n0.a.p2.q.j(new e(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && c.a.n0.a.t1.d.J().r().H()) {
            b.a V = c.a.n0.a.t1.d.J().r().V();
            int G = V.G();
            c.a.n0.a.d2.s.b bVar = new c.a.n0.a.d2.s.b();
            bVar.f4188b = "payProcess";
            bVar.a = n(G);
            bVar.f4189c = str;
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
                    bVar.a("payResultStatus", "cancel");
                }
            }
            bVar.b(Z());
            c.a.n0.a.p2.q.k(new r(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            fVar.f4188b = "launch";
            fVar.f4191e = str;
            if (c.a.n0.a.t1.e.a0() != null) {
                b.a V = c.a.n0.a.t1.e.a0().V();
                fVar.a = n(V.G());
                fVar.f4192f = V.H();
                fVar.f4189c = V.T();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            f4142b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
                }
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                    }
                } else if (f4144d.contains(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                    }
                } else {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject);
                    }
                    c.a.n0.a.d2.b.i("1415", "66", jSONObject);
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

    public static void R(c.a.n0.a.d2.s.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, dVar) == null) || dVar == null) {
            return;
        }
        c.a.n0.a.p2.q.j(new m(dVar, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void S(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            f4142b.execute(new g(str, str2, i2, TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) ? new Exception("stack") : null));
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
            boolean equals = TextUtils.equals(str2, "cancel");
            boolean equals2 = TextUtils.equals(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0);
            f4142b.execute(new h(str2, str, str3, equals, (equals || equals2) ? new Exception("stack") : null, equals2));
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            f4142b.execute(new l(z, str));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
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
            eVar.f4188b = AlbumActivityConfig.FROM_WEB_VIEW;
            eVar.f4189c = str3;
            eVar.a("appkey", str4);
            eVar.a("url", str);
            eVar.a("browser", str2);
            y("3320", "96", eVar);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", eVar.f()));
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
            c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
            c.a.n0.a.t1.e r2 = J.r();
            b.a V = r2.V();
            if (J.D() && r2.r0()) {
                Bundle s0 = V.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r2.V().u1());
                    c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
                    fVar.a = n(V.G());
                    fVar.f4188b = "launch";
                    fVar.f4191e = "cancel";
                    fVar.q = valueOf;
                    fVar.j(V);
                    fVar.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(V.W()));
                    onEvent(fVar);
                    c.a.n0.a.d2.s.f fVar2 = new c.a.n0.a.d2.s.f();
                    fVar2.a = n(V.G());
                    fVar2.f4188b = "launch";
                    fVar2.f4191e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(V);
                    fVar2.b(k(V.W()));
                    fVar2.a("reason", "cancel");
                    if (V.G() == 1) {
                        fVar.a("errorList", c.a.n0.a.s0.b.j().a());
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
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
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
            f4142b.execute(new j(i2));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.a.n0.a.d2.n.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static c.a.n0.a.d2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? c.a.n0.a.d2.b.a(str) : (c.a.n0.a.d2.a) invokeL.objValue;
    }

    public static void d(c.a.n0.a.d2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, fVar) == null) || fVar == null || c.a.n0.a.t1.e.L() == null || c.a.n0.a.t1.e.L().X() == null) {
            return;
        }
        b.a X = c.a.n0.a.t1.e.L().X();
        fVar.a = n(X.G());
        fVar.f4192f = X.H();
        fVar.a("appkey", X.I());
        x("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            eVar.a = n(0);
            eVar.f4188b = str;
            x("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                b.a X = c.a.n0.a.t1.e.L().X();
                eVar.a = n(X.G());
                eVar.f4192f = X.H();
                eVar.f4188b = str;
                eVar.f4189c = str2;
                eVar.f4191e = str3;
                eVar.a("appkey", X.I());
            }
            x("923", eVar);
        }
    }

    public static void g(c.a.n0.a.d2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, eVar) == null) {
            if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                b.a X = c.a.n0.a.t1.e.L().X();
                eVar.a = n(X.G());
                eVar.f4192f = X.H();
                eVar.f4189c = X.T();
            }
            x("936", eVar);
        }
    }

    public static void h(c.a.n0.a.d2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, eVar) == null) {
            if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                b.a X = c.a.n0.a.t1.e.L().X();
                eVar.a = n(X.G());
                eVar.f4192f = X.H();
                eVar.f4189c = X.T();
            }
            x("914", eVar);
        }
    }

    public static void i(c.a.n0.a.d2.a aVar, c.a.n0.a.d2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        c.a.n0.a.p2.q.j(new k(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        c.a.n0.a.d2.s.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = c.a.n0.a.f1.l.a();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new c.a.n0.a.d2.s.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new c.a.n0.a.d2.s.c(str, a2, j2, j3);
            }
            q.a aVar = new q.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.q(str4);
            }
            cVar.f4188b = "request";
            c.a.n0.a.t1.e r2 = c.a.n0.a.t1.d.J().r();
            if (r2 != null && r2.H()) {
                cVar.f4189c = r2.V().T();
                cVar.f4190d = r2.V().V();
            }
            cVar.f4192f = c.a.n0.a.t1.e.f0();
            cVar.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.f4182b = X;
            if (X != null) {
                cVar.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.f());
            }
            JSONObject f2 = cVar.f();
            if (cVar.o()) {
                c.a.n0.a.u.d.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                c.a.n0.a.u.d.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            c.a.n0.a.d2.b.k("834", f2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? c.a.n0.a.d1.g.g() ? "1" : "0" : (String) invokeV.objValue;
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
                Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f4145e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = f4145e.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onEvent(c.a.n0.a.d2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, fVar) == null) {
            ExtensionCore T = c.a.n0.a.x.u.g.U().T();
            if (T != null) {
                fVar.a("extension_ver", T.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", c.a.n0.a.t1.d.J().r().V().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "static", Float.valueOf(c.a.n0.a.s0.a.m().a()));
            fVar.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, fVar);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (f4143c) {
                try {
                    f4143c.notifyAll();
                }
            }
        }
    }

    public static void q(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            eVar.f4188b = str;
            eVar.f4191e = str2;
            eVar.f4192f = c.a.n0.a.t1.e.f0();
            if (c.a.n0.a.t1.e.L() != null && c.a.n0.a.t1.e.L().X() != null) {
                b.a X = c.a.n0.a.t1.e.L().X();
                eVar.f4189c = X.T();
                eVar.a = n(X.G());
            }
            if (TextUtils.equals("click", str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            c.a.n0.a.p2.q.k(new d(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, c.a.n0.a.x1.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, fVar) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
            dVar.o(i2);
            dVar.r(a0.X());
            dVar.q(n(a0.l()));
            dVar.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", c.a.n0.a.x1.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, a0.d0().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f7638b);
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
            f4142b.execute(new i(str, str2, str3));
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        f4142b.execute(new c(str5, i2, str, str2, str3, str4, i3));
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
        f4142b.execute(new f(str, forbiddenInfo));
    }

    public static void x(String str, c.a.n0.a.d2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.n0.a.k1.k.i.c.e().d(new RunnableC0245n(eVar, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, c.a.n0.a.d2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.n0.a.p2.q.j(new o(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
        aVar.k(5L);
        aVar.i(50L);
        c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
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
