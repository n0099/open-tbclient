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
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static String dge;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dgf = false;

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
        com.baidu.swan.apps.adaptation.a.d aud = com.baidu.swan.apps.t.a.aud();
        if (com.baidu.swan.apps.ad.a.a.aCa() || aud.getSwitch("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, e.aDs().aDw(), bundle);
    }

    public static void a(Context context, c cVar, Bundle bundle) {
        if (DEBUG) {
            e.aDs().ru("b4 tryPreload client=" + cVar);
        }
        if (ProcessUtils.isMainProcess() && cVar != null && cVar.dgh.isSwanAppProcess() && !cVar.aDd()) {
            b(context, cVar, bundle);
        }
    }

    private static void b(final Context context, final c cVar, final Bundle bundle) {
        if (dgf) {
            com.baidu.swan.games.utils.so.d.aVr();
            c(context, cVar, bundle);
            return;
        }
        com.baidu.swan.apps.adaptation.b.a.c.ags().agt().agq().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.b.1
            @Override // com.baidu.swan.apps.core.container.a.b
            public void adM() {
                boolean unused = b.dgf = true;
                com.baidu.swan.games.utils.so.d.aVs();
                b.c(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final c cVar, final Bundle bundle) {
        SwanLauncher.aqK().g(new com.baidu.swan.apps.ap.e.b<Exception>() { // from class: com.baidu.swan.apps.process.messaging.service.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: p */
            public void M(Exception exc) {
                b.d(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, c cVar, Bundle bundle) {
        boolean adS = com.baidu.swan.apps.t.a.aud() != null ? com.baidu.swan.apps.t.a.aud().adS() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (adS) {
            if (isMainProcess && TextUtils.isEmpty(dge)) {
                try {
                    dge = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    dge = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.dgh.index);
                jSONObject.put(j.c, dge);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            i.a qH = new i.a("812").qF("swan").qG(Config.LAUNCH).qH(str);
            qH.ca(jSONObject);
            i.onEvent(qH);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (adS) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.dgh.index);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            i.a qH2 = new i.a("812").qF("swan").qG("swan_updated").qH(str);
            qH2.ca(jSONObject2);
            i.onEvent(qH2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.baidu.swan.apps.swancore.b.aIv()) {
            com.baidu.swan.apps.swancore.b.a.aIB();
        }
        bundle.putParcelable("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.kx(0));
        bundle.putParcelable("bundle_key_extension_core", com.baidu.swan.apps.extcore.b.io(0));
        bundle.putInt("bundle_key_preload_switch", com.baidu.swan.apps.t.a.aux().adH());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        if (!com.baidu.swan.apps.performance.b.c.aex()) {
            bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.t.a.aud().adY());
        }
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.dgh.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        com.baidu.swan.games.utils.so.d.Y(bundle);
        cVar.e(context, bundle);
    }

    public static void O(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.t.a.aud().adY());
    }

    public static String aDa() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", com.baidu.swan.apps.core.turbo.d.aph().apr());
            jSONObject.put("slave", com.baidu.swan.apps.core.turbo.d.aph().aps());
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (DEBUG) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }
}
