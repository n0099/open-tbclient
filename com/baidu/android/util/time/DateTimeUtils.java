package com.baidu.android.util.time;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes8.dex */
public final class DateTimeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT_MONTH_CN = "MM月dd日";
    public static final String MD = "MM-dd";
    public static final int MODE_NEXT_NORMAL_DAY = 1;
    public static final int MODE_NEXT_WEEKEND = 3;
    public static final int MODE_NEXT_WORKDAY = 2;
    public static final String MONTH_FORMAT = "yyyy-MM";
    public static long MSEC_OF_ONE_DAY = 86400000;
    public static long MSEC_OF_ONE_HOUR = 3600000;
    public static long MSEC_OF_ONE_MINUTE = 60000;
    public static long MSEC_OF_ONE_SEC = 1000;
    public static final Set<Integer> NORMAL_DAY;
    public static final int TIME_DAY_MILLISECOND = 86400000;
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final Set<Integer> WEEKEND_DAY;
    public static final Set<Integer> WORK_DAY;
    public static final String Y4MD = "yyyy-MM-dd";
    public static final String Y4MD_HM = "yyyy-MM-dd HH:mm";
    public static final String YEAR_FORMAT = "yyyy";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1612472808, "Lcom/baidu/android/util/time/DateTimeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1612472808, "Lcom/baidu/android/util/time/DateTimeUtils;");
                return;
            }
        }
        WORK_DAY = new HashSet();
        WEEKEND_DAY = new HashSet();
        NORMAL_DAY = new HashSet();
        WORK_DAY.add(2);
        WORK_DAY.add(3);
        WORK_DAY.add(4);
        WORK_DAY.add(5);
        WORK_DAY.add(6);
        WEEKEND_DAY.add(7);
        WEEKEND_DAY.add(1);
        NORMAL_DAY.addAll(WORK_DAY);
        NORMAL_DAY.addAll(WEEKEND_DAY);
    }

    public DateTimeUtils() {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return "00:00";
            }
            long parseLong = Long.parseLong(str);
            return String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60));
        }
        return (String) invokeL.objValue;
    }

    public static String format(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Date getCurrDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new Date() : (Date) invokeV.objValue;
    }

    public static Timestamp getCurrTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new Timestamp(System.currentTimeMillis()) : (Timestamp) invokeV.objValue;
    }

    public static String getFormatDateTime(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, context, j2)) == null) ? getFormatTeletextTime(context, j2, true) : (String) invokeLJ.objValue;
    }

    public static long getNextDayByMode(long j2, int i2) {
        InterceptResult invokeCommon;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (i2 == 1) {
                set = NORMAL_DAY;
            } else if (i2 == 2) {
                set = WORK_DAY;
            } else if (i2 != 3) {
                set = NORMAL_DAY;
            } else {
                set = WEEKEND_DAY;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 + 86400000);
            while (!set.contains(Integer.valueOf(calendar.get(7)))) {
                calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000);
            }
            return calendar.getTimeInMillis();
        }
        return invokeCommon.longValue;
    }

    public static String getTextWithSecond(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return "";
            }
            int i3 = i2 / 3600;
            int i4 = (i2 % 3600) / 60;
            int i5 = i2 % 60;
            return (i3 != 0 || z) ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
        }
        return (String) invokeCommon.objValue;
    }

    public static String getWeek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date()) : (String) invokeV.objValue;
    }

    public static String getWeekInZH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? getWeekInZH(new Date()) : (String) invokeV.objValue;
    }

    public static long interval(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.abs((j3 - j2) / 86400000) : invokeCommon.longValue;
    }

    public static boolean isFewDaysAgo(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(6, -i2);
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(j2);
            return calendar3.after(calendar2) && calendar3.before(calendar);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isToday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, date)) == null) {
            if (date == null) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeL.booleanValue;
    }

    public static boolean isYesterday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, date)) == null) {
            if (date == null) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, -1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeL.booleanValue;
    }

    public static String getFormatTeletextTime(Context context, long j2, boolean z) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            try {
                j3 = System.currentTimeMillis();
                j4 = j3 - j2;
                if (j4 >= 0) {
                    j3 = j2;
                }
            } catch (Exception e2) {
                e = e2;
                j3 = j2;
            }
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j3);
                long j5 = (j4 % MSEC_OF_ONE_DAY) / MSEC_OF_ONE_HOUR;
                long j6 = ((j4 % MSEC_OF_ONE_DAY) % MSEC_OF_ONE_HOUR) / MSEC_OF_ONE_MINUTE;
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(11, 0);
                calendar2.set(12, 0);
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                boolean z2 = calendar.get(1) == calendar2.get(1);
                Calendar calendar3 = Calendar.getInstance();
                calendar3.add(2, -1);
                calendar3.set(11, 0);
                calendar3.set(12, 0);
                calendar3.set(13, 0);
                calendar3.set(14, 0);
                if (calendar.after(calendar2)) {
                    return j5 > 0 ? String.format(context.getString(R.string.time_liveshow_teletext_time_hour_before), Long.valueOf(j5)) : j6 > 0 ? String.format(context.getString(R.string.time_liveshow_teletext_time_min_before), Long.valueOf(j6)) : context.getString(R.string.time_liveshow_teletext_time_sec_before);
                } else if (calendar.after(calendar3)) {
                    return String.format(context.getString(R.string.time_liveshow_teletext_time_day_before), Integer.valueOf((int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / MSEC_OF_ONE_DAY) + 1)));
                } else {
                    if (z2) {
                        return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(calendar.getTime());
                    }
                    return new SimpleDateFormat(z ? "yyyy-MM-dd HH:mm" : "yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return String.valueOf(j3);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String getWeekInZH(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, date)) == null) {
            String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int i2 = calendar.get(7) - 1;
            if (i2 < 0) {
                i2 = 0;
            }
            return strArr[i2];
        }
        return (String) invokeL.objValue;
    }

    public static Date format(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (Date) invokeLL.objValue;
    }

    public static Date getFormatDateTime(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (Date) invokeLL.objValue;
    }

    public static String getTextWithSecond(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? getTextWithSecond(i2, true) : (String) invokeI.objValue;
    }

    public static Date getNextDayByMode(Date date, int i2) {
        InterceptResult invokeLI;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, date, i2)) == null) {
            if (i2 == 1) {
                set = NORMAL_DAY;
            } else if (i2 == 2) {
                set = WORK_DAY;
            } else if (i2 != 3) {
                set = NORMAL_DAY;
            } else {
                set = WEEKEND_DAY;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(5, 1);
            while (!set.contains(Integer.valueOf(calendar.get(7)))) {
                calendar.add(5, 1);
            }
            return calendar.getTime();
        }
        return (Date) invokeLI.objValue;
    }

    public static Date format(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, strArr)) == null) {
            Date date = null;
            if (!TextUtils.isEmpty(str) && strArr != null) {
                for (String str2 : strArr) {
                    try {
                        date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (date != null) {
                        break;
                    }
                }
            }
            return date;
        }
        return (Date) invokeLL.objValue;
    }
}
