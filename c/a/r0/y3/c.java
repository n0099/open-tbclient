package c.a.r0.y3;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final ThemeElement a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801442722, "Lc/a/r0/y3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801442722, "Lc/a/r0/y3/c;");
                return;
            }
        }
        ThemeElement.Builder builder = new ThemeElement.Builder();
        builder.common_color = "#FF614EC2";
        builder.dark_color = "#FF614EC2";
        builder.light_color = "#FF614EC2";
        builder.pattern_image = "http://imgsrc.baidu.com/forum/pic/item/00a8540828381f3028c4e2d1a6014c086f06f075.jpg";
        builder.font_color = "#FFFFFFFF";
        a = builder.build(false);
    }

    public static int a(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? (i2 & 16777215) | (((int) ((i2 >>> 24) * f2)) << 24) : invokeCommon.intValue;
    }

    @NonNull
    public static ThemeElement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (ThemeElement) invokeV.objValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            float[] fArr = new float[3];
            Color.colorToHSV(i2, fArr);
            if ((fArr[0] < 0.0f || fArr[0] >= 60.0f) && ((fArr[0] < 120.0f || fArr[0] >= 180.0f) && fArr[0] < 240.0f && fArr[0] >= 300.0f)) {
                fArr[0] = fArr[0] + 15.0f;
            } else {
                fArr[0] = fArr[0] - 15.0f;
            }
            return Color.HSVToColor(fArr);
        }
        return invokeI.intValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == Integer.MAX_VALUE : invokeI.booleanValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null) {
                if (str.length() != 0) {
                    try {
                        if (!str.startsWith("#")) {
                            str = "#" + str;
                        }
                    } catch (Exception unused) {
                        return Integer.MAX_VALUE;
                    }
                }
                return Color.parseColor(str);
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }
}
