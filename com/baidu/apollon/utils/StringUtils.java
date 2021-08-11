package com.baidu.apollon.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.client.result.ResultParser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public abstract class StringUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StringUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, collection)) == null) ? collectionToDelimitedString(collection, ",") : (String) invokeL.objValue;
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, collection, str, str2, str3)) == null) {
            if (CollectionUtils.isEmpty(collection)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                sb.append(str2);
                sb.append(it.next());
                sb.append(str3);
                if (it.hasNext()) {
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static String fen2Yuan(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2).toString();
        }
        return (String) invokeL.objValue;
    }

    public static BigDecimal fen2YuanBigDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2);
        }
        return (BigDecimal) invokeL.objValue;
    }

    public static String formatAmount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? fen2Yuan(yuan2Fen(str)) : (String) invokeL.objValue;
    }

    public static String formatMoneyAmount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str.contains(".")) {
                int indexOf = str.indexOf(".");
                String substring = str.substring(indexOf + 1);
                String substring2 = str.substring(0, indexOf);
                if (substring.length() < 2) {
                    substring = substring + "0";
                }
                return substring2 + "." + substring;
            }
            return str + ".00";
        }
        return (String) invokeL.objValue;
    }

    public static String formatPhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            LogUtil.d("formatPhoneNumber. number = " + str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt >= '0' && charAt <= '9') {
                    stringBuffer.append(charAt);
                }
            }
            if (stringBuffer.length() > 11) {
                stringBuffer = new StringBuffer(stringBuffer.substring(stringBuffer.length() - 11));
            } else if (stringBuffer.length() < 11) {
                return null;
            }
            stringBuffer.insert(7, ' ');
            stringBuffer.insert(3, ' ');
            LogUtil.d("formatPhoneNumber. mobile = " + ((Object) stringBuffer));
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasLength(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, charSequence)) == null) ? charSequence != null && charSequence.length() > 0 : invokeL.booleanValue;
    }

    public static boolean isAmountMoreThanZero(String str) {
        InterceptResult invokeL;
        BigDecimal bigDecimal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                bigDecimal = new BigDecimal(str);
            } catch (Exception unused) {
                bigDecimal = new BigDecimal("0");
            }
            return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean isBankCardNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? Pattern.compile("^[1-9][0-9]{5,31}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isEmail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isPhoneNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? Pattern.compile("^1[0-9]{10}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static float parseFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }

    public static int parseInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static long parseLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String priceAdd(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            return new BigDecimal(str).add(new BigDecimal(str2)).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String replaceBom(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? (TextUtils.isEmpty(str) || str == null || !str.startsWith(ResultParser.BYTE_ORDER_MARK)) ? str : str.substring(1) : (String) invokeL.objValue;
    }

    public static String scoreFenToScore(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "1";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            BigDecimal bigDecimal2 = new BigDecimal(str2);
            if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ONE;
            }
            BigDecimal divide = bigDecimal.divide(bigDecimal2);
            if (LogUtil.DEBUG) {
                LogUtil.logd("score=" + str + "#radio=" + str2 + "#scorefen=" + divide.setScale(0, 1).toString());
            }
            return divide.setScale(0, 1).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String scroeToScoreFen(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "1";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            BigDecimal bigDecimal2 = new BigDecimal(str2);
            if (bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal2 = BigDecimal.ONE;
            }
            BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
            if (LogUtil.DEBUG) {
                LogUtil.logd("score=" + str + "#radio=" + str2 + "#scorefen=" + multiply.setScale(0, 1).toString());
            }
            return multiply.setScale(0, 1).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String[] toStringArray(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, collection)) == null) {
            if (collection == null) {
                return null;
            }
            return (String[]) collection.toArray(new String[collection.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    public static String[] tokenizeToStringArray(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, str2)) == null) ? tokenizeToStringArray(str, str2, true, true) : (String[]) invokeLL.objValue;
    }

    public static String trimAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? !TextUtils.isEmpty(str) ? str.replace(" ", "") : "" : (String) invokeL.objValue;
    }

    public static String yuan2Fen(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            try {
                return String.valueOf(new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0));
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? hasLength((CharSequence) str) : invokeL.booleanValue;
    }

    public static String[] tokenizeToStringArray(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (str == null) {
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            ArrayList arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (z) {
                    nextToken = nextToken.trim();
                }
                if (!z2 || nextToken.length() > 0) {
                    arrayList.add(nextToken);
                }
            }
            return toStringArray(arrayList);
        }
        return (String[]) invokeCommon.objValue;
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, str)) == null) ? collectionToDelimitedString(collection, str, "", "") : (String) invokeLL.objValue;
    }
}
