package com.baidu.swan.impl.map.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.impl.map.item.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, com.baidu.swan.impl.map.item.b bVar) {
        c b = bVar.b(marker);
        String str = "";
        if (b != null && b.bhk != null) {
            str = b.bhk.id;
        }
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).k("markerId", str).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "markertap", jSONObject);
    }

    public static void c(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.d dVar) {
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).k("markerId", dVar.id).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, com.baidu.swan.impl.map.item.b bVar) {
        com.baidu.swan.impl.map.item.a as = bVar.as(view);
        String str = "";
        if (as != null && as.bhg != null) {
            str = as.bhg.id;
        }
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).k("controlId", str).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "controltap", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapStatus mapStatus) {
        JSONObject Qg = C0206a.Qf().k("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).k("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).Qg();
        JSONObject Qg2 = C0206a.Qf().k("mapId", bVar.id).k("northeast", Qg).k("southwest", C0206a.Qf().k("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).k("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).Qg()).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", Qg2.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, LatLng latLng) {
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).k("position", C0206a.Qf().k("latitude", Double.valueOf(latLng.latitude)).k("longitude", Double.valueOf(latLng.longitude)).Qg()).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "tap", jSONObject);
    }

    public static void b(com.baidu.swan.impl.map.item.b bVar) {
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "updated", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0206a.Qf().k("latitude", Double.valueOf(position.latitude)).k("longitude", Double.valueOf(position.longitude)).Qg();
        JSONObject Qg = C0206a.Qf().k("mapId", bVar.id).k("name", mapPoi.getName()).k("latitude", Double.valueOf(position.latitude)).k("longitude", Double.valueOf(position.longitude)).Qg();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", Qg.toString());
            jSONObject.put("wvID", bVar.bhi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bhi, bVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0206a {
        private JSONObject params = new JSONObject();

        static C0206a Qf() {
            return new C0206a();
        }

        C0206a k(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject Qg() {
            return this.params;
        }

        C0206a() {
        }
    }
}
