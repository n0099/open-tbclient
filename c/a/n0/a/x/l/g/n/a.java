package c.a.n0.a.x.l.g.n;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.d;
import c.a.n0.a.b0.h;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.x.d.a;
import c.a.n0.a.x.l.e;
import c.a.n0.a.x.l.g.j;
import c.a.n0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.n0.a.o1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7210f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f7211g;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<PrefetchEvent> a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f7212b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7213c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f7214d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Bundle> f7215e;

    /* renamed from: c.a.n0.a.x.l.g.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0544a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7216b;

        /* renamed from: c  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f7217c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f7218d;

        /* renamed from: e  reason: collision with root package name */
        public c f7219e;

        /* renamed from: f  reason: collision with root package name */
        public int f7220f;

        public b(int i, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), blockingQueue, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7220f = 0;
            this.a = i <= 0 ? 30 : i;
            this.f7216b = false;
            this.f7217c = blockingQueue;
            this.f7218d = atomicInteger;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7216b = true;
                this.f7218d.decrementAndGet();
                b();
                if (a.f7210f) {
                    Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c cVar = this.f7219e;
                if (cVar != null) {
                    cVar.k();
                    this.f7219e = null;
                }
                if (a.f7210f) {
                    Log.d("PreCodeCacheManager", "master destroy");
                }
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
                if (this.f7219e == null) {
                    this.f7219e = d();
                }
                if (this.f7219e == null) {
                    a();
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f7219e.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
                countDownLatch.await(3L, TimeUnit.SECONDS);
                f();
            }
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (g.U().k0() && e()) {
                    return new c(null);
                }
                if (a.f7210f) {
                    Log.d("PreCodeCacheManager", "v8 master can not create");
                }
                return null;
            }
            return (c) invokeV.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean c2 = g.v.c();
                String Y = g.U().Y();
                return g.U().s0() && c2 && (!TextUtils.isEmpty(Y) && new File(Y).exists()) && d.c().b();
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i = this.f7220f + 1;
                this.f7220f = i;
                if (i >= 10) {
                    this.f7220f = 0;
                    b();
                }
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ExecutorUtilsExt.postOnElastic(this, "code_cache_fill_thread", 3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                while (!this.f7216b) {
                    try {
                        try {
                            PrefetchEvent poll = this.f7217c.poll(this.a, TimeUnit.SECONDS);
                            if (poll == null) {
                                a();
                            } else {
                                c(poll);
                            }
                        } catch (InterruptedException e2) {
                            if (a.f7210f) {
                                e2.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (a.f7210f) {
                            th.printStackTrace();
                        }
                        a();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicInteger f7221e;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        /* renamed from: b  reason: collision with root package name */
        public volatile c.a.n0.a.x.l.a f7222b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f7223c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f7224d;

        /* renamed from: c.a.n0.a.x.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0545a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f7225b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f7226c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f7227d;

            public C0545a(c cVar, String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, prefetchEvent, countDownLatch};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7227d = cVar;
                this.a = str;
                this.f7225b = prefetchEvent;
                this.f7226c = countDownLatch;
            }

            @Override // c.a.n0.a.x.l.g.j
            public void onReady() {
                c.a.n0.a.x.f.a h2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f7227d.f7222b != null && (h2 = this.f7227d.f7222b.h()) != null && !h2.isDestroyed()) {
                        this.f7227d.s(this.a, h2);
                        this.f7227d.r(h2, this.f7225b);
                        if (a.f7210f) {
                            Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.a);
                        }
                    }
                    CountDownLatch countDownLatch = this.f7226c;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends c.a.n0.a.x.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f7228b;

            public b(c cVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7228b = cVar;
                this.a = j;
            }

            @Override // c.a.n0.a.x.b
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (a.f7210f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.a) + "ms");
                    }
                    super.a(str);
                    this.f7228b.a = true;
                    this.f7228b.q();
                }
            }
        }

        /* renamed from: c.a.n0.a.x.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0546c extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7229f;

            /* renamed from: c.a.n0.a.x.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0547a extends c.a.n0.a.x.l.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0546c f7230e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0547a(C0546c c0546c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0546c, str, str2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7230e = c0546c;
                }

                @Override // c.a.n0.a.x.l.d
                public h e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        h.b bVar = new h.b();
                        bVar.c(1);
                        bVar.b(this.f7230e.f7229f.n());
                        return bVar.a();
                    }
                    return (h) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0546c(c cVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7229f = cVar;
            }

            @Override // c.a.n0.a.x.l.e
            public c.a.n0.a.x.l.d i(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new C0547a(this, str, "runtime/index.js") : (c.a.n0.a.x.l.d) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1513896013, "Lc/a/n0/a/x/l/g/n/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1513896013, "Lc/a/n0/a/x/l/g/n/a$c;");
                    return;
                }
            }
            f7221e = new AtomicInteger(1000);
        }

        public /* synthetic */ c(C0544a c0544a) {
            this();
        }

        public final synchronized void g(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                synchronized (this) {
                    if (jVar == null) {
                        return;
                    }
                    if (this.a) {
                        jVar.onReady();
                        return;
                    }
                    if (!this.f7223c.contains(jVar)) {
                        this.f7223c.add(jVar);
                    }
                }
            }
        }

        public final PrefetchEvent.c h(PrefetchEvent prefetchEvent, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, str)) == null) {
                if (o(prefetchEvent)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", prefetchEvent.appId);
                    hashMap.put("schema", prefetchEvent.schema);
                    hashMap.put("state", prefetchEvent.state);
                    hashMap.put("scene", prefetchEvent.scene);
                    hashMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, prefetchEvent.appPath);
                    hashMap.put("pageType", prefetchEvent.pageType);
                    File file = new File(prefetchEvent.appPath);
                    String m = c.a.n0.a.q0.d.m(new File(file, "app.json"));
                    prefetchEvent.appConfig = m;
                    hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m);
                    SwanAppConfigData c2 = SwanAppConfigData.c(prefetchEvent.appConfig, file);
                    if (c2 == null || p(c2)) {
                        return null;
                    }
                    String f2 = c2.f();
                    prefetchEvent.pageUrl = f2;
                    hashMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, f2);
                    String f3 = o0.f(prefetchEvent.pageUrl);
                    String o = o0.o(prefetchEvent.pageUrl);
                    String c3 = c.a.n0.a.v1.f.o0.j.c(f3, c2);
                    if (!TextUtils.equals(f3, c3)) {
                        if (!TextUtils.isEmpty(o)) {
                            c3 = c3 + "?" + o;
                        }
                        hashMap.put("pageRoutePath", c3);
                    }
                    return new PrefetchEvent.c(hashMap, str);
                }
                return null;
            }
            return (PrefetchEvent.c) invokeLL.objValue;
        }

        public final c.a.n0.a.x.l.a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long currentTimeMillis = a.f7210f ? System.currentTimeMillis() : 0L;
                c.a.n0.a.x.l.a j = j();
                j.loadUrl(o0.w(g.U().Y()));
                j.d(new b(this, currentTimeMillis));
                return j;
            }
            return (c.a.n0.a.x.l.a) invokeV.objValue;
        }

        public final c.a.n0.a.x.l.a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C0546c(this, AppRuntime.getAppContext()) : (c.a.n0.a.x.l.a) invokeV.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f7222b == null) {
                return;
            }
            this.f7222b.destroy();
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, prefetchEvent, countDownLatch) == null) {
                if (this.f7222b == null) {
                    this.f7222b = i();
                }
                this.f7224d.add(str);
                g(new C0545a(this, str, prefetchEvent, countDownLatch));
            }
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
                codeCacheSetting.id = "appjs";
                ArrayList<String> arrayList = new ArrayList<>();
                codeCacheSetting.pathList = arrayList;
                arrayList.addAll(this.f7224d);
                a.C0515a d2 = a.b.d();
                codeCacheSetting.maxCount = d2.a;
                codeCacheSetting.sizeLimit = d2.f6994b;
                codeCacheSetting.diskCodeCacheSizeThreshold = d2.f6995c;
                return codeCacheSetting;
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = "master" + f7221e.getAndIncrement();
                if (a.f7210f) {
                    Log.d("PreCodeCacheManager", "code cache master id - " + str);
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public final boolean o(PrefetchEvent prefetchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, prefetchEvent)) == null) {
                if (prefetchEvent == null) {
                    return false;
                }
                String str = prefetchEvent.appPath;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                return c.a.n0.a.q0.d.z(file) && c.a.n0.a.q0.d.y(file);
            }
            return invokeL.booleanValue;
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, swanAppConfigData)) == null) {
                String str = swanAppConfigData.n;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    return new JSONObject(str).has("_modules");
                } catch (JSONException e2) {
                    if (a.f7210f) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public final synchronized void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this) {
                    for (j jVar : this.f7223c) {
                        if (jVar != null) {
                            jVar.onReady();
                        }
                    }
                    this.f7223c.clear();
                }
            }
        }

        public final void r(@NonNull c.a.n0.a.x.f.a aVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, prefetchEvent) == null) {
                long currentTimeMillis = a.f7210f ? System.currentTimeMillis() : 0L;
                PrefetchEvent.c h2 = h(prefetchEvent, "preload");
                if (h2 != null) {
                    c.a.n0.a.e0.a.a(aVar, h2);
                    if (a.f7210f) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                }
            }
        }

        public final void s(String str, c.a.n0.a.x.f.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, aVar) == null) && (aVar instanceof c.a.n0.a.b0.a)) {
                ((c.a.n0.a.b0.a) aVar).D0(m());
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f7223c = new ArrayList();
            this.f7224d = new CopyOnWriteArrayList();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1424121426, "Lc/a/n0/a/x/l/g/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1424121426, "Lc/a/n0/a/x/l/g/n/a;");
                return;
            }
        }
        f7210f = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedBlockingQueue();
        this.f7212b = new AtomicInteger(0);
        this.f7213c = 1;
        this.f7215e = new ArrayList();
        m();
        if (f7210f) {
            Log.d("PreCodeCacheManager", "max master size - " + this.f7213c);
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f7211g == null) {
                synchronized (a.class) {
                    if (f7211g == null) {
                        f7211g = new a();
                    }
                }
            }
            return f7211g;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.n0.a.o1.c.f.a
    public void a(String str, c.a.n0.a.o1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && TextUtils.equals(str, "event_puppet_online") && !cVar.D()) {
            n(cVar);
        }
    }

    public final PrefetchEvent b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            PrefetchEvent.b bVar = new PrefetchEvent.b();
            bVar.a(str);
            bVar.e("show");
            bVar.c("fill_code_cache");
            PrefetchEvent b2 = bVar.b();
            b2.appPath = str2;
            b2.pageType = "main";
            return b2;
        }
        return (PrefetchEvent) invokeLL.objValue;
    }

    public final boolean c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? (!ProcessUtils.isMainProcess() || q0.G() || c.a.n0.a.s0.a.w0().c()) && !TextUtils.isEmpty(str) && j > 0 : invokeLJ.booleanValue;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, prefetchEvent) == null) {
            this.a.offer(prefetchEvent);
            if (this.f7214d) {
                p();
            }
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) && c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f7210f) {
                Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
            }
            d(b(str, d.e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) && ProcessUtils.isMainProcess() && c(str, j)) {
            c.a.n0.a.o1.c.f.c h2 = h();
            if (h2 == null) {
                if (f7210f) {
                    Log.d("PreCodeCacheManager", "there is no blank client");
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cc_app_id", str);
            bundle.putLong("cc_app_version", j);
            if (h2.S()) {
                o(h2, bundle);
            } else {
                l(bundle);
            }
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || bundle == null || bundle.size() <= 0 || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        e(bundle.getString("cc_app_id"), bundle.getLong("cc_app_version"));
    }

    public final c.a.n0.a.o1.c.f.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.n0.a.o1.c.f.c e2 = c.a.n0.a.o1.c.f.e.k().e();
            if (e2 == null || e2.D()) {
                return null;
            }
            return e2;
        }
        return (c.a.n0.a.o1.c.f.c) invokeV.objValue;
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(30, this.a, this.f7212b) : (b) invokeV.objValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("master")) {
                String substring = str.substring(6);
                if (TextUtils.isDigitsOnly(substring)) {
                    try {
                        i = Integer.parseInt(substring);
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    return i >= 1000;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            synchronized (this) {
                if (bundle == null) {
                    return;
                }
                this.f7215e.add(bundle);
                if (f7210f) {
                    Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ProcessUtils.isMainProcess()) {
            c.a.n0.a.o1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(c.a.n0.a.o1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            synchronized (this) {
                if (this.f7215e.size() <= 0) {
                    return;
                }
                if (f7210f) {
                    Log.d("PreCodeCacheManager", "send msg from cache");
                }
                for (Bundle bundle : this.f7215e) {
                    o(cVar, bundle);
                }
                this.f7215e.clear();
            }
        }
    }

    public final void o(c.a.n0.a.o1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, bundle) == null) {
            c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
            c.a.n0.a.o1.c.c cVar2 = new c.a.n0.a.o1.c.c(130, bundle);
            cVar2.b(cVar.f5627b);
            e2.h(cVar2);
            if (f7210f) {
                Log.d("PreCodeCacheManager", "current process - " + cVar.f5627b.index);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.a.size() <= 0 || this.f7212b.get() >= this.f7213c) {
            return;
        }
        if (this.f7212b.incrementAndGet() > this.f7213c) {
            this.f7212b.decrementAndGet();
            return;
        }
        j().g();
        if (f7210f) {
            Log.d("PreCodeCacheManager", "start a new code cache fill task");
            Log.d("PreCodeCacheManager", "master size - " + this.f7212b.get());
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f7214d = true;
            p();
        }
    }

    @Override // c.a.n0.a.o1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }
}
