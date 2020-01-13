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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.crZ != null) {
            str = b.crZ.id;
        }
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).p("id", str).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).p("id", dVar.id).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aI = cVar.aI(view);
        String str = "";
        if (aI != null && aI.crX != null) {
            str = aI.crX.id;
        }
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).p("controlId", str).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject apB = C0346a.apA().p("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).p("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).apB();
        JSONObject apB2 = C0346a.apA().p("mapId", cVar.id).p("northeast", apB).p("southwest", C0346a.apA().p("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).p("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).apB()).p("scale", Float.valueOf(mapStatus.zoom)).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", apB2.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).p("position", C0346a.apA().p("latitude", Double.valueOf(latLng.latitude)).p("longitude", Double.valueOf(latLng.longitude)).apB()).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0346a.apA().p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).apB();
        JSONObject apB = C0346a.apA().p("mapId", cVar.id).p("name", mapPoi.getName()).p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).apB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", apB.toString());
            jSONObject.put("wvID", cVar.cso);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cso, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0346a {
        private JSONObject params = new JSONObject();

        static C0346a apA() {
            return new C0346a();
        }

        C0346a p(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject apB() {
            return this.params;
        }

        C0346a() {
        }
    }
}
