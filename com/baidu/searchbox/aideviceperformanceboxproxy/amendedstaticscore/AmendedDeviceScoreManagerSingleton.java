package com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.AmendedDeviceScoreManager;
import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AmendedDeviceScoreManagerSingleton extends AmendedDeviceScoreManager {
    public static /* synthetic */ Interceptable $ic;
    public static AmendedDeviceScoreManagerSingleton sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936160374, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/amendedstaticscore/AmendedDeviceScoreManagerSingleton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936160374, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/amendedstaticscore/AmendedDeviceScoreManagerSingleton;");
                return;
            }
        }
        sInstance = new AmendedDeviceScoreManagerSingleton();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmendedDeviceScoreManagerSingleton() {
        super(ModelProviderRuntime.amendedDeviceScoreModelProvider());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((IAmendedDeviceScoreModelProvider) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static AmendedDeviceScoreManagerSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sInstance : (AmendedDeviceScoreManagerSingleton) invokeV.objValue;
    }
}
