package c.a.d.f.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static a o;
    public static final ThreadFactory p;
    public static final BlockingQueue<Runnable> q;
    public static final Executor r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f2794e;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f2795f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f2796g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f2797h;

    /* renamed from: i  reason: collision with root package name */
    public final SparseIntArray f2798i;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedList<d> f2799j;
    public final LinkedList<d> k;
    public final LinkedList<d> l;
    public HandlerThread m;
    public Handler n;

    /* renamed from: c.a.d.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0114a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f2800e;

        public ThreadFactoryC0114a() {
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
            this.f2800e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "BdAsyncTask #" + String.valueOf(this.f2800e.getAndIncrement());
                BdLog.i(str);
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof d)) {
                        return;
                    }
                    this.a.y((d) obj2);
                } else if (i2 == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                    this.a.p((d) obj);
                    BdBaseApplication.getInst().isDebugMode();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2801f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, c.a.d.f.c.b bVar) {
            super(bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.d.f.c.b) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2801f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (g() == 4) {
                            Process.setThreadPriority(-2);
                        } else if (g() == 3) {
                            Process.setThreadPriority(-1);
                        } else if (g() == 2) {
                            Process.setThreadPriority(0);
                        } else {
                            Process.setThreadPriority(10);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    l();
                } finally {
                    if (!k()) {
                        this.f2801f.n.sendMessageDelayed(this.f2801f.n.obtainMessage(2, this), 1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.d.f.c.b<?> f2802e;

        public d(c.a.d.f.c.b<?> bVar) {
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
            this.f2802e = null;
            if (bVar != null && bVar.b() != null) {
                this.f2802e = bVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2802e.b().isTimeout() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f2802e.a();
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f2802e.b().getParallel() != null) {
                    return this.f2802e.b().getParallel().a();
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2802e.b().getKey() : (String) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f2802e.b().getParallel() != null) {
                    return this.f2802e.b().getParallel().b();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f2802e.b().getParallel() != null) {
                    return this.f2802e.b().getParallel().getType();
                }
                return BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
            }
            return (BdAsyncTaskParallel.BdAsyncTaskParallelType) invokeV.objValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2802e.b().getPriority() : invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2802e.b().getTag() : invokeV.intValue;
        }

        public BdAsyncTask<?, ?, ?> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2802e.b() : (BdAsyncTask) invokeV.objValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2802e.isCancelled() : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2802e.b().isSelfExecute() : invokeV.booleanValue;
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                try {
                    this.f2802e.run();
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
        }

        public void m(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
                this.f2802e.b().setTimeout(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502876512, "Lc/a/d/f/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502876512, "Lc/a/d/f/c/a;");
                return;
            }
        }
        p = new ThreadFactoryC0114a();
        q = new SynchronousQueue();
        r = new ThreadPoolExecutor(7, 256, 30L, TimeUnit.SECONDS, q, p, new ThreadPoolExecutor.DiscardPolicy());
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
        this.f2794e = 0;
        this.f2795f = 0;
        this.f2796g = 0;
        this.f2797h = 0;
        this.f2798i = new SparseIntArray();
        this.f2799j = new LinkedList<>();
        this.k = new LinkedList<>();
        this.l = new LinkedList<>();
        this.m = null;
        this.n = null;
        HandlerThread handlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new b(this, this.m.getLooper());
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (o == null) {
                synchronized (a.class) {
                    if (o == null) {
                        o = new a();
                    }
                }
            }
            return o;
        }
        return (a) invokeV.objValue;
    }

    public final boolean c(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            BdAsyncTaskParallel.BdAsyncTaskParallelType f2 = dVar.f();
            if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL) {
                if (i2 < 1) {
                    return true;
                }
            } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL) {
                if (i2 < 2) {
                    return true;
                }
            } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL) {
                if (i2 < 3) {
                    return true;
                }
            } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL) {
                if (i2 < 4) {
                    return true;
                }
            } else if (f2 != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i2 < dVar.c()) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final synchronized void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                this.k.add(dVar);
                this.f2799j.remove(dVar);
                r.execute(dVar);
                this.n.sendMessageDelayed(this.n.obtainMessage(1, dVar), 180000L);
                int g2 = dVar.g();
                if (g2 == 1) {
                    this.f2797h++;
                } else if (g2 == 2) {
                    this.f2796g++;
                } else if (g2 == 3) {
                    this.f2795f++;
                } else if (g2 == 4) {
                    this.f2794e++;
                    if (this.f2794e >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.f2794e);
                    }
                }
                int e2 = dVar.e();
                if (e2 != 0) {
                    this.f2798i.put(e2, this.f2798i.get(e2, 0) + 1);
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            synchronized (this) {
                if (runnable instanceof c.a.d.f.c.b) {
                    c cVar = new c(this, (c.a.d.f.c.b) runnable);
                    if (cVar.k()) {
                        new Thread(cVar).start();
                        return;
                    }
                    h(cVar);
                    p(null);
                    BdBaseApplication.getInst().isDebugMode();
                }
            }
        }
    }

    public final synchronized int f(LinkedList<d> linkedList, String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, linkedList, str, bdUniqueId)) == null) {
            synchronized (this) {
                int i2 = 0;
                if (linkedList == null || bdUniqueId == null) {
                    return 0;
                }
                int id = bdUniqueId.getId();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h2 = next.h();
                    String d2 = next.d();
                    if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                        if (next.i() != null && !next.i().isCancelled()) {
                            i2++;
                        }
                    }
                }
                return i2;
            }
        }
        return invokeLLL.intValue;
    }

    public int g(String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bdUniqueId)) == null) ? f(this.f2799j, str, bdUniqueId) + f(this.k, str, bdUniqueId) + f(this.l, str, bdUniqueId) : invokeLL.intValue;
    }

    public final synchronized void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                int size = this.f2799j.size();
                int i2 = 0;
                while (i2 < size && this.f2799j.get(i2).g() >= dVar.g()) {
                    i2++;
                }
                this.f2799j.add(i2, dVar);
            }
        }
    }

    public synchronized void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            synchronized (this) {
                j(bdUniqueId, null);
            }
        }
    }

    public synchronized void j(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bdUniqueId, str) == null) {
            synchronized (this) {
                l(bdUniqueId, str);
                n(this.k, false, bdUniqueId, str);
                n(this.l, false, bdUniqueId, str);
            }
        }
    }

    public synchronized void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            synchronized (this) {
                l(bdUniqueId, null);
            }
        }
    }

    public synchronized void l(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdUniqueId, str) == null) {
            synchronized (this) {
                n(this.f2799j, true, bdUniqueId, str);
            }
        }
    }

    public final synchronized void m(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                if (dVar.a()) {
                    this.l.remove(dVar);
                } else {
                    this.k.remove(dVar);
                    this.n.removeMessages(1, dVar);
                    int g2 = dVar.g();
                    if (g2 == 1) {
                        this.f2797h--;
                    } else if (g2 == 2) {
                        this.f2796g--;
                    } else if (g2 == 3) {
                        this.f2795f--;
                    } else if (g2 == 4) {
                        this.f2794e--;
                    }
                    int e2 = dVar.e();
                    if (e2 != 0) {
                        int i2 = this.f2798i.get(e2) - 1;
                        if (i2 <= 0) {
                            this.f2798i.delete(e2);
                        } else {
                            this.f2798i.put(e2, i2);
                        }
                        if (i2 < 0) {
                            BdLog.e("removeTask error < 0");
                        }
                    }
                }
            }
        }
    }

    public final synchronized void n(LinkedList<d> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{linkedList, Boolean.valueOf(z), bdUniqueId, str}) == null) {
            synchronized (this) {
                if (bdUniqueId == null) {
                    return;
                }
                int id = bdUniqueId.getId();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h2 = next.h();
                    String d2 = next.d();
                    if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                        if (z) {
                            it.remove();
                        }
                        next.b();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void o(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdAsyncTask) == null) {
            synchronized (this) {
                Iterator<d> it = this.f2799j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null && next.i() == bdAsyncTask) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void p(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            synchronized (this) {
                m(dVar);
                for (int i2 = 0; i2 < this.f2799j.size(); i2++) {
                    d dVar2 = this.f2799j.get(i2);
                    if (dVar2 != null) {
                        int e2 = dVar2.e();
                        int g2 = dVar2.g();
                        if (g2 != 1) {
                            if (g2 != 2) {
                                if (g2 != 3) {
                                    if (g2 == 4 && e2 == 0) {
                                        d(dVar2);
                                        return;
                                    }
                                } else if (this.f2795f + this.f2796g + this.f2797h >= 7) {
                                    return;
                                }
                            } else if (this.f2795f + this.f2796g + this.f2797h >= 6) {
                                return;
                            }
                        } else if (this.f2795f + this.f2796g + this.f2797h >= 5) {
                            return;
                        }
                        if (c(this.f2798i.get(e2), dVar2)) {
                            d(dVar2);
                            return;
                        }
                    }
                }
            }
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> q(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                v = v(this.k, str);
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> r(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        LinkedList<BdAsyncTask<?, ?, ?>> s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bdUniqueId)) == null) {
            synchronized (this) {
                s = s(bdUniqueId, null);
            }
            return s;
        }
        return (LinkedList) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> s(BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLL;
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bdUniqueId, str)) == null) {
            synchronized (this) {
                linkedList = new LinkedList<>();
                LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.f2799j, bdUniqueId, str);
                if (t != null) {
                    linkedList.addAll(t);
                }
                LinkedList<BdAsyncTask<?, ?, ?>> t2 = t(this.k, bdUniqueId, str);
                if (t2 != null) {
                    linkedList.addAll(t2);
                }
                LinkedList<BdAsyncTask<?, ?, ?>> t3 = t(this.l, bdUniqueId, str);
                if (t3 != null) {
                    linkedList.addAll(t3);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeLL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> t(LinkedList<d> linkedList, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, linkedList, bdUniqueId, str)) == null) {
            synchronized (this) {
                if (linkedList == null || bdUniqueId == null) {
                    return null;
                }
                int id = bdUniqueId.getId();
                LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h2 = next.h();
                    String d2 = next.d();
                    if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                        if (next.i() != null && !next.i().isCancelled()) {
                            linkedList2.add(next.i());
                        }
                    }
                }
                return linkedList2;
            }
        }
        return (LinkedList) invokeLLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "mWaitingTasks = " + this.f2799j.size() + " mRunningTasks = " + this.k.size() + " mTimeOutTasks = " + this.l.size();
        }
        return (String) invokeV.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> u(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            synchronized (this) {
                v = v(this.f2799j, str);
                if (v == null) {
                    v = v(this.k, str);
                }
                if (v == null) {
                    v = v(this.l, str);
                }
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> v(LinkedList<d> linkedList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, linkedList, str)) == null) {
            synchronized (this) {
                if (linkedList == null || str == null) {
                    return null;
                }
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    String d2 = next.d();
                    if (d2 != null && d2.equals(str) && !next.i().isCancelled()) {
                        return next.i();
                    }
                }
                return null;
            }
        }
        return (BdAsyncTask) invokeLL.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> w(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            synchronized (this) {
                v = v(this.f2799j, str);
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> x(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bdUniqueId)) == null) {
            synchronized (this) {
                linkedList = new LinkedList<>();
                LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.f2799j, bdUniqueId, null);
                if (t != null) {
                    linkedList.addAll(t);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeL.objValue;
    }

    public final synchronized void y(d dVar) {
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
            synchronized (this) {
                m(dVar);
                if (!dVar.j()) {
                    dVar.m(true);
                    this.l.add(dVar);
                    if (this.l.size() > 242 && (poll = this.l.poll()) != null) {
                        poll.b();
                    }
                } else {
                    BdLog.e("task TimeOut but it's cancelled()");
                }
                p(null);
            }
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f2799j.size() + "/" + this.k.size() + "/" + this.l.size();
        }
        return (String) invokeV.objValue;
    }
}
