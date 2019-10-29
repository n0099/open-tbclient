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
    public static String bbE;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean bbF = false;
    public static boolean bbG = true;

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
        com.baidu.swan.apps.b.b.c Jl = com.baidu.swan.apps.u.a.Jl();
        if (com.baidu.swan.apps.ac.a.a.NS() || Jl.l("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, a.Ov().Oy(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.bbr.isSwanAppProcess() && !bVar.OH()) {
            bVar.OE();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (bbF) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.Cx().Cy().Cv().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Er() {
                    boolean unused = c.bbF = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.HW().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void AT() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean Bg = com.baidu.swan.apps.u.a.Jl() != null ? com.baidu.swan.apps.u.a.Jl().Bg() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (Bg) {
            if (isMainProcess && TextUtils.isEmpty(bbE)) {
                try {
                    bbE = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    bbE = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", bVar.bbr.id);
                jSONObject.put("ua", bbE);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a gL = new f.a("812").gJ("swan").gK(Config.LAUNCH).gL(str);
            gL.aH(jSONObject);
            f.onEvent(gL);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Bg) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", bVar.bbr.id);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a gL2 = new f.a("812").gJ("swan").gK("swan_updated").gL(str);
            gL2.aH(jSONObject2);
            f.onEvent(gL2);
        }
        Intent intent = new Intent(context, bVar.bbr.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.SU()) {
            com.baidu.swan.apps.swancore.c.a.SZ();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.eT(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.HR().Hh());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.JE().BF());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Jl().Bq());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.bbr.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            bbG = false;
        } catch (Exception e4) {
            bbG = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void Q(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Jl().Bq());
    }
}
