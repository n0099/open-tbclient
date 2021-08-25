package c.a.o0.a.h1.c;

import android.graphics.Color;
import android.text.TextUtils;
import c.a.o0.a.v2.n0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str, int i2) {
        InterceptResult invokeLI;
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                c.a.o0.a.e0.d.l("map", "color string is empty, use default " + Integer.toHexString(i2));
                return i2;
            }
            try {
                if (str.charAt(0) == '#') {
                    String substring = str.substring(1);
                    if (substring.length() != 6 && substring.length() != 8) {
                        throw new IllegalArgumentException("char count not right");
                    }
                    if (substring.length() == 6) {
                        parseLong = Long.parseLong(substring, 16) | (-16777216);
                    } else {
                        parseLong = Long.parseLong(substring.substring(6) + substring.substring(0, 6), 16);
                    }
                    return (int) parseLong;
                }
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                c.a.o0.a.e0.d.l("map", "parse color error, use default " + Integer.toHexString(i2));
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static float b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) ? (float) (d2 * n0.l(AppRuntime.getAppContext())) : invokeCommon.floatValue;
    }
}
