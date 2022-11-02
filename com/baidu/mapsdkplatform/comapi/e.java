package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-52719204, "Lcom/baidu/mapsdkplatform/comapi/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-52719204, "Lcom/baidu/mapsdkplatform/comapi/e;");
                return;
            }
        }
        int[] iArr = new int[NativeLoader.a.values().length];
        a = iArr;
        try {
            iArr[NativeLoader.a.c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NativeLoader.a.b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NativeLoader.a.a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NativeLoader.a.e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NativeLoader.a.d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
