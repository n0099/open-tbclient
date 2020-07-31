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
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.dqW != null) {
            str = b.dqW.id;
        }
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).x("id", str).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).x("id", dVar.id).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aN = cVar.aN(view);
        String str = "";
        if (aN != null && aN.dqU != null) {
            str = aN.dqU.id;
        }
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).x("controlId", str).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aIT = C0466a.aIS().x("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).x("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aIT();
        JSONObject aIT2 = C0466a.aIS().x("mapId", cVar.id).x("northeast", aIT).x("southwest", C0466a.aIS().x("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).x("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aIT()).x("scale", Float.valueOf(mapStatus.zoom)).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aIT2.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).x("position", C0466a.aIS().x("latitude", Double.valueOf(latLng.latitude)).x("longitude", Double.valueOf(latLng.longitude)).aIT()).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0466a.aIS().x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aIT();
        JSONObject aIT = C0466a.aIS().x("mapId", cVar.id).x("name", mapPoi.getName()).x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aIT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aIT.toString());
            jSONObject.put("wvID", cVar.drl);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.drl, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0466a {
        private JSONObject params = new JSONObject();

        static C0466a aIS() {
            return new C0466a();
        }

        C0466a x(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aIT() {
            return this.params;
        }

        C0466a() {
        }
    }
}
