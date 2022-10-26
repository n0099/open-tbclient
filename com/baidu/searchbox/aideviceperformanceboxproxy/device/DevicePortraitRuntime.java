package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitResultHandler;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DevicePortraitRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DevicePortraitRuntime() {
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

    public static IDevicePortraitResultHandler getDefaultResultHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new DefaultDevicePortraitResultHandler();
        }
        return (IDevicePortraitResultHandler) invokeV.objValue;
    }

    public static IDevicePortraitThresholdsConfig getDefaultThresholdsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DefaultIDevicePortraitThresholdsConfigProxy();
        }
        return (IDevicePortraitThresholdsConfig) invokeV.objValue;
    }
}
