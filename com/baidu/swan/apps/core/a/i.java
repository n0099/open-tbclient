package com.baidu.swan.apps.core.a;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void d(String str, String str2, boolean z) {
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
                dB(str2);
                return;
            case 1:
                dC(str2);
                return;
            case 2:
                m(str2, z);
                return;
            default:
                return;
        }
    }

    private static void dB(String str) {
        if (DEBUG) {
            Log.d("SwanAppPkgUpdateManager", "send update ready msg");
        }
        c("updateReady", str, null);
    }

    private static void dC(String str) {
        if (DEBUG) {
            Log.d("SwanAppPkgUpdateManager", "send update failed msg");
        }
        c("updateFailed", str, null);
    }

    private static void m(String str, boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPkgUpdateManager", "send checkForUpdate msg, hasUpdate=" + z);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasUpdate", z);
        c("checkForUpdate", str, bundle);
    }

    private static void c(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanAppPkgUpdateManager", "appId is empty or eventType is empty");
                return;
            }
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("eventType", str);
        SwanAppMessengerService serviceObject = SwanAppMessengerService.getServiceObject();
        if (serviceObject != null) {
            a.b go = com.baidu.swan.apps.process.messaging.service.a.Jx().go(str2);
            if (DEBUG) {
                Log.d("SwanAppPkgUpdateManager", "appId: " + str2 + ", client: " + go);
            }
            if (go != null && go.aHJ && go.aHF.isSwanAppProcess()) {
                serviceObject.sendMessageToClient(go, 107, bundle);
                return;
            }
        }
        SwanAppMessengerService.storePendingMessageToClient(str2, 107, bundle);
    }

    public static void i(Message message) {
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
            com.baidu.swan.apps.m.a.b bVar = new com.baidu.swan.apps.m.a.b("updateStatusChange", hashMap);
            SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
            if (Gr != null && Gr.vD() == 1) {
                com.baidu.swan.games.u.a.Ts().G(string, bundle.getBoolean("hasUpdate"));
            } else {
                com.baidu.swan.apps.w.e.GF().a(bVar);
            }
        }
    }

    public static void a(final com.baidu.swan.apps.database.a aVar, final boolean z) {
        j.c(new Runnable() { // from class: com.baidu.swan.apps.core.a.i.1
            @Override // java.lang.Runnable
            public void run() {
                i.b(com.baidu.swan.apps.database.a.this, z);
            }
        }, "updatePkgCreateTime");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(com.baidu.swan.apps.database.a aVar, boolean z) {
        boolean z2 = false;
        if (aVar != null && aVar.isValid()) {
            SwanAppDbControl aX = SwanAppDbControl.aX(com.baidu.swan.apps.u.a.Ek());
            if (z || aVar.Ct()) {
                if (aVar.avg <= 0) {
                    aVar.avg = 432000L;
                }
                aVar.createTime = System.currentTimeMillis();
                z2 = aX.e(aVar, true);
            }
            if (DEBUG) {
                Log.d("SwanAppPkgUpdateManager", "updatePkgCreateTime: result=" + z2 + ", createTime=" + aVar.createTime);
            }
        }
        return z2;
    }
}
