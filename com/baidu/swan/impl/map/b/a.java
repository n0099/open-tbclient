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
/* loaded from: classes24.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Marker marker, c cVar) {
        com.baidu.swan.impl.map.item.b b = cVar.b(marker);
        String str = "";
        if (b != null && b.dDd != null) {
            str = b.dDd.id;
        }
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).w("id", str).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "markertap", jSONObject);
    }

    public static void b(c cVar, d dVar) {
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).w("id", dVar.id).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "callouttap", jSONObject);
    }

    public static void a(View view, c cVar) {
        com.baidu.swan.impl.map.item.a aR = cVar.aR(view);
        String str = "";
        if (aR != null && aR.dDb != null) {
            str = aR.dDb.id;
        }
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).w("controlId", str).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "controltap", jSONObject);
    }

    public static void a(c cVar, MapStatus mapStatus) {
        JSONObject aSv = C0509a.aSu().w("latitude", Double.valueOf(mapStatus.bound.northeast.latitude)).w("longitude", Double.valueOf(mapStatus.bound.northeast.longitude)).aSv();
        JSONObject aSv2 = C0509a.aSu().w("mapId", cVar.id).w("northeast", aSv).w("southwest", C0509a.aSu().w("latitude", Double.valueOf(mapStatus.bound.southwest.latitude)).w("longitude", Double.valueOf(mapStatus.bound.southwest.longitude)).aSv()).w("scale", Float.valueOf(mapStatus.zoom)).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", aSv2.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "regionchange", jSONObject);
    }

    public static void a(c cVar, LatLng latLng) {
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).w("position", C0509a.aSu().w("latitude", Double.valueOf(latLng.latitude)).w("longitude", Double.valueOf(latLng.longitude)).aSv()).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "tap", jSONObject);
    }

    public static void b(c cVar) {
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "updated", jSONObject);
    }

    public static void a(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C0509a.aSu().w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aSv();
        JSONObject aSv = C0509a.aSu().w("mapId", cVar.id).w("name", mapPoi.getName()).w("latitude", Double.valueOf(position.latitude)).w("longitude", Double.valueOf(position.longitude)).aSv();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", aSv.toString());
            jSONObject.put("wvID", cVar.dDs);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.a(cVar.dDs, cVar.id, "map", "poitap", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class C0509a {
        private JSONObject params = new JSONObject();

        static C0509a aSu() {
            return new C0509a();
        }

        C0509a w(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject aSv() {
            return this.params;
        }

        C0509a() {
        }
    }
}
