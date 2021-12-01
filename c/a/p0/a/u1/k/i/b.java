package c.a.p0.a.u1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.d;
import c.a.p0.a.z2.q0;
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
public class b implements c.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8549c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8550d;

    /* renamed from: e  reason: collision with root package name */
    public List<Runnable> f8551e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.u1.r.c.a f8552f;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8553c;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8553c = bVar;
        }

        @Override // c.a.p0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.p0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8553c.f8549c = false;
                this.f8553c.k();
                this.f8553c.f8550d = false;
            }
        }

        @Override // c.a.p0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
            }
        }

        @Override // c.a.p0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f8553c.f8549c = false;
                this.f8553c.k();
                this.f8553c.o();
            }
        }

        @Override // c.a.p0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f8553c.f8549c = true;
                this.f8553c.n();
                this.f8553c.p();
            }
        }

        @Override // c.a.p0.a.u1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "IdleHandler" : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.p0.a.u1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0504b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0504b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.f8549c) {
                    this.a.l();
                } else {
                    this.a.k();
                }
                return this.a.f8549c;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(103065280, "Lc/a/p0/a/u1/k/i/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(103065280, "Lc/a/p0/a/u1/k/i/b$c;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.a : (b) invokeV.objValue;
    }

    public boolean i(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable == null) {
                return false;
            }
            if (this.f8549c) {
                this.f8551e.add(runnable);
                return true;
            }
            q0.a0(runnable);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f8551e.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f8551e) {
            d.L().post(runnable);
        }
        if (c.a.p0.a.f1.f.a.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f8551e.size();
        }
        this.f8551e.clear();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f8551e.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f8551e.remove(0);
        if (remove != null) {
            d.L().post(remove);
        }
        if (c.a.p0.a.f1.f.a.a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f8551e.size();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.a.u1.r.a.g().i(this.f8552f, 5000);
            this.f8549c = true;
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Looper.getMainLooper();
            Looper.myQueue().addIdleHandler(new C0504b(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f8550d) {
            this.f8550d = false;
            c.a.p0.a.c1.a.p0().c();
            boolean z = c.a.p0.a.f1.f.a.a;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f8550d) {
            return;
        }
        this.f8550d = true;
        c.a.p0.a.c1.a.p0().b(3000);
        if (c.a.p0.a.f1.f.a.a) {
            String str = "YaLog block time = 3000";
        }
    }

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
                return;
            }
        }
        this.f8549c = false;
        this.f8550d = false;
        this.f8551e = new CopyOnWriteArrayList();
        this.f8552f = new a(this);
    }
}
