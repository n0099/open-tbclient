package c.a.r0.a.l2;

import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.g.e;
import c.a.r0.a.k;
import c.a.r0.a.p0.f.f;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f7823b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f7824c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.r0.a.l2.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0444a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7825e;

            public RunnableC0444a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7825e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().postFrameCallback(this.f7825e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final ExecutorService f7826e;

            /* renamed from: f  reason: collision with root package name */
            public final AtomicInteger f7827f;

            /* renamed from: g  reason: collision with root package name */
            public final List<Float> f7828g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f7829h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f7830i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Timer f7831j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.l2.b f7832k;
            public final /* synthetic */ boolean l;
            public final /* synthetic */ b m;

            /* renamed from: c.a.r0.a.l2.c$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0445a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f7833e;

                public RunnableC0445a(b bVar) {
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
                    this.f7833e = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        float b2 = c.a.r0.a.e0.g.d.b();
                        this.f7833e.f7832k.f7810d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.f7833e;
                        bVar.f7832k.f7811e.add(Integer.valueOf(bVar.m.f7835f.get()));
                        this.f7833e.f7832k.f7812f.add(Float.valueOf(b2));
                        e.c i2 = e.i();
                        this.f7833e.f7832k.f7814h.add(Float.valueOf(i2.a));
                        this.f7833e.f7832k.f7815i.add(Float.valueOf(i2.f5849b));
                        this.f7833e.f7832k.f7813g.add(Float.valueOf(i2.f5850c));
                        this.f7833e.f7828g.add(n0.E() ? Float.valueOf(b2) : null);
                    }
                }
            }

            public b(a aVar, boolean z, int i2, Timer timer, c.a.r0.a.l2.b bVar, boolean z2, b bVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z), Integer.valueOf(i2), timer, bVar, Boolean.valueOf(z2), bVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7829h = z;
                this.f7830i = i2;
                this.f7831j = timer;
                this.f7832k = bVar;
                this.l = z2;
                this.m = bVar2;
                this.f7826e = Executors.newCachedThreadPool();
                this.f7827f = new AtomicInteger(0);
                this.f7828g = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f7829h && this.f7827f.getAndIncrement() >= this.f7830i) {
                        c.l(true);
                    }
                    if (!c.f7823b) {
                        this.f7831j.cancel();
                        this.f7826e.shutdown();
                        c.a.r0.a.e0.d.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.f7832k.f7808b = e.e().floatValue();
                        this.f7832k.f7809c = c.a.r0.a.h0.q.b.k().m(c.a.r0.a.d2.d.J().getAppId(), true);
                        this.f7832k.a(this.f7828g);
                        c.a.r0.a.e0.d.i("SwanAppStabilityDataUtil", "采集结果：" + this.f7832k);
                        if (c.f7824c) {
                            c.a.r0.a.e0.d.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.f7832k);
                            c.i(this.f7832k);
                        }
                        if (this.l) {
                            c.a.r0.a.u1.l.a.e(this.f7832k.c());
                            return;
                        }
                        return;
                    }
                    this.f7826e.submit(new RunnableC0445a(this));
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.l2.b bVar = new c.a.r0.a.l2.b();
                bVar.a = d.d(bVar.a);
                boolean f2 = d.f();
                int c2 = d.c(0);
                boolean z = d.e(0) == 1;
                Timer timer = new Timer();
                b bVar2 = new b(null);
                q0.e0(new RunnableC0444a(this, bVar2));
                timer.schedule(new b(this, f2, c2, timer, bVar, z, bVar2), 0L, bVar.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(429733704, "Lc/a/r0/a/l2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(429733704, "Lc/a/r0/a/l2/c;");
                return;
            }
        }
        a = k.a;
        f7823b = false;
        f7824c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.g() && e() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f.a() || c.a.r0.a.h0.g.b.c() : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? d.h() && e() : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f() : invokeV.booleanValue;
    }

    public static synchronized void h(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, str) == null) {
            synchronized (c.class) {
                c.a.r0.a.l2.a.c(jSONObject, str);
            }
        }
    }

    public static void i(c.a.r0.a.l2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            Map<String, String> d2 = bVar.d();
            if (a) {
                String str = "#sendJsMessage data=" + JSONObject.wrap(d2);
            }
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("sendStabilityData", d2));
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "0" : "1");
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("toggleStabilityTestStatus", hashMap));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (f7823b) {
                c.a.r0.a.e0.d.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            f7823b = true;
            c.a.r0.a.e0.d.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f7824c = z;
            f7823b = false;
            d.b();
            c.a.r0.a.e0.d.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f7834e;

        /* renamed from: f  reason: collision with root package name */
        public AtomicInteger f7835f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7836e;

            public a(b bVar) {
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
                this.f7836e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().removeFrameCallback(this.f7836e);
                }
            }
        }

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
                    return;
                }
            }
            this.f7834e = -1L;
            this.f7835f = new AtomicInteger(-1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                if (!c.f7823b) {
                    q0.e0(new a(this));
                    return;
                }
                long j3 = this.f7834e;
                if (j3 > 0 && this.f7835f.get() != (i2 = (int) (1.0E9d / (j2 - j3)))) {
                    this.f7835f.set(i2);
                    c.a.r0.a.e0.d.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.f7835f);
                }
                this.f7834e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
