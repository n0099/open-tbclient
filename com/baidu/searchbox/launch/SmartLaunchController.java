package com.baidu.searchbox.launch;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SmartLaunchController {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isSmartLaunchEnable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1454956315, "Lcom/baidu/searchbox/launch/SmartLaunchController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1454956315, "Lcom/baidu/searchbox/launch/SmartLaunchController;");
        }
    }

    public SmartLaunchController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isSmartLaunchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSmartLaunchScheduleEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SmartLaunchScheduler.getInstance().isScheduleEnd() : invokeV.booleanValue;
    }

    public static boolean isSmartLaunchScheduleInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SmartLaunchScheduler.getInstance().isScheduleInterrupted() : invokeV.booleanValue;
    }

    public static void register(SmartLaunchTask smartLaunchTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, smartLaunchTask) == null) {
            SmartLaunchScheduler.getInstance().register(smartLaunchTask);
        }
    }

    public static void scheduleIdleTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            SmartLaunchScheduler.getInstance().scheduleIdleTask();
        }
    }
}
