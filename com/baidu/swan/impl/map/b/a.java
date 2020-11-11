package com.baidu.swan.impl.map.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.w.a.a.d;
import com.baidu.swan.impl.map.item.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.eds != null) {
            str = b.eds.id;
        }
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).w("id", str).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).w("id", dVar.id).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aX = cVar.aX(view);
        String str = "";
        if (aX != null && aX.edq != null) {
            str = aX.edq.id;
        }
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).w("controlId", str).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aZy = C0552a.aZx().w("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).w("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aZy();
        JSONObject aZy2 = C0552a.aZx().w("mapId", cVar.id).w("northeast", aZy).w("southwest", C0552a.aZx().w("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).w("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aZy()).w("scale", Float.valueOf(mapStatus.zoom)).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aZy2.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).w("position", C0552a.aZx().w("latitude", Double.valueOf(latLng.latitude)).w("longitude", Double.valueOf(latLng.longitude)).aZy()).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0552a.aZx().w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aZy();
        JSONObject aZy = C0552a.aZx().w("mapId", cVar.id).w("name", mapPoi.getName()).w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aZy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aZy.toString());
            jSONObject.put("wvID", cVar.edH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.edH, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0552a {
        private JSONObject params = new JSONObject();

        static C0552a aZx() {
            return new C0552a();
        }

        C0552a w(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aZy() {
            return this.params;
        }

        C0552a() {
        }
    }
}
