package com.baidu.pass.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f42804a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-727620367, "Lcom/baidu/pass/http/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-727620367, "Lcom/baidu/pass/http/a;");
                return;
            }
        }
        int[] iArr = new int[Method.values().length];
        f42804a = iArr;
        try {
            iArr[Method.GET.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f42804a[Method.POST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
