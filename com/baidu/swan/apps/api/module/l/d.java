package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ac;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.y;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b amK() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject cj = cj(getContext());
        return cj == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cj);
    }

    public com.baidu.swan.apps.api.c.b amL() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject cj = cj(getContext());
        return cj == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cj);
    }

    private JSONObject cj(Context context) {
        JSONObject cn2;
        if (com.baidu.swan.apps.t.a.azd().ajd()) {
            cn2 = e.cm(context);
        } else {
            cn2 = e.cn(context);
        }
        if (cn2 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aCb = com.baidu.swan.apps.v.f.aCp().aCb();
        Pair<Integer, Integer> aCc = com.baidu.swan.apps.v.f.aCp().aCc();
        try {
            cn2.put("SDKVersion", ck(context));
            cn2.put("windowWidth", (int) (((Integer) aCb.first).intValue() / displayMetrics.density));
            cn2.put("windowHeight", (int) (((Integer) aCb.second).intValue() / displayMetrics.density));
            cn2.put("screenWidth", ah.O(((Integer) aCc.first).intValue()));
            cn2.put("screenHeight", ah.O(((Integer) aCc.second).intValue()));
            aS(cn2);
            k(context, cn2);
            a(context, cn2, aCc);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + cn2);
        }
        return cn2;
    }

    private static String ck(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).aie();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aXN().auD(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.aui().auD(), i);
    }

    public static void aS(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && aJU.aKg().tp("mapp_location")) {
            com.baidu.swan.apps.t.b.d azs = com.baidu.swan.apps.t.a.azs();
            com.baidu.swan.apps.scheme.actions.f.b aAA = azs == null ? null : azs.aAA();
            if (aAA != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aAA.city);
                jSONObject2.put("cityCode", aAA.cityCode);
                jSONObject2.put("country", aAA.country);
                jSONObject2.put("district", aAA.district);
                jSONObject2.put("province", aAA.province);
                jSONObject2.put("street", aAA.street);
                jSONObject2.put("streetNumber", aAA.streetNumber);
                jSONObject2.put("coord_gcj02", a(aAA, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aAA, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.azs().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.aj(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.aj(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.aj(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.dx(context));
        jSONObject.put("locationEnabled", ak.dy(context));
        jSONObject.put("wifiEnabled", ak.dz(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int O = ah.O(ac.dp(context));
        int O2 = ah.O(((Integer) pair.first).intValue());
        int O3 = ah.O(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, O2);
        jSONObject2.put(VerticalTranslateLayout.TOP, O);
        jSONObject2.put("width", O2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, O3);
        jSONObject2.put("height", O3 - O);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b amM() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aPx());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
