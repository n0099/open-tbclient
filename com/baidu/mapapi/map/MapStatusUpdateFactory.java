package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class MapStatusUpdateFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MapStatusUpdateFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MapStatusUpdate newLatLng(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, latLng)) == null) {
            if (latLng == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(2);
            mapStatusUpdate.b = latLng;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, latLngBounds)) == null) {
            if (latLngBounds == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(3);
            mapStatusUpdate.c = latLngBounds;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, latLngBounds, i, i2)) == null) {
            if (latLngBounds == null || i <= 0 || i2 <= 0) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
            mapStatusUpdate.c = latLngBounds;
            mapStatusUpdate.d = i;
            mapStatusUpdate.e = i2;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeLII.objValue;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{latLngBounds, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (latLngBounds == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
            mapStatusUpdate.c = latLngBounds;
            mapStatusUpdate.k = i;
            mapStatusUpdate.l = i2;
            mapStatusUpdate.m = i3;
            mapStatusUpdate.n = i4;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeCommon.objValue;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65541, null, latLng, f)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
            if (latLng == null) {
                return null;
            }
            mapStatusUpdate.b = latLng;
            mapStatusUpdate.f = f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeLF.objValue;
    }

    public static MapStatusUpdate newLatLngZoom(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{latLngBounds, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (latLngBounds == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(11);
            mapStatusUpdate.c = latLngBounds;
            mapStatusUpdate.k = i;
            mapStatusUpdate.l = i2;
            mapStatusUpdate.m = i3;
            mapStatusUpdate.n = i4;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeCommon.objValue;
    }

    public static MapStatusUpdate newMapStatus(MapStatus mapStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mapStatus)) == null) {
            if (mapStatus == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(1);
            mapStatusUpdate.a = mapStatus;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    public static MapStatusUpdate scrollBy(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
            mapStatusUpdate.g = i;
            mapStatusUpdate.h = i2;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeII.objValue;
    }

    public static MapStatusUpdate zoomBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
            mapStatusUpdate.i = f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeF.objValue;
    }

    public static MapStatusUpdate zoomBy(float f, Point point) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f), point})) == null) {
            if (point == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
            mapStatusUpdate.i = f;
            mapStatusUpdate.j = point;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeCommon.objValue;
    }

    public static MapStatusUpdate zoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
            mapStatusUpdate.i = 1.0f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeV.objValue;
    }

    public static MapStatusUpdate zoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
            mapStatusUpdate.i = -1.0f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeV.objValue;
    }

    public static MapStatusUpdate zoomTo(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65549, null, f)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
            mapStatusUpdate.f = f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeF.objValue;
    }
}
