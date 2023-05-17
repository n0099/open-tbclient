package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.map.MapLayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public /* synthetic */ class e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782127, "Lcom/baidu/mapsdkplatform/comapi/map/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782127, "Lcom/baidu/mapsdkplatform/comapi/map/e;");
                return;
            }
        }
        int[] iArr = new int[MapLayer.values().length];
        a = iArr;
        try {
            iArr[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[MapLayer.MAP_LAYER_INDOOR_POI.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[MapLayer.MAP_LAYER_POI_MARKER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
