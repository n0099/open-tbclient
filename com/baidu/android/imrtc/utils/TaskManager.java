package com.baidu.android.imrtc.utils;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE;
    public static final String TAG = "TaskManager";
    public static TaskManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor service;
    public ExecutorService singleThreadService;

    /* loaded from: classes6.dex */
    public static class Task implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAction;
        public String mJson;

        public Task() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public Task(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mAction = str;
            this.mJson = str2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1355618001, "Lcom/baidu/android/imrtc/utils/TaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1355618001, "Lcom/baidu/android/imrtc/utils/TaskManager;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
    }

    public TaskManager() {
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
        this.service = null;
        this.singleThreadService = null;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.service = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.singleThreadService = Executors.newSingleThreadExecutor();
    }

    public static TaskManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                synchronized (TaskManager.class) {
                    if (instance == null) {
                        instance = new TaskManager();
                    }
                }
            }
            return instance;
        }
        return (TaskManager) invokeV.objValue;
    }

    public <T> Future<T> submitForLocalCallable(Callable<T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, callable)) == null) ? this.singleThreadService.submit(callable) : (Future) invokeL.objValue;
    }

    public void submitForLocalOperation(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            try {
                this.singleThreadService.submit(runnable);
            } catch (Exception e2) {
                LogUtils.e("TaskManager", "Exception ", e2);
            }
        }
    }

    public void submitForNetWork(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            try {
                this.service.submit(runnable);
            } catch (Throwable th) {
                LogUtils.e("TaskManager", "Exception ", th);
            }
        }
    }
}
