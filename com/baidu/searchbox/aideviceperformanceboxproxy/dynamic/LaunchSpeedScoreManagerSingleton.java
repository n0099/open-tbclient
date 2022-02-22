package com.baidu.searchbox.aideviceperformanceboxproxy.dynamic;

import com.baidu.searchbox.aideviceperformance.dynamic.IDynamicModelProvider;
import com.baidu.searchbox.aideviceperformance.dynamic.LaunchSpeedScoreManager;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LaunchSpeedScoreManagerSingleton extends LaunchSpeedScoreManager {
    public static /* synthetic */ Interceptable $ic;
    public static LaunchSpeedScoreManagerSingleton sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1713214043, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/dynamic/LaunchSpeedScoreManagerSingleton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1713214043, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/dynamic/LaunchSpeedScoreManagerSingleton;");
                return;
            }
        }
        sInstance = new LaunchSpeedScoreManagerSingleton();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchSpeedScoreManagerSingleton() {
        super(ModelProviderRuntime.dynamicModelProvider());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((IDynamicModelProvider) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static LaunchSpeedScoreManagerSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sInstance : (LaunchSpeedScoreManagerSingleton) invokeV.objValue;
    }
}
