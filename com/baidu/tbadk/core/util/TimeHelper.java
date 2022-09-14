package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.dh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class TimeHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TimeHelper() {
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

    public static long getDayDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, date, date2)) == null) ? (date.getTime() - date2.getTime()) / 86400000 : invokeLL.longValue;
    }

    public static long getFormatDateLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? dh.g(new SimpleDateFormat("yyyyMMdd").format(getNow()), 0L) : invokeV.longValue;
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
            long j = (time / 86400000) * 24;
            return ((time / 60000) - (j * 60)) - (((time / 3600000) - j) * 60);
        }
        return invokeLL.longValue;
    }

    public static Date getNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new Date(System.currentTimeMillis()) : (Date) invokeV.objValue;
    }

    public static long getSecondDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, date, date2)) == null) {
            long time = date.getTime() - date2.getTime();
            long j = (time / 86400000) * 24;
            long j2 = (time / 3600000) - j;
            long j3 = j * 60;
            long j4 = j2 * 60;
            return (((time / 1000) - (j3 * 60)) - (j4 * 60)) - ((((time / 60000) - j3) - j4) * 60);
        }
        return invokeLL.longValue;
    }

    public static boolean isInTimeBlock(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return currentTimeMillis > j && currentTimeMillis < j2;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, date, date2)) == null) ? date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay() : invokeLL.booleanValue;
    }

    public static boolean isSameYear(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) ? new Date(j).getYear() == new Date(System.currentTimeMillis()).getYear() : invokeJ.booleanValue;
    }

    public static boolean isTargetTimeInTimeBlock(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j > j2 && j < j3 : invokeCommon.booleanValue;
    }

    public static boolean isSameDay(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            new SimpleDateFormat("yyyy-MM-dd");
            return isSameDay(new Date(j), new Date(j2));
        }
        return invokeCommon.booleanValue;
    }
}
