package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class Projection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f41359a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41359a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, point)) == null) {
            if (point == null || (eVar = this.f41359a) == null) {
                return null;
            }
            return CoordUtil.mc2ll(eVar.b(point.x, point.y));
        }
        return (LatLng) invokeL.objValue;
    }

    public float metersToEquatorPixels(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            if (f2 <= 0.0f) {
                return 0.0f;
            }
            return (float) (f2 / this.f41359a.K());
        }
        return invokeF.floatValue;
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, latLng, mapStatus)) == null) {
            if (latLng == null || mapStatus == null) {
                return null;
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            ab abVar = mapStatus.f41256a;
            return new PointF((float) (ll2mc.getLongitudeE6() - abVar.f41959d), (float) (ll2mc.getLatitudeE6() - abVar.f41960e));
        }
        return (PointF) invokeLL.objValue;
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, latLng, mapStatus)) == null) {
            if (latLng == null || mapStatus == null) {
                return null;
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            ab.a aVar = mapStatus.f41256a.k;
            return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.f41966a) * 2.0d) / Math.abs(aVar.f41967b - aVar.f41966a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.f41969d) * 2.0d) / Math.abs(aVar.f41968c - aVar.f41969d)) - 1.0d));
        }
        return (PointF) invokeLL.objValue;
    }

    public Point toScreenLocation(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, latLng)) == null) {
            if (latLng == null || this.f41359a == null) {
                return null;
            }
            return this.f41359a.a(CoordUtil.ll2mc(latLng));
        }
        return (Point) invokeL.objValue;
    }
}
