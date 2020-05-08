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
        if (b != null && b.cVp != null) {
            str = b.cVp.id;
        }
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).u("id", str).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).u("id", dVar.id).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aJ = cVar.aJ(view);
        String str = "";
        if (aJ != null && aJ.cVn != null) {
            str = aJ.cVn.id;
        }
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).u("controlId", str).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aAe = C0407a.aAd().u("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).u("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aAe();
        JSONObject aAe2 = C0407a.aAd().u("mapId", cVar.id).u("northeast", aAe).u("southwest", C0407a.aAd().u("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).u("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aAe()).u("scale", Float.valueOf(mapStatus.zoom)).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aAe2.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).u("position", C0407a.aAd().u("latitude", Double.valueOf(latLng.latitude)).u("longitude", Double.valueOf(latLng.longitude)).aAe()).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0407a.aAd().u("latitude", Double.valueOf(position.latitude)).u("longitude", Double.valueOf(position.longitude)).aAe();
        JSONObject aAe = C0407a.aAd().u("mapId", cVar.id).u("name", mapPoi.getName()).u("latitude", Double.valueOf(position.latitude)).u("longitude", Double.valueOf(position.longitude)).aAe();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aAe.toString());
            jSONObject.put("wvID", cVar.cVE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cVE, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0407a {
        private JSONObject params = new JSONObject();

        static C0407a aAd() {
            return new C0407a();
        }

        C0407a u(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aAe() {
            return this.params;
        }

        C0407a() {
        }
    }
}
