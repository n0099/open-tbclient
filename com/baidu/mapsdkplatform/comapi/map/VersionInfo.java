package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VersionInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KIT_NAME = "BaiduMapSDK_map_v";
    public static final String MAP_APPROVAL_NUMBER = "GS(2022)460号";
    public static final String MAP_COPYRIGHT = "长地万方\nMapbox\nMapKin\n樂客LocalKing PalmCit\nESO DigitalGlobal spaceview\nOSRM Copyright ©2017, Project OSRMcontributors, all rights reserved\nHERE© 2019 HERE, all rights reserved\nOpenStreetMap© OpenStreetMapContributor;(OSMF)";
    public static final String MAP_MAPPING_QUALIFICATION = "甲测资字11111342";
    public static final String VERSION_DESC = "baidumapapi_map";
    public transient /* synthetic */ FieldHolder $fh;

    public static String getApiVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? com.baidu.mapapi.VersionInfo.VERSION_INFO : (String) invokeV.objValue;
    }

    public static String getKitName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "BaiduMapSDK_map_v7_5_3" : (String) invokeV.objValue;
    }

    public static String getVersionDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? VERSION_DESC : (String) invokeV.objValue;
    }

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
}
