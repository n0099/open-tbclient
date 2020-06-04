package com.baidu.swan.apps.process.messaging.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    public static String cua;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cub = false;

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
        com.baidu.swan.apps.adaptation.a.d aeU = com.baidu.swan.apps.u.a.aeU();
        if (com.baidu.swan.apps.af.a.a.ama() || aeU.getSwitch("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, e.anp().ant(), bundle);
    }

    public static void a(Context context, c cVar, Bundle bundle) {
        e.anp().ni("b4 tryPreload client=" + cVar);
        if (ProcessUtils.isMainProcess() && cVar != null && cVar.cud.isSwanAppProcess() && !cVar.ane()) {
            b(context, cVar, bundle);
        }
    }

    private static void b(final Context context, final c cVar, final Bundle bundle) {
        if (cub) {
            com.baidu.swan.games.utils.so.d.aCs();
            c(context, cVar, bundle);
            return;
        }
        com.baidu.swan.apps.adaptation.b.a.c.Tq().Tr().To().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.b.1
            @Override // com.baidu.swan.apps.core.container.a.b
            public void Rf() {
                boolean unused = b.cub = true;
                com.baidu.swan.games.utils.so.d.aCt();
                b.c(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final c cVar, final Bundle bundle) {
        SwanLauncher.acy().e(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.process.messaging.service.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: p */
            public void H(Exception exc) {
                b.d(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, c cVar, Bundle bundle) {
        boolean Rk = com.baidu.swan.apps.u.a.aeU() != null ? com.baidu.swan.apps.u.a.aeU().Rk() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (Rk) {
            if (isMainProcess && TextUtils.isEmpty(cua)) {
                try {
                    cua = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    cua = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.cud.index);
                jSONObject.put(j.c, cua);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            g.a mA = new g.a("812").my("swan").mz(Config.LAUNCH).mA(str);
            mA.bt(jSONObject);
            g.onEvent(mA);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Rk) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.cud.index);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            g.a mA2 = new g.a("812").my("swan").mz("swan_updated").mA(str);
            mA2.bt(jSONObject2);
            g.onEvent(mA2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.baidu.swan.apps.swancore.b.arR()) {
            com.baidu.swan.apps.swancore.b.a.arX();
        }
        bundle.putParcelable("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.hd(0));
        bundle.putParcelable("bundle_key_extension_core", com.baidu.swan.apps.extcore.b.fg(0));
        bundle.putInt("bundle_key_preload_switch", com.baidu.swan.apps.u.a.afn().Ra());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.u.a.aeU().Rq());
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.cud.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        com.baidu.swan.games.utils.so.d.Y(bundle);
        cVar.e(context, bundle);
    }

    public static void P(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.u.a.aeU().Rq());
    }

    public static String anb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", com.baidu.swan.apps.core.turbo.d.abl().abs());
            jSONObject.put("slave", com.baidu.swan.apps.core.turbo.d.abl().abt());
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (DEBUG) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }
}
