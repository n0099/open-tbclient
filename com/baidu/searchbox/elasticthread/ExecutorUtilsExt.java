package com.baidu.searchbox.elasticthread;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ExecutorUtilsExt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String ELASTIC_TASK_NAME_PREFIX = "elastic_";
    public static final String SERIAL_TASK_NAME_PREFIX = "serial_";
    public static final String TAG = "ExecutorUtilsExt";
    public static final int TASK_PRIORITY_BACKGROUND = 3;
    public static final int TASK_PRIORITY_IMMEDIATE = 0;
    public static final int TASK_PRIORITY_INTIME = 2;
    public static final int TASK_PRIORITY_SERIAL = 4;
    public static final int TASK_PRIORITY_USER_RELATED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public ExecutorUtilsExt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void delayPostOnElastic(@NonNull Runnable runnable, @NonNull String str, int i, long j) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (runnable == null) {
                Log.w(TAG, "received a null task ");
                return;
            }
            if (i != 0 && i != 1 && i != 2 && i != 3) {
                Log.w(TAG, "illegal priority " + i);
                i2 = 3;
            } else {
                i2 = i;
            }
            ElasticConfig.updateConfig();
            if (ElasticConfig.elasticExecutorDisabled()) {
                BackupExecutors.getInstance().postThreadPoolTask(runnable, j);
            } else {
                ElasticTaskScheduler.getInstance().postConcurrentTaskDelay(runnable, getStandardTaskName(str, ELASTIC_TASK_NAME_PREFIX), i2, j);
            }
        }
    }

    public static void delayPostOnSerial(@NonNull Runnable runnable, @NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, str, Long.valueOf(j)}) == null) {
            if (runnable == null) {
                Log.w(TAG, "received a null task ");
                return;
            }
            ElasticConfig.updateConfig();
            if (ElasticConfig.elasticExecutorDisabled()) {
                BackupExecutors.getInstance().postSerialTask(runnable, j);
            } else {
                ElasticTaskScheduler.getInstance().postSerialTaskDelay(runnable, getStandardTaskName(str, SERIAL_TASK_NAME_PREFIX), 4, j);
            }
        }
    }

    @Deprecated
    public static Executor getElasticExecutor(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (ElasticConfig.elasticExecutorDisabled()) {
                return BackupExecutors.getInstance().getThreadPoolExecutor();
            }
            return new ElasticExecutor(str, i);
        }
        return (Executor) invokeLI.objValue;
    }

    @Deprecated
    public static void postOnImmediate(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, runnable, str) == null) {
            postOnElastic(runnable, str, 0);
        }
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, runnable, str) == null) {
            delayPostOnSerial(runnable, str, 0L);
        }
    }

    @Deprecated
    public static Executor getImmediateExecutor(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (ElasticConfig.elasticExecutorDisabled()) {
                return BackupExecutors.getInstance().getThreadPoolExecutor();
            }
            return getElasticExecutor(str, 0);
        }
        return (Executor) invokeL.objValue;
    }

    @Deprecated
    public static Executor getSerialExecutor(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (ElasticConfig.elasticExecutorDisabled()) {
                return BackupExecutors.getInstance().getSerialExecutor();
            }
            return new SerialExecutor(str);
        }
        return (Executor) invokeL.objValue;
    }

    public static String getStandardTaskName(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "received an empty task name ");
                str = "default";
            }
            String str3 = str2 + str;
            if (str3.length() > 256) {
                return str3.substring(0, 255);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public static void postOnElastic(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, runnable, str, i) == null) {
            delayPostOnElastic(runnable, str, i, 0L);
        }
    }
}
