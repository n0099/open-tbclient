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

    public com.baidu.swan.apps.api.c.b VI() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bo = bo(getContext());
        return bo == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bo);
    }

    public com.baidu.swan.apps.api.c.b VJ() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bo = bo(getContext());
        return bo == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bo);
    }

    private JSONObject bo(Context context) {
        JSONObject bs;
        if (com.baidu.swan.apps.u.a.aga().SD()) {
            bs = d.br(context);
        } else {
            bs = d.bs(context);
        }
        if (bs == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aiN = f.ajb().aiN();
        Pair<Integer, Integer> aiO = f.ajb().aiO();
        try {
            bs.put("SDKVersion", bp(context));
            bs.put("windowWidth", (int) (((Integer) aiN.first).intValue() / displayMetrics.density));
            bs.put("windowHeight", (int) (((Integer) aiN.second).intValue() / displayMetrics.density));
            bs.put("screenWidth", ag.F(((Integer) aiO.first).intValue()));
            bs.put("screenHeight", ag.F(((Integer) aiO.second).intValue()));
            av(bs);
            k(context, bs);
            a(context, bs, aiO);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bs);
        }
        return bs;
    }

    private static String bp(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).RF();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aBj().acM(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.acr().acM(), i);
    }

    public static void av(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null && apM.apY().ot("mapp_location")) {
            com.baidu.swan.apps.u.b.d agp = com.baidu.swan.apps.u.a.agp();
            com.baidu.swan.apps.scheme.actions.f.b aho = agp == null ? null : agp.aho();
            if (aho != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aho.city);
                jSONObject2.put("cityCode", aho.cityCode);
                jSONObject2.put("country", aho.country);
                jSONObject2.put("district", aho.district);
                jSONObject2.put("province", aho.province);
                jSONObject2.put("street", aho.street);
                jSONObject2.put("streetNumber", aho.streetNumber);
                jSONObject2.put("coord_gcj02", a(aho, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aho, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.u.a.agp().b(bVar, str);
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
        jSONObject.put("notificationAuthorized", aj.cB(context));
        jSONObject.put("locationEnabled", aj.cC(context));
        jSONObject.put("wifiEnabled", aj.cD(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int F = ag.F(aa.cv(context));
        int F2 = ag.F(((Integer) pair.first).intValue());
        int F3 = ag.F(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, F2);
        jSONObject2.put(VerticalTranslateLayout.TOP, F);
        jSONObject2.put("width", F2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, F3);
        jSONObject2.put("height", F3 - F);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b VK() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", aj.auX());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
