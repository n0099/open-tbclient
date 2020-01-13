package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.v;
import com.baidu.swan.apps.as.z;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.api.a.c {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b HL() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, by);
    }

    public com.baidu.swan.apps.api.b.b HM() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, by);
    }

    private JSONObject by(Context context) {
        JSONObject bC;
        if (com.baidu.swan.apps.w.a.RJ().Fd()) {
            bC = d.bB(context);
        } else {
            bC = d.bC(context);
        }
        if (bC == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> Up = f.UC().Up();
        Pair<Integer, Integer> Uq = f.UC().Uq();
        try {
            bC.put("SDKVersion", bz(context));
            bC.put("windowWidth", (int) (((Integer) Up.first).intValue() / displayMetrics.density));
            bC.put("windowHeight", (int) (((Integer) Up.second).intValue() / displayMetrics.density));
            bC.put("screenWidth", af.U(((Integer) Uq.first).intValue()));
            bC.put("screenHeight", af.U(((Integer) Uq.second).intValue()));
            V(bC);
            j(context, bC);
            k(context, bC);
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
            i = ((SwanAppActivity) context).Ed();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.alJ().OA(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.Og().OA(), i);
    }

    public static void V(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && aap.aaz().lk("mapp_location")) {
            com.baidu.swan.apps.w.b.f RZ = com.baidu.swan.apps.w.a.RZ();
            com.baidu.swan.apps.scheme.actions.f.b SR = RZ == null ? null : RZ.SR();
            if (SR != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", SR.city);
                jSONObject2.put("cityCode", SR.cityCode);
                jSONObject2.put("country", SR.country);
                jSONObject2.put("district", SR.district);
                jSONObject2.put("province", SR.province);
                jSONObject2.put("street", SR.street);
                jSONObject2.put("streetNumber", SR.streetNumber);
                jSONObject2.put("coord_gcj02", a(SR, "gcj02"));
                jSONObject2.put("coord_wgs84", a(SR, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.RZ().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", v.aq(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", v.aq(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", v.aq(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ai.cJ(context));
        jSONObject.put("locationEnabled", ai.cK(context));
        jSONObject.put("wifiEnabled", ai.cL(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int U = af.U(z.cD(context));
        int U2 = af.U(af.getDisplayHeight(context));
        int U3 = af.U(af.getDisplayWidth(context));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.RIGHT, U3);
        jSONObject2.put(VerticalTranslateLayout.TOP, U);
        jSONObject2.put("width", U3);
        if (Build.VERSION.SDK_INT >= 28) {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, U + U2);
            jSONObject2.put("height", U2);
        } else {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, U2);
            jSONObject2.put("height", U2 - U);
        }
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.b.b HN() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.aeR());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
