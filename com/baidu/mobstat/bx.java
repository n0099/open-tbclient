package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.CommonParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public final class bx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                str = CommonParam.getCUID(context);
            } catch (Throwable unused) {
                str = "";
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            if (map != null) {
                return new HashMap<>(map);
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j)) == null) {
            Date date = new Date(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            return simpleDateFormat.format(date);
        }
        return (String) invokeJ.objValue;
    }

    public static boolean a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str)) == null) {
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

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return str.length() > i ? str.substring(0, i) : str;
        }
        return (String) invokeLI.objValue;
    }
}
