package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class TimeHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TimeHelper() {
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

    public static long getDayDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, date, date2)) == null) ? (date.getTime() - date2.getTime()) / 86400000 : invokeLL.longValue;
    }

    public static long getFormatDateLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f(new SimpleDateFormat("yyyyMMdd").format(getNow()), 0L) : invokeV.longValue;
    }

    public static long getHourDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, date, date2)) == null) ? (date.getTime() - date2.getTime()) / 3600000 : invokeLL.longValue;
    }

    public static long getMinuteDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, date, date2)) == null) {
            long time = date.getTime() - date2.getTime();
            long j2 = (time / 86400000) * 24;
            return ((time / 60000) - (j2 * 60)) - (((time / 3600000) - j2) * 60);
        }
        return invokeLL.longValue;
    }

    public static Date getNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new Date(System.currentTimeMillis()) : (Date) invokeV.objValue;
    }

    public static long getSecondDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, date, date2)) == null) {
            long time = date.getTime() - date2.getTime();
            long j2 = (time / 86400000) * 24;
            long j3 = (time / 3600000) - j2;
            long j4 = j2 * 60;
            long j5 = j3 * 60;
            return (((time / 1000) - (j4 * 60)) - (j5 * 60)) - ((((time / 60000) - j4) - j5) * 60);
        }
        return invokeLL.longValue;
    }

    public static boolean isInTimeBlock(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return currentTimeMillis > j2 && currentTimeMillis < j3;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, date, date2)) == null) ? date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay() : invokeLL.booleanValue;
    }

    public static boolean isSameYear(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) ? new Date(j2).getYear() == new Date(System.currentTimeMillis()).getYear() : invokeJ.booleanValue;
    }

    public static boolean isTargetTimeInTimeBlock(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? j2 > j3 && j2 < j4 : invokeCommon.booleanValue;
    }

    public static boolean isSameDay(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            new SimpleDateFormat("yyyy-MM-dd");
            return isSameDay(new Date(j2), new Date(j3));
        }
        return invokeCommon.booleanValue;
    }
}
