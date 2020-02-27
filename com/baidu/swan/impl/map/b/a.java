package com.baidu.swan.impl.map.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.z.a.a.d;
import com.baidu.swan.impl.map.item.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.cwb != null) {
            str = b.cwb.id;
        }
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).p("id", str).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).p("id", dVar.id).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aI = cVar.aI(view);
        String str = "";
        if (aI != null && aI.cvZ != null) {
            str = aI.cvZ.id;
        }
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).p("controlId", str).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject arO = C0356a.arN().p("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).p("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).arO();
        JSONObject arO2 = C0356a.arN().p("mapId", cVar.id).p("northeast", arO).p("southwest", C0356a.arN().p("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).p("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).arO()).p("scale", Float.valueOf(mapStatus.zoom)).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", arO2.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).p("position", C0356a.arN().p("latitude", Double.valueOf(latLng.latitude)).p("longitude", Double.valueOf(latLng.longitude)).arO()).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0356a.arN().p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).arO();
        JSONObject arO = C0356a.arN().p("mapId", cVar.id).p("name", mapPoi.getName()).p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).arO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", arO.toString());
            jSONObject.put("wvID", cVar.cwq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwq, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0356a {
        private JSONObject params = new JSONObject();

        static C0356a arN() {
            return new C0356a();
        }

        C0356a p(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject arO() {
            return this.params;
        }

        C0356a() {
        }
    }
}
