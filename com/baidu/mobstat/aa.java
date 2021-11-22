package com.baidu.mobstat;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class aa {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41766a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f41767b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f41768c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581656850, "Lcom/baidu/mobstat/aa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581656850, "Lcom/baidu/mobstat/aa;");
                return;
            }
        }
        f41767b = Build.VERSION.SDK_INT < 9 ? "http://datax.baidu.com/xs.gif" : "https://datax.baidu.com/xs.gif";
        f41768c = Build.VERSION.SDK_INT < 9 ? "http://dxp.baidu.com/upgrade" : "https://dxp.baidu.com/upgrade";
    }
}
