package c.a.p0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import c.a.p0.a.k;
import c.a.p0.a.u2.e;
import c.a.p0.a.z2.q;
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
    public static final boolean f4783i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f4784j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f4785k;
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
    public f f4786b;

    /* renamed from: c  reason: collision with root package name */
    public c f4787c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0210b f4788d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f4789e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4790f;

    /* renamed from: g  reason: collision with root package name */
    public int f4791g;

    /* renamed from: h  reason: collision with root package name */
    public int f4792h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0210b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4794f;

        public RunnableC0210b(b bVar) {
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
            this.f4794f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4793e = true;
                String a = c.a.p0.a.e0.g.d.a();
                if (!TextUtils.isEmpty(a)) {
                    this.f4794f.f4789e.put("cpu", a);
                }
                this.f4793e = false;
            }
        }

        public /* synthetic */ RunnableC0210b(b bVar, a aVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1931134350, "Lc/a/p0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1931134350, "Lc/a/p0/a/e0/g/b$d;");
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f4789e == null) {
                return;
            }
            this.a.f();
            this.a.f4789e.put("mem", Long.valueOf(((ActivityManager) c.a.p0.a.c1.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.a.a != null) {
                this.a.a.sendEmptyMessageDelayed(0, this.a.f4791g);
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
        public final /* synthetic */ b f4798e;

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
            this.f4798e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Set<c.a.p0.a.u2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (c.a.p0.a.u2.c<?> cVar : set) {
                this.f4798e.f4789e.put(cVar.a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575642354, "Lc/a/p0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575642354, "Lc/a/p0/a/e0/g/b;");
                return;
            }
        }
        f4783i = k.a;
        f4784j = c.a.p0.a.u2.d.f8620d.a;
        f4785k = c.a.p0.a.u2.d.f8618b.a;
        l = c.a.p0.a.u2.d.f8619c.a;
        String str = c.a.p0.a.u2.d.f8623g.a;
        m = c.a.p0.a.u2.d.f8625i.a;
        n = c.a.p0.a.u2.d.f8621e.a;
        o = c.a.p0.a.u2.d.f8622f.a;
        p = c.a.p0.a.u2.d.f8624h.a;
        q = c.a.p0.a.u2.d.f8626j.a;
        r = c.a.p0.a.u2.d.f8627k.a;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4788d.f4793e) {
            return;
        }
        q.k(this.f4788d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f4792h++;
            j();
            return this.f4789e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f4792h - 1;
            this.f4792h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f4790f) {
                boolean z = f4783i;
                return;
            }
            this.f4790f = true;
            this.f4787c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f4787c);
            this.f4788d = new RunnableC0210b(this, null);
            this.f4786b = new f(this, null);
            c.a.p0.a.u2.e.a().g(this.f4786b, c.a.p0.a.u2.d.f8620d, c.a.p0.a.u2.d.f8618b, c.a.p0.a.u2.d.f8619c, c.a.p0.a.u2.d.f8625i, c.a.p0.a.u2.d.f8621e, c.a.p0.a.u2.d.f8622f, c.a.p0.a.u2.d.f8623g, c.a.p0.a.u2.d.f8624h, c.a.p0.a.u2.d.f8626j, c.a.p0.a.u2.d.f8627k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f4783i;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f4790f) {
                boolean z = f4783i;
                return;
            }
            this.f4790f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.f4786b != null) {
                c.a.p0.a.u2.e.a().j(this.f4786b, new c.a.p0.a.u2.c[0]);
                this.f4786b = null;
            }
            this.f4787c = null;
            this.f4788d = null;
            boolean z2 = f4783i;
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
        this.f4789e = new ConcurrentHashMap();
        this.f4791g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f4795e;

        /* renamed from: f  reason: collision with root package name */
        public int f4796f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4797g;

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
            this.f4797g = bVar;
            this.f4795e = -1L;
            this.f4796f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f4797g.f4790f) {
                long j3 = this.f4795e;
                if (j3 > 0 && this.f4796f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f4796f = i2;
                    this.f4797g.f4789e.put(ExecutionState.FRAME, Integer.valueOf(i2));
                }
                this.f4795e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
