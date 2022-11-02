package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class MapLayer {
    public static /* synthetic */ Interceptable $ic;
    public static final MapLayer MAP_LAYER_INDOOR_POI;
    public static final MapLayer MAP_LAYER_LOCATION;
    public static final MapLayer MAP_LAYER_OVERLAY;
    public static final MapLayer MAP_LAYER_POI_MARKER;
    public static final /* synthetic */ MapLayer[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781436560, "Lcom/baidu/mapapi/map/MapLayer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781436560, "Lcom/baidu/mapapi/map/MapLayer;");
                return;
            }
        }
        MAP_LAYER_OVERLAY = new MapLayer("MAP_LAYER_OVERLAY", 0);
        MAP_LAYER_LOCATION = new MapLayer("MAP_LAYER_LOCATION", 1);
        MAP_LAYER_POI_MARKER = new MapLayer("MAP_LAYER_POI_MARKER", 2);
        MapLayer mapLayer = new MapLayer("MAP_LAYER_INDOOR_POI", 3);
        MAP_LAYER_INDOOR_POI = mapLayer;
        a = new MapLayer[]{MAP_LAYER_OVERLAY, MAP_LAYER_LOCATION, MAP_LAYER_POI_MARKER, mapLayer};
    }

    public MapLayer(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MapLayer valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (MapLayer) Enum.valueOf(MapLayer.class, str);
        }
        return (MapLayer) invokeL.objValue;
    }

    public static MapLayer[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (MapLayer[]) a.clone();
        }
        return (MapLayer[]) invokeV.objValue;
    }
}
