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
    public f f28520e;

    /* renamed from: f  reason: collision with root package name */
    public e f28521f;

    /* renamed from: g  reason: collision with root package name */
    public g f28522g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f28523h;

    /* renamed from: i  reason: collision with root package name */
    public final int f28524i;

    /* renamed from: j  reason: collision with root package name */
    public String f28525j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.h.a.b o;
    public volatile long p;
    public volatile boolean q;
    public final Runnable r;

    /* renamed from: c.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1649a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1649a() {
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
        public final /* synthetic */ a f28526e;

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
            this.f28526e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28526e.p = 0L;
                this.f28526e.q = false;
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
        s = new C1649a();
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
        this.f28520e = s;
        this.f28521f = t;
        this.f28522g = u;
        this.f28523h = new Handler(Looper.getMainLooper());
        this.f28525j = "";
        this.k = false;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = 0L;
        this.q = false;
        this.r = new d(this);
        this.f28524i = i2;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.f28520e = s;
            } else {
                this.f28520e = fVar;
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
            this.f28525j = null;
            return this;
        }
        return (a) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setName("|ANR-WatchDog|");
            long j2 = this.f28524i;
            long j3 = 0;
            while (!isInterrupted()) {
                boolean z = this.p == 0;
                this.p += j2;
                if (z) {
                    this.f28523h.post(this.r);
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
                                this.f28520e.onAppNotResponding(NewMainAllStackTrace);
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
                            j2 = this.f28521f.a(this.p);
                            if (j2 <= 0) {
                                if (this.f28525j != null) {
                                    this.f28520e.onAppNotResponding(ANRError.New(this.p, this.f28525j, this.k));
                                } else if (this.m) {
                                    this.n = true;
                                    c.h.a.b bVar = new c.h.a.b();
                                    this.o = bVar;
                                    bVar.a();
                                } else {
                                    this.f28520e.onAppNotResponding(ANRError.NewMainOnly(this.p));
                                }
                                j2 = this.f28524i;
                                this.q = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f28522g.a(e2);
                    return;
                }
            }
        }
    }
}
