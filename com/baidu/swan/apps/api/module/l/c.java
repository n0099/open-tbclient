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

    public com.baidu.swan.apps.api.b.b RS() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bp = bp(getContext());
        return bp == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bp);
    }

    public com.baidu.swan.apps.api.b.b RT() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bp = bp(getContext());
        return bp == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bp);
    }

    private JSONObject bp(Context context) {
        JSONObject bt;
        if (com.baidu.swan.apps.w.a.abR().Pm()) {
            bt = d.bs(context);
        } else {
            bt = d.bt(context);
        }
        if (bt == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aex = f.aeK().aex();
        Pair<Integer, Integer> aey = f.aeK().aey();
        try {
            bt.put("SDKVersion", bq(context));
            bt.put("windowWidth", (int) (((Integer) aex.first).intValue() / displayMetrics.density));
            bt.put("windowHeight", (int) (((Integer) aex.second).intValue() / displayMetrics.density));
            bt.put("screenWidth", af.E(((Integer) aey.first).intValue()));
            bt.put("screenHeight", af.E(((Integer) aey.second).intValue()));
            ag(bt);
            j(context, bt);
            k(context, bt);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bt);
        }
        return bt;
    }

    private static String bq(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Om();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.awo().YI(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.Yo().YI(), i);
    }

    public static void ag(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && akN.akX().mL("mapp_location")) {
            com.baidu.swan.apps.w.b.f ach = com.baidu.swan.apps.w.a.ach();
            com.baidu.swan.apps.scheme.actions.f.b acZ = ach == null ? null : ach.acZ();
            if (acZ != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", acZ.city);
                jSONObject2.put("cityCode", acZ.cityCode);
                jSONObject2.put("country", acZ.country);
                jSONObject2.put("district", acZ.district);
                jSONObject2.put("province", acZ.province);
                jSONObject2.put("street", acZ.street);
                jSONObject2.put("streetNumber", acZ.streetNumber);
                jSONObject2.put("coord_gcj02", a(acZ, "gcj02"));
                jSONObject2.put("coord_wgs84", a(acZ, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.ach().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", v.ak(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", v.ak(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", v.ak(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ai.cA(context));
        jSONObject.put("locationEnabled", ai.cB(context));
        jSONObject.put("wifiEnabled", ai.cC(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int E = af.E(z.cu(context));
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

    public com.baidu.swan.apps.api.b.b RU() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.aps());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
