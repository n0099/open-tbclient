package com.baidu.mapapi.map;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            mapStatusUpdate.f6997b = latLng;
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
            mapStatusUpdate.f6998c = latLngBounds;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, latLngBounds, i2, i3)) == null) {
            if (latLngBounds == null || i2 <= 0 || i3 <= 0) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
            mapStatusUpdate.f6998c = latLngBounds;
            mapStatusUpdate.f6999d = i2;
            mapStatusUpdate.f7000e = i3;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeLII.objValue;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{latLngBounds, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (latLngBounds == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
            mapStatusUpdate.f6998c = latLngBounds;
            mapStatusUpdate.k = i2;
            mapStatusUpdate.l = i3;
            mapStatusUpdate.m = i4;
            mapStatusUpdate.n = i5;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeCommon.objValue;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.AD_TEXT_ID, null, latLng, f2)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
            if (latLng == null) {
                return null;
            }
            mapStatusUpdate.f6997b = latLng;
            mapStatusUpdate.f7001f = f2;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeLF.objValue;
    }

    public static MapStatusUpdate newLatLngZoom(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{latLngBounds, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (latLngBounds == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(11);
            mapStatusUpdate.f6998c = latLngBounds;
            mapStatusUpdate.k = i2;
            mapStatusUpdate.l = i3;
            mapStatusUpdate.m = i4;
            mapStatusUpdate.n = i5;
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
            mapStatusUpdate.f6996a = mapStatus;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeL.objValue;
    }

    public static MapStatusUpdate scrollBy(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
            mapStatusUpdate.f7002g = i2;
            mapStatusUpdate.f7003h = i3;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeII.objValue;
    }

    public static MapStatusUpdate zoomBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f2)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
            mapStatusUpdate.f7004i = f2;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeF.objValue;
    }

    public static MapStatusUpdate zoomBy(float f2, Point point) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), point})) == null) {
            if (point == null) {
                return null;
            }
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
            mapStatusUpdate.f7004i = f2;
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
            mapStatusUpdate.f7004i = 1.0f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeV.objValue;
    }

    public static MapStatusUpdate zoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
            mapStatusUpdate.f7004i = -1.0f;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeV.objValue;
    }

    public static MapStatusUpdate zoomTo(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65549, null, f2)) == null) {
            MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
            mapStatusUpdate.f7001f = f2;
            return mapStatusUpdate;
        }
        return (MapStatusUpdate) invokeF.objValue;
    }
}
