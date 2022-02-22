package com.baidu.searchbox.aideviceperformanceboxproxy.model;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformance.device.IDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformance.dynamic.IDynamicModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.amendedstaticscore.DefaultAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.device.DefaultDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformanceboxproxy.dynamic.DefaultDynamicModelProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes11.dex */
public class ModelProviderRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ModelProviderRuntime() {
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

    @Inject(force = false)
    public static IAmendedDeviceScoreModelProvider amendedDeviceScoreModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new DefaultAmendedDeviceScoreModelProvider() : (IAmendedDeviceScoreModelProvider) invokeV.objValue;
    }

    @Inject(force = false)
    public static IDeviceInfoModelProvider deviceInfoModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new DefaultDeviceInfoModelProvider() : (IDeviceInfoModelProvider) invokeV.objValue;
    }

    @Inject(force = false)
    public static IDynamicModelProvider dynamicModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new DefaultDynamicModelProvider() : (IDynamicModelProvider) invokeV.objValue;
    }
}
