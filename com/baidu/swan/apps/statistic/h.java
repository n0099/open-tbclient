package com.baidu.swan.apps.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.process.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        JSONObject jSONObject;
        com.baidu.swan.apps.database.a hh;
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
        if (!TextUtils.isEmpty(string) && (hh = SwanAppDbControl.bX(AppRuntime.getAppContext()).hh(string)) != null) {
            try {
                jSONObject.put("appDbInfo", hh.OK());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        new a.C0287a(10002).lq(jSONObject.toString()).TW();
        finish();
    }

    public static boolean lv(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void e(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (lv(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 == null) {
                str2 = "null";
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put("appId", str == null ? "null" : str);
                com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                if (aap != null) {
                    b.a En = aap.En();
                    jSONObject2.put("launchInfo", En == null ? "null" : En.OK());
                    SwanAppActivity aal = aap.aal();
                    com.baidu.swan.apps.x.b.b bVar = null;
                    if (aal != null && (intent = aal.getIntent()) != null) {
                        bVar = com.baidu.swan.apps.x.b.b.G(intent);
                    }
                    jSONObject2.put("launchInfoIntent", bVar == null ? "null" : bVar.OK());
                } else {
                    jSONObject2.put("swanApp", "null");
                }
                jSONObject2.put("stackTrace", ai.aeN());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.process.messaging.client.a aai = com.baidu.swan.apps.runtime.d.aam().aai();
            if (aai != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                aai.a(bundle, h.class);
            }
        }
    }
}
