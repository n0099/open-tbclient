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
/* loaded from: classes4.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f p;
    public static final e q;
    public static final g r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f32395e;

    /* renamed from: f  reason: collision with root package name */
    public e f32396f;

    /* renamed from: g  reason: collision with root package name */
    public g f32397g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f32398h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32399i;

    /* renamed from: j  reason: collision with root package name */
    public String f32400j;
    public boolean k;
    public boolean l;
    public volatile long m;
    public volatile boolean n;
    public final Runnable o;

    /* renamed from: c.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1475a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1475a() {
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f32401e;

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
            this.f32401e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32401e.m = 0L;
                this.f32401e.n = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        long a(long j2);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes4.dex */
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
        p = new C1475a();
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
        this.f32395e = p;
        this.f32396f = q;
        this.f32397g = r;
        this.f32398h = new Handler(Looper.getMainLooper());
        this.f32400j = "";
        this.k = false;
        this.l = true;
        this.m = 0L;
        this.n = false;
        this.o = new d(this);
        this.f32399i = i2;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.f32395e = p;
            } else {
                this.f32395e = fVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f32400j = null;
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
            long j2 = this.f32399i;
            while (!isInterrupted()) {
                boolean z = this.m == 0;
                this.m += j2;
                if (z) {
                    this.f32398h.post(this.o);
                }
                try {
                    Thread.sleep(j2);
                    if (this.m != 0 && !this.n) {
                        if (!this.l && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            this.n = true;
                        } else {
                            j2 = this.f32396f.a(this.m);
                            if (j2 <= 0) {
                                if (this.f32400j != null) {
                                    NewMainOnly = ANRError.New(this.m, this.f32400j, this.k);
                                } else {
                                    NewMainOnly = ANRError.NewMainOnly(this.m);
                                }
                                this.f32395e.onAppNotResponding(NewMainOnly);
                                j2 = this.f32399i;
                                this.n = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f32397g.a(e2);
                    return;
                }
            }
        }
    }
}
