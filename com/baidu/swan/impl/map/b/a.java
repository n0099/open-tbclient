package com.baidu.swan.impl.map.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.z.a.a.d;
import com.baidu.swan.impl.map.item.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.cwo != null) {
            str = b.cwo.id;
        }
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).p("id", str).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).p("id", dVar.id).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aI = cVar.aI(view);
        String str = "";
        if (aI != null && aI.cwm != null) {
            str = aI.cwm.id;
        }
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).p("controlId", str).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject arT = C0356a.arS().p("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).p("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).arT();
        JSONObject arT2 = C0356a.arS().p("mapId", cVar.id).p("northeast", arT).p("southwest", C0356a.arS().p("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).p("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).arT()).p("scale", Float.valueOf(mapStatus.zoom)).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", arT2.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).p("position", C0356a.arS().p("latitude", Double.valueOf(latLng.latitude)).p("longitude", Double.valueOf(latLng.longitude)).arT()).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0356a.arS().p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).arT();
        JSONObject arT = C0356a.arS().p("mapId", cVar.id).p("name", mapPoi.getName()).p("latitude", Double.valueOf(position.latitude)).p("longitude", Double.valueOf(position.longitude)).arT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", arT.toString());
            jSONObject.put("wvID", cVar.cwD);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.cwD, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0356a {
        private JSONObject params = new JSONObject();

        static C0356a arS() {
            return new C0356a();
        }

        C0356a p(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject arT() {
            return this.params;
        }

        C0356a() {
        }
    }
}
