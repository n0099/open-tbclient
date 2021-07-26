package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
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
/* loaded from: classes3.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f10569a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile x f10570d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10571e;

    /* renamed from: h  reason: collision with root package name */
    public static long f10572h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f10573b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f10574c;

    /* renamed from: f  reason: collision with root package name */
    public BlockingQueue<Runnable> f10575f;

    /* renamed from: g  reason: collision with root package name */
    public BlockingQueue<Runnable> f10576g;

    /* renamed from: i  reason: collision with root package name */
    public Context f10577i;

    /* loaded from: classes3.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f10578a;

        /* renamed from: b  reason: collision with root package name */
        public final String f10579b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10580c;

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
            this.f10578a = new AtomicInteger(1);
            this.f10579b = str;
            this.f10580c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.f10579b + this.f10578a.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f10580c);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443541867, "Lcom/baidu/sofire/utility/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443541867, "Lcom/baidu/sofire/utility/x;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f10569a = availableProcessors;
        f10571e = (availableProcessors * 2) + 1;
        f10572h = 0L;
    }

    public x(Context context) {
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
        this.f10575f = new LinkedBlockingQueue(100);
        this.f10576g = new LinkedBlockingQueue(10);
        int max = (context == null || (i2 = com.baidu.sofire.h.a.a(context).f10436a.getInt("s_t_p_c_s", -1)) <= 0) ? Math.max(4, f10569a) : i2;
        this.f10573b = new ThreadPoolExecutor(max, Math.max(max, (f10569a * 2) + 1), 10L, TimeUnit.SECONDS, this.f10575f, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.f10574c = new ThreadPoolExecutor(2, f10571e, 10L, TimeUnit.SECONDS, this.f10576g, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.f10573b.allowCoreThreadTimeOut(true);
            this.f10574c.allowCoreThreadTimeOut(true);
        }
    }

    public final int a(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                if (this.f10573b != null) {
                    this.f10573b.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (RejectedExecutionException e2) {
                try {
                    if (this.f10577i != null && System.currentTimeMillis() - f10572h >= 86400000) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Integer.valueOf(f10569a));
                        hashMap.put("1", Integer.valueOf(this.f10573b.getCorePoolSize()));
                        hashMap.put("2", Integer.valueOf(this.f10573b.getMaximumPoolSize()));
                        hashMap.put("3", Base64.encodeToString(com.baidu.sofire.b.a(e2).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                        c.a(this.f10577i.getApplicationContext(), "1003147", (Map<String, Object>) hashMap, true);
                        f10572h = System.currentTimeMillis();
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
                    if (this.f10574c != null) {
                        this.f10574c.execute(runnable);
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

    public static x a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f10570d == null) {
                try {
                    synchronized (x.class) {
                        if (f10570d == null) {
                            f10570d = new x(context);
                        }
                    }
                } catch (Throwable unused) {
                    c.a();
                }
            }
            if (f10570d != null && f10570d.f10577i == null && context != null) {
                f10570d.f10577i = context;
            }
            return f10570d;
        }
        return (x) invokeL.objValue;
    }
}
