package c.a.q0.a.d0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cArr)) == null) {
            if (cArr == null || cArr.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (char c2 : cArr) {
                if (c2 != 0) {
                    sb.append(c2);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static char[] b(char[][] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cArr)) == null) {
            if (cArr == null || cArr[0] == null) {
                return null;
            }
            char[] cArr2 = new char[cArr.length * cArr[0].length];
            int i2 = 0;
            for (int i3 = 0; i3 < cArr.length; i3++) {
                for (int i4 = 0; i4 < cArr[i3].length; i4++) {
                    if (cArr[i3][i4] != 0) {
                        cArr2[i2] = cArr[i3][i4];
                        i2++;
                    }
                }
            }
            return cArr2;
        }
        return (char[]) invokeL.objValue;
    }

    public static void c(char[] cArr, char[][] cArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cArr, cArr2) == null) {
            int length = cArr2.length;
            int length2 = cArr2[0].length;
            int i2 = 0;
            int i3 = 0;
            for (char c2 : cArr) {
                if (i2 >= length2) {
                    i3++;
                    i2 = 0;
                }
                if (i3 >= length) {
                    return;
                }
                cArr2[i3][i2] = c2;
                i2++;
            }
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("!") && str.startsWith("$")) {
                return str.replace("$", "").replace("!", "");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static char[][] e(char[][] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cArr)) == null) {
            if (cArr == null || cArr[0] == null) {
                return null;
            }
            char[][] cArr2 = (char[][]) Array.newInstance(char.class, cArr.length, cArr[0].length);
            for (int length = cArr.length - 1; length >= 0; length--) {
                cArr2[(cArr.length - length) - 1] = cArr[length];
            }
            return cArr2;
        }
        return (char[][]) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            char[] charArray = str.toCharArray();
            char[][] cArr = (char[][]) Array.newInstance(char.class, (charArray.length / 2) + 1, 2);
            c(charArray, cArr);
            return a(b(e(cArr)));
        }
        return (String) invokeL.objValue;
    }
}
