package com.baidu.platform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements Projection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MapController a;

    public l(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = mapController;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public float metersToEquatorPixels(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            return (float) (f / this.a.getZoomUnitsInMeter());
        }
        return invokeF.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public GeoPoint fromPixels(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            AppBaseMap baseMap = this.a.getBaseMap();
            if (baseMap == null) {
                return null;
            }
            String ScrPtToGeoPoint = baseMap.ScrPtToGeoPoint(i, i2);
            GeoPoint geoPoint = new GeoPoint(0, 0);
            if (ScrPtToGeoPoint != null) {
                try {
                    JSONObject jSONObject = new JSONObject(ScrPtToGeoPoint);
                    geoPoint.setLongitude(jSONObject.getDouble("geox"));
                    geoPoint.setLatitude(jSONObject.getDouble("geoy"));
                    return geoPoint;
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (GeoPoint) invokeII.objValue;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint geoPoint, int i, Point point) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, geoPoint, i, point)) == null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            AppBaseMap baseMap = this.a.getBaseMap();
            if (baseMap == null) {
                return point;
            }
            String geoPt3ToScrPoint = baseMap.geoPt3ToScrPoint((int) geoPoint.getLongitude(), (int) geoPoint.getLatitude(), i);
            if (geoPt3ToScrPoint != null) {
                try {
                    JSONObject jSONObject = new JSONObject(geoPt3ToScrPoint);
                    point.setIntX(jSONObject.getInt("scrx"));
                    point.setIntY(jSONObject.getInt("scry"));
                } catch (JSONException unused) {
                }
            }
            return point;
        }
        return (Point) invokeLIL.objValue;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point world2Screen(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Point point = new Point(0, 0);
            AppBaseMap baseMap = this.a.getBaseMap();
            if (baseMap == null) {
                return point;
            }
            String worldPointToScreenPoint = baseMap.worldPointToScreenPoint(f, f2, f3);
            if (worldPointToScreenPoint != null) {
                try {
                    JSONObject jSONObject = new JSONObject(worldPointToScreenPoint);
                    point.setDoubleX(jSONObject.optDouble("scrx"));
                    point.setDoubleY(jSONObject.optDouble("scry"));
                    return point;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Point) invokeCommon.objValue;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint geoPoint, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, geoPoint, point)) == null) {
            if (point == null) {
                point = new Point(0, 0);
            }
            AppBaseMap baseMap = this.a.getBaseMap();
            if (baseMap == null) {
                return point;
            }
            String GeoPtToScrPoint = baseMap.GeoPtToScrPoint((int) geoPoint.getLongitude(), (int) geoPoint.getLatitude());
            if (GeoPtToScrPoint != null) {
                try {
                    JSONObject jSONObject = new JSONObject(GeoPtToScrPoint);
                    point.setIntX(jSONObject.getInt("scrx"));
                    point.setIntY(jSONObject.getInt("scry"));
                } catch (JSONException unused) {
                }
            }
            return point;
        }
        return (Point) invokeLL.objValue;
    }
}
