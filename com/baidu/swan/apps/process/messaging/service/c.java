package com.baidu.swan.apps.process.messaging.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static String aHS;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean aHT = false;
    public static boolean aHU = true;

    public static void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SwanAppMessengerService.class);
        intent.setAction("com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            context.startService(intent);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, Bundle bundle) {
        com.baidu.swan.apps.b.b.c En = com.baidu.swan.apps.u.a.En();
        if (com.baidu.swan.apps.ac.a.a.IU() || En.i("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, a.Jx().JA(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.aHF.isSwanAppProcess() && !bVar.JJ()) {
            bVar.JG();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (aHT) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.xz().xA().xx().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void zs() {
                    boolean unused = c.aHT = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.CY().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void vV() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean wi = com.baidu.swan.apps.u.a.En() != null ? com.baidu.swan.apps.u.a.En().wi() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (wi) {
            if (isMainProcess && TextUtils.isEmpty(aHS)) {
                try {
                    aHS = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    aHS = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("process", bVar.aHF.id);
                jSONObject.put("ua", aHS);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a ge = new f.a("812").gc("swan").gd(Config.LAUNCH).ge(str);
            ge.aj(jSONObject);
            f.onEvent(ge);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (wi) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis2);
                jSONObject2.put("process", bVar.aHF.id);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a ge2 = new f.a("812").gc("swan").gd("swan_updated").ge(str);
            ge2.aj(jSONObject2);
            f.onEvent(ge2);
        }
        Intent intent = new Intent(context, bVar.aHF.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.Oa()) {
            com.baidu.swan.apps.swancore.c.a.Of();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.dX(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.CT().Cj());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.EG().wH());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.En().ws());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.aHF.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            aHU = false;
        } catch (Exception e4) {
            aHU = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void K(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.En().ws());
    }
}
