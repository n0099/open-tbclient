package com.baidu.android.util.time;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
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
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Date getCurrDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new Date();
        }
        return (Date) invokeV.objValue;
    }

    public static Timestamp getCurrTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new Timestamp(System.currentTimeMillis());
        }
        return (Timestamp) invokeV.objValue;
    }

    public static String getWeek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        }
        return (String) invokeV.objValue;
    }

    public static String getWeekInZH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return getWeekInZH(new Date());
        }
        return (String) invokeV.objValue;
    }

    public static String convertSecondToHumanView(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                long parseLong = Long.parseLong(str);
                return String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60));
            }
            return BdPlayerProgressView.DEFAULT_TIME_TEXT;
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return (String) invokeLL.objValue;
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
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
                } catch (Exception e) {
                    e.printStackTrace();
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return (Date) invokeLL.objValue;
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
                    } catch (Exception e) {
                        e.printStackTrace();
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

    public static String getFormatTeletextTime(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, context, j)) == null) {
            return getFormatTeletextTime(context, j, true);
        }
        return (String) invokeLJ.objValue;
    }

    public static long interval(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return Math.abs((j2 - j) / 86400000);
        }
        return invokeCommon.longValue;
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        long j3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            try {
                j2 = System.currentTimeMillis();
                j3 = j2 - j;
                if (j3 >= 0) {
                    j2 = j;
                }
            } catch (Exception e) {
                e = e;
                j2 = j;
            }
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j2);
                long j4 = (j3 % MSEC_OF_ONE_DAY) / MSEC_OF_ONE_HOUR;
                long j5 = ((j3 % MSEC_OF_ONE_DAY) % MSEC_OF_ONE_HOUR) / MSEC_OF_ONE_MINUTE;
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(11, 0);
                calendar2.set(12, 0);
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                if (calendar.get(1) == calendar2.get(1)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Calendar calendar3 = Calendar.getInstance();
                calendar3.add(2, -1);
                calendar3.set(11, 0);
                calendar3.set(12, 0);
                calendar3.set(13, 0);
                calendar3.set(14, 0);
                if (calendar.after(calendar2)) {
                    if (j4 > 0) {
                        return String.format(context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c3), Long.valueOf(j4));
                    }
                    if (j5 > 0) {
                        return String.format(context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c4), Long.valueOf(j5));
                    }
                    return context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c5);
                } else if (calendar.after(calendar3)) {
                    return String.format(context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16c2), Integer.valueOf((int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / MSEC_OF_ONE_DAY) + 1)));
                } else {
                    if (z2) {
                        return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(calendar.getTime());
                    }
                    Date time = calendar.getTime();
                    String str = "yyyy-MM-dd";
                    if (z) {
                        str = "yyyy-MM-dd HH:mm";
                    }
                    return new SimpleDateFormat(str, Locale.getDefault()).format(time);
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return String.valueOf(j2);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static long getNextDayByMode(long j, int i) {
        InterceptResult invokeCommon;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        set = NORMAL_DAY;
                    } else {
                        set = WEEKEND_DAY;
                    }
                } else {
                    set = WORK_DAY;
                }
            } else {
                set = NORMAL_DAY;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j + 86400000);
            while (!set.contains(Integer.valueOf(calendar.get(7)))) {
                calendar.setTimeInMillis(calendar.getTimeInMillis() + 86400000);
            }
            return calendar.getTimeInMillis();
        }
        return invokeCommon.longValue;
    }

    public static boolean isFewDaysAgo(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(6, -i);
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(j);
            if (!calendar3.after(calendar2) || !calendar3.before(calendar)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSameDay(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static Date getNextDayByMode(Date date, int i) {
        InterceptResult invokeLI;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, date, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        set = NORMAL_DAY;
                    } else {
                        set = WEEKEND_DAY;
                    }
                } else {
                    set = WORK_DAY;
                }
            } else {
                set = NORMAL_DAY;
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

    public static String getTextWithSecond(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            return getTextWithSecond(i, true);
        }
        return (String) invokeI.objValue;
    }

    public static String getTextWithSecond(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i < 0) {
                return "";
            }
            int i2 = i / 3600;
            int i3 = (i % 3600) / 60;
            int i4 = i % 60;
            if (i2 == 0 && !z) {
                return String.format(Locale.US, "%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4));
            }
            return String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
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
            int i = calendar.get(7) - 1;
            if (i < 0) {
                i = 0;
            }
            return strArr[i];
        }
        return (String) invokeL.objValue;
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
            if (calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
                return false;
            }
            return true;
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
            if (calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
