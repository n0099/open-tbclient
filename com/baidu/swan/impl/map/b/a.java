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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b2 = cVar.b(marker);
        String str = "";
        if (b2 != null && b2.epj != null) {
            str = b2.epj.id;
        }
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).t("id", str).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).t("id", dVar.id).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a be = cVar.be(view);
        String str = "";
        if (be != null && be.eph != null) {
            str = be.eph.id;
        }
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).t("controlId", str).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject baI = C0533a.baH().t("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).t("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).baI();
        JSONObject baI2 = C0533a.baH().t("mapId", cVar.id).t("northeast", baI).t("southwest", C0533a.baH().t("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).t("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).baI()).t("scale", Float.valueOf(mapStatus.zoom)).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", baI2.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).t("position", C0533a.baH().t("latitude", Double.valueOf(latLng.latitude)).t("longitude", Double.valueOf(latLng.longitude)).baI()).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0533a.baH().t("latitude", Double.valueOf(position.latitude)).t("longitude", Double.valueOf(position.longitude)).baI();
        JSONObject baI = C0533a.baH().t("mapId", cVar.id).t("name", mapPoi.getName()).t("latitude", Double.valueOf(position.latitude)).t("longitude", Double.valueOf(position.longitude)).baI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", baI.toString());
            jSONObject.put("wvID", cVar.epy);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.epy, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0533a {
        private JSONObject params = new JSONObject();

        static C0533a baH() {
            return new C0533a();
        }

        C0533a t(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject baI() {
            return this.params;
        }

        C0533a() {
        }
    }
}
