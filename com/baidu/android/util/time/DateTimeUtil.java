package com.baidu.android.util.time;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
@Deprecated
/* loaded from: classes10.dex */
public final class DateTimeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final String YEAR_FORMAT = "yyyy";
    public static long mDelta;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1160393851, "Lcom/baidu/android/util/time/DateTimeUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1160393851, "Lcom/baidu/android/util/time/DateTimeUtil;");
        }
    }

    public DateTimeUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String convertSecondToHumanView(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? DateTimeUtils.convertSecondToHumanView(str) : (String) invokeL.objValue;
    }

    public static String getCalibratedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? String.valueOf((System.currentTimeMillis() / 1000) + mDelta) : (String) invokeV.objValue;
    }

    public static Date getCurrDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new Date() : (Date) invokeV.objValue;
    }

    public static Timestamp getCurrTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new Timestamp(System.currentTimeMillis()) : (Timestamp) invokeV.objValue;
    }

    public static long getDelta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? mDelta : invokeV.longValue;
    }

    public static String getFormatDate(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, date, str)) == null) ? DateTimeUtils.format(date, str) : (String) invokeLL.objValue;
    }

    public static String getFormatDateTime(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, date, str)) == null) ? DateTimeUtils.getFormatDateTime(date, str) : (String) invokeLL.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, context, j2)) == null) ? getFormatTeletextTime(context, j2, true) : (String) invokeLJ.objValue;
    }

    public static long getNextDay(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? DateTimeUtils.getNextDayByMode(j2, i2) : invokeCommon.longValue;
    }

    public static String getWeek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date()) : (String) invokeV.objValue;
    }

    public static String getWeekOfDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? DateTimeUtils.getWeekInZH() : (String) invokeV.objValue;
    }

    public static long interval(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, l, l2)) == null) ? DateTimeUtils.interval(l.longValue(), l2.longValue()) : invokeLL.longValue;
    }

    public static boolean isFewDaysAgo(Long l, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, l, i2)) == null) ? DateTimeUtils.isFewDaysAgo(l.longValue(), i2) : invokeLI.booleanValue;
    }

    public static boolean isSameDay(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, l, l2)) == null) ? DateTimeUtils.isSameDay(l.longValue(), l2.longValue()) : invokeLL.booleanValue;
    }

    public static boolean isToday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, date)) == null) ? DateTimeUtils.isToday(date) : invokeL.booleanValue;
    }

    public static boolean isYesterday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, date)) == null) ? DateTimeUtils.isYesterday(date) : invokeL.booleanValue;
    }

    public static void setDeltaTime(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, str) == null) || str == null) {
            return;
        }
        try {
            mDelta = Long.parseLong(str) - (System.currentTimeMillis() / 1000);
        } catch (Exception e2) {
            e2.printStackTrace();
            mDelta = 0L;
        }
    }

    public static Date getFormatDate(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? DateTimeUtils.format(str, str2) : (Date) invokeLL.objValue;
    }

    public static Date getFormatDateTime(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) ? DateTimeUtils.getFormatDateTime(str, str2) : (Date) invokeLL.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? DateTimeUtils.getFormatTeletextTime(context, j2, z) : (String) invokeCommon.objValue;
    }

    public static Date getFormatDate(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, strArr)) == null) ? DateTimeUtils.format(str, strArr) : (Date) invokeLL.objValue;
    }
}
