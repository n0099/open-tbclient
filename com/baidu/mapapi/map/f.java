package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public /* synthetic */ class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f40404a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f40405b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-961215029, "Lcom/baidu/mapapi/map/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-961215029, "Lcom/baidu/mapapi/map/f;");
                return;
            }
        }
        int[] iArr = new int[com.baidu.mapsdkplatform.comapi.map.aa.values().length];
        f40405b = iArr;
        try {
            iArr[com.baidu.mapsdkplatform.comapi.map.aa.f40896b.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f40405b[com.baidu.mapsdkplatform.comapi.map.aa.f40895a.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        f40404a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f40404a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f40404a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
