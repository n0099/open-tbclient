package c.p.a.e.b.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.DownloadReceiver;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.p.a.e.b.e.b A;
    public static volatile c.p.a.e.b.f.f B;
    public static volatile List<c.p.a.e.b.f.m> C;
    public static volatile boolean D;
    public static volatile OkHttpClient E;
    public static volatile c.p.a.e.b.o.h F;
    public static volatile c.p.a.e.b.o.h G;
    public static volatile u H;
    public static final List<c.p.a.e.b.f.r> I;
    public static boolean J;
    public static int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static int P;
    public static boolean Q;
    public static final List<c.p.a.e.b.f.q> R;
    public static final List<c.p.a.e.b.f.g> S;
    public static int T;
    public static boolean U;
    public static boolean V;
    public static r W;
    public static c.p.a.e.b.e.c X;
    public static volatile boolean Y;

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f35108a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f35109b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile l f35110c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile j f35111d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c.p.a.e.b.f.j f35112e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile c.p.a.e.b.m.a f35113f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile p f35114g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile p f35115h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f35116i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile c.p.a.e.b.o.a f35117j;
    public static volatile c.p.a.e.b.o.j k;
    public static volatile c.p.a.e.b.o.a l;
    public static volatile c.p.a.e.b.o.j m;
    public static volatile m n;
    public static volatile ExecutorService o;
    public static volatile ExecutorService p;
    public static volatile ExecutorService q;
    public static volatile ExecutorService r;
    public static volatile ExecutorService s;
    public static volatile ExecutorService t;
    public static volatile ExecutorService u;
    public static volatile ExecutorService v;
    public static volatile i w;
    public static volatile DownloadReceiver x;
    public static volatile s y;
    public static volatile q z;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
            Context n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (n = e.n()) == null) {
                return;
            }
            c.p.a.e.b.l.f.A0(n);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements c.p.a.e.b.o.h {
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

        @Override // c.p.a.e.b.o.h
        public List<InetAddress> a(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? Dns.SYSTEM.lookup(str) : (List) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements c.p.a.e.b.e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // c.p.a.e.b.e.c
        public void a(int i2, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
            }
        }

        @Override // c.p.a.e.b.e.c
        public void b(int i2, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {

        /* loaded from: classes4.dex */
        public interface a {
            void a();
        }

        p a();

        t a(a aVar);

        n b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473478662, "Lc/p/a/e/b/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473478662, "Lc/p/a/e/b/g/e;");
                return;
            }
        }
        C = new ArrayList();
        D = false;
        E = null;
        I = new ArrayList();
        J = false;
        L = Runtime.getRuntime().availableProcessors() + 1;
        M = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        int i2 = L;
        N = i2;
        O = i2;
        P = 8192;
        R = new ArrayList();
        S = new ArrayList();
        U = true;
        V = false;
        Y = false;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c.p.a.e.b.o.k A(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        InterceptResult invokeCommon;
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        c.p.a.e.b.o.k z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str, str2, list, Integer.valueOf(i3), Boolean.valueOf(z3), downloadInfo})) == null) {
            if (!TextUtils.isEmpty(str2)) {
                List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
                arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
                list2 = arrayList;
                i4 = 1;
            } else if (z2) {
                list2 = list;
                i4 = i3;
            } else {
                i4 = 2;
                list2 = list;
            }
            int[] a0 = a0(i4);
            Exception exc = null;
            for (int i5 : a0) {
                try {
                    z4 = z(i2, str, str2, list2, i5, z3, downloadInfo);
                } catch (Exception e2) {
                    if (downloadInfo.isExpiredRedownload() && c.p.a.e.b.l.f.S0(e2) && c.p.a.e.b.l.f.x0(list2)) {
                        c.p.a.e.b.c.a.b("dcach::http exception 304, throw excepiton, not retry " + e2);
                        throw e2;
                    }
                    exc = e2;
                }
                if (z4 != null) {
                    return z4;
                }
            }
            if (exc == null) {
                return null;
            }
            throw exc;
        }
        return (c.p.a.e.b.o.k) invokeCommon.objValue;
    }

    public static ExecutorService A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (o == null) {
                synchronized (e.class) {
                    if (o == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(L, L, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.p.a.e.b.k.a("DownloadThreadPool-cpu-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        o = threadPoolExecutor;
                    }
                }
            }
            return o;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static c.p.a.e.b.o.k B(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str, list})) == null) ? A(z2, i2, str, null, list, 0, false, null) : (c.p.a.e.b.o.k) invokeCommon.objValue;
    }

    public static ExecutorService B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? p != null ? p : A0() : (ExecutorService) invokeV.objValue;
    }

    public static synchronized void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            synchronized (e.class) {
                if (context != null) {
                    if (f35108a == null) {
                        f35108a = context.getApplicationContext();
                        c.p.a.e.b.a.a.c().e(f35108a);
                    }
                }
            }
        }
    }

    public static ExecutorService C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? r != null ? r : E0() : (ExecutorService) invokeV.objValue;
    }

    public static void D(com.ss.android.socialbase.downloader.constants.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, dVar) == null) {
            synchronized (R) {
                for (c.p.a.e.b.f.q qVar : R) {
                    if (qVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.constants.d.f75837b) {
                            qVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.constants.d.f75838c) {
                            qVar.b();
                        }
                    }
                }
                if (dVar == com.ss.android.socialbase.downloader.constants.d.f75838c) {
                    R.clear();
                }
            }
        }
    }

    public static ExecutorService D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? s != null ? s : E0() : (ExecutorService) invokeV.objValue;
    }

    public static void E(c.p.a.e.b.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, bVar) == null) || bVar == null) {
            return;
        }
        A = bVar;
    }

    public static ExecutorService E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (q == null) {
                synchronized (e.class) {
                    if (q == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(N, N, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.p.a.e.b.k.a("DownloadThreadPool-mix-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        q = threadPoolExecutor;
                    }
                }
            }
            return q;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void F(c.p.a.e.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, cVar) == null) {
            X = cVar;
        }
    }

    public static ExecutorService F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (u == null) {
                synchronized (e.class) {
                    if (u == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(M, M, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.p.a.e.b.k.a("DownloadThreadPool-chunk-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        u = threadPoolExecutor;
                    }
                }
            }
            return u;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void G(c.p.a.e.b.f.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, fVar) == null) {
            B = fVar;
            c.p.a.e.b.j.a.i();
        }
    }

    public static ExecutorService G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (t == null) {
                synchronized (e.class) {
                    if (t == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(O, O, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.p.a.e.b.k.a("DownloadThreadPool-db-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        t = threadPoolExecutor;
                    }
                }
            }
            return t;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static void H(c.p.a.e.b.f.j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, jVar) == null) || jVar == null) {
            return;
        }
        f35112e = jVar;
    }

    public static OkHttpClient H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (E == null) {
                synchronized (e.class) {
                    if (E == null) {
                        E = I0().build();
                    }
                }
            }
            return E;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static void I(c.p.a.e.b.f.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, mVar) == null) || mVar == null) {
            return;
        }
        synchronized (C) {
            C.add(mVar);
        }
    }

    public static OkHttpClient.Builder I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
            if (v != null) {
                builder.dispatcher(new Dispatcher(v));
            }
            return builder;
        }
        return (OkHttpClient.Builder) invokeV.objValue;
    }

    public static void J(c.p.a.e.b.f.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, qVar) == null) {
            synchronized (R) {
                if (qVar != null) {
                    if (!R.contains(qVar)) {
                        R.add(qVar);
                    }
                }
            }
        }
    }

    public static c.p.a.e.b.o.h J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? F : (c.p.a.e.b.o.h) invokeV.objValue;
    }

    public static synchronized void K(c.p.a.e.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, bVar) == null) {
            synchronized (e.class) {
                if (Y) {
                    c.p.a.e.b.c.a.k("DownloadComponentManager", "component has init");
                    return;
                }
                boolean z2 = D;
                k0(bVar);
                if (f35109b == null) {
                    f35109b = new c.p.a.e.b.m.d();
                }
                if (f35114g == null) {
                    f35114g = new c.p.a.e.b.m.h();
                }
                if (f35115h == null && f35116i != null) {
                    f35115h = f35116i.a();
                }
                if (f35110c == null) {
                    f35110c = new c.p.a.e.b.m.i();
                }
                if (f35113f == null) {
                    f35113f = new c.p.a.e.b.m.e();
                }
                if (f35111d == null) {
                    f35111d = new c.p.a.e.b.m.c();
                }
                if (w == null) {
                    w = new c.p.a.e.b.m.b();
                }
                if (y == null) {
                    y = new c.p.a.e.b.m.j();
                }
                if (K <= 0 || K > L) {
                    K = L;
                }
                u();
                if (D && !z2 && !c.p.a.e.b.l.f.p0()) {
                    c.p.a.e.b.m.l.a(true).e();
                } else if (c.p.a.e.b.l.f.B0()) {
                    ExecutorService B0 = B0();
                    if (B0 != null) {
                        B0.execute(new a());
                    }
                } else {
                    Context n2 = n();
                    if (n2 != null) {
                        c.p.a.e.b.l.f.A0(n2);
                    }
                }
                f();
                Y = true;
            }
        }
    }

    public static c.p.a.e.b.o.h K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (G == null) {
                synchronized (e.class) {
                    if (G == null) {
                        G = new b();
                    }
                }
            }
            return G;
        }
        return (c.p.a.e.b.o.h) invokeV.objValue;
    }

    public static void L(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, dVar) == null) {
            c.p.a.e.b.c.a.c("wjd", "setIndependentServiceCreator::creator=" + dVar);
            f35116i = dVar;
        }
    }

    public static synchronized m L0() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            synchronized (e.class) {
                mVar = n;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }

    public static void M(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, iVar) == null) || iVar == null) {
            return;
        }
        w = iVar;
    }

    public static k M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (f35109b == null) {
                synchronized (e.class) {
                    if (f35109b == null) {
                        f35109b = new c.p.a.e.b.m.d();
                    }
                }
            }
            return f35109b;
        }
        return (k) invokeV.objValue;
    }

    public static void N(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, null, jVar) == null) || jVar == null) {
            return;
        }
        f35111d = jVar;
    }

    public static p N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (f35114g == null) {
                synchronized (e.class) {
                    if (f35114g == null) {
                        f35114g = new c.p.a.e.b.m.h();
                    }
                }
            }
            return f35114g;
        }
        return (p) invokeV.objValue;
    }

    public static void O(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, kVar) == null) || kVar == null) {
            return;
        }
        f35109b = kVar;
    }

    public static p O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (f35115h == null) {
                synchronized (e.class) {
                    if (f35115h == null) {
                        f35115h = f35116i.a();
                    }
                }
            }
            return f35115h;
        }
        return (p) invokeV.objValue;
    }

    public static void P(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, lVar) == null) || lVar == null) {
            return;
        }
        f35110c = lVar;
    }

    public static synchronized void Q(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, mVar) == null) {
            synchronized (e.class) {
                if (mVar != null) {
                    n = mVar;
                    if (f35109b instanceof c.p.a.e.b.m.d) {
                        ((c.p.a.e.b.m.d) f35109b).m();
                    }
                }
            }
        }
    }

    public static void R(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, rVar) == null) {
        }
    }

    public static void S(c.p.a.e.b.n.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65571, null, aVar, i2) == null) {
            synchronized (S) {
                for (c.p.a.e.b.f.g gVar : S) {
                    if (gVar != null) {
                        gVar.a(aVar, i2);
                    }
                }
            }
        }
    }

    public static void T(c.p.a.e.b.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, aVar) == null) {
            if (aVar != null) {
                f35117j = aVar;
            }
            Q = f35117j != null;
        }
    }

    public static void U(c.p.a.e.b.o.j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, null, jVar) == null) || jVar == null) {
            return;
        }
        k = jVar;
    }

    public static void V(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, runnable) == null) {
            h0(runnable, false);
        }
    }

    public static void W(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65575, null, runnable, z2) == null) || runnable == null) {
            return;
        }
        if (z2 && !c.p.a.e.b.l.f.B0()) {
            runnable.run();
        } else {
            A0().execute(runnable);
        }
    }

    public static void X(List<c.p.a.e.b.f.r> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65576, null, list) == null) && I.isEmpty()) {
            synchronized (I) {
                I.addAll(list);
            }
        }
    }

    public static void Y(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65577, null, executorService) == null) || executorService == null) {
            return;
        }
        u = executorService;
    }

    public static void Z(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65578, null, z2) == null) {
            V = z2;
        }
    }

    public static List<c.p.a.e.b.f.r> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? I : (List) invokeV.objValue;
    }

    public static int[] a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65580, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0} : (int[]) invokeI.objValue;
    }

    public static l b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            if (f35110c == null) {
                synchronized (e.class) {
                    if (f35110c == null) {
                        f35110c = new c.p.a.e.b.m.i();
                    }
                }
            }
            return f35110c;
        }
        return (l) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c.p.a.e.b.o.i b0(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        InterceptResult invokeCommon;
        IOException iOException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65582, null, new Object[]{str, list, Integer.valueOf(i2), Boolean.valueOf(z2), downloadInfo})) == null) {
            c.p.a.e.b.o.j r0 = i2 == 1 ? r0() : x0();
            if (r0 != null) {
                long j2 = 0;
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            iOException = e2;
                            th = th;
                            if (z2) {
                                c.p.a.e.b.e.a.j(null, str, null, System.currentTimeMillis() - j2, "head", i2, iOException, downloadInfo);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        iOException = null;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                c.p.a.e.b.o.i a2 = r0.a(str, list);
                if (z2) {
                    c.p.a.e.b.e.a.j(a2, str, null, System.currentTimeMillis() - j2, "head", i2, null, downloadInfo);
                }
                return a2;
            }
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        return (c.p.a.e.b.o.i) invokeCommon.objValue;
    }

    public static c.p.a.e.b.m.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            if (f35113f == null) {
                synchronized (e.class) {
                    if (f35113f == null) {
                        f35113f = new c.p.a.e.b.m.e();
                    }
                }
            }
            return f35113f;
        }
        return (c.p.a.e.b.m.a) invokeV.objValue;
    }

    public static synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, null) == null) {
            synchronized (e.class) {
                if (D) {
                    return;
                }
                D = true;
                Intent intent = new Intent(n(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                n().startService(intent);
                if (!c.p.a.e.b.l.f.p0()) {
                    c.p.a.e.b.m.l.a(true).e();
                }
            }
        }
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? T : invokeV.intValue;
    }

    public static void d0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65586, null, i2) == null) || i2 <= 0) {
            return;
        }
        K = i2;
    }

    @NonNull
    public static JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (B != null && B.a() != null) {
                return B.a();
            }
            return c.p.a.e.b.d.c.f35085g;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static synchronized void e0(c.p.a.e.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, bVar) == null) {
            synchronized (e.class) {
                k0(bVar);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65589, null) == null) && TextUtils.isEmpty(c.p.a.e.b.d.c.f35081c)) {
            c.p.a.e.b.d.c.f35081c = RomUtils.MANUFACTURER_OPPO;
            c.p.a.e.b.d.c.f35080b = c.p.a.e.b.d.c.f35081c.toUpperCase();
        }
    }

    public static void f0(c.p.a.e.b.n.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65590, null, aVar, i2) == null) {
            synchronized (S) {
                for (c.p.a.e.b.f.g gVar : S) {
                    if (gVar != null) {
                        gVar.b(aVar, i2);
                    }
                }
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? U : invokeV.booleanValue;
    }

    public static void g0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65592, null, runnable) == null) || runnable == null) {
            return;
        }
        if (!c.p.a.e.b.l.f.B0()) {
            runnable.run();
        } else {
            G0().execute(runnable);
        }
    }

    public static synchronized int h() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            synchronized (e.class) {
                i2 = P;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static void h0(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65594, null, runnable, z2) == null) || runnable == null) {
            return;
        }
        if (z2 && !c.p.a.e.b.l.f.B0()) {
            runnable.run();
        } else {
            B0().execute(runnable);
        }
    }

    public static j i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) {
            if (f35111d == null) {
                synchronized (e.class) {
                    if (f35111d == null) {
                        f35111d = new c.p.a.e.b.m.c();
                    }
                }
            }
            return f35111d;
        }
        return (j) invokeV.objValue;
    }

    public static void i0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65596, null, executorService) == null) || executorService == null) {
            return;
        }
        v = executorService;
    }

    public static c.p.a.e.b.f.j j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? f35112e : (c.p.a.e.b.f.j) invokeV.objValue;
    }

    public static void j0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65598, null, z2) == null) {
            U = z2;
        }
    }

    public static i k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            if (w == null) {
                synchronized (e.class) {
                    if (w == null) {
                        w = new c.p.a.e.b.m.b();
                    }
                }
            }
            return w;
        }
        return (i) invokeV.objValue;
    }

    public static void k0(c.p.a.e.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65600, null, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.i() != null) {
            C(bVar.i());
        }
        if (bVar.k() != null) {
            O(bVar.k());
        }
        if (bVar.u() != null) {
            P(bVar.u());
        }
        if (bVar.g() != null) {
            N(bVar.g());
        }
        if (bVar.A() != null) {
            H(bVar.A());
        }
        if (bVar.v() != 0) {
            d0(bVar.v());
        }
        if (bVar.s() != null) {
            T(bVar.s());
        }
        if (bVar.r() != null) {
            U(bVar.r());
        }
        if (bVar.o() != null) {
            Q(bVar.o());
        }
        if (bVar.e() != null) {
            l0(bVar.e());
        }
        if (bVar.t() != null) {
            o0(bVar.t());
        }
        if (bVar.x() != null) {
            q0(bVar.x());
        }
        if (bVar.y() != null) {
            s0(bVar.y());
        }
        if (bVar.w() != null) {
            u0(bVar.w());
        }
        if (bVar.j() != null) {
            w0(bVar.j());
        }
        if (bVar.h() != null) {
            Y(bVar.h());
        }
        if (bVar.B() != null) {
            i0(bVar.B());
        }
        if (!bVar.l().isEmpty()) {
            X(bVar.l());
        }
        if (bVar.z() != null) {
            z = bVar.z();
        }
        if (bVar.D() > 1024) {
            P = bVar.D();
        }
        if (bVar.f() != null) {
            M(bVar.f());
        }
        if (bVar.F()) {
            D = true;
        }
        if (bVar.n() != 0) {
            T = bVar.n();
        }
        if (bVar.q() != null) {
            G(bVar.q());
        }
        if (bVar.m() != null) {
            F = bVar.m();
        }
        if (bVar.C() != null) {
            H = bVar.C();
            if (H.a()) {
                T(H.b());
                U(H.c());
            } else {
                T(v0());
                U(x0());
            }
        }
        j0(bVar.G());
        if (bVar.p() != null) {
            E(bVar.p());
        }
    }

    public static s l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            if (y == null) {
                synchronized (e.class) {
                    if (y == null) {
                        y = new c.p.a.e.b.m.j();
                    }
                }
            }
            return y;
        }
        return (s) invokeV.objValue;
    }

    public static void l0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65602, null, executorService) == null) || executorService == null) {
            return;
        }
        o = executorService;
    }

    public static u m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            if (H == null) {
                synchronized (e.class) {
                    if (H == null) {
                        H = new u.a();
                    }
                }
            }
            return H;
        }
        return (u) invokeV.objValue;
    }

    public static synchronized boolean m0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            synchronized (e.class) {
                z2 = D;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public static synchronized Context n() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            synchronized (e.class) {
                context = f35108a;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static c.p.a.e.b.o.a n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? f35117j : (c.p.a.e.b.o.a) invokeV.objValue;
    }

    public static synchronized boolean o() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            synchronized (e.class) {
                z2 = Q;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public static void o0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65608, null, executorService) == null) || executorService == null) {
            return;
        }
        p = executorService;
    }

    @NonNull
    public static c.p.a.e.b.e.c p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            if (X == null) {
                X = new c();
            }
            return X;
        }
        return (c.p.a.e.b.e.c) invokeV.objValue;
    }

    public static List<c.p.a.e.b.f.m> p0() {
        InterceptResult invokeV;
        List<c.p.a.e.b.f.m> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            synchronized (C) {
                list = C;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static r q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? W : (r) invokeV.objValue;
    }

    public static void q0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65612, null, executorService) == null) || executorService == null) {
            return;
        }
        q = executorService;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? Y : invokeV.booleanValue;
    }

    public static c.p.a.e.b.o.j r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) ? k : (c.p.a.e.b.o.j) invokeV.objValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("supportMultiProc::=");
            sb.append(f35116i != null);
            c.p.a.e.b.c.a.c("wjd", sb.toString());
            return f35116i != null;
        }
        return invokeV.booleanValue;
    }

    public static void s0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65616, null, executorService) == null) || executorService == null) {
            return;
        }
        r = executorService;
    }

    public static d t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? f35116i : (d) invokeV.objValue;
    }

    public static c.p.a.e.b.e.b t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? A : (c.p.a.e.b.e.b) invokeV.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65619, null) == null) {
            if (x == null) {
                x = new DownloadReceiver();
            }
            if (J) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f35108a.registerReceiver(x, intentFilter);
                J = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void u0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65620, null, executorService) == null) || executorService == null) {
            return;
        }
        s = executorService;
    }

    public static int v(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return 0;
            }
            return w(downloadInfo.getUrl(), downloadInfo.getSavePath());
        }
        return invokeL.intValue;
    }

    public static c.p.a.e.b.o.a v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) {
            if (l == null) {
                synchronized (e.class) {
                    if (l == null) {
                        l = new c.p.a.e.b.m.g();
                    }
                }
            }
            return l;
        }
        return (c.p.a.e.b.o.a) invokeV.objValue;
    }

    public static int w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65623, null, str, str2)) == null) {
            l b2 = b();
            if (b2 == null) {
                return 0;
            }
            return b2.a(str, str2);
        }
        return invokeLL.intValue;
    }

    public static void w0(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65624, null, executorService) == null) || executorService == null) {
            return;
        }
        t = executorService;
    }

    public static c.p.a.e.b.o.i x(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65625, null, str, list)) == null) ? y(str, list, 0, false, null) : (c.p.a.e.b.o.i) invokeLL.objValue;
    }

    public static c.p.a.e.b.o.j x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            if (m == null) {
                synchronized (e.class) {
                    if (m == null) {
                        m = new c.p.a.e.b.m.f();
                    }
                }
            }
            return m;
        }
        return (c.p.a.e.b.o.j) invokeV.objValue;
    }

    public static c.p.a.e.b.o.i y(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        InterceptResult invokeCommon;
        c.p.a.e.b.o.i b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65627, null, new Object[]{str, list, Integer.valueOf(i2), Boolean.valueOf(z2), downloadInfo})) == null) {
            Exception e2 = null;
            for (int i3 : a0(i2)) {
                try {
                    b0 = b0(str, list, i3, z2, downloadInfo);
                } catch (Exception e3) {
                    e2 = e3;
                }
                if (b0 != null) {
                    return b0;
                }
            }
            if (e2 == null) {
                return null;
            }
            throw e2;
        }
        return (c.p.a.e.b.o.i) invokeCommon.objValue;
    }

    public static boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) ? c.p.a.e.b.j.a.r().b("switch_not_auto_boot_service", V ? 1 : 0) > 0 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c.p.a.e.b.o.k z(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        InterceptResult invokeCommon;
        IOException iOException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65629, null, new Object[]{Integer.valueOf(i2), str, str2, list, Integer.valueOf(i3), Boolean.valueOf(z2), downloadInfo})) == null) {
            c.p.a.e.b.o.a n0 = i3 == 1 ? n0() : v0();
            if (n0 != null) {
                IOException iOException2 = null;
                long j2 = 0;
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        e = e2;
                        iOException = e;
                        try {
                            throw iOException;
                        } catch (Throwable th) {
                            th = th;
                            iOException2 = iOException;
                            if (z2) {
                                c.p.a.e.b.e.a.j(null, str, str2, System.currentTimeMillis() - j2, "get", i3, iOException2, downloadInfo);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                try {
                    c.p.a.e.b.o.k downloadWithConnection = n0.downloadWithConnection(i2, str, list);
                    if (z2) {
                        c.p.a.e.b.e.a.j(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i3, null, downloadInfo);
                    }
                    return downloadWithConnection;
                } catch (IOException e3) {
                    e = e3;
                    iOException = e;
                    throw iOException;
                } catch (Throwable th3) {
                    th = th3;
                    if (z2) {
                    }
                    throw th;
                }
            }
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
        }
        return (c.p.a.e.b.o.k) invokeCommon.objValue;
    }

    public static synchronized q z0() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) {
            synchronized (e.class) {
                qVar = z;
            }
            return qVar;
        }
        return (q) invokeV.objValue;
    }
}
