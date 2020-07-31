package com.baidu.swan.apps.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends com.baidu.swan.apps.process.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        JSONObject jSONObject;
        com.baidu.swan.apps.database.a ks;
        String string = bundle.getString("key_swan_appid", "");
        String string2 = bundle.getString("key_report_info", "");
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        try {
            jSONObject = new JSONObject(string2);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e("VersionBusinessUbc", "execCall: ", e);
            }
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(string) && (ks = SwanAppDbControl.bR(AppRuntime.getAppContext()).ks(string)) != null) {
            try {
                jSONObject.put("appDbInfo", ks.aed());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        new c.a(10002).pj(jSONObject.toString()).aeU();
        finish();
    }

    public static boolean pr(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void h(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (pr(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 == null) {
                str2 = "null";
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put("appId", str == null ? "null" : str);
                com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                if (arv != null) {
                    b.a Se = arv.Se();
                    jSONObject2.put("launchInfo", Se == null ? "null" : Se.aed());
                    SwanAppActivity arp = arv.arp();
                    com.baidu.swan.apps.u.c.b bVar = null;
                    if (arp != null && (intent = arp.getIntent()) != null) {
                        bVar = com.baidu.swan.apps.u.c.b.r(intent);
                    }
                    jSONObject2.put("launchInfoIntent", bVar == null ? "null" : bVar.aed());
                } else {
                    jSONObject2.put("swanApp", "null");
                }
                jSONObject2.put("stackTrace", al.awZ());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.process.messaging.client.a arm = com.baidu.swan.apps.runtime.d.arr().arm();
            if (arm != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                arm.b(bundle, j.class);
            }
        }
    }
}
