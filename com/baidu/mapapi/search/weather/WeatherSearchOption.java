package com.baidu.mapapi.search.weather;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WeatherSearchOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeatherServerType a;
    public String b;
    public LatLng c;
    public WeatherDataType d;
    public LanguageType e;

    public WeatherSearchOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = WeatherServerType.WEATHER_SERVER_TYPE_DEFAULT;
        this.d = WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME;
        this.e = LanguageType.LanguageTypeChinese;
    }

    public WeatherDataType getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (WeatherDataType) invokeV.objValue;
    }

    public String getDistrictID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public LanguageType getLanguageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (LanguageType) invokeV.objValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (LatLng) invokeV.objValue;
    }

    public WeatherServerType getServerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (WeatherServerType) invokeV.objValue;
    }

    public WeatherSearchOption districtID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (WeatherSearchOption) invokeL.objValue;
    }

    public WeatherSearchOption languageType(LanguageType languageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, languageType)) == null) {
            this.e = languageType;
            return this;
        }
        return (WeatherSearchOption) invokeL.objValue;
    }

    public WeatherSearchOption location(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, latLng)) == null) {
            this.c = latLng;
            return this;
        }
        return (WeatherSearchOption) invokeL.objValue;
    }

    public WeatherSearchOption serverType(WeatherServerType weatherServerType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, weatherServerType)) == null) {
            this.a = weatherServerType;
            return this;
        }
        return (WeatherSearchOption) invokeL.objValue;
    }

    public WeatherSearchOption weatherDataType(WeatherDataType weatherDataType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, weatherDataType)) == null) {
            this.d = weatherDataType;
            return this;
        }
        return (WeatherSearchOption) invokeL.objValue;
    }
}
