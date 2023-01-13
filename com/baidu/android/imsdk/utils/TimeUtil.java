package com.baidu.android.imsdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class TimeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PATTERN_DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public transient /* synthetic */ FieldHolder $fh;

    public TimeUtil() {
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

    public static String getFormatDateStr(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, str)) == null) {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        }
        return (String) invokeJL.objValue;
    }

    public static String getFormatDateStr(long j, String str, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), str, locale})) == null) {
            return new SimpleDateFormat(str, locale).format(new Date(j));
        }
        return (String) invokeCommon.objValue;
    }

    public static long getTimeSecondByInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            return (System.currentTimeMillis() - (j * 1000)) / 1000;
        }
        return invokeJ.longValue;
    }
}
