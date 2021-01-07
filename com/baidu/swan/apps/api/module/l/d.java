package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.platform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ac;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.y;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b anV() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject cq = cq(getContext());
        return cq == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cq);
    }

    public com.baidu.swan.apps.api.c.b anW() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject cq = cq(getContext());
        return cq == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cq);
    }

    private JSONObject cq(Context context) {
        JSONObject cu;
        if (com.baidu.swan.apps.t.a.aAv().akm()) {
            cu = e.ct(context);
        } else {
            cu = e.cu(context);
        }
        if (cu == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aDt = com.baidu.swan.apps.v.f.aDH().aDt();
        Pair<Integer, Integer> aDu = com.baidu.swan.apps.v.f.aDH().aDu();
        try {
            cu.put("SDKVersion", cr(context));
            cu.put("windowWidth", (int) (((Integer) aDt.first).intValue() / displayMetrics.density));
            cu.put("windowHeight", (int) (((Integer) aDt.second).intValue() / displayMetrics.density));
            cu.put("screenWidth", ah.Q(((Integer) aDu.first).intValue()));
            cu.put("screenHeight", ah.Q(((Integer) aDu.second).intValue()));
            ba(cu);
            j(context, cu);
            a(context, cu, aDu);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + cu);
        }
        return cu;
    }

    private static String cr(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).ajl();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.bai().avW(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.avB().avW(), i);
    }

    public static void ba(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null && aMl.aMx().tm("mapp_location")) {
            com.baidu.swan.apps.t.b.d aAK = com.baidu.swan.apps.t.a.aAK();
            com.baidu.swan.apps.scheme.actions.f.b aBS = aAK == null ? null : aAK.aBS();
            if (aBS != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aBS.city);
                jSONObject2.put("cityCode", aBS.cityCode);
                jSONObject2.put("country", aBS.country);
                jSONObject2.put("district", aBS.district);
                jSONObject2.put("province", aBS.province);
                jSONObject2.put("street", aBS.street);
                jSONObject2.put("streetNumber", aBS.streetNumber);
                jSONObject2.put("coord_gcj02", a(aBS, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aBS, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b2 = com.baidu.swan.apps.t.a.aAK().b(bVar, str);
        if (b2 != null && b2.length >= 2) {
            jSONObject.put("longitude", b2[0]);
            jSONObject.put("latitude", b2[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.aq(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.aq(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.aq(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.dQ(context));
        jSONObject.put("locationEnabled", ak.dR(context));
        jSONObject.put("wifiEnabled", ak.dS(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int Q = ah.Q(ac.dI(context));
        int Q2 = ah.Q(((Integer) pair.first).intValue());
        int Q3 = ah.Q(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, Q2);
        jSONObject2.put(VerticalTranslateLayout.TOP, Q);
        jSONObject2.put("width", Q2);
        jSONObject2.put("bottom", Q3);
        jSONObject2.put("height", Q3 - Q);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b anX() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aRP());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
