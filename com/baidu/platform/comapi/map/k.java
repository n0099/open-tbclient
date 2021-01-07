package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements Projection {

    /* renamed from: a  reason: collision with root package name */
    private MapController f4351a;

    public k(MapController mapController) {
        this.f4351a = null;
        this.f4351a = mapController;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public GeoPoint fromPixels(int i, int i2) {
        AppBaseMap baseMap = this.f4351a.getBaseMap();
        if (baseMap == null) {
            return null;
        }
        String ScrPtToGeoPoint = baseMap.ScrPtToGeoPoint(i, i2);
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        if (ScrPtToGeoPoint != null) {
            try {
                JSONObject jSONObject = new JSONObject(ScrPtToGeoPoint);
                geoPoint.setLongitude(jSONObject.getDouble("geox"));
                geoPoint.setLatitude(jSONObject.getDouble("geoy"));
                return geoPoint;
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public float metersToEquatorPixels(float f) {
        return (float) (f / this.f4351a.getZoomUnitsInMeter());
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point toPixels(GeoPoint geoPoint, Point point) {
        String GeoPtToScrPoint;
        if (point == null) {
            point = new Point(0, 0);
        }
        AppBaseMap baseMap = this.f4351a.getBaseMap();
        if (baseMap != null && (GeoPtToScrPoint = baseMap.GeoPtToScrPoint((int) geoPoint.getLongitude(), (int) geoPoint.getLatitude())) != null) {
            try {
                JSONObject jSONObject = new JSONObject(GeoPtToScrPoint);
                point.setIntX(jSONObject.getInt("scrx"));
                point.setIntY(jSONObject.getInt("scry"));
            } catch (JSONException e) {
            }
        }
        return point;
    }

    @Override // com.baidu.platform.comapi.map.Projection
    public Point world2Screen(float f, float f2, float f3) {
        Point point = new Point(0, 0);
        AppBaseMap baseMap = this.f4351a.getBaseMap();
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
            } catch (JSONException e) {
            }
        }
        return null;
    }
}
