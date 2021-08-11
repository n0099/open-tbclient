package c.a.n0.a.j2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.n;
import c.a.n0.a.v2.q;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6734a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f6735b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f6736c;

    /* renamed from: d  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f6737d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f6739f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f6740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6741h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6742i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6743j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ NetworkStatRecord n;

        public a(String str, long j2, long j3, int i2, int i3, String str2, String str3, String str4, String str5, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6738e = str;
            this.f6739f = j2;
            this.f6740g = j3;
            this.f6741h = i2;
            this.f6742i = i3;
            this.f6743j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (k.n(this.f6738e)) {
                    if (k.f6734a) {
                        String str = "onRequest: ignore " + this.f6738e;
                        return;
                    }
                    return;
                }
                long j2 = this.f6739f - this.f6740g;
                boolean z = this.f6741h == 200;
                if (this.f6742i == 0) {
                    if (TextUtils.equals(this.f6743j, "1")) {
                        if (z) {
                            c.a.n0.a.h0.i.i.p(this.f6738e, j2);
                        } else {
                            c.a.n0.a.h0.i.i.n(this.f6738e, this.f6741h);
                        }
                    } else if (TextUtils.equals(this.f6743j, "0")) {
                        c.a.n0.a.h0.i.i.o(this.f6738e);
                    }
                }
                if (z && j2 < 5000) {
                    if (k.f6734a) {
                        String str2 = "code 200 & cost(" + (this.f6739f - this.f6740g) + ") is ok, don't report";
                        return;
                    }
                    return;
                }
                k.j(this.f6741h, this.f6738e, this.f6742i, this.k, this.l, this.m, this.f6743j, this.f6740g, this.f6739f, this.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6747h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6748i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6749j;
        public final /* synthetic */ int k;

        public b(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
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
            this.f6744e = str;
            this.f6745f = i2;
            this.f6746g = str2;
            this.f6747h = str3;
            this.f6748i = str4;
            this.f6749j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.j2.p.c cVar;
            JSONObject f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a2 = c.a.n0.a.n1.l.a();
                if (k.f6734a) {
                    String str = "get NetworkQuality: " + a2;
                }
                if (TextUtils.equals(this.f6744e, "1")) {
                    cVar = new c.a.n0.a.j2.p.c(this.f6745f, this.f6746g, this.f6747h, a2);
                } else {
                    cVar = new c.a.n0.a.j2.p.c(this.f6746g, a2, 0L, 0L);
                }
                new n.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f6748i)) {
                    cVar.q(this.f6748i);
                }
                if (!TextUtils.isEmpty(this.f6749j)) {
                    cVar.p(this.f6749j);
                }
                cVar.f6790b = "downloadFile";
                if (c.a.n0.a.a2.e.i() != null && c.a.n0.a.a2.e.i().N() != null) {
                    cVar.f6791c = c.a.n0.a.a2.e.i().N().T();
                }
                cVar.f6794f = c.a.n0.a.a2.e.V();
                cVar.f6789a = k.m(this.k);
                c.a.n0.a.j2.b.k("834", cVar.f());
                c.a.n0.a.e0.d.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.e f6750e;

        public c(c.a.n0.a.j2.p.e eVar) {
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
            this.f6750e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k("894", this.f6750e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.b f6751e;

        public d(c.a.n0.a.j2.p.b bVar) {
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
            this.f6751e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k("751", this.f6751e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f6753f;

        public e(String str, ForbiddenInfo forbiddenInfo) {
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
            this.f6752e = str;
            this.f6753f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                dVar.f6793e = this.f6752e;
                dVar.f6790b = "show";
                dVar.f6789a = "swan";
                ForbiddenInfo forbiddenInfo = this.f6753f;
                dVar.f6791c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f6753f.appId);
                c.a.n0.a.j2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6755f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6756g;

        public f(String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6754e = str;
            this.f6755f = str2;
            this.f6756g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.a2.e Q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = c.a.n0.a.a2.e.Q()) == null) {
                return;
            }
            b.a L = Q.L();
            String O = Q.O();
            String appId = Q.getAppId();
            c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
            dVar.f6790b = "login";
            dVar.f6789a = k.m(L.G());
            dVar.f6794f = appId;
            dVar.f6793e = this.f6754e;
            dVar.a("appName", O);
            dVar.a("invokeFrom", this.f6755f);
            dVar.a("scene", Integer.valueOf(this.f6756g));
            if (TextUtils.equals(this.f6754e, "show")) {
                c.a.n0.a.j2.b.i("1936", "80", dVar.f());
            } else if (TextUtils.equals(this.f6754e, "success")) {
                c.a.n0.a.j2.b.i("1936", "81", dVar.f());
            } else if (TextUtils.equals(this.f6754e, com.baidu.pass.biometrics.face.liveness.b.a.g0)) {
                c.a.n0.a.j2.b.i("1936", "82", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6759g;

        public g(String str, String str2, String str3) {
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
            this.f6757e = str;
            this.f6758f = str2;
            this.f6759g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
                b.a L = r.L();
                String O = r.O();
                String appId = r.getAppId();
                c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                dVar.f6790b = "swanLogin";
                dVar.f6789a = k.m(L.G());
                dVar.f6794f = appId;
                dVar.f6793e = this.f6757e;
                dVar.a("appName", O);
                dVar.a("loginScene", this.f6758f);
                String str = this.f6759g;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                c.a.n0.a.j2.b.i("1936", "1936", dVar.f());
                if (k.f6734a) {
                    String str2 = "onSwanLoginProcessStatistic: scene = " + this.f6758f + " value = " + this.f6757e + " info = " + this.f6759g;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.e f6760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.a f6761f;

        public h(c.a.n0.a.j2.p.e eVar, c.a.n0.a.j2.a aVar) {
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
            this.f6760e = eVar;
            this.f6761f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.p.e eVar = this.f6760e;
                if (eVar != null) {
                    c.a.n0.a.j2.b.f(this.f6761f, eVar.f().toString());
                }
                c.a.n0.a.j2.b.c(this.f6761f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.d f6762e;

        public i(c.a.n0.a.j2.p.d dVar) {
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
            this.f6762e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.f6762e.g())) {
                    this.f6762e.k(c.a.n0.a.a2.d.g().r().L().V());
                }
                c.a.n0.a.j2.b.k("671", this.f6762e.f());
                c.a.n0.a.e0.d.h("SwanAppUBCStatistic", "671 event=" + this.f6762e.f().toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.e f6764f;

        public j(String str, c.a.n0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6763e = str;
            this.f6764f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k(this.f6763e, this.f6764f.f());
            }
        }
    }

    /* renamed from: c.a.n0.a.j2.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0266k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.e f6767g;

        public RunnableC0266k(String str, String str2, c.a.n0.a.j2.p.e eVar) {
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
            this.f6765e = str;
            this.f6766f = str2;
            this.f6767g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.i(this.f6765e, this.f6766f, this.f6767g.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.b f6768e;

        public l(c.a.n0.a.j2.p.b bVar) {
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
            this.f6768e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k("751", this.f6768e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.b f6769e;

        public m(c.a.n0.a.j2.p.b bVar) {
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
            this.f6769e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k("751", this.f6769e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.b f6770e;

        public n(c.a.n0.a.j2.p.b bVar) {
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
            this.f6770e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.j2.b.k("751", this.f6770e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.j2.p.e f6771e;

        public o(c.a.n0.a.j2.p.e eVar) {
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
            this.f6771e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6771e.b(k.R());
                c.a.n0.a.j2.b.k("778", this.f6771e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213940930, "Lc/a/n0/a/j2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213940930, "Lc/a/n0/a/j2/k;");
                return;
            }
        }
        f6734a = c.a.n0.a.k.f6803a;
        f6735b = Executors.newSingleThreadExecutor();
        f6736c = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f6737d = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f6737d.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f6737d;
        copyOnWriteArrayList2.add(c.a.n0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f6737d;
        copyOnWriteArrayList3.add(c.a.n0.a.d0.a.d() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A() {
        b.a L;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || !c.a.n0.a.a2.d.g().C() || (P = (L = c.a.n0.a.a2.d.g().r().L()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = L.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
        fVar.f6789a = m(c.a.n0.a.a2.d.g().l());
        fVar.f6794f = L.H();
        if (c.a.n0.a.u1.a.a.E(L.g0())) {
            fVar.f6791c = "remote-debug";
        } else if (c.a.n0.a.u1.a.a.C()) {
            fVar.f6791c = "local-debug";
        } else {
            fVar.f6791c = L.T();
        }
        fVar.f6790b = "launch";
        fVar.f6793e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        c.a.n0.a.j2.e.n(fVar, L.W(), L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = c.a.n0.a.r1.h.d("startup");
        if (d2 != null) {
            if (d2.t() || d2.r()) {
                return;
            }
            d2.B("value", "na_success");
        }
    }

    public static void B(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, str) == null) {
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            if (c.a.n0.a.a2.d.g().r().e()) {
                eVar.d(c.a.n0.a.a2.d.g().r().L().r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f6790b = "show";
            eVar.f6791c = str;
            eVar.f6793e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f6794f = c.a.n0.a.a2.e.V();
            c.a.n0.a.r1.k.i.c.f().e(new o(eVar), "SwanAppUBCOnPagesRoute");
        }
    }

    public static void C(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, list) == null) {
            if (c.a.n0.a.a2.d.g().r().e()) {
                b.a L = c.a.n0.a.a2.d.g().r().L();
                i2 = L.G();
                str3 = L.r0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            c.a.n0.a.j2.p.b bVar = new c.a.n0.a.j2.p.b();
            bVar.f6790b = "pay";
            bVar.f6791c = str;
            bVar.f6794f = c.a.n0.a.a2.e.V();
            bVar.f6789a = m(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", c.a.n0.a.a2.e.i().O());
                bVar.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                bVar.d(str3);
            }
            bVar.b(R());
            q.j(new m(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void D(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            c.a.n0.a.j2.p.b bVar = new c.a.n0.a.j2.p.b();
            b.a L = c.a.n0.a.a2.d.g().r().L();
            if (c.a.n0.a.a2.d.g().r().e()) {
                bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f6790b = "pay";
            bVar.f6793e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f6791c = str;
            bVar.f6794f = c.a.n0.a.a2.e.V();
            bVar.f6789a = m(L.G());
            bVar.a("money", str2);
            bVar.b(R());
            q.i(new l(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void E(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.n0.a.j2.p.b bVar = new c.a.n0.a.j2.p.b();
            b.a L = c.a.n0.a.a2.d.g().r().L();
            if (c.a.n0.a.a2.d.g().r().e()) {
                bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f6790b = "paylogin";
            bVar.f6791c = str;
            bVar.f6794f = L.I();
            bVar.f6789a = m(L.G());
            bVar.f6793e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", c.a.n0.a.c1.a.m().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            c.a.n0.a.h0.g.f J = c.a.n0.a.g1.f.V().J();
            c.a.n0.a.l1.c I1 = J == null ? null : J.I1();
            if (I1 != null && !TextUtils.isEmpty(I1.g())) {
                bVar.a("page", I1.g());
            }
            bVar.b(R());
            q.i(new d(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void F(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, i2) == null) && c.a.n0.a.a2.d.g().r().e()) {
            b.a L = c.a.n0.a.a2.d.g().r().L();
            int G = L.G();
            c.a.n0.a.j2.p.b bVar = new c.a.n0.a.j2.p.b();
            bVar.f6790b = "payProcess";
            bVar.f6789a = m(G);
            bVar.f6791c = str;
            bVar.a("paymentProcess", str2);
            bVar.a("appid", L.H());
            bVar.a("source", L.T());
            if (L.i0() != null) {
                bVar.a("swan", L.i0().swanCoreVersionName);
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
            bVar.b(R());
            q.j(new n(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
            fVar.f6790b = "launch";
            fVar.f6793e = str;
            if (c.a.n0.a.a2.e.Q() != null) {
                b.a L = c.a.n0.a.a2.e.Q().L();
                fVar.f6789a = m(L.G());
                fVar.f6794f = L.H();
                fVar.f6791c = L.T();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void H(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            f6735b.execute(new a(str, j3, j2, i2, i3, str5, str2, str3, str4, networkStatRecord));
        }
    }

    public static void I(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (f6734a) {
                    String str3 = "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str;
                }
            } else if (TextUtils.isEmpty(str2)) {
                boolean z = f6734a;
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (f6734a) {
                        String str4 = "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2;
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (f6734a) {
                        String str5 = "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2;
                    }
                } else if (f6736c.contains(host)) {
                    if (f6734a) {
                        String str6 = "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2;
                    }
                } else {
                    if (f6734a) {
                        String str7 = "RequestForAvatar: onRequestForAvatar: hit. url=" + str2;
                        String str8 = "value=" + jSONObject;
                    }
                    c.a.n0.a.j2.b.i("1415", "66", jSONObject);
                }
            }
        }
    }

    public static void J(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            K(i2, str, i3, str2, null, null, j2, j3);
        }
    }

    public static void K(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            H(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
        }
    }

    public static void L(c.a.n0.a.j2.p.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, dVar) == null) || dVar == null) {
            return;
        }
        q.i(new i(dVar), "SwanAppUBCStability");
    }

    public static void M(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, str, i2, str2) == null) {
            f6735b.execute(new f(str, str2, i2));
        }
    }

    public static void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            O(str, str2, null);
        }
    }

    public static void O(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            f6735b.execute(new g(str2, str, str3));
        }
    }

    public static JSONObject P(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, networkStatRecord)) == null) {
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
                if (f6734a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            c.a.n0.a.a2.d g2 = c.a.n0.a.a2.d.g();
            c.a.n0.a.a2.e r = g2.r();
            b.a L = r.L();
            if (g2.C() && r.i0()) {
                Bundle r0 = L.r0();
                if (r0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r.L().s1());
                    c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
                    fVar.f6789a = m(L.G());
                    fVar.f6790b = "launch";
                    fVar.f6793e = QueryResponse.Options.CANCEL;
                    fVar.q = valueOf;
                    fVar.j(L);
                    fVar.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(L.W()));
                    onEvent(fVar);
                    c.a.n0.a.j2.p.f fVar2 = new c.a.n0.a.j2.p.f();
                    fVar2.f6789a = m(L.G());
                    fVar2.f6790b = "launch";
                    fVar2.f6793e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(L);
                    fVar2.b(k(L.W()));
                    fVar2.a("reason", QueryResponse.Options.CANCEL);
                    if (L.G() == 1) {
                        fVar.a("errorList", c.a.n0.a.c1.b.j().a());
                    }
                    fVar2.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(fVar2);
                    r0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject R() {
        InterceptResult invokeV;
        b.a N;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
            if (i2 == null || (N = i2.N()) == null || (M = N.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static c.a.n0.a.j2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? c.a.n0.a.j2.b.a(str) : (c.a.n0.a.j2.a) invokeL.objValue;
    }

    public static void d(c.a.n0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, fVar) == null) || fVar == null || c.a.n0.a.a2.e.i() == null || c.a.n0.a.a2.e.i().N() == null) {
            return;
        }
        b.a N = c.a.n0.a.a2.e.i().N();
        fVar.f6789a = m(N.G());
        fVar.f6794f = N.H();
        fVar.a("appkey", N.I());
        u("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            eVar.f6789a = m(0);
            eVar.f6790b = str;
            u("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, str, str2, str3) == null) {
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            if (c.a.n0.a.a2.e.i() != null && c.a.n0.a.a2.e.i().N() != null) {
                b.a N = c.a.n0.a.a2.e.i().N();
                eVar.f6789a = m(N.G());
                eVar.f6794f = N.H();
                eVar.f6790b = str;
                eVar.f6791c = str2;
                eVar.f6793e = str3;
                eVar.a("appkey", N.I());
            }
            u("923", eVar);
        }
    }

    public static void g(c.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, eVar) == null) {
            if (c.a.n0.a.a2.e.i() != null && c.a.n0.a.a2.e.i().N() != null) {
                b.a N = c.a.n0.a.a2.e.i().N();
                eVar.f6789a = m(N.G());
                eVar.f6794f = N.H();
                eVar.f6791c = N.T();
            }
            u("936", eVar);
        }
    }

    public static void h(c.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, eVar) == null) {
            if (c.a.n0.a.a2.e.i() != null && c.a.n0.a.a2.e.i().N() != null) {
                b.a N = c.a.n0.a.a2.e.i().N();
                eVar.f6789a = m(N.G());
                eVar.f6794f = N.H();
                eVar.f6791c = N.T();
            }
            u("914", eVar);
        }
    }

    public static void i(c.a.n0.a.j2.a aVar, c.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65563, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        q.i(new h(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        c.a.n0.a.j2.p.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = c.a.n0.a.n1.l.a();
            if (f6734a) {
                String str6 = "get NetworkQuality: " + a2;
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new c.a.n0.a.j2.p.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new c.a.n0.a.j2.p.c(str, a2, j2, j3);
            }
            n.a aVar = new n.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.q(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.p(str4);
            }
            cVar.f6790b = "request";
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            if (r != null && r.e()) {
                cVar.f6791c = r.L().T();
                cVar.f6792d = r.L().V();
            }
            cVar.f6794f = c.a.n0.a.a2.e.V();
            cVar.f6789a = m(i3);
            JSONObject P = P(networkStatRecord);
            aVar.f6781b = P;
            if (P != null) {
                cVar.e(P);
            }
            if (f6734a) {
                String str7 = "Reporting: " + cVar.f();
            }
            JSONObject f2 = cVar.f();
            c.a.n0.a.j2.b.k("834", f2);
            I(cVar.m(), cVar.n(), f2);
            c.a.n0.a.e0.d.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
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
                    if (f6734a) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? c.a.n0.a.m1.f.g() ? "1" : "0" : (String) invokeV.objValue;
    }

    public static String m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            if (f6734a) {
                String str2 = "isIgnoreRequest: start with " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f6737d.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = f6737d.get(i2);
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    if (f6734a) {
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

    public static void o(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65569, null, str, str2, z) == null) {
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            eVar.f6790b = str;
            eVar.f6793e = str2;
            eVar.f6794f = c.a.n0.a.a2.e.V();
            if (c.a.n0.a.a2.e.i() != null && c.a.n0.a.a2.e.i().N() != null) {
                b.a N = c.a.n0.a.a2.e.i().N();
                eVar.f6791c = N.T();
                eVar.f6789a = m(N.G());
            }
            if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            q.j(new c(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void onEvent(c.a.n0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, fVar) == null) {
            ExtensionCore M = c.a.n0.a.h0.u.g.N().M();
            if (M != null) {
                fVar.a("extension_ver", M.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", c.a.n0.a.a2.d.g().r().L().d("launch_by_reload") ? "1" : "0");
            u("606", fVar);
        }
    }

    public static void p(int i2, c.a.n0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, null, i2, fVar) == null) {
            c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
            if (Q == null) {
                boolean z = f6734a;
                return;
            }
            c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", c.a.n0.a.e2.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, Q.T().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f5265b);
                    jSONObject.put("scopeData", fVar.f5264a);
                }
            } catch (JSONException e2) {
                if (f6734a) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            L(dVar);
        }
    }

    @WorkerThread
    public static void q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        f6735b.execute(new b(str5, i2, str, str2, str3, str4, i3));
    }

    public static void r(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            q(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void s(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            q(i2, str, i3, str2, str3, str4, "1");
        }
    }

    public static void t(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65575, null, forbiddenInfo, str) == null) || forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        f6735b.execute(new e(str, forbiddenInfo));
    }

    public static void u(String str, c.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.n0.a.r1.k.i.c.f().e(new j(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, c.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65577, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        q.i(new RunnableC0266k(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2, String str2) {
        c.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65578, null, str, i2, str2) == null) || (Q = c.a.n0.a.a2.e.Q()) == null) {
            return;
        }
        c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
        aVar.j(5L);
        aVar.h(50L);
        c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(Q.L());
        dVar.q(m(Q.l()));
        dVar.m(Q.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Q.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (f6734a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        L(dVar);
    }

    public static void x(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65579, null, str, i2) == null) {
            q(0, str, i2, null, null, null, "0");
        }
    }

    public static void y(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65580, null, str, i2, networkStatRecord) == null) {
            z(str, i2, networkStatRecord, 0L, 0L);
        }
    }

    public static void z(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            H(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord);
        }
    }
}
