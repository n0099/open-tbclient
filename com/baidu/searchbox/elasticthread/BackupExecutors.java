package com.baidu.searchbox.elasticthread;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class BackupExecutors {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACKUP_THREAD_POOL_CORE_SIZE = 15;
    public static volatile BackupExecutors sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService mSerialExecutor;
    public ScheduledExecutorService mThreadPoolExecutor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1343699417, "Lcom/baidu/searchbox/elasticthread/BackupExecutors;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1343699417, "Lcom/baidu/searchbox/elasticthread/BackupExecutors;");
        }
    }

    public BackupExecutors() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThreadPoolExecutor = Executors.newScheduledThreadPool(15);
        this.mSerialExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public static BackupExecutors getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (BackupExecutors.class) {
                    if (sInstance == null) {
                        sInstance = new BackupExecutors();
                    }
                }
            }
            return sInstance;
        }
        return (BackupExecutors) invokeV.objValue;
    }

    public Executor getSerialExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSerialExecutor : (Executor) invokeV.objValue;
    }

    public Executor getThreadPoolExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mThreadPoolExecutor : (Executor) invokeV.objValue;
    }

    public void postSerialTask(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j) == null) {
            this.mSerialExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public void postThreadPoolTask(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j) == null) {
            this.mThreadPoolExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }
}
