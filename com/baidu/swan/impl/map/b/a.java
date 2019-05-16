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
        if (b != null && b.bnt != null) {
            str = b.bnt.id;
        }
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).m("markerId", str).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "markertap", jSONObject);
    }

    public static void c(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.d dVar) {
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).m("markerId", dVar.id).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, com.baidu.swan.impl.map.item.b bVar) {
        com.baidu.swan.impl.map.item.a ay = bVar.ay(view);
        String str = "";
        if (ay != null && ay.bnp != null) {
            str = ay.bnp.id;
        }
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).m("controlId", str).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "controltap", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapStatus mapStatus) {
        JSONObject TQ = C0220a.TP().m("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).m("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).TQ();
        JSONObject TQ2 = C0220a.TP().m("mapId", bVar.id).m("northeast", TQ).m("southwest", C0220a.TP().m("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).m("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).TQ()).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", TQ2.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, LatLng latLng) {
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).m("position", C0220a.TP().m("latitude", Double.valueOf(latLng.latitude)).m("longitude", Double.valueOf(latLng.longitude)).TQ()).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "tap", jSONObject);
    }

    public static void b(com.baidu.swan.impl.map.item.b bVar) {
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "updated", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0220a.TP().m("latitude", Double.valueOf(position.latitude)).m("longitude", Double.valueOf(position.longitude)).TQ();
        JSONObject TQ = C0220a.TP().m("mapId", bVar.id).m("name", mapPoi.getName()).m("latitude", Double.valueOf(position.latitude)).m("longitude", Double.valueOf(position.longitude)).TQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", TQ.toString());
            jSONObject.put("wvID", bVar.bnr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bnr, bVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0220a {
        private JSONObject params = new JSONObject();

        static C0220a TP() {
            return new C0220a();
        }

        C0220a m(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject TQ() {
            return this.params;
        }

        C0220a() {
        }
    }
}
