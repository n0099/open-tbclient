package b.a.j0.a.l;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f3105a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f3106b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f3107c;

    /* renamed from: d  reason: collision with root package name */
    public static final RejectedExecutionHandler f3108d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f3109e;

        /* renamed from: b.a.j0.a.l.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0085a implements Thread.UncaughtExceptionHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0085a(a aVar) {
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
                    }
                }
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
                    String str = "线程名字=" + thread.getName() + "线程crash信息";
                }
            }
        }

        public a() {
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
            this.f3109e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, "TaskScheduler #" + this.f3109e.getAndIncrement());
                thread.setUncaughtExceptionHandler(new C0085a(this));
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements RejectedExecutionHandler {
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

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                synchronized (this) {
                    if (d.f3105a == null) {
                        LinkedBlockingQueue unused = d.f3106b = new LinkedBlockingQueue();
                        ThreadPoolExecutor unused2 = d.f3105a = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, d.f3106b, d.f3107c);
                    }
                }
                d.f3105a.execute(runnable);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1189261258, "Lb/a/j0/a/l/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1189261258, "Lb/a/j0/a/l/d;");
                return;
            }
        }
        f3107c = new a();
        f3108d = new b();
    }

    public static ScheduledThreadPoolExecutor f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? new ScheduledThreadPoolExecutor(i2, f3107c) : (ScheduledThreadPoolExecutor) invokeI.objValue;
    }

    public static ThreadPoolExecutor g(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f3107c);
            threadPoolExecutor.setRejectedExecutionHandler(f3108d);
            return threadPoolExecutor;
        }
        return (ThreadPoolExecutor) invokeII.objValue;
    }
}
