package com.baidu.searchbox.appframework;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class BdBoxActivityManager {
    public static /* synthetic */ Interceptable $ic;
    public static BdBoxActivityLifecycle sMainGlobalActivityLifecycle;
    public transient /* synthetic */ FieldHolder $fh;

    public BdBoxActivityManager() {
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

    public static void finishAllActivity() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.finishAllActivity();
        }
    }

    public static int getActivityCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getActivityCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static LinkedList<WeakReference<Activity>> getActivityStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getActivityStack();
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public static BdBoxActivityLifecycle getMainGlobalActivityLifecycle() {
        InterceptResult invokeV;
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (BdBoxActivityLifecycle.class) {
                bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            }
            return bdBoxActivityLifecycle;
        }
        return (BdBoxActivityLifecycle) invokeV.objValue;
    }

    public static Activity getPenultimateActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getPenultimateActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static Activity getRealTopActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getRealTopActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static Activity getTopActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getTopActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public static boolean isForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null && bdBoxActivityLifecycle.isForeground()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Activity getSpecifiedActivity(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null) {
                return bdBoxActivityLifecycle.getSpecifiedActivity(cls);
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public static boolean isActivityInStack(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
            if (bdBoxActivityLifecycle != null && bdBoxActivityLifecycle.isActivityInStack(cls)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void registerGlobalLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, iActivityLifecycle) == null) && iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.registerGlobalLifeCycle(iActivityLifecycle);
        }
    }

    public static void registerLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, iActivityLifecycle) == null) && iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.registerLifeCycle(iActivityLifecycle);
        }
    }

    public static void setMainGlobalActivityLifecycle(BdBoxActivityLifecycle bdBoxActivityLifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, bdBoxActivityLifecycle) == null) {
            synchronized (BdBoxActivityLifecycle.class) {
                if (sMainGlobalActivityLifecycle == null) {
                    sMainGlobalActivityLifecycle = bdBoxActivityLifecycle;
                } else {
                    throw new IllegalStateException("The main activity lifecycle has already been initialized.");
                }
            }
        }
    }

    public static void unregisterLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, iActivityLifecycle) == null) && iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.unregisterLifeCycle(iActivityLifecycle);
        }
    }
}
