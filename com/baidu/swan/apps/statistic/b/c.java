package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aSF;

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
                    if (aSF != null) {
                        aSF.clearAll();
                        aSF = null;
                    }
                    aSF = new b();
                }
                if (aSF != null) {
                    aSF.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals("error", aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        aSF.Ku();
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppLaunchFunnelUBC", "sFlow is null");
                }
            }
        }
    }

    public static void s(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null) {
            Log.d("SwanAppLaunchFunnelUBC", "launchinfo is null");
            return;
        }
        Bundle bundle = bVar.axQ;
        if (bundle == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchFunnelUBC", "launchinfo has no extra data");
                return;
            }
            return;
        }
        String string = bundle.getString("ext_stats_funnel_start", "0");
        String string2 = bundle.getString("ext_stats_funnel_scheme", "0");
        String string3 = bundle.getString("ext_stats_funnel_aps", "0");
        String string4 = bundle.getString("ext_stats_funnel_pkgcheck", "0");
        String string5 = bundle.getString("ext_stats_funnel_install", "0");
        bundle.remove("ext_stats_funnel_start");
        bundle.remove("ext_stats_funnel_scheme");
        bundle.remove("ext_stats_funnel_aps");
        bundle.remove("ext_stats_funnel_pkgcheck");
        bundle.remove("ext_stats_funnel_install");
        c(new a(IntentConfig.START, string, ""));
        c(new a("scheme", string2, ""));
        c(new a("aps", string3, ""));
        c(new a("pkgcheck", string4, ""));
        c(new a("install", string5, ""));
        t(bVar);
    }

    public static void t(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null && aSF != null) {
            aSF.aSy = bVar.axX;
            aSF.mAppId = bVar.mAppId;
            aSF.mSource = bVar.axG;
            Bundle bundle = bVar.axQ;
            if (bundle != null) {
                aSF.aSB = bundle.getString("aiapp_extra_need_download", "");
                aSF.aSC = bundle.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && aSF != null) {
            aSF.aSy = cVar.axX;
            aSF.mAppId = cVar.mAppId;
            aSF.mSource = cVar.mFrom;
            Bundle DC = cVar.DC();
            if (DC != null) {
                aSF.aSB = DC.getString("aiapp_extra_need_download", "");
                aSF.aSC = DC.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
