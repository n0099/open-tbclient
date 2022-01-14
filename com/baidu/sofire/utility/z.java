package com.baidu.sofire.utility;

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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile z f38551d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f38552e;

    /* renamed from: h  reason: collision with root package name */
    public static long f38553h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f38554b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f38555c;

    /* renamed from: f  reason: collision with root package name */
    public BlockingQueue<Runnable> f38556f;

    /* renamed from: g  reason: collision with root package name */
    public BlockingQueue<Runnable> f38557g;

    /* renamed from: i  reason: collision with root package name */
    public Context f38558i;

    /* loaded from: classes11.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38559b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38560c;

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger(1);
            this.f38559b = str;
            this.f38560c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.f38559b + this.a.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f38560c);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443541805, "Lcom/baidu/sofire/utility/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443541805, "Lcom/baidu/sofire/utility/z;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        f38552e = (availableProcessors * 2) + 1;
        f38553h = 0L;
    }

    public z(Context context) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38556f = new LinkedBlockingQueue(100);
        this.f38557g = new LinkedBlockingQueue(10);
        int max = (context == null || (i2 = com.baidu.sofire.h.a.a(context).a.getInt("s_t_p_c_s", -1)) <= 0) ? Math.max(4, a) : i2;
        this.f38554b = new ThreadPoolExecutor(max, Math.max(max, (a * 2) + 1), 10L, TimeUnit.SECONDS, this.f38556f, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.f38555c = new ThreadPoolExecutor(2, f38552e, 10L, TimeUnit.SECONDS, this.f38557g, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.f38554b.allowCoreThreadTimeOut(true);
            this.f38555c.allowCoreThreadTimeOut(true);
        }
    }

    public final int a(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                if (this.f38554b != null) {
                    this.f38554b.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (RejectedExecutionException e2) {
                try {
                    if (this.f38558i != null && System.currentTimeMillis() - f38553h >= 86400000) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Integer.valueOf(a));
                        hashMap.put("1", Integer.valueOf(this.f38554b.getCorePoolSize()));
                        hashMap.put("2", Integer.valueOf(this.f38554b.getMaximumPoolSize()));
                        hashMap.put("3", Base64.encodeToString(com.baidu.sofire.b.a(e2).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                        c.a(this.f38558i.getApplicationContext(), "1003147", (Map<String, Object>) hashMap, true);
                        f38553h = System.currentTimeMillis();
                    }
                } catch (Throwable unused) {
                    c.a();
                }
                c.a();
                return -1;
            } catch (Throwable unused2) {
                c.a();
                return -3;
            }
        }
        return invokeL.intValue;
    }

    public final int b(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
            if (runnable != null) {
                try {
                    if (this.f38555c != null) {
                        this.f38555c.execute(runnable);
                        return 1;
                    }
                    return -2;
                } catch (Throwable unused) {
                    c.a();
                    return -3;
                }
            }
            return -2;
        }
        return invokeL.intValue;
    }

    public static z a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f38551d == null) {
                try {
                    synchronized (z.class) {
                        if (f38551d == null) {
                            f38551d = new z(context);
                        }
                    }
                } catch (Throwable unused) {
                    c.a();
                }
            }
            if (f38551d != null && f38551d.f38558i == null && context != null) {
                f38551d.f38558i = context;
            }
            return f38551d;
        }
        return (z) invokeL.objValue;
    }
}
