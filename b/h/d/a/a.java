package b.h.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= 'a' && c2 <= 'z' : invokeCommon.booleanValue;
    }

    public static boolean b(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= 'A' && c2 <= 'Z' : invokeCommon.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                if (b(str.charAt(i2))) {
                    char[] charArray = str.toCharArray();
                    while (i2 < length) {
                        char c2 = charArray[i2];
                        if (b(c2)) {
                            charArray[i2] = (char) (c2 ^ ' ');
                        }
                        i2++;
                    }
                    return String.valueOf(charArray);
                }
                i2++;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static char d(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? a(c2) ? (char) (c2 ^ ' ') : c2 : invokeCommon.charValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                if (a(str.charAt(i2))) {
                    char[] charArray = str.toCharArray();
                    while (i2 < length) {
                        char c2 = charArray[i2];
                        if (a(c2)) {
                            charArray[i2] = (char) (c2 ^ ' ');
                        }
                        i2++;
                    }
                    return String.valueOf(charArray);
                }
                i2++;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
