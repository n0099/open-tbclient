package c.a.e.e.m;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, obj, z)) == null) {
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return obj instanceof String ? Boolean.parseBoolean((String) obj) : z;
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) {
            if (str == null) {
                return z;
            }
            try {
                return Boolean.parseBoolean(str);
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static double c(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (str == null) {
                return d2;
            }
            try {
                return Double.parseDouble(str);
            } catch (Exception unused) {
                return d2;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static float d(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, str, f2)) == null) {
            if (str == null) {
                return f2;
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int e(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static int f(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, str, i2, i3)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str, i3);
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLII.intValue;
    }

    public static long g(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, str, j2)) == null) {
            if (str == null) {
                return j2;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j2;
            }
        }
        return invokeLJ.longValue;
    }
}
