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
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b afQ() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bD = bD(getContext());
        return bD == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bD);
    }

    public com.baidu.swan.apps.api.c.b afR() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bD = bD(getContext());
        return bD == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bD);
    }

    private JSONObject bD(Context context) {
        JSONObject bH;
        if (com.baidu.swan.apps.t.a.asi().acj()) {
            bH = e.bG(context);
        } else {
            bH = e.bH(context);
        }
        if (bH == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> avg = com.baidu.swan.apps.v.f.avu().avg();
        Pair<Integer, Integer> avh = com.baidu.swan.apps.v.f.avu().avh();
        try {
            bH.put("SDKVersion", bE(context));
            bH.put("windowWidth", (int) (((Integer) avg.first).intValue() / displayMetrics.density));
            bH.put("windowHeight", (int) (((Integer) avg.second).intValue() / displayMetrics.density));
            bH.put("screenWidth", ah.L(((Integer) avh.first).intValue()));
            bH.put("screenHeight", ah.L(((Integer) avh.second).intValue()));
            aN(bH);
            k(context, bH);
            a(context, bH, avh);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bH);
        }
        return bH;
    }

    private static String bE(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).abk();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aQW().anI(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.ann().anI(), i);
    }

    public static void aN(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && aDa.aDm().sf("mapp_location")) {
            com.baidu.swan.apps.t.b.d asy = com.baidu.swan.apps.t.a.asy();
            com.baidu.swan.apps.scheme.actions.f.b atF = asy == null ? null : asy.atF();
            if (atF != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", atF.city);
                jSONObject2.put("cityCode", atF.cityCode);
                jSONObject2.put("country", atF.country);
                jSONObject2.put("district", atF.district);
                jSONObject2.put("province", atF.province);
                jSONObject2.put("street", atF.street);
                jSONObject2.put("streetNumber", atF.streetNumber);
                jSONObject2.put("coord_gcj02", a(atF, "gcj02"));
                jSONObject2.put("coord_wgs84", a(atF, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.asy().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.ai(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.ai(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.ai(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.cR(context));
        jSONObject.put("locationEnabled", ak.cS(context));
        jSONObject.put("wifiEnabled", ak.cT(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int L = ah.L(ac.cJ(context));
        int L2 = ah.L(((Integer) pair.first).intValue());
        int L3 = ah.L(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, L2);
        jSONObject2.put(VerticalTranslateLayout.TOP, L);
        jSONObject2.put("width", L2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, L3);
        jSONObject2.put("height", L3 - L);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b afS() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aIF());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
