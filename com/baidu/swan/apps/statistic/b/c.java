package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b bps;

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
                    if (bps != null) {
                        bps.clearAll();
                        bps = null;
                    }
                    bps = new b();
                }
                if (bps != null) {
                    bps.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals(BdStatsConstant.StatsType.ERROR, aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        bps.SE();
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
        Bundle KJ = bVar.KJ();
        if (KJ == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = KJ.getString("ext_stats_funnel_start", "0");
        String string2 = KJ.getString("ext_stats_funnel_scheme", "0");
        String string3 = KJ.getString("ext_stats_funnel_aps", "0");
        String string4 = KJ.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = KJ.getString("ext_stats_funnel_install", "0");
        KJ.remove("ext_stats_funnel_start");
        KJ.remove("ext_stats_funnel_scheme");
        KJ.remove("ext_stats_funnel_aps");
        KJ.remove("ext_stats_funnel_pkgcheck");
        KJ.remove("ext_stats_funnel_install");
        c(new a("start", string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a(Config.INPUT_INSTALLED_PKG, string5, ""));
        v(bVar);
    }

    public static void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && bps != null) {
            bps.bpl = bVar.KP();
            bps.mAppId = bVar.getAppId();
            bps.mSource = bVar.KF();
            Bundle KJ = bVar.KJ();
            if (KJ != null) {
                bps.bpo = KJ.getString("aiapp_extra_need_download", "");
                bps.bpp = KJ.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && bps != null) {
            bps.bpl = cVar.aST;
            bps.mAppId = cVar.mAppId;
            bps.mSource = cVar.mFrom;
            Bundle Kt = cVar.Kt();
            if (Kt != null) {
                bps.bpo = Kt.getString("aiapp_extra_need_download", "");
                bps.bpp = Kt.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
