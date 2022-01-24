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
    public static final boolean f5842i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f5843j;
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
    public f f5844b;

    /* renamed from: c  reason: collision with root package name */
    public c f5845c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0312b f5846d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f5847e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5848f;

    /* renamed from: g  reason: collision with root package name */
    public int f5849g;

    /* renamed from: h  reason: collision with root package name */
    public int f5850h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0312b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5852f;

        public RunnableC0312b(b bVar) {
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
            this.f5852f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5851e = true;
                String a = c.a.r0.a.e0.g.d.a();
                if (!TextUtils.isEmpty(a)) {
                    this.f5852f.f5847e.put("cpu", a);
                }
                this.f5851e = false;
            }
        }

        public /* synthetic */ RunnableC0312b(b bVar, a aVar) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.f5847e == null) {
                return;
            }
            this.a.f();
            this.a.f5847e.put("mem", Long.valueOf(((ActivityManager) c.a.r0.a.c1.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.a.a != null) {
                this.a.a.sendEmptyMessageDelayed(0, this.a.f5849g);
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
        public final /* synthetic */ b f5856e;

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
            this.f5856e = bVar;
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
                this.f5856e.f5847e.put(cVar.a, cVar.a());
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
        f5842i = k.a;
        f5843j = c.a.r0.a.u2.d.f9597d.a;
        k = c.a.r0.a.u2.d.f9595b.a;
        l = c.a.r0.a.u2.d.f9596c.a;
        String str = c.a.r0.a.u2.d.f9600g.a;
        m = c.a.r0.a.u2.d.f9602i.a;
        n = c.a.r0.a.u2.d.f9598e.a;
        o = c.a.r0.a.u2.d.f9599f.a;
        p = c.a.r0.a.u2.d.f9601h.a;
        q = c.a.r0.a.u2.d.f9603j.a;
        r = c.a.r0.a.u2.d.k.a;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5846d.f5851e) {
            return;
        }
        q.k(this.f5846d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f5850h++;
            j();
            return this.f5847e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f5850h - 1;
            this.f5850h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f5848f) {
                boolean z = f5842i;
                return;
            }
            this.f5848f = true;
            this.f5845c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f5845c);
            this.f5846d = new RunnableC0312b(this, null);
            this.f5844b = new f(this, null);
            c.a.r0.a.u2.e.a().g(this.f5844b, c.a.r0.a.u2.d.f9597d, c.a.r0.a.u2.d.f9595b, c.a.r0.a.u2.d.f9596c, c.a.r0.a.u2.d.f9602i, c.a.r0.a.u2.d.f9598e, c.a.r0.a.u2.d.f9599f, c.a.r0.a.u2.d.f9600g, c.a.r0.a.u2.d.f9601h, c.a.r0.a.u2.d.f9603j, c.a.r0.a.u2.d.k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f5842i;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f5848f) {
                boolean z = f5842i;
                return;
            }
            this.f5848f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.f5844b != null) {
                c.a.r0.a.u2.e.a().j(this.f5844b, new c.a.r0.a.u2.c[0]);
                this.f5844b = null;
            }
            this.f5845c = null;
            this.f5846d = null;
            boolean z2 = f5842i;
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
        this.f5847e = new ConcurrentHashMap();
        this.f5849g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f5853e;

        /* renamed from: f  reason: collision with root package name */
        public int f5854f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f5855g;

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
            this.f5855g = bVar;
            this.f5853e = -1L;
            this.f5854f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f5855g.f5848f) {
                long j3 = this.f5853e;
                if (j3 > 0 && this.f5854f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f5854f = i2;
                    this.f5855g.f5847e.put(ExecutionState.FRAME, Integer.valueOf(i2));
                }
                this.f5853e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
