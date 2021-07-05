package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.res.Configuration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, Context context) {
        InterceptResult invokeLL;
        Field[] fields;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                Configuration configuration = context.getResources().getConfiguration();
                for (Field field : configuration.getClass().getFields()) {
                    try {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            sb.append(field.getName());
                            sb.append(": ");
                            sb.append(field.get(configuration));
                            sb.append('\n');
                        }
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        str2 = "Failed to inspect device configuration: " + configuration;
                        com.baidu.crabsdk.lite.b.a.e(str, str2, e);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        str2 = "Failed to inspect device configuration: " + configuration;
                        com.baidu.crabsdk.lite.b.a.e(str, str2, e);
                    }
                }
            } catch (RuntimeException e4) {
                com.baidu.crabsdk.lite.b.a.e(str, "getConfigInfo", e4);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
