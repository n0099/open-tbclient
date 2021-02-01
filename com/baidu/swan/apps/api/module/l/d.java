package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
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

    public com.baidu.swan.apps.api.c.b akz() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject co = co(getContext());
        return co == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, co);
    }

    public com.baidu.swan.apps.api.c.b akA() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject co = co(getContext());
        return co == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, co);
    }

    private JSONObject co(Context context) {
        JSONObject cs;
        if (com.baidu.swan.apps.t.a.awZ().agQ()) {
            cs = e.cr(context);
        } else {
            cs = e.cs(context);
        }
        if (cs == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> azX = com.baidu.swan.apps.v.f.aAl().azX();
        Pair<Integer, Integer> azY = com.baidu.swan.apps.v.f.aAl().azY();
        try {
            cs.put("SDKVersion", cp(context));
            cs.put("windowWidth", (int) (((Integer) azX.first).intValue() / displayMetrics.density));
            cs.put("windowHeight", (int) (((Integer) azX.second).intValue() / displayMetrics.density));
            cs.put("screenWidth", ah.R(((Integer) azY.first).intValue()));
            cs.put("screenHeight", ah.R(((Integer) azY.second).intValue()));
            aX(cs);
            j(context, cs);
            a(context, cs, azY);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + cs);
        }
        return cs;
    }

    private static String cp(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).getFrameType();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aWA().asA(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.ase().asA(), i);
    }

    public static void aX(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && aIK.aIW().su("mapp_location")) {
            com.baidu.swan.apps.t.b.d axo = com.baidu.swan.apps.t.a.axo();
            com.baidu.swan.apps.scheme.actions.f.b ayw = axo == null ? null : axo.ayw();
            if (ayw != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", ayw.city);
                jSONObject2.put("cityCode", ayw.cityCode);
                jSONObject2.put("country", ayw.country);
                jSONObject2.put("district", ayw.district);
                jSONObject2.put("province", ayw.province);
                jSONObject2.put("street", ayw.street);
                jSONObject2.put("streetNumber", ayw.streetNumber);
                jSONObject2.put("coord_gcj02", a(ayw, "gcj02"));
                jSONObject2.put("coord_wgs84", a(ayw, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b2 = com.baidu.swan.apps.t.a.axo().b(bVar, str);
        if (b2 != null && b2.length >= 2) {
            jSONObject.put("longitude", b2[0]);
            jSONObject.put("latitude", b2[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.ao(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.ao(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.ao(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.dO(context));
        jSONObject.put("locationEnabled", ak.dP(context));
        jSONObject.put("wifiEnabled", ak.dQ(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int R = ah.R(ac.dG(context));
        int R2 = ah.R(((Integer) pair.first).intValue());
        int R3 = ah.R(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, R2);
        jSONObject2.put(VerticalTranslateLayout.TOP, R);
        jSONObject2.put("width", R2);
        jSONObject2.put("bottom", R3);
        jSONObject2.put("height", R3 - R);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b akB() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aOo());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
