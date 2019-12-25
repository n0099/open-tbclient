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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.crO != null) {
            str = b.crO.id;
        }
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).p("id", str).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).p("id", dVar.id).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aE = cVar.aE(view);
        String str = "";
        if (aE != null && aE.crM != null) {
            str = aE.crM.id;
        }
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).p("controlId", str).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aph = C0344a.apg().p("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).p("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aph();
        JSONObject aph2 = C0344a.apg().p("mapId", cVar.id).p("northeast", aph).p("southwest", C0344a.apg().p("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).p("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aph()).p("scale", Float.valueOf(mapStatus.zoom)).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aph2.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).p("position", C0344a.apg().p("latitude", Double.valueOf(latLng.latitude)).p("longitude", Double.valueOf(latLng.longitude)).aph()).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0344a.apg().p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).aph();
        JSONObject aph = C0344a.apg().p("mapId", cVar.id).p("name", mapPoi.getName()).p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).aph();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aph.toString());
            jSONObject.put("wvID", cVar.csd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.csd, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0344a {
        private JSONObject params = new JSONObject();

        static C0344a apg() {
            return new C0344a();
        }

        C0344a p(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aph() {
            return this.params;
        }

        C0344a() {
        }
    }
}
