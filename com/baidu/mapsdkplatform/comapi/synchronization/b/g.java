package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/trip/search" : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "http://cp01-lbs-api01.cp01.baidu.com:8108/lbs_navsdk_mini/tripshare/v1/trip/search" : (String) invokeV.objValue;
    }
}
