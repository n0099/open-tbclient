package com.baidu.swan.apps.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.statistic.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends com.baidu.swan.apps.process.b.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.process.b.a.a
    public void u(@NonNull Bundle bundle) {
        JSONObject jSONObject;
        com.baidu.swan.apps.database.a dV;
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
        if (!TextUtils.isEmpty(string) && (dV = SwanAppDbControl.aX(AppRuntime.getAppContext()).dV(string)) != null) {
            try {
                jSONObject.put("appDbInfo", dV.toShortString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        new a.C0181a(10002).hk(jSONObject.toString()).Fr();
        finish();
    }

    public static boolean ho(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void c(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (ho(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 == null) {
                str2 = "null";
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put("appId", str == null ? "null" : str);
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                if (Lq != null) {
                    com.baidu.swan.apps.v.b.b vk = Lq.vk();
                    jSONObject2.put("launchInfo", vk == null ? "null" : vk.toShortString());
                    com.baidu.swan.apps.v.b.b bVar = null;
                    if (Lq.getActivity() != null && (intent = Lq.getActivity().getIntent()) != null) {
                        bVar = com.baidu.swan.apps.v.b.b.F(intent);
                    }
                    jSONObject2.put("launchInfoIntent", bVar == null ? "null" : bVar.toShortString());
                } else {
                    jSONObject2.put("swanApp", "null");
                }
                jSONObject2.put("stackTrace", ac.OT());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.process.messaging.client.a IE = com.baidu.swan.apps.process.messaging.client.a.IE();
            if (IE != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                IE.a(bundle, f.class);
            }
        }
    }
}
