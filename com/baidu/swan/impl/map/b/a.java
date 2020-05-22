package com.baidu.swan.impl.map.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.x.a.a.d;
import com.baidu.swan.impl.map.item.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.dgq != null) {
            str = b.dgq.id;
        }
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).x("id", str).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).x("id", dVar.id).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aI = cVar.aI(view);
        String str = "";
        if (aI != null && aI.dgo != null) {
            str = aI.dgo.id;
        }
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).x("controlId", str).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aDW = C0448a.aDV().x("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).x("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aDW();
        JSONObject aDW2 = C0448a.aDV().x("mapId", cVar.id).x("northeast", aDW).x("southwest", C0448a.aDV().x("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).x("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aDW()).x("scale", Float.valueOf(mapStatus.zoom)).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aDW2.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).x("position", C0448a.aDV().x("latitude", Double.valueOf(latLng.latitude)).x("longitude", Double.valueOf(latLng.longitude)).aDW()).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0448a.aDV().x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aDW();
        JSONObject aDW = C0448a.aDV().x("mapId", cVar.id).x("name", mapPoi.getName()).x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aDW();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aDW.toString());
            jSONObject.put("wvID", cVar.dgF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dgF, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0448a {
        private JSONObject params = new JSONObject();

        static C0448a aDV() {
            return new C0448a();
        }

        C0448a x(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aDW() {
            return this.params;
        }

        C0448a() {
        }
    }
}
