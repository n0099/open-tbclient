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
        if (b != null && b.bog != null) {
            str = b.bog.id;
        }
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).m("markerId", str).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "markertap", jSONObject);
    }

    public static void c(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.d dVar) {
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).m("markerId", dVar.id).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, com.baidu.swan.impl.map.item.b bVar) {
        com.baidu.swan.impl.map.item.a aA = bVar.aA(view);
        String str = "";
        if (aA != null && aA.boc != null) {
            str = aA.boc.id;
        }
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).m("controlId", str).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "controltap", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapStatus mapStatus) {
        JSONObject UI = C0222a.UH().m("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).m("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).UI();
        JSONObject UI2 = C0222a.UH().m("mapId", bVar.id).m("northeast", UI).m("southwest", C0222a.UH().m("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).m("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).UI()).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", UI2.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, LatLng latLng) {
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).m("position", C0222a.UH().m("latitude", Double.valueOf(latLng.latitude)).m("longitude", Double.valueOf(latLng.longitude)).UI()).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "tap", jSONObject);
    }

    public static void b(com.baidu.swan.impl.map.item.b bVar) {
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "updated", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0222a.UH().m("latitude", Double.valueOf(position.latitude)).m("longitude", Double.valueOf(position.longitude)).UI();
        JSONObject UI = C0222a.UH().m("mapId", bVar.id).m("name", mapPoi.getName()).m("latitude", Double.valueOf(position.latitude)).m("longitude", Double.valueOf(position.longitude)).UI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", UI.toString());
            jSONObject.put("wvID", bVar.boe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.boe, bVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0222a {
        private JSONObject params = new JSONObject();

        static C0222a UH() {
            return new C0222a();
        }

        C0222a m(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject UI() {
            return this.params;
        }

        C0222a() {
        }
    }
}
