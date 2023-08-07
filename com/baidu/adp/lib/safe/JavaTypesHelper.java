package com.baidu.adp.lib.safe;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class JavaTypesHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JavaTypesHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean toBoolean(@Nullable Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, obj, z)) == null) {
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                if (obj instanceof String) {
                    return Boolean.parseBoolean((String) obj);
                }
                return z;
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static double toDouble(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Double.valueOf(d)})) == null) {
            if (str == null) {
                return d;
            }
            try {
                return Double.parseDouble(str);
            } catch (Exception unused) {
                return d;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static float toFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, str, f)) == null) {
            if (str == null) {
                return f;
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return f;
            }
        }
        return invokeLF.floatValue;
    }

    public static int toInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            if (str == null) {
                return i;
            }
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static long toLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, str, j)) == null) {
            if (str == null) {
                return j;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public static boolean toBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
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

    public static int toInt(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, str, i, i2)) == null) {
            if (str == null) {
                return i;
            }
            try {
                return Integer.parseInt(str, i2);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLII.intValue;
    }
}
