package com.baidu.platform.comapi.wnplatform.o;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
/* loaded from: classes6.dex */
public class b {
    public static GeoPoint a(double d, double d2) {
        LatLng a2 = a(new LatLng(d2, d), CoordinateType.WGS84);
        return new GeoPoint((int) (a2.latitude * 100000.0d), (int) (a2.longitude * 100000.0d));
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }
}
