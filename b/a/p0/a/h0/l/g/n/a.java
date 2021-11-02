package b.a.p0.a.h0.l.g.n;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.h0.d.a;
import b.a.p0.a.h0.l.e;
import b.a.p0.a.h0.l.g.j;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.h2.d;
import b.a.p0.a.k;
import b.a.p0.a.l0.g;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
public class a implements b.a.p0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5476g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f5477h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<PrefetchEvent> f5478a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f5479b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5480c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5481d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5482e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Bundle> f5483f;

    /* renamed from: b.a.p0.a.h0.l.g.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0218a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f5484e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5485f;

        /* renamed from: g  reason: collision with root package name */
        public final BlockingQueue<PrefetchEvent> f5486g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f5487h;

        /* renamed from: i  reason: collision with root package name */
        public c f5488i;
        public int j;

        public b(int i2, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), blockingQueue, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = 0;
            this.f5484e = i2 <= 0 ? 30 : i2;
            this.f5485f = false;
            this.f5486g = blockingQueue;
            this.f5487h = atomicInteger;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5485f = true;
                this.f5487h.decrementAndGet();
                b();
                boolean z = a.f5476g;
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c cVar = this.f5488i;
                if (cVar != null) {
                    cVar.k();
                    this.f5488i = null;
                }
                boolean z = a.f5476g;
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
                if (this.f5488i == null) {
                    this.f5488i = d();
                }
                if (this.f5488i == null) {
                    a();
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.f5488i.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
                countDownLatch.await(3L, TimeUnit.SECONDS);
                f();
            }
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (g.M().a0() && e()) {
                    return new c(null);
                }
                boolean z = a.f5476g;
                return null;
            }
            return (c) invokeV.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean c2 = g.t.c();
                String Q = g.M().Q();
                return g.M().h0() && c2 && (!TextUtils.isEmpty(Q) && new File(Q).exists()) && d.c().b();
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.j + 1;
                this.j = i2;
                if (i2 >= 10) {
                    this.j = 0;
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
                while (!this.f5485f) {
                    try {
                        try {
                            PrefetchEvent poll = this.f5486g.poll(this.f5484e, TimeUnit.SECONDS);
                            if (poll == null) {
                                a();
                            } else {
                                c(poll);
                            }
                        } catch (InterruptedException e2) {
                            if (a.f5476g) {
                                e2.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (a.f5476g) {
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
        public static final AtomicInteger f5489e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f5490a;

        /* renamed from: b  reason: collision with root package name */
        public volatile b.a.p0.a.h0.l.a f5491b;

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f5492c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f5493d;

        /* renamed from: b.a.p0.a.h0.l.g.n.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0219a implements j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f5494a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PrefetchEvent f5495b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f5496c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f5497d;

            public C0219a(c cVar, String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, prefetchEvent, countDownLatch};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5497d = cVar;
                this.f5494a = str;
                this.f5495b = prefetchEvent;
                this.f5496c = countDownLatch;
            }

            @Override // b.a.p0.a.h0.l.g.j
            public void onReady() {
                b.a.p0.a.h0.f.a f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f5497d.f5491b != null && (f2 = this.f5497d.f5491b.f()) != null && !f2.isDestroyed()) {
                        this.f5497d.s(this.f5494a, f2);
                        this.f5497d.r(f2, this.f5495b);
                        if (a.f5476g) {
                            String str = "fill code cache finish for - " + this.f5494a;
                        }
                    }
                    CountDownLatch countDownLatch = this.f5496c;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends b.a.p0.a.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f5498a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f5499b;

            public b(c cVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5499b = cVar;
                this.f5498a = j;
            }

            @Override // b.a.p0.a.h0.b
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (a.f5476g) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String str2 = "create a new master cost - " + (currentTimeMillis - this.f5498a) + "ms";
                    }
                    super.a(str);
                    this.f5499b.f5490a = true;
                    this.f5499b.q();
                }
            }
        }

        /* renamed from: b.a.p0.a.h0.l.g.n.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0220c extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c k;

            /* renamed from: b.a.p0.a.h0.l.g.n.a$c$c$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0221a extends b.a.p0.a.h0.l.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0220c f5500e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0221a(C0220c c0220c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0220c, str, str2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5500e = c0220c;
                }

                @Override // b.a.p0.a.h0.l.d
                public b.a.p0.a.l0.g e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        g.b bVar = new g.b();
                        bVar.c(1);
                        bVar.b(this.f5500e.k.n());
                        return bVar.a();
                    }
                    return (b.a.p0.a.l0.g) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0220c(c cVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.k = cVar;
            }

            @Override // b.a.p0.a.h0.l.e
            public b.a.p0.a.h0.l.d j(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new C0221a(this, str, "runtime/index.js") : (b.a.p0.a.h0.l.d) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638772552, "Lb/a/p0/a/h0/l/g/n/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1638772552, "Lb/a/p0/a/h0/l/g/n/a$c;");
                    return;
                }
            }
            f5489e = new AtomicInteger(1000);
        }

        public /* synthetic */ c(C0218a c0218a) {
            this();
        }

        public final synchronized void g(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                synchronized (this) {
                    if (jVar == null) {
                        return;
                    }
                    if (this.f5490a) {
                        jVar.onReady();
                        return;
                    }
                    if (!this.f5492c.contains(jVar)) {
                        this.f5492c.add(jVar);
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
                    String m = b.a.p0.a.a1.e.m(new File(file, "app.json"));
                    prefetchEvent.appConfig = m;
                    hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m);
                    SwanAppConfigData c2 = SwanAppConfigData.c(prefetchEvent.appConfig, file);
                    if (c2 == null || p(c2)) {
                        return null;
                    }
                    String e2 = c2.e();
                    prefetchEvent.pageUrl = e2;
                    hashMap.put("pageUrl", e2);
                    String f2 = o0.f(prefetchEvent.pageUrl);
                    String o = o0.o(prefetchEvent.pageUrl);
                    String c3 = b.a.p0.a.c2.f.p0.j.c(f2, c2);
                    if (!TextUtils.equals(f2, c3)) {
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

        public final b.a.p0.a.h0.l.a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long currentTimeMillis = a.f5476g ? System.currentTimeMillis() : 0L;
                b.a.p0.a.h0.l.a j = j();
                j.loadUrl(o0.w(b.a.p0.a.h0.u.g.M().Q()));
                j.c(new b(this, currentTimeMillis));
                return j;
            }
            return (b.a.p0.a.h0.l.a) invokeV.objValue;
        }

        public final b.a.p0.a.h0.l.a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C0220c(this, AppRuntime.getAppContext()) : (b.a.p0.a.h0.l.a) invokeV.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f5491b == null) {
                return;
            }
            this.f5491b.destroy();
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, prefetchEvent, countDownLatch) == null) {
                if (this.f5491b == null) {
                    this.f5491b = i();
                }
                this.f5493d.add(str);
                g(new C0219a(this, str, prefetchEvent, countDownLatch));
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
                arrayList.addAll(this.f5493d);
                a.C0193a a2 = a.b.a();
                codeCacheSetting.maxCount = a2.f5169a;
                codeCacheSetting.sizeLimit = a2.f5170b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f5171c;
                return codeCacheSetting;
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = "master" + f5489e.getAndIncrement();
                if (a.f5476g) {
                    String str2 = "code cache master id - " + str;
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
                return b.a.p0.a.a1.e.z(file) && b.a.p0.a.a1.e.y(file);
            }
            return invokeL.booleanValue;
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, swanAppConfigData)) == null) {
                String str = swanAppConfigData.m;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    return new JSONObject(str).has("_modules");
                } catch (JSONException e2) {
                    if (a.f5476g) {
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
                    for (j jVar : this.f5492c) {
                        if (jVar != null) {
                            jVar.onReady();
                        }
                    }
                    this.f5492c.clear();
                }
            }
        }

        public final void r(@NonNull b.a.p0.a.h0.f.a aVar, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, prefetchEvent) == null) {
                long currentTimeMillis = a.f5476g ? System.currentTimeMillis() : 0L;
                PrefetchEvent.c h2 = h(prefetchEvent, "preload");
                if (h2 != null) {
                    b.a.p0.a.o0.a.a(aVar, h2);
                    if (a.f5476g) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str = "send code cache msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                    }
                }
            }
        }

        public final void s(String str, b.a.p0.a.h0.f.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, aVar) == null) && (aVar instanceof b.a.p0.a.l0.a)) {
                ((b.a.p0.a.l0.a) aVar).C0(m());
            }
        }

        public c() {
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
            this.f5492c = new ArrayList();
            this.f5493d = new CopyOnWriteArrayList();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15113065, "Lb/a/p0/a/h0/l/g/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-15113065, "Lb/a/p0/a/h0/l/g/n/a;");
                return;
            }
        }
        f5476g = k.f6397a;
    }

    public a() {
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
        this.f5478a = new LinkedBlockingQueue();
        this.f5479b = new AtomicInteger(0);
        this.f5480c = 1;
        this.f5483f = new ArrayList();
        b.a.p0.a.c1.a.Z().getSwitch("swan_preset_code_cache", 0);
        this.f5482e = 0;
        m();
        b.a.p0.a.e0.d.h("PreCodeCacheManager", "swan_preset_code_cache - " + this.f5482e);
        if (f5476g) {
            String str = "max master size - " + this.f5480c;
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5477h == null) {
                synchronized (a.class) {
                    if (f5477h == null) {
                        f5477h = new a();
                    }
                }
            }
            return f5477h;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.v1.c.f.a
    public void a(String str, b.a.p0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && TextUtils.equals(str, "event_puppet_online") && !cVar.C()) {
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
            b2.pageType = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
            return b2;
        }
        return (PrefetchEvent) invokeLL.objValue;
    }

    public final boolean c(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if (!ProcessUtils.isMainProcess() || q0.G() || b.a.p0.a.c1.a.n0().c()) {
                int i2 = this.f5482e;
                if (i2 != 0) {
                    if (i2 == 1) {
                        boolean z2 = f5476g;
                        z = true;
                    } else if (i2 == 2) {
                        boolean z3 = f5476g;
                        z = !b.a.p0.a.c1.a.l0().a();
                    }
                    return !z ? false : false;
                }
                boolean z4 = f5476g;
                z = false;
                return !z ? false : false;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, prefetchEvent) == null) {
            this.f5478a.offer(prefetchEvent);
            if (this.f5481d) {
                p();
            }
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) && c(str, j) && !ProcessUtils.isMainProcess()) {
            if (f5476g) {
                String str2 = "start to fill code cache app - " + str + " , version - " + j;
            }
            d(b(str, e.C0109e.i(str, String.valueOf(j)).getPath() + File.separator));
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) && ProcessUtils.isMainProcess() && c(str, j)) {
            b.a.p0.a.v1.c.f.c h2 = h();
            if (h2 == null) {
                boolean z = f5476g;
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cc_app_id", str);
            bundle.putLong("cc_app_version", j);
            if (h2.H()) {
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

    public final b.a.p0.a.v1.c.f.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.p0.a.v1.c.f.c e2 = b.a.p0.a.v1.c.f.e.k().e();
            if (e2 == null || e2.C()) {
                return null;
            }
            return e2;
        }
        return (b.a.p0.a.v1.c.f.c) invokeV.objValue;
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(30, this.f5478a, this.f5479b) : (b) invokeV.objValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("master")) {
                String substring = str.substring(6);
                if (TextUtils.isDigitsOnly(substring)) {
                    try {
                        i2 = Integer.parseInt(substring);
                    } catch (NumberFormatException unused) {
                        i2 = 0;
                    }
                    return i2 >= 1000;
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
                this.f5483f.add(bundle);
                boolean z = f5476g;
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && ProcessUtils.isMainProcess()) {
            b.a.p0.a.v1.c.f.e.k().b(this);
        }
    }

    public final synchronized void n(b.a.p0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            synchronized (this) {
                if (this.f5483f.size() <= 0) {
                    return;
                }
                boolean z = f5476g;
                for (Bundle bundle : this.f5483f) {
                    o(cVar, bundle);
                }
                this.f5483f.clear();
            }
        }
    }

    public final void o(b.a.p0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, bundle) == null) {
            b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
            b.a.p0.a.v1.c.c cVar2 = new b.a.p0.a.v1.c.c(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, bundle);
            cVar2.b(cVar.f8519f);
            e2.h(cVar2);
            if (f5476g) {
                String str = "current process - " + cVar.f8519f.index;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f5478a.size() <= 0 || this.f5479b.get() >= this.f5480c) {
            return;
        }
        if (this.f5479b.incrementAndGet() > this.f5480c) {
            this.f5479b.decrementAndGet();
            return;
        }
        j().g();
        if (f5476g) {
            String str = "master size - " + this.f5479b.get();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f5481d = true;
            p();
        }
    }

    @Override // b.a.p0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }
}
