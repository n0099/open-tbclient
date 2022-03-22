package com.baidu.searchbox.appframework;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GlobalActivityLifecycle extends BdBoxActivityLifecycle {
    public static /* synthetic */ Interceptable $ic;
    public static GlobalActivityLifecycle sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public GlobalActivityLifecycle() {
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

    public static GlobalActivityLifecycle getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (GlobalActivityLifecycle.class) {
                    if (sInstance == null) {
                        sInstance = new GlobalActivityLifecycle();
                        AppRuntime.getApplication().registerActivityLifecycleCallbacks(sInstance);
                    }
                }
            }
            return sInstance;
        }
        return (GlobalActivityLifecycle) invokeV.objValue;
    }
}
