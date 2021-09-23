package c.a.w.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
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
/* loaded from: classes4.dex */
public class a implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadFactory o;
    public static final BlockingQueue<Runnable> p;
    public static final Executor q;
    public static volatile a r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final SparseIntArray f30377e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<d> f30378f;

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<d> f30379g;

    /* renamed from: h  reason: collision with root package name */
    public final LinkedList<d> f30380h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f30381i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f30382j;
    public volatile int k;
    public volatile int l;
    public HandlerThread m;
    public Handler n;

    /* renamed from: c.a.w.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class ThreadFactoryC1404a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f30383e;

        public ThreadFactoryC1404a() {
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
            this.f30383e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "BdAsyncTask #" + String.valueOf(this.f30383e.getAndIncrement());
                c.a.w.j.a.g(str);
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30384a;

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
            this.f30384a = aVar;
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
                    this.f30384a.j((d) obj2);
                } else if (i2 == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                    this.f30384a.i((d) obj);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f30385f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, c.a.w.a.b bVar) {
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
                    super((c.a.w.a.b) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30385f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (e() == 4) {
                            Process.setThreadPriority(-2);
                        } else if (e() == 3) {
                            Process.setThreadPriority(-1);
                        } else if (e() == 2) {
                            Process.setThreadPriority(0);
                        } else {
                            Process.setThreadPriority(10);
                        }
                    } catch (Exception e2) {
                        c.a.w.j.a.d(e2.getMessage());
                    }
                    j();
                } finally {
                    if (!h()) {
                        this.f30385f.n.sendMessageDelayed(this.f30385f.n.obtainMessage(2, this), 1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.w.a.b<?> f30386e;

        public d(c.a.w.a.b<?> bVar) {
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
            this.f30386e = null;
            if (bVar != null && bVar.b() != null) {
                this.f30386e = bVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30386e.a();
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f30386e.b().j() != null) {
                    return this.f30386e.b().j().a();
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f30386e.b().j() != null) {
                    return this.f30386e.b().j().b();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public BdAsyncTaskParallelType d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f30386e.b().j() != null) {
                    return this.f30386e.b().j().c();
                }
                return BdAsyncTaskParallelType.MAX_PARALLEL;
            }
            return (BdAsyncTaskParallelType) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30386e.b().k() : invokeV.intValue;
        }

        public BdAsyncTask<?, ?, ?> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30386e.b() : (BdAsyncTask) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30386e.isCancelled() : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30386e.b().m() : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30386e.b().n() : invokeV.booleanValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    this.f30386e.run();
                } catch (OutOfMemoryError e2) {
                    c.a.w.j.a.e(e2);
                }
            }
        }

        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.f30386e.b().y(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-985208346, "Lc/a/w/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-985208346, "Lc/a/w/a/a;");
                return;
            }
        }
        o = new ThreadFactoryC1404a();
        p = new SynchronousQueue();
        q = new ThreadPoolExecutor(7, 256, 30L, TimeUnit.SECONDS, p, o, new ThreadPoolExecutor.DiscardPolicy());
        r = null;
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
        this.f30377e = new SparseIntArray();
        this.f30378f = new LinkedList<>();
        this.f30379g = new LinkedList<>();
        this.f30380h = new LinkedList<>();
        this.f30381i = 0;
        this.f30382j = 0;
        this.k = 0;
        this.l = 0;
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
            if (r == null) {
                synchronized (a.class) {
                    if (r == null) {
                        r = new a();
                    }
                }
            }
            return r;
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
            BdAsyncTaskParallelType d2 = dVar.d();
            if (d2 == BdAsyncTaskParallelType.SERIAL) {
                if (i2 < 1) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.TWO_PARALLEL) {
                if (i2 < 2) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.THREE_PARALLEL) {
                if (i2 < 3) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.FOUR_PARALLEL) {
                if (i2 < 4) {
                    return true;
                }
            } else if (d2 != BdAsyncTaskParallelType.CUSTOM_PARALLEL || i2 < dVar.b()) {
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
                this.f30379g.add(dVar);
                this.f30378f.remove(dVar);
                q.execute(dVar);
                this.n.sendMessageDelayed(this.n.obtainMessage(1, dVar), 180000L);
                int e2 = dVar.e();
                if (e2 == 1) {
                    this.l++;
                } else if (e2 == 2) {
                    this.k++;
                } else if (e2 == 3) {
                    this.f30382j++;
                } else if (e2 == 4) {
                    this.f30381i++;
                    if (this.f30381i >= 7) {
                        c.a.w.j.a.d("SuperHight Task too much num = " + this.f30381i);
                    }
                }
                int c2 = dVar.c();
                if (c2 != 0) {
                    this.f30377e.put(c2, this.f30377e.get(c2, 0) + 1);
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            synchronized (this) {
                if (runnable instanceof c.a.w.a.b) {
                    c cVar = new c(this, (c.a.w.a.b) runnable);
                    if (cVar.h()) {
                        new Thread(cVar).start();
                        return;
                    }
                    f(cVar);
                    i(null);
                }
            }
        }
    }

    public final synchronized void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                int size = this.f30378f.size();
                int i2 = 0;
                while (i2 < size && this.f30378f.get(i2).e() >= dVar.e()) {
                    i2++;
                }
                this.f30378f.add(i2, dVar);
            }
        }
    }

    public final synchronized void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                if (dVar.i()) {
                    this.f30380h.remove(dVar);
                } else {
                    this.f30379g.remove(dVar);
                    this.n.removeMessages(1, dVar);
                    int e2 = dVar.e();
                    if (e2 == 1) {
                        this.l--;
                    } else if (e2 == 2) {
                        this.k--;
                    } else if (e2 == 3) {
                        this.f30382j--;
                    } else if (e2 == 4) {
                        this.f30381i--;
                    }
                    int c2 = dVar.c();
                    if (c2 != 0) {
                        int i2 = this.f30377e.get(c2) - 1;
                        if (i2 <= 0) {
                            this.f30377e.delete(c2);
                        } else {
                            this.f30377e.put(c2, i2);
                        }
                        if (i2 < 0) {
                            c.a.w.j.a.d("removeTask error < 0");
                        }
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
    public synchronized void h(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdAsyncTask) == null) {
            synchronized (this) {
                Iterator<d> it = this.f30378f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null && next.f() == bdAsyncTask) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                for (int i2 = 0; i2 < this.f30378f.size(); i2++) {
                    d dVar2 = this.f30378f.get(i2);
                    if (dVar2 != null) {
                        int c2 = dVar2.c();
                        int e2 = dVar2.e();
                        if (e2 != 1) {
                            if (e2 != 2) {
                                if (e2 != 3) {
                                    if (e2 == 4 && c2 == 0) {
                                        d(dVar2);
                                        return;
                                    }
                                } else if (this.f30382j + this.k + this.l >= 7) {
                                    return;
                                }
                            } else if (this.f30382j + this.k + this.l >= 6) {
                                return;
                            }
                        } else if (this.f30382j + this.k + this.l >= 5) {
                            return;
                        }
                        if (c(this.f30377e.get(c2), dVar2)) {
                            d(dVar2);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void j(d dVar) {
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                if (!dVar.g()) {
                    dVar.k(true);
                    this.f30380h.add(dVar);
                    if (this.f30380h.size() > 242 && (poll = this.f30380h.poll()) != null) {
                        poll.a();
                    }
                } else {
                    c.a.w.j.a.d("task TimeOut but it's cancelled()");
                }
                i(null);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "mWaitingTasks = " + this.f30378f.size() + " mRunningTasks = " + this.f30379g.size() + " mTimeOutTasks = " + this.f30380h.size();
        }
        return (String) invokeV.objValue;
    }
}
