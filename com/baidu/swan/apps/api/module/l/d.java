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
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b acv() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, by);
    }

    public com.baidu.swan.apps.api.c.b acw() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, by);
    }

    private JSONObject by(Context context) {
        JSONObject bC;
        if (com.baidu.swan.apps.t.a.aoM().YO()) {
            bC = e.bB(context);
        } else {
            bC = e.bC(context);
        }
        if (bC == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> arK = com.baidu.swan.apps.v.f.arY().arK();
        Pair<Integer, Integer> arL = com.baidu.swan.apps.v.f.arY().arL();
        try {
            bC.put("SDKVersion", bz(context));
            bC.put("windowWidth", (int) (((Integer) arK.first).intValue() / displayMetrics.density));
            bC.put("windowHeight", (int) (((Integer) arK.second).intValue() / displayMetrics.density));
            bC.put("screenWidth", ah.J(((Integer) arL.first).intValue()));
            bC.put("screenHeight", ah.J(((Integer) arL.second).intValue()));
            aD(bC);
            k(context, bC);
            a(context, bC, arL);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bC);
        }
        return bC;
    }

    private static String bz(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).XP();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aNC().akn(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.ajS().akn(), i);
    }

    public static void aD(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && azI.azU().ra("mapp_location")) {
            com.baidu.swan.apps.t.b.d apb = com.baidu.swan.apps.t.a.apb();
            com.baidu.swan.apps.scheme.actions.f.b aqj = apb == null ? null : apb.aqj();
            if (aqj != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aqj.city);
                jSONObject2.put("cityCode", aqj.cityCode);
                jSONObject2.put("country", aqj.country);
                jSONObject2.put("district", aqj.district);
                jSONObject2.put("province", aqj.province);
                jSONObject2.put("street", aqj.street);
                jSONObject2.put("streetNumber", aqj.streetNumber);
                jSONObject2.put("coord_gcj02", a(aqj, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aqj, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.apb().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.ac(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.ac(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.ac(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.cM(context));
        jSONObject.put("locationEnabled", ak.cN(context));
        jSONObject.put("wifiEnabled", ak.cO(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int J = ah.J(ac.cE(context));
        int J2 = ah.J(((Integer) pair.first).intValue());
        int J3 = ah.J(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, J2);
        jSONObject2.put(VerticalTranslateLayout.TOP, J);
        jSONObject2.put("width", J2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, J3);
        jSONObject2.put("height", J3 - J);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b acx() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aFm());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
