package com.baidu.mapapi.search.weather;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class WeatherDataType {
    public static final /* synthetic */ WeatherDataType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WeatherDataType WEATHER_DATA_TYPE_ALERT;
    public static final WeatherDataType WEATHER_DATA_TYPE_ALL;
    public static final WeatherDataType WEATHER_DATA_TYPE_FORECASTS_FOR_DAY;
    public static final WeatherDataType WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR;
    public static final WeatherDataType WEATHER_DATA_TYPE_LIFE_INDEX;
    public static final WeatherDataType WEATHER_DATA_TYPE_REAL_TIME;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144277950, "Lcom/baidu/mapapi/search/weather/WeatherDataType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-144277950, "Lcom/baidu/mapapi/search/weather/WeatherDataType;");
                return;
            }
        }
        WEATHER_DATA_TYPE_REAL_TIME = new WeatherDataType("WEATHER_DATA_TYPE_REAL_TIME", 0);
        WEATHER_DATA_TYPE_FORECASTS_FOR_DAY = new WeatherDataType("WEATHER_DATA_TYPE_FORECASTS_FOR_DAY", 1);
        WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR = new WeatherDataType("WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR", 2);
        WEATHER_DATA_TYPE_LIFE_INDEX = new WeatherDataType("WEATHER_DATA_TYPE_LIFE_INDEX", 3);
        WEATHER_DATA_TYPE_ALERT = new WeatherDataType("WEATHER_DATA_TYPE_ALERT", 4);
        WeatherDataType weatherDataType = new WeatherDataType("WEATHER_DATA_TYPE_ALL", 5);
        WEATHER_DATA_TYPE_ALL = weatherDataType;
        $VALUES = new WeatherDataType[]{WEATHER_DATA_TYPE_REAL_TIME, WEATHER_DATA_TYPE_FORECASTS_FOR_DAY, WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR, WEATHER_DATA_TYPE_LIFE_INDEX, WEATHER_DATA_TYPE_ALERT, weatherDataType};
    }

    public WeatherDataType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static WeatherDataType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (WeatherDataType) Enum.valueOf(WeatherDataType.class, str);
        }
        return (WeatherDataType) invokeL.objValue;
    }

    public static WeatherDataType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (WeatherDataType[]) $VALUES.clone();
        }
        return (WeatherDataType[]) invokeV.objValue;
    }
}
