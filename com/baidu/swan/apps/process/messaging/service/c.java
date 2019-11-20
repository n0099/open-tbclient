package com.baidu.swan.apps.process.messaging.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static String bbm;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean bbn = false;
    public static boolean bbo = true;

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
        com.baidu.swan.apps.b.b.c Jm = com.baidu.swan.apps.u.a.Jm();
        if (com.baidu.swan.apps.ac.a.a.NT() || Jm.l("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, a.Ow().Oz(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.baZ.isSwanAppProcess() && !bVar.OI()) {
            bVar.OF();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (bbn) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.Cy().Cz().Cw().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Es() {
                    boolean unused = c.bbn = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.HX().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void AU() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean Bh = com.baidu.swan.apps.u.a.Jm() != null ? com.baidu.swan.apps.u.a.Jm().Bh() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (Bh) {
            if (isMainProcess && TextUtils.isEmpty(bbm)) {
                try {
                    bbm = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    bbm = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", bVar.baZ.id);
                jSONObject.put("ua", bbm);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a gL = new f.a("812").gJ("swan").gK(Config.LAUNCH).gL(str);
            gL.aI(jSONObject);
            f.onEvent(gL);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Bh) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", bVar.baZ.id);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a gL2 = new f.a("812").gJ("swan").gK("swan_updated").gL(str);
            gL2.aI(jSONObject2);
            f.onEvent(gL2);
        }
        Intent intent = new Intent(context, bVar.baZ.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.SW()) {
            com.baidu.swan.apps.swancore.c.a.Tb();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.eT(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.HS().Hi());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.JF().BG());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Jm().Br());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.baZ.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            bbo = false;
        } catch (Exception e4) {
            bbo = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void Q(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Jm().Br());
    }
}
