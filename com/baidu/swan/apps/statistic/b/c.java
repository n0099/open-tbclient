package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aWG;

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
                    if (aWG != null) {
                        aWG.clearAll();
                        aWG = null;
                    }
                    aWG = new b();
                }
                if (aWG != null) {
                    aWG.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals("error", aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        aWG.NM();
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
        Bundle FO = bVar.FO();
        if (FO == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = FO.getString("ext_stats_funnel_start", "0");
        String string2 = FO.getString("ext_stats_funnel_scheme", "0");
        String string3 = FO.getString("ext_stats_funnel_aps", "0");
        String string4 = FO.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = FO.getString("ext_stats_funnel_install", "0");
        FO.remove("ext_stats_funnel_start");
        FO.remove("ext_stats_funnel_scheme");
        FO.remove("ext_stats_funnel_aps");
        FO.remove("ext_stats_funnel_pkgcheck");
        FO.remove("ext_stats_funnel_install");
        c(new a(IntentConfig.START, string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a(Config.INPUT_INSTALLED_PKG, string5, ""));
        v(bVar);
    }

    public static void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && aWG != null) {
            aWG.aWz = bVar.FU();
            aWG.mAppId = bVar.getAppId();
            aWG.mSource = bVar.FK();
            Bundle FO = bVar.FO();
            if (FO != null) {
                aWG.aWC = FO.getString("aiapp_extra_need_download", "");
                aWG.aWD = FO.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && aWG != null) {
            aWG.aWz = cVar.azX;
            aWG.mAppId = cVar.mAppId;
            aWG.mSource = cVar.mFrom;
            Bundle Fy = cVar.Fy();
            if (Fy != null) {
                aWG.aWC = Fy.getString("aiapp_extra_need_download", "");
                aWG.aWD = Fy.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
