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
    public static String aFr;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean aFs = false;
    public static boolean aFt = true;

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
        com.baidu.swan.apps.b.b.c Cz = com.baidu.swan.apps.u.a.Cz();
        if (Cz == null || Cz.j("swan_preload_keep_alive", true)) {
            e(context, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context, Bundle bundle) {
        a(context, a.Gu().Gx(), bundle);
    }

    private static void a(Context context, a.b bVar, Bundle bundle) {
        if (ProcessUtils.isMainProcess() && bVar != null && bVar.aFe.isSwanAppProcess() && !bVar.GG()) {
            bVar.GD();
            b(context, bVar, bundle);
        }
    }

    private static void b(final Context context, final a.b bVar, final Bundle bundle) {
        if (aFs) {
            c(context, bVar, bundle);
        } else {
            com.baidu.swan.apps.b.c.a.a.wh().wi().wf().a(new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.process.messaging.service.c.1
                @Override // com.baidu.swan.apps.core.container.a.b
                public void xT() {
                    boolean unused = c.aFs = true;
                    c.c(context, bVar, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final a.b bVar, final Bundle bundle) {
        com.baidu.swan.apps.extcore.cores.a.Bm().a(new com.baidu.swan.apps.extcore.c.a() { // from class: com.baidu.swan.apps.process.messaging.service.c.2
            @Override // com.baidu.swan.apps.extcore.c.a
            public void uK() {
                c.d(context, bVar, bundle);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, a.b bVar, Bundle bundle) {
        boolean vf = com.baidu.swan.apps.u.a.Cz() != null ? com.baidu.swan.apps.u.a.Cz().vf() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? "main" : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (vf) {
            if (isMainProcess && TextUtils.isEmpty(aFr)) {
                try {
                    aFr = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    aFr = "exception::" + e.toString();
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis);
                jSONObject.put("process", bVar.aFe.id);
                jSONObject.put("ua", aFr);
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            f.a fK = new f.a("812").fI("swan").fJ("launch").fK(str);
            fK.ai(jSONObject);
            f.onEvent(fK);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (vf) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis2);
                jSONObject2.put("process", bVar.aFe.id);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e3) {
                if (DEBUG) {
                    e3.printStackTrace();
                }
            }
            f.a fK2 = new f.a("812").fI("swan").fJ("swan_updated").fK(str);
            fK2.ai(jSONObject2);
            f.onEvent(fK2);
        }
        Intent intent = new Intent(context, bVar.aFe.service);
        intent.addCategory("android.intent.category.DEFAULT");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (DEBUG && com.baidu.swan.apps.swancore.b.KM()) {
            com.baidu.swan.apps.swancore.c.a.KR();
        }
        intent.putExtra("bundle_key_swan_core", com.baidu.swan.apps.swancore.b.dJ(0));
        intent.putExtra("bundle_key_extension_core", com.baidu.swan.apps.extcore.a.Bh().As());
        intent.putExtra("bundle_key_preload_switch", com.baidu.swan.apps.u.a.CS().vr());
        intent.putExtra("bundle_key_preload_launch_time", currentTimeMillis);
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Cz().vo());
        intent.putExtra("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        intent.putExtra("bundle_key_preload_src", str);
        intent.putExtra("bundle_key_process", bVar.aFe.id);
        intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
        try {
            context.startService(intent);
            aFt = false;
        } catch (Exception e4) {
            aFt = true;
            if (DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public static void L(Intent intent) {
        intent.putExtra("bundle_key_v8_ab", com.baidu.swan.apps.u.a.Cz().vo());
    }
}
