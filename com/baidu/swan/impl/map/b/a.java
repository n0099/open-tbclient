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
/* loaded from: classes24.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.ebK != null) {
            str = b.ebK.id;
        }
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).w("id", str).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).w("id", dVar.id).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aX = cVar.aX(view);
        String str = "";
        if (aX != null && aX.ebI != null) {
            str = aX.ebI.id;
        }
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).w("controlId", str).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aYR = C0550a.aYQ().w("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).w("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aYR();
        JSONObject aYR2 = C0550a.aYQ().w("mapId", cVar.id).w("northeast", aYR).w("southwest", C0550a.aYQ().w("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).w("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aYR()).w("scale", Float.valueOf(mapStatus.zoom)).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aYR2.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).w("position", C0550a.aYQ().w("latitude", Double.valueOf(latLng.latitude)).w("longitude", Double.valueOf(latLng.longitude)).aYR()).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0550a.aYQ().w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aYR();
        JSONObject aYR = C0550a.aYQ().w("mapId", cVar.id).w("name", mapPoi.getName()).w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aYR();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aYR.toString());
            jSONObject.put("wvID", cVar.ebZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(cVar.ebZ, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class C0550a {
        private JSONObject params = new JSONObject();

        static C0550a aYQ() {
            return new C0550a();
        }

        C0550a w(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aYR() {
            return this.params;
        }

        C0550a() {
        }
    }
}
