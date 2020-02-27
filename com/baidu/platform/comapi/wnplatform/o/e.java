package com.baidu.platform.comapi.wnplatform.o;

import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes8.dex */
public class e {
    public static MapStatusUpdate a(MapStatus mapStatus) {
        return MapStatusUpdateFactory.newMapStatus(mapStatus);
    }

    public static LatLng a(GeoPoint geoPoint) {
        return CoordUtil.Coordinate_encryptEx(((float) geoPoint.getLongitudeE6()) / 100000.0f, ((float) geoPoint.getLatitudeE6()) / 100000.0f, "gcj02");
    }
}
