package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.DevicePortraitManager;
import com.baidu.searchbox.aideviceperformance.device.IDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig;
import com.baidu.searchbox.aideviceperformanceboxproxy.model.ModelProviderRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DevicePortraitManagerSingleton extends DevicePortraitManager {
    public static /* synthetic */ Interceptable $ic;
    public static DevicePortraitManagerSingleton sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1641657991, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/device/DevicePortraitManagerSingleton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1641657991, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/device/DevicePortraitManagerSingleton;");
                return;
            }
        }
        sInstance = new DevicePortraitManagerSingleton();
    }

    public static DevicePortraitManagerSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sInstance;
        }
        return (DevicePortraitManagerSingleton) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevicePortraitManagerSingleton() {
        super(DevicePortraitRuntime.getDefaultResultHandler(), DevicePortraitRuntime.getDefaultThresholdsConfig(), ModelProviderRuntime.deviceInfoModelProvider());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((IDevicePortraitResultHandler) objArr[0], (IDevicePortraitThresholdsConfig) objArr[1], (IDeviceInfoModelProvider) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
