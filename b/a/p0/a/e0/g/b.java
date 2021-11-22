package b.a.p0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import b.a.p0.a.k;
import b.a.p0.a.u2.e;
import b.a.p0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f4664i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f4665a;

    /* renamed from: b  reason: collision with root package name */
    public f f4666b;

    /* renamed from: c  reason: collision with root package name */
    public c f4667c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0154b f4668d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f4669e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4670f;

    /* renamed from: g  reason: collision with root package name */
    public int f4671g;

    /* renamed from: h  reason: collision with root package name */
    public int f4672h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0154b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4674f;

        public RunnableC0154b(b bVar) {
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
            this.f4674f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4673e = true;
                String a2 = b.a.p0.a.e0.g.d.a();
                if (!TextUtils.isEmpty(a2)) {
                    this.f4674f.f4669e.put("cpu", a2);
                }
                this.f4673e = false;
            }
        }

        public /* synthetic */ RunnableC0154b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f4678a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366760593, "Lb/a/p0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1366760593, "Lb/a/p0/a/e0/g/b$d;");
                    return;
                }
            }
            f4678a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f4679a;

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
            this.f4679a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f4679a.f4669e == null) {
                return;
            }
            this.f4679a.f();
            this.f4679a.f4669e.put("mem", Long.valueOf(((ActivityManager) b.a.p0.a.c1.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f4679a.f4665a != null) {
                this.f4679a.f4665a.sendEmptyMessageDelayed(0, this.f4679a.f4671g);
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
        public final /* synthetic */ b f4680e;

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
            this.f4680e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Set<b.a.p0.a.u2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (b.a.p0.a.u2.c<?> cVar : set) {
                this.f4680e.f4669e.put(cVar.f9125a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065108177, "Lb/a/p0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065108177, "Lb/a/p0/a/e0/g/b;");
                return;
            }
        }
        f4664i = k.f6863a;
        j = b.a.p0.a.u2.d.f9130d.f9125a;
        k = b.a.p0.a.u2.d.f9128b.f9125a;
        l = b.a.p0.a.u2.d.f9129c.f9125a;
        String str = b.a.p0.a.u2.d.f9133g.f9125a;
        m = b.a.p0.a.u2.d.f9135i.f9125a;
        n = b.a.p0.a.u2.d.f9131e.f9125a;
        o = b.a.p0.a.u2.d.f9132f.f9125a;
        p = b.a.p0.a.u2.d.f9134h.f9125a;
        q = b.a.p0.a.u2.d.j.f9125a;
        r = b.a.p0.a.u2.d.k.f9125a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.f4678a : (b) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4668d.f4673e) {
            return;
        }
        q.k(this.f4668d, "swanAppCpuMonitor");
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f4672h++;
            j();
            return this.f4669e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f4672h - 1;
            this.f4672h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f4670f) {
                boolean z = f4664i;
                return;
            }
            this.f4670f = true;
            this.f4667c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f4667c);
            this.f4668d = new RunnableC0154b(this, null);
            this.f4666b = new f(this, null);
            b.a.p0.a.u2.e.a().g(this.f4666b, b.a.p0.a.u2.d.f9130d, b.a.p0.a.u2.d.f9128b, b.a.p0.a.u2.d.f9129c, b.a.p0.a.u2.d.f9135i, b.a.p0.a.u2.d.f9131e, b.a.p0.a.u2.d.f9132f, b.a.p0.a.u2.d.f9133g, b.a.p0.a.u2.d.f9134h, b.a.p0.a.u2.d.j, b.a.p0.a.u2.d.k);
            e eVar = new e(this, null);
            this.f4665a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f4664i;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f4670f) {
                boolean z = f4664i;
                return;
            }
            this.f4670f = false;
            e eVar = this.f4665a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f4665a = null;
            }
            if (this.f4666b != null) {
                b.a.p0.a.u2.e.a().j(this.f4666b, new b.a.p0.a.u2.c[0]);
                this.f4666b = null;
            }
            this.f4667c = null;
            this.f4668d = null;
            boolean z2 = f4664i;
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
        this.f4669e = new ConcurrentHashMap();
        this.f4671g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f4675e;

        /* renamed from: f  reason: collision with root package name */
        public int f4676f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4677g;

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
            this.f4677g = bVar;
            this.f4675e = -1L;
            this.f4676f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.f4677g.f4670f) {
                long j2 = this.f4675e;
                if (j2 > 0 && this.f4676f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f4676f = i2;
                    this.f4677g.f4669e.put("frame", Integer.valueOf(i2));
                }
                this.f4675e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
