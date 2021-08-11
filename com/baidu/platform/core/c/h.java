package com.baidu.platform.core.c;

import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public /* synthetic */ class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f44111a;
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
        f44111a = iArr;
        try {
            iArr[SearchType.f44059a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f44111a[SearchType.f44060b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f44111a[SearchType.f44061c.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
