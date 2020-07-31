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
/* loaded from: classes7.dex */
public final class b {
    public static String cBn;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cBo = false;

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
        com.baidu.swan.apps.adaptation.a.d ahm = com.baidu.swan.apps.t.a.ahm();
        if (com.baidu.swan.apps.ae.a.a.aoP() || ahm.getSwitch("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, e.aqf().aqj(), bundle);
    }

    public static void a(Context context, c cVar, Bundle bundle) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                e.aqf().nX("b4 tryPreload client=" + cVar);
            }
        } else {
            e.aqf().nX("b4 tryPreload client=" + cVar);
        }
        if (ProcessUtils.isMainProcess() && cVar != null && cVar.cBq.isSwanAppProcess() && !cVar.apU()) {
            b(context, cVar, bundle);
        }
    }

    private static void b(final Context context, final c cVar, final Bundle bundle) {
        if (cBo) {
            com.baidu.swan.games.utils.so.d.aHl();
            c(context, cVar, bundle);
            return;
        }
        com.baidu.swan.apps.adaptation.b.a.c.UY().UZ().UW().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.b.1
            @Override // com.baidu.swan.apps.core.container.a.b
            public void SC() {
                boolean unused = b.cBo = true;
                com.baidu.swan.games.utils.so.d.aHm();
                b.c(context, cVar, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final c cVar, final Bundle bundle) {
        SwanLauncher.aeL().f(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.process.messaging.service.b.2
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
        boolean SI = com.baidu.swan.apps.t.a.ahm() != null ? com.baidu.swan.apps.t.a.ahm().SI() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (SI) {
            if (isMainProcess && TextUtils.isEmpty(cBn)) {
                try {
                    cBn = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    cBn = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.cBq.index);
                jSONObject.put(j.c, cBn);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            i.a nk = new i.a("812").ni("swan").nj(Config.LAUNCH).nk(str);
            nk.bF(jSONObject);
            i.onEvent(nk);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (SI) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis2);
                jSONObject2.put("process", cVar.cBq.index);
                jSONObject2.put(BdStatsConstant.StatsKey.COST, currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            i.a nk2 = new i.a("812").ni("swan").nj("swan_updated").nk(str);
            nk2.bF(jSONObject2);
            i.onEvent(nk2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.baidu.swan.apps.swancore.b.auZ()) {
            com.baidu.swan.apps.swancore.b.a.avf();
        }
        bundle.putParcelable("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.hx(0));
        bundle.putParcelable("bundle_key_extension_core", com.baidu.swan.apps.extcore.b.fA(0));
        bundle.putInt("bundle_key_preload_switch", com.baidu.swan.apps.t.a.ahG().Sx());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.t.a.ahm().SO());
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.cBq.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        com.baidu.swan.games.utils.so.d.Z(bundle);
        cVar.e(context, bundle);
    }

    public static void Q(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", com.baidu.swan.apps.t.a.ahm().SO());
    }

    public static String apR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", com.baidu.swan.apps.core.turbo.d.adw().adD());
            jSONObject.put("slave", com.baidu.swan.apps.core.turbo.d.adw().adE());
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
