package com.baidu.android.common.others.lang;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class StringUtils {
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

    public static boolean containsWhitespace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(charSequence.charAt(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean endsWith(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
            if (str != null && str2 != null) {
                if (str.endsWith(str2)) {
                    return true;
                }
                if (str.length() >= str2.length() && z) {
                    return str.substring(str.length() - str2.length()).toLowerCase(Locale.getDefault()).equals(str2.toLowerCase(Locale.getDefault()));
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static int getRepetitions(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, str, str2)) != null) {
            return invokeLL.intValue;
        }
        int i2 = 0;
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf == -1) {
                return i3;
            }
            i3++;
            i2 = indexOf + str2.length();
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) {
            if (charSequence != null && (length = charSequence.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!Character.isWhitespace(charSequence.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int length(String str, boolean z) {
        InterceptResult invokeLZ;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i2 = 0;
            for (char c2 : str.toCharArray()) {
                float f2 = 2.0f;
                if (c2 > 0 && c2 < 127 && z) {
                    f2 = 1.0f;
                }
                i2 = (int) (i2 + f2);
            }
            return i2;
        }
        return invokeLZ.intValue;
    }

    public static boolean startsWith(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, str, str2, z)) == null) {
            if (str == null || str2 == null || str.length() < str2.length()) {
                return false;
            }
            if (str.startsWith(str2)) {
                return true;
            }
            if (z) {
                return str.substring(0, str2.length()).toLowerCase(Locale.getDefault()).equals(str2.toLowerCase(Locale.getDefault()));
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase(Locale.getDefault());
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            if (sb.length() > 1) {
                return sb.substring(0, sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }
}
