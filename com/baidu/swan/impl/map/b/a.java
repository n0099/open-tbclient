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
        if (b != null && b.dAY != null) {
            str = b.dAY.id;
        }
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).w("id", str).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).w("id", dVar.id).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aP = cVar.aP(view);
        String str = "";
        if (aP != null && aP.dAW != null) {
            str = aP.dAW.id;
        }
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).w("controlId", str).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aRJ = C0514a.aRI().w("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).w("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aRJ();
        JSONObject aRJ2 = C0514a.aRI().w("mapId", cVar.id).w("northeast", aRJ).w("southwest", C0514a.aRI().w("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).w("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aRJ()).w("scale", Float.valueOf(mapStatus.zoom)).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aRJ2.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).w("position", C0514a.aRI().w("latitude", Double.valueOf(latLng.latitude)).w("longitude", Double.valueOf(latLng.longitude)).aRJ()).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0514a.aRI().w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aRJ();
        JSONObject aRJ = C0514a.aRI().w("mapId", cVar.id).w("name", mapPoi.getName()).w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aRJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aRJ.toString());
            jSONObject.put("wvID", cVar.dBn);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dBn, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0514a {
        private JSONObject params = new JSONObject();

        static C0514a aRI() {
            return new C0514a();
        }

        C0514a w(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aRJ() {
            return this.params;
        }

        C0514a() {
        }
    }
}
