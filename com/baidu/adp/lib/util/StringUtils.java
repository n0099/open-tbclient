package com.baidu.adp.lib.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class StringUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PASSWORD_PREFIX = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})";
    public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm";
    public static final String lineSeparator;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(359337454, "Lcom/baidu/adp/lib/util/StringUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(359337454, "Lcom/baidu/adp/lib/util/StringUtils;");
                return;
            }
        }
        lineSeparator = System.getProperty("line.separator");
    }

    public StringUtils() {
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

    public static String SimpleDateFormat(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date)) == null) {
            if (date == null) {
                return null;
            }
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        }
        return (String) invokeL.objValue;
    }

    public static final void clearStringBuilder(StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sb) == null) || sb == null || sb.length() <= 0) {
            return;
        }
        sb.delete(0, sb.length());
    }

    public static long getyyyyMMddHHTimeForNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return (calendar.get(1) * 1000000) + 0 + ((calendar.get(2) + 1) * 10000) + (calendar.get(5) * 100) + calendar.get(11);
        }
        return invokeV.longValue;
    }

    public static Date handleDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? handleDate(str, "yyyy-MM-dd HH:mm") : (Date) invokeL.objValue;
    }

    public static boolean isChinese(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c2)})) == null) ? Pattern.compile("[一-龥]").matcher(String.valueOf(c2)).find() : invokeCommon.booleanValue;
    }

    public static boolean isJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    if (jSONArray.getJSONObject(0) != null) {
                        return true;
                    }
                }
            } catch (Error | Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isNULL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? str == null : invokeL.booleanValue;
    }

    public static boolean isNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? str == null || str.trim().length() == 0 : invokeL.booleanValue;
    }

    public static boolean isValidPassWord(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.contains(" ")) {
                return false;
            }
            return str.matches(PASSWORD_PREFIX);
        }
        return invokeL.booleanValue;
    }

    public static final String string(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, objArr)) == null) {
            if (objArr != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Object obj : objArr) {
                    if (obj != null) {
                        if (obj instanceof String) {
                            stringBuffer.append((String) obj);
                        } else {
                            stringBuffer.append(String.valueOf(obj));
                        }
                    }
                }
                return stringBuffer.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String translateSecondsToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            if (i2 <= 0) {
                return "00:00";
            }
            int i3 = i2 / 60;
            if (i3 < 60) {
                return unitFormat(i3) + ":" + unitFormat(i2 % 60);
            }
            int i4 = i3 / 60;
            if (i4 > 99) {
                return "99:59:59";
            }
            int i5 = i3 % 60;
            return unitFormat(i4) + ":" + unitFormat(i5) + ":" + unitFormat((i2 - (i4 * 3600)) - (i5 * 60));
        }
        return (String) invokeI.objValue;
    }

    @NonNull
    public static String tryFixDefaultValue(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public static String unitFormat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) {
            if (i2 >= 0 && i2 < 10) {
                return "0" + Integer.toString(i2);
            }
            return "" + i2;
        }
        return (String) invokeI.objValue;
    }

    public static Date handleDate(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "yyyy-MM-dd HH:mm";
            }
            if (str != null && str.length() != 0) {
                try {
                    return new SimpleDateFormat(str2).parse(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Date) invokeLL.objValue;
    }

    public static boolean isNull(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, str, z)) == null) {
            boolean z2 = str == null || str.trim().length() == 0;
            if (z2 || !z || str == null || !str.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                return z2;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static String SimpleDateFormat(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, date, str)) == null) {
            if (date == null) {
                return null;
            }
            if (str == null) {
                str = "yyyy-MM-dd HH:mm";
            }
            return new SimpleDateFormat(str).format(date);
        }
        return (String) invokeLL.objValue;
    }
}
