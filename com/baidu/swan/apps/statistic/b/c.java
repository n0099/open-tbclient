package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aVy;

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
                    if (aVy != null) {
                        aVy.clearAll();
                        aVy = null;
                    }
                    aVy = new b();
                }
                if (aVy != null) {
                    aVy.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals("error", aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        aVy.MT();
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
        Bundle Fa = bVar.Fa();
        if (Fa == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = Fa.getString("ext_stats_funnel_start", "0");
        String string2 = Fa.getString("ext_stats_funnel_scheme", "0");
        String string3 = Fa.getString("ext_stats_funnel_aps", "0");
        String string4 = Fa.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = Fa.getString("ext_stats_funnel_install", "0");
        Fa.remove("ext_stats_funnel_start");
        Fa.remove("ext_stats_funnel_scheme");
        Fa.remove("ext_stats_funnel_aps");
        Fa.remove("ext_stats_funnel_pkgcheck");
        Fa.remove("ext_stats_funnel_install");
        c(new a(IntentConfig.START, string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a("install", string5, ""));
        v(bVar);
    }

    public static void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && aVy != null) {
            aVy.aVr = bVar.Fg();
            aVy.mAppId = bVar.getAppId();
            aVy.mSource = bVar.EW();
            Bundle Fa = bVar.Fa();
            if (Fa != null) {
                aVy.aVu = Fa.getString("aiapp_extra_need_download", "");
                aVy.aVv = Fa.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && aVy != null) {
            aVy.aVr = cVar.ayS;
            aVy.mAppId = cVar.mAppId;
            aVy.mSource = cVar.mFrom;
            Bundle EK = cVar.EK();
            if (EK != null) {
                aVy.aVu = EK.getString("aiapp_extra_need_download", "");
                aVy.aVv = EK.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
