package com.baidu.platform.domain;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.baidu.platform.domain.c
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/place/v2/search" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/place/v2/detail" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/indoor/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/place/v2/suggestion" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/geocoder/v2" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/geocoder/v2" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/pathplan/v2/transit" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui2/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui2/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/pathplan/v2/riding" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui2/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui2/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/phpui2/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/apimap/v1/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "https://j.map.baidu.com/" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "https://client.map.baidu.com/imap/share/ps" : (String) invokeV.objValue;
    }

    @Override // com.baidu.platform.domain.c
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "https://api.map.baidu.com/sdkproxy/lbs_androidsdk/apimap/v1/s" : (String) invokeV.objValue;
    }
}
