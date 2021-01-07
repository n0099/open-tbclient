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
        if (b2 != null && b2.erP != null) {
            str = b2.erP.id;
        }
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).v("id", str).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).v("id", dVar.id).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a bi = cVar.bi(view);
        String str = "";
        if (bi != null && bi.erN != null) {
            str = bi.erN.id;
        }
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).v("controlId", str).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject bep = C0553a.beo().v("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).v("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).bep();
        JSONObject bep2 = C0553a.beo().v("mapId", cVar.id).v("northeast", bep).v("southwest", C0553a.beo().v("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).v("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).bep()).v("scale", Float.valueOf(mapStatus.zoom)).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", bep2.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).v("position", C0553a.beo().v("latitude", Double.valueOf(latLng.latitude)).v("longitude", Double.valueOf(latLng.longitude)).bep()).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0553a.beo().v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bep();
        JSONObject bep = C0553a.beo().v("mapId", cVar.id).v("name", mapPoi.getName()).v("latitude", Double.valueOf(position.latitude)).v("longitude", Double.valueOf(position.longitude)).bep();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", bep.toString());
            jSONObject.put("wvID", cVar.ese);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.c(cVar.ese, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0553a {
        private JSONObject params = new JSONObject();

        static C0553a beo() {
            return new C0553a();
        }

        C0553a v(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject bep() {
            return this.params;
        }

        C0553a() {
        }
    }
}
