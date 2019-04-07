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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String aoH;

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar) {
        a(context, cVar, true);
    }

    public static void a(final Context context, final com.baidu.swan.apps.v.b.c cVar, boolean z) {
        boolean z2;
        String uuid = UUID.randomUUID().toString();
        cVar.DA().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.FH().q(uuid, "aiapp_abtest_info", TextUtils.isEmpty(aoH) ? "" : aoH);
        aoH = "";
        com.baidu.swan.apps.performance.b.FH().f(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.xO().isInProgress());
        cVar.DA().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.database.a eh = SwanAppDbControl.bE(context).eh(cVar.mAppId);
        com.baidu.swan.apps.performance.b.FH().ar(uuid, "aiapp_query_db_timestamp");
        if (eh != null && !TextUtils.isEmpty(eh.appId)) {
            b(eh.appId, eh.iconUrl, eh.version, eh.category);
        }
        boolean a = a(eh, cVar, uuid);
        String str = a ? "1" : "0";
        if (z) {
            cVar.DA().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, eh, str);
        }
        cVar.DA().putString("aiapp_extra_need_download", str);
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        if (a) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "执行APS全流程，不执行并行操作");
            }
            b.a(context, cVar, a.xB(), uuid);
        } else {
            if (DEBUG) {
                Log.e("loadSwanAppBundle", "本地有包，Local");
            }
            b.a(context, cVar, eh, true, uuid);
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地有包，并行请求APS");
            }
            final int xA = a.xA();
            if (eh != null && (z2 = eh.aum)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "本地有包，手百更新后小程序首次启动: " + z2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(eh.appId);
                com.baidu.b.a.c.a.d(Constants.VIA_REPORT_TYPE_QQFAVORITES, arrayList);
            }
            int i = 0;
            if (com.baidu.swan.apps.u.a.Cz() != null) {
                i = com.baidu.swan.apps.u.a.Cz().ve();
            }
            if (i > 0) {
                j.a(new Runnable() { // from class: com.baidu.swan.apps.core.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(context, cVar, xA, "");
                    }
                }, i, TimeUnit.MILLISECONDS);
            } else {
                b.a(context, cVar, xA, "");
            }
        }
        if (DEBUG) {
            com.baidu.b.a.a.setDebug(DEBUG);
        }
    }

    public static void b(String str, String str2, String str3, int i) {
        SwanAppMessengerService serviceObject;
        if (!TextUtils.isEmpty(str) && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
            a.b fP = com.baidu.swan.apps.process.messaging.service.a.Gu().fP(str);
            if (DEBUG) {
                Log.d("loadSwanAppBundle", "appId: " + str + ", client: " + fP);
            }
            if (fP.aFh && fP.aFd.isSwanAppProcess()) {
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
                serviceObject.sendMessageToClient(fP, 108, bundle);
            }
        }
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(cVar.aya);
        fVar.d(cVar);
        fVar.aSx = str;
        fVar.mType = "launch";
        if (aVar != null) {
            fVar.mAppVersion = aVar.version;
        }
        String str2 = cVar.axK;
        if (str2 != null) {
            String queryParameter = Uri.parse(str2).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                        fVar.ai(optJSONObject);
                    }
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
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
            com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 0);
            cVar.DA().putString("aiapp_extra_pkg_download", "1");
            return true;
        } else if (aVar.errorCode != 0) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有错误code，走APS");
            }
            com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (com.baidu.swan.apps.database.a.e(aVar)) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有悬而未决的的aps errcode要处理，走APS");
            }
            com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (aVar.AE()) {
            if (com.baidu.swan.apps.core.a.c.b.xO().dM(aVar.appId)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + aVar.appId);
                }
                com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 1);
            boolean z = aVar.aum;
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
            com.baidu.swan.apps.performance.b.FH().e(str, "aiapp_launch_state", 4);
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
