package com.baidu.swan.apps.core.a;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.process.SwanAppPreHandleInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.games.i.a;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String apy;

    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar) {
        a(context, cVar, true);
    }

    public static void a(final Context context, final com.baidu.swan.apps.v.b.c cVar, boolean z) {
        boolean z2;
        String uuid = UUID.randomUUID().toString();
        cVar.Fu().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        cVar.Fu().putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.IC().q(uuid, "aiapp_abtest_info", TextUtils.isEmpty(apy) ? "" : apy);
        apy = "";
        com.baidu.swan.apps.performance.b.IC().f(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.zm().zn());
        cVar.Fu().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        com.baidu.swan.apps.database.a dZ = SwanAppDbControl.aX(context).dZ(cVar.mAppId);
        com.baidu.swan.apps.performance.b.IC().as(uuid, "aiapp_query_db_timestamp");
        boolean a = a(dZ, cVar, uuid);
        String str = a ? "1" : "0";
        if (z) {
            cVar.Fu().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, dZ, str);
        }
        cVar.Fu().putString("aiapp_extra_need_download", str);
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        if (a) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "执行APS全流程，不执行并行操作");
            }
            b.a(context, cVar, a.yZ(), uuid);
        } else {
            if (DEBUG) {
                Log.e("loadSwanAppBundle", "本地有包，Local");
            }
            if (dZ != null && !TextUtils.isEmpty(dZ.appId)) {
                b(dZ.appId, dZ.iconUrl, dZ.version, dZ.ave);
            }
            b.a(context, cVar, dZ, true, uuid);
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地有包，并行请求APS");
            }
            final int yY = a.yY();
            if (dZ != null && (z2 = dZ.avh)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "本地有包，手百更新后小程序首次启动: " + z2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dZ.appId);
                com.baidu.b.a.c.a.c(Constants.VIA_REPORT_TYPE_QQFAVORITES, arrayList);
            }
            int i = 0;
            if (com.baidu.swan.apps.u.a.En() != null) {
                i = com.baidu.swan.apps.u.a.En().wh();
            }
            if (i > 0) {
                j.a(new Runnable() { // from class: com.baidu.swan.apps.core.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(context, cVar, yY, "");
                    }
                }, i, TimeUnit.MILLISECONDS);
            } else {
                b.a(context, cVar, yY, "");
            }
        }
        if (DEBUG) {
            com.baidu.b.a.a.setDebug(DEBUG);
        }
    }

    public static void b(String str, String str2, String str3, int i) {
        SwanAppMessengerService serviceObject;
        if (!TextUtils.isEmpty(str) && (serviceObject = SwanAppMessengerService.getServiceObject()) != null) {
            a.b gm = com.baidu.swan.apps.process.messaging.service.a.Jx().gm(str);
            if (DEBUG) {
                Log.d("loadSwanAppBundle", "appId: " + str + ", client: " + gm);
            }
            if (gm.aHJ && gm.aHF.isSwanAppProcess()) {
                SwanAppPreHandleInfo swanAppPreHandleInfo = new SwanAppPreHandleInfo();
                swanAppPreHandleInfo.appId = str;
                if (!TextUtils.isEmpty(str3)) {
                    swanAppPreHandleInfo.version = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    swanAppPreHandleInfo.iconUrl = str2;
                }
                swanAppPreHandleInfo.ave = i;
                Bundle bundle = new Bundle();
                bundle.putParcelable("ai_apps_data", swanAppPreHandleInfo);
                serviceObject.sendMessageToClient(gm, 108, bundle);
            }
        }
    }

    public static boolean R(@NonNull Context context, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(SwanAppDbControl.aX(context).dZ(str));
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(cVar.azz);
        fVar.d(cVar);
        fVar.aVX = str;
        fVar.mType = Config.LAUNCH;
        if (aVar != null) {
            fVar.mAppVersion = aVar.version;
        }
        fVar.ak(com.baidu.swan.apps.statistic.e.ht(cVar.azw));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
    }

    private static boolean a(@Nullable com.baidu.swan.apps.database.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, String str) {
        if (!a(aVar)) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地无包，走APS");
            }
            com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 0);
            cVar.Fu().putString("aiapp_extra_pkg_download", "1");
            return true;
        } else if (aVar.errorCode != 0) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有错误code，走APS");
            }
            com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (com.baidu.swan.apps.database.a.e(aVar)) {
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "有悬而未决的的aps errcode要处理，走APS");
            }
            com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (aVar.Ct()) {
            if (com.baidu.swan.apps.core.a.c.b.zm().dD(aVar.appId)) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + aVar.appId);
                }
                com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("loadSwanAppBundle", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 1);
            boolean z = aVar.avh;
            if (z) {
                if (DEBUG) {
                    Log.i("loadSwanAppBundle", "本地有包，手百更新后小程序首次启动且包过期: " + z);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar.appId);
                com.baidu.b.a.c.a.c(Constants.VIA_REPORT_TYPE_QQFAVORITES, arrayList);
                return true;
            }
            return true;
        } else {
            com.baidu.swan.apps.performance.b.IC().d(str, "aiapp_launch_state", 4);
            return false;
        }
    }

    private static boolean a(@Nullable com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId) || TextUtils.isEmpty(aVar.version)) {
            return false;
        }
        if (aVar.ave == 1) {
            return b(aVar);
        }
        File ae = e.d.ae(aVar.appId, aVar.version);
        if (ae == null || !ae.exists()) {
            File q = e.d.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static boolean b(com.baidu.swan.apps.database.a aVar) {
        File ae = a.d.ae(aVar.appId, aVar.version);
        if (ae == null || !ae.exists()) {
            File q = a.d.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }
}
