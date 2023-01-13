package com.baidu.adp.lib.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
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
/* loaded from: classes.dex */
public class StringUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PASSWORD_PREFIX = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})";
    public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm";
    public static final String lineSeparator;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static boolean isNULL(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? str == null : invokeL.booleanValue;
    }

    @NonNull
    public static String tryFixDefaultValue(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sb) == null) && sb != null && sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }

    public static Date handleDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return handleDate(str, "yyyy-MM-dd HH:mm");
        }
        return (Date) invokeL.objValue;
    }

    public static boolean isJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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

    public static boolean isNotNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return !isNull(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str != null && str.trim().length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidPassWord(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.contains(" ")) {
                return str.matches(PASSWORD_PREFIX);
            }
            return false;
        }
        return invokeL.booleanValue;
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

    public static boolean equalsIgnoreNull(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (isNull(str) && isNull(str2)) {
                return true;
            }
            return str.equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static Date handleDate(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
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

    public static long getyyyyMMddHHTimeForNow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return (calendar.get(1) * 1000000) + 0 + ((calendar.get(2) + 1) * 10000) + (calendar.get(5) * 100) + calendar.get(11);
        }
        return invokeV.longValue;
    }

    public static boolean isChinese(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Character.valueOf(c)})) == null) {
            if (Pattern.compile("[一-龥]").matcher(String.valueOf(c)).find()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final String string(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, objArr)) == null) {
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

    public static String unitFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i)) == null) {
            if (i >= 0 && i < 10) {
                return "0" + Integer.toString(i);
            }
            return "" + i;
        }
        return (String) invokeI.objValue;
    }

    public static boolean isNull(String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, str, z)) == null) {
            if (str != null && str.trim().length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && z && str != null && str.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                return true;
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    public static String translateSecondsToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            if (i <= 0) {
                return BdPlayerProgressView.DEFAULT_TIME_TEXT;
            }
            int i2 = i / 60;
            if (i2 < 60) {
                return unitFormat(i2) + ":" + unitFormat(i % 60);
            }
            int i3 = i2 / 60;
            if (i3 > 99) {
                return "99:59:59";
            }
            int i4 = i2 % 60;
            return unitFormat(i3) + ":" + unitFormat(i4) + ":" + unitFormat((i - (i3 * 3600)) - (i4 * 60));
        }
        return (String) invokeI.objValue;
    }
}
