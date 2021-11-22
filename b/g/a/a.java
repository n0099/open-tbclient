package b.g.a;

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
/* loaded from: classes6.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f p;
    public static final e q;
    public static final g r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f32139e;

    /* renamed from: f  reason: collision with root package name */
    public e f32140f;

    /* renamed from: g  reason: collision with root package name */
    public g f32141g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f32142h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32143i;
    public String j;
    public boolean k;
    public boolean l;
    public volatile long m;
    public volatile boolean n;
    public final Runnable o;

    /* renamed from: b.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1513a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1513a() {
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

        @Override // b.g.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                throw aNRError;
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // b.g.a.a.e
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // b.g.a.a.g
        public void a(InterruptedException interruptedException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interruptedException) == null) {
                String str = "Interrupted: " + interruptedException.getMessage();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f32144e;

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
            this.f32144e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32144e.m = 0L;
                this.f32144e.n = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        long a(long j);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(827281321, "Lb/g/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(827281321, "Lb/g/a/a;");
                return;
            }
        }
        p = new C1513a();
        q = new b();
        r = new c();
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
        this.f32139e = p;
        this.f32140f = q;
        this.f32141g = r;
        this.f32142h = new Handler(Looper.getMainLooper());
        this.j = "";
        this.k = false;
        this.l = true;
        this.m = 0L;
        this.n = false;
        this.o = new d(this);
        this.f32143i = i2;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.f32139e = p;
            } else {
                this.f32139e = fVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.j = null;
            return this;
        }
        return (a) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setName("|ANR-WatchDog|");
            long j = this.f32143i;
            while (!isInterrupted()) {
                boolean z = this.m == 0;
                this.m += j;
                if (z) {
                    this.f32142h.post(this.o);
                }
                try {
                    Thread.sleep(j);
                    if (this.m != 0 && !this.n) {
                        if (!this.l && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            this.n = true;
                        } else {
                            j = this.f32140f.a(this.m);
                            if (j <= 0) {
                                if (this.j != null) {
                                    NewMainOnly = ANRError.New(this.m, this.j, this.k);
                                } else {
                                    NewMainOnly = ANRError.NewMainOnly(this.m);
                                }
                                this.f32139e.onAppNotResponding(NewMainOnly);
                                j = this.f32143i;
                                this.n = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f32141g.a(e2);
                    return;
                }
            }
        }
    }
}
