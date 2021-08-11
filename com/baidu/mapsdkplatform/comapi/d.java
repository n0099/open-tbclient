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
    public static final /* synthetic */ int[] f41916a;
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
        f41916a = iArr;
        try {
            iArr[NativeLoader.a.f41836c.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f41916a[NativeLoader.a.f41835b.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f41916a[NativeLoader.a.f41834a.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f41916a[NativeLoader.a.f41838e.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f41916a[NativeLoader.a.f41837d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
