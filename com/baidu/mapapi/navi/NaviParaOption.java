package com.baidu.mapapi.navi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NaviParaOption {
    public LatLng a;
    public String b;
    public LatLng c;
    public String d;
    public WayPoint e;
    public NaviRoutePolicy f = NaviRoutePolicy.DEFAULT;

    /* loaded from: classes3.dex */
    public enum NaviRoutePolicy {
        BLK,
        TIME,
        DIS,
        FEE,
        HIGHWAY,
        DEFAULT
    }

    public String getEndName() {
        return this.d;
    }

    public LatLng getEndPoint() {
        return this.c;
    }

    public String getNaviRoutePolicy() {
        int i = a.a[this.f.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return "DEFAULT";
                        }
                        return "HIGHWAY";
                    }
                    return "FEE";
                }
                return "DIS";
            }
            return "TIME";
        }
        return "BLK";
    }

    public String getStartName() {
        return this.b;
    }

    public LatLng getStartPoint() {
        return this.a;
    }

    public NaviParaOption endName(String str) {
        this.d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy naviRoutePolicy) {
        this.f = naviRoutePolicy;
        return this;
    }

    public NaviParaOption setWayPoint(WayPoint wayPoint) {
        if (wayPoint == null) {
            return null;
        }
        this.e = wayPoint;
        return this;
    }

    public NaviParaOption startName(String str) {
        this.b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public JSONArray getWayPoint() {
        WayPoint wayPoint = this.e;
        JSONArray jSONArray = null;
        if (wayPoint == null) {
            return null;
        }
        List<WayPointInfo> viaPoints = wayPoint.getViaPoints();
        if (viaPoints != null && viaPoints.size() != 0) {
            jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < viaPoints.size(); i++) {
                WayPointInfo wayPointInfo = viaPoints.get(i);
                if (wayPointInfo != null) {
                    try {
                        if (!TextUtils.isEmpty(wayPointInfo.getWayPointName())) {
                            jSONObject.put("name", wayPointInfo.getWayPointName());
                        }
                        LatLng latLng = wayPointInfo.getLatLng();
                        if (latLng != null) {
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.gcjToBaidu(latLng);
                            }
                            jSONObject.put(SuggestAddrField.KEY_LNG, latLng.longitude);
                            jSONObject.put(SuggestAddrField.KEY_LAT, latLng.latitude);
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }
}
