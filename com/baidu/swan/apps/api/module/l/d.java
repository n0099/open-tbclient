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
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ade() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bx = bx(getContext());
        return bx == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bx);
    }

    public com.baidu.swan.apps.api.c.b adf() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bx = bx(getContext());
        return bx == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, bx);
    }

    private JSONObject bx(Context context) {
        JSONObject bB;
        if (com.baidu.swan.apps.t.a.apx().Zx()) {
            bB = e.bA(context);
        } else {
            bB = e.bB(context);
        }
        if (bB == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> asv = com.baidu.swan.apps.v.f.asJ().asv();
        Pair<Integer, Integer> asw = com.baidu.swan.apps.v.f.asJ().asw();
        try {
            bB.put("SDKVersion", by(context));
            bB.put("windowWidth", (int) (((Integer) asv.first).intValue() / displayMetrics.density));
            bB.put("windowHeight", (int) (((Integer) asv.second).intValue() / displayMetrics.density));
            bB.put("screenWidth", ah.J(((Integer) asw.first).intValue()));
            bB.put("screenHeight", ah.J(((Integer) asw.second).intValue()));
            aG(bB);
            k(context, bB);
            a(context, bB, asw);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bB);
        }
        return bB;
    }

    private static String by(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Yy();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aOn().akX(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.akC().akX(), i);
    }

    public static void aG(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && aAr.aAD().rt("mapp_location")) {
            com.baidu.swan.apps.t.b.d apM = com.baidu.swan.apps.t.a.apM();
            com.baidu.swan.apps.scheme.actions.f.b aqT = apM == null ? null : apM.aqT();
            if (aqT != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aqT.city);
                jSONObject2.put("cityCode", aqT.cityCode);
                jSONObject2.put("country", aqT.country);
                jSONObject2.put("district", aqT.district);
                jSONObject2.put("province", aqT.province);
                jSONObject2.put("street", aqT.street);
                jSONObject2.put("streetNumber", aqT.streetNumber);
                jSONObject2.put("coord_gcj02", a(aqT, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aqT, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.apM().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.af(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.af(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.af(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.cL(context));
        jSONObject.put("locationEnabled", ak.cM(context));
        jSONObject.put("wifiEnabled", ak.cN(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int J = ah.J(ac.cD(context));
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

    public com.baidu.swan.apps.api.c.b adg() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aFW());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
