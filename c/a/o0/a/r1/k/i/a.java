package c.a.o0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import c.a.o0.a.a2.d;
import c.a.o0.a.r1.l.e;
import c.a.o0.a.v2.q0;
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
public class a implements c.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f8372f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f8373g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8374b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8375c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f8376d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.r1.r.c.a f8377e;

    /* renamed from: c.a.o0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0358a implements c.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8378b;

        public C0358a(a aVar) {
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
            this.f8378b = aVar;
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8378b.f8374b = false;
                this.f8378b.l();
                this.f8378b.f8375c = false;
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f8378b.f8374b = false;
                this.f8378b.l();
                this.f8378b.p();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f8378b.f8374b = true;
                this.f8378b.o();
                this.f8378b.q();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
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
        public final /* synthetic */ a f8379a;

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
            this.f8379a = aVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f8379a.f8374b) {
                    if (a.f8373g) {
                        this.f8379a.m();
                    }
                } else {
                    this.f8379a.l();
                }
                return this.f8379a.f8374b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f8380a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709456447, "Lc/a/o0/a/r1/k/i/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1709456447, "Lc/a/o0/a/r1/k/i/a$c;");
                    return;
                }
            }
            f8380a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2022799906, "Lc/a/o0/a/r1/k/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2022799906, "Lc/a/o0/a/r1/k/i/a;");
                return;
            }
        }
        int f2 = e.f();
        f8372f = f2;
        f8373g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0358a c0358a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.f8380a : (a) invokeV.objValue;
    }

    public boolean j(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f8372f > 0 && this.f8374b) {
                this.f8376d.add(runnable);
                return true;
            }
            q0.X(runnable);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f8376d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f8376d) {
            d.i().post(runnable);
        }
        if (c.a.o0.a.f1.f.a.f5674a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f8376d.size();
        }
        this.f8376d.clear();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f8376d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f8376d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (c.a.o0.a.f1.f.a.f5674a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f8376d.size();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f8372f > 0) {
                c.a.o0.a.r1.r.a.f().h(this.f8377e, f8372f);
                this.f8374b = true;
            } else {
                boolean z = c.a.o0.a.f1.f.a.f5674a;
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f8375c) {
            this.f8375c = false;
            c.a.o0.a.c1.a.g0().a();
            boolean z = c.a.o0.a.f1.f.a.f5674a;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f8375c) {
            return;
        }
        this.f8375c = true;
        int o = e.o();
        c.a.o0.a.c1.a.g0().b(o);
        if (c.a.o0.a.f1.f.a.f5674a) {
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
        this.f8374b = false;
        this.f8375c = false;
        this.f8376d = new CopyOnWriteArrayList();
        this.f8377e = new C0358a(this);
    }
}
