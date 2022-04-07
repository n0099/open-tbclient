package com.baidu.ar.arplay.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(Object obj, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, obj, f)) == null) {
            if (obj != null) {
                if ((obj instanceof Float) || (obj instanceof Integer)) {
                    return ((Float) obj).floatValue();
                }
                if (obj instanceof String) {
                    try {
                        return Float.parseFloat((String) obj);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return f;
                    }
                }
                return f;
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    public static int a(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, obj, i)) == null) {
            if (obj != null) {
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                if (obj instanceof Float) {
                    return ((Float) obj).intValue();
                }
                if (obj instanceof String) {
                    try {
                        return Integer.parseInt((String) obj);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return i;
                    }
                }
                return i;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static long a(Object obj, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, obj, j)) == null) {
            if (obj != null) {
                if ((obj instanceof Long) || (obj instanceof Float)) {
                    return ((Long) obj).longValue();
                }
                if (obj instanceof String) {
                    try {
                        return Long.parseLong((String) obj);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return j;
                    }
                }
                return j;
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public static String a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) ? obj != null ? String.valueOf(obj) : str : (String) invokeLL.objValue;
    }
}
