package com.baidu.swan.apps.process.messaging.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static String aFn;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean aFo = false;
    public static boolean aFp = true;

    public static void c(Context context, Bundle bundle) {
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
    public static void d(Context context, Bundle bundle) {
        com.baidu.swan.apps.b.b.c CB = com.baidu.swan.apps.u.a.CB();
        if (CB == null || CB.j("swan_preload_keep_alive", true)) {
            e(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context, Bundle bundle) {
        a(context, a.Gw().Gz(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.aFa.isSwanAppProcess() && !bVar.GI()) {
            bVar.GF();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (aFo) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.wi().wj().wg().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void xU() {
                    boolean unused = c.aFo = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.Bo().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void uL() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean vg = com.baidu.swan.apps.u.a.CB() != null ? com.baidu.swan.apps.u.a.CB().vg() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (vg) {
            if (isMainProcess && TextUtils.isEmpty(aFn)) {
                try {
                    aFn = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    aFn = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("process", bVar.aFa.id);
                jSONObject.put("ua", aFn);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a fJ = new f.a("812").fH("swan").fI("launch").fJ(str);
            fJ.ai(jSONObject);
            f.onEvent(fJ);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (vg) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis2);
                jSONObject2.put("process", bVar.aFa.id);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a fJ2 = new f.a("812").fH("swan").fI("swan_updated").fJ(str);
            fJ2.ai(jSONObject2);
            f.onEvent(fJ2);
        }
        Intent intent = new Intent(context, bVar.aFa.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.KO()) {
            com.baidu.swan.apps.swancore.c.a.KT();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.dK(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.Bj().At());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.CU().vs());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.CB().vp());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.aFa.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            aFp = false;
        } catch (Exception e4) {
            aFp = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void L(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.CB().vp());
    }
}
