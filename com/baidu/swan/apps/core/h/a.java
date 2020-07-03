package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.messaging.service.c;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(c cVar, Bundle bundle) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("swan_app_on_launch_event", bundle);
        com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(122, bundle2).a(cVar.cyQ).eM(true));
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
        }
    }

    /* renamed from: com.baidu.swan.apps.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0345a {
        private static int cdP = -1;

        public static String abD() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_launch_switch", "debug_ab");
        }

        public static boolean abE() {
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable getAppLaunchDebugSwitch : " + abD());
                String abD = abD();
                char c = 65535;
                switch (abD.hashCode()) {
                    case 251117829:
                        if (abD.equals("debug_on_app_launch")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 547804557:
                        if (abD.equals("debug_ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 569516856:
                        if (abD.equals("debug_on_activity_create")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                }
            }
            if (cdP < 0) {
                cdP = com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_launch_switch", 1);
            }
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + cdP);
            }
            return cdP == 1;
        }
    }
}
