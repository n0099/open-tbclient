package c.p.a.e.b.k;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.n;
import c.p.a.e.b.f.t;
import c.p.a.e.b.f.u;
import c.p.a.e.b.f.y;
import c.p.a.e.b.f.z;
import c.p.a.e.b.g.s;
import c.p.a.e.b.i.j;
import c.p.a.e.b.i.m;
import c.p.a.e.b.m.p;
import c.p.a.e.b.m.q;
import c.p.a.e.b.o.i;
import c.p.a.e.b.o.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.DebugConstants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.l;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements f, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final String O;
    public transient /* synthetic */ FieldHolder $fh;
    public k A;
    public i B;
    public y C;
    public u D;
    public volatile int E;
    public boolean F;
    public boolean G;
    public String H;
    public boolean I;
    public long J;
    public long K;
    public final c.p.a.e.b.j.a L;
    public int M;
    public volatile j N;

    /* renamed from: e  reason: collision with root package name */
    public Future f35270e;

    /* renamed from: f  reason: collision with root package name */
    public final c.p.a.e.b.n.a f35271f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35272g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f35273h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c.p.a.e.b.k.b> f35274i;

    /* renamed from: j  reason: collision with root package name */
    public volatile c.p.a.e.b.g.g f35275j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final AtomicBoolean p;
    public volatile com.ss.android.socialbase.downloader.constants.h q;
    public final c.p.a.e.b.g.k r;
    public DownloadInfo s;
    public c.p.a.e.b.g.j t;
    public final c.p.a.e.b.g.j u;
    public c.p.a.e.b.g.i v;
    public final c.p.a.e.b.g.i w;
    public s x;
    public final c.p.a.e.b.g.h y;
    public volatile BaseException z;

    /* loaded from: classes4.dex */
    public class a extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f35276b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35276b = cVar;
        }

        @Override // c.p.a.e.b.f.n, c.p.a.e.b.f.x
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                super.a(list);
                this.f35276b.I(list);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f35277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f35278b;

        public b(c cVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35278b = cVar;
            this.f35277a = atomicBoolean;
        }

        @Override // c.p.a.e.b.f.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f35278b) {
                    this.f35277a.set(true);
                    this.f35278b.s();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473359560, "Lc/p/a/e/b/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473359560, "Lc/p/a/e/b/k/c;");
                return;
            }
        }
        O = c.class.getSimpleName();
    }

    public c(c.p.a.e.b.n.a aVar, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35272g = false;
        this.f35274i = new ArrayList<>();
        this.q = com.ss.android.socialbase.downloader.constants.h.f76168a;
        this.E = 5;
        this.F = false;
        this.G = false;
        this.I = false;
        this.M = 0;
        this.N = null;
        this.f35271f = aVar;
        if (aVar != null) {
            this.s = aVar.J();
            this.t = aVar.D();
            this.v = aVar.C();
            this.C = aVar.O();
            this.D = aVar.F();
            this.x = v(aVar);
            this.L = c.p.a.e.b.j.a.d(this.s.getId());
        } else {
            this.L = c.p.a.e.b.j.a.r();
        }
        V();
        this.r = c.p.a.e.b.g.e.M0();
        this.u = c.p.a.e.b.g.e.i();
        this.w = c.p.a.e.b.g.e.k();
        this.y = new c.p.a.e.b.g.h(aVar, handler);
        this.p = new AtomicBoolean(true);
    }

    public static com.ss.android.socialbase.downloader.model.b w(DownloadInfo downloadInfo, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadInfo, j2)) == null) {
            b.C2081b c2081b = new b.C2081b(downloadInfo.getId());
            c2081b.b(-1);
            c2081b.c(0L);
            c2081b.m(j2);
            c2081b.g(j2);
            c2081b.i(0L);
            c2081b.k(downloadInfo.getTotalBytes() - j2);
            return c2081b.e();
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeLJ.objValue;
    }

    public final void A(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
            if (list.size() == i2) {
                J(list, this.s.getTotalBytes());
                return;
            }
            throw new BaseException((int) DebugConstants.HTTP_ERRCODE_VERSION_HIGH, new IllegalArgumentException());
        }
    }

    public final void B(long j2, int i2) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            long j3 = j2 / i2;
            int id = this.s.getId();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            long j4 = 0;
            while (i3 < i2) {
                long j5 = i3 == i2 + (-1) ? 0L : (j4 + j3) - 1;
                b.C2081b c2081b = new b.C2081b(id);
                c2081b.b(i3);
                c2081b.c(j4);
                c2081b.m(j4);
                c2081b.g(j4);
                c2081b.i(j5);
                com.ss.android.socialbase.downloader.model.b e2 = c2081b.e();
                arrayList.add(e2);
                this.r.a(e2);
                j4 += j3;
                i3++;
            }
            this.s.setChunkCount(i2);
            this.r.a(id, i2);
            J(arrayList, j2);
        }
    }

    public final void E(com.ss.android.socialbase.downloader.model.b bVar, String str, k kVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str, kVar) == null) {
            bVar.a(this.s.getTotalBytes() - bVar.n());
            this.s.setChunkCount(1);
            this.r.a(this.s.getId(), 1);
            this.f35275j = new c.p.a.e.b.g.g(this.s, str, kVar, bVar, this);
            h0();
        }
    }

    public final void F(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            c.p.a.e.b.l.f.w(this.s);
            this.l = false;
            this.s.resetDataForEtagEndure(str);
            this.r.a(this.s);
            throw new com.ss.android.socialbase.downloader.exception.i(str2);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    public final void G(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) && this.A == null) {
            c.p.a.e.b.o.b.d f2 = this.s.getChunkCount() == 1 ? c.p.a.e.b.o.b.a.a().f(str, list) : null;
            try {
                if (f2 != null) {
                    e(this.A);
                    this.s.setPreconnectLevel(2);
                    this.A = f2;
                } else {
                    try {
                        k A = c.p.a.e.b.g.e.A(this.s.isNeedDefaultHttpServiceBackUp(), this.s.getMaxBytes(), str, null, list, this.L.m("net_lib_strategy"), this.L.b("monitor_download_connect", 0) > 0, this.s);
                        this.A = A;
                        e(A);
                    } catch (BaseException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        if (this.s.isExpiredRedownload() && c.p.a.e.b.l.f.S0(th) && c.p.a.e.b.l.f.x0(list)) {
                            c.p.a.e.b.c.a.g(O, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.s.getCacheControl());
                            long W0 = c.p.a.e.b.l.f.W0(this.s.getCacheControl());
                            if (W0 <= 0) {
                                W0 = c.p.a.e.b.j.a.d(this.s.getId()).b("default_304_max_age", 300);
                            }
                            this.s.setCacheExpiredTime(System.currentTimeMillis() + (W0 * 1000));
                            throw new com.ss.android.socialbase.downloader.exception.a(this.H);
                        } else if (!c.p.a.e.b.l.f.P0(th)) {
                            if (c.p.a.e.b.l.f.L0(th)) {
                                F("", "http code 412");
                                throw null;
                            } else {
                                c.p.a.e.b.l.f.B(th, "CreateFirstConnection");
                                throw null;
                            }
                        } else {
                            F("", "http code 416");
                            throw null;
                        }
                    }
                }
                if (this.A == null) {
                    throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
                }
            } catch (Throwable th2) {
                e(this.A);
                throw th2;
            }
        }
    }

    public final void H(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, list, Long.valueOf(j2)}) == null) {
            N(str, list, j2);
            i iVar = this.B;
            if (iVar != null) {
                try {
                    d(str, iVar, j2);
                } catch (Throwable unused) {
                    this.G = true;
                }
            }
            if (this.B == null || this.G) {
                G(str, list);
                d(str, this.A, j2);
            }
        }
    }

    public final void I(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.s.setForbiddenBackupUrls(list, this.q == com.ss.android.socialbase.downloader.constants.h.f76174g);
        c.p.a.e.b.m.a c2 = c.p.a.e.b.g.e.c();
        if (c2 != null) {
            c2.Q(this.s.getId());
        }
    }

    public final void J(List<com.ss.android.socialbase.downloader.model.b> list, long j2) throws BaseException {
        long p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, list, j2) == null) {
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null) {
                    if (bVar.p() == 0) {
                        p = j2 - bVar.n();
                    } else {
                        p = (bVar.p() - bVar.n()) + 1;
                    }
                    if (p > 0) {
                        bVar.a(p);
                        if (this.s.isNeedReuseFirstConnection() && this.A != null && (!this.s.isHeadConnectionAvailable() || this.G)) {
                            if (bVar.s() == 0) {
                                this.f35274i.add(new c.p.a.e.b.k.b(bVar, this.f35271f, this.A, this));
                            } else if (bVar.s() > 0) {
                                this.f35274i.add(new c.p.a.e.b.k.b(bVar, this.f35271f, this));
                            }
                        } else {
                            this.f35274i.add(new c.p.a.e.b.k.b(bVar, this.f35271f, this));
                        }
                    }
                }
            }
            if (c.p.a.e.b.l.a.a(64)) {
                ArrayList arrayList = new ArrayList(this.f35274i.size());
                Iterator<c.p.a.e.b.k.b> it = this.f35274i.iterator();
                while (it.hasNext()) {
                    c.p.a.e.b.k.b next = it.next();
                    if (this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) {
                        next.e();
                    } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76169b) {
                        next.a();
                    } else {
                        arrayList.add(next);
                    }
                }
                try {
                    List<Future> W = c.p.a.e.b.m.e.W(arrayList);
                    for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = c.p.a.e.b.m.e.X(W)) {
                        if (j0()) {
                            return;
                        }
                        runnable.run();
                    }
                    if (W == null || W.isEmpty()) {
                        return;
                    }
                    for (Future future : W) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(this.f35274i.size());
            Iterator<c.p.a.e.b.k.b> it2 = this.f35274i.iterator();
            while (it2.hasNext()) {
                c.p.a.e.b.k.b next2 = it2.next();
                if (this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) {
                    next2.e();
                } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76169b) {
                    next2.a();
                } else {
                    arrayList2.add(Executors.callable(next2));
                }
            }
            if (j0()) {
                return;
            }
            try {
                c.p.a.e.b.m.e.V(arrayList2);
            } catch (InterruptedException e2) {
                throw new BaseException(1020, e2);
            }
        }
    }

    public void K(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, future) == null) {
            this.f35270e = future;
        }
    }

    public final boolean L(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, str, str2)) == null) {
            if (i2 == 412) {
                return true;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.n || this.m)) {
                return (i2 == 201 || i2 == 416) && this.s.getCurBytes() > 0;
            }
            return true;
        }
        return invokeILL.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.h.f76170c;
            if (this.N != null) {
                this.N.r();
            }
            if (this.f35275j != null) {
                this.f35275j.j();
            }
            if (this.N == null && this.f35275j == null) {
                g0();
                this.q = com.ss.android.socialbase.downloader.constants.h.f76170c;
                d0();
            }
            r();
        }
    }

    public final void N(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        c.p.a.e.b.o.b.c b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, list, Long.valueOf(j2)}) == null) {
            boolean z = true;
            if (this.s.getChunkCount() == 1 && (b2 = c.p.a.e.b.o.b.a.a().b(str, list)) != null) {
                this.B = b2;
                this.s.setPreconnectLevel(1);
            }
            if (this.B == null && !this.G && this.s.isHeadConnectionAvailable()) {
                try {
                    int m = this.L.m("net_lib_strategy");
                    if (this.L.b("monitor_download_connect", 0) <= 0) {
                        z = false;
                    }
                    this.B = c.p.a.e.b.g.e.y(str, list, m, z, this.s);
                } catch (Throwable th) {
                    this.s.setHeadConnectionException(c.p.a.e.b.l.f.a1(th));
                }
            }
        }
    }

    public c.p.a.e.b.n.a O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f35271f : (c.p.a.e.b.n.a) invokeV.objValue;
    }

    public void P(long j2) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) && (kVar = this.A) != null && (kVar instanceof c.p.a.e.b.o.c)) {
            try {
                ((c.p.a.e.b.o.c) kVar).a(j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.p.get() : invokeV.booleanValue;
    }

    public final boolean R(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, baseException)) == null) {
            AtomicInteger atomicInteger = this.f35273h;
            boolean z = true;
            if (atomicInteger != null) {
                if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                    if (this.s.trySwitchToNextBackupUrl()) {
                        this.f35273h.set(this.s.getBackUpUrlRetryCount());
                        this.s.updateCurRetryTime(this.f35273h.get());
                    } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.s.canReplaceHttpForRetry())) {
                        this.f35273h.set(this.s.getRetryCount());
                        this.s.updateCurRetryTime(this.f35273h.get());
                        this.s.setHttpsToHttpRetryUsed(true);
                    } else {
                        g(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f35273h), String.valueOf(this.s.getRetryCount()), baseException.getErrorMessage())));
                        return true;
                    }
                    z = false;
                }
                if (this.q != com.ss.android.socialbase.downloader.constants.h.f76173f && z) {
                    this.s.updateCurRetryTime(this.f35273h.decrementAndGet());
                }
                return false;
            }
            g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        return invokeL.booleanValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo != null) {
                return downloadInfo.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.K = System.currentTimeMillis();
            this.y.b();
        }
    }

    public Future U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35270e : (Future) invokeV.objValue;
    }

    public final void V() {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (downloadInfo = this.s) == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.s.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f35273h;
        if (atomicInteger == null) {
            this.f35273h = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int status = this.s.getStatus();
            if (status == 1 || this.s.canSkipStatusHandler()) {
                return true;
            }
            if (status == -2 || status == -4) {
                return false;
            }
            g(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f9, code lost:
        if (r9.L.l("fix_file_exist_update_download_info") != false) goto L89;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af A[Catch: all -> 0x00ee, TryCatch #10 {all -> 0x00ee, blocks: (B:58:0x00ab, B:60:0x00af, B:62:0x00b3, B:75:0x00ed), top: B:96:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X() throws com.ss.android.socialbase.downloader.exception.a {
        Throwable th;
        com.ss.android.socialbase.downloader.exception.a e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = false;
            boolean z2 = true;
            try {
                try {
                    try {
                        int id = this.s.getId();
                        if (this.r != null) {
                            if (c.p.a.e.b.l.a.a(2048)) {
                                this.r.e();
                            }
                            DownloadInfo b2 = this.r.b(id);
                            if (b2 != null && !b2.isNewTask()) {
                                String savePath = this.s.getSavePath();
                                String md5 = this.s.getMd5();
                                this.s.copyFromCacheData(b2, true);
                                boolean z3 = c.p.a.e.b.l.a.a(4096) && b2 != this.s;
                                try {
                                    if (savePath.equals(b2.getSavePath()) && c.p.a.e.b.l.f.M(b2, false, md5)) {
                                        try {
                                            throw new com.ss.android.socialbase.downloader.exception.a(b2.getName());
                                        } catch (com.ss.android.socialbase.downloader.exception.a e3) {
                                            throw e3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = z3;
                                            if (this.f35271f != null) {
                                            }
                                            if (z) {
                                            }
                                        }
                                    } else if (c.p.a.e.b.g.e.v(b2) != id) {
                                        try {
                                            this.r.f(id);
                                        } catch (SQLiteException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else {
                                        z2 = z3;
                                    }
                                } catch (com.ss.android.socialbase.downloader.exception.a e5) {
                                    e2 = e5;
                                    throw e2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    z = z3;
                                    z2 = false;
                                    if (this.f35271f != null) {
                                        c.p.a.e.b.e.a.e(this.f35271f.R(), this.s, new BaseException(1003, c.p.a.e.b.l.f.a0(th, "checkTaskCache")), this.s.getStatus());
                                    }
                                    if (z) {
                                    }
                                }
                            }
                            this.s.reset();
                        } else {
                            z2 = false;
                        }
                        try {
                            V();
                        } catch (com.ss.android.socialbase.downloader.exception.a e6) {
                            e2 = e6;
                            throw e2;
                        } catch (Throwable th4) {
                            th = th4;
                            z = z2;
                            z2 = false;
                            if (this.f35271f != null && this.s != null) {
                                c.p.a.e.b.e.a.e(this.f35271f.R(), this.s, new BaseException(1003, c.p.a.e.b.l.f.a0(th, "checkTaskCache")), this.s.getStatus());
                            }
                            if (z) {
                                if (!z2 || this.L.l("fix_file_exist_update_download_info")) {
                                    this.r.a(this.s);
                                }
                            }
                            return;
                        }
                    } catch (SQLiteException e7) {
                        e7.printStackTrace();
                        return;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.a e8) {
                    e2 = e8;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (z2) {
                    this.r.a(this.s);
                }
            } catch (Throwable th6) {
                if (0 != 0) {
                    if (1 != 0) {
                        try {
                        } catch (SQLiteException e9) {
                            e9.printStackTrace();
                        }
                    }
                    this.r.a(this.s);
                }
                throw th6;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e A[LOOP:0: B:26:0x005e->B:60:0x005e, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048598, this) != null) {
            return;
        }
        Process.setThreadPriority(10);
        try {
            if (this.s != null && this.K > 0) {
                this.s.increaseDownloadPrepareTime(System.currentTimeMillis() - this.K);
            }
        } catch (Throwable unused) {
        }
        try {
            c.p.a.e.b.f.b Q = this.f35271f.Q();
            if (Q != null) {
                if (Q.a()) {
                    this.y.v();
                    return;
                }
            }
        } finally {
            if (W()) {
            }
        }
        if (W()) {
            z R = this.f35271f.R();
            DownloadInfo downloadInfo = this.s;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo2 = this.s;
            c.p.a.e.b.e.a.e(R, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            return;
        }
        while (true) {
            Z();
            if (!this.F) {
                return;
            }
            if (this.E > 0) {
                this.E--;
            } else if (this.s.getCurBytes() != this.s.getTotalBytes()) {
                c.p.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            } else if (this.s.getCurBytes() <= 0) {
                c.p.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            } else if (this.s.getTotalBytes() <= 0) {
                c.p.a.e.b.c.a.g(O, this.s.getErrorBytesLog());
                this.y.g(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.s.getByteInvalidRetryStatus()));
                return;
            }
        }
    }

    public final void Z() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            try {
                this.q = com.ss.android.socialbase.downloader.constants.h.f76168a;
                this.s.updateStartDownloadTime();
                this.s.resetRealStartDownloadTime();
                long currentTimeMillis = System.currentTimeMillis();
                this.s.setFirstSpeedTime(-1L);
                try {
                    X();
                    z = false;
                } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                    String str = O;
                    c.p.a.e.b.c.a.g(str, "file exist " + e2.a());
                    this.H = e2.a();
                    z = true;
                }
                if (!this.F) {
                    this.y.n();
                }
                this.F = false;
                if (j0()) {
                    return;
                }
                if (!TextUtils.isEmpty(this.H) && z) {
                    if (this.s.isExpiredRedownload()) {
                        this.I = c.p.a.e.b.l.f.D0(this.s);
                    }
                    if (!this.I) {
                        a0();
                        return;
                    }
                }
                while (!j0()) {
                    try {
                        try {
                            try {
                                o();
                                k();
                                n();
                                c2 = this.r.c(this.s.getId());
                                p();
                            } catch (BaseException e3) {
                                String str2 = O;
                                c.p.a.e.b.c.a.j(str2, "downloadInner: baseException = " + e3);
                                if (this.q != com.ss.android.socialbase.downloader.constants.h.f76169b) {
                                    if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                        if (a(e3)) {
                                            if (c.p.a.e.b.l.f.K(e3)) {
                                                q();
                                            }
                                            if (h(e3, 0L) != com.ss.android.socialbase.downloader.exception.h.f76224a) {
                                                g0();
                                            } else {
                                                g0();
                                                return;
                                            }
                                        } else {
                                            g(e3);
                                        }
                                    }
                                    this.q = com.ss.android.socialbase.downloader.constants.h.f76172e;
                                    g0();
                                    return;
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                            a0();
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.i e4) {
                        String str3 = O;
                        c.p.a.e.b.c.a.j(str3, "downloadInner: retry throwable for " + e4.a());
                        if (this.q != com.ss.android.socialbase.downloader.constants.h.f76169b) {
                            if (this.f35273h != null && this.f35273h.get() > 0) {
                                this.s.updateCurRetryTime(this.f35273h.decrementAndGet());
                                this.s.setStatus(5);
                            } else if (this.f35273h != null) {
                                if (this.s.trySwitchToNextBackupUrl()) {
                                    this.s.setStatus(5);
                                    this.f35273h.set(this.s.getRetryCount());
                                    this.s.updateCurRetryTime(this.f35273h.get());
                                } else {
                                    g(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.s.getRetryCount()), e4.a())));
                                }
                            } else {
                                g(new BaseException((int) SDKLogTypeConstants.TYPE_NATIVE_CPU_CLICK, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                            }
                            g0();
                        }
                    } catch (Throwable th) {
                        String str4 = O;
                        c.p.a.e.b.c.a.j(str4, "downloadInner: throwable =  " + th);
                        if (this.q != com.ss.android.socialbase.downloader.constants.h.f76169b) {
                            g(new BaseException(1045, th));
                        }
                    }
                    if (b0()) {
                        c.p.a.e.b.c.a.i(O, "downloadSegments return");
                        g0();
                        return;
                    }
                    String connectionUrl = this.s.getConnectionUrl();
                    if (j0()) {
                        g0();
                        return;
                    }
                    long G0 = this.l ? c.p.a.e.b.l.f.G0(this.s) : 0L;
                    com.ss.android.socialbase.downloader.model.b w = w(this.s, G0);
                    List<com.ss.android.socialbase.downloader.model.c> y = y(w);
                    c.p.a.e.b.l.f.C(y, this.s);
                    c.p.a.e.b.l.f.d0(y, this.s);
                    this.s.setPreconnectLevel(0);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        H(connectionUrl, y, G0);
                        this.s.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                        if (j0()) {
                            g0();
                            return;
                        }
                        long totalBytes = this.s.getTotalBytes();
                        a(totalBytes);
                        int u = u(totalBytes, c2);
                        if (j0()) {
                            g0();
                            return;
                        } else if (u > 0) {
                            boolean z2 = u == 1;
                            this.k = z2;
                            if (z2) {
                                if (this.A == null) {
                                    try {
                                        currentTimeMillis2 = System.currentTimeMillis();
                                        G(connectionUrl, y);
                                        this.s.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                    } finally {
                                    }
                                }
                                if (j0()) {
                                    g0();
                                    return;
                                }
                                this.s.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                c0();
                                E(w, connectionUrl, this.A);
                            } else {
                                if (!this.s.isNeedReuseFirstConnection()) {
                                    f0();
                                }
                                if (j0()) {
                                    g0();
                                    return;
                                }
                                c0();
                                this.s.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                                if (this.l) {
                                    A(u, c2);
                                } else {
                                    B(totalBytes, u);
                                }
                            }
                            g0();
                            return;
                        } else {
                            throw new BaseException(1032, "chunkCount is 0");
                        }
                    } finally {
                    }
                }
            } finally {
                d0();
            }
        }
    }

    @Override // c.p.a.e.b.k.f
    public void a(long j2) throws BaseException {
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            String tempPath = this.s.getTempPath();
            String tempName = this.s.getTempName();
            if (c.p.a.e.b.l.f.f0(j2)) {
                return;
            }
            c.p.a.e.b.n.c f2 = c.p.a.e.b.l.f.f(this.s, tempPath, tempName, -1);
            try {
                long length = new File(tempPath, tempName).length();
                long j4 = j2 - length;
                long y0 = c.p.a.e.b.l.f.y0(tempPath);
                c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(this.s.getId());
                if (d2.b("space_fill_part_download", 0) == 1) {
                    this.J = 0L;
                    if (j4 <= 0) {
                        j4 = this.s.getTotalBytes() - this.s.getCurBytes();
                    }
                    if (y0 < j4) {
                        String str = O;
                        c.p.a.e.b.c.a.j(str, "checkSpaceOverflow: contentLength = " + c.p.a.e.b.l.f.a(j2) + "MB, downloaded = " + c.p.a.e.b.l.f.a(length) + "MB, required = " + c.p.a.e.b.l.f.a(j4) + "MB, available = " + c.p.a.e.b.l.f.a(y0) + "MB");
                        int i2 = (y0 > 0L ? 1 : (y0 == 0L ? 0 : -1));
                        if (i2 > 0) {
                            int b2 = d2.b("space_fill_min_keep_mb", 100);
                            if (b2 > 0) {
                                j3 = y0 - (b2 * 1048576);
                                String str2 = O;
                                c.p.a.e.b.c.a.j(str2, "checkSpaceOverflow: minKeep = " + b2 + "MB, canDownload = " + c.p.a.e.b.l.f.a(j3) + "MB");
                                if (j3 > 0) {
                                    this.J = this.s.getCurBytes() + j3;
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.d(y0, j4);
                                }
                            } else {
                                j3 = y0;
                            }
                            if (length < j2) {
                                if (j3 + length > j2) {
                                }
                                f2.o(j2);
                                c.p.a.e.b.l.f.E(f2);
                            }
                        } else if (d2.b("download_when_space_negative", 0) != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("availableSpace ");
                            sb.append(i2 == 0 ? "=" : "<");
                            sb.append(" 0");
                            throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb.toString());
                        } else {
                            f2.o(j2);
                            c.p.a.e.b.l.f.E(f2);
                        }
                    }
                } else {
                    int i3 = (y0 > 0L ? 1 : (y0 == 0L ? 0 : -1));
                    if (i3 <= 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("availableSpace ");
                        sb2.append(i3 == 0 ? "=" : "<");
                        sb2.append(" 0");
                        throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, sb2.toString());
                    } else if (y0 < j4) {
                        throw new com.ss.android.socialbase.downloader.exception.d(y0, j4);
                    }
                }
                f2.o(j2);
                c.p.a.e.b.l.f.E(f2);
            } catch (Throwable th) {
                c.p.a.e.b.l.f.E(f2);
                throw th;
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.p.a.e.b.c.a.g(O, "finishWithFileExist");
            if (c.p.a.e.b.j.a.r().q("fix_end_for_file_exist_error", true)) {
                if (this.H.equals(this.s.getName())) {
                    this.q = com.ss.android.socialbase.downloader.constants.h.f76172e;
                } else {
                    this.q = com.ss.android.socialbase.downloader.constants.h.f76175h;
                }
            } else if (this.H.equals(this.s.getTargetFilePath())) {
                this.q = com.ss.android.socialbase.downloader.constants.h.f76172e;
            } else {
                this.q = com.ss.android.socialbase.downloader.constants.h.f76175h;
            }
        }
    }

    @Override // c.p.a.e.b.k.f
    public boolean b(long j2) throws BaseException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j2)) == null) {
            if (this.J > 0 && this.s.getCurBytes() > this.J) {
                m();
            }
            return this.y.k(j2);
        }
        return invokeJ.booleanValue;
    }

    public final boolean b0() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!this.s.isExpiredRedownload() && this.s.getChunkCount() == 1 && this.s.getThrottleNetSpeed() <= 0) {
                JSONObject u = c.p.a.e.b.j.a.d(this.s.getId()).u("segment_config");
                List<c.p.a.e.b.i.i> n = this.r.n(this.s.getId());
                if (this.s.getCurBytes() > 0) {
                    if (n == null || n.isEmpty()) {
                        return false;
                    }
                    if (u == null) {
                        u = new JSONObject();
                    }
                }
                if (u == null) {
                    return false;
                }
                this.N = new j(this.s, m.b(u), this);
                if (j0()) {
                    c.p.a.e.b.c.a.i(O, "downloadSegments: is stopped by user");
                    if (this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) {
                        this.N.r();
                    } else {
                        this.N.C();
                    }
                    return true;
                }
                return this.N.A(n);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.k.f
    public void c(c.p.a.e.b.k.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) || this.k) {
            return;
        }
        synchronized (this) {
            this.f35274i.remove(bVar);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && c.p.a.e.b.j.a.d(this.s.getId()).b("reset_retain_retry_times", 0) == 1 && this.M < 3) {
            this.f35273h.set(this.s.isBackUpUrlUsed() ? this.s.getBackUpUrlRetryCount() : this.s.getRetryCount());
            this.M++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0141, code lost:
        c.p.a.e.b.l.f.w(r18.s);
     */
    @Override // c.p.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, i iVar, long j2) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        long j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{str, iVar, Long.valueOf(j2)}) == null) || iVar == null) {
            return;
        }
        try {
            c.p.a.e.b.n.b bVar = new c.p.a.e.b.n.b(str, iVar);
            int i2 = bVar.f35400c;
            String d2 = bVar.d();
            if (TextUtils.isEmpty(this.s.getMimeType()) && !TextUtils.isEmpty(d2)) {
                this.s.setMimeType(d2);
            }
            boolean b2 = bVar.b();
            this.m = b2;
            this.s.setSupportPartial(b2);
            this.n = bVar.a();
            String str2 = this.s.geteTag();
            String c2 = bVar.c();
            String f2 = bVar.f();
            String g2 = bVar.g();
            String str3 = O;
            c.p.a.e.b.c.a.g(str3, "dcache=responseCode=" + i2 + " last_modified=" + f2 + " CACHE_CONTROL=" + g2 + " max-age=" + bVar.k() + " isDeleteCacheIfCheckFailed=" + this.s.isDeleteCacheIfCheckFailed());
            String str4 = O;
            c.p.a.e.b.c.a.g(str4, "dcache=firstOffset=" + j2 + " cur=" + f2 + " before=" + this.s.getLastModified() + " cur=" + bVar.j() + " before=" + this.s.getTotalBytes());
            if (!TextUtils.isEmpty(g2)) {
                this.s.setCacheControl(g2);
                if (bVar.k() > 0) {
                    this.s.setCacheExpiredTime(System.currentTimeMillis() + (bVar.k() * 1000));
                }
            }
            if (this.s.isExpiredRedownload() && this.I && !TextUtils.isEmpty(this.H)) {
                boolean z = false;
                if (i2 != 304) {
                    if ((!TextUtils.isEmpty(this.s.getLastModified()) || !this.s.isDeleteCacheIfCheckFailed()) && TextUtils.equals(f2, this.s.getLastModified())) {
                    }
                    String str5 = O;
                    c.p.a.e.b.c.a.g(str5, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                    throw new com.ss.android.socialbase.downloader.exception.a(this.H);
                }
                z = true;
                String str52 = O;
                c.p.a.e.b.c.a.g(str52, "dcache=responseCode=" + i2 + " lastModified not changed, use local file  " + f2);
                throw new com.ss.android.socialbase.downloader.exception.a(this.H);
            }
            int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i3 > 0 && this.s.isExpiredRedownload() && !TextUtils.equals(f2, this.s.getLastModified())) {
                c.p.a.e.b.c.a.g(O, "dcache cdn file change, so retry");
                F("", "cdn file changed");
                throw null;
            }
            if (!TextUtils.isEmpty(f2)) {
                this.s.setLastModified(f2);
            }
            if (L(i2, str2, c2)) {
                if (iVar instanceof k) {
                    F((TextUtils.isEmpty(str2) || !str2.equals(c2)) ? c2 : "", "eTag of server file changed");
                    throw null;
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1002, i2, "");
            }
            if (!this.m && !this.n) {
                if (i2 == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "response code error : " + i2);
            }
            if (this.n && i3 > 0) {
                if (iVar instanceof k) {
                    F("", "http head request not support");
                    throw null;
                }
                throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
            }
            long h2 = bVar.h();
            if (!(iVar instanceof k) && h2 < 0 && c.p.a.e.b.l.d.a(this.s)) {
                throw new BaseException(1004, "");
            }
            String g3 = TextUtils.isEmpty(this.s.getName()) ? c.p.a.e.b.l.f.g(iVar, this.s.getUrl()) : "";
            boolean i4 = bVar.i();
            this.o = i4;
            if (!i4 && h2 == 0 && !(iVar instanceof k)) {
                throw new BaseException(1004, "");
            }
            if (this.o) {
                j3 = -1;
            } else {
                String Y = c.p.a.e.b.l.f.Y(iVar, "Content-Range");
                String str6 = O;
                c.p.a.e.b.c.a.i(str6, "firstConnection: contentRange = " + Y);
                if (!TextUtils.isEmpty(Y) && this.L.q("fix_get_total_bytes", true)) {
                    j3 = c.p.a.e.b.l.f.V(Y);
                    String str7 = O;
                    c.p.a.e.b.c.a.i(str7, "firstConnection: 1 totalLength = " + j3);
                } else {
                    long j4 = j2 + h2;
                    String str8 = O;
                    c.p.a.e.b.c.a.k(str8, "firstConnection: 2 totalLength = " + j4 + ", contentLength = " + h2);
                    j3 = j4;
                }
            }
            if (j0()) {
                return;
            }
            if (this.s.getExpectFileLength() > 0 && c.p.a.e.b.j.a.d(this.s.getId()).m("force_check_file_length") == 1 && this.s.getExpectFileLength() != j3) {
                throw new BaseException(1070, "expectFileLength = " + this.s.getExpectFileLength() + " , totalLength = " + j3);
            }
            this.y.e(j3, c2, g3);
        } catch (BaseException e2) {
            throw e2;
        } catch (com.ss.android.socialbase.downloader.exception.i e3) {
            throw e3;
        } catch (Throwable th) {
            c.p.a.e.b.l.f.B(th, "HandleFirstConnection");
            throw null;
        }
    }

    public final void d0() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            String str = O;
            c.p.a.e.b.c.a.g(str, "endDownloadRunnable::runStatus=" + this.q);
            boolean z3 = (this.q == com.ss.android.socialbase.downloader.constants.h.f76169b || this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) ? false : true;
            try {
                z = k0();
                z2 = false;
            } catch (Exception e2) {
                if (e2 instanceof BaseException) {
                    this.y.g((BaseException) e2);
                } else {
                    this.y.g(new BaseException(1046, e2));
                }
                z = true;
                z2 = true;
            }
            if (!z && !z2) {
                this.F = true;
                c.p.a.e.b.c.a.g(O, "jump to restart");
                return;
            }
            this.p.set(false);
            if (z3) {
                try {
                    c.p.a.e.b.m.a c2 = c.p.a.e.b.g.e.c();
                    if (c2 != null) {
                        c2.l(this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    z R = this.f35271f.R();
                    DownloadInfo downloadInfo = this.s;
                    BaseException baseException = new BaseException(1014, c.p.a.e.b.l.f.a0(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.s;
                    c.p.a.e.b.e.a.e(R, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // c.p.a.e.b.k.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(i iVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048611, this, iVar) != null) {
            return;
        }
        if (iVar != null) {
            try {
                int b2 = iVar.b();
                this.s.setHttpStatusCode(b2);
                this.s.setHttpStatusMessage(c.p.a.e.b.l.b.a(b2));
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                this.s.setHttpStatusCode(-1);
                this.s.setHttpStatusMessage("");
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    public final void e0() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (iVar = this.B) == null) {
            return;
        }
        iVar.c();
        this.B = null;
    }

    @Override // c.p.a.e.b.k.f
    public void f(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, baseException) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo != null) {
                downloadInfo.setChunkDowngradeRetryUsed(true);
            }
            i(baseException, false);
        }
    }

    public final void f0() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (kVar = this.A) == null) {
            return;
        }
        kVar.d();
        this.A = null;
    }

    @Override // c.p.a.e.b.k.f
    public void g(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, baseException) == null) {
            String str = O;
            c.p.a.e.b.c.a.g(str, "onError:" + baseException.getMessage());
            this.q = com.ss.android.socialbase.downloader.constants.h.f76171d;
            this.z = baseException;
            r();
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            e0();
            f0();
        }
    }

    @Override // c.p.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.h h(BaseException baseException, long j2) {
        InterceptResult invokeLJ;
        long totalBytes;
        long j3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048617, this, baseException, j2)) == null) {
            this.z = baseException;
            this.s.increaseCurBytes(-j2);
            this.r.a(this.s);
            if (i0()) {
                return com.ss.android.socialbase.downloader.exception.h.f76224a;
            }
            if (baseException != null && baseException.getErrorCode() == 1047) {
                if (this.C != null && !this.s.isForbiddenRetryed()) {
                    a aVar = new a(this);
                    boolean a2 = this.C.a(aVar);
                    this.s.setForbiddenRetryed();
                    if (a2) {
                        if (!aVar.a()) {
                            r();
                            this.y.y();
                            this.q = com.ss.android.socialbase.downloader.constants.h.f76174g;
                            return com.ss.android.socialbase.downloader.exception.h.f76224a;
                        }
                        z = true;
                    }
                } else if (R(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f76224a;
                }
                z = false;
            } else if (c.p.a.e.b.l.f.V0(baseException)) {
                if (this.D == null) {
                    g(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.f76224a;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                b bVar = new b(this, atomicBoolean);
                if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                    com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                    j3 = dVar.a();
                    totalBytes = dVar.b();
                } else {
                    totalBytes = this.s.getTotalBytes();
                    j3 = -1;
                }
                synchronized (this) {
                    if (this.D.a(j3, totalBytes, bVar)) {
                        if (!c.p.a.e.b.j.a.d(this.s.getId()).q("not_delete_when_clean_space", false)) {
                            m0();
                        }
                        if (!atomicBoolean.get()) {
                            if (this.q != com.ss.android.socialbase.downloader.constants.h.f76174g) {
                                this.q = com.ss.android.socialbase.downloader.constants.h.f76174g;
                                r();
                                this.y.y();
                            }
                            return com.ss.android.socialbase.downloader.exception.h.f76224a;
                        }
                        if (R(baseException)) {
                            return com.ss.android.socialbase.downloader.exception.h.f76224a;
                        }
                        z = true;
                    } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76174g) {
                        return com.ss.android.socialbase.downloader.exception.h.f76224a;
                    } else {
                        g(baseException);
                        return com.ss.android.socialbase.downloader.exception.h.f76224a;
                    }
                }
            } else {
                if (R(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.h.f76224a;
                }
                z = false;
            }
            if (!z && t()) {
                r();
            }
            this.y.h(baseException, this.q == com.ss.android.socialbase.downloader.constants.h.f76173f);
            return this.q == com.ss.android.socialbase.downloader.constants.h.f76173f ? com.ss.android.socialbase.downloader.exception.h.f76224a : com.ss.android.socialbase.downloader.exception.h.f76225b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeLJ.objValue;
    }

    public final void h0() throws BaseException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.f35275j == null) {
            return;
        }
        if (this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) {
            this.s.setStatus(-4);
            this.f35275j.j();
        } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76169b) {
            this.s.setStatus(-2);
            this.f35275j.h();
        } else {
            this.f35275j.k();
        }
    }

    @Override // c.p.a.e.b.k.f
    public void i(BaseException baseException, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048619, this, baseException, z) == null) {
            c.p.a.e.b.c.a.g(O, "onAllChunkRetryWithReset");
            this.q = com.ss.android.socialbase.downloader.constants.h.f76176i;
            this.z = baseException;
            r();
            if (z ? R(baseException) : false) {
                return;
            }
            q();
        }
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q == com.ss.android.socialbase.downloader.constants.h.f76170c || this.q == com.ss.android.socialbase.downloader.constants.h.f76169b : invokeV.booleanValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.x.a(this.s.getCurRetryTimeInTotal(), this.s.getTotalRetryCount()) : invokeV.longValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (i0() || this.s.getStatus() == -2) {
                if (i0()) {
                    return true;
                }
                if (this.s.getStatus() == -2) {
                    this.q = com.ss.android.socialbase.downloader.constants.h.f76169b;
                    return true;
                } else if (this.s.getStatus() == -4) {
                    this.q = com.ss.android.socialbase.downloader.constants.h.f76170c;
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        c.p.a.e.b.m.a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            int id = this.s.getId();
            int v = c.p.a.e.b.g.e.v(this.s);
            if (this.s.isDownloaded() && !this.s.isExpiredRedownload() && !this.I) {
                throw new BaseException(1009, "file has downloaded");
            }
            DownloadInfo b2 = this.r.b(v);
            if (b2 == null || (c2 = c.p.a.e.b.g.e.c()) == null || b2.getId() == id || !b2.equalsTask(this.s)) {
                return;
            }
            if (!c2.r(b2.getId())) {
                List<com.ss.android.socialbase.downloader.model.b> c3 = this.r.c(v);
                c.p.a.e.b.l.f.w(this.s);
                this.r.f(v);
                if (b2 == null || !b2.isBreakpointAvailable()) {
                    return;
                }
                this.s.copyFromCacheData(b2, false);
                this.r.a(this.s);
                if (c3 != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar : c3) {
                        bVar.b(id);
                        this.r.a(bVar);
                    }
                }
                throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
            }
            this.r.f(id);
            throw new BaseException(1025, "another same task is downloading");
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.q == com.ss.android.socialbase.downloader.constants.h.f76171d) {
                this.y.g(this.z);
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76170c) {
                this.y.s();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76169b) {
                this.y.u();
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76172e) {
                try {
                    this.y.x();
                } catch (BaseException e2) {
                    this.y.g(e2);
                }
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76175h) {
                try {
                    this.y.j(this.H);
                } catch (BaseException e3) {
                    this.y.g(e3);
                }
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76176i) {
                this.y.h(this.z, false);
                return false;
            } else if (this.q == com.ss.android.socialbase.downloader.constants.h.f76174g) {
                return true;
            } else {
                if (this.q == com.ss.android.socialbase.downloader.constants.h.f76173f && !l0()) {
                    c.p.a.e.b.c.a.g(O, "doTaskStatusHandle retryDelay");
                    n0();
                    return this.q == com.ss.android.socialbase.downloader.constants.h.f76173f;
                }
                try {
                    if (!m0()) {
                        return false;
                    }
                    this.y.w();
                    q.d().w();
                } catch (Throwable th) {
                    g(new BaseException(1008, c.p.a.e.b.l.f.a0(th, "doTaskStatusHandle onComplete")));
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            DownloadInfo downloadInfo = this.s;
            if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
                return false;
            }
            return (!this.l || this.s.getChunkCount() > 1) && !this.s.isChunkDowngradeRetryUsed() && this.m && !this.o;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.s.getChunkCount() <= 1) {
                return this.s.getCurBytes() > 0 && this.s.getCurBytes() == this.s.getTotalBytes();
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.getId());
            if (c2 == null || c2.size() <= 1) {
                return false;
            }
            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                if (bVar == null || !bVar.i()) {
                    return false;
                }
                while (r0.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m() throws BaseException {
        long j2;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            try {
                j2 = c.p.a.e.b.l.f.y0(this.s.getTempPath());
            } catch (BaseException unused) {
                j2 = 0;
            }
            c.p.a.e.b.c.a.i(O, "checkSpaceOverflowInProgress: available = " + c.p.a.e.b.l.f.a(j2) + "MB");
            if (j2 > 0) {
                long totalBytes = this.s.getTotalBytes() - this.s.getCurBytes();
                if (j2 < totalBytes && (b2 = c.p.a.e.b.j.a.d(this.s.getId()).b("space_fill_min_keep_mb", 100)) > 0) {
                    long j3 = j2 - (b2 * 1048576);
                    c.p.a.e.b.c.a.i(O, "checkSpaceOverflowInProgress: minKeep  = " + b2 + "MB, canDownload = " + c.p.a.e.b.l.f.a(j3) + "MB");
                    if (j3 > 0) {
                        this.J = this.s.getCurBytes() + j3 + 1048576;
                        return;
                    } else {
                        this.J = 0L;
                        throw new com.ss.android.socialbase.downloader.exception.d(j2, totalBytes);
                    }
                }
            }
            this.J = 0L;
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.s.isChunked()) {
                DownloadInfo downloadInfo = this.s;
                downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
            }
            String str = O;
            c.p.a.e.b.c.a.i(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.s.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.s.getTotalBytes());
            if (this.s.getCurBytes() > 0) {
                if (this.s.isIgnoreDataVerify()) {
                    return true;
                }
                if (this.s.getTotalBytes() > 0 && this.s.getCurBytes() == this.s.getTotalBytes()) {
                    return true;
                }
            }
            this.s.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.f76151b);
            this.s.reset();
            this.r.a(this.s);
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            c.p.a.e.b.l.f.w(this.s);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() throws com.ss.android.socialbase.downloader.exception.f {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.s.isOnlyWifi() && !c.p.a.e.b.l.f.J(c.p.a.e.b.g.e.n(), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
            }
            if (this.s.isDownloadWithWifiValid()) {
                if (!this.s.isPauseReserveWithWifiValid()) {
                    throw new com.ss.android.socialbase.downloader.exception.e();
                }
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.c();
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.h.f76168a;
        }
    }

    public final void o() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (!TextUtils.isEmpty(this.s.getSavePath())) {
                if (!TextUtils.isEmpty(this.s.getName())) {
                    File file = new File(this.s.getSavePath());
                    if (!file.exists()) {
                        boolean mkdirs = file.mkdirs();
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        int i2 = 0;
                        if (c.p.a.e.b.j.a.d(this.s.getId()).b("opt_mkdir_failed", 0) == 1) {
                            while (!mkdirs) {
                                int i3 = i2 + 1;
                                if (i2 >= 3) {
                                    break;
                                }
                                try {
                                    Thread.sleep(10L);
                                    mkdirs = file.mkdirs();
                                    i2 = i3;
                                } catch (InterruptedException unused) {
                                }
                            }
                            if (mkdirs || file.exists()) {
                                return;
                            }
                            if (c.p.a.e.b.l.f.y0(this.s.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + this.s.getSavePath());
                            }
                            throw new BaseException(1030, "download savePath directory can not created:" + this.s.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.s.getSavePath());
                    } else if (file.isDirectory()) {
                        return;
                    } else {
                        if (c.p.a.e.b.l.d.b(this.s)) {
                            file.delete();
                            if (file.mkdirs() || file.exists()) {
                                return;
                            }
                            throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + this.s.getSavePath());
                        }
                        throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not a directory:" + this.s.getSavePath());
                    }
                }
                throw new BaseException(1029, "download name can not be empty");
            }
            throw new BaseException(1028, "download savePath can not be empty");
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            long M0 = c.p.a.e.b.l.f.M0(this.s);
            long curBytes = this.s.getCurBytes();
            if (M0 != curBytes) {
                String str = O;
                c.p.a.e.b.c.a.j(str, "checkTaskCanResume: offset = " + M0 + ", curBytes = " + curBytes);
            }
            this.s.setCurBytes(M0);
            boolean z = M0 > 0;
            this.l = z;
            if (z || this.I) {
                return;
            }
            c.p.a.e.b.c.a.i(O, "checkTaskCanResume: deleteAllDownloadFiles");
            this.r.d(this.s.getId());
            this.r.m(this.s.getId());
            c.p.a.e.b.l.f.w(this.s);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            String str = O;
            c.p.a.e.b.c.a.j(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
            try {
                this.r.d(this.s.getId());
                this.r.m(this.s.getId());
                c.p.a.e.b.l.f.w(this.s);
                this.l = false;
                this.s.resetDataForEtagEndure("");
                this.r.a(this.s);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            try {
                Iterator it = ((ArrayList) this.f35274i.clone()).iterator();
                while (it.hasNext()) {
                    c.p.a.e.b.k.b bVar = (c.p.a.e.b.k.b) it.next();
                    if (bVar != null) {
                        bVar.e();
                    }
                }
            } catch (Throwable th) {
                String str = O;
                c.p.a.e.b.c.a.i(str, "cancelAllChunkRunnable: " + th.toString());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            c.p.a.e.b.g.e.S(this.f35271f, 3);
            try {
                c.p.a.e.b.o.d.a().b();
                Y();
                c.p.a.e.b.o.d.a().c();
                c.p.a.e.b.g.e.f0(this.f35271f, 3);
            } catch (Throwable th) {
                c.p.a.e.b.o.d.a().c();
                throw th;
            }
        }
    }

    public final void s() {
        c.p.a.e.b.m.a c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || j0() || (c2 = c.p.a.e.b.g.e.c()) == null) {
            return;
        }
        c2.Q(this.s.getId());
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r9 <= 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int u(long j2, List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeJL;
        int i2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048638, this, j2, list)) == null) {
            if (l()) {
                if (!this.l) {
                    c.p.a.e.b.g.j jVar = this.t;
                    if (jVar != null) {
                        a2 = jVar.a(j2);
                    } else {
                        a2 = this.u.a(j2);
                    }
                    l d2 = c.p.a.e.b.o.m.a().d();
                    c.p.a.e.b.c.a.g(O, String.format("NetworkQuality is : %s", d2.name()));
                    this.s.setNetworkQuality(d2.name());
                    c.p.a.e.b.g.i iVar = this.v;
                    if (iVar != null) {
                        i2 = iVar.a(a2, d2);
                    } else {
                        i2 = this.w.a(a2, d2);
                    }
                } else if (list != null) {
                    i2 = list.size();
                } else {
                    i2 = this.s.getChunkCount();
                }
            }
            i2 = 1;
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.g(O, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(i2), this.s.getName(), String.valueOf(j2)));
            }
            return i2;
        }
        return invokeJL.intValue;
    }

    public final s v(c.p.a.e.b.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, aVar)) == null) {
            s U = aVar.U();
            if (U != null) {
                return U;
            }
            DownloadInfo J = aVar.J();
            if (J != null) {
                String retryDelayTimeArray = J.getRetryDelayTimeArray();
                if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                    return new p(retryDelayTimeArray);
                }
            }
            return c.p.a.e.b.g.e.l();
        }
        return (s) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r9.f() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.ss.android.socialbase.downloader.model.b x(com.ss.android.socialbase.downloader.model.b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048640, this, bVar, i2)) == null) {
            com.ss.android.socialbase.downloader.model.b bVar2 = null;
            if (bVar.d()) {
                long c2 = bVar.c(true);
                String str = O;
                c.p.a.e.b.c.a.g(str, "reuseChunk retainLen:" + c2 + " chunkIndex:" + i2);
                boolean z = false;
                if (!bVar.f() && c2 > c.p.a.e.b.d.c.f35107f && this.s.isNeedReuseChunkRunnable()) {
                    List<com.ss.android.socialbase.downloader.model.b> a2 = bVar.a(this.s.getChunkCount(), this.s.getTotalBytes());
                    if (a2 != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar3 : a2) {
                            this.r.b(bVar3);
                        }
                    }
                }
                z = true;
                if (z && bVar.f()) {
                    for (int i3 = 1; i3 < bVar.g().size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar4 = bVar.g().get(i3);
                        if (bVar4 != null) {
                            String str2 = O;
                            c.p.a.e.b.c.a.g(str2, "check can checkUnCompletedChunk -- chunkIndex:" + bVar4.s() + " currentOffset:" + bVar4.n() + "  startOffset:" + bVar4.l() + " contentLen:" + bVar4.q());
                            if (bVar4.s() < 0 || (!bVar4.i() && !bVar4.c())) {
                                bVar2 = bVar4;
                                break;
                            }
                        }
                    }
                    if (bVar2 != null) {
                        long n = bVar.n();
                        String str3 = O;
                        c.p.a.e.b.c.a.g(str3, "unComplete chunk " + bVar.s() + " curOffset:" + n + " reuseChunk chunkIndex:" + i2 + " for subChunk:" + bVar2.s());
                        this.r.a(bVar2.k(), bVar2.s(), bVar2.b(), i2);
                        bVar2.c(i2);
                        bVar2.a(true);
                    }
                }
                return bVar2;
            }
            return null;
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeLI.objValue;
    }

    public final List<com.ss.android.socialbase.downloader.model.c> y(com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bVar)) == null) {
            List<com.ss.android.socialbase.downloader.model.c> t = c.p.a.e.b.l.f.t(this.s.getExtraHeaders(), this.s.geteTag(), bVar);
            if (this.s.isExpiredRedownload() && this.I && this.s.getLastModified() != null) {
                t.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.s.getLastModified()));
                t.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
                String str = O;
                c.p.a.e.b.c.a.g(str, "dcache::add head IF_MODIFIED_SINCE=" + this.s.getLastModified());
            }
            return t;
        }
        return (List) invokeL.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.q = com.ss.android.socialbase.downloader.constants.h.f76169b;
            if (this.N != null) {
                this.N.C();
            }
            if (this.f35275j != null) {
                this.f35275j.h();
            }
            if (this.N == null && this.f35275j == null) {
                g0();
                this.q = com.ss.android.socialbase.downloader.constants.h.f76169b;
                d0();
            }
            try {
                Iterator it = ((ArrayList) this.f35274i.clone()).iterator();
                while (it.hasNext()) {
                    c.p.a.e.b.k.b bVar = (c.p.a.e.b.k.b) it.next();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.k.f
    public com.ss.android.socialbase.downloader.exception.h b(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{bVar, baseException, Long.valueOf(j2)})) == null) {
            if (i0()) {
                return com.ss.android.socialbase.downloader.exception.h.f76224a;
            }
            if (baseException != null && (baseException.getErrorCode() == 1047 || c.p.a.e.b.l.f.V0(baseException))) {
                return h(baseException, j2);
            }
            this.z = baseException;
            this.s.increaseCurBytes(-j2);
            this.r.a(this.s);
            if (R(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.f76224a;
            }
            this.y.i(bVar, baseException, this.q == com.ss.android.socialbase.downloader.constants.h.f76173f);
            if (this.q != com.ss.android.socialbase.downloader.constants.h.f76173f && this.s.isNeedRetryDelay()) {
                long j3 = j();
                if (j3 > 0) {
                    String str = O;
                    c.p.a.e.b.c.a.i(str, "onSingleChunkRetry with delay time " + j3);
                    try {
                        Thread.sleep(j3);
                    } catch (Throwable th) {
                        String str2 = O;
                        c.p.a.e.b.c.a.j(str2, "onSingleChunkRetry:" + th.getMessage());
                    }
                }
            }
            return com.ss.android.socialbase.downloader.exception.h.f76225b;
        }
        return (com.ss.android.socialbase.downloader.exception.h) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.k.f
    public boolean a(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, baseException)) == null) {
            if (this.N == null || !c.p.a.e.b.l.f.Y0(baseException) || this.f35273h.get() >= this.s.getRetryCount()) {
                if (c.p.a.e.b.l.f.h0(baseException)) {
                    if (this.k && !this.f35272g) {
                        c.p.a.e.b.l.f.w(this.s);
                        this.f35272g = true;
                    }
                    return true;
                }
                AtomicInteger atomicInteger = this.f35273h;
                if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.s.hasNextBackupUrl()) {
                    if (baseException == null) {
                        return false;
                    }
                    if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.s.canReplaceHttpForRetry()) {
                        return false;
                    }
                }
                return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.k.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        InterceptResult invokeI;
        com.ss.android.socialbase.downloader.model.b x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            synchronized (this) {
                if (this.s.getChunkCount() < 2) {
                    return null;
                }
                List<com.ss.android.socialbase.downloader.model.b> c2 = this.r.c(this.s.getId());
                if (c2 != null && !c2.isEmpty()) {
                    for (int i3 = 0; i3 < c2.size(); i3++) {
                        com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
                        if (bVar != null && (x = x(bVar, i2)) != null) {
                            return x;
                        }
                    }
                    return null;
                }
                return null;
            }
        }
        return (com.ss.android.socialbase.downloader.model.b) invokeI.objValue;
    }
}
