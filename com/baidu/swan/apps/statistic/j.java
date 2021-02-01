package com.baidu.swan.apps.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class j extends com.baidu.swan.apps.process.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        JSONObject jSONObject;
        com.baidu.swan.apps.database.a nk;
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
        if (!TextUtils.isEmpty(string) && (nk = SwanAppDbControl.cP(AppRuntime.getAppContext()).nk(string)) != null) {
            try {
                jSONObject.put("appDbInfo", nk.atb());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        new c.a(10002).sE(jSONObject.toString()).auo();
        finish();
    }

    public static boolean sM(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void h(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (sM(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            if (str2 == null) {
                str2 = "null";
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put("appId", str == null ? "null" : str);
                com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                if (aIK != null) {
                    b.a afZ = aIK.afZ();
                    jSONObject2.put("launchInfo", afZ == null ? "null" : afZ.atb());
                    SwanAppActivity aIE = aIK.aIE();
                    com.baidu.swan.apps.u.c.b bVar = null;
                    if (aIE != null && (intent = aIE.getIntent()) != null) {
                        bVar = com.baidu.swan.apps.u.c.b.t(intent);
                    }
                    jSONObject2.put("launchInfoIntent", bVar == null ? "null" : bVar.atb());
                } else {
                    jSONObject2.put("swanApp", "null");
                }
                jSONObject2.put("stackTrace", ak.getStackTrace());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.process.messaging.client.a aIB = com.baidu.swan.apps.runtime.d.aIG().aIB();
            if (aIB != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                aIB.b(bundle, j.class);
            }
        }
    }
}
