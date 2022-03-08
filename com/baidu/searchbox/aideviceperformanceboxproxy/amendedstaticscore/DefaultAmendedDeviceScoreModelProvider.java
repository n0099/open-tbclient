package com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DefaultAmendedDeviceScoreModelProvider implements IAmendedDeviceScoreModelProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultAmendedDeviceScoreModelProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.model.IDevicePerformanceModelInfoProvider
    public DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType devicePerformanceModelInfoType, DevicePerformanceModelInfo devicePerformanceModelInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, devicePerformanceModelInfoType, devicePerformanceModelInfo)) == null) ? devicePerformanceModelInfo : (DevicePerformanceModelInfo) invokeLL.objValue;
    }
}
