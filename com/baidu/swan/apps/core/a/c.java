package com.baidu.swan.apps.core.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.process.SwanAppPreHandleInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.games.i.a;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public static String aoC;

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar) {
        a(context, cVar, true);
    }

    public static void a(final Context context, final com.baidu.swan.apps.v.b.c cVar, boolean z) {
        boolean z2;
        String uuid = UUID.randomUUID().toString();
        cVar.DC().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.FJ().q(uuid, "aiapp_abtest_info", TextUtils.isEmpty(aoC) ? "" : aoC);
        aoC = "";
        com.baidu.swan.apps.performance.b.FJ().f(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.xP().isInProgress());
        cVar.DC().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.database.a ef = SwanAppDbControl.bE(context).ef(cVar.mAppId);
        com.baidu.swan.apps.performance.b.FJ().ar(uuid, "aiapp_query_db_timestamp");
        if (ef != null && !TextUtils.isEmpty(ef.appId)) {
            b(ef.appId, ef.iconUrl, ef.version, ef.category);
        }
        boolean a = a(ef, cVar, uuid);
        String str = a ? "1" : "0";
        if (z) {
            cVar.DC().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, ef, str);
        }
        cVar.DC().putString("aiapp_extra_need_download", str);
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        if (a) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "执行APS全流程，不执行并行操作");
            }
            b.a(context, cVar, a.xC(), uuid);
        } else {
            if (DEBUG) {
                Log.e("loadSwanAppBundle", "本地有包，Local");
            }
            b.a(context, cVar, ef, true, uuid);
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地有包，并行请求APS");
            }
            final int xB = a.xB();
            if (ef != null && (z2 = ef.auh)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "本地有包，手百更新后小程序首次启动: " + z2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(ef.appId);
                com.baidu.b.a.c.a.d(Constants.VIA_REPORT_TYPE_QQFAVORITES, arrayList);
            }
            int i = 0;
            if (com.baidu.swan.apps.u.a.CB() != null) {
                i = com.baidu.swan.apps.u.a.CB().vf();
            }
            if (i > 0) {
                j.a(new Runnable() { // from class: com.baidu.swan.apps.core.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(context, cVar, xB, "");
                    }
                }, i, TimeUnit.MILLISECONDS);
            } else {
                b.a(context, cVar, xB, "");
            }
        }
        if (DEBUG) {
            com.baidu.b.a.a.setDebug(DEBUG);
        }
    }

    public static void b(String str, String str2, String str3, int i) {
        SwanAppMessengerService serviceObject;
        if (!TextUtils.isEmpty(str) && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
            a.b fO = com.baidu.swan.apps.process.messaging.service.a.Gw().fO(str);
            if (DEBUG) {
                Log.d("loadSwanAppBundle", "appId: " + str + ", client: " + fO);
            }
            if (fO.aFd && fO.aEZ.isSwanAppProcess()) {
                SwanAppPreHandleInfo swanAppPreHandleInfo = new SwanAppPreHandleInfo();
                swanAppPreHandleInfo.appId = str;
                if (!TextUtils.isEmpty(str3)) {
                    swanAppPreHandleInfo.version = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    swanAppPreHandleInfo.iconUrl = str2;
                }
                swanAppPreHandleInfo.category = i;
                Bundle bundle = new Bundle();
                bundle.putParcelable("ai_apps_data", swanAppPreHandleInfo);
                serviceObject.sendMessageToClient(fO, 108, bundle);
            }
        }
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(cVar.axW);
        fVar.d(cVar);
        fVar.aSt = str;
        fVar.mType = "launch";
        if (aVar != null) {
            fVar.mAppVersion = aVar.version;
        }
        String str2 = cVar.axG;
        if (str2 != null) {
            String queryParameter = Uri.parse(str2).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                        fVar.ai(optJSONObject);
                    }
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.c.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        com.baidu.swan.apps.statistic.c.onEvent(fVar);
    }

    private static boolean a(@Nullable com.baidu.swan.apps.database.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, String str) {
        if (!a(aVar)) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地无包，走APS");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 0);
            cVar.DC().putString("aiapp_extra_pkg_download", "1");
            return true;
        } else if (aVar.errorCode != 0) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有错误code，走APS");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (com.baidu.swan.apps.database.a.e(aVar)) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有悬而未决的的aps errcode要处理，走APS");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (aVar.AF()) {
            if (com.baidu.swan.apps.core.a.c.b.xP().dK(aVar.appId)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + aVar.appId);
                }
                com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 1);
            boolean z = aVar.auh;
            if (z) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "本地有包，手百更新后小程序首次启动且包过期: " + z);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar.appId);
                com.baidu.b.a.c.a.d(Constants.VIA_REPORT_TYPE_QQFAVORITES, arrayList);
                return true;
            }
            return true;
        } else {
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 4);
            return false;
        }
    }

    private static boolean a(@Nullable com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId) || TextUtils.isEmpty(aVar.version)) {
            return false;
        }
        if (aVar.category == 1) {
            return b(aVar);
        }
        File ah = c.d.ah(aVar.appId, aVar.version);
        if (ah == null || !ah.exists()) {
            File q = c.d.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static boolean b(com.baidu.swan.apps.database.a aVar) {
        File ah = a.c.ah(aVar.appId, aVar.version);
        if (ah == null || !ah.exists()) {
            File q = a.c.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }
}
