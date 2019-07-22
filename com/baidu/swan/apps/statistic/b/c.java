package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aWi;

    public static synchronized void c(a aVar) {
        synchronized (c.class) {
            if (aVar == null) {
                if (DEBUG) {
                    Log.d("SwanAppLaunchFunnelUBC", "SwanApp Funnel Event is null");
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppLaunchFunnelUBC", "record: " + aVar.toString());
                }
                if (TextUtils.equals(IntentConfig.START, aVar.id)) {
                    if (aWi != null) {
                        aWi.clearAll();
                        aWi = null;
                    }
                    aWi = new b();
                }
                if (aWi != null) {
                    aWi.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals("error", aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        aWi.NI();
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppLaunchFunnelUBC", "sFlow is null");
                }
            }
        }
    }

    public static void u(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null) {
            Log.d("SwanAppLaunchFunnelUBC", "launchinfo is null");
            return;
        }
        Bundle FK = bVar.FK();
        if (FK == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = FK.getString("ext_stats_funnel_start", "0");
        String string2 = FK.getString("ext_stats_funnel_scheme", "0");
        String string3 = FK.getString("ext_stats_funnel_aps", "0");
        String string4 = FK.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = FK.getString("ext_stats_funnel_install", "0");
        FK.remove("ext_stats_funnel_start");
        FK.remove("ext_stats_funnel_scheme");
        FK.remove("ext_stats_funnel_aps");
        FK.remove("ext_stats_funnel_pkgcheck");
        FK.remove("ext_stats_funnel_install");
        c(new a(IntentConfig.START, string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a(Config.INPUT_INSTALLED_PKG, string5, ""));
        v(bVar);
    }

    public static void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && aWi != null) {
            aWi.aWb = bVar.FQ();
            aWi.mAppId = bVar.getAppId();
            aWi.mSource = bVar.FG();
            Bundle FK = bVar.FK();
            if (FK != null) {
                aWi.aWe = FK.getString("aiapp_extra_need_download", "");
                aWi.aWf = FK.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && aWi != null) {
            aWi.aWb = cVar.azz;
            aWi.mAppId = cVar.mAppId;
            aWi.mSource = cVar.mFrom;
            Bundle Fu = cVar.Fu();
            if (Fu != null) {
                aWi.aWe = Fu.getString("aiapp_extra_need_download", "");
                aWi.aWf = Fu.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
