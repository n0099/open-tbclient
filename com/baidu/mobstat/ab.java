package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43137a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f43138b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f43139c = "M";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43140d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f43141e = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(581656881, "Lcom/baidu/mobstat/ab;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(581656881, "Lcom/baidu/mobstat/ab;");
        }
    }
}
