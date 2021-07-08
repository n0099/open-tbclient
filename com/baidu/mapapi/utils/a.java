package com.baidu.mapapi.utils;

import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7499a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(286916859, "Lcom/baidu/mapapi/utils/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(286916859, "Lcom/baidu/mapapi/utils/a;");
                return;
            }
        }
        int[] iArr = new int[CoordinateConverter.CoordType.values().length];
        f7499a = iArr;
        try {
            iArr[CoordinateConverter.CoordType.COMMON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7499a[CoordinateConverter.CoordType.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7499a[CoordinateConverter.CoordType.BD09LL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7499a[CoordinateConverter.CoordType.BD09MC.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
