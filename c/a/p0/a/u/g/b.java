package c.a.p0.a.u.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import c.a.p0.a.k2.e;
import c.a.p0.a.p2.q;
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
    public static final boolean f7675i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f7676j;
    public static final String k;
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
    public f f7677b;

    /* renamed from: c  reason: collision with root package name */
    public c f7678c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0477b f7679d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f7680e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7681f;

    /* renamed from: g  reason: collision with root package name */
    public int f7682g;

    /* renamed from: h  reason: collision with root package name */
    public int f7683h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.a.u.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0477b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7684e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7685f;

        public RunnableC0477b(b bVar) {
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
            this.f7685f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7684e = true;
                String a = c.a.p0.a.u.g.d.a();
                if (!TextUtils.isEmpty(a)) {
                    this.f7685f.f7680e.put("cpu", a);
                }
                this.f7684e = false;
            }
        }

        public /* synthetic */ RunnableC0477b(b bVar, a aVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1180361554, "Lc/a/p0/a/u/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1180361554, "Lc/a/p0/a/u/g/b$d;");
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f7680e == null) {
                return;
            }
            this.a.f();
            this.a.f7680e.put("mem", Long.valueOf(((ActivityManager) c.a.p0.a.s0.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.a.a != null) {
                this.a.a.sendEmptyMessageDelayed(0, this.a.f7682g);
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
        public final /* synthetic */ b f7689e;

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
            this.f7689e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(Set<c.a.p0.a.k2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (c.a.p0.a.k2.c<?> cVar : set) {
                this.f7689e.f7680e.put(cVar.a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-7710254, "Lc/a/p0/a/u/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-7710254, "Lc/a/p0/a/u/g/b;");
                return;
            }
        }
        f7675i = c.a.p0.a.a.a;
        f7676j = c.a.p0.a.k2.d.f6425d.a;
        k = c.a.p0.a.k2.d.f6423b.a;
        l = c.a.p0.a.k2.d.f6424c.a;
        String str = c.a.p0.a.k2.d.f6428g.a;
        m = c.a.p0.a.k2.d.f6430i.a;
        n = c.a.p0.a.k2.d.f6426e.a;
        o = c.a.p0.a.k2.d.f6427f.a;
        p = c.a.p0.a.k2.d.f6429h.a;
        q = c.a.p0.a.k2.d.f6431j.a;
        r = c.a.p0.a.k2.d.k.a;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7679d.f7684e) {
            return;
        }
        q.k(this.f7679d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f7683h++;
            j();
            return this.f7680e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f7683h - 1;
            this.f7683h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f7681f) {
                boolean z = f7675i;
                return;
            }
            this.f7681f = true;
            this.f7678c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f7678c);
            this.f7679d = new RunnableC0477b(this, null);
            this.f7677b = new f(this, null);
            c.a.p0.a.k2.e.a().g(this.f7677b, c.a.p0.a.k2.d.f6425d, c.a.p0.a.k2.d.f6423b, c.a.p0.a.k2.d.f6424c, c.a.p0.a.k2.d.f6430i, c.a.p0.a.k2.d.f6426e, c.a.p0.a.k2.d.f6427f, c.a.p0.a.k2.d.f6428g, c.a.p0.a.k2.d.f6429h, c.a.p0.a.k2.d.f6431j, c.a.p0.a.k2.d.k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f7675i;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f7681f) {
                boolean z = f7675i;
                return;
            }
            this.f7681f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.f7677b != null) {
                c.a.p0.a.k2.e.a().j(this.f7677b, new c.a.p0.a.k2.c[0]);
                this.f7677b = null;
            }
            this.f7678c = null;
            this.f7679d = null;
            boolean z2 = f7675i;
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
        this.f7680e = new ConcurrentHashMap();
        this.f7682g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f7686e;

        /* renamed from: f  reason: collision with root package name */
        public int f7687f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f7688g;

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
            this.f7688g = bVar;
            this.f7686e = -1L;
            this.f7687f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f7688g.f7681f) {
                long j3 = this.f7686e;
                if (j3 > 0 && this.f7687f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f7687f = i2;
                    this.f7688g.f7680e.put(ExecutionState.FRAME, Integer.valueOf(i2));
                }
                this.f7686e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
