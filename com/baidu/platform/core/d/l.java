package com.baidu.platform.core.d;

import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public /* synthetic */ class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f44337a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056793028, "Lcom/baidu/platform/core/d/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056793028, "Lcom/baidu/platform/core/d/l;");
                return;
            }
        }
        int[] iArr = new int[SearchType.values().length];
        f44337a = iArr;
        try {
            iArr[SearchType.f44290j.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f44337a[SearchType.k.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f44337a[SearchType.m.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
