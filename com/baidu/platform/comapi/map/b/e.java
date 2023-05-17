package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.b.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public /* synthetic */ class e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2068443614, "Lcom/baidu/platform/comapi/map/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2068443614, "Lcom/baidu/platform/comapi/map/b/e;");
                return;
            }
        }
        int[] iArr = new int[d.a.values().length];
        a = iArr;
        try {
            iArr[d.a.d.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[d.a.c.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[d.a.a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[d.a.b.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[d.a.e.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[d.a.f.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[d.a.g.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[d.a.h.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
