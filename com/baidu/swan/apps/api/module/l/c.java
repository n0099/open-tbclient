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

    public com.baidu.swan.apps.api.b.b Kc() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject bC = bC(getContext());
        return bC == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bC);
    }

    public com.baidu.swan.apps.api.b.b Kd() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject bC = bC(getContext());
        return bC == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, bC);
    }

    private JSONObject bC(Context context) {
        JSONObject bG;
        if (com.baidu.swan.apps.w.a.TZ().Hu()) {
            bG = d.bF(context);
        } else {
            bG = d.bG(context);
        }
        if (bG == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> WF = f.WS().WF();
        Pair<Integer, Integer> WG = f.WS().WG();
        try {
            bG.put("SDKVersion", bD(context));
            bG.put("windowWidth", (int) (((Integer) WF.first).intValue() / displayMetrics.density));
            bG.put("windowHeight", (int) (((Integer) WF.second).intValue() / displayMetrics.density));
            bG.put("screenWidth", af.U(((Integer) WG.first).intValue()));
            bG.put("screenHeight", af.U(((Integer) WG.second).intValue()));
            V(bG);
            j(context, bG);
            k(context, bG);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bG);
        }
        return bG;
    }

    private static String bD(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Gu();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.anY().QQ(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.Qw().QQ(), i);
    }

    public static void V(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && acF.acP().lz("mapp_location")) {
            com.baidu.swan.apps.w.b.f Up = com.baidu.swan.apps.w.a.Up();
            com.baidu.swan.apps.scheme.actions.f.b Vh = Up == null ? null : Up.Vh();
            if (Vh != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", Vh.city);
                jSONObject2.put("cityCode", Vh.cityCode);
                jSONObject2.put("country", Vh.country);
                jSONObject2.put("district", Vh.district);
                jSONObject2.put("province", Vh.province);
                jSONObject2.put("street", Vh.street);
                jSONObject2.put("streetNumber", Vh.streetNumber);
                jSONObject2.put("coord_gcj02", a(Vh, "gcj02"));
                jSONObject2.put("coord_wgs84", a(Vh, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.Up().b(bVar, str);
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
        jSONObject.put("notificationAuthorized", ai.cN(context));
        jSONObject.put("locationEnabled", ai.cO(context));
        jSONObject.put("wifiEnabled", ai.cP(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int U = af.U(z.cH(context));
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

    public com.baidu.swan.apps.api.b.b Ke() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.ahh());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
