package com.baidu.swan.apps.core.pms;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void j(String str, String str2, boolean z) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1330233754:
                if (str.equals("updateFailed")) {
                    c = 1;
                    break;
                }
                break;
            case -1317168438:
                if (str.equals("checkForUpdate")) {
                    c = 2;
                    break;
                }
                break;
            case -585906598:
                if (str.equals("updateReady")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                mX(str2);
                return;
            case 1:
                mY(str2);
                return;
            case 2:
                S(str2, z);
                return;
            default:
                return;
        }
    }

    private static void mX(String str) {
        if (DEBUG) {
            Log.d("SwanAppPkgUpdateManager", "send update ready msg");
        }
        c("updateReady", str, null);
    }

    private static void mY(String str) {
        com.baidu.swan.apps.console.c.bn("SwanAppPkgUpdateManager", "send update failed msg");
        c("updateFailed", str, null);
    }

    private static void S(String str, boolean z) {
        com.baidu.swan.apps.console.c.bn("SwanAppPkgUpdateManager", "send checkForUpdate msg, hasUpdate=" + z);
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasUpdate", z);
        c("checkForUpdate", str, bundle);
    }

    private static void c(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.bn("SwanAppPkgUpdateManager", "appId is empty or eventType is empty");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("eventType", str);
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(107, bundle).w(str2));
    }

    public static void m(Message message) {
        if (message != null && (message.obj instanceof Bundle)) {
            Bundle bundle = (Bundle) message.obj;
            String string = bundle.getString("eventType");
            HashMap hashMap = new HashMap();
            hashMap.put("eventType", string);
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(string, "checkForUpdate")) {
                try {
                    jSONObject.put("hasUpdate", bundle.getBoolean("hasUpdate"));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.event.a.b bVar = new com.baidu.swan.apps.event.a.b("updateStatusChange", hashMap);
            SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
            if (awY != null && awY.ade() == 1) {
                com.baidu.swan.games.aa.a.aUQ().as(string, bundle.getBoolean("hasUpdate"));
            } else {
                com.baidu.swan.apps.v.f.axo().b(bVar);
            }
        }
    }
}
