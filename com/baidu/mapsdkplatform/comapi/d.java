package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public /* synthetic */ class d {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-52719235, "Lcom/baidu/mapsdkplatform/comapi/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-52719235, "Lcom/baidu/mapsdkplatform/comapi/d;");
                return;
            }
        }
        int[] iArr = new int[NativeLoader.a.values().length];
        a = iArr;
        try {
            iArr[NativeLoader.a.f36791c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NativeLoader.a.f36790b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NativeLoader.a.a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NativeLoader.a.f36793e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NativeLoader.a.f36792d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
