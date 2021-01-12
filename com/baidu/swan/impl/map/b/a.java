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
        com.baidu.swan.impl.map.item.b b2 = cVar.b(marker);
        String str = "";
        if (b2 != null && b2.emZ != null) {
            str = b2.emZ.id;
        }
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).v("id", str).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).v("id", dVar.id).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a bi = cVar.bi(view);
        String str = "";
        if (bi != null && bi.emX != null) {
            str = bi.emX.id;
        }
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).v("controlId", str).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject bav = C0536a.bau().v("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).v("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).bav();
        JSONObject bav2 = C0536a.bau().v("mapId", cVar.id).v("northeast", bav).v("southwest", C0536a.bau().v("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).v("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).bav()).v("scale", Float.valueOf(mapStatus.zoom)).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", bav2.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).v("position", C0536a.bau().v("latitude", Double.valueOf(latLng.latitude)).v("longitude", Double.valueOf(latLng.longitude)).bav()).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0536a.bau().v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bav();
        JSONObject bav = C0536a.bau().v("mapId", cVar.id).v("name", mapPoi.getName()).v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bav();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", bav.toString());
            jSONObject.put("wvID", cVar.enp);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.enp, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0536a {
        private JSONObject params = new JSONObject();

        static C0536a bau() {
            return new C0536a();
        }

        C0536a v(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject bav() {
            return this.params;
        }

        C0536a() {
        }
    }
}
