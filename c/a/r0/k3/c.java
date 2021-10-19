package c.a.r0.k3;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? (i2 & 16777215) | (((int) ((i2 >>> 24) * f2)) << 24) : invokeCommon.intValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
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

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
