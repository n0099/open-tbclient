package b.d.b;

import b.d.b.e0.h.f;
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
/* loaded from: classes6.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Executor f30503g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f30504a;

    /* renamed from: b  reason: collision with root package name */
    public final long f30505b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f30506c;

    /* renamed from: d  reason: collision with root package name */
    public final Deque<b.d.b.e0.h.c> f30507d;

    /* renamed from: e  reason: collision with root package name */
    public final b.d.b.e0.h.d f30508e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30509f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f30510e;

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
            this.f30510e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                long a2 = this.f30510e.a(System.nanoTime());
                if (a2 == -1) {
                    return;
                }
                if (a2 > 0) {
                    long j = a2 / 1000000;
                    long j2 = a2 - (1000000 * j);
                    synchronized (this.f30510e) {
                        try {
                            this.f30510e.wait(j, (int) j2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(741423938, "Lb/d/b/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(741423938, "Lb/d/b/j;");
                return;
            }
        }
        f30503g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), b.d.b.e0.e.F("OkHttp ConnectionPool", true));
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

    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this) {
                b.d.b.e0.h.c cVar = null;
                long j2 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (b.d.b.e0.h.c cVar2 : this.f30507d) {
                    if (e(cVar2, j) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j3 = j - cVar2.o;
                        if (j3 > j2) {
                            cVar = cVar2;
                            j2 = j3;
                        }
                    }
                }
                if (j2 < this.f30505b && i2 <= this.f30504a) {
                    if (i2 > 0) {
                        return this.f30505b - j2;
                    }
                    if (i3 > 0) {
                        return this.f30505b;
                    }
                    this.f30509f = false;
                    return -1L;
                }
                this.f30507d.remove(cVar);
                b.d.b.e0.e.g(cVar.o());
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    public boolean b(b.d.b.e0.h.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (!cVar.k && this.f30504a != 0) {
                notifyAll();
                return false;
            }
            this.f30507d.remove(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Socket c(b.d.b.a aVar, b.d.b.e0.h.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, fVar)) == null) {
            for (b.d.b.e0.h.c cVar : this.f30507d) {
                if (cVar.k(aVar, null) && cVar.m() && cVar != fVar.d()) {
                    return fVar.r(cVar);
                }
            }
            return null;
        }
        return (Socket) invokeLL.objValue;
    }

    @Nullable
    public b.d.b.e0.h.c d(b.d.b.a aVar, b.d.b.e0.h.f fVar, d0 d0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aVar, fVar, d0Var)) == null) {
            for (b.d.b.e0.h.c cVar : this.f30507d) {
                if (cVar.k(aVar, d0Var)) {
                    fVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        return (b.d.b.e0.h.c) invokeLLL.objValue;
    }

    public final int e(b.d.b.e0.h.c cVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, cVar, j)) == null) {
            List<Reference<b.d.b.e0.h.f>> list = cVar.n;
            int i2 = 0;
            while (i2 < list.size()) {
                Reference<b.d.b.e0.h.f> reference = list.get(i2);
                if (reference.get() != null) {
                    i2++;
                } else {
                    b.d.b.e0.n.g.m().v("A connection to " + cVar.route().a().l() + " was leaked. Did you forget to close a response body?", ((f.b) reference).f30263a);
                    list.remove(i2);
                    cVar.k = true;
                    if (list.isEmpty()) {
                        cVar.o = j - this.f30505b;
                        return 0;
                    }
                }
            }
            return list.size();
        }
        return invokeLJ.intValue;
    }

    public void f(b.d.b.e0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            if (!this.f30509f) {
                this.f30509f = true;
                f30503g.execute(this.f30506c);
            }
            this.f30507d.add(cVar);
        }
    }

    public j(int i2, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30506c = new a(this);
        this.f30507d = new ArrayDeque();
        this.f30508e = new b.d.b.e0.h.d();
        this.f30504a = i2;
        this.f30505b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }
}
