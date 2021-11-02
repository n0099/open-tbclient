package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public /* synthetic */ class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f40028a;
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
        f40028a = iArr;
        try {
            iArr[NativeLoader.a.f39948c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f40028a[NativeLoader.a.f39947b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f40028a[NativeLoader.a.f39946a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f40028a[NativeLoader.a.f39950e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f40028a[NativeLoader.a.f39949d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
