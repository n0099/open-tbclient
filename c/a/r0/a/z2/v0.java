package c.a.r0.a.z2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v0 implements c.a.r0.a.z2.g1.c<Exception> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10267i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f10268e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f10269f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f10270g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f10271h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f10272e;

        /* renamed from: c.a.r0.a.z2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0646a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10273e;

            public RunnableC0646a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10273e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (v0.f10267i) {
                        String str = "do updateCore, isStop=" + this.f10273e.f10272e.f10271h;
                    }
                    if (this.f10273e.f10272e.f10271h) {
                        return;
                    }
                    this.f10273e.f10272e.i();
                }
            }
        }

        public a(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10272e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ProcessUtils.isMainProcess()) {
                    this.f10272e.f10271h = false;
                    synchronized (v0.class) {
                        this.f10272e.f10268e = System.currentTimeMillis();
                        if (this.f10272e.f10270g != null) {
                            this.f10272e.f10269f.removeCallbacks(this.f10272e.f10270g);
                        }
                        this.f10272e.f10270g = new RunnableC0646a(this);
                        long a = c.a.r0.q.k.i.n.a(300) * 1000;
                        this.f10272e.f10269f.postDelayed(this.f10272e.f10270g, a);
                        if (v0.f10267i) {
                            String str = "wait next heart beat: " + a;
                        }
                    }
                    return;
                }
                c.a.r0.a.y1.b.e.c(c.class, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f10274e;

        public b(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10274e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.q.b.l(new c.a.r0.q.j.m.i(0), new c.a.r0.a.h0.m.j(this.f10274e, true));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                v0.j().l();
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final v0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1841031651, "Lc/a/r0/a/z2/v0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1841031651, "Lc/a/r0/a/z2/v0$d;");
                    return;
                }
            }
            a = new v0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(837669027, "Lc/a/r0/a/z2/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(837669027, "Lc/a/r0/a/z2/v0;");
                return;
            }
        }
        f10267i = c.a.r0.a.k.a;
    }

    public /* synthetic */ v0(a aVar) {
        this();
    }

    public static v0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.a : (v0) invokeV.objValue;
    }

    @AnyThread
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.l(new b(this), "SwanH2HeartBeatManager");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.z2.g1.c
    /* renamed from: k */
    public void onCallback(Exception exc) {
        c.a.r0.q.i.b pmsError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            this.f10270g = null;
            boolean z = f10267i;
            if (exc != null) {
                Throwable cause = exc.getCause();
                if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f11755f >= 500) {
                    m();
                    c.a.r0.q.k.i.n.a = false;
                    c.a.r0.a.e0.d.k("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f11755f);
                    return;
                }
                l();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && c.a.r0.q.k.i.n.a) {
            boolean z = f10267i;
            q.l(new a(this), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c.a.r0.q.k.i.n.a) {
            boolean z = f10267i;
            this.f10271h = true;
            Runnable runnable = this.f10270g;
            if (runnable != null) {
                this.f10269f.removeCallbacks(runnable);
            }
            this.f10270g = null;
        }
    }

    public v0() {
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
        this.f10271h = false;
        this.f10269f = new Handler(Looper.getMainLooper());
    }
}
