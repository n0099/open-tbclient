package com.baidu.searchbox.performance.speed.task;

import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class LaunchTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "LaunchTask";
    public static Looper asyncLooper;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void execute();

    public abstract String getName();

    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136873914, "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(136873914, "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;");
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        asyncLooper = handlerThread.getLooper();
        DEBUG = AppConfig.isDebug();
    }

    public LaunchTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            execute();
            SpeedStatsManager.getInstance().setTaskRunTime(getName(), System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
