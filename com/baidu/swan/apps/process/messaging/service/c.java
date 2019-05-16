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
    public static String aHk;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean aHl = false;
    public static boolean aHm = true;

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
        com.baidu.swan.apps.b.b.c DE = com.baidu.swan.apps.u.a.DE();
        if (com.baidu.swan.apps.ac.a.a.Ih() || DE.i("swan_preload_keep_alive", true)) {
            d(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Bundle bundle) {
        a(context, a.IK().IN(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.aGX.isSwanAppProcess() && !bVar.IW()) {
            bVar.IT();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (aHl) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.wY().wZ().wW().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void yL() {
                    boolean unused = c.aHl = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.Cp().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void vu() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean vH = com.baidu.swan.apps.u.a.DE() != null ? com.baidu.swan.apps.u.a.DE().vH() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (vH) {
            if (isMainProcess && TextUtils.isEmpty(aHk)) {
                try {
                    aHk = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    aHk = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("process", bVar.aGX.id);
                jSONObject.put("ua", aHk);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a fZ = new f.a("812").fX("swan").fY("launch").fZ(str);
            fZ.aj(jSONObject);
            f.onEvent(fZ);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (vH) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis2);
                jSONObject2.put("process", bVar.aGX.id);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a fZ2 = new f.a("812").fX("swan").fY("swan_updated").fZ(str);
            fZ2.aj(jSONObject2);
            f.onEvent(fZ2);
        }
        Intent intent = new Intent(context, bVar.aGX.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.Nl()) {
            com.baidu.swan.apps.swancore.c.a.Nq();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.dU(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.Ck().BB());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.DX().wg());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.DE().vR());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.aGX.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            aHm = false;
        } catch (Exception e4) {
            aHm = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void K(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.DE().vR());
    }
}
