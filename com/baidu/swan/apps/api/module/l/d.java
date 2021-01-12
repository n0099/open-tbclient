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

    public com.baidu.swan.apps.api.c.b akb() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject cp = cp(getContext());
        return cp == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cp);
    }

    public com.baidu.swan.apps.api.c.b akc() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject cp = cp(getContext());
        return cp == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, cp);
    }

    private JSONObject cp(Context context) {
        JSONObject ct;
        if (com.baidu.swan.apps.t.a.awB().ags()) {
            ct = e.cs(context);
        } else {
            ct = e.ct(context);
        }
        if (ct == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> azz = com.baidu.swan.apps.v.f.azN().azz();
        Pair<Integer, Integer> azA = com.baidu.swan.apps.v.f.azN().azA();
        try {
            ct.put("SDKVersion", cq(context));
            ct.put("windowWidth", (int) (((Integer) azz.first).intValue() / displayMetrics.density));
            ct.put("windowHeight", (int) (((Integer) azz.second).intValue() / displayMetrics.density));
            ct.put("screenWidth", ah.Q(((Integer) azA.first).intValue()));
            ct.put("screenHeight", ah.Q(((Integer) azA.second).intValue()));
            ba(ct);
            j(context, ct);
            a(context, ct, azA);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + ct);
        }
        return ct;
    }

    private static String cq(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).afr();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aWo().asb(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.arG().asb(), i);
    }

    public static void ba(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && aIr.aID().sa("mapp_location")) {
            com.baidu.swan.apps.t.b.d awQ = com.baidu.swan.apps.t.a.awQ();
            com.baidu.swan.apps.scheme.actions.f.b axY = awQ == null ? null : awQ.axY();
            if (axY != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", axY.city);
                jSONObject2.put("cityCode", axY.cityCode);
                jSONObject2.put("country", axY.country);
                jSONObject2.put("district", axY.district);
                jSONObject2.put("province", axY.province);
                jSONObject2.put("street", axY.street);
                jSONObject2.put("streetNumber", axY.streetNumber);
                jSONObject2.put("coord_gcj02", a(axY, "gcj02"));
                jSONObject2.put("coord_wgs84", a(axY, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b2 = com.baidu.swan.apps.t.a.awQ().b(bVar, str);
        if (b2 != null && b2.length >= 2) {
            jSONObject.put("longitude", b2[0]);
            jSONObject.put("latitude", b2[1]);
        }
        return jSONObject;
    }

    private void j(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", y.aq(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", y.aq(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", y.aq(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", ak.dP(context));
        jSONObject.put("locationEnabled", ak.dQ(context));
        jSONObject.put("wifiEnabled", ak.dR(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int Q = ah.Q(ac.dH(context));
        int Q2 = ah.Q(((Integer) pair.first).intValue());
        int Q3 = ah.Q(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, Q2);
        jSONObject2.put(VerticalTranslateLayout.TOP, Q);
        jSONObject2.put("width", Q2);
        jSONObject2.put("bottom", Q3);
        jSONObject2.put("height", Q3 - Q);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b akd() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", ak.aNV());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
