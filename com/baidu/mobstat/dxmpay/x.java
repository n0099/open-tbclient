package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.mobstat.dxmpay.util.CuidUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                str = CommonParam.getCUID(context);
            } catch (Throwable unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? CuidUtil.getCuid3(context) : str;
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            if (map != null) {
                return new HashMap<>(map);
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public static boolean a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                String methodName = stackTraceElement.getMethodName();
                if (!TextUtils.isEmpty(methodName) && cls != null && methodName.equals(str)) {
                    Class<?> cls2 = null;
                    try {
                        cls2 = Class.forName(stackTraceElement.getClassName());
                    } catch (Throwable unused) {
                    }
                    if (cls2 != null && cls.isAssignableFrom(cls2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return str.length() > i2 ? str.substring(0, i2) : str;
        }
        return (String) invokeLI.objValue;
    }
}
