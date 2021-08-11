package c.i.b.a.i0;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int[] a(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            int[] iArr = new int[4];
            if (TextUtils.isEmpty(str)) {
                iArr[0] = -1;
                return iArr;
            }
            int length = str.length();
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                length = indexOf;
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1 || indexOf2 > length) {
                indexOf2 = length;
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 == -1 || indexOf3 > indexOf2) {
                indexOf3 = indexOf2;
            }
            int indexOf4 = str.indexOf(58);
            if (indexOf4 > indexOf3) {
                indexOf4 = -1;
            }
            int i3 = indexOf4 + 2;
            if (i3 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i3) == '/') {
                i2 = str.indexOf(47, indexOf4 + 3);
                if (i2 == -1 || i2 > indexOf2) {
                    i2 = indexOf2;
                }
            } else {
                i2 = indexOf4 + 1;
            }
            iArr[0] = indexOf4;
            iArr[1] = i2;
            iArr[2] = indexOf2;
            iArr[3] = length;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static String b(StringBuilder sb, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, sb, i2, i3)) == null) {
            if (i2 >= i3) {
                return sb.toString();
            }
            if (sb.charAt(i2) == '/') {
                i2++;
            }
            int i6 = i2;
            int i7 = i6;
            while (i6 <= i3) {
                if (i6 == i3) {
                    i4 = i6;
                } else if (sb.charAt(i6) == '/') {
                    i4 = i6 + 1;
                } else {
                    i6++;
                }
                int i8 = i7 + 1;
                if (i6 == i8 && sb.charAt(i7) == '.') {
                    sb.delete(i7, i4);
                    i3 -= i4 - i7;
                } else {
                    if (i6 == i7 + 2 && sb.charAt(i7) == '.' && sb.charAt(i8) == '.') {
                        i5 = sb.lastIndexOf("/", i7 - 2) + 1;
                        int i9 = i5 > i2 ? i5 : i2;
                        sb.delete(i9, i4);
                        i3 -= i4 - i9;
                    } else {
                        i5 = i6 + 1;
                    }
                    i7 = i5;
                }
                i6 = i7;
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            int[] a2 = a(str2);
            if (a2[0] != -1) {
                sb.append(str2);
                b(sb, a2[1], a2[2]);
                return sb.toString();
            }
            int[] a3 = a(str);
            if (a2[3] == 0) {
                sb.append((CharSequence) str, 0, a3[3]);
                sb.append(str2);
                return sb.toString();
            } else if (a2[2] == 0) {
                sb.append((CharSequence) str, 0, a3[2]);
                sb.append(str2);
                return sb.toString();
            } else if (a2[1] != 0) {
                int i2 = a3[0] + 1;
                sb.append((CharSequence) str, 0, i2);
                sb.append(str2);
                return b(sb, a2[1] + i2, i2 + a2[2]);
            } else if (str2.charAt(a2[1]) == '/') {
                sb.append((CharSequence) str, 0, a3[1]);
                sb.append(str2);
                return b(sb, a3[1], a3[1] + a2[2]);
            } else if (a3[0] + 2 < a3[1] && a3[1] == a3[2]) {
                sb.append((CharSequence) str, 0, a3[1]);
                sb.append('/');
                sb.append(str2);
                return b(sb, a3[1], a3[1] + a2[2] + 1);
            } else {
                int lastIndexOf = str.lastIndexOf(47, a3[2] - 1);
                int i3 = lastIndexOf == -1 ? a3[1] : lastIndexOf + 1;
                sb.append((CharSequence) str, 0, i3);
                sb.append(str2);
                return b(sb, a3[1], i3 + a2[2]);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Uri d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? Uri.parse(c(str, str2)) : (Uri) invokeLL.objValue;
    }
}
