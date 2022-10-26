package com.baidu.sofire.k;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static volatile p g;
    public static final int h;
    public static long i;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;
    public ThreadPoolExecutor b;
    public BlockingQueue c;
    public BlockingQueue d;
    public Context e;

    /* loaded from: classes2.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;
        public final String b;
        public final int c;

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger(1);
            this.b = str;
            this.c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.b + this.a.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.c);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259326, "Lcom/baidu/sofire/k/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259326, "Lcom/baidu/sofire/k/p;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f = availableProcessors;
        h = (availableProcessors * 2) + 1;
        i = 0L;
    }

    public p() {
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
        this.c = new LinkedBlockingQueue(100);
        this.d = new LinkedBlockingQueue(10);
        int i4 = f;
        int max = Math.max(4, i4);
        int max2 = Math.max(max, (i4 * 2) + 1);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.a = new ThreadPoolExecutor(max, max2, 10L, timeUnit, this.c, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.b = new ThreadPoolExecutor(2, h, 10L, timeUnit, this.d, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.allowCoreThreadTimeOut(true);
            this.b.allowCoreThreadTimeOut(true);
        }
    }

    public static p a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (g == null) {
                try {
                    synchronized (p.class) {
                        if (g == null) {
                            g = new p();
                        }
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
            }
            if (g != null && g.e == null && context != null) {
                g.e = context;
            }
            return g;
        }
        return (p) invokeL.objValue;
    }

    public int a(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.a;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (RejectedExecutionException e) {
                try {
                    if (this.e != null && System.currentTimeMillis() - i >= 86400000) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Integer.valueOf(f));
                        hashMap.put("1", Integer.valueOf(this.a.getCorePoolSize()));
                        hashMap.put("2", Integer.valueOf(this.a.getMaximumPoolSize()));
                        hashMap.put("3", Base64.encodeToString(com.baidu.sofire.a.b.a(e).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                        com.baidu.sofire.k.a.a(this.e.getApplicationContext(), "1003147", (Map) hashMap, true);
                        i = System.currentTimeMillis();
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                int i3 = com.baidu.sofire.a.b.a;
                return -1;
            } catch (Throwable unused2) {
                int i4 = com.baidu.sofire.a.b.a;
                return -3;
            }
        }
        return invokeL.intValue;
    }

    public int b(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.b;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return -3;
            }
        }
        return invokeL.intValue;
    }
}
