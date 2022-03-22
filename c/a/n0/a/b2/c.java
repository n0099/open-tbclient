package c.a.n0.a.b2;

import android.util.Log;
import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f0.f.f;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.u.g.e;
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
    public static volatile boolean f3931b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f3932c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.n0.a.b2.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0218a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0218a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
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
                    Choreographer.getInstance().postFrameCallback(this.a);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ExecutorService a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicInteger f3933b;

            /* renamed from: c  reason: collision with root package name */
            public final List<Float> f3934c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f3935d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f3936e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f3937f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.b2.b f3938g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f3939h;
            public final /* synthetic */ b i;

            /* renamed from: c.a.n0.a.b2.c$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0219a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0219a(b bVar) {
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
                        float b2 = c.a.n0.a.u.g.d.b();
                        this.a.f3938g.f3920d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.a;
                        bVar.f3938g.f3921e.add(Integer.valueOf(bVar.i.f3940b.get()));
                        this.a.f3938g.f3922f.add(Float.valueOf(b2));
                        e.c i = e.i();
                        this.a.f3938g.f3924h.add(Float.valueOf(i.a));
                        this.a.f3938g.i.add(Float.valueOf(i.f6508b));
                        this.a.f3938g.f3923g.add(Float.valueOf(i.f6509c));
                        this.a.f3934c.add(n0.D() ? Float.valueOf(b2) : null);
                    }
                }
            }

            public b(a aVar, boolean z, int i, Timer timer, c.a.n0.a.b2.b bVar, boolean z2, b bVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z), Integer.valueOf(i), timer, bVar, Boolean.valueOf(z2), bVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3935d = z;
                this.f3936e = i;
                this.f3937f = timer;
                this.f3938g = bVar;
                this.f3939h = z2;
                this.i = bVar2;
                this.a = Executors.newCachedThreadPool();
                this.f3933b = new AtomicInteger(0);
                this.f3934c = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f3935d && this.f3933b.getAndIncrement() >= this.f3936e) {
                        c.l(true);
                    }
                    if (!c.f3931b) {
                        this.f3937f.cancel();
                        this.a.shutdown();
                        c.a.n0.a.u.d.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.f3938g.f3918b = e.e().floatValue();
                        this.f3938g.f3919c = c.a.n0.a.x.q.b.k().m(c.a.n0.a.t1.d.J().getAppId(), true);
                        this.f3938g.a(this.f3934c);
                        c.a.n0.a.u.d.i("SwanAppStabilityDataUtil", "采集结果：" + this.f3938g);
                        if (c.f3932c) {
                            c.a.n0.a.u.d.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.f3938g);
                            c.i(this.f3938g);
                        }
                        if (this.f3939h) {
                            c.a.n0.a.k1.l.a.e(this.f3938g.c());
                            return;
                        }
                        return;
                    }
                    this.a.submit(new RunnableC0219a(this));
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.b2.b bVar = new c.a.n0.a.b2.b();
                bVar.a = d.d(bVar.a);
                boolean f2 = d.f();
                int c2 = d.c(0);
                boolean z = d.e(0) == 1;
                Timer timer = new Timer();
                b bVar2 = new b(null);
                q0.e0(new RunnableC0218a(this, bVar2));
                timer.schedule(new b(this, f2, c2, timer, bVar, z, bVar2), 0L, bVar.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1206552514, "Lc/a/n0/a/b2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1206552514, "Lc/a/n0/a/b2/c;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f3931b = false;
        f3932c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.g() && e() : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f.a() || c.a.n0.a.x.g.b.c() : invokeV.booleanValue;
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
                c.a.n0.a.b2.a.c(jSONObject, str);
            }
        }
    }

    public static void i(c.a.n0.a.b2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            Map<String, String> d2 = bVar.d();
            if (a) {
                Log.d("SwanAppStabilityDataUtil", "#sendJsMessage data=" + JSONObject.wrap(d2));
            }
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("sendStabilityData", d2));
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "0" : "1");
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("toggleStabilityTestStatus", hashMap));
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (f3931b) {
                c.a.n0.a.u.d.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            f3931b = true;
            c.a.n0.a.u.d.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f3932c = z;
            f3931b = false;
            d.b();
            c.a.n0.a.u.d.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public AtomicInteger f3940b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
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
                    Choreographer.getInstance().removeFrameCallback(this.a);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1L;
            this.f3940b = new AtomicInteger(-1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (!c.f3931b) {
                    q0.e0(new a(this));
                    return;
                }
                long j2 = this.a;
                if (j2 > 0 && this.f3940b.get() != (i = (int) (1.0E9d / (j - j2)))) {
                    this.f3940b.set(i);
                    c.a.n0.a.u.d.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.f3940b);
                }
                this.a = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
