package com.baidu.tbadk.core.util;

import android.net.ParseException;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.e.e.p.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes6.dex */
public class StringHelper extends k {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ALA_CARD_DAY_BEFORE = null;
    public static String ALA_CARD_HOUR_BEFORE = null;
    public static String ALA_CARD_MIN_BEFORE = null;
    public static final SimpleDateFormat FORMATE_DATE_DAY_TIME;
    public static final SimpleDateFormat FORMATE_DATE_HOUR;
    public static final SimpleDateFormat FORMATE_DATE_SECOND;
    public static final SimpleDateFormat FORMATE_DATE_SECOND_CHINESE;
    public static final SimpleDateFormat FORMATE_DATE_YEAR_M_D;
    public static final SimpleDateFormat FORMATE_MONTH_DAY;
    public static final SimpleDateFormat FORMATE_MONTH_DAY_HOUR_MINUTE;
    public static final SimpleDateFormat FORMAT_DATE_MONTH_SECOND_;
    public static final SimpleDateFormat FORMAT_DATE_YEAR_SECOND;
    public static final SimpleDateFormat FORMAT_MONTH_DAY_CHINEASE;
    public static String HOUR_BEFORE = null;
    public static String MIN_BEFORE = null;
    public static long MS_TO_DAY = 0;
    public static long MS_TO_HOUR = 0;
    public static long MS_TO_MIN = 0;
    public static long MS_TO_SEC = 1000;
    public static String SEC_BEFORE = null;
    public static float SIZE_FLOAT_G = 1.0737418E9f;
    public static float SIZE_FLOAT_K = 1024.0f;
    public static float SIZE_FLOAT_M = 1048576.0f;
    public static final String STRING_MORE = "...";
    public static String TIME_DAY;
    public static String TIME_HOUR;
    public static String TIME_MINUTE;
    public static String TIME_SECOND;
    public static Date date;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-650186212, "Lcom/baidu/tbadk/core/util/StringHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-650186212, "Lcom/baidu/tbadk/core/util/StringHelper;");
                return;
            }
        }
        long j2 = 1000 * 60;
        MS_TO_MIN = j2;
        long j3 = j2 * 60;
        MS_TO_HOUR = j3;
        MS_TO_DAY = j3 * 24;
        HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour_before);
        MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_min_before);
        SEC_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_sec_before);
        TIME_DAY = TbadkCoreApplication.getInst().getApp().getString(R.string.day);
        TIME_HOUR = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour);
        TIME_MINUTE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_minute);
        TIME_SECOND = TbadkCoreApplication.getInst().getApp().getString(R.string.time_second);
        ALA_CARD_DAY_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_day);
        ALA_CARD_HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_hour);
        ALA_CARD_MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.ala_card_create_min);
        FORMATE_DATE_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FORMATE_DATE_SECOND_CHINESE = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
        FORMATE_DATE_DAY_TIME = new SimpleDateFormat("dd日HH:mm");
        FORMATE_DATE_HOUR = new SimpleDateFormat("HH:mm");
        FORMATE_DATE_YEAR_M_D = new SimpleDateFormat("yyyy-MM-dd");
        FORMATE_MONTH_DAY_HOUR_MINUTE = new SimpleDateFormat("MM-dd HH:mm");
        FORMATE_MONTH_DAY = new SimpleDateFormat("MM-dd");
        FORMAT_MONTH_DAY_CHINEASE = new SimpleDateFormat("MM月dd日");
        FORMAT_DATE_YEAR_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        FORMAT_DATE_MONTH_SECOND_ = new SimpleDateFormat("MM-dd HH:mm");
        date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            k.FORMATE_DATE_ALL.setTimeZone(timeZone);
            k.FORMATE_DATE_YEAR.setTimeZone(timeZone);
            k.FORMATE_DATE_TIME.setTimeZone(timeZone);
            k.FORMATE_DATE_MOUTH.setTimeZone(timeZone);
            k.FORMATE_DATE_MOUTH_TIME.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_WEEK.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_1.setTimeZone(timeZone);
            k.FORMATE_DATE_MS.setTimeZone(timeZone);
            k.FORMATE_DATE_DAY_NO_YEAR.setTimeZone(timeZone);
        }
    }

    public StringHelper() {
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

    public static String GetPostTimeString(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date2)) == null) ? date2 == null ? "" : getPostTimeString(new Date(), date2) : (String) invokeL.objValue;
    }

    public static String JsonArrayToString(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = jSONArray.length();
            int i2 = 0;
            while (i2 < length) {
                try {
                    sb.append(jSONArray.get(i2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                i2++;
                if (i2 < length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            long[] parseVersion = parseVersion(str);
            long[] parseVersion2 = parseVersion(str2);
            long j2 = 0;
            long j3 = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                j3 += parseVersion[i2] << (24 - (i2 * 8));
            }
            for (int i3 = 0; i3 < 3; i3++) {
                j2 += parseVersion2[i3] << (24 - (i3 * 8));
            }
            int i4 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
            if (i4 > 0) {
                return 1;
            }
            return i4 == 0 ? 0 : -1;
        }
        return invokeLL.intValue;
    }

    public static String cutChineseAndEnglishWithEmoji(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, str, i2, str2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            int i5 = i3 + 1;
            if (i5 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                String substring = str.substring(0, str.offsetByCodePoints(0, str.codePointCount(0, i5)));
                if (str.equals(substring)) {
                    return substring;
                }
                return substring + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String cutChineseAndEnglishWithSuffix(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i2, str2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            int i5 = i3 + 1;
            if (i5 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                return str.substring(0, i5) + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String cutForumNameWithSuffix(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65544, null, str, i2, str2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            int i5 = i3 + 1;
            if (i5 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                if (i4 + 2 < i2) {
                    return str.substring(0, i5) + str2;
                }
                return str.substring(0, i3) + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String cutHotTopicShow(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i2, str2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            if (str.indexOf("#") == 0 && str.lastIndexOf("#") == length - 1) {
                String replaceAll = str.replaceAll("#", "");
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    i4 = k.isChinese(replaceAll.charAt(i3)) ? i4 + 2 : i4 + 1;
                    if (i4 >= i2) {
                        break;
                    }
                    i3++;
                }
                StringBuilder sb = new StringBuilder();
                int i5 = i3 + 1;
                if (i5 < length) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append("#");
                    sb.append(replaceAll.substring(0, i5));
                    sb.append(str2);
                    sb.append("#");
                    return sb.toString();
                }
                sb.append("#");
                sb.append(replaceAll);
                sb.append("#");
                return sb.toString();
            }
            return cutChineseAndEnglishWithSuffix(str, i2, str2);
        }
        return (String) invokeLIL.objValue;
    }

    @Deprecated
    public static String cutStringWithEllipsis(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) ? (str == null || i2 < 0 || str.length() == i2) ? str : cutStringWithSuffix(str, i2 - 1, "...") : (String) invokeLI.objValue;
    }

    public static String cutStringWithEllipsisNew(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i2)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (i2 <= 0) {
                return str;
            }
            try {
                if (str.codePointCount(0, str.length()) <= i2) {
                    return str;
                }
                String substring = str.substring(0, str.offsetByCodePoints(0, i2 - 1));
                return substring + "...";
            } catch (Throwable th) {
                BdLog.e(th);
                return str;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String cutStringWithEllipsisStrict(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(str.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            if (i4 > i2 || i3 + 1 < length) {
                if (i4 + 2 < i2) {
                    return str.substring(0, i3 + 1) + "...";
                }
                return str.substring(0, i3) + "...";
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String cutStringWithSuffix(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, str, i2, str2)) == null) {
            if (str == null || i2 < 0 || str.length() <= i2) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, i2));
            if (str2 == null) {
                sb.append("");
            } else {
                sb.append(str2);
            }
            return sb.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public static String dateToConstellation(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, date2)) == null) {
            if (date2 == null) {
                return null;
            }
            String[] strArr = {"宝瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "室女座", "天秤座", "天蝎座", "人马座", "摩羯座"};
            int[] iArr = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date2);
                int i2 = calendar.get(5);
                int i3 = calendar.get(2);
                if (i2 < iArr[i3]) {
                    i3--;
                }
                if (i3 < 0) {
                    i3 = 11;
                }
                if (i3 >= 0 && i3 <= 11) {
                    return strArr[i3];
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean equals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            return str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static String forceLToR(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (k.isEmpty(str)) {
                return "";
            }
            return "\u202d" + str + "\u202c";
        }
        return (String) invokeL.objValue;
    }

    public static String formatDayOrHourTime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65554, null, j2)) == null) {
            int i2 = (int) (j2 / 3600000);
            if (i2 >= 24) {
                return ((i2 / 24) + 1) + TIME_DAY;
            }
            return (i2 + 1) + TIME_HOUR;
        }
        return (String) invokeJ.objValue;
    }

    public static String formatDayTime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65555, null, j2)) == null) {
            return (((j2 / 3600000) / 24) + 1) + TIME_DAY;
        }
        return (String) invokeJ.objValue;
    }

    public static String formatDistanceNum(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Double.valueOf(d2)})) == null) {
            String format = String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2));
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
            if ("0".equals(format)) {
                format = "0.1";
            }
            return "<" + format + "km";
        }
        return (String) invokeCommon.objValue;
    }

    public static String formatGiftNumForTDouDisPlay(long j2) {
        InterceptResult invokeJ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65557, null, j2)) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            String valueOf = String.valueOf(j2);
            if (j2 < 100000000) {
                if (j2 >= 10000000) {
                    float f2 = ((float) j2) / 10000.0f;
                    long j3 = j2 / 10000;
                    if (j2 % 10000000 > 999) {
                        return String.format("%.2f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                    }
                    return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return valueOf;
            }
            long j4 = j2 % 100000000;
            if (j4 != 0) {
                double d2 = ((float) j2) / 1.0E8f;
                double d3 = j2 / 100000000;
                if (j4 > 999999.0d) {
                    str = String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                } else {
                    str = d3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return str;
            }
            return (j2 / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        }
        return (String) invokeJ.objValue;
    }

    public static String formatNumForTdouDisPlay(long j2) {
        InterceptResult invokeJ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65558, null, j2)) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            String valueOf = String.valueOf(j2);
            if (j2 < 100000000) {
                if (j2 >= 1000000) {
                    float f2 = ((float) j2) / 10000.0f;
                    long j3 = j2 / 10000;
                    if (j2 % 1000000 > 999) {
                        return String.format("%.2f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                    }
                    return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return valueOf;
            }
            long j4 = j2 % 100000000;
            if (j4 != 0) {
                double d2 = ((float) j2) / 1.0E8f;
                double d3 = j2 / 100000000;
                if (j4 > 999999.0d) {
                    str = String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                } else {
                    str = d3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return str;
            }
            return (j2 / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
        }
        return (String) invokeJ.objValue;
    }

    public static String formatOverBaiwanNum(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65559, null, f2)) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            String valueOf = String.valueOf(f2);
            if (f2 >= 1.0E8f) {
                if (f2 % 1.0E8f != 0.0f) {
                    double d2 = f2 / 1.0E8f;
                    return String.format("%.1f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (f2 / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (f2 >= 1000000.0f) {
                float f3 = f2 / 10000.0f;
                long j2 = f3;
                if (f3 > ((float) j2)) {
                    return String.format("%.1f", Float.valueOf(f3)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeF.objValue;
    }

    public static String formatSecondsTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i2)) == null) {
            int i3 = i2 / 1000;
            int i4 = i3 % 60;
            int i5 = (i3 / 60) % 60;
            int i6 = i3 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            return i6 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
        }
        return (String) invokeI.objValue;
    }

    public static String formatTosepara(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i2)) == null) ? new DecimalFormat("#,###").format(i2) : (String) invokeI.objValue;
    }

    public static String formatYdouOverBaiwanNum(float f2) {
        InterceptResult invokeF;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65565, null, f2)) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 >= 1.0E8f) {
                if (f2 % 1.0E8f != 0.0f) {
                    double d2 = f2 / 1.0E8f;
                    return String.format("%.2f", Double.valueOf(d2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (f2 / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (f2 < 1000000.0f) {
                int i2 = (int) f2;
                if (f2 > i2) {
                    return ((int) (100.0f * f2)) % 10 == 0 ? String.format("%.1f", Float.valueOf(f2)) : String.format("%.2f", Float.valueOf(f2));
                }
                return String.valueOf(i2);
            } else {
                long j2 = f2 / 10000;
                if (f2 / 10000.0f > ((float) j2)) {
                    return String.format("%.2f", Float.valueOf(f3)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            }
        }
        return (String) invokeF.objValue;
    }

    public static String getBaAgeAutoYearAndMonth(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1);
            }
            float c2 = b.c(str, 0.0f);
            if (c2 > 1.0f) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), Integer.valueOf(Math.round(c2)));
            }
            int round = Math.round(c2 * 12.0f);
            return round >= 12 ? String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), 1) : round < 1 ? String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1) : String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), Integer.valueOf(round));
        }
        return (String) invokeL.objValue;
    }

    public static String getChatTimeString(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, date2)) == null) ? getChatTimeString(new Date(), date2) : (String) invokeL.objValue;
    }

    public static int getChineseAndEnglishLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = k.isChinese(str.charAt(i3)) ? i2 + 2 : i2 + 1;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String getChineseFormatTimeString(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMATE_DATE_SECOND_CHINESE) {
                format = FORMATE_DATE_SECOND_CHINESE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getChineseMonthBytime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65572, null, j2)) == null) {
            switch (new Date(j2).getMonth() + 1) {
                case 1:
                    return "一月";
                case 2:
                    return "二月";
                case 3:
                    return "三月";
                case 4:
                    return "四月";
                case 5:
                    return "五月";
                case 6:
                    return "六月";
                case 7:
                    return "七月";
                case 8:
                    return "八月";
                case 9:
                    return "九月";
                case 10:
                    return "十月";
                case 11:
                    return "十一月";
                case 12:
                    return "十二月";
                default:
                    return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String getChineseYearBytime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65573, null, j2)) == null) {
            return getYearBytime(j2) + "年";
        }
        return (String) invokeJ.objValue;
    }

    public static String getCurrentString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            Date date2 = new Date();
            synchronized (k.FORMATE_DATE_MS) {
                format = k.FORMATE_DATE_MS.format(date2);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentTimeZoneDay() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            Date date2 = new Date();
            synchronized (k.FORMATE_DATE_DAY) {
                format = k.FORMATE_DATE_DAY.format(date2);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentTimeZoneSecond() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            Date date2 = new Date();
            synchronized (FORMATE_DATE_SECOND) {
                format = FORMATE_DATE_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public static String getDateBytime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65577, null, j2)) == null) {
            int date2 = new Date(j2).getDate();
            if (date2 < 10) {
                return "0" + String.valueOf(date2);
            }
            return String.valueOf(date2);
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringDHM(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, date2)) == null) {
            synchronized (FORMATE_DATE_DAY_TIME) {
                format = FORMATE_DATE_DAY_TIME.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringDay1(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, date2)) == null) {
            synchronized (k.FORMATE_DATE_DAY_1) {
                format = k.FORMATE_DATE_DAY_1.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringDayNoYear(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, date2)) == null) {
            synchronized (k.FORMATE_DATE_DAY_NO_YEAR) {
                format = k.FORMATE_DATE_DAY_NO_YEAR.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringHM(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65581, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMATE_DATE_HOUR) {
                format = FORMATE_DATE_HOUR.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMHH(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65582, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMAT_DATE_MONTH_SECOND_) {
                format = FORMAT_DATE_MONTH_SECOND_.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMd(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65583, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMATE_MONTH_DAY) {
                format = FORMATE_MONTH_DAY.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdChinease(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65584, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMAT_MONTH_DAY_CHINEASE) {
                format = FORMAT_MONTH_DAY_CHINEASE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdHm(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65585, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMATE_MONTH_DAY_HOUR_MINUTE) {
                format = FORMATE_MONTH_DAY_HOUR_MINUTE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdHmSs(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65586, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMATE_DATE_SECOND) {
                format = FORMATE_DATE_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringYMH(long j2) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65587, null, j2)) == null) {
            Date date2 = new Date(j2);
            synchronized (FORMAT_DATE_YEAR_SECOND) {
                format = FORMAT_DATE_YEAR_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringYearMonthDay(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, date2)) == null) {
            synchronized (FORMATE_DATE_YEAR_M_D) {
                format = FORMATE_DATE_YEAR_M_D.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateWeek(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, date2)) == null) {
            synchronized (k.FORMATE_DATE_DAY_WEEK) {
                format = k.FORMATE_DATE_DAY_WEEK.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getFixedText(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d2 = 0.0d;
            int i3 = 0;
            while (true) {
                if (i3 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i3);
                d2 += ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9')) ? 1.0d : 0.5d;
                if (d2 <= i2) {
                    sb.append(charAt);
                    i3++;
                } else if (z) {
                    String fixedText = getFixedText(sb.toString(), i2 - 1, false);
                    return fixedText + "...";
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String getFormatAlaLiveTime(long j2) {
        InterceptResult invokeJ;
        String formatAlaLiveTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65591, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatAlaLiveTime = getFormatAlaLiveTime(date);
            }
            return formatAlaLiveTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatSize(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65593, null, j2)) == null) {
            float f2 = (float) j2;
            return f2 >= SIZE_FLOAT_G ? String.format(Locale.getDefault(), "%.1fG", Float.valueOf(f2 / SIZE_FLOAT_G)) : f2 >= SIZE_FLOAT_M ? String.format(Locale.getDefault(), "%.1fM", Float.valueOf(f2 / SIZE_FLOAT_M)) : f2 >= SIZE_FLOAT_K / 10.0f ? String.format(Locale.getDefault(), "%.1fK", Float.valueOf(f2 / SIZE_FLOAT_K)) : TbadkCoreApplication.getInst().getString(R.string.less_than_zero_dot_one_k);
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTime(long j2) {
        InterceptResult invokeJ;
        String formatTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65594, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatTime = getFormatTime(date, false);
            }
            return formatTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForAlaCardCreate(long j2) {
        InterceptResult invokeJ;
        String formatTimeForAlaCardCreate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65596, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatTimeForAlaCardCreate = getFormatTimeForAlaCardCreate(date);
            }
            return formatTimeForAlaCardCreate;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForHomeC(long j2) {
        InterceptResult invokeJ;
        String formatTimeHomeC;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65598, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatTimeHomeC = getFormatTimeHomeC(date);
            }
            return formatTimeHomeC;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForJustNow(long j2) {
        InterceptResult invokeJ;
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65599, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatTimeForJustNow = getFormatTimeForJustNow(date, false);
            }
            return formatTimeForJustNow;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeHomeC(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time < MS_TO_DAY && time > 0) {
                if (time < MS_TO_HOUR) {
                    if (time < MS_TO_MIN) {
                        long j2 = time / MS_TO_SEC;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        return String.valueOf(j2) + SEC_BEFORE;
                    }
                    return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
                }
                return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.more_one_day);
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatTimeShort(long j2) {
        InterceptResult invokeJ;
        String formatTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65602, null, j2)) == null) {
            synchronized (date) {
                date.setTime(j2);
                formatTime = getFormatTime(date, true);
            }
            return formatTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getHighLightString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, str, str2)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (StringUtils.isNull(str2)) {
                str2 = "#007bd1";
            }
            String str3 = null;
            try {
                str3 = str.replaceAll("<em>", "<font color='" + str2 + "'>");
                return str3.replaceAll("</em>", "</font>");
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return str3;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getNameFromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, str)) == null) {
            try {
                int lastIndexOf = str.lastIndexOf("/");
                int lastIndexOf2 = str.lastIndexOf(".");
                if (lastIndexOf == -1) {
                    return str;
                }
                if (lastIndexOf < lastIndexOf2) {
                    return str.substring(lastIndexOf, lastIndexOf2);
                }
                return str.substring(lastIndexOf);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getNegativeInfinity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? "-∞" : (String) invokeV.objValue;
    }

    public static String getPostTimeInterval(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65606, null, j2)) == null) {
            long abs = Math.abs(System.currentTimeMillis() - (j2 * 1000));
            if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return "刚刚";
            }
            if (abs < Long.MAX_VALUE && abs / MS_TO_DAY == 0) {
                if (abs / MS_TO_HOUR != 0) {
                    return (abs / MS_TO_HOUR) + "小时前";
                }
                return (abs / MS_TO_MIN) + "分钟前";
            }
            return "";
        }
        return (String) invokeJ.objValue;
    }

    public static String getPostTimeString(Date date2, Date date3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65607, null, date2, date3)) == null) {
            if (date3 == null) {
                return "";
            }
            int day = date2.getDay() - date3.getDay();
            long time = date2.getTime() - date3.getTime();
            if (time < 0) {
                return time > -120000 ? "刚刚" : k.getDateStringDay(date3);
            } else if (time < 30000) {
                return "刚刚";
            } else {
                if (time < 60000) {
                    return "半分钟前";
                }
                if (time < 3600000) {
                    return String.valueOf((time * 60) / 3600000) + "分钟前";
                } else if (time < 86400000) {
                    return day == 0 ? k.getDateStringHm(date3) : "1天前";
                } else if (time >= 2678400000L) {
                    return time < 2764800000L ? "1个月前" : k.getDateStringDay(date3);
                } else {
                    return String.valueOf((time * 31) / 2678400000L) + "天前";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getRealSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = k.isChinese(str.charAt(i3)) ? i2 + 2 : i2 + 1;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int getRealSize2(String str) {
        InterceptResult invokeL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, str)) == null) {
            int i2 = 0;
            if (str == null || (bytes = str.getBytes()) == null) {
                return 0;
            }
            int length = bytes.length;
            int i3 = 0;
            while (i2 < length) {
                int i4 = bytes[i2] & 255;
                if (i4 >= 252) {
                    i3 += 2;
                    i2 += 6;
                } else if (i4 >= 248) {
                    i3 += 2;
                    i2 += 5;
                } else if (i4 >= 240) {
                    i3 += 2;
                    i2 += 4;
                } else if (i4 >= 224) {
                    i3 += 2;
                    i2 += 3;
                } else if (i4 >= 192) {
                    i3 += 2;
                    i2 += 2;
                } else {
                    i3++;
                    i2++;
                }
            }
            return i3;
        }
        return invokeL.intValue;
    }

    public static String getStringYearToSecond(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, date2)) == null) {
            synchronized (FORMATE_DATE_SECOND) {
                format = FORMATE_DATE_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getTimeInterval(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65611, null, j2)) == null) {
            long abs = Math.abs(System.currentTimeMillis() - (j2 * 1000));
            if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return "刚刚";
            }
            if (abs >= Long.MAX_VALUE) {
                return "一个月前";
            }
            long j3 = MS_TO_DAY;
            if (abs / j3 != 0) {
                if (abs / j3 > 30) {
                    return "一个月前";
                }
                return (abs / MS_TO_DAY) + "天前";
            } else if (abs / MS_TO_HOUR != 0) {
                return (abs / MS_TO_HOUR) + "小时前";
            } else {
                return (abs / MS_TO_MIN) + "分钟前";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String getTimeSpace(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65612, null, j2)) == null) {
            if (j2 <= 0) {
                return "1秒";
            }
            long j3 = MS_TO_DAY;
            if (j2 < j3) {
                if (j2 < MS_TO_HOUR) {
                    if (j2 < MS_TO_MIN) {
                        long j4 = j2 / MS_TO_SEC;
                        if (j4 == 0) {
                            j4 = 1;
                        }
                        return String.valueOf(j4) + TIME_SECOND;
                    }
                    return String.valueOf(j2 / MS_TO_MIN) + TIME_MINUTE;
                }
                return String.valueOf(j2 / MS_TO_HOUR) + TIME_HOUR;
            }
            return String.valueOf(j2 / j3) + TIME_DAY;
        }
        return (String) invokeJ.objValue;
    }

    public static String getUserDescByGender(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65613, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
                }
                return TbadkCoreApplication.getInst().getContext().getString(R.string.she);
            }
            return TbadkCoreApplication.getInst().getContext().getString(R.string.he);
        }
        return (String) invokeI.objValue;
    }

    public static String getWeekString(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65614, null, i2, i3, i4)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, i2);
            calendar.set(2, i3);
            calendar.set(5, i4);
            switch (calendar.get(7)) {
                case 1:
                    return "周日";
                case 2:
                    return "周一";
                case 3:
                    return "周二";
                case 4:
                    return "周三";
                case 5:
                    return "周四";
                case 6:
                    return "周五";
                case 7:
                    return "周六";
                default:
                    return "周";
            }
        }
        return (String) invokeIII.objValue;
    }

    public static String getYearBytime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65615, null, j2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            return String.valueOf(calendar.get(1));
        }
        return (String) invokeJ.objValue;
    }

    public static int getyyyyMMddTimeForNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return (calendar.get(1) * 10000) + 0 + ((calendar.get(2) + 1) * 100) + calendar.get(5);
        }
        return invokeV.intValue;
    }

    public static SpannableString highLightText(String str, String str2, int i2, boolean z) {
        InterceptResult invokeCommon;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65619, null, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str) && i2 > 0) {
                SpannableString spannableString = new SpannableString(str);
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    if (z) {
                        lastIndexOf = str.indexOf(str2);
                    } else {
                        lastIndexOf = str.lastIndexOf(str2);
                    }
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i2)), lastIndexOf, str2.length() + lastIndexOf, 33);
                }
                return spannableString;
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static boolean isHttpUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65620, null, str)) == null) ? str != null && str.length() > 6 && str.substring(0, 7).equalsIgnoreCase("http://") : invokeL.booleanValue;
    }

    public static boolean isHttpsUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, str)) == null) ? str != null && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase("https://") : invokeL.booleanValue;
    }

    public static boolean isJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, str)) == null) {
            if (!k.isEmpty(str)) {
                String trim = str.trim();
                if (trim.startsWith(PreferencesUtil.LEFT_MOUNT) && trim.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isJSONObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65623, null, str)) == null) {
            if (k.isEmpty(str)) {
                return false;
            }
            try {
                Object nextValue = new JSONTokener(str).nextValue();
                if (nextValue instanceof JSONObject) {
                    return true;
                }
                boolean z = nextValue instanceof JSONArray;
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            return isHttpUrl(str) || isHttpsUrl(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isTaday(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65625, null, j2)) == null) {
            Time time = new Time();
            time.set(j2);
            int i2 = time.year;
            int i3 = time.month;
            int i4 = time.monthDay;
            time.set(System.currentTimeMillis());
            return i2 == time.year && i3 == time.month && i4 == time.monthDay;
        }
        return invokeJ.booleanValue;
    }

    public static boolean isThisYear(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, str)) == null) {
            if (str.length() != 10) {
                return false;
            }
            return FORMATE_DATE_YEAR_M_D.format(new Date()).substring(0, 4).equals(str.substring(0, 4));
        }
        return invokeL.booleanValue;
    }

    public static String long2String(long j2, String str) {
        InterceptResult invokeJL;
        Date date2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65627, null, j2, str)) == null) {
            if (String.valueOf(j2).length() == 10) {
                date2 = new Date(j2 * 1000);
            } else {
                date2 = new Date(j2);
            }
            return new SimpleDateFormat(str).format(date2);
        }
        return (String) invokeJL.objValue;
    }

    public static String longNumFormatOver(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65628, null, j2)) == null) {
            if (j2 <= 9999999) {
                if (j2 < 0) {
                    return "0";
                }
                return "" + j2;
            }
            float f2 = ((float) j2) / 10000.0f;
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            return round + "w+";
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver10000(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65629, null, j2)) == null) {
            if (j2 <= 9999) {
                if (j2 < 0) {
                    return "0";
                }
                return "" + j2;
            }
            float f2 = ((float) j2) / 10000.0f;
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            return round + "W";
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver10000wan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65630, null, j2)) == null) {
            if (j2 <= 9999999) {
                if (j2 < 0) {
                    return "0";
                }
                return "" + j2;
            }
            float f2 = ((float) j2) / 10000.0f;
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            return round + "w+";
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver10000wanAdd(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65631, null, j2)) == null) {
            if (j2 > 9990000) {
                return "999W+";
            }
            if (j2 < 0) {
                return "0";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver9999wan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65632, null, j2)) == null) {
            if (j2 < 0) {
                return "0";
            }
            if (j2 > 99990000) {
                return "9999W+";
            }
            if (j2 > 9999) {
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                float f2 = ((float) j2) / 10000.0f;
                if (f2 < 1000.0f) {
                    return decimalFormat.format(f2) + "W";
                }
                long round = Math.round(f2);
                if (((float) round) > f2) {
                    round--;
                }
                return round + "W";
            }
            return String.valueOf(j2);
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver9999wanDoublePoint(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65633, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < 0.0d) {
                return "0";
            }
            if (d2 > 9.999E7d) {
                return "9999万+";
            }
            if (d2 > 9999.0d) {
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                return decimalFormat.format(((float) d2) / 10000.0f) + "万";
            }
            return new DecimalFormat("#0.00").format(d2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String longNumFormatOver9999wanOnePoint(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65634, null, j2)) == null) {
            if (j2 < 0) {
                return "0";
            }
            if (j2 > 99990000) {
                return "9999万+";
            }
            if (j2 > 9999) {
                DecimalFormat decimalFormat = new DecimalFormat("#0.0");
                return decimalFormat.format(((float) j2) / 10000.0f) + "万";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    @Deprecated
    public static String numFormat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65635, null, i2)) == null) {
            if (i2 > 9999) {
                return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i2 / 10000.0f));
            }
            if (i2 < 0) {
                return "0";
            }
            return "" + i2;
        }
        return (String) invokeI.objValue;
    }

    public static String numFormat9999W(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65636, null, j2)) == null) {
            if (j2 <= 9999999) {
                if (j2 < 0) {
                    return "0";
                }
                return "" + j2;
            }
            float f2 = ((float) j2) / 10000.0f;
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            if (round >= 9999) {
                return "9999W+";
            }
            return j2 + "W";
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65637, null, j2)) == null) {
            if (j2 > 9999) {
                return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j2) / 10000.0f));
            }
            if (j2 < 0) {
                return "0";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver100000ReturnInt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65638, null, j2)) == null) {
            if (j2 > 99999) {
                return ((int) (((float) j2) / 10000.0f)) + "W";
            } else if (j2 < 0) {
                return "0";
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000ReturnInt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65639, null, j2)) == null) {
            if (j2 > 9999) {
                return ((int) (((float) j2) / 10000.0f)) + "W";
            } else if (j2 < 0) {
                return "0";
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000wan(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65640, null, f2)) == null) {
            if (f2 <= 9999999.0f) {
                if (f2 < 0.0f) {
                    return "0";
                }
                return "" + f2;
            }
            float f3 = f2 / 10000.0f;
            long round = Math.round(f3);
            if (((float) round) > f3) {
                round--;
            }
            return round + "W";
        }
        return (String) invokeF.objValue;
    }

    public static String numFormatOverWan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65642, null, j2)) == null) {
            if (j2 > 99990000) {
                return "9999W+";
            }
            if (j2 >= 10000000) {
                return String.valueOf(j2 / 10000) + "W";
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j2) / 10000.0f));
            }
            if (i2 == 0) {
                return "1W";
            }
            if (j2 < 0) {
                return "0";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanNa(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65643, null, j2)) == null) {
            if (j2 > 99990000) {
                return "9999W+";
            }
            if (j2 >= 10000000) {
                return String.valueOf(j2 / 10000) + "W";
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j2) / 10000.0f));
            }
            if (i2 == 0) {
                return "1W";
            }
            if (j2 < 0) {
                return "--";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanWithNegative(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65644, null, j2)) == null) {
            if (j2 > 99990000) {
                return "9999W+";
            }
            if (j2 >= 10000000) {
                return String.valueOf(j2 / 10000) + "W";
            }
            int i2 = (j2 > 10000L ? 1 : (j2 == 10000L ? 0 : -1));
            if (i2 > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j2) / 10000.0f));
            }
            if (i2 == 0) {
                return "1W";
            }
            if (j2 < -99990000) {
                return "-9999W+";
            }
            if (j2 <= -10000000) {
                return String.valueOf(j2 / 10000) + "W";
            }
            int i3 = (j2 > (-10000L) ? 1 : (j2 == (-10000L) ? 0 : -1));
            if (i3 < 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j2) / 10000.0f));
            }
            if (i3 == 0) {
                return "-1W";
            }
            return "" + j2;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanWithoutDecimals(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65645, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 100000) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j2) / 10000.0f));
            } else {
                if (j2 < 10000000) {
                    return (j2 / 10000) + "W";
                }
                float f2 = ((float) (j2 / 1000000)) / 10.0f;
                if (f2 >= 9999.0f) {
                    return "9999KW+";
                }
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "KW";
                }
                return ((int) f2) + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numOver1000(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65646, null, i2)) == null) {
            if (i2 > 1000) {
                return "999+";
            }
            if (i2 < 0) {
                return "0";
            }
            return "" + i2;
        }
        return (String) invokeI.objValue;
    }

    public static String numberUniform(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65647, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 9999000.0d) {
                float f2 = ((float) (j2 / 1000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "万";
                }
                return f2 + "万";
            } else {
                return "999.9万";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormat(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65648, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 10000000) {
                float f2 = ((float) (j2 / 1000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "万";
                }
                return f2 + "万";
            } else {
                float f3 = ((float) (j2 / 1000000)) / 10.0f;
                if (f3 % 1.0f == 0.0f) {
                    return ((int) f3) + "千万";
                }
                return f3 + "千万";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtra(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65649, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 10000000) {
                float f2 = ((float) (j2 / 1000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "W";
                }
                return f2 + "W";
            } else {
                float f3 = ((float) (j2 / 1000000)) / 10.0f;
                if (f3 >= 9999.0f) {
                    return "9999KW+";
                }
                if (f3 % 1.0f == 0.0f) {
                    return ((int) f3) + "KW";
                }
                return f3 + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRound(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65650, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 10000000) {
                return String.format("%.1f", Double.valueOf(j2 / 10000.0d)) + "W";
            } else {
                float f2 = ((float) (j2 / 1000000)) / 10.0f;
                if (f2 >= 9999.0f) {
                    return "9999KW+";
                }
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "KW";
                }
                return f2 + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRoundFloat(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65651, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            }
            double d2 = j2;
            if (d2 < 9999000.0d) {
                float f2 = ((float) (j2 / 1000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "W";
                }
                return f2 + "W";
            } else if (d2 < 9.9999E10d) {
                float f3 = ((float) (j2 / 1000000)) / 10.0f;
                if (f3 % 1.0f == 0.0f) {
                    return ((int) f3) + "KW";
                }
                return f3 + "KW";
            } else {
                return "9999.9KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRoundInt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65652, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 10000000) {
                String format = String.format("%.1f", Double.valueOf(j2 / 10000.0d));
                if (format.endsWith(".0")) {
                    format = format.substring(0, format.length() - 2);
                }
                return format + "W";
            } else {
                String format2 = String.format("%.1f", Double.valueOf((j2 / 1000000.0d) / 10.0d));
                if (format2.endsWith(".0")) {
                    format2 = format2.substring(0, format2.length() - 2);
                }
                float c2 = b.c(format2, 1.0f);
                if (c2 >= 9999.0f) {
                    return "9999KW+";
                }
                if (c2 % 1.0f == 0.0f) {
                    return ((int) c2) + "KW";
                }
                return c2 + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRoundVote(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65653, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 10000000) {
                String format = String.format("%.1f", Double.valueOf(j2 / 10000.0d));
                if (format.endsWith(".0")) {
                    format = format.substring(0, format.length() - 2);
                }
                return format + "w";
            } else {
                float f2 = ((float) (j2 / 1000000)) / 10.0f;
                if (f2 >= 999.0f) {
                    return "999kw+";
                }
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + TiebaStatic.Params.H5_FORUM_NAME;
                }
                return f2 + TiebaStatic.Params.H5_FORUM_NAME;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformOver1000Wan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65654, null, j2)) == null) {
            if (j2 <= 0) {
                return "0";
            }
            if (j2 < 10000) {
                return j2 + "";
            } else if (j2 < 9999000.0d) {
                float f2 = ((float) (j2 / 1000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "W";
                }
                return f2 + "W";
            } else {
                return "999.9W";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static long[] parseVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65655, null, str)) == null) {
            long[] jArr = new long[3];
            if (str != null) {
                String[] split = str.replace(".", "#").split("#");
                jArr[0] = Long.parseLong(split[0]);
                jArr[1] = Long.parseLong(split[1]);
                jArr[2] = Long.parseLong(split[2]);
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public static String showTimeString(long j2) {
        InterceptResult invokeJ;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65656, null, j2)) == null) {
            Date date2 = new Date(j2);
            if (date2.getMinutes() < 10) {
                valueOf = "0" + date2.getMinutes();
            } else {
                valueOf = String.valueOf(date2.getMinutes());
            }
            return date2.getHours() > 12 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours() - 12), valueOf}) : date2.getHours() == 12 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours()), valueOf}) : date2.getHours() == 0 ? TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(12), valueOf}) : TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(date2.getHours()), valueOf});
        }
        return (String) invokeJ.objValue;
    }

    public static long string2long(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65657, null, str, str2)) == null) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (java.text.ParseException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static String stringForVideoTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65658, null, i2)) == null) {
            if (i2 < 1000) {
                i2 = 1000;
            }
            int i3 = i2 / 1000;
            int i4 = i3 % 60;
            int i5 = (i3 / 60) % 60;
            int i6 = i3 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            return i6 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
        }
        return (String) invokeI.objValue;
    }

    public static String subString(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65659, null, str, i2)) == null) {
            if (str == null || i2 <= 0) {
                return "";
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                i3 = k.isChinese(charAt) ? i3 + 2 : i3 + 1;
                if (i3 > i2) {
                    break;
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static String subString2(String str, int i2) {
        InterceptResult invokeLI;
        byte[] bytes;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65660, null, str, i2)) == null) {
            if (str == null || i2 < 0 || (bytes = str.getBytes()) == null) {
                return null;
            }
            int length = bytes.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = bytes[i4] & 255;
                if (i6 >= 252) {
                    i5 += 2;
                    i3 = 6;
                } else if (i6 >= 248) {
                    i5 += 2;
                    i3 = 5;
                } else if (i6 >= 240) {
                    i5 += 2;
                    i3 = 4;
                } else if (i6 >= 224) {
                    i5 += 2;
                    i3 = 3;
                } else if (i6 >= 192) {
                    i5 += 2;
                    i3 = 2;
                } else {
                    i5++;
                    i3 = 1;
                }
                if (i5 > i2) {
                    byte[] bArr = new byte[i4];
                    System.arraycopy(bytes, 0, bArr, 0, i4);
                    return new String(bArr);
                } else if (i5 == i2) {
                    int i7 = i4 + i3;
                    byte[] bArr2 = new byte[i7];
                    System.arraycopy(bytes, 0, bArr2, 0, i7);
                    return new String(bArr2);
                } else {
                    i4 += i3;
                }
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String trim(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65661, null, str)) == null) ? str != null ? str.trim() : "" : (String) invokeL.objValue;
    }

    public static SpannableStringBuilder forceLToR(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, spannableStringBuilder)) == null) {
            if (spannableStringBuilder == null) {
                return new SpannableStringBuilder("");
            }
            return new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static String formatTosepara(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65564, null, j2)) == null) ? new DecimalFormat("#,###").format(j2) : (String) invokeJ.objValue;
    }

    public static String getChatTimeString(Date date2, Date date3) {
        InterceptResult invokeLL;
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, date2, date3)) == null) {
            if (date3 == null) {
                return "";
            }
            int day = date2.getDay() - date3.getDay();
            long time = date2.getTime() - date3.getTime();
            if (time < 0) {
                return time > -120000 ? "刚刚" : k.getDateStringDay(date3);
            } else if (time < 30000) {
                return "刚刚";
            } else {
                if (time < 60000) {
                    return "半分钟前";
                }
                if (time < 3600000) {
                    return String.valueOf((time * 60) / 3600000) + "分钟前";
                } else if (time < 86400000) {
                    return day == 0 ? k.getDateStringHm(date3) : "1天前";
                } else if (time < 2678400000L) {
                    return String.valueOf((time * 31) / 2678400000L) + "天前";
                } else if (time < 2764800000L) {
                    return "1个月前";
                } else {
                    if (date2.getYear() == date3.getYear()) {
                        synchronized (k.FORMATE_DATE_DAY_NO_YEAR) {
                            format2 = k.FORMATE_DATE_DAY_NO_YEAR.format(date3);
                        }
                        return format2;
                    }
                    synchronized (k.FORMATE_DATE_DAY) {
                        format = k.FORMATE_DATE_DAY.format(date3);
                    }
                    return format;
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getChineseAndEnglishLength(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, charSequence)) == null) {
            if (charSequence == null) {
                return 0;
            }
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = k.isChinese(charSequence.charAt(i3)) ? i2 + 2 : i2 + 1;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String numFormatOver10000wan(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65641, null, j2)) == null) {
            if (j2 <= 9999999) {
                if (j2 < 0) {
                    return "0";
                }
                return "" + j2;
            }
            float f2 = ((float) j2) / 10000.0f;
            long round = Math.round(f2);
            if (((float) round) > f2) {
                round--;
            }
            return round + "W";
        }
        return (String) invokeJ.objValue;
    }

    public static CharSequence cutChineseAndEnglishWithSuffix(CharSequence charSequence, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, charSequence, i2, str)) == null) {
            if (charSequence == null || i2 <= 0) {
                return "";
            }
            int length = charSequence.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                i4 = k.isChinese(charSequence.charAt(i3)) ? i4 + 2 : i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                i3++;
            }
            int i5 = i3 + 1;
            if (i5 < length) {
                if (str == null) {
                    str = "";
                }
                return ((Object) charSequence.subSequence(0, i5)) + str;
            }
            return charSequence;
        }
        return (CharSequence) invokeLIL.objValue;
    }

    public static String getFormatAlaLiveTime(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            StringBuilder sb = new StringBuilder();
            long j2 = time / MS_TO_HOUR;
            if (j2 > 0) {
                sb.append(j2 + "小时");
            }
            long j3 = time % MS_TO_HOUR;
            if (j3 > 0) {
                long j4 = j3 / MS_TO_MIN;
                if (j4 == 0) {
                    j4 = 1;
                }
                sb.append(j4 + "分钟");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatTime(Date date2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65595, null, date2, z)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time >= MS_TO_DAY || time <= 0) {
                if (z) {
                    return getDateStringDayNoYear(date2);
                }
                return k.getDateStringDay(date2);
            } else if (time < MS_TO_HOUR) {
                if (time < MS_TO_MIN) {
                    long j2 = time / MS_TO_SEC;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    return String.valueOf(j2) + SEC_BEFORE;
                }
                return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
            } else {
                return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String getFormatTimeForAlaCardCreate(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time < 0) {
                return "";
            }
            if (time < MS_TO_DAY) {
                if (time < MS_TO_HOUR) {
                    if (time < MS_TO_MIN) {
                        return "1" + ALA_CARD_MIN_BEFORE;
                    }
                    return String.valueOf(time / MS_TO_MIN) + ALA_CARD_MIN_BEFORE;
                }
                return String.valueOf(time / MS_TO_HOUR) + ALA_CARD_HOUR_BEFORE;
            }
            return String.valueOf(time / MS_TO_DAY) + ALA_CARD_DAY_BEFORE;
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatTimeForJustNow(Date date2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65600, null, date2, z)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time >= MS_TO_DAY || time <= 0) {
                if (z) {
                    return getDateStringDayNoYear(date2);
                }
                return k.getDateStringDay(date2);
            } else if (time < MS_TO_HOUR) {
                if (time < MS_TO_MIN) {
                    return "刚刚";
                }
                return String.valueOf(time / MS_TO_MIN) + MIN_BEFORE;
            } else {
                return String.valueOf(time / MS_TO_HOUR) + HOUR_BEFORE;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String formatOverBaiwanNum(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65560, null, j2)) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            String valueOf = String.valueOf(j2);
            if (j2 >= 100000000) {
                if (j2 % 100000000 != 0) {
                    return String.format("%.1f", Double.valueOf(((float) j2) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (j2 / 100000000) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (j2 >= 1000000) {
                float f2 = ((float) j2) / 10000.0f;
                long j3 = j2 / 10000;
                if (f2 > ((float) j3)) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String formatSecondsTime(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65562, null, j2)) == null) {
            long j3 = j2 % 60;
            long j4 = (j2 / 60) % 60;
            long j5 = j2 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            return j5 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
        }
        return (String) invokeJ.objValue;
    }

    public static SpannableString highLightText(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65617, null, str, i2, i3, i4)) == null) {
            if (!TextUtils.isEmpty(str) && i4 > 0) {
                SpannableString spannableString = new SpannableString(str);
                if (i2 < i3 && i2 < str.length() && str.length() >= i3) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i4)), i2, i3, 33);
                }
                return spannableString;
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeLIII.objValue;
    }

    public static SpannableString highLightText(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65618, null, str, str2, i2)) == null) ? highLightText(str, str2, i2, true) : (SpannableString) invokeLLI.objValue;
    }
}
