package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.x;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class Projection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comapi.map.d a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
    }

    public LatLng fromScreenLocation(Point point) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, point)) == null) {
            if (point != null && (dVar = this.a) != null) {
                return CoordUtil.mc2ll(dVar.b(point.x, point.y));
            }
            return null;
        }
        return (LatLng) invokeL.objValue;
    }

    public float metersToEquatorPixels(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            return (float) (f / this.a.K());
        }
        return invokeF.floatValue;
    }

    public Point toScreenLocation(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, latLng)) == null) {
            if (latLng != null && this.a != null) {
                return this.a.a(CoordUtil.ll2mc(latLng));
            }
            return null;
        }
        return (Point) invokeL.objValue;
    }

    public Point geoPoint3toScreenLocation(LatLng latLng, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng, i)) == null) {
            if (latLng != null && this.a != null && i >= 0) {
                return this.a.a(CoordUtil.ll2mc(latLng), i);
            }
            return null;
        }
        return (Point) invokeLI.objValue;
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, latLng, mapStatus)) == null) {
            if (latLng != null && mapStatus != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                com.baidu.mapsdkplatform.comapi.map.x xVar = mapStatus.a;
                return new PointF((float) (ll2mc.getLongitudeE6() - xVar.d), (float) (ll2mc.getLatitudeE6() - xVar.e));
            }
            return null;
        }
        return (PointF) invokeLL.objValue;
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, latLng, mapStatus)) == null) {
            if (latLng != null && mapStatus != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                x.a aVar = mapStatus.a.k;
                return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.a) * 2.0d) / Math.abs(aVar.b - aVar.a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
            }
            return null;
        }
        return (PointF) invokeLL.objValue;
    }
}
