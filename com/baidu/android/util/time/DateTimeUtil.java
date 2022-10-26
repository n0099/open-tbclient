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
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getCalibratedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return String.valueOf((System.currentTimeMillis() / 1000) + mDelta);
        }
        return (String) invokeV.objValue;
    }

    public static Date getCurrDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new Date();
        }
        return (Date) invokeV.objValue;
    }

    public static Timestamp getCurrTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new Timestamp(System.currentTimeMillis());
        }
        return (Timestamp) invokeV.objValue;
    }

    public static long getDelta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return mDelta;
        }
        return invokeV.longValue;
    }

    public static String getWeek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        }
        return (String) invokeV.objValue;
    }

    public static String getWeekOfDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return DateTimeUtils.getWeekInZH();
        }
        return (String) invokeV.objValue;
    }

    public static String convertSecondToHumanView(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return DateTimeUtils.convertSecondToHumanView(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean isToday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, date)) == null) {
            return DateTimeUtils.isToday(date);
        }
        return invokeL.booleanValue;
    }

    public static boolean isYesterday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, date)) == null) {
            return DateTimeUtils.isYesterday(date);
        }
        return invokeL.booleanValue;
    }

    public static void setDeltaTime(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65558, null, str) != null) || str == null) {
            return;
        }
        try {
            mDelta = Long.parseLong(str) - (System.currentTimeMillis() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            mDelta = 0L;
        }
    }

    public static String getFormatDate(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, date, str)) == null) {
            return DateTimeUtils.format(date, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String getFormatDateTime(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, date, str)) == null) {
            return DateTimeUtils.getFormatDateTime(date, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, null, context, j)) == null) {
            return getFormatTeletextTime(context, j, true);
        }
        return (String) invokeLJ.objValue;
    }

    public static long getNextDay(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return DateTimeUtils.getNextDayByMode(j, i);
        }
        return invokeCommon.longValue;
    }

    public static long interval(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, l, l2)) == null) {
            return DateTimeUtils.interval(l.longValue(), l2.longValue());
        }
        return invokeLL.longValue;
    }

    public static boolean isFewDaysAgo(Long l, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, l, i)) == null) {
            return DateTimeUtils.isFewDaysAgo(l.longValue(), i);
        }
        return invokeLI.booleanValue;
    }

    public static boolean isSameDay(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, l, l2)) == null) {
            return DateTimeUtils.isSameDay(l.longValue(), l2.longValue());
        }
        return invokeLL.booleanValue;
    }

    public static Date getFormatDate(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return DateTimeUtils.format(str, str2);
        }
        return (Date) invokeLL.objValue;
    }

    public static Date getFormatDateTime(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            return DateTimeUtils.getFormatDateTime(str, str2);
        }
        return (Date) invokeLL.objValue;
    }

    public static Date getFormatDate(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, strArr)) == null) {
            return DateTimeUtils.format(str, strArr);
        }
        return (Date) invokeLL.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return DateTimeUtils.getFormatTeletextTime(context, j, z);
        }
        return (String) invokeCommon.objValue;
    }
}
