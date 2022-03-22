package c.e.a;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
/* loaded from: classes3.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f o;
    public static final e p;
    public static final g q;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public e f23247b;

    /* renamed from: c  reason: collision with root package name */
    public g f23248c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f23249d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23250e;

    /* renamed from: f  reason: collision with root package name */
    public String f23251f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23252g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23253h;
    public boolean i;
    public boolean j;
    public c.e.a.b k;
    public volatile long l;
    public volatile boolean m;
    public final Runnable n;

    /* renamed from: c.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1654a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1654a() {
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

        @Override // c.e.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                throw aNRError;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.e.a.a.e
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // c.e.a.a.g
        public void a(InterruptedException interruptedException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interruptedException) == null) {
                Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l = 0L;
                this.a.m = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        long a(long j);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1782133942, "Lc/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1782133942, "Lc/e/a/a;");
                return;
            }
        }
        o = new C1654a();
        p = new b();
        q = new c();
    }

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = o;
        this.f23247b = p;
        this.f23248c = q;
        this.f23249d = new Handler(Looper.getMainLooper());
        this.f23251f = "";
        this.f23252g = false;
        this.f23253h = true;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = 0L;
        this.m = false;
        this.n = new d(this);
        this.f23250e = i;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.a = o;
            } else {
                this.a = fVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f23251f = null;
            return this;
        }
        return (a) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setName("|ANR-WatchDog|");
            long j = this.f23250e;
            long j2 = 0;
            while (!isInterrupted()) {
                boolean z = this.l == 0;
                this.l += j;
                if (z) {
                    this.f23249d.post(this.n);
                }
                try {
                    Thread.sleep(j);
                    if (this.i && this.j) {
                        if (this.k == null) {
                            this.k = new c.e.a.b();
                        }
                        if (this.l == 0 && !this.m) {
                            this.j = false;
                            ANRError NewMainAllStackTrace = ANRError.NewMainAllStackTrace(this.k.b(), j2);
                            if (NewMainAllStackTrace != null) {
                                this.a.onAppNotResponding(NewMainAllStackTrace);
                            }
                        } else {
                            j2 = this.l;
                            this.k.a();
                        }
                    }
                    if (this.l != 0 && !this.m) {
                        if (!this.f23253h && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                            this.m = true;
                        } else {
                            j = this.f23247b.a(this.l);
                            if (j <= 0) {
                                if (this.f23251f != null) {
                                    this.a.onAppNotResponding(ANRError.New(this.l, this.f23251f, this.f23252g));
                                } else if (this.i) {
                                    this.j = true;
                                    c.e.a.b bVar = new c.e.a.b();
                                    this.k = bVar;
                                    bVar.a();
                                } else {
                                    this.a.onAppNotResponding(ANRError.NewMainOnly(this.l));
                                }
                                j = this.f23250e;
                                this.m = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f23248c.a(e2);
                    return;
                }
            }
        }
    }
}
