package c.a.r0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import c.a.r0.a.k;
import c.a.r0.a.u2.e;
import c.a.r0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.ExecutionState;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5827i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f5828j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f5829k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public f f5830b;

    /* renamed from: c  reason: collision with root package name */
    public c f5831c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0294b f5832d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f5833e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5834f;

    /* renamed from: g  reason: collision with root package name */
    public int f5835g;

    /* renamed from: h  reason: collision with root package name */
    public int f5836h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0294b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5838f;

        public RunnableC0294b(b bVar) {
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
            this.f5838f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5837e = true;
                String a = c.a.r0.a.e0.g.d.a();
                if (!TextUtils.isEmpty(a)) {
                    this.f5838f.f5833e.put("cpu", a);
                }
                this.f5837e = false;
            }
        }

        public /* synthetic */ RunnableC0294b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(920017100, "Lc/a/r0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(920017100, "Lc/a/r0/a/e0/g/b$d;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
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
            this.a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f5833e == null) {
                return;
            }
            this.a.f();
            this.a.f5833e.put("mem", Long.valueOf(((ActivityManager) c.a.r0.a.c1.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.a.a != null) {
                this.a.a.sendEmptyMessageDelayed(0, this.a.f5835g);
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class f implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5842e;

        public f(b bVar) {
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
            this.f5842e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Set<c.a.r0.a.u2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (c.a.r0.a.u2.c<?> cVar : set) {
                this.f5842e.f5833e.put(cVar.a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317476916, "Lc/a/r0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1317476916, "Lc/a/r0/a/e0/g/b;");
                return;
            }
        }
        f5827i = k.a;
        f5828j = c.a.r0.a.u2.d.f9664d.a;
        f5829k = c.a.r0.a.u2.d.f9662b.a;
        l = c.a.r0.a.u2.d.f9663c.a;
        String str = c.a.r0.a.u2.d.f9667g.a;
        m = c.a.r0.a.u2.d.f9669i.a;
        n = c.a.r0.a.u2.d.f9665e.a;
        o = c.a.r0.a.u2.d.f9666f.a;
        p = c.a.r0.a.u2.d.f9668h.a;
        q = c.a.r0.a.u2.d.f9670j.a;
        r = c.a.r0.a.u2.d.f9671k.a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.a : (b) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5832d.f5837e) {
            return;
        }
        q.k(this.f5832d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f5836h++;
            j();
            return this.f5833e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f5836h - 1;
            this.f5836h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f5834f) {
                boolean z = f5827i;
                return;
            }
            this.f5834f = true;
            this.f5831c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f5831c);
            this.f5832d = new RunnableC0294b(this, null);
            this.f5830b = new f(this, null);
            c.a.r0.a.u2.e.a().g(this.f5830b, c.a.r0.a.u2.d.f9664d, c.a.r0.a.u2.d.f9662b, c.a.r0.a.u2.d.f9663c, c.a.r0.a.u2.d.f9669i, c.a.r0.a.u2.d.f9665e, c.a.r0.a.u2.d.f9666f, c.a.r0.a.u2.d.f9667g, c.a.r0.a.u2.d.f9668h, c.a.r0.a.u2.d.f9670j, c.a.r0.a.u2.d.f9671k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f5827i;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f5834f) {
                boolean z = f5827i;
                return;
            }
            this.f5834f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.f5830b != null) {
                c.a.r0.a.u2.e.a().j(this.f5830b, new c.a.r0.a.u2.c[0]);
                this.f5830b = null;
            }
            this.f5831c = null;
            this.f5832d = null;
            boolean z2 = f5827i;
        }
    }

    public b() {
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
        this.f5833e = new ConcurrentHashMap();
        this.f5835g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f5839e;

        /* renamed from: f  reason: collision with root package name */
        public int f5840f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f5841g;

        public c(b bVar) {
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
            this.f5841g = bVar;
            this.f5839e = -1L;
            this.f5840f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f5841g.f5834f) {
                long j3 = this.f5839e;
                if (j3 > 0 && this.f5840f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f5840f = i2;
                    this.f5841g.f5833e.put(ExecutionState.FRAME, Integer.valueOf(i2));
                }
                this.f5839e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
