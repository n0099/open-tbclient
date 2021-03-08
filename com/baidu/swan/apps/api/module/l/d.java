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
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b akC() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject cn2 = cn(getContext());
        return cn2 == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cn2);
    }

    public com.baidu.swan.apps.api.c.b akD() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject cn2 = cn(getContext());
        return cn2 == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cn2);
    }

    private JSONObject cn(Context context) {
        JSONObject cr;
        if (com.baidu.swan.apps.t.a.axc().agT()) {
            cr = e.cq(context);
        } else {
            cr = e.cr(context);
        }
        if (cr == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> aAa = com.baidu.swan.apps.v.f.aAo().aAa();
        Pair<Integer, Integer> aAb = com.baidu.swan.apps.v.f.aAo().aAb();
        try {
            cr.put("SDKVersion", co(context));
            cr.put("windowWidth", (int) (((Integer) aAa.first).intValue() / displayMetrics.density));
            cr.put("windowHeight", (int) (((Integer) aAa.second).intValue() / displayMetrics.density));
            cr.put("screenWidth", ah.V(((Integer) aAb.first).intValue()));
            cr.put("screenHeight", ah.V(((Integer) aAb.second).intValue()));
            aZ(cr);
            j(context, cr);
            a(context, cr, aAb);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + cr);
        }
        return cr;
    }

    private static String co(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).getFrameType();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aWD().asD(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.ash().asD(), i);
    }

    public static void aZ(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && aIN.aIZ().sB("mapp_location")) {
            com.baidu.swan.apps.t.b.d axr = com.baidu.swan.apps.t.a.axr();
            com.baidu.swan.apps.scheme.actions.f.b ayz = axr == null ? null : axr.ayz();
            if (ayz != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", ayz.city);
                jSONObject2.put("cityCode", ayz.cityCode);
                jSONObject2.put("country", ayz.country);
                jSONObject2.put("district", ayz.district);
                jSONObject2.put("province", ayz.province);
                jSONObject2.put("street", ayz.street);
                jSONObject2.put("streetNumber", ayz.streetNumber);
                jSONObject2.put("coord_gcj02", a(ayz, "gcj02"));
                jSONObject2.put("coord_wgs84", a(ayz, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.axr().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.ao(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.ao(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.ao(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.dN(context));
        jSONObject.put("locationEnabled", ak.dO(context));
        jSONObject.put("wifiEnabled", ak.dP(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int V = ah.V(ac.dF(context));
        int V2 = ah.V(((Integer) pair.first).intValue());
        int V3 = ah.V(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, V2);
        jSONObject2.put(VerticalTranslateLayout.TOP, V);
        jSONObject2.put("width", V2);
        jSONObject2.put("bottom", V3);
        jSONObject2.put("height", V3 - V);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b akE() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aOr());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
