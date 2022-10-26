package com.baidu.mobstat;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class y {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static final String b;
    public static final String c;
    public static String d;
    public static String e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        String str;
        String str2;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709493, "Lcom/baidu/mobstat/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709493, "Lcom/baidu/mobstat/y;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 9) {
            str = "http://datax.baidu.com/xs.gif";
        } else {
            str = "https://datax.baidu.com/xs.gif";
        }
        b = str;
        if (Build.VERSION.SDK_INT < 9) {
            str2 = "http://dxp.baidu.com/upgrade";
        } else {
            str2 = "https://dxp.baidu.com/upgrade";
        }
        c = str2;
        d = ".mtj_timestamp";
        f = "__send_log_data_";
        e = ".confd";
    }
}
