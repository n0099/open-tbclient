package com.baidu.cyberplayer.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class CyberTaskExcutor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CyberTaskExcutor f38841a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f38842b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38843c;

    /* renamed from: d  reason: collision with root package name */
    public final int f38844d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f38845e;

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f38846f;

    /* loaded from: classes5.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f38847a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38848b;

        /* renamed from: c  reason: collision with root package name */
        public int f38849c;

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
            this.f38847a = new AtomicInteger(1);
            this.f38849c = 5;
            this.f38848b = str + "-";
            this.f38849c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.f38848b + this.f38847a.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(true);
                }
                thread.setPriority(this.f38849c);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    public CyberTaskExcutor() {
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
        this.f38842b = 2;
        this.f38843c = 7;
        this.f38844d = 120;
        this.f38845e = new ThreadPoolExecutor(2, 7, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new a("cyber-thread", 5));
        this.f38846f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));
        ExecutorService executorService = this.f38845e;
        if (executorService == null || !(executorService instanceof ThreadPoolExecutor)) {
            return;
        }
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        InterceptResult invokeV;
        CyberTaskExcutor cyberTaskExcutor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CyberTaskExcutor.class) {
                if (f38841a == null) {
                    f38841a = new CyberTaskExcutor();
                }
                cyberTaskExcutor = f38841a;
            }
            return cyberTaskExcutor;
        }
        return (CyberTaskExcutor) invokeV.objValue;
    }

    @Keep
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            this.f38845e.execute(runnable);
        }
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            this.f38846f.execute(runnable);
        }
    }
}
