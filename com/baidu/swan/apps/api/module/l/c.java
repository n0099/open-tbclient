package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.apps.w.f;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b UC() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bn = bn(getContext());
        return bn == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bn);
    }

    public com.baidu.swan.apps.api.c.b UD() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bn = bn(getContext());
        return bn == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bn);
    }

    private JSONObject bn(Context context) {
        JSONObject br;
        if (com.baidu.swan.apps.u.a.aeU().Rx()) {
            br = d.bq(context);
        } else {
            br = d.br(context);
        }
        if (br == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> ahH = f.ahV().ahH();
        Pair<Integer, Integer> ahI = f.ahV().ahI();
        try {
            br.put("SDKVersion", bo(context));
            br.put("windowWidth", (int) (((Integer) ahH.first).intValue() / displayMetrics.density));
            br.put("windowHeight", (int) (((Integer) ahH.second).intValue() / displayMetrics.density));
            br.put("screenWidth", ag.D(((Integer) ahI.first).intValue()));
            br.put("screenHeight", ag.D(((Integer) ahI.second).intValue()));
            ao(br);
            k(context, br);
            a(context, br, ahI);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + br);
        }
        return br;
    }

    private static String bo(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Qz();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aAd().abG(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.abl().abG(), i);
    }

    public static void ao(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null && aoF.aoR().ok("mapp_location")) {
            com.baidu.swan.apps.u.b.d afj = com.baidu.swan.apps.u.a.afj();
            com.baidu.swan.apps.scheme.actions.f.b agi = afj == null ? null : afj.agi();
            if (agi != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", agi.city);
                jSONObject2.put("cityCode", agi.cityCode);
                jSONObject2.put("country", agi.country);
                jSONObject2.put("district", agi.district);
                jSONObject2.put("province", agi.province);
                jSONObject2.put("street", agi.street);
                jSONObject2.put("streetNumber", agi.streetNumber);
                jSONObject2.put("coord_gcj02", a(agi, "gcj02"));
                jSONObject2.put("coord_wgs84", a(agi, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.u.a.afj().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", w.Y(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", w.Y(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", w.Y(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", aj.cA(context));
        jSONObject.put("locationEnabled", aj.cB(context));
        jSONObject.put("wifiEnabled", aj.cC(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int D = ag.D(aa.cu(context));
        int D2 = ag.D(((Integer) pair.first).intValue());
        int D3 = ag.D(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, D2);
        jSONObject2.put(VerticalTranslateLayout.TOP, D);
        jSONObject2.put("width", D2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, D3);
        jSONObject2.put("height", D3 - D);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b UE() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", aj.atR());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
