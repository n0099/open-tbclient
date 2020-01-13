package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.inner.GeoPoint;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class af {
    private com.baidu.mapsdkplatform.comjni.map.basemap.a a;

    public af(com.baidu.mapsdkplatform.comjni.map.basemap.a aVar) {
        this.a = aVar;
    }

    public Point a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        Point point = new Point(0, 0);
        String b = this.a.b((int) geoPoint.getLongitudeE6(), (int) geoPoint.getLatitudeE6());
        if (b != null) {
            try {
                JSONObject jSONObject = new JSONObject(b);
                point.x = jSONObject.getInt("scrx");
                point.y = jSONObject.getInt("scry");
                return point;
            } catch (JSONException e) {
                e.printStackTrace();
                return point;
            }
        }
        return point;
    }

    public GeoPoint a(int i, int i2) {
        String a = this.a.a(i, i2);
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        if (a != null) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                geoPoint.setLongitudeE6(jSONObject.getInt("geox"));
                geoPoint.setLatitudeE6(jSONObject.getInt("geoy"));
                return geoPoint;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
