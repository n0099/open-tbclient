package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
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
            iArr[NativeLoader.a.f34367c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NativeLoader.a.f34366b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NativeLoader.a.a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NativeLoader.a.f34369e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NativeLoader.a.f34368d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
