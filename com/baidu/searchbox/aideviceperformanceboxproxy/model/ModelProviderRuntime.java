package com.baidu.searchbox.aideviceperformanceboxproxy.model;

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
/* loaded from: classes2.dex */
public class ModelProviderRuntime {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ModelProviderRuntime() {
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

    public static IAmendedDeviceScoreModelProvider amendedDeviceScoreModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new DefaultAmendedDeviceScoreModelProvider();
        }
        return (IAmendedDeviceScoreModelProvider) invokeV.objValue;
    }

    public static IDeviceInfoModelProvider deviceInfoModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DefaultDeviceInfoModelProvider();
        }
        return (IDeviceInfoModelProvider) invokeV.objValue;
    }

    public static IDynamicModelProvider dynamicModelProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new DefaultDynamicModelProvider();
        }
        return (IDynamicModelProvider) invokeV.objValue;
    }
}
