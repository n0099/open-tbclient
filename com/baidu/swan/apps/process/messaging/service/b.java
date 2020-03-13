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
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b {
    public static String bJw;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean bJx = false;

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
        com.baidu.swan.apps.adaptation.a.d TZ = com.baidu.swan.apps.w.a.TZ();
        if (com.baidu.swan.apps.ah.a.a.aam() || TZ.getSwitch("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, e.abu().aby(), bundle);
    }

    public static void a(Context context, c cVar, Bundle bundle) {
        e.abu().kB("b4 tryPreload client=" + cVar);
        if (ProcessUtils.isMainProcess() && cVar != null && cVar.bJA.isSwanAppProcess() && !cVar.abj()) {
            b(context, cVar, bundle);
        }
    }

    private static void b(final Context context, final c cVar, final Bundle bundle) {
        if (bJx) {
            com.baidu.swan.games.utils.so.d.aqm();
            c(context, cVar, bundle);
            return;
        }
        com.baidu.swan.apps.adaptation.b.a.c.IY().IZ().IW().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.b.1
            @Override // com.baidu.swan.apps.core.container.a.b
            public void Hd() {
                boolean unused = b.bJx = true;
                com.baidu.swan.games.utils.so.d.aqn();
                b.c(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final c cVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.RR().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.b.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void RI() {
                com.baidu.swan.apps.extcore.cores.a.RR().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.b.2.1
                    @Override // com.baidu.swan.apps.extcore.c.a
                    public void RI() {
                        b.d(context, cVar, bundle);
                    }
                }, 1);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, c cVar, Bundle bundle) {
        boolean Hh = com.baidu.swan.apps.w.a.TZ() != null ? com.baidu.swan.apps.w.a.TZ().Hh() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (Hh) {
            if (isMainProcess && TextUtils.isEmpty(bJw)) {
                try {
                    bJw = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    bJw = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.bJA.index);
                jSONObject.put(j.c, bJw);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a jZ = new f.a("812").jX("swan").jY(Config.LAUNCH).jZ(str);
            jZ.aZ(jSONObject);
            f.onEvent(jZ);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Hh) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.bJA.index);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a jZ2 = new f.a("812").jX("swan").jY("swan_updated").jZ(str);
            jZ2.aZ(jSONObject2);
            f.onEvent(jZ2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.baidu.swan.apps.swancore.b.afu()) {
            com.baidu.swan.apps.swancore.c.a.afA();
        }
        bundle.putParcelable("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.gA(0));
        bundle.putParcelable("bundle_key_extension_core", com.baidu.swan.apps.extcore.b.eO(0));
        bundle.putInt("bundle_key_preload_switch", com.baidu.swan.apps.w.a.Ut().GX());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.w.a.TZ().Hn());
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.bJA.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        com.baidu.swan.games.utils.so.d.S(bundle);
        cVar.e(context, bundle);
    }

    public static void J(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.w.a.TZ().Hn());
    }

    public static String abg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", com.baidu.swan.apps.core.k.d.Qw().QC());
            jSONObject.put("slave", com.baidu.swan.apps.core.k.d.Qw().QD());
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
