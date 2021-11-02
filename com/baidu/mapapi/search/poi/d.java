package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public /* synthetic */ class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f39746a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-432229504, "Lcom/baidu/mapapi/search/poi/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-432229504, "Lcom/baidu/mapapi/search/poi/d;");
                return;
            }
        }
        int[] iArr = new int[PoiFilter.IndustryType.values().length];
        f39746a = iArr;
        try {
            iArr[PoiFilter.IndustryType.HOTEL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f39746a[PoiFilter.IndustryType.CATER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f39746a[PoiFilter.IndustryType.LIFE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
