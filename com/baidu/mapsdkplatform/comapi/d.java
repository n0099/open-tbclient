package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public /* synthetic */ class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f42200a;
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
        f42200a = iArr;
        try {
            iArr[NativeLoader.a.f42120c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f42200a[NativeLoader.a.f42119b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f42200a[NativeLoader.a.f42118a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f42200a[NativeLoader.a.f42122e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f42200a[NativeLoader.a.f42121d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
