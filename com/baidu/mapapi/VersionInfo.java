package com.baidu.mapapi;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class VersionInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KIT_NAME = "BaiduMapSDK_base_v5_4_4";
    public static final String VERSION_DESC = "baidumapapi_base";
    public static final String VERSION_INFO = "5_4_4";
    public transient /* synthetic */ FieldHolder $fh;

    public VersionInfo() {
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

    public static String getApiVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? VERSION_INFO : (String) invokeV.objValue;
    }

    public static String getKitName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? KIT_NAME : (String) invokeV.objValue;
    }

    public static String getVersionDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? VERSION_DESC : (String) invokeV.objValue;
    }
}
