package com.baidu.platform.core.i;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class d {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056644321, "Lcom/baidu/platform/core/i/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056644321, "Lcom/baidu/platform/core/i/d;");
                return;
            }
        }
        int[] iArr = new int[LanguageType.values().length];
        c = iArr;
        try {
            iArr[LanguageType.LanguageTypeEnglish.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[LanguageType.LanguageTypeChinese.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[CoordType.values().length];
        b = iArr2;
        try {
            iArr2[CoordType.BD09LL.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[CoordType.GCJ02.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr3 = new int[WeatherDataType.values().length];
        a = iArr3;
        try {
            iArr3[WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_DAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[WeatherDataType.WEATHER_DATA_TYPE_LIFE_INDEX.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[WeatherDataType.WEATHER_DATA_TYPE_ALERT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[WeatherDataType.WEATHER_DATA_TYPE_ALL.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
