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
        if (b != null && b.bGz != null) {
            str = b.bGz.id;
        }
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).j("markerId", str).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "markertap", jSONObject);
    }

    public static void c(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.a.d dVar) {
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).j("markerId", dVar.id).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, com.baidu.swan.impl.map.item.b bVar) {
        com.baidu.swan.impl.map.item.a aG = bVar.aG(view);
        String str = "";
        if (aG != null && aG.bGv != null) {
            str = aG.bGv.id;
        }
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).j("controlId", str).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "controltap", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapStatus mapStatus) {
        JSONObject Zz = C0263a.Zy().j("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).j("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).Zz();
        JSONObject Zz2 = C0263a.Zy().j("mapId", bVar.id).j("northeast", Zz).j("southwest", C0263a.Zy().j("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).j("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).Zz()).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", Zz2.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, LatLng latLng) {
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).j("position", C0263a.Zy().j("latitude", Double.valueOf(latLng.latitude)).j("longitude", Double.valueOf(latLng.longitude)).Zz()).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "tap", jSONObject);
    }

    public static void b(com.baidu.swan.impl.map.item.b bVar) {
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "updated", jSONObject);
    }

    public static void a(com.baidu.swan.impl.map.item.b bVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0263a.Zy().j("latitude", Double.valueOf(position.latitude)).j("longitude", Double.valueOf(position.longitude)).Zz();
        JSONObject Zz = C0263a.Zy().j("mapId", bVar.id).j("name", mapPoi.getName()).j("latitude", Double.valueOf(position.latitude)).j("longitude", Double.valueOf(position.longitude)).Zz();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", Zz.toString());
            jSONObject.put("wvID", bVar.bGx);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        d.a(bVar.bGx, bVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0263a {
        private JSONObject params = new JSONObject();

        static C0263a Zy() {
            return new C0263a();
        }

        C0263a j(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject Zz() {
            return this.params;
        }

        C0263a() {
        }
    }
}
