package com.baidu.searchbox.aideviceperformanceboxproxy.device;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DefaultIDevicePortraitThresholdsConfigProxy implements IDevicePortraitThresholdsConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static float sThresholdLowMid = -1.0f;
    public static float sThresholdMidHigh = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1384614635, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/device/DefaultIDevicePortraitThresholdsConfigProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1384614635, "Lcom/baidu/searchbox/aideviceperformanceboxproxy/device/DefaultIDevicePortraitThresholdsConfigProxy;");
        }
    }

    public DefaultIDevicePortraitThresholdsConfigProxy() {
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

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig
    public float getThresholdLowMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (sThresholdLowMid < 0.0f) {
                sThresholdLowMid = 0.35f;
            }
            return sThresholdLowMid;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.device.IDevicePortraitThresholdsConfig
    public float getThresholdMidHigh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (sThresholdMidHigh < 0.0f) {
                sThresholdMidHigh = 0.6f;
            }
            return sThresholdMidHigh;
        }
        return invokeV.floatValue;
    }
}
