package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.gg;
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

    public static boolean isTargetTimeInTimeBlock(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j > j2 && j < j3 : invokeCommon.booleanValue;
    }

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

    public static long getFormatDateLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return gg.g(new SimpleDateFormat("yyyyMMdd").format(getNow()), 0L);
        }
        return invokeV.longValue;
    }

    public static Date getNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new Date(System.currentTimeMillis());
        }
        return (Date) invokeV.objValue;
    }

    public static long getDayDifference(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return getDayDifference(new Date(j), new Date(j2));
        }
        return invokeCommon.longValue;
    }

    public static long getMinuteDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, date, date2)) == null) {
            long time = date.getTime() - date2.getTime();
            long j = (time / 86400000) * 24;
            return ((time / 60000) - (j * 60)) - (((time / 3600000) - j) * 60);
        }
        return invokeLL.longValue;
    }

    public static long getSecondDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, date, date2)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > j && currentTimeMillis < j2) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            new SimpleDateFormat("yyyy-MM-dd");
            return isSameDay(new Date(j), new Date(j2));
        }
        return invokeCommon.booleanValue;
    }

    public static long getDayDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, date, date2)) == null) {
            return (date.getTime() - date2.getTime()) / 86400000;
        }
        return invokeLL.longValue;
    }

    public static long getHourDifference(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, date, date2)) == null) {
            return (date.getTime() - date2.getTime()) / 3600000;
        }
        return invokeLL.longValue;
    }

    public static boolean isAdjacentDays(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Date date = new Date(j);
            Date date2 = new Date(j2);
            if (date.getDate() + 1 == date2.getDate() && date.getMonth() == date2.getMonth() && date.getYear() == date2.getYear()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, date, date2)) == null) {
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isSameYear(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65548, null, j)) == null) {
            if (new Date(j).getYear() != new Date(System.currentTimeMillis()).getYear()) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }
}
