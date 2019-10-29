package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b bpK;

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
                if (TextUtils.equals("start", aVar.id)) {
                    if (bpK != null) {
                        bpK.clearAll();
                        bpK = null;
                    }
                    bpK = new b();
                }
                if (bpK != null) {
                    bpK.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals(BdStatsConstant.StatsType.ERROR, aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        bpK.SC();
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
        Bundle KI = bVar.KI();
        if (KI == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = KI.getString("ext_stats_funnel_start", "0");
        String string2 = KI.getString("ext_stats_funnel_scheme", "0");
        String string3 = KI.getString("ext_stats_funnel_aps", "0");
        String string4 = KI.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = KI.getString("ext_stats_funnel_install", "0");
        KI.remove("ext_stats_funnel_start");
        KI.remove("ext_stats_funnel_scheme");
        KI.remove("ext_stats_funnel_aps");
        KI.remove("ext_stats_funnel_pkgcheck");
        KI.remove("ext_stats_funnel_install");
        c(new a("start", string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a(Config.INPUT_INSTALLED_PKG, string5, ""));
        v(bVar);
    }

    public static void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && bpK != null) {
            bpK.bpD = bVar.KO();
            bpK.mAppId = bVar.getAppId();
            bpK.mSource = bVar.KE();
            Bundle KI = bVar.KI();
            if (KI != null) {
                bpK.bpG = KI.getString("aiapp_extra_need_download", "");
                bpK.bpH = KI.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && bpK != null) {
            bpK.bpD = cVar.aTl;
            bpK.mAppId = cVar.mAppId;
            bpK.mSource = cVar.mFrom;
            Bundle Ks = cVar.Ks();
            if (Ks != null) {
                bpK.bpG = Ks.getString("aiapp_extra_need_download", "");
                bpK.bpH = Ks.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
