package com.baidu.swan.apps.api.module.l;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.ab;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.x;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    private JSONObject bSt;

    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b Wo() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info");
        }
        JSONObject br = br(getContext());
        return br == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, br);
    }

    public com.baidu.swan.apps.api.c.b Wp() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get system info sync");
        }
        JSONObject br = br(getContext());
        return br == null ? new com.baidu.swan.apps.api.c.b(202, "empty joData") : new com.baidu.swan.apps.api.c.b(0, br);
    }

    private JSONObject bq(Context context) {
        JSONObject bv;
        if (com.baidu.swan.apps.t.a.ahm().ST()) {
            bv = d.bu(context);
        } else {
            bv = d.bv(context);
        }
        if (bv == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        Pair<Integer, Integer> akd = f.akr().akd();
        Pair<Integer, Integer> ake = f.akr().ake();
        try {
            bv.put("SDKVersion", bs(context));
            bv.put("windowWidth", (int) (((Integer) akd.first).intValue() / displayMetrics.density));
            bv.put("windowHeight", (int) (((Integer) akd.second).intValue() / displayMetrics.density));
            bv.put("screenWidth", ai.F(((Integer) ake.first).intValue()));
            bv.put("screenHeight", ai.F(((Integer) ake.second).intValue()));
            ax(bv);
            k(context, bv);
            a(context, bv, ake);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.i("Api-SystemInfo-aiapp", "getSystemInfo:  " + bv);
        }
        return bv;
    }

    private JSONObject br(Context context) {
        if (!com.baidu.swan.apps.performance.b.b.aon()) {
            return bq(context);
        }
        if (!Wq()) {
            this.bSt = null;
            return bq(context);
        }
        if (this.bSt == null) {
            this.bSt = bq(context);
        }
        if (DEBUG) {
            Log.d("Api-SystemInfo", "in start process, getSysInfo hit cache");
        }
        JSONObject jSONObject = new JSONObject();
        aw(jSONObject);
        return jSONObject;
    }

    private boolean Wq() {
        return com.baidu.swan.apps.performance.a.f.aoh().aol();
    }

    private void aw(@NonNull JSONObject jSONObject) {
        if (this.bSt != null && this.bSt.length() > 0) {
            try {
                Iterator<String> keys = this.bSt.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, this.bSt.get(next));
                }
            } catch (Exception e) {
            }
        }
    }

    private static String bs(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).RU();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aEO().adQ(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.adw().adQ(), i);
    }

    public static void ax(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null && arv.arH().pc("mapp_location")) {
            com.baidu.swan.apps.t.b.d ahB = com.baidu.swan.apps.t.a.ahB();
            com.baidu.swan.apps.scheme.actions.f.b aiD = ahB == null ? null : ahB.aiD();
            if (aiD != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", aiD.city);
                jSONObject2.put("cityCode", aiD.cityCode);
                jSONObject2.put("country", aiD.country);
                jSONObject2.put("district", aiD.district);
                jSONObject2.put("province", aiD.province);
                jSONObject2.put("street", aiD.street);
                jSONObject2.put("streetNumber", aiD.streetNumber);
                jSONObject2.put("coord_gcj02", a(aiD, "gcj02"));
                jSONObject2.put("coord_wgs84", a(aiD, CoordinateType.WGS84));
                jSONObject.put("cacheLocation", jSONObject2);
            }
        }
    }

    private static JSONObject a(@NonNull com.baidu.swan.apps.scheme.actions.f.b bVar, @NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        double[] b = com.baidu.swan.apps.t.a.ahB().b(bVar, str);
        if (b != null && b.length >= 2) {
            jSONObject.put("longitude", b[0]);
            jSONObject.put("latitude", b[1]);
        }
        return jSONObject;
    }

    private void k(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("cameraAuthorized", x.Z(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
        jSONObject.put("locationAuthorized", x.Z(context, "android.permission.ACCESS_FINE_LOCATION"));
        jSONObject.put("microphoneAuthorized", x.Z(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        jSONObject.put("notificationAuthorized", al.cF(context));
        jSONObject.put("locationEnabled", al.cG(context));
        jSONObject.put("wifiEnabled", al.cH(context));
    }

    private void a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        int F = ai.F(ab.cx(context));
        int F2 = ai.F(((Integer) pair.first).intValue());
        int F3 = ai.F(((Integer) pair.second).intValue());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("left", 0);
        jSONObject2.put(HorizontalTranslateLayout.DIRECTION_RIGHT, F2);
        jSONObject2.put(VerticalTranslateLayout.TOP, F);
        jSONObject2.put("width", F2);
        jSONObject2.put(VerticalTranslateLayout.BOTTOM, F3);
        jSONObject2.put("height", F3 - F);
        jSONObject.put("safeArea", jSONObject2);
    }

    public com.baidu.swan.apps.api.c.b Wr() {
        if (DEBUG) {
            Log.d("Api-SystemInfo", "start get common sys info sync");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", al.axd());
            return new com.baidu.swan.apps.api.c.b(0, jSONObject);
        } catch (JSONException e) {
            return new com.baidu.swan.apps.api.c.b(1001, "exec fail");
        }
    }
}
