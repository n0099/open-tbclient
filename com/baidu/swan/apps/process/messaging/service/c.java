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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static String aIq;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean aIr = false;
    public static boolean aIs = true;

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
        com.baidu.swan.apps.b.b.c Er = com.baidu.swan.apps.u.a.Er();
        if (com.baidu.swan.apps.ac.a.a.IY() || Er.i("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, a.JB().JE(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.aId.isSwanAppProcess() && !bVar.JN()) {
            bVar.JK();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (aIr) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.xD().xE().xB().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void zw() {
                    boolean unused = c.aIr = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.Dc().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void vZ() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean wm = com.baidu.swan.apps.u.a.Er() != null ? com.baidu.swan.apps.u.a.Er().wm() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (wm) {
            if (isMainProcess && TextUtils.isEmpty(aIq)) {
                try {
                    aIq = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    aIq = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", bVar.aId.id);
                jSONObject.put("ua", aIq);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a gg = new f.a("812").ge("swan").gf(Config.LAUNCH).gg(str);
            gg.aj(jSONObject);
            f.onEvent(gg);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (wm) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", bVar.aId.id);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a gg2 = new f.a("812").ge("swan").gf("swan_updated").gg(str);
            gg2.aj(jSONObject2);
            f.onEvent(gg2);
        }
        Intent intent = new Intent(context, bVar.aId.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.Oe()) {
            com.baidu.swan.apps.swancore.c.a.Oj();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.dY(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.CX().Cn());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.EK().wL());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Er().ww());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.aId.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            aIs = false;
        } catch (Exception e4) {
            aIs = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void K(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Er().ww());
    }
}
