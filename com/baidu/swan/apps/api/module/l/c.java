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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.api.a.c {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b Hp() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, by);
    }

    public com.baidu.swan.apps.api.b.b Hq() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject by = by(getContext());
        return by == null ? new com.baidu.swan.apps.api.b.b(202, "empty joData") : new com.baidu.swan.apps.api.b.b(0, by);
    }

    private JSONObject by(Context context) {
        JSONObject bC;
        if (com.baidu.swan.apps.w.a.Rn().EH()) {
            bC = d.bB(context);
        } else {
            bC = d.bC(context);
        }
        if (bC == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> TS = f.Uf().TS();
        Pair<Integer, Integer> TT = f.Uf().TT();
        try {
            bC.put("SDKVersion", bz(context));
            bC.put("windowWidth", (int) (((Integer) TS.first).intValue() / displayMetrics.density));
            bC.put("windowHeight", (int) (((Integer) TS.second).intValue() / displayMetrics.density));
            bC.put("screenWidth", af.V(((Integer) TT.first).intValue()));
            bC.put("screenHeight", af.V(((Integer) TT.second).intValue()));
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
            i = ((SwanAppActivity) context).DH();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.i.a.alq().Oe(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.k.d.NK().Oe(), i);
    }

    public static void V(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && ZS.aac().lh("mapp_location")) {
            com.baidu.swan.apps.w.b.f RD = com.baidu.swan.apps.w.a.RD();
            com.baidu.swan.apps.scheme.actions.f.b Sv = RD == null ? null : RD.Sv();
            if (Sv != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", Sv.city);
                jSONObject2.put("cityCode", Sv.cityCode);
                jSONObject2.put("country", Sv.country);
                jSONObject2.put("district", Sv.district);
                jSONObject2.put("province", Sv.province);
                jSONObject2.put("street", Sv.street);
                jSONObject2.put("streetNumber", Sv.streetNumber);
                jSONObject2.put("coord_gcj02", a(Sv, "gcj02"));
                jSONObject2.put("coord_wgs84", a(Sv, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.w.a.RD().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", v.ao(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", v.ao(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", v.ao(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ai.cJ(context));
        jSONObject.put("locationEnabled", ai.cK(context));
        jSONObject.put("wifiEnabled", ai.cL(context));
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        int V = af.V(z.cD(context));
        int V2 = af.V(af.getDisplayHeight(context));
        int V3 = af.V(af.getDisplayWidth(context));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.RIGHT, V3);
        jSONObject2.put(VerticalTranslateLayout.TOP, V);
        jSONObject2.put("width", V3);
        if (Build.VERSION.SDK_INT >= 28) {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, V + V2);
            jSONObject2.put("height", V2);
        } else {
            jSONObject2.put(VerticalTranslateLayout.BOTTOM, V2);
            jSONObject2.put("height", V2 - V);
        }
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.b.b Hr() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ai.aey());
            return new com.baidu.swan.apps.api.b.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.b.b(1001, "exec fail");
        }
    }
}
