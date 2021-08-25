package c.a.o0.a.v2;

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
/* loaded from: classes.dex */
public class u0 implements c.a.o0.a.v2.e1.b<Exception> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9390i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f9391e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f9392f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f9393g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f9394h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f9395e;

        /* renamed from: c.a.o0.a.v2.u0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0438a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f9396e;

            public RunnableC0438a(a aVar) {
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
                this.f9396e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (u0.f9390i) {
                        String str = "do updateCore, isStop=" + this.f9396e.f9395e.f9394h;
                    }
                    if (this.f9396e.f9395e.f9394h) {
                        return;
                    }
                    this.f9396e.f9395e.i();
                }
            }
        }

        public a(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9395e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ProcessUtils.isMainProcess()) {
                    this.f9395e.f9394h = false;
                    synchronized (u0.class) {
                        this.f9395e.f9391e = System.currentTimeMillis();
                        if (this.f9395e.f9393g != null) {
                            this.f9395e.f9392f.removeCallbacks(this.f9395e.f9393g);
                        }
                        this.f9395e.f9393g = new RunnableC0438a(this);
                        long a2 = c.a.o0.n.j.i.l.a(300) * 1000;
                        this.f9395e.f9392f.postDelayed(this.f9395e.f9393g, a2);
                        if (u0.f9390i) {
                            String str = "wait next heart beat: " + a2;
                        }
                    }
                    return;
                }
                c.a.o0.a.v1.b.d.b(c.class, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f9397e;

        public b(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9397e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.n.b.j(new c.a.o0.n.i.m.h(0), new c.a.o0.a.h0.m.i(this.f9397e, true));
            }
        }
    }

    /* loaded from: classes.dex */
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
                u0.j().l();
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final u0 f9398a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(44043107, "Lc/a/o0/a/v2/u0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(44043107, "Lc/a/o0/a/v2/u0$d;");
                    return;
                }
            }
            f9398a = new u0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819038243, "Lc/a/o0/a/v2/u0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819038243, "Lc/a/o0/a/v2/u0;");
                return;
            }
        }
        f9390i = c.a.o0.a.k.f7049a;
    }

    public /* synthetic */ u0(a aVar) {
        this();
    }

    public static u0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.f9398a : (u0) invokeV.objValue;
    }

    @AnyThread
    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.k(new b(this), "SwanH2HeartBeatManager");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.v2.e1.b
    /* renamed from: k */
    public void onCallback(Exception exc) {
        c.a.o0.n.h.a pmsError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            this.f9393g = null;
            boolean z = f9390i;
            if (exc != null) {
                Throwable cause = exc.getCause();
                if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f11850d >= 500) {
                    m();
                    c.a.o0.n.j.i.l.f12001a = false;
                    c.a.o0.a.e0.d.h("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f11850d);
                    return;
                }
                l();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && c.a.o0.n.j.i.l.f12001a) {
            boolean z = f9390i;
            q.k(new a(this), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c.a.o0.n.j.i.l.f12001a) {
            boolean z = f9390i;
            this.f9394h = true;
            Runnable runnable = this.f9393g;
            if (runnable != null) {
                this.f9392f.removeCallbacks(runnable);
            }
            this.f9393g = null;
        }
    }

    public u0() {
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
        this.f9394h = false;
        this.f9392f = new Handler(Looper.getMainLooper());
    }
}
