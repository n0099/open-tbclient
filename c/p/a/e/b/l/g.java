package c.p.a.e.b.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, strArr)) == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append('\"');
            sb.append(str2);
            sb.append('\"');
            sb.append(" (");
            h(sb, strArr);
            sb.append(") VALUES (");
            d(sb, strArr.length);
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, strArr)) == null) {
            String str2 = '\"' + str + '\"';
            StringBuilder sb = new StringBuilder("DELETE FROM ");
            sb.append(str2);
            if (strArr != null && strArr.length > 0) {
                sb.append(" WHERE ");
                g(sb, str2, strArr);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, strArr, strArr2)) == null) {
            String str2 = '\"' + str + '\"';
            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append(str2);
            sb.append(" SET ");
            j(sb, strArr);
            if (strArr2 != null && strArr2.length > 0) {
                sb.append(" WHERE ");
                g(sb, str2, strArr2);
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static StringBuilder d(StringBuilder sb, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, sb, i2)) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 < i2 - 1) {
                    sb.append("?,");
                } else {
                    sb.append('?');
                }
            }
            return sb;
        }
        return (StringBuilder) invokeLI.objValue;
    }

    public static StringBuilder e(StringBuilder sb, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sb, str)) == null) {
            sb.append('\"');
            sb.append(str);
            sb.append('\"');
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }

    public static StringBuilder f(StringBuilder sb, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, sb, str, str2)) == null) {
            sb.append(str);
            sb.append(".\"");
            sb.append(str2);
            sb.append('\"');
            return sb;
        }
        return (StringBuilder) invokeLLL.objValue;
    }

    public static StringBuilder g(StringBuilder sb, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, sb, str, strArr)) == null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                f(sb, str, strArr[i2]);
                sb.append("=?");
                if (i2 < strArr.length - 1) {
                    sb.append(',');
                }
            }
            return sb;
        }
        return (StringBuilder) invokeLLL.objValue;
    }

    public static StringBuilder h(StringBuilder sb, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, sb, strArr)) == null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append('\"');
                sb.append(strArr[i2]);
                sb.append('\"');
                if (i2 < length - 1) {
                    sb.append(',');
                }
            }
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }

    public static String i(String str, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, strArr, strArr2)) == null) {
            StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
            sb.append('\"' + str + '\"');
            sb.append(" (");
            h(sb, strArr);
            sb.append(") VALUES (");
            d(sb, strArr.length);
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static StringBuilder j(StringBuilder sb, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, sb, strArr)) == null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                e(sb, strArr[i2]);
                sb.append("=?");
                if (i2 < strArr.length - 1) {
                    sb.append(',');
                }
            }
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }
}
