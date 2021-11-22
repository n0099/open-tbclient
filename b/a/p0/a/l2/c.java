package b.a.p0.a.l2;

import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.g.e;
import b.a.p0.a.k;
import b.a.p0.a.p0.f.f;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6993a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f6994b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f6995c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.p0.a.l2.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0304a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f6996e;

            public RunnableC0304a(a aVar, b bVar) {
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
                this.f6996e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().postFrameCallback(this.f6996e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final ExecutorService f6997e;

            /* renamed from: f  reason: collision with root package name */
            public final AtomicInteger f6998f;

            /* renamed from: g  reason: collision with root package name */
            public final List<Float> f6999g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f7000h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f7001i;
            public final /* synthetic */ Timer j;
            public final /* synthetic */ b.a.p0.a.l2.b k;
            public final /* synthetic */ boolean l;
            public final /* synthetic */ b m;

            /* renamed from: b.a.p0.a.l2.c$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0305a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f7002e;

                public RunnableC0305a(b bVar) {
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
                    this.f7002e = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        float b2 = b.a.p0.a.e0.g.d.b();
                        this.f7002e.k.f6980d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.f7002e;
                        bVar.k.f6981e.add(Integer.valueOf(bVar.m.f7004f.get()));
                        this.f7002e.k.f6982f.add(Float.valueOf(b2));
                        e.c i2 = e.i();
                        this.f7002e.k.f6984h.add(Float.valueOf(i2.f4689a));
                        this.f7002e.k.f6985i.add(Float.valueOf(i2.f4690b));
                        this.f7002e.k.f6983g.add(Float.valueOf(i2.f4691c));
                        this.f7002e.f6999g.add(n0.E() ? Float.valueOf(b2) : null);
                    }
                }
            }

            public b(a aVar, boolean z, int i2, Timer timer, b.a.p0.a.l2.b bVar, boolean z2, b bVar2) {
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
                this.f7000h = z;
                this.f7001i = i2;
                this.j = timer;
                this.k = bVar;
                this.l = z2;
                this.m = bVar2;
                this.f6997e = Executors.newCachedThreadPool();
                this.f6998f = new AtomicInteger(0);
                this.f6999g = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f7000h && this.f6998f.getAndIncrement() >= this.f7001i) {
                        c.l(true);
                    }
                    if (!c.f6994b) {
                        this.j.cancel();
                        this.f6997e.shutdown();
                        b.a.p0.a.e0.d.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.k.f6978b = e.e().floatValue();
                        this.k.f6979c = b.a.p0.a.h0.q.b.k().m(b.a.p0.a.d2.d.J().getAppId(), true);
                        this.k.a(this.f6999g);
                        b.a.p0.a.e0.d.i("SwanAppStabilityDataUtil", "采集结果：" + this.k);
                        if (c.f6995c) {
                            b.a.p0.a.e0.d.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.k);
                            c.i(this.k);
                        }
                        if (this.l) {
                            b.a.p0.a.u1.l.a.e(this.k.c());
                            return;
                        }
                        return;
                    }
                    this.f6997e.submit(new RunnableC0305a(this));
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
                b.a.p0.a.l2.b bVar = new b.a.p0.a.l2.b();
                bVar.f6977a = d.d(bVar.f6977a);
                boolean f2 = d.f();
                int c2 = d.c(0);
                boolean z = d.e(0) == 1;
                Timer timer = new Timer();
                b bVar2 = new b(null);
                q0.e0(new RunnableC0304a(this, bVar2));
                timer.schedule(new b(this, f2, c2, timer, bVar, z, bVar2), 0L, bVar.f6977a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1328319339, "Lb/a/p0/a/l2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1328319339, "Lb/a/p0/a/l2/c;");
                return;
            }
        }
        f6993a = k.f6863a;
        f6994b = false;
        f6995c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.g() && e() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f.a() || b.a.p0.a.h0.g.b.c() : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.h() && e() : invokeV.booleanValue;
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
                b.a.p0.a.l2.a.c(jSONObject, str);
            }
        }
    }

    public static void i(b.a.p0.a.l2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            Map<String, String> d2 = bVar.d();
            if (f6993a) {
                String str = "#sendJsMessage data=" + JSONObject.wrap(d2);
            }
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("sendStabilityData", d2));
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "0" : "1");
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("toggleStabilityTestStatus", hashMap));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (f6994b) {
                b.a.p0.a.e0.d.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            f6994b = true;
            b.a.p0.a.e0.d.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f6995c = z;
            f6994b = false;
            d.b();
            b.a.p0.a.e0.d.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f7003e;

        /* renamed from: f  reason: collision with root package name */
        public AtomicInteger f7004f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7005e;

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
                this.f7005e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().removeFrameCallback(this.f7005e);
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
            this.f7003e = -1L;
            this.f7004f = new AtomicInteger(-1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (!c.f6994b) {
                    q0.e0(new a(this));
                    return;
                }
                long j2 = this.f7003e;
                if (j2 > 0 && this.f7004f.get() != (i2 = (int) (1.0E9d / (j - j2)))) {
                    this.f7004f.set(i2);
                    b.a.p0.a.e0.d.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.f7004f);
                }
                this.f7003e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
