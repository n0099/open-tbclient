package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public /* synthetic */ class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f42397a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-879695110, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-879695110, "Lcom/baidu/mapsdkplatform/comapi/synchronization/b/c;");
                return;
            }
        }
        int[] iArr = new int[c.a.values().length];
        f42397a = iArr;
        try {
            iArr[c.a.f42430a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f42397a[c.a.f42432c.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f42397a[c.a.f42434e.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f42397a[c.a.f42431b.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f42397a[c.a.f42433d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
