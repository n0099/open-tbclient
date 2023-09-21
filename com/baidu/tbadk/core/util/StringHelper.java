package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.ParseException;
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
/* loaded from: classes4.dex */
public class StringHelper extends di {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_CARD_DAY_BEFORE;
    public static final String ALA_CARD_HOUR_BEFORE;
    public static final String ALA_CARD_MIN_BEFORE;
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
    public static final String HOUR_BEFORE;
    public static final String MIN_BEFORE;
    public static final long MS_TO_DAY = 86400000;
    public static final long MS_TO_HOUR = 3600000;
    public static final long MS_TO_MIN = 60000;
    public static final long MS_TO_SEC = 1000;
    public static final String SEC_BEFORE;
    public static final float SIZE_FLOAT_G = 1.0737418E9f;
    public static final float SIZE_FLOAT_K = 1024.0f;
    public static final float SIZE_FLOAT_M = 1048576.0f;
    public static final String STRING_MORE = "...";
    public static final String TIME_DAY;
    public static final String TIME_HOUR;
    public static final String TIME_MINUTE;
    public static final String TIME_MINUTE_SINGLE;
    public static final String TIME_SECOND;
    public static final String[] TIME_STR;
    public static Date date;
    public transient /* synthetic */ FieldHolder $fh;

    public static String getNegativeInfinity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? "-∞" : (String) invokeV.objValue;
    }

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
        HOUR_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour_before);
        MIN_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_min_before);
        SEC_BEFORE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_sec_before);
        TIME_DAY = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0528);
        TIME_HOUR = TbadkCoreApplication.getInst().getApp().getString(R.string.time_hour);
        TIME_MINUTE = TbadkCoreApplication.getInst().getApp().getString(R.string.time_minute);
        TIME_SECOND = TbadkCoreApplication.getInst().getApp().getString(R.string.time_second);
        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0ca4);
        TIME_MINUTE_SINGLE = string;
        TIME_STR = new String[]{TIME_DAY, TIME_HOUR, string, TIME_SECOND};
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
            di.FORMATE_DATE_ALL.setTimeZone(timeZone);
            di.FORMATE_DATE_YEAR.setTimeZone(timeZone);
            di.FORMATE_DATE_TIME.setTimeZone(timeZone);
            di.FORMATE_DATE_MOUTH.setTimeZone(timeZone);
            di.FORMATE_DATE_MOUTH_TIME.setTimeZone(timeZone);
            di.FORMATE_DATE_DAY.setTimeZone(timeZone);
            di.FORMATE_DATE_DAY_WEEK.setTimeZone(timeZone);
            di.FORMATE_DATE_DAY_1.setTimeZone(timeZone);
            di.FORMATE_DATE_MS.setTimeZone(timeZone);
            di.FORMATE_DATE_DAY_NO_YEAR.setTimeZone(timeZone);
        }
    }

    public StringHelper() {
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

    public static String getCurrentString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            Date date2 = new Date();
            synchronized (di.FORMATE_DATE_MS) {
                format = di.FORMATE_DATE_MS.format(date2);
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
            synchronized (di.FORMATE_DATE_DAY) {
                format = di.FORMATE_DATE_DAY.format(date2);
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

    public static int getyyyyMMddTimeForNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return (calendar.get(1) * 10000) + 0 + ((calendar.get(2) + 1) * 100) + calendar.get(5);
        }
        return invokeV.intValue;
    }

    public static String JsonArrayToString(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    sb.append(jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
                if (i < length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static SpannableStringBuilder forceLToR(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, spannableStringBuilder)) == null) {
            if (spannableStringBuilder == null) {
                return new SpannableStringBuilder("");
            }
            return new SpannableStringBuilder("\u202d").append((CharSequence) spannableStringBuilder).append((CharSequence) "\u202c");
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static String getDateBytime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65577, null, j)) == null) {
            int date2 = new Date(j).getDate();
            if (date2 < 10) {
                return "0" + String.valueOf(date2);
            }
            return String.valueOf(date2);
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForJustNowAndDate(long j) {
        InterceptResult invokeJ;
        boolean z;
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65601, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                if (date.getYear() == new Date().getYear()) {
                    z = true;
                } else {
                    z = false;
                }
                formatTimeForJustNow = getFormatTimeForJustNow(date, z);
            }
            return formatTimeForJustNow;
        }
        return (String) invokeJ.objValue;
    }

    public static String getNameFromUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, str)) == null) {
            try {
                int lastIndexOf = str.lastIndexOf("/");
                int lastIndexOf2 = str.lastIndexOf(".");
                if (lastIndexOf != -1) {
                    if (lastIndexOf < lastIndexOf2) {
                        return str.substring(lastIndexOf, lastIndexOf2);
                    }
                    return str.substring(lastIndexOf);
                }
                return str;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getRealSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (di.isChinese(str.charAt(i2))) {
                    i += 2;
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static boolean isTaday(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65629, null, j)) == null) {
            Time time = new Time();
            time.set(j);
            int i = time.year;
            int i2 = time.month;
            int i3 = time.monthDay;
            time.set(System.currentTimeMillis());
            if (i == time.year && i2 == time.month && i3 == time.monthDay) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public static boolean isThisYear(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, str)) == null) {
            if (str.length() != 10) {
                return false;
            }
            if (!FORMATE_DATE_YEAR_M_D.format(new Date()).substring(0, 4).equals(str.substring(0, 4))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String longNumFormatOver10000wanAdd(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65635, null, j)) == null) {
            if (j > 9990000) {
                return "999W+";
            }
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numOver1000(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65650, null, i)) == null) {
            if (i > 1000) {
                return "999+";
            }
            if (i < 0) {
                return "0";
            }
            return "" + i;
        }
        return (String) invokeI.objValue;
    }

    public static int compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            long[] parseVersion = parseVersion(str);
            long[] parseVersion2 = parseVersion(str2);
            long j = 0;
            long j2 = 0;
            for (int i = 0; i < 4; i++) {
                j2 += parseVersion[i] << (32 - (i * 8));
            }
            for (int i2 = 0; i2 < 4; i2++) {
                j += parseVersion2[i2] << (32 - (i2 * 8));
            }
            int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i3 > 0) {
                return 1;
            }
            if (i3 != 0) {
                return -1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String cutStringWithEllipsisNew(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (i <= 0) {
                return str;
            }
            try {
                if (str.codePointCount(0, str.length()) <= i) {
                    return str;
                }
                String substring = str.substring(0, str.offsetByCodePoints(0, i - 1));
                return substring + "...";
            } catch (Throwable th) {
                BdLog.e(th);
                return str;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String getHighLightString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65604, null, str, str2)) == null) {
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
            } catch (Exception e) {
                BdLog.e(e.toString());
                return str3;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String subString(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65664, null, str, i)) == null) {
            if (str != null && i > 0) {
                int length = str.length();
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = str.charAt(i3);
                    if (di.isChinese(charAt)) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > i) {
                        break;
                    }
                    sb.append(charAt);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String cutChineseAndEnglishWithEmoji(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, str2)) == null) {
            if (str == null || i <= 0) {
                return "";
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (di.isChinese(str.charAt(i2))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 >= i) {
                    break;
                }
                i2++;
            }
            int i4 = i2 + 1;
            if (i4 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                String substring = str.substring(0, str.offsetByCodePoints(0, str.codePointCount(0, i4)));
                if (str.equals(substring)) {
                    return substring;
                }
                return substring + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String cutForumNameWithSuffix(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, str2)) == null) {
            if (str == null || i <= 0) {
                return "";
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (di.isChinese(str.charAt(i2))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 >= i) {
                    break;
                }
                i2++;
            }
            int i4 = i2 + 1;
            if (i4 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                if (i3 + 2 < i) {
                    return str.substring(0, i4) + str2;
                }
                return str.substring(0, i2) + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String cutHotTopicShow(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65544, null, str, i, str2)) == null) {
            if (str == null || i <= 0) {
                return "";
            }
            int length = str.length();
            if (str.indexOf("#") == 0 && str.lastIndexOf("#") == length - 1) {
                String replaceAll = str.replaceAll("#", "");
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    if (di.isChinese(replaceAll.charAt(i2))) {
                        i3 += 2;
                    } else {
                        i3++;
                    }
                    if (i3 >= i) {
                        break;
                    }
                    i2++;
                }
                StringBuilder sb = new StringBuilder();
                int i4 = i2 + 1;
                if (i4 < length) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append("#");
                    sb.append(replaceAll.substring(0, i4));
                    sb.append(str2);
                    sb.append("#");
                    return sb.toString();
                }
                sb.append("#");
                sb.append(replaceAll);
                sb.append("#");
                return sb.toString();
            }
            return cutChineseAndEnglishWithSuffix(str, i, str2);
        }
        return (String) invokeLIL.objValue;
    }

    public static String getFixedText(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            double d2 = 0.0d;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || (charAt >= '0' && charAt <= '9'))) {
                    d = 0.5d;
                } else {
                    d = 1.0d;
                }
                d2 += d;
                if (d2 <= i) {
                    sb.append(charAt);
                    i2++;
                } else if (z) {
                    String fixedText = getFixedText(sb.toString(), i - 1, false);
                    return fixedText + "...";
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static CharSequence cutChineseAndEnglishWithSuffix(CharSequence charSequence, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, charSequence, i, str)) == null) {
            if (charSequence == null || i <= 0) {
                return "";
            }
            int length = charSequence.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (di.isChinese(charSequence.charAt(i2))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 >= i) {
                    break;
                }
                i2++;
            }
            int i4 = i2 + 1;
            if (i4 < length) {
                if (str == null) {
                    str = "";
                }
                return ((Object) charSequence.subSequence(0, i4)) + str;
            }
            return charSequence;
        }
        return (CharSequence) invokeLIL.objValue;
    }

    public static String cutChineseAndEnglishWithSuffix(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, str, i, str2)) == null) {
            if (str == null || i <= 0) {
                return "";
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (di.isChinese(str.charAt(i2))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 >= i) {
                    break;
                }
                i2++;
            }
            int i4 = i2 + 1;
            if (i4 < length) {
                if (str2 == null) {
                    str2 = "";
                }
                return str.substring(0, i4) + str2;
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    @Deprecated
    public static String cutStringWithEllipsis(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            if (str != null && i >= 0 && str.length() != i) {
                return cutStringWithSuffix(str, i - 1, "...");
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static boolean equals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            return str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static int[] getSpecialTextIndex(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65613, null, str, i)) == null) {
            String string = TbadkCoreApplication.getInst().getString(i);
            int[] iArr = {str.indexOf(string), iArr[0] + string.length()};
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static long string2long(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65662, null, str, str2)) == null) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static String cutStringWithEllipsisStrict(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i)) == null) {
            if (str != null && i > 0) {
                int length = str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    if (di.isChinese(str.charAt(i2))) {
                        i3 += 2;
                    } else {
                        i3++;
                    }
                    if (i3 >= i) {
                        break;
                    }
                    i2++;
                }
                if (i3 <= i && i2 + 1 >= length) {
                    return str;
                }
                if (i3 + 2 < i) {
                    return str.substring(0, i2 + 1) + "...";
                }
                return str.substring(0, i2) + "...";
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String getFormatTimeForJustNow(Date date2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65600, null, date2, z)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time < 86400000 && time > 0) {
                if (time < 3600000) {
                    if (time < 60000) {
                        return "刚刚";
                    }
                    return String.valueOf(time / 60000) + MIN_BEFORE;
                }
                return String.valueOf(time / 3600000) + HOUR_BEFORE;
            } else if (z) {
                return getDateStringDayNoYear(date2);
            } else {
                return di.getDateStringDay(date2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String subString2(String str, int i) {
        InterceptResult invokeLI;
        byte[] bytes;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65665, null, str, i)) == null) {
            if (str == null || i < 0 || (bytes = str.getBytes()) == null) {
                return null;
            }
            int length = bytes.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = bytes[i3] & 255;
                if (i5 >= 252) {
                    i4 += 2;
                    i2 = 6;
                } else if (i5 >= 248) {
                    i4 += 2;
                    i2 = 5;
                } else if (i5 >= 240) {
                    i4 += 2;
                    i2 = 4;
                } else if (i5 >= 224) {
                    i4 += 2;
                    i2 = 3;
                } else if (i5 >= 192) {
                    i4 += 2;
                    i2 = 2;
                } else {
                    i4++;
                    i2 = 1;
                }
                if (i4 > i) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(bytes, 0, bArr, 0, i3);
                    return new String(bArr);
                } else if (i4 == i) {
                    int i6 = i3 + i2;
                    byte[] bArr2 = new byte[i6];
                    System.arraycopy(bytes, 0, bArr2, 0, i6);
                    return new String(bArr2);
                } else {
                    i3 += i2;
                }
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String cutStringWithSuffix(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, str, i, str2)) == null) {
            if (str != null && i >= 0 && str.length() > i) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, i));
                if (str2 == null) {
                    sb.append("");
                } else {
                    sb.append(str2);
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    public static String dateToConstellation(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, date2)) == null) {
            if (date2 == null) {
                return null;
            }
            String[] strArr = {"宝瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "室女座", "天秤座", "天蝎座", "人马座", "摩羯座"};
            int[] iArr = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date2);
                int i = calendar.get(5);
                int i2 = calendar.get(2);
                if (i < iArr[i2]) {
                    i2--;
                }
                if (i2 < 0) {
                    i2 = 11;
                }
                if (i2 >= 0 && i2 <= 11) {
                    return strArr[i2];
                }
            } catch (android.net.ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String formatDistanceNum(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Double.valueOf(d)})) == null) {
            String format = String.format(Locale.getDefault(), "%.1f", Double.valueOf(d));
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

    public static String formatSecondsTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            int i2 = i / 1000;
            int i3 = i2 % 60;
            int i4 = (i2 / 60) % 60;
            int i5 = i2 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            if (i5 > 0) {
                return formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString();
            }
            return formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
        }
        return (String) invokeI.objValue;
    }

    public static String getChineseMonthBytime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65572, null, j)) == null) {
            switch (new Date(j).getMonth() + 1) {
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

    public static String getFormatAlaLiveTime(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            StringBuilder sb = new StringBuilder();
            long j = time / 3600000;
            if (j > 0) {
                sb.append(j + "小时");
            }
            long j2 = time % 3600000;
            if (j2 > 0) {
                long j3 = j2 / 60000;
                if (j3 == 0) {
                    j3 = 1;
                }
                sb.append(j3 + "分钟");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65593, null, j)) == null) {
            float f = (float) j;
            if (f >= 1.0737418E9f) {
                return String.format(Locale.getDefault(), "%.1fG", Float.valueOf(f / 1.0737418E9f));
            }
            if (f >= 1048576.0f) {
                return String.format(Locale.getDefault(), "%.1fM", Float.valueOf(f / 1048576.0f));
            }
            if (f >= 102.4f) {
                return String.format(Locale.getDefault(), "%.1fK", Float.valueOf(f / 1024.0f));
            }
            return TbadkCoreApplication.getInst().getString(R.string.less_than_zero_dot_one_k);
        }
        return (String) invokeJ.objValue;
    }

    public static String getNewMsgTimeInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65607, null, j)) == null) {
            long time = new Date().getTime() - new Date(j / 1000).getTime();
            long j2 = time / 3600000;
            int i = (j2 > 24L ? 1 : (j2 == 24L ? 0 : -1));
            if (i > 0) {
                return "";
            }
            if (j2 > 0 && i <= 0) {
                return j2 + HOUR_BEFORE;
            }
            long j3 = time % 3600000;
            if (j3 > 0) {
                long j4 = j3 / 60000;
                if (j4 == 0) {
                    return TbadkCoreApplication.getInst().getString(R.string.time_just_now);
                }
                return j4 + MIN_BEFORE;
            }
            return null;
        }
        return (String) invokeJ.objValue;
    }

    public static String getPostTimeInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65608, null, j)) == null) {
            long abs = Math.abs(System.currentTimeMillis() - (j * 1000));
            if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return "刚刚";
            }
            if (abs >= Long.MAX_VALUE || abs / 86400000 != 0) {
                return "";
            }
            long j2 = abs / 3600000;
            if (j2 != 0) {
                return j2 + "小时前";
            }
            return (abs / 60000) + "分钟前";
        }
        return (String) invokeJ.objValue;
    }

    public static String getTimeInterval(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65615, null, j)) == null) {
            long abs = Math.abs(System.currentTimeMillis() - (j * 1000));
            if (abs <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return "刚刚";
            }
            if (abs >= Long.MAX_VALUE) {
                return "一个月前";
            }
            long j2 = abs / 86400000;
            if (j2 != 0) {
                if (j2 > 30) {
                    return "一个月前";
                }
                return j2 + "天前";
            }
            long j3 = abs / 3600000;
            if (j3 != 0) {
                return j3 + "小时前";
            }
            return (abs / 60000) + "分钟前";
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver9999wan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65636, null, j)) == null) {
            if (j < 0) {
                return "0";
            }
            if (j > 99990000) {
                return "9999W+";
            }
            if (j > 9999) {
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                float f = ((float) j) / 10000.0f;
                if (f < 1000.0f) {
                    return decimalFormat.format(f) + ExifInterface.LONGITUDE_WEST;
                }
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                return round + ExifInterface.LONGITUDE_WEST;
            }
            return String.valueOf(j);
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver9999wanDoublePoint(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65637, null, new Object[]{Double.valueOf(d)})) == null) {
            if (d < 0.0d) {
                return "0";
            }
            if (d > 9.999E7d) {
                return "9999万+";
            }
            if (d > 9999.0d) {
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                return decimalFormat.format(((float) d) / 10000.0f) + "万";
            }
            return new DecimalFormat("#0.00").format(d);
        }
        return (String) invokeCommon.objValue;
    }

    public static String numFormatOverWan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65646, null, j)) == null) {
            if (j > 99990000) {
                return "9999W+";
            }
            if (j >= 10000000) {
                return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
            }
            if (i == 0) {
                return "1W";
            }
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanNa(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65647, null, j)) == null) {
            if (j > 99990000) {
                return "9999W+";
            }
            if (j >= 10000000) {
                return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
            }
            if (i == 0) {
                return "1W";
            }
            if (j < 0) {
                return "--";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniform(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65651, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 9999000.0d) {
                float f = ((float) (j / 1000)) / 10.0f;
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "万";
                }
                return f + "万";
            } else {
                return "999.9万";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformOver1000Wan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65659, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 9999000.0d) {
                float f = ((float) (j / 1000)) / 10.0f;
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + ExifInterface.LONGITUDE_WEST;
                }
                return f + ExifInterface.LONGITUDE_WEST;
            } else {
                return "999.9W";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String stringForVideoTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65663, null, i)) == null) {
            if (i < 1000) {
                i = 1000;
            }
            int i2 = i / 1000;
            int i3 = i2 % 60;
            int i4 = (i2 / 60) % 60;
            int i5 = i2 / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            if (i5 > 0) {
                return formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString();
            }
            return formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
        }
        return (String) invokeI.objValue;
    }

    public static String forceLToR(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (di.isEmpty(str)) {
                return "";
            }
            return "\u202d" + str + "\u202c";
        }
        return (String) invokeL.objValue;
    }

    public static String formatDayOrHourTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65553, null, j)) == null) {
            int i = (int) (j / 3600000);
            if (i >= 24) {
                return ((i / 24) + 1) + TIME_DAY;
            }
            return (i + 1) + TIME_HOUR;
        }
        return (String) invokeJ.objValue;
    }

    public static int getRealSize2(String str) {
        InterceptResult invokeL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, str)) == null) {
            int i = 0;
            if (str == null || (bytes = str.getBytes()) == null) {
                return 0;
            }
            int length = bytes.length;
            int i2 = 0;
            while (i < length) {
                int i3 = bytes[i] & 255;
                if (i3 >= 252) {
                    i2 += 2;
                    i += 6;
                } else if (i3 >= 248) {
                    i2 += 2;
                    i += 5;
                } else if (i3 >= 240) {
                    i2 += 2;
                    i += 4;
                } else if (i3 >= 224) {
                    i2 += 2;
                    i += 3;
                } else if (i3 >= 192) {
                    i2 += 2;
                    i += 2;
                } else {
                    i2++;
                    i++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String getUserDescByGender(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65617, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f09ba);
                }
                return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13f0);
            }
            return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f09ba);
        }
        return (String) invokeI.objValue;
    }

    public static String longNumFormatOver(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65632, null, j)) == null) {
            if (j > 9999999) {
                float f = ((float) j) / 10000.0f;
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                return round + "w+";
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver10000(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65633, null, j)) == null) {
            if (j > 9999) {
                float f = ((float) j) / 10000.0f;
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                return round + ExifInterface.LONGITUDE_WEST;
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver10000wan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65634, null, j)) == null) {
            if (j > 9999999) {
                float f = ((float) j) / 10000.0f;
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                return round + "w+";
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String longNumFormatOver9999wanOnePoint(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65638, null, j)) == null) {
            if (j < 0) {
                return "0";
            }
            if (j > 99990000) {
                return "9999万+";
            }
            if (j > 9999) {
                DecimalFormat decimalFormat = new DecimalFormat("#0.0");
                return decimalFormat.format(((float) j) / 10000.0f) + "万";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    @Deprecated
    public static String numFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65639, null, i)) == null) {
            if (i > 9999) {
                return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
            }
            if (i < 0) {
                return "0";
            }
            return "" + i;
        }
        return (String) invokeI.objValue;
    }

    public static String numFormat9999W(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65640, null, j)) == null) {
            if (j > 9999999) {
                float f = ((float) j) / 10000.0f;
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                if (round >= 9999) {
                    return "9999W+";
                }
                return j + ExifInterface.LONGITUDE_WEST;
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65641, null, j)) == null) {
            if (j > 9999) {
                return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(((float) j) / 10000.0f));
            }
            if (j < 0) {
                return "0";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver100000ReturnInt(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65642, null, j)) == null) {
            if (j > 99999) {
                return ((int) (((float) j) / 10000.0f)) + ExifInterface.LONGITUDE_WEST;
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000ReturnInt(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65643, null, j)) == null) {
            if (j > 9999) {
                return ((int) (((float) j) / 10000.0f)) + ExifInterface.LONGITUDE_WEST;
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOver10000wan(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65644, null, f)) == null) {
            if (f > 9999999.0f) {
                float f2 = f / 10000.0f;
                long round = Math.round(f2);
                if (((float) round) > f2) {
                    round--;
                }
                return round + ExifInterface.LONGITUDE_WEST;
            } else if (f < 0.0f) {
                return "0";
            } else {
                return "" + f;
            }
        }
        return (String) invokeF.objValue;
    }

    public static long[] parseVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65660, null, str)) == null) {
            long[] jArr = new long[4];
            if (str != null) {
                String[] split = str.replace(".", "#").split("#");
                jArr[0] = JavaTypesHelper.toLong(split[0], 0L);
                jArr[1] = JavaTypesHelper.toLong(split[1], 0L);
                jArr[2] = JavaTypesHelper.toLong(split[2], 0L);
                if (split.length < 4) {
                    jArr[3] = 0;
                } else {
                    jArr[3] = JavaTypesHelper.toLong(split[3], 0L);
                }
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public static String formatDayTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65554, null, j)) == null) {
            return (((j / 3600000) / 24) + 1) + TIME_DAY;
        }
        return (String) invokeJ.objValue;
    }

    public static String formatTosepara(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            return new DecimalFormat("#,###").format(i);
        }
        return (String) invokeI.objValue;
    }

    public static String getChatTimeString(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, date2)) == null) {
            return getChatTimeString(new Date(), date2);
        }
        return (String) invokeL.objValue;
    }

    public static int getChineseAndEnglishLength(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, charSequence)) == null) {
            if (charSequence == null) {
                return 0;
            }
            int length = charSequence.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (di.isChinese(charSequence.charAt(i2))) {
                    i += 2;
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String getChineseFormatTimeString(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMATE_DATE_SECOND_CHINESE) {
                format = FORMATE_DATE_SECOND_CHINESE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getChineseYearBytime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65573, null, j)) == null) {
            return getYearBytime(j) + "年";
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
            synchronized (di.FORMATE_DATE_DAY_1) {
                format = di.FORMATE_DATE_DAY_1.format(date2);
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
            synchronized (di.FORMATE_DATE_DAY_NO_YEAR) {
                format = di.FORMATE_DATE_DAY_NO_YEAR.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getDateStringHM(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65581, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMATE_DATE_HOUR) {
                format = FORMATE_DATE_HOUR.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMHH(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65582, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMAT_DATE_MONTH_SECOND_) {
                format = FORMAT_DATE_MONTH_SECOND_.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMd(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65583, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMATE_MONTH_DAY) {
                format = FORMATE_MONTH_DAY.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdChinease(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65584, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMAT_MONTH_DAY_CHINEASE) {
                format = FORMAT_MONTH_DAY_CHINEASE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdHm(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65585, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMATE_MONTH_DAY_HOUR_MINUTE) {
                format = FORMATE_MONTH_DAY_HOUR_MINUTE.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringMdHmSs(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65586, null, j)) == null) {
            Date date2 = new Date(j);
            synchronized (FORMATE_DATE_SECOND) {
                format = FORMATE_DATE_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeJ.objValue;
    }

    public static String getDateStringYMH(long j) {
        InterceptResult invokeJ;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65587, null, j)) == null) {
            Date date2 = new Date(j);
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
            synchronized (di.FORMATE_DATE_DAY_WEEK) {
                format = di.FORMATE_DATE_DAY_WEEK.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatAlaLiveTime(long j) {
        InterceptResult invokeJ;
        String formatAlaLiveTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65591, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatAlaLiveTime = getFormatAlaLiveTime(date);
            }
            return formatAlaLiveTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTime(long j) {
        InterceptResult invokeJ;
        String formatTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65594, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatTime = getFormatTime(date, false);
            }
            return formatTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForAlaCardCreate(long j) {
        InterceptResult invokeJ;
        String formatTimeForAlaCardCreate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65596, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatTimeForAlaCardCreate = getFormatTimeForAlaCardCreate(date);
            }
            return formatTimeForAlaCardCreate;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForHomeC(long j) {
        InterceptResult invokeJ;
        String formatTimeHomeC;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65598, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatTimeHomeC = getFormatTimeHomeC(date);
            }
            return formatTimeHomeC;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeForJustNow(long j) {
        InterceptResult invokeJ;
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65599, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatTimeForJustNow = getFormatTimeForJustNow(date, false);
            }
            return formatTimeForJustNow;
        }
        return (String) invokeJ.objValue;
    }

    public static String getFormatTimeShort(long j) {
        InterceptResult invokeJ;
        String formatTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65603, null, j)) == null) {
            synchronized (date) {
                date.setTime(j);
                formatTime = getFormatTime(date, true);
            }
            return formatTime;
        }
        return (String) invokeJ.objValue;
    }

    public static String getPostTimeString(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            return getPostTimeString(new Date(), date2);
        }
        return (String) invokeL.objValue;
    }

    public static String getStringYearToSecond(Date date2) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, date2)) == null) {
            synchronized (FORMATE_DATE_SECOND) {
                format = FORMATE_DATE_SECOND.format(date2);
            }
            return format;
        }
        return (String) invokeL.objValue;
    }

    public static String getYearBytime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65619, null, j)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return String.valueOf(calendar.get(1));
        }
        return (String) invokeJ.objValue;
    }

    public static boolean isHttpUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, str)) == null) {
            if (str == null || str.length() <= 6 || !str.substring(0, 7).equalsIgnoreCase("http://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isHttpsUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, str)) == null) {
            if (str == null || str.length() <= 7 || !str.substring(0, 8).equalsIgnoreCase("https://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, str)) == null) {
            if (!di.isEmpty(str)) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, str)) == null) {
            if (di.isEmpty(str)) {
                return false;
            }
            try {
                Object nextValue = new JSONTokener(str).nextValue();
                if (nextValue instanceof JSONObject) {
                    return true;
                }
                boolean z = nextValue instanceof JSONArray;
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            if (!isHttpUrl(str) && !isHttpsUrl(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String trim(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65666, null, str)) == null) {
            if (str != null) {
                return str.trim();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String formatGiftNumForTDouDisPlay(long j) {
        InterceptResult invokeJ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            String valueOf = String.valueOf(j);
            if (j >= CoolPraiseView.BILLION) {
                long j2 = j % CoolPraiseView.BILLION;
                if (j2 != 0) {
                    double d = ((float) j) / 1.0E8f;
                    double d2 = j / CoolPraiseView.BILLION;
                    if (j2 > 999999.0d) {
                        str = String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                    } else {
                        str = d2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                    }
                    return str;
                }
                return (j / CoolPraiseView.BILLION) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (j >= 10000000) {
                float f = ((float) j) / 10000.0f;
                long j3 = j / 10000;
                if (j % 10000000 > 999) {
                    return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String formatNumForTdouDisPlay(long j) {
        InterceptResult invokeJ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65557, null, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            String valueOf = String.valueOf(j);
            if (j >= CoolPraiseView.BILLION) {
                long j2 = j % CoolPraiseView.BILLION;
                if (j2 != 0) {
                    double d = ((float) j) / 1.0E8f;
                    double d2 = j / CoolPraiseView.BILLION;
                    if (j2 > 999999.0d) {
                        str = String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                    } else {
                        str = d2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                    }
                    return str;
                }
                return (j / CoolPraiseView.BILLION) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (j >= 1000000) {
                float f = ((float) j) / 10000.0f;
                long j3 = j / 10000;
                if (j % 1000000 > 999) {
                    return String.format("%.2f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j3 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String formatOverBaiwanNum(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65558, null, f)) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            String valueOf = String.valueOf(f);
            if (f >= 1.0E8f) {
                if (f % 1.0E8f != 0.0f) {
                    double d = f / 1.0E8f;
                    return String.format("%.1f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (f / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (f >= 1000000.0f) {
                float f2 = f / 10000.0f;
                long j = f2;
                if (f2 > ((float) j)) {
                    return String.format("%.1f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeF.objValue;
    }

    public static String formatYdouOverBaiwanNum(float f) {
        InterceptResult invokeF;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65564, null, f)) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f >= 1.0E8f) {
                if (f % 1.0E8f != 0.0f) {
                    double d = f / 1.0E8f;
                    return String.format("%.2f", Double.valueOf(d)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (f / 1.0E8f) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (f >= 1000000.0f) {
                long j = f / 10000;
                if (f / 10000.0f > ((float) j)) {
                    return String.format("%.2f", Float.valueOf(f2)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                int i = (int) f;
                if (f > i) {
                    if (((int) (100.0f * f)) % 10 == 0) {
                        return String.format("%.1f", Float.valueOf(f));
                    }
                    return String.format("%.2f", Float.valueOf(f));
                }
                return String.valueOf(i);
            }
        }
        return (String) invokeF.objValue;
    }

    public static String numberUniformFormatExtraWithRoundInt(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65657, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
                if (format.endsWith(".0")) {
                    format = format.substring(0, format.length() - 2);
                }
                return format + ExifInterface.LONGITUDE_WEST;
            } else {
                String format2 = String.format("%.1f", Double.valueOf((j / 1000000.0d) / 10.0d));
                if (format2.endsWith(".0")) {
                    format2 = format2.substring(0, format2.length() - 2);
                }
                float f = JavaTypesHelper.toFloat(format2, 1.0f);
                if (f >= 9999.0f) {
                    return "9999KW+";
                }
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "KW";
                }
                return f + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String formatOverBaiwanNum(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65559, null, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            String valueOf = String.valueOf(j);
            if (j >= CoolPraiseView.BILLION) {
                if (j % CoolPraiseView.BILLION != 0) {
                    return String.format("%.1f", Double.valueOf(((float) j) / 1.0E8f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
                }
                return (j / CoolPraiseView.BILLION) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_yi);
            } else if (j >= 1000000) {
                float f = ((float) j) / 10000.0f;
                long j2 = j / 10000;
                if (f > ((float) j2)) {
                    return String.format("%.1f", Float.valueOf(f)) + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
                }
                return j2 + TbadkCoreApplication.getInst().getResources().getString(R.string.unit_wan);
            } else {
                return valueOf;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String formatSecondsTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65561, null, j)) == null) {
            long j2 = j % 60;
            long j3 = (j / 60) % 60;
            long j4 = j / 3600;
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            sb.setLength(0);
            if (j4 > 0) {
                return formatter.format("%d:%02d:%02d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString();
            }
            return formatter.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j2)).toString();
        }
        return (String) invokeJ.objValue;
    }

    public static String formatTosepara(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65563, null, j)) == null) {
            return new DecimalFormat("#,###").format(j);
        }
        return (String) invokeJ.objValue;
    }

    public static int getChineseAndEnglishLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (di.isChinese(str.charAt(i2))) {
                    i += 2;
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String generateTimeStrByWidth(long j, long j2, long j3, long j4, TextPaint textPaint, int i, String str) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), textPaint, Integer.valueOf(i), str})) == null) {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            if (textPaint != null && i != 0) {
                String str3 = str2 + " ";
                float f = i;
                if (textPaint.measureText(str3) > f) {
                    return str2;
                }
                StringBuilder sb = new StringBuilder(str3);
                long[] jArr = {j, j2, j3, j4};
                int length = TIME_STR.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (textPaint.measureText(sb.toString() + jArr[i2] + TIME_STR[i2]) > f) {
                        break;
                    }
                    sb.append(jArr[i2]);
                    sb.append(TIME_STR[i2]);
                }
                return sb.toString();
            }
            return String.format(str2 + " " + TbadkCoreApplication.getInst().getResources().getString(R.string.headlines_item_count_down), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
        return (String) invokeCommon.objValue;
    }

    public static String getBaAgeAutoYearAndMonth(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1);
            }
            float f = JavaTypesHelper.toFloat(str, 0.0f);
            if (f > 1.0f) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), Integer.valueOf(Math.round(f)));
            }
            int round = Math.round(f * 12.0f);
            if (round >= 12) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_more_one_year), 1);
            }
            if (round < 1) {
                return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), 1);
            }
            return String.format(TbadkCoreApplication.getInst().getString(R.string.ba_age_less_one_year), Integer.valueOf(round));
        }
        return (String) invokeL.objValue;
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
            if (time < 86400000) {
                if (time < 3600000) {
                    if (time < 60000) {
                        return "1" + ALA_CARD_MIN_BEFORE;
                    }
                    return String.valueOf(time / 60000) + ALA_CARD_MIN_BEFORE;
                }
                return String.valueOf(time / 3600000) + ALA_CARD_HOUR_BEFORE;
            }
            return String.valueOf(time / 86400000) + ALA_CARD_DAY_BEFORE;
        }
        return (String) invokeL.objValue;
    }

    public static String getFormatTimeHomeC(Date date2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, date2)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time < 86400000 && time > 0) {
                if (time < 3600000) {
                    if (time < 60000) {
                        long j = time / 1000;
                        if (j == 0) {
                            j = 1;
                        }
                        return String.valueOf(j) + SEC_BEFORE;
                    }
                    return String.valueOf(time / 60000) + MIN_BEFORE;
                }
                return String.valueOf(time / 3600000) + HOUR_BEFORE;
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.more_one_day);
        }
        return (String) invokeL.objValue;
    }

    public static String getTimeSpace(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65616, null, j)) == null) {
            if (j <= 0) {
                return "1秒";
            }
            if (j < 86400000) {
                if (j < 3600000) {
                    if (j < 60000) {
                        long j2 = j / 1000;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        return String.valueOf(j2) + TIME_SECOND;
                    }
                    return String.valueOf(j / 60000) + TIME_MINUTE;
                }
                return String.valueOf(j / 3600000) + TIME_HOUR;
            }
            return String.valueOf(j / 86400000) + TIME_DAY;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanWithNegative(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65648, null, j)) == null) {
            if (j > 99990000) {
                return "9999W+";
            }
            if (j >= 10000000) {
                return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
            }
            int i = (j > 10000L ? 1 : (j == 10000L ? 0 : -1));
            if (i > 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
            }
            if (i == 0) {
                return "1W";
            }
            if (j < -99990000) {
                return "-9999W+";
            }
            if (j <= -10000000) {
                return String.valueOf(j / 10000) + ExifInterface.LONGITUDE_WEST;
            }
            int i2 = (j > (-10000L) ? 1 : (j == (-10000L) ? 0 : -1));
            if (i2 < 0) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
            }
            if (i2 == 0) {
                return "-1W";
            }
            return "" + j;
        }
        return (String) invokeJ.objValue;
    }

    public static String numFormatOverWanWithoutDecimals(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65649, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 100000) {
                return String.format(Locale.getDefault(), "%.1fW", Float.valueOf(((float) j) / 10000.0f));
            } else {
                if (j < 10000000) {
                    return (j / 10000) + ExifInterface.LONGITUDE_WEST;
                }
                float f = ((float) (j / 1000000)) / 10.0f;
                if (f >= 9999.0f) {
                    return "9999KW+";
                }
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "KW";
                }
                return ((int) f) + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65652, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                float f = ((float) (j / 1000)) / 10.0f;
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "万";
                }
                return f + "万";
            } else {
                float f2 = ((float) (j / 1000000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "千万";
                }
                return f2 + "千万";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtra(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65653, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                float f = ((float) (j / 1000)) / 10.0f;
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + ExifInterface.LONGITUDE_WEST;
                }
                return f + ExifInterface.LONGITUDE_WEST;
            } else {
                float f2 = ((float) (j / 1000000)) / 10.0f;
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

    public static String numberUniformFormatExtraWithCollect(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65654, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
                if (format.endsWith(".0")) {
                    format = format.substring(0, format.length() - 2);
                }
                return format + ExifInterface.LONGITUDE_WEST;
            } else {
                float f = ((float) (j / 1000000)) / 10.0f;
                if (f >= 9.0f) {
                    return "9KW+";
                }
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "KW";
                }
                return f + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRound(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65655, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                return String.format("%.1f", Double.valueOf(j / 10000.0d)) + ExifInterface.LONGITUDE_WEST;
            } else {
                float f = ((float) (j / 1000000)) / 10.0f;
                if (f >= 9999.0f) {
                    return "9999KW+";
                }
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + "KW";
                }
                return f + "KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRoundFloat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65656, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            }
            double d = j;
            if (d < 9999000.0d) {
                float f = ((float) (j / 1000)) / 10.0f;
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + ExifInterface.LONGITUDE_WEST;
                }
                return f + ExifInterface.LONGITUDE_WEST;
            } else if (d < 9.9999E10d) {
                float f2 = ((float) (j / 1000000)) / 10.0f;
                if (f2 % 1.0f == 0.0f) {
                    return ((int) f2) + "KW";
                }
                return f2 + "KW";
            } else {
                return "9999.9KW";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String numberUniformFormatExtraWithRoundVote(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65658, null, j)) == null) {
            if (j <= 0) {
                return "0";
            }
            if (j < 10000) {
                return j + "";
            } else if (j < 10000000) {
                String format = String.format("%.1f", Double.valueOf(j / 10000.0d));
                if (format.endsWith(".0")) {
                    format = format.substring(0, format.length() - 2);
                }
                return format + "w";
            } else {
                float f = ((float) (j / 1000000)) / 10.0f;
                if (f >= 999.0f) {
                    return "999kw+";
                }
                if (f % 1.0f == 0.0f) {
                    return ((int) f) + TiebaStatic.Params.H5_FORUM_NAME;
                }
                return f + TiebaStatic.Params.H5_FORUM_NAME;
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String showTimeString(long j) {
        InterceptResult invokeJ;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65661, null, j)) == null) {
            Date date2 = new Date(j);
            if (date2.getMinutes() < 10) {
                valueOf = "0" + date2.getMinutes();
            } else {
                valueOf = String.valueOf(date2.getMinutes());
            }
            if (date2.getHours() > 12) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours() - 12), valueOf});
            }
            if (date2.getHours() == 12) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_afternoon, new Object[]{String.valueOf(date2.getHours()), valueOf});
            }
            if (date2.getHours() == 0) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(12), valueOf});
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.time_show_morning, new Object[]{String.valueOf(date2.getHours()), valueOf});
        }
        return (String) invokeJ.objValue;
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
                if (time > -120000) {
                    return "刚刚";
                }
                return di.getDateStringDay(date3);
            } else if (time < 30000) {
                return "刚刚";
            } else {
                if (time < 60000) {
                    return "半分钟前";
                }
                if (time < 3600000) {
                    return String.valueOf((time * 60) / 3600000) + "分钟前";
                } else if (time < 86400000) {
                    if (day == 0) {
                        return di.getDateStringHm(date3);
                    }
                    return "1天前";
                } else if (time < 2678400000L) {
                    return String.valueOf((time * 31) / 2678400000L) + "天前";
                } else if (time < 2764800000L) {
                    return "1个月前";
                } else {
                    if (date2.getYear() == date3.getYear()) {
                        synchronized (di.FORMATE_DATE_DAY_NO_YEAR) {
                            format2 = di.FORMATE_DATE_DAY_NO_YEAR.format(date3);
                        }
                        return format2;
                    }
                    synchronized (di.FORMATE_DATE_DAY) {
                        format = di.FORMATE_DATE_DAY.format(date3);
                    }
                    return format;
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getFormatTime(Date date2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65595, null, date2, z)) == null) {
            if (date2 == null) {
                return "";
            }
            long time = new Date().getTime() - date2.getTime();
            if (time < 86400000 && time > 0) {
                if (time < 3600000) {
                    if (time < 60000) {
                        long j = time / 1000;
                        if (j == 0) {
                            j = 1;
                        }
                        return String.valueOf(j) + SEC_BEFORE;
                    }
                    return String.valueOf(time / 60000) + MIN_BEFORE;
                }
                return String.valueOf(time / 3600000) + HOUR_BEFORE;
            } else if (z) {
                return getDateStringDayNoYear(date2);
            } else {
                return di.getDateStringDay(date2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String getPostTimeString(Date date2, Date date3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, date2, date3)) == null) {
            if (date3 == null) {
                return "";
            }
            int day = date2.getDay() - date3.getDay();
            long time = date2.getTime() - date3.getTime();
            if (time < 0) {
                if (time > -120000) {
                    return "刚刚";
                }
                return di.getDateStringDay(date3);
            } else if (time < 30000) {
                return "刚刚";
            } else {
                if (time < 60000) {
                    return "半分钟前";
                }
                if (time < 3600000) {
                    return String.valueOf((time * 60) / 3600000) + "分钟前";
                } else if (time < 86400000) {
                    if (day == 0) {
                        return di.getDateStringHm(date3);
                    }
                    return "1天前";
                } else if (time < 2678400000L) {
                    return String.valueOf((time * 31) / 2678400000L) + "天前";
                } else if (time < 2764800000L) {
                    return "1个月前";
                } else {
                    return di.getDateStringDay(date3);
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getWeekString(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65618, null, i, i2, i3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, i);
            calendar.set(2, i2);
            calendar.set(5, i3);
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

    public static SpannableString highLightText(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65621, null, str, i, i2, i3)) == null) {
            if (!TextUtils.isEmpty(str) && i3 > 0) {
                SpannableString spannableString = new SpannableString(str);
                if (i < i2 && i < str.length() && str.length() >= i2) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), i, i2, 33);
                }
                return spannableString;
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeLIII.objValue;
    }

    public static SpannableString highLightText(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65622, null, str, str2, i)) == null) {
            return highLightText(str, str2, i, true);
        }
        return (SpannableString) invokeLLI.objValue;
    }

    public static SpannableString highLightText(String str, String str2, int i, boolean z) {
        InterceptResult invokeCommon;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65623, null, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!TextUtils.isEmpty(str) && i > 0) {
                SpannableString spannableString = new SpannableString(str);
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    if (z) {
                        lastIndexOf = str.indexOf(str2);
                    } else {
                        lastIndexOf = str.lastIndexOf(str2);
                    }
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i)), lastIndexOf, str2.length() + lastIndexOf, 33);
                }
                return spannableString;
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public static String long2String(long j, String str) {
        InterceptResult invokeJL;
        Date date2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65631, null, j, str)) == null) {
            if (String.valueOf(j).length() == 10) {
                date2 = new Date(j * 1000);
            } else {
                date2 = new Date(j);
            }
            return new SimpleDateFormat(str).format(date2);
        }
        return (String) invokeJL.objValue;
    }

    public static String numFormatOver10000wan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65645, null, j)) == null) {
            if (j > 9999999) {
                float f = ((float) j) / 10000.0f;
                long round = Math.round(f);
                if (((float) round) > f) {
                    round--;
                }
                return round + ExifInterface.LONGITUDE_WEST;
            } else if (j < 0) {
                return "0";
            } else {
                return "" + j;
            }
        }
        return (String) invokeJ.objValue;
    }
}
