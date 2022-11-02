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
public final class WeatherServerType {
    public static final /* synthetic */ WeatherServerType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final WeatherServerType LANGUAGE_SERVER_TYPE_ABROAD;
    public static final WeatherServerType WEATHER_SERVER_TYPE_DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353591177, "Lcom/baidu/mapapi/search/weather/WeatherServerType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(353591177, "Lcom/baidu/mapapi/search/weather/WeatherServerType;");
                return;
            }
        }
        WEATHER_SERVER_TYPE_DEFAULT = new WeatherServerType("WEATHER_SERVER_TYPE_DEFAULT", 0);
        WeatherServerType weatherServerType = new WeatherServerType("LANGUAGE_SERVER_TYPE_ABROAD", 1);
        LANGUAGE_SERVER_TYPE_ABROAD = weatherServerType;
        $VALUES = new WeatherServerType[]{WEATHER_SERVER_TYPE_DEFAULT, weatherServerType};
    }

    public WeatherServerType(String str, int i) {
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

    public static WeatherServerType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (WeatherServerType) Enum.valueOf(WeatherServerType.class, str);
        }
        return (WeatherServerType) invokeL.objValue;
    }

    public static WeatherServerType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (WeatherServerType[]) $VALUES.clone();
        }
        return (WeatherServerType[]) invokeV.objValue;
    }
}
