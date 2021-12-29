package c.d.b;

import c.d.b.e0.h.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Executor f28830g;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28831b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f28832c;

    /* renamed from: d  reason: collision with root package name */
    public final Deque<c.d.b.e0.h.c> f28833d;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.b.e0.h.d f28834e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28835f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f28836e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28836e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                long a = this.f28836e.a(System.nanoTime());
                if (a == -1) {
                    return;
                }
                if (a > 0) {
                    long j2 = a / 1000000;
                    long j3 = a - (1000000 * j2);
                    synchronized (this.f28836e) {
                        try {
                            this.f28836e.wait(j2, (int) j3);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810733023, "Lc/d/b/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810733023, "Lc/d/b/j;");
                return;
            }
        }
        f28830g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.d.b.e0.e.F("OkHttp ConnectionPool", true));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(5, 5L, TimeUnit.MINUTES);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), (TimeUnit) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            synchronized (this) {
                c.d.b.e0.h.c cVar = null;
                long j3 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (c.d.b.e0.h.c cVar2 : this.f28833d) {
                    if (e(cVar2, j2) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j4 = j2 - cVar2.o;
                        if (j4 > j3) {
                            cVar = cVar2;
                            j3 = j4;
                        }
                    }
                }
                if (j3 < this.f28831b && i2 <= this.a) {
                    if (i2 > 0) {
                        return this.f28831b - j3;
                    }
                    if (i3 > 0) {
                        return this.f28831b;
                    }
                    this.f28835f = false;
                    return -1L;
                }
                this.f28833d.remove(cVar);
                c.d.b.e0.e.g(cVar.o());
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    public boolean b(c.d.b.e0.h.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (!cVar.f28585k && this.a != 0) {
                notifyAll();
                return false;
            }
            this.f28833d.remove(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Socket c(c.d.b.a aVar, c.d.b.e0.h.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, fVar)) == null) {
            for (c.d.b.e0.h.c cVar : this.f28833d) {
                if (cVar.k(aVar, null) && cVar.m() && cVar != fVar.d()) {
                    return fVar.r(cVar);
                }
            }
            return null;
        }
        return (Socket) invokeLL.objValue;
    }

    @Nullable
    public c.d.b.e0.h.c d(c.d.b.a aVar, c.d.b.e0.h.f fVar, d0 d0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aVar, fVar, d0Var)) == null) {
            for (c.d.b.e0.h.c cVar : this.f28833d) {
                if (cVar.k(aVar, d0Var)) {
                    fVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        return (c.d.b.e0.h.c) invokeLLL.objValue;
    }

    public final int e(c.d.b.e0.h.c cVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, cVar, j2)) == null) {
            List<Reference<c.d.b.e0.h.f>> list = cVar.n;
            int i2 = 0;
            while (i2 < list.size()) {
                Reference<c.d.b.e0.h.f> reference = list.get(i2);
                if (reference.get() != null) {
                    i2++;
                } else {
                    c.d.b.e0.n.g.m().v("A connection to " + cVar.route().a().l() + " was leaked. Did you forget to close a response body?", ((f.b) reference).a);
                    list.remove(i2);
                    cVar.f28585k = true;
                    if (list.isEmpty()) {
                        cVar.o = j2 - this.f28831b;
                        return 0;
                    }
                }
            }
            return list.size();
        }
        return invokeLJ.intValue;
    }

    public void f(c.d.b.e0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            if (!this.f28835f) {
                this.f28835f = true;
                f28830g.execute(this.f28832c);
            }
            this.f28833d.add(cVar);
        }
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28832c = new a(this);
        this.f28833d = new ArrayDeque();
        this.f28834e = new c.d.b.e0.h.d();
        this.a = i2;
        this.f28831b = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }
}
