package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static b aSE;

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
                    if (aSE != null) {
                        aSE.clearAll();
                        aSE = null;
                    }
                    aSE = new b();
                }
                if (aSE != null) {
                    aSE.a(aVar);
                    if (TextUtils.equals("narun", aVar.id) || TextUtils.equals("error", aVar.id) || TextUtils.equals("cancel", aVar.id)) {
                        aSE.Ku();
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
        Bundle bundle = bVar.axP;
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
        if (bVar != null && aSE != null) {
            aSE.aSx = bVar.axW;
            aSE.mAppId = bVar.mAppId;
            aSE.mSource = bVar.axF;
            Bundle bundle = bVar.axP;
            if (bundle != null) {
                aSE.aSA = bundle.getString("aiapp_extra_need_download", "");
                aSE.aSB = bundle.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }

    public static void e(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar != null && aSE != null) {
            aSE.aSx = cVar.axW;
            aSE.mAppId = cVar.mAppId;
            aSE.mSource = cVar.mFrom;
            Bundle DC = cVar.DC();
            if (DC != null) {
                aSE.aSA = DC.getString("aiapp_extra_need_download", "");
                aSE.aSB = DC.getString("aiapp_extra_pkg_download", "0");
            }
        }
    }
}
