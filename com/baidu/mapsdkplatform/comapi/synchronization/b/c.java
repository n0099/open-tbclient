package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7840a;
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
        f7840a = iArr;
        try {
            iArr[c.a.f7873a.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7840a[c.a.f7875c.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7840a[c.a.f7877e.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7840a[c.a.f7874b.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7840a[c.a.f7876d.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
