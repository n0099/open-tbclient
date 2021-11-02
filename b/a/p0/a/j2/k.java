package b.a.p0.a.j2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.n;
import b.a.p0.a.v2.q;
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
    public static final boolean f6331a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f6332b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f6333c;

    /* renamed from: d  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f6334d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6335e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f6336f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f6337g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6338h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6339i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ NetworkStatRecord n;

        public a(String str, long j, long j2, int i2, int i3, String str2, String str3, String str4, String str5, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6335e = str;
            this.f6336f = j;
            this.f6337g = j2;
            this.f6338h = i2;
            this.f6339i = i3;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (k.n(this.f6335e)) {
                    if (k.f6331a) {
                        String str = "onRequest: ignore " + this.f6335e;
                        return;
                    }
                    return;
                }
                long j = this.f6336f - this.f6337g;
                boolean z = this.f6338h == 200;
                if (this.f6339i == 0) {
                    if (TextUtils.equals(this.j, "1")) {
                        if (z) {
                            b.a.p0.a.h0.i.i.p(this.f6335e, j);
                        } else {
                            b.a.p0.a.h0.i.i.n(this.f6335e, this.f6338h);
                        }
                    } else if (TextUtils.equals(this.j, "0")) {
                        b.a.p0.a.h0.i.i.o(this.f6335e);
                    }
                }
                if (z && j < 5000) {
                    if (k.f6331a) {
                        String str2 = "code 200 & cost(" + (this.f6336f - this.f6337g) + ") is ok, don't report";
                        return;
                    }
                    return;
                }
                k.j(this.f6338h, this.f6335e, this.f6339i, this.k, this.l, this.m, this.j, this.f6337g, this.f6336f, this.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6340e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6341f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6342g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6343h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6344i;
        public final /* synthetic */ String j;
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
            this.f6340e = str;
            this.f6341f = i2;
            this.f6342g = str2;
            this.f6343h = str3;
            this.f6344i = str4;
            this.j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.j2.p.c cVar;
            JSONObject f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a2 = b.a.p0.a.n1.l.a();
                if (k.f6331a) {
                    String str = "get NetworkQuality: " + a2;
                }
                if (TextUtils.equals(this.f6340e, "1")) {
                    cVar = new b.a.p0.a.j2.p.c(this.f6341f, this.f6342g, this.f6343h, a2);
                } else {
                    cVar = new b.a.p0.a.j2.p.c(this.f6342g, a2, 0L, 0L);
                }
                new n.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f6344i)) {
                    cVar.q(this.f6344i);
                }
                if (!TextUtils.isEmpty(this.j)) {
                    cVar.p(this.j);
                }
                cVar.f6384b = "downloadFile";
                if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                    cVar.f6385c = b.a.p0.a.a2.e.i().M().S();
                }
                cVar.f6388f = b.a.p0.a.a2.e.U();
                cVar.f6383a = k.m(this.k);
                b.a.p0.a.j2.b.k("834", cVar.f());
                b.a.p0.a.e0.d.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6345e;

        public c(b.a.p0.a.j2.p.e eVar) {
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
            this.f6345e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k("894", this.f6345e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.b f6346e;

        public d(b.a.p0.a.j2.p.b bVar) {
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
            this.f6346e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k("751", this.f6346e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f6348f;

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
            this.f6347e = str;
            this.f6348f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.f6387e = this.f6347e;
                dVar.f6384b = "show";
                dVar.f6383a = "swan";
                ForbiddenInfo forbiddenInfo = this.f6348f;
                dVar.f6385c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f6348f.appId);
                b.a.p0.a.j2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6350f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6351g;

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
            this.f6349e = str;
            this.f6350f = str2;
            this.f6351g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.p0.a.a2.e P;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (P = b.a.p0.a.a2.e.P()) == null) {
                return;
            }
            b.a K = P.K();
            String N = P.N();
            String appId = P.getAppId();
            b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
            dVar.f6384b = "login";
            dVar.f6383a = k.m(K.F());
            dVar.f6388f = appId;
            dVar.f6387e = this.f6349e;
            dVar.a("appName", N);
            dVar.a("invokeFrom", this.f6350f);
            dVar.a("scene", Integer.valueOf(this.f6351g));
            if (TextUtils.equals(this.f6349e, "show")) {
                b.a.p0.a.j2.b.i("1936", "80", dVar.f());
            } else if (TextUtils.equals(this.f6349e, "success")) {
                b.a.p0.a.j2.b.i("1936", "81", dVar.f());
            } else if (TextUtils.equals(this.f6349e, com.baidu.pass.biometrics.face.liveness.b.a.g0)) {
                b.a.p0.a.j2.b.i("1936", "82", dVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6353f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6354g;

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
            this.f6352e = str;
            this.f6353f = str2;
            this.f6354g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
                b.a K = r.K();
                String N = r.N();
                String appId = r.getAppId();
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.f6384b = "swanLogin";
                dVar.f6383a = k.m(K.F());
                dVar.f6388f = appId;
                dVar.f6387e = this.f6352e;
                dVar.a("appName", N);
                dVar.a("loginScene", this.f6353f);
                String str = this.f6354g;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                b.a.p0.a.j2.b.i("1936", "1936", dVar.f());
                if (k.f6331a) {
                    String str2 = "onSwanLoginProcessStatistic: scene = " + this.f6353f + " value = " + this.f6352e + " info = " + this.f6354g;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.a f6356f;

        public h(b.a.p0.a.j2.p.e eVar, b.a.p0.a.j2.a aVar) {
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
            this.f6355e = eVar;
            this.f6356f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.p.e eVar = this.f6355e;
                if (eVar != null) {
                    b.a.p0.a.j2.b.f(this.f6356f, eVar.f().toString());
                }
                b.a.p0.a.j2.b.c(this.f6356f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.d f6357e;

        public i(b.a.p0.a.j2.p.d dVar) {
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
            this.f6357e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.f6357e.g())) {
                    this.f6357e.k(b.a.p0.a.a2.d.g().r().K().U());
                }
                b.a.p0.a.j2.b.k("671", this.f6357e.f());
                b.a.p0.a.e0.d.h("SwanAppUBCStatistic", "671 event=" + this.f6357e.f().toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6359f;

        public j(String str, b.a.p0.a.j2.p.e eVar) {
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
            this.f6358e = str;
            this.f6359f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k(this.f6358e, this.f6359f.f());
            }
        }
    }

    /* renamed from: b.a.p0.a.j2.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0271k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6361f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6362g;

        public RunnableC0271k(String str, String str2, b.a.p0.a.j2.p.e eVar) {
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
            this.f6360e = str;
            this.f6361f = str2;
            this.f6362g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.i(this.f6360e, this.f6361f, this.f6362g.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.b f6363e;

        public l(b.a.p0.a.j2.p.b bVar) {
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
            this.f6363e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k("751", this.f6363e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.b f6364e;

        public m(b.a.p0.a.j2.p.b bVar) {
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
            this.f6364e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k("751", this.f6364e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.b f6365e;

        public n(b.a.p0.a.j2.p.b bVar) {
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
            this.f6365e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.j2.b.k("751", this.f6365e.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6366e;

        public o(b.a.p0.a.j2.p.e eVar) {
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
            this.f6366e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6366e.b(k.R());
                b.a.p0.a.j2.b.k("778", this.f6366e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326472545, "Lb/a/p0/a/j2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326472545, "Lb/a/p0/a/j2/k;");
                return;
            }
        }
        f6331a = b.a.p0.a.k.f6397a;
        f6332b = Executors.newSingleThreadExecutor();
        f6333c = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f6334d = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f6334d.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f6334d;
        copyOnWriteArrayList2.add(b.a.p0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f6334d;
        copyOnWriteArrayList3.add(b.a.p0.a.d0.a.d() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A() {
        b.a K;
        Bundle O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || !b.a.p0.a.a2.d.g().C() || (O = (K = b.a.p0.a.a2.d.g().r().K()).O()) == null || O.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = K.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
        fVar.f6383a = m(b.a.p0.a.a2.d.g().l());
        fVar.f6388f = K.G();
        if (b.a.p0.a.u1.a.a.E(K.f0())) {
            fVar.f6385c = "remote-debug";
        } else if (b.a.p0.a.u1.a.a.C()) {
            fVar.f6385c = "local-debug";
        } else {
            fVar.f6385c = K.S();
        }
        fVar.f6384b = "launch";
        fVar.f6387e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        b.a.p0.a.j2.e.n(fVar, K.V(), K.q0().getString(UBCCloudControlProcessor.UBC_KEY));
        O.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = b.a.p0.a.r1.h.d("startup");
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
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            if (b.a.p0.a.a2.d.g().r().e()) {
                eVar.d(b.a.p0.a.a2.d.g().r().K().q0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f6384b = "show";
            eVar.f6385c = str;
            eVar.f6387e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f6388f = b.a.p0.a.a2.e.U();
            b.a.p0.a.r1.k.i.c.f().e(new o(eVar), "SwanAppUBCOnPagesRoute");
        }
    }

    public static void C(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, list) == null) {
            if (b.a.p0.a.a2.d.g().r().e()) {
                b.a K = b.a.p0.a.a2.d.g().r().K();
                i2 = K.F();
                str3 = K.q0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            b.a.p0.a.j2.p.b bVar = new b.a.p0.a.j2.p.b();
            bVar.f6384b = "pay";
            bVar.f6385c = str;
            bVar.f6388f = b.a.p0.a.a2.e.U();
            bVar.f6383a = m(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", b.a.p0.a.a2.e.i().N());
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
            b.a.p0.a.j2.p.b bVar = new b.a.p0.a.j2.p.b();
            b.a K = b.a.p0.a.a2.d.g().r().K();
            if (b.a.p0.a.a2.d.g().r().e()) {
                bVar.d(K.q0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f6384b = "pay";
            bVar.f6387e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f6385c = str;
            bVar.f6388f = b.a.p0.a.a2.e.U();
            bVar.f6383a = m(K.F());
            bVar.a("money", str2);
            bVar.b(R());
            q.i(new l(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void E(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.p0.a.j2.p.b bVar = new b.a.p0.a.j2.p.b();
            b.a K = b.a.p0.a.a2.d.g().r().K();
            if (b.a.p0.a.a2.d.g().r().e()) {
                bVar.d(K.q0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f6384b = "paylogin";
            bVar.f6385c = str;
            bVar.f6388f = K.H();
            bVar.f6383a = m(K.F());
            bVar.f6387e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", b.a.p0.a.c1.a.m().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.T().H();
            b.a.p0.a.l1.c E1 = H == null ? null : H.E1();
            if (E1 != null && !TextUtils.isEmpty(E1.g())) {
                bVar.a("page", E1.g());
            }
            bVar.b(R());
            q.i(new d(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void F(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, i2) == null) && b.a.p0.a.a2.d.g().r().e()) {
            b.a K = b.a.p0.a.a2.d.g().r().K();
            int F = K.F();
            b.a.p0.a.j2.p.b bVar = new b.a.p0.a.j2.p.b();
            bVar.f6384b = "payProcess";
            bVar.f6383a = m(F);
            bVar.f6385c = str;
            bVar.a("paymentProcess", str2);
            bVar.a("appid", K.G());
            bVar.a("source", K.S());
            if (K.h0() != null) {
                bVar.a("swan", K.h0().swanCoreVersionName);
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
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6384b = "launch";
            fVar.f6387e = str;
            if (b.a.p0.a.a2.e.P() != null) {
                b.a K = b.a.p0.a.a2.e.P().K();
                fVar.f6383a = m(K.F());
                fVar.f6388f = K.G();
                fVar.f6385c = K.S();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void H(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            f6332b.execute(new a(str, j3, j2, i2, i3, str5, str2, str3, str4, networkStatRecord));
        }
    }

    public static void I(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (f6331a) {
                    String str3 = "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str;
                }
            } else if (TextUtils.isEmpty(str2)) {
                boolean z = f6331a;
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (f6331a) {
                        String str4 = "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2;
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (f6331a) {
                        String str5 = "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2;
                    }
                } else if (f6333c.contains(host)) {
                    if (f6331a) {
                        String str6 = "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2;
                    }
                } else {
                    if (f6331a) {
                        String str7 = "RequestForAvatar: onRequestForAvatar: hit. url=" + str2;
                        String str8 = "value=" + jSONObject;
                    }
                    b.a.p0.a.j2.b.i("1415", "66", jSONObject);
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

    public static void L(b.a.p0.a.j2.p.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, dVar) == null) || dVar == null) {
            return;
        }
        q.i(new i(dVar), "SwanAppUBCStability");
    }

    public static void M(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, str, i2, str2) == null) {
            f6332b.execute(new f(str, str2, i2));
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
            f6332b.execute(new g(str2, str, str3));
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
                if (f6331a) {
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
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            b.a.p0.a.a2.e r = g2.r();
            b.a K = r.K();
            if (g2.C() && r.h0()) {
                Bundle q0 = K.q0();
                if (q0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r.K().r1());
                    b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
                    fVar.f6383a = m(K.F());
                    fVar.f6384b = "launch";
                    fVar.f6387e = QueryResponse.Options.CANCEL;
                    fVar.q = valueOf;
                    fVar.j(K);
                    fVar.d(q0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(K.V()));
                    onEvent(fVar);
                    b.a.p0.a.j2.p.f fVar2 = new b.a.p0.a.j2.p.f();
                    fVar2.f6383a = m(K.F());
                    fVar2.f6384b = "launch";
                    fVar2.f6387e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(K);
                    fVar2.b(k(K.V()));
                    fVar2.a("reason", QueryResponse.Options.CANCEL);
                    if (K.F() == 1) {
                        fVar.a("errorList", b.a.p0.a.c1.b.j().a());
                    }
                    fVar2.d(q0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(fVar2);
                    q0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject R() {
        InterceptResult invokeV;
        b.a M;
        JSONObject L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null || (M = i2.M()) == null || (L = M.L()) == null || !TextUtils.equals(L.optString("token"), "swanubc")) {
                return null;
            }
            return L;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static b.a.p0.a.j2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? b.a.p0.a.j2.b.a(str) : (b.a.p0.a.j2.a) invokeL.objValue;
    }

    public static void d(b.a.p0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, fVar) == null) || fVar == null || b.a.p0.a.a2.e.i() == null || b.a.p0.a.a2.e.i().M() == null) {
            return;
        }
        b.a M = b.a.p0.a.a2.e.i().M();
        fVar.f6383a = m(M.F());
        fVar.f6388f = M.G();
        fVar.a("appkey", M.H());
        u("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6383a = m(0);
            eVar.f6384b = str;
            u("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, str, str2, str3) == null) {
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                b.a M = b.a.p0.a.a2.e.i().M();
                eVar.f6383a = m(M.F());
                eVar.f6388f = M.G();
                eVar.f6384b = str;
                eVar.f6385c = str2;
                eVar.f6387e = str3;
                eVar.a("appkey", M.H());
            }
            u("923", eVar);
        }
    }

    public static void g(b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, eVar) == null) {
            if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                b.a M = b.a.p0.a.a2.e.i().M();
                eVar.f6383a = m(M.F());
                eVar.f6388f = M.G();
                eVar.f6385c = M.S();
            }
            u("936", eVar);
        }
    }

    public static void h(b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, eVar) == null) {
            if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                b.a M = b.a.p0.a.a2.e.i().M();
                eVar.f6383a = m(M.F());
                eVar.f6388f = M.G();
                eVar.f6385c = M.S();
            }
            u("914", eVar);
        }
    }

    public static void i(b.a.p0.a.j2.a aVar, b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65563, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        q.i(new h(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        b.a.p0.a.j2.p.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = b.a.p0.a.n1.l.a();
            if (f6331a) {
                String str6 = "get NetworkQuality: " + a2;
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new b.a.p0.a.j2.p.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new b.a.p0.a.j2.p.c(str, a2, j2, j3);
            }
            n.a aVar = new n.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.q(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.p(str4);
            }
            cVar.f6384b = "request";
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            if (r != null && r.e()) {
                cVar.f6385c = r.K().S();
                cVar.f6386d = r.K().U();
            }
            cVar.f6388f = b.a.p0.a.a2.e.U();
            cVar.f6383a = m(i3);
            JSONObject P = P(networkStatRecord);
            aVar.f6376b = P;
            if (P != null) {
                cVar.e(P);
            }
            if (f6331a) {
                String str7 = "Reporting: " + cVar.f();
            }
            JSONObject f2 = cVar.f();
            b.a.p0.a.j2.b.k("834", f2);
            I(cVar.m(), cVar.n(), f2);
            b.a.p0.a.e0.d.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
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
                    if (f6331a) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? b.a.p0.a.m1.f.g() ? "1" : "0" : (String) invokeV.objValue;
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
            if (f6331a) {
                String str2 = "isIgnoreRequest: start with " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f6334d.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str3 = f6334d.get(i2);
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    if (f6331a) {
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
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6384b = str;
            eVar.f6387e = str2;
            eVar.f6388f = b.a.p0.a.a2.e.U();
            if (b.a.p0.a.a2.e.i() != null && b.a.p0.a.a2.e.i().M() != null) {
                b.a M = b.a.p0.a.a2.e.i().M();
                eVar.f6385c = M.S();
                eVar.f6383a = m(M.F());
            }
            if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            q.j(new c(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void onEvent(b.a.p0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, fVar) == null) {
            ExtensionCore L = b.a.p0.a.h0.u.g.M().L();
            if (L != null) {
                fVar.a("extension_ver", L.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", b.a.p0.a.a2.d.g().r().K().d("launch_by_reload") ? "1" : "0");
            u("606", fVar);
        }
    }

    public static void p(int i2, b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, null, i2, fVar) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                boolean z = f6331a;
                return;
            }
            b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(P.M());
            dVar.q(m(P.l()));
            dVar.m(P.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", P.getAppId());
                jSONObject.put("msg", b.a.p0.a.e2.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, P.S().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f4905b);
                    jSONObject.put("scopeData", fVar.f4904a);
                }
            } catch (JSONException e2) {
                if (f6331a) {
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
        f6332b.execute(new b(str5, i2, str, str2, str3, str4, i3));
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
        f6332b.execute(new e(str, forbiddenInfo));
    }

    public static void u(String str, b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.r1.k.i.c.f().e(new j(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65577, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        q.i(new RunnableC0271k(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2, String str2) {
        b.a.p0.a.a2.e P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65578, null, str, i2, str2) == null) || (P = b.a.p0.a.a2.e.P()) == null) {
            return;
        }
        b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
        aVar.j(5L);
        aVar.h(50L);
        b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(P.K());
        dVar.q(m(P.l()));
        dVar.m(P.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", P.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (f6331a) {
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
