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
        if (b != null && b.dXB != null) {
            str = b.dXB.id;
        }
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).w("id", str).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).w("id", dVar.id).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aT = cVar.aT(view);
        String str = "";
        if (aT != null && aT.dXz != null) {
            str = aT.dXz.id;
        }
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).w("controlId", str).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aWY = C0540a.aWX().w("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).w("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aWY();
        JSONObject aWY2 = C0540a.aWX().w("mapId", cVar.id).w("northeast", aWY).w("southwest", C0540a.aWX().w("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).w("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aWY()).w("scale", Float.valueOf(mapStatus.zoom)).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aWY2.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).w("position", C0540a.aWX().w("latitude", Double.valueOf(latLng.latitude)).w("longitude", Double.valueOf(latLng.longitude)).aWY()).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0540a.aWX().w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aWY();
        JSONObject aWY = C0540a.aWX().w("mapId", cVar.id).w("name", mapPoi.getName()).w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aWY();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aWY.toString());
            jSONObject.put("wvID", cVar.dXQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dXQ, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0540a {
        private JSONObject params = new JSONObject();

        static C0540a aWX() {
            return new C0540a();
        }

        C0540a w(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aWY() {
            return this.params;
        }

        C0540a() {
        }
    }
}
