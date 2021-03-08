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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.eqK != null) {
            str = b.eqK.id;
        }
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).u("id", str).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).u("id", dVar.id).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a be = cVar.be(view);
        String str = "";
        if (be != null && be.eqI != null) {
            str = be.eqI.id;
        }
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).u("controlId", str).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject baL = C0539a.baK().u("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).u("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).baL();
        JSONObject baL2 = C0539a.baK().u("mapId", cVar.id).u("northeast", baL).u("southwest", C0539a.baK().u("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).u("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).baL()).u("scale", Float.valueOf(mapStatus.zoom)).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", baL2.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).u("position", C0539a.baK().u("latitude", Double.valueOf(latLng.latitude)).u("longitude", Double.valueOf(latLng.longitude)).baL()).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0539a.baK().u("latitude", Double.valueOf(position.latitude)).u("longitude", Double.valueOf(position.longitude)).baL();
        JSONObject baL = C0539a.baK().u("mapId", cVar.id).u("name", mapPoi.getName()).u("latitude", Double.valueOf(position.latitude)).u("longitude", Double.valueOf(position.longitude)).baL();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", baL.toString());
            jSONObject.put("wvID", cVar.eqZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.eqZ, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0539a {
        private JSONObject params = new JSONObject();

        static C0539a baK() {
            return new C0539a();
        }

        C0539a u(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject baL() {
            return this.params;
        }

        C0539a() {
        }
    }
}
