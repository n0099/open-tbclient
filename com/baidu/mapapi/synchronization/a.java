package com.baidu.mapapi.synchronization;

import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-200536788, "Lcom/baidu/mapapi/synchronization/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-200536788, "Lcom/baidu/mapapi/synchronization/a;");
                return;
            }
        }
        int[] iArr = new int[SyncCoordinateConverter.CoordType.values().length];
        a = iArr;
        try {
            iArr[SyncCoordinateConverter.CoordType.COMMON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[SyncCoordinateConverter.CoordType.BD09LL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
