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

    public com.baidu.swan.apps.api.b.b Kf() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bB = bB(getContext());
        return bB == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bB);
    }

    public com.baidu.swan.apps.api.b.b Kg() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bB = bB(getContext());
        return bB == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bB);
    }

    private JSONObject bB(Context context) {
        JSONObject bF;
        if (com.baidu.swan.apps.w.a.Uc().Hz()) {
            bF = d.bE(context);
        } else {
            bF = d.bF(context);
        }
        if (bF == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> WI = f.WV().WI();
        Pair<Integer, Integer> WJ = f.WV().WJ();
        try {
            bF.put("SDKVersion", bC(context));
            bF.put("windowWidth", (int) (((Integer) WI.first).intValue() / displayMetrics.density));
            bF.put("windowHeight", (int) (((Integer) WI.second).intValue() / displayMetrics.density));
            bF.put("screenWidth", af.U(((Integer) WJ.first).intValue()));
            bF.put("screenHeight", af.U(((Integer) WJ.second).intValue()));
            V(bF);
            j(context, bF);
            k(context, bF);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bF);
        }
        return bF;
    }

    private static String bC(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Gz();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.aob().QT(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.Qz().QT(), i);
    }

    public static void V(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && acI.acS().ly("mapp_location")) {
            com.baidu.swan.apps.w.b.f Us = com.baidu.swan.apps.w.a.Us();
            com.baidu.swan.apps.scheme.actions.f.b Vk = Us == null ? null : Us.Vk();
            if (Vk != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", Vk.city);
                jSONObject2.put("cityCode", Vk.cityCode);
                jSONObject2.put("country", Vk.country);
                jSONObject2.put("district", Vk.district);
                jSONObject2.put("province", Vk.province);
                jSONObject2.put("street", Vk.street);
                jSONObject2.put("streetNumber", Vk.streetNumber);
                jSONObject2.put("coord_gcj02", a(Vk, "gcj02"));
                jSONObject2.put("coord_wgs84", a(Vk, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.Us().b(bVar, str);
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
        jSONObject.put("notificationAuthorized", ai.cM(context));
        jSONObject.put("locationEnabled", ai.cN(context));
        jSONObject.put("wifiEnabled", ai.cO(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int U = af.U(z.cG(context));
        int U2 = af.U(af.getDisplayHeight(context));
        int U3 = af.U(af.getDisplayWidth(context));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, U3);
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

    public com.baidu.swan.apps.api.b.b Kh() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.ahk());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
