package com.baidu.platform.core.c;

import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public /* synthetic */ class h {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056822943, "Lcom/baidu/platform/core/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056822943, "Lcom/baidu/platform/core/c/h;");
                return;
            }
        }
        int[] iArr = new int[SearchType.values().length];
        a = iArr;
        try {
            iArr[SearchType.a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[SearchType.f38822b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[SearchType.f38823c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
