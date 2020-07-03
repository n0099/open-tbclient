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
        if (b != null && b.dlc != null) {
            str = b.dlc.id;
        }
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).x("id", str).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).x("id", dVar.id).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aI = cVar.aI(view);
        String str = "";
        if (aI != null && aI.dla != null) {
            str = aI.dla.id;
        }
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).x("controlId", str).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aFc = C0454a.aFb().x("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).x("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aFc();
        JSONObject aFc2 = C0454a.aFb().x("mapId", cVar.id).x("northeast", aFc).x("southwest", C0454a.aFb().x("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).x("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aFc()).x("scale", Float.valueOf(mapStatus.zoom)).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aFc2.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).x("position", C0454a.aFb().x("latitude", Double.valueOf(latLng.latitude)).x("longitude", Double.valueOf(latLng.longitude)).aFc()).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0454a.aFb().x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aFc();
        JSONObject aFc = C0454a.aFb().x("mapId", cVar.id).x("name", mapPoi.getName()).x("latitude", Double.valueOf(position.latitude)).x("longitude", Double.valueOf(position.longitude)).aFc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aFc.toString());
            jSONObject.put("wvID", cVar.dlr);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dlr, cVar.id, "map", "poitap", jSONObject);
    }

    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0454a {
        private JSONObject params = new JSONObject();

        static C0454a aFb() {
            return new C0454a();
        }

        C0454a x(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aFc() {
            return this.params;
        }

        C0454a() {
        }
    }
}
