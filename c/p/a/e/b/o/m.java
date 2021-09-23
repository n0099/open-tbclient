package c.p.a.e.b.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f35457a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f35458b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f35459c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f35460d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f35461e;

    /* renamed from: f  reason: collision with root package name */
    public int f35462f;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35463a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1555465997, "Lc/p/a/e/b/o/m$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1555465997, "Lc/p/a/e/b/o/m$a;");
                    return;
                }
            }
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f35463a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.f76327a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35463a[com.ss.android.socialbase.downloader.network.l.f76328b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35463a[com.ss.android.socialbase.downloader.network.l.f76329c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35463a[com.ss.android.socialbase.downloader.network.l.f76330d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final m f35464a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1555466028, "Lc/p/a/e/b/o/m$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1555466028, "Lc/p/a/e/b/o/m$b;");
                    return;
                }
            }
            f35464a = new m(null);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473240086, "Lc/p/a/e/b/o/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473240086, "Lc/p/a/e/b/o/m;");
        }
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f35464a : (m) invokeV.objValue;
    }

    public final com.ss.android.socialbase.downloader.network.l b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < 0.0d) {
                return com.ss.android.socialbase.downloader.network.l.f76331e;
            }
            if (d2 < 150.0d) {
                return com.ss.android.socialbase.downloader.network.l.f76327a;
            }
            if (d2 < 550.0d) {
                return com.ss.android.socialbase.downloader.network.l.f76328b;
            }
            if (d2 < 2000.0d) {
                return com.ss.android.socialbase.downloader.network.l.f76329c;
            }
            return com.ss.android.socialbase.downloader.network.l.f76330d;
        }
        return (com.ss.android.socialbase.downloader.network.l) invokeCommon.objValue;
    }

    public synchronized void c(long j2, long j3) {
        com.ss.android.socialbase.downloader.network.l d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (this) {
                double d3 = ((j2 * 1.0d) / j3) * 8.0d;
                if (j3 == 0 || d3 < 3.0d) {
                    return;
                }
                try {
                    this.f35457a.b(d3);
                    d2 = d();
                } catch (Throwable unused) {
                }
                if (this.f35458b) {
                    this.f35462f++;
                    if (d2 != this.f35460d.get()) {
                        this.f35458b = false;
                        this.f35462f = 1;
                    }
                    if (this.f35462f >= 5.0d && e()) {
                        this.f35458b = false;
                        this.f35462f = 1;
                        this.f35459c.set(this.f35460d.get());
                        f();
                    }
                    return;
                }
                if (this.f35459c.get() != d2) {
                    this.f35458b = true;
                    this.f35460d = new AtomicReference<>(d2);
                }
            }
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f35457a == null) {
                    return com.ss.android.socialbase.downloader.network.l.f76331e;
                }
                return b(this.f35457a.a());
            }
        }
        return (com.ss.android.socialbase.downloader.network.l) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f35457a == null) {
                return false;
            }
            try {
                int i2 = a.f35463a[this.f35459c.get().ordinal()];
                double d2 = 2000.0d;
                double d3 = 550.0d;
                if (i2 == 1) {
                    d3 = 0.0d;
                    d2 = 150.0d;
                } else if (i2 == 2) {
                    d2 = 550.0d;
                    d3 = 150.0d;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return true;
                    }
                    d2 = 3.4028234663852886E38d;
                    d3 = 2000.0d;
                }
                double a2 = this.f35457a.a();
                if (a2 > d2) {
                    if (a2 > d2 * 1.25d) {
                        return true;
                    }
                } else if (a2 < d3 * 0.8d) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                int size = this.f35461e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f35461e.get(i2).a(this.f35459c.get());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public m() {
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
        this.f35457a = new f(0.05d);
        this.f35458b = false;
        this.f35459c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.f76331e);
        this.f35461e = new ArrayList<>();
    }
}
