package com.baidu.mapapi.navi;

import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161826240, "Lcom/baidu/mapapi/navi/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161826240, "Lcom/baidu/mapapi/navi/a;");
                return;
            }
        }
        int[] iArr = new int[NaviParaOption.NaviRoutePolicy.values().length];
        a = iArr;
        try {
            iArr[NaviParaOption.NaviRoutePolicy.BLK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.TIME.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.DIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.FEE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.HIGHWAY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.DEFAULT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
