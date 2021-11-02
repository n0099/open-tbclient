package b.a.p0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import b.a.p0.a.a2.d;
import b.a.p0.a.r1.l.e;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f7682f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f7683g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7684b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7685c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f7686d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.r1.r.c.a f7687e;

    /* renamed from: b.a.p0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0355a implements b.a.p0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7688b;

        public C0355a(a aVar) {
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
            this.f7688b = aVar;
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7688b.f7684b = false;
                this.f7688b.l();
                this.f7688b.f7685c = false;
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f7688b.f7684b = false;
                this.f7688b.l();
                this.f7688b.p();
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f7688b.f7684b = true;
                this.f7688b.o();
                this.f7688b.q();
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "IdleHandler" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7689a;

        public b(a aVar) {
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
            this.f7689a = aVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f7689a.f7684b) {
                    if (a.f7683g) {
                        this.f7689a.m();
                    }
                } else {
                    this.f7689a.l();
                }
                return this.f7689a.f7684b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f7690a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1607746495, "Lb/a/p0/a/r1/k/i/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1607746495, "Lb/a/p0/a/r1/k/i/a$c;");
                    return;
                }
            }
            f7690a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1531286178, "Lb/a/p0/a/r1/k/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1531286178, "Lb/a/p0/a/r1/k/i/a;");
                return;
            }
        }
        int f2 = e.f();
        f7682f = f2;
        f7683g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0355a c0355a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.f7690a : (a) invokeV.objValue;
    }

    public boolean j(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f7682f > 0 && this.f7684b) {
                this.f7686d.add(runnable);
                return true;
            }
            q0.X(runnable);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f7686d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f7686d) {
            d.i().post(runnable);
        }
        if (b.a.p0.a.f1.f.a.f5062a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f7686d.size();
        }
        this.f7686d.clear();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f7686d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f7686d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (b.a.p0.a.f1.f.a.f5062a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f7686d.size();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f7682f > 0) {
                b.a.p0.a.r1.r.a.f().h(this.f7687e, f7682f);
                this.f7684b = true;
            } else {
                boolean z = b.a.p0.a.f1.f.a.f5062a;
            }
            q();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new b(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f7685c) {
            this.f7685c = false;
            b.a.p0.a.c1.a.g0().a();
            boolean z = b.a.p0.a.f1.f.a.f5062a;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f7685c) {
            return;
        }
        this.f7685c = true;
        int o = e.o();
        b.a.p0.a.c1.a.g0().b(o);
        if (b.a.p0.a.f1.f.a.f5062a) {
            String str = "YaLog block time = " + o;
        }
    }

    public a() {
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
        this.f7684b = false;
        this.f7685c = false;
        this.f7686d = new CopyOnWriteArrayList();
        this.f7687e = new C0355a(this);
    }
}
