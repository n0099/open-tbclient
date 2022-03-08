package c.a.p0.a.b2;

import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f0.f.f;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.u.g.e;
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
    public static volatile boolean f4623b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f4624c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.a.b2.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0230a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f4625e;

            public RunnableC0230a(a aVar, b bVar) {
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
                this.f4625e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().postFrameCallback(this.f4625e);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final ExecutorService f4626e;

            /* renamed from: f  reason: collision with root package name */
            public final AtomicInteger f4627f;

            /* renamed from: g  reason: collision with root package name */
            public final List<Float> f4628g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f4629h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ int f4630i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ Timer f4631j;
            public final /* synthetic */ c.a.p0.a.b2.b k;
            public final /* synthetic */ boolean l;
            public final /* synthetic */ b m;

            /* renamed from: c.a.p0.a.b2.c$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0231a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f4632e;

                public RunnableC0231a(b bVar) {
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
                    this.f4632e = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        float b2 = c.a.p0.a.u.g.d.b();
                        this.f4632e.k.f4610d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.f4632e;
                        bVar.k.f4611e.add(Integer.valueOf(bVar.m.f4634f.get()));
                        this.f4632e.k.f4612f.add(Float.valueOf(b2));
                        e.c i2 = e.i();
                        this.f4632e.k.f4614h.add(Float.valueOf(i2.a));
                        this.f4632e.k.f4615i.add(Float.valueOf(i2.f7696b));
                        this.f4632e.k.f4613g.add(Float.valueOf(i2.f7697c));
                        this.f4632e.f4628g.add(n0.E() ? Float.valueOf(b2) : null);
                    }
                }
            }

            public b(a aVar, boolean z, int i2, Timer timer, c.a.p0.a.b2.b bVar, boolean z2, b bVar2) {
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
                this.f4629h = z;
                this.f4630i = i2;
                this.f4631j = timer;
                this.k = bVar;
                this.l = z2;
                this.m = bVar2;
                this.f4626e = Executors.newCachedThreadPool();
                this.f4627f = new AtomicInteger(0);
                this.f4628g = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f4629h && this.f4627f.getAndIncrement() >= this.f4630i) {
                        c.l(true);
                    }
                    if (!c.f4623b) {
                        this.f4631j.cancel();
                        this.f4626e.shutdown();
                        c.a.p0.a.u.d.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.k.f4608b = e.e().floatValue();
                        this.k.f4609c = c.a.p0.a.x.q.b.k().m(c.a.p0.a.t1.d.J().getAppId(), true);
                        this.k.a(this.f4628g);
                        c.a.p0.a.u.d.i("SwanAppStabilityDataUtil", "采集结果：" + this.k);
                        if (c.f4624c) {
                            c.a.p0.a.u.d.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.k);
                            c.i(this.k);
                        }
                        if (this.l) {
                            c.a.p0.a.k1.l.a.e(this.k.c());
                            return;
                        }
                        return;
                    }
                    this.f4626e.submit(new RunnableC0231a(this));
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
                c.a.p0.a.b2.b bVar = new c.a.p0.a.b2.b();
                bVar.a = d.d(bVar.a);
                boolean f2 = d.f();
                int c2 = d.c(0);
                boolean z = d.e(0) == 1;
                Timer timer = new Timer();
                b bVar2 = new b(null);
                q0.e0(new RunnableC0230a(this, bVar2));
                timer.schedule(new b(this, f2, c2, timer, bVar, z, bVar2), 0L, bVar.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(813525504, "Lc/a/p0/a/b2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(813525504, "Lc/a/p0/a/b2/c;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f4623b = false;
        f4624c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.g() && e() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f.a() || c.a.p0.a.x.g.b.c() : invokeV.booleanValue;
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
                c.a.p0.a.b2.a.c(jSONObject, str);
            }
        }
    }

    public static void i(c.a.p0.a.b2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            Map<String, String> d2 = bVar.d();
            if (a) {
                String str = "#sendJsMessage data=" + JSONObject.wrap(d2);
            }
            c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.c("sendStabilityData", d2));
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "0" : "1");
            c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.c("toggleStabilityTestStatus", hashMap));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (f4623b) {
                c.a.p0.a.u.d.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            f4623b = true;
            c.a.p0.a.u.d.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f4624c = z;
            f4623b = false;
            d.b();
            c.a.p0.a.u.d.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f4633e;

        /* renamed from: f  reason: collision with root package name */
        public AtomicInteger f4634f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f4635e;

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
                this.f4635e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().removeFrameCallback(this.f4635e);
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
            this.f4633e = -1L;
            this.f4634f = new AtomicInteger(-1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                if (!c.f4623b) {
                    q0.e0(new a(this));
                    return;
                }
                long j3 = this.f4633e;
                if (j3 > 0 && this.f4634f.get() != (i2 = (int) (1.0E9d / (j2 - j3)))) {
                    this.f4634f.set(i2);
                    c.a.p0.a.u.d.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.f4634f);
                }
                this.f4633e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
