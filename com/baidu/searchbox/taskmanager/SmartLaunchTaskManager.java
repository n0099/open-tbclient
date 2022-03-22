package com.baidu.searchbox.taskmanager;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.SmartLaunchController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SmartLaunchTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SmartLaunchManager";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(275168238, "Lcom/baidu/searchbox/taskmanager/SmartLaunchTaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(275168238, "Lcom/baidu/searchbox/taskmanager/SmartLaunchTaskManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public SmartLaunchTaskManager() {
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

    private void smartLaunchSchedule(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            SmartLaunchController.scheduleIdleTask();
            if (DEBUG) {
                Log.d("SmartLaunchManager", "SmartLaunch: schedule idle task");
            }
        }
    }

    public void schedule(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (SmartLaunchController.isSmartLaunchEnabled()) {
                if (DEBUG) {
                    Log.d("SmartLaunchManager", "enable smart launch");
                }
                smartLaunchSchedule(context);
                return;
            }
            if (DEBUG) {
                Log.d("SmartLaunchManager", "disable smart launch");
            }
            SmartLaunchController.scheduleIdleTask();
        }
    }
}
