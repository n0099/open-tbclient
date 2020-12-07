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
        if (b != null && b.eiL != null) {
            str = b.eiL.id;
        }
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).v("id", str).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).v("id", dVar.id).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aZ = cVar.aZ(view);
        String str = "";
        if (aZ != null && aZ.eiJ != null) {
            str = aZ.eiJ.id;
        }
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).v("controlId", str).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject bbW = C0562a.bbV().v("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).v("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).bbW();
        JSONObject bbW2 = C0562a.bbV().v("mapId", cVar.id).v("northeast", bbW).v("southwest", C0562a.bbV().v("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).v("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).bbW()).v("scale", Float.valueOf(mapStatus.zoom)).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", bbW2.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).v("position", C0562a.bbV().v("latitude", Double.valueOf(latLng.latitude)).v("longitude", Double.valueOf(latLng.longitude)).bbW()).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0562a.bbV().v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bbW();
        JSONObject bbW = C0562a.bbV().v("mapId", cVar.id).v("name", mapPoi.getName()).v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bbW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", bbW.toString());
            jSONObject.put("wvID", cVar.eja);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eja, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0562a {
        private JSONObject params = new JSONObject();

        static C0562a bbV() {
            return new C0562a();
        }

        C0562a v(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject bbW() {
            return this.params;
        }

        C0562a() {
        }
    }
}
