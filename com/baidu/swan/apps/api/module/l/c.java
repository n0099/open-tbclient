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
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.api.a.c {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b RR() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bd = bd(getContext());
        return bd == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bd);
    }

    public com.baidu.swan.apps.api.b.b RS() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bd = bd(getContext());
        return bd == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bd);
    }

    private JSONObject bd(Context context) {
        JSONObject bh;
        if (com.baidu.swan.apps.w.a.abQ().Pl()) {
            bh = d.bg(context);
        } else {
            bh = d.bh(context);
        }
        if (bh == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aew = f.aeJ().aew();
        Pair<Integer, Integer> aex = f.aeJ().aex();
        try {
            bh.put("SDKVersion", be(context));
            bh.put("windowWidth", (int) (((Integer) aew.first).intValue() / displayMetrics.density));
            bh.put("windowHeight", (int) (((Integer) aew.second).intValue() / displayMetrics.density));
            bh.put("screenWidth", af.E(((Integer) aex.first).intValue()));
            bh.put("screenHeight", af.E(((Integer) aex.second).intValue()));
            ag(bh);
            j(context, bh);
            k(context, bh);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bh);
        }
        return bh;
    }

    private static String be(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Ol();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.awo().YH(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.Yn().YH(), i);
    }

    public static void ag(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null && akM.akW().mL("mapp_location")) {
            com.baidu.swan.apps.w.b.f acg = com.baidu.swan.apps.w.a.acg();
            com.baidu.swan.apps.scheme.actions.f.b acY = acg == null ? null : acg.acY();
            if (acY != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", acY.city);
                jSONObject2.put("cityCode", acY.cityCode);
                jSONObject2.put("country", acY.country);
                jSONObject2.put("district", acY.district);
                jSONObject2.put("province", acY.province);
                jSONObject2.put("street", acY.street);
                jSONObject2.put("streetNumber", acY.streetNumber);
                jSONObject2.put("coord_gcj02", a(acY, "gcj02"));
                jSONObject2.put("coord_wgs84", a(acY, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.acg().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", v.Y(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", v.Y(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", v.Y(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ai.co(context));
        jSONObject.put("locationEnabled", ai.cp(context));
        jSONObject.put("wifiEnabled", ai.cq(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int E = af.E(z.ci(context));
        int E2 = af.E(af.getDisplayHeight(context));
        int E3 = af.E(af.getDisplayWidth(context));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, E3);
        jSONObject2.put(VerticalTranslateLayout.TOP, E);
        jSONObject2.put("width", E3);
        if (Build.VERSION.SDK_INT >= 28) {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, E + E2);
            jSONObject2.put("height", E2);
        } else {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, E2);
            jSONObject2.put("height", E2 - E);
        }
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.b.b RT() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.apr());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
