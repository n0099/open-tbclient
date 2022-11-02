package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-961215153, "Lcom/baidu/mapapi/map/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-961215153, "Lcom/baidu/mapapi/map/b;");
                return;
            }
        }
        int[] iArr = new int[com.baidu.mapsdkplatform.comapi.map.w.values().length];
        b = iArr;
        try {
            iArr[com.baidu.mapsdkplatform.comapi.map.w.b.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[com.baidu.mapsdkplatform.comapi.map.w.a.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
