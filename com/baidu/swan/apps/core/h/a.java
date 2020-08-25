package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.messaging.service.c;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(c cVar, Bundle bundle) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("swan_app_on_launch_event", bundle);
        com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(122, bundle2).a(cVar.cJz).fo(true));
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
        }
    }

    /* renamed from: com.baidu.swan.apps.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0388a {
        private static int clN = -1;

        public static String aje() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab");
        }

        public static boolean ajf() {
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable getAppLaunchDebugSwitch : " + aje());
                String aje = aje();
                char c = 65535;
                switch (aje.hashCode()) {
                    case 251117829:
                        if (aje.equals("debug_on_app_launch")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 547804557:
                        if (aje.equals("debug_ab")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 569516856:
                        if (aje.equals("debug_on_activity_create")) {
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
            if (clN < 0) {
                clN = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_sub_pkg_launch_switch", 0);
            }
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + clN);
            }
            return clN == 1;
        }
    }
}
