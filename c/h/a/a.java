package c.h.a;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
/* loaded from: classes9.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f s;
    public static final e t;
    public static final g u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f29385e;

    /* renamed from: f  reason: collision with root package name */
    public e f29386f;

    /* renamed from: g  reason: collision with root package name */
    public g f29387g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f29388h;

    /* renamed from: i  reason: collision with root package name */
    public final int f29389i;

    /* renamed from: j  reason: collision with root package name */
    public String f29390j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f29391k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.h.a.b o;
    public volatile long p;
    public volatile boolean q;
    public final Runnable r;

    /* renamed from: c.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1632a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1632a() {
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

        @Override // c.h.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                throw aNRError;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.h.a.a.e
        public long a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements g {
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

        @Override // c.h.a.a.g
        public void a(InterruptedException interruptedException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interruptedException) == null) {
                String str = "Interrupted: " + interruptedException.getMessage();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29392e;

        public d(a aVar) {
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
            this.f29392e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29392e.p = 0L;
                this.f29392e.q = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        long a(long j2);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1696246489, "Lc/h/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1696246489, "Lc/h/a/a;");
                return;
            }
        }
        s = new C1632a();
        t = new b();
        u = new c();
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29385e = s;
        this.f29386f = t;
        this.f29387g = u;
        this.f29388h = new Handler(Looper.getMainLooper());
        this.f29390j = "";
        this.f29391k = false;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = 0L;
        this.q = false;
        this.r = new d(this);
        this.f29389i = i2;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.f29385e = s;
            } else {
                this.f29385e = fVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f29390j = null;
            return this;
        }
        return (a) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setName("|ANR-WatchDog|");
            long j2 = this.f29389i;
            long j3 = 0;
            while (!isInterrupted()) {
                boolean z = this.p == 0;
                this.p += j2;
                if (z) {
                    this.f29388h.post(this.r);
                }
                try {
                    Thread.sleep(j2);
                    if (this.m && this.n) {
                        if (this.o == null) {
                            this.o = new c.h.a.b();
                        }
                        if (this.p == 0 && !this.q) {
                            this.n = false;
                            ANRError NewMainAllStackTrace = ANRError.NewMainAllStackTrace(this.o.b(), j3);
                            if (NewMainAllStackTrace != null) {
                                this.f29385e.onAppNotResponding(NewMainAllStackTrace);
                            }
                        } else {
                            j3 = this.p;
                            this.o.a();
                        }
                    }
                    if (this.p != 0 && !this.q) {
                        if (!this.l && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            this.q = true;
                        } else {
                            j2 = this.f29386f.a(this.p);
                            if (j2 <= 0) {
                                if (this.f29390j != null) {
                                    this.f29385e.onAppNotResponding(ANRError.New(this.p, this.f29390j, this.f29391k));
                                } else if (this.m) {
                                    this.n = true;
                                    c.h.a.b bVar = new c.h.a.b();
                                    this.o = bVar;
                                    bVar.a();
                                } else {
                                    this.f29385e.onAppNotResponding(ANRError.NewMainOnly(this.p));
                                }
                                j2 = this.f29389i;
                                this.q = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f29387g.a(e2);
                    return;
                }
            }
        }
    }
}
