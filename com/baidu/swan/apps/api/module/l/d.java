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

    public com.baidu.swan.apps.api.c.b akk() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bD = bD(getContext());
        return bD == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bD);
    }

    public com.baidu.swan.apps.api.c.b akl() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bD = bD(getContext());
        return bD == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bD);
    }

    private JSONObject bD(Context context) {
        JSONObject bH;
        if (com.baidu.swan.apps.t.a.awD().agD()) {
            bH = e.bG(context);
        } else {
            bH = e.bH(context);
        }
        if (bH == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> azA = com.baidu.swan.apps.v.f.azO().azA();
        Pair<Integer, Integer> azB = com.baidu.swan.apps.v.f.azO().azB();
        try {
            bH.put("SDKVersion", bE(context));
            bH.put("windowWidth", (int) (((Integer) azA.first).intValue() / displayMetrics.density));
            bH.put("windowHeight", (int) (((Integer) azA.second).intValue() / displayMetrics.density));
            bH.put("screenWidth", ah.P(((Integer) azB.first).intValue()));
            bH.put("screenHeight", ah.P(((Integer) azB.second).intValue()));
            aW(bH);
            k(context, bH);
            a(context, bH, azB);
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
            i = ((SwanAppActivity) context).afE();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aVq().asd(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.arI().asd(), i);
    }

    public static void aW(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && aHu.aHG().sN("mapp_location")) {
            com.baidu.swan.apps.t.b.d awS = com.baidu.swan.apps.t.a.awS();
            com.baidu.swan.apps.scheme.actions.f.b axZ = awS == null ? null : awS.axZ();
            if (axZ != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", axZ.city);
                jSONObject2.put("cityCode", axZ.cityCode);
                jSONObject2.put("country", axZ.country);
                jSONObject2.put("district", axZ.district);
                jSONObject2.put("province", axZ.province);
                jSONObject2.put("street", axZ.street);
                jSONObject2.put("streetNumber", axZ.streetNumber);
                jSONObject2.put("coord_gcj02", a(axZ, "gcj02"));
                jSONObject2.put("coord_wgs84", a(axZ, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.awS().b(bVar, str);
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
        jSONObject.put("notificationAuthorized", ak.cR(context));
        jSONObject.put("locationEnabled", ak.cS(context));
        jSONObject.put("wifiEnabled", ak.cT(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int P = ah.P(ac.cJ(context));
        int P2 = ah.P(((Integer) pair.first).intValue());
        int P3 = ah.P(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, P2);
        jSONObject2.put(VerticalTranslateLayout.TOP, P);
        jSONObject2.put("width", P2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, P3);
        jSONObject2.put("height", P3 - P);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b akm() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aMZ());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
