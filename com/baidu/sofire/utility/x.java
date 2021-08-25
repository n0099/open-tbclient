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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f45361a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile x f45362d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f45363e;

    /* renamed from: h  reason: collision with root package name */
    public static long f45364h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f45365b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f45366c;

    /* renamed from: f  reason: collision with root package name */
    public BlockingQueue<Runnable> f45367f;

    /* renamed from: g  reason: collision with root package name */
    public BlockingQueue<Runnable> f45368g;

    /* renamed from: i  reason: collision with root package name */
    public Context f45369i;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f45370a;

        /* renamed from: b  reason: collision with root package name */
        public final String f45371b;

        /* renamed from: c  reason: collision with root package name */
        public final int f45372c;

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
            this.f45370a = new AtomicInteger(1);
            this.f45371b = str;
            this.f45372c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.f45371b + this.f45370a.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.f45372c);
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
        f45361a = availableProcessors;
        f45363e = (availableProcessors * 2) + 1;
        f45364h = 0L;
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
        this.f45367f = new LinkedBlockingQueue(100);
        this.f45368g = new LinkedBlockingQueue(10);
        int max = (context == null || (i2 = com.baidu.sofire.h.a.a(context).f45224a.getInt("s_t_p_c_s", -1)) <= 0) ? Math.max(4, f45361a) : i2;
        this.f45365b = new ThreadPoolExecutor(max, Math.max(max, (f45361a * 2) + 1), 10L, TimeUnit.SECONDS, this.f45367f, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.f45366c = new ThreadPoolExecutor(2, f45363e, 10L, TimeUnit.SECONDS, this.f45368g, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.f45365b.allowCoreThreadTimeOut(true);
            this.f45366c.allowCoreThreadTimeOut(true);
        }
    }

    public final int a(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            try {
                if (this.f45365b != null) {
                    this.f45365b.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (RejectedExecutionException e2) {
                try {
                    if (this.f45369i != null && System.currentTimeMillis() - f45364h >= 86400000) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Integer.valueOf(f45361a));
                        hashMap.put("1", Integer.valueOf(this.f45365b.getCorePoolSize()));
                        hashMap.put("2", Integer.valueOf(this.f45365b.getMaximumPoolSize()));
                        hashMap.put("3", Base64.encodeToString(com.baidu.sofire.b.a(e2).getBytes(), 0).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                        c.a(this.f45369i.getApplicationContext(), "1003147", (Map<String, Object>) hashMap, true);
                        f45364h = System.currentTimeMillis();
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
                    if (this.f45366c != null) {
                        this.f45366c.execute(runnable);
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
            if (f45362d == null) {
                try {
                    synchronized (x.class) {
                        if (f45362d == null) {
                            f45362d = new x(context);
                        }
                    }
                } catch (Throwable unused) {
                    c.a();
                }
            }
            if (f45362d != null && f45362d.f45369i == null && context != null) {
                f45362d.f45369i = context;
            }
            return f45362d;
        }
        return (x) invokeL.objValue;
    }
}
