package com.baidu.platform.core.e;

import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class g {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056763392, "Lcom/baidu/platform/core/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056763392, "Lcom/baidu/platform/core/e/g;");
                return;
            }
        }
        int[] iArr = new int[SearchType.values().length];
        a = iArr;
        try {
            iArr[SearchType.q.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[SearchType.r.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
