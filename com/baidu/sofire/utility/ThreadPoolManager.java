package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.BaiduLog;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ThreadPoolManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORE_EXECUTOR_MAX_SIZE;
    public static final int CORE_EXECUTOR_SIZE = 2;
    public static final int CORE_QUEUE_LEN = 10;
    public static final int N;
    public static final int QUEUE_LEN = 100;
    public static final int RESULT_CODE_EXCEPTION = -3;
    public static final int RESULT_CODE_OK = 1;
    public static final int RESULT_CODE_REJECTED_EXECUTION = -1;
    public static final int RESULT_CODE_TASK_NULL = -2;
    public static volatile ThreadPoolManager sInstance;
    public static long sLastReportTime;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ThreadPoolExecutor mCoreExecutor;
    public BlockingQueue<Runnable> mCorePoolQueue;
    public BlockingQueue<Runnable> mPoolQueue;
    public ThreadPoolExecutor mTaskExecutor;

    /* loaded from: classes2.dex */
    public static class MyThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String namePrefix;
        public final int priority;
        public final AtomicInteger threadNumber;

        public MyThreadFactory(String str, int i) {
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
            this.threadNumber = new AtomicInteger(1);
            this.namePrefix = str;
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable, this.namePrefix + this.threadNumber.getAndIncrement());
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.priority);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(728285062, "Lcom/baidu/sofire/utility/ThreadPoolManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(728285062, "Lcom/baidu/sofire/utility/ThreadPoolManager;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        N = availableProcessors;
        CORE_EXECUTOR_MAX_SIZE = (availableProcessors * 2) + 1;
        sLastReportTime = 0L;
    }

    public ThreadPoolManager(Context context) {
        int threadPoolCoreSize;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPoolQueue = new LinkedBlockingQueue(100);
        this.mCorePoolQueue = new LinkedBlockingQueue(10);
        int max = (context == null || (threadPoolCoreSize = SharedPreferenceManager.getInstance(context).getThreadPoolCoreSize()) <= 0) ? Math.max(4, N) : threadPoolCoreSize;
        this.mTaskExecutor = new ThreadPoolExecutor(max, Math.max(max, (N * 2) + 1), 10L, TimeUnit.SECONDS, this.mPoolQueue, new MyThreadFactory("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.mCoreExecutor = new ThreadPoolExecutor(2, CORE_EXECUTOR_MAX_SIZE, 10L, TimeUnit.SECONDS, this.mCorePoolQueue, new MyThreadFactory("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.mTaskExecutor.allowCoreThreadTimeOut(true);
            this.mCoreExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public static ThreadPoolManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (sInstance == null) {
                try {
                    synchronized (ThreadPoolManager.class) {
                        if (sInstance == null) {
                            sInstance = new ThreadPoolManager(context);
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
            if (sInstance != null && sInstance.mContext == null && context != null) {
                sInstance.mContext = context;
            }
            return sInstance;
        }
        return (ThreadPoolManager) invokeL.objValue;
    }

    private void reportRejected(RejectedExecutionException rejectedExecutionException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, rejectedExecutionException) == null) {
            try {
                if (this.mContext != null && System.currentTimeMillis() - sLastReportTime >= 86400000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", Integer.valueOf(N));
                    hashMap.put("1", Integer.valueOf(this.mTaskExecutor.getCorePoolSize()));
                    hashMap.put("2", Integer.valueOf(this.mTaskExecutor.getMaximumPoolSize()));
                    hashMap.put("3", Base64.encodeToString(BaiduLog.getStackTraceString(rejectedExecutionException).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                    CommonMethods.sendEventUDC(this.mContext.getApplicationContext(), "1003147", hashMap, true);
                    sLastReportTime = System.currentTimeMillis();
                }
            } catch (Throwable unused) {
                CommonMethods.handleNuLException(rejectedExecutionException);
            }
        }
    }

    public int execute(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null) {
                try {
                    if (this.mTaskExecutor != null) {
                        this.mTaskExecutor.execute(runnable);
                        return 1;
                    }
                    return -2;
                } catch (RejectedExecutionException e) {
                    reportRejected(e);
                    CommonMethods.handleNuLException(e);
                    return -1;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return -3;
                }
            }
            return -2;
        }
        return invokeL.intValue;
    }

    public int executeCore(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable)) == null) {
            if (runnable != null) {
                try {
                    if (this.mCoreExecutor != null) {
                        this.mCoreExecutor.execute(runnable);
                        return 1;
                    }
                    return -2;
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return -3;
                }
            }
            return -2;
        }
        return invokeL.intValue;
    }
}
