package com.baidu.searchbox;

import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class StartupCountStatsController {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean hasInit;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(514588364, "Lcom/baidu/searchbox/StartupCountStatsController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(514588364, "Lcom/baidu/searchbox/StartupCountStatsController;");
        }
    }

    public StartupCountStatsController() {
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

    public static void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || hasInit) {
            return;
        }
        synchronized (StartupCountStatsController.class) {
            if (!hasInit) {
                if (BdBoxActivityManager.getMainGlobalActivityLifecycle() == null) {
                    BdBoxActivityManager.setMainGlobalActivityLifecycle(GlobalActivityLifecycle.getInstance());
                }
                BdBoxActivityManager.registerLifeCycle(new StartupCountStats());
                hasInit = true;
            }
        }
    }

    public static void resetDefaultUploadID() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            StartupCountStats.setStartupCountUploadId(StartupCountStatsUtils.MEG_STARTUP_UBC_ID);
            StartupCountStats.setUseDurationUploadId("18");
        }
    }
}
