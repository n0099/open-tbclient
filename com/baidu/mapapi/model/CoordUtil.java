package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.List;
/* loaded from: classes2.dex */
public class CoordUtil {
    public static LatLng Coordinate_encryptEx(float f2, float f3, String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.a(f2, f3, str);
    }

    public static LatLng decodeLocation(String str) {
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        LatLng a2 = com.baidu.mapsdkplatform.comapi.util.b.a(str);
        return coordType == coordType2 ? CoordTrans.baiduToGcj(a2) : a2;
    }

    public static List<LatLng> decodeLocationList(String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.c(str);
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.d(str);
    }

    public static LatLng decodeNodeLocation(String str) {
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        LatLng b2 = com.baidu.mapsdkplatform.comapi.util.b.b(str);
        return coordType == coordType2 ? CoordTrans.baiduToGcj(b2) : b2;
    }

    public static double getDistance(Point point, Point point2) {
        return com.baidu.mapsdkplatform.comjni.tools.a.a(point, point2);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i2) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng), i2) : com.baidu.mapsdkplatform.comapi.util.b.a(latLng, i2);
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng)) : com.baidu.mapsdkplatform.comapi.util.b.a(latLng);
    }

    public static Point ll2point(LatLng latLng) {
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.b(CoordTrans.gcjToBaidu(latLng)) : com.baidu.mapsdkplatform.comapi.util.b.b(latLng);
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        LatLng a2 = com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint);
        return coordType == coordType2 ? CoordTrans.baiduToGcj(a2) : a2;
    }
}
