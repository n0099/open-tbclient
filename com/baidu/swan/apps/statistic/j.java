package com.baidu.swan.apps.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j extends com.baidu.swan.apps.process.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        JSONObject jSONObject;
        com.baidu.swan.apps.database.a jY;
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
        if (!TextUtils.isEmpty(string) && (jY = SwanAppDbControl.bO(AppRuntime.getAppContext()).jY(string)) != null) {
            try {
                jSONObject.put("appDbInfo", jY.acY());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        new c.a(10002).oA(jSONObject.toString()).ait();
        finish();
    }

    public static boolean oH(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void e(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (oH(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 == null) {
                str2 = "null";
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put("appId", str == null ? "null" : str);
                com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                if (apM != null) {
                    b.a RP = apM.RP();
                    jSONObject2.put("launchInfo", RP == null ? "null" : RP.acY());
                    SwanAppActivity apG = apM.apG();
                    com.baidu.swan.apps.v.b.b bVar = null;
                    if (apG != null && (intent = apG.getIntent()) != null) {
                        bVar = com.baidu.swan.apps.v.b.b.r(intent);
                    }
                    jSONObject2.put("launchInfoIntent", bVar == null ? "null" : bVar.acY());
                } else {
                    jSONObject2.put("swanApp", "null");
                }
                jSONObject2.put("stackTrace", aj.auT());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.process.messaging.client.a apD = com.baidu.swan.apps.runtime.d.apI().apD();
            if (apD != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                apD.b(bundle, j.class);
            }
        }
    }
}
