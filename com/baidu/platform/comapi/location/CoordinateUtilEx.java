package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.basestruct.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class CoordinateUtilEx {
    public static Point Coordinate_encryptEx(float f, float f2, String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            str = "bd09ll";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1395470197:
                if (str.equals("bd09ll")) {
                    c = 2;
                    break;
                }
                break;
            case -1395470175:
                if (str.equals(CoordinateType.BD09MC)) {
                    c = 3;
                    break;
                }
                break;
            case 98175376:
                if (str.equals("gcj02")) {
                    c = 1;
                    break;
                }
                break;
            case 113079775:
                if (str.equals(CoordinateType.WGS84)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CoordinateUtil.wgs84Tobd09mc(f, f2);
            case 1:
                return CoordinateUtil.gcj02Tobd09mc(f, f2);
            case 2:
                return CoordinateUtil.bd09llTobd09mc(f, f2);
            case 3:
                return new Point(f, f2);
            default:
                return null;
        }
    }

    public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> arrayList, String str) {
        Point point;
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            str = "bd09ll";
        }
        if (str.equals("bd09ll") || str.equals(CoordinateType.BD09MC) || str.equals("gcj02") || str.equals(CoordinateType.WGS84)) {
            float[] fArr = new float[arrayList.size()];
            float[] fArr2 = new float[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                fArr[i] = arrayList.get(i).getIntX() / 100000.0f;
                fArr2[i] = arrayList.get(i).getIntY() / 100000.0f;
            }
            ArrayList<Point> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < fArr.length; i2++) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1395470197:
                        if (str.equals("bd09ll")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1395470175:
                        if (str.equals(CoordinateType.BD09MC)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 98175376:
                        if (str.equals("gcj02")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 113079775:
                        if (str.equals(CoordinateType.WGS84)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        point = CoordinateUtil.wgs84Tobd09mc(fArr[i2], fArr2[i2]);
                        break;
                    case 1:
                        point = CoordinateUtil.gcj02Tobd09mc(fArr[i2], fArr2[i2]);
                        break;
                    case 2:
                        point = CoordinateUtil.bd09llTobd09mc(fArr[i2], fArr2[i2]);
                        break;
                    case 3:
                        point = new Point(fArr[i2], fArr2[i2]);
                        break;
                    default:
                        point = null;
                        break;
                }
                if (point != null) {
                    arrayList2.add(point);
                }
            }
            return arrayList2;
        }
        return null;
    }

    public static double getDistanceByMc(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return CoordinateUtil.getDistanceByMc(geoPoint.getLongitude(), geoPoint.getLatitude(), geoPoint2.getLongitude(), geoPoint2.getLatitude());
    }

    public static double getDistanceByMc(Point point, Point point2) {
        return CoordinateUtil.getDistanceByMc(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY());
    }

    @Deprecated
    public static a getGeoComplexPointFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPt(str);
    }

    @Deprecated
    public static a getGeoComplexPtBoundFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPtBound(str);
    }

    public static Point getGeoPointFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToPoint(str);
    }

    public static String getStringFromGeoPoint(Point point) {
        return CoordinateUtil.pointToGeoString(point);
    }
}
